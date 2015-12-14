// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.internal.constants.LeaderboardCollection;
import com.google.android.gms.games.internal.constants.TimeSpan;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardVariant

public final class LeaderboardVariantEntity
    implements LeaderboardVariant
{

    private final int zzaxL;
    private final int zzaxM;
    private final boolean zzaxN;
    private final long zzaxO;
    private final String zzaxP;
    private final long zzaxQ;
    private final String zzaxR;
    private final String zzaxS;
    private final long zzaxT;
    private final String zzaxU;
    private final String zzaxV;
    private final String zzaxW;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardvariant)
    {
        zzaxL = leaderboardvariant.getTimeSpan();
        zzaxM = leaderboardvariant.getCollection();
        zzaxN = leaderboardvariant.hasPlayerInfo();
        zzaxO = leaderboardvariant.getRawPlayerScore();
        zzaxP = leaderboardvariant.getDisplayPlayerScore();
        zzaxQ = leaderboardvariant.getPlayerRank();
        zzaxR = leaderboardvariant.getDisplayPlayerRank();
        zzaxS = leaderboardvariant.getPlayerScoreTag();
        zzaxT = leaderboardvariant.getNumScores();
        zzaxU = leaderboardvariant.zzuT();
        zzaxV = leaderboardvariant.zzuU();
        zzaxW = leaderboardvariant.zzuV();
    }

    static int zza(LeaderboardVariant leaderboardvariant)
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(leaderboardvariant.getTimeSpan()), Integer.valueOf(leaderboardvariant.getCollection()), Boolean.valueOf(leaderboardvariant.hasPlayerInfo()), Long.valueOf(leaderboardvariant.getRawPlayerScore()), leaderboardvariant.getDisplayPlayerScore(), Long.valueOf(leaderboardvariant.getPlayerRank()), leaderboardvariant.getDisplayPlayerRank(), Long.valueOf(leaderboardvariant.getNumScores()), leaderboardvariant.zzuT(), leaderboardvariant.zzuV(), 
            leaderboardvariant.zzuU()
        });
    }

    static boolean zza(LeaderboardVariant leaderboardvariant, Object obj)
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
        if (!zzw.equal(Integer.valueOf(((LeaderboardVariant) (obj)).getTimeSpan()), Integer.valueOf(leaderboardvariant.getTimeSpan())) || !zzw.equal(Integer.valueOf(((LeaderboardVariant) (obj)).getCollection()), Integer.valueOf(leaderboardvariant.getCollection())) || !zzw.equal(Boolean.valueOf(((LeaderboardVariant) (obj)).hasPlayerInfo()), Boolean.valueOf(leaderboardvariant.hasPlayerInfo())) || !zzw.equal(Long.valueOf(((LeaderboardVariant) (obj)).getRawPlayerScore()), Long.valueOf(leaderboardvariant.getRawPlayerScore())) || !zzw.equal(((LeaderboardVariant) (obj)).getDisplayPlayerScore(), leaderboardvariant.getDisplayPlayerScore()) || !zzw.equal(Long.valueOf(((LeaderboardVariant) (obj)).getPlayerRank()), Long.valueOf(leaderboardvariant.getPlayerRank())) || !zzw.equal(((LeaderboardVariant) (obj)).getDisplayPlayerRank(), leaderboardvariant.getDisplayPlayerRank()) || !zzw.equal(Long.valueOf(((LeaderboardVariant) (obj)).getNumScores()), Long.valueOf(leaderboardvariant.getNumScores())) || !zzw.equal(((LeaderboardVariant) (obj)).zzuT(), leaderboardvariant.zzuT()) || !zzw.equal(((LeaderboardVariant) (obj)).zzuV(), leaderboardvariant.zzuV()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((LeaderboardVariant) (obj)).zzuU(), leaderboardvariant.zzuU())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(LeaderboardVariant leaderboardvariant)
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzu(leaderboardvariant).zzg("TimeSpan", TimeSpan.zzfQ(leaderboardvariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zzfQ(leaderboardvariant.getCollection()));
        Object obj;
        if (leaderboardvariant.hasPlayerInfo())
        {
            obj = Long.valueOf(leaderboardvariant.getRawPlayerScore());
        } else
        {
            obj = "none";
        }
        zza1 = zza1.zzg("RawPlayerScore", obj);
        if (leaderboardvariant.hasPlayerInfo())
        {
            obj = leaderboardvariant.getDisplayPlayerScore();
        } else
        {
            obj = "none";
        }
        zza1 = zza1.zzg("DisplayPlayerScore", obj);
        if (leaderboardvariant.hasPlayerInfo())
        {
            obj = Long.valueOf(leaderboardvariant.getPlayerRank());
        } else
        {
            obj = "none";
        }
        zza1 = zza1.zzg("PlayerRank", obj);
        if (leaderboardvariant.hasPlayerInfo())
        {
            obj = leaderboardvariant.getDisplayPlayerRank();
        } else
        {
            obj = "none";
        }
        return zza1.zzg("DisplayPlayerRank", obj).zzg("NumScores", Long.valueOf(leaderboardvariant.getNumScores())).zzg("TopPageNextToken", leaderboardvariant.zzuT()).zzg("WindowPageNextToken", leaderboardvariant.zzuV()).zzg("WindowPagePrevToken", leaderboardvariant.zzuU()).toString();
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Object freeze()
    {
        return zzuW();
    }

    public int getCollection()
    {
        return zzaxM;
    }

    public String getDisplayPlayerRank()
    {
        return zzaxR;
    }

    public String getDisplayPlayerScore()
    {
        return zzaxP;
    }

    public long getNumScores()
    {
        return zzaxT;
    }

    public long getPlayerRank()
    {
        return zzaxQ;
    }

    public String getPlayerScoreTag()
    {
        return zzaxS;
    }

    public long getRawPlayerScore()
    {
        return zzaxO;
    }

    public int getTimeSpan()
    {
        return zzaxL;
    }

    public boolean hasPlayerInfo()
    {
        return zzaxN;
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

    public String zzuT()
    {
        return zzaxU;
    }

    public String zzuU()
    {
        return zzaxV;
    }

    public String zzuV()
    {
        return zzaxW;
    }

    public LeaderboardVariant zzuW()
    {
        return this;
    }
}
