# Project Nexus - Biblioteca de Validação de propriedades e metodos

uma biblioteca de validação desenvolvida como parte do projeto Nexus. O objetivo principal desta biblioteca é fornecer funcionalidades permitindo validar campos e properidades de metodos para facilitar outros projetos e separar as responsabilidades

## Funcionalidades Principais

- **Validação com notação**: A Lib utiliza como apoio a dependencia de validation do spring-boot,o que permitirá a criação de diversos tipos de notações.
- **Testes Abrangentes**: A biblioteca é acompanhada por testes unitários para garantir o correto funcionamento das funcionalidades.


## Como usar

Para usar esta biblioteca, você precisa adicionar as seguintes dependências e repositórios ao seu arquivo `pom.xml`:

### Dependências

Inclua a seguinte dependência dentro da tag `<dependencies>` do seu `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>com.nexus</groupId>
        <artifactId>validations</artifactId>
        <version>0.0.1-SNAPSHOT</version>
    </dependency>
    <!-- outras dependências aqui -->
</dependencies>
```

Inclua a seguinte dependência dentro da tag `<repositories>` do seu `pom.xml`:

```xml
<repositories>
    <repository>
        <id>lib-validations</id>
        <url>https://raw.githubusercontent.com/igorcampos-dev/nexus.java.lib.validations/master/target/</url>
    </repository>
    <!-- outros repositórios aqui -->
</repositories>

```