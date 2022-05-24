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
								<form>
									<div class="row">
										<div class="col-md-5 pr-1">
											<div class="form-group">
												<label>ID</label> <input type="text"
													class="form-control" id="idAluno" name="idAluno" readonly="readonly">
				                                            
											</div>
										</div>
										<div class="col-md-3 px-1">
											<div class="form-group">
												<label>Nome</label> <input type="text" class="form-control"
													placeholder="name" name="nome" id="nome">
											</div>
										</div>
										<div class="col-md-4 pl-1">
											<div class="form-group">
												<label for="exampleInputEmail1">Telefone</label> <input
													type="email" class="form-control" placeholder="telefone"
													name="telefone" id="telefone">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 pr-1">
											<div class="form-group">
												<label>CPF</label> <input type="text" class="form-control"
													placeholder="cpf" name="cpf" id="cpf">
											</div>
										</div>
										<div class="col-md-6 pl-1">
											<div class="form-group">
												<label>Cep</label> <input type="text" class="form-control"
													placeholder="cep" name="cep" id="cep">
											</div>
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 pr-1">
											<div class="form-group">
												<label>Logradouro</label> <input type="text"
													class="form-control" placeholder="logradouro"
													name="logradouro" id="logradouro">
											</div>
										</div>
										<div class="col-md-6 pl-1">
											<div class="form-group">
												<label>Número</label> <input type="text"
													class="form-control" placeholder="numero" name="logradouro"
													id="logradouro">
											</div>
										</div>
									</div>


									<div class="row">
										<div class="col-md-4 pr-1">
											<div class="form-group">
												<label>Bairro</label> <input type="text"
													class="form-control" placeholder="bairro" name="bairro"
													id="bairro">
											</div>
										</div>
										<div class="col-md-4 px-1">
											<div class="form-group">
												<label>Cidade</label> <input type="text"
													class="form-control" placeholder="cidade" name="cidade"
													id="cidade">
											</div>
										</div>
										<div class="col-md-4 pl-1">
											<div class="form-group">
												<label>UF</label> <input type="text" class="form-control"
													placeholder="uf" name="uf" id="uf">
											</div>
										</div>
									</div>

									<div class="row">
										<div class="update ml-auto mr-auto">
											<button type="submit" class="btn btn-primary btn-round">Cadastrar</button>
										</div>
									</div>
								</form>
							</div>
						</div>
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

</body>

</html>