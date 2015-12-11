// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzawj extends AbstractGamesCallbacks
{

    private final com.google.android.gms.internal.backs.zzawj zzawi;
    private final String zzawj;

    public void zzP(DataHolder dataholder)
    {
        zzawi.zzawi(new zzawi(dataholder, zzawj));
    }

    public (com.google.android.gms.internal.backs backs, String s)
    {
        zzawi = (com.google.android.gms.internal.backs.zzawi)zzx.zzb(backs, "Holder must not be null");
        zzawj = (String)zzx.zzb(s, "MilestoneId must not be null");
    }
}
