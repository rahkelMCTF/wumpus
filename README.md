# Mundo dos Wumpus
O mundo dos wumpus é uma caverna que consiste em salas conectadas por passagens. À espreita em algum lugar na caverna está o terrível wumpus, um monstro que devora qualquer guerreiro que entra em sua sala. O wumpus pode ser atingido por um agente, mas o agente só tem uma flecha. Algumas salas contêm poços sem fundo nos quais cairá qualquer um que vagar por elas (com exceção do wumpus). A única característica que abranda esse ambiente desolador é a possibilidade de encontrar um monte de ouro.

Definição do ambiente de tarefa:
- Medida de desempenho: +1000 ouro; -1000 morrer; -1 por ação; -10 por usar a flecha; 
- Ambiente: malha 4x4 contendo salas; O agente sempre inicia na posição [1,1]; Posições do ouro ou wumpus são escolhidas ao acaso e os poços são escolhidos com probabilidade de 0,2.
- Atuadores: ParaFrente; VirarEsquerda; VirarDireita; Agarrar; Atirar; Escalar;
- Sensores: Fedor, Brisa, Brilho, Impacto, Grito

Como os sensores funcionam:
- Nos quadrados contendo o Wumpus e em seus adjacentes o agente percebe um FEDOR
- Nos quadrados diretamente adjacentes a um poço, o agente percebe a BRISA
- No quadrado onde está o ouro, o agente percebe o BRILHO
- Quando caminha para uma parede, o agente percebe um IMPACTO
- Quando o Wumpus é morto, o agente percebe um GRITO de qualquer lugar na caverna


O que foi feito até agora:
- Implementação das classes e métodos
- Criação aleatória da caverna e inclusão dos itens do jogo (ainda apresenta falhas)
