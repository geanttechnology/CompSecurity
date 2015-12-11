// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            ao, ad, u

final class b
    implements Runnable
{

    final ad a;
    final u b;
    final ao c;

    public final void run()
    {
        synchronized (c)
        {
            c.d = true;
            a.a(b);
            Object obj = b;
            ad ad1 = a;
            ad1.getClass();
            obj = new <init>(ad1, ((u) (obj)));
            if (ao.a(c))
            {
                android.view.roup.LayoutParams layoutparams = c.getLayoutParams();
                c.l = layoutparams.width;
                c.k = layoutparams.height;
                if (c.l <= 0)
                {
                    c.l = c.getWidth();
                }
                if (c.k <= 0)
                {
                    c.k = c.getHeight();
                }
            }
            ((tHeight) (obj)).a(c.getLayoutParams());
            c.loadUrl("javascript:MMJS.sdk.setState('resized');");
            c.c = "resized";
        }
        return;
        exception;
        ao1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ms(ao ao1, ad ad1, u u)
    {
        c = ao1;
        a = ad1;
        b = u;
        super();
    }
}
