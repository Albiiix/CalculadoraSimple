package com.example.calculadora;

import static java.lang.Math.cos;
import static java.lang.Math.pow;
import static java.lang.Math.sin;
import static java.lang.Math.sqrt;
import static java.lang.Math.tan;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.OrientationEventListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private Button uno;
    private Button dos;
    private Button tres;
    private Button cuatro;
    private Button cinco;
    private Button seis;
    private Button siete;
    private Button ocho;
    private Button nueve;
    private Button cero;
    private Button punto;

    private Button b_suma;
    private Button b_resta;
    private Button b_multiplicacion;
    private Button b_division;
    private Button b_igual;
    private Button b_potencia;
    private Button b_raiz;
    private Button b_porcentaje;
    private Button masmenos;

    private Button cancel;
    private Button cancele;
    private Button off;
    private Button m;
    private Button mplus;
    private Button mminus;
    private Button mrecall;
    private Button mclear;

    private Button fraccion;
    private Button pi;
    private Button seno;
    private Button coseno;
    private Button tangente;

    private TextView resultado;
    private TextView operacion;

    private Double num1 = 0.0;
    private Double num2 = 0.0;
    private Double result = 0.0;
    private String oper = "";
    private Integer actual = 0;
    private Integer activado_menos = 0;
    private Double num_memoria= 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        int orientation = getResources().getConfiguration().orientation;

        operacion= findViewById(R.id.operacion);

        uno= findViewById(R.id.uno);
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=")){
                    guardar_num("1");
                }else{
                    resetear();
                    guardar_num("1");
                }


            }
        });

        dos= findViewById(R.id.dos);
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=")){
                    guardar_num("2");
                }else{
                    resetear();
                    guardar_num("2");
                }
            }
        });

        tres= findViewById(R.id.tres);
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=")){
                    guardar_num("3");
                }else{
                    resetear();
                    guardar_num("3");
                }
            }
        });

        cuatro= findViewById(R.id.cuatro);
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=")){
                    guardar_num("4");
                }else{
                    resetear();
                    guardar_num("4");
                }
            }
        });

        cinco= findViewById(R.id.cinco);
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=")){
                    guardar_num("5");
                }else{
                    resetear();
                    guardar_num("5");
                }
            }
        });

        seis= findViewById(R.id.seis);
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=")){
                    guardar_num("6");
                }else{
                    resetear();
                    guardar_num("6");
                }
            }
        });

        siete= findViewById(R.id.siete);
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=")){
                    guardar_num("7");
                }else{
                    resetear();
                    guardar_num("7");
                }
            }
        });

        ocho= findViewById(R.id.ocho);
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=")){
                    guardar_num("8");
                }else{
                    resetear();
                    guardar_num("8");
                }
            }
        });

        nueve= findViewById(R.id.nueve);
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=")){
                    guardar_num("9");
                }else{
                    resetear();
                    guardar_num("9");
                }
            }
        });

        cero= findViewById(R.id.cero);
        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=")){
                    guardar_num("0");
                }else{
                    resetear();
                    guardar_num("0");
                }
            }
        });

        punto= findViewById(R.id.punto);
        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!operacion.getText().toString().contains("=") && !oper.contains(".")){
                    guardar_num(".");
                }else if(!oper.contains(".")){
                    resetear();
                    guardar_num(".");
                }else{
                    Toast.makeText(getApplicationContext(),"Simbolo . ya introducido",Toast.LENGTH_SHORT).show();
                }
            }
        });

        masmenos= findViewById(R.id.masmenos);
        masmenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (operacion.getText().toString().isEmpty() || oper.equals("")) {
                    Toast.makeText(getApplicationContext(), "Introduce primero un numero", Toast.LENGTH_SHORT).show();
                } else {
                    String sub = oper;
                    Double aux = new Double(oper);
                    aux = aux * (-1);
                    oper = aux.toString();
                    if (aux < 0.0) {
                        if (!operacion.getText().toString().contains("(") && !operacion.getText().toString().contains(")")) {
                            operacion.setText(operacion.getText().toString().replace(sub, "(" + oper + ")"));
                        } else {
                            operacion.setText(operacion.getText().toString().replace(sub, oper));
                        }
                        activado_menos = 1;
                    } else {
                        operacion.setText(operacion.getText().toString().replace(sub, oper));
                    }
                    resultado.setText(resultado.getText().toString().replace(sub, oper));
                }
            }
        });


        b_suma= findViewById(R.id.suma);
        b_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = "";
                if(!operacion.getText().toString().isEmpty()) {
                    aux = operacion.getText().toString().substring(operacion.getText().toString().length() - 1);
                }

                if(operacion.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Introduce primero un numero",Toast.LENGTH_SHORT).show();
                }
                else if(activado_menos==1 || ningun_operador()){
                    operar("+", 1);
                    activado_menos=0;
                }
                else if(operador_introducido(aux)){
                    Toast.makeText(getApplicationContext(),"Operador ya introducido",Toast.LENGTH_SHORT).show();
                }
                else{
                   dar_resultado();
                   operar("+", 1);
                }
            }
        });

        b_resta= findViewById(R.id.menos);
        b_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = "";
                if(!operacion.getText().toString().isEmpty()) {
                    aux = operacion.getText().toString().substring(operacion.getText().toString().length() - 1);
                }

                if(operacion.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Introduce primero un numero",Toast.LENGTH_SHORT).show();
                }
                else if(activado_menos==1 || ningun_operador()){
                    operar("-", 2);
                }
                else if(operador_introducido(aux)){
                    Toast.makeText(getApplicationContext(),"Operador ya introducido",Toast.LENGTH_SHORT).show();
                }
                else{
                    dar_resultado();
                    operar("-", 2);
                }
            }
        });

        b_multiplicacion= findViewById(R.id.multiplicacion);
        b_multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = "";
                if(!operacion.getText().toString().isEmpty()) {
                    aux = operacion.getText().toString().substring(operacion.getText().toString().length() - 1);
                }

                if(operacion.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Introduce primero un numero",Toast.LENGTH_SHORT).show();
                }
                else if(activado_menos==1 || ningun_operador()){
                    operar("*", 3);
                }
                else if(operador_introducido(aux)){
                    Toast.makeText(getApplicationContext(),"Operador ya introducido",Toast.LENGTH_SHORT).show();
                }

                else{
                    dar_resultado();
                    operar("*", 3);
                }
            }
        });

        b_division= findViewById(R.id.dividir);
        b_division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = "";
                if(!operacion.getText().toString().isEmpty()) {
                    aux = operacion.getText().toString().substring(operacion.getText().toString().length() - 1);
                }

                if(operacion.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Introduce primero un numero",Toast.LENGTH_SHORT).show();
                }
                else if(activado_menos==1 || ningun_operador()){
                    operar("/", 4);
                }
                else if(operador_introducido(aux)){
                    Toast.makeText(getApplicationContext(),"Operador ya introducido",Toast.LENGTH_SHORT).show();
                }

                else{
                    dar_resultado();
                    operar("/", 4);
                }
            }
        });

        b_potencia= findViewById(R.id.potencia);
        b_potencia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aux = "";
                if(!operacion.getText().toString().isEmpty()) {
                    aux = operacion.getText().toString().substring(operacion.getText().toString().length() - 1);
                }

                if(operacion.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Introduce primero un numero",Toast.LENGTH_SHORT).show();
                }
                else if(ningun_operador()){
                    operar("^", 5);
                }
                else if(operador_introducido(aux)){
                    Toast.makeText(getApplicationContext(),"Operador ya introducido",Toast.LENGTH_SHORT).show();
                }
                else{
                    dar_resultado();
                    operar("^", 5);
                }
            }
        });

        b_raiz= findViewById(R.id.raiz);
        b_raiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ningun_operador()) {
                            operacion.append("√");
                            actual = 6;
                }else if(!operacion.getText().toString().contains("+") && !operacion.getText().toString().contains("-") &&
                        !operacion.getText().toString().contains("*") && !operacion.getText().toString().contains("/")
                        && !operacion.getText().toString().contains("^")){
                    dar_resultado();
                    operar("*", 3);
                    operacion.append("√");
                }
                else{ operacion.append("√");}

            }
        });

        b_porcentaje= findViewById(R.id.porcentaje);
        b_porcentaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operacion.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Introduce primero un numero",Toast.LENGTH_SHORT).show();
                }
                else {
                    String sub = oper;
                    Double aux = new Double(oper);
                    aux = aux / 100;
                    oper = aux.toString();
                    operacion.setText(operacion.getText().toString().replace(sub, oper));
                    resultado.setText(resultado.getText().toString().replace(sub, oper));
                }
            }
        });

        resultado= findViewById(R.id.resultado);

        b_igual= findViewById(R.id.igual);
        b_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String aux = "";
                if(!operacion.getText().toString().isEmpty()) {
                    aux = operacion.getText().toString().substring(operacion.getText().toString().length() - 1);
                }
                if(operacion.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Introduce primero un numero",Toast.LENGTH_SHORT).show();
                }
                else if(ningun_operador2()){
                    operacion.append("=");
                    resultado.setText(oper);
                    actual=0;
                }
                else if(iniciada_operacion(aux)){
                    Toast.makeText(getApplicationContext(),"Operacion incompleta",Toast.LENGTH_SHORT).show();
                }
                else if(!operacion.getText().toString().contains("=")){
                    dar_resultado();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Resultado ya dado",Toast.LENGTH_SHORT).show();
                }

            }
        });

        cancel= findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetear();
            }
        });

        cancele= findViewById(R.id.cancele);
        cancele.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sub= oper;
                oper="";
                operacion.setText( operacion.getText().toString().replace(sub,oper));
                resultado.setText("0");
            }
        });

        off= findViewById(R.id.off);
        off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        m= findViewById(R.id.m);
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num_memoria= new Double(resultado.getText().toString());
                Toast.makeText(getApplicationContext(),"Numero agregado a memoria",Toast.LENGTH_SHORT).show();
            }
        });

        mplus= findViewById(R.id.mplus);
        mplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                num_memoria= num_memoria + new Double(resultado.getText().toString());
                Toast.makeText(getApplicationContext(),"Numero sumado en memoria",Toast.LENGTH_SHORT).show();
            }
        });

        if(orientation==2) {
            mminus = findViewById(R.id.mminus);
            mminus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                   num_memoria = num_memoria - new Double(resultado.getText().toString());
                    Toast.makeText(getApplicationContext(),"Numero restado en memoria",Toast.LENGTH_SHORT).show();
                }
            });

            mrecall = findViewById(R.id.mrecall);
            mrecall.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    resultado.setText(num_memoria.toString());
                    operacion.append(num_memoria.toString());
                    oper= num_memoria.toString();
                }
            });

            mclear = findViewById(R.id.mclear);
            mclear.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    num_memoria= 0.0;
                    Toast.makeText(getApplicationContext(),"Memoria borrada",Toast.LENGTH_SHORT).show();
                }
            });

            fraccion = findViewById(R.id.fraccion);
            fraccion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String aux = "";
                    if(!operacion.getText().toString().isEmpty()) {
                        aux = operacion.getText().toString().substring(operacion.getText().toString().length() - 1);
                    }

                    if(ningun_operador() || !oper.equals("")){
                        num1= new Double(oper);
                        result= 1/num1;
                        operacion.setText("1/("+ num1 + ") =");
                        oper= result.toString();
                        resultado.setText(result.toString());
                    }
                    else if(iniciada_operacion(aux)){
                        Toast.makeText(getApplicationContext(),"Operacion no válida",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        operacion.setText("1/("+ operacion.getText().toString() + ")");
                        dar_resultado();
                        result = 1/result;
                        oper=result.toString();
                        resultado.setText(result.toString());
                        actual=0;
                    }

                }
            });

            pi = findViewById(R.id.pi);
            pi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (!operacion.getText().toString().contains("3.14")) {
                        if (!operacion.getText().toString().contains("=")) {
                            oper = "3.14";
                            operacion.append("3.14");
                            resultado.setText("3.14");
                        } else {
                            num1 = 0.0;
                            num2 = 0.0;
                            result = 0.0;
                            oper = "3.14";
                            operacion.setText("3.14");
                            resultado.setText("3.14");
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Numero pi ya introducido", Toast.LENGTH_SHORT).show();
                    }
                }
            });

            seno = findViewById(R.id.seno);
            seno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String aux = "";
                    if(!operacion.getText().toString().isEmpty()) {
                        aux = operacion.getText().toString().substring(operacion.getText().toString().length() - 1);
                    }

                    if(ningun_operador() && !operacion.getText().toString().isEmpty()){
                        num1= new Double(oper);
                        result= sin(num1);
                        operacion.setText("sin("+ num1 + ") =");
                        oper= result.toString();
                        resultado.setText(result.toString());
                    }
                    else if(iniciada_operacion(aux)){
                        Toast.makeText(getApplicationContext(),"Operación no válida",Toast.LENGTH_SHORT).show();
                    }
                    else if(operacion.getText().toString().isEmpty()){
                        operacion.setText("sin(");
                        actual=7;
                    }
                    else{
                        operacion.setText("sin("+ operacion.getText().toString() + ")");
                        dar_resultado();
                        result = sin(result);
                        oper=result.toString();
                        resultado.setText(result.toString());
                        actual=0;
                    }
                }
            });

            coseno = findViewById(R.id.coseno);
            coseno.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String aux = "";
                    if(!operacion.getText().toString().isEmpty()) {
                        aux = operacion.getText().toString().substring(operacion.getText().toString().length() - 1);
                    }

                    if(ningun_operador() && !operacion.getText().toString().isEmpty()){
                        num1= new Double(oper);
                        result= cos(num1);
                        operacion.setText("cos("+ num1 + ") =");
                        oper= result.toString();
                        resultado.setText(result.toString());
                    }
                    else if(iniciada_operacion(aux)){
                        Toast.makeText(getApplicationContext(),"Operación no válida",Toast.LENGTH_SHORT).show();
                    }
                    else if(operacion.getText().toString().isEmpty()){
                        operacion.setText("cos(");
                        actual=8;
                    }
                    else{
                        operacion.setText("cos("+ operacion.getText().toString() + ")");
                        dar_resultado();
                        result = cos(result);
                        oper=result.toString();
                        resultado.setText(result.toString());
                        actual=0;
                    }
                }
            });

            tangente = findViewById(R.id.tangente);
            tangente.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    String aux = "";
                    if(!operacion.getText().toString().isEmpty()) {
                        aux = operacion.getText().toString().substring(operacion.getText().toString().length() - 1);
                    }

                    if(ningun_operador() && !operacion.getText().toString().isEmpty()){
                        num1= new Double(oper);
                        result= tan(num1);
                        operacion.setText("tan("+ num1 + ") =");
                        oper= result.toString();
                        resultado.setText(result.toString());
                    }
                    else if(iniciada_operacion(aux)){
                        Toast.makeText(getApplicationContext(),"Operación no válida",Toast.LENGTH_SHORT).show();
                    }
                    else if(operacion.getText().toString().isEmpty()){
                        operacion.setText("tan(");
                        actual=9;
                    }
                    else{
                        operacion.setText("tan("+ operacion.getText().toString() + ")");
                        dar_resultado();
                        result = tan(result);
                        oper=result.toString();
                        resultado.setText(result.toString());
                        actual=0;
                    }
                }
            });
        }


    }

    public void resetear(){
        operacion.setText("");
        resultado.setText("0");
        num1 = 0.0;
        num2 = 0.0;
        oper = "";
        result = 0.0;
    }

    public String guardar_num(String num){

        if((resultado.getText().toString().equals("0") && !num.equals("0")))
        {

            if(num.equals(".")){
                oper = oper + "0"+num;
                operacion.append("0"+num);
                resultado.setText("0"+ num);
            }else{
                oper = oper + num;
                operacion.append(num);
                resultado.setText(num);
            }

        } else if(!resultado.getText().toString().equals("0")){
            oper = oper + num;
            operacion.append(num);
            resultado.append(num);
        }

        return oper;
    }

    public void operar(String tipo, Integer tipo2){
        if (!operacion.getText().toString().contains("=")) {
            num1 = new Double(oper);
            oper = "";
            operacion.append(tipo);
            resultado.setText("0");
        }else{
            num1 = new Double(oper);
            operacion.setText(oper + tipo);
            oper = "";
            resultado.setText("0");
        }
        actual=tipo2;
    }

    public boolean ningun_operador(){
        if(!operacion.getText().toString().contains("+") && !operacion.getText().toString().contains("-") &&
                !operacion.getText().toString().contains("*") && !operacion.getText().toString().contains("/")
                && !operacion.getText().toString().contains("^") && !operacion.getText().toString().contains("√")){
            return true;
        }
        return false;
    }

    public boolean ningun_operador2(){
        if(!operacion.getText().toString().contains("+") && !operacion.getText().toString().contains("-") &&
                !operacion.getText().toString().contains("*") && !operacion.getText().toString().contains("/")
                && !operacion.getText().toString().contains("^")  && !operacion.getText().toString().contains("√")
                && !operacion.getText().toString().contains("=") && !operacion.getText().toString().contains("sin(")
                && !operacion.getText().toString().contains("cos(") && !operacion.getText().toString().contains("tan(")){
            return true;
        }
        return false;
    }

    public boolean iniciada_operacion(String aux){
        if(aux.equals("+") || aux.equals("-") || aux.equals("*") || aux.equals("/") || aux.equals("^")){
            return true;
        }
        return false;
    }

    public boolean operador_introducido(String aux){
        if((aux.equals("+") || aux.equals("-") ||
                aux.equals("*") || aux.equals("/")
                || aux.equals("^")) && !aux.equals("=")){
            return true;
        }
        return false;
    }

    public void dar_resultado(){
        if(actual !=6) {
            if(operacion.getText().toString().contains("√")){
                num2 = new Double(oper);
                num2= sqrt(num2);
                oper = "";

            }else{
                num2 = new Double(oper);
                oper = "";

            }
        }

            if (actual == 1) {
                result = num1 + num2;
            } else if (actual == 2) {
                result = num1 - num2;
            } else if (actual == 3) {
                result = num1 * num2;
            } else if (actual == 4) {
                result = num1 / num2;
            } else if (actual == 5) {
                result = pow(num1, num2);
            } else if (actual == 6) {
                num1 = new Double(oper);
                oper = "";
                result = sqrt(num1);
            } else if (actual == 7){
                operacion.append(")");
                result= sin(num2);
            } else if (actual == 8){
                operacion.append(")");
                result= cos(num2);
            } else if (actual == 9){
                operacion.append(")");
                result= tan(num2);
            }

        operacion.append("=");
        oper=result.toString();
        resultado.setText(result.toString());
        actual=0;
    }

   @Override
    protected void onSaveInstanceState(Bundle outState){

        outState.putDouble("num1", num1);
        outState.putDouble("num2", num2);
        outState.putString("resultado", resultado.getText().toString());
        outState.putString("operacion", operacion.getText().toString());
        outState.putDouble("result", result);
        outState.putString("oper", oper);
        outState.putInt("actual", actual);
        outState.putInt("activado_menos", activado_menos);
        outState.putDouble("num_memoria", num_memoria);
       super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        num1 = savedInstanceState.getDouble("num1");
        num2 = savedInstanceState.getDouble("num2");
        resultado.setText(savedInstanceState.getString("resultado"));
        operacion.setText(savedInstanceState.getString("operacion"));
        result = savedInstanceState.getDouble("result");
        oper = savedInstanceState.getString("oper");
        actual = savedInstanceState.getInt("actual");
        activado_menos = savedInstanceState.getInt("activado_menos");
        num_memoria = savedInstanceState.getDouble("num_memoria");
    }
}