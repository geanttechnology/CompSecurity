// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;


// Referenced classes of package com.wishabi.flipp.widget:
//            ShoppingListPopup, ds, dr

final class dq
    implements Runnable
{

    boolean a;
    final ShoppingListPopup b;

    public dq(ShoppingListPopup shoppinglistpopup, long l)
    {
        b = shoppinglistpopup;
        super();
        a = false;
        shoppinglistpopup.postDelayed(this, l);
    }

    public final void run()
    {
        if (!a)
        {
            if (ShoppingListPopup.a(b) == ds.e)
            {
                ShoppingListPopup.a(b, ds.c);
            }
            if (ShoppingListPopup.b(b) != null && !ShoppingListPopup.b(b).a())
            {
                b.a(true);
                return;
            }
        }
    }
}
