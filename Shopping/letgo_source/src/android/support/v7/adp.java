// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
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

// Referenced classes of package android.support.v7:
//            adm, ls, lt, adl, 
//            lc, aah, ado, abo, 
//            la, ld, lb

public class adp extends adm
{

    private static final String a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;
    private static final String g;
    private static final String h;
    private static final String i;
    private static final String j;
    private static final List k = Arrays.asList(new String[] {
        "detail", "checkout", "checkout_option", "click", "add", "remove", "purchase", "refund"
    });
    private static final Pattern l = Pattern.compile("dimension(\\d+)");
    private static final Pattern m = Pattern.compile("metric(\\d+)");
    private static Map n;
    private static Map o;
    private final Set p;
    private final adl q;
    private final aah r;

    public adp(Context context, aah aah1)
    {
        this(context, aah1, new adl(context));
    }

    adp(Context context, aah aah1, adl adl1)
    {
        super(a, new String[0]);
        r = aah1;
        q = adl1;
        p = new HashSet();
        p.add("");
        p.add("0");
        p.add("false");
    }

    private lc a(String s, Map map)
    {
        s = new lc(s);
        Object obj = map.get("id");
        if (obj != null)
        {
            s.a(String.valueOf(obj));
        }
        obj = map.get("affiliation");
        if (obj != null)
        {
            s.b(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null)
        {
            s.c(String.valueOf(obj));
        }
        obj = map.get("list");
        if (obj != null)
        {
            s.e(String.valueOf(obj));
        }
        obj = map.get("option");
        if (obj != null)
        {
            s.d(String.valueOf(obj));
        }
        obj = map.get("revenue");
        if (obj != null)
        {
            s.a(a(obj).doubleValue());
        }
        obj = map.get("tax");
        if (obj != null)
        {
            s.b(a(obj).doubleValue());
        }
        obj = map.get("shipping");
        if (obj != null)
        {
            s.c(a(obj).doubleValue());
        }
        map = ((Map) (map.get("step")));
        if (map != null)
        {
            s.a(b(map).intValue());
        }
        return s;
    }

    private Double a(Object obj)
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
                throw new RuntimeException((new StringBuilder()).append("Cannot convert the object to Double: ").append(((NumberFormatException) (obj)).getMessage()).toString());
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
            throw new RuntimeException((new StringBuilder()).append("Cannot convert the object to Double: ").append(obj.toString()).toString());
        }
    }

    private String a(String s)
    {
        s = ((String) (r.c(s)));
        if (s == null)
        {
            return null;
        } else
        {
            return s.toString();
        }
    }

    private Map a(lv.a a1)
    {
        a1 = ((lv.a) (ado.e(a1)));
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

    private void a(la la1, Map map)
    {
        String s = a("transactionId");
        if (s != null) goto _L2; else goto _L1
_L1:
        abo.a("Cannot find transactionId in data layer.");
_L4:
        return;
_L2:
        LinkedList linkedlist;
        Object obj;
        linkedlist = new LinkedList();
        try
        {
            obj = b((lv.a)map.get(g));
            ((Map) (obj)).put("&t", "transaction");
            java.util.Map.Entry entry;
            for (Iterator iterator = e(map).entrySet().iterator(); iterator.hasNext(); a(((Map) (obj)), (String)entry.getValue(), a((String)entry.getKey())))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        // Misplaced declaration of an exception variable
        catch (la la1)
        {
            abo.a("Unable to send transaction", la1);
            return;
        }
        linkedlist.add(obj);
        obj = b("transactionProducts");
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_348;
        }
        obj = ((List) (obj)).iterator();
_L3:
        Map map1;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_348;
        }
        map1 = (Map)((Iterator) (obj)).next();
        if (map1.get("name") == null)
        {
            abo.a("Unable to send transaction item hit due to missing 'name' field.");
            return;
        }
        Map map2;
        map2 = b((lv.a)map.get(g));
        map2.put("&t", "item");
        map2.put("&ti", s);
        java.util.Map.Entry entry1;
        for (Iterator iterator1 = f(map).entrySet().iterator(); iterator1.hasNext(); a(map2, (String)entry1.getValue(), (String)map1.get(entry1.getKey())))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

        linkedlist.add(map2);
          goto _L3
        map = linkedlist.iterator();
        while (map.hasNext()) 
        {
            la1.a((Map)map.next());
        }
          goto _L4
    }

    private void a(Map map, String s, String s1)
    {
        if (s1 != null)
        {
            map.put(s, s1);
        }
    }

    private boolean a(Map map, String s)
    {
        map = (lv.a)map.get(s);
        if (map == null)
        {
            return false;
        } else
        {
            return ado.d(map).booleanValue();
        }
    }

    private Integer b(Object obj)
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
                throw new RuntimeException((new StringBuilder()).append("Cannot convert the object to Integer: ").append(((NumberFormatException) (obj)).getMessage()).toString());
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
            throw new RuntimeException((new StringBuilder()).append("Cannot convert the object to Integer: ").append(obj.toString()).toString());
        }
    }

    private List b(String s)
    {
        s = ((String) (r.c(s)));
        if (s == null)
        {
            return null;
        }
        if (!(s instanceof List))
        {
            throw new IllegalArgumentException("transactionProducts should be of type List.");
        }
        for (Iterator iterator = ((List)s).iterator(); iterator.hasNext();)
        {
            if (!(iterator.next() instanceof Map))
            {
                throw new IllegalArgumentException("Each element of transactionProducts should be of type Map.");
            }
        }

        return (List)s;
    }

    private Map b(lv.a a1)
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
        String s = (String)a1.get("&aip");
        if (s != null && p.contains(s.toLowerCase()))
        {
            a1.remove("&aip");
        }
        return a1;
    }

    private void b(la la1, Map map)
    {
        ky.b b1 = new ky.b();
        Object obj = b((lv.a)map.get(g));
        b1.a(((Map) (obj)));
        if (a(map, e))
        {
            map = ((Map) (r.c("ecommerce")));
            Object obj1;
            RuntimeException runtimeexception;
            Map map1;
            RuntimeException runtimeexception1;
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
            map = ((Map) (ado.e((lv.a)map.get(f))));
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
        if (obj instanceof List)
        {
            for (obj = ((List)obj).iterator(); ((Iterator) (obj)).hasNext();)
            {
                obj1 = (Map)((Iterator) (obj)).next();
                try
                {
                    b1.a(d(((Map) (obj1))), (String)((Map) (obj1)).get("list"));
                }
                // Misplaced declaration of an exception variable
                catch (RuntimeException runtimeexception)
                {
                    abo.a((new StringBuilder()).append("Failed to extract a product from DataLayer. ").append(runtimeexception.getMessage()).toString());
                }
            }

        }
        if (map.containsKey("promoClick"))
        {
            obj = (List)((Map)map.get("promoClick")).get("promotions");
        } else
        if (map.containsKey("promoView"))
        {
            obj = (List)((Map)map.get("promoView")).get("promotions");
        } else
        {
            obj = null;
        }
        if (obj == null) goto _L4; else goto _L3
_L3:
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            runtimeexception = (Map)((Iterator) (obj)).next();
            try
            {
                b1.a(c(runtimeexception));
            }
            // Misplaced declaration of an exception variable
            catch (RuntimeException runtimeexception)
            {
                abo.a((new StringBuilder()).append("Failed to extract a promotion from DataLayer. ").append(runtimeexception.getMessage()).toString());
            }
        }

        if (!map.containsKey("promoClick")) goto _L6; else goto _L5
_L5:
        b1.a("&promoa", "click");
        flag = false;
_L12:
        if (!flag) goto _L2; else goto _L7
_L7:
        runtimeexception = k.iterator();
_L10:
        if (!runtimeexception.hasNext()) goto _L2; else goto _L8
_L8:
        obj = (String)runtimeexception.next();
        if (!map.containsKey(obj)) goto _L10; else goto _L9
_L9:
        map = (Map)map.get(obj);
        runtimeexception = (List)map.get("products");
        if (runtimeexception != null)
        {
            for (runtimeexception = runtimeexception.iterator(); runtimeexception.hasNext();)
            {
                map1 = (Map)runtimeexception.next();
                try
                {
                    b1.a(d(map1));
                }
                // Misplaced declaration of an exception variable
                catch (RuntimeException runtimeexception1)
                {
                    abo.a((new StringBuilder()).append("Failed to extract a product from DataLayer. ").append(runtimeexception1.getMessage()).toString());
                }
            }

        }
          goto _L11
_L6:
        b1.a("&promoa", "view");
_L4:
        flag = true;
          goto _L12
_L11:
        if (!map.containsKey("actionField")) goto _L14; else goto _L13
_L13:
        map = a(((String) (obj)), (Map)map.get("actionField"));
_L15:
        b1.a(map);
_L2:
        la1.a(b1.a());
        return;
_L14:
        map = new lc(((String) (obj)));
          goto _L15
        map;
        abo.a((new StringBuilder()).append("Failed to extract a product action from DataLayer. ").append(map.getMessage()).toString());
          goto _L2
    }

    private ld c(Map map)
    {
        ld ld1 = new ld();
        String s = (String)map.get("id");
        if (s != null)
        {
            ld1.a(String.valueOf(s));
        }
        s = (String)map.get("name");
        if (s != null)
        {
            ld1.b(String.valueOf(s));
        }
        s = (String)map.get("creative");
        if (s != null)
        {
            ld1.c(String.valueOf(s));
        }
        map = (String)map.get("position");
        if (map != null)
        {
            ld1.d(String.valueOf(map));
        }
        return ld1;
    }

    private lb d(Map map)
    {
        lb lb1;
        Object obj;
        lb1 = new lb();
        obj = map.get("id");
        if (obj != null)
        {
            lb1.a(String.valueOf(obj));
        }
        obj = map.get("name");
        if (obj != null)
        {
            lb1.b(String.valueOf(obj));
        }
        obj = map.get("brand");
        if (obj != null)
        {
            lb1.c(String.valueOf(obj));
        }
        obj = map.get("category");
        if (obj != null)
        {
            lb1.d(String.valueOf(obj));
        }
        obj = map.get("variant");
        if (obj != null)
        {
            lb1.e(String.valueOf(obj));
        }
        obj = map.get("coupon");
        if (obj != null)
        {
            lb1.f(String.valueOf(obj));
        }
        obj = map.get("position");
        if (obj != null)
        {
            lb1.a(b(obj).intValue());
        }
        obj = map.get("price");
        if (obj != null)
        {
            lb1.a(a(obj).doubleValue());
        }
        obj = map.get("quantity");
        if (obj != null)
        {
            lb1.b(b(obj).intValue());
        }
        obj = map.keySet().iterator();
_L2:
        String s;
        Matcher matcher;
        if (!((Iterator) (obj)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        s = (String)((Iterator) (obj)).next();
        matcher = l.matcher(s);
        if (matcher.matches())
        {
            int i1;
            try
            {
                i1 = Integer.parseInt(matcher.group(1));
            }
            catch (NumberFormatException numberformatexception)
            {
                abo.b((new StringBuilder()).append("illegal number in custom dimension value: ").append(s).toString());
                continue; /* Loop/switch isn't completed */
            }
            lb1.a(i1, String.valueOf(map.get(s)));
            continue; /* Loop/switch isn't completed */
        }
        numberformatexception = m.matcher(s);
        if (!numberformatexception.matches())
        {
            continue; /* Loop/switch isn't completed */
        }
        int j1 = Integer.parseInt(numberformatexception.group(1));
        lb1.a(j1, b(map.get(s)).intValue());
        continue; /* Loop/switch isn't completed */
        NumberFormatException numberformatexception1;
        numberformatexception1;
        abo.b((new StringBuilder()).append("illegal number in custom metric value: ").append(s).toString());
        if (true) goto _L2; else goto _L1
_L1:
        return lb1;
    }

    private Map e(Map map)
    {
        map = (lv.a)map.get(i);
        if (map != null)
        {
            return a(map);
        }
        if (n == null)
        {
            map = new HashMap();
            map.put("transactionId", "&ti");
            map.put("transactionAffiliation", "&ta");
            map.put("transactionTax", "&tt");
            map.put("transactionShipping", "&ts");
            map.put("transactionTotal", "&tr");
            map.put("transactionCurrency", "&cu");
            n = map;
        }
        return n;
    }

    private Map f(Map map)
    {
        map = (lv.a)map.get(j);
        if (map != null)
        {
            return a(map);
        }
        if (o == null)
        {
            map = new HashMap();
            map.put("name", "&in");
            map.put("sku", "&ic");
            map.put("category", "&iv");
            map.put("price", "&ip");
            map.put("quantity", "&iq");
            map.put("currency", "&cu");
            o = map;
        }
        return o;
    }

    public volatile lv.a a(Map map)
    {
        return super.a(map);
    }

    public volatile boolean a()
    {
        return super.a();
    }

    public volatile String b()
    {
        return super.b();
    }

    public void b(Map map)
    {
        la la1 = q.a("_GTM_DEFAULT_TRACKER_");
        la1.a(a(map, "collect_adid"));
        if (a(map, d))
        {
            b(la1, map);
            return;
        }
        if (a(map, c))
        {
            la1.a(b((lv.a)map.get(g)));
            return;
        }
        if (a(map, h))
        {
            a(la1, map);
            return;
        } else
        {
            abo.b("Ignoring unknown tag.");
            return;
        }
    }

    public volatile Set c()
    {
        return super.c();
    }

    static 
    {
        a = ls.az.toString();
        b = lt.b.toString();
        c = lt.l.toString();
        d = lt.aG.toString();
        e = lt.aA.toString();
        f = lt.az.toString();
        g = lt.k.toString();
        h = lt.dd.toString();
        i = lt.dg.toString();
        j = lt.di.toString();
    }
}
