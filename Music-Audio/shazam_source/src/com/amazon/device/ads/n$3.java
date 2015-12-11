// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            n, ck, cl

final class a
    implements Runnable
{

    final n a;

    public final void run()
    {
        n n1 = a;
        if (n1.getAndSetNeedsToLoadAdOnLayout$138603())
        {
            ck.a().b.a(.J);
            n1.a("Can't load an ad because the view size cannot be determined.");
        }
    }

    (n n1)
    {
        a = n1;
        super();
    }
}
