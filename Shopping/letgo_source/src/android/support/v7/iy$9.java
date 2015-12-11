// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package android.support.v7:
//            iy, ja, jc

class a
    implements Runnable
{

    final long a;
    final iy b;

    public void run()
    {
        ja ja1 = ja.a(b.b);
        ja1.b(a);
        iy.d(b).set(false);
        if (ja1.a() > (long)iy.e(b))
        {
            b.i.a(new Runnable() {

                final iy._cls9 a;

                public void run()
                {
                    a.b.b(iy.f(a.b));
                }

            
            {
                a = iy._cls9.this;
                super();
            }
            });
            return;
        } else
        {
            iy.b(b, false);
            iy.a(b, iy.g(b));
            return;
        }
    }

    _cls1.a(iy iy1, long l)
    {
        b = iy1;
        a = l;
        super();
    }
}
