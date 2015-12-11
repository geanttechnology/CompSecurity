// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.ebay.common.Preferences;
import com.ebay.common.content.dm.AdRtmDataManager;
import com.ebay.common.net.SimpleHttpGETRequest;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.rtm.RtmHelper;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.activities.RecentlyViewedItemsActivity;
import com.ebay.mobile.activities.RegisterFragment;
import com.ebay.mobile.activities.ShowWebViewActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.categorybrowser.TopLevelCategoriesFragment;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.home.cards.BuyingOverviewModel;
import com.ebay.mobile.home.cards.FollowingViewHolder;
import com.ebay.mobile.home.cards.FollowingViewModel;
import com.ebay.mobile.home.cards.InspirationContentViewHolder;
import com.ebay.mobile.home.cards.ListAnItemContentViewHolder;
import com.ebay.mobile.home.cards.ListOfSellingDraftsViewModel;
import com.ebay.mobile.home.cards.NotificationsViewModel;
import com.ebay.mobile.home.cards.RTMViewModel;
import com.ebay.mobile.home.cards.RecentlyViewedItemsHolder;
import com.ebay.mobile.home.cards.RecentlyViewedItemsModel;
import com.ebay.mobile.home.cards.ScheduledListingViewModel;
import com.ebay.mobile.home.cards.SellSignInViewModel;
import com.ebay.mobile.home.cards.SellingDraftViewModel;
import com.ebay.mobile.home.cards.SellingOverviewModel;
import com.ebay.mobile.home.cards.SellingUtilityViewModel;
import com.ebay.mobile.home.cards.WatchingViewHolder;
import com.ebay.mobile.home.cards.WatchingViewModel;
import com.ebay.mobile.home.departments.DepartmentFragment;
import com.ebay.mobile.home.departments.DepartmentFragmentAdapter;
import com.ebay.mobile.home.departments.DepartmentNameViewModel;
import com.ebay.mobile.home.departments.DepartmentNamesAdapter;
import com.ebay.mobile.home.departments.DepartmentPageChangeListener;
import com.ebay.mobile.notifications.ItemCache;
import com.ebay.mobile.sell.ListingFragmentActivity;
import com.ebay.mobile.sell.lists.SellingListActivity;
import com.ebay.mobile.sell.util.SellUtil;
import com.ebay.mobile.sellsmartbox.SmartboxActivity;
import com.ebay.mobile.user.symban.SymbanActivity;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ThreatMatrixDataManager;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.content.dm.UssChannelsDataManager;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelsContainer;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentSourceEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.net.api.lds.ListingCategoryFilters;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.home:
//            SellFragmentAdapter, StartFragmentAdapter

public class StartFragment extends BaseFragment
    implements StartFragmentAdapter.AdapterHost, com.ebay.nautilus.domain.content.dm.UssChannelsDataManager.Observer, com.ebay.nautilus.domain.content.dm.UssContentsDataManager.Observer
{
    static class ActivitySwipeRefreshListener
        implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    {

        private final WeakReference fragmentReference;

        public void onRefresh()
        {
            StartFragment startfragment = (StartFragment)fragmentReference.get();
            if (startfragment == null || startfragment.getView() == null)
            {
                return;
            }
            SwipeRefreshLayout swiperefreshlayout = (SwipeRefreshLayout)startfragment.getView().findViewById(0x7f1002e1);
            if (swiperefreshlayout != null)
            {
                swiperefreshlayout.setRefreshing(true);
            }
            if (startfragment.ussContentsDataManager != null)
            {
                startfragment.ussContentsDataManager.invalidateAndForceReloadData();
                return;
            } else
            {
                UssContentsDataManager.invalidateActivityChannelData(startfragment.getFwActivity().getEbayContext(), new ContentSourceEnum[0]);
                return;
            }
        }

        ActivitySwipeRefreshListener(StartFragment startfragment)
        {
            fragmentReference = new WeakReference(startfragment);
        }
    }

    static final class CarouselOnClickListener
        implements com.ebay.mobile.common.view.ViewModel.OnClickListener
    {

        private final WeakReference fragmentReference;

        public void onClick(View view, ViewModel viewmodel)
        {
            StartFragment startfragment;
            startfragment = (StartFragment)fragmentReference.get();
            break MISSING_BLOCK_LABEL_11;
            if (startfragment != null && startfragment.getView() != null && (viewmodel instanceof DepartmentNameViewModel))
            {
                view = (DepartmentNameViewModel)viewmodel;
                viewmodel = (ViewPager)startfragment.getView().findViewById(0x7f1002e6);
                if (viewmodel != null)
                {
                    if (((DepartmentNameViewModel) (view)).position != viewmodel.getCurrentItem())
                    {
                        viewmodel.setCurrentItem(((DepartmentNameViewModel) (view)).position, true);
                        return;
                    }
                    if (((DepartmentNameViewModel) (view)).channel.isDepartment)
                    {
                        view = ((DepartmentNameViewModel) (view)).channel.departmentName;
                    } else
                    {
                        view = ((DepartmentNameViewModel) (view)).channel.name;
                    }
                    view = startfragment.getChildFragmentManager().findFragmentByTag(view);
                    if (view != null && (view instanceof DepartmentFragment))
                    {
                        ((DepartmentFragment)view).toggleFeaturedCategories();
                        return;
                    }
                }
            }
            return;
        }

        CarouselOnClickListener(StartFragment startfragment)
        {
            fragmentReference = new WeakReference(startfragment);
        }
    }

    private static final class ChannelState extends Enum
    {

        private static final ChannelState $VALUES[];
        public static final ChannelState STATE_ERROR;
        public static final ChannelState STATE_LOADED;
        public static final ChannelState STATE_LOADING;
        public static final ChannelState STATE_SIGNIN;

        public static ChannelState valueOf(String s)
        {
            return (ChannelState)Enum.valueOf(com/ebay/mobile/home/StartFragment$ChannelState, s);
        }

        public static ChannelState[] values()
        {
            return (ChannelState[])$VALUES.clone();
        }

        static 
        {
            STATE_LOADING = new ChannelState("STATE_LOADING", 0);
            STATE_SIGNIN = new ChannelState("STATE_SIGNIN", 1);
            STATE_LOADED = new ChannelState("STATE_LOADED", 2);
            STATE_ERROR = new ChannelState("STATE_ERROR", 3);
            $VALUES = (new ChannelState[] {
                STATE_LOADING, STATE_SIGNIN, STATE_LOADED, STATE_ERROR
            });
        }

        private ChannelState(String s, int i)
        {
            super(s, i);
        }
    }

    static class NoScrollOnItemTouchListener
        implements android.support.v7.widget.RecyclerView.OnItemTouchListener
    {

        private static final android.view.GestureDetector.SimpleOnGestureListener noScrollGestureDetector = new android.view.GestureDetector.SimpleOnGestureListener() {

            public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                return true;
            }

            public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
            {
                return true;
            }

            public boolean onSingleTapUp(MotionEvent motionevent)
            {
                return false;
            }

        };
        private boolean capturing;
        private final GestureDetector gestureDetector;
        private final WeakReference viewReference;

        public boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
        {
            boolean flag;
            flag = false;
            recyclerview = (ViewGroup)viewReference.get();
            if (recyclerview == null)
            {
                return false;
            }
            if (gestureDetector.onTouchEvent(motionevent) || recyclerview.onInterceptTouchEvent(motionevent))
            {
                flag = true;
            }
            try
            {
                capturing = flag;
            }
            // Misplaced declaration of an exception variable
            catch (RecyclerView recyclerview) { }
            return capturing;
        }

        public void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
        {
            for (recyclerview = (ViewGroup)viewReference.get(); recyclerview == null || !capturing;)
            {
                return;
            }

            recyclerview.onTouchEvent(motionevent);
        }


        NoScrollOnItemTouchListener(ViewGroup viewgroup)
        {
            capturing = false;
            viewReference = new WeakReference(viewgroup);
            gestureDetector = new GestureDetector(viewgroup.getContext(), noScrollGestureDetector);
        }
    }

    static class PromoRtmObserver
        implements com.ebay.common.content.dm.AdRtmDataManager.Observer
    {

        private final WeakReference fragmentReference;

        public void onAdsContextReady(List list, com.ebay.common.content.dm.AdRtmDataManager.AdRequestType adrequesttype)
        {
            adrequesttype = (StartFragment)fragmentReference.get();
            DataManagerContainer datamanagercontainer;
            if (adrequesttype != null)
            {
                if ((datamanagercontainer = adrequesttype.getDataManagerContainer()) != null)
                {
                    adrequesttype.ussContentsDataManager = (UssContentsDataManager)datamanagercontainer.initialize(UssContentsDataManager.getChannelKeyParams(((StartFragment) (adrequesttype)).channel.name, null, list), adrequesttype);
                    return;
                }
            }
        }

        public void onAdsReady(RtmHelper rtmhelper, com.ebay.common.content.dm.AdRtmDataManager.AdRequestType adrequesttype)
        {
        }

        PromoRtmObserver(StartFragment startfragment)
        {
            fragmentReference = new WeakReference(startfragment);
        }
    }

    static class SellSwipeRefreshListener
        implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    {

        private final WeakReference fragmentReference;

        public void onRefresh()
        {
            StartFragment startfragment = (StartFragment)fragmentReference.get();
            if (startfragment == null || startfragment.getView() == null)
            {
                return;
            }
            SwipeRefreshLayout swiperefreshlayout = (SwipeRefreshLayout)startfragment.getView().findViewById(0x7f1002e1);
            if (swiperefreshlayout != null)
            {
                swiperefreshlayout.setRefreshing(true);
            }
            if (startfragment.ussContentsDataManager != null)
            {
                startfragment.ussContentsDataManager.invalidateAndForceReloadData();
                return;
            } else
            {
                UssContentsDataManager.invalidateSellChannelData(startfragment.getFwActivity().getEbayContext(), new ContentSourceEnum[0]);
                return;
            }
        }

        SellSwipeRefreshListener(StartFragment startfragment)
        {
            fragmentReference = new WeakReference(startfragment);
        }
    }

    public static interface StartChannelHost
    {

        public transient abstract Channel getChannel(int ai[]);

        public abstract int getChannelIndex(ChannelEnum channelenum);

        public abstract void navigateToChannel(ChannelEnum channelenum, boolean flag, boolean flag1);
    }


    public static final String CHANNEL_NAME_ACTIVITY = "ACTIVITY";
    public static final String CHANNEL_NAME_SELL = "SELL";
    public static final String CHANNEL_NAME_SHOP = "SHOP";
    private static final int DIALOG_INVALID_DRAFT = 1;
    public static final String EXTRA_CHANNEL = "Channel";
    public static final String EXTRA_CHANNEL_INDEX = "ChannelIndex";
    public static final String EXTRA_DEPARTMENT_INDEX = "DepartmentIndex";
    public static final String EXTRA_DRAFT_ID = "RedirectDraftId";
    public static final String EXTRA_VARIATION_TRACKING_LIST = "variationTrackingList";
    private static final int LOADER_ID_RTM_TRACKING = 10;
    private static final int REQUEST_CODE_REGISTER = 1;
    private static final int REQUEST_CODE_SIGNIN = 1;
    private static final String TODO_BUYER_PAID = "BUYER_PAID";
    private static final String TODO_SELLER_OFFER_RECEIVED = "SELLER_OFFER_RECEIVED";
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logger = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("StartFragment", 3, "StartFragment logger.");
    private com.ebay.mobile.common.view.ViewModel.OnClickListener activeClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener buyingOverviewClickListener;
    private Channel channel;
    private android.view.View.OnClickListener channelErrorClickListener;
    private int channelIndex;
    private ChannelState channelState;
    private StartFragmentAdapter contentAdapter;
    protected int departmentIndex;
    protected DepartmentPageChangeListener departmentPageChangeListener;
    protected ViewPager departmentPager;
    public String draftId;
    private View error;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener followingOverviewClickListener;
    private int initialViewType;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener inspirationClickListener;
    private boolean isVariationTrackingRestored;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener listAnItemClickListener;
    private RecyclerView navigationView;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener notificationsClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener overviewErrorClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener promoClickListener;
    private com.ebay.common.content.dm.AdRtmDataManager.KeyParams promoRtmDataManagerKeyParams;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener recentlyViewedItemsClickListener;
    private RecyclerView recyclerView;
    private android.support.v7.widget.RecyclerView.OnScrollListener recyclerViewScrollListener;
    private SwipeRefreshLayout refreshLayout;
    private View registerButton;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener scheduledClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener scheduledItemClickListener;
    private boolean sellChannelEnabled;
    private SellFragmentAdapter sellContentAdapter;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener sellingDraftsClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener sellingDraftsItemClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener sellingOverviewClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener sellingUtilityClickListener;
    private View signIn;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener signInClickListener;
    private android.view.View.OnClickListener signInStateClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener soldClickListener;
    private WeakReference startChannelHostReference;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener unsoldClickListener;
    private UssContentsDataManager ussContentsDataManager;
    private ArrayList variationTrackingViewTypes;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener watchingClickListener;

    public StartFragment()
    {
        channelState = ChannelState.STATE_LOADING;
        channelIndex = -1;
        departmentIndex = -1;
        initialViewType = -1;
        variationTrackingViewTypes = new ArrayList();
        followingOverviewClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                SourceIdentification sourceidentification;
                Activity activity;
                sourceidentification = new SourceIdentification("HomePage", "followedsearch", "activity");
                activity = getActivity();
                if (view.getId() != 0x7f100229) goto _L2; else goto _L1
_L1:
                view = ActivityStarter.getBrowseFollowsIntent(activity);
                view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                activity.startActivity(view);
_L4:
                return;
_L2:
                int i;
                int j;
                if (!(viewmodel instanceof FollowingViewModel))
                {
                    continue; /* Loop/switch isn't completed */
                }
                viewmodel = (FollowingViewModel)viewmodel;
                j = view.getId();
                i = 0;
                do
                {
                    if (i >= FollowingViewHolder.idListInterests.length)
                    {
                        break;
                    }
                    if (j == FollowingViewHolder.idListInterests[i])
                    {
                        view = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest)((FollowingViewModel) (viewmodel)).followedInterests.get(i);
                        if (view != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (view)).entity != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (view)).entity.interestId != null)
                        {
                            viewmodel = ActivityStarter.getSavedSearchIntent(activity, getFwActivity().getEbayContext(), ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (view)).entity.interestId, null);
                            if (viewmodel != null)
                            {
                                viewmodel.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                                (new ItemCache(activity)).markSavedSearchViewed(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedInterest) (view)).entity.interestId);
                                activity.startActivity(viewmodel);
                                return;
                            }
                        }
                        continue; /* Loop/switch isn't completed */
                    }
                    i++;
                } while (true);
                i = 0;
_L5:
                if (i < FollowingViewHolder.idListProfiles.length)
                {
label0:
                    {
                        if (j != FollowingViewHolder.idListProfiles[i])
                        {
                            break label0;
                        }
                        view = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser)((FollowingViewModel) (viewmodel)).followedUsers.get(i);
                        if (view != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser) (view)).entity != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser) (view)).entity.userIdentifier != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser) (view)).entity.userIdentifier.username != null)
                        {
                            viewmodel = eBayDictionaryProvider.getLockedSearchParameters(activity, null);
                            viewmodel.sellerId = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.FollowedUser) (view)).entity.userIdentifier.username;
                            view = ActivityStarter.getSearchResultListIntent(activity, viewmodel, null);
                            view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                            startActivity(view);
                            return;
                        }
                    }
                }
                if (true) goto _L4; else goto _L3
_L3:
                i++;
                  goto _L5
                if (true) goto _L4; else goto _L6
_L6:
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        channelErrorClickListener = new android.view.View.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view)
            {
                if (view.getId() == 0x7f10022c)
                {
                    updateChannelState(ChannelState.STATE_LOADING);
                    ussContentsDataManager.invalidateAndForceReloadData();
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        overviewErrorClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (view.getId() == 0x7f10022c)
                {
                    updateChannelState(ChannelState.STATE_LOADING);
                    ussContentsDataManager.invalidateAndForceReloadData();
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        sellingOverviewClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                int i = view.getId();
                view = new SourceIdentification("HomePage", "sellingoverview", "activity");
                viewmodel = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
                viewmodel.putExtra("com.ebay.mobile.analytics.sid", view);
                if (i == 0x7f1002a6)
                {
                    viewmodel.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD);
                    startActivity(viewmodel);
                } else
                {
                    if (i == 0x7f1002a9)
                    {
                        viewmodel.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.UNSOLD);
                        startActivity(viewmodel);
                        return;
                    }
                    if (i == 0x7f1002a5 && startChannelHostReference != null)
                    {
                        view = getActivity();
                        if (view != null)
                        {
                            (new TrackingData("StartSelling", TrackingType.EVENT)).send(view);
                        }
                        view = (StartChannelHost)startChannelHostReference.get();
                        if (view != null)
                        {
                            view.navigateToChannel(ChannelEnum.SELL, true, true);
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        buyingOverviewClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                Activity activity = getActivity();
                int i = view.getId();
                SourceIdentification sourceidentification = new SourceIdentification("HomePage", "buyingoverview", "activity");
                if (view.getId() == 0x7f100226)
                {
                    view = MyEbayLandingActivity.getBuyingActivityIntent(activity, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.BIDS);
                    view.setFlags(0x24000000);
                    view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                    startSignedInActivity(activity, view, true);
                } else
                {
                    if (i == 0x7f100227)
                    {
                        view = MyEbayLandingActivity.getBuyingActivityIntent(activity, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.OFFERS);
                        view.setFlags(0x24000000);
                        view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                        startSignedInActivity(activity, view, true);
                        return;
                    }
                    if (i == 0x7f100228)
                    {
                        view = MyEbayLandingActivity.getBuyingActivityIntent(activity, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.WON);
                        view.setFlags(0x24000000);
                        view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                        startSignedInActivity(activity, view, true);
                        return;
                    }
                    if (i == 0x7f100229 && (viewmodel instanceof BuyingOverviewModel))
                    {
                        if (((BuyingOverviewModel)viewmodel).record.emptyBuying)
                        {
                            if (startChannelHostReference != null)
                            {
                                view = getActivity();
                                if (view != null)
                                {
                                    (new TrackingData("StartShopping", TrackingType.EVENT)).send(view);
                                }
                                view = (StartChannelHost)startChannelHostReference.get();
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
                            startSignedInActivity(activity, view, true);
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        notificationsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof NotificationsViewModel) goto _L2; else goto _L1
_L1:
                return;
_L2:
                Intent intent;
                NotificationsViewModel notificationsviewmodel = (NotificationsViewModel)viewmodel;
                viewmodel = null;
                byte byte0 = -1;
                SourceIdentification sourceidentification = new SourceIdentification("HomePage", "notifications", "activity");
                intent = new Intent();
                intent.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                if (view.getId() == 0x7f10028a)
                {
                    byte0 = 0;
                } else
                if (view.getId() == 0x7f10028b)
                {
                    byte0 = 1;
                } else
                if (view.getId() == 0x7f10028c)
                {
                    byte0 = 2;
                }
                if (byte0 != -1)
                {
                    if (notificationsviewmodel.notifications.size() >= byte0 + 1)
                    {
                        viewmodel = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)notificationsviewmodel.notifications.get(byte0)).notification;
                    }
                    if (viewmodel != null)
                    {
                        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).action == null || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).action.name == null || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject == null || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing == null)
                        {
                            break; /* Loop/switch isn't completed */
                        }
                        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId != null)
                        {
                            if (com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.PAY_NOW.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).action.name))
                            {
                                ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ConstantsCommon.ItemKind.Won, intent);
                            } else
                            if (com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.SHIP_ITEM.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).action.name))
                            {
                                ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ConstantsCommon.ItemKind.Sold, intent);
                            } else
                            if (com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.RAISE_BID.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).action.name))
                            {
                                ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ConstantsCommon.ItemKind.Bidding, intent);
                            } else
                            if (com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.REVIEW_OFFER.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).action.name))
                            {
                                ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ConstantsCommon.ItemKind.Unknown, intent);
                            } else
                            if (com.ebay.nautilus.domain.data.SymbanNotification.ActionEnum.VIEW_ITEM.equals(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).action.name))
                            {
                                ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ConstantsCommon.ItemKind.Unknown, intent);
                            } else
                            {
                                ItemViewActivity.StartActivityFromMEB(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.transactionId, com.ebay.common.ConstantsCommon.ItemKind.Unknown, intent);
                            }
                        } else
                        {
                            ItemViewActivity.StartActivity(getActivity(), Long.valueOf(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).subject.listing.listingId).longValue(), com.ebay.common.ConstantsCommon.ItemKind.Unknown);
                        }
                    }
                }
_L5:
                if (view.getId() == 0x7f10028d)
                {
                    view = new Intent(getActivity(), com/ebay/mobile/user/symban/SymbanActivity);
                    view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                    getActivity().startActivity(view);
                    return;
                }
                if (true) goto _L1; else goto _L3
_L3:
                if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).name == null) goto _L5; else goto _L4
_L4:
                if ("BUYER_PAID".equals(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).name))
                {
                    viewmodel = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
                    viewmodel.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD);
                    viewmodel.putExtra("filter", "AwaitingShipment");
                    viewmodel.putExtras(intent);
                    startActivity(viewmodel);
                } else
                if ("SELLER_OFFER_RECEIVED".equals(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Notification) (viewmodel)).name))
                {
                    viewmodel = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
                    viewmodel.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.ACTIVE);
                    viewmodel.putExtra("filter", "NewOffers");
                    viewmodel.putExtras(intent);
                    startActivity(viewmodel);
                }
                  goto _L5
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        watchingClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof WatchingViewModel)
                {
                    WatchingViewModel watchingviewmodel = (WatchingViewModel)viewmodel;
                    viewmodel = new SourceIdentification("HomePage", "watching", "activity");
                    if (view.getId() == 0x7f100229)
                    {
                        view = MyEbayLandingActivity.getWatchingActivityIntent(getActivity(), com.ebay.mobile.activities.MyEbayLandingActivity.WatchingTarget.ALL);
                        view.setFlags(0x24000000);
                        view.putExtra("com.ebay.mobile.analytics.sid", viewmodel);
                        startSignedInActivity(getActivity(), view, true);
                        return;
                    }
                    int i = 0;
                    while (i < WatchingViewHolder.idList.length) 
                    {
                        if (view.getId() == WatchingViewHolder.idList[i] && watchingviewmodel.contentRecords != null && watchingviewmodel.contentRecords.get(i) != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)watchingviewmodel.contentRecords.get(i)).listings != null)
                        {
                            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)watchingviewmodel.contentRecords.get(i)).listings.get(0);
                            if (listing != null)
                            {
                                Intent intent = new Intent();
                                intent.putExtra("com.ebay.mobile.analytics.sid", viewmodel);
                                ItemViewActivity.StartActivity(getActivity(), Long.valueOf(listing.listingId).longValue(), com.ebay.common.ConstantsCommon.ItemKind.Watched, intent);
                            }
                        }
                        i++;
                    }
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        recentlyViewedItemsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof RecentlyViewedItemsModel)
                {
                    RecentlyViewedItemsModel recentlyvieweditemsmodel = (RecentlyViewedItemsModel)viewmodel;
                    viewmodel = new SourceIdentification("HomePage", "recents", "activity");
                    if (view.getId() == 0x7f100294)
                    {
                        view = new Intent(getActivity(), com/ebay/mobile/activities/RecentlyViewedItemsActivity);
                        view.putExtra("com.ebay.mobile.analytics.sid", viewmodel);
                        startSignedInActivity(getActivity(), view, false);
                        return;
                    }
                    int i = 0;
                    while (i < RecentlyViewedItemsHolder.idList.length) 
                    {
                        if (view.getId() == RecentlyViewedItemsHolder.idList[i] && recentlyvieweditemsmodel.contentRecords != null && recentlyvieweditemsmodel.contentRecords.get(i) != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)recentlyvieweditemsmodel.contentRecords.get(i)).listings != null)
                        {
                            com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing listing = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Listing)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)recentlyvieweditemsmodel.contentRecords.get(i)).listings.get(0);
                            if (listing != null)
                            {
                                Intent intent = new Intent();
                                intent.putExtra("com.ebay.mobile.analytics.sid", viewmodel);
                                ItemViewActivity.StartActivity(getActivity(), Long.valueOf(listing.listingId).longValue(), com.ebay.common.ConstantsCommon.ItemKind.RecentlyViewed, intent);
                            }
                        }
                        i++;
                    }
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        listAnItemClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                view = new Intent(getActivity(), com/ebay/mobile/sellsmartbox/SmartboxActivity);
                view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "listanitem", "sell"));
                getActivity().startActivity(view);
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        sellingDraftsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                view = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
                view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "drafts", "sell"));
                view.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.DRAFT);
                startActivity(view);
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        sellingDraftsItemClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof SellingDraftViewModel)
                {
                    openDraft((SellingDraftViewModel)viewmodel);
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        scheduledClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                view = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
                view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "scheduled", "sell"));
                view.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.SCHEDULED);
                startActivity(view);
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        scheduledItemClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (!(viewmodel instanceof ScheduledListingViewModel))
                {
                    break MISSING_BLOCK_LABEL_63;
                }
                view = (ScheduledListingViewModel)viewmodel;
                long l = Long.parseLong(((ScheduledListingViewModel) (view)).listingId);
                view = new Intent();
                view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "scheduled", "sell"));
                ItemViewActivity.StartActivity(getActivity(), l, com.ebay.common.ConstantsCommon.ItemKind.Scheduled, view);
_L1:
                return;
                view;
                if (StartFragment.logger.isLoggable)
                {
                    StartFragment.logger.logAsError("Scheduled item id could not be parsed");
                    return;
                }
                  goto _L1
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        activeClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof SellingUtilityViewModel)
                {
                    view = (SellingUtilityViewModel)viewmodel;
                    viewmodel = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
                    viewmodel.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.ACTIVE);
                    if (!TextUtils.isEmpty(((SellingUtilityViewModel) (view)).activeItemType))
                    {
                        viewmodel.putExtra("filter", ((SellingUtilityViewModel) (view)).activeItemType);
                    }
                    viewmodel.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "active", "sell"));
                    startActivity(viewmodel);
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        soldClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof SellingUtilityViewModel)
                {
                    view = (SellingUtilityViewModel)viewmodel;
                    viewmodel = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
                    viewmodel.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD);
                    if (!TextUtils.isEmpty(((SellingUtilityViewModel) (view)).soldItemType))
                    {
                        viewmodel.putExtra("filter", ((SellingUtilityViewModel) (view)).soldItemType);
                    }
                    viewmodel.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "sold", "sell"));
                    startActivity(viewmodel);
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        unsoldClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof SellingUtilityViewModel)
                {
                    view = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
                    view.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.UNSOLD);
                    view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "unsold", "sell"));
                    getActivity().startActivity(view);
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        sellingUtilityClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof SellingUtilityViewModel)
                {
                    view = (SellingUtilityViewModel)viewmodel;
                    viewmodel = new Intent(getActivity(), com/ebay/mobile/sell/lists/SellingListActivity);
                    if (((SellingUtilityViewModel) (view)).sellListType == com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD)
                    {
                        if (!TextUtils.isEmpty(((SellingUtilityViewModel) (view)).soldItemType))
                        {
                            viewmodel.putExtra("filter", ((SellingUtilityViewModel) (view)).soldItemType);
                        }
                        viewmodel.putExtra("listType", ((SellingUtilityViewModel) (view)).sellListType);
                        view = "sold";
                    } else
                    {
                        if (!TextUtils.isEmpty(((SellingUtilityViewModel) (view)).activeItemType))
                        {
                            viewmodel.putExtra("filter", ((SellingUtilityViewModel) (view)).activeItemType);
                        }
                        viewmodel.putExtra("listType", ((SellingUtilityViewModel) (view)).sellListType);
                        if (((SellingUtilityViewModel) (view)).sellListType == com.ebay.mobile.sell.lists.SellingListActivity.ListType.UNSOLD)
                        {
                            view = "unsold";
                        } else
                        {
                            view = "active";
                        }
                    }
                    viewmodel.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", view, "sell"));
                    startActivity(viewmodel);
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        inspirationClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof SellingOverviewModel)
                {
                    view = ((SellingOverviewModel)viewmodel).sellingImageList;
                    if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (view)).button != null && !TextUtils.isEmpty(((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (view)).button.url))
                    {
                        Activity activity = getActivity();
                        viewmodel = new Intent(activity, com/ebay/mobile/activities/ShowWebViewActivity);
                        viewmodel.putExtra("url", ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (view)).button.url);
                        if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (view)).name == com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.Name.valet)
                        {
                            view = activity.getString(0x7f070481);
                            if (MyApp.getPrefs().isSignedIn())
                            {
                                viewmodel.putExtra("use_sso", true);
                            } else
                            {
                                viewmodel.putExtra("add_device_id", false);
                            }
                            viewmodel.putExtra("enablefileDownload", true);
                            viewmodel.putExtra("lessProgress", true);
                        } else
                        {
                            view = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SellingImageList) (view)).title;
                        }
                        viewmodel.putExtra("android.intent.extra.TITLE", view);
                        startActivity(viewmodel);
                    }
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        promoClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            private void sendRtmTracking(RTMViewModel rtmviewmodel)
            {
                com.ebay.nautilus.kernel.content.EbayContext ebaycontext = getBaseActivity().getEbayContext();
                if (rtmviewmodel.rtmTrackingUrl != null)
                {
                    try
                    {
                        SimpleHttpGETRequest simplehttpgetrequest = new SimpleHttpGETRequest(ebaycontext, new URL(rtmviewmodel.rtmTrackingUrl));
                        getFwLoaderManager().start(10, simplehttpgetrequest, false);
                    }
                    catch (MalformedURLException malformedurlexception) { }
                }
                if (!TextUtils.isEmpty(rtmviewmodel.clickId))
                {
                    TrackingData trackingdata = new TrackingData("RTMItemList", TrackingType.EVENT);
                    trackingdata.addKeyValuePair("trkp", rtmviewmodel.clickId);
                    trackingdata.send(ebaycontext);
                }
            }

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof RTMViewModel)
                {
                    view = (RTMViewModel)viewmodel;
                    sendRtmTracking(view);
                    startActivity(view.getIntent(getActivity()));
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        signInClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof SellSignInViewModel)
                {
                    if (view.getId() == 0x7f10029e)
                    {
                        view = SignInModalActivity.getIntentForSignIn("HomePage", getActivity());
                        view.putExtra("fromHome", true);
                        startActivityForResult(view, 1);
                    } else
                    if (view.getId() == 0x7f10029d)
                    {
                        startActivityForResult(getRegisterIntent(getActivity(), true), 1);
                        return;
                    }
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        signInStateClickListener = new android.view.View.OnClickListener() {

            final StartFragment this$0;

            public void onClick(View view)
            {
                if (view.getId() == 0x7f10029e)
                {
                    Intent intent = SignInModalActivity.getIntentForSignIn("HomePage", getActivity());
                    intent.putExtra("fromHome", true);
                    startActivityForResult(intent, 1);
                }
                if (view.getId() == 0x7f10029d)
                {
                    startActivityForResult(getRegisterIntent(getActivity(), true), 1);
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
        recyclerViewScrollListener = new android.support.v7.widget.RecyclerView.OnScrollListener() {

            final StartFragment this$0;

            public void onScrollStateChanged(RecyclerView recyclerview, int i)
            {
                super.onScrollStateChanged(recyclerview, i);
            }

            public void onScrolled(RecyclerView recyclerview, int i, int j)
            {
                super.onScrolled(recyclerview, i, j);
                if (getUserVisibleHint() && sellContentAdapter != null && variationTrackingViewTypes != null && variationTrackingViewTypes.size() < sellContentAdapter.variationIdCount)
                {
                    sendSellingTrackingData();
                }
            }

            
            {
                this$0 = StartFragment.this;
                super();
            }
        };
    }

    private boolean hasFullscreenSignIn(Contents contents)
    {
label0:
        {
            if (contents == null || contents.contentGroups == null)
            {
                break label0;
            }
            contents = contents.contentGroups.iterator();
            Object obj;
            do
            {
                do
                {
                    if (!contents.hasNext())
                    {
                        break label0;
                    }
                    obj = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup)contents.next();
                } while (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contentSource != ContentSourceEnum.SIGN_IN || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents == null || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents.size() <= 0);
                obj = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup) (obj)).contents.get(0)).signIn;
            } while (obj == null || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SignIn) (obj)).template == null || ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SignIn) (obj)).template != com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord.SignIn.Template.FULLSCREEN);
            return true;
        }
        return false;
    }

    private void openDraft(SellingDraftViewModel sellingdraftviewmodel)
    {
        String s = sellingdraftviewmodel.categoryIdPath;
        Object obj2 = null;
        Object obj1 = s;
        Object obj = obj2;
        if (!TextUtils.isEmpty(s))
        {
            obj1 = s;
            obj = obj2;
            if (s.contains(">"))
            {
                obj1 = s.replace(" > ", ":");
                obj = ((String) (obj1)).split(":");
                if (obj.length > 0)
                {
                    obj = obj[obj.length - 1];
                } else
                {
                    obj = obj1;
                }
            }
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj1))) && ListingCategoryFilters.categoryOkForNewListing(EbaySite.getInstanceFromId(sellingdraftviewmodel.draftSiteId).id, ((String) (obj1))))
        {
            obj1 = new Intent(getActivity(), com/ebay/mobile/sell/ListingFragmentActivity);
            ((Intent) (obj1)).putExtra("site", EbaySite.getInstanceFromId(sellingdraftviewmodel.draftSiteId));
            ((Intent) (obj1)).putExtra("draft_id", sellingdraftviewmodel.draftId);
            ((Intent) (obj1)).putExtra("listing_mode", sellingdraftviewmodel.draftListingMode);
            ((Intent) (obj1)).putExtra("category_id", ((String) (obj)));
            ((Intent) (obj1)).putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification("HomePage", "drafts", "sell"));
            startActivity(((Intent) (obj1)));
            return;
        } else
        {
            SellUtil.showInvalidDraftDialog(this, 1);
            return;
        }
    }

    private void sendSellingTrackingData()
    {
        if (recyclerView != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        int i;
        int j;
        obj = recyclerView.getLayoutManager();
        if (!(obj instanceof GridLayoutManager))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (GridLayoutManager)obj;
        i = ((GridLayoutManager) (obj)).findFirstVisibleItemPosition();
        j = ((GridLayoutManager) (obj)).findLastVisibleItemPosition();
_L9:
        if (i < 0 || j >= sellContentAdapter.getItemCount() || i > j) goto _L1; else goto _L3
_L3:
        if (i > j) goto _L1; else goto _L4
_L4:
        obj = recyclerView.getChildAt(i);
        if (obj == null) goto _L6; else goto _L5
_L5:
        int k;
        obj = recyclerView.getChildViewHolder(((View) (obj)));
        k = ((android.support.v7.widget.RecyclerView.ViewHolder) (obj)).getItemViewType();
        if (!variationTrackingViewTypes.contains(Integer.valueOf(k))) goto _L7; else goto _L6
_L6:
        i++;
          goto _L3
        if (!(obj instanceof LinearLayoutManager)) goto _L1; else goto _L8
_L8:
        obj = (LinearLayoutManager)obj;
        i = ((LinearLayoutManager) (obj)).findFirstVisibleItemPosition();
        j = ((LinearLayoutManager) (obj)).findLastVisibleItemPosition();
          goto _L9
_L7:
        if (!(obj instanceof ListAnItemContentViewHolder))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((ListAnItemContentViewHolder)obj).getVariationId();
        variationTrackingViewTypes.add(Integer.valueOf(k));
_L11:
        TrackingData trackingdata = new TrackingData("SellerInspiration", TrackingType.PAGE_IMPRESSION);
        trackingdata.addKeyValuePair("variationID", ((String) (obj)));
        trackingdata.send(getActivity());
          goto _L6
        if (!(obj instanceof InspirationContentViewHolder)) goto _L6; else goto _L10
_L10:
        obj = ((InspirationContentViewHolder)obj).getVariationId();
        variationTrackingViewTypes.add(Integer.valueOf(k));
          goto _L11
    }

    private void startSignedInActivity(Activity activity, Intent intent, boolean flag)
    {
        if (!MyApp.getPrefs().isSignedIn())
        {
            Intent intent1 = SignInModalActivity.getIntentForSignIn("HomePage", activity);
            ArrayList arraylist = new ArrayList();
            if (flag)
            {
                Intent intent2 = new Intent(activity, com/ebay/mobile/activities/eBay);
                intent2.setFlags(0x24000000);
                arraylist.add(intent2);
            }
            arraylist.add(intent);
            intent1.putParcelableArrayListExtra("redirect_intents", arraylist);
            activity.startActivity(intent1);
            return;
        } else
        {
            activity.startActivity(intent);
            return;
        }
    }

    private void updateChannelState()
    {
        updateChannelState(channelState);
    }

    private void updateChannelState(ChannelState channelstate)
    {
        View view;
        if (getView() == null)
        {
            view = null;
        } else
        {
            view = getView().findViewById(0x7f1002e5);
        }
        if (channelstate != ChannelState.STATE_LOADING) goto _L2; else goto _L1
_L1:
        if (view != null)
        {
            view.setVisibility(0);
        }
        if (recyclerView != null)
        {
            recyclerView.setVisibility(8);
        }
        if (signIn != null)
        {
            signIn.setVisibility(8);
        }
        if (error != null)
        {
            error.setVisibility(8);
        }
_L4:
        channelState = channelstate;
        return;
_L2:
        if (channelstate == ChannelState.STATE_LOADED)
        {
            if (view != null)
            {
                view.setVisibility(8);
            }
            if (recyclerView != null)
            {
                recyclerView.setVisibility(0);
            }
            if (signIn != null)
            {
                signIn.setVisibility(8);
            }
            if (error != null)
            {
                error.setVisibility(8);
            }
        } else
        if (channelstate == ChannelState.STATE_SIGNIN)
        {
            if (view != null)
            {
                view.setVisibility(8);
            }
            if (recyclerView != null)
            {
                recyclerView.setVisibility(8);
            }
            if (signIn != null)
            {
                signIn.setVisibility(0);
            }
            if (error != null)
            {
                error.setVisibility(8);
            }
        } else
        if (channelstate == ChannelState.STATE_ERROR)
        {
            if (view != null)
            {
                view.setVisibility(8);
            }
            if (recyclerView != null)
            {
                recyclerView.setVisibility(8);
            }
            if (signIn != null)
            {
                signIn.setVisibility(8);
            }
            if (error != null)
            {
                error.setVisibility(0);
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void updateView(View view)
    {
        boolean flag;
        if (view == null)
        {
            return;
        }
        flag = getActivity().getResources().getBoolean(0x7f0b0006);
        if (channel == null || !"SELL".equals(channel.name) || sellContentAdapter != null) goto _L2; else goto _L1
_L1:
        sellContentAdapter = new SellFragmentAdapter(getActivity());
        sellContentAdapter.setOnClickListener(listAnItemClickListener, new int[] {
            2
        });
        sellContentAdapter.setOnClickListener(listAnItemClickListener, new int[] {
            3
        });
        sellContentAdapter.setOnClickListener(sellingDraftsClickListener, new int[] {
            6
        });
        sellContentAdapter.setOnClickListener(sellingDraftsItemClickListener, new int[] {
            7
        });
        sellContentAdapter.setOnClickListener(scheduledClickListener, new int[] {
            12
        });
        sellContentAdapter.setOnClickListener(scheduledItemClickListener, new int[] {
            13
        });
        sellContentAdapter.setOnClickListener(activeClickListener, new int[] {
            4
        });
        sellContentAdapter.setOnClickListener(soldClickListener, new int[] {
            0
        });
        sellContentAdapter.setOnClickListener(unsoldClickListener, new int[] {
            1
        });
        sellContentAdapter.setOnClickListener(sellingUtilityClickListener, new int[] {
            8
        });
        sellContentAdapter.setOnClickListener(sellingUtilityClickListener, new int[] {
            11
        });
        sellContentAdapter.setOnClickListener(sellingUtilityClickListener, new int[] {
            10
        });
        sellContentAdapter.setOnClickListener(sellingUtilityClickListener, new int[] {
            9
        });
        sellContentAdapter.setOnClickListener(inspirationClickListener, new int[] {
            5
        });
        sellContentAdapter.setOnClickListener(inspirationClickListener, new int[] {
            16
        });
        sellContentAdapter.setOnClickListener(inspirationClickListener, new int[] {
            19
        });
        sellContentAdapter.setOnClickListener(inspirationClickListener, new int[] {
            20
        });
        sellContentAdapter.setOnClickListener(promoClickListener, new int[] {
            14
        });
        sellContentAdapter.setOnClickListener(signInClickListener, new int[] {
            17
        });
        sellContentAdapter.setOnClickListener(notificationsClickListener, new int[] {
            18
        });
        error = view.findViewById(0x7f1002e4);
        if (error != null)
        {
            error.findViewById(0x7f10022c).setOnClickListener(channelErrorClickListener);
        }
        recyclerView = (RecyclerView)view.findViewById(0x7f1002e2);
        recyclerView.setLayoutManager(sellContentAdapter.createLayoutManager());
        recyclerView.setAdapter(sellContentAdapter);
        recyclerView.addItemDecoration(sellContentAdapter.itemDecorator);
        recyclerView.addOnScrollListener(recyclerViewScrollListener);
        refreshLayout = (SwipeRefreshLayout)view.findViewById(0x7f1002e1);
        refreshLayout.setOnRefreshListener(new SellSwipeRefreshListener(this));
_L5:
        updateChannelState();
        return;
_L2:
        if (channel == null || !"ACTIVITY".equals(channel.name) || contentAdapter != null) goto _L4; else goto _L3
_L3:
        contentAdapter = new StartFragmentAdapter(getActivity(), this);
        contentAdapter.setOnClickListener(notificationsClickListener, new int[] {
            0
        });
        contentAdapter.setOnClickListener(watchingClickListener, new int[] {
            1
        });
        contentAdapter.setOnClickListener(recentlyViewedItemsClickListener, new int[] {
            4
        });
        contentAdapter.setOnClickListener(buyingOverviewClickListener, new int[] {
            8
        });
        contentAdapter.setOnClickListener(buyingOverviewClickListener, new int[] {
            9
        });
        contentAdapter.setOnClickListener(overviewErrorClickListener, new int[] {
            10
        });
        contentAdapter.setOnClickListener(sellingOverviewClickListener, new int[] {
            5
        });
        contentAdapter.setOnClickListener(sellingOverviewClickListener, new int[] {
            6
        });
        contentAdapter.setOnClickListener(overviewErrorClickListener, new int[] {
            7
        });
        contentAdapter.setOnClickListener(followingOverviewClickListener, new int[] {
            2
        });
        signIn = view.findViewById(0x7f1002e3);
        if (signIn != null)
        {
            signIn.findViewById(0x7f10029e).setOnClickListener(signInStateClickListener);
            registerButton = signIn.findViewById(0x7f10029d);
            registerButton.setOnClickListener(signInStateClickListener);
            registerButton.setEnabled(true);
        }
        error = view.findViewById(0x7f1002e4);
        if (error != null)
        {
            error.findViewById(0x7f10022c).setOnClickListener(channelErrorClickListener);
        }
        recyclerView = (RecyclerView)view.findViewById(0x7f1002e2);
        recyclerView.addItemDecoration(contentAdapter.itemDecorator);
        recyclerView.setLayoutManager(contentAdapter.createLayoutManager());
        recyclerView.setAdapter(contentAdapter);
        refreshLayout = (SwipeRefreshLayout)view.findViewById(0x7f1002e1);
        refreshLayout.setOnRefreshListener(new ActivitySwipeRefreshListener(this));
          goto _L5
_L4:
        if (channel == null || !"SHOP".equals(channel.name)) goto _L5; else goto _L6
_L6:
        if (view instanceof ViewGroup)
        {
            ((ViewGroup)view).setMotionEventSplittingEnabled(false);
        }
        departmentPager = (ViewPager)view.findViewById(0x7f1002e6);
        if (departmentPager == null || channel.subChannels == null) goto _L5; else goto _L7
_L7:
        if (departmentIndex >= 0 && departmentIndex < channel.subChannels.size()) goto _L9; else goto _L8
_L8:
        int i = 0;
_L10:
        if (i < channel.subChannels.size())
        {
            if (!((Channel)channel.subChannels.get(i)).isLanding)
            {
                break MISSING_BLOCK_LABEL_1349;
            }
            departmentIndex = i;
        }
_L9:
        departmentPager.setAdapter(new DepartmentFragmentAdapter(getChildFragmentManager(), channel.subChannels, flag));
        DepartmentNamesAdapter departmentnamesadapter = new DepartmentNamesAdapter(getActivity(), channel.subChannels, new CarouselOnClickListener(this));
        navigationView = (RecyclerView)view.findViewById(0x7f1002e7);
        if (navigationView != null)
        {
            navigationView.getItemAnimator().setSupportsChangeAnimations(false);
            navigationView.setLayoutManager(new LinearLayoutManager(getBaseActivity(), 0, false));
            navigationView.addOnItemTouchListener(new NoScrollOnItemTouchListener(departmentPager));
            navigationView.setAdapter(departmentnamesadapter);
            departmentPageChangeListener = new DepartmentPageChangeListener(this, navigationView, getActivity(), channel.name);
        }
        departmentPager.setOnPageChangeListener(departmentPageChangeListener);
        if (departmentIndex >= 0)
        {
            departmentPager.setCurrentItem(departmentIndex, false);
            navigationView.getLayoutManager().scrollToPosition(departmentIndex);
            navigationView.addOnLayoutChangeListener(new android.view.View.OnLayoutChangeListener() {

                final StartFragment this$0;

                public void onLayoutChange(View view1, int j, int k, int l, int i1, int j1, int k1, 
                        int l1, int i2)
                {
                    if (navigationView == view1 && departmentPageChangeListener != null)
                    {
                        departmentPageChangeListener.onPageScrolled(departmentIndex, 0.0F, 0);
                    }
                    navigationView.removeOnLayoutChangeListener(this);
                }

            
            {
                this$0 = StartFragment.this;
                super();
            }
            });
        }
          goto _L5
        i++;
          goto _L10
    }

    public Channel getChannel()
    {
        return channel;
    }

    public Intent getRegisterIntent(Context context, boolean flag)
    {
        return RegisterFragment.getStartingIntent(context, flag);
    }

    public boolean isSellChannelEnabled()
    {
        return sellChannelEnabled;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (j == -1 && i == 1 && channelState == ChannelState.STATE_SIGNIN)
        {
            updateChannelState(ChannelState.STATE_LOADING);
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (activity instanceof StartChannelHost)
        {
            startChannelHostReference = new WeakReference((StartChannelHost)activity);
        }
    }

    public void onChannelsChanged(UssChannelsDataManager usschannelsdatamanager, Content content, EbayCountry ebaycountry)
    {
        if (!content.getStatus().hasError()) goto _L2; else goto _L1
_L1:
        sellChannelEnabled = false;
_L4:
        return;
_L2:
        usschannelsdatamanager = (ChannelsContainer)content.getData();
        if (usschannelsdatamanager != null && ((ChannelsContainer) (usschannelsdatamanager)).channels != null)
        {
            usschannelsdatamanager = ((ChannelsContainer) (usschannelsdatamanager)).channels;
        } else
        {
            usschannelsdatamanager = Collections.emptyList();
        }
        sellChannelEnabled = false;
        usschannelsdatamanager = usschannelsdatamanager.iterator();
        do
        {
            if (!usschannelsdatamanager.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
            content = (Channel)usschannelsdatamanager.next();
        } while (!ChannelEnum.SELL.name().equals(((Channel) (content)).name));
        break; /* Loop/switch isn't completed */
        if (true) goto _L4; else goto _L3
_L3:
        sellChannelEnabled = true;
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        boolean flag;
        if (bundle != null)
        {
            channelIndex = bundle.getInt("ChannelIndex");
            channel = (Channel)bundle.getParcelable("Channel");
            departmentIndex = bundle.getInt("DepartmentIndex");
            variationTrackingViewTypes.clear();
            variationTrackingViewTypes.addAll(bundle.getIntegerArrayList("variationTrackingList"));
        } else
        {
            bundle = getArguments();
            if (bundle != null)
            {
                channelIndex = bundle.getInt("ChannelIndex", -1);
                if (startChannelHostReference != null)
                {
                    StartChannelHost startchannelhost = (StartChannelHost)startChannelHostReference.get();
                    if (startchannelhost != null)
                    {
                        channel = startchannelhost.getChannel(new int[] {
                            channelIndex
                        });
                    }
                }
                departmentIndex = bundle.getInt("DepartmentIndex", -1);
            } else
            {
                throw new IllegalArgumentException("CHANNEL_INDEX");
            }
        }
        if (variationTrackingViewTypes.size() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isVariationTrackingRestored = flag;
        updateChannelState(ChannelState.STATE_LOADING);
        initDataManagers();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (channel != null && "SELL".equals(channel.name))
        {
            layoutinflater = layoutinflater.inflate(0x7f030123, viewgroup, false);
        } else
        if (channel != null && "ACTIVITY".equals(channel.name))
        {
            layoutinflater = layoutinflater.inflate(0x7f030123, viewgroup, false);
        } else
        if (channel != null && "SHOP".equals(channel.name))
        {
            layoutinflater = layoutinflater.inflate(0x7f030124, viewgroup, false);
        } else
        {
            layoutinflater = layoutinflater.inflate(0x7f0300b3, viewgroup, false);
        }
        updateView(layoutinflater);
        return layoutinflater;
    }

    public void onDestroyView()
    {
        DataManagerContainer datamanagercontainer = getDataManagerContainer();
        if (datamanagercontainer != null)
        {
            if (ussContentsDataManager != null)
            {
                datamanagercontainer.delete(ussContentsDataManager.getParams());
            }
            datamanagercontainer.delete(ThreatMatrixDataManager.key());
            datamanagercontainer.delete(UserContextDataManager.KEY);
            datamanagercontainer.delete(UssChannelsDataManager.KEY);
        }
        departmentPageChangeListener = null;
        recyclerView = null;
        departmentPager = null;
        navigationView = null;
        signIn = null;
        registerButton = null;
        error = null;
        refreshLayout = null;
        sellContentAdapter = null;
        contentAdapter = null;
        recyclerViewScrollListener = null;
        super.onDestroyView();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        Object obj = null;
        super.onInitializeDataManagers(datamanagercontainer);
        UserContextDataManager usercontextdatamanager = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, null);
        if (usercontextdatamanager.getCurrentCountry() == null)
        {
            usercontextdatamanager.setCurrentCountry(EbayCountryManager.detectCountry());
        }
        datamanagercontainer.initialize(UssChannelsDataManager.KEY, this);
        if (channel != null && "ACTIVITY".equals(channel.name))
        {
            ussContentsDataManager = (UssContentsDataManager)datamanagercontainer.initialize(UssContentsDataManager.getChannelKeyParams(channel.name), this);
        } else
        if (channel != null && "SELL".equals(channel.name))
        {
            PromoRtmObserver promortmobserver = new PromoRtmObserver(this);
            if (promoRtmDataManagerKeyParams != null)
            {
                datamanagercontainer.delete(promoRtmDataManagerKeyParams);
            }
            promoRtmDataManagerKeyParams = new com.ebay.common.content.dm.AdRtmDataManager.KeyParams();
            AdRtmDataManager adrtmdatamanager = (AdRtmDataManager)datamanagercontainer.initialize(promoRtmDataManagerKeyParams, promortmobserver);
            Preferences preferences = MyApp.getPrefs();
            Authentication authentication = preferences.getAuthentication();
            datamanagercontainer = obj;
            if (authentication != null)
            {
                datamanagercontainer = authentication.iafToken;
            }
            adrtmdatamanager.getPromoRtmContext(preferences, preferences.getCurrentSite(), datamanagercontainer, "20375", promortmobserver);
            return;
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        bundle.putInt("ChannelIndex", channelIndex);
        bundle.putParcelable("Channel", channel);
        if (departmentPager != null)
        {
            bundle.putInt("DepartmentIndex", departmentPager.getCurrentItem());
        } else
        {
            bundle.putInt("DepartmentIndex", departmentIndex);
        }
        bundle.putIntegerArrayList("variationTrackingList", variationTrackingViewTypes);
        super.onSaveInstanceState(bundle);
    }

    public void onStreamChanged(UssContentsDataManager usscontentsdatamanager, Content content, boolean flag, boolean flag1)
    {
        usscontentsdatamanager = getActivity();
        if (getView() == null || usscontentsdatamanager == null || usscontentsdatamanager.isFinishing())
        {
            return;
        }
        if (logger.isLoggable)
        {
            logger.log("Got stream data.");
        }
        if (refreshLayout != null)
        {
            refreshLayout.setRefreshing(false);
        }
        ResultStatus resultstatus = content.getStatus();
        if (resultstatus.hasError())
        {
            if (EbayErrorUtil.userNotLoggedIn(resultstatus.getMessages()) && MyApp.getPrefs().isSignedIn())
            {
                MyApp.signOutForIafTokenFailure(usscontentsdatamanager);
                return;
            } else
            {
                updateChannelState(ChannelState.STATE_ERROR);
                return;
            }
        }
        usscontentsdatamanager = (Contents)content.getData();
        if (!hasFullscreenSignIn(usscontentsdatamanager)) goto _L2; else goto _L1
_L1:
        updateChannelState(ChannelState.STATE_SIGNIN);
_L4:
        initialViewType = -1;
        return;
_L2:
        updateChannelState(ChannelState.STATE_LOADED);
        if (contentAdapter != null)
        {
            contentAdapter.setContents(usscontentsdatamanager);
        }
        if (sellContentAdapter != null)
        {
            sellContentAdapter.setContents(usscontentsdatamanager);
            openDraft(draftId);
            flag = getUserVisibleHint();
            if (!isVariationTrackingRestored)
            {
                variationTrackingViewTypes.clear();
            }
            isVariationTrackingRestored = false;
            if (flag && variationTrackingViewTypes.size() < sellContentAdapter.variationIdCount)
            {
                sendSellingTrackingData();
            }
        }
        if (initialViewType > -1)
        {
            final int finalInitialViewType = initialViewType;
            recyclerView.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                final StartFragment this$0;
                final int val$finalInitialViewType;

                public void onGlobalLayout()
                {
                    recyclerView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    scrollToViewType(finalInitialViewType);
                }

            
            {
                this$0 = StartFragment.this;
                finalInitialViewType = i;
                super();
            }
            });
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        super.onTaskComplete(i, fwloader);
    }

    public void openDraft(String s)
    {
        if (sellContentAdapter != null && sellContentAdapter.getDrafts() != null)
        {
            Object obj = sellContentAdapter.getDrafts();
            if (!TextUtils.isEmpty(s))
            {
                obj = ((ListOfSellingDraftsViewModel) (obj)).drafts.iterator();
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        break;
                    }
                    SellingDraftViewModel sellingdraftviewmodel = (SellingDraftViewModel)(ViewModel)((Iterator) (obj)).next();
                    if (!s.equals(sellingdraftviewmodel.draftId))
                    {
                        continue;
                    }
                    openDraft(sellingdraftviewmodel);
                    break;
                } while (true);
                draftId = null;
            }
            return;
        } else
        {
            draftId = s;
            return;
        }
    }

    public void scrollToTop()
    {
        Object obj;
        RecyclerView recyclerview;
        NautilusKernel.verifyMain();
        recyclerview = recyclerView;
        obj = recyclerview;
        if (channel == null) goto _L2; else goto _L1
_L1:
        obj = recyclerview;
        if (!"SHOP".equals(channel.name)) goto _L2; else goto _L3
_L3:
        obj = (StartChannelHost)startChannelHostReference.get();
        if (obj != null) goto _L5; else goto _L4
_L4:
        return;
_L5:
        Object obj1;
        obj1 = ((StartChannelHost) (obj)).getChannel(new int[] {
            ((StartChannelHost) (obj)).getChannelIndex(ChannelEnum.SHOP), departmentPager.getCurrentItem()
        });
        obj = recyclerview;
        if (obj1 != null)
        {
            if (((Channel) (obj1)).isDepartment)
            {
                obj = ((Channel) (obj1)).departmentName;
            } else
            {
                obj = ((Channel) (obj1)).name;
            }
            obj1 = getChildFragmentManager().findFragmentByTag(((String) (obj)));
            obj = recyclerview;
            if (obj1 != null)
            {
                obj = recyclerview;
                if (((Fragment) (obj1)).getView() != null)
                {
                    if (!(obj1 instanceof DepartmentFragment))
                    {
                        break; /* Loop/switch isn't completed */
                    }
                    if (((DepartmentFragment)obj1).isExpanded())
                    {
                        ((DepartmentFragment)obj1).toggleFeaturedCategories();
                    }
                    obj = (RecyclerView)((Fragment) (obj1)).getView().findViewById(0x7f1002e8);
                }
            }
        }
_L2:
        if (obj != null)
        {
            ((RecyclerView) (obj)).getLayoutManager().scrollToPosition(0);
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
        obj = recyclerview;
        if (obj1 instanceof TopLevelCategoriesFragment)
        {
            ((TopLevelCategoriesFragment)obj1).clearSelectedCategory();
            obj = (RecyclerView)((Fragment) (obj1)).getView().findViewById(0x7f1000c8);
        }
          goto _L2
        if (true) goto _L4; else goto _L7
_L7:
    }

    public void scrollToViewType(int i)
    {
        Object obj;
        Object obj1;
        Object obj2;
        Object obj3;
        obj1 = recyclerView;
        if (contentAdapter != null)
        {
            obj = contentAdapter;
        } else
        {
            obj = sellContentAdapter;
        }
        obj3 = obj;
        obj2 = obj1;
        if (channel == null) goto _L2; else goto _L1
_L1:
        obj3 = obj;
        obj2 = obj1;
        if (!"SHOP".equals(channel.name)) goto _L2; else goto _L3
_L3:
        obj2 = (StartChannelHost)startChannelHostReference.get();
        if (obj2 != null) goto _L5; else goto _L4
_L4:
        return;
_L5:
        Object obj4 = ((StartChannelHost) (obj2)).getChannel(new int[] {
            ((StartChannelHost) (obj2)).getChannelIndex(ChannelEnum.SHOP), departmentPager.getCurrentItem()
        });
        obj3 = obj;
        obj2 = obj1;
        if (obj4 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        int j;
        if (((Channel) (obj4)).isDepartment)
        {
            obj2 = ((Channel) (obj4)).departmentName;
        } else
        {
            obj2 = ((Channel) (obj4)).name;
        }
        obj4 = getChildFragmentManager().findFragmentByTag(((String) (obj2)));
        obj3 = obj;
        obj2 = obj1;
        if (obj4 == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj3 = obj;
        obj2 = obj1;
        if (((Fragment) (obj4)).getView() == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (obj4 instanceof DepartmentFragment)
        {
            if (((DepartmentFragment)obj4).isExpanded())
            {
                ((DepartmentFragment)obj4).toggleFeaturedCategories();
            }
            obj = (RecyclerView)((Fragment) (obj4)).getView().findViewById(0x7f1002e8);
        } else
        {
            obj = obj1;
            if (obj4 instanceof TopLevelCategoriesFragment)
            {
                ((TopLevelCategoriesFragment)obj4).clearSelectedCategory();
                obj = (RecyclerView)((Fragment) (obj4)).getView().findViewById(0x7f1000c8);
            }
        }
        if (obj == null)
        {
            obj1 = null;
        } else
        {
            obj1 = ((RecyclerView) (obj)).getAdapter();
        }
        obj3 = (RecyclerContentAdapter)(RecyclerContentAdapter)obj1;
        obj2 = obj;
_L2:
        if (obj3 == null || obj2 == null) goto _L4; else goto _L6
_L6:
        j = ((RecyclerContentAdapter) (obj3)).getPositionForViewType(i);
        if (j > -1)
        {
            recyclerView.getLayoutManager().scrollToPosition(j);
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (((RecyclerContentAdapter) (obj3)).getItemCount() != 0) goto _L4; else goto _L7
_L7:
        initialViewType = i;
        return;
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag && sellContentAdapter != null && variationTrackingViewTypes != null && variationTrackingViewTypes.size() < sellContentAdapter.variationIdCount)
        {
            sendSellingTrackingData();
        }
    }

    public void update()
    {
        if (startChannelHostReference != null)
        {
            StartChannelHost startchannelhost = (StartChannelHost)startChannelHostReference.get();
            if (startchannelhost != null)
            {
                channel = startchannelhost.getChannel(new int[] {
                    channelIndex
                });
            }
        }
        updateView(getView());
    }






/*
    static UssContentsDataManager access$102(StartFragment startfragment, UssContentsDataManager usscontentsdatamanager)
    {
        startfragment.ussContentsDataManager = usscontentsdatamanager;
        return usscontentsdatamanager;
    }

*/











}
