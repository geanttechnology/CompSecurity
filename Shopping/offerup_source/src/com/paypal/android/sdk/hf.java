// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.paypal.android.sdk:
//            ig

public class hf
{

    private static final Map a;
    private static final Set b;
    private static boolean f;
    private Map c;
    private ig d;
    private Class e;

    public hf(Class class1, List list)
    {
        c = new LinkedHashMap();
        e = class1;
        String s;
        for (class1 = list.iterator(); class1.hasNext(); b(s))
        {
            list = (ig)class1.next();
            s = list.a();
            if (c.containsKey(s))
            {
                throw new RuntimeException((new StringBuilder("Locale ")).append(s).append(" already added").toString());
            }
            c.put(s, list);
        }

        a(((String) (null)));
    }

    private void b(String s)
    {
        ig ig1 = (ig)c.get(s);
        ArrayList arraylist = new ArrayList();
        Enum aenum[] = (Enum[])e.getEnumConstants();
        int j = aenum.length;
        for (int i = 0; i < j; i++)
        {
            Enum enum = aenum[i];
            String s1 = (new StringBuilder("[")).append(s).append(",").append(enum).append("]").toString();
            if (ig1.a(enum, null) == null)
            {
                arraylist.add((new StringBuilder("Missing ")).append(s1).toString());
            }
        }

        for (s = arraylist.iterator(); s.hasNext(); s.next()) { }
    }

    private ig c(String s)
    {
        Object obj3 = null;
        Object obj1 = null;
        Object obj = obj1;
        if (s != null)
        {
            if (s.length() < 2)
            {
                obj = obj1;
            } else
            {
                ig ig1 = obj3;
                if (a.containsKey(s))
                {
                    obj = (String)a.get(s);
                    ig1 = (ig)c.get(obj);
                    (new StringBuilder("Overriding locale specifier ")).append(s).append(" with ").append(((String) (obj)));
                }
                obj = ig1;
                if (ig1 == null)
                {
                    Object obj2;
                    if (s.contains("_"))
                    {
                        obj = s;
                    } else
                    {
                        obj = (new StringBuilder()).append(s).append("_").append(Locale.getDefault().getCountry()).toString();
                    }
                    obj = (ig)c.get(obj);
                }
                obj2 = obj;
                if (obj == null)
                {
                    obj2 = (ig)c.get(s);
                }
                obj = obj2;
                if (obj2 == null)
                {
                    s = s.substring(0, 2);
                    return (ig)c.get(s);
                }
            }
        }
        return ((ig) (obj));
    }

    public final String a()
    {
        return d.a();
    }

    public final String a(Enum enum)
    {
        Object obj = d;
        String s1 = Locale.getDefault().getCountry().toUpperCase(Locale.US);
        String s = ((ig) (obj)).a(enum, s1);
        obj = s;
        if (s == null)
        {
            (new StringBuilder("Missing localized string for [")).append(d.a()).append(",Key.").append(enum.toString()).append("]");
            obj = ((ig)c.get("en")).a(enum, s1);
        }
        s = ((String) (obj));
        if (obj == null)
        {
            (new StringBuilder("Missing localized string for [en,Key.")).append(enum.toString()).append("], so defaulting to keyname");
            s = enum.toString();
        }
        return s;
    }

    public final String a(String s, Enum enum)
    {
        String s1 = d.a(s);
        if (s1 != null)
        {
            return s1;
        } else
        {
            return String.format(a(enum), new Object[] {
                s
            });
        }
    }

    public final void a(String s)
    {
        ig ig1 = null;
        (new StringBuilder("setLanguage(")).append(s).append(")");
        d = null;
        if (s != null)
        {
            ig1 = c(s);
        }
        Object obj = ig1;
        if (ig1 == null)
        {
            obj = Locale.getDefault().toString();
            (new StringBuilder()).append(s).append(" not found.  Attempting to look for ").append(((String) (obj)));
            obj = c(((String) (obj)));
        }
        s = ((String) (obj));
        if (obj == null)
        {
            s = (ig)c.get("en");
        }
        if (!f && s == null)
        {
            throw new AssertionError();
        }
        d = s;
        if (!f && d == null)
        {
            throw new AssertionError();
        } else
        {
            (new StringBuilder("setting locale to:")).append(d.a());
            return;
        }
    }

    static 
    {
        boolean flag;
        if (!com/paypal/android/sdk/hf.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f = flag;
        com/paypal/android/sdk/hf.getSimpleName();
        a = new HashMap();
        b = new HashSet();
        a.put("zh_CN", "zh-Hans");
        a.put("zh_TW", "zh-Hant_TW");
        a.put("zh_HK", "zh-Hant");
        a.put("en_UK", "en_GB");
        a.put("en_IE", "en_GB");
        a.put("iw_IL", "he");
        a.put("no", "nb");
        b.add("he");
        b.add("ar");
    }
}
