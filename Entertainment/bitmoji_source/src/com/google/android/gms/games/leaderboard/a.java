// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.ep;
import com.google.android.gms.internal.fm;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            Leaderboard, LeaderboardVariant, f

public final class a
    implements Leaderboard
{

    private final String FE;
    private final Uri FJ;
    private final String FU;
    private final String IJ;
    private final int IK;
    private final ArrayList IL;
    private final Game IM;

    public a(Leaderboard leaderboard)
    {
        IJ = leaderboard.getLeaderboardId();
        FE = leaderboard.getDisplayName();
        FJ = leaderboard.getIconImageUri();
        FU = leaderboard.getIconImageUrl();
        IK = leaderboard.getScoreOrder();
        Object obj = leaderboard.getGame();
        int j;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new GameEntity(((Game) (obj)));
        }
        IM = ((Game) (obj));
        leaderboard = leaderboard.getVariants();
        j = leaderboard.size();
        IL = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            IL.add((f)(f)((LeaderboardVariant)leaderboard.get(i)).freeze());
        }

    }

    static int a(Leaderboard leaderboard)
    {
        return ep.hashCode(new Object[] {
            leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants()
        });
    }

    static boolean a(Leaderboard leaderboard, Object obj)
    {
        boolean flag1 = true;
        if (obj instanceof Leaderboard) goto _L2; else goto _L1
_L1:
        boolean flag = false;
_L4:
        return flag;
_L2:
        flag = flag1;
        if (leaderboard == obj) goto _L4; else goto _L3
_L3:
        obj = (Leaderboard)obj;
        if (!ep.equal(((Leaderboard) (obj)).getLeaderboardId(), leaderboard.getLeaderboardId()) || !ep.equal(((Leaderboard) (obj)).getDisplayName(), leaderboard.getDisplayName()) || !ep.equal(((Leaderboard) (obj)).getIconImageUri(), leaderboard.getIconImageUri()) || !ep.equal(Integer.valueOf(((Leaderboard) (obj)).getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ep.equal(((Leaderboard) (obj)).getVariants(), leaderboard.getVariants())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String b(Leaderboard leaderboard)
    {
        return ep.e(leaderboard).a("LeaderboardId", leaderboard.getLeaderboardId()).a("DisplayName", leaderboard.getDisplayName()).a("IconImageUri", leaderboard.getIconImageUri()).a("IconImageUrl", leaderboard.getIconImageUrl()).a("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).a("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public Leaderboard fW()
    {
        return this;
    }

    public Object freeze()
    {
        return fW();
    }

    public String getDisplayName()
    {
        return FE;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        fm.b(FE, chararraybuffer);
    }

    public Game getGame()
    {
        return IM;
    }

    public Uri getIconImageUri()
    {
        return FJ;
    }

    public String getIconImageUrl()
    {
        return FU;
    }

    public String getLeaderboardId()
    {
        return IJ;
    }

    public int getScoreOrder()
    {
        return IK;
    }

    public ArrayList getVariants()
    {
        return new ArrayList(IL);
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
