// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v4.view;

import android.view.Gravity;

public final class e
{
    static interface a
    {

        public abstract int a(int i, int j);
    }

    static final class b
        implements a
    {

        public final int a(int i, int j)
        {
            return 0xff7fffff & i;
        }

        b()
        {
        }
    }

    static final class c
        implements a
    {

        public final int a(int i, int j)
        {
            return Gravity.getAbsoluteGravity(i, j);
        }

        c()
        {
        }
    }


    static final a a;

    public static int a(int i, int j)
    {
        return a.a(i, j);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT >= 17)
        {
            a = new c();
        } else
        {
            a = new b();
        }
    }
}
