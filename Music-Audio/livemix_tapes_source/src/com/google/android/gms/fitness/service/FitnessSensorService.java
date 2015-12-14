// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.service;

import android.app.AppOpsManager;
import android.app.Service;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Binder;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.internal.service.FitnessDataSourcesRequest;
import com.google.android.gms.fitness.internal.service.FitnessUnregistrationRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.google.android.gms.internal.zzlv;
import com.google.android.gms.internal.zzmt;
import com.google.android.gms.internal.zznh;
import java.util.List;

// Referenced classes of package com.google.android.gms.fitness.service:
//            FitnessSensorServiceRequest

public abstract class FitnessSensorService extends Service
{
    private static class zza extends com.google.android.gms.fitness.internal.service.zzc.zza
    {

        private final FitnessSensorService zzaqQ;

        public void zza(FitnessDataSourcesRequest fitnessdatasourcesrequest, zzmt zzmt1)
            throws RemoteException
        {
            zzaqQ.zzsI();
            zzmt1.zza(new DataSourcesResult(zzaqQ.onFindDataSources(fitnessdatasourcesrequest.getDataTypes()), Status.zzaaD));
        }

        public void zza(FitnessUnregistrationRequest fitnessunregistrationrequest, zznh zznh1)
            throws RemoteException
        {
            zzaqQ.zzsI();
            if (zzaqQ.onUnregister(fitnessunregistrationrequest.getDataSource()))
            {
                zznh1.zzr(Status.zzaaD);
                return;
            } else
            {
                zznh1.zzr(new Status(13));
                return;
            }
        }

        public void zza(FitnessSensorServiceRequest fitnesssensorservicerequest, zznh zznh1)
            throws RemoteException
        {
            zzaqQ.zzsI();
            if (zzaqQ.onRegister(fitnesssensorservicerequest))
            {
                zznh1.zzr(Status.zzaaD);
                return;
            } else
            {
                zznh1.zzr(new Status(13));
                return;
            }
        }

        private zza(FitnessSensorService fitnesssensorservice)
        {
            zzaqQ = fitnesssensorservice;
        }

    }


    public static final String SERVICE_INTERFACE = "com.google.android.gms.fitness.service.FitnessSensorService";
    private zza zzaqP;

    public FitnessSensorService()
    {
    }

    public final IBinder onBind(Intent intent)
    {
        if ("com.google.android.gms.fitness.service.FitnessSensorService".equals(intent.getAction()))
        {
            if (Log.isLoggable("FitnessSensorService", 3))
            {
                Log.d("FitnessSensorService", (new StringBuilder()).append("Intent ").append(intent).append(" received by ").append(getClass().getName()).toString());
            }
            return zzaqP.asBinder();
        } else
        {
            return null;
        }
    }

    public void onCreate()
    {
        super.onCreate();
        zzaqP = new zza(this);
    }

    public abstract List onFindDataSources(List list);

    public abstract boolean onRegister(FitnessSensorServiceRequest fitnesssensorservicerequest);

    public abstract boolean onUnregister(DataSource datasource);

    protected void zzsI()
        throws SecurityException
    {
        int i = Binder.getCallingUid();
        if (!zzlv.zzpV()) goto _L2; else goto _L1
_L1:
        ((AppOpsManager)getSystemService("appops")).checkPackage(i, "com.google.android.gms");
_L4:
        return;
_L2:
label0:
        {
            String as[] = getPackageManager().getPackagesForUid(i);
            if (as == null)
            {
                break label0;
            }
            int j = as.length;
            i = 0;
            do
            {
                if (i >= j)
                {
                    break label0;
                }
                if (as[i].equals("com.google.android.gms"))
                {
                    break;
                }
                i++;
            } while (true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        throw new SecurityException("Unauthorized caller");
    }
}
