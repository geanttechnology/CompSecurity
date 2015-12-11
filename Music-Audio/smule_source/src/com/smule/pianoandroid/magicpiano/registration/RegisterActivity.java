// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.smule.android.c.a;
import com.smule.android.c.ab;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.ag;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;
import com.smule.pianoandroid.utils.z;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            RegistrationEntryActivity, NewAccountFlow, LoginActivity

public class RegisterActivity extends ag
    implements ab
{

    private static final String c = com/smule/pianoandroid/magicpiano/registration/RegisterActivity.getName();
    private static String g;
    private static Boolean h = Boolean.valueOf(false);
    EditText a;
    Button b;
    private android.view.View.OnClickListener d;
    private android.view.View.OnClickListener e;
    private Dialog f;
    private String i;

    public RegisterActivity()
    {
    }

    static void a(RegisterActivity registeractivity)
    {
        registeractivity.c();
    }

    static Dialog b(RegisterActivity registeractivity)
    {
        return registeractivity.f;
    }

    private void c()
    {
        startActivity(com.smule.pianoandroid.magicpiano.registration.RegistrationEntryActivity.a(this, false, true, null, null, i));
        finish();
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        return "RegisterNewEmail";
    }

    public void onBackPressed()
    {
        c();
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03005e);
        i = getIntent().getStringExtra("SIGN_IN_TITLE");
        ((TextView)findViewById(0x7f0a0037)).setTypeface(z.a(this));
        ((TextView)findViewById(0x7f0a00ba)).setTypeface(z.b(this));
        Object obj = (Button)findViewById(0x7f0a00bc);
        ((Button) (obj)).setTypeface(z.c(this));
        ((Button) (obj)).setOnClickListener(new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
                com.smule.pianoandroid.magicpiano.registration.RegisterActivity.a(a);
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        });
        a = (EditText)findViewById(0x7f0a00b9);
        a.setTypeface(z.e(this));
        obj = getIntent().getStringExtra("email_param");
        if (obj != null)
        {
            a.setText(((CharSequence) (obj)));
        }
        a.requestFocus();
        n.a(this, a);
        b = (Button)findViewById(0x7f0a01f2);
        b.setTypeface(z.c(this));
        b.setOnClickListener(new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
                if ((new NewAccountFlow(a)).a(a.a.getText().toString(), null))
                {
                    a.b.setEnabled(false);
                }
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        });
        d = new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
                view = new Intent(a, com/smule/pianoandroid/magicpiano/registration/LoginActivity);
                view.putExtra("param_email", a.a.getText().toString());
                a.startActivity(view);
                a.finish();
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        };
        e = new android.view.View.OnClickListener() {

            final RegisterActivity a;

            public void onClick(View view)
            {
                RegisterActivity.b(a).dismiss();
                a.a.setText("");
            }

            
            {
                a = RegisterActivity.this;
                super();
            }
        };
        if (bundle != null) goto _L2; else goto _L1
_L1:
        g = null;
_L4:
        o.a(a, b);
        com.smule.android.c.a.k();
        return;
_L2:
        if (g != null)
        {
            f = o.a(this, g, a.getText().toString(), d, e);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onPause()
    {
        super.onPause();
        MagicApplication.getInstance().onPause();
    }

    protected void onResume()
    {
        super.onResume();
        MagicApplication.getInstance().onResume();
    }

    protected void onStart()
    {
        super.onStart();
        if (!isFinishing())
        {
            MagicApplication.onActivityStart(this);
        }
    }

    protected void onStop()
    {
        super.onStop();
        if (!isFinishing())
        {
            MagicApplication.onActivityStop(this);
        }
    }

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        if (flag)
        {
            b.setClickable(true);
        }
    }

}
