// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.games.leaderboard;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.internal.zzln;
import java.util.ArrayList;

// Referenced classes of package com.google.android.gms.games.leaderboard:
//            Leaderboard, LeaderboardVariant, LeaderboardVariantEntity

public final class LeaderboardEntity
    implements Leaderboard
{

    private final String zzahh;
    private final Uri zzaqW;
    private final String zzarh;
    private final String zzaxt;
    private final int zzaxu;
    private final ArrayList zzaxv;
    private final Game zzaxw;

    public LeaderboardEntity(Leaderboard leaderboard)
    {
        zzaxt = leaderboard.getLeaderboardId();
        zzahh = leaderboard.getDisplayName();
        zzaqW = leaderboard.getIconImageUri();
        zzarh = leaderboard.getIconImageUrl();
        zzaxu = leaderboard.getScoreOrder();
        Object obj = leaderboard.getGame();
        int j;
        if (obj == null)
        {
            obj = null;
        } else
        {
            obj = new GameEntity(((Game) (obj)));
        }
        zzaxw = ((Game) (obj));
        leaderboard = leaderboard.getVariants();
        j = leaderboard.size();
        zzaxv = new ArrayList(j);
        for (int i = 0; i < j; i++)
        {
            zzaxv.add((LeaderboardVariantEntity)(LeaderboardVariantEntity)((LeaderboardVariant)leaderboard.get(i)).freeze());
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
        return zzw.zzu(leaderboard).zzg("LeaderboardId", leaderboard.getLeaderboardId()).zzg("DisplayName", leaderboard.getDisplayName()).zzg("IconImageUri", leaderboard.getIconImageUri()).zzg("IconImageUrl", leaderboard.getIconImageUrl()).zzg("ScoreOrder", Integer.valueOf(leaderboard.getScoreOrder())).zzg("Variants", leaderboard.getVariants()).toString();
    }

    public boolean equals(Object obj)
    {
        return zza(this, obj);
    }

    public Object freeze()
    {
        return zzuQ();
    }

    public String getDisplayName()
    {
        return zzahh;
    }

    public void getDisplayName(CharArrayBuffer chararraybuffer)
    {
        zzln.zzb(zzahh, chararraybuffer);
    }

    public Game getGame()
    {
        return zzaxw;
    }

    public Uri getIconImageUri()
    {
        return zzaqW;
    }

    public String getIconImageUrl()
    {
        return zzarh;
    }

    public String getLeaderboardId()
    {
        return zzaxt;
    }

    public int getScoreOrder()
    {
        return zzaxu;
    }

    public ArrayList getVariants()
    {
        return new ArrayList(zzaxv);
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

    public Leaderboard zzuQ()
    {
        return this;
    }
}
