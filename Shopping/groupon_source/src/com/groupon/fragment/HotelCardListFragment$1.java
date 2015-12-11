// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import android.widget.ListAdapter;
import com.groupon.Channel;
import com.groupon.animation.ActivityTransitionUtils;
import com.groupon.db.models.MarketRateResult;
import com.groupon.models.nst.ImpressionClickMetadata;
import com.groupon.util.HotelsMultiColumnListAdapter;
import com.groupon.util.LoggingUtils;
import com.groupon.view.dealcards.HotelSmallDealCard;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            HotelCardListFragment

class  extends HotelsMultiColumnListAdapter
{

    final HotelCardListFragment this$0;

    public void onMarketRateDealCardClicked(int i, View view, MarketRateResult marketrateresult)
    {
        String s = marketrateresult.remoteId;
        LoggingUtils loggingutils = loggingUtils;
        Object obj;
        if (pagerChannel != null)
        {
            obj = pagerChannel.toString();
        } else
        {
            obj = "";
        }
        loggingutils.logClickWithMetadata("", "impression_click", ((String) (obj)), new ImpressionClickMetadata(s, "", i, "hotel"));
        obj = view.findViewById(0x7f100121);
        if (android.os.ickMetadata >= 21)
        {
            obj = ActivityTransitionUtils.getDealToDetailsActivityOptions(getActivity(), ((View) (obj)));
        } else
        {
            obj = null;
        }
        view = ((HotelSmallDealCard)((com.groupon.util.owItemWrapper)view).getWrappedView()).getImageViewSize();
        if (Strings.equalsIgnoreCase(marketrateresult.source, "HOTEL"))
        {
            view = HotelCardListFragment.access$000(HotelCardListFragment.this, marketrateresult, view);
        } else
        {
            view = HotelCardListFragment.access$100(HotelCardListFragment.this, marketrateresult, view);
        }
        startActivity(view, ((android.os.Bundle) (obj)));
    }

    (ListAdapter listadapter, int i)
    {
        this$0 = HotelCardListFragment.this;
        super(listadapter, i);
    }
}
