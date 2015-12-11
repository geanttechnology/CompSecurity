// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Handler;

// Referenced classes of package com.google.android.gms.internal:
//            cl, er, cj

final class ck
{

    final Runnable a;
    volatile boolean b;

    public ck(cj cj)
    {
        b = false;
        a = new cl(this, cj);
    }

    public final void a()
    {
        er.a.postDelayed(a, 250L);
    }
}
