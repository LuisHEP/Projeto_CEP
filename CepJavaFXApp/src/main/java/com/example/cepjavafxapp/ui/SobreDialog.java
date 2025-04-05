package com.example.cepjavafxapp.ui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.scene.Cursor;
import javafx.stage.Stage;
import java.io.InputStream;
import javafx.scene.image.Image;

import java.awt.*;
import java.net.URI;

public class SobreDialog {

    public static void mostrarSobre(Stage parentStage) {
        Stage sobreStage = new Stage();
        sobreStage.initModality(Modality.APPLICATION_MODAL);
        sobreStage.setTitle("Sobre o Aplicativo");

        Label titulo = new Label("Buscador de CEP");
        titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Label autor = new Label("Desenvolvido por Luis Paladino");
        autor.setStyle("-fx-font-size: 14px;");

        // Criando ícones e ajustando layout
        ImageView linkedinIcon = criarIcone("/icons/linkedin.png", "https://www.linkedin.com/in/luis-paladino/");
        ImageView githubIcon = criarIcone("/icons/github.png", "https://github.com/LuisHEP");

        HBox iconesBox = new HBox(20, linkedinIcon, githubIcon);
        iconesBox.setAlignment(Pos.CENTER);

        Button fecharButton = new Button("Fechar");
        fecharButton.setOnAction(e -> sobreStage.close());

        VBox layout = new VBox(15, titulo, autor, iconesBox, fecharButton);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 320, 230);
        sobreStage.setScene(scene);
        sobreStage.initOwner(parentStage);
        sobreStage.showAndWait();
    }

    private static ImageView criarIcone(String caminhoImagem, String url) {
        InputStream imgStream = SobreDialog.class.getResourceAsStream(caminhoImagem);
        if (imgStream == null) {
            throw new IllegalArgumentException("Imagem não encontrada: " + caminhoImagem);
        }

        ImageView icon = new ImageView(new Image(imgStream));
        icon.setFitWidth(32);
        icon.setFitHeight(32);
        icon.setCursor(Cursor.HAND);

        icon.setOnMouseClicked(event -> abrirNavegador(url));
        return icon;
    }

    private static void abrirNavegador(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
