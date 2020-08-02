<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="model.Empresa" %>
<%@page import="dao.EmpresaDAO"%>
<%@page import="java.util.ArrayList" %>

<% 
	EmpresaDAO dao = new EmpresaDAO();
	
	ArrayList<Empresa> list;
	
	list = dao.listarEmpresa();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="js/cont.js"></script>
    <meta charset="UTF-8" />

    <style type="text/css">
        body {
            background: 0066CC;
        }
        
        .abas {
            position: relative;
            background: 0066CC;
        }
        
        .aba {
            display: inline;
            background: 0066CC;
        }
        
        .aba>a {
            float: left;
            padding: 0.5em 1em;
            background: linear-gradient(#FFF, #EEE);
            border-width: 1px;
            border-style: solid;
            border-color: #CCC #CCC #FFF;
            border-top-right-radius: 8px;
            border-top-left-radius: 8px;
        }
        
        .aba:not(:target) a {
            border-bottom: 0 none;
        }
        
        .aba:target a,
        a:hover {
            background: 0066CC;
        }
        
        .conteudo {
            position: absolute;
            left: 0;
            top: calc(2em + 4px);
            /* altura do link + bordas */
            z-index: -2;
            border: 1px solid #CCC;
            background-color: white;
            width: 100%;
        }
        
        .aba:target .conteudo {
            z-index: -1;
        }
        
        li {
            background: 0066CC;
        }
        
        input,
        label {
            width: 100%;
            display: block;
        }
        
        ul {
            padding: 0;
            margin: 0;
        }
        
        ul li.teste {
            list-style-type: none;
            display: inline-block;
            margin: 10px;
            color: white;
            text-shadow: 2px 2px 7px grey;
            font-size: 25px !important;
        }
        
        ul li.teste:hover {
            color: yellow;
        }
        
        ul li.teste.active,
        ul li.teste.secondary-active {
            color: yellow;
        }
        
        input[type="radio"] {
            display: none;
        } 
        
        input[type="submit"] {
            background-color: #0066CC;
            color: white;
            width: 100px;
        } 
        
    </style>
    <title>Cadastro de Avaliação</title>
</head>

<body>
<c:import url="Menu.jsp" />
    <h3>Cadastro de Avaliação</h3>
    <label for="sel1">Selecione a Empresa:</label>
         <select class="form-control" id="sel1" name="empresa" >
    <option>Selecione a empresa</option>

		<%
			for(Empresa registro: list){
		%>
  <option selected="selected"><%= registro.getId() %></option>
		<%
			}
		%>
 </select><br>
    <form action="controller.do" method="get">
        <!-- Criando a listagem -->
        <ul class="abas">
            <!-- Aqui, criação da primeira aba -->
            <li class="aba" id="aba-1" style="background: 0066CC;">
                <a href="#aba-1">Acesso Cadeirantes</a>
                <section class="conteudo">
                    <ul>
                        <li class="teste"><label for="rating_1"><i class="fa fa-star" aria-hidden="true"></i></label>
                            <input type="radio" name="nota1" id="rating_1" value="1" /></li>
                        <li class="teste"><label for="rating_2"><i class="fa fa-star" aria-hidden="true"></i></label>
                            <input type="radio" name="nota1" id="rating_2" value="2" /></li>
                        <li class="teste"><label for="rating_3"><i class="fa fa-star" aria-hidden="true"></i></label>
                            <input type="radio" name="nota1" id="rating_3" value="3" /></li>
                        <li class="teste"><label for="rating_4"><i class="fa fa-star" aria-hidden="true"></i></label>
                            <input type="radio" name="nota1" id="rating_4" value="4" /></li>
                    </ul>
                     Comentario: <textarea onkeyup="limite1(this.value)" style="width: 300px; height: 100px; resize: none;" name="comentario1" maxlength="140" placeholder="Digite seu comentario (Não obrigatório) máx 140 caracteres" id="texto1"></textarea><span id="cont1">140</span> Restantes <br>
                </section>
            </li>

            <!-- Aqui, criação da segunda aba -->
            <li class="aba" id="aba-2">
                <a href="#aba-2">Sanitario Cadeirantes</a>
                <section class="conteudo">
                    <ul>
                        <li class="teste"><label for="rating_5"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota2" id="rating_5" value="1" /></li>
                        <li class="teste"><label for="rating_6"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota2" id="rating_6" value="2" /></li>
                        <li class="teste"><label for="rating_7"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota2" id="rating_7" value="3" /></li>
                        <li class="teste"><label for="rating_8"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota2" id="rating_8" value="4" /></li>
                    </ul>
                    Comentario: <textarea onkeyup="limite2(this.value)" style="width: 300px; height: 100px; resize: none;" name="comentario2" maxlength="140" placeholder="Digite seu comentario (Não obrigatório) máx 140 caracteres" id="texto2"></textarea><span id="cont2">140</span> Restantes <br>
                </section>
            </li>

            <!-- Aqui, criação da terceira aba -->
            <li class="aba" id="aba-3">
                <a href="#aba-3">Instruções em Braile</a>
                <section class="conteudo">
                    <ul>
                        <li class="teste"><label for="rating_9"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota3" id="rating_9" value="1" /></li>
                        <li class="teste"><label for="rating_10"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota3" id="rating_10" value="2" /></li>
                        <li class="teste"><label for="rating_11"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota3" id="rating_11" value="3" /></li>
                        <li class="teste"><label for="rating_12"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota3" id="rating_12" value="4" /></li>
                    </ul>
                    Comentario: <textarea onkeyup="limite3(this.value)" style="width: 300px; height: 100px; resize: none;" name="comentario3" maxlength="140" placeholder="Digite seu comentario (Não obrigatório) máx 140 caracteres" id="texto3"></textarea><span id="cont3">140</span> Restantes <br>
                </section>
            </li>
            <!-- Aqui, criação da quarta aba -->
            <li class="aba" id="aba-4">
                <a href="#aba-4">Sinalização no Piso</a>
                <section class="conteudo">
                    <ul>
                        <li class="teste"><label for="rating_13"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota4" id="rating_13" value="1" /></li>
                        <li class="teste"><label for="rating_14"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota4" id="rating_14" value="2" /></li>
                        <li class="teste"><label for="rating_15"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota4" id="rating_15" value="3" /></li>
                        <li class="teste"><label for="rating_16"><i class="fa fa-star" aria-hidden="true"></i></label><input type="radio" name="nota4" id="rating_16" value="4" /></li>
                    </ul>
                    Comentario: <textarea onkeyup="limite4(this.value)" style="width: 300px; height: 100px; resize: none;" name="comentario4" maxlength="140" placeholder="Digite seu comentario (Não obrigatório) máx 140 caracteres" id="texto4"></textarea><span id="cont4">140</span> Restantes <br>
                   <button type="submit" class="btn btn-primary" name="command"
					value="CriarAvaliacao">Avaliar</button>
                </section>
            </li>
        </ul>
    </form>
       
        <script>
            $('li.teste').on('click', function() {
                $('li').removeClass('active');
                $('li').removeClass('secondary-active');
                $(this).addClass('active');
                $(this).prevAll().addClass('secondary-active');
            })
        </script>

</body>

</html>