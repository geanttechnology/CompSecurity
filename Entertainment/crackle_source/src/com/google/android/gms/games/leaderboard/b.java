// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            Leaderboard, a, g

public final class b extends com.google.android.gms.common.data.b
    implements Leaderboard
{

    private final Game vG;
    private final int vH;

    b(DataHolder dataholder, int i, int j)
    {
        super(dataholder, i);
        vH = j;
        vG = new com.google.android.gms.games.b(dataholder, i);
    }

    public Leaderboard dp()
    {
        return new a(this);
    }

    public boolean equals(Object obj)
    {
        return a.a(this, obj);
    }

    public Object freeze()
    {
        return dp();
    }

    public String getDisplayName()
    {
        return getString("name");
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        a("name", chararraybuffer);
    }

    public Game getGame()
    {
        return vG;
    }

    public Uri getIconImageUri()
    {
        return L("board_icon_image_uri");
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
        ArrayList arraylist = new ArrayList(vH);
        for (int i = 0; i < vH; i++)
        {
            arraylist.add(new g(nE, nG + i));
        }

        return arraylist;
    }

    public int hashCode()
    {
        return a.a(this);
    }

    public String toString()
    {
        return a.b(this);
    }
}
