// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import com.smule.android.c.aa;
import com.smule.pianoandroid.e.c;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.smule.pianoandroid.a:
//            b

public class a
{

    private static final String a = com/smule/pianoandroid/a/a.getSimpleName();

    public a()
    {
    }

    public static a b(Map map)
    {
        if (map.size() < 1)
        {
            aa.b(a, "Expected condition root, but got empty dictionary.");
            return null;
        }
        if (map.size() > 1)
        {
            aa.b(a, (new StringBuilder()).append("Expected condition root, but got multiple entries: ").append(map).toString());
            return null;
        } else
        {
            String s = (String)map.keySet().iterator().next();
            return c.a().a(s).a_(map);
        }
    }

    public boolean a(Map map)
    {
        return false;
    }

}
