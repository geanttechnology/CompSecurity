// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.zzmo;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardScore

public final class LeaderboardScoreEntity
    implements LeaderboardScore
{

    private final String zzaAa;
    private final long zzaAb;
    private final long zzaAc;
    private final String zzaAd;
    private final Uri zzaAe;
    private final Uri zzaAf;
    private final PlayerEntity zzaAg;
    private final String zzaAh;
    private final String zzaAi;
    private final String zzaAj;
    private final long zzazY;
    private final String zzazZ;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardscore)
    {
        zzazY = leaderboardscore.getRank();
        zzazZ = (String)zzx.zzw(leaderboardscore.getDisplayRank());
        zzaAa = (String)zzx.zzw(leaderboardscore.getDisplayScore());
        zzaAb = leaderboardscore.getRawScore();
        zzaAc = leaderboardscore.getTimestampMillis();
        zzaAd = leaderboardscore.getScoreHolderDisplayName();
        zzaAe = leaderboardscore.getScoreHolderIconImageUri();
        zzaAf = leaderboardscore.getScoreHolderHiResImageUri();
        Object obj = leaderboardscore.getScoreHolder();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = (PlayerEntity)((Player) (obj)).freeze();
        }
        zzaAg = ((PlayerEntity) (obj));
        zzaAh = leaderboardscore.getScoreTag();
        zzaAi = leaderboardscore.getScoreHolderIconImageUrl();
        zzaAj = leaderboardscore.getScoreHolderHiResImageUrl();
    }

    static int zza(LeaderboardScore leaderboardscore)
    {
        return zzw.hashCode(new Object[] {
            Long.valueOf(leaderboardscore.getRank()), leaderboardscore.getDisplayRank(), Long.valueOf(leaderboardscore.getRawScore()), leaderboardscore.getDisplayScore(), Long.valueOf(leaderboardscore.getTimestampMillis()), leaderboardscore.getScoreHolderDisplayName(), leaderboardscore.getScoreHolderIconImageUri(), leaderboardscore.getScoreHolderHiResImageUri(), leaderboardscore.getScoreHolder()
        });
    }

    static boolean zza(LeaderboardScore leaderboardscore, Object obj)
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
        if (!zzw.equal(Long.valueOf(((LeaderboardScore) (obj)).getRank()), Long.valueOf(leaderboardscore.getRank())) || !zzw.equal(((LeaderboardScore) (obj)).getDisplayRank(), leaderboardscore.getDisplayRank()) || !zzw.equal(Long.valueOf(((LeaderboardScore) (obj)).getRawScore()), Long.valueOf(leaderboardscore.getRawScore())) || !zzw.equal(((LeaderboardScore) (obj)).getDisplayScore(), leaderboardscore.getDisplayScore()) || !zzw.equal(Long.valueOf(((LeaderboardScore) (obj)).getTimestampMillis()), Long.valueOf(leaderboardscore.getTimestampMillis())) || !zzw.equal(((LeaderboardScore) (obj)).getScoreHolderDisplayName(), leaderboardscore.getScoreHolderDisplayName()) || !zzw.equal(((LeaderboardScore) (obj)).getScoreHolderIconImageUri(), leaderboardscore.getScoreHolderIconImageUri()) || !zzw.equal(((LeaderboardScore) (obj)).getScoreHolderHiResImageUri(), leaderboardscore.getScoreHolderHiResImageUri()) || !zzw.equal(((LeaderboardScore) (obj)).getScoreHolder(), leaderboardscore.getScoreHolder()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((LeaderboardScore) (obj)).getScoreTag(), leaderboardscore.getScoreTag())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(LeaderboardScore leaderboardscore)
    {
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzv(leaderboardscore).zzg("Rank", Long.valueOf(leaderboardscore.getRank())).zzg("DisplayRank", leaderboardscore.getDisplayRank()).zzg("Score", Long.valueOf(leaderboardscore.getRawScore())).zzg("DisplayScore", leaderboardscore.getDisplayScore()).zzg("Timestamp", Long.valueOf(leaderboardscore.getTimestampMillis())).zzg("DisplayName", leaderboardscore.getScoreHolderDisplayName()).zzg("IconImageUri", leaderboardscore.getScoreHolderIconImageUri()).zzg("IconImageUrl", leaderboardscore.getScoreHolderIconImageUrl()).zzg("HiResImageUri", leaderboardscore.getScoreHolderHiResImageUri()).zzg("HiResImageUrl", leaderboardscore.getScoreHolderHiResImageUrl());
        Player player;
        if (leaderboardscore.getScoreHolder() == null)
        {
            player = null;
        } else
        {
            player = leaderboardscore.getScoreHolder();
        }
        return zza1.zzg("Player", player).zzg("ScoreTag", leaderboardscore.getScoreTag()).toString();
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Object freeze()
    {
        return zzvI();
    }

    public String getDisplayRank()
    {
        return zzazZ;
    }

    public void getDisplayRank(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzazZ, chararraybuffer);
    }

    public String getDisplayScore()
    {
        return zzaAa;
    }

    public void getDisplayScore(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzaAa, chararraybuffer);
    }

    public long getRank()
    {
        return zzazY;
    }

    public long getRawScore()
    {
        return zzaAb;
    }

    public Player getScoreHolder()
    {
        return zzaAg;
    }

    public String getScoreHolderDisplayName()
    {
        if (zzaAg == null)
        {
            return zzaAd;
        } else
        {
            return zzaAg.getDisplayName();
        }
    }

    public void getScoreHolderDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (zzaAg == null)
        {
            zzmo.zzb(zzaAd, chararraybuffer);
            return;
        } else
        {
            zzaAg.getDisplayName(chararraybuffer);
            return;
        }
    }

    public Uri getScoreHolderHiResImageUri()
    {
        if (zzaAg == null)
        {
            return zzaAf;
        } else
        {
            return zzaAg.getHiResImageUri();
        }
    }

    public String getScoreHolderHiResImageUrl()
    {
        if (zzaAg == null)
        {
            return zzaAj;
        } else
        {
            return zzaAg.getHiResImageUrl();
        }
    }

    public Uri getScoreHolderIconImageUri()
    {
        if (zzaAg == null)
        {
            return zzaAe;
        } else
        {
            return zzaAg.getIconImageUri();
        }
    }

    public String getScoreHolderIconImageUrl()
    {
        if (zzaAg == null)
        {
            return zzaAi;
        } else
        {
            return zzaAg.getIconImageUrl();
        }
    }

    public String getScoreTag()
    {
        return zzaAh;
    }

    public long getTimestampMillis()
    {
        return zzaAc;
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

    public LeaderboardScore zzvI()
    {
        return this;
    }
}
