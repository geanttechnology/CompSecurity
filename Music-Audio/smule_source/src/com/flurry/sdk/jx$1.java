// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            jc, jx, jn

final class der extends jc
{

    public void a(jx jx1)
    {
        if (jx1 instanceof jn)
        {
            ((jn)jx1).o();
            return;
        }
        int j = jx.a(jx1);
        int i = j;
        if (j == 0)
        {
            i = jx.b(jx1);
        }
        if (i == 13)
        {
            jx.a(jx1, 9);
            return;
        }
        if (i == 12)
        {
            jx.a(jx1, 8);
            return;
        }
        if (i == 14)
        {
            jx.a(jx1, 10);
            return;
        } else
        {
            throw new IllegalStateException((new StringBuilder()).append("Expected a name but was ").append(jx1.f()).append(" ").append(" at line ").append(jx.c(jx1)).append(" column ").append(jx.d(jx1)).append(" path ").append(jx1.q()).toString());
        }
    }

    der()
    {
    }
}
