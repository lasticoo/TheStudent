package com.T1CO.thestudent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText;
    private EditText passwordEditText;
    private String fadil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        emailEditText = findViewById(R.id.email);
        passwordEditText = findViewById(R.id.passwordlogin); // Pastikan ID ini sesuai

        // Ambil email dan username dari intent
        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String username = intent.getStringExtra("username"); // Ambil username
        if (email != null) {
            emailEditText.setText(email); // Isi email ke EditText
        }

        // Inisialisasi tombol login
        ImageButton loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(v -> processLogin(username)); // Kirim username ke method
    }

    private void processLogin(String username) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // Validasi login (sederhana)
        if (!email.isEmpty() && !password.isEmpty()) {
            Intent intent = new Intent(LoginActivity.this, DashboardActivity.class);
            intent.putExtra("username", username); // Kirim username ke DashboardActivity
            startActivity(intent);
            finish(); // Tutup LoginActivity
        } else {
            Toast.makeText(this, "Harap masukkan email dan kata sandi", Toast.LENGTH_SHORT).show();
        }
    }
}