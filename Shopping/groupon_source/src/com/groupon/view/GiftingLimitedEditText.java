// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.ButterKnife;

public class GiftingLimitedEditText extends RelativeLayout
{

    private static final int DEFAULT_TEXT_LIMIT = 330;
    TextView counter;
    EditText editField;
    private int maximumTextSize;

    public GiftingLimitedEditText(Context context)
    {
        super(context);
        initComponents();
    }

    public GiftingLimitedEditText(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        initComponents();
    }

    public GiftingLimitedEditText(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        initComponents();
    }

    private void initComponents()
    {
        maximumTextSize = 330;
        LayoutInflater.from(getContext()).inflate(0x7f0300ff, this, true);
        ButterKnife.bind(this, this);
        counter.setText(String.valueOf(maximumTextSize));
        setMaxTextSize(maximumTextSize);
        editField.addTextChangedListener(new TextWatcher() {

            final GiftingLimitedEditText this$0;

            public void afterTextChanged(Editable editable)
            {
                counter.setText(String.valueOf(maximumTextSize - editable.length()));
            }

            public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            public void onTextChanged(CharSequence charsequence, int i, int j, int k)
            {
            }

            
            {
                this$0 = GiftingLimitedEditText.this;
                super();
            }
        });
    }

    public Editable getText()
    {
        return editField.getText();
    }

    public void setError(String s)
    {
        editField.setError(s);
    }

    public void setMaxTextSize(int i)
    {
        maximumTextSize = i;
        editField.setFilters(new InputFilter[] {
            new android.text.InputFilter.LengthFilter(i)
        });
    }

    public void setText(String s)
    {
        editField.setText(s);
    }

}
