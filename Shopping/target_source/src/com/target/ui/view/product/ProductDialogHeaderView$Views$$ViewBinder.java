// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;

// Referenced classes of package com.target.ui.view.product:
//            ProductVariationView, ProductDialogPriceView, ProductDialogWarningView

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        .w = (ProductVariationView)viewbinder.variationView((View)viewbinder.variationView(obj, 0x7f10053b, "field 'variationView'"), 0x7f10053b, "field 'variationView'");
        .w = (ProductDialogPriceView)viewbinder.priceView((View)viewbinder.priceView(obj, 0x7f10053c, "field 'priceView'"), 0x7f10053c, "field 'priceView'");
        .w = (ProductDialogWarningView)viewbinder.warningView((View)viewbinder.warningView(obj, 0x7f10053d, "field 'warningView'"), 0x7f10053d, "field 'warningView'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.w = null;
        bind1.w = null;
        bind1.w = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
