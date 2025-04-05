# 🔎 Buscador de CEP com JavaFX + Spring Boot

Este projeto é uma aplicação desktop feita com **JavaFX** para interface gráfica e **Spring Boot** para consumo de API de CEP (como o ViaCEP). A ideia é oferecer uma ferramenta simples para consultar dados de endereços a partir de um CEP, com interface amigável e moderna.

---

## 🧱 Estrutura do Projeto

O projeto é composto por dois módulos principais:

- `CepJavaFXApp`: Responsável pela **interface gráfica** (JavaFX)
- `Buscador_CEP`: Responsável pelo **consumo da API de CEP** (Spring Boot)

Estes dois módulos estão integrados, e o Spring Boot é iniciado dentro da aplicação JavaFX.

---

## 🎯 Funcionalidades

- Busca de endereço a partir do CEP
- Exibição de logradouro, bairro, cidade, estado
- Botão **"Limpar"** para resetar os campos
- Janela **"Sobre"** que é exibida ao iniciar o app (obrigatória de fechar para usar)

---

🛠️ Tecnologias utilizadas
Java 17

Spring Boot

JavaFX (FXML)

Maven

API ViaCEP

---

## 🚀 Como executar

### ✅ Requisitos

- Java 17 ou superior
- Maven 3.6+
- IDE (IntelliJ recomendada)

### ▶️ Rodar via Maven

```bash
mvn clean package
java -jar target/CepJavaFXApp.jar

Ou, se estiver usando JDK 17+ com jpackage, você pode gerar um .exe:

jpackage --input target --name BuscadorCEP --main-jar CepJavaFXApp.jar --main-class com.seupacote.MainApp --type exe

Substitua com.seupacote.MainApp pelo seu pacote real.
