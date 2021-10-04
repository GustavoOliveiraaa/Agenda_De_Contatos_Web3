package com.gustavooliveira.agenda.controller;



import javax.swing.JOptionPane;

import com.gustavooliveira.agenda.model.Contato;
import com.gustavooliveira.agenda.model.Lista;
import com.gustavooliveira.agenda.view.Tela;

public class Agenda {
	//Atributos

	//Métodos
	public void iniciarAgenda() {
		//Criar o objeto da classe Tela
	Tela tela = new Tela();
	
	
	//Estrutura do Menu
	String menu = ":: Agenda de Contatos ::\n\n" +
	"1. Cadastrar\n" +
	"2. Buscar\n" +
	"3. Editar\n" +
	"4. Excluir\n\n"
	;
	
	//CRUD
	//Create Read Update Delete
	
	//Menu ativo
	
	boolean isAtivo = true;
	
	//Loop principal do sistema
	while (isAtivo) {
		String opcao = tela.informar(menu, "Informe uma opção do Menu QwQ", -1);
		
		switch(opcao) {
			case "1":
				cadastrarContato(tela);
				break;
				
			case "2":
				buscarContato(tela);
				break;
				
			case "3":
				editarContato(tela);
				break;
			
			case "4":
				deletarContato(tela);
				break;
				
			default: 
				int sair = tela.confirmar("Deseja sair?", "Encerrar", 3);
				
				if (sair == 0) {
					isAtivo = false;
					tela.mostrar("Encerrando o sistema... ", "Encerrando", 1);
				}
			} //Fecha o swiitch
		} // Fecha o while
	} // Fecha o método IniciarAgenda()
	private void cadastrarContato(Tela tela) {
		//Criar a Lista Singleton
		
		//Usuário informa os dados
	String nome = tela.informar("Informe o Nome", "Nome", 1);
	String email = tela.informar("Informe o E-mail", "E-mail", 1);
	String fone = tela.informar("Informe o Telefone", "Fone", 1);
	
	//Objeto da classe contato
	Contato contato = new Contato(nome, email, fone);
	
	//Adicionar o Contato na Lista de contatos da Agenda
	Lista.getInstance().add(contato);
	}
	//---------
	private void buscarContato(Tela tela) {
		//Guarda o número de registros na Lista
		int numeroRegistros = Lista.getInstance().size();
		
		if (numeroRegistros > 0) {
			String listaContatos = "";
			
			for (int i = 0; i < numeroRegistros; i++) {
				listaContatos +=
						"ID:" + (i + 1) +
						"\nNome:" + Lista.getInstance().get(i).getNome() +
						"\nE-mail:"+ Lista.getInstance().get(i).getEmail() +
						"\nFone:" + Lista.getInstance().get(i).getFone() +
						"\n\n";
			}
			// Mostra o resultado da busca
			tela.mostrar(listaContatos, "Contatos", 1);
			
		}else {
			tela.mostrar("Nenhum registro encontrado", "Contatos", 1);
		}
	}
	//---------
	private void editarContato(Tela tela) {
		buscarContato(tela);
		int id;
		
		id = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ID do usuario para a alteração de informaçôes"));
		
		
		//Usuário informa os dados
		String nome = tela.editar("Editar o Nome", "Nome", 1);
		String email = tela.editar("Editar o E-mail", "E-mail", 1);
		String fone = tela.editar("Editar o Telefone", "Fone", 1);
		
		//Objeto da classe contato
		Contato contato = new Contato(nome, email, fone);
		contatoAtualizado(contato, id);
		
			}
	
	private void contatoAtualizado (Contato contato, int id) {
		Lista.getInstance().get(id -1).setNome(contato.getNome());
		Lista.getInstance().get(id -1).setFone(contato.getFone());
		Lista.getInstance().get(id -1).setEmail(contato.getEmail());
}
	
	//--------
	public void deletarContato (Tela tela) {
		
		buscarContato(tela);
		
		int idClear;
		
		idClear = Integer.parseInt(JOptionPane.showInputDialog(null, "Deletar contato?"));
		
		Lista.getInstance().remove(idClear -1);
		}
	}

