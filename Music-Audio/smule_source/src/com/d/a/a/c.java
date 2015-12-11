// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a.a;

import com.d.a.b;
import java.util.Random;

// Referenced classes of package com.d.a.a:
//            a

public class c
    implements a
{

    private float a;
    private float b;

    public c(float f, float f1)
    {
        b = f;
        a = f1;
    }

    public void a(b b1, Random random)
    {
        b1.d = random.nextFloat() * (a - b) + b;
    }
}
