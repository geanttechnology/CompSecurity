// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7.widget;

import android.view.View;

// Referenced classes of package android.support.v7.widget:
//            ag, ah, au

public abstract class af
{

    protected final au a;
    int b;

    private af(au au)
    {
        b = 0x80000000;
        a = au;
    }

    af(au au, byte byte0)
    {
        this(au);
    }

    public static af a(au au, int i)
    {
        switch (i)
        {
        default:
            throw new IllegalArgumentException("invalid orientation");

        case 0: // '\0'
            return new ag(au);

        case 1: // '\001'
            return new ah(au);
        }
    }

    public final int a()
    {
        if (0x80000000 == b)
        {
            return 0;
        } else
        {
            return e() - b;
        }
    }

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int f();
}
