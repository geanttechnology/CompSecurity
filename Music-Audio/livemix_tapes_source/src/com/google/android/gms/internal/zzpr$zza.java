// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.plus.model.people.PersonBuffer;

// Referenced classes of package com.google.android.gms.internal:
//            zzpr

private static abstract class piClient extends com.google.android.gms.plus.zza
{

    public com.google.android.gms.plus.adPeopleResult zzaZ(Status status)
    {
        return new com.google.android.gms.plus.People.LoadPeopleResult(status) {

            final Status zzQs;
            final zzpr.zza zzaLR;

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
                zzaLR = zzpr.zza.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzaZ(status);
    }

    private piClient(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    piClient(GoogleApiClient googleapiclient, piClient piclient)
    {
        this(googleapiclient);
    }
}
