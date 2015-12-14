// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.internal.zzln;

// Referenced classes of package com.google.android.gms.games:
//            Game, GameEntityCreator

public final class GameEntity extends GamesDowngradeableSafeParcel
    implements Game
{
    static final class GameEntityCreatorCompat extends GameEntityCreator
    {

        public Object createFromParcel(Parcel parcel)
        {
            return zzdC(parcel);
        }

        public GameEntity zzdC(Parcel parcel)
        {
            if (GameEntity.zzc(GameEntity.zzsP()) || GameEntity.zzcW(com/google/android/gms/games/GameEntity.getCanonicalName()))
            {
                return super.zzdC(parcel);
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
    private final boolean zzAn;
    private final String zzSX;
    private final String zzahh;
    private final String zzaoB;
    private final String zzaqT;
    private final String zzaqU;
    private final String zzaqV;
    private final Uri zzaqW;
    private final Uri zzaqX;
    private final Uri zzaqY;
    private final boolean zzaqZ;
    private final boolean zzara;
    private final String zzarb;
    private final int zzarc;
    private final int zzard;
    private final int zzare;
    private final boolean zzarf;
    private final boolean zzarg;
    private final String zzarh;
    private final String zzari;
    private final String zzarj;
    private final boolean zzark;
    private final boolean zzarl;
    private final String zzarm;
    private final boolean zzarn;

    GameEntity(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            Uri uri, Uri uri1, Uri uri2, boolean flag, boolean flag1, String s6, int j, 
            int k, int l, boolean flag2, boolean flag3, String s7, String s8, String s9, 
            boolean flag4, boolean flag5, boolean flag6, String s10, boolean flag7)
    {
        mVersionCode = i;
        zzSX = s;
        zzahh = s1;
        zzaqT = s2;
        zzaqU = s3;
        zzaoB = s4;
        zzaqV = s5;
        zzaqW = uri;
        zzarh = s7;
        zzaqX = uri1;
        zzari = s8;
        zzaqY = uri2;
        zzarj = s9;
        zzaqZ = flag;
        zzara = flag1;
        zzarb = s6;
        zzarc = j;
        zzard = k;
        zzare = l;
        zzarf = flag2;
        zzarg = flag3;
        zzAn = flag4;
        zzark = flag5;
        zzarl = flag6;
        zzarm = s10;
        zzarn = flag7;
    }

    public GameEntity(Game game)
    {
        mVersionCode = 7;
        zzSX = game.getApplicationId();
        zzaqT = game.getPrimaryCategory();
        zzaqU = game.getSecondaryCategory();
        zzaoB = game.getDescription();
        zzaqV = game.getDeveloperName();
        zzahh = game.getDisplayName();
        zzaqW = game.getIconImageUri();
        zzarh = game.getIconImageUrl();
        zzaqX = game.getHiResImageUri();
        zzari = game.getHiResImageUrl();
        zzaqY = game.getFeaturedImageUri();
        zzarj = game.getFeaturedImageUrl();
        zzaqZ = game.zzsK();
        zzara = game.zzsM();
        zzarb = game.zzsN();
        zzarc = game.zzsO();
        zzard = game.getAchievementTotalCount();
        zzare = game.getLeaderboardCount();
        zzarf = game.isRealTimeMultiplayerEnabled();
        zzarg = game.isTurnBasedMultiplayerEnabled();
        zzAn = game.isMuted();
        zzark = game.zzsL();
        zzarl = game.areSnapshotsEnabled();
        zzarm = game.getThemeColor();
        zzarn = game.hasGamepadSupport();
    }

    static int zza(Game game)
    {
        return zzw.hashCode(new Object[] {
            game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.zzsK()), 
            Boolean.valueOf(game.zzsM()), game.zzsN(), Integer.valueOf(game.zzsO()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted()), Boolean.valueOf(game.zzsL()), Boolean.valueOf(game.areSnapshotsEnabled()), 
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
        if (!zzw.equal(((Game) (obj)).getApplicationId(), game.getApplicationId()) || !zzw.equal(((Game) (obj)).getDisplayName(), game.getDisplayName()) || !zzw.equal(((Game) (obj)).getPrimaryCategory(), game.getPrimaryCategory()) || !zzw.equal(((Game) (obj)).getSecondaryCategory(), game.getSecondaryCategory()) || !zzw.equal(((Game) (obj)).getDescription(), game.getDescription()) || !zzw.equal(((Game) (obj)).getDeveloperName(), game.getDeveloperName()) || !zzw.equal(((Game) (obj)).getIconImageUri(), game.getIconImageUri()) || !zzw.equal(((Game) (obj)).getHiResImageUri(), game.getHiResImageUri()) || !zzw.equal(((Game) (obj)).getFeaturedImageUri(), game.getFeaturedImageUri()) || !zzw.equal(Boolean.valueOf(((Game) (obj)).zzsK()), Boolean.valueOf(game.zzsK())) || !zzw.equal(Boolean.valueOf(((Game) (obj)).zzsM()), Boolean.valueOf(game.zzsM())) || !zzw.equal(((Game) (obj)).zzsN(), game.zzsN()) || !zzw.equal(Integer.valueOf(((Game) (obj)).zzsO()), Integer.valueOf(game.zzsO())) || !zzw.equal(Integer.valueOf(((Game) (obj)).getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) || !zzw.equal(Integer.valueOf(((Game) (obj)).getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) || !zzw.equal(Boolean.valueOf(((Game) (obj)).isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled())))
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag2 = ((Game) (obj)).isTurnBasedMultiplayerEnabled();
        if (game.isTurnBasedMultiplayerEnabled() && zzw.equal(Boolean.valueOf(((Game) (obj)).isMuted()), Boolean.valueOf(game.isMuted())) && zzw.equal(Boolean.valueOf(((Game) (obj)).zzsL()), Boolean.valueOf(game.zzsL())))
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
        return zzw.zzu(game).zzg("ApplicationId", game.getApplicationId()).zzg("DisplayName", game.getDisplayName()).zzg("PrimaryCategory", game.getPrimaryCategory()).zzg("SecondaryCategory", game.getSecondaryCategory()).zzg("Description", game.getDescription()).zzg("DeveloperName", game.getDeveloperName()).zzg("IconImageUri", game.getIconImageUri()).zzg("IconImageUrl", game.getIconImageUrl()).zzg("HiResImageUri", game.getHiResImageUri()).zzg("HiResImageUrl", game.getHiResImageUrl()).zzg("FeaturedImageUri", game.getFeaturedImageUri()).zzg("FeaturedImageUrl", game.getFeaturedImageUrl()).zzg("PlayEnabledGame", Boolean.valueOf(game.zzsK())).zzg("InstanceInstalled", Boolean.valueOf(game.zzsM())).zzg("InstancePackageName", game.zzsN()).zzg("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).zzg("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).zzg("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).zzg("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).zzg("AreSnapshotsEnabled", Boolean.valueOf(game.areSnapshotsEnabled())).zzg("ThemeColor", game.getThemeColor()).zzg("HasGamepadSupport", Boolean.valueOf(game.hasGamepadSupport())).toString();
    }

    static boolean zzc(Integer integer)
    {
        return zzd(integer);
    }

    static boolean zzcW(String s)
    {
        return zzcj(s);
    }

    static Integer zzsP()
    {
        return zzor();
    }

    public boolean areSnapshotsEnabled()
    {
        return zzarl;
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
        return zzard;
    }

    public String getApplicationId()
    {
        return zzSX;
    }

    public String getDescription()
    {
        return zzaoB;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzaoB, chararraybuffer);
    }

    public String getDeveloperName()
    {
        return zzaqV;
    }

    public void getDeveloperName(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzaqV, chararraybuffer);
    }

    public String getDisplayName()
    {
        return zzahh;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzahh, chararraybuffer);
    }

    public Uri getFeaturedImageUri()
    {
        return zzaqY;
    }

    public String getFeaturedImageUrl()
    {
        return zzarj;
    }

    public Uri getHiResImageUri()
    {
        return zzaqX;
    }

    public String getHiResImageUrl()
    {
        return zzari;
    }

    public Uri getIconImageUri()
    {
        return zzaqW;
    }

    public String getIconImageUrl()
    {
        return zzarh;
    }

    public int getLeaderboardCount()
    {
        return zzare;
    }

    public String getPrimaryCategory()
    {
        return zzaqT;
    }

    public String getSecondaryCategory()
    {
        return zzaqU;
    }

    public String getThemeColor()
    {
        return zzarm;
    }

    public int getVersionCode()
    {
        return mVersionCode;
    }

    public boolean hasGamepadSupport()
    {
        return zzarn;
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
        return zzAn;
    }

    public boolean isRealTimeMultiplayerEnabled()
    {
        return zzarf;
    }

    public boolean isTurnBasedMultiplayerEnabled()
    {
        return zzarg;
    }

    public String toString()
    {
        return zzb(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        Object obj = null;
        if (!zzos())
        {
            GameEntityCreator.zza(this, parcel, i);
            return;
        }
        parcel.writeString(zzSX);
        parcel.writeString(zzahh);
        parcel.writeString(zzaqT);
        parcel.writeString(zzaqU);
        parcel.writeString(zzaoB);
        parcel.writeString(zzaqV);
        String s;
        if (zzaqW == null)
        {
            s = null;
        } else
        {
            s = zzaqW.toString();
        }
        parcel.writeString(s);
        if (zzaqX == null)
        {
            s = null;
        } else
        {
            s = zzaqX.toString();
        }
        parcel.writeString(s);
        if (zzaqY == null)
        {
            s = obj;
        } else
        {
            s = zzaqY.toString();
        }
        parcel.writeString(s);
        if (zzaqZ)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (zzara)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(zzarb);
        parcel.writeInt(zzarc);
        parcel.writeInt(zzard);
        parcel.writeInt(zzare);
    }

    public boolean zzsK()
    {
        return zzaqZ;
    }

    public boolean zzsL()
    {
        return zzark;
    }

    public boolean zzsM()
    {
        return zzara;
    }

    public String zzsN()
    {
        return zzarb;
    }

    public int zzsO()
    {
        return zzarc;
    }

}
