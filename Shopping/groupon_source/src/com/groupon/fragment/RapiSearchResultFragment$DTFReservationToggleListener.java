// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.Channel;
import com.groupon.callbacks.OnToggleListener;
import com.groupon.models.nst.DTFGenericMetadata;
import com.groupon.util.LoggingUtils;
import com.groupon.view.HeaderToggle;
import com.groupon.view.HeaderTogglePresenter;

// Referenced classes of package com.groupon.fragment:
//            RapiSearchResultFragment, RapiSearchResultFragmentPresenter

private class <init>
    implements OnToggleListener
{

    final RapiSearchResultFragment this$0;

    public void onToggle(boolean flag)
    {
        RapiSearchResultFragment.access$100(RapiSearchResultFragment.this).toggleReservation(flag);
        DTFGenericMetadata dtfgenericmetadata = new DTFGenericMetadata();
        dtfgenericmetadata.type = RapiSearchResultFragment.access$100(RapiSearchResultFragment.this).getCategoryIntent()._mth0();
        String s;
        if (flag)
        {
            s = "on";
        } else
        {
            s = "off";
        }
        dtfgenericmetadata.state = s;
        loggingUtils.logImpression("", "bookable_toggle", Channel.GLOBAL_SEARCH.name(), "", dtfgenericmetadata);
        headerToggle.getPresenter().setEnabled(false);
        loggingUtils.logClickWithMetadata("", "bookable_toggle", Channel.GLOBAL_SEARCH.name(), dtfgenericmetadata);
        RapiSearchResultFragment.access$100(RapiSearchResultFragment.this).reloadDeals();
    }

    private ()
    {
        this$0 = RapiSearchResultFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
