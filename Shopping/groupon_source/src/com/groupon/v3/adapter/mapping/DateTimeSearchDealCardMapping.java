// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.adapter.mapping;

import android.view.View;
import com.groupon.db.models.DealSummary;
import com.groupon.fragment.RapiSearchResultDomainModelFacade;
import com.groupon.util.AppStartupImageLoadListener;
import com.groupon.v3.adapter.UniversalListAdapter;
import com.groupon.v3.view.callbacks.DealCallbacks;
import com.groupon.v3.view.callbacks.DealCardBookingsViewHandler;
import com.groupon.v3.view.param.DealInfo;
import com.groupon.view.dealcards.DealCardBase;

// Referenced classes of package com.groupon.v3.adapter.mapping:
//            DefaultLargeDealCardMapping

public class DateTimeSearchDealCardMapping extends DefaultLargeDealCardMapping
{

    private RapiSearchResultDomainModelFacade domainModelFacade;

    public DateTimeSearchDealCardMapping(RapiSearchResultDomainModelFacade rapisearchresultdomainmodelfacade)
    {
        domainModelFacade = rapisearchresultdomainmodelfacade;
    }

    public void bindView(int i, android.support.v7.widget.RecyclerView.ViewHolder viewholder, UniversalListAdapter universallistadapter)
    {
        DealCardBase dealcardbase = (DealCardBase)viewholder.itemView;
        DealCardBookingsViewHandler dealcardbookingsviewhandler = (DealCardBookingsViewHandler)getCallback(com/groupon/v3/view/callbacks/DealCallbacks);
        dealcardbase.setPillsCallback(dealcardbookingsviewhandler);
        dealcardbase.setRapiSearchResultDomainModelFacade(domainModelFacade);
        universallistadapter = (DealSummary)universallistadapter.getItem(i);
        if (appStartupImageLoadListener != null)
        {
            appStartupImageLoadListener.assignToViews((DealCardBase)viewholder.itemView);
        }
        universallistadapter.putAttr("is_show_badge_ab_test_on", Boolean.valueOf(isShowBadge));
        ((DealCardBase)(DealCardBase)viewholder.itemView).setInfoWithPlace(universallistadapter, currentPlace);
        dealcardbookingsviewhandler.setSelectedPillsStartAt(dealcardbase.getShowedTimePills());
        dealcardbookingsviewhandler.onDealBound(new DealInfo(universallistadapter));
        viewholder.itemView.setTag(0x7f100001, universallistadapter);
    }
}
