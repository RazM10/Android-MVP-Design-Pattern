package org.myself.android_mvp_design;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity implements Presenter.PresenterListener {

    EditText mName, mEmail, mAddress;
    TextView mInfo;
    ProgressBar progressBar;

    Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(ViewActivity.this);

        mName=findViewById(R.id.name_et);
        mEmail=findViewById(R.id.email_et);
        mAddress=findViewById(R.id.address_et);
        mInfo=findViewById(R.id.info_tv);

        initProgressBar();

        mName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updateName(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                hideProgressBar();
            }
        });

        mEmail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updateEmail(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                hideProgressBar();
            }
        });

        mAddress.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                presenter.updateAddress(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
                hideProgressBar();
            }
        });
    }

    private void initProgressBar() {
        progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleSmall);
        progressBar.setIndeterminate(true);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(Resources.getSystem().getDisplayMetrics().widthPixels,
                250);
        params.addRule(RelativeLayout.CENTER_IN_PARENT);
        this.addContentView(progressBar, params);
        showProgressBar();
    }

    @Override
    public void getModelFullInfo(String info) {
        mInfo.setText(info);
    }

    @Override
    public void showProgressBar() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        progressBar.setVisibility(View.INVISIBLE);
    }
}
