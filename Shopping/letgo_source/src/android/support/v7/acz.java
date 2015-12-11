// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Map;

// Referenced classes of package android.support.v7:
//            aat, ls, ado

class acz extends aat
{

    private static final String a;

    public acz()
    {
        super(a, new String[0]);
    }

    public lv.a a(Map map)
    {
        return ado.e(Integer.valueOf(android.os.Build.VERSION.SDK_INT));
    }

    public boolean a()
    {
        return true;
    }

    static 
    {
        a = ls.A.toString();
    }
}
