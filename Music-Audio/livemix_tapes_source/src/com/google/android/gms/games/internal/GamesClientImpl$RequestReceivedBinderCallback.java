// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.request.GameRequest;
import com.google.android.gms.games.request.GameRequestBuffer;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzaiL extends AbstractGamesCallbacks
{

    private final zzl zzaiL;

    public void onRequestRemoved(String s)
    {
        zzaiL.zza(new zzaiL(s));
    }

    public void zzr(DataHolder dataholder)
    {
        GameRequestBuffer gamerequestbuffer;
        gamerequestbuffer = new GameRequestBuffer(dataholder);
        dataholder = null;
        if (gamerequestbuffer.getCount() > 0)
        {
            dataholder = (GameRequest)((GameRequest)gamerequestbuffer.get(0)).freeze();
        }
        gamerequestbuffer.release();
        if (dataholder != null)
        {
            zzaiL.zza(new (dataholder));
        }
        return;
        dataholder;
        gamerequestbuffer.release();
        throw dataholder;
    }

    Y(zzl zzl1)
    {
        zzaiL = zzl1;
    }
}
