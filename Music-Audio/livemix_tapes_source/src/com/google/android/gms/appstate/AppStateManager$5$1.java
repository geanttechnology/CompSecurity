// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.appstate;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzjn;

// Referenced classes of package com.google.android.gms.appstate:
//            AppStateManager

class zzQs
    implements eDeletedResult
{

    final Status zzQs;
    final zzQs zzQv;

    public int getStateKey()
    {
        return zzQv.Qt;
    }

    public Status getStatus()
    {
        return zzQs;
    }

    <init>(<init> <init>1, Status status)
    {
        zzQv = <init>1;
        zzQs = status;
        super();
    }

    // Unreferenced inner class com/google/android/gms/appstate/AppStateManager$5

/* anonymous class */
    static final class AppStateManager._cls5 extends AppStateManager.zzb
    {

        final int zzQt;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzjn)zzb1);
        }

        protected void zza(zzjn zzjn1)
            throws RemoteException
        {
            zzjn1.zza(this, zzQt);
        }

        public Result zzb(Status status)
        {
            return zzh(status);
        }

        public AppStateManager.StateDeletedResult zzh(Status status)
        {
            return new AppStateManager._cls5._cls1(this, status);
        }

            
            {
                zzQt = i;
                super(googleapiclient);
            }
    }

}
