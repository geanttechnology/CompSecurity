// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.abtnprojects.ambatana.ui.signup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.du;
import android.support.v7.ii;
import android.support.v7.iv;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.view.Window;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
import butterknife.ButterKnife;
import com.abtnprojects.ambatana.h;
import com.abtnprojects.ambatana.models.SignUpUserInfoBitmap;
import com.abtnprojects.ambatana.ui.widgets.NotifyScrollView;
import com.abtnprojects.ambatana.ui.widgets.RevealablePasswordContainer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.abtnprojects.ambatana.ui.signup:
//            l, k, m, j, 
//            h

public class SignUpActivity extends l
    implements com.abtnprojects.ambatana.ui.fragments.AddPhotoSelectSourceDialog.a, k, com.abtnprojects.ambatana.ui.widgets.RevealablePasswordContainer.a
{

    private Boolean A;
    private ii B;
    AutoCompleteTextView acTvEmail;
    Button createAccountButton;
    EditText etName;
    EditText etPassword;
    ImageView ivAvatar;
    private h n;
    NotifyScrollView notifyScrollView;
    RevealablePasswordContainer passwordContainer;
    ViewSwitcher vsAvatar;
    private String x;
    private String y;
    private String z;

    public SignUpActivity()
    {
        A = Boolean.valueOf(false);
    }

    private void o()
    {
        x = etName.getText().toString();
        y = acTvEmail.getText().toString();
        z = etPassword.getText().toString();
        if (c(z) && e(y) && d(x))
        {
            createAccountButton.setEnabled(true);
            return;
        } else
        {
            createAccountButton.setEnabled(false);
            return;
        }
    }

    private void t()
    {
        etName.setError(null);
        acTvEmail.setError(null);
        etPassword.setError(null);
    }

    private void u()
    {
        createAccountButton.setEnabled(false);
        t();
        Object obj = null;
        x = etName.getText().toString();
        y = acTvEmail.getText().toString();
        z = etPassword.getText().toString();
        android.graphics.Bitmap bitmap = n.a();
        boolean flag;
        if (TextUtils.isEmpty(z))
        {
            etPassword.setError(getString(0x7f09006a));
            obj = etPassword;
            flag = true;
        } else
        if (z.length() < 4)
        {
            etPassword.setError(getString(0x7f090199, new Object[] {
                Integer.valueOf(4)
            }));
            obj = etPassword;
            flag = true;
        } else
        {
            flag = false;
        }
        if (TextUtils.isEmpty(y))
        {
            acTvEmail.setError(getString(0x7f09006a));
            obj = acTvEmail;
            flag = true;
        } else
        if (!Patterns.EMAIL_ADDRESS.matcher(y).matches())
        {
            acTvEmail.setError(getString(0x7f090198));
            obj = acTvEmail;
            flag = true;
        }
        if (TextUtils.isEmpty(x))
        {
            etName.setError(getString(0x7f09006a));
            obj = etName;
            flag = true;
        }
        if (x.length() < 2)
        {
            etName.setError(getString(0x7f09019a, new Object[] {
                Integer.valueOf(2)
            }));
            obj = etName;
            flag = true;
        }
        if (flag)
        {
            createAccountButton.setEnabled(true);
            ((View) (obj)).requestFocus();
            return;
        } else
        {
            com.abtnprojects.ambatana.models.LetgoAddress letgoaddress = s.a();
            n();
            o.a(new SignUpUserInfoBitmap(y.toLowerCase(), z, x, bitmap), letgoaddress, this);
            return;
        }
    }

    private void v()
    {
        A = Boolean.valueOf(B.a());
        if (A.booleanValue())
        {
            u();
            return;
        } else
        {
            a(getString(0x7f09019c), getString(0x7f09019b));
            return;
        }
    }

    public void c_()
    {
        n.a(this);
    }

    public void d_()
    {
        n.b(this);
    }

    void k()
    {
        Bundle bundle;
        if (getIntent() == null)
        {
            bundle = null;
        } else
        {
            bundle = getIntent().getExtras();
        }
        o = new j(this, p, n, t, new com.abtnprojects.ambatana.ui.signup.h(bundle), u);
        o.b(this);
    }

    public void l()
    {
        s();
        createAccountButton.setEnabled(true);
        b(0x7f090197);
    }

    public void m()
    {
        s();
    }

    public void n()
    {
        c(0x7f09019d);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f040075);
        p();
        getWindow().setSoftInputMode(3);
        ButterKnife.bind(this);
        B = new ii(getApplicationContext());
        n = new h(this, vsAvatar, ivAvatar);
        passwordContainer.setPasswordChangeListener(this);
        k();
        a(acTvEmail);
        r();
    }

    protected void onDestroy()
    {
        iv.a(q);
        super.onDestroy();
    }

    boolean onFinishEditPassword(int i)
    {
        if (i == 6)
        {
            v();
            return true;
        } else
        {
            return false;
        }
    }

    void onSendButtonClicked()
    {
        v();
    }

    void onSignInTextChanged()
    {
        o();
    }

    protected void onStop()
    {
        super.onStop();
        s();
        iv.a(q);
    }

    void onUserImageClicked()
    {
        n.c();
    }

    protected void p()
    {
        super.p();
        v.setNavigationIcon(0x7f0200d1);
    }

    public void q()
    {
        o();
    }
}
