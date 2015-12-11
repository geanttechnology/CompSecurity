// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, lt, ado, 
//            aah

class aek extends aat
{

    private static final String a;
    private static final String b;
    private static final String c;
    private final aah d;

    public aek(aah aah1)
    {
        super(a, new String[] {
            b
        });
        d = aah1;
    }

    public lv.a a(Map map)
    {
        Object obj = d.c(ado.a((lv.a)map.get(b)));
        if (obj == null)
        {
            map = (lv.a)map.get(c);
            if (map != null)
            {
                return map;
            } else
            {
                return ado.f();
            }
        } else
        {
            return ado.e(obj);
        }
    }

    public boolean a()
    {
        return false;
    }

    static 
    {
        a = ls.i.toString();
        b = lt.bH.toString();
        c = lt.as.toString();
    }
}
