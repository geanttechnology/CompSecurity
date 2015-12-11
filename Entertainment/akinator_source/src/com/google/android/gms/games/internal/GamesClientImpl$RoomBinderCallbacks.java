// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.internal.zzlm;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzawv extends AbstractGamesCallbacks
{

    private final zzlm zzawt;
    private final zzlm zzawu;
    private final zzlm zzawv;

    public void onLeftRoom(int i, String s)
    {
        zzawt.zza(new it>(i, s));
    }

    public void onP2PConnected(String s)
    {
        if (zzawu != null)
        {
            zzawu.zza(new (s));
        }
    }

    public void onP2PDisconnected(String s)
    {
        if (zzawu != null)
        {
            zzawu.zza(new ier(s));
        }
    }

    public void onRealTimeMessageReceived(RealTimeMessage realtimemessage)
    {
        if (zzawv != null)
        {
            zzawv.zza(new ier(realtimemessage));
        }
    }

    public void zzA(DataHolder dataholder)
    {
        zzawt.zza(new init>(dataholder));
    }

    public void zzB(DataHolder dataholder)
    {
        if (zzawu != null)
        {
            zzawu.zza(new er(dataholder));
        }
    }

    public void zzC(DataHolder dataholder)
    {
        if (zzawu != null)
        {
            zzawu.zza(new fier(dataholder));
        }
    }

    public void zzD(DataHolder dataholder)
    {
        zzawt.zza(new r(dataholder));
    }

    public void zzE(DataHolder dataholder)
    {
        if (zzawu != null)
        {
            zzawu.zza(new ier(dataholder));
        }
    }

    public void zzF(DataHolder dataholder)
    {
        if (zzawu != null)
        {
            zzawu.zza(new Notifier(dataholder));
        }
    }

    public void zza(DataHolder dataholder, String as[])
    {
        if (zzawu != null)
        {
            zzawu.zza(new ifier(dataholder, as));
        }
    }

    public void zzb(DataHolder dataholder, String as[])
    {
        if (zzawu != null)
        {
            zzawu.zza(new er(dataholder, as));
        }
    }

    public void zzc(DataHolder dataholder, String as[])
    {
        if (zzawu != null)
        {
            zzawu.zza(new (dataholder, as));
        }
    }

    public void zzd(DataHolder dataholder, String as[])
    {
        if (zzawu != null)
        {
            zzawu.zza(new (dataholder, as));
        }
    }

    public void zze(DataHolder dataholder, String as[])
    {
        if (zzawu != null)
        {
            zzawu.zza(new r(dataholder, as));
        }
    }

    public void zzf(DataHolder dataholder, String as[])
    {
        if (zzawu != null)
        {
            zzawu.zza(new fier(dataholder, as));
        }
    }

    public void zzz(DataHolder dataholder)
    {
        zzawt.zza(new <init>(dataholder));
    }

    public fier(zzlm zzlm1)
    {
        zzawt = (zzlm)zzx.zzb(zzlm1, "Callbacks must not be null");
        zzawu = null;
        zzawv = null;
    }

    public zzawv(zzlm zzlm1, zzlm zzlm2, zzlm zzlm3)
    {
        zzawt = (zzlm)zzx.zzb(zzlm1, "Callbacks must not be null");
        zzawu = zzlm2;
        zzawv = zzlm3;
    }
}
