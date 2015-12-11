// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;

// Referenced classes of package com.google.android.gms.playlog.internal:
//            zzf

public class zzd
    implements com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
{

    private zzf zzaRE;
    private final com.google.android.gms.internal.zzqd.zza zzaRP;
    private boolean zzaRQ;

    public zzd(com.google.android.gms.internal.zzqd.zza zza1)
    {
        zzaRP = zza1;
        zzaRE = null;
        zzaRQ = true;
    }

    public void onConnected(Bundle bundle)
    {
        zzaRE.zzap(false);
        if (zzaRQ && zzaRP != null)
        {
            zzaRP.zzBr();
        }
        zzaRQ = false;
    }

    public void onConnectionFailed(ConnectionResult connectionresult)
    {
        zzaRE.zzap(true);
        if (zzaRQ && zzaRP != null)
        {
            if (connectionresult.hasResolution())
            {
                zzaRP.zzf(connectionresult.getResolution());
            } else
            {
                zzaRP.zzBs();
            }
        }
        zzaRQ = false;
    }

    public void onConnectionSuspended(int i)
    {
        zzaRE.zzap(true);
    }

    public void zza(zzf zzf1)
    {
        zzaRE = zzf1;
    }

    public void zzao(boolean flag)
    {
        zzaRQ = flag;
    }
}
