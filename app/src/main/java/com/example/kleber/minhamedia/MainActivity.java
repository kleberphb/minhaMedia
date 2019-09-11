package com.example.kleber.minhamedia;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et_nota_01, et_nota_02, et_nota_final;
    private TextView tv_media, tv_situacao, tv_observacao, tv_observacao_02;
    private ImageView iv_imagem;
    private String result_media = "", resultado_final = "";
    private LinearLayout ll_nota_final;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nota_01 = findViewById(R.id.et_nota_01);
        et_nota_02 = findViewById(R.id.et_nota_02);
        et_nota_final = findViewById(R.id.et_nota_final);
        ll_nota_final = findViewById(R.id.ll_nota_final);
        tv_media = findViewById(R.id.tv_media);
        tv_situacao = findViewById(R.id.tv_situacao);
        tv_observacao = findViewById(R.id.tv_observacao);
        tv_observacao_02 = findViewById(R.id.tv_observacao_02);
        iv_imagem = findViewById(R.id.iv_imagem);

        et_nota_01.setText("");
        et_nota_02.setText("");
        et_nota_final.setText("");
        tv_media.setText("");
        tv_situacao.setText("");
        tv_observacao.setText("");
        tv_observacao_02.setText("");

        et_nota_01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void afterTextChanged(Editable s) {

                minhaMedia();
            }
        });

        et_nota_02.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void afterTextChanged(Editable s) {

                minhaMedia();
            }
        });

        et_nota_final.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

                notaFinal();

            }
        });

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void minhaMedia() {

        if (!et_nota_01.getText().toString().isEmpty()) {
            float nota_1 = Float.parseFloat(et_nota_01.getText().toString());

            if (nota_1 <= 10) {
                et_nota_02.setEnabled(true);

                if (!et_nota_01.getText().toString().isEmpty() &&
                        !et_nota_01.getText().toString().equals(".") &&
                        !et_nota_02.getText().toString().isEmpty() &&
                        !et_nota_02.getText().toString().equals(".")) {

                    float nota1 = Float.parseFloat(et_nota_01.getText().toString());
                    float nota2 = Float.parseFloat(et_nota_02.getText().toString());

                    if (nota1 <= 10 && nota2 <= 10) {

                        et_nota_01.setEnabled(true);

                        float media = (nota1 + nota2) / 2;
                        float med_final = 10 - media;
                        resultado_final = Float.toString(med_final);
                        String resultado = Float.toString(media);
                        tv_media.setText("Sua média foi de " + resultado + " pts");

                        if (media >= 7) {

                            et_nota_final.setEnabled(false);
                            ll_nota_final.setForeground(getDrawable(R.color.colorBlue));
                            tv_observacao.setText("Parabéns pela conquista");
                            tv_observacao_02.setText("Continue sempre assim...");
                            tv_situacao.setText("APROVADO");
                            iv_imagem.setImageResource(R.drawable.aprovado);

                        } else {

                            tv_observacao.setText("A vida é feita de obstáculos, você consegue...");
                            tv_observacao_02.setText("Você precisará de " + resultado_final + " pts para ser aprovado na final");
                            tv_situacao.setText("AGUARDANDO PROVA FINAL");
                            et_nota_final.setEnabled(true);
                            ll_nota_final.setForeground(getDrawable(R.color.transparente));
                            iv_imagem.setImageResource(R.drawable.reprovado);
                        }

                    } else {
                        et_nota_01.setEnabled(false);
                        et_nota_final.setEnabled(false);
                        ll_nota_final.setForeground(getDrawable(R.color.colorBlue));
                        tv_observacao.setText("Sua nota não pode ser maior que 10");
                        tv_observacao_02.setText("");
                        tv_situacao.setText("");
                        tv_media.setText("");
                        iv_imagem.setImageResource(R.drawable.processando);
                    }

                } else {

                    et_nota_final.setEnabled(false);
                    ll_nota_final.setForeground(getDrawable(R.color.colorBlue));
                    tv_observacao.setText("");
                    tv_observacao_02.setText("");
                    tv_situacao.setText("");
                    tv_media.setText("");
                    iv_imagem.setImageResource(R.drawable.processando);

                }
            } else {

                et_nota_02.setEnabled(false);
                et_nota_final.setEnabled(false);
                ll_nota_final.setForeground(getDrawable(R.color.colorBlue));
                tv_observacao.setText("Sua nota não pode ser maior que 10");
                tv_observacao_02.setText("");
                tv_situacao.setText("");
                tv_media.setText("");
                iv_imagem.setImageResource(R.drawable.processando);


            }

        } else {

            tv_observacao.setText("");
            tv_observacao_02.setText("");
            tv_situacao.setText("");
            tv_media.setText("");
            iv_imagem.setImageResource(R.drawable.processando);

        }

    }

    private void notaFinal() {

        if (!et_nota_final.getText().toString().isEmpty()) {
            float nota_finals = Float.parseFloat(et_nota_final.getText().toString());

            if (nota_finals <= 10) {

                if (!et_nota_01.getText().toString().isEmpty() &&
                        !et_nota_02.getText().toString().isEmpty() &&
                        !et_nota_final.getText().toString().isEmpty() &&
                        !et_nota_final.getText().toString().equals("")) {

                    et_nota_01.setEnabled(false);
                    et_nota_02.setEnabled(false);

                    float nota_001 = Float.parseFloat(et_nota_01.getText().toString());
                    float nota_002 = Float.parseFloat(et_nota_02.getText().toString());
                    float nota_final = Float.parseFloat(et_nota_final.getText().toString());

                    float medias = (nota_001 + nota_002) / 2;
                    result_media = Float.toString(medias);
                    float result = (medias + nota_final) / 2;
                    String resultado = Float.toString(result);
                    tv_media.setText("Sua média foi de " + resultado + " pts");

                    if (result >= 5) {
                        tv_situacao.setText("APROVADO");
                        tv_observacao.setText("Parabéns, desta vez foi por pouco");
                        tv_observacao_02.setText("Estude mais, e melhore seu desempenho");
                        iv_imagem.setImageResource(R.drawable.aprovado);

                    } else {

                        tv_situacao.setText("REPROVADO");
                        tv_observacao.setText("Que pena, não foi desta vez");
                        tv_observacao_02.setText("Não desista, continue estudando que você consegue");
                        iv_imagem.setImageResource(R.drawable.reprovado);

                    }

                } else {
                    et_nota_01.setEnabled(true);
                    et_nota_02.setEnabled(true);
                    tv_media.setText("Sua média foi de " + result_media + " pts");
                    tv_observacao_02.setText("Você precisará de " + resultado_final + " pts para ser aprovado na final");
                    tv_situacao.setText("AGUARDANDO PROVA FINAL");
                    iv_imagem.setImageResource(R.drawable.processando);

                }


            } else {

                et_nota_01.setEnabled(false);
                et_nota_02.setEnabled(false);
                tv_observacao.setText("Sua nota não pode ser maior que 10");
                tv_observacao_02.setText("");
                tv_situacao.setText("");
                tv_media.setText("");
                iv_imagem.setImageResource(R.drawable.processando);

            }


        } else {

            et_nota_01.setEnabled(true);
            et_nota_02.setEnabled(true);
            tv_media.setText("Sua média foi de " + result_media + " pts");
            tv_observacao_02.setText("Você precisará de " + resultado_final + " pts para ser aprovado na final");
            tv_situacao.setText("AGUARDANDO PROVA FINAL");
            iv_imagem.setImageResource(R.drawable.processando);

        }


    }

}
