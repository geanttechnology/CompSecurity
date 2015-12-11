// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.smule.android.c.a;
import com.smule.android.c.aa;
import com.smule.android.c.ab;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.UserManager;
import com.smule.android.network.managers.ar;
import com.smule.android.network.managers.at;
import com.smule.android.network.managers.aw;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.ag;
import com.smule.pianoandroid.magicpiano.b.j;
import com.smule.pianoandroid.magicpiano.b.k;
import com.smule.pianoandroid.magicpiano.c;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.z;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            RegistrationEntryActivity, b, e, NewHandleActivity, 
//            ForgotPasswordActivity, NewAccountFlow

public class LoginActivity extends ag
    implements ab, com.smule.android.network.managers.UserManager.AccountIconResponseCallback, k
{

    private static final String b = com/smule/pianoandroid/magicpiano/registration/LoginActivity.getName();
    private static Boolean g = Boolean.valueOf(false);
    private static Boolean j = Boolean.valueOf(false);
    Boolean a;
    private EditText c;
    private EditText d;
    private Button e;
    private com.smule.pianoandroid.magicpiano.registration.b f;
    private boolean h;
    private Dialog i;
    private android.view.View.OnClickListener k;
    private android.view.View.OnClickListener l;
    private String m;
    private Boolean n;

    public LoginActivity()
    {
        h = false;
        n = Boolean.valueOf(false);
        a = Boolean.valueOf(false);
    }

    static Dialog a(LoginActivity loginactivity, Dialog dialog)
    {
        loginactivity.i = dialog;
        return dialog;
    }

    static void a(LoginActivity loginactivity)
    {
        loginactivity.d();
    }

    static EditText b(LoginActivity loginactivity)
    {
        return loginactivity.c;
    }

    static EditText c(LoginActivity loginactivity)
    {
        return loginactivity.d;
    }

    private void c()
    {
        Object obj = getIntent().getData();
        if (obj != null)
        {
            String s = ((Uri) (obj)).getQueryParameter("email");
            obj = ((Uri) (obj)).getQueryParameter("password");
            if (s != null)
            {
                c.setText(s);
            }
            if (obj != null)
            {
                d.setText(((CharSequence) (obj)));
            }
            if (s != null && obj != null)
            {
                h = false;
                if (a.booleanValue())
                {
                    e();
                    return;
                } else
                {
                    h = true;
                    return;
                }
            }
        }
    }

    private void d()
    {
        startActivity(com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(this, false, true, null, null, m));
        finish();
    }

    static void d(LoginActivity loginactivity)
    {
        loginactivity.e();
    }

    static com.smule.pianoandroid.magicpiano.registration.b e(LoginActivity loginactivity)
    {
        return loginactivity.f;
    }

    private void e()
    {
        if (n.booleanValue())
        {
            return;
        } else
        {
            n = Boolean.valueOf(true);
            String s = getResources().getString(0x7f0c016c);
            f = new com.smule.pianoandroid.magicpiano.registration.b(this);
            f.a(s, b);
            (new j(this, this, c.getText().toString(), d.getText().toString())).execute(new Void[0]);
            return;
        }
    }

    static android.view.View.OnClickListener f(LoginActivity loginactivity)
    {
        return loginactivity.k;
    }

    static android.view.View.OnClickListener g(LoginActivity loginactivity)
    {
        return loginactivity.l;
    }

    public void a(aw aw1)
    {
        n = Boolean.valueOf(false);
        if (aw1 != null && aw1.a != null && aw1.a.a == p.a)
        {
            switch (aw1.a.b)
            {
            default:
                f.a(0x7f0c016e);
                com.smule.android.network.core.b.a(aw1.a);
                return;

            case 0: // '\0'
                f.a();
                ar.a();
                ar.a(Boolean.valueOf(true), this);
                ar.a().a(this, true);
                com.smule.pianoandroid.magicpiano.registration.e.c();
                if (aw1.o.booleanValue())
                {
                    startActivity(new Intent(this, com/smule/pianoandroid/magicpiano/registration/NewHandleActivity));
                    finish();
                    return;
                } else
                {
                    com.smule.pianoandroid.magicpiano.registration.e.a(this);
                    return;
                }

            case 69: // 'E'
                UserManager.n().a(c.getText().toString(), this);
                return;
            }
        } else
        {
            f.f();
            return;
        }
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        return "RegisterExistingAccount";
    }

    public void handleResponse(at at1)
    {
        runOnUiThread(new Runnable(at1) {

            final at a;
            final LoginActivity b;

            public void run()
            {
                if (a != null && a.a.a())
                {
                    LoginActivity.e(b).a(0x7f0c0147);
                    return;
                }
                if (a != null && (a.a.b == 1012 || a.a.b == 65))
                {
                    LoginActivity.e(b).a();
                    com.smule.pianoandroid.magicpiano.registration.LoginActivity.a(b, com.smule.pianoandroid.utils.o.a(b, com.smule.pianoandroid.magicpiano.registration.LoginActivity.b(b).getText().toString(), LoginActivity.f(b), LoginActivity.g(b)));
                    return;
                } else
                {
                    com.smule.android.network.core.b.a(a.a);
                    LoginActivity.e(b).f();
                    return;
                }
            }

            
            {
                b = LoginActivity.this;
                a = at1;
                super();
            }
        });
    }

    public volatile void handleResponse(Object obj)
    {
        handleResponse((at)obj);
    }

    public void onBackPressed()
    {
        d();
        if (i != null)
        {
            i.dismiss();
            i = null;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        q = false;
        super.onCreate(bundle);
        setContentView(0x7f03003c);
        if (isFinishing())
        {
            return;
        }
        m = getIntent().getStringExtra("SIGN_IN_TITLE");
        Object obj = (Button)findViewById(0x7f0a00bc);
        ((Button) (obj)).setTypeface(z.c(this));
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final LoginActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.registration.LoginActivity.a(a);
            }

            
            {
                a = LoginActivity.this;
                super();
            }
        });
        ((TextView)findViewById(0x7f0a0037)).setTypeface(z.a(this));
        ((TextView)findViewById(0x7f0a00ba)).setTypeface(z.b(this));
        ((TextView)findViewById(0x7f0a0137)).setTypeface(z.b(this));
        c = (EditText)findViewById(0x7f0a00b9);
        c.setTypeface(z.e(this));
        c.requestFocus();
        com.smule.pianoandroid.utils.n.a(this, c);
        d = (EditText)findViewById(0x7f0a0136);
        d.setTypeface(z.e(this));
        e = (Button)findViewById(0x7f0a0135);
        e.setTypeface(z.c(this));
        e.setOnClickListener(new android.view.View.OnClickListener() {

            final LoginActivity a;

            public void onClick(View view)
            {
                if (!com.smule.pianoandroid.utils.ab.a(com.smule.pianoandroid.magicpiano.registration.LoginActivity.b(a).getText().toString()))
                {
                    MagicApplication.getInstance().showToast(a.getResources().getString(0x7f0c00e4), 0);
                    return;
                }
                if (com.smule.pianoandroid.magicpiano.registration.LoginActivity.c(a).getText().length() < 6)
                {
                    MagicApplication.getInstance().showToast(a.getResources().getString(0x7f0c01cc), 0);
                    return;
                } else
                {
                    LoginActivity.d(a);
                    return;
                }
            }

            
            {
                a = LoginActivity.this;
                super();
            }
        });
        obj = (TextView)findViewById(0x7f0a0138);
        ((TextView) (obj)).setTypeface(z.e(this));
        ((TextView) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final LoginActivity a;

            public void onClick(View view)
            {
                view = new Intent(a, com/smule/pianoandroid/magicpiano/registration/ForgotPasswordActivity);
                String s = com.smule.pianoandroid.magicpiano.registration.LoginActivity.b(a).getText().toString();
                if (s != null)
                {
                    view.putExtra("EMAIL", s);
                }
                a.startActivity(view);
                a.finish();
            }

            
            {
                a = LoginActivity.this;
                super();
            }
        });
        obj = getIntent().getStringExtra("param_email");
        if (obj != null && !TextUtils.isEmpty(((CharSequence) (obj))))
        {
            c.setText(((CharSequence) (obj)));
            d.requestFocus();
            com.smule.pianoandroid.utils.n.a(this, d);
        }
        k = new android.view.View.OnClickListener() {

            final LoginActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.registration.LoginActivity.a(a, null);
            }

            
            {
                a = LoginActivity.this;
                super();
            }
        };
        l = new android.view.View.OnClickListener() {

            final LoginActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.registration.LoginActivity.a(a, null);
                (new NewAccountFlow(a)).a(com.smule.pianoandroid.magicpiano.registration.LoginActivity.b(a).getText().toString(), com.smule.pianoandroid.magicpiano.registration.LoginActivity.c(a).getText().toString());
            }

            
            {
                a = LoginActivity.this;
                super();
            }
        };
        if (bundle != null)
        {
            g = Boolean.valueOf(bundle.getBoolean("dismiss_dialog", false));
            if (g.booleanValue())
            {
                bundle = getFragmentManager().findFragmentByTag(b);
                if (bundle != null)
                {
                    ((c)bundle).dismiss();
                }
                g = Boolean.valueOf(false);
            }
            if (j.booleanValue())
            {
                i = com.smule.pianoandroid.utils.o.a(this, c.getText().toString(), k, l);
                j = null;
            }
        } else
        {
            g = Boolean.valueOf(false);
            j = Boolean.valueOf(false);
        }
        c();
        com.smule.pianoandroid.utils.o.a(c, d, e);
        com.smule.android.c.a.m();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        aa.a(b, (new StringBuilder()).append("onNewIntent : ").append(intent.getData()).toString());
        c();
    }

    protected void onPause()
    {
        super.onPause();
        a = Boolean.valueOf(false);
        MagicApplication.getInstance().onPause();
    }

    protected void onResume()
    {
        super.onResume();
        a = Boolean.valueOf(true);
        MagicApplication.getInstance().onResume();
        if (h)
        {
            e();
            h = false;
        }
    }

    protected void onStart()
    {
        super.onStart();
        MagicApplication.onActivityStart(this);
    }

    protected void onStop()
    {
        super.onStop();
        MagicApplication.onActivityStop(this);
    }

}
