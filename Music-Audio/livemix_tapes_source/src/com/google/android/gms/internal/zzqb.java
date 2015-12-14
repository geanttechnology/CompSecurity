// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;

// Referenced classes of package com.google.android.gms.internal:
//            zzqa

public class zzqb extends zzj
{

    public zzqb(Context context, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf)
    {
        super(context, context.getMainLooper(), 73, zzf, connectioncallbacks, onconnectionfailedlistener);
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzdF(ibinder);
    }

    protected zzqa zzdF(IBinder ibinder)
    {
        return zzqa.zza.zzdE(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }
}
