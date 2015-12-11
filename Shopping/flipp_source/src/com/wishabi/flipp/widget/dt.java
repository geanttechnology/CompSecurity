// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;


// Referenced classes of package com.wishabi.flipp.widget:
//            ShoppingListZeroCaseView

final class dt
    implements Runnable
{

    final int a;
    final int b;
    final ShoppingListZeroCaseView c;

    dt(ShoppingListZeroCaseView shoppinglistzerocaseview, int i, int j)
    {
        c = shoppinglistzerocaseview;
        a = i;
        b = j;
        super();
    }

    public final void run()
    {
        ShoppingListZeroCaseView.a(c, a, b);
    }
}
