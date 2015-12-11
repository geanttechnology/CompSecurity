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

    private final int zzaAl;
    private final int zzaAm;
    private final boolean zzaAn;
    private final long zzaAo;
    private final String zzaAp;
    private final long zzaAq;
    private final String zzaAr;
    private final String zzaAs;
    private final long zzaAt;
    private final String zzaAu;
    private final String zzaAv;
    private final String zzaAw;

    public LeaderboardVariantEntity(LeaderboardVariant leaderboardvariant)
    {
        zzaAl = leaderboardvariant.getTimeSpan();
        zzaAm = leaderboardvariant.getCollection();
        zzaAn = leaderboardvariant.hasPlayerInfo();
        zzaAo = leaderboardvariant.getRawPlayerScore();
        zzaAp = leaderboardvariant.getDisplayPlayerScore();
        zzaAq = leaderboardvariant.getPlayerRank();
        zzaAr = leaderboardvariant.getDisplayPlayerRank();
        zzaAs = leaderboardvariant.getPlayerScoreTag();
        zzaAt = leaderboardvariant.getNumScores();
        zzaAu = leaderboardvariant.zzvJ();
        zzaAv = leaderboardvariant.zzvK();
        zzaAw = leaderboardvariant.zzvL();
    }

    static int zza(LeaderboardVariant leaderboardvariant)
    {
        return zzw.hashCode(new Object[] {
            Integer.valueOf(leaderboardvariant.getTimeSpan()), Integer.valueOf(leaderboardvariant.getCollection()), Boolean.valueOf(leaderboardvariant.hasPlayerInfo()), Long.valueOf(leaderboardvariant.getRawPlayerScore()), leaderboardvariant.getDisplayPlayerScore(), Long.valueOf(leaderboardvariant.getPlayerRank()), leaderboardvariant.getDisplayPlayerRank(), Long.valueOf(leaderboardvariant.getNumScores()), leaderboardvariant.zzvJ(), leaderboardvariant.zzvL(), 
            leaderboardvariant.zzvK()
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
        if (!zzw.equal(Integer.valueOf(((LeaderboardVariant) (obj)).getTimeSpan()), Integer.valueOf(leaderboardvariant.getTimeSpan())) || !zzw.equal(Integer.valueOf(((LeaderboardVariant) (obj)).getCollection()), Integer.valueOf(leaderboardvariant.getCollection())) || !zzw.equal(Boolean.valueOf(((LeaderboardVariant) (obj)).hasPlayerInfo()), Boolean.valueOf(leaderboardvariant.hasPlayerInfo())) || !zzw.equal(Long.valueOf(((LeaderboardVariant) (obj)).getRawPlayerScore()), Long.valueOf(leaderboardvariant.getRawPlayerScore())) || !zzw.equal(((LeaderboardVariant) (obj)).getDisplayPlayerScore(), leaderboardvariant.getDisplayPlayerScore()) || !zzw.equal(Long.valueOf(((LeaderboardVariant) (obj)).getPlayerRank()), Long.valueOf(leaderboardvariant.getPlayerRank())) || !zzw.equal(((LeaderboardVariant) (obj)).getDisplayPlayerRank(), leaderboardvariant.getDisplayPlayerRank()) || !zzw.equal(Long.valueOf(((LeaderboardVariant) (obj)).getNumScores()), Long.valueOf(leaderboardvariant.getNumScores())) || !zzw.equal(((LeaderboardVariant) (obj)).zzvJ(), leaderboardvariant.zzvJ()) || !zzw.equal(((LeaderboardVariant) (obj)).zzvL(), leaderboardvariant.zzvL()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((LeaderboardVariant) (obj)).zzvK(), leaderboardvariant.zzvK())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(LeaderboardVariant leaderboardvariant)
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzv(leaderboardvariant).zzg("TimeSpan", TimeSpan.zzfZ(leaderboardvariant.getTimeSpan())).zzg("Collection", LeaderboardCollection.zzfZ(leaderboardvariant.getCollection()));
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
        return zza1.zzg("DisplayPlayerRank", obj).zzg("NumScores", Long.valueOf(leaderboardvariant.getNumScores())).zzg("TopPageNextToken", leaderboardvariant.zzvJ()).zzg("WindowPageNextToken", leaderboardvariant.zzvL()).zzg("WindowPagePrevToken", leaderboardvariant.zzvK()).toString();
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Object freeze()
    {
        return zzvM();
    }

    public int getCollection()
    {
        return zzaAm;
    }

    public String getDisplayPlayerRank()
    {
        return zzaAr;
    }

    public String getDisplayPlayerScore()
    {
        return zzaAp;
    }

    public long getNumScores()
    {
        return zzaAt;
    }

    public long getPlayerRank()
    {
        return zzaAq;
    }

    public String getPlayerScoreTag()
    {
        return zzaAs;
    }

    public long getRawPlayerScore()
    {
        return zzaAo;
    }

    public int getTimeSpan()
    {
        return zzaAl;
    }

    public boolean hasPlayerInfo()
    {
        return zzaAn;
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

    public String zzvJ()
    {
        return zzaAu;
    }

    public String zzvK()
    {
        return zzaAv;
    }

    public String zzvL()
    {
        return zzaAw;
    }

    public LeaderboardVariant zzvM()
    {
        return this;
    }
}
