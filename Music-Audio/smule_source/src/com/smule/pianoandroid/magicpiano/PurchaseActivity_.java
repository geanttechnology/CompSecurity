// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import b.a.a.a.a;
import b.a.a.a.b;
import b.a.a.a.c;

// Referenced classes of package com.smule.pianoandroid.magicpiano:
//            ap

public final class PurchaseActivity_ extends ap
    implements a, b
{

    private final c e = new c();

    public PurchaseActivity_()
    {
    }

    private void a(Bundle bundle)
    {
        c.a(this);
    }

    public void a(a a1)
    {
        c = (TextView)a1.findViewById(0x7f0a01ea);
        b = a1.findViewById(0x7f0a00b5);
        d = (TextView)a1.findViewById(0x7f0a01ee);
        c();
    }

    public void onCreate(Bundle bundle)
    {
        c c1 = c.a(e);
        a(bundle);
        super.onCreate(bundle);
        c.a(c1);
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
        e.a(this);
    }

    public void setContentView(View view)
    {
        super.setContentView(view);
        e.a(this);
    }

    public void setContentView(View view, android.view.ViewGroup.LayoutParams layoutparams)
    {
        super.setContentView(view, layoutparams);
        e.a(this);
    }
}
