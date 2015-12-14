// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.fitness.zza;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzmi

public abstract class zzmj extends zzj
{

    protected zzmj(Context context, Looper looper, int i, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf)
    {
        super(context, looper, i, zzf, connectioncallbacks, onconnectionfailedlistener);
    }

    protected Set zza(Set set)
    {
        return com.google.android.gms.fitness.zza.zze(set);
    }

    public boolean zzlm()
    {
        return !zzmi.zzat(getContext());
    }

    public boolean zzoC()
    {
        return true;
    }
}
