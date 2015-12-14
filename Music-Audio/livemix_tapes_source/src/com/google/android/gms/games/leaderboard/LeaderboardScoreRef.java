// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardScore, LeaderboardScoreEntity

public final class LeaderboardScoreRef extends zzc
    implements LeaderboardScore
{

    private final PlayerRef zzaxK;

    LeaderboardScoreRef(DataHolder dataholder, int i)
    {
        super(dataholder, i);
        zzaxK = new PlayerRef(dataholder, i);
    }

    public boolean equals(Object obj)
    {
        return LeaderboardScoreEntity.zza(this, obj);
    }

    public Object freeze()
    {
        return zzuS();
    }

    public String getDisplayRank()
    {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer chararraybuffer)
    {
        zza("display_rank", chararraybuffer);
    }

    public String getDisplayScore()
    {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer chararraybuffer)
    {
        zza("display_score", chararraybuffer);
    }

    public long getRank()
    {
        return getLong("rank");
    }

    public long getRawScore()
    {
        return getLong("raw_score");
    }

    public Player getScoreHolder()
    {
        if (zzcf("external_player_id"))
        {
            return null;
        } else
        {
            return zzaxK;
        }
    }

    public String getScoreHolderDisplayName()
    {
        if (zzcf("external_player_id"))
        {
            return getString("default_display_name");
        } else
        {
            return zzaxK.getDisplayName();
        }
    }

    public void getScoreHolderDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (zzcf("external_player_id"))
        {
            zza("default_display_name", chararraybuffer);
            return;
        } else
        {
            zzaxK.getDisplayName(chararraybuffer);
            return;
        }
    }

    public Uri getScoreHolderHiResImageUri()
    {
        if (zzcf("external_player_id"))
        {
            return null;
        } else
        {
            return zzaxK.getHiResImageUri();
        }
    }

    public String getScoreHolderHiResImageUrl()
    {
        if (zzcf("external_player_id"))
        {
            return null;
        } else
        {
            return zzaxK.getHiResImageUrl();
        }
    }

    public Uri getScoreHolderIconImageUri()
    {
        if (zzcf("external_player_id"))
        {
            return zzce("default_display_image_uri");
        } else
        {
            return zzaxK.getIconImageUri();
        }
    }

    public String getScoreHolderIconImageUrl()
    {
        if (zzcf("external_player_id"))
        {
            return getString("default_display_image_url");
        } else
        {
            return zzaxK.getIconImageUrl();
        }
    }

    public String getScoreTag()
    {
        return getString("score_tag");
    }

    public long getTimestampMillis()
    {
        return getLong("achieved_timestamp");
    }

    public int hashCode()
    {
        return LeaderboardScoreEntity.zza(this);
    }

    public String toString()
    {
        return LeaderboardScoreEntity.zzb(this);
    }

    public LeaderboardScore zzuS()
    {
        return new LeaderboardScoreEntity(this);
    }
}
