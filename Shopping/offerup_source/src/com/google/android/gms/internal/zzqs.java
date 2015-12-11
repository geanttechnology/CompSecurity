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
//            zzqr

public class zzqs extends zzj
{

    public zzqs(Context context, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener, zzf zzf)
    {
        super(context, context.getMainLooper(), 73, zzf, connectioncallbacks, onconnectionfailedlistener);
    }

    protected IInterface zzW(IBinder ibinder)
    {
        return zzdL(ibinder);
    }

    protected zzqr zzdL(IBinder ibinder)
    {
        return zzqr.zza.zzdK(ibinder);
    }

    protected String zzfK()
    {
        return "com.google.android.gms.search.service.SEARCH_AUTH_START";
    }

    protected String zzfL()
    {
        return "com.google.android.gms.search.internal.ISearchAuthService";
    }
}
