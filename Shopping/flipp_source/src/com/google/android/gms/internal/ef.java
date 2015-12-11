// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;


// Referenced classes of package com.google.android.gms.internal:
//            ee

final class ef
    implements Runnable
{

    final ee a;

    ef(ee ee1)
    {
        a = ee1;
        super();
    }

    public final void run()
    {
        a.f = Thread.currentThread();
        a.a();
    }
}
