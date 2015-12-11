// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.HashMap;
import java.util.HashSet;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.device.ads:
//            aq, cp, a, aa

final class ay
{

    private static ay d = new ay();
    HashMap a;
    HashMap b;
    HashMap c;
    private HashMap e;

    ay()
    {
        a = new HashMap();
        b = new HashMap();
        e = new HashMap();
        c = new HashMap();
        a("amazon.js", new aq());
        cp cp1 = new cp();
        a(a.b, cp1);
        a(a.c, cp1);
        a(a.d, cp1);
        a("mraid.js", cp1);
    }

    public static ay a()
    {
        return d;
    }

    private void a(a a1, aa aa)
    {
        HashSet hashset1 = (HashSet)a.get(a1);
        HashSet hashset = hashset1;
        if (hashset1 == null)
        {
            hashset = new HashSet();
            a.put(a1, hashset);
        }
        hashset.add(aa);
    }

    private void a(String s, aa aa)
    {
        String s1 = String.format("<[Ss][Cc][Rr][Ii][Pp][Tt](\\s[^>]*\\s|\\s)[Ss][Rr][Cc]\\s*=\\s*[\"']%s[\"']", new Object[] {
            s
        });
        Object obj = (HashSet)b.get(s1);
        HashSet hashset = ((HashSet) (obj));
        if (obj == null)
        {
            hashset = new HashSet();
            b.put(s1, hashset);
        }
        hashset.add(aa);
        obj = String.format(".*\\W%s$|^%s$", new Object[] {
            s, s
        });
        hashset = (HashSet)c.get(obj);
        s = hashset;
        if (hashset == null)
        {
            s = new HashSet();
            c.put(obj, s);
        }
        s.add(aa);
    }

    final Pattern a(String s)
    {
        Pattern pattern1 = (Pattern)e.get(s);
        Pattern pattern = pattern1;
        if (pattern1 == null)
        {
            pattern = Pattern.compile(s);
            e.put(s, pattern);
        }
        return pattern;
    }

}
