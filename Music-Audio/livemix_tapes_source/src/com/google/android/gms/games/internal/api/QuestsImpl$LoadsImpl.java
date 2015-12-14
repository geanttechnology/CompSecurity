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

    public com.google.android.gms.games.quest.lt zzav(Status status)
    {
        return new com.google.android.gms.games.quest.Quests.LoadQuestsResult(status) {

            final Status zzQs;
            final QuestsImpl.LoadsImpl zzavI;

            public QuestBuffer getQuests()
            {
                return new QuestBuffer(DataHolder.zzbp(zzQs.getStatusCode()));
            }

            public Status getStatus()
            {
                return zzQs;
            }

            public void release()
            {
            }

            
            {
                zzavI = QuestsImpl.LoadsImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzav(status);
    }

    private _cls1.zzQs(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    >(GoogleApiClient googleapiclient, > >)
    {
        this(googleapiclient);
    }
}
