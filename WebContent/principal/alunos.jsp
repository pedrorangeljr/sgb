<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html lang="en">

<!-- Início head -->

<jsp:include page="head.jsp"></jsp:include>

<!-- Fim head -->

<body class="">
	<div class="wrapper ">

		<!-- Início sidebar -->

		<jsp:include page="sidebar.jsp"></jsp:include>

		<!-- Fim sidbar -->

		<div class="main-panel">

			<!-- Inicio Navbar -->

			<jsp:include page="nav.jsp"></jsp:include>

			<!-- Fim Navbar -->

			<div class="content">
				<div class="row">

					<div class="col-md-12">
						<div class="card card-user">
							<div class="card-header">
								<h5 class="card-title">Cadastro de Alunos</h5>
							</div>
							<div class="card-body">
								<form method="post"
									action="<%=request.getContextPath()%>/ServletAluno"
									id="formAluno">
									<input type="hidden" name="acao" id="acao" valeu="">
									<div class="row">
										<div class="col-md-5 pr-1">
											<div class="form-group">
												<label>ID</label> <input type="text" class="form-control"
													id="idAluno" name="idAluno" readonly="readonly"
													value="${alunos.idAluno }">

											</div>
										</div>
										<div class="col-md-3 px-1">
											<div class="form-group">
												<label>Nome</label> <input type="text" class="form-control"
													placeholder="name" name="nome" id="nome"
													value="${alunos.nome }">
											</div>
										</div>
										<div class="col-md-4 pl-1">
											<div class="form-group">
												<label for="exampleInputEmail1">Telefone</label> <input
													type="text" class="form-control" placeholder="telefone"
													name="telefone" id="telefone" value="${alunos.telefone }">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 pr-1">
											<div class="form-group">
												<label>CPF</label> <input type="text" class="form-control"
													placeholder="cpf" name="cpf" id="cpf"
													value="${alunos.cpf }">
											</div>
										</div>
										<div class="col-md-6 pl-1">
											<div class="form-group">
												<label>Cep</label> <input type="text" class="form-control"
													placeholder="cep" onblur="pesquisaCep();" name="cep"
													id="cep" value="${alunos.cep }">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 pr-1">
											<div class="form-group">
												<label>Logradouro</label> <input type="text"
													class="form-control" placeholder="logradouro"
													name="logradouro" id="logradouro"
													value="${alunos.logradouro }">
											</div>
										</div>
										<div class="col-md-6 pl-1">
											<div class="form-group">
												<label>Número</label> <input type="text"
													class="form-control" placeholder="numero" name="numero"
													id="numero" value="${alunos.numero }">
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-md-4 pr-1">
											<div class="form-group">
												<label>Bairro</label> <input type="text"
													class="form-control" placeholder="bairro" name="bairro"
													id="bairro" value="${alunos.bairro }">
											</div>
										</div>
										<div class="col-md-4 px-1">
											<div class="form-group">
												<label>Cidade</label> <input type="text"
													class="form-control" placeholder="cidade" name="cidade"
													id="cidade" value="${alunos.cidade }">
											</div>
										</div>
										<div class="col-md-4 pl-1">
											<div class="form-group">
												<label>UF</label> <input type="text" class="form-control"
													placeholder="uf" name="uf" id="uf" value="${alunos.uf }">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="update ml-auto mr-auto">
											<button type="button" class="btn btn-primary btn-round"
												onclick="limparForm();">Novo</button>
											<button type="submit" class="btn btn-success btn-round">Cadastrar</button>
											<button type="button" class="btn btn-danger btn-round"
												onclick="criarDelete();">Excluir</button>

											<!-- Button trigger modal -->
											<button type="button" class="btn btn-dark btn-round"
												data-toggle="modal" data-target="#exampleModalAluno">
												Pesquisar</button>
										</div>
									</div>
								</form>
							</div>
						</div>
						<span>${msg }</span>
					</div>

				</div>
			</div>
		</div>


		<!-- Início footer -->



		<!-- Fim footer -->

	</div>
	</div>

	<!--   Core JS Files   -->
	<jsp:include page="scripts.jsp"></jsp:include>

	<!-- Modal -->
	<div class="modal fade" id="exampleModalAluno" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabelAluno"
		aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabelAluno">Pesquisa
						de Alunos</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				
				<div class="modal-body">
				
				   <div class="input-group mb-3">
							<input type="text"  class="form-control" id="nomeBusca"
								placeholder="nome...">
							<div class="input-group-append">
								<button type="button" class="input-group-text" onclick="buscarAluno();">
									<i class="nc-icon nc-zoom-split"></i>
								</button>
							</div>
						</div>
						
				 <div style="height: 300px;overflow: scroll">
                  <table class="table" id="tabelaFunc">
                    <thead class=" text-primary">
                      <th>
                        ID
                      </th>
                      <th>
                        Nome
                      </th>
                      <th>
                        Ver
                      </th>
                    </thead>
                    <tbody>
                    
                    </tbody>
                  </table>
                 
                  </div>
				
				</div>
				
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary btn-round"
						data-dismiss="modal">Fechar</button>

				</div>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	
	    function buscarAluno() {
	    	
	    	var nomeBusca = document.getElementById("nomeBusca").value;
	    	
	    	if(nomeBusca != null && nomeBusca != '' && nomeBusca.trim() != '') {
	    		
	    		var urlAction = document.getElementById('formAluno').action;
	    		
	    		 $.ajax({
	    		     
	    		     method: "get",
	    		     url : urlAction,
	    		     data : "nomeBusca" + nomeBusca + '&acao=buscarAlunoAjax',
	    		     success: function (response) {
	    			 
	    			 
	    			  
	    		     }
	    		     
	    		 }).fail(function(xhr, status, errorThrown){
	    		    alert('Erro ao buscar aluno por nome: ' + xhr.responseText);
	    		 });
	    		 
	    	}
	    }
	    
		function pesquisaCep() {

			var cep = $('#cep').val();

			$.getJSON("https://viacep.com.br/ws/" + cep + "/json/?callback=?",
					function(dados) {

						if (!("erro" in dados)) {

							$('#cep').val(dados.cep);
							$("#logradouro").val(dados.logradouro);
							$("#bairro").val(dados.bairro);
							$("#cidade").val(dados.localidade);
							$("#uf").val(dados.uf);

						}

					});

		}

		function limparForm() {

			var elementos = document.getElementById("formAluno").elements;

			for (p = 0; p < elementos.length; p++) {

				elementos[p].value = '';
			}
		}

		function criarDelete() {

			if (confirm("Deseja Excluir o Aluno ?")) {

				document.getElementById("formAluno").method = "get";
				document.getElementById("acao").value = 'deletar';
				document.getElementById("formAluno").submit();
			}
		}
	</script>
</body>

</html>