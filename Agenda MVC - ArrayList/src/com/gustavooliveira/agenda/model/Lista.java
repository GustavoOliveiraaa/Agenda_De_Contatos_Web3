package com.gustavooliveira.agenda.model;
import java.util.ArrayList;
import java.util.List;

public class Lista {
	//Atributos
	private static List<Contato> lista;
	
	//Instância Única da lista (Singleton)
	public static List<Contato> getInstance() {
		if (lista == null) {
		lista = new ArrayList<>();	
		}
	return lista;
	}
}
