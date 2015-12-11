// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.b;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.d;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            LeaderboardScore, d

public final class e extends b
    implements LeaderboardScore
{

    private final d vU;

    e(DataHolder dataholder, int i)
    {
        super(dataholder, i);
        vU = new d(dataholder, i);
    }

    public LeaderboardScore ds()
    {
        return new com.google.android.gms.games.leaderboard.d(this);
    }

    public boolean equals(Object obj)
    {
        return d.a(this, obj);
    }

    public Object freeze()
    {
        return ds();
    }

    public String getDisplayRank()
    {
        return getString("display_rank");
    }

    public void getDisplayRank(CharArrayBuffer chararraybuffer)
    {
        a("display_rank", chararraybuffer);
    }

    public String getDisplayScore()
    {
        return getString("display_score");
    }

    public void getDisplayScore(CharArrayBuffer chararraybuffer)
    {
        a("display_score", chararraybuffer);
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
        if (M("external_player_id"))
        {
            return null;
        } else
        {
            return vU;
        }
    }

    public String getScoreHolderDisplayName()
    {
        if (M("external_player_id"))
        {
            return getString("default_display_name");
        } else
        {
            return vU.getDisplayName();
        }
    }

    public void getScoreHolderDisplayName(CharArrayBuffer chararraybuffer)
    {
        if (M("external_player_id"))
        {
            a("default_display_name", chararraybuffer);
            return;
        } else
        {
            vU.getDisplayName(chararraybuffer);
            return;
        }
    }

    public Uri getScoreHolderHiResImageUri()
    {
        if (M("external_player_id"))
        {
            return null;
        } else
        {
            return vU.getHiResImageUri();
        }
    }

    public Uri getScoreHolderIconImageUri()
    {
        if (M("external_player_id"))
        {
            return L("default_display_image_uri");
        } else
        {
            return vU.getIconImageUri();
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
        return d.a(this);
    }

    public String toString()
    {
        return com.google.android.gms.games.leaderboard.d.b(this);
    }
}
