// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, ado

class aef extends aat
{

    private static final String a;
    private final String b;

    public aef(String s)
    {
        super(a, new String[0]);
        b = s;
    }

    public lv.a a(Map map)
    {
        if (b == null)
        {
            return ado.f();
        } else
        {
            return ado.e(b);
        }
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.j.toString();
    }
}
