import java.util.Scanner;

public class Main {
    public static void clearScreen() {
        for(int i = 0; i < 30*300; i++){
            System.out.print("\n");
        }
        System.out.println("\n" +
                " .d8888b.                                                                 888               8888888b.                  888                               888 \n" +
                "d88P  Y88b                                                                888               888   Y88b                 888                               888 \n" +
                "888    888                                                                888               888    888                 888                               888 \n" +
                "888         .d88b.  888  888  .d88b.  888d888 88888b.   .d88b.        .d88888  .d88b.       888   d88P .d88b.  888d888 888888 888  888  .d88b.   8888b.  888 \n" +
                "888  88888 d88\"\"88b 888  888 d8P  Y8b 888P\"   888 \"88b d88\"\"88b      d88\" 888 d8P  Y8b      8888888P\" d88\"\"88b 888P\"   888    888  888 d88P\"88b     \"88b 888 \n" +
                "888    888 888  888 Y88  88P 88888888 888     888  888 888  888      888  888 88888888      888       888  888 888     888    888  888 888  888 .d888888 888 \n" +
                "Y88b  d88P Y88..88P  Y8bd8P  Y8b.     888     888  888 Y88..88P      Y88b 888 Y8b.          888       Y88..88P 888     Y88b.  Y88b 888 Y88b 888 888  888 888 \n" +
                " \"Y8888P88  \"Y88P\"    Y88P    \"Y8888  888     888  888  \"Y88P\"        \"Y88888  \"Y8888       888        \"Y88P\"  888      \"Y888  \"Y88888  \"Y88888 \"Y888888 888 \n" +
                "                                                                                                                                            888              \n" +
                "                                                                                                                                       Y8b d88P              \n" +
                "                                                                                                                                        \"Y88P\"               \n");
    }
    public static String initialMenu(Scanner scanner) {
        clearScreen();
        System.out.print("1- Adicionar Cidadao\n2- Lista de Cidadaos\n3- Apagar Cidadão\n4- Fechar programa\nEscolha uma opçao: ");
        return scanner.nextLine();
    }

    public static PortugueseCitizen addCitizenMenu(Scanner scanner) {
        clearScreen();
        String citizenName = new String();
        String citizenAge = new String();
        System.out.print("Nome: ");
        citizenName = scanner.nextLine();
        System.out.print("Idade: ");
        citizenAge = scanner.nextLine();
        PortugueseCitizen citizen = new PortugueseCitizen(citizenName, citizenAge);
        citizen.setVatNumber();
        citizen.setCiNumber();
        return citizen;
    }

    public static void printCitizens(PortugueseCitizen[] citizens, Scanner scanner) {
        clearScreen();
        String menuOption = new String();
        if (citizens[0] == null) {
            System.out.println("A lista está vazia, por favor retorne ao menu e adicione um cidadão!\n");
        }
        for(int index = 0; index < citizens.length && citizens[index] != null; index++) {
            System.out.println((index + 1) + "-" + " " + "Nome: " + citizens[index].name + "\t" + "Idade: "
                    + citizens[index].age + "\t" + "NIF: " + citizens[index].getVatNumber() + "\t" + "NIC: " + citizens[index].getCiNumber() + "\n");
        }
        System.out.print("Clique 0 para voltar ao menu: ");
        menuOption = scanner.nextLine();
        if (menuOption.equals("0")) {
            return;
        }
    }

    public static PortugueseCitizen[] deleteFromArray(PortugueseCitizen[] citizens, Integer index) {
        PortugueseCitizen[] arrayDeleted = null;

        for(int i = 0; i < citizens.length; i++) {
            if (i == index) {
                continue;
            }
            arrayDeleted[i] = citizens[i];
        }

        return arrayDeleted;
    }

    public static PortugueseCitizen[] deleteCitizen(PortugueseCitizen[] citizens, Scanner scanner) {
        clearScreen();
        String menuOption = new String();
        if (citizens[0] == null) {
            System.out.println("A lista está vazia, por favor retorne ao menu e adicione um cidadão!\n");
        }
        for(int index = 0; index < citizens.length && citizens[index] != null; index++) {
            System.out.println((index + 1) + "-" + " " + "Nome: " + citizens[index].name + "\t" + "Idade: "
                    + citizens[index].age + "\t" + "NIF: " + citizens[index].getVatNumber() + "\t" + "NIC: " + citizens[index].getCiNumber() + "\n");
        }
        System.out.print("Clique 0 para voltar ao menu: ");
        menuOption = scanner.nextLine();
        System.out.print("Insira o número do cidadão que pretende apagar: ");
        String indexToDelete = scanner.nextLine();
        Integer index = Integer.parseInt(indexToDelete);
        citizens = deleteFromArray(citizens, index);
        return citizens;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String menuOption = new String();
        menuOption = initialMenu(scanner);
        PortugueseCitizen[] citizens = new PortugueseCitizen[1000];
        int citizenIndex = 0;

        while(!menuOption.equals("3")) {
            clearScreen();
            if(menuOption.equals("1")) {
                citizens[citizenIndex] = addCitizenMenu(scanner);
                citizenIndex++;
                menuOption = initialMenu(scanner);
                continue;
            }
            else if(menuOption.equals("2")) {
                printCitizens(citizens, scanner);
                menuOption = initialMenu(scanner);
                continue;
            }
            else if(menuOption.equals("3")) {
                deleteCitizen(citizens, scanner);
                menuOption = initialMenu(scanner);
                continue;
            }
            else {
                initialMenu(scanner);
                continue;
            }
        }
        clearScreen();
        return;
    }
}
