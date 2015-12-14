// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzatX extends AbstractGamesCallbacks
{

    private final zzl zzatV;
    private final zzl zzatW;
    private final zzl zzatX;

    public void onLeftRoom(int i, String s)
    {
        zzatV.zza(new it>(i, s));
    }

    public void onP2PConnected(String s)
    {
        if (zzatW != null)
        {
            zzatW.zza(new (s));
        }
    }

    public void onP2PDisconnected(String s)
    {
        if (zzatW != null)
        {
            zzatW.zza(new ier(s));
        }
    }

    public void onRealTimeMessageReceived(RealTimeMessage realtimemessage)
    {
        if (zzatX != null)
        {
            zzatX.zza(new ier(realtimemessage));
        }
    }

    public void zzA(DataHolder dataholder)
    {
        if (zzatW != null)
        {
            zzatW.zza(new fier(dataholder));
        }
    }

    public void zzB(DataHolder dataholder)
    {
        zzatV.zza(new r(dataholder));
    }

    public void zzC(DataHolder dataholder)
    {
        if (zzatW != null)
        {
            zzatW.zza(new ier(dataholder));
        }
    }

    public void zzD(DataHolder dataholder)
    {
        if (zzatW != null)
        {
            zzatW.zza(new Notifier(dataholder));
        }
    }

    public void zza(DataHolder dataholder, String as[])
    {
        if (zzatW != null)
        {
            zzatW.zza(new ifier(dataholder, as));
        }
    }

    public void zzb(DataHolder dataholder, String as[])
    {
        if (zzatW != null)
        {
            zzatW.zza(new er(dataholder, as));
        }
    }

    public void zzc(DataHolder dataholder, String as[])
    {
        if (zzatW != null)
        {
            zzatW.zza(new (dataholder, as));
        }
    }

    public void zzd(DataHolder dataholder, String as[])
    {
        if (zzatW != null)
        {
            zzatW.zza(new (dataholder, as));
        }
    }

    public void zze(DataHolder dataholder, String as[])
    {
        if (zzatW != null)
        {
            zzatW.zza(new r(dataholder, as));
        }
    }

    public void zzf(DataHolder dataholder, String as[])
    {
        if (zzatW != null)
        {
            zzatW.zza(new fier(dataholder, as));
        }
    }

    public void zzx(DataHolder dataholder)
    {
        zzatV.zza(new <init>(dataholder));
    }

    public void zzy(DataHolder dataholder)
    {
        zzatV.zza(new init>(dataholder));
    }

    public void zzz(DataHolder dataholder)
    {
        if (zzatW != null)
        {
            zzatW.zza(new er(dataholder));
        }
    }

    public er(zzl zzl1)
    {
        zzatV = (zzl)com.google.android.gms.common.internal.zzx.zzb(zzl1, "Callbacks must not be null");
        zzatW = null;
        zzatX = null;
    }

    public zzatX(zzl zzl1, zzl zzl2, zzl zzl3)
    {
        zzatV = (zzl)com.google.android.gms.common.internal.zzx.zzb(zzl1, "Callbacks must not be null");
        zzatW = zzl2;
        zzatX = zzl3;
    }
}
