// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.smule.android.c.a;
import com.smule.android.c.aa;
import com.smule.android.network.core.NetworkResponseCallback;
import com.smule.android.network.core.b;
import com.smule.android.network.core.o;
import com.smule.android.network.core.p;
import com.smule.android.network.managers.UserManager;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.ag;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.z;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            b, LoginActivity, NewAccountFlow

public class ForgotPasswordActivity extends ag
{

    private static final String d = com/smule/pianoandroid/magicpiano/registration/ForgotPasswordActivity.getName();
    EditText a;
    com.smule.pianoandroid.magicpiano.registration.b b;
    Dialog c;

    public ForgotPasswordActivity()
    {
    }

    private void a()
    {
        b = new com.smule.pianoandroid.magicpiano.registration.b(this);
        b.a(getString(0x7f0c0056), "");
        Handler handler = new Handler();
        UserManager.n().a(a.getText().toString(), new NetworkResponseCallback(handler) {

            final Handler a;
            final ForgotPasswordActivity b;

            public void handleResponse(o o1)
            {
                Runnable runnable = new Runnable(this, o1) {

                    final o a;
                    final _cls3 b;

                    public void run()
                    {
                        com.smule.pianoandroid.magicpiano.registration.ForgotPasswordActivity.a(b.b, a);
                    }

            
            {
                b = _pcls3;
                a = o1;
                super();
            }
                };
                if (!o1.a())
                {
                    a.post(runnable);
                    return;
                } else
                {
                    a.post(new Runnable(this, runnable) {

                        final Runnable a;
                        final _cls3 b;

                        public void run()
                        {
                            b.b.b.b(b.b.getString(0x7f0c00e9));
                            b.a.postDelayed(a, 2000L);
                        }

            
            {
                b = _pcls3;
                a = runnable;
                super();
            }
                    });
                    return;
                }
            }

            public volatile void handleResponse(Object obj)
            {
                handleResponse((o)obj);
            }

            
            {
                b = ForgotPasswordActivity.this;
                a = handler;
                super();
            }
        });
    }

    private void a(o o1)
    {
        if (o1.a != p.a)
        {
            b.f();
            return;
        }
        if (o1.a())
        {
            com.smule.android.c.a.e();
            aa.c(d, "Email found!");
            b.a();
            b();
            return;
        }
        if (o1.b == 65)
        {
            aa.c(d, "Email not found!");
            b.a();
            c();
            return;
        } else
        {
            b.g();
            com.smule.android.network.core.b.a(o1);
            return;
        }
    }

    static void a(ForgotPasswordActivity forgotpasswordactivity)
    {
        forgotpasswordactivity.b();
    }

    static void a(ForgotPasswordActivity forgotpasswordactivity, o o1)
    {
        forgotpasswordactivity.a(o1);
    }

    private void b()
    {
        Intent intent = new Intent(this, com/smule/pianoandroid/magicpiano/registration/LoginActivity);
        intent.putExtra("param_email", a.getText().toString());
        startActivity(intent);
        finish();
    }

    static void b(ForgotPasswordActivity forgotpasswordactivity)
    {
        forgotpasswordactivity.a();
    }

    private void c()
    {
        c = com.smule.pianoandroid.utils.o.a(this, a.getText().toString(), new android.view.View.OnClickListener() {

            final ForgotPasswordActivity a;

            public void onClick(View view)
            {
                a.c = null;
            }

            
            {
                a = ForgotPasswordActivity.this;
                super();
            }
        }, new android.view.View.OnClickListener() {

            final ForgotPasswordActivity a;

            public void onClick(View view)
            {
                a.c = null;
                (new NewAccountFlow(a)).a(a.a.getText().toString(), null);
            }

            
            {
                a = ForgotPasswordActivity.this;
                super();
            }
        });
    }

    public void onBackPressed()
    {
        b();
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag1 = true;
        super.onCreate(bundle);
        String s = getIntent().getStringExtra("EMAIL");
        if (bundle != null)
        {
            s = bundle.getString("EMAIL");
        }
        Button button;
        boolean flag;
        if (bundle != null && bundle.getBoolean("ALERT"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setContentView(0x7f03002c);
        bundle = findViewById(0x7f0a00b5);
        ((TextView)bundle.findViewById(0x7f0a0037)).setTypeface(z.a(this));
        ((TextView)bundle.findViewById(0x7f0a00ba)).setTypeface(z.b(this));
        button = (Button)bundle.findViewById(0x7f0a00bc);
        button.setTypeface(z.c(this));
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final ForgotPasswordActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.registration.ForgotPasswordActivity.a(a);
            }

            
            {
                a = ForgotPasswordActivity.this;
                super();
            }
        });
        button = (Button)bundle.findViewById(0x7f0a00bd);
        button.setTypeface(z.c(this));
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final ForgotPasswordActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.registration.ForgotPasswordActivity.b(a);
            }

            
            {
                a = ForgotPasswordActivity.this;
                super();
            }
        });
        if (s == null || TextUtils.isEmpty(s))
        {
            flag1 = false;
        }
        button.setEnabled(flag1);
        a = (EditText)bundle.findViewById(0x7f0a00b9);
        a.setTypeface(z.e(this));
        if (s != null)
        {
            a.setText(s);
        }
        if (flag)
        {
            c();
        } else
        {
            n.a(this, a);
        }
        com.smule.pianoandroid.utils.o.a(a, button);
        com.smule.android.c.a.d();
    }

    protected void onDestroy()
    {
        if (c != null)
        {
            c.dismiss();
            c = null;
        }
        super.onDestroy();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        bundle.putString("EMAIL", a.getText().toString());
        if (c != null)
        {
            bundle.putBoolean("ALERT", true);
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
