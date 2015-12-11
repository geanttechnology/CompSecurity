// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;


// Referenced classes of package com.a.a.a.a:
//            c, z, b

final class aa
    implements c
{

    final z a;

    aa(z z1)
    {
        a = z1;
        super();
    }

    public final void a(String s, String s1)
    {
        if ("no-cache".equalsIgnoreCase(s))
        {
            z.b(a);
        } else
        {
            if ("no-store".equalsIgnoreCase(s))
            {
                z.c(a);
                return;
            }
            if ("max-age".equalsIgnoreCase(s))
            {
                z.a(a, b.a(s1));
                return;
            }
            if ("s-maxage".equalsIgnoreCase(s))
            {
                z.b(a, b.a(s1));
                return;
            }
            if ("public".equalsIgnoreCase(s))
            {
                z.d(a);
                return;
            }
            if ("must-revalidate".equalsIgnoreCase(s))
            {
                z.e(a);
                return;
            }
        }
    }
}
