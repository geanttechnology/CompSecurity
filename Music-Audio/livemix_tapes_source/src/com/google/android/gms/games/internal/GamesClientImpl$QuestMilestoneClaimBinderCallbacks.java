// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzatL extends AbstractGamesCallbacks
{

    private final com.google.android.gms.common.api.cks.zzatL zzatK;
    private final String zzatL;

    public void zzN(DataHolder dataholder)
    {
        zzatK.zzatK(new zzatK(dataholder, zzatL));
    }

    public (com.google.android.gms.common.api.cks cks, String s)
    {
        zzatK = (com.google.android.gms.common.api.cks.zzatK)zzx.zzb(cks, "Holder must not be null");
        zzatL = (String)zzx.zzb(s, "MilestoneId must not be null");
    }
}
