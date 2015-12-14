// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzj;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzpv, zzpu

public class zzpx extends zzj
{

    private final Context mContext;

    public zzpx(Context context, Looper looper, zzf zzf, com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks connectioncallbacks, com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener onconnectionfailedlistener)
    {
        super(context, looper, 45, zzf, connectioncallbacks, onconnectionfailedlistener);
        mContext = context;
    }

    private String zzlK()
    {
        Object obj;
        try
        {
            obj = mContext.getPackageManager();
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            return null;
        }
        if (obj == null)
        {
            return null;
        }
        obj = ((PackageManager) (obj)).getApplicationInfo(mContext.getPackageName(), 128);
        if (obj == null)
        {
            return null;
        }
        obj = ((ApplicationInfo) (obj)).metaData;
        if (obj == null)
        {
            return null;
        }
        obj = (String)((Bundle) (obj)).get("com.google.android.safetynet.API_KEY");
        return ((String) (obj));
    }

    protected IInterface zzV(IBinder ibinder)
    {
        return zzdC(ibinder);
    }

    public void zza(zzpu zzpu, List list, int i, String s)
        throws RemoteException
    {
        int ai[] = new int[list.size()];
        for (int j = 0; j < list.size(); j++)
        {
            ai[j] = ((Integer)list.get(j)).intValue();
        }

        ((zzpv)zzoA()).zza(zzpu, zzlK(), ai, i, s);
    }

    public void zza(zzpu zzpu, byte abyte0[])
        throws RemoteException
    {
        ((zzpv)zzoA()).zza(zzpu, abyte0);
    }

    protected zzpv zzdC(IBinder ibinder)
    {
        return zzpv.zza.zzdB(ibinder);
    }

    protected String zzfA()
    {
        return "com.google.android.gms.safetynet.service.START";
    }

    protected String zzfB()
    {
        return "com.google.android.gms.safetynet.internal.ISafetyNetService";
    }
}
