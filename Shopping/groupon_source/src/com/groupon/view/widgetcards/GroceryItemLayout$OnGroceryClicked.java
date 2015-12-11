// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.view.View;
import com.groupon.v3.adapter.callback.IViewCallback;
import com.groupon.view.dealcards.GroceryItemView;

// Referenced classes of package com.groupon.view.widgetcards:
//            GroceryItemLayout

private class groceryItem
    implements android.view.nGroceryClicked
{

    private GroceryItemView groceryItem;
    final GroceryItemLayout this$0;
    private IViewCallback viewCallback;

    public void onClick(View view)
    {
        if (viewCallback != null)
        {
            viewCallback.onViewClick(groceryItem);
        }
    }

    public (IViewCallback iviewcallback, GroceryItemView groceryitemview)
    {
        this$0 = GroceryItemLayout.this;
        super();
        viewCallback = iviewcallback;
        groceryItem = groceryitemview;
    }
}
