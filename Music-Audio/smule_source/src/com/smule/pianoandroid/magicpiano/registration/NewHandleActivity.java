// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.smule.android.c.a;
import com.smule.android.c.ab;
import com.smule.android.network.core.b;
import com.smule.android.network.managers.UserManager;
import com.smule.pianoandroid.magicpiano.MagicApplication;
import com.smule.pianoandroid.magicpiano.ag;
import com.smule.pianoandroid.magicpiano.b.r;
import com.smule.pianoandroid.magicpiano.b.s;
import com.smule.pianoandroid.utils.n;
import com.smule.pianoandroid.utils.o;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            b, e

public class NewHandleActivity extends ag
    implements ab, s
{

    private static final String b = com/smule/pianoandroid/magicpiano/registration/NewHandleActivity.getName();
    Boolean a;
    private EditText c;
    private Button d;
    private com.smule.pianoandroid.magicpiano.registration.b e;
    private Boolean f;

    public NewHandleActivity()
    {
        f = null;
        a = Boolean.valueOf(false);
    }

    static EditText a(NewHandleActivity newhandleactivity)
    {
        return newhandleactivity.c;
    }

    static com.smule.pianoandroid.magicpiano.registration.b a(NewHandleActivity newhandleactivity, com.smule.pianoandroid.magicpiano.registration.b b1)
    {
        newhandleactivity.e = b1;
        return b1;
    }

    static com.smule.pianoandroid.magicpiano.registration.b b(NewHandleActivity newhandleactivity)
    {
        return newhandleactivity.e;
    }

    static String c()
    {
        return b;
    }

    public void a(com.smule.android.network.core.o o1, Boolean boolean1, int i)
    {
        if (boolean1.booleanValue())
        {
            com.smule.android.c.a.l();
            if (e != null)
            {
                e.a();
            }
            if (f != null)
            {
                o.b(this, f.booleanValue(), new Runnable() {

                    final NewHandleActivity a;

                    public void run()
                    {
                        com.smule.pianoandroid.magicpiano.registration.e.a(a);
                    }

            
            {
                a = NewHandleActivity.this;
                super();
            }
                });
                return;
            } else
            {
                com.smule.pianoandroid.magicpiano.registration.e.a(this);
                return;
            }
        }
        if (i == -1)
        {
            boolean1 = getResources().getString(0x7f0c02c4);
            com.smule.android.network.core.b.a(o1);
            o1 = boolean1;
        } else
        {
            o1 = getResources().getString(i);
        }
        e.a(o1);
    }

    public boolean a()
    {
        return true;
    }

    public String b()
    {
        return b;
    }

    public void onBackPressed()
    {
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03004a);
        c = (EditText)findViewById(0x7f0a017d);
        bundle = getIntent().getStringExtra("param_handle");
        if (getIntent().hasExtra("param_fb_reward"))
        {
            f = Boolean.valueOf(getIntent().getBooleanExtra("param_fb_reward", false));
        }
        if (bundle == null) goto _L2; else goto _L1
_L1:
        c.setText(bundle);
_L4:
        if (bundle.length() > 0)
        {
            c.setSelection(bundle.length());
        }
        c.requestFocus();
        n.a(this, c);
        d = (Button)findViewById(0x7f0a017a);
        d.setOnClickListener(new android.view.View.OnClickListener() {

            final NewHandleActivity a;

            public void onClick(View view)
            {
                if (com.smule.pianoandroid.magicpiano.registration.NewHandleActivity.a(a).getText().toString().length() < 2)
                {
                    MagicApplication.getInstance().showToast(a.getString(0x7f0c0136), 0);
                    return;
                }
                if (com.smule.pianoandroid.magicpiano.registration.NewHandleActivity.a(a).getText().toString().equals(UserManager.n().e()))
                {
                    view = a.getResources().getString(0x7f0c023f);
                    com.smule.pianoandroid.magicpiano.registration.NewHandleActivity.a(a, new com.smule.pianoandroid.magicpiano.registration.b(a));
                    com.smule.pianoandroid.magicpiano.registration.NewHandleActivity.b(a).a(view, NewHandleActivity.c());
                    (new Handler()).postDelayed(new Runnable(this) {

                        final _cls1 a;

                        public void run()
                        {
                            a.a.a(null, Boolean.valueOf(true), 0);
                        }

            
            {
                a = _pcls1;
                super();
            }
                    }, 1000L);
                    return;
                } else
                {
                    view = a.getResources().getString(0x7f0c023f);
                    com.smule.pianoandroid.magicpiano.registration.NewHandleActivity.a(a, new com.smule.pianoandroid.magicpiano.registration.b(a));
                    com.smule.pianoandroid.magicpiano.registration.NewHandleActivity.b(a).a(view, NewHandleActivity.c());
                    (new r(com.smule.pianoandroid.magicpiano.registration.NewHandleActivity.a(a).getText().toString(), "", "", null, a)).execute(new Void[0]);
                    return;
                }
            }

            
            {
                a = NewHandleActivity.this;
                super();
            }
        });
        o.a(c, d);
        com.smule.android.c.a.n();
        return;
_L2:
        String s1 = UserManager.n().e();
        bundle = s1;
        if (s1 != null)
        {
            c.setText(s1);
            bundle = s1;
        }
        if (true) goto _L4; else goto _L3
_L3:
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
