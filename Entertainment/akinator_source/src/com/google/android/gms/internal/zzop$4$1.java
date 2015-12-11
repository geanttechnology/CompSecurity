// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzop, zzno, zznz

class <init> extends <init>
{

    final b zzarz;

    public void zza(DailyTotalResult dailytotalresult)
        throws RemoteException
    {
        zzarz.b(dailytotalresult);
    }

    piClient(piClient piclient)
    {
        zzarz = piclient;
        super();
    }

    // Unreferenced inner class com/google/android/gms/internal/zzop$4

/* anonymous class */
    class zzop._cls4 extends zzno.zza
    {

        final zzop zzarv;
        final DataType zzary;

        protected DailyTotalResult zzK(Status status)
        {
            return DailyTotalResult.zza(status, zzary);
        }

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzno)zzb1);
        }

        protected void zza(zzno zzno1)
            throws RemoteException
        {
            DailyTotalRequest dailytotalrequest = new DailyTotalRequest(new zzop._cls4._cls1(this), zzary);
            ((zznz)zzno1.zzpc()).zza(dailytotalrequest);
        }

        protected Result zzb(Status status)
        {
            return zzK(status);
        }

            
            {
                zzarv = zzop1;
                zzary = datatype;
                super(googleapiclient);
            }
    }

}
