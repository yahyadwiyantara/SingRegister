package id.sch.smktelkom_mlg.tugas01.xiirpl3020.singregister;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText namapenyanyi;
    RadioGroup jenisSuara;
    RadioButton JenisKelamin, JenisKelamin2;
    CheckBox checkBoxStatus, checkBoxStatus2, checkBoxStatus3;
    Spinner spinner;
    Button button;
    TextView nama, jeniskelamin, posisi, jenissuara;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        namapenyanyi = (EditText) findViewById(R.id.editTextNama);
        JenisKelamin = (RadioButton) findViewById(R.id.radioButtonJenisKelamin);
        JenisKelamin2 = (RadioButton) findViewById(R.id.radioButtonJenisKelamin2);
        jenisSuara = (RadioGroup) findViewById(R.id.gender);
        checkBoxStatus = (CheckBox) findViewById(R.id.checkBoxStatus);
        checkBoxStatus2 = (CheckBox) findViewById(R.id.checkBoxStatus2);
        checkBoxStatus3 = (CheckBox) findViewById(R.id.checkBoxStatus3);
        button = (Button) findViewById(R.id.button);
        spinner = (Spinner) findViewById(R.id.spinnerSuara);
        nama = (TextView) findViewById(R.id.textViewNama);
        jeniskelamin = (TextView) findViewById(R.id.textViewJenisKelamin);
        posisi = (TextView) findViewById(R.id.textViewPosisi);
        jenissuara = (TextView) findViewById(R.id.textViewJenisSuara);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                doProcess();
            }
        });


    }

    private void doProcess() {
        if (isValid()) {
            String penyanyi = namapenyanyi.getText().toString();
            nama.setText("Nama Anda: " + penyanyi);
            jenissuara.setText("Jenis Suara Anda : " + spinner.getSelectedItem().toString());
        }
    }

    private boolean isValid() {
        boolean valid = true;

        String nama = namapenyanyi.getText().toString();
        String hasil = null;
        String centang = "Posisi Anda:\n";
        int startlen = centang.length();

        if (nama.isEmpty()) {
            namapenyanyi.setError("Nama belum diisi");
            valid = false;
        } else if (nama.length() < 3) {
            namapenyanyi.setError("Nama minimal 3 karakter");
            valid = false;
        }
        if (JenisKelamin.isChecked()) {
            hasil = JenisKelamin.getText().toString();
        } else if (JenisKelamin2.isChecked()) {
            hasil = JenisKelamin2.getText().toString();
        }

        if (hasil == null) {
            jeniskelamin.setText("Belum memilih Jenis Kelamin");
        } else {
            jeniskelamin.setText("Jenis kelamin: " + hasil);
        }
        if (checkBoxStatus.isChecked()) centang += checkBoxStatus.getText() + "\n";
        if (checkBoxStatus2.isChecked()) centang += checkBoxStatus2.getText() + "\n";
        if (checkBoxStatus3.isChecked()) centang += checkBoxStatus3.getText() + "\n";

        if (centang.length() == startlen) centang += "Tidak Ada Pada Pilihan";

        posisi.setText(centang);


        return valid;
    }
}
