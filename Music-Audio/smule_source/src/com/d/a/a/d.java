// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.d.a.a;

import com.d.a.b;
import java.util.Random;

// Referenced classes of package com.d.a.a:
//            a

public class d
    implements a
{

    private float a;
    private float b;
    private int c;
    private int d;

    public d(float f, float f1, int i, int j)
    {
        a = f;
        b = f1;
        c = i;
        d = j;
_L3:
        if (c < 0) goto _L2; else goto _L1
_L1:
        if (d >= 0)
        {
            if (c > d)
            {
                i = c;
                c = d;
                d = i;
            }
            return;
        }
        break MISSING_BLOCK_LABEL_84;
_L2:
        c = c + 360;
          goto _L3
        d = d + 360;
          goto _L1
    }

    public void a(b b1, Random random)
    {
        float f = random.nextFloat();
        float f1 = b;
        float f2 = a;
        f = a + f * (f1 - f2);
        double d1;
        int i;
        if (d == c)
        {
            i = c;
        } else
        {
            i = random.nextInt(d - c) + c;
        }
        f1 = (float)(((double)i * 3.1415926535897931D) / 180D);
        b1.h = (float)((double)f * Math.cos(f1));
        d1 = f;
        b1.i = (float)(Math.sin(f1) * d1);
    }
}
