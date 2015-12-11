// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.target.ui.util.validation.h;
import com.target.ui.view.CustomErrorViewWrapper;

// Referenced classes of package com.target.ui.view.account:
//            b

public class AccountCreationEmailView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        EditText email;
        CustomErrorViewWrapper error;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(String s);
    }

    private final class b extends com.target.ui.k.b
    {

        final AccountCreationEmailView this$0;
        private boolean wasValid;

        public void a(Editable editable)
        {
            boolean flag = AccountCreationEmailView.c(AccountCreationEmailView.this);
            if (wasValid != flag)
            {
                AccountCreationEmailView.a(AccountCreationEmailView.this, flag);
            }
            AccountCreationEmailView.b(AccountCreationEmailView.this, flag);
        }

        public void a(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = AccountCreationEmailView.c(AccountCreationEmailView.this);
        }

        public void b(CharSequence charsequence, int i, int j, int k)
        {
        }

        private b()
        {
            this$0 = AccountCreationEmailView.this;
            super();
        }

    }


    private final android.view.View.OnFocusChangeListener mFocusChangeListener;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public AccountCreationEmailView(Context context)
    {
        super(context);
        mFocusChangeListener = new android.view.View.OnFocusChangeListener() {

            final AccountCreationEmailView this$0;

            public void onFocusChange(View view, boolean flag)
            {
                while (view.getId() != AccountCreationEmailView.a(AccountCreationEmailView.this).email.getId() || flag) 
                {
                    return;
                }
                AccountCreationEmailView.b(AccountCreationEmailView.this);
            }

            
            {
                this$0 = AccountCreationEmailView.this;
                super();
            }
        };
        a(context);
    }

    public AccountCreationEmailView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFocusChangeListener = new _cls1();
        a(context);
    }

    public AccountCreationEmailView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mFocusChangeListener = new _cls1();
        a(context);
    }

    static Views a(AccountCreationEmailView accountcreationemailview)
    {
        return accountcreationemailview.mViews;
    }

    private void a(Context context)
    {
        inflate(context, 0x7f03001e, this);
        mViews = new Views(this);
        mViews.email.setOnFocusChangeListener(mFocusChangeListener);
        mViews.email.addTextChangedListener(new b());
    }

    static void a(AccountCreationEmailView accountcreationemailview, boolean flag)
    {
        accountcreationemailview.a(flag);
    }

    private void a(boolean flag)
    {
        if (mValidationListener == null)
        {
            return;
        } else
        {
            mValidationListener.a(this, flag);
            return;
        }
    }

    private void b()
    {
        setErrorState(c());
    }

    static void b(AccountCreationEmailView accountcreationemailview)
    {
        accountcreationemailview.b();
    }

    static void b(AccountCreationEmailView accountcreationemailview, boolean flag)
    {
        accountcreationemailview.setErrorState(flag);
    }

    private boolean c()
    {
        return h.i(mViews.email.getText().toString());
    }

    static boolean c(AccountCreationEmailView accountcreationemailview)
    {
        return accountcreationemailview.c();
    }

    private void setErrorState(boolean flag)
    {
        String s = mViews.email.getText().toString();
        if (s != null)
        {
            if (s.isEmpty())
            {
                mViews.error.b();
                return;
            }
            boolean flag1 = mViews.email.hasFocus();
            if (flag)
            {
                mViews.error.b();
                return;
            }
            if (!flag1)
            {
                mViews.error.setErrorState(getResources().getString(0x7f090061));
                return;
            }
        }
    }

    public void a(a a1)
    {
        if (a1 == null)
        {
            return;
        }
        boolean flag = c();
        if (!flag)
        {
            a1.a();
        } else
        {
            a1.a(mViews.email.getText().toString());
        }
        setErrorState(flag);
    }

    public boolean a()
    {
        return h.i(mViews.email.getText().toString());
    }

    public void setEmail(String s)
    {
        mViews.email.setText(s);
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }
}
