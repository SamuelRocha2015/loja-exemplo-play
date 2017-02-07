package controllers;

import java.util.List;

import javax.inject.Inject;

import DAO.ProdutoDAO;
import models.Produto;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;

public class ApiController extends Controller {
	

	@Inject
	ProdutoDAO dao;

	public Result api() {
		List<Produto> lista = dao.getAll();
		return ok(Json.toJson(lista));
	}
	
	public Result apiTipo(String tipo) {
		List<Produto> lista = dao.getByTipo(tipo);
		return ok(Json.toJson(lista));
	}
}
