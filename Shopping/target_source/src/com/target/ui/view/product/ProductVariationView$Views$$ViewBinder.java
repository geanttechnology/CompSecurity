// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.Spinner;

// Referenced classes of package com.target.ui.view.product:
//            FixedHeightGridView

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (Spinner)viewbinder.dropDown((View)viewbinder.dropDown(obj, 0x7f1005e1, "field 'dropDown'"), 0x7f1005e1, "field 'dropDown'");
        . = (FixedHeightGridView)viewbinder.gridView((View)viewbinder.gridView(obj, 0x7f1005e3, "field 'gridView'"), 0x7f1005e3, "field 'gridView'");
        .iv = (View)viewbinder.dropDownTopDiv(obj, 0x7f1005e0, "field 'dropDownTopDiv'");
        .omDiv = (View)viewbinder.dropDownBottomDiv(obj, 0x7f1005e2, "field 'dropDownBottomDiv'");
        .omDiv = (View)viewbinder.gridViewBottomDiv(obj, 0x7f1005e4, "field 'gridViewBottomDiv'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.iv = null;
        bind1.omDiv = null;
        bind1.omDiv = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
