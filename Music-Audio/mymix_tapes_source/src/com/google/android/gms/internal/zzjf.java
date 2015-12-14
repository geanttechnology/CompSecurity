// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

// Referenced classes of package com.google.android.gms.internal:
//            zzjc

public class zzjf extends zzj
{

    public zzjf(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 19, zzf, connectioncallbacks, onconnectionfailedlistener);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzah(ibinder);
    }

    protected zzjc zzah(IBinder ibinder)
    {
        return zzjc.zza.zzaf(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.icing.LIGHTWEIGHT_INDEX_SERVICE";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.appdatasearch.internal.ILightweightAppDataSearch";
    }

    public zzjc zzlg()
        throws DeadObjectException
    {
        return (zzjc)zzoA();
    }
}
