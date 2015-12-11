// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.groupon.util.GrouponNavigationDrawerActivity;
import com.groupon.view.LiveChatView;
import com.groupon.view.ObservableScrollView;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.activity:
//            MarketRatePurchase, GrouponFragmentActivity

public class nder extends nder
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponFragmentActivity grouponfragmentactivity, Object obj)
    {
        bind(ewbinder, (MarketRatePurchase)grouponfragmentactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, MarketRatePurchase marketratepurchase, Object obj)
    {
        super.bind(ewbinder, marketratepurchase, obj);
        marketratepurchase.scroller = (ObservableScrollView)ewbinder.oller((View)ewbinder.View(obj, 0x7f10012a, "field 'scroller'"), 0x7f10012a, "field 'scroller'");
        marketratepurchase.scrollableContent = (View)ewbinder.View(obj, 0x7f1000da, "field 'scrollableContent'");
        marketratepurchase.titleGradientContainer = (View)ewbinder.View(obj, 0x7f10012b, "field 'titleGradientContainer'");
        marketratepurchase.hotelImageView = (ImageView)ewbinder.elImageView((View)ewbinder.View(obj, 0x7f100402, "field 'hotelImageView'"), 0x7f100402, "field 'hotelImageView'");
        marketratepurchase.titleView = (TextView)ewbinder.leView((View)ewbinder.View(obj, 0x7f10007a, "field 'titleView'"), 0x7f10007a, "field 'titleView'");
        marketratepurchase.locationView = (TextView)ewbinder.ationView((View)ewbinder.View(obj, 0x7f1002d4, "field 'locationView'"), 0x7f1002d4, "field 'locationView'");
        marketratepurchase.roomDetailsContainer = (LinearLayout)ewbinder.mDetailsContainer((View)ewbinder.View(obj, 0x7f100408, "field 'roomDetailsContainer'"), 0x7f100408, "field 'roomDetailsContainer'");
        marketratepurchase.reervationContainer = (LinearLayout)ewbinder.rvationContainer((View)ewbinder.View(obj, 0x7f100407, "field 'reervationContainer'"), 0x7f100407, "field 'reervationContainer'");
        marketratepurchase.paymentDetailsContainer = (LinearLayout)ewbinder.mentDetailsContainer((View)ewbinder.View(obj, 0x7f100409, "field 'paymentDetailsContainer'"), 0x7f100409, "field 'paymentDetailsContainer'");
        marketratepurchase.grouponBucksView = (View)ewbinder.View(obj, 0x7f10040a, "field 'grouponBucksView'");
        marketratepurchase.gBucksValue = (TextView)ewbinder.cksValue((View)ewbinder.View(obj, 0x7f100393, "field 'gBucksValue'"), 0x7f100393, "field 'gBucksValue'");
        marketratepurchase.cancellationPolicyContainer = (View)ewbinder.View(obj, 0x7f10040b, "field 'cancellationPolicyContainer'");
        marketratepurchase.roomCancellationPolicyView = (TextView)ewbinder.mCancellationPolicyView((View)ewbinder.View(obj, 0x7f10040c, "field 'roomCancellationPolicyView'"), 0x7f10040c, "field 'roomCancellationPolicyView'");
        marketratepurchase.cancellationPolicyView = (WebView)ewbinder.cellationPolicyView((View)ewbinder.View(obj, 0x7f10040d, "field 'cancellationPolicyView'"), 0x7f10040d, "field 'cancellationPolicyView'");
        marketratepurchase.viewTerms = (TextView)ewbinder.wTerms((View)ewbinder.View(obj, 0x7f1002d1, "field 'viewTerms'"), 0x7f1002d1, "field 'viewTerms'");
        marketratepurchase.bottomBar = (View)ewbinder.View(obj, 0x7f1000a0, "field 'bottomBar'");
        marketratepurchase.submit = (SpinnerButton)ewbinder.mit((View)ewbinder.View(obj, 0x7f100102, "field 'submit'"), 0x7f100102, "field 'submit'");
        marketratepurchase.bottomBarText = (TextView)ewbinder.tomBarText((View)ewbinder.View(obj, 0x7f100111, "field 'bottomBarText'"), 0x7f100111, "field 'bottomBarText'");
        marketratepurchase.guestName = (TextView)ewbinder.stName((View)ewbinder.View(obj, 0x7f100406, "field 'guestName'"), 0x7f100406, "field 'guestName'");
        marketratepurchase.guestNameContainer = (RelativeLayout)ewbinder.stNameContainer((View)ewbinder.View(obj, 0x7f100405, "field 'guestNameContainer'"), 0x7f100405, "field 'guestNameContainer'");
        marketratepurchase.liveChatView = (LiveChatView)ewbinder.eChatView((View)ewbinder.View(obj, 0x7f1002cf, "field 'liveChatView'"), 0x7f1002cf, "field 'liveChatView'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponNavigationDrawerActivity grouponnavigationdraweractivity, Object obj)
    {
        bind(ewbinder, (MarketRatePurchase)grouponnavigationdraweractivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (MarketRatePurchase)obj, obj1);
    }

    public volatile void unbind(GrouponFragmentActivity grouponfragmentactivity)
    {
        unbind((MarketRatePurchase)grouponfragmentactivity);
    }

    public void unbind(MarketRatePurchase marketratepurchase)
    {
        super.unbind(marketratepurchase);
        marketratepurchase.scroller = null;
        marketratepurchase.scrollableContent = null;
        marketratepurchase.titleGradientContainer = null;
        marketratepurchase.hotelImageView = null;
        marketratepurchase.titleView = null;
        marketratepurchase.locationView = null;
        marketratepurchase.roomDetailsContainer = null;
        marketratepurchase.reervationContainer = null;
        marketratepurchase.paymentDetailsContainer = null;
        marketratepurchase.grouponBucksView = null;
        marketratepurchase.gBucksValue = null;
        marketratepurchase.cancellationPolicyContainer = null;
        marketratepurchase.roomCancellationPolicyView = null;
        marketratepurchase.cancellationPolicyView = null;
        marketratepurchase.viewTerms = null;
        marketratepurchase.bottomBar = null;
        marketratepurchase.submit = null;
        marketratepurchase.bottomBarText = null;
        marketratepurchase.guestName = null;
        marketratepurchase.guestNameContainer = null;
        marketratepurchase.liveChatView = null;
    }

    public volatile void unbind(GrouponNavigationDrawerActivity grouponnavigationdraweractivity)
    {
        unbind((MarketRatePurchase)grouponnavigationdraweractivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((MarketRatePurchase)obj);
    }

    public nder()
    {
    }
}
