package DAO;

import java.util.List;

import models.Produto;
//import com.avaje.ebean.Finder;
import  com.avaje.ebean.Model.*;
import play.db.ebean.*;


public class ProdutoDAO {
	
	private Finder<Long, Produto> produtos = new Finder<>(Produto.class);
	   

	public List<Produto> getAll() {
		 return produtos.all();
	}


	public List<Produto> getByTipo(String tipo) {
		return produtos.
				where().eq("tipo", tipo) .findList();
	}

}
