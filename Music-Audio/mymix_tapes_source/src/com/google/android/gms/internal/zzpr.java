// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.RemoteException;
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

public final class zzpr
    implements People
{
    private static abstract class zza extends com.google.android.gms.plus.Plus.zza
    {

        public com.google.android.gms.plus.People.LoadPeopleResult zzaZ(Status status)
        {
            return new com.google.android.gms.plus.People.LoadPeopleResult(this, status) {

                final Status zzQs;
                final zza zzaLR;

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
                    return zzQs;
                }

                public void release()
                {
                }

            
            {
                zzaLR = zza1;
                zzQs = status;
                super();
            }
            };
        }

        public Result zzb(Status status)
        {
            return zzaZ(status);
        }

        private zza(GoogleApiClient googleapiclient)
        {
            super(googleapiclient);
        }

    }


    public zzpr()
    {
    }

    public Person getCurrentPerson(GoogleApiClient googleapiclient)
    {
        return Plus.zzf(googleapiclient, true).zzyI();
    }

    public PendingResult load(GoogleApiClient googleapiclient, Collection collection)
    {
        return googleapiclient.zza(new zza(googleapiclient, collection) {

            final zzpr zzaLO;
            final Collection zzaLP;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zze)zzb);
            }

            protected void zza(zze zze1)
            {
                zze1.zza(this, zzaLP);
            }

            
            {
                zzaLO = zzpr.this;
                zzaLP = collection;
                super(googleapiclient);
            }
        });
    }

    public transient PendingResult load(GoogleApiClient googleapiclient, String as[])
    {
        return googleapiclient.zza(new zza(googleapiclient, as) {

            final zzpr zzaLO;
            final String zzaLQ[];

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zze)zzb);
            }

            protected void zza(zze zze1)
            {
                zze1.zzd(this, zzaLQ);
            }

            
            {
                zzaLO = zzpr.this;
                zzaLQ = as;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadConnected(GoogleApiClient googleapiclient)
    {
        return googleapiclient.zza(new zza(googleapiclient) {

            final zzpr zzaLO;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zze)zzb);
            }

            protected void zza(zze zze1)
            {
                zze1.zzl(this);
            }

            
            {
                zzaLO = zzpr.this;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadVisible(GoogleApiClient googleapiclient, int i, String s)
    {
        return googleapiclient.zza(new zza(googleapiclient, i, s) {

            final String zzaLG;
            final int zzaLN;
            final zzpr zzaLO;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zze)zzb);
            }

            protected void zza(zze zze1)
            {
                zza(zze1.zza(this, zzaLN, zzaLG));
            }

            
            {
                zzaLO = zzpr.this;
                zzaLN = i;
                zzaLG = s;
                super(googleapiclient);
            }
        });
    }

    public PendingResult loadVisible(GoogleApiClient googleapiclient, String s)
    {
        return googleapiclient.zza(new zza(googleapiclient, s) {

            final String zzaLG;
            final zzpr zzaLO;

            protected volatile void zza(com.google.android.gms.common.api.Api.zzb zzb)
                throws RemoteException
            {
                zza((zze)zzb);
            }

            protected void zza(zze zze1)
            {
                zza(zze1.zzq(this, zzaLG));
            }

            
            {
                zzaLO = zzpr.this;
                zzaLG = s;
                super(googleapiclient);
            }
        });
    }
}
