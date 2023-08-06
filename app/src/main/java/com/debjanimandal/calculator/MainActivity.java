package com.debjanimandal.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button btn0,btn1,btn3,btn4, btn5, btn6, btn7, btn8, btn9, btn2,btnAC, btnDEL, btnADD,btnSUB, btnDOT, btnEQUALS, btnDIV, btnMUL;
    private TextView history, result;
    private String number=null;
    double firstNumber=0;
    double lastNumber=0;
    String status=null;
    Boolean operator=false;
    DecimalFormat myformat=new DecimalFormat("######.######");
    String his,curres;
    Boolean dotflag=true;
    Boolean btnACcontrol=true;
    Boolean btnEqualsControl=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn0=findViewById(R.id.btn0);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn5=findViewById(R.id.btn5);
        btn6=findViewById(R.id.btn6);
        btn7=findViewById(R.id.btn7);
        btn8=findViewById(R.id.btn8);
        btn9=findViewById(R.id.btn9);
        btnDIV=findViewById(R.id.btnDiv);
        btnMUL=findViewById(R.id.btnMul);
        btnADD=findViewById(R.id.btnadd);
        btnSUB=findViewById(R.id.btnsub);
        btnAC=findViewById(R.id.btnAC);
        btnDEL=findViewById(R.id.btnDel);
        btnDOT=findViewById(R.id.btndot);
        btnEQUALS=findViewById(R.id.btnequals);
        history=findViewById(R.id.textViewhistory);
        result=findViewById(R.id.textViewResult);

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("0");
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("1");
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("2");
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("3");
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("4");
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("5");
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("6");
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("7");
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("8");
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                numberClick("9");
            }
        });
        btnDIV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                his=history.getText().toString();
                curres=result.getText().toString();
                history.setText(his+curres+"/");
                if(operator==true)
                {
                    if(status=="addition") {
                        plus();
                    } else if (status=="multiplication") {
                        mul();
                    } else if (status=="subtraction") {
                        minus();
                    } else {
                        div();
                    }
                }
                status="divide";
                operator=false;
                number=null;
            }
        });
        btnMUL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                his=history.getText().toString();
                curres=result.getText().toString();
                history.setText(his+curres+"*");
                if(operator==true)
                {
                    if(status=="addition") {
                        plus();
                    } else if (status=="divide") {
                        div();
                    } else if (status=="subtraction") {
                        minus();
                    } else {
                        mul();
                    }
                }
                status="multiplication";
                operator=false;
                number=null;
            }
        });
        btnADD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                his=history.getText().toString();
                curres=result.getText().toString();
                history.setText(his+curres+"+");
                if(operator==true)
                {
                    if(status=="multiplication") {
                        mul();
                    } else if (status=="divide") {
                        div();
                    } else if (status=="subtraction") {
                        minus();
                    } else {
                        plus();
                    }
                }
                status="addition";
                operator=false;
                number=null;
            }
        });
        btnSUB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                his=history.getText().toString();
                curres=result.getText().toString();
                history.setText(his+curres+"-");
                    if(operator==true)
                    {
                        if(status=="addition") {
                            plus();
                        } else if (status=="multiplication") {
                            mul();
                        } else if (status=="divide") {
                            div();
                        } else {
                            minus();
                        }
                    }
                    status="subtraction";
                    operator=false;
                    number=null;
            }
        });
        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number=null;
                status=null;
                firstNumber=0;
                lastNumber=0;
                result.setText("0");
                history.setText("");
                dotflag=true;
                btnACcontrol=true;
            }
        });
        btnDOT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(dotflag==true) {
                    if (number == null) {
                        number = "0.";
                    } else {
                        number = number + ".";
                    }
                }
                result.setText(number);
                dotflag=false;
            }
        });
        btnDEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnACcontrol==true) {
                    result.setText("0");
                }
                else {
                    number=number.substring(0,number.length()-1);
                    if(number.length()==0) {
                        btnDEL.setClickable(false);
                    } else if (number.contains(".")) {
                        dotflag=false;
                    } else {
                        dotflag=true;
                    }
                    result.setText(number);
                }

            }
        });
        btnEQUALS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(operator==true)
                {
                    if(status=="addition") {
                        plus();
                    } else if (status=="multiplication") {
                        mul();
                    } else if (status=="divide") {
                        div();
                    } else if(status=="subtraction"){
                        minus();
                    }
                    else {
                        firstNumber=Double.parseDouble(result.getText().toString());
                    }
                }
                operator=false;
                btnEqualsControl=true;
            }
        });

    }
    public void numberClick(String view)
    {
        if(number==null)
        {
            number=view;
        } else if (btnEqualsControl==true) {
            firstNumber=0;
            lastNumber=0;
            number=view;
        } else {
            number=number+view;
        }
        result.setText(number);
        operator=true;
        btnACcontrol=false;
        btnDEL.setClickable(true);
        btnEqualsControl=false;
    }
    public void plus()
    {
        lastNumber=Double.parseDouble(result.getText().toString());
        firstNumber=firstNumber+lastNumber;
        result.setText(myformat.format(firstNumber));
        dotflag=true;
    }
    public void minus() {
        if(firstNumber==0)
        {
            firstNumber=Double.parseDouble(result.getText().toString());
        }
        else {
            lastNumber=Double.parseDouble(result.getText().toString());
            firstNumber=firstNumber-lastNumber;
        }
        result.setText(myformat.format(firstNumber));
        dotflag=true;
    }
    public void mul()
    {
        if(firstNumber==0)
        {
            firstNumber=1;
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        else {
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = firstNumber * lastNumber;
        }
        result.setText(myformat.format(firstNumber));
        dotflag=true;
    }
    public void div()
    {
        if(firstNumber==0)
        {
            lastNumber=Double.parseDouble(result.getText().toString());
            firstNumber=lastNumber/1;
        }
        else {
            lastNumber = Double.parseDouble(result.getText().toString());
            firstNumber = firstNumber / lastNumber;
        }
        result.setText(myformat.format(firstNumber));
        dotflag=true;
    }
}