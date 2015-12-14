// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.PlayStorePurchaseListener;

// Referenced classes of package com.google.android.gms.internal:
//            zzfz, zzfv

public final class zzgb extends zzfw.zza
{

    private final PlayStorePurchaseListener zztJ;

    public zzgb(PlayStorePurchaseListener playstorepurchaselistener)
    {
        zztJ = playstorepurchaselistener;
    }

    public final boolean isValidPurchase(String s)
    {
        return zztJ.isValidPurchase(s);
    }

    public final void zza(zzfv zzfv)
    {
        zztJ.onInAppPurchaseFinished(new zzfz(zzfv));
    }
}
