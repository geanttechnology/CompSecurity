// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.view.callbacks;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Pair;
import android.view.View;
import com.groupon.Channel;
import com.groupon.abtest.BadgesAbTestHelper;
import com.groupon.activity.IntentFactory;
import com.groupon.animation.ActivityTransitionUtils;
import com.groupon.db.models.Badge;
import com.groupon.db.models.DealSummary;
import com.groupon.models.country.Country;
import com.groupon.models.nst.DealImpressionMetadata;
import com.groupon.models.nst.ImpressionClickMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.EncodedNSTField;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;
import com.groupon.util.DealUtils;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.LoggingUtils;
import com.groupon.v3.view.param.DealCardClickInfo;
import com.groupon.view.dealcards.DealCardBase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.v3.view.callbacks:
//            DealCallbacks

public class DealCardViewHandler
    implements DealCallbacks
{

    public final String RIBBON = "ribbon";
    private AbTestService abTestService;
    private BadgesAbTestHelper badgesAbTestHelper;
    private BuyUtils buyUtil;
    private Channel channel;
    private CurrentCountryManager currentCountryManager;
    private IncentivesUtil incentivesUtil;
    private IntentFactory intentFactory;
    private boolean isShowBadgeOnFeaturedRapi1509USCA;
    private boolean isShowBadgeOnSearch1509USCA;
    private LoggingUtils loggingUtils;
    private String nstKeyString;

    public DealCardViewHandler(Context context, String s, Channel channel1)
    {
        RoboGuice.getInjector(context).injectMembers(this);
        nstKeyString = s;
        channel = channel1;
        isShowBadgeOnSearch1509USCA = badgesAbTestHelper.isShowBadgeOnSearch();
        isShowBadgeOnFeaturedRapi1509USCA = badgesAbTestHelper.isShowBadgeOnFeaturedRapi();
    }

    public boolean checkForAndStartGoodsMultiOptionActivity(Context context, DealSummary dealsummary)
    {
        int i;
        boolean flag;
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = dealsummary.optionDimensionsCount(flag, currentCountryManager.getCurrentCountry().isUSACompatible());
        if (buyUtil.showOptionsWithImages(dealsummary, context))
        {
            context.startActivity(intentFactory.newGoodsMultiOptionIntent(dealsummary.remoteId, channel, i));
            return true;
        } else
        {
            return false;
        }
    }

    protected void fillMetadataWithExtraInfo(DealCardClickInfo dealcardclickinfo, JsonEncodedNSTField jsonencodednstfield)
    {
label0:
        {
            dealcardclickinfo = dealcardclickinfo.getDealSummary();
            Iterator iterator;
            boolean flag;
            if (!DealUtils.isSoldOutOrClosed(dealcardclickinfo) && (isShowBadgeOnSearch1509USCA && Channel.GLOBAL_SEARCH.equals(channel) || isShowBadgeOnFeaturedRapi1509USCA && Channel.FEATURED.equals(channel)))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                break label0;
            }
            iterator = ((DealSummary) (dealcardclickinfo)).badges.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                dealcardclickinfo = (Badge)iterator.next();
            } while (!DealUtils.isBadgeValid(dealcardclickinfo));
            if (jsonencodednstfield instanceof DealImpressionMetadata)
            {
                jsonencodednstfield = (DealImpressionMetadata)jsonencodednstfield;
                jsonencodednstfield.badgeDisplayText = ((Badge) (dealcardclickinfo)).text;
                jsonencodednstfield.badgeType = ((Badge) (dealcardclickinfo)).badgeType;
            } else
            if (jsonencodednstfield instanceof ImpressionClickMetadata)
            {
                jsonencodednstfield = (ImpressionClickMetadata)jsonencodednstfield;
                jsonencodednstfield.badgeDisplayText = ((Badge) (dealcardclickinfo)).text;
                jsonencodednstfield.badgeType = ((Badge) (dealcardclickinfo)).badgeType;
                return;
            }
        }
    }

    public Intent getDealCardClickIntent(DealCardClickInfo dealcardclickinfo, View view)
    {
        view = ((DealCardBase)view).getImageViewSize();
        return intentFactory.newDealIntent(dealcardclickinfo.getDealSummary(), channel, view);
    }

    protected EncodedNSTField getExtraInfo(DealCardClickInfo dealcardclickinfo)
    {
        return Logger.NULL_NST_FIELD;
    }

    protected void logImpressionClick(DealCardClickInfo dealcardclickinfo)
    {
        Object obj = dealcardclickinfo.getDealSummary();
        ImpressionClickMetadata impressionclickmetadata = new ImpressionClickMetadata(((DealSummary) (obj)).remoteId, ((DealSummary) (obj)).uuid, ((DealSummary) (obj)).derivedTrackingPosition, "deal");
        fillMetadataWithExtraInfo(dealcardclickinfo, impressionclickmetadata);
        LoggingUtils loggingutils = loggingUtils;
        if (channel != null)
        {
            obj = channel.toString();
        } else
        {
            obj = "";
        }
        loggingutils.logClick("", "impression_click", ((String) (obj)), impressionclickmetadata, getExtraInfo(dealcardclickinfo));
    }

    public void onDealBound(DealCardClickInfo dealcardclickinfo)
    {
        DealSummary dealsummary = dealcardclickinfo.getDealSummary();
        DealImpressionMetadata dealimpressionmetadata = new DealImpressionMetadata(dealsummary.derivedPricingMetadataOfferType, incentivesUtil.getIncentivePromoCode(dealsummary), dealsummary.getDealStatus());
        fillMetadataWithExtraInfo(dealcardclickinfo, dealimpressionmetadata);
        loggingUtils.logDealImpressionV1(channel.toString(), "", dealsummary, dealsummary.derivedTrackingPosition, dealimpressionmetadata, nstKeyString, abTestService, true, false, true);
    }

    public void onDealClick(View view, DealCardClickInfo dealcardclickinfo)
    {
        if (dealcardclickinfo != null && dealcardclickinfo.getDealSummary() != null)
        {
            DealSummary dealsummary = dealcardclickinfo.getDealSummary();
            Context context = view.getContext();
            logImpressionClick(dealcardclickinfo);
            if (!checkForAndStartGoodsMultiOptionActivity(context, dealsummary))
            {
                Object obj = view.findViewById(0x7f100121);
                View view1 = view.findViewById(0x7f100230);
                ArrayList arraylist = new ArrayList();
                arraylist.add(Pair.create(obj, "deal_image_transition"));
                if (view1.getVisibility() == 0)
                {
                    arraylist.add(Pair.create(view1, "sold_out_banner_transition"));
                }
                if (android.os.Build.VERSION.SDK_INT >= 21)
                {
                    obj = ActivityTransitionUtils.getDealToDetailsActivityOptions((Activity)context, (Pair[])arraylist.toArray(new Pair[arraylist.size()]));
                } else
                {
                    obj = null;
                }
                context.startActivity(getDealCardClickIntent(dealcardclickinfo, view), ((android.os.Bundle) (obj)));
                return;
            }
        }
    }
}
