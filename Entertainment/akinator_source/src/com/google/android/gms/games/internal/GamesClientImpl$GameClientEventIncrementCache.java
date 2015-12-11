// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.games.internal.events.EventIncrementCache;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl, IGamesService, GamesLog

private class zzavq extends EventIncrementCache
{

    final GamesClientImpl zzavq;

    protected void zzs(String s, int i)
    {
        if (zzavq.isConnected())
        {
            ((IGamesService)zzavq.zzpc()).zzp(s, i);
            return;
        }
        try
        {
            GamesLog.zzz("GamesClientImpl", (new StringBuilder()).append("Unable to increment event ").append(s).append(" by ").append(i).append(" because the games client is no longer connected").toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GamesClientImpl.zza(zzavq, s);
        }
        return;
    }

    public Y(GamesClientImpl gamesclientimpl)
    {
        zzavq = gamesclientimpl;
        super(gamesclientimpl.getContext().getMainLooper(), 1000);
    }
}
