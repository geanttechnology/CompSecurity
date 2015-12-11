// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.analytics.tracking.android;

import java.util.SortedSet;
import java.util.TreeSet;

// Referenced classes of package com.google.analytics.tracking.android:
//            aj

public final class ai
{

    private static final ai d = new ai();
    private SortedSet a;
    private StringBuilder b;
    private boolean c;

    private ai()
    {
        a = new TreeSet();
        b = new StringBuilder();
        c = false;
    }

    public static ai a()
    {
        return d;
    }

    public final void a(aj aj1)
    {
        this;
        JVM INSTR monitorenter ;
        if (!c)
        {
            a.add(aj1);
            b.append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(aj1.ordinal()));
        }
        this;
        JVM INSTR monitorexit ;
        return;
        aj1;
        throw aj1;
    }

    public final void a(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        c = flag;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public final String b()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = new StringBuilder();
        int i;
        int j;
        j = 6;
        i = 0;
_L4:
        aj aj1;
        int k;
        if (a.size() <= 0)
        {
            break; /* Loop/switch isn't completed */
        }
        aj1 = (aj)a.first();
        a.remove(aj1);
        k = aj1.ordinal();
_L2:
        if (k < j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuilder) (obj)).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
        j += 6;
        i = 0;
        if (true) goto _L2; else goto _L1
_L1:
        i += 1 << aj1.ordinal() % 6;
        if (true) goto _L4; else goto _L3
_L3:
        if (i > 0)
        {
            break MISSING_BLOCK_LABEL_114;
        }
        if (((StringBuilder) (obj)).length() != 0)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        ((StringBuilder) (obj)).append("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".charAt(i));
        a.clear();
        obj = ((StringBuilder) (obj)).toString();
        this;
        JVM INSTR monitorexit ;
        return ((String) (obj));
        Exception exception;
        exception;
        throw exception;
    }

    public final String c()
    {
        this;
        JVM INSTR monitorenter ;
        String s;
        if (b.length() > 0)
        {
            b.insert(0, ".");
        }
        s = b.toString();
        b = new StringBuilder();
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

}
