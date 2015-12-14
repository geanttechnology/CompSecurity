// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pf.common.a;

import android.graphics.Bitmap;
import com.pf.common.utility.References;
import com.pf.common.utility.m;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

// Referenced classes of package com.pf.common.a:
//            d, c, h

abstract class e
    implements d
{

    final String a;
    volatile Reference b;
    boolean c;
    final String d = m.a(new Throwable());
    final c e;

    e(c c1, String s)
    {
        e = c1;
        super();
        b = References.a();
        if (s == null)
        {
            s = c1.a(this);
        }
        a = s;
    }

    static void a(e e1, Bitmap bitmap)
    {
        e1.c(bitmap);
    }

    private void c(Bitmap bitmap)
    {
        a(bitmap);
        if (c.a)
        {
            b = References.a();
        }
    }

    private Bitmap f()
    {
        Bitmap bitmap = com.pf.common.a.c.c(e).a(this);
        if (bitmap != null)
        {
            return bitmap;
        } else
        {
            return g();
        }
    }

    private Bitmap g()
    {
        Bitmap bitmap = e();
        if (bitmap != null)
        {
            com.pf.common.a.c.c(e).put(this, bitmap);
        }
        return bitmap;
    }

    public Bitmap a()
    {
        d();
        Bitmap bitmap = (Bitmap)b.get();
        if (bitmap != null)
        {
            return bitmap;
        }
        bitmap = f();
        if (bitmap != null)
        {
            b = new WeakReference(bitmap);
            return bitmap;
        } else
        {
            b = References.a();
            return null;
        }
    }

    abstract void a(Bitmap bitmap);

    public final void b()
    {
        this;
        JVM INSTR monitorenter ;
        if (!c)
        {
            b = References.a();
            com.pf.common.a.c.c(e).remove(this);
            c();
            c = true;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    void c()
    {
    }

    void d()
    {
        if (c)
        {
            throw new IllegalStateException("Operation cannot be done in deleted entity.");
        } else
        {
            return;
        }
    }

    abstract Bitmap e();

    public boolean equals(Object obj)
    {
        if (this == obj)
        {
            return true;
        }
        if (!(obj instanceof e))
        {
            return false;
        } else
        {
            obj = (e)obj;
            return a.equals(((e) (obj)).a);
        }
    }

    public int hashCode()
    {
        return a.hashCode();
    }
}
