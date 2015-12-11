// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.view.MapSliceRedesign;

// Referenced classes of package com.groupon.activity:
//            MarketRateReservation, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (MarketRateReservation)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, MarketRateReservation marketratereservation, Object obj)
    {
        super.bind(ewbinder, marketratereservation, obj);
        marketratereservation.hotelImageView = (ImageView)ewbinder.elImageView((View)ewbinder.w(obj, 0x7f100402, "field 'hotelImageView'"), 0x7f100402, "field 'hotelImageView'");
        marketratereservation.hotelTitle = (TextView)ewbinder.elTitle((View)ewbinder.w(obj, 0x7f10007a, "field 'hotelTitle'"), 0x7f10007a, "field 'hotelTitle'");
        marketratereservation.hotelLocation = (TextView)ewbinder.elLocation((View)ewbinder.w(obj, 0x7f1002d4, "field 'hotelLocation'"), 0x7f1002d4, "field 'hotelLocation'");
        marketratereservation.bookingInfoContainer = (LinearLayout)ewbinder.kingInfoContainer((View)ewbinder.w(obj, 0x7f10040e, "field 'bookingInfoContainer'"), 0x7f10040e, "field 'bookingInfoContainer'");
        marketratereservation.gBucksContainer = (View)ewbinder.w(obj, 0x7f10038d, "field 'gBucksContainer'");
        marketratereservation.gBucksValue = (TextView)ewbinder.cksValue((View)ewbinder.w(obj, 0x7f100393, "field 'gBucksValue'"), 0x7f100393, "field 'gBucksValue'");
        marketratereservation.mapSlice = (MapSliceRedesign)ewbinder.Slice((View)ewbinder.w(obj, 0x7f10013f, "field 'mapSlice'"), 0x7f10013f, "field 'mapSlice'");
        marketratereservation.highlightsContainer = (View)ewbinder.w(obj, 0x7f10040f, "field 'highlightsContainer'");
        marketratereservation.highlightsWebView = (WebView)ewbinder.hlightsWebView((View)ewbinder.w(obj, 0x7f100411, "field 'highlightsWebView'"), 0x7f100411, "field 'highlightsWebView'");
        marketratereservation.highlightsTitleView = (TextView)ewbinder.hlightsTitleView((View)ewbinder.w(obj, 0x7f100410, "field 'highlightsTitleView'"), 0x7f100410, "field 'highlightsTitleView'");
        marketratereservation.amenitiesContainer = (View)ewbinder.w(obj, 0x7f1003a4, "field 'amenitiesContainer'");
        marketratereservation.amenitiesView = (TextView)ewbinder.nitiesView((View)ewbinder.w(obj, 0x7f1003a5, "field 'amenitiesView'"), 0x7f1003a5, "field 'amenitiesView'");
        marketratereservation.finePrintContainer = (View)ewbinder.w(obj, 0x7f1003a6, "field 'finePrintContainer'");
        marketratereservation.finePrintWebView = (WebView)ewbinder.ePrintWebView((View)ewbinder.w(obj, 0x7f100412, "field 'finePrintWebView'"), 0x7f100412, "field 'finePrintWebView'");
        marketratereservation.progress = (View)ewbinder.w(obj, 0x7f10010b, "field 'progress'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (MarketRateReservation)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((MarketRateReservation)grouponactivity);
    }

    public void unbind(MarketRateReservation marketratereservation)
    {
        super.(marketratereservation);
        marketratereservation.hotelImageView = null;
        marketratereservation.hotelTitle = null;
        marketratereservation.hotelLocation = null;
        marketratereservation.bookingInfoContainer = null;
        marketratereservation.gBucksContainer = null;
        marketratereservation.gBucksValue = null;
        marketratereservation.mapSlice = null;
        marketratereservation.highlightsContainer = null;
        marketratereservation.highlightsWebView = null;
        marketratereservation.highlightsTitleView = null;
        marketratereservation.amenitiesContainer = null;
        marketratereservation.amenitiesView = null;
        marketratereservation.finePrintContainer = null;
        marketratereservation.finePrintWebView = null;
        marketratereservation.progress = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((MarketRateReservation)obj);
    }

    public ()
    {
    }
}
