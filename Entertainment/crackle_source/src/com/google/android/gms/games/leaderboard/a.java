// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.ee;
import com.google.android.gms.internal.fc;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            Leaderboard, LeaderboardVariant, f

public final class a
    implements Leaderboard
{

    private final String qa;
    private final Uri sL;
    private final String vD;
    private final int vE;
    private final ArrayList vF;
    private final Game vG;

    public a(Leaderboard leaderboard)
    {
        vD = leaderboard.getLeaderboardId();
        qa = leaderboard.getDisplayName();
        sL = leaderboard.getIconImageUri();
        vE = leaderboard.getScoreOrder();
        Object obj = leaderboard.getGame();
        int j;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new GameEntity(((Game) (obj)));
        }
        vG = ((Game) (obj));
        leaderboard = leaderboard.getVariants();
        j = leaderboard.size();
        vF = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            vF.add((f)(f)((LeaderboardVariant)leaderboard.get(i)).freeze());
        }

    }

    static int a(Leaderboard leaderboard)
    {
        return ee.hashCode(new Object[] {
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
        if (!ee.equal(((Leaderboard) (obj)).getLeaderboardId(), leaderboard.getLeaderboardId()) || !ee.equal(((Leaderboard) (obj)).getDisplayName(), leaderboard.getDisplayName()) || !ee.equal(((Leaderboard) (obj)).getIconImageUri(), leaderboard.getIconImageUri()) || !ee.equal(Integer.valueOf(((Leaderboard) (obj)).getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (ee.equal(((Leaderboard) (obj)).getVariants(), leaderboard.getVariants())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String b(Leaderboard leaderboard)
    {
        return ee.e(leaderboard).a("LeaderboardId", leaderboard.getLeaderboardId()).a("DisplayName", leaderboard.getDisplayName()).a("IconImageUri", leaderboard.getIconImageUri()).a("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).a("Variants", leaderboard.getVariants()).toString();
    }

    public Leaderboard dp()
    {
        return this;
    }

    public boolean equals(Object obj)
    {
        return a(this, obj);
    }

    public Object freeze()
    {
        return dp();
    }

    public String getDisplayName()
    {
        return qa;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        fc.b(qa, chararraybuffer);
    }

    public Game getGame()
    {
        return vG;
    }

    public Uri getIconImageUri()
    {
        return sL;
    }

    public String getLeaderboardId()
    {
        return vD;
    }

    public int getScoreOrder()
    {
        return vE;
    }

    public ArrayList getVariants()
    {
        return new ArrayList(vF);
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
