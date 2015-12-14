// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.GamesStatusCodes;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzQz extends AbstractGamesCallbacks
{

    private final com.google.android.gms.common.api.cks.zzQz zzQz;

    public void zzll()
    {
        com.google.android.gms.common.api.Status status = GamesStatusCodes.zzfx(0);
        zzQz.zzQz(status);
    }

    public (com.google.android.gms.common.api.cks cks)
    {
        zzQz = (com.google.android.gms.common.api.cks.zzQz)zzx.zzb(cks, "Holder must not be null");
    }
}
