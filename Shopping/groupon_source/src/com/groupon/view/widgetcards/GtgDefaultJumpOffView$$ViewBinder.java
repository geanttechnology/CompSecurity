// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.widgetcards;

import android.view.View;
import android.widget.TextView;
import com.groupon.view.PlaceholderUrlImageView;

// Referenced classes of package com.groupon.view.widgetcards:
//            GtgDefaultJumpOffView

public class 
    implements butterknife.View..ViewBinder
{

    public void bind(butterknife.View..ViewBinder viewbinder, GtgDefaultJumpOffView gtgdefaultjumpoffview, Object obj)
    {
        gtgdefaultjumpoffview.iconImageView = (PlaceholderUrlImageView)viewbinder.iconImageView((View)viewbinder.w(obj, 0x7f100375, "field 'iconImageView'"), 0x7f100375, "field 'iconImageView'");
        gtgdefaultjumpoffview.callToActionImageView = (PlaceholderUrlImageView)viewbinder.callToActionImageView((View)viewbinder.w(obj, 0x7f100377, "field 'callToActionImageView'"), 0x7f100377, "field 'callToActionImageView'");
        gtgdefaultjumpoffview.titleView = (TextView)viewbinder.titleView((View)viewbinder.w(obj, 0x7f10007a, "field 'titleView'"), 0x7f10007a, "field 'titleView'");
        gtgdefaultjumpoffview.callToActionView = (TextView)viewbinder.callToActionView((View)viewbinder.w(obj, 0x7f100378, "field 'callToActionView'"), 0x7f100378, "field 'callToActionView'");
    }

    public volatile void bind(butterknife.View..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (GtgDefaultJumpOffView)obj, obj1);
    }

    public void unbind(GtgDefaultJumpOffView gtgdefaultjumpoffview)
    {
        gtgdefaultjumpoffview.iconImageView = null;
        gtgdefaultjumpoffview.callToActionImageView = null;
        gtgdefaultjumpoffview.titleView = null;
        gtgdefaultjumpoffview.callToActionView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((GtgDefaultJumpOffView)obj);
    }

    public ()
    {
    }
}
