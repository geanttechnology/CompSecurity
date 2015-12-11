// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            acj, ado, adn

abstract class acd extends acj
{

    public acd(String s)
    {
        super(s);
    }

    protected abstract boolean a(adn adn, adn adn1, Map map);

    protected boolean a(lv.a a1, lv.a a2, Map map)
    {
        a1 = ado.b(a1);
        a2 = ado.b(a2);
        if (a1 == ado.d() || a2 == ado.d())
        {
            return false;
        } else
        {
            return a(((adn) (a1)), ((adn) (a2)), map);
        }
    }
}
