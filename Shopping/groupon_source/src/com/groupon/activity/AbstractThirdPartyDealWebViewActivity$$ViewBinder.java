// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            AbstractThirdPartyDealWebViewActivity, BaseWebViewActivity, GrouponActivity

public class  extends 
{

    public void bind(butterknife.ewBinder ewbinder, AbstractThirdPartyDealWebViewActivity abstractthirdpartydealwebviewactivity, Object obj)
    {
        super.(ewbinder, abstractthirdpartydealwebviewactivity, obj);
        abstractthirdpartydealwebviewactivity.toolbar = (Toolbar)ewbinder.lbar((View)ewbinder.lbar(obj, 0x7f100180, "field 'toolbar'"), 0x7f100180, "field 'toolbar'");
        abstractthirdpartydealwebviewactivity.pageTitle = (TextView)ewbinder.eTitle((View)ewbinder.eTitle(obj, 0x7f1002c4, "field 'pageTitle'"), 0x7f1002c4, "field 'pageTitle'");
        abstractthirdpartydealwebviewactivity.closeButton = (ImageView)ewbinder.seButton((View)ewbinder.seButton(obj, 0x7f100214, "field 'closeButton'"), 0x7f100214, "field 'closeButton'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, BaseWebViewActivity basewebviewactivity, Object obj)
    {
        bind(ewbinder, (AbstractThirdPartyDealWebViewActivity)basewebviewactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (AbstractThirdPartyDealWebViewActivity)grouponactivity, obj);
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (AbstractThirdPartyDealWebViewActivity)obj, obj1);
    }

    public void unbind(AbstractThirdPartyDealWebViewActivity abstractthirdpartydealwebviewactivity)
    {
        super.bind(abstractthirdpartydealwebviewactivity);
        abstractthirdpartydealwebviewactivity.toolbar = null;
        abstractthirdpartydealwebviewactivity.pageTitle = null;
        abstractthirdpartydealwebviewactivity.closeButton = null;
    }

    public volatile void unbind(BaseWebViewActivity basewebviewactivity)
    {
        unbind((AbstractThirdPartyDealWebViewActivity)basewebviewactivity);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((AbstractThirdPartyDealWebViewActivity)grouponactivity);
    }

    public volatile void unbind(Object obj)
    {
        unbind((AbstractThirdPartyDealWebViewActivity)obj);
    }

    public ()
    {
    }
}
