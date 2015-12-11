// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.groupon.Channel;
import com.groupon.activity.Carousel;
import com.groupon.adapter.ImagePrefetchAdapterHelper;
import com.groupon.adapter.VpsAdapter;
import com.groupon.db.models.AbstractDeal;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.models.nst.DealImpressionMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.core.AbTestService;
import com.groupon.util.DealCardListUtils;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.IncentivesUtil;
import com.groupon.util.ScrollToolBarHelper;
import commonlib.adapter.JavaListAdapter;
import commonlib.manager.PaginatedSyncManager;
import commonlib.manager.SyncManager;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            AbstractDealsAndWidgetsBaseFragment, DealCardEndlessAdapter

public abstract class BaseCardListFragment extends AbstractDealsAndWidgetsBaseFragment
    implements DealsAndMyGrouponsBaseEndlessAdapter.PaginatedSyncManagerProvider, com.groupon.util.ScrollToolBarHelper.OnToolBarInitializeListener
{

    protected DealCardEndlessAdapter dealCardEndlessAdapter;
    private DealCardListUtils dealCardListUtils;
    protected DeviceInfoUtil deviceInfoUtil;
    protected boolean disableScrollHelper;
    protected View headerView;
    protected ImagePrefetchAdapterHelper imagePrefetchAdapterHelper;
    protected IncentivesUtil incentivesUtil;
    protected String pagerChannelAndSubchannel;
    protected ScrollToolBarHelper scrollToolBarHelper;

    public BaseCardListFragment(Channel channel)
    {
        super(channel);
        disableScrollHelper = false;
        pagerChannelAndSubchannel = channel.name();
    }

    public void configureSyncManager()
    {
    }

    protected View createHeaderView()
    {
        return null;
    }

    public SyncManager getBaseSyncManager()
    {
        return getSyncManager();
    }

    protected abstract View getCardView(ListAdapter listadapter, int i, View view, ViewGroup viewgroup);

    protected abstract DealCardEndlessAdapter getDealCardEndlessAdapter(BaseAdapter baseadapter, BaseCardListFragment basecardlistfragment);

    protected JsonEncodedNSTField getDealImpressionExtraInfo(AbstractDeal abstractdeal)
    {
        Object obj = JsonEncodedNSTField.NULL_JSON_NST_FIELD;
        if (abstractdeal != null)
        {
            obj = new DealImpressionMetadata(abstractdeal.derivedPricingMetadataOfferType, incentivesUtil.getIncentivePromoCode(abstractdeal), abstractdeal.getDealStatus());
        }
        return ((JsonEncodedNSTField) (obj));
    }

    public int getDealListColumns()
    {
        int i = activity.getResources().getInteger(0x7f0d0001);
        if (i > 1)
        {
            return i;
        } else
        {
            return getNonTabletDealListColumns();
        }
    }

    protected View getHeaderView()
    {
        if (headerView == null)
        {
            headerView = createHeaderView();
        }
        return headerView;
    }

    public int getNonTabletDealListColumns()
    {
        return 1;
    }

    protected List getPlaces()
    {
        return null;
    }

    public abstract AnyChannelSyncManager getSyncManager();

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    protected String getWidgetNstChannelName()
    {
        return Channel.UNKNOWN.toString();
    }

    public abstract void initLoader(JavaListAdapter javalistadapter);

    protected boolean isHeaderSelectable()
    {
        return false;
    }

    protected abstract void logDealImpression(String s, String s1, Object obj, int i, JsonEncodedNSTField jsonencodednstfield, String s2, AbTestService abtestservice, 
            boolean flag, boolean flag1);

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        setUpRefreshListener();
        bundle = getSyncManager();
        bundle.setFirstPageSize(dealCardListUtils.getFirstPageSize());
        bundle.setSubsequencePageSize(dealCardListUtils.getSubsequencePageSize());
        configureSyncManager();
        bundle = new JavaListAdapter() {

            final BaseCardListFragment this$0;

            public long getItemId(int i)
            {
                return (long)getItem(i).hashCode();
            }

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                return getCardView(this, i, view, viewgroup);
            }

            
            {
                this$0 = BaseCardListFragment.this;
                super();
            }
        };
        dealCardEndlessAdapter = getDealCardEndlessAdapter(bundle, this);
        setListAdapter(new VpsAdapter(dealCardEndlessAdapter));
        populateHeaderView(0);
        initLoader(bundle);
        if ((activity instanceof Carousel) && !disableScrollHelper)
        {
            scrollToolBarHelper.initToolBar((Carousel)activity, this);
        }
        Bundle bundle1 = getActivity().getIntent().getExtras();
        if (bundle1 == null)
        {
            bundle = null;
        } else
        {
            bundle = (Channel)bundle1.getParcelable("channel");
        }
        if (bundle == pagerChannel && bundle1.getBoolean("isDeepLinked", false))
        {
            getView().getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final BaseCardListFragment this$0;

                public void onGlobalLayout()
                {
                    if (getActivity() != null && !isRemoving())
                    {
                        forceReload();
                    }
                    getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }

            
            {
                this$0 = BaseCardListFragment.this;
                super();
            }
            });
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        String s = getClass().getSimpleName();
        bundle = null;
        Object obj = getArguments();
        if (obj != null)
        {
            bundle = ((Bundle) (obj)).getStringArray("channelOptions");
        }
        obj = getSyncManager();
        ((AnyChannelSyncManager) (obj)).setFragmentName(s);
        if (channel != null)
        {
            s = channel.name();
        } else
        {
            s = pagerChannelAndSubchannel;
        }
        ((AnyChannelSyncManager) (obj)).setChannelId(s);
        ((AnyChannelSyncManager) (obj)).setNstChannel(nstChannel);
        ((AnyChannelSyncManager) (obj)).setChannelOptions(bundle);
    }

    public void onPause()
    {
        getListView().setOnScrollListener(null);
        super.onPause();
    }

    public void onToolBarInitialized()
    {
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        view = getHeaderView();
        if (view != null)
        {
            view.setVisibility(8);
            getListView().addHeaderView(view, null, isHeaderSelectable());
        }
    }

    protected void populateHeaderView(int i)
    {
        if (headerView != null)
        {
            headerView.setVisibility(0);
        }
    }

    protected boolean requiresRedirectLogging()
    {
        return true;
    }

    public void setChannelName(String s)
    {
        pagerChannelAndSubchannel = s;
    }

    protected abstract void tracking(String s, Object obj, int i, JsonEncodedNSTField jsonencodednstfield);
}
