// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.a;

import com.fasterxml.jackson.databind.JsonNode;
import com.smule.android.network.managers.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.smule.pianoandroid.magicpiano.a:
//            l, k, m

public class j
{

    static final String a = com/smule/pianoandroid/magicpiano/a/j.getName();
    private static j h = null;
    private static String i = "{\"xpconfig\":{\"correct_notes_multiplier\":\"0.0167\",\"song_length_multiplier\":\"0.025\",\"difficulty_multipliers\":{\"easy\":\"1.0\",\"medium\":\"2.0\",\"hard\":\"3.0\",\"recital\":\"4.0\"},\"streaks\":[{\"threshold\":\"25\",\"multiplier\":\"1.2\"},{\"threshold\":\"50\",\"multiplier\":\"1.4\"},{\"threshold\":\"100\",\"multiplier\":\"1.8\"},{\"threshold\":\"200\",\"multiplier\":\"2.0\"},{\"threshold\":\"400\",\"multiplier\":\"2.1\"}],\"star_values\":{\"easy\":{\"xp\":\"10\",\"threshold\":[\"0.15\",\"0.5\",\"0.85\"]},\"medium\":{\"xp\":\"20\",\"threshold\":[\"0.25\",\"0.6\",\"0.9\"]},\"hard\":{\"xp\":\"30\",\"threshold\":[\"0.35\",\"0.7\",\"0.95\"]},\"recital\":{\"xp\":\"0\",\"threshold\":[\"0.8\",\"0.9\",\"0.98\"]}}}}";
    private Map b;
    private Map c;
    private Map d;
    private List e;
    private double f;
    private double g;

    private j()
    {
        Object obj = com.smule.android.network.managers.a.a();
        ((a) (obj)).a("piandroid.xp", i);
        obj = ((a) (obj)).a("piandroid.xp", "xpconfig", null);
        f = ((JsonNode) (obj)).get("correct_notes_multiplier").asDouble(0.012500000000000001D);
        g = ((JsonNode) (obj)).get("song_length_multiplier").asDouble(0.025000000000000001D);
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (Iterator iterator = ((JsonNode) (obj)).get("difficulty_multipliers").fields(); iterator.hasNext(); hashmap.put(entry.getKey(), Double.valueOf(((JsonNode)entry.getValue()).asDouble())))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        HashMap hashmap1 = new HashMap();
        java.util.Map.Entry entry1;
        l l1;
        for (Iterator iterator1 = ((JsonNode) (obj)).get("star_values").fields(); iterator1.hasNext(); hashmap1.put(entry1.getKey(), l1))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
            Object obj2 = (JsonNode)entry1.getValue();
            l1 = new l();
            l1.a(((JsonNode) (obj2)).get("xp").asLong());
            ArrayList arraylist = new ArrayList();
            for (obj2 = ((JsonNode) (obj2)).get("threshold").elements(); ((Iterator) (obj2)).hasNext(); arraylist.add(Double.valueOf(((JsonNode)((Iterator) (obj2)).next()).asDouble()))) { }
            l1.a(arraylist);
        }

        b = new HashMap(4);
        c = new HashMap(4);
        d = new HashMap(4);
        k ak[] = k.values();
        int j1 = ak.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            k k1 = ak[i1];
            Object obj1 = (Double)hashmap.get(k1.name().toLowerCase());
            if (obj1 != null)
            {
                b.put(k1, obj1);
            }
            c.put(k1, Long.valueOf(10L));
            d.put(k1, Arrays.asList(new Double[] {
                Double.valueOf(0.14999999999999999D), Double.valueOf(0.80000000000000004D), Double.valueOf(0.94999999999999996D)
            }));
            obj1 = (l)hashmap1.get(k1.name().toLowerCase());
            if (obj1 != null)
            {
                c.put(k1, Long.valueOf(((l) (obj1)).a()));
                d.put(k1, ((l) (obj1)).b());
            }
        }

        e = new ArrayList();
        m m1;
        for (obj = ((JsonNode) (obj)).get("streaks").elements(); ((Iterator) (obj)).hasNext(); e.add(m1))
        {
            JsonNode jsonnode = (JsonNode)((Iterator) (obj)).next();
            m1 = new m();
            m1.a(jsonnode.get("multiplier").asDouble());
            m1.a(jsonnode.get("threshold").asInt());
        }

    }

    public static j a()
    {
        com/smule/pianoandroid/magicpiano/a/j;
        JVM INSTR monitorenter ;
        j j1;
        if (h == null)
        {
            h = new j();
        }
        j1 = h;
        com/smule/pianoandroid/magicpiano/a/j;
        JVM INSTR monitorexit ;
        return j1;
        Exception exception;
        exception;
        throw exception;
    }

    public double a(int i1)
    {
        Iterator iterator = e.iterator();
        int j1 = 0;
        double d1 = 1.0D;
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            m m1 = (m)iterator.next();
            if (i1 >= m1.a() && m1.a() >= j1)
            {
                j1 = m1.a();
                d1 = m1.b();
            }
        } while (true);
        return d1;
    }

    public double a(int i1, k k1)
    {
        k1 = (List)d.get(k1);
        if (i1 > k1.size())
        {
            return (double)i1 * 0.33000000000000002D;
        } else
        {
            return Math.min(((Double)k1.get(i1 - 1)).doubleValue(), 1.0D);
        }
    }

    public double a(k k1)
    {
        k1 = (Double)b.get(k1);
        if (k1 != null)
        {
            return k1.doubleValue();
        } else
        {
            return 1.0D;
        }
    }

    public double b()
    {
        return f;
    }

    public long b(k k1)
    {
        k1 = (Long)c.get(k1);
        if (k1 != null)
        {
            return k1.longValue();
        } else
        {
            return 10L;
        }
    }

    public double c()
    {
        return g;
    }

}
