// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.ViewConfiguration;

// Referenced classes of package android.support.v4.view:
//            as, at

public class ar
{
    static class a
        implements e
    {

        public int a(ViewConfiguration viewconfiguration)
        {
            return viewconfiguration.getScaledTouchSlop();
        }

        public boolean b(ViewConfiguration viewconfiguration)
        {
            return true;
        }

        a()
        {
        }
    }

    static class b extends a
    {

        public int a(ViewConfiguration viewconfiguration)
        {
            return as.a(viewconfiguration);
        }

        b()
        {
        }
    }

    static class c extends b
    {

        public boolean b(ViewConfiguration viewconfiguration)
        {
            return false;
        }

        c()
        {
        }
    }

    static class d extends c
    {

        public boolean b(ViewConfiguration viewconfiguration)
        {
            return at.a(viewconfiguration);
        }

        d()
        {
        }
    }

    static interface e
    {

        public abstract int a(ViewConfiguration viewconfiguration);

        public abstract boolean b(ViewConfiguration viewconfiguration);
    }


    static final e a;

    public static int a(ViewConfiguration viewconfiguration)
    {
        return a.a(viewconfiguration);
    }

    public static boolean b(ViewConfiguration viewconfiguration)
    {
        return a.b(viewconfiguration);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 14)
        {
            a = new d();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            a = new c();
        } else
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            a = new b();
        } else
        {
            a = new a();
        }
    }
}
