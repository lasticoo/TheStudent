package com.T1CO.thestudent;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class RegisterActivity extends AppCompatActivity {

    private EditText fullnameEditText;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private EditText emailEditText;
    private EditText birthdateEditText;
    private EditText addressEditText;
    private Spinner genderSpinner;
    private Spinner religionSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

        // Inisialisasi EditText dan Spinner
        fullnameEditText = findViewById(R.id.fullname);
        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        emailEditText = findViewById(R.id.email);
        birthdateEditText = findViewById(R.id.birthdate);
        addressEditText = findViewById(R.id.address);
        genderSpinner = findViewById(R.id.gender);
        religionSpinner = findViewById(R.id.religion);

        // Tambahkan listener untuk EditText tanggal lahir
        birthdateEditText.setOnClickListener(v -> showDatePickerDialog());

        // Inisialisasi tombol submit
        ImageButton submitButton = findViewById(R.id.submit_button);
        submitButton.setOnClickListener(v -> processRegistration());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void showDatePickerDialog() {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                (view, selectedYear, selectedMonth, selectedDay) -> {
                    selectedMonth += 1; // bulan dimulai dari 0
                    String date = selectedDay + "/" + selectedMonth + "/" + selectedYear;
                    birthdateEditText.setText(date);
                },
                year, month, day);
        datePickerDialog.show();
    }

    private void processRegistration() {
        // Mengambil data dari EditText dan Spinner
        String email = emailEditText.getText().toString();
        String username = usernameEditText.getText().toString(); // Ambil username

        // Menampilkan pesan registrasi berhasil
        Toast.makeText(this, "Registrasi berhasil", Toast.LENGTH_LONG).show();

        // Pindah ke LoginActivity dan mengirim email dan username
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        intent.putExtra("email", email);
        intent.putExtra("username", username); // Kirim username
        startActivity(intent);
        finish(); // Tutup activity ini
    }
}