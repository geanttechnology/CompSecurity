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
//            zzjw

public class zzjv
    implements AppInviteApi
{
    static abstract class zza extends zzlb.zza
    {

        public zza(GoogleApiClient googleapiclient)
        {
            super(AppInvite.zzRk, googleapiclient);
        }
    }

    final class zzb extends zza
    {

        private final String zzRm;
        final zzjv zzRn;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzjw)zzb1);
        }

        protected void zza(zzjw zzjw1)
            throws RemoteException
        {
            zzjw1.zzb(new zzjx.zza(this) {

                final zzb zzRo;

                public void zze(Status status)
                    throws RemoteException
                {
                    zzRo.zzb(status);
                }

            
            {
                zzRo = zzb1;
                super();
            }
            }, zzRm);
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
            zzRn = zzjv.this;
            super(googleapiclient);
            zzRm = s;
        }
    }

    final class zzc extends zza
    {

        private final String zzRm;
        final zzjv zzRn;

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzjw)zzb1);
        }

        protected void zza(zzjw zzjw1)
            throws RemoteException
        {
            zzjw1.zza(new zzjx.zza(this) {

                final zzc zzRp;

                public void zze(Status status)
                    throws RemoteException
                {
                    zzRp.zzb(status);
                }

            
            {
                zzRp = zzc1;
                super();
            }
            }, zzRm);
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
            zzRn = zzjv.this;
            super(googleapiclient);
            zzRm = s;
        }
    }


    public zzjv()
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
