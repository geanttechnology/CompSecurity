// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            ef

public abstract class ee
{

    final Runnable e = new ef(this);
    volatile Thread f;

    public ee()
    {
    }

    public abstract void a();

    public abstract void b_();

    public final void e()
    {
        b_();
        if (f != null)
        {
            f.interrupt();
        }
    }
}
