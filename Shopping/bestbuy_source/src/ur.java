// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.graphics.drawable.Drawable;

public class ur extends ux
    implements ut
{

    private final String a;
    private final Drawable b;
    private final String c;
    private final Drawable d;
    private final String e;
    private final String f;
    private final Object g = new Object();
    private us h;

    public ur(String s, Drawable drawable, String s1, Drawable drawable1, String s2, String s3)
    {
        a = s;
        b = drawable;
        c = s1;
        d = drawable1;
        e = s2;
        f = s3;
    }

    public String a()
    {
        return a;
    }

    public void a(int i)
    {
label0:
        {
            synchronized (g)
            {
                if (h != null)
                {
                    break label0;
                }
                acb.b("Attempt to perform click before content ad initialized.");
            }
            return;
        }
        h.a("1", i);
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
        synchronized (g)
        {
            h = us1;
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

    public String f()
    {
        return f;
    }

    public void g()
    {
label0:
        {
            synchronized (g)
            {
                if (h != null)
                {
                    break label0;
                }
                acb.b("Attempt to record impression before content ad initialized.");
            }
            return;
        }
        h.a();
        obj;
        JVM INSTR monitorexit ;
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }
}
