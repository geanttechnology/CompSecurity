// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.result.DailyTotalResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzno, zzmm, zzmx

class <init> extends <init>
{

    final a zzapc;

    public void zza(DailyTotalResult dailytotalresult)
        throws RemoteException
    {
        zzapc.a(dailytotalresult);
    }

    piClient(piClient piclient)
    {
        zzapc = piclient;
        super();
    }

    // Unreferenced inner class com/google/android/gms/internal/zzno$4

/* anonymous class */
    class zzno._cls4 extends zzmm.zza
    {

        final zzno zzaoY;
        final DataType zzapb;

        protected DailyTotalResult zzK(Status status)
        {
            return DailyTotalResult.zzQ(status);
        }

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzmm)zzb1);
        }

        protected void zza(zzmm zzmm1)
            throws RemoteException
        {
            Object obj = new zzno._cls4._cls1(this);
            String s = zzmm1.getContext().getPackageName();
            obj = new DailyTotalRequest(((zzmr) (obj)), zzapb, s);
            ((zzmx)zzmm1.zzoA()).zza(((DailyTotalRequest) (obj)));
        }

        protected Result zzb(Status status)
        {
            return zzK(status);
        }

            
            {
                zzaoY = zzno1;
                zzapb = datatype;
                super(googleapiclient);
            }
    }

}
