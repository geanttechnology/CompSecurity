// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import com.google.android.gms.d.e;
import com.google.android.gms.d.f;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// Referenced classes of package com.google.android.gms.e:
//            o, cj

final class bi extends o
{

    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;
    private static final String f;

    public bi()
    {
        super(b, new String[] {
            c, d
        });
    }

    public final com.google.android.gms.d.h.a a(Map map)
    {
        Object obj = (com.google.android.gms.d.h.a)map.get(c);
        com.google.android.gms.d.h.a a1 = (com.google.android.gms.d.h.a)map.get(d);
        if (obj == null || obj == com.google.android.gms.e.cj.f() || a1 == null || a1 == com.google.android.gms.e.cj.f())
        {
            return com.google.android.gms.e.cj.f();
        }
        byte byte0 = 64;
        if (cj.d((com.google.android.gms.d.h.a)map.get(e)).booleanValue())
        {
            byte0 = 66;
        }
        map = (com.google.android.gms.d.h.a)map.get(f);
        int i;
        if (map != null)
        {
            map = cj.c(map);
            if (map == cj.b())
            {
                return com.google.android.gms.e.cj.f();
            }
            int j = map.intValue();
            i = j;
            if (j < 0)
            {
                return com.google.android.gms.e.cj.f();
            }
        } else
        {
            i = 1;
        }
        try
        {
            map = cj.a(((com.google.android.gms.d.h.a) (obj)));
            obj = cj.a(a1);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return com.google.android.gms.e.cj.f();
        }
        a1 = null;
        obj = Pattern.compile(((String) (obj)), byte0).matcher(map);
        map = a1;
        if (!((Matcher) (obj)).find())
        {
            break MISSING_BLOCK_LABEL_186;
        }
        map = a1;
        if (((Matcher) (obj)).groupCount() >= i)
        {
            map = ((Matcher) (obj)).group(i);
        }
        if (map != null)
        {
            break MISSING_BLOCK_LABEL_194;
        }
        return com.google.android.gms.e.cj.f();
        map = cj.a(map);
        return map;
    }

    public final boolean a()
    {
        return true;
    }

    static 
    {
        b = e.M.toString();
        c = f.p.toString();
        d = f.q.toString();
        e = f.bh.toString();
        f = f.bb.toString();
    }
}
