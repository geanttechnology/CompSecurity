// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


// Referenced classes of package com.a.a:
//            q, t

public final class d
    implements q
{

    private int a;
    private int b;
    private final int c;
    private final float d;

    public d()
    {
        this(2500);
    }

    public d(int i)
    {
        a = i;
        c = 0;
        d = 1.0F;
    }

    public final int a()
    {
        return a;
    }

    public final void a(t t)
    {
        b = b + 1;
        a = (int)((float)a + (float)a * d);
        boolean flag;
        if (b <= c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw t;
        } else
        {
            return;
        }
    }

    public final int b()
    {
        return b;
    }
}
