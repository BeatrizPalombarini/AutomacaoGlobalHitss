#language: pt

@ObterFrete 
Funcionalidade: Obter o frete
	
	Contexto:
		Dado que eu acesse o site
    Entao sera validado o acesso
     
   Cenario: 01 - Validar o endpoint
    Dado que tenha um endpoint "ws/SP/São%20Paulo/"
    E tenha o endereco da rua "Henri%20Dunant"
    Quando for realizada uma requisicao "https://viacep.com.br/"
    Entao devera retornar o status "200"
    
   Cenario: 02 - Realizar a busca de CEP por endereço
    Dado que tenha um endpoint "ws/SP/São%20Paulo/"
    E tenha o endereco da rua "Henri%20Dunant"
    Quando for realizada uma requisicao "https://viacep.com.br/"
    Entao devera retornar o status "200"
    E devera retornar um CEP valido
    
   @Positivo
   Esquema do Cenario: 03 - Validar item no carrinho e frete positivo
   	Dado que eu pesquise um produto <produto>
   	Quando escolher o produto desejado <numeroDoProduto>
   	E validar a página do produto 
   	E adicionar o produto ao carrinho
   	E realizar a busca de cep pelo endereco <endereco>
   	E inserir o CEP
   	Entao sera exibido o valor do frete
   	
   	Exemplos:
   	|produto                        |numeroDoProduto|endereco        |
   	|"Código Limpo"                 |"1"            |"Henri%20Dunant"|
   	|"webcam"                       |"3"            |"Henri%20Dunant"|
   	|"Teclado Mecânico"             |"8"            |"Henri%20Dunant"|
   	|"Livro Algoritmo e Programação"|"1"            |"Henri%20Dunant"|
   	|"Livro Matemática Discreta"    |"2"            |"Henri%20Dunant"|
   	
   @Negativo
   Esquema do Cenario: 04 - Validar item no carrinho e frete negativo
   	Dado que eu pesquise um produto <produto>
   	Quando escolher o produto desejado <numeroDoProduto>
   	Entao devera dar erro ao escolher o produto pelo <numeroDoProduto>
   	
   	Exemplos:
   	|produto                        |numeroDoProduto|endereco        |
   	|"Código Limpo"                 |"a"            |"Henri%20Dunant"|
   	|"webcam"                       |"b"            |"Henri%20Dunant"|
   	
   Esquema do Cenario: 04 - Validar item no carrinho e frete negativo
   	Dado que eu pesquise um produto <produto>
   	Quando escolher o produto desejado <numeroDoProduto>
   	E validar a página do produto 
   	E adicionar o produto ao carrinho
   	E realizar a busca de cep pelo endereco <endereco>
   	Entao devera dar erro ao buscar o cep
   	
   	Exemplos:
   	|produto                        |numeroDoProduto|endereco        |
   	|"Teclado Mecânico"             |"8"            |"!"             |
   	|"Livro Algoritmo e Programação"|"1"            |"!@"            |
   	|"Livro Matemática Discreta"    |"2"            |"!@#$"          |