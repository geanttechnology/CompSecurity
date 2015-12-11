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
import android.widget.RelativeLayout;
import roboguice.util.Strings;

public class ActionBarClearableEditText extends RelativeLayout
{

    private ImageView clearButton;
    private EditText editText;

    public ActionBarClearableEditText(Context context)
    {
        super(context);
        initViews();
    }

    public ActionBarClearableEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initViews();
    }

    public ActionBarClearableEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        initViews();
    }

    public void addTextChangedListener(TextWatcher textwatcher)
    {
        editText.addTextChangedListener(textwatcher);
    }

    public Editable getText()
    {
        return editText.getText();
    }

    protected void initClearTextButton()
    {
        clearButton.setVisibility(8);
        clearButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ActionBarClearableEditText this$0;

            public void onClick(View view)
            {
                editText.setText("");
                editText.requestFocus();
            }

            
            {
                this$0 = ActionBarClearableEditText.this;
                super();
            }
        });
    }

    protected void initViews()
    {
        LayoutInflater.from(getContext()).inflate(0x7f030019, this, true);
        editText = (EditText)findViewById(0x7f10009c);
        clearButton = (ImageView)findViewById(0x7f10009b);
        showHideClearButton();
        initClearTextButton();
    }

    public void setHint(int i)
    {
        editText.setHint(i);
    }

    public void setHint(CharSequence charsequence)
    {
        editText.setHint(charsequence);
    }

    public void setImeOptions(int i)
    {
        editText.setImeOptions(i);
    }

    public void setOnClickListener(android.view.View.OnClickListener onclicklistener)
    {
        super.setOnClickListener(onclicklistener);
        editText.setOnClickListener(onclicklistener);
    }

    public void setOnFocusChangeListener(android.view.View.OnFocusChangeListener onfocuschangelistener)
    {
        super.setOnFocusChangeListener(onfocuschangelistener);
        editText.setOnFocusChangeListener(onfocuschangelistener);
    }

    public void setOnKeyListener(android.view.View.OnKeyListener onkeylistener)
    {
        super.setOnKeyListener(onkeylistener);
        editText.setOnKeyListener(onkeylistener);
    }

    public void setText(String s)
    {
        editText.setText(s);
    }

    protected void showHideClearButton()
    {
        editText.addTextChangedListener(new TextWatcher() {

            final ActionBarClearableEditText this$0;

            public void afterTextChanged(Editable editable)
            {
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
                    i = 8;
                }
                imageview.setVisibility(i);
            }

            
            {
                this$0 = ActionBarClearableEditText.this;
                super();
            }
        });
    }


}
