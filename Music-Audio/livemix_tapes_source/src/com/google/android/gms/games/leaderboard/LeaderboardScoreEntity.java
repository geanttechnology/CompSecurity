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
import com.google.android.gms.internal.zzln;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardScore

public final class LeaderboardScoreEntity
    implements LeaderboardScore
{

    private final String zzaxA;
    private final long zzaxB;
    private final long zzaxC;
    private final String zzaxD;
    private final Uri zzaxE;
    private final Uri zzaxF;
    private final PlayerEntity zzaxG;
    private final String zzaxH;
    private final String zzaxI;
    private final String zzaxJ;
    private final long zzaxy;
    private final String zzaxz;

    public LeaderboardScoreEntity(LeaderboardScore leaderboardscore)
    {
        zzaxy = leaderboardscore.getRank();
        zzaxz = (String)zzx.zzv(leaderboardscore.getDisplayRank());
        zzaxA = (String)zzx.zzv(leaderboardscore.getDisplayScore());
        zzaxB = leaderboardscore.getRawScore();
        zzaxC = leaderboardscore.getTimestampMillis();
        zzaxD = leaderboardscore.getScoreHolderDisplayName();
        zzaxE = leaderboardscore.getScoreHolderIconImageUri();
        zzaxF = leaderboardscore.getScoreHolderHiResImageUri();
        Object obj = leaderboardscore.getScoreHolder();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = (PlayerEntity)((Player) (obj)).freeze();
        }
        zzaxG = ((PlayerEntity) (obj));
        zzaxH = leaderboardscore.getScoreTag();
        zzaxI = leaderboardscore.getScoreHolderIconImageUrl();
        zzaxJ = leaderboardscore.getScoreHolderHiResImageUrl();
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
        com.google.android.gms.common.internal.zzw.zza zza1 = zzw.zzu(leaderboardscore).zzg("Rank", Long.valueOf(leaderboardscore.getRank())).zzg("DisplayRank", leaderboardscore.getDisplayRank()).zzg("Score", Long.valueOf(leaderboardscore.getRawScore())).zzg("DisplayScore", leaderboardscore.getDisplayScore()).zzg("Timestamp", Long.valueOf(leaderboardscore.getTimestampMillis())).zzg("DisplayName", leaderboardscore.getScoreHolderDisplayName()).zzg("IconImageUri", leaderboardscore.getScoreHolderIconImageUri()).zzg("IconImageUrl", leaderboardscore.getScoreHolderIconImageUrl()).zzg("HiResImageUri", leaderboardscore.getScoreHolderHiResImageUri()).zzg("HiResImageUrl", leaderboardscore.getScoreHolderHiResImageUrl());
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
        return zzuS();
    }

    public String getDisplayRank()
    {
        return zzaxz;
    }

    public void getDisplayRank(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzaxz, chararraybuffer);
    }

    public String getDisplayScore()
    {
        return zzaxA;
    }

    public void getDisplayScore(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzaxA, chararraybuffer);
    }

    public long getRank()
    {
        return zzaxy;
    }

    public long getRawScore()
    {
        return zzaxB;
    }

    public Player getScoreHolder()
    {
        return zzaxG;
    }

    public String getScoreHolderDisplayName()
    {
        if (zzaxG == null)
        {
            return zzaxD;
        } else
        {
            return zzaxG.getDisplayName();
        }
    }

    public void getScoreHolderDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (zzaxG == null)
        {
            zzln.zzb(zzaxD, chararraybuffer);
            return;
        } else
        {
            zzaxG.getDisplayName(chararraybuffer);
            return;
        }
    }

    public Uri getScoreHolderHiResImageUri()
    {
        if (zzaxG == null)
        {
            return zzaxF;
        } else
        {
            return zzaxG.getHiResImageUri();
        }
    }

    public String getScoreHolderHiResImageUrl()
    {
        if (zzaxG == null)
        {
            return zzaxJ;
        } else
        {
            return zzaxG.getHiResImageUrl();
        }
    }

    public Uri getScoreHolderIconImageUri()
    {
        if (zzaxG == null)
        {
            return zzaxE;
        } else
        {
            return zzaxG.getIconImageUri();
        }
    }

    public String getScoreHolderIconImageUrl()
    {
        if (zzaxG == null)
        {
            return zzaxI;
        } else
        {
            return zzaxG.getIconImageUrl();
        }
    }

    public String getScoreTag()
    {
        return zzaxH;
    }

    public long getTimestampMillis()
    {
        return zzaxC;
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

    public LeaderboardScore zzuS()
    {
        return this;
    }
}
