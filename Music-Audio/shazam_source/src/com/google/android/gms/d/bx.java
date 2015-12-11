// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            bo, bn

public final class bx extends bs.a
{

    private final com.google.android.gms.ads.b.d.a a;

    public bx(com.google.android.gms.ads.b.d.a a1)
    {
        a = a1;
    }

    public final void a(bn bn)
    {
        a.onAppInstallAdLoaded(new bo(bn));
    }
}
