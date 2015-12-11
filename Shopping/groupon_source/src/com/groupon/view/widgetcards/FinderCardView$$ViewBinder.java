// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.view.View;
import android.widget.TextView;
import com.groupon.view.PlaceholderUrlImageView;

// Referenced classes of package com.groupon.view.widgetcards:
//            FinderCardView

public class 
    implements butterknife.View..ViewBinder
{

    public void bind(butterknife.View..ViewBinder viewbinder, FinderCardView findercardview, Object obj)
    {
        findercardview.backgroundImageView = (PlaceholderUrlImageView)viewbinder.((View)viewbinder.iredView(obj, 0x7f100299, "field 'backgroundImageView'"), 0x7f100299, "field 'backgroundImageView'");
        findercardview.iconImageView = (PlaceholderUrlImageView)viewbinder.((View)viewbinder.iredView(obj, 0x7f10029a, "field 'iconImageView'"), 0x7f10029a, "field 'iconImageView'");
        findercardview.callToActionImageView = (PlaceholderUrlImageView)viewbinder.((View)viewbinder.iredView(obj, 0x7f10029b, "field 'callToActionImageView'"), 0x7f10029b, "field 'callToActionImageView'");
        findercardview.titleView = (TextView)viewbinder.((View)viewbinder.iredView(obj, 0x7f10007a, "field 'titleView'"), 0x7f10007a, "field 'titleView'");
        findercardview.discountView = (TextView)viewbinder.((View)viewbinder.iredView(obj, 0x7f100272, "field 'discountView'"), 0x7f100272, "field 'discountView'");
        findercardview.callToActionView = (TextView)viewbinder.((View)viewbinder.iredView(obj, 0x7f10029c, "field 'callToActionView'"), 0x7f10029c, "field 'callToActionView'");
    }

    public volatile void bind(butterknife.View..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (FinderCardView)obj, obj1);
    }

    public void unbind(FinderCardView findercardview)
    {
        findercardview.backgroundImageView = null;
        findercardview.iconImageView = null;
        findercardview.callToActionImageView = null;
        findercardview.titleView = null;
        findercardview.discountView = null;
        findercardview.callToActionView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((FinderCardView)obj);
    }

    public ()
    {
    }
}
