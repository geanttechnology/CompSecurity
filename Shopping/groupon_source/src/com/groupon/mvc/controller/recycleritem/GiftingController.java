// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.util.BuyUtils;
import com.groupon.util.DealUtils;
import com.groupon.util.LoggingUtils;
import com.groupon.util.LoginUtil;
import java.util.ArrayList;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class GiftingController extends RecyclerItemViewController
{
    private class OnGiftingClickListener
        implements android.view.View.OnClickListener
    {

        final GiftingController this$0;

        public void onClick(View view)
        {
            view = new ClickMetadata();
            view.dealId = deal.remoteId;
            ClickExtraInfo clickextrainfo = new ClickExtraInfo();
            clickextrainfo.buyAsGift = Boolean.valueOf(true);
            ClickExtraInfo clickextrainfo1 = new ClickExtraInfo();
            clickextrainfo1.pageId = pageViewId;
            loggingUtils.logClick("", "send_as_gift_click", channel.toString(), null, clickextrainfo1);
            loggingUtils.logClick("", "click_buy", channel.toString(), view, clickextrainfo);
            boolean flag;
            if (mobileOnly1403USCAEnabled && deal.getDisplayOption("platformExclusive", false))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!isMultiOptionDeal || Strings.notEmpty(preselectedOptionId) && buyUtils.showOptionsWithImages(deal, context) || canDisplayExposedMultiOptions)
            {
                loginUtil.startGiftingFlow(deal, option, preselectedOptionId, channel, flag, false);
                return;
            } else
            {
                view = intentFactory.newMultiOptionIntent(channel, deal.remoteId, null, null, flag, false, null);
                context.startActivity(view.putExtra("comingFromGifting", true).putExtra("dealId", deal.remoteId));
                return;
            }
        }

        private OnGiftingClickListener()
        {
            this$0 = GiftingController.this;
            super();
        }

    }


    public static final String COMING_FROM_GIFTING = "comingFromGifting";
    public static final String SEND_AS_GIFT_CLICK = "send_as_gift_click";
    private BuyUtils buyUtils;
    private boolean canDisplayExposedMultiOptions;
    private Channel channel;
    private boolean comingFromMyGroupons;
    private Deal deal;
    private IntentFactory intentFactory;
    private boolean isDealClosedOrSoldOut;
    private boolean isMultiOptionDeal;
    private LoggingUtils loggingUtils;
    private LoginUtil loginUtil;
    private boolean mobileOnly1403USCAEnabled;
    private Option option;
    private String pageViewId;
    private String preselectedOptionId;
    private boolean shouldAddGiftingButtonOnDealDetail;

    public GiftingController(Context context)
    {
        super(context);
    }

    public android.view.View.OnClickListener getCallback()
    {
        return new OnGiftingClickListener();
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public void processData()
    {
        boolean flag;
        boolean flag1;
        if (deal.getOptions().size() > 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        isMultiOptionDeal = flag1;
        if (DealUtils.isGiftableDeal(deal, DealUtils.hasExternalUrl(deal), isDealClosedOrSoldOut) && shouldAddGiftingButtonOnDealDetail && !comingFromMyGroupons)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            setState(0);
            return;
        } else
        {
            setState(2);
            return;
        }
    }

    public void setCanDisplayExposedMultiOptions(boolean flag)
    {
        setState(1);
        canDisplayExposedMultiOptions = flag;
    }

    public void setChannel(Channel channel1)
    {
        setState(1);
        channel = channel1;
    }

    public void setComingFromMyGroupons(boolean flag)
    {
        setState(1);
        comingFromMyGroupons = flag;
    }

    public void setDeal(Deal deal1)
    {
        setState(1);
        deal = deal1;
    }

    public void setIsDealClosedOrSoldOut(boolean flag)
    {
        setState(1);
        isDealClosedOrSoldOut = flag;
    }

    public void setMobileOnly1403USCAEnabled(boolean flag)
    {
        setState(1);
        mobileOnly1403USCAEnabled = flag;
    }

    public void setOption(Option option1)
    {
        setState(1);
        option = option1;
    }

    public void setPageViewId(String s)
    {
        setState(1);
        pageViewId = s;
    }

    public void setPreselectedOptionId(String s)
    {
        setState(1);
        preselectedOptionId = s;
    }

    public void setShouldAddGiftingButtonOnDealDetail(boolean flag)
    {
        setState(1);
        shouldAddGiftingButtonOnDealDetail = flag;
    }












}
