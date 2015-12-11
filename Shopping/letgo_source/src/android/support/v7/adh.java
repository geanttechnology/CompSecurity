// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            acj, ado

abstract class adh extends acj
{

    public adh(String s)
    {
        super(s);
    }

    protected boolean a(lv.a a1, lv.a a2, Map map)
    {
        a1 = ado.a(a1);
        a2 = ado.a(a2);
        if (a1 == ado.e() || a2 == ado.e())
        {
            return false;
        } else
        {
            return a(((String) (a1)), ((String) (a2)), map);
        }
    }

    protected abstract boolean a(String s, String s1, Map map);
}
