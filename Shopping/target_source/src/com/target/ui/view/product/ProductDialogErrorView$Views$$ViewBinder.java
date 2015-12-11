// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.view.product:
//            ProductDialogZipCodeView

public class I
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder, I i, Object obj)
    {
        i.I = (TargetErrorView)viewbinder.errorView((View)viewbinder.errorView(obj, 0x7f10050c, "field 'errorView'"), 0x7f10050c, "field 'errorView'");
        i.I = (ProductDialogZipCodeView)viewbinder.zipCodeView((View)viewbinder.zipCodeView(obj, 0x7f10050d, "field 'zipCodeView'"), 0x7f10050d, "field 'zipCodeView'");
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

    public I()
    {
    }
}
