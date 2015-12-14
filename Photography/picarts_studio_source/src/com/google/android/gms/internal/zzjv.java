// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.appinvite.AppInviteApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

public class zzjv
    implements AppInviteApi
{

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

    private class zzc extends zza
    {
        private class zza extends zzlb.zza
        {

            public zza(GoogleApiClient googleapiclient)
            {
                super(AppInvite.zzRk, googleapiclient);
            }
        }


        private final String zzRm;
        final zzjv zzRn;

        protected final volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
        {
            zza((zzjw)zzb1);
        }

        protected final void zza(zzjw zzjw1)
        {
            zzjw1.zza(new zzjx.zza() {

                final zzc zzRp;

                public void zze(Status status)
                {
                    zzRp.zzb(status);
                }

                
                {
                    zzRp = zzc.this;
                    super();
                }
            }, zzRm);
        }

        protected final Result zzb(Status status)
        {
            return zzd(status);
        }

        protected final Status zzd(Status status)
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


    private class zzb extends zza
    {

        private final String zzRm;
        final zzjv zzRn;

        protected final volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
        {
            zza((zzjw)zzb1);
        }

        protected final void zza(zzjw zzjw1)
        {
            zzjw1.zzb(new zzjx.zza() {

                final zzb zzRo;

                public void zze(Status status)
                {
                    zzRo.zzb(status);
                }

                
                {
                    zzRo = zzb.this;
                    super();
                }
            }, zzRm);
        }

        protected final Result zzb(Status status)
        {
            return zzd(status);
        }

        protected final Status zzd(Status status)
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

}
