// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.widget;

import android.view.View;
import android.widget.TextView;

// Referenced classes of package com.wishabi.flipp.widget:
//            ShoppingListZeroCaseView, dv

final class du
    implements android.view.View.OnClickListener
{

    final ShoppingListZeroCaseView a;

    du(ShoppingListZeroCaseView shoppinglistzerocaseview)
    {
        a = shoppinglistzerocaseview;
        super();
    }

    public final void onClick(View view)
    {
        ShoppingListZeroCaseView.a(a).a((TextView)view);
    }
}
