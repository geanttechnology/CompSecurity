// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.gc;
import com.google.android.gms.internal.ge;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardVariant

public final class f
    implements LeaderboardVariant
{

    private final int vV;
    private final int vW;
    private final boolean vX;
    private final long vY;
    private final String vZ;
    private final long wa;
    private final String wb;
    private final String wc;
    private final long wd;
    private final String we;
    private final String wf;
    private final String wg;

    public f(LeaderboardVariant leaderboardvariant)
    {
        vV = leaderboardvariant.getTimeSpan();
        vW = leaderboardvariant.getCollection();
        vX = leaderboardvariant.hasPlayerInfo();
        vY = leaderboardvariant.getRawPlayerScore();
        vZ = leaderboardvariant.getDisplayPlayerScore();
        wa = leaderboardvariant.getPlayerRank();
        wb = leaderboardvariant.getDisplayPlayerRank();
        wc = leaderboardvariant.getPlayerScoreTag();
        wd = leaderboardvariant.getNumScores();
        we = leaderboardvariant.dt();
        wf = leaderboardvariant.du();
        wg = leaderboardvariant.dv();
    }

    static int a(LeaderboardVariant leaderboardvariant)
    {
        return ee.hashCode(new Object[] {
            Integer.valueOf(leaderboardvariant.getTimeSpan()), Integer.valueOf(leaderboardvariant.getCollection()), Boolean.valueOf(leaderboardvariant.hasPlayerInfo()), Long.valueOf(leaderboardvariant.getRawPlayerScore()), leaderboardvariant.getDisplayPlayerScore(), Long.valueOf(leaderboardvariant.getPlayerRank()), leaderboardvariant.getDisplayPlayerRank(), Long.valueOf(leaderboardvariant.getNumScores()), leaderboardvariant.dt(), leaderboardvariant.dv(), 
            leaderboardvariant.du()
        });
    }

    static boolean a(LeaderboardVariant leaderboardvariant, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof LeaderboardVariant) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (leaderboardvariant == obj) goto _L4; else goto _L3
_L3:
        obj = (LeaderboardVariant)obj;
        if (!ee.equal(Integer.valueOf(((LeaderboardVariant) (obj)).getTimeSpan()), Integer.valueOf(leaderboardvariant.getTimeSpan())) || !ee.equal(Integer.valueOf(((LeaderboardVariant) (obj)).getCollection()), Integer.valueOf(leaderboardvariant.getCollection())) || !ee.equal(Boolean.valueOf(((LeaderboardVariant) (obj)).hasPlayerInfo()), Boolean.valueOf(leaderboardvariant.hasPlayerInfo())) || !ee.equal(Long.valueOf(((LeaderboardVariant) (obj)).getRawPlayerScore()), Long.valueOf(leaderboardvariant.getRawPlayerScore())) || !ee.equal(((LeaderboardVariant) (obj)).getDisplayPlayerScore(), leaderboardvariant.getDisplayPlayerScore()) || !ee.equal(Long.valueOf(((LeaderboardVariant) (obj)).getPlayerRank()), Long.valueOf(leaderboardvariant.getPlayerRank())) || !ee.equal(((LeaderboardVariant) (obj)).getDisplayPlayerRank(), leaderboardvariant.getDisplayPlayerRank()) || !ee.equal(Long.valueOf(((LeaderboardVariant) (obj)).getNumScores()), Long.valueOf(leaderboardvariant.getNumScores())) || !ee.equal(((LeaderboardVariant) (obj)).dt(), leaderboardvariant.dt()) || !ee.equal(((LeaderboardVariant) (obj)).dv(), leaderboardvariant.dv()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ee.equal(((LeaderboardVariant) (obj)).du(), leaderboardvariant.du())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String b(LeaderboardVariant leaderboardvariant)
    {
        com.google.android.gms.internal.ee.a a1 = ee.e(leaderboardvariant).a("TimeSpan", ge.aG(leaderboardvariant.getTimeSpan())).a("Collection", gc.aG(leaderboardvariant.getCollection()));
        Object obj;
        if (leaderboardvariant.hasPlayerInfo())
        {
            obj = Long.valueOf(leaderboardvariant.getRawPlayerScore());
        } else
        {
            obj = "none";
        }
        a1 = a1.a("RawPlayerScore", obj);
        if (leaderboardvariant.hasPlayerInfo())
        {
            obj = leaderboardvariant.getDisplayPlayerScore();
        } else
        {
            obj = "none";
        }
        a1 = a1.a("DisplayPlayerScore", obj);
        if (leaderboardvariant.hasPlayerInfo())
        {
            obj = Long.valueOf(leaderboardvariant.getPlayerRank());
        } else
        {
            obj = "none";
        }
        a1 = a1.a("PlayerRank", obj);
        if (leaderboardvariant.hasPlayerInfo())
        {
            obj = leaderboardvariant.getDisplayPlayerRank();
        } else
        {
            obj = "none";
        }
        return a1.a("DisplayPlayerRank", obj).a("NumScores", Long.valueOf(leaderboardvariant.getNumScores())).a("TopPageNextToken", leaderboardvariant.dt()).a("WindowPageNextToken", leaderboardvariant.dv()).a("WindowPagePrevToken", leaderboardvariant.du()).toString();
    }

    public String dt()
    {
        return we;
    }

    public String du()
    {
        return wf;
    }

    public String dv()
    {
        return wg;
    }

    public LeaderboardVariant dw()
    {
        return this;
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public Object freeze()
    {
        return dw();
    }

    public int getCollection()
    {
        return vW;
    }

    public String getDisplayPlayerRank()
    {
        return wb;
    }

    public String getDisplayPlayerScore()
    {
        return vZ;
    }

    public long getNumScores()
    {
        return wd;
    }

    public long getPlayerRank()
    {
        return wa;
    }

    public String getPlayerScoreTag()
    {
        return wc;
    }

    public long getRawPlayerScore()
    {
        return vY;
    }

    public int getTimeSpan()
    {
        return vV;
    }

    public boolean hasPlayerInfo()
    {
        return vX;
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
