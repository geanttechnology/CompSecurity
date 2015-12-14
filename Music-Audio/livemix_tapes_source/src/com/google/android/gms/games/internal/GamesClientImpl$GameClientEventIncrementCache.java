// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.games.internal.events.EventIncrementCache;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl, IGamesService, GamesLog

private class zzasS extends EventIncrementCache
{

    final GamesClientImpl zzasS;

    protected void zzt(String s, int i)
    {
        if (zzasS.isConnected())
        {
            ((IGamesService)zzasS.zzoA()).zzq(s, i);
            return;
        }
        try
        {
            GamesLog.zzx("GamesClientImpl", (new StringBuilder()).append("Unable to increment event ").append(s).append(" by ").append(i).append(" because the games client is no longer connected").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GamesClientImpl.zza(zzasS, s);
        }
        return;
    }

    public Y(GamesClientImpl gamesclientimpl)
    {
        zzasS = gamesclientimpl;
        super(gamesclientimpl.getContext().getMainLooper(), 1000);
    }
}
