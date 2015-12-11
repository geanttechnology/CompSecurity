// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.view.View;
import android.widget.TextView;
import com.groupon.view.PlaceholderUrlImageView;

// Referenced classes of package com.groupon.view.widgetcards:
//            GtgDefaultPromoView

public class 
    implements butterknife.View..ViewBinder
{

    public void bind(butterknife.View..ViewBinder viewbinder, GtgDefaultPromoView gtgdefaultpromoview, Object obj)
    {
        gtgdefaultpromoview.backgroundImageView = (PlaceholderUrlImageView)viewbinder.backgroundImageView((View)viewbinder.iew(obj, 0x7f100379, "field 'backgroundImageView'"), 0x7f100379, "field 'backgroundImageView'");
        gtgdefaultpromoview.iconImageView = (PlaceholderUrlImageView)viewbinder.iconImageView((View)viewbinder.iew(obj, 0x7f100375, "field 'iconImageView'"), 0x7f100375, "field 'iconImageView'");
        gtgdefaultpromoview.callToActionImageView = (PlaceholderUrlImageView)viewbinder.callToActionImageView((View)viewbinder.iew(obj, 0x7f100377, "field 'callToActionImageView'"), 0x7f100377, "field 'callToActionImageView'");
        gtgdefaultpromoview.titleView = (TextView)viewbinder.titleView((View)viewbinder.iew(obj, 0x7f10007a, "field 'titleView'"), 0x7f10007a, "field 'titleView'");
        gtgdefaultpromoview.callToActionView = (TextView)viewbinder.callToActionView((View)viewbinder.iew(obj, 0x7f100378, "field 'callToActionView'"), 0x7f100378, "field 'callToActionView'");
    }

    public volatile void bind(butterknife.View..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (GtgDefaultPromoView)obj, obj1);
    }

    public void unbind(GtgDefaultPromoView gtgdefaultpromoview)
    {
        gtgdefaultpromoview.backgroundImageView = null;
        gtgdefaultpromoview.iconImageView = null;
        gtgdefaultpromoview.callToActionImageView = null;
        gtgdefaultpromoview.titleView = null;
        gtgdefaultpromoview.callToActionView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GtgDefaultPromoView)obj);
    }

    public ()
    {
    }
}
