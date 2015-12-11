// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import com.groupon.Channel;
import com.groupon.adapter.OptionsAdapter;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.goods.shoppingcart.ShoppingCartPresenter;
import com.groupon.models.country.Country;
import com.groupon.models.nst.MultiOptionClickExtraInfo;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;
import com.groupon.util.LoginUtil;
import java.util.ArrayList;

// Referenced classes of package com.groupon.activity:
//            MultiOptionActivity, IntentFactory

class this._cls0
    implements android.widget.kListener
{

    final MultiOptionActivity this$0;

    public void onItemClick(AdapterView adapterview, View view, int i, long l)
    {
        view = MultiOptionActivity.access$100(MultiOptionActivity.this).getItem(i);
        Logger logger;
        if (MultiOptionActivity.access$200(MultiOptionActivity.this))
        {
            if (((Option) (view)).specificAttributeDelivery || ((Option) (view)).specificAttributeTakeout)
            {
                adapterview = "on";
            } else
            {
                adapterview = "off";
            }
        } else
        {
            adapterview = "";
        }
        MultiOptionActivity.this.logger.logMultiOption("", dealId, ((Option) (view)).remoteId, MultiOptionActivity.access$300(MultiOptionActivity.this).getOptions().size(), i, MultiOptionActivity.access$400(MultiOptionActivity.this).getMultiOptionExtraInfoString(adapterview, getPageViewId()));
        logger = MultiOptionActivity.this.logger;
        if (channel != null)
        {
            adapterview = channel.toString();
        } else
        {
            adapterview = "";
        }
        logger.logClick("", "deal_option_click", adapterview, Logger.NULL_NST_FIELD, new MultiOptionClickExtraInfo(getPageViewId(), defaultOptionId, ((Option) (view)).remoteId));
        if (next != null)
        {
            next.putExtra("optionId", ((Option) (view)).remoteId);
            next.putExtra("channel", channel);
            startActivity(next);
            return;
        }
        if (comingFromGifting)
        {
            MultiOptionActivity.access$500(MultiOptionActivity.this).startGiftingFlow(MultiOptionActivity.access$300(MultiOptionActivity.this), view, defaultOptionId, channel, isMobileOnly, false);
            return;
        }
        if (MultiOptionActivity.access$600(MultiOptionActivity.this))
        {
            MultiOptionActivity.access$700(MultiOptionActivity.this, false);
            MultiOptionActivity.access$800(MultiOptionActivity.this).addToCartAndOpen(MultiOptionActivity.access$300(MultiOptionActivity.this), view);
            return;
        }
        if (isMultiOptionSelection && !MultiOptionActivity.access$900(MultiOptionActivity.this).getCurrentCountry().isJapan())
        {
            startActivity(MultiOptionActivity.access$1000(MultiOptionActivity.this).newPurchaseLoginIntent(dealId, ((Option) (view)).remoteId, channel, isDeepLinked));
            finish();
            return;
        }
        if (MultiOptionActivity.access$300(MultiOptionActivity.this).isTravelBookableDeal && !MultiOptionActivity.access$900(MultiOptionActivity.this).getCurrentCountry().isJapan())
        {
            startActivity(MultiOptionActivity.access$1000(MultiOptionActivity.this).newCalendarBookingIntent(MultiOptionActivity.access$300(MultiOptionActivity.this), channel, ((Option) (view)).remoteId, checkInDate, checkOutDate, redirectToEnterCode));
            return;
        } else
        {
            adapterview = ((Option) (view)).externalUrl;
            MultiOptionActivity.access$1100(MultiOptionActivity.this, adapterview, MultiOptionActivity.access$300(MultiOptionActivity.this), view, channel);
            return;
        }
    }

    entCountryManager()
    {
        this$0 = MultiOptionActivity.this;
        super();
    }
}
