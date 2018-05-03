package com.german.springmvc;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.german.springmvc.entidad.Pelicula;
import com.german.springmvc.entidad.Usuario;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class InicioController {

	private HttpServletRequest request;

	@RequestMapping(value = "/peliculas", method = RequestMethod.GET)
	public ModelAndView redireccion() throws ParseException {
		ModelAndView mv = new ModelAndView();

		if (validaSession()) {
			mv.addObject("error", "Session Terminada");
			mv.setViewName("login");
			return mv;

		}
		SimpleDateFormat d = new SimpleDateFormat("dd-MM-yyyy");

		List<Pelicula> lista = new ArrayList<>();

		Pelicula p = new Pelicula();
		p.setId(1);
		p.setClasificacion('A');
		p.setDuracion(230);
		p.setFechaEstreno(d.parse("31-03-2018"));
		p.setGenero("Aventura");
		p.setImagen("http://t1.gstatic.com/images?q=tbn:ANd9GcRUejO8nuOTtu-88efaopbJJ4rnl0wrfzVWFfvOitxnUo45bcMj");
		p.setEstatus('A');
		p.setTitulo("El Grinch Renacido Maldito");

		lista.add(p);
		p = new Pelicula();
		p.setId(2);
		p.setClasificacion('B');
		p.setDuracion(190);
		p.setFechaEstreno(d.parse("14-02-2018"));
		p.setGenero("Terror");
		p.setImagen(
				"http://www.rockandpop.cl/wp-content/uploads/2018/03/landscape-1500890190-avengers-infinity-war-poster-resized-1.jpg");
		p.setEstatus('I');
		p.setTitulo("La Anaconda");
		lista.add(p);
		mv.addObject("peliculas", lista);
		mv.setViewName("peliculas");
		return mv;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		log.info("Raiz");
		return "login";
	}

	@RequestMapping(value = "/inicio", method = RequestMethod.GET)
	public String inicio(Model model) {
		if (validaSession()) {
			return "login";
		}
		model.addAttribute("usuario", request.getSession().getAttribute("usuario"));
		return "index";
	}

	@RequestMapping(value = "/logeo", method = RequestMethod.POST)
	public String validaUsuario(String usuario, String password, Model model, HttpServletRequest rq,
			HttpServletResponse rs) {
		log.info(usuario);
		log.info(password);
		Usuario u = new Usuario();
		if ("admin".equals(usuario) && "1234".equals(password)) {
			u.setUser(usuario);
			u.setPass(password);
			rq.getSession().setAttribute("usuario", u);
			request = rq;
			return "index";
		}
		model.addAttribute("error", "Usuario o Contraseña Incorrecta");
		return "login";

	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admininstracion() {
		if (validaSession()) {
			return "login";
		}
		return "admin";
	}

	public boolean validaSession() {
		boolean flag = false;
		if (request == null) {
			flag = true;
		} else if (request.getSession().getAttribute("usuario") == null) {
			request.getSession().invalidate();
			// return new ModelAndView("redirect:/index");
			flag = true;
		}
		// return "";
		return flag;
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String cierraSession(HttpServletRequest request) {
		request.getSession().invalidate();

		return "login";
	}
}
