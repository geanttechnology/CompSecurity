// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.net.Uri;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.Moments;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.moments.Moment;
import com.google.android.gms.plus.model.moments.MomentBuffer;

public final class zzlo
    implements Moments
{

    public zzlo()
    {
    }

    public PendingResult load(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zza(googleapiclient) {
            private class zza extends com.google.android.gms.plus.Plus.zza
            {

                public Result createFailedResult(Status status)
                {
                    return zzaJ(status);
                }

                public com.google.android.gms.plus.Moments.LoadMomentsResult zzaJ(Status status)
                {
                    return new com.google.android.gms.plus.Moments.LoadMomentsResult(status) {

                        final Status zzKj;
                        final zza zzazw;

                        public MomentBuffer getMomentBuffer()
                        {
                            return null;
                        }

                        public String getNextPageToken()
                        {
                            return null;
                        }

                        public Status getStatus()
                        {
                            return zzKj;
                        }

                        public String getUpdated()
                        {
                            return null;
                        }

                        public void release()
                        {
                        }

                        
                        {
                            zzazw = zza.this;
                            zzKj = status;
                            super();
                        }
                    };
                }

                private zza(GoogleApiClient googleapiclient)
                {
                    super(googleapiclient);
                }

            }


            final zzlo zzazp;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            {
                zza((zze)zza1);
            }

            protected void zza(zze zze1)
            {
                zze1.zzi(this);
            }

            
            {
                zzazp = zzlo.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult load(GoogleApiClient googleapiclient, int i, String s, Uri uri, String s1, String s2)
    {
        return googleapiclient.zza(new zza(googleapiclient, i, s, uri, s1, s2) {

            final int zzakf;
            final zzlo zzazp;
            final String zzazq;
            final Uri zzazr;
            final String zzazs;
            final String zzazt;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            {
                zza((zze)zza1);
            }

            protected void zza(zze zze1)
            {
                zze1.zza(this, zzakf, zzazq, zzazr, zzazs, zzazt);
            }

            
            {
                zzazp = zzlo.this;
                zzakf = i;
                zzazq = s;
                zzazr = uri;
                zzazs = s1;
                zzazt = s2;
                super(googleapiclient);
            }
        });
    }

    public PendingResult remove(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zzb(new zzb(googleapiclient, s) {
            private class zzb extends com.google.android.gms.plus.Plus.zza
            {

                public Result createFailedResult(Status status)
                {
                    return zzb(status);
                }

                public Status zzb(Status status)
                {
                    return status;
                }

                private zzb(GoogleApiClient googleapiclient)
                {
                    super(googleapiclient);
                }

            }


            final zzlo zzazp;
            final String zzazv;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            {
                zza((zze)zza1);
            }

            protected void zza(zze zze1)
            {
                zze1.zzdp(zzazv);
                setResult(Status.zzQU);
            }

            
            {
                zzazp = zzlo.this;
                zzazv = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult write(GoogleApiClient googleapiclient, Moment moment)
    {
        return googleapiclient.zzb(new zzc(googleapiclient, moment) {
            private class zzc extends com.google.android.gms.plus.Plus.zza
            {

                public Result createFailedResult(Status status)
                {
                    return zzb(status);
                }

                public Status zzb(Status status)
                {
                    return status;
                }

                private zzc(GoogleApiClient googleapiclient)
                {
                    super(googleapiclient);
                }

            }


            final zzlo zzazp;
            final Moment zzazu;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            {
                zza((zze)zza1);
            }

            protected void zza(zze zze1)
            {
                zze1.zza(this, zzazu);
            }

            
            {
                zzazp = zzlo.this;
                zzazu = moment;
                super(googleapiclient);
            }
        });
    }
}
