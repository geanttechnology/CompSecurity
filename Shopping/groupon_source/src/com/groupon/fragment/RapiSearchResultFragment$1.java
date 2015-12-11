// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.view.View;
import com.groupon.Channel;
import com.groupon.models.nst.DTFGenericMetadata;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultFragment, RapiSearchResultFragmentPresenter, RapiSearchResultDomainModelFacade

class this._cls0
    implements android.view.gment._cls1
{

    final RapiSearchResultFragment this$0;

    public void onClick(View view)
    {
        view = new DTFGenericMetadata();
        view.type = RapiSearchResultFragment.access$100(RapiSearchResultFragment.this).getCategoryIntent().toTrackingString();
        view.date = RapiSearchResultFragment.access$100(RapiSearchResultFragment.this).getDomainModelFacade().getReservationDateFormatted();
        view.time = RapiSearchResultFragment.access$100(RapiSearchResultFragment.this).getDomainModelFacade().getReservationTimeFormatted();
        if (RapiSearchResultFragment.access$100(RapiSearchResultFragment.this).isFoodAndDrinkIntent())
        {
            view.partysize = Integer.valueOf(RapiSearchResultFragment.access$100(RapiSearchResultFragment.this).getDomainModelFacade().getPartySize());
        } else
        {
            view.service = RapiSearchResultFragment.access$100(RapiSearchResultFragment.this).getDomainModelFacade().getServiceType();
        }
        loggingUtils.logClickWithMetadata("", "dtf_inputs", Channel.GLOBAL_SEARCH.name(), view);
        RapiSearchResultFragment.access$200(RapiSearchResultFragment.this);
    }

    Facade()
    {
        this$0 = RapiSearchResultFragment.this;
        super();
    }
}
