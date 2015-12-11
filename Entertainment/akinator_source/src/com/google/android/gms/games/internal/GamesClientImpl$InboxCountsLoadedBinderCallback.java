// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.GamesStatusCodes;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzagy extends AbstractGamesCallbacks
{

    private final com.google.android.gms.internal.> zzagy;

    public void zzg(int i, Bundle bundle)
    {
        bundle.setClassLoader(getClass().getClassLoader());
        com.google.android.gms.common.api.Status status = GamesStatusCodes.zzfG(i);
        zzagy.zzagy(new zzagy(status, bundle));
    }

    (com.google.android.gms.internal.lback lback)
    {
        zzagy = (com.google.android.gms.internal.lback.zzagy)zzx.zzb(lback, "Holder must not be null");
    }
}
