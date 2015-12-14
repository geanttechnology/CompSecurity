// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal.api;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.games.quest.Quest;

// Referenced classes of package com.google.android.gms.games.internal.api:
//            QuestsImpl

private static abstract class <init> extends com.google.android.gms.games.odImpl
{

    public com.google.android.gms.games.quest.lt zzat(Status status)
    {
        return new com.google.android.gms.games.quest.Quests.AcceptQuestResult(status) {

            final Status zzQs;
            final QuestsImpl.AcceptImpl zzavG;

            public Quest getQuest()
            {
                return null;
            }

            public Status getStatus()
            {
                return zzQs;
            }

            
            {
                zzavG = QuestsImpl.AcceptImpl.this;
                zzQs = status;
                super();
            }
        };
    }

    public Result zzb(Status status)
    {
        return zzat(status);
    }

    private _cls1.zzQs(GoogleApiClient googleapiclient)
    {
        super(googleapiclient);
    }

    (GoogleApiClient googleapiclient,  )
    {
        this(googleapiclient);
    }
}
