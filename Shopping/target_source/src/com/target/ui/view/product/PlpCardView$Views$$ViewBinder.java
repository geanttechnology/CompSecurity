// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import com.target.ui.view.BitmapImageView;

// Referenced classes of package com.target.ui.view.product:
//            PlpGridPriceView

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (BitmapImageView)viewbinder.mImageView((View)viewbinder.dView(obj, 0x7f1004ed, "field 'mImageView'"), 0x7f1004ed, "field 'mImageView'");
        . = (PlpGridPriceView)viewbinder.w((View)viewbinder.dView(obj, 0x7f1004ef, "field 'mPriceBlock'"), 0x7f1004ef, "field 'mPriceBlock'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
