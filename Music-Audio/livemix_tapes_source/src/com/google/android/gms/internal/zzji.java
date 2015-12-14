// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import com.google.android.gms.appinvite.AppInvite;
import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

// Referenced classes of package com.google.android.gms.internal:
//            zzjj

public class zzji
    implements AppInviteApi
{
    static abstract class zza extends com.google.android.gms.common.api.zzc.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(AppInvite.zzQf, googleapiclient);
        }
    }

    final class zzb extends zza
    {

        private final String zzQh;
        final zzji zzQi;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzjj)zzb1);
        }

        protected void zza(zzjj zzjj1)
            throws RemoteException
        {
            zzjj1.zzb(new zzjk.zza(this) {

                final zzb zzQj;

                public void zze(Status status)
                    throws RemoteException
                {
                    zzQj.zza(status);
                }

            
            {
                zzQj = zzb1;
                super();
            }
            }, zzQh);
        }

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            return status;
        }

        public zzb(GoogleApiClient googleapiclient, String s)
        {
            zzQi = zzji.this;
            super(googleapiclient);
            zzQh = s;
        }
    }

    final class zzc extends zza
    {

        private final String zzQh;
        final zzji zzQi;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzjj)zzb1);
        }

        protected void zza(zzjj zzjj1)
            throws RemoteException
        {
            zzjj1.zza(new zzjk.zza(this) {

                final zzc zzQk;

                public void zze(Status status)
                    throws RemoteException
                {
                    zzQk.zza(status);
                }

            
            {
                zzQk = zzc1;
                super();
            }
            }, zzQh);
        }

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            return status;
        }

        public zzc(GoogleApiClient googleapiclient, String s)
        {
            zzQi = zzji.this;
            super(googleapiclient);
            zzQh = s;
        }
    }


    public zzji()
    {
    }

    public PendingResult convertInvitation(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zzc(googleapiclient, s));
    }

    public PendingResult updateInvitationOnInstall(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zzb(googleapiclient, s));
    }
}
