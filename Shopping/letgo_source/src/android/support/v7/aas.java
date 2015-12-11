// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, acx, ado

class aas extends aat
{

    private static final String a;
    private final acx b;

    public aas(acx acx1)
    {
        super(a, new String[0]);
        b = acx1;
    }

    public lv.a a(Map map)
    {
        map = b.a();
        if (map == null)
        {
            return ado.f();
        } else
        {
            return ado.e(map);
        }
    }

    public boolean a()
    {
        return false;
    }

    static 
    {
        a = ls.q.toString();
    }
}
