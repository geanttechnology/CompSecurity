// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzk;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzlj, zzli

public class zzlf
    implements zzlj
{

    private final zzli zzabr;

    public zzlf(zzli zzli1)
    {
        zzabr = zzli1;
    }

    private void zza(zzli.zzf zzf)
    {
        zzabr.zzb(zzf);
        com.google.android.gms.common.api.Api.zzb zzb1 = zzabr.zza(zzf.zznx());
        if (!zzb1.isConnected() && zzabr.zzach.containsKey(zzf.zznx()))
        {
            zzf.zzv(new Status(17));
            return;
        } else
        {
            zzf.zzb(zzb1);
            return;
        }
    }

    public void begin()
    {
        while (!zzabr.zzaca.isEmpty()) 
        {
            try
            {
                zza((zzli.zzf)zzabr.zzaca.remove());
            }
            catch (DeadObjectException deadobjectexception)
            {
                Log.w("GACConnected", "Service died while flushing queue", deadobjectexception);
            }
        }
    }

    public void connect()
    {
    }

    public void disconnect()
    {
        zzabr.zzach.clear();
        zzabr.zznY();
        zzabr.zzg(null);
        zzabr.zzabZ.zzpk();
    }

    public String getName()
    {
        return "CONNECTED";
    }

    public void onConnected(Bundle bundle)
    {
    }

    public void onConnectionSuspended(int i)
    {
        if (i == 1)
        {
            zzabr.zzoe();
        }
        for (Iterator iterator = zzabr.zzacm.iterator(); iterator.hasNext(); ((zzli.zzf)iterator.next()).zzw(new Status(8, "The connection to Google Play services was lost"))) { }
        zzabr.zzg(null);
        zzabr.zzabZ.zzbG(i);
        zzabr.zzabZ.zzpk();
        if (i == 2)
        {
            zzabr.connect();
        }
    }

    public zzlb.zza zza(zzlb.zza zza1)
    {
        return zzb(zza1);
    }

    public void zza(ConnectionResult connectionresult, Api api, int i)
    {
    }

    public zzlb.zza zzb(zzlb.zza zza1)
    {
        try
        {
            zza(zza1);
        }
        catch (DeadObjectException deadobjectexception)
        {
            zzabr.zza(new _cls1(this));
            return zza1;
        }
        return zza1;
    }

    private class _cls1 extends zzli.zzb
    {

        final zzlf zzabs;

        public void zznO()
        {
            zzabs.onConnectionSuspended(1);
        }

        _cls1(zzlj zzlj1)
        {
            zzabs = zzlf.this;
            super(zzlj1);
        }
    }

}
