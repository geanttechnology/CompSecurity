// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.People;
import com.google.android.gms.plus.Plus;
import com.google.android.gms.plus.internal.zze;
import com.google.android.gms.plus.model.people.Person;
import com.google.android.gms.plus.model.people.PersonBuffer;
import java.util.Collection;

public final class zzlp
    implements People
{

    public zzlp()
    {
    }

    public Person getCurrentPerson(GoogleApiClient googleapiclient)
    {
        return Plus.zzf(googleapiclient, true).zzvy();
    }

    public PendingResult load(GoogleApiClient googleapiclient, Collection collection)
    {
        return googleapiclient.zza(new zza(googleapiclient, collection) {

            final zzlp zzazy;
            final Collection zzazz;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            {
                zza((zze)zza1);
            }

            protected void zza(zze zze1)
            {
                zze1.zza(this, zzazz);
            }

            
            {
                zzazy = zzlp.this;
                zzazz = collection;
                super(googleapiclient);
            }
        });
    }

    public transient PendingResult load(GoogleApiClient googleapiclient, String as[])
    {
        return googleapiclient.zza(new zza(googleapiclient, as) {

            final String zzazA[];
            final zzlp zzazy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            {
                zza((zze)zza1);
            }

            protected void zza(zze zze1)
            {
                zze1.zzd(this, zzazA);
            }

            
            {
                zzazy = zzlp.this;
                zzazA = as;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadConnected(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zza(googleapiclient) {

            final zzlp zzazy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            {
                zza((zze)zza1);
            }

            protected void zza(zze zze1)
            {
                zze1.zzj(this);
            }

            
            {
                zzazy = zzlp.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadVisible(GoogleApiClient googleapiclient, int i, String s)
    {
        return googleapiclient.zza(new zza(googleapiclient, i, s) {
            private class zza extends com.google.android.gms.plus.Plus.zza
            {

                public Result createFailedResult(Status status)
                {
                    return zzaK(status);
                }

                public com.google.android.gms.plus.People.LoadPeopleResult zzaK(Status status)
                {
                    return new com.google.android.gms.plus.People.LoadPeopleResult(status) {

                        final Status zzKj;
                        final zza zzazB;

                        public String getNextPageToken()
                        {
                            return null;
                        }

                        public PersonBuffer getPersonBuffer()
                        {
                            return null;
                        }

                        public Status getStatus()
                        {
                            return zzKj;
                        }

                        public void release()
                        {
                        }

                        
                        {
                            zzazB = zza.this;
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


            final String zzazq;
            final int zzazx;
            final zzlp zzazy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            {
                zza((zze)zza1);
            }

            protected void zza(zze zze1)
            {
                setCancelToken(zze1.zza(this, zzazx, zzazq));
            }

            
            {
                zzazy = zzlp.this;
                zzazx = i;
                zzazq = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadVisible(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zza(googleapiclient, s) {

            final String zzazq;
            final zzlp zzazy;

            protected volatile void zza(com.google.android.gms.common.api.Api.zza zza1)
            {
                zza((zze)zza1);
            }

            protected void zza(zze zze1)
            {
                setCancelToken(zze1.zzr(this, zzazq));
            }

            
            {
                zzazy = zzlp.this;
                zzazq = s;
                super(googleapiclient);
            }
        });
    }
}
