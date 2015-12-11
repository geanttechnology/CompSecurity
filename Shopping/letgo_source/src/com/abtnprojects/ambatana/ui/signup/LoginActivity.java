// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.ii;
import android.support.v7.iv;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.ui.widgets.RevealablePasswordContainer;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            l, e, d, m, 
//            h, i

public class LoginActivity extends l
    implements e, com.abtnprojects.ambatana.ui.widgets.RevealablePasswordContainer.a
{

    AutoCompleteTextView acTvUserName;
    EditText etPassword;
    Button mCreateAccountButton;
    private boolean n;
    RevealablePasswordContainer revealablePasswordContainer;
    private ii x;
    private String y;
    private String z;

    public LoginActivity()
    {
    }

    private void t()
    {
        a(getString(0x7f0900c6), getString(0x7f0900c5));
    }

    private void u()
    {
        acTvUserName.setError(null);
        etPassword.setError(null);
    }

    private void v()
    {
        y = acTvUserName.getText().toString();
        z = etPassword.getText().toString();
        if (c(z) && e(y))
        {
            mCreateAccountButton.setEnabled(true);
            return;
        } else
        {
            mCreateAccountButton.setEnabled(false);
            return;
        }
    }

    void k()
    {
        o = new d(this, p, t, u);
        o.b(this);
    }

    void l()
    {
        n = x.a();
        if (n)
        {
            o();
            return;
        } else
        {
            t();
            return;
        }
    }

    public void m()
    {
        s();
        a(getString(0x7f0900c8), getString(0x7f0900c7));
    }

    public void n()
    {
        s();
    }

    public void o()
    {
        Object obj1 = null;
        boolean flag1 = true;
        u();
        y = acTvUserName.getText().toString();
        z = etPassword.getText().toString();
        Object obj;
        boolean flag;
        if (TextUtils.isEmpty(z))
        {
            etPassword.setError(getString(0x7f09006a));
            obj = etPassword;
            flag = true;
        } else
        if (z.length() < 4)
        {
            etPassword.setError(getString(0x7f0900c3, new Object[] {
                Integer.valueOf(4)
            }));
            obj = etPassword;
            flag = true;
        } else
        {
            flag = false;
            obj = null;
        }
        if (!TextUtils.isEmpty(y)) goto _L2; else goto _L1
_L1:
        acTvUserName.setError(getString(0x7f09006a));
        obj = acTvUserName;
        flag = flag1;
_L4:
        if (flag)
        {
            ((View) (obj)).requestFocus();
            return;
        }
        break; /* Loop/switch isn't completed */
_L2:
        if (!Patterns.EMAIL_ADDRESS.matcher(y).matches())
        {
            acTvUserName.setError(getString(0x7f090198));
            obj = acTvUserName;
            flag = flag1;
        }
        if (true) goto _L4; else goto _L3
_L3:
        c(0x7f0900c9);
        if (getIntent() == null)
        {
            obj = obj1;
        } else
        {
            obj = getIntent().getExtras();
        }
        o.a(y.toLowerCase(Locale.getDefault()), z, new h(((Bundle) (obj))), this);
        return;
    }

    void onAfterTextChanged()
    {
        v();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040051);
        p();
        x = new ii(getApplicationContext());
        ButterKnife.bind(this);
        k();
        a(acTvUserName);
        revealablePasswordContainer.setPasswordChangeListener(this);
        r();
    }

    protected void onDestroy()
    {
        s();
        iv.a(q);
        super.onDestroy();
    }

    boolean onFinishEditPassword(int j)
    {
        if (j == 6)
        {
            l();
            return true;
        } else
        {
            return false;
        }
    }

    void onForgotPasswordClicked()
    {
        p.c();
    }

    void onSendButtonClicked()
    {
        l();
    }

    protected void onStop()
    {
        super.onStop();
        s();
        iv.a(q);
    }

    protected void p()
    {
        super.p();
        v.setNavigationIcon(0x7f0200d1);
    }

    public void q()
    {
        v();
    }
}
