<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <div class="sidebar" data-color="white" data-active-color="danger">
      <div class="logo">
        <a  class="simple-text logo-mini">
          <div class="logo-image-small">
            <img src="<%= request.getContextPath() %>/assets/img/logo-small.png">
          </div>
          <!-- <p>CT</p> -->
        </a>
        <a  class="simple-text logo-normal">
          <%= session.getAttribute("usuario") %>     
        </a>
      </div>
      <div class="sidebar-wrapper">
        <ul class="nav">
          <li class="active ">
            <a href="<%= request.getContextPath()%>/principal/principal.jsp">
              <i class="nc-icon nc-bank"></i>
              <p>Dashboard</p>
            </a>
          </li>
          <li>
            <a href="<%= request.getContextPath()%>/principal/alunos.jsp">
              <i class="nc-icon nc-single-02"></i>
              <p>Alunos</p>
            </a>
          </li>
          <li>
            <a href="./editora.html">
              <i class="nc-icon nc-pin-3"></i>
              <p>Editoras</p>
            </a>
          </li>
          <li>
            <a href="<%= request.getContextPath()%>/principal/funcionarios.jsp">
              <i class=" nc-icon nc-badge"></i>
              <p>funcionarios</p>
            </a>
          </li>
          <li>
            <a href="./livro.html">
              <i class="nc-icon nc-book-bookmark"></i>
              <p>Livros</p>
            </a>
          </li>
          <li>
            <a href="./tables.html">
              <i class="nc-icon nc-tile-56"></i>
              <p>Table List</p>
            </a>
          </li>
          <li>
            <a href="./typography.html">
              <i class="nc-icon nc-caps-small"></i>
              <p>Typography</p>
            </a>
          </li>
        </ul>
      </div>
    </div>