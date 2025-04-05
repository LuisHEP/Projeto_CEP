package com.example.cepjavafxapp.ui;

import com.example.cepjavafxapp.service.CepService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CepApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        SobreDialog.mostrarSobre(primaryStage);

        primaryStage.setTitle("Buscador de CEP");

        Label cepLabel = new Label("CEP:");
        TextField cepInput = new TextField();
        cepInput.setPromptText("Digite o CEP");
        cepInput.setMaxWidth(100);
        cepInput.setStyle("-fx-font-size: 14px;");

        cepInput.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                cepInput.setText(oldValue);
            }
            if (newValue.length() > 8) {
                cepInput.setText(newValue.substring(0, 8));
            }
        });

        Button buscarBtn = new Button("Buscar");
        Button limparBtn = new Button("Limpar");

        buscarBtn.setStyle("-fx-font-size: 14px; -fx-padding: 5px 10px;");
        limparBtn.setStyle("-fx-font-size: 14px; -fx-padding: 5px 10px;");

        TextField logradouroOutput = criarCampoSaida();
        TextField bairroOutput = criarCampoSaida();
        TextField cidadeOutput = criarCampoSaida();
        TextField estadoOutput = criarCampoSaida();
        TextField dddOutput = criarCampoSaida();

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(12));
        grid.setVgap(8);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.add(cepLabel, 0, 0);
        grid.add(cepInput, 1, 0);
        grid.add(buscarBtn, 2, 0);
        grid.add(limparBtn, 3, 0);

        grid.add(new Label("Rua:"), 0, 1);
        grid.add(logradouroOutput, 1, 1, 3, 1);

        grid.add(new Label("Bairro:"), 0, 2);
        grid.add(bairroOutput, 1, 2, 3, 1);

        grid.add(new Label("Cidade:"), 0, 3);
        grid.add(cidadeOutput, 1, 3, 3, 1);

        grid.add(new Label("Estado:"), 0, 4);
        grid.add(estadoOutput, 1, 4, 3, 1);

        grid.add(new Label("DDD:"), 0, 5);
        grid.add(dddOutput, 1, 5, 3, 1);

        buscarBtn.setOnAction(e -> {
            String cep = cepInput.getText();
            if (cep.length() == 8) {
                var resultado = CepService.buscarCep(cep);

                if (resultado != null) {
                    logradouroOutput.setText(resultado.get("logradouro"));
                    bairroOutput.setText(resultado.get("bairro"));
                    cidadeOutput.setText(resultado.get("localidade"));
                    estadoOutput.setText(resultado.get("uf"));
                    dddOutput.setText(resultado.get("ddd"));
                } else {
                    logradouroOutput.setText("Erro ao buscar");
                    bairroOutput.clear();
                    cidadeOutput.clear();
                    estadoOutput.clear();
                    dddOutput.clear();
                }
            } else {
                logradouroOutput.setText("CEP inválido!");
            }
        });

        limparBtn.setOnAction(e -> {
            cepInput.clear();
            logradouroOutput.clear();
            bairroOutput.clear();
            cidadeOutput.clear();
            estadoOutput.clear();
            dddOutput.clear();
        });

        Scene scene = new Scene(grid, 370, 250);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private TextField criarCampoSaida() {
        TextField campo = new TextField();
        campo.setEditable(false);
        campo.setStyle("-fx-font-size: 14px; -fx-font-family: 'Arial';");
        return campo;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
