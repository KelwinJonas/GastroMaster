package br.com.ufrpeuag.gastromaster.ui;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.com.ufrpeuag.gastromaster.negocio.excecoes.GarcomInexistenteException;
import br.com.ufrpeuag.gastromaster.negocio.excecoes.GerenteInexistenteException;
import br.com.ufrpeuag.gastromaster.negocio.excecoes.ListarTodosInvalidoException;
import br.com.ufrpeuag.gastromaster.negocio.fachada.Fachada;
import br.com.ufrpeuag.gastromaster.negocio.modelo.classes.Garcom;
import br.com.ufrpeuag.gastromaster.negocio.modelo.classes.Gerente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class FuncionariosControlador implements Initializable{
	
	@FXML
	private TableView<Gerente> gerenteList;
	@FXML
	private TableColumn<Gerente, String> nomeColunaGerente;
	@FXML
	private TableColumn<Gerente, String> identificadorColunaGerente;

	private List<Gerente> gerentes = new ArrayList<>();
    private ObservableList<Gerente> listaObservabelGerente;
    
	@FXML
	private Label nomeLabelGerente;
	@FXML
	private Label cpfLabelGerente;
	@FXML
	private Label dataNascLabelGerente;
	@FXML
	private Label telefoneLabelGerente;
	@FXML
	private Label emailLabelGerente;
	@FXML
	private Label salarioLabelGerente;
	@FXML
	private Label senhaLabelGerente;
	@FXML
	private Label identificadorLabelGerente;
	@FXML
	private Label cidadeLabelGerente;
	@FXML
	private Label bairroLabelGerente;
	@FXML
	private Label ruaLabelGerente;
	@FXML
	private Label numeroLabelGerente;
	@FXML
	private Label cepLabelGerente;
	@FXML
	private Button deletarGerente;
	@FXML
	private Button cadastrarGerente;
	

    @FXML
	private TableView<Garcom> garcomList;
	@FXML
	private TableColumn<Garcom, String> nomeColunaGarcom;
	@FXML
	private TableColumn<Garcom, String> identificadorColunaGarcom;

	private List<Garcom> garcons = new ArrayList<>();
    private ObservableList<Garcom> listaObservabelGarcom;
	
	@FXML
	private Label nomeLabelGarcom;
	@FXML
	private Label cpfLabelGarcom;
	@FXML
	private Label dataNascLabelGarcom;
	@FXML
	private Label telefoneLabelGarcom;
	@FXML
	private Label emailLabelGarcom;
	@FXML
	private Label salarioLabelGarcom;
	@FXML
	private Label identificadorLabelGarcom;
	@FXML
	private Label cidadeLabelGarcom;
	@FXML
	private Label bairroLabelGarcom;
	@FXML
	private Label ruaLabelGarcom;
	@FXML
	private Label numeroLabelGarcom;
	@FXML
	private Label cepLabelGarcom;	
	@FXML
	private Button deletarGarcom;
	@FXML
	private Button cadastrarGarcom;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			listarFuncionarios();
		} catch (ListarTodosInvalidoException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		mostarDetalhesGerente(null);
		mostarDetalhesGarcom(null);
		gerenteList.getSelectionModel().selectedItemProperty().addListener((observable, odlValue, newValeu) -> mostarDetalhesGerente(newValeu));
		garcomList.getSelectionModel().selectedItemProperty().addListener((observable, odlValue, newValeu) -> mostarDetalhesGarcom(newValeu));
		
	}
	
	public void listarFuncionarios() throws ListarTodosInvalidoException, SQLException{
		gerentes = Fachada.getSingleton().listarTodosGerentes();
		listaObservabelGerente = FXCollections.observableArrayList(gerentes);
		gerenteList.setItems(listaObservabelGerente);
		nomeColunaGerente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		identificadorColunaGerente.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificador()));
		
		garcons = Fachada.getSingleton().ListarTodosGarcons();
		listaObservabelGarcom = FXCollections.observableArrayList(garcons);
		garcomList.setItems(listaObservabelGarcom);
		nomeColunaGarcom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNome()));
		identificadorColunaGarcom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdentificador()));
    
    }
	
	public void mostarDetalhesGerente(Gerente gerente) {
		if(gerente != null) {
			nomeLabelGerente.setText(gerente.getNome());
			cpfLabelGerente.setText(gerente.getCpf());
			//dataNascLabelGerente.setText(gerente.getDataNasc());
			telefoneLabelGerente.setText(gerente.getTelefone());
			emailLabelGerente.setText(gerente.getEmail());
			salarioLabelGerente.setText(Double.toString(gerente.getSalario()));
			senhaLabelGerente.setText(gerente.getSenha());
			identificadorLabelGerente.setText(gerente.getIdentificador());
			cidadeLabelGerente.setText(gerente.getEndereco().getCidade());
			bairroLabelGerente.setText(gerente.getEndereco().getBairro());
			ruaLabelGerente.setText(gerente.getEndereco().getRua());
			numeroLabelGerente.setText(Integer.toString(gerente.getEndereco().getNumero()));
			cepLabelGerente.setText(gerente.getEndereco().getCep());
		} else {
			nomeLabelGerente.setText("");
			cpfLabelGerente.setText("");
			dataNascLabelGerente.setText("");
			telefoneLabelGerente.setText("");
			emailLabelGerente.setText("");
			salarioLabelGerente.setText("");
			senhaLabelGerente.setText("");
			identificadorLabelGerente.setText("");
			cidadeLabelGerente.setText("");
			bairroLabelGerente.setText("");
			ruaLabelGerente.setText("");
			numeroLabelGerente.setText("");
			cepLabelGerente.setText("");
		}
		
	}
	
	public void mostarDetalhesGarcom(Garcom garcom) {
		if(garcom != null) {
			nomeLabelGarcom.setText(garcom.getNome());
			cpfLabelGarcom.setText(garcom.getCpf());
			//dataNascLabelGarcom.setText(garcom.getDataNasc());
			telefoneLabelGarcom.setText(garcom.getTelefone());
			emailLabelGarcom.setText(garcom.getEmail());
			salarioLabelGarcom.setText(Double.toString(garcom.getSalario()));
			identificadorLabelGarcom.setText(garcom.getIdentificador());
			cidadeLabelGarcom.setText(garcom.getEndereco().getCidade());
			bairroLabelGarcom.setText(garcom.getEndereco().getBairro());
			ruaLabelGarcom.setText(garcom.getEndereco().getRua());
			numeroLabelGarcom.setText(Integer.toString(garcom.getEndereco().getNumero()));
			cepLabelGarcom.setText(garcom.getEndereco().getCep());
		} else {
			nomeLabelGarcom.setText("");
			cpfLabelGarcom.setText("");
			dataNascLabelGarcom.setText("");
			telefoneLabelGarcom.setText("");
			emailLabelGarcom.setText("");
			salarioLabelGarcom.setText("");
			identificadorLabelGarcom.setText("");
			cidadeLabelGarcom.setText("");
			bairroLabelGarcom.setText("");
			ruaLabelGarcom.setText("");
			numeroLabelGarcom.setText("");
			cepLabelGarcom.setText("");
		}
		
	}
	
	@FXML
	public void handleDeletarGerente(ActionEvent event) throws GerenteInexistenteException, SQLException {
		try {
			Gerente gerente = new Gerente();
			gerente = gerenteList.getSelectionModel().getSelectedItem();
			Fachada.getSingleton().deletarGerente(gerente);
			listarFuncionarios();
			CaixasDeAlerta.CaixaConcluido("Deletar Gerente", "Gerente deletado.");
		}catch(GerenteInexistenteException  ex) {
			CaixasDeAlerta.CaixaErro("Deletar Gerente", ex.getLocalizedMessage(), "Selecione um gerente para deletar.");
		}catch(Exception ex) {
			CaixasDeAlerta.CaixaErro("Deletar Gerente", "Erro inesperado.", "Erro inesperado.");
		}
	}
	
	@FXML
	public void handleDeletarGarcom(ActionEvent event) throws GarcomInexistenteException, SQLException {
		try {
			Garcom garcom = new Garcom();
			garcom = garcomList.getSelectionModel().getSelectedItem();
			Fachada.getSingleton().deletarGarcom(garcom);
			listarFuncionarios();
			CaixasDeAlerta.CaixaConcluido("Deletar Gar�om", "Gar�om deletado.");
		}catch(GarcomInexistenteException ex) {
			CaixasDeAlerta.CaixaErro("Deletar Gar�om", ex.getLocalizedMessage(), "Selecione um gar�om para deletar.");
		}catch(Exception ex) {
			CaixasDeAlerta.CaixaErro("Deletar Gar�om", "Erro inesperado.", "Erro inesperado.");
		}
	}
	
	@FXML
	public void handleCadastarGerente(ActionEvent event) {
		
	}
	
	

}
