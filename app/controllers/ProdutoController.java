package controllers;

import java.util.List;

import javax.inject.Inject;

import DAO.ProdutoDAO;
import models.Produto;
import play.data.DynamicForm;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.*;

public class ProdutoController extends Controller {

	@Inject
	FormFactory formularios;

	@Inject
	ProdutoDAO dao;

	public Result form() {
		DynamicForm formulario = formularios.form();
		return ok(formProduto.render(formulario));
	}

	public Result salva() {
		Form<Produto> formulario = formularios.form(Produto.class).bindFromRequest();
		Produto produto = formulario.get();
		produto.save();
		flash("success", "seu " + produto.getTipo() + " foi cadastrado com sucess!");
		return redirect(routes.ProdutoController.form());
	}
	
	
	public Result lista() {
		List<Produto> lista = dao.getAll();
		return ok(listaProduto.render(lista));
	}
	

}
