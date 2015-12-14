// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.safetynet.AttestationData;
import com.google.android.gms.safetynet.SafeBrowsingData;
import com.google.android.gms.safetynet.SafetyNetApi;
import java.util.List;

// Referenced classes of package com.google.android.gms.internal:
//            zzpt, zzpu, zzps, zzpx

public class zzpw
    implements SafetyNetApi
{
    static class zza
        implements com.google.android.gms.safetynet.SafetyNetApi.AttestationResult
    {

        private final Status zzQA;
        private final AttestationData zzaNH;

        public String getJwsResult()
        {
            if (zzaNH == null)
            {
                return null;
            } else
            {
                return zzaNH.getJwsResult();
            }
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public zza(Status status, AttestationData attestationdata)
        {
            zzQA = status;
            zzaNH = attestationdata;
        }
    }

    static abstract class zzb extends zzpt
    {

        protected zzpu zzaNI;

        protected Result zzb(Status status)
        {
            return zzba(status);
        }

        protected com.google.android.gms.safetynet.SafetyNetApi.AttestationResult zzba(Status status)
        {
            return new zza(status, null);
        }

        public zzb(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
            zzaNI = new _cls1(this);
        }
    }

    static abstract class zzc extends zzpt
    {

        protected zzpu zzaNI;

        protected Result zzb(Status status)
        {
            return zzbb(status);
        }

        protected com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult zzbb(Status status)
        {
            return new zzd(status, null);
        }

        public zzc(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
            zzaNI = new _cls1(this);
        }
    }

    static class zzd
        implements com.google.android.gms.safetynet.SafetyNetApi.SafeBrowsingResult
    {

        private Status zzQA;
        private String zzaNB;
        private final SafeBrowsingData zzaNL;

        public String getMetadata()
        {
            return zzaNB;
        }

        public Status getStatus()
        {
            return zzQA;
        }

        public zzd(Status status, SafeBrowsingData safebrowsingdata)
        {
            zzQA = status;
            zzaNL = safebrowsingdata;
            zzaNB = null;
            if (zzaNL != null)
            {
                zzaNB = zzaNL.getMetadata();
                return;
            } else
            {
                zzQA = new Status(8);
                return;
            }
        }
    }


    public zzpw()
    {
    }

    public PendingResult attest(GoogleApiClient googleapiclient, byte abyte0[])
    {
        return googleapiclient.zza(new zzb(googleapiclient, abyte0) {

            final byte zzaND[];
            final zzpw zzaNE;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                throws RemoteException
            {
                zza((zzpx)zzb1);
            }

            protected void zza(zzpx zzpx1)
                throws RemoteException
            {
                zzpx1.zza(zzaNI, zzaND);
            }

            
            {
                zzaNE = zzpw.this;
                zzaND = abyte0;
                super(googleapiclient);
            }
        });
    }

    public PendingResult lookupUri(GoogleApiClient googleapiclient, List list, String s)
    {
        if (list == null)
        {
            throw new IllegalArgumentException("Null threatTypes in lookupUri");
        }
        if (TextUtils.isEmpty(s))
        {
            throw new IllegalArgumentException("Null or empty uri in lookupUri");
        } else
        {
            return googleapiclient.zza(new zzc(googleapiclient, list, s) {

                final zzpw zzaNE;
                final List zzaNF;
                final String zzaNG;

                protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb1)
                    throws RemoteException
                {
                    zza((zzpx)zzb1);
                }

                protected void zza(zzpx zzpx1)
                    throws RemoteException
                {
                    zzpx1.zza(zzaNI, zzaNF, 1, zzaNG);
                }

            
            {
                zzaNE = zzpw.this;
                zzaNF = list;
                zzaNG = s;
                super(googleapiclient);
            }
            });
        }
    }

    // Unreferenced inner class com/google/android/gms/internal/zzpw$zzb$1

/* anonymous class */
    class zzb._cls1 extends zzps
    {

        final zzb zzaNJ;

        public void zza(Status status, AttestationData attestationdata)
        {
            zzaNJ.zza(new zza(status, attestationdata));
        }

            
            {
                zzaNJ = zzb1;
                super();
            }
    }


    // Unreferenced inner class com/google/android/gms/internal/zzpw$zzc$1

/* anonymous class */
    class zzc._cls1 extends zzps
    {

        final zzc zzaNK;

        public void zza(Status status, SafeBrowsingData safebrowsingdata)
        {
            zzaNK.zza(new zzd(status, safebrowsingdata));
        }

            
            {
                zzaNK = zzc1;
                super();
            }
    }

}
