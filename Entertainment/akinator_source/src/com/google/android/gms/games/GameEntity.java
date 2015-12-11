// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzmo;

// Referenced classes of package com.google.android.gms.games:
//            Game, GameEntityCreator

public final class GameEntity extends GamesDowngradeableSafeParcel
    implements Game
{
    static final class GameEntityCreatorCompat extends GameEntityCreator
    {

        public Object createFromParcel(Parcel parcel)
        {
            return zzdN(parcel);
        }

        public GameEntity zzdN(Parcel parcel)
        {
            if (GameEntity.zzc(GameEntity.zztC()) || GameEntity.zzcV(com/google/android/gms/games/GameEntity.getCanonicalName()))
            {
                return super.zzdN(parcel);
            }
            String s = parcel.readString();
            String s1 = parcel.readString();
            String s2 = parcel.readString();
            String s3 = parcel.readString();
            String s4 = parcel.readString();
            String s5 = parcel.readString();
            Object obj = parcel.readString();
            Object obj1;
            Object obj2;
            boolean flag;
            boolean flag1;
            if (obj == null)
            {
                obj = null;
            } else
            {
                obj = Uri.parse(((String) (obj)));
            }
            obj1 = parcel.readString();
            if (obj1 == null)
            {
                obj1 = null;
            } else
            {
                obj1 = Uri.parse(((String) (obj1)));
            }
            obj2 = parcel.readString();
            if (obj2 == null)
            {
                obj2 = null;
            } else
            {
                obj2 = Uri.parse(((String) (obj2)));
            }
            if (parcel.readInt() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (parcel.readInt() > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            return new GameEntity(7, s, s1, s2, s3, s4, s5, ((Uri) (obj)), ((Uri) (obj1)), ((Uri) (obj2)), flag, flag1, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
        }

        GameEntityCreatorCompat()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new GameEntityCreatorCompat();
    private final int mVersionCode;
    private final boolean zzBa;
    private final String zzTa;
    private final String zzUM;
    private final String zzaqZ;
    private final int zzatA;
    private final int zzatB;
    private final int zzatC;
    private final boolean zzatD;
    private final boolean zzatE;
    private final String zzatF;
    private final String zzatG;
    private final String zzatH;
    private final boolean zzatI;
    private final boolean zzatJ;
    private final String zzatK;
    private final boolean zzatL;
    private final String zzatr;
    private final String zzats;
    private final String zzatt;
    private final Uri zzatu;
    private final Uri zzatv;
    private final Uri zzatw;
    private final boolean zzatx;
    private final boolean zzaty;
    private final String zzatz;

    GameEntity(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            Uri uri, Uri uri1, Uri uri2, boolean flag, boolean flag1, String s6, int j, 
            int k, int l, boolean flag2, boolean flag3, String s7, String s8, String s9, 
            boolean flag4, boolean flag5, boolean flag6, String s10, boolean flag7)
    {
        mVersionCode = i;
        zzUM = s;
        zzTa = s1;
        zzatr = s2;
        zzats = s3;
        zzaqZ = s4;
        zzatt = s5;
        zzatu = uri;
        zzatF = s7;
        zzatv = uri1;
        zzatG = s8;
        zzatw = uri2;
        zzatH = s9;
        zzatx = flag;
        zzaty = flag1;
        zzatz = s6;
        zzatA = j;
        zzatB = k;
        zzatC = l;
        zzatD = flag2;
        zzatE = flag3;
        zzBa = flag4;
        zzatI = flag5;
        zzatJ = flag6;
        zzatK = s10;
        zzatL = flag7;
    }

    public GameEntity(Game game)
    {
        mVersionCode = 7;
        zzUM = game.getApplicationId();
        zzatr = game.getPrimaryCategory();
        zzats = game.getSecondaryCategory();
        zzaqZ = game.getDescription();
        zzatt = game.getDeveloperName();
        zzTa = game.getDisplayName();
        zzatu = game.getIconImageUri();
        zzatF = game.getIconImageUrl();
        zzatv = game.getHiResImageUri();
        zzatG = game.getHiResImageUrl();
        zzatw = game.getFeaturedImageUri();
        zzatH = game.getFeaturedImageUrl();
        zzatx = game.zztx();
        zzaty = game.zztz();
        zzatz = game.zztA();
        zzatA = game.zztB();
        zzatB = game.getAchievementTotalCount();
        zzatC = game.getLeaderboardCount();
        zzatD = game.isRealTimeMultiplayerEnabled();
        zzatE = game.isTurnBasedMultiplayerEnabled();
        zzBa = game.isMuted();
        zzatI = game.zzty();
        zzatJ = game.areSnapshotsEnabled();
        zzatK = game.getThemeColor();
        zzatL = game.hasGamepadSupport();
    }

    static int zza(Game game)
    {
        return zzw.hashCode(new Object[] {
            game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zztx()), 
            Boolean.valueOf(game.zztz()), game.zztA(), Integer.valueOf(game.zztB()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzty()), Boolean.valueOf(game.areSnapshotsEnabled()), 
            game.getThemeColor(), Boolean.valueOf(game.hasGamepadSupport())
        });
    }

    static boolean zza(Game game, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Game) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (game == obj) goto _L4; else goto _L3
_L3:
        obj = (Game)obj;
        if (!zzw.equal(((Game) (obj)).getApplicationId(), game.getApplicationId()) || !zzw.equal(((Game) (obj)).getDisplayName(), game.getDisplayName()) || !zzw.equal(((Game) (obj)).getPrimaryCategory(), game.getPrimaryCategory()) || !zzw.equal(((Game) (obj)).getSecondaryCategory(), game.getSecondaryCategory()) || !zzw.equal(((Game) (obj)).getDescription(), game.getDescription()) || !zzw.equal(((Game) (obj)).getDeveloperName(), game.getDeveloperName()) || !zzw.equal(((Game) (obj)).getIconImageUri(), game.getIconImageUri()) || !zzw.equal(((Game) (obj)).getHiResImageUri(), game.getHiResImageUri()) || !zzw.equal(((Game) (obj)).getFeaturedImageUri(), game.getFeaturedImageUri()) || !zzw.equal(Boolean.valueOf(((Game) (obj)).zztx()), Boolean.valueOf(game.zztx())) || !zzw.equal(Boolean.valueOf(((Game) (obj)).zztz()), Boolean.valueOf(game.zztz())) || !zzw.equal(((Game) (obj)).zztA(), game.zztA()) || !zzw.equal(Integer.valueOf(((Game) (obj)).zztB()), Integer.valueOf(game.zztB())) || !zzw.equal(Integer.valueOf(((Game) (obj)).getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) || !zzw.equal(Integer.valueOf(((Game) (obj)).getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) || !zzw.equal(Boolean.valueOf(((Game) (obj)).isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled())))
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag2 = ((Game) (obj)).isTurnBasedMultiplayerEnabled();
        if (game.isTurnBasedMultiplayerEnabled() && zzw.equal(Boolean.valueOf(((Game) (obj)).isMuted()), Boolean.valueOf(game.isMuted())) && zzw.equal(Boolean.valueOf(((Game) (obj)).zzty()), Boolean.valueOf(game.zzty())))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!zzw.equal(Boolean.valueOf(flag2), Boolean.valueOf(flag)) || !zzw.equal(Boolean.valueOf(((Game) (obj)).areSnapshotsEnabled()), Boolean.valueOf(game.areSnapshotsEnabled())) || !zzw.equal(((Game) (obj)).getThemeColor(), game.getThemeColor()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(Boolean.valueOf(((Game) (obj)).hasGamepadSupport()), Boolean.valueOf(game.hasGamepadSupport()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(Game game)
    {
        return zzw.zzv(game).zzg("ApplicationId", game.getApplicationId()).zzg("DisplayName", game.getDisplayName()).zzg("PrimaryCategory", game.getPrimaryCategory()).zzg("SecondaryCategory", game.getSecondaryCategory()).zzg("Description", game.getDescription()).zzg("DeveloperName", game.getDeveloperName()).zzg("IconImageUri", game.getIconImageUri()).zzg("IconImageUrl", game.getIconImageUrl()).zzg("HiResImageUri", game.getHiResImageUri()).zzg("HiResImageUrl", game.getHiResImageUrl()).zzg("FeaturedImageUri", game.getFeaturedImageUri()).zzg("FeaturedImageUrl", game.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(game.zztx())).zzg("InstanceInstalled", Boolean.valueOf(game.zztz())).zzg("InstancePackageName", game.zztA()).zzg("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).zzg("ThemeColor", game.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    static boolean zzc(Integer integer)
    {
        return zzd(integer);
    }

    static boolean zzcV(String s)
    {
        return zzck(s);
    }

    static Integer zztC()
    {
        return zzoT();
    }

    public boolean areSnapshotsEnabled()
    {
        return zzatJ;
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Game freeze()
    {
        return this;
    }

    public volatile Object freeze()
    {
        return freeze();
    }

    public int getAchievementTotalCount()
    {
        return zzatB;
    }

    public String getApplicationId()
    {
        return zzUM;
    }

    public String getDescription()
    {
        return zzaqZ;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzaqZ, chararraybuffer);
    }

    public String getDeveloperName()
    {
        return zzatt;
    }

    public void getDeveloperName(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzatt, chararraybuffer);
    }

    public String getDisplayName()
    {
        return zzTa;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzTa, chararraybuffer);
    }

    public Uri getFeaturedImageUri()
    {
        return zzatw;
    }

    public String getFeaturedImageUrl()
    {
        return zzatH;
    }

    public Uri getHiResImageUri()
    {
        return zzatv;
    }

    public String getHiResImageUrl()
    {
        return zzatG;
    }

    public Uri getIconImageUri()
    {
        return zzatu;
    }

    public String getIconImageUrl()
    {
        return zzatF;
    }

    public int getLeaderboardCount()
    {
        return zzatC;
    }

    public String getPrimaryCategory()
    {
        return zzatr;
    }

    public String getSecondaryCategory()
    {
        return zzats;
    }

    public String getThemeColor()
    {
        return zzatK;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public boolean hasGamepadSupport()
    {
        return zzatL;
    }

    public int hashCode()
    {
        return zza(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public boolean isMuted()
    {
        return zzBa;
    }

    public boolean isRealTimeMultiplayerEnabled()
    {
        return zzatD;
    }

    public boolean isTurnBasedMultiplayerEnabled()
    {
        return zzatE;
    }

    public String toString()
    {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        Object obj = null;
        if (!zzoU())
        {
            GameEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeString(zzUM);
        parcel.writeString(zzTa);
        parcel.writeString(zzatr);
        parcel.writeString(zzats);
        parcel.writeString(zzaqZ);
        parcel.writeString(zzatt);
        String s;
        if (zzatu == null)
        {
            s = null;
        } else
        {
            s = zzatu.toString();
        }
        parcel.writeString(s);
        if (zzatv == null)
        {
            s = null;
        } else
        {
            s = zzatv.toString();
        }
        parcel.writeString(s);
        if (zzatw == null)
        {
            s = obj;
        } else
        {
            s = zzatw.toString();
        }
        parcel.writeString(s);
        if (zzatx)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (zzaty)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(zzatz);
        parcel.writeInt(zzatA);
        parcel.writeInt(zzatB);
        parcel.writeInt(zzatC);
    }

    public String zztA()
    {
        return zzatz;
    }

    public int zztB()
    {
        return zzatA;
    }

    public boolean zztx()
    {
        return zzatx;
    }

    public boolean zzty()
    {
        return zzatI;
    }

    public boolean zztz()
    {
        return zzaty;
    }

}
