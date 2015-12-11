// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

// Referenced classes of package com.groupon.activity:
//            MarketRateThanks, GrouponActivity

public class  extends 
{

    public volatile void bind(butterknife.ewBinder ewbinder, GrouponActivity grouponactivity, Object obj)
    {
        bind(ewbinder, (MarketRateThanks)grouponactivity, obj);
    }

    public void bind(butterknife.ewBinder ewbinder, MarketRateThanks marketratethanks, Object obj)
    {
        super.ind(ewbinder, marketratethanks, obj);
        marketratethanks.topLogo = (ImageView)ewbinder.Logo((View)ewbinder.alView(obj, 0x7f100545, null), 0x7f100545, "field 'topLogo'");
        marketratethanks.title = (TextView)ewbinder.le((View)ewbinder.alView(obj, 0x7f10055b, null), 0x7f10055b, "field 'title'");
        marketratethanks.subtitle = (TextView)ewbinder.title((View)ewbinder.alView(obj, 0x7f10055c, null), 0x7f10055c, "field 'subtitle'");
        marketratethanks.shareButton = (Button)ewbinder.reButton((View)ewbinder.alView(obj, 0x7f10055d, null), 0x7f10055d, "field 'shareButton'");
        marketratethanks.myGrouponsButton = (Button)ewbinder.rouponsButton((View)ewbinder.alView(obj, 0x7f10055e, null), 0x7f10055e, "field 'myGrouponsButton'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (MarketRateThanks)obj, obj1);
    }

    public volatile void unbind(GrouponActivity grouponactivity)
    {
        unbind((MarketRateThanks)grouponactivity);
    }

    public void unbind(MarketRateThanks marketratethanks)
    {
        super.nbind(marketratethanks);
        marketratethanks.topLogo = null;
        marketratethanks.title = null;
        marketratethanks.subtitle = null;
        marketratethanks.shareButton = null;
        marketratethanks.myGrouponsButton = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((MarketRateThanks)obj);
    }

    public ()
    {
    }
}
