// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a.a;

import java.util.Random;

// Referenced classes of package com.d.a.a:
//            a

public class b
    implements a
{

    private float a;
    private float b;

    public b(float f, float f1)
    {
        a = f;
        b = f1;
    }

    public void a(com.d.a.b b1, Random random)
    {
        b1.g = random.nextFloat() * (b - a) + a;
    }
}
