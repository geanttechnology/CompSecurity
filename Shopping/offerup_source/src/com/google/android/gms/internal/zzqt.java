// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.search.SearchAuthApi;

public class zzqt
    implements SearchAuthApi
{

    public zzqt()
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

    private class zzb extends zzlb.zza
    {

        private final GoogleApiClient zzVs;
        private final String zzaUN;
        private final boolean zzaUQ = Log.isLoggable("SearchAuth", 3);

        static boolean zza(zzb zzb1)
        {
            return zzb1.zzaUQ;
        }

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
        {
            zza((zzqs)zzb1);
        }

        protected void zza(zzqs zzqs1)
        {
            if (zzaUQ)
            {
                Log.d("SearchAuth", "ClearTokenImpl started");
            }
            String s = zzVs.getContext().getPackageName();
            class _cls1 extends zza
            {
                private class zza extends zzqq.zza
                {

                    public void zza(Status status, GoogleNowAuthState googlenowauthstate)
                    {
                        throw new UnsupportedOperationException();
                    }

                    public void zzbb(Status status)
                    {
                        throw new UnsupportedOperationException();
                    }

                    zza()
                    {
                    }
                }


                final zzb zzaUR;

                public void zzbb(Status status)
                {
                    if (zzb.zza(zzaUR))
                    {
                        Log.d("SearchAuth", "ClearTokenImpl success");
                    }
                    zzaUR.zzb(status);
                }

                _cls1()
                {
                    zzaUR = zzb.this;
                    super();
                }
            }

            _cls1 _lcls1 = new _cls1();
            ((zzqr)zzqs1.zzpc()).zzb(_lcls1, s, zzaUN);
        }

        protected Result zzb(Status status)
        {
            return zzd(status);
        }

        protected Status zzd(Status status)
        {
            if (zzaUQ)
            {
                Log.d("SearchAuth", (new StringBuilder("ClearTokenImpl received failure: ")).append(status.getStatusMessage()).toString());
            }
            return status;
        }

        protected zzb(GoogleApiClient googleapiclient, String s)
        {
            super(SearchAuth.zzRk, googleapiclient);
            zzVs = googleapiclient;
            zzaUN = s;
        }
    }


    private class zzc extends zzlb.zza
    {

        private final GoogleApiClient zzVs;
        private final boolean zzaUQ = Log.isLoggable("SearchAuth", 3);
        private final String zzaUS;

        static boolean zza(zzc zzc1)
        {
            return zzc1.zzaUQ;
        }

        protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
        {
            zza((zzqs)zzb1);
        }

        protected void zza(zzqs zzqs1)
        {
            if (zzaUQ)
            {
                Log.d("SearchAuth", "GetGoogleNowAuthImpl started");
            }
            String s = zzVs.getContext().getPackageName();
            class _cls1 extends zza
            {

                final zzc zzaUT;

                public void zza(Status status, GoogleNowAuthState googlenowauthstate)
                {
                    if (zzc.zza(zzaUT))
                    {
                        Log.d("SearchAuth", "GetGoogleNowAuthImpl success");
                    }
                    zzaUT.zzb(new zzd(status, googlenowauthstate));
                }

                _cls1()
                {
                    zzaUT = zzc.this;
                    super();
                }

                private class zzd
                    implements com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult
                {

                    private final Status zzSC;
                    private final GoogleNowAuthState zzaUU;

                    public GoogleNowAuthState getGoogleNowAuthState()
                    {
                        return zzaUU;
                    }

                    public Status getStatus()
                    {
                        return zzSC;
                    }

                    zzd(Status status, GoogleNowAuthState googlenowauthstate)
                    {
                        zzSC = status;
                        zzaUU = googlenowauthstate;
                    }
                }

            }

            _cls1 _lcls1 = new _cls1();
            ((zzqr)zzqs1.zzpc()).zza(_lcls1, s, zzaUS);
        }

        protected Result zzb(Status status)
        {
            return zzbc(status);
        }

        protected com.google.android.gms.search.SearchAuthApi.GoogleNowAuthResult zzbc(Status status)
        {
            if (zzaUQ)
            {
                Log.d("SearchAuth", (new StringBuilder("GetGoogleNowAuthImpl received failure: ")).append(status.getStatusMessage()).toString());
            }
            return new zzd(status, null);
        }

        protected zzc(GoogleApiClient googleapiclient, String s)
        {
            super(SearchAuth.zzRk, googleapiclient);
            zzVs = googleapiclient;
            zzaUS = s;
        }
    }

}
