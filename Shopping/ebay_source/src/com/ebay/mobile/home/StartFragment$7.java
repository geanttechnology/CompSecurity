// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.content.Intent;
import android.view.View;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.home.cards.BuyingOverviewModel;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import java.lang.ref.WeakReference;

// Referenced classes of package com.ebay.mobile.home:
//            StartFragment

class this._cls0
    implements com.ebay.mobile.common.view.kListener
{

    final StartFragment this$0;

    public void onClick(View view, ViewModel viewmodel)
    {
        android.app.Activity activity = getActivity();
        int i = view.getId();
        SourceIdentification sourceidentification = new SourceIdentification("HomePage", "buyingoverview", "activity");
        if (view.getId() == 0x7f100226)
        {
            view = MyEbayLandingActivity.getBuyingActivityIntent(activity, com.ebay.mobile.activities.ivity.BuyingTarget.BIDS);
            view.setFlags(0x24000000);
            view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
            StartFragment.access$700(StartFragment.this, activity, view, true);
        } else
        {
            if (i == 0x7f100227)
            {
                view = MyEbayLandingActivity.getBuyingActivityIntent(activity, com.ebay.mobile.activities.ivity.BuyingTarget.OFFERS);
                view.setFlags(0x24000000);
                view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                StartFragment.access$700(StartFragment.this, activity, view, true);
                return;
            }
            if (i == 0x7f100228)
            {
                view = MyEbayLandingActivity.getBuyingActivityIntent(activity, com.ebay.mobile.activities.ivity.BuyingTarget.WON);
                view.setFlags(0x24000000);
                view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                StartFragment.access$700(StartFragment.this, activity, view, true);
                return;
            }
            if (i == 0x7f100229 && (viewmodel instanceof BuyingOverviewModel))
            {
                if (((BuyingOverviewModel)viewmodel).record.emptyBuying)
                {
                    if (StartFragment.access$600(StartFragment.this) != null)
                    {
                        view = getActivity();
                        if (view != null)
                        {
                            (new TrackingData("StartShopping", TrackingType.EVENT)).send(view);
                        }
                        view = (artChannelHost)StartFragment.access$600(StartFragment.this).get();
                        if (view != null)
                        {
                            view.navigateToChannel(ChannelEnum.SHOP, true, true);
                            return;
                        }
                    }
                } else
                {
                    view = MyEbayLandingActivity.getBuyingActivityIntent(activity);
                    view.setFlags(0x24000000);
                    view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                    StartFragment.access$700(StartFragment.this, activity, view, true);
                    return;
                }
            }
        }
    }

    ()
    {
        this$0 = StartFragment.this;
        super();
    }
}
