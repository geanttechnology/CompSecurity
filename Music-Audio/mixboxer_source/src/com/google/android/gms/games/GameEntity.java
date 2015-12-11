// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fm;

// Referenced classes of package com.google.android.gms.games:
//            Game, a

public final class GameEntity extends fm
    implements Game
{
    static final class a extends com.google.android.gms.games.a
    {

        public GameEntity Y(Parcel parcel)
        {
            if (GameEntity.b(GameEntity.da()) || GameEntity.ad(com/google/android/gms/games/GameEntity.getCanonicalName()))
            {
                return super.Y(parcel);
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
            return new GameEntity(2, s, s1, s2, s3, s4, s5, ((Uri) (obj)), ((Uri) (obj1)), ((Uri) (obj2)), flag, flag1, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false);
        }

        public Object createFromParcel(Parcel parcel)
        {
            return Y(parcel);
        }

        a()
        {
        }
    }


    public static final android.os.Parcelable.Creator CREATOR = new a();
    private final int kg;
    private final String kh;
    private final String qa;
    private final String sH;
    private final String sI;
    private final String sJ;
    private final String sK;
    private final Uri sL;
    private final Uri sM;
    private final Uri sN;
    private final boolean sO;
    private final boolean sP;
    private final String sQ;
    private final int sR;
    private final int sS;
    private final int sT;
    private final boolean sU;
    private final boolean sV;

    GameEntity(int i, String s, String s1, String s2, String s3, String s4, String s5, 
            Uri uri, Uri uri1, Uri uri2, boolean flag, boolean flag1, String s6, int j, 
            int k, int l, boolean flag2, boolean flag3)
    {
        kg = i;
        kh = s;
        qa = s1;
        sH = s2;
        sI = s3;
        sJ = s4;
        sK = s5;
        sL = uri;
        sM = uri1;
        sN = uri2;
        sO = flag;
        sP = flag1;
        sQ = s6;
        sR = j;
        sS = k;
        sT = l;
        sU = flag2;
        sV = flag3;
    }

    public GameEntity(Game game)
    {
        kg = 2;
        kh = game.getApplicationId();
        sH = game.getPrimaryCategory();
        sI = game.getSecondaryCategory();
        sJ = game.getDescription();
        sK = game.getDeveloperName();
        qa = game.getDisplayName();
        sL = game.getIconImageUri();
        sM = game.getHiResImageUri();
        sN = game.getFeaturedImageUri();
        sO = game.isPlayEnabledGame();
        sP = game.isInstanceInstalled();
        sQ = game.getInstancePackageName();
        sR = game.getGameplayAclStatus();
        sS = game.getAchievementTotalCount();
        sT = game.getLeaderboardCount();
        sU = game.isRealTimeMultiplayerEnabled();
        sV = game.isTurnBasedMultiplayerEnabled();
    }

    static int a(Game game)
    {
        return ee.hashCode(new Object[] {
            game.getApplicationId(), game.getDisplayName(), game.getPrimaryCategory(), game.getSecondaryCategory(), game.getDescription(), game.getDeveloperName(), game.getIconImageUri(), game.getHiResImageUri(), game.getFeaturedImageUri(), Boolean.valueOf(game.isPlayEnabledGame()), 
            Boolean.valueOf(game.isInstanceInstalled()), game.getInstancePackageName(), Integer.valueOf(game.getGameplayAclStatus()), Integer.valueOf(game.getAchievementTotalCount()), Integer.valueOf(game.getLeaderboardCount()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())
        });
    }

    static boolean a(Game game, Object obj)
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
        if (!ee.equal(((Game) (obj)).getApplicationId(), game.getApplicationId()) || !ee.equal(((Game) (obj)).getDisplayName(), game.getDisplayName()) || !ee.equal(((Game) (obj)).getPrimaryCategory(), game.getPrimaryCategory()) || !ee.equal(((Game) (obj)).getSecondaryCategory(), game.getSecondaryCategory()) || !ee.equal(((Game) (obj)).getDescription(), game.getDescription()) || !ee.equal(((Game) (obj)).getDeveloperName(), game.getDeveloperName()) || !ee.equal(((Game) (obj)).getIconImageUri(), game.getIconImageUri()) || !ee.equal(((Game) (obj)).getHiResImageUri(), game.getHiResImageUri()) || !ee.equal(((Game) (obj)).getFeaturedImageUri(), game.getFeaturedImageUri()) || !ee.equal(Boolean.valueOf(((Game) (obj)).isPlayEnabledGame()), Boolean.valueOf(game.isPlayEnabledGame())) || !ee.equal(Boolean.valueOf(((Game) (obj)).isInstanceInstalled()), Boolean.valueOf(game.isInstanceInstalled())) || !ee.equal(((Game) (obj)).getInstancePackageName(), game.getInstancePackageName()) || !ee.equal(Integer.valueOf(((Game) (obj)).getGameplayAclStatus()), Integer.valueOf(game.getGameplayAclStatus())) || !ee.equal(Integer.valueOf(((Game) (obj)).getAchievementTotalCount()), Integer.valueOf(game.getAchievementTotalCount())) || !ee.equal(Integer.valueOf(((Game) (obj)).getLeaderboardCount()), Integer.valueOf(game.getLeaderboardCount())) || !ee.equal(Boolean.valueOf(((Game) (obj)).isRealTimeMultiplayerEnabled()), Boolean.valueOf(game.isRealTimeMultiplayerEnabled())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ee.equal(Boolean.valueOf(((Game) (obj)).isTurnBasedMultiplayerEnabled()), Boolean.valueOf(game.isTurnBasedMultiplayerEnabled()))) goto _L4; else goto _L5
_L5:
        return false;
    }

    static boolean ad(String s)
    {
        return P(s);
    }

    static String b(Game game)
    {
        return ee.e(game).a("ApplicationId", game.getApplicationId()).a("DisplayName", game.getDisplayName()).a("PrimaryCategory", game.getPrimaryCategory()).a("SecondaryCategory", game.getSecondaryCategory()).a("Description", game.getDescription()).a("DeveloperName", game.getDeveloperName()).a("IconImageUri", game.getIconImageUri()).a("HiResImageUri", game.getHiResImageUri()).a("FeaturedImageUri", game.getFeaturedImageUri()).a("PlayEnabledGame", Boolean.valueOf(game.isPlayEnabledGame())).a("InstanceInstalled", Boolean.valueOf(game.isInstanceInstalled())).a("InstancePackageName", game.getInstancePackageName()).a("GameplayAclStatus", Integer.valueOf(game.getGameplayAclStatus())).a("AchievementTotalCount", Integer.valueOf(game.getAchievementTotalCount())).a("LeaderboardCount", Integer.valueOf(game.getLeaderboardCount())).a("RealTimeMultiplayerEnabled", Boolean.valueOf(game.isRealTimeMultiplayerEnabled())).a("TurnBasedMultiplayerEnabled", Boolean.valueOf(game.isTurnBasedMultiplayerEnabled())).toString();
    }

    static boolean b(Integer integer)
    {
        return c(integer);
    }

    static Integer da()
    {
        return bM();
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
        return sS;
    }

    public String getApplicationId()
    {
        return kh;
    }

    public String getDescription()
    {
        return sJ;
    }

    public void getDescription(CharArrayBuffer chararraybuffer)
    {
        fc.b(sJ, chararraybuffer);
    }

    public String getDeveloperName()
    {
        return sK;
    }

    public void getDeveloperName(CharArrayBuffer chararraybuffer)
    {
        fc.b(sK, chararraybuffer);
    }

    public String getDisplayName()
    {
        return qa;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        fc.b(qa, chararraybuffer);
    }

    public Uri getFeaturedImageUri()
    {
        return sN;
    }

    public int getGameplayAclStatus()
    {
        return sR;
    }

    public Uri getHiResImageUri()
    {
        return sM;
    }

    public Uri getIconImageUri()
    {
        return sL;
    }

    public String getInstancePackageName()
    {
        return sQ;
    }

    public int getLeaderboardCount()
    {
        return sT;
    }

    public String getPrimaryCategory()
    {
        return sH;
    }

    public String getSecondaryCategory()
    {
        return sI;
    }

    public int getVersionCode()
    {
        return kg;
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
        return sP;
    }

    public boolean isPlayEnabledGame()
    {
        return sO;
    }

    public boolean isRealTimeMultiplayerEnabled()
    {
        return sU;
    }

    public boolean isTurnBasedMultiplayerEnabled()
    {
        return sV;
    }

    public String toString()
    {
        return b(this);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        boolean flag = true;
        Object obj = null;
        if (!bN())
        {
            com.google.android.gms.games.a.a(this, parcel, i);
            return;
        }
        parcel.writeString(kh);
        parcel.writeString(qa);
        parcel.writeString(sH);
        parcel.writeString(sI);
        parcel.writeString(sJ);
        parcel.writeString(sK);
        String s;
        if (sL == null)
        {
            s = null;
        } else
        {
            s = sL.toString();
        }
        parcel.writeString(s);
        if (sM == null)
        {
            s = null;
        } else
        {
            s = sM.toString();
        }
        parcel.writeString(s);
        if (sN == null)
        {
            s = obj;
        } else
        {
            s = sN.toString();
        }
        parcel.writeString(s);
        if (sO)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        if (sP)
        {
            i = ((flag) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        parcel.writeString(sQ);
        parcel.writeInt(sR);
        parcel.writeInt(sS);
        parcel.writeInt(sT);
    }

}
