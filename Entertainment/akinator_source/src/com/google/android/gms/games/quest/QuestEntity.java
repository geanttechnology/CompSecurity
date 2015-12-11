// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.quest;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzmo;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.google.android.gms.games.quest:
//            Quest, QuestEntityCreator, Milestone, MilestoneEntity

public final class QuestEntity
    implements SafeParcelable, Quest
{

    public static final android.os.Parcelable.Creator CREATOR = new QuestEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final int zzWJ;
    private final GameEntity zzaAy;
    private final String zzaBq;
    private final long zzaBr;
    private final Uri zzaBs;
    private final String zzaBt;
    private final long zzaBu;
    private final Uri zzaBv;
    private final String zzaBw;
    private final long zzaBx;
    private final long zzaBy;
    private final ArrayList zzaBz;
    private final String zzaqZ;
    private final long zzauA;

    QuestEntity(int i, GameEntity gameentity, String s, long l, Uri uri, String s1, 
            String s2, long l1, long l2, Uri uri1, String s3, 
            String s4, long l3, long l4, int j, int k, 
            ArrayList arraylist)
    {
        mVersionCode = i;
        zzaAy = gameentity;
        zzaBq = s;
        zzaBr = l;
        zzaBs = uri;
        zzaBt = s1;
        zzaqZ = s2;
        zzaBu = l1;
        zzauA = l2;
        zzaBv = uri1;
        zzaBw = s3;
        mName = s4;
        zzaBx = l3;
        zzaBy = l4;
        mState = j;
        zzWJ = k;
        zzaBz = arraylist;
    }

    public QuestEntity(Quest quest)
    {
        mVersionCode = 2;
        zzaAy = new GameEntity(quest.getGame());
        zzaBq = quest.getQuestId();
        zzaBr = quest.getAcceptedTimestamp();
        zzaqZ = quest.getDescription();
        zzaBs = quest.getBannerImageUri();
        zzaBt = quest.getBannerImageUrl();
        zzaBu = quest.getEndTimestamp();
        zzaBv = quest.getIconImageUri();
        zzaBw = quest.getIconImageUrl();
        zzauA = quest.getLastUpdatedTimestamp();
        mName = quest.getName();
        zzaBx = quest.zzvQ();
        zzaBy = quest.getStartTimestamp();
        mState = quest.getState();
        zzWJ = quest.getType();
        quest = quest.zzvP();
        int j = quest.size();
        zzaBz = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            zzaBz.add((MilestoneEntity)(MilestoneEntity)((Milestone)quest.get(i)).freeze());
        }

    }

    static int zza(Quest quest)
    {
        return zzw.hashCode(new Object[] {
            quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.zzvP(), quest.getName(), 
            Long.valueOf(quest.zzvQ()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState())
        });
    }

    static boolean zza(Quest quest, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Quest) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (quest == obj) goto _L4; else goto _L3
_L3:
        obj = (Quest)obj;
        if (!zzw.equal(((Quest) (obj)).getGame(), quest.getGame()) || !zzw.equal(((Quest) (obj)).getQuestId(), quest.getQuestId()) || !zzw.equal(Long.valueOf(((Quest) (obj)).getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) || !zzw.equal(((Quest) (obj)).getBannerImageUri(), quest.getBannerImageUri()) || !zzw.equal(((Quest) (obj)).getDescription(), quest.getDescription()) || !zzw.equal(Long.valueOf(((Quest) (obj)).getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) || !zzw.equal(((Quest) (obj)).getIconImageUri(), quest.getIconImageUri()) || !zzw.equal(Long.valueOf(((Quest) (obj)).getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) || !zzw.equal(((Quest) (obj)).zzvP(), quest.zzvP()) || !zzw.equal(((Quest) (obj)).getName(), quest.getName()) || !zzw.equal(Long.valueOf(((Quest) (obj)).zzvQ()), Long.valueOf(quest.zzvQ())) || !zzw.equal(Long.valueOf(((Quest) (obj)).getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(Integer.valueOf(((Quest) (obj)).getState()), Integer.valueOf(quest.getState()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(Quest quest)
    {
        return zzw.zzv(quest).zzg("Game", quest.getGame()).zzg("QuestId", quest.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).zzg("BannerImageUri", quest.getBannerImageUri()).zzg("BannerImageUrl", quest.getBannerImageUrl()).zzg("Description", quest.getDescription()).zzg("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).zzg("IconImageUri", quest.getIconImageUri()).zzg("IconImageUrl", quest.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).zzg("Milestones", quest.zzvP()).zzg("Name", quest.getName()).zzg("NotifyTimestamp", Long.valueOf(quest.zzvQ())).zzg("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).zzg("State", Integer.valueOf(quest.getState())).toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Quest freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public long getAcceptedTimestamp()
    {
        return zzaBr;
    }

    public Uri getBannerImageUri()
    {
        return zzaBs;
    }

    public String getBannerImageUrl()
    {
        return zzaBt;
    }

    public Milestone getCurrentMilestone()
    {
        return (Milestone)zzvP().get(0);
    }

    public String getDescription()
    {
        return zzaqZ;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzaqZ, chararraybuffer);
    }

    public long getEndTimestamp()
    {
        return zzaBu;
    }

    public Game getGame()
    {
        return zzaAy;
    }

    public Uri getIconImageUri()
    {
        return zzaBv;
    }

    public String getIconImageUrl()
    {
        return zzaBw;
    }

    public long getLastUpdatedTimestamp()
    {
        return zzauA;
    }

    public String getName()
    {
        return mName;
    }

    public void getName(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(mName, chararraybuffer);
    }

    public String getQuestId()
    {
        return zzaBq;
    }

    public long getStartTimestamp()
    {
        return zzaBy;
    }

    public int getState()
    {
        return mState;
    }

    public int getType()
    {
        return zzWJ;
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

    public boolean isEndingSoon()
    {
        return zzaBx <= System.currentTimeMillis() + 0x1b7740L;
    }

    public String toString()
    {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        QuestEntityCreator.zza(this, parcel, i);
    }

    public List zzvP()
    {
        return new ArrayList(zzaBz);
    }

    public long zzvQ()
    {
        return zzaBx;
    }

}
