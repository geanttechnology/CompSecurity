// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, ado

class acf extends aat
{

    private static final String a;

    public acf()
    {
        super(a, new String[0]);
    }

    public lv.a a(Map map)
    {
        return ado.e(android.os.Build.VERSION.RELEASE);
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.u.toString();
    }
}
