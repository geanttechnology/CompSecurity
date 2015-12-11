// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;


// Referenced classes of package com.millennialmedia.android:
//            ao, ad, an

final class a
    implements Runnable
{

    final ad a;
    final ao b;

    public final void run()
    {
        synchronized (b)
        {
            a.b();
            if (an.c() && !ao.a(b))
            {
                android.view.roup.LayoutParams layoutparams = b.getLayoutParams();
                layoutparams.width = b.l;
                layoutparams.height = b.k;
                b.l = -50;
                b.k = -50;
                b.requestLayout();
            }
            b.k();
            b.d = true;
            b.invalidate();
        }
        return;
        exception;
        ao1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    ms(ao ao1, ad ad1)
    {
        b = ao1;
        a = ad1;
        super();
    }
}
