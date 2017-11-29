package com.mapasgoogle.javi.calculator;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewBox;
    private Button buttonDel;
    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonAC;
    private Button buttonMM;
    private Button buttonPorc;
    private Button buttonDiv;
    private Button buttonPro;
    private Button buttonRes;
    private Button buttonSum;
    private Button buttonEqu;
    private Button buttonDec;

    private String num1 = null;
    private String num2 = null;
    private String stringResult = "0";
    private boolean nextMark = true;
    private boolean markNum2 = false;
    private String lastPressedKey = null;

    private Operation operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inicializo el objeto que llevara toda la operacion
        operation = new Operation(0, 0, null);

        textViewBox = (TextView) findViewById(R.id.tvBox);
        buttonDel = (Button) findViewById(R.id.btDel);
        buttonAC = (Button) findViewById(R.id.btAC);
        buttonMM = (Button) findViewById(R.id.btMM);
        buttonPorc = (Button) findViewById(R.id.btPorc);
        buttonDiv = (Button) findViewById(R.id.btDiv);
        buttonPro = (Button) findViewById(R.id.btPro);
        buttonRes = (Button) findViewById(R.id.btRes);
        buttonSum = (Button) findViewById(R.id.btSum);
        button0 = (Button) findViewById(R.id.bt0);
        button1 = (Button) findViewById(R.id.bt1);
        button2 = (Button) findViewById(R.id.bt2);
        button3 = (Button) findViewById(R.id.bt3);
        button4 = (Button) findViewById(R.id.bt4);
        button5 = (Button) findViewById(R.id.bt5);
        button6 = (Button) findViewById(R.id.bt6);
        button7 = (Button) findViewById(R.id.bt7);
        button8 = (Button) findViewById(R.id.bt8);
        button9 = (Button) findViewById(R.id.bt9);
        buttonDec = (Button) findViewById(R.id.btDec);
        buttonEqu = (Button) findViewById(R.id.btEqu);

        buttonAC.setOnClickListener(this);
        buttonDel.setOnClickListener(this);
        buttonMM.setOnClickListener(this);
        buttonPorc.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonPro.setOnClickListener(this);
        buttonRes.setOnClickListener(this);
        buttonSum.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonDec.setOnClickListener(this);
        buttonEqu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btAC:
                cleanAll();
                break;
            case R.id.btDel:
                cleanCharByChar();
                break;
            case R.id.btMM:
                changeSimbol();
                break;
            case R.id.btPorc:
                configureOperation("porc", buttonPorc);
                break;
            case R.id.bt7:
                writeNumberOperation("7");
                break;
            case R.id.bt8:
                writeNumberOperation("8");
                break;
            case R.id.bt9:
                writeNumberOperation("9");
                break;
            case R.id.bt6:
                writeNumberOperation("6");
                break;
            case R.id.bt5:
                writeNumberOperation("5");
                break;
            case R.id.bt4:
                writeNumberOperation("4");
                break;
            case R.id.bt3:
                writeNumberOperation("3");
                break;
            case R.id.bt2:
                writeNumberOperation("2");
                break;
            case R.id.bt1:
                writeNumberOperation("1");
                break;
            case R.id.bt0:
                writeNumberOperation("0");
                break;
            case R.id.btDec:
                if(stringResult.equals("")) stringResult = "0";
                writeNumberOperation(",");
                break;
            case R.id.btDiv:
                configureOperation("div", buttonDiv);
                break;
            case R.id.btPro:
                configureOperation("prod", buttonPro);
                break;
            case R.id.btRes:
                configureOperation("res", buttonRes);
                break;
            case R.id.btSum:
                configureOperation("sum", buttonSum);
                break;
            default:// Boton igual
                if(operation.getOperation1() != null){
                    checkOperation();
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    buttonDiv.setBackground(getDrawable(R.drawable.button_secundary_no_pressed));
                    buttonPorc.setBackground(getDrawable(R.drawable.button_secundary_no_pressed));
                    buttonPro.setBackground(getDrawable(R.drawable.button_secundary_no_pressed));
                    buttonRes.setBackground(getDrawable(R.drawable.button_secundary_no_pressed));
                    buttonSum.setBackground(getDrawable(R.drawable.button_secundary_no_pressed));
                }
                markNum2 = false;
                lastPressedKey = "=";
                break;
        }

        textViewBox.setText(stringResult);
    }

    /**
     * Establece la operacion segun el estado de la calculadora
     */
    private void configureOperation(String ope, Button button) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            button.setBackground(getDrawable(R.drawable.button_secundary_pressed));
        }
        if(lastPressedKey != ope) {
            if(lastPressedKey == "="){
                nextMark = false;
                markNum2 = true;
                operation.setOperation1(ope);
            }else {
                checkOperation();
                operation.setOperation1(ope);
                num2 = null;
                operation.setNumberTwo(0.0);
                lastPressedKey = ope;
            }
        }
    }

    /**
     * Realiza la operacion
     */
    private void checkOperation() {
        if(operation.getOperation1() != null && operation.getNumberTwo() != 0.0){
            // Realizo operacion
            switch (operation.getOperation1()){
                case "sum":
                    stringResult = String.valueOf(operation.operationSum(operation.getNumberOne(), operation.getNumberTwo()));
                    break;
                case "res":
                    stringResult = String.valueOf(operation.operationDeduct(operation.getNumberOne(), operation.getNumberTwo()));
                    break;
                case "prod":
                    stringResult = String.valueOf(operation.operationProduct(operation.getNumberOne(), operation.getNumberTwo()));
                    break;
                case "div":
                    stringResult = String.valueOf(operation.operationDivision(operation.getNumberOne(), operation.getNumberTwo()));
                    break;
                case "porc":
                    stringResult = String.valueOf(operation.operationPorcentage(operation.getNumberOne(), operation.getNumberTwo()));
                    break;
            }
            if(stringResult.substring(stringResult.length()-1, stringResult.length()).equals("0") &&
                    stringResult.substring(stringResult.length()-2, stringResult.length()-1).equals(".")){
                stringResult = stringResult.replace(".0", "");
            }
        }

        if(stringResult.indexOf(".") > -1 && stringResult.length() > 1) {
            deleteCeros();
        }

        num1 = stringResult;
        operation.setNumberOne(Double.parseDouble(num1));
        nextMark = false;
        markNum2 = true;

        if(lastPressedKey != null){
            markNum2 = false;
            if(!lastPressedKey.equals("=")){
                num2 = null;
            }
        }
    }

    /**
     * Elimina ceros que puede dar el double a partir de la coma
     */
    private void deleteCeros() {
        for(int i = stringResult.length()-1 ; i > stringResult.indexOf(".") ; i--){
            String n = String.valueOf(stringResult.charAt(i));
            if(n.equals("0")){
                stringResult = stringResult.substring(0, i);
                i--;
            }
        }
        if(stringResult.length() > 1 &&
                stringResult.substring(stringResult.length()-1, stringResult.length()).equals(".")){
            stringResult = stringResult.replace(".", "");
        }
    }

    /**
     * Borra caracter a caracter
     */
    private void cleanCharByChar() {

        if(stringResult.length() <= 1){
            stringResult = "";
        }else{
            stringResult = stringResult.substring(0, stringResult.length()-1);
        }
        if(stringResult.length() > 1 && stringResult.substring(stringResult.length()-1, stringResult.length()) == ","){
            stringResult = stringResult.replace(",", "");
        }

        if(!stringResult.equals("")){
            insertNumberOperation(Double.parseDouble(stringResult));
        }
        nextMark = true;
    }

    /**
     * Escribe la tecla pulsada
     * @param s
     */
    private void writeNumberOperation(String s) {

        if(stringResult.equals("0") && !s.equals(",") || !nextMark) stringResult = "";

        if(s.equals(",")){ // Si pulsamos la coma de decimal...
            if(stringResult.indexOf(".") > -1){ // Comprobamos que no hay una coma ya
                return;
            }else{ // Si no la hay, la ponemos y concatenamos un 0 para que no falle al insertar el dato en el objeto, ya que es un double
                if(markNum2){
                    if(operation.getNumberTwo() != 0.0) {
                        num2 = ".0";
                    }else{
                        num2 = "0.0";
                    }
                }else{
                    num1 = ".0";
                }
            }
        }else{ // Si pulsamos cualquier numero...
            if(markNum2){
                if(num2 != null && num2.indexOf(",") > -1){ // Comprobamos si hay coma de decimal, si la hay debemos borrar el 0 que le precede
                    num2 = num2.replace(".0", "");
                }else{
                    num2 = s;
                }
            }else{
                if(num1 != null && num1.indexOf(",") > -1){ // Comprobamos si hay coma de decimal, si la hay debemos borrar el 0 que le precede
                    num1 = num1.replace(".0", "");
                }else{
                    num1 = s;
                }
            }
        }

        if(markNum2){
            stringResult += num2;
            insertNumberOperation(Double.parseDouble(stringResult));
            if(s.equals(",")) stringResult = stringResult.substring(0, stringResult.length()-1);
        }else{
            stringResult += num1;
            insertNumberOperation(Double.parseDouble(stringResult));
            if(s.equals(",")) stringResult = stringResult.substring(0, stringResult.length()-1);
        }

        nextMark = true;
        lastPressedKey = null;
    }

    /**
     * Inserta el numero en el objeto Operation
     * @param num
     */
    private void insertNumberOperation(double num) {
        if(markNum2){
            operation.setNumberTwo(num);
        }else{
            operation.setNumberOne(num);
        }
    }

    /**
     * Pulsa el boton AC, se ponen todas las variables como al principio
     */
    private void cleanAll() {
        num1 = null;
        num2 = null;
        stringResult = "0";
        nextMark = true;
        markNum2 = false;
        lastPressedKey = null;
        operation.setNumberOne(0);
        operation.setNumberTwo(0);
        operation.setOperation1(null);
    }

    /**
     * Cambia el simbolo a negativo o positivo
     */
    private void changeSimbol() {

        if(stringResult.equals("0") || (markNum2 && num2 == null)) stringResult = "";
        // Compruebo que signo tiene el texto de la caja
        if(stringResult.length() >= 1 && stringResult.substring(0, 1).equals("-")){
            stringResult = stringResult.replace("-", "");
        }else{
            stringResult = "-"+stringResult;
        }

        if(!stringResult.equals("") && !stringResult.equals("-")) {
            if (operation.getNumberTwo() != 0.0) {
                operation.setNumberTwo(Double.parseDouble(stringResult));
            } else {
                operation.setNumberOne(Double.parseDouble(stringResult));
            }
        }
    }

}
