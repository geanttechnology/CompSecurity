// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.groupon.Channel;
import com.groupon.abtest.CabCavOnDealDetailsAbTestHelper;
import com.groupon.abtest.GiftingAbTestHelper;
import com.groupon.abtest.TravelReviewsAbTestHelper;
import com.groupon.activity.transition.DealDetailsRecyclerTransitionController;
import com.groupon.adapter.DealDetailsRecyclerAdapter;
import com.groupon.adapter.widget.FilterableWidgetListAdapter;
import com.groupon.callbacks.DefaultHotelReviewsRequestCallback;
import com.groupon.callbacks.DefaultOnDealDetailsWidgetsEventListener;
import com.groupon.callbacks.DefaultOnExposedOptionsEventListener;
import com.groupon.callbacks.DefaultQandARequestCallback;
import com.groupon.callbacks.DeliveryEstimationLoaderCallback;
import com.groupon.callbacks.DeliveryEstimationSyncCallback;
import com.groupon.callbacks.OnActivityTransitionFinishedListener;
import com.groupon.callbacks.OnBottomBarAnimationFinishedListener;
import com.groupon.callbacks.OnMerchantRecommendationsClickEventListener;
import com.groupon.callbacks.OnPageLoadComplete;
import com.groupon.callbacks.OnRecyclerViewHeaderLoadedListener;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DeliveryEstimation;
import com.groupon.db.models.HotelReviews;
import com.groupon.db.models.Merchant;
import com.groupon.db.models.Option;
import com.groupon.db.models.Pagination;
import com.groupon.events.CustomPageViewEvent;
import com.groupon.loader.DealLoaderCallbacks;
import com.groupon.loader.WidgetsForDealLoaderCallbacks;
import com.groupon.manager.DealSyncManager;
import com.groupon.manager.DeliveryEstimationSyncManager;
import com.groupon.manager.GrouponSyncManager;
import com.groupon.manager.WidgetOnDealDetailsSyncManager;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.models.country.Country;
import com.groupon.models.deal.SharedDealInfo;
import com.groupon.models.dealdetails.DealDetailsViewType;
import com.groupon.models.nst.CSVEncodedNSTField;
import com.groupon.models.nst.DeliveryEstimateImpressionExtraInfo;
import com.groupon.models.nst.InteractionDealIdMetadata;
import com.groupon.models.nst.PageViewExtraInfo;
import com.groupon.models.qadiscussions.QaDiscussionPaginationWrapper;
import com.groupon.mvc.controller.BottomBarController;
import com.groupon.mvc.controller.recycleritem.AdditionalInfoController;
import com.groupon.mvc.controller.recycleritem.AmenitiesController;
import com.groupon.mvc.controller.recycleritem.CabWidgetsController;
import com.groupon.mvc.controller.recycleritem.CavWidgetsController;
import com.groupon.mvc.controller.recycleritem.CompanyInfoController;
import com.groupon.mvc.controller.recycleritem.DateTimeFinderReservationController;
import com.groupon.mvc.controller.recycleritem.DeliveryEstimationController;
import com.groupon.mvc.controller.recycleritem.DetailsHeaderController;
import com.groupon.mvc.controller.recycleritem.DirectionsController;
import com.groupon.mvc.controller.recycleritem.ExposedMultiOptionsController;
import com.groupon.mvc.controller.recycleritem.FinePrintController;
import com.groupon.mvc.controller.recycleritem.GiftingController;
import com.groupon.mvc.controller.recycleritem.HighlightsController;
import com.groupon.mvc.controller.recycleritem.IncentivesController;
import com.groupon.mvc.controller.recycleritem.LiveChatController;
import com.groupon.mvc.controller.recycleritem.MarketplaceController;
import com.groupon.mvc.controller.recycleritem.MerchantRecommendationsController;
import com.groupon.mvc.controller.recycleritem.MoreInfoController;
import com.groupon.mvc.controller.recycleritem.OtherDetailsController;
import com.groupon.mvc.controller.recycleritem.QAndAController;
import com.groupon.mvc.controller.recycleritem.RecyclerItemViewController;
import com.groupon.mvc.controller.recycleritem.TipsController;
import com.groupon.mvc.controller.recycleritem.TravelUgcReviewsController;
import com.groupon.mvc.controller.recycleritem.TripAdvisorReviewsController;
import com.groupon.mvc.controller.recycleritem.WhatYouGetController;
import com.groupon.mvc.view.DealDetailsBottomBarView;
import com.groupon.mvc.view.viewholder.DetailsHeaderViewHolder;
import com.groupon.service.QaDiscussionsService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.marketrate.HotelsService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.ArraySharedPreferences;
import com.groupon.util.BuyUtils;
import com.groupon.util.DealUtils;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.GrouponDialogListener;
import com.groupon.util.GrouponSafeAsyncTask;
import com.groupon.util.LoggingUtils;
import com.groupon.util.MultiOptionUtil;
import com.groupon.util.ShareHelper;
import com.groupon.util.TransparentToolBarRecyclerHelper;
import com.groupon.view.DealDetailsTemporaryImage;
import commonlib.manager.SyncManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            AbstractDetailsBase, IntentFactory

public class DealDetails extends AbstractDetailsBase
    implements CustomPageViewEvent, GrouponDialogListener
{
    private class MoreInfoTask extends GrouponSafeAsyncTask
    {

        private String pitchHtml;
        final DealDetails this$0;

        private String processPitchHtml(String s)
        {
            Object obj = s;
            if (Strings.notEmpty(s))
            {
                Object obj1 = Pattern.compile("(.*)(<\\s*(embed|object).*[\"']([^\"']+youtube[^\"']+).*<\\s*/\\s*(embed|object)\\s*>)(.*)", 32);
                obj = Pattern.compile("([^\"']+youtube[^\"']+)", 2).matcher(s);
                int i;
                for (i = 0; ((Matcher) (obj)).find(); i++) { }
                if (i > 1)
                {
                    obj = ((Matcher) (obj)).replaceFirst("");
                } else
                {
                    obj = s;
                }
                obj1 = ((Pattern) (obj1)).matcher(((CharSequence) (obj)));
                obj = s;
                if (((Matcher) (obj1)).matches())
                {
                    obj = ((Matcher) (obj1)).replaceAll((new StringBuilder()).append("$1<a href=\"$4\">").append(getString(0x7f08040a)).append("</a>$6").toString());
                }
            }
            return ((String) (obj));
        }

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public String call()
            throws Exception
        {
            return processPitchHtml(pitchHtml);
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((String)obj);
        }

        protected void onSuccess(String s)
            throws Exception
        {
            super.onSuccess(s);
            MoreInfoController moreinfocontroller1 = (MoreInfoController)recyclerViewControllersMap.get(DealDetailsViewType.MORE_INFO);
            MoreInfoController moreinfocontroller = moreinfocontroller1;
            if (moreinfocontroller1 == null)
            {
                moreinfocontroller = new MoreInfoController(DealDetails.this);
            }
            moreinfocontroller.setDeal(deal);
            moreinfocontroller.setPitchHtml(s);
            moreinfocontroller.processData();
            doAddRecyclerViewController(DealDetailsViewType.MORE_INFO, moreinfocontroller);
            if (moreinfocontroller.isReady())
            {
                detailsRecyclerView.setItemViewCacheSize(recyclerViewControllersMap.size());
                dealDetailsRecyclerAdapter.insertItem(DealDetailsViewType.MORE_INFO, moreinfocontroller);
            }
        }

        public MoreInfoTask(String s)
        {
            this$0 = DealDetails.this;
            super();
            pitchHtml = s;
        }
    }

    private class OnBottomBarSlideInListener
        implements OnBottomBarAnimationFinishedListener
    {

        final DealDetails this$0;

        public void onBottomBarAnimationFinished(View view)
        {
            if (onPageLoadComplete != null)
            {
                onPageLoadComplete.onLoadComplete();
            }
            view = (android.widget.RelativeLayout.LayoutParams)detailsRecyclerView.getLayoutParams();
            view.addRule(2, 0x7f1000a0);
            detailsRecyclerView.setLayoutParams(view);
        }

        private OnBottomBarSlideInListener()
        {
            this$0 = DealDetails.this;
            super();
        }

    }

    private class OnBottomBarSlideOutListener
        implements OnBottomBarAnimationFinishedListener
    {

        final DealDetails this$0;

        public void onBottomBarAnimationFinished(View view)
        {
            view.setVisibility(4);
            HashMap hashmap = new HashMap(1);
            hashmap.put(Integer.valueOf(0x7f1000a0), view);
            transitionController.addAllAnimatedViews(hashmap);
            transitionController.handleReturnTransition();
            ActivityCompat.finishAfterTransition(DealDetails.this);
        }

        private OnBottomBarSlideOutListener()
        {
            this$0 = DealDetails.this;
            super();
        }

    }

    private class OnDealDetailsHeaderLoadedListener
        implements OnRecyclerViewHeaderLoadedListener
    {

        final DealDetails this$0;

        public void onHeaderLoaded(DetailsHeaderViewHolder detailsheaderviewholder)
        {
            dealImageContainer = detailsheaderviewholder.dealImageContainer;
            imageGradientOverlay = detailsheaderviewholder.imageGradientOverlay;
            temporaryDealImageView = detailsheaderviewholder.temporaryDealImageView;
            titleValuePriceSection = detailsheaderviewholder.titleValuePriceSection;
            isHeaderFullyVisible = true;
            if (shouldEnableCustomEnterTransition())
            {
                handleLollipopSceneTransition();
                return;
            } else
            {
                handleDefaultSceneTransition();
                return;
            }
        }

        public void onHeaderReloaded(DetailsHeaderViewHolder detailsheaderviewholder)
        {
            bottomBarController.displayBottomBar();
        }

        private OnDealDetailsHeaderLoadedListener()
        {
            this$0 = DealDetails.this;
            super();
        }

    }

    private class OnExposedOptionsEventListener extends DefaultOnExposedOptionsEventListener
    {

        final DealDetails this$0;

        public void onOptionSelectionChange(String s)
        {
            selectedOptionIdForExposedMultiOptions = s;
            s = option.remoteId;
            exposedOptionsIds = (new String[] {
                selectedOptionIdForExposedMultiOptions, s
            });
            option = (Option)optionsById.get(selectedOptionIdForExposedMultiOptions);
            bottomBarController.setDealAndOption(deal, option);
            updateBottomBar();
            updateRecyclerViewControllers();
            doInitOrRestartEstimationLoader();
        }

        private OnExposedOptionsEventListener()
        {
            this$0 = DealDetails.this;
            super();
        }

    }

    private class OnFinishListener
        implements com.groupon.mvc.controller.BottomBarController.BottomBarControllerListener
    {

        final DealDetails this$0;

        public void onFinish()
        {
            finish();
        }

        private OnFinishListener()
        {
            this$0 = DealDetails.this;
            super();
        }

    }

    private class OnMerchantRecommendationsClickListener
        implements OnMerchantRecommendationsClickEventListener
    {

        final DealDetails this$0;

        public void onClick(View view, String s)
        {
            detailsRecyclerView.scrollToPosition(dealDetailsRecyclerAdapter.getFirstPositionForItem(DealDetailsViewType.TIPS));
            view = new CSVEncodedNSTField(logger, new String[] {
                s
            });
            logger.logClick("", "dd_recommendation_see_all", dealId, view, Logger.NULL_NST_FIELD);
        }

        private OnMerchantRecommendationsClickListener()
        {
            this$0 = DealDetails.this;
            super();
        }

    }

    private class OnRecyclerViewScrollListener extends android.support.v7.widget.RecyclerView.OnScrollListener
    {

        final DealDetails this$0;

        public void onScrolled(RecyclerView recyclerview, int i, int j)
        {
            super.onScrolled(recyclerview, i, j);
            if (DeviceInfoUtil.getScreenOrientation(DealDetails.this) == 1)
            {
                transparentToolBarRecyclerHelper.adjustToolbarTransparency(j);
            }
            LinearLayoutManager linearlayoutmanager = (LinearLayoutManager)recyclerview.getLayoutManager();
            if (linearlayoutmanager.findLastCompletelyVisibleItemPosition() == recyclerViewControllersMap.size() - 1)
            {
                logger.logUserInteraction("", "end_of_deal_details", getPageViewId(), loggingUtils.encodeAsJson(new InteractionDealIdMetadata(dealId)), Logger.NULL_NST_FIELD);
            }
            recyclerview = (DetailsHeaderController)recyclerViewControllersMap.get(DealDetailsViewType.HEADER);
            if (recyclerview != null)
            {
                boolean flag1 = isHeaderFullyVisible;
                boolean flag;
                if (linearlayoutmanager.findFirstCompletelyVisibleItemPosition() == DealDetailsViewType.HEADER.ordinal())
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag1 != flag)
                {
                    DealDetails dealdetails = DealDetails.this;
                    if (!isHeaderFullyVisible)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    dealdetails.isHeaderFullyVisible = flag;
                    recyclerview.setHeaderFullyVisible(isHeaderFullyVisible);
                    recyclerview.processDealImageViewData();
                    dealDetailsRecyclerAdapter.updateItem(DealDetailsViewType.HEADER, recyclerview);
                }
            }
        }

        private OnRecyclerViewScrollListener()
        {
            this$0 = DealDetails.this;
            super();
        }

    }

    private class OnTransitionFinishedListener
        implements OnActivityTransitionFinishedListener
    {

        final DealDetails this$0;

        public void onTransitionFinished()
        {
            if (deal != null)
            {
                slideInBottomBar();
            } else
            {
                DetailsHeaderController detailsheadercontroller = (DetailsHeaderController)recyclerViewControllersMap.get(DealDetailsViewType.HEADER);
                if (detailsheadercontroller != null)
                {
                    detailsheadercontroller.setDisplayLoadingView(true);
                    detailsheadercontroller.processData();
                    if (detailsheadercontroller.isReady())
                    {
                        dealDetailsRecyclerAdapter.updateItem(DealDetailsViewType.HEADER, detailsheadercontroller);
                        return;
                    }
                }
            }
        }

        private OnTransitionFinishedListener()
        {
            this$0 = DealDetails.this;
            super();
        }

    }

    private class OnWidgetsEventListener extends DefaultOnDealDetailsWidgetsEventListener
    {

        final DealDetails this$0;

        private void initWidgetSyncManager()
        {
            widgetSyncManager.setDealUuid(deal.uuid);
            widgetSyncManager.requestSync(null, null);
        }

        public void onCabWidgetsInitialized(FilterableWidgetListAdapter filterablewidgetlistadapter)
        {
            if (!cabWidgetsLoaderInitialized)
            {
                cabWidgetsLoaderInitialized = true;
                if (cabCavOnDealDetailsAbTestHelper.shouldDisplayCABWidget())
                {
                    filterablewidgetlistadapter = new WidgetsForDealLoaderCallbacks(DealDetails.this, filterablewidgetlistadapter, deal.uuid);
                    getLoaderManager().initLoader(1, null, filterablewidgetlistadapter);
                }
            }
            initWidgetSyncManager();
        }

        public void onCavWidgetsInitialized(FilterableWidgetListAdapter filterablewidgetlistadapter)
        {
            if (!cavWidgetsLoaderInitialized)
            {
                cavWidgetsLoaderInitialized = true;
                if (cabCavOnDealDetailsAbTestHelper.shouldDisplayCAVWidget())
                {
                    filterablewidgetlistadapter = new WidgetsForDealLoaderCallbacks(DealDetails.this, filterablewidgetlistadapter, deal.uuid);
                    getLoaderManager().initLoader(2, null, filterablewidgetlistadapter);
                }
            }
            initWidgetSyncManager();
        }

        private OnWidgetsEventListener()
        {
            this$0 = DealDetails.this;
            super();
        }

    }

    protected static class PeriodicTasks
        implements Runnable
    {

        private static final int TIME_LEFT_UPDATE_INTERVAL = 500;
        private AtomicBoolean canceled;
        private WeakReference contextRef;

        public void cancel()
        {
            canceled.set(true);
        }

        public void run()
        {
            Object obj = (DealDetails)contextRef.get();
            if (obj != null && !canceled.get()) goto _L2; else goto _L1
_L1:
            return;
_L2:
            BottomBarController bottombarcontroller;
            bottombarcontroller = ((DealDetails) (obj)).bottomBarController;
            obj = ((DealDetails) (obj)).handler;
            bottombarcontroller.updateTimeLeftView();
            if (!canceled.get())
            {
                ((Handler) (obj)).postAtTime(this, ((SystemClock.uptimeMillis() + 500L) / 500L) * 500L);
                return;
            }
              goto _L1
            Object obj1;
            obj1;
            if (canceled.get()) goto _L1; else goto _L3
_L3:
            ((Handler) (obj)).postAtTime(this, ((SystemClock.uptimeMillis() + 500L) / 500L) * 500L);
            return;
            obj1;
            if (!canceled.get())
            {
                ((Handler) (obj)).postAtTime(this, ((SystemClock.uptimeMillis() + 500L) / 500L) * 500L);
            }
            throw obj1;
        }

        public PeriodicTasks(DealDetails dealdetails)
        {
            canceled = new AtomicBoolean(false);
            contextRef = new WeakReference(dealdetails);
        }
    }

    private class QandARequestCallback extends DefaultQandARequestCallback
    {

        final DealDetails this$0;

        public void onDiscussionsSuccess(QaDiscussionPaginationWrapper qadiscussionpaginationwrapper)
        {
            qaPostsCount = qadiscussionpaginationwrapper.pagination.getCount();
            insertQandAController(initQandAController(qaPostsCount, false));
        }

        public void onPostsSuccess(List list)
        {
            DealDetails dealdetails = DealDetails.this;
            int i;
            if (list != null)
            {
                i = list.size();
            } else
            {
                i = 0;
            }
            dealdetails.qaPostsCount = i;
            insertQandAController(initQandAController(qaPostsCount, true));
        }

        private QandARequestCallback()
        {
            this$0 = DealDetails.this;
            super();
        }

    }

    private static class TripAdvisorReviewsCallback extends DefaultHotelReviewsRequestCallback
    {

        private WeakReference activityWeakReference;

        public void onHotelReviewsSuccess(HotelReviews hotelreviews)
        {
            if (hotelreviews != null && activityWeakReference.get() != null)
            {
                ((DealDetails)activityWeakReference.get()).insertTripAdvisorReviewsController(((DealDetails)activityWeakReference.get()).initTripAdvisorReviewsController(hotelreviews));
            }
        }

        public TripAdvisorReviewsCallback(DealDetails dealdetails)
        {
            activityWeakReference = new WeakReference(dealdetails);
        }
    }


    private static final String ACTION_REFRESH = "refresh";
    private static final int CAB_WIDGET = 1;
    private static final int CAV_WIDGET = 2;
    public static final String COMING_FROM_GIFTING = "comingFromGifting";
    private static final int DEAL_DETAILS_COMPONENT_PADDING_V2 = 12;
    private static final String DELIVERY_ESTIMATION_IMPRESSION = "shipping_estimate";
    private static final int DELIVERY_ESTIMATION_WIDGET = 3;
    private static final String EXPOSED_OPTIONS_ID = "exposed_options_id";
    private static final float IMAGE_ASCPECT_RATIO = 0.6068182F;
    public static final String IMPRESSION_TYPE_LIVE_CHAT_SHOW_LIVE_CHAT = "show_live_chat";
    public static final String NO = "no";
    private static final String NO_DELIVERY_ESTIMATION_IMPRESSION = "no_shipping_estimate";
    public static final String PLACEMENT_LIVE_CHAT_BOTTOM = "bottom";
    private static final String QA_POSTS_COUNT = "qa_posts_count";
    private static final int QA_POSTS_COUNT_NOT_REQUESTED = -1;
    private static final String SELECTED_OPTION_ID_FOR_EXPOSED_OPTIONS = "selected_option_id_for_exposed_multi_options";
    public static final String SEND_AS_GIFT_CLICK = "send_as_gift_click";
    public static final String YES = "yes";
    private Action appIndexViewAction;
    private BottomBarController bottomBarController;
    DealDetailsBottomBarView bottomBarView;
    private BuyUtils buyUtils;
    private CabCavOnDealDetailsAbTestHelper cabCavOnDealDetailsAbTestHelper;
    private boolean cabWidgetsLoaderInitialized;
    private boolean canDisplayExposedMultiOptions;
    private boolean cavWidgetsLoaderInitialized;
    Channel channel;
    Date checkInDate;
    Date checkOutDate;
    boolean comingFromMyGroupons;
    boolean comingFromShoppingCart;
    private CurrentCountryManager currentCountryManager;
    private DateTimeFinderReservationDetails dateTimeFinderReservationDetails;
    Bundle dateTimeFinderReservationDetailsBundle;
    private Deal deal;
    private DealDetailsRecyclerAdapter dealDetailsRecyclerAdapter;
    String dealId;
    private View dealImageContainer;
    int dealImageWidthWeightLandscape;
    private DealSyncManager dealSyncManager;
    int dealTitleWidthWeightLandscape;
    private String defaultOptionIdForExposedMultiOptions;
    private DeliveryEstimationSyncManager deliveryEstimationSyncManager;
    RecyclerView detailsRecyclerView;
    private String exposedOptionsIds[];
    private boolean gdt1503USCAEnabeld;
    private GiftingAbTestHelper giftingAbTestHelper;
    String goodsCategoryExtraInfo;
    private boolean goodsConnectedMarketPlace1504Enabled;
    private boolean goodsDeliveryEstimate1511USCAEnabled;
    private GoogleApiClient googleApiClient;
    private Handler handler;
    private boolean hasDealBeenIndexed;
    private HotelsService hotelsService;
    private View imageGradientOverlay;
    private boolean isDealClosedOrSoldOut;
    boolean isDeepLinked;
    private boolean isEstimationLoaderInitialized;
    private boolean isHeaderFullyVisible;
    private boolean livechatGADealPage1508USEnabled;
    private boolean mobileOnly1403USCAEnabled;
    private MultiOptionUtil multiOptionUtil;
    private boolean multiOptions1508INTLEnabled;
    int numDealActivitiesOnStack;
    private OnPageLoadComplete onPageLoadComplete;
    private Option option;
    String optionId;
    private Map optionsById;
    private AtomicReference periodicTask;
    private ArraySharedPreferences prefs;
    String preselectedOptionId;
    private QaDiscussionsService qaDiscussionsService;
    private int qaPostsCount;
    private Map recyclerViewControllersMap;
    boolean restartedDueToConfigurationChange;
    View rootView;
    private String selectedOptionIdForExposedMultiOptions;
    SharedDealInfo sharedDealInfo;
    private boolean shouldAddGiftingButtonOnDealDetail;
    boolean shouldLaunchPurchasePage;
    private DealDetailsTemporaryImage temporaryDealImageView;
    private boolean thirdPartyLinkout1509Enabled;
    private boolean tipsRecoUGConDDUSCA1014Enabled;
    private View titleValuePriceSection;
    TextView toolbarTitleText;
    private DealDetailsRecyclerTransitionController transitionController;
    private TransparentToolBarRecyclerHelper transparentToolBarRecyclerHelper;
    private TravelReviewsAbTestHelper travelReviewsAbTestHelper;
    private boolean travelTripAdvisorReviewsEnabled;
    private boolean travelUGCReviewsEnabled;
    private WidgetOnDealDetailsSyncManager widgetSyncManager;

    public DealDetails()
    {
        numDealActivitiesOnStack = 0;
        periodicTask = new AtomicReference();
    }

    private float calculateDealImageHeight()
    {
        float f = (float)dealImageWidthWeightLandscape / (float)(dealImageWidthWeightLandscape + dealTitleWidthWeightLandscape);
        f = (DeviceInfoUtil.getScreenWidthDpi(this) * f - 12F) * 0.6068182F;
        if (getResources().getConfiguration().orientation == 1)
        {
            float f1 = DeviceInfoUtil.getScreenHeightDpi(this) / 3F;
            f = f1;
            if (f1 > 450F)
            {
                f = 450F;
            }
        }
        return f;
    }

    private boolean canDisplaySharedElementTransition()
    {
        return sharedDealInfo != null && sharedDealInfo.dealImageHeight > 0;
    }

    private String[] createExposedOptionsIds(Deal deal1, Option option1)
    {
        String s = option1.remoteId;
        Object obj = null;
        Iterator iterator = deal1.getOptions().iterator();
        deal1 = ((Deal) (obj));
        do
        {
            obj = deal1;
            if (!iterator.hasNext())
            {
                break;
            }
            Option option2 = (Option)iterator.next();
            if (Strings.equals(option1.remoteId, option2.remoteId))
            {
                continue;
            }
            obj = deal1;
            if (deal1 == null)
            {
                obj = option2.remoteId;
            }
            deal1 = ((Deal) (obj));
            if (option2.isSoldOutOrExpired())
            {
                continue;
            }
            obj = option2.remoteId;
            break;
        } while (true);
        return (new String[] {
            s, obj
        });
    }

    private void doAddDeliveryEstimationWidget(DeliveryEstimation deliveryestimation)
    {
        Object obj1 = (DeliveryEstimationController)recyclerViewControllersMap.get(DealDetailsViewType.DELIVERY_ESTIMATION);
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new DeliveryEstimationController(this);
        }
        ((DeliveryEstimationController) (obj)).setDeal(deal);
        if (deliveryestimation != null)
        {
            obj1 = (String)deliveryestimation.estimatesMap.get(option.uuid);
        } else
        {
            obj1 = "";
        }
        ((DeliveryEstimationController) (obj)).setEstimation(((String) (obj1)));
        ((DeliveryEstimationController) (obj)).processData();
        if (recyclerViewControllersMap.containsKey(DealDetailsViewType.DELIVERY_ESTIMATION))
        {
            dealDetailsRecyclerAdapter.updateItem(DealDetailsViewType.DELIVERY_ESTIMATION, ((RecyclerItemViewController) (obj)));
        } else
        if (((DeliveryEstimationController) (obj)).isReady())
        {
            doAddRecyclerViewController(DealDetailsViewType.DELIVERY_ESTIMATION, ((RecyclerItemViewController) (obj)));
            detailsRecyclerView.setItemViewCacheSize(recyclerViewControllersMap.size());
            dealDetailsRecyclerAdapter.insertItem(DealDetailsViewType.DELIVERY_ESTIMATION, ((RecyclerItemViewController) (obj)));
        }
        obj = logger;
        if (deliveryestimation != null && !Strings.isEmpty(deliveryestimation.estimatesMap.get(option.uuid)))
        {
            deliveryestimation = "shipping_estimate";
        } else
        {
            deliveryestimation = "no_shipping_estimate";
        }
        ((Logger) (obj)).logImpression("", deliveryestimation, channel.name(), "", new DeliveryEstimateImpressionExtraInfo(deal));
    }

    private void doAddRecyclerViewController(DealDetailsViewType dealdetailsviewtype, RecyclerItemViewController recycleritemviewcontroller)
    {
        if (recycleritemviewcontroller.isEditing())
        {
            throw new IllegalStateException("After editing a controller please call processData().");
        } else
        {
            recyclerViewControllersMap.put(dealdetailsviewtype, recycleritemviewcontroller);
            return;
        }
    }

    private void doInitOrRestartEstimationLoader()
    {
        DeliveryEstimationLoaderCallback deliveryestimationloadercallback;
label0:
        {
            if (goodsDeliveryEstimate1511USCAEnabled && DealUtils.isGoodsShoppingDeal(deal) && !deliveryEstimationSyncManager.hasAutomaticSyncBeenStarted() && !isDealClosedOrSoldOut)
            {
                deliveryestimationloadercallback = new DeliveryEstimationLoaderCallback(this, deal.uuid, option.uuid) {

                    final DealDetails this$0;

                    public void onDeliveryEstimationLoaded(DeliveryEstimation deliveryestimation)
                    {
                        doAddDeliveryEstimationWidget(deliveryestimation);
                    }

                    public void onEstimationSyncRequested()
                    {
                        startDeliveryEstimationAutomaticSync();
                    }

            
            {
                this$0 = DealDetails.this;
                super(context, s, s1);
            }
                };
                if (!isEstimationLoaderInitialized)
                {
                    break label0;
                }
                getLoaderManager().restartLoader(3, null, deliveryestimationloadercallback);
            }
            return;
        }
        isEstimationLoaderInitialized = true;
        getLoaderManager().initLoader(3, null, deliveryestimationloadercallback);
    }

    private void doOpenShareDialog()
    {
        if (deal != null)
        {
            (new ShareHelper(this, deal.getTitle(), deal.dealUrl)).shareDeal();
        }
    }

    private void handleDefaultSceneTransition()
    {
        if (sharedDealInfo != null)
        {
            temporaryDealImageView.setImageHeight(calculateDealImageHeight());
            temporaryDealImageView.loadImageFromUrl(sharedDealInfo.largeImageUrl, null);
            return;
        } else
        {
            temporaryDealImageView.setVisibility(8);
            return;
        }
    }

    private void handleLollipopSceneTransition()
    {
        HashMap hashmap = new HashMap(7);
        hashmap.put(Integer.valueOf(0x7f100180), toolbar);
        hashmap.put(Integer.valueOf(0x7f100254), rootView);
        hashmap.put(Integer.valueOf(0x7f1000da), detailsRecyclerView);
        hashmap.put(Integer.valueOf(0x7f1004bf), imageGradientOverlay);
        hashmap.put(Integer.valueOf(0x7f100222), dealImageContainer);
        hashmap.put(Integer.valueOf(0x7f100385), temporaryDealImageView);
        hashmap.put(Integer.valueOf(0x7f1004c0), titleValuePriceSection);
        transitionController.initializeController(sharedDealInfo, calculateDealImageHeight(), hashmap);
        transitionController.handleEnterTransition(new OnTransitionFinishedListener());
    }

    private void indexDealDetailPage(Deal deal1)
    {
        if (googleApiClient != null && !isDealClosedOrSoldOut)
        {
            googleApiClient.connect();
            String s;
            Uri uri;
            if (deal1.announcementTitle != null)
            {
                s = deal1.announcementTitle;
            } else
            {
                s = "";
            }
            uri = Uri.parse(String.format("%s://%s/https/www.groupon.com/dispatch/%s/deal/%s", new Object[] {
                "android-app", getApplicationContext().getPackageName(), currentCountryManager.getCurrentCountry().shortName, deal1.remoteId
            }));
            appIndexViewAction = Action.newAction("http://schema.org/ViewAction", s, Uri.parse(deal1.dealUrl), uri);
            AppIndex.AppIndexApi.start(googleApiClient, appIndexViewAction);
        }
    }

    private void initABTestValues()
    {
        boolean flag1 = true;
        boolean flag = currentCountryManager.getCurrentCountry().isUSACompatible();
        tipsRecoUGConDDUSCA1014Enabled = abTestService.isVariantEnabledAndUSCA("tipsRecoUGConDDUSCA1014", "on");
        goodsConnectedMarketPlace1504Enabled = abTestService.isVariantEnabledAndUSCA("goodsConnectedMarketplaceUSCA1504", "on");
        MultiOptionUtil multioptionutil;
        SharedDealInfo shareddealinfo;
        if (!flag && abTestService.isVariantEnabled("multioptions1508INTL", "on"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        multiOptions1508INTLEnabled = flag;
        mobileOnly1403USCAEnabled = abTestService.isVariantEnabled("mobileOnly1403USCA", "on");
        livechatGADealPage1508USEnabled = abTestService.isVariantEnabled("livechatGADealpage1508US", "on");
        gdt1503USCAEnabeld = abTestService.isVariantEnabled("GDT1503USCA", "on");
        goodsDeliveryEstimate1511USCAEnabled = abTestService.isVariantEnabledAndUSCA("goodsDeliveryEstimates1511USCA", "on");
        travelUGCReviewsEnabled = travelReviewsAbTestHelper.isTravelUGCReviewsEnabled();
        multioptionutil = multiOptionUtil;
        shareddealinfo = sharedDealInfo;
        if (dateTimeFinderReservationDetails != null)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        canDisplayExposedMultiOptions = multioptionutil.canDisplayExposedMultiOptions(shareddealinfo, flag);
    }

    private void initABTestValuesAfterDealLoad()
    {
        boolean flag1 = true;
        MultiOptionUtil multioptionutil;
        Deal deal1;
        Channel channel1;
        boolean flag;
        if (DealUtils.hasExternalUrl(deal) && abTestService.isVariantEnabled("thirdPartyLinkout1509", "on"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        thirdPartyLinkout1509Enabled = flag;
        multioptionutil = multiOptionUtil;
        deal1 = deal;
        channel1 = channel;
        if (dateTimeFinderReservationDetails != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        canDisplayExposedMultiOptions = multioptionutil.canDisplayExposedMultiOptions(deal1, channel1, flag);
        if (DealUtils.isGiftableDeal(deal, DealUtils.hasExternalUrl(deal), isDealClosedOrSoldOut) && giftingAbTestHelper.shouldAddGiftingButtonOnDealDetail())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        shouldAddGiftingButtonOnDealDetail = flag;
        if (travelReviewsAbTestHelper.isTravelTripAdvisorReviewsEnabled() && DealUtils.isGetawaysTravelDeal(deal))
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        travelTripAdvisorReviewsEnabled = flag;
    }

    private void initDetailsRecyclerView(boolean flag)
    {
        LinearLayoutManager linearlayoutmanager = new LinearLayoutManager(this);
        linearlayoutmanager.setOrientation(1);
        detailsRecyclerView.setLayoutManager(linearlayoutmanager);
        detailsRecyclerView.setItemAnimator(new DefaultItemAnimator());
        detailsRecyclerView.setOnScrollListener(new OnRecyclerViewScrollListener());
        dealDetailsRecyclerAdapter = new DealDetailsRecyclerAdapter(this, recyclerViewControllersMap);
        if (flag)
        {
            transitionController.setTransitionFinished(true);
        } else
        {
            dealDetailsRecyclerAdapter.setOnHeaderLoadedListener(new OnDealDetailsHeaderLoadedListener());
        }
        detailsRecyclerView.setAdapter(dealDetailsRecyclerAdapter);
    }

    private void initPeriodicTasks()
    {
        PeriodicTasks periodictasks = new PeriodicTasks(this);
        PeriodicTasks periodictasks1 = (PeriodicTasks)periodicTask.getAndSet(periodictasks);
        if (periodictasks1 != null)
        {
            periodictasks1.cancel();
            handler.removeCallbacks(periodictasks1);
        }
        periodictasks.run();
    }

    private QAndAController initQandAController(int i, boolean flag)
    {
        QAndAController qandacontroller1 = (QAndAController)recyclerViewControllersMap.get(DealDetailsViewType.Q_AND_A);
        QAndAController qandacontroller = qandacontroller1;
        if (qandacontroller1 == null)
        {
            qandacontroller = new QAndAController(this);
        }
        qandacontroller.setDeal(deal);
        qandacontroller.setPostsCount(i);
        qandacontroller.setShowNativeScreen(flag);
        qandacontroller.processData();
        return qandacontroller;
    }

    private TripAdvisorReviewsController initTripAdvisorReviewsController(HotelReviews hotelreviews)
    {
        TripAdvisorReviewsController tripadvisorreviewscontroller1 = (TripAdvisorReviewsController)recyclerViewControllersMap.get(DealDetailsViewType.TRAVEL_TRIPADVISOR_REVIEWS);
        TripAdvisorReviewsController tripadvisorreviewscontroller = tripadvisorreviewscontroller1;
        if (tripadvisorreviewscontroller1 == null)
        {
            tripadvisorreviewscontroller = new TripAdvisorReviewsController(this);
        }
        tripadvisorreviewscontroller.setDeal(deal);
        tripadvisorreviewscontroller.setTravelTripAdvisorReviewsEnabled(travelTripAdvisorReviewsEnabled);
        tripadvisorreviewscontroller.setHotelReviews(hotelreviews);
        tripadvisorreviewscontroller.processData();
        return tripadvisorreviewscontroller;
    }

    private void insertQandAController(QAndAController qandacontroller)
    {
        doAddRecyclerViewController(DealDetailsViewType.Q_AND_A, qandacontroller);
        if (qandacontroller.isReady())
        {
            detailsRecyclerView.setItemViewCacheSize(recyclerViewControllersMap.size());
            dealDetailsRecyclerAdapter.insertItem(DealDetailsViewType.Q_AND_A, qandacontroller);
        }
    }

    private void insertTripAdvisorReviewsController(TripAdvisorReviewsController tripadvisorreviewscontroller)
    {
        doAddRecyclerViewController(DealDetailsViewType.TRAVEL_TRIPADVISOR_REVIEWS, tripadvisorreviewscontroller);
        if (tripadvisorreviewscontroller.isReady())
        {
            detailsRecyclerView.setItemViewCacheSize(recyclerViewControllersMap.size());
            dealDetailsRecyclerAdapter.insertItem(DealDetailsViewType.TRAVEL_TRIPADVISOR_REVIEWS, tripadvisorreviewscontroller);
        }
    }

    private void onAfterDealLoaded()
    {
        long l = SystemClock.elapsedRealtime();
        updateToolbarTitle();
        updateBottomBar();
        updateRecyclerViewControllers();
        doInitOrRestartEstimationLoader();
        if (travelTripAdvisorReviewsEnabled && DealUtils.isGetawaysTravelDeal(deal))
        {
            requestTripAdvisorReviews();
        }
        if (!comingFromShoppingCart && !comingFromMyGroupons)
        {
            String s;
            String s1;
            String s2;
            long l1;
            if (deal.isTravelBookableDeal)
            {
                s = "bookingDeal";
            } else
            {
                s = "getawaysDeal";
            }
            if (channel == Channel.GETAWAYS)
            {
                s1 = s;
            } else
            {
                s1 = null;
            }
            if (gdt1503USCAEnabeld && deal.getOptions().size() == 1)
            {
                if (option.specificAttributeDelivery || option.specificAttributeTakeout)
                {
                    s = "on";
                } else
                {
                    s = "off";
                }
            } else
            {
                s = "";
            }
            if (goodsConnectedMarketPlace1504Enabled && deal.shippingAddressRequired && deal.isConnectedMarketPlaceDeal)
            {
                s2 = "marketplace_deal";
            } else
            {
                s2 = "";
            }
            logger.logDealView("", channel.toString(), deal.remoteId, deal.uuid, loggingUtils.getDealViewExtraInfo(deal, isDealClosedOrSoldOut, s1, goodsCategoryExtraInfo, s, s2, defaultOptionIdForExposedMultiOptions, dateTimeFinderReservationDetails));
        }
        l1 = SystemClock.elapsedRealtime();
        logger.logGeneralEvent("deal_performance", "refresh", dealId, (int)(l1 - l), Logger.NULL_NST_FIELD);
    }

    private void requestQAndADiscussions()
    {
        if (!currentCountryManager.getCurrentCountry().isUSACompatible()) goto _L2; else goto _L1
_L1:
        if (qaPostsCount == -1) goto _L4; else goto _L3
_L3:
        doAddRecyclerViewController(DealDetailsViewType.Q_AND_A, initQandAController(qaPostsCount, false));
_L6:
        return;
_L4:
        qaDiscussionsService.getDiscussions(dealId, new QandARequestCallback());
        return;
_L2:
        if (currentCountryManager.getCurrentCountry().isRussia())
        {
            if (qaPostsCount != -1)
            {
                doAddRecyclerViewController(DealDetailsViewType.Q_AND_A, initQandAController(qaPostsCount, true));
                return;
            } else
            {
                qaDiscussionsService.getPosts(dealId, null, new QandARequestCallback());
                return;
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void requestTripAdvisorReviews()
    {
        hotelsService.getHotelReviews(deal.uuid, getString(0x7f080464), new TripAdvisorReviewsCallback(this));
    }

    private void setupInitialViewControllers()
    {
        recyclerViewControllersMap = new LinkedHashMap();
        if (sharedDealInfo != null)
        {
            DetailsHeaderController detailsheadercontroller = new DetailsHeaderController(this);
            detailsheadercontroller.setSharedDealInfo(sharedDealInfo);
            detailsheadercontroller.setPreselectedOptionId(preselectedOptionId);
            detailsheadercontroller.setChannel(channel);
            detailsheadercontroller.setMultiOptions1508INTLEnabled(multiOptions1508INTLEnabled);
            detailsheadercontroller.setCanDisplayExposedMultiOptions(canDisplayExposedMultiOptions);
            detailsheadercontroller.setComingFromMyGroupons(comingFromMyGroupons);
            detailsheadercontroller.setGoodsConnectedMarketPlace1504Enabled(goodsConnectedMarketPlace1504Enabled);
            if (!shouldEnableCustomEnterTransition())
            {
                detailsheadercontroller.setDisplayLoadingView(true);
            }
            detailsheadercontroller.processData();
            doAddRecyclerViewController(DealDetailsViewType.HEADER, detailsheadercontroller);
            if (detailsheadercontroller.isReady())
            {
                detailsRecyclerView.setItemViewCacheSize(recyclerViewControllersMap.size());
            }
        }
        bottomBarController = new BottomBarController(this, bottomBarView, new OnFinishListener());
        bottomBarController.setPreselectedOptionId(preselectedOptionId);
        bottomBarController.setChannel(channel);
        bottomBarController.setCheckInDate(checkInDate);
        bottomBarController.setCheckOutDate(checkOutDate);
        bottomBarController.setComingFromShoppingCart(comingFromShoppingCart);
        bottomBarController.setComingFromMyGroupons(comingFromMyGroupons);
        bottomBarController.setShowViewCart(false);
        bottomBarController.setMobileOnly1403USCAEnabled(mobileOnly1403USCAEnabled);
        bottomBarController.setGdt1503USCAEnabled(gdt1503USCAEnabeld);
    }

    private boolean shouldEnableCustomEnterTransition()
    {
        return android.os.Build.VERSION.SDK_INT >= 21 && !restartedDueToConfigurationChange && canDisplaySharedElementTransition();
    }

    private void slideInBottomBar()
    {
        bottomBarController.slideInBottomBar(new OnBottomBarSlideInListener());
    }

    private void startDeliveryEstimationAutomaticSync()
    {
        deliveryEstimationSyncManager.setDealUUID(deal.uuid);
        deliveryEstimationSyncManager.setOptionUUID(option.uuid);
        deliveryEstimationSyncManager.startAutomaticSyncs(new DeliveryEstimationSyncCallback(this, deliveryEstimationSyncManager) {

            final DealDetails this$0;

            public void addDeliveryEstimationWidget(DeliveryEstimation deliveryestimation)
            {
                doAddDeliveryEstimationWidget(deliveryestimation);
            }

            
            {
                this$0 = DealDetails.this;
                super(context, deliveryestimationsyncmanager);
            }
        }, null);
        deliveryEstimationSyncManager.setAutomaticSyncStatus(true);
    }

    private void updateBottomBar()
    {
        bottomBarController.setDealAndOption(deal, option);
        bottomBarController.setThirdPartyLinkout1509Enabled(thirdPartyLinkout1509Enabled);
        bottomBarController.setCanDisplayExposedMultiOptions(canDisplayExposedMultiOptions);
        bottomBarController.setDefaultOptionIdForExposedMultiOptions(defaultOptionIdForExposedMultiOptions);
        bottomBarController.setDateTimeFinderReservationDetails(dateTimeFinderReservationDetails);
        bottomBarController.setIsDeepLinked(isDeepLinked);
        bottomBarController.updateBuyButtonView();
        bottomBarController.updateTimeLeftView();
        bottomBarController.updateShoppingCartView();
        if (android.os.Build.VERSION.SDK_INT < 21 || restartedDueToConfigurationChange || transitionController.isTransitionFinished() || !canDisplaySharedElementTransition())
        {
            slideInBottomBar();
        }
    }

    private void updateRecyclerViewControllers()
    {
        Object obj1 = (DetailsHeaderController)recyclerViewControllersMap.get(DealDetailsViewType.HEADER);
        Object obj = obj1;
        if (obj1 == null)
        {
            obj = new DetailsHeaderController(this);
        }
        ((DetailsHeaderController) (obj)).setDeal(deal);
        ((DetailsHeaderController) (obj)).setOption(option);
        ((DetailsHeaderController) (obj)).setPreselectedOptionId(preselectedOptionId);
        ((DetailsHeaderController) (obj)).setChannel(channel);
        ((DetailsHeaderController) (obj)).setMobileOnly1403USCAEnabled(mobileOnly1403USCAEnabled);
        ((DetailsHeaderController) (obj)).setMultiOptions1508INTLEnabled(multiOptions1508INTLEnabled);
        ((DetailsHeaderController) (obj)).setCanDisplayExposedMultiOptions(canDisplayExposedMultiOptions);
        ((DetailsHeaderController) (obj)).setComingFromMyGroupons(comingFromMyGroupons);
        ((DetailsHeaderController) (obj)).setHeaderFullyVisible(isHeaderFullyVisible);
        ((DetailsHeaderController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.HEADER, ((RecyclerItemViewController) (obj)));
        obj1 = (DateTimeFinderReservationController)recyclerViewControllersMap.get(DealDetailsViewType.DATE_TIME_FINDER_RESERVATION);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new DateTimeFinderReservationController(this);
        }
        ((DateTimeFinderReservationController) (obj)).setDeal(deal);
        ((DateTimeFinderReservationController) (obj)).setOption(option);
        ((DateTimeFinderReservationController) (obj)).setChannel(channel);
        ((DateTimeFinderReservationController) (obj)).setDefaultOptionIdForExposedMultiOptions(defaultOptionIdForExposedMultiOptions);
        ((DateTimeFinderReservationController) (obj)).setDateTimeFinderReservationDetails(dateTimeFinderReservationDetails);
        ((DateTimeFinderReservationController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.DATE_TIME_FINDER_RESERVATION, ((RecyclerItemViewController) (obj)));
        obj1 = (ExposedMultiOptionsController)recyclerViewControllersMap.get(DealDetailsViewType.VERTICALLY_EXPOSED_MULTI_OPTIONS);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new ExposedMultiOptionsController(this);
        }
        ((ExposedMultiOptionsController) (obj)).setDeal(deal);
        ((ExposedMultiOptionsController) (obj)).setOption(option);
        ((ExposedMultiOptionsController) (obj)).setChannel(channel);
        ((ExposedMultiOptionsController) (obj)).setExposedOptionsIds(exposedOptionsIds);
        ((ExposedMultiOptionsController) (obj)).setPageViewId(getPageViewId());
        ((ExposedMultiOptionsController) (obj)).setDefaultOptionIdForExposedMultiOptions(defaultOptionIdForExposedMultiOptions);
        ((ExposedMultiOptionsController) (obj)).setIsDeepLinked(isDeepLinked);
        ((ExposedMultiOptionsController) (obj)).setCanDisplayExposedMultiOptions(canDisplayExposedMultiOptions);
        ((ExposedMultiOptionsController) (obj)).setOnExposedOptionsEventListener(new OnExposedOptionsEventListener());
        ((ExposedMultiOptionsController) (obj)).setDateTimeFinderReservationDetails(dateTimeFinderReservationDetails);
        ((ExposedMultiOptionsController) (obj)).setGdt1503USCAEnabled(gdt1503USCAEnabeld);
        ((ExposedMultiOptionsController) (obj)).setComingFromMyGroupons(comingFromMyGroupons);
        ((ExposedMultiOptionsController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.VERTICALLY_EXPOSED_MULTI_OPTIONS, ((RecyclerItemViewController) (obj)));
        obj1 = (IncentivesController)recyclerViewControllersMap.get(DealDetailsViewType.INCENTIVES);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new IncentivesController(this);
        }
        ((IncentivesController) (obj)).setDeal(deal);
        ((IncentivesController) (obj)).setOption(option);
        ((IncentivesController) (obj)).setChannel(channel);
        ((IncentivesController) (obj)).setPreselectedOptionId(preselectedOptionId);
        ((IncentivesController) (obj)).setMobileOnly1403USCAEnabled(mobileOnly1403USCAEnabled);
        ((IncentivesController) (obj)).setCanDisplayExposedMultiOptions(canDisplayExposedMultiOptions);
        ((IncentivesController) (obj)).setIsDeepLinked(isDeepLinked);
        boolean flag;
        if (dateTimeFinderReservationDetails != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((IncentivesController) (obj)).setDtfFlowEnabled(flag);
        ((IncentivesController) (obj)).setCheckInDate(checkInDate);
        ((IncentivesController) (obj)).setCheckOutDate(checkOutDate);
        ((IncentivesController) (obj)).setComingFromMyGroupons(comingFromMyGroupons);
        ((IncentivesController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.INCENTIVES, ((RecyclerItemViewController) (obj)));
        obj1 = (MerchantRecommendationsController)recyclerViewControllersMap.get(DealDetailsViewType.MERCHANT_RECOMMENDATION);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new MerchantRecommendationsController(this);
        }
        ((MerchantRecommendationsController) (obj)).setDeal(deal);
        ((MerchantRecommendationsController) (obj)).setRecommendationsClickListener(new OnMerchantRecommendationsClickListener());
        ((MerchantRecommendationsController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.MERCHANT_RECOMMENDATION, ((RecyclerItemViewController) (obj)));
        obj1 = (MarketplaceController)recyclerViewControllersMap.get(DealDetailsViewType.MARKETPLACE);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new MarketplaceController(this);
        }
        ((MarketplaceController) (obj)).setDeal(deal);
        ((MarketplaceController) (obj)).setPageViewId(getPageViewId());
        ((MarketplaceController) (obj)).setGoodsConnectedMarketPlace1504Enabled(goodsConnectedMarketPlace1504Enabled);
        ((MarketplaceController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.MARKETPLACE, ((RecyclerItemViewController) (obj)));
        obj1 = (HighlightsController)recyclerViewControllersMap.get(DealDetailsViewType.HIGHLIGHTS);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new HighlightsController(this);
        }
        ((HighlightsController) (obj)).setDeal(deal);
        ((HighlightsController) (obj)).setOption(option);
        ((HighlightsController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.HIGHLIGHTS, ((RecyclerItemViewController) (obj)));
        obj1 = (TravelUgcReviewsController)recyclerViewControllersMap.get(DealDetailsViewType.TRAVEL_UGC_REVIEWS);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new TravelUgcReviewsController(this);
        }
        ((TravelUgcReviewsController) (obj)).setDeal(deal);
        if (travelUGCReviewsEnabled && DealUtils.isGetawaysTravelDeal(deal))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((TravelUgcReviewsController) (obj)).setTravelUGCReviewsEnabled(flag);
        ((TravelUgcReviewsController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.TRAVEL_UGC_REVIEWS, ((RecyclerItemViewController) (obj)));
        obj1 = (CabWidgetsController)recyclerViewControllersMap.get(DealDetailsViewType.CAB_WIDGETS);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new CabWidgetsController(this);
        }
        ((CabWidgetsController) (obj)).setDeal(deal);
        ((CabWidgetsController) (obj)).setChannel(channel);
        if (comingFromMyGroupons || comingFromShoppingCart)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((CabWidgetsController) (obj)).setFromMyGrouponsOrShoppingCart(flag);
        ((CabWidgetsController) (obj)).setNumDealActivitiesOnStack(numDealActivitiesOnStack);
        ((CabWidgetsController) (obj)).setActivityWidgetsCallback(new OnWidgetsEventListener());
        ((CabWidgetsController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.CAB_WIDGETS, ((RecyclerItemViewController) (obj)));
        obj1 = (GiftingController)recyclerViewControllersMap.get(DealDetailsViewType.GIFTING);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new GiftingController(this);
        }
        ((GiftingController) (obj)).setDeal(deal);
        ((GiftingController) (obj)).setOption(option);
        ((GiftingController) (obj)).setPageViewId(getPageViewId());
        ((GiftingController) (obj)).setPreselectedOptionId(preselectedOptionId);
        ((GiftingController) (obj)).setMobileOnly1403USCAEnabled(mobileOnly1403USCAEnabled);
        ((GiftingController) (obj)).setCanDisplayExposedMultiOptions(canDisplayExposedMultiOptions);
        ((GiftingController) (obj)).setIsDealClosedOrSoldOut(isDealClosedOrSoldOut);
        ((GiftingController) (obj)).setShouldAddGiftingButtonOnDealDetail(shouldAddGiftingButtonOnDealDetail);
        ((GiftingController) (obj)).setChannel(channel);
        ((GiftingController) (obj)).setComingFromMyGroupons(comingFromMyGroupons);
        ((GiftingController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.GIFTING, ((RecyclerItemViewController) (obj)));
        obj1 = (WhatYouGetController)recyclerViewControllersMap.get(DealDetailsViewType.WHAT_YOU_GET);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new WhatYouGetController(this);
        }
        ((WhatYouGetController) (obj)).setDeal(deal);
        ((WhatYouGetController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.WHAT_YOU_GET, ((RecyclerItemViewController) (obj)));
        obj1 = (FinePrintController)recyclerViewControllersMap.get(DealDetailsViewType.FINE_PRINT);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new FinePrintController(this);
        }
        ((FinePrintController) (obj)).setDeal(deal);
        ((FinePrintController) (obj)).setOption(option);
        ((FinePrintController) (obj)).setChannel(channel);
        ((FinePrintController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.FINE_PRINT, ((RecyclerItemViewController) (obj)));
        obj1 = (CompanyInfoController)recyclerViewControllersMap.get(DealDetailsViewType.COMPANY_INFO);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new CompanyInfoController(this);
        }
        ((CompanyInfoController) (obj)).setDeal(deal);
        ((CompanyInfoController) (obj)).setOption(option);
        ((CompanyInfoController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.COMPANY_INFO, ((RecyclerItemViewController) (obj)));
        obj1 = (DirectionsController)recyclerViewControllersMap.get(DealDetailsViewType.DIRECTIONS);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new DirectionsController(this);
        }
        ((DirectionsController) (obj)).setDeal(deal);
        ((DirectionsController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.DIRECTIONS, ((RecyclerItemViewController) (obj)));
        obj1 = (AdditionalInfoController)recyclerViewControllersMap.get(DealDetailsViewType.ADDITIONAL_INFO);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new AdditionalInfoController(this);
        }
        ((AdditionalInfoController) (obj)).setOption(option);
        ((AdditionalInfoController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.ADDITIONAL_INFO, ((RecyclerItemViewController) (obj)));
        if (currentCountryManager.getCurrentCountry().isJapan() && option != null && Strings.notEmpty(option.pitchHtml))
        {
            obj = option.pitchHtml;
        } else
        {
            obj = deal.pitchHtml;
        }
        (new MoreInfoTask(((String) (obj)))).execute();
        obj1 = (AmenitiesController)recyclerViewControllersMap.get(DealDetailsViewType.AMENITIES);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new AmenitiesController(this);
        }
        ((AmenitiesController) (obj)).setDeal(deal);
        ((AmenitiesController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.AMENITIES, ((RecyclerItemViewController) (obj)));
        obj1 = (OtherDetailsController)recyclerViewControllersMap.get(DealDetailsViewType.OTHER_DETAILS);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new OtherDetailsController(this);
        }
        ((OtherDetailsController) (obj)).setDeal(deal);
        ((OtherDetailsController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.OTHER_DETAILS, ((RecyclerItemViewController) (obj)));
        obj = new TipsController(this);
        ((TipsController) (obj)).setDeal(deal);
        ((TipsController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.TIPS, ((RecyclerItemViewController) (obj)));
        requestQAndADiscussions();
        obj1 = (CavWidgetsController)recyclerViewControllersMap.get(DealDetailsViewType.CAV_WIDGETS);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new CavWidgetsController(this);
        }
        ((CavWidgetsController) (obj)).setDeal(deal);
        ((CavWidgetsController) (obj)).setChannel(channel);
        if (comingFromMyGroupons || comingFromShoppingCart)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((CavWidgetsController) (obj)).setFromMyGrouponsOrShoppingCart(flag);
        ((CavWidgetsController) (obj)).setNumDealActivitiesOnStack(numDealActivitiesOnStack);
        ((CavWidgetsController) (obj)).setActivityWidgetsCallback(new OnWidgetsEventListener());
        ((CavWidgetsController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.CAV_WIDGETS, ((RecyclerItemViewController) (obj)));
        obj1 = (LiveChatController)recyclerViewControllersMap.get(DealDetailsViewType.LIVE_CHAT);
        obj = obj1;
        if (obj1 == null)
        {
            obj = new LiveChatController(this);
        }
        ((LiveChatController) (obj)).setDeal(deal);
        ((LiveChatController) (obj)).setChannel(channel);
        ((LiveChatController) (obj)).setPageViewId(getPageViewId());
        ((LiveChatController) (obj)).setLiveChatGADealPage1508USEnabled(livechatGADealPage1508USEnabled);
        ((LiveChatController) (obj)).processData();
        doAddRecyclerViewController(DealDetailsViewType.LIVE_CHAT, ((RecyclerItemViewController) (obj)));
        detailsRecyclerView.setItemViewCacheSize(recyclerViewControllersMap.size());
        dealDetailsRecyclerAdapter.alterItemRange(recyclerViewControllersMap);
    }

    private void updateToolbarTitle()
    {
        String s;
        if (deal.merchant == null)
        {
            s = "";
        } else
        {
            s = deal.merchant.name;
        }
        if (!Strings.notEmpty(s))
        {
            s = deal.title;
        }
        toolbarTitleText.setText(s);
    }

    protected void forceReloadForDevMode()
    {
        dealSyncManager.requestSync(this, null);
        CabCavOnDealDetailsAbTestHelper cabcavondealdetailsabtesthelper = cabCavOnDealDetailsAbTestHelper;
        Deal deal1 = deal;
        boolean flag;
        if (comingFromMyGroupons || comingFromShoppingCart)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (cabcavondealdetailsabtesthelper.shouldDisplayWidgets(deal1, flag, numDealActivitiesOnStack))
        {
            widgetSyncManager.requestSync(null, null);
        }
    }

    public android.app.LoaderManager.LoaderCallbacks getLoaderCallBack()
    {
        long l = SystemClock.elapsedRealtime();
        String s = dealId;
        Date date = checkInDate;
        Date date1 = checkOutDate;
        boolean flag;
        if (travelUGCReviewsEnabled || tipsRecoUGConDDUSCA1014Enabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return new DealLoaderCallbacks(s, date, date1, flag, goodsConnectedMarketPlace1504Enabled, l) {

            final DealDetails this$0;
            final long val$dealLoaderCallbacksStartTime;

            public void onDealLoaded(Deal deal1)
            {
                boolean flag4 = false;
                int i;
                boolean flag3;
                if (!currentCountryManager.getCurrentCountry().isJapan())
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                i = deal1.optionDimensionsCount(flag3, currentCountryManager.getCurrentCountry().isUSACompatible());
                if (isDeepLinked && buyUtils.showOptionsWithImages(deal1, DealDetails.this))
                {
                    startActivity(intentFactory.newGoodsMultiOptionIntent(deal1.remoteId, channel, i).putExtra("isDeepLinked", isDeepLinked));
                    finish();
                    return;
                }
                deal = deal1;
                optionsById = DealUtils.createOptionsByIdMap(deal1);
                initABTestValuesAfterDealLoad();
                DealDetails dealdetails;
                long l1;
                if (Strings.notEmpty(selectedOptionIdForExposedMultiOptions))
                {
                    option = (Option)optionsById.get(selectedOptionIdForExposedMultiOptions);
                } else
                {
label0:
                    {
                        if (!Strings.notEmpty(preselectedOptionId))
                        {
                            break label0;
                        }
                        option = (Option)optionsById.get(preselectedOptionId);
                    }
                }
_L2:
label1:
                {
                    if (option == null)
                    {
                        option = (Option)optionsById.get(deal1.defaultOptionId);
                    }
                    if (exposedOptionsIds == null && option != null)
                    {
                        exposedOptionsIds = createExposedOptionsIds(deal1, option);
                    }
                    Iterator iterator;
                    Option option1;
                    boolean flag1;
                    boolean flag2;
                    if (Strings.equalsIgnoreCase("closed", deal1.status) || option != null && Strings.equalsIgnoreCase("closed", option.status))
                    {
                        flag1 = true;
                    } else
                    {
                        flag1 = false;
                    }
                    if (deal1.isSoldOut() || option != null && option.isSoldOut())
                    {
                        flag2 = true;
                    } else
                    {
                        flag2 = false;
                    }
                    if (!flag1)
                    {
                        initPeriodicTasks();
                    }
                    dealdetails = DealDetails.this;
                    if (!flag1)
                    {
                        flag3 = flag4;
                        if (!flag2)
                        {
                            break label1;
                        }
                    }
                    flag3 = true;
                }
                dealdetails.isDealClosedOrSoldOut = flag3;
                if (!hasDealBeenIndexed)
                {
                    indexDealDetailPage(deal1);
                    hasDealBeenIndexed = true;
                }
                onAfterDealLoaded();
                l1 = SystemClock.elapsedRealtime();
                logger.logGeneralEvent("deal_performance", "on_deal_detals_loaded", dealId, (int)(l1 - dealLoaderCallbacksStartTime), Logger.NULL_NST_FIELD);
                return;
                iterator = deal1.getOptions().iterator();
_L4:
                if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
                option1 = (Option)iterator.next();
                if (option1.isSoldOutOrExpired()) goto _L4; else goto _L3
_L3:
                option = option1;
                defaultOptionIdForExposedMultiOptions = option.remoteId;
                  goto _L2
            }

            public void onLoadFinished(Loader loader, Deal deal1)
            {
                super.onLoadFinished(loader, deal1);
            }

            public volatile void onLoadFinished(Loader loader, Object obj)
            {
                onLoadFinished(loader, (Deal)obj);
            }

            
            {
                this$0 = DealDetails.this;
                dealLoaderCallbacksStartTime = l;
                super(final_context, s, date, date1, flag, flag1);
            }
        };
    }

    public GrouponSyncManager getSyncManager()
    {
        return dealSyncManager;
    }

    public volatile SyncManager getSyncManager()
    {
        return getSyncManager();
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        if (DeviceInfoUtil.getScreenOrientation(this) == 1)
        {
            transparentToolBarRecyclerHelper.initToolBar(this, calculateDealImageHeight());
        }
    }

    protected void initLollipopSceneTransition()
    {
        postponeEnterTransition();
    }

    public void logPageViewEvent()
    {
        String s1 = "";
        String s = s1;
        if (sharedDealInfo != null)
        {
            s = s1;
            if (sharedDealInfo.secondLevelDealCategories != null)
            {
                s = s1;
                String s2;
                if (!sharedDealInfo.secondLevelDealCategories.isEmpty())
                {
                    if (sharedDealInfo.secondLevelDealCategories.contains("food-and-drink"))
                    {
                        s = "F&D";
                    } else
                    {
                        s = s1;
                        if (sharedDealInfo.secondLevelDealCategories.contains("beauty-and-spas"))
                        {
                            s = "HBW";
                        }
                    }
                }
            }
        }
        s2 = "";
        s1 = s2;
        if (Strings.notEmpty(s))
        {
            s1 = s2;
            if (dateTimeFinderReservationDetails != null)
            {
                if (dateTimeFinderReservationDetails.partialIntent)
                {
                    s1 = "partial";
                } else
                {
                    s1 = "full";
                }
            }
        }
        logger.logPageView("", getClass().getSimpleName(), new PageViewExtraInfo(dealId, s, s1));
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (i == 10149 && -1 == j && intent != null)
        {
            DetailsHeaderController detailsheadercontroller = (DetailsHeaderController)recyclerViewControllersMap.get(DealDetailsViewType.HEADER);
            if (detailsheadercontroller != null)
            {
                detailsheadercontroller.setImageCarouselPosition(intent.getIntExtra("image_carousel_current_position", 0));
                detailsheadercontroller.processDealImageViewData();
                dealDetailsRecyclerAdapter.updateItem(DealDetailsViewType.HEADER, detailsheadercontroller);
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        long l1 = SystemClock.elapsedRealtime();
        long l = SystemClock.currentThreadTimeMillis();
        super.onCreate(bundle);
        if (isDeepLinked && shouldLaunchPurchasePage)
        {
            Intent intent1 = intentFactory.newPurchaseLoginIntent(dealId, optionId, channel);
            Intent intent2 = (Intent)intent1.getParcelableExtra("next");
            Intent intent = intent2;
            if (intent2 == null)
            {
                intent = intent1;
            }
            intent.putExtra("isDeepLinked", true).putExtra("should_launch_purchase_page", shouldLaunchPurchasePage).putExtra("is_wearable_preview_purchase", getIntent().getBooleanExtra("is_wearable_preview_purchase", false));
            startActivity(intent1);
        }
        if (dateTimeFinderReservationDetailsBundle != null)
        {
            dateTimeFinderReservationDetails = (DateTimeFinderReservationDetails)dateTimeFinderReservationDetailsBundle.getParcelable("reservation_details");
        }
        initABTestValues();
        numDealActivitiesOnStack = numDealActivitiesOnStack + 1;
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            googleApiClient = (new com.google.android.gms.common.api.GoogleApiClient.Builder(this)).addApi(AppIndex.API).build();
        }
        if (channel == null)
        {
            channel = Channel.DETAIL;
        }
        if (checkInDate != null && checkOutDate != null)
        {
            dealSyncManager.setForceDownload(true);
        }
        setContentView(0x7f03001d);
        onPageLoadComplete = new OnPageLoadComplete(logger, l1);
        boolean flag;
        if (bundle != null)
        {
            qaPostsCount = bundle.getInt("qa_posts_count");
            selectedOptionIdForExposedMultiOptions = bundle.getString("selected_option_id_for_exposed_multi_options");
            exposedOptionsIds = bundle.getStringArray("exposed_options_id");
        } else
        {
            qaPostsCount = -1;
        }
        setupInitialViewControllers();
        if (bundle != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        initDetailsRecyclerView(flag);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            initLollipopSceneTransition();
        }
        initLoaderManager();
        abTestService.isVariantEnabled("AAonDealDetailsPage1510", "On");
        l1 = SystemClock.elapsedRealtime();
        logger.logGeneralEvent("deal_performance", "deal_details_onCreate", dealId, (int)(l1 - l), Logger.NULL_NST_FIELD);
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        menu.add(0, 0x7f10001d, 0, 0x7f080370).setIcon(0x7f0201f5).setShowAsAction(2);
        if (prefs.getBoolean("showActivityRefreshMenuItem", false))
        {
            menu.add(0, 0x7f10001a, 0, 0x7f080310);
        }
        return super.onCreateOptionsMenu(menu);
    }

    protected void onDestroy()
    {
        handler.removeCallbacks((Runnable)periodicTask.get());
        DetailsHeaderController detailsheadercontroller = (DetailsHeaderController)recyclerViewControllersMap.get(DealDetailsViewType.HEADER);
        if (detailsheadercontroller != null)
        {
            detailsheadercontroller.setHeaderFullyVisible(false);
            detailsheadercontroller.processDealImageViewData();
            dealDetailsRecyclerAdapter.updateItem(DealDetailsViewType.HEADER, detailsheadercontroller);
        }
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        menuitem.getItemId();
        JVM INSTR lookupswitch 3: default 40
    //                   16908332: 46
    //                   2131755034: 158
    //                   2131755037: 151;
           goto _L1 _L2 _L3 _L4
_L1:
        return super.onOptionsItemSelected(menuitem);
_L2:
        if (getIntent().getFlags() == 0x4000000)
        {
            if (channel == null && deal != null && !deal.getChannelList().isEmpty())
            {
                channel = (Channel)deal.getChannelList().iterator().next();
            }
            if (channel != Channel.WIDGET)
            {
                ActionBarUtil.navigateUpTo(this, channel, intentFactory.newCarouselChannelIntent(channel, new String[0]), intentFactory.newCarouselIntent());
                return true;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        doOpenShareDialog();
        continue; /* Loop/switch isn't completed */
_L3:
        forceReloadForDevMode();
        if (true) goto _L1; else goto _L5
_L5:
    }

    protected void onResume()
    {
        super.onResume();
        bottomBarController.onResume();
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putInt("qa_posts_count", qaPostsCount);
        bundle.putString("selected_option_id_for_exposed_multi_options", selectedOptionIdForExposedMultiOptions);
        bundle.putStringArray("exposed_options_id", exposedOptionsIds);
    }

    protected void onStop()
    {
        if (googleApiClient != null && appIndexViewAction != null)
        {
            AppIndex.AppIndexApi.end(googleApiClient, appIndexViewAction);
            googleApiClient.disconnect();
        }
        deliveryEstimationSyncManager.stopAutomaticSyncs();
        super.onStop();
    }

    protected boolean shouldStartAutomaticSyncsOnResume()
    {
        return android.os.Build.VERSION.SDK_INT < 21 || !transitionController.shouldStartSceneTransition();
    }

    public void supportFinishAfterTransition()
    {
        setResult(-1);
        int i = ((LinearLayoutManager)detailsRecyclerView.getLayoutManager()).findFirstCompletelyVisibleItemPosition();
        if (transitionController.isInitialized() && i == 0)
        {
            transitionController.setReturning(true);
            android.widget.RelativeLayout.LayoutParams layoutparams = (android.widget.RelativeLayout.LayoutParams)detailsRecyclerView.getLayoutParams();
            layoutparams.removeRule(2);
            detailsRecyclerView.setLayoutParams(layoutparams);
            bottomBarController.slideOutBottomBar(new OnBottomBarSlideOutListener());
            return;
        } else
        {
            finish();
            return;
        }
    }





/*
    static Deal access$1402(DealDetails dealdetails, Deal deal1)
    {
        dealdetails.deal = deal1;
        return deal1;
    }

*/



/*
    static Map access$1502(DealDetails dealdetails, Map map)
    {
        dealdetails.optionsById = map;
        return map;
    }

*/




/*
    static String access$1702(DealDetails dealdetails, String s)
    {
        dealdetails.selectedOptionIdForExposedMultiOptions = s;
        return s;
    }

*/



/*
    static Option access$1802(DealDetails dealdetails, Option option1)
    {
        dealdetails.option = option1;
        return option1;
    }

*/


/*
    static String access$1902(DealDetails dealdetails, String s)
    {
        dealdetails.defaultOptionIdForExposedMultiOptions = s;
        return s;
    }

*/



/*
    static String[] access$2002(DealDetails dealdetails, String as[])
    {
        dealdetails.exposedOptionsIds = as;
        return as;
    }

*/




/*
    static boolean access$2302(DealDetails dealdetails, boolean flag)
    {
        dealdetails.isDealClosedOrSoldOut = flag;
        return flag;
    }

*/



/*
    static boolean access$2402(DealDetails dealdetails, boolean flag)
    {
        dealdetails.hasDealBeenIndexed = flag;
        return flag;
    }

*/











/*
    static boolean access$3302(DealDetails dealdetails, boolean flag)
    {
        dealdetails.isHeaderFullyVisible = flag;
        return flag;
    }

*/





/*
    static View access$3702(DealDetails dealdetails, View view)
    {
        dealdetails.dealImageContainer = view;
        return view;
    }

*/


/*
    static View access$3802(DealDetails dealdetails, View view)
    {
        dealdetails.imageGradientOverlay = view;
        return view;
    }

*/


/*
    static DealDetailsTemporaryImage access$3902(DealDetails dealdetails, DealDetailsTemporaryImage dealdetailstemporaryimage)
    {
        dealdetails.temporaryDealImageView = dealdetailstemporaryimage;
        return dealdetailstemporaryimage;
    }

*/


/*
    static View access$4002(DealDetails dealdetails, View view)
    {
        dealdetails.titleValuePriceSection = view;
        return view;
    }

*/






/*
    static int access$4402(DealDetails dealdetails, int i)
    {
        dealdetails.qaPostsCount = i;
        return i;
    }

*/










/*
    static boolean access$5202(DealDetails dealdetails, boolean flag)
    {
        dealdetails.cabWidgetsLoaderInitialized = flag;
        return flag;
    }

*/




/*
    static boolean access$5402(DealDetails dealdetails, boolean flag)
    {
        dealdetails.cavWidgetsLoaderInitialized = flag;
        return flag;
    }

*/



}
