package punit;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class depate {
    int emp_id;
    String first_name, last_name, job_title, email;
    double salary;
    int department;

    public depate(int id, String fName, String lName, String job, double salary, int dept, String email) {
        this.emp_id = id;
        this.first_name = fName;
        this.last_name = lName;
        this.job_title = job;
        this.salary = salary;
        this.department = dept;
        this.email = email;
    }

    @Override
    public String toString() {
        return emp_id + " - " + first_name + " " + last_name + " (" + job_title + ")";
    }
}

public class EmpDeptAWT extends Frame implements ActionListener {
    private static final long serialVersionUID = 1L;
    private static ArrayList<Employee> employees = new ArrayList<>();

    Label lblTitle, lblEmpId, lblFirstName, lblLastName, lblJob, lblSalary, lblDept, lblEmail;
    TextField txtEmpId, txtFirstName, txtLastName, txtJob, txtSalary, txtDept, txtEmail;
    Button btnAdd, btnSearch, btnDelete, btnView, btnExit;
    TextArea txtArea;

    public EmpDeptAWT() {
        setLayout(null);
        setTitle("Employee Management System");
        setSize(500, 600);
        setVisible(true);

        lblTitle = new Label("Employee Management System", Label.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 16));
        lblTitle.setBounds(50, 40, 400, 30);
        add(lblTitle);

        lblEmpId = new Label("Emp ID:");
        lblEmpId.setBounds(50, 80, 100, 30);
        add(lblEmpId);
        txtEmpId = new TextField();
        txtEmpId.setBounds(180, 80, 200, 30);
        add(txtEmpId);

        lblFirstName = new Label("First Name:");
        lblFirstName.setBounds(50, 120, 100, 30);
        add(lblFirstName);
        txtFirstName = new TextField();
        txtFirstName.setBounds(180, 120, 200, 30);
        add(txtFirstName);

        lblLastName = new Label("Last Name:");
        lblLastName.setBounds(50, 160, 100, 30);
        add(lblLastName);
        txtLastName = new TextField();
        txtLastName.setBounds(180, 160, 200, 30);
        add(txtLastName);

        lblJob = new Label("Job Title:");
        lblJob.setBounds(50, 200, 100, 30);
        add(lblJob);
        txtJob = new TextField();
        txtJob.setBounds(180, 200, 200, 30);
        add(txtJob);

        lblSalary = new Label("Salary:");
        lblSalary.setBounds(50, 240, 100, 30);
        add(lblSalary);
        txtSalary = new TextField();
        txtSalary.setBounds(180, 240, 200, 30);
        add(txtSalary);

        lblDept = new Label("Department:");
        lblDept.setBounds(50, 280, 100, 30);
        add(lblDept);
        txtDept = new TextField();
        txtDept.setBounds(180, 280, 200, 30);
        add(txtDept);

        lblEmail = new Label("Email:");
        lblEmail.setBounds(50, 320, 100, 30);
        add(lblEmail);
        txtEmail = new TextField();
        txtEmail.setBounds(180, 320, 200, 30);
        add(txtEmail);

        btnAdd = new Button("Add Employee");
        btnAdd.setBounds(50, 360, 120, 30);
        add(btnAdd);
        btnAdd.addActionListener(this);

        btnSearch = new Button("Search Employee");
        btnSearch.setBounds(180, 360, 120, 30);
        add(btnSearch);
        btnSearch.addActionListener(this);

        btnDelete = new Button("Delete Employee");
        btnDelete.setBounds(310, 360, 120, 30);
        add(btnDelete);
        btnDelete.addActionListener(this);

        btnView = new Button("View Employees");
        btnView.setBounds(100, 400, 120, 30);
        add(btnView);
        btnView.addActionListener(this);

        btnExit = new Button("Exit");
        btnExit.setBounds(240, 400, 120, 30);
        add(btnExit);
        btnExit.addActionListener(this);

        txtArea = new TextArea();
        txtArea.setBounds(50, 440, 400, 100);
        add(txtArea);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            addEmployee();
        } else if (e.getSource() == btnSearch) {
            searchEmployee();
        } else if (e.getSource() == btnDelete) {
            deleteEmployee();
        } else if (e.getSource() == btnView) {
            viewEmployees();
        } else if (e.getSource() == btnExit) {
            System.exit(0);
        }
    }

    private void addEmployee() {
        try {
            int id = Integer.parseInt(txtEmpId.getText().trim());
            String fName = txtFirstName.getText().trim();
            String lName = txtLastName.getText().trim();
            String job = txtJob.getText().trim();
            double salary = Double.parseDouble(txtSalary.getText().trim());
            int dept = Integer.parseInt(txtDept.getText().trim());
            String email = txtEmail.getText().trim();

            employees.add(new Employee(id, fName, lName, job, salary, dept, email));
            txtArea.setText("Employee added successfully!");

        } catch (NumberFormatException ex) {
            txtArea.setText("Error: Please enter valid numbers for ID, Salary, and Department.");
        }
    }

    private void searchEmployee() {
        try {
            int id = Integer.parseInt(txtEmpId.getText().trim());
            for (Employee emp : employees) {
                if (emp.emp_id == id) {
                    txtArea.setText("Found Employee:\nID: " + emp.emp_id + "\nName: " + emp.first_name + " " + emp.last_name + "\nJob: " + emp.job_title + "\nSalary: " + emp.salary + "\nDept: " + emp.department + "\nEmail: " + emp.email);
                    return;
                }
            }
            txtArea.setText("Employee Not Found!");

        } catch (NumberFormatException ex) {
            txtArea.setText("Error: Enter a valid Employee ID.");
        }
    }

    private void deleteEmployee() {
        try {
            int id = Integer.parseInt(txtEmpId.getText().trim());
            employees.removeIf(emp -> emp.emp_id == id);
            txtArea.setText("Employee deleted successfully!");

        } catch (NumberFormatException ex) {
            txtArea.setText("Error: Enter a valid Employee ID.");
        }
    }

    private void viewEmployees() {
        if (employees.isEmpty()) {
            txtArea.setText("No employees available.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Employee emp : employees) {
                sb.append(emp).append("\n");
            }
            txtArea.setText(sb.toString());
        }
    }

    public static void main(String[] args) {
        new EmpDeptAWT();
    }
}

