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
import com.target.mothership.util.o;
import com.target.ui.util.validation.a;
import com.target.ui.util.validation.a.f;
import com.target.ui.view.CustomErrorViewWrapper;
import java.util.List;

// Referenced classes of package com.target.ui.view.account:
//            b

public class AccountCreationPasswordView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        CustomErrorViewWrapper error;
        EditText input;

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

        final AccountCreationPasswordView this$0;
        private boolean wasValid;

        public void a(Editable editable)
        {
            editable = AccountCreationPasswordView.b(AccountCreationPasswordView.this);
            boolean flag = ((f) (editable)).isValid;
            if (wasValid != flag)
            {
                com.target.ui.view.account.AccountCreationPasswordView.a(AccountCreationPasswordView.this, flag);
            }
            com.target.ui.view.account.AccountCreationPasswordView.a(AccountCreationPasswordView.this, editable);
        }

        public void a(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = AccountCreationPasswordView.b(AccountCreationPasswordView.this).isValid;
        }

        public void b(CharSequence charsequence, int i, int j, int k)
        {
        }

        private b()
        {
            this$0 = AccountCreationPasswordView.this;
            super();
        }

    }


    private final android.view.View.OnFocusChangeListener mFocusChangeListener;
    private com.target.ui.view.account.b mValidationListener;
    private Views mViews;

    public AccountCreationPasswordView(Context context)
    {
        super(context);
        mFocusChangeListener = new android.view.View.OnFocusChangeListener() {

            final AccountCreationPasswordView this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (!flag)
                {
                    com.target.ui.view.account.AccountCreationPasswordView.a(AccountCreationPasswordView.this);
                }
            }

            
            {
                this$0 = AccountCreationPasswordView.this;
                super();
            }
        };
        a(context);
    }

    public AccountCreationPasswordView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mFocusChangeListener = new _cls1();
        a(context);
    }

    public AccountCreationPasswordView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mFocusChangeListener = new _cls1();
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f030021, this);
        mViews = new Views(this);
        mViews.input.addTextChangedListener(new b());
        mViews.input.setOnFocusChangeListener(mFocusChangeListener);
    }

    static void a(AccountCreationPasswordView accountcreationpasswordview)
    {
        accountcreationpasswordview.b();
    }

    static void a(AccountCreationPasswordView accountcreationpasswordview, f f1)
    {
        accountcreationpasswordview.setErrorState(f1);
    }

    static void a(AccountCreationPasswordView accountcreationpasswordview, boolean flag)
    {
        accountcreationpasswordview.a(flag);
    }

    private void a(boolean flag)
    {
        if (mValidationListener != null)
        {
            mValidationListener.a(this, flag);
        }
    }

    static f b(AccountCreationPasswordView accountcreationpasswordview)
    {
        return accountcreationpasswordview.c();
    }

    private void b()
    {
        setErrorState(c());
    }

    private f c()
    {
        return com.target.ui.util.validation.a.a(mViews.input.getText().toString());
    }

    private void setErrorState(f f1)
    {
        String s = mViews.input.getText().toString();
        boolean flag = f1.isValid;
        boolean flag1 = mViews.input.hasFocus();
        boolean flag2 = o.c(s);
        if (flag2 && flag1)
        {
            mViews.error.b();
        } else
        {
            if (flag2 && !flag1)
            {
                mViews.error.setErrorState(getResources().getString(0x7f090060));
                return;
            }
            if (!flag1 && !flag)
            {
                setErrorText(f1.reasons);
                return;
            }
            flag2 = mViews.error.a();
            if (flag1 && !flag && flag2)
            {
                setErrorText(f1.reasons);
                return;
            }
            if (flag)
            {
                mViews.error.b();
                return;
            }
        }
    }

    private void setErrorText(List list)
    {
        if (list != null && !list.isEmpty())
        {
            Resources resources = getResources();
            if (list.contains(com.target.ui.util.validation.a.f.a.TOO_SHORT))
            {
                mViews.error.setErrorState(resources.getString(0x7f090069));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.f.a.TOO_LONG))
            {
                mViews.error.setErrorState(resources.getString(0x7f090067));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.f.a.REQ_NO_GREATERTHAN_LESSTHAN))
            {
                mViews.error.setErrorState(resources.getString(0x7f090068));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.f.a.REQ_CAP_NUM_SPECIAL))
            {
                mViews.error.setErrorState(resources.getString(0x7f09006a));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.f.a.REQ_NOT_ALL_NUMBERS))
            {
                mViews.error.setErrorState(resources.getString(0x7f090065));
                return;
            }
            if (list.contains(com.target.ui.util.validation.a.f.a.REQ_NOT_ALL_SPECIAL_CHARS))
            {
                mViews.error.setErrorState(resources.getString(0x7f090066));
                return;
            }
        }
    }

    public void a(a a1)
    {
        f f1 = c();
        if (f1.isValid)
        {
            a1.a(f1.password);
        } else
        {
            a1.a();
        }
        setErrorState(f1);
    }

    public boolean a()
    {
        return com.target.ui.util.validation.a.a(mViews.input.getText().toString()).isValid;
    }

    public void setInputValidationListener(com.target.ui.view.account.b b1)
    {
        mValidationListener = b1;
    }
}
