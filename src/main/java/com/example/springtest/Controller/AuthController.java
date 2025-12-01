package com.example.springtest.Controller;

import com.example.springtest.DTO.GetDetailsResponse;
import com.example.springtest.DTO.LoginRequest;
import com.example.springtest.DTO.RegisterRequest;
import com.example.springtest.DTO.UpdateRequest;
import com.example.springtest.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;
    @Autowired
    public  AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest registerRequest) {
        if(registerRequest.getNID().length() != 10){ return "Invalid NID"; }
        return authService.Register(registerRequest);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginDetail){
        return authService.Login(loginDetail);
    }

    @PostMapping("/update")
    public String update(@RequestBody UpdateRequest updateRequest){
        return authService.Update(updateRequest);
    }

    @GetMapping("/getDetails/{AID}")
    public GetDetailsResponse getDetails(@PathVariable String AID){
        return authService.getDetails(AID);
    }

    @GetMapping("/getAID/{NID}")
    public String getAID(@PathVariable String NID){
        return authService.getAID(NID);
    }

    @PostMapping("/test")
    public String test(){
        return "test";
    }
}
