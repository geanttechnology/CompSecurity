// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.GamesStatusCodes;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzasZ
    implements com.google.android.gms.games.snapshot.zzasZ
{

    private final Status zzQA;
    private final String zzasZ;

    public String getSnapshotId()
    {
        return zzasZ;
    }

    public Status getStatus()
    {
        return zzQA;
    }

    (int i, String s)
    {
        zzQA = GamesStatusCodes.zzfx(i);
        zzasZ = s;
    }
}
