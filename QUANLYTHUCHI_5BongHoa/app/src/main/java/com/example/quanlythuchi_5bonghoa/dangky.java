package com.example.quanlythuchi_5bonghoa;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class dangky extends AppCompatActivity {

    private TextInputLayout tilFullName, tilUsername, tilEmail, tilPassword, tilConfirm;
    private TextInputEditText edtFullName, edtUsername, edtEmail, edtPassword, edtConfirm;
    private MaterialButton btnSignUp;
    private TextView tvAlreadyHave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dangky);

        tilFullName = findViewById(R.id.tilFullName);
        tilUsername = findViewById(R.id.tilUsername);
        tilEmail = findViewById(R.id.tilEmail);
        tilPassword = findViewById(R.id.tilPassword);
        tilConfirm = findViewById(R.id.tilConfirmPassword);

        edtFullName = findViewById(R.id.edtFullName);
        edtUsername = findViewById(R.id.edtUsername);
        edtEmail = findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);
        edtConfirm = findViewById(R.id.edtConfirmPassword);

        btnSignUp = findViewById(R.id.btnSignUp);
        tvAlreadyHave = findViewById(R.id.tvAlreadyHave);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleRegister();
            }
        });

        tvAlreadyHave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(dangky.this, dangnhap.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void handleRegister() {
        tilFullName.setError(null);
        tilUsername.setError(null);
        tilEmail.setError(null);
        tilPassword.setError(null);
        tilConfirm.setError(null);

        String fullName = edtFullName.getText() != null ? edtFullName.getText().toString().trim() : "";
        String username = edtUsername.getText() != null ? edtUsername.getText().toString().trim() : "";
        String email = edtEmail.getText() != null ? edtEmail.getText().toString().trim() : "";
        String password = edtPassword.getText() != null ? edtPassword.getText().toString().trim() : "";
        String confirm = edtConfirm.getText() != null ? edtConfirm.getText().toString().trim() : "";

        boolean valid = true;

        if (TextUtils.isEmpty(fullName)) {
            tilFullName.setError("Vui lòng nhập họ tên");
            valid = false;
        }

        if (TextUtils.isEmpty(username)) {
            tilUsername.setError("Vui lòng nhập username");
            valid = false;
        }

        if (TextUtils.isEmpty(email) || !email.contains("@")) {
            tilEmail.setError("Email không hợp lệ");
            valid = false;
        }

        if (TextUtils.isEmpty(password)) {
            tilPassword.setError("Nhập mật khẩu");
            valid = false;
        }

        if (!password.equals(confirm)) {
            tilConfirm.setError("Mật khẩu không khớp");
            valid = false;
        }

        if (!valid) return;

        Toast.makeText(this, "Đăng ký thành công!", Toast.LENGTH_SHORT).show();

        startActivity(new Intent(dangky.this, dangnhap.class));
        finish();
    }
}
