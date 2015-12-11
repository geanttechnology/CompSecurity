// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzavx
    implements com.google.android.gms.games.snapshot.zzavx
{

    private final Status zzSC;
    private final String zzavx;

    public String getSnapshotId()
    {
        return zzavx;
    }

    public Status getStatus()
    {
        return zzSC;
    }

    (int i, String s)
    {
        zzSC = GamesStatusCodes.zzfG(i);
        zzavx = s;
    }
}
