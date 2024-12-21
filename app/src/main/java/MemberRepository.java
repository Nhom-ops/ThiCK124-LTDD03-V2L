import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;




public class MemberRepository {

    private SQLiteDatabase db;
    private DatabaseHelper dbHelper;

    public MemberRepository(Context context) {
        dbHelper = new DatabaseHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // Thêm thành viên mới
    public long addMember(String name, String email, String phone, String imageUrl) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("phone", phone);
        values.put("image_url", imageUrl);
        return db.insert("members", null, values);
    }

    // Lấy tất cả thành viên
    public Cursor getAllMembers() {
        return db.rawQuery("SELECT * FROM members", null);
    }

    // Cập nhật thông tin thành viên
    public int updateMember(int id, String name, String email, String phone, String imageUrl) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("phone", phone);
        values.put("image_url", imageUrl);
        return db.update("members", values, "id = ?", new String[]{String.valueOf(id)});
    }

    // Xóa thành viên
    public int deleteMember(int id) {
        return db.delete("members", "id = ?", new String[]{String.valueOf(id)});
    }

    // Đảm bảo đóng cơ sở dữ liệu
    public void close() {
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    // Đảm bảo đóng cursor khi không sử dụng nữa
    public void closeCursor(Cursor cursor) {
        if (cursor != null && !cursor.isClosed()) {
            cursor.close();
        }
    }
}
