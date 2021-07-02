package com.example.day2project;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DialogActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button b1, b2, b3, b4;
    int selectedMenu = 0;
    String[] menu = {"치킨", "피자", "스파게티"};
    boolean[] checked = {true, true, false};  //기본값 설정


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog2);
        init();
    }

    private void init(){
        b1 = findViewById(R.id.button1);
        b2 = findViewById(R.id.button2);
        b3 = findViewById(R.id.button3);
        b4 = findViewById(R.id.button4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button1){
            displayDialog();
        }else if(v.getId() == R.id.button2){
            displayDialog2();
        }else if(v.getId() == R.id.button3){
            displayDialog3();
        } else if(v.getId() == R.id.button4){
            displayDialog4();
        }

}

    private void displayDialog4() {
        View view = View.inflate(this, R.layout.dialog, null);
        EditText et1 = view.findViewById(R.id.etmessage);

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("사용자 정의 대화 상자");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setView(view);
        dlg.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast("입력한 메세지 : " + et1.getText().toString() + "가 선택되었습니다!");
            }
        });
        dlg.setPositiveButton("CANCEL", null);
        dlg.show();
    }

    private void displayDialog3() {

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("첵박 대화 상자");
        dlg.setMultiChoiceItems(menu, checked, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                checked[which] = isChecked;
            }
        });
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String list = "";
                int i=0;
                for(i=0; i<checked.length; i++) {
                    if(checked[i])
                        list += menu[selectedMenu] + ", ";
                }
                displayToast(menu[selectedMenu] + "가 선택되었습니다!");
            }
        });
        dlg.setPositiveButton("CANCLE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast("취소 되었습니다!");
            }
        });
        dlg.show();

    }

    private void displayDialog2() {

        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setTitle("Radio 대화 상자");
        //메세지를 쓰면 안되어요. dlg.setMessage("대화상자 메세지입니다.");
        dlg.setSingleChoiceItems(menu, 1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selectedMenu= which;
            }
        });
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(menu[selectedMenu] + " 가 선택되었습니다!");
            }
        });
        dlg.show();

    }

    private void displayDialog() {
        AlertDialog.Builder dlg = new AlertDialog.Builder(this);
        dlg.setMessage("기본 대화 상자");
        dlg.setMessage("대화상자 메세지입니다.");
        dlg.setIcon(R.mipmap.ic_launcher);
        dlg.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                displayToast(null);
            }
        });
        dlg.show();
    }

    private void displayToast(String s) {
        if(s == null) Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
        Toast.makeText(this, s , Toast.LENGTH_SHORT).show();
    }
}