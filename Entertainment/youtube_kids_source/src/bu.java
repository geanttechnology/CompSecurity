// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;

public class bu
{

    public int a;
    public bv b;
    public boolean c;
    public boolean d;
    public boolean e;
    private boolean f;
    private boolean g;

    public bu(Context context)
    {
        c = false;
        d = false;
        e = true;
        f = false;
        g = false;
        context.getApplicationContext();
    }

    public final void a()
    {
        c = true;
        e = false;
        d = false;
        b();
    }

    public final void a(bv bv1)
    {
        if (b == null)
        {
            throw new IllegalStateException("No listener register");
        }
        if (b != bv1)
        {
            throw new IllegalArgumentException("Attempting to unregister the wrong listener");
        } else
        {
            b = null;
            return;
        }
    }

    public final void a(Object obj)
    {
        if (b != null)
        {
            b.a(this, obj);
        }
    }

    public void b()
    {
    }

    public final void c()
    {
        c = false;
        d();
    }

    public void d()
    {
    }

    public final void e()
    {
        f();
        e = true;
        c = false;
        d = false;
        f = false;
        g = false;
    }

    public void f()
    {
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder(64);
        a.a(this, stringbuilder);
        stringbuilder.append(" id=");
        stringbuilder.append(a);
        stringbuilder.append("}");
        return stringbuilder.toString();
    }
}
