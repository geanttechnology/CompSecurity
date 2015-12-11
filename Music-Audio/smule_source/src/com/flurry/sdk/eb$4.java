// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            eb, dq

class it>
    implements it>
{

    final eb a;

    public void a()
    {
        if (eb.o(a) == 3 && eb.b(a) != null)
        {
            if (a.isViewAttachedToActivity() && a.a(eb.b(a)))
            {
                a.removeView(eb.b(a));
            }
            eb.b(a).cleanupLayout();
            eb.a(a, null);
        }
    }

    public void b()
    {
        if (eb.o(a) == 3 && eb.b(a) != null)
        {
            if (a.isViewAttachedToActivity() && a.a(eb.b(a)))
            {
                a.removeView(eb.b(a));
            }
            eb.b(a).cleanupLayout();
            eb.a(a, null);
        }
    }

    public void c()
    {
        if (eb.o(a) == 3 && eb.b(a) != null)
        {
            eb.b(a).cleanupLayout();
            eb.a(a, null);
        }
    }

    (eb eb1)
    {
        a = eb1;
        super();
    }
}
