// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.QuestBuffer;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            QuestsImpl

private static abstract class <init> extends com.google.android.gms.games.hodImpl
{

    public com.google.android.gms.games.quest.lt zzau(Status status)
    {
        return new com.google.android.gms.games.quest.Quests.LoadQuestsResult(status) {

            final Status zzVb;
            final QuestsImpl.LoadsImpl zzayg;

            public QuestBuffer getQuests()
            {
                return new QuestBuffer(DataHolder.zzbu(zzVb.getStatusCode()));
            }

            public Status getStatus()
            {
                return zzVb;
            }

            public void release()
            {
            }

            
            {
                zzayg = QuestsImpl.LoadsImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzau(status);
    }

    private _cls1.zzVb(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    >(GoogleApiClient googleapiclient, > >)
    {
        this(googleapiclient);
    }
}
