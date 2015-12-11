// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.view.WobbleSpaceshipCatView;

// Referenced classes of package com.groupon.activity:
//            ThirdPartyLinkoutDealWebViewActivity, AbstractThirdPartyDealWebViewActivity, BaseWebViewActivity, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, AbstractThirdPartyDealWebViewActivity abstractthirdpartydealwebviewactivity, Object obj)
    {
        bind(ewbinder, (ThirdPartyLinkoutDealWebViewActivity)abstractthirdpartydealwebviewactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, BaseWebViewActivity basewebviewactivity, Object obj)
    {
        bind(ewbinder, (ThirdPartyLinkoutDealWebViewActivity)basewebviewactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (ThirdPartyLinkoutDealWebViewActivity)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, ThirdPartyLinkoutDealWebViewActivity thirdpartylinkoutdealwebviewactivity, Object obj)
    {
        super.bind(ewbinder, thirdpartylinkoutdealwebviewactivity, obj);
        thirdpartylinkoutdealwebviewactivity.loadingCat = (LinearLayout)ewbinder.dingCat((View)ewbinder.dingCat(obj, 0x7f1003df, "field 'loadingCat'"), 0x7f1003df, "field 'loadingCat'");
        thirdpartylinkoutdealwebviewactivity.wobbleSpaceshipCatView = (WobbleSpaceshipCatView)ewbinder.bleSpaceshipCatView((View)ewbinder.bleSpaceshipCatView(obj, 0x7f1003e1, "field 'wobbleSpaceshipCatView'"), 0x7f1003e1, "field 'wobbleSpaceshipCatView'");
        thirdpartylinkoutdealwebviewactivity.loadingTitle = (TextView)ewbinder.dingTitle((View)ewbinder.dingTitle(obj, 0x7f1003e3, "field 'loadingTitle'"), 0x7f1003e3, "field 'loadingTitle'");
        thirdpartylinkoutdealwebviewactivity.loadingContent = (TextView)ewbinder.dingContent((View)ewbinder.dingContent(obj, 0x7f1003e4, "field 'loadingContent'"), 0x7f1003e4, "field 'loadingContent'");
        thirdpartylinkoutdealwebviewactivity.pageUrl = (TextView)ewbinder.eUrl((View)ewbinder.eUrl(obj, 0x7f1003d6, "field 'pageUrl'"), 0x7f1003d6, "field 'pageUrl'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (ThirdPartyLinkoutDealWebViewActivity)obj, obj1);
    }

    public volatile void unbind(AbstractThirdPartyDealWebViewActivity abstractthirdpartydealwebviewactivity)
    {
        unbind((ThirdPartyLinkoutDealWebViewActivity)abstractthirdpartydealwebviewactivity);
    }

    public volatile void unbind(BaseWebViewActivity basewebviewactivity)
    {
        unbind((ThirdPartyLinkoutDealWebViewActivity)basewebviewactivity);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((ThirdPartyLinkoutDealWebViewActivity)grouponactivity);
    }

    public void unbind(ThirdPartyLinkoutDealWebViewActivity thirdpartylinkoutdealwebviewactivity)
    {
        super.unbind(thirdpartylinkoutdealwebviewactivity);
        thirdpartylinkoutdealwebviewactivity.loadingCat = null;
        thirdpartylinkoutdealwebviewactivity.wobbleSpaceshipCatView = null;
        thirdpartylinkoutdealwebviewactivity.loadingTitle = null;
        thirdpartylinkoutdealwebviewactivity.loadingContent = null;
        thirdpartylinkoutdealwebviewactivity.pageUrl = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((ThirdPartyLinkoutDealWebViewActivity)obj);
    }

    public ()
    {
    }
}
