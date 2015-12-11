// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fy;

// Referenced classes of package com.google.android.gms.games:
//            Game, a

public final class GameEntity extends fy
    implements Game
{
    static final class a extends com.google.android.gms.games.a
    {

        public GameEntity aj(Parcel parcel)
        {
            if (GameEntity.b(GameEntity.fk()) || GameEntity.at(com/google/android/gms/games/GameEntity.getCanonicalName()))
            {
                return super.aj(parcel);
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
            return new GameEntity(2, s, s1, s2, s3, s4, s5, ((Uri) (obj)), ((Uri) (obj1)), ((Uri) (obj2)), flag, flag1, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false);
        }

        public Object createFromParcel(Parcel parcel)
        {
            return aj(parcel);
        }

        a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new a();
    private final String FE;
    private final String FF;
    private final String FG;
    private final String FH;
    private final String FI;
    private final Uri FJ;
    private final Uri FK;
    private final Uri FL;
    private final boolean FM;
    private final boolean FN;
    private final String FO;
    private final int FP;
    private final int FQ;
    private final int FR;
    private final boolean FS;
    private final boolean FT;
    private final String FU;
    private final String FV;
    private final String FW;
    private final boolean FX;
    private final int wj;
    private final String wk;

    GameEntity(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            Uri uri, Uri uri1, Uri uri2, boolean flag, boolean flag1, String s6, int j, 
            int k, int l, boolean flag2, boolean flag3, String s7, String s8, String s9, 
            boolean flag4)
    {
        wj = i;
        wk = s;
        FE = s1;
        FF = s2;
        FG = s3;
        FH = s4;
        FI = s5;
        FJ = uri;
        FU = s7;
        FK = uri1;
        FV = s8;
        FL = uri2;
        FW = s9;
        FM = flag;
        FN = flag1;
        FO = s6;
        FP = j;
        FQ = k;
        FR = l;
        FS = flag2;
        FT = flag3;
        FX = flag4;
    }

    public GameEntity(Game game)
    {
        wj = 2;
        wk = game.getApplicationId();
        FF = game.getPrimaryCategory();
        FG = game.getSecondaryCategory();
        FH = game.getDescription();
        FI = game.getDeveloperName();
        FE = game.getDisplayName();
        FJ = game.getIconImageUri();
        FU = game.getIconImageUrl();
        FK = game.getHiResImageUri();
        FV = game.getHiResImageUrl();
        FL = game.getFeaturedImageUri();
        FW = game.getFeaturedImageUrl();
        FM = game.isPlayEnabledGame();
        FN = game.isInstanceInstalled();
        FO = game.getInstancePackageName();
        FP = game.getGameplayAclStatus();
        FQ = game.getAchievementTotalCount();
        FR = game.getLeaderboardCount();
        FS = game.isRealTimeMultiplayerEnabled();
        FT = game.isTurnBasedMultiplayerEnabled();
        FX = game.isMuted();
    }

    static int a(Game game)
    {
        return ep.hashCode(new Object[] {
            game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.isPlayEnabledGame()), 
            Boolean.valueOf(game.isInstanceInstalled()), game.getInstancePackageName(), Integer.valueOf(game.getGameplayAclStatus()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isMuted())
        });
    }

    static boolean a(Game game, Object obj)
    {
        boolean flag2 = true;
        if (obj instanceof Game) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag2;
        if (game == obj) goto _L4; else goto _L3
_L3:
        obj = (Game)obj;
        if (!ep.equal(((Game) (obj)).getApplicationId(), game.getApplicationId()) || !ep.equal(((Game) (obj)).getDisplayName(), game.getDisplayName()) || !ep.equal(((Game) (obj)).getPrimaryCategory(), game.getPrimaryCategory()) || !ep.equal(((Game) (obj)).getSecondaryCategory(), game.getSecondaryCategory()) || !ep.equal(((Game) (obj)).getDescription(), game.getDescription()) || !ep.equal(((Game) (obj)).getDeveloperName(), game.getDeveloperName()) || !ep.equal(((Game) (obj)).getIconImageUri(), game.getIconImageUri()) || !ep.equal(((Game) (obj)).getHiResImageUri(), game.getHiResImageUri()) || !ep.equal(((Game) (obj)).getFeaturedImageUri(), game.getFeaturedImageUri()) || !ep.equal(Boolean.valueOf(((Game) (obj)).isPlayEnabledGame()), Boolean.valueOf(game.isPlayEnabledGame())) || !ep.equal(Boolean.valueOf(((Game) (obj)).isInstanceInstalled()), Boolean.valueOf(game.isInstanceInstalled())) || !ep.equal(((Game) (obj)).getInstancePackageName(), game.getInstancePackageName()) || !ep.equal(Integer.valueOf(((Game) (obj)).getGameplayAclStatus()), Integer.valueOf(game.getGameplayAclStatus())) || !ep.equal(Integer.valueOf(((Game) (obj)).getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) || !ep.equal(Integer.valueOf(((Game) (obj)).getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) || !ep.equal(Boolean.valueOf(((Game) (obj)).isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled())))
        {
            break; /* Loop/switch isn't completed */
        }
        boolean flag3 = ((Game) (obj)).isTurnBasedMultiplayerEnabled();
        boolean flag1;
        if (game.isTurnBasedMultiplayerEnabled() && ep.equal(Boolean.valueOf(((Game) (obj)).isMuted()), Boolean.valueOf(game.isMuted())))
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        flag = flag2;
        if (ep.equal(Boolean.valueOf(flag3), Boolean.valueOf(flag1))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static boolean at(String s)
    {
        return ae(s);
    }

    static String b(Game game)
    {
        return ep.e(game).a("ApplicationId", game.getApplicationId()).a("DisplayName", game.getDisplayName()).a("PrimaryCategory", game.getPrimaryCategory()).a("SecondaryCategory", game.getSecondaryCategory()).a("Description", game.getDescription()).a("DeveloperName", game.getDeveloperName()).a("IconImageUri", game.getIconImageUri()).a("IconImageUrl", game.getIconImageUrl()).a("HiResImageUri", game.getHiResImageUri()).a("HiResImageUrl", game.getHiResImageUrl()).a("FeaturedImageUri", game.getFeaturedImageUri()).a("FeaturedImageUrl", game.getFeaturedImageUrl()).a("PlayEnabledGame", Boolean.valueOf(game.isPlayEnabledGame())).a("InstanceInstalled", Boolean.valueOf(game.isInstanceInstalled())).a("InstancePackageName", game.getInstancePackageName()).a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).toString();
    }

    static boolean b(Integer integer)
    {
        return c(integer);
    }

    static Integer fk()
    {
        return dY();
    }

    public int describeContents()
    {
        return 0;
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
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
        return FQ;
    }

    public String getApplicationId()
    {
        return wk;
    }

    public String getDescription()
    {
        return FH;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        fm.b(FH, chararraybuffer);
    }

    public String getDeveloperName()
    {
        return FI;
    }

    public void getDeveloperName(CharArrayBuffer chararraybuffer)
    {
        fm.b(FI, chararraybuffer);
    }

    public String getDisplayName()
    {
        return FE;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        fm.b(FE, chararraybuffer);
    }

    public Uri getFeaturedImageUri()
    {
        return FL;
    }

    public String getFeaturedImageUrl()
    {
        return FW;
    }

    public int getGameplayAclStatus()
    {
        return FP;
    }

    public Uri getHiResImageUri()
    {
        return FK;
    }

    public String getHiResImageUrl()
    {
        return FV;
    }

    public Uri getIconImageUri()
    {
        return FJ;
    }

    public String getIconImageUrl()
    {
        return FU;
    }

    public String getInstancePackageName()
    {
        return FO;
    }

    public int getLeaderboardCount()
    {
        return FR;
    }

    public String getPrimaryCategory()
    {
        return FF;
    }

    public String getSecondaryCategory()
    {
        return FG;
    }

    public int getVersionCode()
    {
        return wj;
    }

    public int hashCode()
    {
        return a(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public boolean isInstanceInstalled()
    {
        return FN;
    }

    public boolean isMuted()
    {
        return FX;
    }

    public boolean isPlayEnabledGame()
    {
        return FM;
    }

    public boolean isRealTimeMultiplayerEnabled()
    {
        return FS;
    }

    public boolean isTurnBasedMultiplayerEnabled()
    {
        return FT;
    }

    public String toString()
    {
        return b(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        Object obj = null;
        if (!dZ())
        {
            com.google.android.gms.games.a.a(this, parcel, i);
            return;
        }
        parcel.writeString(wk);
        parcel.writeString(FE);
        parcel.writeString(FF);
        parcel.writeString(FG);
        parcel.writeString(FH);
        parcel.writeString(FI);
        String s;
        if (FJ == null)
        {
            s = null;
        } else
        {
            s = FJ.toString();
        }
        parcel.writeString(s);
        if (FK == null)
        {
            s = null;
        } else
        {
            s = FK.toString();
        }
        parcel.writeString(s);
        if (FL == null)
        {
            s = obj;
        } else
        {
            s = FL.toString();
        }
        parcel.writeString(s);
        if (FM)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (FN)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(FO);
        parcel.writeInt(FP);
        parcel.writeInt(FQ);
        parcel.writeInt(FR);
    }

}
