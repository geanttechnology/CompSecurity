// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.zzc;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameRef;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            Leaderboard, LeaderboardEntity, LeaderboardVariantRef

public final class LeaderboardRef extends zzc
    implements Leaderboard
{

    private final int zzauX;
    private final Game zzazW;

    LeaderboardRef(DataHolder dataholder, int i, int j)
    {
        super(dataholder, i);
        zzauX = j;
        zzazW = new GameRef(dataholder, i);
    }

    public boolean equals(Object obj)
    {
        return LeaderboardEntity.zza(this, obj);
    }

    public Object freeze()
    {
        return zzvG();
    }

    public String getDisplayName()
    {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        zza("name", chararraybuffer);
    }

    public Game getGame()
    {
        return zzazW;
    }

    public Uri getIconImageUri()
    {
        return zzcf("board_icon_image_uri");
    }

    public String getIconImageUrl()
    {
        return getString("board_icon_image_url");
    }

    public String getLeaderboardId()
    {
        return getString("external_leaderboard_id");
    }

    public int getScoreOrder()
    {
        return getInteger("score_order");
    }

    public ArrayList getVariants()
    {
        ArrayList arraylist = new ArrayList(zzauX);
        for (int i = 0; i < zzauX; i++)
        {
            arraylist.add(new LeaderboardVariantRef(zzabq, zzadl + i));
        }

        return arraylist;
    }

    public int hashCode()
    {
        return LeaderboardEntity.zza(this);
    }

    public String toString()
    {
        return LeaderboardEntity.zzb(this);
    }

    public Leaderboard zzvG()
    {
        return new LeaderboardEntity(this);
    }
}
