// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavz
    implements com.google.android.gms.games.sultImpl
{

    private final Status zzSC;
    private final String zzavy;
    private final boolean zzavz;

    public Status getStatus()
    {
        return zzSC;
    }

    public (DataHolder dataholder)
    {
        zzSC = GamesStatusCodes.zzfG(dataholder.getStatusCode());
        if (dataholder.getCount() <= 0) goto _L2; else goto _L1
_L1:
        zzavy = dataholder.zzd("external_game_id", 0, 0);
        zzavz = dataholder.zze("muted", 0, 0);
_L4:
        dataholder.close();
        return;
_L2:
        zzavy = null;
        zzavz = false;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        dataholder.close();
        throw exception;
    }
}
