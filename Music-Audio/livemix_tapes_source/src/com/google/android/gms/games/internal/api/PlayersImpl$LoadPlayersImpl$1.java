// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.PlayerBuffer;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            PlayersImpl

class zzQs
    implements com.google.android.gms.games.layersImpl._cls1
{

    final Status zzQs;
    final zzQs zzavw;

    public PlayerBuffer getPlayers()
    {
        return new PlayerBuffer(DataHolder.zzbp(14));
    }

    public Status getStatus()
    {
        return zzQs;
    }

    public void release()
    {
    }

    ( , Status status)
    {
        zzavw = ;
        zzQs = status;
        super();
    }
}
