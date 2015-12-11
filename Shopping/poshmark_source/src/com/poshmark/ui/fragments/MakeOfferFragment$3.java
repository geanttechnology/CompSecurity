// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.ListingSummary;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.OfferFlowHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            MakeOfferFragment

class this._cls0
    implements android.view.
{

    final MakeOfferFragment this$0;

    public void onClick(View view)
    {
        if (MakeOfferFragment.access$000(MakeOfferFragment.this) != null && (MakeOfferFragment.access$000(MakeOfferFragment.this) instanceof OfferFlowHandler))
        {
            String s = offerText.getText().toString();
            if (MakeOfferFragment.access$100(MakeOfferFragment.this, s))
            {
                Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "offer_price_entered_next_tapped", MakeOfferFragment.access$000(MakeOfferFragment.this).getListingDetails().getIdAsString());
                PMContainerActivity pmcontaineractivity = (PMContainerActivity)getActivity();
                view.clearFocus();
                getActivity().getWindow().setSoftInputMode(2);
                MakeOfferFragment.access$200(MakeOfferFragment.this, s.substring(1));
            }
        }
    }

    ()
    {
        this$0 = MakeOfferFragment.this;
        super();
    }
}
