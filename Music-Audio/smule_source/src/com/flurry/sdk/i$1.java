// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            fy, i, fs, p, 
//            v, fx

class nit>
    implements fy
{

    final i a;

    public void a(fs fs1)
    {
        if (.c.equals(fs1.b))
        {
            i.a(a).b(fs1.a);
            i.b(a).a(fs1.a);
        } else
        {
            if (.d.equals(fs1.b))
            {
                i.a(a).c(fs1.a);
                i.b(a).b(fs1.a);
                return;
            }
            if (.b.equals(fs1.b))
            {
                i.a(a).d(fs1.a);
                i.b(a).c(fs1.a);
                return;
            }
        }
    }

    public void notify(fx fx)
    {
        a((fs)fx);
    }

    (i j)
    {
        a = j;
        super();
    }
}
