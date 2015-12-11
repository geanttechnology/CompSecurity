// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

// Referenced classes of package android.support.v7:
//            rn, re

public final class rk extends rf.a
{

    private final InAppPurchaseListener a;

    public rk(InAppPurchaseListener inapppurchaselistener)
    {
        a = inapppurchaselistener;
    }

    public void a(re re)
    {
        a.onInAppPurchaseRequested(new rn(re));
    }
}
