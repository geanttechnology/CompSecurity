// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.d;


// Referenced classes of package com.mopub.d:
//            p, s

public final class d
    implements p
{

    private int a;
    private int b;
    private final int c;
    private final float d;

    public d()
    {
        this(2500, 1, 1.0F);
    }

    public d(int i, int j, float f)
    {
        a = i;
        c = j;
        d = f;
    }

    public final int a()
    {
        return a;
    }

    public final void a(s s)
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
            throw s;
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
