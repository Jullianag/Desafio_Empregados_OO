package application;

import entities.Address;
import entities.Department;
import entities.Employee;

import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do departamento: ");
        String nomeDepartamento = sc.nextLine();
        System.out.print("Dia do pagamento: ");
        int diaPagamento = sc.nextInt();
        System.out.print("Email: ");
        sc.nextLine();
        String email = sc.nextLine();
        System.out.print("Telefone: ");
        String telefone = sc.nextLine();
        Address address = new Address(email, telefone);

        Department department = new Department(nomeDepartamento, diaPagamento, address);

        System.out.print("Quantos funcionários tem o departamento? ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++) {
            System.out.printf("Dados do funcionário %d%n", i+1);
            System.out.print("Nome: ");
            sc.nextLine();
            String nome = sc.nextLine();
            System.out.print("Salário: ");
            double salario = sc.nextDouble();
            Employee employee = new Employee(nome, salario);
            department.addEmployee(employee);
        }

        System.out.println();
        System.out.println("FOLHA DE PAGAMENTO:");
        showReport(department);

        sc.close();
    }

    private static void showReport(Department dept) {
        System.out.printf("Departamento Vendas = R$ %.2f%n", dept.payroll());
        System.out.printf("Pagamento realizado no dia %d%n", dept.getPayDay());
        System.out.println("Funcionários:");
        for (Employee emp : dept.getEmployees()) {
            System.out.println(emp.getName());
        }
        System.out.printf("Para dúvidas favor entrar em contato: %s%n", dept.getAddress().getEmail());
    }
}
