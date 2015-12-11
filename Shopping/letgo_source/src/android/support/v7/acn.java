// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

// Referenced classes of package android.support.v7:
//            aat, ls, lt, ado

class acn extends aat
{

    private static final String a;
    private static final String b;
    private static final String c;
    private static final String d;
    private static final String e;

    public acn()
    {
        super(a, new String[] {
            b, c
        });
    }

    public lv.a a(Map map)
    {
        Object obj = (lv.a)map.get(b);
        lv.a a1 = (lv.a)map.get(c);
        if (obj == null || obj == ado.f() || a1 == null || a1 == ado.f())
        {
            return ado.f();
        }
        byte byte0 = 64;
        if (ado.d((lv.a)map.get(d)).booleanValue())
        {
            byte0 = 66;
        }
        map = (lv.a)map.get(e);
        int i;
        if (map != null)
        {
            map = ado.c(map);
            if (map == ado.b())
            {
                return ado.f();
            }
            int j = map.intValue();
            i = j;
            if (j < 0)
            {
                return ado.f();
            }
        } else
        {
            i = 1;
        }
        try
        {
            map = ado.a(((lv.a) (obj)));
            obj = ado.a(a1);
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            return ado.f();
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
        return ado.f();
        map = ado.e(map);
        return map;
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.M.toString();
        b = lt.p.toString();
        c = lt.q.toString();
        d = lt.bh.toString();
        e = lt.bb.toString();
    }
}
