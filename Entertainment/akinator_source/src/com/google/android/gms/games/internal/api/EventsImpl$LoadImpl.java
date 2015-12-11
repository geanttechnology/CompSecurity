// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.event.EventBuffer;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            EventsImpl

private static abstract class <init> extends com.google.android.gms.games.thodImpl
{

    public com.google.android.gms.games.event.ult zzab(Status status)
    {
        return new com.google.android.gms.games.event.Events.LoadEventsResult(status) {

            final Status zzVb;
            final EventsImpl.LoadImpl zzaxh;

            public EventBuffer getEvents()
            {
                return new EventBuffer(DataHolder.zzbu(14));
            }

            public Status getStatus()
            {
                return zzVb;
            }

            public void release()
            {
            }

            
            {
                zzaxh = EventsImpl.LoadImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzab(status);
    }

    private _cls1.zzVb(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    t>(GoogleApiClient googleapiclient, t> t>)
    {
        this(googleapiclient);
    }
}
