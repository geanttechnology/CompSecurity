// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import b.a.a.a.a;
import b.a.a.a.b;
import b.a.a.a.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            bb

public final class TrialSubsActivity_ extends bb
    implements a, b
{

    private final c f = new c();

    public TrialSubsActivity_()
    {
    }

    private void a(Bundle bundle)
    {
        c.a(this);
        e();
    }

    private void e()
    {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null)
        {
            if (bundle.containsKey("SKU"))
            {
                d = bundle.getString("SKU");
            }
            if (bundle.containsKey("PRICE"))
            {
                e = bundle.getString("PRICE");
            }
        }
    }

    public void a(a a1)
    {
        a = (TextView)a1.findViewById(0x7f0a0242);
        c = (Button)a1.findViewById(0x7f0a0087);
        b = (Button)a1.findViewById(0x7f0a0243);
        if (c != null)
        {
            c.setOnClickListener(new android.view.View.OnClickListener() {

                final TrialSubsActivity_ a;

                public void onClick(View view)
                {
                    a.b();
                }

            
            {
                a = TrialSubsActivity_.this;
                super();
            }
            });
        }
        if (b != null)
        {
            b.setOnClickListener(new android.view.View.OnClickListener() {

                final TrialSubsActivity_ a;

                public void onClick(View view)
                {
                    a.a();
                }

            
            {
                a = TrialSubsActivity_.this;
                super();
            }
            });
        }
        c();
    }

    public void onCreate(Bundle bundle)
    {
        c c1 = c.a(f);
        a(bundle);
        super.onCreate(bundle);
        c.a(c1);
        setContentView(0x7f030074);
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (a() < 5 && i == 4 && keyevent.getRepeatCount() == 0)
        {
            onBackPressed();
        }
        return super.onKeyDown(i, keyevent);
    }

    public void setContentView(int i)
    {
        super.setContentView(i);
        f.a(this);
    }

    public void setContentView(View view)
    {
        super.setContentView(view);
        f.a(this);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
        f.a(this);
    }

    public void setIntent(Intent intent)
    {
        super.setIntent(intent);
        e();
    }
}
