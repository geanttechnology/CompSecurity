// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;
import com.google.android.gms.search.SearchAuth;
import com.google.android.gms.search.SearchAuthApi;

// Referenced classes of package com.google.android.gms.internal:
//            zzqb, zzqa

public class zzqc
    implements SearchAuthApi
{
    static abstract class zza extends zzpz.zza
    {

        public void zza(Status status, GoogleNowAuthState googlenowauthstate)
        {
            throw new UnsupportedOperationException();
        }

        public void zzbc(Status status)
        {
            throw new UnsupportedOperationException();
        }

        zza()
        {
        }
    }

    static class zzb extends com.google.android.gms.common.api.zzc.zza
    {

        private final GoogleApiClient zzTC;
        private final String zzaNN;
        private final boolean zzaNQ = Log.isLoggable("SearchAuth", 3);

        static boolean zza(zzb zzb1)
        {
            return zzb1.zzaNQ;
        }

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzqb)zzb1);
        }

        protected void zza(zzqb zzqb1)
            throws RemoteException
        {
            if (zzaNQ)
            {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            String s = zzTC.getContext().getPackageName();
            zza zza1 = new zza(this) {

                final zzb zzaNR;

                public void zzbc(Status status)
                {
                    if (zzb.zza(zzaNR))
                    {
                        Log.d("SearchAuth", "ClearTokenImpl success");
                    }
                    zzaNR.zza(status);
                }

            
            {
                zzaNR = zzb1;
                super();
            }
            };
            ((zzqa)zzqb1.zzoA()).zzb(zza1, s, zzaNN);
        }

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            if (zzaNQ)
            {
                Log.d("SearchAuth", (new StringBuilder()).append("ClearTokenImpl received failure: ").append(status.getStatusMessage()).toString());
            }
            return status;
        }

        protected zzb(GoogleApiClient googleapiclient, String s)
        {
            super(SearchAuth.zzQf, googleapiclient);
            zzTC = googleapiclient;
            zzaNN = s;
        }
    }

    static class zzc extends com.google.android.gms.common.api.zzc.zza
    {

        private final GoogleApiClient zzTC;
        private final boolean zzaNQ = Log.isLoggable("SearchAuth", 3);
        private final String zzaNS;

        static boolean zza(zzc zzc1)
        {
            return zzc1.zzaNQ;
        }

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
            throws RemoteException
        {
            zza((zzqb)zzb1);
        }

        protected void zza(zzqb zzqb1)
            throws RemoteException
        {
            if (zzaNQ)
            {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            String s = zzTC.getContext().getPackageName();
            zza zza1 = new zza(this) {

                final zzc zzaNT;

                public void zza(Status status, GoogleNowAuthState googlenowauthstate)
                {
                    if (zzc.zza(zzaNT))
                    {
                        Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                    }
                    zzaNT.zza(new zzd(status, googlenowauthstate));
                }

            
            {
                zzaNT = zzc1;
                super();
            }
            };
            ((zzqa)zzqb1.zzoA()).zza(zza1, s, zzaNS);
        }

        protected Result zzb(Status status)
        {
            return zzbd(status);
        }

        protected com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult zzbd(Status status)
        {
            if (zzaNQ)
            {
                Log.d("SearchAuth", (new StringBuilder()).append("GetGoogleNowAuthImpl received failure: ").append(status.getStatusMessage()).toString());
            }
            return new zzd(status, null);
        }

        protected zzc(GoogleApiClient googleapiclient, String s)
        {
            super(SearchAuth.zzQf, googleapiclient);
            zzTC = googleapiclient;
            zzaNS = s;
        }
    }

    static class zzd
        implements com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult
    {

        private final Status zzQA;
        private final GoogleNowAuthState zzaNU;

        public GoogleNowAuthState getGoogleNowAuthState()
        {
            return zzaNU;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        zzd(Status status, GoogleNowAuthState googlenowauthstate)
        {
            zzQA = status;
            zzaNU = googlenowauthstate;
        }
    }


    public zzqc()
    {
    }

    public PendingResult clearToken(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zzb(googleapiclient, s));
    }

    public PendingResult getGoogleNowAuth(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zzc(googleapiclient, s));
    }
}
