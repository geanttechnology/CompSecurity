// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package android.support.v7:
//            adm, ls, lt, ado, 
//            aah

class aem extends adm
{

    private static final String a;
    private static final String b;
    private static final String c;
    private final aah d;

    public aem(aah aah1)
    {
        super(a, new String[] {
            b
        });
        d = aah1;
    }

    private void a(lv.a a1)
    {
        if (a1 != null && a1 != ado.a())
        {
            if ((a1 = ado.a(a1)) != ado.e())
            {
                d.a(a1);
                return;
            }
        }
    }

    private void b(lv.a a1)
    {
        if (a1 != null && a1 != ado.a())
        {
            if ((a1 = ((lv.a) (ado.e(a1)))) instanceof List)
            {
                a1 = ((List)a1).iterator();
                while (a1.hasNext()) 
                {
                    Object obj = a1.next();
                    if (obj instanceof Map)
                    {
                        obj = (Map)obj;
                        d.a(((Map) (obj)));
                    }
                }
            }
        }
    }

    public void b(Map map)
    {
        b((lv.a)map.get(b));
        a((lv.a)map.get(c));
    }

    static 
    {
        a = ls.N.toString();
        b = lt.dv.toString();
        c = lt.M.toString();
    }
}
