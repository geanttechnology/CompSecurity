// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.Endpoint;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.fragment.DealSubsetFragment;
import com.groupon.fragment.PartitionedDealSubsetFragment;
import com.groupon.service.DeepLinkManager;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity

public class DealSubsetActivity extends GrouponFragmentActivity
{

    private static final String ALL_DEALS = "all_deals";
    private DeepLinkManager deepLinkManager;
    private DeepLinkUtil deepLinkUtil;
    int numDealSubsetActivitiesOnStack;
    Channel originatingChannel;
    String partialDealSubsetUrl;
    SharedPreferences prefs;
    String slotId;
    String subsetId;
    String title;
    String widgetCampaign;
    String widgetRequestId;
    String widgetScenarioId;
    String widgetTreatment;

    public DealSubsetActivity()
    {
        numDealSubsetActivitiesOnStack = 0;
    }

    public Channel getOriginatingChannel()
    {
        return originatingChannel;
    }

    public String getWidgetCampaign()
    {
        return widgetCampaign;
    }

    public String getWidgetRequestId()
    {
        return widgetRequestId;
    }

    public String getWidgetScenarioId()
    {
        return widgetScenarioId;
    }

    public String getWidgetTreatment()
    {
        return widgetTreatment;
    }

    protected boolean hasCartIcon()
    {
        return true;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(title);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030202);
        setProgressBarIndeterminateVisibility(false);
        bundle = getFragmentManager();
        if (bundle.findFragmentById(0x7f100171) != null) goto _L2; else goto _L1
_L1:
        Object obj;
        FragmentTransaction fragmenttransaction;
        boolean flag1;
        fragmenttransaction = bundle.beginTransaction();
        obj = new Bundle();
        numDealSubsetActivitiesOnStack = numDealSubsetActivitiesOnStack + 1;
        ((Bundle) (obj)).putString("partial_deal_subset_url", partialDealSubsetUrl);
        ((Bundle) (obj)).putString("subset_id", subsetId);
        ((Bundle) (obj)).putParcelable("originating_channel", originatingChannel);
        ((Bundle) (obj)).putString("tracking", "all_deals");
        ((Bundle) (obj)).putString("slot_id", slotId);
        ((Bundle) (obj)).putInt("num_deal_subset_activities_on_stack", numDealSubsetActivitiesOnStack);
        flag1 = false;
        if (!deepLinkUtil.isDeepLink(partialDealSubsetUrl)) goto _L4; else goto _L3
_L3:
        ((Bundle) (obj)).putParcelable("channel", Channel.DEAL_SUBSET_SEARCH);
        bundle = deepLinkUtil.getDeepLink(partialDealSubsetUrl);
        boolean flag = flag1;
        boolean flag2;
        if (!deepLinkManager.isDirectlyFollowable(bundle))
        {
            break MISSING_BLOCK_LABEL_188;
        }
        flag2 = bundle.getEndpoint().equals(Endpoint.WIDGETS);
        flag = flag1;
        if (flag2)
        {
            flag = true;
        }
_L6:
        if (!flag)
        {
            bundle = com/groupon/fragment/DealSubsetFragment.getName();
            obj = DealSubsetFragment.instantiate(this, bundle, ((Bundle) (obj)));
        } else
        {
            bundle = com/groupon/fragment/PartitionedDealSubsetFragment.getName();
            obj = PartitionedDealSubsetFragment.instantiate(this, bundle, ((Bundle) (obj)));
        }
        ((Fragment) (obj)).setHasOptionsMenu(true);
        fragmenttransaction.setCustomAnimations(0x10b0000, 0x10b0001);
        fragmenttransaction.replace(0x7f100171, ((Fragment) (obj)), bundle);
        fragmenttransaction.commitAllowingStateLoss();
_L2:
        return;
_L4:
        ((Bundle) (obj)).putParcelable("channel", Channel.ALLDEALS);
        flag = flag1;
        continue; /* Loop/switch isn't completed */
        bundle;
        flag = flag1;
        if (true) goto _L6; else goto _L5
_L5:
    }
}
