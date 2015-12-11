// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.registration;

import android.content.Context;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.smule.pianoandroid.magicpiano.MagicApplication;

// Referenced classes of package com.smule.pianoandroid.magicpiano.registration:
//            c, d

public class b
{

    FragmentActivity a;
    d b;
    c c;
    String d;
    boolean e;
    Runnable f;

    public b(FragmentActivity fragmentactivity)
    {
        a = fragmentactivity;
        e = false;
    }

    private void c(String s)
    {
        c = com.smule.pianoandroid.magicpiano.registration.c.a(a, s, "");
        c.a(f);
    }

    public void a()
    {
        c();
        e = true;
    }

    public void a(int i)
    {
        a(MagicApplication.getContext().getResources().getString(i));
    }

    public void a(Runnable runnable)
    {
        f = runnable;
    }

    public void a(String s)
    {
        boolean flag;
        if (b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        c();
        e = true;
        if (flag)
        {
            c(s);
            return;
        } else
        {
            d = s;
            return;
        }
    }

    public void a(String s, String s1)
    {
        b = com.smule.pianoandroid.magicpiano.registration.d.b(a, 0, s);
        b.a(this);
    }

    public void b()
    {
        if (e)
        {
            d();
            e = false;
        }
        if (d != null)
        {
            e();
            c(d);
        }
    }

    public void b(String s)
    {
        b.a(s);
    }

    public void c()
    {
        d();
        e();
    }

    public void d()
    {
        if (b != null)
        {
            b.dismiss();
            b = null;
        }
    }

    public void e()
    {
        if (c != null)
        {
            c.dismiss();
            c = null;
        }
    }

    public void f()
    {
        a(MagicApplication.getContext().getResources().getString(0x7f0c0045));
    }

    public void g()
    {
        a(MagicApplication.getContext().getResources().getString(0x7f0c00f7));
    }
}
