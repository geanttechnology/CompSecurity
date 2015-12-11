// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, lt

class aec extends aat
{

    private static final String a;
    private static final String b;

    public aec()
    {
        super(a, new String[] {
            b
        });
    }

    public lv.a a(Map map)
    {
        return (lv.a)map.get(b);
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.g.toString();
        b = lt.dv.toString();
    }
}
