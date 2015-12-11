// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.fc;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardScore

public final class d
    implements LeaderboardScore
{

    private final long vK;
    private final String vL;
    private final String vM;
    private final long vN;
    private final long vO;
    private final String vP;
    private final Uri vQ;
    private final Uri vR;
    private final PlayerEntity vS;
    private final String vT;

    public d(LeaderboardScore leaderboardscore)
    {
        vK = leaderboardscore.getRank();
        vL = (String)eg.f(leaderboardscore.getDisplayRank());
        vM = (String)eg.f(leaderboardscore.getDisplayScore());
        vN = leaderboardscore.getRawScore();
        vO = leaderboardscore.getTimestampMillis();
        vP = leaderboardscore.getScoreHolderDisplayName();
        vQ = leaderboardscore.getScoreHolderIconImageUri();
        vR = leaderboardscore.getScoreHolderHiResImageUri();
        Object obj = leaderboardscore.getScoreHolder();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = (PlayerEntity)((Player) (obj)).freeze();
        }
        vS = ((PlayerEntity) (obj));
        vT = leaderboardscore.getScoreTag();
    }

    static int a(LeaderboardScore leaderboardscore)
    {
        return ee.hashCode(new Object[] {
            Long.valueOf(leaderboardscore.getRank()), leaderboardscore.getDisplayRank(), Long.valueOf(leaderboardscore.getRawScore()), leaderboardscore.getDisplayScore(), Long.valueOf(leaderboardscore.getTimestampMillis()), leaderboardscore.getScoreHolderDisplayName(), leaderboardscore.getScoreHolderIconImageUri(), leaderboardscore.getScoreHolderHiResImageUri(), leaderboardscore.getScoreHolder()
        });
    }

    static boolean a(LeaderboardScore leaderboardscore, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof LeaderboardScore) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (leaderboardscore == obj) goto _L4; else goto _L3
_L3:
        obj = (LeaderboardScore)obj;
        if (!ee.equal(Long.valueOf(((LeaderboardScore) (obj)).getRank()), Long.valueOf(leaderboardscore.getRank())) || !ee.equal(((LeaderboardScore) (obj)).getDisplayRank(), leaderboardscore.getDisplayRank()) || !ee.equal(Long.valueOf(((LeaderboardScore) (obj)).getRawScore()), Long.valueOf(leaderboardscore.getRawScore())) || !ee.equal(((LeaderboardScore) (obj)).getDisplayScore(), leaderboardscore.getDisplayScore()) || !ee.equal(Long.valueOf(((LeaderboardScore) (obj)).getTimestampMillis()), Long.valueOf(leaderboardscore.getTimestampMillis())) || !ee.equal(((LeaderboardScore) (obj)).getScoreHolderDisplayName(), leaderboardscore.getScoreHolderDisplayName()) || !ee.equal(((LeaderboardScore) (obj)).getScoreHolderIconImageUri(), leaderboardscore.getScoreHolderIconImageUri()) || !ee.equal(((LeaderboardScore) (obj)).getScoreHolderHiResImageUri(), leaderboardscore.getScoreHolderHiResImageUri()) || !ee.equal(((LeaderboardScore) (obj)).getScoreHolder(), leaderboardscore.getScoreHolder()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ee.equal(((LeaderboardScore) (obj)).getScoreTag(), leaderboardscore.getScoreTag())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String b(LeaderboardScore leaderboardscore)
    {
        com.google.android.gms.internal.ee.a a1 = ee.e(leaderboardscore).a("Rank", Long.valueOf(leaderboardscore.getRank())).a("DisplayRank", leaderboardscore.getDisplayRank()).a("Score", Long.valueOf(leaderboardscore.getRawScore())).a("DisplayScore", leaderboardscore.getDisplayScore()).a("Timestamp", Long.valueOf(leaderboardscore.getTimestampMillis())).a("DisplayName", leaderboardscore.getScoreHolderDisplayName()).a("IconImageUri", leaderboardscore.getScoreHolderIconImageUri()).a("HiResImageUri", leaderboardscore.getScoreHolderHiResImageUri());
        Player player;
        if (leaderboardscore.getScoreHolder() == null)
        {
            player = null;
        } else
        {
            player = leaderboardscore.getScoreHolder();
        }
        return a1.a("Player", player).a("ScoreTag", leaderboardscore.getScoreTag()).toString();
    }

    public LeaderboardScore ds()
    {
        return this;
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public Object freeze()
    {
        return ds();
    }

    public String getDisplayRank()
    {
        return vL;
    }

    public void getDisplayRank(CharArrayBuffer chararraybuffer)
    {
        fc.b(vL, chararraybuffer);
    }

    public String getDisplayScore()
    {
        return vM;
    }

    public void getDisplayScore(CharArrayBuffer chararraybuffer)
    {
        fc.b(vM, chararraybuffer);
    }

    public long getRank()
    {
        return vK;
    }

    public long getRawScore()
    {
        return vN;
    }

    public Player getScoreHolder()
    {
        return vS;
    }

    public String getScoreHolderDisplayName()
    {
        if (vS == null)
        {
            return vP;
        } else
        {
            return vS.getDisplayName();
        }
    }

    public void getScoreHolderDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (vS == null)
        {
            fc.b(vP, chararraybuffer);
            return;
        } else
        {
            vS.getDisplayName(chararraybuffer);
            return;
        }
    }

    public Uri getScoreHolderHiResImageUri()
    {
        if (vS == null)
        {
            return vR;
        } else
        {
            return vS.getHiResImageUri();
        }
    }

    public Uri getScoreHolderIconImageUri()
    {
        if (vS == null)
        {
            return vQ;
        } else
        {
            return vS.getIconImageUri();
        }
    }

    public String getScoreTag()
    {
        return vT;
    }

    public long getTimestampMillis()
    {
        return vO;
    }

    public int hashCode()
    {
        return a(this);
    }

    public boolean isDataValid()
    {
        return true;
    }

    public String toString()
    {
        return b(this);
    }
}
