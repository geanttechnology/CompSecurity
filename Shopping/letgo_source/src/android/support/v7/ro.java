// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

// Referenced classes of package android.support.v7:
//            rm, ri

public final class ro extends rj.a
{

    private final PlayStorePurchaseListener a;

    public ro(PlayStorePurchaseListener playstorepurchaselistener)
    {
        a = playstorepurchaselistener;
    }

    public void a(ri ri)
    {
        a.onInAppPurchaseFinished(new rm(ri));
    }

    public boolean a(String s)
    {
        return a.isValidPurchase(s);
    }
}
