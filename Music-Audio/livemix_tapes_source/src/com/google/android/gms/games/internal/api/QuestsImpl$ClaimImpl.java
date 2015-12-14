// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.quest.Milestone;
import com.google.android.gms.games.quest.Quest;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            QuestsImpl

private static abstract class <init> extends com.google.android.gms.games.hodImpl
{

    public com.google.android.gms.games.quest.Result zzau(Status status)
    {
        return new com.google.android.gms.games.quest.Quests.ClaimMilestoneResult(status) {

            final Status zzQs;
            final QuestsImpl.ClaimImpl zzavH;

            public Milestone getMilestone()
            {
                return null;
            }

            public Quest getQuest()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzavH = QuestsImpl.ClaimImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzau(status);
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
