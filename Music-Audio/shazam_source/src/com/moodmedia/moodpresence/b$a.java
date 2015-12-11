// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;


// Referenced classes of package com.moodmedia.moodpresence:
//            b

class b
{

    long a;
    int b;
    final b c;

    long a()
    {
        return a;
    }

    void a(long l)
    {
        a = l;
    }

    int b()
    {
        return b;
    }

    long c()
    {
        if (a == -1L || a == 0L)
        {
            return -1L;
        } else
        {
            return a >>> 63 - c.b;
        }
    }

    (b b1, long l, int i)
    {
        c = b1;
        super();
        a = l;
        b = i;
    }
}
