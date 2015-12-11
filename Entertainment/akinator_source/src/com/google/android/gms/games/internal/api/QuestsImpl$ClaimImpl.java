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

    public com.google.android.gms.games.quest.Result zzat(Status status)
    {
        return new com.google.android.gms.games.quest.Quests.ClaimMilestoneResult(status) {

            final Status zzVb;
            final QuestsImpl.ClaimImpl zzayf;

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
                return zzVb;
            }

            
            {
                zzayf = QuestsImpl.ClaimImpl.this;
                zzVb = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzat(status);
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
