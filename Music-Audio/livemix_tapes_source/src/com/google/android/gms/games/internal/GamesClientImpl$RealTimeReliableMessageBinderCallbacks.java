// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.zzl;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzatP extends AbstractGamesCallbacks
{

    final zzl zzatP;

    public void zzb(int i, int j, String s)
    {
        if (zzatP != null)
        {
            zzatP.zza(new zzatP(i, j, s));
        }
    }

    public (zzl zzl1)
    {
        zzatP = zzl1;
    }
}
