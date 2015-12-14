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
import com.google.android.gms.internal.zzln;
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
    private final int zzUS;
    private final String zzaoB;
    private final long zzasc;
    private final GameEntity zzaxY;
    private final String zzayQ;
    private final long zzayR;
    private final Uri zzayS;
    private final String zzayT;
    private final long zzayU;
    private final Uri zzayV;
    private final String zzayW;
    private final long zzayX;
    private final long zzayY;
    private final ArrayList zzayZ;

    QuestEntity(int i, GameEntity gameentity, String s, long l, Uri uri, String s1, 
            String s2, long l1, long l2, Uri uri1, String s3, 
            String s4, long l3, long l4, int j, int k, 
            ArrayList arraylist)
    {
        mVersionCode = i;
        zzaxY = gameentity;
        zzayQ = s;
        zzayR = l;
        zzayS = uri;
        zzayT = s1;
        zzaoB = s2;
        zzayU = l1;
        zzasc = l2;
        zzayV = uri1;
        zzayW = s3;
        mName = s4;
        zzayX = l3;
        zzayY = l4;
        mState = j;
        zzUS = k;
        zzayZ = arraylist;
    }

    public QuestEntity(Quest quest)
    {
        mVersionCode = 2;
        zzaxY = new GameEntity(quest.getGame());
        zzayQ = quest.getQuestId();
        zzayR = quest.getAcceptedTimestamp();
        zzaoB = quest.getDescription();
        zzayS = quest.getBannerImageUri();
        zzayT = quest.getBannerImageUrl();
        zzayU = quest.getEndTimestamp();
        zzayV = quest.getIconImageUri();
        zzayW = quest.getIconImageUrl();
        zzasc = quest.getLastUpdatedTimestamp();
        mName = quest.getName();
        zzayX = quest.zzva();
        zzayY = quest.getStartTimestamp();
        mState = quest.getState();
        zzUS = quest.getType();
        quest = quest.zzuZ();
        int j = quest.size();
        zzayZ = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            zzayZ.add((MilestoneEntity)(MilestoneEntity)((Milestone)quest.get(i)).freeze());
        }

    }

    static int zza(Quest quest)
    {
        return zzw.hashCode(new Object[] {
            quest.getGame(), quest.getQuestId(), Long.valueOf(quest.getAcceptedTimestamp()), quest.getBannerImageUri(), quest.getDescription(), Long.valueOf(quest.getEndTimestamp()), quest.getIconImageUri(), Long.valueOf(quest.getLastUpdatedTimestamp()), quest.zzuZ(), quest.getName(), 
            Long.valueOf(quest.zzva()), Long.valueOf(quest.getStartTimestamp()), Integer.valueOf(quest.getState())
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
        if (!zzw.equal(((Quest) (obj)).getGame(), quest.getGame()) || !zzw.equal(((Quest) (obj)).getQuestId(), quest.getQuestId()) || !zzw.equal(Long.valueOf(((Quest) (obj)).getAcceptedTimestamp()), Long.valueOf(quest.getAcceptedTimestamp())) || !zzw.equal(((Quest) (obj)).getBannerImageUri(), quest.getBannerImageUri()) || !zzw.equal(((Quest) (obj)).getDescription(), quest.getDescription()) || !zzw.equal(Long.valueOf(((Quest) (obj)).getEndTimestamp()), Long.valueOf(quest.getEndTimestamp())) || !zzw.equal(((Quest) (obj)).getIconImageUri(), quest.getIconImageUri()) || !zzw.equal(Long.valueOf(((Quest) (obj)).getLastUpdatedTimestamp()), Long.valueOf(quest.getLastUpdatedTimestamp())) || !zzw.equal(((Quest) (obj)).zzuZ(), quest.zzuZ()) || !zzw.equal(((Quest) (obj)).getName(), quest.getName()) || !zzw.equal(Long.valueOf(((Quest) (obj)).zzva()), Long.valueOf(quest.zzva())) || !zzw.equal(Long.valueOf(((Quest) (obj)).getStartTimestamp()), Long.valueOf(quest.getStartTimestamp())))
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
        return zzw.zzu(quest).zzg("Game", quest.getGame()).zzg("QuestId", quest.getQuestId()).zzg("AcceptedTimestamp", Long.valueOf(quest.getAcceptedTimestamp())).zzg("BannerImageUri", quest.getBannerImageUri()).zzg("BannerImageUrl", quest.getBannerImageUrl()).zzg("Description", quest.getDescription()).zzg("EndTimestamp", Long.valueOf(quest.getEndTimestamp())).zzg("IconImageUri", quest.getIconImageUri()).zzg("IconImageUrl", quest.getIconImageUrl()).zzg("LastUpdatedTimestamp", Long.valueOf(quest.getLastUpdatedTimestamp())).zzg("Milestones", quest.zzuZ()).zzg("Name", quest.getName()).zzg("NotifyTimestamp", Long.valueOf(quest.zzva())).zzg("StartTimestamp", Long.valueOf(quest.getStartTimestamp())).zzg("State", Integer.valueOf(quest.getState())).toString();
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
        return zzayR;
    }

    public Uri getBannerImageUri()
    {
        return zzayS;
    }

    public String getBannerImageUrl()
    {
        return zzayT;
    }

    public Milestone getCurrentMilestone()
    {
        return (Milestone)zzuZ().get(0);
    }

    public String getDescription()
    {
        return zzaoB;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzaoB, chararraybuffer);
    }

    public long getEndTimestamp()
    {
        return zzayU;
    }

    public Game getGame()
    {
        return zzaxY;
    }

    public Uri getIconImageUri()
    {
        return zzayV;
    }

    public String getIconImageUrl()
    {
        return zzayW;
    }

    public long getLastUpdatedTimestamp()
    {
        return zzasc;
    }

    public String getName()
    {
        return mName;
    }

    public void getName(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(mName, chararraybuffer);
    }

    public String getQuestId()
    {
        return zzayQ;
    }

    public long getStartTimestamp()
    {
        return zzayY;
    }

    public int getState()
    {
        return mState;
    }

    public int getType()
    {
        return zzUS;
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
        return zzayX <= System.currentTimeMillis() + 0x1b7740L;
    }

    public String toString()
    {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        QuestEntityCreator.zza(this, parcel, i);
    }

    public List zzuZ()
    {
        return new ArrayList(zzayZ);
    }

    public long zzva()
    {
        return zzayX;
    }

}
