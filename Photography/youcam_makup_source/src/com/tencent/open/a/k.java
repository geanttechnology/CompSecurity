// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.open.a;

import android.os.Environment;
import android.text.TextUtils;
import com.tencent.open.utils.c;
import java.io.File;

// Referenced classes of package com.tencent.open.a:
//            c, b, a, g, 
//            h, j, e

public class k
{

    public static k a = null;
    protected static final b c;
    protected a b;

    private k()
    {
        b = new a(c);
    }

    public static k a()
    {
        if (a != null) goto _L2; else goto _L1
_L1:
        com/tencent/open/a/k;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new k();
        }
        com/tencent/open/a/k;
        JVM INSTR monitorexit ;
_L2:
        return a;
        Exception exception;
        exception;
        com/tencent/open/a/k;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static final void a(String s, String s1)
    {
        a().a(1, s, s1, null);
    }

    public static final void a(String s, String s1, Throwable throwable)
    {
        a().a(2, s, s1, throwable);
    }

    public static void b()
    {
        com/tencent/open/a/k;
        JVM INSTR monitorenter ;
        a().d();
        if (a != null)
        {
            a = null;
        }
        com/tencent/open/a/k;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        com/tencent/open/a/k;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static final void b(String s, String s1)
    {
        a().a(2, s, s1, null);
    }

    public static final void b(String s, String s1, Throwable throwable)
    {
        a().a(16, s, s1, throwable);
    }

    protected static File c()
    {
        Object obj = com.tencent.open.utils.c.b();
        String s = ((String) (obj));
        if (TextUtils.isEmpty(((CharSequence) (obj))))
        {
            s = "default";
        }
        s = (new StringBuilder()).append(c.h).append(File.separator).append(s).toString();
        obj = g.b();
        boolean flag;
        if (obj != null && ((h) (obj)).c() > c.k)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            return new File(Environment.getExternalStorageDirectory(), s);
        } else
        {
            return new File(com.tencent.open.utils.c.c(), s);
        }
    }

    public static final void c(String s, String s1)
    {
        a().a(4, s, s1, null);
    }

    public static final void d(String s, String s1)
    {
        a().a(8, s, s1, null);
    }

    public static final void e(String s, String s1)
    {
        a().a(16, s, s1, null);
    }

    protected void a(int i, String s, String s1, Throwable throwable)
    {
        j.a.b(i, Thread.currentThread(), System.currentTimeMillis(), s, s1, throwable);
        if (!com.tencent.open.a.e.a(c.b, i) || b == null)
        {
            return;
        } else
        {
            b.b(i, Thread.currentThread(), System.currentTimeMillis(), s, s1, throwable);
            return;
        }
    }

    protected void d()
    {
        if (b != null)
        {
            b.a();
            b.b();
            b = null;
        }
    }

    static 
    {
        int i = c.r;
        long l = c.s;
        c = new b(c(), i, c.l, c.m, c.g, c.n, 10, c.j, l);
    }
}
