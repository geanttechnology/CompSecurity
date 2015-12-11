// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.quest;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;

// Referenced classes of package com.google.android.gms.games.quest:
//            Milestone, MilestoneEntityCreator

public final class MilestoneEntity
    implements SafeParcelable, Milestone
{

    public static final android.os.Parcelable.Creator CREATOR = new MilestoneEntityCreator();
    private final int mState;
    private final int mVersionCode;
    private final long zzaBn;
    private final long zzaBo;
    private final byte zzaBp[];
    private final String zzavb;
    private final String zzawj;

    MilestoneEntity(int i, String s, long l, long l1, byte abyte0[], 
            int j, String s1)
    {
        mVersionCode = i;
        zzawj = s;
        zzaBn = l;
        zzaBo = l1;
        zzaBp = abyte0;
        mState = j;
        zzavb = s1;
    }

    public MilestoneEntity(Milestone milestone)
    {
        mVersionCode = 4;
        zzawj = milestone.getMilestoneId();
        zzaBn = milestone.getCurrentProgress();
        zzaBo = milestone.getTargetProgress();
        mState = milestone.getState();
        zzavb = milestone.getEventId();
        milestone = milestone.getCompletionRewardData();
        if (milestone == null)
        {
            zzaBp = null;
            return;
        } else
        {
            zzaBp = new byte[milestone.length];
            System.arraycopy(milestone, 0, zzaBp, 0, milestone.length);
            return;
        }
    }

    static int zza(Milestone milestone)
    {
        return zzw.hashCode(new Object[] {
            milestone.getMilestoneId(), Long.valueOf(milestone.getCurrentProgress()), Long.valueOf(milestone.getTargetProgress()), Integer.valueOf(milestone.getState()), milestone.getEventId()
        });
    }

    static boolean zza(Milestone milestone, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Milestone) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (milestone == obj) goto _L4; else goto _L3
_L3:
        obj = (Milestone)obj;
        if (!zzw.equal(((Milestone) (obj)).getMilestoneId(), milestone.getMilestoneId()) || !zzw.equal(Long.valueOf(((Milestone) (obj)).getCurrentProgress()), Long.valueOf(milestone.getCurrentProgress())) || !zzw.equal(Long.valueOf(((Milestone) (obj)).getTargetProgress()), Long.valueOf(milestone.getTargetProgress())) || !zzw.equal(Integer.valueOf(((Milestone) (obj)).getState()), Integer.valueOf(milestone.getState())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((Milestone) (obj)).getEventId(), milestone.getEventId())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(Milestone milestone)
    {
        return zzw.zzv(milestone).zzg("MilestoneId", milestone.getMilestoneId()).zzg("CurrentProgress", Long.valueOf(milestone.getCurrentProgress())).zzg("TargetProgress", Long.valueOf(milestone.getTargetProgress())).zzg("State", Integer.valueOf(milestone.getState())).zzg("CompletionRewardData", milestone.getCompletionRewardData()).zzg("EventId", milestone.getEventId()).toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Milestone freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public byte[] getCompletionRewardData()
    {
        return zzaBp;
    }

    public long getCurrentProgress()
    {
        return zzaBn;
    }

    public String getEventId()
    {
        return zzavb;
    }

    public String getMilestoneId()
    {
        return zzawj;
    }

    public int getState()
    {
        return mState;
    }

    public long getTargetProgress()
    {
        return zzaBo;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public int hashCode()
    {
        return zza(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        MilestoneEntityCreator.zza(this, parcel, i);
    }

}
