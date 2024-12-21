package com.example.thick124_ltdd03_v2l;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MemberActivity extends AppCompatActivity {

    private TextView memberName, memberEmail, memberPhone;
    private ImageView memberImage;
    private Button buttonEdit, buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member);

        memberName = findViewById(R.id.memberName);
        memberEmail = findViewById(R.id.memberEmail);
        memberPhone = findViewById(R.id.memberPhone);
        memberImage = findViewById(R.id.memberImage);
        buttonEdit = findViewById(R.id.buttonEdit);
        buttonDelete = findViewById(R.id.buttonDelete);

        // Hiển thị thông tin mặc định (có thể thay đổi sau khi lấy từ cơ sở dữ liệu)
        memberName.setText("Tên thành viên: John Doe");
        memberEmail.setText("Email: johndoe@example.com");
        memberPhone.setText("Điện thoại: 0123456789");
        memberImage.setImageResource(R.drawable.ic_default_image);  // Thêm ảnh mặc định

        // Xử lý khi nhấn vào nút "Chỉnh sửa"
        buttonEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển sang màn hình chỉnh sửa thông tin thành viên
                Intent intent = new Intent(MemberActivity.this, EditMemberActivity.class);
                startActivity(intent);
            }
        });

        // Xử lý khi nhấn vào nút "Xóa"
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Xóa thông tin thành viên và quay lại màn hình chính
                // Xử lý xóa trong cơ sở dữ liệu ở đây
                finish(); // Quay lại MainActivity
            }
        });
    }
}