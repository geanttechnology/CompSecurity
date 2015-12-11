// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.dealcards;

import android.view.View;
import android.widget.TextView;
import com.groupon.view.UrlImageView;

// Referenced classes of package com.groupon.view.dealcards:
//            GroceryItemView

public class 
    implements butterknife.ew..ViewBinder
{

    public void bind(butterknife.ew..ViewBinder viewbinder, GroceryItemView groceryitemview, Object obj)
    {
        groceryitemview.imageView = (UrlImageView)viewbinder.imageView((View)viewbinder.redView(obj, 0x7f10033a, "field 'imageView'"), 0x7f10033a, "field 'imageView'");
        groceryitemview.titleLabel = (TextView)viewbinder.titleLabel((View)viewbinder.redView(obj, 0x7f10033b, "field 'titleLabel'"), 0x7f10033b, "field 'titleLabel'");
        groceryitemview.cashBack = (TextView)viewbinder.cashBack((View)viewbinder.redView(obj, 0x7f10033c, "field 'cashBack'"), 0x7f10033c, "field 'cashBack'");
    }

    public volatile void bind(butterknife.ew..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (GroceryItemView)obj, obj1);
    }

    public void unbind(GroceryItemView groceryitemview)
    {
        groceryitemview.imageView = null;
        groceryitemview.titleLabel = null;
        groceryitemview.cashBack = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GroceryItemView)obj);
    }

    public ()
    {
    }
}
