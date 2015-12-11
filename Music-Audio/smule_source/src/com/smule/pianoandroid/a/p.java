// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.a;

import com.smule.android.c.aa;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// Referenced classes of package com.smule.pianoandroid.a:
//            f, c, a

public class p extends f
{

    public p()
    {
        super(null);
    }

    public volatile int a()
    {
        return super.a();
    }

    public volatile List a(List list, Map map)
    {
        return super.a(list, map);
    }

    public boolean a(Map map)
    {
        Boolean boolean1;
        Object obj;
        Object obj1;
        boolean1 = Boolean.valueOf(false);
        obj = a(a, map);
        map = ((Map) (((List) (obj)).get(0)));
        obj1 = ((List) (obj)).get(1);
        if (!(map instanceof String) || !(obj1 instanceof String))
        {
            aa.a(c.a(), (new StringBuilder()).append("Operands are not strings : ").append(map).append(" / ").append(obj1).toString());
            return false;
        }
        obj = String.valueOf(map);
        obj1 = String.valueOf(obj1);
        map = boolean1;
        if (Pattern.compile(((String) (obj1)), 34).matcher(((CharSequence) (obj))).matches())
        {
            map = Boolean.valueOf(true);
        }
_L2:
        return map.booleanValue();
        map;
        aa.b(c.a(), (new StringBuilder()).append("Bad regex pattern in like statement: ").append(((String) (obj1))).toString());
        map = boolean1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public volatile a a_(Map map)
    {
        return super.a_(map);
    }
}
