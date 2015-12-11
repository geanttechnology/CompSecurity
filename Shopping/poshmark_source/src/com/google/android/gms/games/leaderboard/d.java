// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.fm;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardScore

public final class d
    implements LeaderboardScore
{

    private final long IQ;
    private final String IR;
    private final String IS;
    private final long IT;
    private final long IU;
    private final String IV;
    private final Uri IW;
    private final Uri IX;
    private final PlayerEntity IY;
    private final String IZ;
    private final String Ja;
    private final String Jb;

    public d(LeaderboardScore leaderboardscore)
    {
        IQ = leaderboardscore.getRank();
        IR = (String)er.f(leaderboardscore.getDisplayRank());
        IS = (String)er.f(leaderboardscore.getDisplayScore());
        IT = leaderboardscore.getRawScore();
        IU = leaderboardscore.getTimestampMillis();
        IV = leaderboardscore.getScoreHolderDisplayName();
        IW = leaderboardscore.getScoreHolderIconImageUri();
        IX = leaderboardscore.getScoreHolderHiResImageUri();
        Object obj = leaderboardscore.getScoreHolder();
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = (PlayerEntity)((Player) (obj)).freeze();
        }
        IY = ((PlayerEntity) (obj));
        IZ = leaderboardscore.getScoreTag();
        Ja = leaderboardscore.getScoreHolderIconImageUrl();
        Jb = leaderboardscore.getScoreHolderHiResImageUrl();
    }

    static int a(LeaderboardScore leaderboardscore)
    {
        return ep.hashCode(new Object[] {
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
        if (!ep.equal(Long.valueOf(((LeaderboardScore) (obj)).getRank()), Long.valueOf(leaderboardscore.getRank())) || !ep.equal(((LeaderboardScore) (obj)).getDisplayRank(), leaderboardscore.getDisplayRank()) || !ep.equal(Long.valueOf(((LeaderboardScore) (obj)).getRawScore()), Long.valueOf(leaderboardscore.getRawScore())) || !ep.equal(((LeaderboardScore) (obj)).getDisplayScore(), leaderboardscore.getDisplayScore()) || !ep.equal(Long.valueOf(((LeaderboardScore) (obj)).getTimestampMillis()), Long.valueOf(leaderboardscore.getTimestampMillis())) || !ep.equal(((LeaderboardScore) (obj)).getScoreHolderDisplayName(), leaderboardscore.getScoreHolderDisplayName()) || !ep.equal(((LeaderboardScore) (obj)).getScoreHolderIconImageUri(), leaderboardscore.getScoreHolderIconImageUri()) || !ep.equal(((LeaderboardScore) (obj)).getScoreHolderHiResImageUri(), leaderboardscore.getScoreHolderHiResImageUri()) || !ep.equal(((LeaderboardScore) (obj)).getScoreHolder(), leaderboardscore.getScoreHolder()))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ep.equal(((LeaderboardScore) (obj)).getScoreTag(), leaderboardscore.getScoreTag())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String b(LeaderboardScore leaderboardscore)
    {
        com.google.android.gms.internal.ep.a a1 = ep.e(leaderboardscore).a("Rank", Long.valueOf(leaderboardscore.getRank())).a("DisplayRank", leaderboardscore.getDisplayRank()).a("Score", Long.valueOf(leaderboardscore.getRawScore())).a("DisplayScore", leaderboardscore.getDisplayScore()).a("Timestamp", Long.valueOf(leaderboardscore.getTimestampMillis())).a("DisplayName", leaderboardscore.getScoreHolderDisplayName()).a("IconImageUri", leaderboardscore.getScoreHolderIconImageUri()).a("IconImageUrl", leaderboardscore.getScoreHolderIconImageUrl()).a("HiResImageUri", leaderboardscore.getScoreHolderHiResImageUri()).a("HiResImageUrl", leaderboardscore.getScoreHolderHiResImageUrl());
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

    public boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public LeaderboardScore fZ()
    {
        return this;
    }

    public Object freeze()
    {
        return fZ();
    }

    public String getDisplayRank()
    {
        return IR;
    }

    public void getDisplayRank(CharArrayBuffer chararraybuffer)
    {
        fm.b(IR, chararraybuffer);
    }

    public String getDisplayScore()
    {
        return IS;
    }

    public void getDisplayScore(CharArrayBuffer chararraybuffer)
    {
        fm.b(IS, chararraybuffer);
    }

    public long getRank()
    {
        return IQ;
    }

    public long getRawScore()
    {
        return IT;
    }

    public Player getScoreHolder()
    {
        return IY;
    }

    public String getScoreHolderDisplayName()
    {
        if (IY == null)
        {
            return IV;
        } else
        {
            return IY.getDisplayName();
        }
    }

    public void getScoreHolderDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (IY == null)
        {
            fm.b(IV, chararraybuffer);
            return;
        } else
        {
            IY.getDisplayName(chararraybuffer);
            return;
        }
    }

    public Uri getScoreHolderHiResImageUri()
    {
        if (IY == null)
        {
            return IX;
        } else
        {
            return IY.getHiResImageUri();
        }
    }

    public String getScoreHolderHiResImageUrl()
    {
        if (IY == null)
        {
            return Jb;
        } else
        {
            return IY.getHiResImageUrl();
        }
    }

    public Uri getScoreHolderIconImageUri()
    {
        if (IY == null)
        {
            return IW;
        } else
        {
            return IY.getIconImageUri();
        }
    }

    public String getScoreHolderIconImageUrl()
    {
        if (IY == null)
        {
            return Ja;
        } else
        {
            return IY.getIconImageUrl();
        }
    }

    public String getScoreTag()
    {
        return IZ;
    }

    public long getTimestampMillis()
    {
        return IU;
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
