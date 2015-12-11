// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.zzb;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzmo;

// Referenced classes of package com.google.android.gms.games.achievement:
//            Achievement, AchievementEntityCreator

public final class AchievementEntity
    implements SafeParcelable, Achievement
{

    public static final android.os.Parcelable.Creator CREATOR = new AchievementEntityCreator();
    private final String mName;
    private final int mState;
    private final int mVersionCode;
    private final int zzWJ;
    private final String zzaqZ;
    private final long zzauA;
    private final long zzauB;
    private final String zzauq;
    private final Uri zzaur;
    private final String zzaus;
    private final Uri zzaut;
    private final String zzauu;
    private final int zzauv;
    private final String zzauw;
    private final PlayerEntity zzaux;
    private final int zzauy;
    private final String zzauz;

    AchievementEntity(int i, String s, int j, String s1, String s2, Uri uri, String s3, 
            Uri uri1, String s4, int k, String s5, PlayerEntity playerentity, int l, int i1, 
            String s6, long l1, long l2)
    {
        mVersionCode = i;
        zzauq = s;
        zzWJ = j;
        mName = s1;
        zzaqZ = s2;
        zzaur = uri;
        zzaus = s3;
        zzaut = uri1;
        zzauu = s4;
        zzauv = k;
        zzauw = s5;
        zzaux = playerentity;
        mState = l;
        zzauy = i1;
        zzauz = s6;
        zzauA = l1;
        zzauB = l2;
    }

    public AchievementEntity(Achievement achievement)
    {
        mVersionCode = 1;
        zzauq = achievement.getAchievementId();
        zzWJ = achievement.getType();
        mName = achievement.getName();
        zzaqZ = achievement.getDescription();
        zzaur = achievement.getUnlockedImageUri();
        zzaus = achievement.getUnlockedImageUrl();
        zzaut = achievement.getRevealedImageUri();
        zzauu = achievement.getRevealedImageUrl();
        zzaux = (PlayerEntity)achievement.getPlayer().freeze();
        mState = achievement.getState();
        zzauA = achievement.getLastUpdatedTimestamp();
        zzauB = achievement.getXpValue();
        if (achievement.getType() == 1)
        {
            zzauv = achievement.getTotalSteps();
            zzauw = achievement.getFormattedTotalSteps();
            zzauy = achievement.getCurrentSteps();
            zzauz = achievement.getFormattedCurrentSteps();
        } else
        {
            zzauv = 0;
            zzauw = null;
            zzauy = 0;
            zzauz = null;
        }
        com.google.android.gms.common.internal.zzb.zzs(zzauq);
        com.google.android.gms.common.internal.zzb.zzs(zzaqZ);
    }

    static int zza(Achievement achievement)
    {
        int i;
        int j;
        if (achievement.getType() == 1)
        {
            j = achievement.getCurrentSteps();
            i = achievement.getTotalSteps();
        } else
        {
            i = 0;
            j = 0;
        }
        return zzw.hashCode(new Object[] {
            achievement.getAchievementId(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.getPlayer(), Integer.valueOf(j), Integer.valueOf(i)
        });
    }

    static boolean zza(Achievement achievement, Object obj)
    {
        boolean flag2 = true;
        if (obj instanceof Achievement) goto _L2; else goto _L1
_L1:
        boolean flag1 = false;
_L4:
        return flag1;
_L2:
        flag1 = flag2;
        if (achievement == obj) goto _L4; else goto _L3
_L3:
        obj = (Achievement)obj;
        boolean flag;
        if (achievement.getType() == 1)
        {
            flag1 = zzw.equal(Integer.valueOf(((Achievement) (obj)).getCurrentSteps()), Integer.valueOf(achievement.getCurrentSteps()));
            flag = zzw.equal(Integer.valueOf(((Achievement) (obj)).getTotalSteps()), Integer.valueOf(achievement.getTotalSteps()));
        } else
        {
            flag = true;
            flag1 = true;
        }
        if (!zzw.equal(((Achievement) (obj)).getAchievementId(), achievement.getAchievementId()) || !zzw.equal(((Achievement) (obj)).getName(), achievement.getName()) || !zzw.equal(Integer.valueOf(((Achievement) (obj)).getType()), Integer.valueOf(achievement.getType())) || !zzw.equal(((Achievement) (obj)).getDescription(), achievement.getDescription()) || !zzw.equal(Long.valueOf(((Achievement) (obj)).getXpValue()), Long.valueOf(achievement.getXpValue())) || !zzw.equal(Integer.valueOf(((Achievement) (obj)).getState()), Integer.valueOf(achievement.getState())) || !zzw.equal(Long.valueOf(((Achievement) (obj)).getLastUpdatedTimestamp()), Long.valueOf(achievement.getLastUpdatedTimestamp())) || !zzw.equal(((Achievement) (obj)).getPlayer(), achievement.getPlayer()) || !flag1)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag2;
        if (flag) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(Achievement achievement)
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzv(achievement).zzg("Id", achievement.getAchievementId()).zzg("Type", Integer.valueOf(achievement.getType())).zzg("Name", achievement.getName()).zzg("Description", achievement.getDescription()).zzg("Player", achievement.getPlayer()).zzg("State", Integer.valueOf(achievement.getState()));
        if (achievement.getType() == 1)
        {
            zza1.zzg("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            zza1.zzg("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return zza1.toString();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Achievement freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public String getAchievementId()
    {
        return zzauq;
    }

    public int getCurrentSteps()
    {
        boolean flag = true;
        if (getType() != 1)
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzb.zzZ(flag);
        return zztM();
    }

    public String getDescription()
    {
        return zzaqZ;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzaqZ, chararraybuffer);
    }

    public String getFormattedCurrentSteps()
    {
        boolean flag = true;
        if (getType() != 1)
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzb.zzZ(flag);
        return zztN();
    }

    public void getFormattedCurrentSteps(CharArrayBuffer chararraybuffer)
    {
        boolean flag = true;
        if (getType() != 1)
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzb.zzZ(flag);
        zzmo.zzb(zzauz, chararraybuffer);
    }

    public String getFormattedTotalSteps()
    {
        boolean flag = true;
        if (getType() != 1)
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzb.zzZ(flag);
        return zztL();
    }

    public void getFormattedTotalSteps(CharArrayBuffer chararraybuffer)
    {
        boolean flag = true;
        if (getType() != 1)
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzb.zzZ(flag);
        zzmo.zzb(zzauw, chararraybuffer);
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

    public Player getPlayer()
    {
        return zzaux;
    }

    public Uri getRevealedImageUri()
    {
        return zzaut;
    }

    public String getRevealedImageUrl()
    {
        return zzauu;
    }

    public int getState()
    {
        return mState;
    }

    public int getTotalSteps()
    {
        boolean flag = true;
        if (getType() != 1)
        {
            flag = false;
        }
        com.google.android.gms.common.internal.zzb.zzZ(flag);
        return zztK();
    }

    public int getType()
    {
        return zzWJ;
    }

    public Uri getUnlockedImageUri()
    {
        return zzaur;
    }

    public String getUnlockedImageUrl()
    {
        return zzaus;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public long getXpValue()
    {
        return zzauB;
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
        AchievementEntityCreator.zza(this, parcel, i);
    }

    public int zztK()
    {
        return zzauv;
    }

    public String zztL()
    {
        return zzauw;
    }

    public int zztM()
    {
        return zzauy;
    }

    public String zztN()
    {
        return zzauz;
    }

}
