// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.os.Bundle;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class >
    implements com.google.android.gms.games.multiplayer.turnbased.
{

    private final Status zzSC;
    private final LoadMatchesResponse zzavM;

    public LoadMatchesResponse getMatches()
    {
        return zzavM;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    public void release()
    {
        zzavM.release();
    }

    MatchesResult(Status status, Bundle bundle)
    {
        zzSC = status;
        zzavM = new LoadMatchesResponse(bundle);
    }
}
