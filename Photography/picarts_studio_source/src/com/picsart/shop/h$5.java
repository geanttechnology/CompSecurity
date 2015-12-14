// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.shop;


// Referenced classes of package com.picsart.shop:
//            h, j

final class t>
    implements Runnable
{

    private int a;
    private h b;

    public final void run()
    {
        h.o(b).scrollToPositionWithOffset(0x3fffffff, a);
    }

    (h h1, int i)
    {
        b = h1;
        a = i;
        super();
    }
}
