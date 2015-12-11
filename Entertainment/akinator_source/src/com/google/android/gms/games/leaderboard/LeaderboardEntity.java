// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzmo;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            Leaderboard, LeaderboardVariant, LeaderboardVariantEntity

public final class LeaderboardEntity
    implements Leaderboard
{

    private final String zzTa;
    private final String zzatF;
    private final Uri zzatu;
    private final String zzazT;
    private final int zzazU;
    private final ArrayList zzazV;
    private final Game zzazW;

    public LeaderboardEntity(Leaderboard leaderboard)
    {
        zzazT = leaderboard.getLeaderboardId();
        zzTa = leaderboard.getDisplayName();
        zzatu = leaderboard.getIconImageUri();
        zzatF = leaderboard.getIconImageUrl();
        zzazU = leaderboard.getScoreOrder();
        Object obj = leaderboard.getGame();
        int j;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new GameEntity(((Game) (obj)));
        }
        zzazW = ((Game) (obj));
        leaderboard = leaderboard.getVariants();
        j = leaderboard.size();
        zzazV = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            zzazV.add((LeaderboardVariantEntity)(LeaderboardVariantEntity)((LeaderboardVariant)leaderboard.get(i)).freeze());
        }

    }

    static int zza(Leaderboard leaderboard)
    {
        return zzw.hashCode(new Object[] {
            leaderboard.getLeaderboardId(), leaderboard.getDisplayName(), leaderboard.getIconImageUri(), Integer.valueOf(leaderboard.getScoreOrder()), leaderboard.getVariants()
        });
    }

    static boolean zza(Leaderboard leaderboard, Object obj)
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
        if (!zzw.equal(((Leaderboard) (obj)).getLeaderboardId(), leaderboard.getLeaderboardId()) || !zzw.equal(((Leaderboard) (obj)).getDisplayName(), leaderboard.getDisplayName()) || !zzw.equal(((Leaderboard) (obj)).getIconImageUri(), leaderboard.getIconImageUri()) || !zzw.equal(Integer.valueOf(((Leaderboard) (obj)).getScoreOrder()), Integer.valueOf(leaderboard.getScoreOrder())))
        {
            break; /* Loop/switch isn't completed */
        }
        flag = flag1;
        if (zzw.equal(((Leaderboard) (obj)).getVariants(), leaderboard.getVariants())) goto _L4; else goto _L5
_L5:
        return false;
    }

    static String zzb(Leaderboard leaderboard)
    {
        return zzw.zzv(leaderboard).zzg("LeaderboardId", leaderboard.getLeaderboardId()).zzg("DisplayName", leaderboard.getDisplayName()).zzg("IconImageUri", leaderboard.getIconImageUri()).zzg("IconImageUrl", leaderboard.getIconImageUrl()).zzg("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).zzg("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Object freeze()
    {
        return zzvG();
    }

    public String getDisplayName()
    {
        return zzTa;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        zzmo.zzb(zzTa, chararraybuffer);
    }

    public Game getGame()
    {
        return zzazW;
    }

    public Uri getIconImageUri()
    {
        return zzatu;
    }

    public String getIconImageUrl()
    {
        return zzatF;
    }

    public String getLeaderboardId()
    {
        return zzazT;
    }

    public int getScoreOrder()
    {
        return zzazU;
    }

    public ArrayList getVariants()
    {
        return new ArrayList(zzazV);
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

    public Leaderboard zzvG()
    {
        return this;
    }
}
