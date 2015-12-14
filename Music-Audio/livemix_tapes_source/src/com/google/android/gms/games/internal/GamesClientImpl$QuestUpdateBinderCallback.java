// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.internal;

import com.google.android.gms.common.api.zzl;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.quest.Quest;
import com.google.android.gms.games.quest.QuestBuffer;

// Referenced classes of package com.google.android.gms.games.internal:
//            AbstractGamesCallbacks, GamesClientImpl

private static final class zzaiL extends AbstractGamesCallbacks
{

    private final zzl zzaiL;

    private Quest zzX(DataHolder dataholder)
    {
        QuestBuffer questbuffer;
        questbuffer = new QuestBuffer(dataholder);
        dataholder = null;
        if (questbuffer.getCount() > 0)
        {
            dataholder = (Quest)((Quest)questbuffer.get(0)).freeze();
        }
        questbuffer.release();
        return dataholder;
        dataholder;
        questbuffer.release();
        throw dataholder;
    }

    public void zzP(DataHolder dataholder)
    {
        dataholder = zzX(dataholder);
        if (dataholder != null)
        {
            zzaiL.zza(new it>(dataholder));
        }
    }

    (zzl zzl1)
    {
        zzaiL = zzl1;
    }
}
