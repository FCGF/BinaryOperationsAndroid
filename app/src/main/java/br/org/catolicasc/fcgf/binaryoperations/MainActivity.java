package br.org.catolicasc.fcgf.binaryoperations;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button addButton;
    Button subtractButton;
    Button multiplyButton;
    Button divideButton;
    Button clearButton;
    EditText editText;
    TextView resultText;
    boolean calculated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addButton = (Button) findViewById(R.id.addButton);
        subtractButton = (Button) findViewById(R.id.subtractButton);
        multiplyButton = (Button) findViewById(R.id.multiplyButton);
        divideButton = (Button) findViewById(R.id.divideButton);
        clearButton = (Button) findViewById(R.id.clearButton);
        editText = (EditText) findViewById(R.id.editText);
        resultText = (TextView) findViewById(R.id.resultText);

        calculated = false;

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(Operation.ADD);
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(Operation.SUBTRACT);
            }
        });

        multiplyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(Operation.MULTIPLY);
            }
        });

        divideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(Operation.DIVIDE);
            }
        });

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculated = false;
                makeText("", editText);
                makeText("", resultText);
                BinaryCalculator.GetInstance().clear();
            }
        });

        editText.setFilters(new InputFilter[]{
                new InputFilter() {
                    @Override
                    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                        for (int i = start; i < end; i++) {
                            if (source.charAt(i) != '0' && source.charAt(i) != '1') {
                                return "";
                            }
                        }
                        return null;
                    }
                }
        });

    }

    private void click(Operation operation) {
        BinaryCalculator calculator = BinaryCalculator.GetInstance();
        final String readText = editText.getText().toString();

        calculator.addValue(readText);
        calculator.addOperand(operation);
        try {
            if (calculator.shouldCalculate()) {
                String result = calculator.executeOperation();
                makeText(String.format("%s %c", result, operation.getSymbol()), resultText);
                calculated = true;
            } else {
                makeText(String.format("%s %c", readText, operation.getSymbol()), resultText);
                calculated = false;
            }
            makeText("", editText);
        } catch (Exception ex) {
            makeToast(getString(R.string.calculationError));
        }
    }

    private void makeToast(final String text) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void makeText(final String text, final TextView view) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                view.setText(text);
            }
        });
    }


}
