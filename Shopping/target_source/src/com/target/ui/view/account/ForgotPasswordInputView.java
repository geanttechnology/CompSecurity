// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.target.mothership.util.o;
import com.target.ui.util.e.a;
import com.target.ui.util.validation.h;
import com.target.ui.view.CustomErrorViewWrapper;
import java.util.regex.Pattern;

public class ForgotPasswordInputView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        EditText email;
        CustomErrorViewWrapper error;
        Button send;

        Views(View view)
        {
            super(view);
        }
    }

    private final class a
        implements TextWatcher
    {

        final ForgotPasswordInputView this$0;

        public void afterTextChanged(Editable editable)
        {
            if (ForgotPasswordInputView.c(ForgotPasswordInputView.this))
            {
                ForgotPasswordInputView.d(ForgotPasswordInputView.this);
                return;
            } else
            {
                ForgotPasswordInputView.e(ForgotPasswordInputView.this);
                return;
            }
        }

        public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        public void onTextChanged(CharSequence charsequence, int i, int j, int k)
        {
        }

        private a()
        {
            this$0 = ForgotPasswordInputView.this;
            super();
        }

    }

    public static interface b
    {

        public abstract void a(String s);
    }


    private static final Pattern EMAIL;
    private b mListener;
    private final android.widget.TextView.OnEditorActionListener mSendActionListener;
    private final android.view.View.OnClickListener mSendClickListener;
    private Views mViews;

    public ForgotPasswordInputView(Context context)
    {
        super(context);
        mSendActionListener = new android.widget.TextView.OnEditorActionListener() {

            final ForgotPasswordInputView this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 4)
                {
                    com.target.ui.view.account.ForgotPasswordInputView.a(ForgotPasswordInputView.this);
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = ForgotPasswordInputView.this;
                super();
            }
        };
        mSendClickListener = new android.view.View.OnClickListener() {

            final ForgotPasswordInputView this$0;

            public void onClick(View view)
            {
                ForgotPasswordInputView.b(ForgotPasswordInputView.this);
            }

            
            {
                this$0 = ForgotPasswordInputView.this;
                super();
            }
        };
        a(context);
    }

    public ForgotPasswordInputView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mSendActionListener = new _cls1();
        mSendClickListener = new _cls2();
        a(context);
    }

    public ForgotPasswordInputView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mSendActionListener = new _cls1();
        mSendClickListener = new _cls2();
        a(context);
    }

    private void a()
    {
        if (c())
        {
            b();
            return;
        } else
        {
            d();
            return;
        }
    }

    private void a(Context context)
    {
        setOrientation(1);
        inflate(context, 0x7f0300e9, this);
        mViews = new Views(this);
        mViews.email.addTextChangedListener(new a());
        mViews.email.setOnEditorActionListener(mSendActionListener);
        mViews.send.setEnabled(false);
        mViews.send.setOnClickListener(mSendClickListener);
        com.target.ui.util.e.a.b(mViews.email);
    }

    static void a(ForgotPasswordInputView forgotpasswordinputview)
    {
        forgotpasswordinputview.a();
    }

    private void b()
    {
        if (mListener != null)
        {
            mListener.a(mViews.email.getText().toString());
        }
    }

    static void b(ForgotPasswordInputView forgotpasswordinputview)
    {
        forgotpasswordinputview.b();
    }

    private boolean c()
    {
        return h.i(mViews.email.getText().toString());
    }

    static boolean c(ForgotPasswordInputView forgotpasswordinputview)
    {
        return forgotpasswordinputview.c();
    }

    private void d()
    {
        mViews.error.setErrorState(getResources().getString(0x7f090061));
        mViews.send.setEnabled(false);
    }

    static void d(ForgotPasswordInputView forgotpasswordinputview)
    {
        forgotpasswordinputview.e();
    }

    private void e()
    {
        mViews.error.b();
        mViews.send.setEnabled(true);
    }

    static void e(ForgotPasswordInputView forgotpasswordinputview)
    {
        forgotpasswordinputview.d();
    }

    public void a(String s, boolean flag)
    {
        if (!o.c(s))
        {
            mViews.email.setText(s);
            if (flag)
            {
                mViews.email.selectAll();
                return;
            }
        }
    }

    public void setOnResetRequestedListener(b b1)
    {
        mListener = b1;
    }

    static 
    {
        EMAIL = Patterns.EMAIL_ADDRESS;
    }
}
