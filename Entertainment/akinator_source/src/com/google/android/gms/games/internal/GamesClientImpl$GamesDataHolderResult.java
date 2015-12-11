// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusCodes;
import com.google.android.gms.internal.zzle;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static abstract class Q extends zzle
{

    protected Q(DataHolder dataholder)
    {
        super(dataholder, GamesStatusCodes.zzfG(dataholder.getStatusCode()));
    }
}
