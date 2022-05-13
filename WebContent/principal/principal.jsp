<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html lang="en">

<!-- In�cio head -->

 <jsp:include page="head.jsp"></jsp:include>

<!-- Fim head -->

<body class="">
  <div class="wrapper ">
    
    <!-- In�cio sidebar -->
       
       <jsp:include page="sidebar.jsp"></jsp:include>
    
    <!-- Fim sidbar -->
    
    <div class="main-panel">
    
      <!-- Navbar -->
      
       <jsp:include page="nav.jsp"></jsp:include>
      
      <!-- End Navbar -->
      
      <div class="content">
        <!-- In�cio Card -->
          
          <jsp:include page="card.jsp"></jsp:include>
          
        <!-- Fim Card -->
        
        <div class="row">
        
        </div>
        
       </div>
       
       <!-- In�cio footer -->
   
          
          
       <!-- Fim footer -->
      
    </div>
  </div>
  
  <!--   Core JS Files   -->
  <jsp:include page="scripts.jsp"></jsp:include>
  
</body>

</html>
   