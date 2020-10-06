package com.example.srilankavehicleinfo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetails extends AppCompatActivity {

    private TextView view1;
    private TextView view2;
    private Button warning;
    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_details);

        view1 = (TextView) findViewById(R.id.web1);
        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openWebViewOne();
                showWarningDialog();
            }
        });

        view2 = (TextView) findViewById(R.id.web2);
        view2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                openWebViewTwo();
                showWarningDialog2();
            }
        });

        ok = (Button)findViewById(R.id.btnok);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent newIntent = new Intent(ShowDetails.this, SubmitNumber.class);
                startActivity(newIntent);
            }
        });


//        findViewById(R.id.web1).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });


    }

    private void showWarningDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ShowDetails.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(ShowDetails.this).inflate(R.layout.disclaimer_popup, (ConstraintLayout) findViewById(R.id.layoutDialogContainer));
        builder.setView(view);

        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.warning_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.warning_text));
        ((Button) view.findViewById(R.id.buttonwarning)).setText(getResources().getString(R.string.okey));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.warning);

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonwarning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebViewOne();
//                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    private void showWarningDialog2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(ShowDetails.this, R.style.AlertDialogTheme);
        View view = LayoutInflater.from(ShowDetails.this).inflate(R.layout.disclaimer_popup, (ConstraintLayout) findViewById(R.id.layoutDialogContainer));
        builder.setView(view);

        ((TextView) view.findViewById(R.id.textTitle)).setText(getResources().getString(R.string.warning_title));
        ((TextView) view.findViewById(R.id.textMessage)).setText(getResources().getString(R.string.warning_text));
        ((Button) view.findViewById(R.id.buttonwarning)).setText(getResources().getString(R.string.okey));
        ((ImageView) view.findViewById(R.id.imageIcon)).setImageResource(R.drawable.warning);

        final AlertDialog alertDialog = builder.create();

        view.findViewById(R.id.buttonwarning).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWebViewTwo();
//                alertDialog.dismiss();
            }
        });

        if (alertDialog.getWindow() != null) {
            alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
        alertDialog.show();
    }

    public void openWebViewOne() {
        Intent viewOne = new Intent(this, InfoViewOne.class);
        startActivity(viewOne);
    }

    public void openWebViewTwo() {
        Intent viewTwo = new Intent(this, InfoViewTwo.class);
        startActivity(viewTwo);
    }
}