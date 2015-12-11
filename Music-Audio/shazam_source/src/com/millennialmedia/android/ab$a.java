// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.lang.ref.WeakReference;

// Referenced classes of package com.millennialmedia.android:
//            ab, ac, ao

static class > extends >
{

    WeakReference a;

    final void a()
    {
        ab ab1 = (ab)a.get();
        if (ab1 != null)
        {
            ab1.a(false);
        }
    }

    public void a(String s)
    {
        ab ab1;
        ab1 = (ab)a.get();
        if (ab1 == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        ab1.a(true);
        if (ab1.l == null || ab1.l.b == null)
        {
            break MISSING_BLOCK_LABEL_91;
        }
        s = ab1.l.b;
        s;
        JVM INSTR monitorenter ;
        if (!ab1.l.b.hasWindowFocus())
        {
            break MISSING_BLOCK_LABEL_73;
        }
        ab1.l.b.n();
_L2:
        return;
        ab1.l.b.m();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        s;
        JVM INSTR monitorexit ;
        throw exception;
    }

    (ab ab1)
    {
        a = new WeakReference(ab1);
    }
}
