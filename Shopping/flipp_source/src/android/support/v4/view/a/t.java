// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view.a;

import java.util.List;

// Referenced classes of package android.support.v4.view.a:
//            x, v, z, u, 
//            e

public final class t
{

    private static final u b;
    public final Object a;

    public t()
    {
        a = b.a(this);
    }

    public t(Object obj)
    {
        a = obj;
    }

    public static e a()
    {
        return null;
    }

    public static boolean b()
    {
        return false;
    }

    public static List c()
    {
        return null;
    }

    public static e d()
    {
        return null;
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 19)
        {
            b = new x();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 16)
        {
            b = new v();
        } else
        {
            b = new z();
        }
    }
}
