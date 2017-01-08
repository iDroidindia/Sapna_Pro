package sapna_pro.idi.sapna_pro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserListDbHelper extends SQLiteOpenHelper {
	
	
	//public static final String DATABASE_NAME = "Android.db";
	public static final int VERSION = 3;
	public static final String TABLE = "UserList_Latest";
	public static final String ID = "ID";
	public static final String USERNAME = "USERNAME";
	public static final String PASSWORD = "PASSWORD";
	public static final String NAME  = "NAME";
	public static final String CONTACT = "CONTACT";
	public static final String EMAIL_ID = "EMAIL_ID";
	
	public UserListDbHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, TABLE, null, VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		try {
			createTable();

		} catch (Exception e) {

		}
	}

	public void createTable() {
		// TODO Auto-generated method stub
		
		SQLiteDatabase sdb = this.getWritableDatabase();


		String sql = "CREATE TABLE IF NOT EXISTS "+ TABLE + " (" +ID+
				" INTEGER PRIMARY KEY AUTOINCREMENT, " + USERNAME
				+ " VARCHAR NOT NULL, " + PASSWORD+ " VARCHAR NOT NULL, " + NAME +" VARCHAR NOT NULL, " + CONTACT + " VARCHAR NOT NULL, " + EMAIL_ID + " VARCHAR NOT NULL );" ;
		
		System.out.println(sql);
		
		sdb.execSQL(sql);
		
		sdb.close();
		
	}
	
	public void insertData(String username,String password,String name,String contact,String email_id){

		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues values = new ContentValues();

		values.put(USERNAME, username);

		values.put(PASSWORD, password);
		values.put(NAME,name);

		values.put(CONTACT,contact);
		values.put(EMAIL_ID,email_id);
		db.insert(TABLE, null, values);
		System.out.println("Submitted...");
		Log.i("password", password);

		db.close();
	}

	public String getData_for_username(String us, String pass)
	{
        String res = "no data";
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor data = db.rawQuery("SELECT USERNAME From "+TABLE+" WHERE USERNAME = '"+us+"' AND PASSWORD = '"+pass+"';", null);

		if (data.moveToFirst()) {
			while(!data.isAfterLast()){

				System.out.println(data.getString(data.getColumnIndex(USERNAME)));
				res = data.getString(data.getColumnIndex(USERNAME));
				data.moveToNext();
			}

		}

		if (data != null && !data.isClosed()) {
			data.close();
		}
        return res;


	}
	
	public void getData(){

		SQLiteDatabase db = this.getReadableDatabase();

		Cursor allData = query(db, "SELECT * From "+TABLE);

		
		if (allData.moveToFirst()) {
			while(!allData.isAfterLast()){
				
				System.out.println(allData.getString(allData.getColumnIndex(USERNAME)));
				System.out.println(allData.getString(allData.getColumnIndex(PASSWORD)));





				allData.moveToNext();
			}
			
		}
		
		if (allData != null && !allData.isClosed()) {
			allData.close();
		}
		System.out.println("Data Fetched...");
		
	}
	
	public Cursor query(SQLiteDatabase db, String query) {

		Cursor cursor = db.rawQuery(query, null);
		System.out.println("Executing Query: " + query);
		return cursor;

	}
	
	public void updateData(String username,String newPassword) {

		SQLiteDatabase db = this.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(PASSWORD,newPassword);
		
		
		System.out.println("Hello "+username);
		
		db.update(TABLE, values, USERNAME+"='"+username+"'", null);
		
		System.out.println("Updated the record with ...."+newPassword);
		
//**		db.update(TABLE, values, Qid + "='" + value.getQid() + "'" + " and "
//	**			+ Surveyid + "='" + value.getSurveyid() + "'", null);

	}

	public void delete(String username){

		SQLiteDatabase dp =this.getWritableDatabase();

		dp.delete(TABLE,USERNAME+ "=" + username,null);


	}








	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}
