package br.com.gleison.calcgleison;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int i = 0;
    int count = 0;
    float[] Result;
    float Total = 0;
    String operator;
    TextView RESULTSCREEN;
    static  int INVALID = 9999999;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Result = new float[2];
        RESULTSCREEN = (TextView) findViewById(R.id.RESULTSCREEN);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.buttonsoma: operator = "soma";
                proximoNumero();
                break;
            case R.id.buttonsub: operator = "sub";
                proximoNumero();
                break;
            case R.id.buttonmult: operator = "mult";
                proximoNumero();
                break;
            case R.id.buttondiv: operator = "div";
                proximoNumero();
                break;
            case R.id.buttonigual: calcular();
                count = 0;
                break;
            case R.id.buttonLimpar: limpar();
                break;
        }

        if(count<7) {

            switch (view.getId()) {
                case R.id.button0:
                    Result[i] = (Result[i] * 10);
                    count++;
                    break;
                case R.id.button1:
                    Result[i] = (Result[i] * 10) + 1;
                    count++;
                    break;
                case R.id.button2:
                    Result[i] = (Result[i] * 10) + 2;
                    count++;
                    break;
                case R.id.button3:
                    Result[i] = (Result[i] * 10) + 3;
                    count++;
                    break;
                case R.id.button4:
                    Result[i] = (Result[i] * 10) + 4;
                    count++;
                    break;
                case R.id.button5:
                    Result[i] = (Result[i] * 10) + 5;
                    count++;
                    break;
                case R.id.button6:
                    Result[i] = (Result[i] * 10) + 6;
                    count++;
                    break;
                case R.id.button7:
                    Result[i] = (Result[i] * 10) + 7;
                    count++;
                    break;
                case R.id.button8:
                    Result[i] = (Result[i] * 10) + 8;
                    count++;
                    break;
                case R.id.button9:
                    Result[i] = (Result[i] * 10) + 9;
                    count++;
                    break;
            }
        }

        changesResult();
        Total = 0;
    }

    private void calcular(){
        double value;
        switch (operator){
            case "soma": Total = (Result[0] + Result[1]); break;
            case "sub": Total = Result[0] - Result[1]; break;
            case "mult": Total = Result[0] * Result[1]; break;
            case "div": Total = Result[0] / Result[1]; break;
        }
        if (Total<INVALID) {
            Result[0] = Total;
            Result[1] = 0;
            i = 1;
        }
    }

    private void changesResult(){
        if (Total != 0 && Total<INVALID){
            String tela = String.valueOf(Total);
            RESULTSCREEN.setText(tela);
        }else if (Total>INVALID){
            String tela = "ERROR";
            RESULTSCREEN.setText(tela);
        } else {
            String tela = String.valueOf(Result[i]);
            RESULTSCREEN.setText(tela);
        }
    }

    private void limpar(){
        i = 0;
        Result[0] = 0;
        Result[1] = 0;
        Total = 0;
        count = 0;
    }

    private void proximoNumero(){
        count = 0;
        i = 1;
    }
}
