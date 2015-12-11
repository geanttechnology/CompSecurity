// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.network.a;

import com.crittercism.app.Crittercism;
import com.smule.android.network.core.b;
import com.smule.android.network.core.k;
import com.smule.android.network.core.l;
import com.smule.android.network.core.m;
import com.smule.android.network.core.n;
import com.smule.android.network.core.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.android.network.a:
//            i, h

public class g
{

    private static final String a = com/smule/android/network/a/g.getName();

    public g()
    {
    }

    private static k a(String s, boolean flag)
    {
        return new k(m.a, s, l.b, n.c, null, flag);
    }

    public static o a()
    {
        k k1 = a("/v2/game/get", true);
        k1.d = new HashMap();
        k1.d.put("app", com.smule.android.network.core.b.b());
        return com.smule.android.network.core.b.a().a(k1);
    }

    public static o a(int j, long l1, List list)
    {
        long l2;
label0:
        {
            if (l1 <= 0x30d40L)
            {
                l2 = l1;
                if (l1 >= 0L)
                {
                    break label0;
                }
            }
            Crittercism.a(new Exception((new StringBuilder()).append("GAMEAPI.setPlayerScores: invalid xp : ").append(l1).toString()));
            l2 = -2L;
        }
        k k1 = a("/v2/game/player/score/set", true);
        k1.d = new HashMap();
        k1.d.put("level", Integer.valueOf(j));
        k1.d.put("xp", Long.valueOf(l2));
        ArrayList arraylist = new ArrayList(list.size());
        HashMap hashmap;
        for (list = list.iterator(); list.hasNext(); arraylist.add(hashmap))
        {
            i i1 = (i)list.next();
            if (i1.b > 0x30d40 || i1.b < 0)
            {
                Crittercism.a(new Exception((new StringBuilder()).append("GAMEAPI.setPlayerScores: invalid score : ").append(i1.b).toString()));
                i1.b = -1;
            }
            hashmap = new HashMap();
            hashmap.put("songId", i1.a);
            hashmap.put("score", Integer.valueOf(i1.b));
            hashmap.put("progress", i1.c);
        }

        k1.d.put("playerScores", arraylist);
        return com.smule.android.network.core.b.a().a(k1);
    }

    public static o a(List list)
    {
        k k1 = a("/v2/game/player/achievement/set", true);
        k1.d = new HashMap();
        ArrayList arraylist = new ArrayList(list.size());
        HashMap hashmap;
        for (list = list.iterator(); list.hasNext(); arraylist.add(hashmap))
        {
            h h1 = (h)list.next();
            hashmap = new HashMap();
            hashmap.put("complete", Boolean.valueOf(h1.c));
            hashmap.put("claim", Boolean.valueOf(h1.d));
            hashmap.put("achievementId", h1.a);
            hashmap.put("progress", h1.b);
        }

        k1.d.put("playerAchievements", arraylist);
        return com.smule.android.network.core.b.a().a(k1);
    }

    public static o b()
    {
        k k1 = a("/v2/game/player/restore", true);
        return com.smule.android.network.core.b.a().a(k1);
    }

}
