// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.internal.zzlm;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzawn extends AbstractGamesCallbacks
{

    final zzlm zzawn;

    public void zzb(int i, int j, String s)
    {
        if (zzawn != null)
        {
            zzawn.zza(new zzawn(i, j, s));
        }
    }

    public (zzlm zzlm1)
    {
        zzawn = zzlm1;
    }
}
