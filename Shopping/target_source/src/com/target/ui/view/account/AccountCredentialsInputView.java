// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.account;

import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Patterns;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.a.a.e;
import com.target.mothership.model.guest.interfaces.AccountDetails;
import com.target.mothership.model.guest.interfaces.Guest;
import com.target.mothership.util.o;
import com.target.ui.util.validation.h;
import com.target.ui.view.CustomErrorViewWrapper;
import java.util.regex.Pattern;

// Referenced classes of package com.target.ui.view.account:
//            b

public class AccountCredentialsInputView extends LinearLayout
{
    static class Views extends com.target.ui.view.a
    {

        EditText account;
        CustomErrorViewWrapper accountWrapper;
        EditText password;
        CustomErrorViewWrapper passwordWrapper;

        Views(View view)
        {
            super(view);
        }
    }

    public static interface a
    {

        public abstract void a();

        public abstract void a(String s, String s1);
    }

    private final class b extends com.target.ui.k.b
    {

        private CustomErrorViewWrapper input;
        final AccountCredentialsInputView this$0;
        private boolean wasValid;

        private void a(boolean flag)
        {
            if (AccountCredentialsInputView.c(AccountCredentialsInputView.this) != null)
            {
                AccountCredentialsInputView.c(AccountCredentialsInputView.this).a(AccountCredentialsInputView.this, flag);
            }
        }

        private void a(boolean flag, boolean flag1)
        {
            if (input.getId() == AccountCredentialsInputView.f(AccountCredentialsInputView.this).accountWrapper.getId())
            {
                AccountCredentialsInputView.a(AccountCredentialsInputView.this, flag);
            } else
            if (input.getId() == AccountCredentialsInputView.f(AccountCredentialsInputView.this).passwordWrapper.getId())
            {
                AccountCredentialsInputView.b(AccountCredentialsInputView.this, flag1);
                return;
            }
        }

        public void a(Editable editable)
        {
            boolean flag1 = AccountCredentialsInputView.d(AccountCredentialsInputView.this);
            boolean flag2 = com.target.ui.view.account.AccountCredentialsInputView.e(AccountCredentialsInputView.this);
            boolean flag;
            if (flag1 && flag2)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag != wasValid)
            {
                a(flag);
            }
            wasValid = flag;
            a(flag2, flag1);
        }

        public void a(CharSequence charsequence, int i, int j, int k)
        {
            wasValid = d();
        }

        public void b(CharSequence charsequence, int i, int j, int k)
        {
        }

        public b(CustomErrorViewWrapper customerrorviewwrapper)
        {
            this$0 = AccountCredentialsInputView.this;
            super();
            input = customerrorviewwrapper;
        }
    }

    public static interface c
        extends com.target.ui.view.account.b
    {

        public abstract void a(View view, String s, String s1);
    }

    public static interface d
    {

        public abstract void a(boolean flag);
    }


    private static final Pattern EMAIL;
    private static final String TAG = com/target/ui/view/account/AccountCredentialsInputView.getSimpleName();
    private final android.view.View.OnFocusChangeListener mEmailFocusChangeListener;
    private final android.view.ViewTreeObserver.OnGlobalFocusChangeListener mFocusChangeListener;
    private final a mImeActionInputRequester;
    private d mInputFocusListener;
    private final android.widget.TextView.OnEditorActionListener mSubmitListener;
    private c mValidationListener;
    private Views mViews;

    public AccountCredentialsInputView(Context context)
    {
        super(context);
        mEmailFocusChangeListener = new android.view.View.OnFocusChangeListener() {

            final AccountCredentialsInputView this$0;

            public void onFocusChange(View view, boolean flag)
            {
                if (!flag)
                {
                    AccountCredentialsInputView.a(AccountCredentialsInputView.this);
                }
            }

            
            {
                this$0 = AccountCredentialsInputView.this;
                super();
            }
        };
        mSubmitListener = new android.widget.TextView.OnEditorActionListener() {

            final AccountCredentialsInputView this$0;

            public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
            {
                if (i == 2)
                {
                    a(AccountCredentialsInputView.b(AccountCredentialsInputView.this));
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = AccountCredentialsInputView.this;
                super();
            }
        };
        mImeActionInputRequester = new a() {

            final AccountCredentialsInputView this$0;

            public void a()
            {
            }

            public void a(String s, String s1)
            {
                if (AccountCredentialsInputView.c(AccountCredentialsInputView.this) != null)
                {
                    AccountCredentialsInputView.c(AccountCredentialsInputView.this).a(AccountCredentialsInputView.this, s, s1);
                }
            }

            
            {
                this$0 = AccountCredentialsInputView.this;
                super();
            }
        };
        mFocusChangeListener = new android.view.ViewTreeObserver.OnGlobalFocusChangeListener() {

            final AccountCredentialsInputView this$0;

            public void onGlobalFocusChanged(View view, View view1)
            {
                AccountCredentialsInputView.a(AccountCredentialsInputView.this, view, view1);
            }

            
            {
                this$0 = AccountCredentialsInputView.this;
                super();
            }
        };
        a(context);
    }

    public AccountCredentialsInputView(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mEmailFocusChangeListener = new _cls1();
        mSubmitListener = new _cls2();
        mImeActionInputRequester = new _cls3();
        mFocusChangeListener = new _cls4();
        a(context);
    }

    public AccountCredentialsInputView(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        mEmailFocusChangeListener = new _cls1();
        mSubmitListener = new _cls2();
        mImeActionInputRequester = new _cls3();
        mFocusChangeListener = new _cls4();
        a(context);
    }

    private void a(Context context)
    {
        inflate(context, 0x7f0300fa, this);
        mViews = new Views(this);
        mViews.account.addTextChangedListener(new b(mViews.accountWrapper));
        mViews.account.setOnFocusChangeListener(mEmailFocusChangeListener);
        mViews.password.addTextChangedListener(new b(mViews.passwordWrapper));
        mViews.password.setImeOptions(2);
        mViews.password.setOnEditorActionListener(mSubmitListener);
        getViewTreeObserver().addOnGlobalFocusChangeListener(mFocusChangeListener);
    }

    private void a(View view, View view1)
    {
        int i = -1;
        if (mViews != null)
        {
            boolean flag;
            int j;
            if (view != null)
            {
                j = view.getId();
            } else
            {
                j = -1;
            }
            if (view1 != null)
            {
                i = view1.getId();
            }
            if (j == mViews.account.getId() || j == mViews.password.getId())
            {
                j = 1;
            } else
            {
                j = 0;
            }
            if (i == mViews.account.getId() || i == mViews.password.getId())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (j == 0 || !flag)
            {
                if (j == 0 && flag)
                {
                    a(true);
                    return;
                }
                if (j != 0 && !flag)
                {
                    a(false);
                    return;
                }
            }
        }
    }

    static void a(AccountCredentialsInputView accountcredentialsinputview)
    {
        accountcredentialsinputview.g();
    }

    static void a(AccountCredentialsInputView accountcredentialsinputview, View view, View view1)
    {
        accountcredentialsinputview.a(view, view1);
    }

    static void a(AccountCredentialsInputView accountcredentialsinputview, boolean flag)
    {
        accountcredentialsinputview.setAccountErrorState(flag);
    }

    private void a(boolean flag)
    {
        if (mInputFocusListener != null)
        {
            mInputFocusListener.a(flag);
        }
    }

    static a b(AccountCredentialsInputView accountcredentialsinputview)
    {
        return accountcredentialsinputview.mImeActionInputRequester;
    }

    static void b(AccountCredentialsInputView accountcredentialsinputview, boolean flag)
    {
        accountcredentialsinputview.setPasswordErrorState(flag);
    }

    static c c(AccountCredentialsInputView accountcredentialsinputview)
    {
        return accountcredentialsinputview.mValidationListener;
    }

    static boolean d(AccountCredentialsInputView accountcredentialsinputview)
    {
        return accountcredentialsinputview.f();
    }

    private boolean e()
    {
        return h.i(mViews.account.getText().toString());
    }

    static boolean e(AccountCredentialsInputView accountcredentialsinputview)
    {
        return accountcredentialsinputview.e();
    }

    static Views f(AccountCredentialsInputView accountcredentialsinputview)
    {
        return accountcredentialsinputview.mViews;
    }

    private boolean f()
    {
        return !o.e(mViews.password.getText().toString());
    }

    private void g()
    {
        setAccountErrorState(e());
    }

    private void setAccountErrorState(boolean flag)
    {
        boolean flag2 = mViews.account.hasFocus();
        boolean flag1;
        if (!flag && !mViews.account.getText().toString().isEmpty() && !flag2)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            mViews.accountWrapper.setErrorState(getResources().getString(0x7f090061));
        } else
        if (flag)
        {
            mViews.accountWrapper.b();
            return;
        }
    }

    private void setPasswordErrorState(boolean flag)
    {
        if (flag)
        {
            mViews.passwordWrapper.b();
            return;
        } else
        {
            mViews.passwordWrapper.setErrorState(getResources().getString(0x7f090060));
            return;
        }
    }

    public String a()
    {
        return mViews.account.getText().toString();
    }

    public void a(Guest guest)
    {
        if (guest == null || !guest.getAccountDetails().b())
        {
            return;
        } else
        {
            guest = ((AccountDetails)guest.getAccountDetails().c()).getEmailAddress();
            mViews.account.setText(guest);
            mViews.password.requestFocus();
            return;
        }
    }

    public void a(a a1)
    {
        if (a1 == null)
        {
            return;
        }
        boolean flag = e();
        boolean flag1 = f();
        if (flag && flag1)
        {
            a1.a(mViews.account.getText().toString(), mViews.password.getText().toString());
            return;
        } else
        {
            setAccountErrorState(flag);
            setPasswordErrorState(flag1);
            a1.a();
            return;
        }
    }

    public void b()
    {
        mViews.password.setText("");
    }

    public void c()
    {
        mViews.account.setEnabled(false);
    }

    public boolean d()
    {
        return e() && f();
    }

    public void setCredentialsValidationListener(c c1)
    {
        mValidationListener = c1;
    }

    public void setEmailAddress(String s)
    {
        if (o.g(s))
        {
            mViews.account.setText(s);
        }
    }

    public void setInputFocusListener(d d1)
    {
        mInputFocusListener = d1;
    }

    static 
    {
        EMAIL = Patterns.EMAIL_ADDRESS;
    }
}
