package controller;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.LoginResponse;
import model.Employee;
import repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@CrossOrigin(origins = "http://localhost:5173") // if frontend runs on port 3000
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest loginRequest) {
        Employee employee = employeeRepository.findByEmail(loginRequest.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (employee.getPassword().equals(loginRequest.getPassword())) {
            return new LoginResponse("Login successful", employee.getRole());
        } else {
            throw new RuntimeException("Invalid password");
        }
    }
}
