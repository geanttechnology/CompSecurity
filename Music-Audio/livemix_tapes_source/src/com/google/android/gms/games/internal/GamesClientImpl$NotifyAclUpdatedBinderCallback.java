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

    private final com.google.android.gms.common.api.ack.zzQz zzQz;

    public void zzfI(int i)
    {
        zzQz.zzQz(GamesStatusCodes.zzfx(i));
    }

    (com.google.android.gms.common.api.ack ack)
    {
        zzQz = (com.google.android.gms.common.api.ack.zzQz)zzx.zzb(ack, "Holder must not be null");
    }
}
