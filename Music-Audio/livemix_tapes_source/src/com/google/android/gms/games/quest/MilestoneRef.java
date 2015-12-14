// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.internal.GamesLog;

// Referenced classes of package com.google.android.gms.games.quest:
//            Milestone, MilestoneEntity

public final class MilestoneRef extends zzc
    implements Milestone
{

    MilestoneRef(DataHolder dataholder, int i)
    {
        super(dataholder, i);
    }

    private long zzuY()
    {
        return getLong("initial_value");
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return MilestoneEntity.zza(this, obj);
    }

    public Milestone freeze()
    {
        return new MilestoneEntity(this);
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public byte[] getCompletionRewardData()
    {
        return getByteArray("completion_reward_data");
    }

    public long getCurrentProgress()
    {
        long l1 = 0L;
        getState();
        JVM INSTR tableswitch 1 4: default 36
    //                   1 86
    //                   2 91
    //                   3 78
    //                   4 78;
           goto _L1 _L2 _L3 _L4 _L4
_L1:
        long l = 0L;
_L6:
        if (l < 0L)
        {
            GamesLog.zzx("MilestoneRef", "Current progress should never be negative");
            l = l1;
        }
        l1 = l;
        if (l > getTargetProgress())
        {
            GamesLog.zzx("MilestoneRef", "Current progress should never exceed target progress");
            l1 = getTargetProgress();
        }
        return l1;
_L4:
        l = getTargetProgress();
        continue; /* Loop/switch isn't completed */
_L2:
        l = 0L;
        continue; /* Loop/switch isn't completed */
_L3:
        long l2 = getLong("current_value");
        l = l2;
        if (getLong("quest_state") != 6L)
        {
            l = l2 - zzuY();
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public String getEventId()
    {
        return getString("external_event_id");
    }

    public String getMilestoneId()
    {
        return getString("external_milestone_id");
    }

    public int getState()
    {
        return getInteger("milestone_state");
    }

    public long getTargetProgress()
    {
        return getLong("target_value");
    }

    public int hashCode()
    {
        return MilestoneEntity.zza(this);
    }

    public String toString()
    {
        return MilestoneEntity.zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        ((MilestoneEntity)freeze()).writeToParcel(parcel, i);
    }
}
