// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.app;

import android.view.View;
import android.widget.EditText;

// Referenced classes of package com.wishabi.flipp.app:
//            ShoppingListFragment

final class ez
    implements android.view.View.OnFocusChangeListener
{

    final ShoppingListFragment a;

    ez(ShoppingListFragment shoppinglistfragment)
    {
        a = shoppinglistfragment;
        super();
    }

    public final void onFocusChange(View view, boolean flag)
    {
        if (flag)
        {
            view.setTag(Boolean.valueOf(false));
        } else
        if (view.getTag() != null && !((Boolean)view.getTag()).booleanValue())
        {
            a.a((EditText)view);
            return;
        }
    }
}
