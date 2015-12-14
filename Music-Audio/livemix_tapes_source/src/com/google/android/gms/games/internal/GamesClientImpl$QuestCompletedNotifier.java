// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestUpdateListener;

// Referenced classes of package com.google.android.gms.games.internal:
//            GamesClientImpl

private static final class zzasU
    implements com.google.android.gms.common.api.ier
{

    private final Quest zzasU;

    public void zza(QuestUpdateListener questupdatelistener)
    {
        questupdatelistener.onQuestCompleted(zzasU);
    }

    public void zznh()
    {
    }

    public void zzo(Object obj)
    {
        zza((QuestUpdateListener)obj);
    }

    (Quest quest)
    {
        zzasU = quest;
    }
}
