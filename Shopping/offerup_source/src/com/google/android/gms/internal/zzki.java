// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.Set;

// Referenced classes of package com.google.android.gms.internal:
//            zzkk

public final class zzki extends zzj
{

    private final Bundle zzSa;

    public zzki(Context context, Looper looper, zzf zzf1, com.google.android.gms.auth.api.Auth.zza zza, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 16, zzf1, connectioncallbacks, onconnectionfailedlistener);
        if (zza == null)
        {
            context = new Bundle();
        } else
        {
            context = zza.zzlE();
        }
        zzSa = context;
    }

    protected final IInterface zzW(IBinder ibinder)
    {
        return zzau(ibinder);
    }

    protected final zzkk zzau(IBinder ibinder)
    {
        return zzkk.zza.zzaw(ibinder);
    }

    protected final String zzfK()
    {
        return "com.google.android.gms.auth.service.START";
    }

    protected final String zzfL()
    {
        return "com.google.android.gms.auth.api.internal.IAuthService";
    }

    public final boolean zzlN()
    {
        zzf zzf1 = zzpa();
        return !TextUtils.isEmpty(zzf1.getAccountName()) && !zzf1.zzb(Auth.PROXY_API).isEmpty();
    }

    protected final Bundle zzly()
    {
        return zzSa;
    }
}
