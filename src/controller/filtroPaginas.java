package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter({"/CriarAvaliacao.jsp", "/CriarEmpresa.jsp", "/CriarCategoria.jsp", "/listarEmpresa.jsp", "/index.jsp", "/Empresa.jsp", "/Categoria.jsp", "/Usuario.jsp", "/Avaliacao.jsp"}) 
public class filtroPaginas implements Filter {

    public filtroPaginas() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		
		String url = httpServletRequest .getRequestURI();
		
		HttpSession sessao = httpServletRequest .getSession();
		
		if (sessao.getAttribute("usuAutenticado")!=null || url.lastIndexOf("login.jsp")>-1 ||
		url.lastIndexOf("autenticador") >-1){
		chain.doFilter(request, response);
		}else{
				((HttpServletResponse) response).sendRedirect("login.jsp");
			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
