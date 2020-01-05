# testeUBS

Passo 1 - Onde esta localizado o projeto
Projeto esta no bitbucket
link: https://evandrocp@bitbucket.org/ironsoftbr/ubs_teste.git


Passo 2 - Baixar o projeto
- Após baixar o projeto no workspace, abrir o Eclipse STS, fazer o import do projeto pelo pacote maven
- Configurar o java jdk 1.8 no build path

Passo 3 - Baixar os pacotes do maven que estão no POM.xml
Pelo eclipse, clica sobre o projeto, run as, Maven clean e depois Maven install

Passo 4 - Para executar o projeto
Atenção: a porta 8080 tem que estar disponivel no computador.
É um projeto spring boot, executar o arquivo TesteUbsApplication.java

Passo 5 - Arquivo de Configuração
O Arquivo application.properties tem configurações do path onde será colocado os arquivos .json e os paths serão criados ao executar o projeto
Como default temos:
path.arquivo.json=c:/Temp/UBS/IN
path.criarestruturadiretorioIN=c:/temp/UBS/IN/processado
path.criarestruturadiretorioOUT=c:/temp/UBS/OUT/enviado

Pode ser alterado conforme sua preferencia ou sistema operacional

Passo 6 - O projeto em execução
Abrir o browser com o link: http://localhost:8080/api/swagger-ui.html

Passo 7 - Metodos criados

acesso-banco-controller (Utilizar estes metodos somente se o banco de dados não foi criado, ele será criado como nome banco.db na raiz do projeto)
- conectarBanco: irá conectar no banco sqlite
- criarTabela: cria a tabela para importação dos arquivos .json

teste-ambiente-controller
- testeAmbiente: metodo criado para testar se ambiente esta no ar

data-controller
- carregaArquivos: Para efetuar a importação dos dados no banco sqlite (banco.db)

calculo-controller
- calculo: Para efetuar o processamento de calculo (exercicio 2), colocar o nome do produto e quantas lojas serão divididos



