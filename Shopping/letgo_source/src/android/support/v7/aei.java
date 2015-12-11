// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            aat, ls, lt, ado, 
//            abo

class aei extends aat
{
    public static interface a
    {

        public abstract Object a(String s, Map map);
    }


    private static final String a;
    private static final String b;
    private static final String c;
    private final a d;

    public aei(a a1)
    {
        super(a, new String[] {
            b
        });
        d = a1;
    }

    public lv.a a(Map map)
    {
        String s = ado.a((lv.a)map.get(b));
        HashMap hashmap = new HashMap();
        map = (lv.a)map.get(c);
        if (map != null)
        {
            map = ((Map) (ado.e(map)));
            if (!(map instanceof Map))
            {
                abo.b("FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return ado.f();
            }
            java.util.Map.Entry entry;
            for (map = ((Map)map).entrySet().iterator(); map.hasNext(); hashmap.put(entry.getKey().toString(), entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

        }
        try
        {
            map = ado.e(d.a(s, hashmap));
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            abo.b((new StringBuilder()).append("Custom macro/tag ").append(s).append(" threw exception ").append(map.getMessage()).toString());
            return ado.f();
        }
        return map;
    }

    public boolean a()
    {
        return false;
    }

    static 
    {
        a = ls.r.toString();
        b = lt.ba.toString();
        c = lt.d.toString();
    }
}
