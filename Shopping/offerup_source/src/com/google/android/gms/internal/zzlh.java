// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

// Referenced classes of package com.google.android.gms.internal:
//            zzlj, zzli

public class zzlh
    implements zzlj
{

    private final zzli zzabr;

    public zzlh(zzli zzli1)
    {
        zzabr = zzli1;
    }

    public void begin()
    {
        zzabr.zznZ();
        zzabr.zzaci = Collections.emptySet();
    }

    public void connect()
    {
        zzabr.zzoa();
    }

    public void disconnect()
    {
        zzli.zzf zzf;
        for (Iterator iterator = zzabr.zzaca.iterator(); iterator.hasNext(); zzf.cancel())
        {
            zzf = (zzli.zzf)iterator.next();
            zzf.zza(null);
        }

        zzabr.zzaca.clear();
        zzabr.zzach.clear();
        zzabr.zznY();
    }

    public String getName()
    {
        return "DISCONNECTED";
    }

    public void onConnected(Bundle bundle)
    {
    }

    public void onConnectionSuspended(int i)
    {
    }

    public zzlb.zza zza(zzlb.zza zza1)
    {
        zzabr.zzaca.add(zza1);
        return zza1;
    }

    public void zza(ConnectionResult connectionresult, Api api, int i)
    {
    }

    public zzlb.zza zzb(zzlb.zza zza1)
    {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
