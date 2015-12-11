// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import roboguice.util.Strings;

public class ClearableEditText extends LinearLayout
{

    private ImageView clearButton;
    private EditText editText;

    public ClearableEditText(Context context)
    {
        this(context, null);
        initViews();
    }

    public ClearableEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initViews();
    }

    public ClearableEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        initViews();
    }

    protected void clearText()
    {
        clearButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ClearableEditText this$0;

            public void onClick(View view)
            {
                editText.setText("");
                editText.requestFocus();
            }

            
            {
                this$0 = ClearableEditText.this;
                super();
            }
        });
    }

    public Editable getText()
    {
        return editText.getText();
    }

    protected void initViews()
    {
        LayoutInflater.from(getContext()).inflate(0x7f030065, this, true);
        editText = (EditText)findViewById(0x7f1001a3);
        clearButton = (ImageView)findViewById(0x7f1001a4);
        showHideClearButton();
        clearButton.setVisibility(4);
        clearText();
    }

    public void setText(String s)
    {
        editText.setText(s);
    }

    public void setWidth(int i)
    {
        editText.setWidth(i);
    }

    protected void showHideClearButton()
    {
        editText.addTextChangedListener(new TextWatcher() {

            final ClearableEditText this$0;

            public void afterTextChanged(Editable editable)
            {
                ImageView imageview = clearButton;
                byte byte0;
                if (Strings.isEmpty(editable))
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 0;
                }
                imageview.setVisibility(byte0);
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
                ImageView imageview = clearButton;
                if (Strings.notEmpty(charsequence))
                {
                    i = 0;
                } else
                {
                    i = 4;
                }
                imageview.setVisibility(i);
            }

            
            {
                this$0 = ClearableEditText.this;
                super();
            }
        });
    }


}
