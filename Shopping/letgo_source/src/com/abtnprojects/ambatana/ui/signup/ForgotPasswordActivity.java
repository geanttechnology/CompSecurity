// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;
import butterknife.ButterKnife;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            l, c, m, b

public class ForgotPasswordActivity extends l
    implements c
{

    AutoCompleteTextView acTvEmail;
    Button btnSubmitPassword;
    String n;

    public ForgotPasswordActivity()
    {
        n = null;
    }

    private void q()
    {
        n = acTvEmail.getText().toString();
        o.a(n, this);
    }

    public void b(String s)
    {
        Toast.makeText(this, getString(0x7f090154, new Object[] {
            s
        }), 1).show();
    }

    void k()
    {
        o = new b(this, p, u);
        o.b(this);
    }

    public void l()
    {
        acTvEmail.setError(getString(0x7f090159));
    }

    public void m()
    {
        acTvEmail.setError(getString(0x7f09006a));
    }

    public void n()
    {
        b(0x7f090158);
    }

    public void o()
    {
        InputMethodManager inputmethodmanager = (InputMethodManager)getSystemService("input_method");
        View view1 = getCurrentFocus();
        View view = view1;
        if (view1 == null)
        {
            view = new View(this);
        }
        inputmethodmanager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    void onAfterTextChanged()
    {
        n = acTvEmail.getText().toString();
        if (e(n))
        {
            btnSubmitPassword.setEnabled(true);
            return;
        } else
        {
            btnSubmitPassword.setEnabled(false);
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040068);
        p();
        ButterKnife.bind(this);
        k();
        a(acTvEmail);
        r();
    }

    boolean onFinishEditPassword(int i)
    {
        if (i == 6)
        {
            q();
            return true;
        } else
        {
            return false;
        }
    }

    protected void onSubmitPasswordClicked()
    {
        q();
    }

    protected void p()
    {
        super.p();
        v.setNavigationIcon(0x7f0200d1);
    }
}
