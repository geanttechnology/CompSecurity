// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.ads.purchase.InAppPurchaseListener;

// Referenced classes of package com.google.android.gms.internal:
//            zzga, zzfr

public final class zzfx extends zzfs.zza
{

    private final InAppPurchaseListener zztI;

    public zzfx(InAppPurchaseListener inapppurchaselistener)
    {
        zztI = inapppurchaselistener;
    }

    public final void zza(zzfr zzfr)
    {
        zztI.onInAppPurchaseRequested(new zzga(zzfr));
    }
}
