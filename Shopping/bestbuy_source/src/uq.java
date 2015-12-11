// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;

public class uq extends uv
    implements ut
{

    private final String a;
    private final Drawable b;
    private final String c;
    private final Drawable d;
    private final String e;
    private final double f;
    private final String g;
    private final String h;
    private final Object i = new Object();
    private us j;

    public uq(String s, Drawable drawable, String s1, Drawable drawable1, String s2, double d1, 
            String s3, String s4)
    {
        a = s;
        b = drawable;
        c = s1;
        d = drawable1;
        e = s2;
        f = d1;
        g = s3;
        h = s4;
    }

    public String a()
    {
        return a;
    }

    public void a(int k)
    {
label0:
        {
            synchronized (i)
            {
                if (j != null)
                {
                    break label0;
                }
                acb.b("Attempt to perform click before app install ad initialized.");
            }
            return;
        }
        j.a("2", k);
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public void a(us us1)
    {
        synchronized (i)
        {
            j = us1;
        }
        return;
        us1;
        obj;
        JVM INSTR monitorexit ;
        throw us1;
    }

    public ry b()
    {
        return sb.a(b);
    }

    public String c()
    {
        return c;
    }

    public ry d()
    {
        return sb.a(d);
    }

    public String e()
    {
        return e;
    }

    public double f()
    {
        return f;
    }

    public String g()
    {
        return g;
    }

    public String h()
    {
        return h;
    }

    public void i()
    {
label0:
        {
            synchronized (i)
            {
                if (j != null)
                {
                    break label0;
                }
                acb.b("Attempt to record impression before app install ad initialized.");
            }
            return;
        }
        j.a();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
