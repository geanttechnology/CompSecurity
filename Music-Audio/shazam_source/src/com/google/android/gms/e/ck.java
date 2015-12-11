// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import com.google.android.gms.analytics.a.a;
import com.google.android.gms.analytics.a.b;
import com.google.android.gms.analytics.a.c;
import com.google.android.gms.analytics.h;
import com.google.android.gms.analytics.k;
import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.android.gms.e:
//            ch, cg, c, cj, 
//            aj

public final class ck extends ch
{

    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;
    private static final String g;
    private static final String h;
    private static final String i;
    private static final String j;
    private static final String k;
    private static final List l = Arrays.asList(new String[] {
        "detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund"
    });
    private static final Pattern m = Pattern.compile("dimension(\\d+)");
    private static final Pattern n = Pattern.compile("metric(\\d+)");
    private static Map o;
    private static Map p;
    private final Set q;
    private final cg r;
    private final com.google.android.gms.e.c s;

    public ck(Context context, com.google.android.gms.e.c c1)
    {
        this(c1, new cg(context));
    }

    private ck(com.google.android.gms.e.c c1, cg cg1)
    {
        super(b, new String[0]);
        s = c1;
        r = cg1;
        q = new HashSet();
        q.add("");
        q.add("0");
        q.add("false");
    }

    private static Double a(Object obj)
    {
        if (obj instanceof String)
        {
            try
            {
                obj = Double.valueOf((String)obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException((new StringBuilder("Cannot convert the object to Double: ")).append(((NumberFormatException) (obj)).getMessage()).toString());
            }
            return ((Double) (obj));
        }
        if (obj instanceof Integer)
        {
            return Double.valueOf(((Integer)obj).doubleValue());
        }
        if (obj instanceof Double)
        {
            return (Double)obj;
        } else
        {
            throw new RuntimeException((new StringBuilder("Cannot convert the object to Double: ")).append(obj.toString()).toString());
        }
    }

    private String a(String s1)
    {
        s1 = ((String) (s.a(s1)));
        if (s1 == null)
        {
            return null;
        } else
        {
            return s1.toString();
        }
    }

    private static Map a(com.google.android.gms.d.h.a a1)
    {
        a1 = ((com.google.android.gms.d.h.a) (com.google.android.gms.e.cj.e(a1)));
        if (!(a1 instanceof Map))
        {
            return null;
        }
        Object obj = (Map)a1;
        a1 = new LinkedHashMap();
        java.util.Map.Entry entry;
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); a1.put(entry.getKey().toString(), entry.getValue().toString()))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        return a1;
    }

    private void a(h h1, Map map)
    {
        String s1 = a("transactionId");
        if (s1 != null) goto _L2; else goto _L1
_L1:
        com.google.android.gms.e.aj.a("Cannot find transactionId in data layer.");
_L6:
        return;
_L2:
        Object obj;
        LinkedList linkedlist;
        Object obj1;
        linkedlist = new LinkedList();
        java.util.Map.Entry entry;
        try
        {
            obj1 = b((com.google.android.gms.d.h.a)map.get(h));
            ((Map) (obj1)).put("&t", "transaction");
            obj = (com.google.android.gms.d.h.a)map.get(j);
        }
        // Misplaced declaration of an exception variable
        catch (h h1)
        {
            com.google.android.gms.e.aj.a("Unable to send transaction", h1);
            return;
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        obj = a(((com.google.android.gms.d.h.a) (obj)));
_L3:
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); a(((Map) (obj1)), (String)entry.getValue(), a((String)entry.getKey())))
        {
            entry = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_248;
        if (o == null)
        {
            obj = new HashMap();
            ((HashMap) (obj)).put("transactionId", "&ti");
            ((HashMap) (obj)).put("transactionAffiliation", "&ta");
            ((HashMap) (obj)).put("transactionTax", "&tt");
            ((HashMap) (obj)).put("transactionShipping", "&ts");
            ((HashMap) (obj)).put("transactionTotal", "&tr");
            ((HashMap) (obj)).put("transactionCurrency", "&cu");
            o = ((Map) (obj));
        }
        obj = o;
          goto _L3
        linkedlist.add(obj1);
        obj = b("transactionProducts");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_558;
        }
        obj1 = ((List) (obj)).iterator();
_L5:
        Map map1;
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_558;
        }
        map1 = (Map)((Iterator) (obj1)).next();
        if (map1.get("name") == null)
        {
            com.google.android.gms.e.aj.a("Unable to send transaction item hit due to missing 'name' field.");
            return;
        }
        Map map2;
        map2 = b((com.google.android.gms.d.h.a)map.get(h));
        map2.put("&t", "item");
        map2.put("&ti", s1);
        obj = (com.google.android.gms.d.h.a)map.get(k);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_454;
        }
        obj = a(((com.google.android.gms.d.h.a) (obj)));
_L4:
        java.util.Map.Entry entry1;
        for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); a(map2, (String)entry1.getValue(), (String)map1.get(entry1.getKey())))
        {
            entry1 = (java.util.Map.Entry)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_545;
        if (p == null)
        {
            obj = new HashMap();
            ((HashMap) (obj)).put("name", "&in");
            ((HashMap) (obj)).put("sku", "&ic");
            ((HashMap) (obj)).put("category", "&iv");
            ((HashMap) (obj)).put("price", "&ip");
            ((HashMap) (obj)).put("quantity", "&iq");
            ((HashMap) (obj)).put("currency", "&cu");
            p = ((Map) (obj));
        }
        obj = p;
          goto _L4
        linkedlist.add(map2);
          goto _L5
        map = linkedlist.iterator();
        while (map.hasNext()) 
        {
            h1.a((Map)map.next());
        }
          goto _L6
    }

    private static void a(Map map, String s1, String s2)
    {
        if (s2 != null)
        {
            map.put(s1, s2);
        }
    }

    private static boolean a(Map map, String s1)
    {
        map = (com.google.android.gms.d.h.a)map.get(s1);
        if (map == null)
        {
            return false;
        } else
        {
            return cj.d(map).booleanValue();
        }
    }

    private static Integer b(Object obj)
    {
        if (obj instanceof String)
        {
            try
            {
                obj = Integer.valueOf((String)obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                throw new RuntimeException((new StringBuilder("Cannot convert the object to Integer: ")).append(((NumberFormatException) (obj)).getMessage()).toString());
            }
            return ((Integer) (obj));
        }
        if (obj instanceof Double)
        {
            return Integer.valueOf(((Double)obj).intValue());
        }
        if (obj instanceof Integer)
        {
            return (Integer)obj;
        } else
        {
            throw new RuntimeException((new StringBuilder("Cannot convert the object to Integer: ")).append(obj.toString()).toString());
        }
    }

    private List b(String s1)
    {
        s1 = ((String) (s.a(s1)));
        if (s1 == null)
        {
            return null;
        }
        if (!(s1 instanceof List))
        {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        for (Iterator iterator = ((List)s1).iterator(); iterator.hasNext();)
        {
            if (!(iterator.next() instanceof Map))
            {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }

        return (List)s1;
    }

    private Map b(com.google.android.gms.d.h.a a1)
    {
        if (a1 == null)
        {
            return new HashMap();
        }
        a1 = a(a1);
        if (a1 == null)
        {
            return new HashMap();
        }
        String s1 = (String)a1.get("&aip");
        if (s1 != null && q.contains(s1.toLowerCase()))
        {
            a1.remove("&aip");
        }
        return a1;
    }

    private static a c(Map map)
    {
        a a1;
        Object obj;
        a1 = new a();
        obj = map.get("id");
        if (obj != null)
        {
            a1.a("id", String.valueOf(obj));
        }
        obj = map.get("name");
        if (obj != null)
        {
            a1.a("nm", String.valueOf(obj));
        }
        obj = map.get("brand");
        if (obj != null)
        {
            a1.a("br", String.valueOf(obj));
        }
        obj = map.get("category");
        if (obj != null)
        {
            a1.a("ca", String.valueOf(obj));
        }
        obj = map.get("variant");
        if (obj != null)
        {
            a1.a("va", String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null)
        {
            a1.a("cc", String.valueOf(obj));
        }
        obj = map.get("position");
        if (obj != null)
        {
            a1.a("ps", Integer.toString(b(obj).intValue()));
        }
        obj = map.get("price");
        if (obj != null)
        {
            a1.a("pr", Double.toString(a(obj).doubleValue()));
        }
        obj = map.get("quantity");
        if (obj != null)
        {
            a1.a("qt", Integer.toString(b(obj).intValue()));
        }
        obj = map.keySet().iterator();
_L2:
        Object obj1;
        Matcher matcher;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (String)((Iterator) (obj)).next();
        matcher = m.matcher(((CharSequence) (obj1)));
        if (matcher.matches())
        {
            int i1;
            try
            {
                i1 = Integer.parseInt(matcher.group(1));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                com.google.android.gms.e.aj.a();
                continue; /* Loop/switch isn't completed */
            }
            obj1 = String.valueOf(map.get(obj1));
            a1.a(com.google.android.gms.analytics.k.a("cd", i1), ((String) (obj1)));
            continue; /* Loop/switch isn't completed */
        }
        matcher = n.matcher(((CharSequence) (obj1)));
        if (!matcher.matches())
        {
            continue; /* Loop/switch isn't completed */
        }
        int j1 = Integer.parseInt(matcher.group(1));
        int k1 = b(map.get(obj1)).intValue();
        a1.a(com.google.android.gms.analytics.k.a("cm", j1), Integer.toString(k1));
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception;
        numberformatexception;
        com.google.android.gms.e.aj.a();
        if (true) goto _L2; else goto _L1
_L1:
        return a1;
    }

    public final volatile com.google.android.gms.d.h.a a(Map map)
    {
        return super.a(map);
    }

    public final volatile boolean a()
    {
        return super.a();
    }

    public final volatile String b()
    {
        return super.b();
    }

    public final void b(Map map)
    {
        Object obj = r;
        ((cg) (obj)).a("_GTM_DEFAULT_TRACKER_");
        h h1 = ((cg) (obj)).a;
        h1.a = a(map, "collect_adid");
        if (!a(map, e))
        {
            break MISSING_BLOCK_LABEL_1184;
        }
        com.google.android.gms.analytics.f.b b1 = new com.google.android.gms.analytics.f.b();
        obj = b((com.google.android.gms.d.h.a)map.get(h));
        if (obj != null)
        {
            ((com.google.android.gms.analytics.f.a) (b1)).a.putAll(new HashMap(((Map) (obj))));
        }
        if (a(map, f))
        {
            map = ((Map) (s.a("ecommerce")));
            RuntimeException runtimeexception;
            Object obj1;
            RuntimeException runtimeexception1;
            Object obj2;
            RuntimeException runtimeexception2;
            Object obj3;
            boolean flag;
            if (map instanceof Map)
            {
                map = (Map)map;
            } else
            {
                map = null;
            }
        } else
        {
            map = ((Map) (com.google.android.gms.e.cj.e((com.google.android.gms.d.h.a)map.get(g))));
            if (map instanceof Map)
            {
                map = (Map)map;
            } else
            {
                map = null;
            }
        }
        if (map == null) goto _L2; else goto _L1
_L1:
        obj1 = (String)((Map) (obj)).get("&cu");
        obj = obj1;
        if (obj1 == null)
        {
            obj = (String)map.get("currencyCode");
        }
        if (obj != null)
        {
            b1.a("&cu", ((String) (obj)));
        }
        obj = map.get("impressions");
        if (!(obj instanceof List)) goto _L4; else goto _L3
_L3:
        obj2 = ((List)obj).iterator();
_L5:
        if (!((Iterator) (obj2)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Map)((Iterator) (obj2)).next();
        obj3 = c(((Map) (obj)));
        obj1 = (String)((Map) (obj)).get("list");
        obj = obj1;
        if (obj1 == null)
        {
            obj = "";
        }
        try
        {
            if (!((com.google.android.gms.analytics.f.a) (b1)).c.containsKey(obj))
            {
                ((com.google.android.gms.analytics.f.a) (b1)).c.put(obj, new ArrayList());
            }
            ((List)((com.google.android.gms.analytics.f.a) (b1)).c.get(obj)).add(obj3);
        }
        // Misplaced declaration of an exception variable
        catch (RuntimeException runtimeexception)
        {
            com.google.android.gms.e.aj.a((new StringBuilder("Failed to extract a product from DataLayer. ")).append(runtimeexception.getMessage()).toString());
        }
        if (true) goto _L5; else goto _L4
_L4:
        if (map.containsKey("promoClick"))
        {
            runtimeexception = (List)((Map)map.get("promoClick")).get("promotions");
        } else
        if (map.containsKey("promoView"))
        {
            runtimeexception = (List)((Map)map.get("promoView")).get("promotions");
        } else
        {
            runtimeexception = null;
        }
        if (runtimeexception == null) goto _L7; else goto _L6
_L6:
        runtimeexception = runtimeexception.iterator();
_L9:
        if (!runtimeexception.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj2 = (Map)runtimeexception.next();
        obj1 = new c();
        obj3 = (String)((Map) (obj2)).get("id");
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_471;
        }
        ((c) (obj1)).a("id", String.valueOf(obj3));
        obj3 = (String)((Map) (obj2)).get("name");
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_503;
        }
        ((c) (obj1)).a("nm", String.valueOf(obj3));
        obj3 = (String)((Map) (obj2)).get("creative");
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_535;
        }
        ((c) (obj1)).a("cr", String.valueOf(obj3));
        obj2 = (String)((Map) (obj2)).get("position");
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_567;
        }
        ((c) (obj1)).a("ps", String.valueOf(obj2));
        ((com.google.android.gms.analytics.f.a) (b1)).d.add(obj1);
        continue; /* Loop/switch isn't completed */
        runtimeexception1;
        com.google.android.gms.e.aj.a((new StringBuilder("Failed to extract a promotion from DataLayer. ")).append(runtimeexception1.getMessage()).toString());
        if (true) goto _L9; else goto _L8
_L8:
        if (!map.containsKey("promoClick")) goto _L11; else goto _L10
_L10:
        b1.a("&promoa", "click");
        flag = false;
_L17:
        if (!flag) goto _L2; else goto _L12
_L12:
        runtimeexception = l.iterator();
_L15:
        if (!runtimeexception.hasNext()) goto _L2; else goto _L13
_L13:
        runtimeexception1 = (String)runtimeexception.next();
        if (!map.containsKey(runtimeexception1)) goto _L15; else goto _L14
_L14:
        map = (Map)map.get(runtimeexception1);
        runtimeexception = (List)map.get("products");
        if (runtimeexception != null)
        {
            for (runtimeexception = runtimeexception.iterator(); runtimeexception.hasNext();)
            {
                obj2 = (Map)runtimeexception.next();
                try
                {
                    obj2 = c(((Map) (obj2)));
                    ((com.google.android.gms.analytics.f.a) (b1)).e.add(obj2);
                }
                // Misplaced declaration of an exception variable
                catch (RuntimeException runtimeexception2)
                {
                    com.google.android.gms.e.aj.a((new StringBuilder("Failed to extract a product from DataLayer. ")).append(runtimeexception2.getMessage()).toString());
                }
            }

        }
          goto _L16
_L11:
        b1.a("&promoa", "view");
_L7:
        flag = true;
          goto _L17
_L16:
        if (!map.containsKey("actionField"))
        {
            break MISSING_BLOCK_LABEL_1145;
        }
        runtimeexception = (Map)map.get("actionField");
        map = new b(runtimeexception1);
        runtimeexception1 = ((RuntimeException) (runtimeexception.get("id")));
        if (runtimeexception1 == null)
        {
            break MISSING_BLOCK_LABEL_901;
        }
        map.a("&ti", String.valueOf(runtimeexception1));
        runtimeexception1 = ((RuntimeException) (runtimeexception.get("affiliation")));
        if (runtimeexception1 == null)
        {
            break MISSING_BLOCK_LABEL_926;
        }
        map.a("&ta", String.valueOf(runtimeexception1));
        runtimeexception1 = ((RuntimeException) (runtimeexception.get("coupon")));
        if (runtimeexception1 == null)
        {
            break MISSING_BLOCK_LABEL_951;
        }
        map.a("&tcc", String.valueOf(runtimeexception1));
        runtimeexception1 = ((RuntimeException) (runtimeexception.get("list")));
        if (runtimeexception1 == null)
        {
            break MISSING_BLOCK_LABEL_976;
        }
        map.a("&pal", String.valueOf(runtimeexception1));
        runtimeexception1 = ((RuntimeException) (runtimeexception.get("option")));
        if (runtimeexception1 == null)
        {
            break MISSING_BLOCK_LABEL_1001;
        }
        map.a("&col", String.valueOf(runtimeexception1));
        runtimeexception1 = ((RuntimeException) (runtimeexception.get("revenue")));
        if (runtimeexception1 == null)
        {
            break MISSING_BLOCK_LABEL_1032;
        }
        map.a("&tr", Double.toString(a(runtimeexception1).doubleValue()));
        runtimeexception1 = ((RuntimeException) (runtimeexception.get("tax")));
        if (runtimeexception1 == null)
        {
            break MISSING_BLOCK_LABEL_1063;
        }
        map.a("&tt", Double.toString(a(runtimeexception1).doubleValue()));
        runtimeexception1 = ((RuntimeException) (runtimeexception.get("shipping")));
        if (runtimeexception1 == null)
        {
            break MISSING_BLOCK_LABEL_1094;
        }
        map.a("&ts", Double.toString(a(runtimeexception1).doubleValue()));
        runtimeexception = ((RuntimeException) (runtimeexception.get("step")));
        if (runtimeexception == null)
        {
            break MISSING_BLOCK_LABEL_1128;
        }
        map.a("&cos", Integer.toString(b(runtimeexception).intValue()));
_L18:
        try
        {
            b1.b = map;
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            com.google.android.gms.e.aj.a((new StringBuilder("Failed to extract a product action from DataLayer. ")).append(map.getMessage()).toString());
        }
_L2:
        h1.a(b1.a());
        return;
        map = new b(runtimeexception1);
          goto _L18
        if (a(map, d))
        {
            h1.a(b((com.google.android.gms.d.h.a)map.get(h)));
            return;
        }
        if (a(map, i))
        {
            a(h1, map);
            return;
        } else
        {
            com.google.android.gms.e.aj.a();
            return;
        }
    }

    public final volatile Set c()
    {
        return super.c();
    }

    static 
    {
        b = e.az.toString();
        c = f.b.toString();
        d = f.l.toString();
        e = f.aG.toString();
        f = f.aA.toString();
        g = f.az.toString();
        h = f.k.toString();
        i = f.dd.toString();
        j = f.dg.toString();
        k = f.di.toString();
    }
}
