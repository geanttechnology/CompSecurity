// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.Status;
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

    public (int i, String s, boolean flag)
    {
        zzSC = GamesStatusCodes.zzfG(i);
        zzavy = s;
        zzavz = flag;
    }
}
