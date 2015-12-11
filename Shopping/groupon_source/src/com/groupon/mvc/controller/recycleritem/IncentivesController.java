// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.controller.recycleritem;

import android.content.Context;
import android.view.View;
import com.groupon.Channel;
import com.groupon.db.models.CommonOptions;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.models.nst.ClickExtraInfo;
import com.groupon.models.nst.ClickMetadata;
import com.groupon.mvc.model.Incentive;
import com.groupon.util.BuyUtils;
import com.groupon.util.DealUtils;
import com.groupon.util.IncentivesUtil;
import java.util.Date;
import java.util.Map;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.mvc.controller.recycleritem:
//            RecyclerItemViewController

public class IncentivesController extends RecyclerItemViewController
{
    private class OnIncentivesClickListener
        implements android.view.View.OnClickListener
    {

        final IncentivesController this$0;

        public void onClick(View view)
        {
            Object obj = new ClickMetadata();
            obj.dealId = deal.remoteId;
            ClickExtraInfo clickextrainfo = new ClickExtraInfo();
            clickextrainfo.buyAsGift = Boolean.valueOf(false);
            Map map;
            boolean flag;
            if (mobileOnly1403USCAEnabled && deal.getDisplayOption("platformExclusive", false))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            map = DealUtils.createOptionsByIdMap(deal);
            if (buyUtils.showOptionsWithImages(deal, context) && Strings.notEmpty(preselectedOptionId))
            {
                obj = buyUtils.getListenerForOptions(context, deal, (Option)map.get(preselectedOptionId), null, channel, flag, true, "enter_promo_code", "deal_details", ((com.groupon.tracking.mobile.EncodedNSTField) (obj)), clickextrainfo, isDeepLinked);
            } else
            if (canDisplayExposedMultiOptions && !deal.isTravelBookableDeal)
            {
                obj = buyUtils.getListenerForOptions(context, deal, option, null, channel, flag, true, "enter_promo_code", "deal_details", ((com.groupon.tracking.mobile.EncodedNSTField) (obj)), clickextrainfo, isDeepLinked);
            } else
            {
                boolean flag1;
                if (map.size() > 1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                obj = buyUtils.getListener(context, flag1, deal, channel, "enter_promo_code", "deal_details", ((com.groupon.tracking.mobile.EncodedNSTField) (obj)), checkInDate, checkOutDate, flag, true, false, isDeepLinked);
            }
            ((android.view.View.OnClickListener) (obj)).onClick(view);
        }

        private OnIncentivesClickListener()
        {
            this$0 = IncentivesController.this;
            super();
        }

    }


    private BuyUtils buyUtils;
    private boolean canDisplayExposedMultiOptions;
    private Channel channel;
    private Date checkInDate;
    private Date checkOutDate;
    private boolean comingFromMyGroupons;
    private Deal deal;
    private boolean dtfFlowEnabled;
    private IncentivesUtil incentivesUtil;
    private boolean isDeepLinked;
    private boolean mobileOnly1403USCAEnabled;
    private Option option;
    private String preselectedOptionId;

    public IncentivesController(Context context)
    {
        super(context);
    }

    private boolean isDtfExperienceEnabled()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (dtfFlowEnabled)
        {
            flag = flag1;
            if (DealUtils.isBookingEngineDeal(deal, false))
            {
                flag = true;
            }
        }
        return flag;
    }

    public android.view.View.OnClickListener getCallback()
    {
        return new OnIncentivesClickListener();
    }

    public volatile Object getCallback()
    {
        return getCallback();
    }

    public void processData()
    {
        boolean flag1 = true;
        Object obj;
        IncentivesUtil incentivesutil;
        Deal deal1;
        boolean flag;
        boolean flag2;
        if (option != null)
        {
            obj = option;
        } else
        {
            obj = deal;
        }
        flag = Strings.equalsIgnoreCase("closed", ((CommonOptions) (obj)).getStatus());
        incentivesutil = incentivesUtil;
        deal1 = deal;
        if (flag || ((CommonOptions) (obj)).isSoldOut())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj = incentivesutil.getIncentiveLongTitle(deal1, flag);
        flag2 = canDisplayExposedMultiOptions;
        if (Strings.isEmpty(obj) || comingFromMyGroupons)
        {
            setState(0);
            return;
        }
        model = new Incentive();
        ((Incentive)model).incentiveTitle = ((String) (obj));
        obj = (Incentive)model;
        if (incentivesUtil.getPromotionType(deal) == com.groupon.util.IncentivesUtil.PromotionType.PROMO_CODE && !isDtfExperienceEnabled())
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        obj.shouldDisplayEnterCode = flag;
        ((Incentive)model).displayTopSeparator = flag2;
        setState(2);
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

    public void setCheckInDate(Date date)
    {
        setState(1);
        checkInDate = date;
    }

    public void setCheckOutDate(Date date)
    {
        setState(1);
        checkOutDate = date;
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

    public void setDtfFlowEnabled(boolean flag)
    {
        setState(1);
        dtfFlowEnabled = flag;
    }

    public void setIsDeepLinked(boolean flag)
    {
        setState(1);
        isDeepLinked = flag;
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

    public void setPreselectedOptionId(String s)
    {
        setState(1);
        preselectedOptionId = s;
    }










}
