// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.formats;

import android.content.Context;
import io.presage.Presage;
import io.presage.ads.d;
import io.presage.do.e;
import java.util.ArrayList;

public abstract class io.presage.formats.a
{
    public static interface a
    {

        public abstract void b(String s);
    }


    protected d a;
    protected ArrayList b;
    protected Context c;
    protected a d;
    private String e;
    private String f;
    private e g;

    public io.presage.formats.a(String s, String s1, d d1, e e1)
    {
        e = s;
        f = s1;
        a = d1;
        g = e1;
        b = new ArrayList();
    }

    public final a a()
    {
        return d;
    }

    public final Object a(String s)
    {
        return g.a(s);
    }

    public final void a(a a1)
    {
        d = a1;
    }

    public void b()
    {
        e = null;
        f = null;
        g = null;
        c = null;
    }

    public abstract void c();

    public abstract void d();

    public final ArrayList e()
    {
        return b;
    }

    public final String f()
    {
        return e;
    }

    public final e g()
    {
        return g;
    }

    public final Context h()
    {
        if (c == null)
        {
            c = Presage.getInstance().getContext();
        }
        return c;
    }
}
