// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.gq;
import com.google.android.gms.internal.gu;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardVariant

public final class f
    implements LeaderboardVariant
{

    private final int Jd;
    private final int Je;
    private final boolean Jf;
    private final long Jg;
    private final String Jh;
    private final long Ji;
    private final String Jj;
    private final String Jk;
    private final long Jl;
    private final String Jm;
    private final String Jn;
    private final String Jo;

    public f(LeaderboardVariant leaderboardvariant)
    {
        Jd = leaderboardvariant.getTimeSpan();
        Je = leaderboardvariant.getCollection();
        Jf = leaderboardvariant.hasPlayerInfo();
        Jg = leaderboardvariant.getRawPlayerScore();
        Jh = leaderboardvariant.getDisplayPlayerScore();
        Ji = leaderboardvariant.getPlayerRank();
        Jj = leaderboardvariant.getDisplayPlayerRank();
        Jk = leaderboardvariant.getPlayerScoreTag();
        Jl = leaderboardvariant.getNumScores();
        Jm = leaderboardvariant.ga();
        Jn = leaderboardvariant.gb();
        Jo = leaderboardvariant.gc();
    }

    static int a(LeaderboardVariant leaderboardvariant)
    {
        return ep.hashCode(new Object[] {
            Integer.valueOf(leaderboardvariant.getTimeSpan()), Integer.valueOf(leaderboardvariant.getCollection()), Boolean.valueOf(leaderboardvariant.hasPlayerInfo()), Long.valueOf(leaderboardvariant.getRawPlayerScore()), leaderboardvariant.getDisplayPlayerScore(), Long.valueOf(leaderboardvariant.getPlayerRank()), leaderboardvariant.getDisplayPlayerRank(), Long.valueOf(leaderboardvariant.getNumScores()), leaderboardvariant.ga(), leaderboardvariant.gc(), 
            leaderboardvariant.gb()
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
        if (!ep.equal(Integer.valueOf(((LeaderboardVariant) (obj)).getTimeSpan()), Integer.valueOf(leaderboardvariant.getTimeSpan())) || !ep.equal(Integer.valueOf(((LeaderboardVariant) (obj)).getCollection()), Integer.valueOf(leaderboardvariant.getCollection())) || !ep.equal(Boolean.valueOf(((LeaderboardVariant) (obj)).hasPlayerInfo()), Boolean.valueOf(leaderboardvariant.hasPlayerInfo())) || !ep.equal(Long.valueOf(((LeaderboardVariant) (obj)).getRawPlayerScore()), Long.valueOf(leaderboardvariant.getRawPlayerScore())) || !ep.equal(((LeaderboardVariant) (obj)).getDisplayPlayerScore(), leaderboardvariant.getDisplayPlayerScore()) || !ep.equal(Long.valueOf(((LeaderboardVariant) (obj)).getPlayerRank()), Long.valueOf(leaderboardvariant.getPlayerRank())) || !ep.equal(((LeaderboardVariant) (obj)).getDisplayPlayerRank(), leaderboardvariant.getDisplayPlayerRank()) || !ep.equal(Long.valueOf(((LeaderboardVariant) (obj)).getNumScores()), Long.valueOf(leaderboardvariant.getNumScores())) || !ep.equal(((LeaderboardVariant) (obj)).ga(), leaderboardvariant.ga()) || !ep.equal(((LeaderboardVariant) (obj)).gc(), leaderboardvariant.gc()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ep.equal(((LeaderboardVariant) (obj)).gb(), leaderboardvariant.gb())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String b(LeaderboardVariant leaderboardvariant)
    {
        com.google.android.gms.internal.ep.a a1 = ep.e(leaderboardvariant).a("TimeSpan", gu.aW(leaderboardvariant.getTimeSpan())).a("Collection", gq.aW(leaderboardvariant.getCollection()));
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
        return a1.a("DisplayPlayerRank", obj).a("NumScores", Long.valueOf(leaderboardvariant.getNumScores())).a("TopPageNextToken", leaderboardvariant.ga()).a("WindowPageNextToken", leaderboardvariant.gc()).a("WindowPagePrevToken", leaderboardvariant.gb()).toString();
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public Object freeze()
    {
        return gd();
    }

    public String ga()
    {
        return Jm;
    }

    public String gb()
    {
        return Jn;
    }

    public String gc()
    {
        return Jo;
    }

    public LeaderboardVariant gd()
    {
        return this;
    }

    public int getCollection()
    {
        return Je;
    }

    public String getDisplayPlayerRank()
    {
        return Jj;
    }

    public String getDisplayPlayerScore()
    {
        return Jh;
    }

    public long getNumScores()
    {
        return Jl;
    }

    public long getPlayerRank()
    {
        return Ji;
    }

    public String getPlayerScoreTag()
    {
        return Jk;
    }

    public long getRawPlayerScore()
    {
        return Jg;
    }

    public int getTimeSpan()
    {
        return Jd;
    }

    public boolean hasPlayerInfo()
    {
        return Jf;
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
