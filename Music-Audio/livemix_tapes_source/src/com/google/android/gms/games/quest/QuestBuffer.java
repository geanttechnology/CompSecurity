// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.quest;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzf;

// Referenced classes of package com.google.android.gms.games.quest:
//            QuestRef, Quest

public final class QuestBuffer extends zzf
{

    public QuestBuffer(DataHolder dataholder)
    {
        super(dataholder);
    }

    protected Object zzk(int i, int j)
    {
        return zzs(i, j);
    }

    protected String zznW()
    {
        return "external_quest_id";
    }

    protected Quest zzs(int i, int j)
    {
        return new QuestRef(zzYX, i, j);
    }
}
