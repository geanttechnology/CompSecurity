// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.util.ai;
import com.target.ui.util.e.a;

public class ZipCodeChooserView extends LinearLayout
    implements TextWatcher, android.widget.TextView.OnEditorActionListener
{
    private static class a
    {

        public EditText zipCodeEditText;
        public Button zipCodeSearchButton;

        public a(View view)
        {
            zipCodeEditText = (EditText)view.findViewById(0x7f1005ee);
            zipCodeSearchButton = (Button)view.findViewById(0x7f1005ef);
        }
    }

    private class b
        implements android.view.View.OnFocusChangeListener
    {

        final ZipCodeChooserView this$0;

        public void onFocusChange(View view, boolean flag)
        {
            if (ZipCodeChooserView.b(ZipCodeChooserView.this) == null)
            {
                return;
            } else
            {
                ZipCodeChooserView.b(ZipCodeChooserView.this).a(flag);
                return;
            }
        }

        private b()
        {
            this$0 = ZipCodeChooserView.this;
            super();
        }

    }

    public static interface c
    {

        public abstract void a(boolean flag);
    }

    public static interface d
    {

        public abstract void a(String s);
    }


    private static final int ZIP_CODE_LENGTH = 5;
    private c mFocusChangeListener;
    private d mListener;
    private a mViews;

    public ZipCodeChooserView(Context context)
    {
        super(context);
        a();
    }

    public ZipCodeChooserView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        a();
    }

    public ZipCodeChooserView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        a();
    }

    static void a(ZipCodeChooserView zipcodechooserview)
    {
        zipcodechooserview.b();
    }

    static c b(ZipCodeChooserView zipcodechooserview)
    {
        return zipcodechooserview.mFocusChangeListener;
    }

    private void b()
    {
        com.target.ui.util.e.a.a(this);
        String s = mViews.zipCodeEditText.getText().toString();
        if (o.g(s) && s.length() == 5)
        {
            if (mListener != null)
            {
                mListener.a(mViews.zipCodeEditText.getText().toString());
            }
            return;
        } else
        {
            ai.a(getContext(), 0x7f090141);
            return;
        }
    }

    public void a()
    {
        LayoutInflater.from(getContext()).inflate(0x7f03020d, this, true);
        mViews = new a(this);
        mViews.zipCodeEditText.addTextChangedListener(this);
        mViews.zipCodeEditText.setOnEditorActionListener(this);
        mViews.zipCodeEditText.setOnFocusChangeListener(new b());
        mViews.zipCodeSearchButton.setOnClickListener(new android.view.View.OnClickListener() {

            final ZipCodeChooserView this$0;

            public void onClick(View view)
            {
                com.target.ui.view.ZipCodeChooserView.a(ZipCodeChooserView.this);
            }

            
            {
                this$0 = ZipCodeChooserView.this;
                super();
            }
        });
    }

    public void afterTextChanged(Editable editable)
    {
        editable = editable.toString();
        Button button = mViews.zipCodeSearchButton;
        boolean flag;
        if (o.g(editable) && editable.length() == 5)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        button.setEnabled(flag);
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        if (i == 6 || keyevent != null && keyevent.getKeyCode() == 66)
        {
            b();
            return true;
        } else
        {
            return false;
        }
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public void setEnabled(boolean flag)
    {
        mViews.zipCodeEditText.setEnabled(flag);
        mViews.zipCodeSearchButton.setEnabled(flag);
    }

    public void setZipCode(String s)
    {
        if (!o.g(s) || s.length() > 5 || mViews == null)
        {
            return;
        } else
        {
            mViews.zipCodeEditText.setText(s);
            return;
        }
    }

    public void setZipCodeFocusChangeListener(c c1)
    {
        mFocusChangeListener = c1;
    }

    public void setZipCodeListener(d d1)
    {
        mListener = d1;
    }
}
