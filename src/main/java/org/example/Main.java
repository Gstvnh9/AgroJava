package org.example;

import java.util.Scanner;
import java.util.Locale;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

public class Main {
    static void main() {

        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner entrada = new Scanner (System.in);
        entrada.useLocale(Locale.US);

        int opcao = 0;
        double mediaPluviosidade = 0;
        double maiorIndice = 0;
        double[] chuva = new double[7];
        int[][] fazenda = new int[4][4];
        int alertasQuantidade = 0;

        do {

            System.out.println("========== MENU INTERATIVO ==========");
            System.out.println("1 - Cadastrar Dados");
            System.out.println("2 - Exibir Mapa do Campo");
            System.out.println("3 - Relatório de Alertas de Irrigação");
            System.out.println("4 - Sair");
            System.out.println("=====================================");
            opcao = entrada.nextInt();

            while (opcao > 4) {

                System.out.println("Insira uma opção válida, por favor!");
                opcao = entrada.nextInt();

            }

            if (opcao == 1) {

                System.out.println("Primeiro, você irá cadastrar o volume de chuva diário:");
                System.out.println("Pressione enter para começar...");
                entrada.nextLine();
                entrada.nextLine();

                System.out.println("Indique o volume de chuva registrado no domingo: ");
                chuva[0] = entrada.nextDouble();

                System.out.println("Indique o volume de chuva registrado na segunda-feira: ");
                chuva[1] = entrada.nextDouble();

                System.out.println("Indique o volume de chuva registrado na terça-feira: ");
                chuva[2] = entrada.nextDouble();

                System.out.println("Indique o volume de chuva registrado na quarta-feira: ");
                chuva[3] = entrada.nextDouble();

                System.out.println("Indique o volume de chuva registrado na quinta-feira: ");
                chuva[4] = entrada.nextDouble();

                System.out.println("Indique o volume de chuva registrado na sexta-feira: ");
                chuva[5] = entrada.nextDouble();

                System.out.println("Indique o volume de chuva registrado no sábado: ");
                chuva[6] = entrada.nextDouble();

                System.out.println("Pressione enter para cadastrar os próximos dados...");
                entrada.nextLine();
                entrada.nextLine();

                System.out.println("Agora, você irá cadastrar a porcentagem de umidade de alguns talhões:");
                System.out.println("Pressione enter para começar...");
                entrada.nextLine();

                System.out.println("Informe a porcentagem do primeiro talhão, da primeira região: ");
                fazenda[0][0] = entrada.nextInt();

                System.out.println("Informe a porcentagem do segundo talhão, da primeira região: ");
                fazenda[0][1] = entrada.nextInt();

                System.out.println("Informe a porcentagem do terceiro talhão, da primeira região: ");
                fazenda[0][2] = entrada.nextInt();

                System.out.println("Informe a porcentagem do quarto talhão, da primeira região: ");
                fazenda[0][3] = entrada.nextInt();

                System.out.println("Informe a porcentagem do primeiro talhão, da segunda região: ");
                fazenda[1][0] = entrada.nextInt();

                System.out.println("Informe a porcentagem do segundo talhão, da segunda região: ");
                fazenda[1][1] = entrada.nextInt();

                System.out.println("Informe a porcentagem do terceiro talhão, da segunda região: ");
                fazenda[1][2] = entrada.nextInt();

                System.out.println("Informe a porcentagem do quarto talhão, da segunda região: ");
                fazenda[1][3] = entrada.nextInt();

                System.out.println("Informe a porcentagem do primeiro talhão, da terceira região: ");
                fazenda[2][0] = entrada.nextInt();

                System.out.println("Informe a porcentagem do segundo talhão, da terceira região: ");
                fazenda[2][1] = entrada.nextInt();

                System.out.println("Informe a porcentagem do terceira talhão, da terceira região: ");
                fazenda[2][2] = entrada.nextInt();

                System.out.println("Informe a porcentagem do quarto talhão, da terceira região: ");
                fazenda[2][3] = entrada.nextInt();

                System.out.println("Informe a porcentagem do primeiro talhão, da quarta região: ");
                fazenda[3][0] = entrada.nextInt();

                System.out.println("Informe a porcentagem do segundo talhão, da quarta região: ");
                fazenda[3][1] = entrada.nextInt();

                System.out.println("Informe a porcentagem do terceiro talhão, da quarta região: ");
                fazenda[3][2] = entrada.nextInt();

                System.out.println("Informe a porcentagem do quarto talhão, da quarta região: ");
                fazenda[3][3] = entrada.nextInt();

                System.out.println("Pressione enter para voltar ao menu inicial...");
                entrada.nextLine();
                entrada.nextLine();


            } else if (opcao == 2) {

                for (int i = 0; i < chuva.length; i++) {

                    mediaPluviosidade += chuva[i];

                    if (maiorIndice == 0) {

                        maiorIndice = chuva[i];

                    } else if (maiorIndice < chuva[i]) {

                        maiorIndice = chuva[i];

                    }

                }

                mediaPluviosidade /= 7;

                System.out.println("===================================== RELATÓRIO GERAL ====================================");
                System.out.println("Média de Pluviosidade Semanal: " + mediaPluviosidade + " mm");
                System.out.println("Maior Indice: " + maiorIndice + " mm");
                System.out.println("==========================================================================================");

                System.out.println("====================================== MAPA DO CAMPO =====================================");

                for (int i = 0; i < 4; i++) {

                    for (int j = 0; j < 4; j++) {

                        System.out.println("==================================================================================");
                        System.out.println("Umidade na região [" + (i + 1) + "], do talão [" + (j + 1) + "]: " + fazenda[i][j]);

                        if (fazenda[i][j] < 30) {

                            System.out.println("É necessária uma melhor irrigação!");
                            alertasQuantidade++;

                        }

                        System.out.println("==================================================================================");

                    }

                }

                System.out.println("Pressione enter para voltar ao menu inicial...");
                entrada.nextLine();
                entrada.nextLine();

            } else if (opcao == 3) {

                System.out.println("Foram registrados " + alertasQuantidade + " alertas de irrigação!");

                System.out.println("Pressione enter para voltar ao menu inicial...");
                entrada.nextLine();
                entrada.nextLine();

            }

        } while (opcao == 1 || opcao == 2 || opcao == 3);

        if (opcao == 4) {

            System.out.println("Obrigado por usar nosso sistema.");
            System.out.println("Até logo!");

        }
    }
}
