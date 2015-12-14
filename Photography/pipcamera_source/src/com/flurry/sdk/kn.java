// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;

import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.flurry.sdk:
//            kp, lb

public class kn extends kp
{

    private a a;
    private Object b;
    private Object c;
    private lb d;
    private lb e;

    public kn()
    {
    }

    static Object a(kn kn1)
    {
        return kn1.b;
    }

    static Object a(kn kn1, Object obj)
    {
        kn1.c = obj;
        return obj;
    }

    static lb b(kn kn1)
    {
        return kn1.d;
    }

    static lb c(kn kn1)
    {
        return kn1.e;
    }

    static void d(kn kn1)
    {
        kn1.s();
    }

    private void r()
    {
        a(new kp.c() {

            final kn a;

            public void a(kp kp1)
            {
                kn.d(a);
            }

            public void a(kp kp1, InputStream inputstream)
            {
                while (!kp1.g() || kn.c(a) == null) 
                {
                    return;
                }
                kn.a(a, kn.c(a).b(inputstream));
            }

            public void a(kp kp1, OutputStream outputstream)
            {
                if (kn.a(a) != null && kn.b(a) != null)
                {
                    kn.b(a).a(outputstream, kn.a(a));
                }
            }

            
            {
                a = kn.this;
                super();
            }
        });
    }

    private void s()
    {
        while (a == null || e()) 
        {
            return;
        }
        a.a(this, c);
    }

    public void a()
    {
        r();
        super.a();
    }

    public void a(a a1)
    {
        a = a1;
    }

    public void a(lb lb)
    {
        d = lb;
    }

    public void a(Object obj)
    {
        b = obj;
    }

    public void b(lb lb)
    {
        e = lb;
    }

    private class a
    {

        public abstract void a(kn kn1, Object obj);
    }

}
