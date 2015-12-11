// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.LoaderManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListAdapter;
import com.groupon.Channel;
import com.groupon.activity.DealSubsetActivity;
import com.groupon.activity.IntentFactory;
import com.groupon.adapter.VpsAdapter;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.WidgetSummary;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.loader.WidgetsForDeeplinkLoaderCallbacks;
import com.groupon.manager.WidgetsOnDealSubsetFragmentSyncManager;
import com.groupon.service.DeepLinkManager;
import com.groupon.util.DealCardMultiColumnListAdapter;
import com.groupon.util.LoggingUtils;
import com.groupon.util.PendingAdapterWrapper;
import com.groupon.view.DealSetCallbacks;
import commonlib.adapter.JavaListAdapter;
import commonlib.adapter.PendingAdapterInterface;
import commonlib.manager.SyncManager;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            AbstractDealsAndWidgetsBaseFragment

public class PartitionedDealSubsetFragment extends AbstractDealsAndWidgetsBaseFragment
    implements DealSetCallbacks
{

    private static final int DEFAULT_DEAL_SUBSET_ACTIVITIES_ON_STACK = 3;
    private static final int MAX_DEAL_SUBSET_ACTIVITIES_ON_STACK = 5;
    private static final int MIN_DEAL_SUBSET_ACTIVITIES_ON_STACK = 1;
    private String dbChannel;
    private DeepLinkUtil deepLinkUtil;
    private boolean hideWidgetSubsetNavigation;
    private int numDealSubsetActivitiesOnStack;
    private Channel originatingChannel;
    private String partialDealSubsetUrl;
    private PendingAdapterWrapper pendingAdapterWrapper;
    private String slotId;
    private WidgetsOnDealSubsetFragmentSyncManager syncManager;
    private FilterableWidgetListAdapter widgetListAdapter;

    public PartitionedDealSubsetFragment()
    {
        super(Channel.ALLDEALS);
        numDealSubsetActivitiesOnStack = 0;
        hideWidgetSubsetNavigation = false;
    }

    protected boolean checkIfShouldHideWidgetSubsetNavigation(int i)
    {
        return i >= Math.min(Math.max(1, 3), 5);
    }

    public void configureSyncManager()
    {
        partialDealSubsetUrl = getArguments().getString("partial_deal_subset_url");
        dbChannel = Channel.encodePath(new String[] {
            Channel.ALLDEALS.name(), Strings.md5(partialDealSubsetUrl), "WIDGETS"
        });
        syncManager.configure(partialDealSubsetUrl, Channel.ALLDEALS.name(), dbChannel, getOriginatingNstChannel().toString());
    }

    public PendingAdapterInterface getAppendingAdapter()
    {
        return pendingAdapterWrapper;
    }

    public SyncManager getBaseSyncManager()
    {
        return getSyncManager();
    }

    public Channel getChannelNameForDealDetails()
    {
        Channel channel = Channel.channelForNstChannel(getNstChannel());
        if (channel != null)
        {
            return channel;
        } else
        {
            return Channel.DEAL_SUBSET_MM;
        }
    }

    protected String getNstChannel()
    {
        return getOriginatingNstChannel().toString();
    }

    protected void getOnSubsetClickedExtras(Bundle bundle)
    {
        bundle.putInt("num_deal_subset_activities_on_stack", numDealSubsetActivitiesOnStack);
    }

    public Channel getOriginatingNstChannel()
    {
        Channel channel = ((DealSubsetActivity)getActivity()).getOriginatingChannel();
        if (channel != null)
        {
            return channel;
        } else
        {
            return Channel.DEAL_SUBSET_MM;
        }
    }

    public WidgetsOnDealSubsetFragmentSyncManager getSyncManager()
    {
        return syncManager;
    }

    protected String getWidgetNstChannelName()
    {
        return Channel.DEAL_SUBSET_MM.toString();
    }

    public void initLoader(JavaListAdapter javalistadapter)
    {
        getLoaderManager().initLoader(0, null, new WidgetsForDeeplinkLoaderCallbacks(getActivity(), javalistadapter, dbChannel, pendingAdapterWrapper));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setUpRefreshListener();
        configureSyncManager();
        loggingUtils.setRequiresRedirectLogging(false);
        widgetListAdapter = new FilterableWidgetListAdapter(getActivity(), this, null, null, loggingUtils, "INVALID_KEYSTRING", getOriginatingNstChannel(), hideWidgetSubsetNavigation, new String[] {
            slotId
        });
        boolean flag;
        if (originatingChannel == Channel.POST_PURCHASE)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        widgetListAdapter.setWidgetsAdapterOnThankYouScreen(flag);
        widgetListAdapter.setRequiresRedirectLogging(false);
        pendingAdapterWrapper = new PendingAdapterWrapper(widgetListAdapter);
        setListAdapter(new VpsAdapter(new DealCardMultiColumnListAdapter(pendingAdapterWrapper, 1) {

            final PartitionedDealSubsetFragment this$0;

            public void onDealCardClicked(int i, View view, DealSummary dealsummary)
            {
                PartitionedDealSubsetFragment.this.onDealCardClicked(i, view, dealsummary);
            }

            public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
            {
                onMemberClick(view, dealsummary);
            }

            
            {
                this$0 = PartitionedDealSubsetFragment.this;
                super(listadapter, i);
            }
        }));
        initLoader(widgetListAdapter);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        bundle = getArguments();
        if (bundle != null)
        {
            numDealSubsetActivitiesOnStack = bundle.getInt("num_deal_subset_activities_on_stack");
            slotId = bundle.getString("slot_id");
            originatingChannel = (Channel)bundle.getParcelable("originating_channel");
        }
        if (!Strings.isEmpty(slotId)) goto _L2; else goto _L1
_L1:
        slotId = "topSlot";
_L4:
        hideWidgetSubsetNavigation = checkIfShouldHideWidgetSubsetNavigation(numDealSubsetActivitiesOnStack);
        return;
_L2:
        if (!slotId.equals("CAVSlot"))
        {
            break; /* Loop/switch isn't completed */
        }
        bundle = "CAV";
_L5:
        loggingUtils.logThankYouDealSubsetPageView(bundle);
        if (true) goto _L4; else goto _L3
_L3:
        if (slotId.equals("CABSlot"))
        {
            bundle = "CAB";
        } else
        {
            bundle = "RVD";
        }
          goto _L5
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void onMemberClick(View view, DealSummary dealsummary)
    {
        onWidgetDealCardClicked(view, dealsummary);
    }

    public void onSubsetClick(WidgetSummary widgetsummary)
    {
        loggingUtils.logDealSubsetClick(widgetsummary, getWidgetNstChannelName());
        Object obj = widgetsummary.moreAssetsDealsUrl;
        if (deepLinkUtil.isDeepLink(((String) (obj))))
        {
            try
            {
                widgetsummary = deepLinkUtil.getDeepLink(((String) (obj)));
                obj = new Bundle();
                ((Bundle) (obj)).putParcelable("originating_channel", getOriginatingNstChannel());
                getOnSubsetClickedExtras(((Bundle) (obj)));
                deepLinkManager.followDeepLink(getActivity(), widgetsummary, ((Bundle) (obj)));
                return;
            }
            // Misplaced declaration of an exception variable
            catch (WidgetSummary widgetsummary)
            {
                startActivity(((IntentFactory)intentFactory.get()).newCarouselIntent());
            }
            return;
        } else
        {
            startActivity(((IntentFactory)intentFactory.get()).newDealSubsetIntent(widgetsummary, channel));
            return;
        }
    }

    public void onWidgetDealCardClicked(View view, DealSummary dealsummary)
    {
        view = dealsummary.parentWidgetSummary.type;
        if (view.equals("MegamindWatsonRecentlyViewedDeals_Android") || view.equals("MegamindCustomersAlsoBought") || view.equals("MegamindCustomersAlsoViewedMobile"))
        {
            loggingUtils.logThankYouWidgetDealClick(dealsummary, getWidgetNstChannelName(), getActivity().getClass().getSimpleName());
        } else
        {
            loggingUtils.logWidgetDealClick(dealsummary, getWidgetNstChannelName());
        }
        startActivity(((IntentFactory)intentFactory.get()).nextActivityFromWidgetDealClick(dealsummary, getChannelNameForDealDetails()));
    }
}
