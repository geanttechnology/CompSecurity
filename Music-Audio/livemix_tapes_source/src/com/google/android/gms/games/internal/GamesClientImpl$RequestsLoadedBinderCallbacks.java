// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.GamesStatusCodes;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzatT extends AbstractGamesCallbacks
{

    private final com.google.android.gms.common.api.it> zzatT;

    public void zzd(int i, Bundle bundle)
    {
        bundle.setClassLoader(getClass().getClassLoader());
        com.google.android.gms.common.api.Status status = GamesStatusCodes.zzfx(i);
        zzatT.zzatT(new zzatT(status, bundle));
    }

    public Y(com.google.android.gms.common.api.cks cks)
    {
        zzatT = (com.google.android.gms.common.api.cks.zzatT)zzx.zzb(cks, "Holder must not be null");
    }
}
