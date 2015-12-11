// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.view.MapSlice;
import com.groupon.view.SpinnerButton;
import com.groupon.view.UrlImageView;

// Referenced classes of package com.groupon.activity:
//            Groupon, GrouponActivity

public class wBinder extends wBinder
{

    public void bind(butterknife.ewBinder ewbinder, Groupon groupon, Object obj)
    {
        super.bind(ewbinder, groupon, obj);
        groupon.titleView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f10007a, "field 'titleView'"), 0x7f10007a, "field 'titleView'");
        groupon.subtitleView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f10011a, "field 'subtitleView'"), 0x7f10011a, "field 'subtitleView'");
        groupon.subtitleDivider = (View)ewbinder.indRequiredView(obj, 0x7f10034c, "field 'subtitleDivider'");
        groupon.usedOnView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f10034d, "field 'usedOnView'"), 0x7f10034d, "field 'usedOnView'");
        groupon.usedOnDivider = (View)ewbinder.indRequiredView(obj, 0x7f10034e, "field 'usedOnDivider'");
        groupon.dealImageView = (UrlImageView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100121, "field 'dealImageView'"), 0x7f100121, "field 'dealImageView'");
        groupon.finePrintView = (WebView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100357, "field 'finePrintView'"), 0x7f100357, "field 'finePrintView'");
        groupon.expirationView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100356, "field 'expirationView'"), 0x7f100356, "field 'expirationView'");
        groupon.vendorNameView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100350, "field 'vendorNameView'"), 0x7f100350, "field 'vendorNameView'");
        groupon.vendorUrlView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100351, "field 'vendorUrlView'"), 0x7f100351, "field 'vendorUrlView'");
        groupon.useGrouponView = (SpinnerButton)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100102, "field 'useGrouponView'"), 0x7f100102, "field 'useGrouponView'");
        groupon.bookNowButton = (Button)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100104, "field 'bookNowButton'"), 0x7f100104, "field 'bookNowButton'");
        groupon.gdtOrderButton = (Button)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100103, "field 'gdtOrderButton'"), 0x7f100103, "field 'gdtOrderButton'");
        groupon.mapSlice = (MapSlice)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100352, "field 'mapSlice'"), 0x7f100352, "field 'mapSlice'");
        groupon.progressView = (View)ewbinder.indRequiredView(obj, 0x7f10010b, "field 'progressView'");
        groupon.contentView = (View)ewbinder.indRequiredView(obj, 0x7f100132, "field 'contentView'");
        groupon.instructionsSection = (View)ewbinder.indRequiredView(obj, 0x7f10033d, "field 'instructionsSection'");
        groupon.instructionsView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100153, "field 'instructionsView'"), 0x7f100153, "field 'instructionsView'");
        groupon.bottomBarView = (View)ewbinder.indRequiredView(obj, 0x7f1000a0, "field 'bottomBarView'");
        groupon.bottomBarButtonsContainer = (LinearLayout)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100101, "field 'bottomBarButtonsContainer'"), 0x7f100101, "field 'bottomBarButtonsContainer'");
        groupon.universalRulesView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100358, "field 'universalRulesView'"), 0x7f100358, "field 'universalRulesView'");
        groupon.messageView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100105, "field 'messageView'"), 0x7f100105, "field 'messageView'");
        groupon.shipmentInfoContainer = (ViewGroup)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f10034f, "field 'shipmentInfoContainer'"), 0x7f10034f, "field 'shipmentInfoContainer'");
        groupon.tripDetailsContainer = (LinearLayout)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100353, "field 'tripDetailsContainer'"), 0x7f100353, "field 'tripDetailsContainer'");
        groupon.paymentDetailsContainer = (LinearLayout)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100354, "field 'paymentDetailsContainer'"), 0x7f100354, "field 'paymentDetailsContainer'");
        groupon.imageContainer = (View)ewbinder.indRequiredView(obj, 0x7f1002c5, "field 'imageContainer'");
        groupon.noVoucher = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f10035c, "field 'noVoucher'"), 0x7f10035c, "field 'noVoucher'");
        groupon.cancelOrderButton = (Button)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f10035b, "field 'cancelOrderButton'"), 0x7f10035b, "field 'cancelOrderButton'");
        groupon.pageButtonsContainer = (LinearLayout)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f10035a, "field 'pageButtonsContainer'"), 0x7f10035a, "field 'pageButtonsContainer'");
        groupon.giftContainer = (View)ewbinder.indRequiredView(obj, 0x7f100348, "field 'giftContainer'");
        groupon.giftSubjectView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100349, "field 'giftSubjectView'"), 0x7f100349, "field 'giftSubjectView'");
        groupon.giftEmailView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f10034a, "field 'giftEmailView'"), 0x7f10034a, "field 'giftEmailView'");
        groupon.giftClaimedView = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f10034b, "field 'giftClaimedView'"), 0x7f10034b, "field 'giftClaimedView'");
        groupon.grouponContent = (LinearLayout)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100347, "field 'grouponContent'"), 0x7f100347, "field 'grouponContent'");
        groupon.status = (TextView)ewbinder.astView((View)ewbinder.indRequiredView(obj, 0x7f100238, "field 'status'"), 0x7f100238, "field 'status'");
        ewbinder = ewbinder.etContext(obj).getResources();
        groupon.available = ewbinder.getString(0x7f08006b);
        groupon.refundPending = ewbinder.getString(0x7f080312);
        groupon.primeNoNetworkTitle = ewbinder.getString(0x7f0802ea);
        groupon.primeNoNetworkMessage = ewbinder.getString(0x7f0802e9);
        groupon.yes = ewbinder.getString(0x1040013);
        groupon.no = ewbinder.getString(0x1040009);
        groupon.shipmentInfoStatusShippedFormat = ewbinder.getString(0x7f080377);
        groupon.shipmentInfoStatusShipped = ewbinder.getString(0x7f080376);
        groupon.shipmentInfoStatusNotShipped = ewbinder.getString(0x7f080375);
        groupon.voucherInSeparateEmail = ewbinder.getString(0x7f080283);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (Groupon)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (Groupon)obj, obj1);
    }

    public void unbind(Groupon groupon)
    {
        super.unbind(groupon);
        groupon.titleView = null;
        groupon.subtitleView = null;
        groupon.subtitleDivider = null;
        groupon.usedOnView = null;
        groupon.usedOnDivider = null;
        groupon.dealImageView = null;
        groupon.finePrintView = null;
        groupon.expirationView = null;
        groupon.vendorNameView = null;
        groupon.vendorUrlView = null;
        groupon.useGrouponView = null;
        groupon.bookNowButton = null;
        groupon.gdtOrderButton = null;
        groupon.mapSlice = null;
        groupon.progressView = null;
        groupon.contentView = null;
        groupon.instructionsSection = null;
        groupon.instructionsView = null;
        groupon.bottomBarView = null;
        groupon.bottomBarButtonsContainer = null;
        groupon.universalRulesView = null;
        groupon.messageView = null;
        groupon.shipmentInfoContainer = null;
        groupon.tripDetailsContainer = null;
        groupon.paymentDetailsContainer = null;
        groupon.imageContainer = null;
        groupon.noVoucher = null;
        groupon.cancelOrderButton = null;
        groupon.pageButtonsContainer = null;
        groupon.giftContainer = null;
        groupon.giftSubjectView = null;
        groupon.giftEmailView = null;
        groupon.giftClaimedView = null;
        groupon.grouponContent = null;
        groupon.status = null;
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((Groupon)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((Groupon)obj);
    }

    public wBinder()
    {
    }
}
