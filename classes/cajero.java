package classes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class cajero {

    // Clase BankAccount
    class BankAccount {
        private BigDecimal balance;
        private String accountNumber;

        public BankAccount(String accountNumber, double balance) {
            this.accountNumber = accountNumber;
            this.balance = BigDecimal.valueOf(balance);
        }

        public String getAccountNumber() {
            return accountNumber;
        }

        public BigDecimal getBalance() {
            return balance;
        }

        public void setBalance(BigDecimal balance) {
            this.balance = balance.setScale(3, RoundingMode.HALF_UP);
            System.out.println("Nuevo balance: " + this.balance + "\n");
        }
    }

    // Clase Customer
    class Customer {
        private String name;
        private String dni;

        public Customer(String name, String dni) {
            this.name = name;
            this.dni = dni;
        }

        public String getName() {
            return name;
        }

        public String getDni() {
            return dni;
        }
    }

    // Clase CajeroOperaciones
    class CajeroOperaciones {

        public void getUserOption(Customer customer, BankAccount bankAccount, Scanner scanner) {
            while (true) {
                mostrarMenu();
                int option = scanner.nextInt();

                switch (option) {
                    case 1 -> retirarDinero(bankAccount, scanner);
                    case 2 -> mostrarCuenta(customer, bankAccount);
                    case 3 -> {
                        System.out.println("Tenga un buen día.");
                        return;  // Salir del método en lugar de usar System.exit(0)
                    }
                    default -> System.out.println("Escoja una opción válida \n");
                }
            }
        }

        private void mostrarMenu() {
            System.out.println("Escoja la acción que desea realizar: ");
            System.out.println("1. Retirar");
            System.out.println("2. Ver cuenta");
            System.out.println("3. Salir");
        }

        private void retirarDinero(BankAccount bankAccount, Scanner scanner) {
            System.out.println("Inserte un monto a retirar");
            double dineroRetirar = scanner.nextDouble();

            BigDecimal balance = bankAccount.getBalance();
            BigDecimal montoARetirar = BigDecimal.valueOf(dineroRetirar);

            if (balance.compareTo(montoARetirar) >= 0) {
                bankAccount.setBalance(balance.subtract(montoARetirar));
            } else {
                System.out.println("Saldo insuficiente.\n");
            }
        }

        private void mostrarCuenta(Customer customer, BankAccount bankAccount) {
            System.out.println("Usuario: " + customer.getName() + ", DNI: " + customer.getDni());
            System.out.println("Número de cuenta: " + bankAccount.getAccountNumber() + ", Balance: $" + bankAccount.getBalance() + "\n");
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            cajero cajero = new cajero();

            BankAccount account = cajero.new BankAccount("1242", 321.1);
            Customer customer = cajero.new Customer("Miguel", "32134");
            CajeroOperaciones operaciones = cajero.new CajeroOperaciones();

            operaciones.getUserOption(customer, account, scanner);
        }
    }
}
