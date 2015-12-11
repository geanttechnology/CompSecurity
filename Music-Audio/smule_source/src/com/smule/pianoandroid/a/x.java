// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smule.android.f.e;
import com.smule.android.f.h;
import com.smule.android.network.core.o;
import com.smule.pianoandroid.data.model.GameReward;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.smule.pianoandroid.a:
//            y

public class x
{

    public static String a = "game.data.level-rewards-refresh";
    public static String b = "game.data.achv-rewards-refresh";
    public static String c = "game.balance.refresh";
    public static String d = "game.product.reward";
    private static y e;
    private static y f;
    private static Map g = new TreeMap();
    private static Map h = new HashMap();

    public static y a()
    {
        return e;
    }

    private static List a(JsonNode jsonnode)
    {
        Object obj = jsonnode.get("rewards");
        jsonnode = new ArrayList();
        for (obj = ((JsonNode) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            JsonNode jsonnode1 = (JsonNode)((Iterator) (obj)).next();
            try
            {
                jsonnode.add(com.smule.android.f.e.a().treeToValue(jsonnode1, com/smule/pianoandroid/data/model/GameReward));
            }
            catch (IOException ioexception)
            {
                ioexception.printStackTrace();
            }
        }

        a(((List) (jsonnode)));
        return jsonnode;
    }

    public static void a(int i)
    {
        g.remove(Integer.valueOf(i));
    }

    public static void a(o o1)
    {
        if (o1 != null && o1.a())
        {
            e = y.c;
            c(o1);
        } else
        {
            e = y.d;
        }
        com.smule.android.f.h.a().a(a, new Object[0]);
    }

    public static void a(String s)
    {
        h.remove(s);
    }

    private static void a(List list)
    {
        list = list.iterator();
        boolean flag = false;
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            GameReward gamereward = (GameReward)list.next();
            com.smule.pianoandroid.data.model.GameReward.Type type = gamereward.getRewardType();
            if (type == com.smule.pianoandroid.data.model.GameReward.Type.COINS)
            {
                flag = true;
            } else
            if (type == com.smule.pianoandroid.data.model.GameReward.Type.PRODUCT)
            {
                com.smule.android.f.h.a().a(d, gamereward.value);
            }
        } while (true);
        if (flag)
        {
            com.smule.android.f.h.a().a(c, new Object[0]);
        }
    }

    public static y b()
    {
        return f;
    }

    public static List b(int i)
    {
        return (List)g.get(Integer.valueOf(i));
    }

    public static List b(String s)
    {
        return (List)h.get(s);
    }

    public static void b(o o1)
    {
        if (o1 != null && o1.a())
        {
            f = y.c;
            d(o1);
        } else
        {
            f = y.d;
        }
        com.smule.android.f.h.a().a(b, new Object[0]);
    }

    public static void c()
    {
        e = y.b;
    }

    private static void c(o o1)
    {
        JsonNode jsonnode;
        int i;
        for (o1 = o1.b().get("levelRewards").iterator(); o1.hasNext(); g.put(Integer.valueOf(i), a(jsonnode)))
        {
            jsonnode = (JsonNode)o1.next();
            i = jsonnode.get("level").asInt();
        }

    }

    public static void d()
    {
        f = y.b;
    }

    private static void d(o o1)
    {
        JsonNode jsonnode;
        String s;
        for (o1 = o1.b().get("achievementRewards").iterator(); o1.hasNext(); h.put(s, a(jsonnode)))
        {
            jsonnode = (JsonNode)o1.next();
            s = jsonnode.get("achievementId").asText();
        }

    }

    static 
    {
        e = y.a;
        f = y.a;
    }
}
