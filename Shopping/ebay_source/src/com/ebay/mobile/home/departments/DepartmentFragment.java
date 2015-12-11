// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.home.departments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.content.dm.AdRtmDataManager;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.SimpleHttpGETRequest;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.rtm.RtmHelper;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.activities.CoreActivity;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.collections.BrowseCollectionsActivity;
import com.ebay.mobile.collections.CollectionDetailsActivity;
import com.ebay.mobile.collections.CollectionViewModel;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.common.view.ViewModel;
import com.ebay.mobile.deals.BrowseDealsActivity;
import com.ebay.mobile.deals.DealsDetailsActivity;
import com.ebay.mobile.deals.DealsHubFragment;
import com.ebay.mobile.eBayDictionaryProvider;
import com.ebay.mobile.events.BrowseEventsActivity;
import com.ebay.mobile.events.EventItemsActivity;
import com.ebay.mobile.events.EventTimeLeftHelper;
import com.ebay.mobile.events.EventViewModel;
import com.ebay.mobile.home.cards.CategoriesViewModel;
import com.ebay.mobile.home.cards.DepartmentTitleViewHolder;
import com.ebay.mobile.home.cards.DepartmentTitleViewModel;
import com.ebay.mobile.home.cards.FeaturedCategoriesViewHolder;
import com.ebay.mobile.home.cards.FeaturedCategoriesViewModel;
import com.ebay.mobile.home.cards.ListOfCollectionsViewModel;
import com.ebay.mobile.home.cards.ListOfEventGroupsViewModel;
import com.ebay.mobile.home.cards.ListOfListingsViewModel;
import com.ebay.mobile.home.cards.ListOfTrendingViewModel;
import com.ebay.mobile.home.cards.ListingViewModel;
import com.ebay.mobile.home.cards.NativeAdsViewHolder;
import com.ebay.mobile.home.cards.NativeAdsViewModel;
import com.ebay.mobile.home.cards.RTMViewModel;
import com.ebay.mobile.home.channels.ChannelDispatcher;
import com.ebay.mobile.home.channels.ChannelFragment;
import com.ebay.mobile.home.channels.ChannelObserver;
import com.ebay.mobile.trend.TrendingActivity;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.AdUtil;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.content.dm.UssContentsDataManager;
import com.ebay.nautilus.domain.data.UnifiedStream.Category;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.Contents;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.ebay.nautilus.kernel.util.NumberUtil;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.FwActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.ebay.mobile.home.departments:
//            DepartmentContentAdapter, DepartmentFragmentActivity

public class DepartmentFragment extends BaseFragment
    implements ChannelFragment, com.ebay.nautilus.domain.content.dm.ImageDataManager.Observer, com.ebay.nautilus.domain.content.dm.UssContentsDataManager.Observer
{
    static class AdRtmObserver
        implements com.ebay.common.content.dm.AdRtmDataManager.Observer
    {

        private final WeakReference fragmentReference;

        public void onAdsContextReady(List list, com.ebay.common.content.dm.AdRtmDataManager.AdRequestType adrequesttype)
        {
            adrequesttype = (DepartmentFragment)fragmentReference.get();
            DataManagerContainer datamanagercontainer;
            if (adrequesttype != null)
            {
                if ((datamanagercontainer = adrequesttype.getDataManagerContainer()) != null)
                {
                    if (((DepartmentFragment) (adrequesttype)).isDepartment)
                    {
                        list = (UssContentsDataManager)datamanagercontainer.initialize(UssContentsDataManager.getDepartmentChannelKeyParams(((DepartmentFragment) (adrequesttype)).departmentId, null, list), adrequesttype);
                    } else
                    {
                        list = (UssContentsDataManager)datamanagercontainer.initialize(UssContentsDataManager.getChannelKeyParams(((DepartmentFragment) (adrequesttype)).departmentId, null, list), adrequesttype);
                    }
                    adrequesttype.contentDataManager = list;
                    return;
                }
            }
        }

        public void onAdsReady(RtmHelper rtmhelper, com.ebay.common.content.dm.AdRtmDataManager.AdRequestType adrequesttype)
        {
        }

        AdRtmObserver(DepartmentFragment departmentfragment)
        {
            fragmentReference = new WeakReference(departmentfragment);
        }
    }

    static final class ContentScrollListener extends android.support.v7.widget.RecyclerView.OnScrollListener
    {

        private final ChannelObserver dispatcher;
        private final WeakReference fragmentReference;

        public void onScrolled(RecyclerView recyclerview, int i, int j)
        {
            super.onScrolled(recyclerview, i, j);
            for (recyclerview = (DepartmentFragment)fragmentReference.get(); recyclerview == null || recyclerview.isRemoving() || dispatcher == null;)
            {
                return;
            }

            ChannelObserver channelobserver = dispatcher;
            if (recyclerview.hasScrollOffset())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            channelobserver.onScrollChanged(recyclerview, 0, i);
        }

        ContentScrollListener(DepartmentFragment departmentfragment, ChannelObserver channelobserver)
        {
            fragmentReference = new WeakReference(departmentfragment);
            dispatcher = channelobserver;
        }
    }

    static class ContentsSwipeRefreshListener
        implements android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    {

        private final WeakReference fragmentReference;

        public void onRefresh()
        {
            DepartmentFragment departmentfragment = (DepartmentFragment)fragmentReference.get();
            if (departmentfragment != null && departmentfragment.getView() != null)
            {
                SwipeRefreshLayout swiperefreshlayout = (SwipeRefreshLayout)departmentfragment.getView().findViewById(0x7f1002e1);
                if (swiperefreshlayout != null)
                {
                    swiperefreshlayout.setRefreshing(true);
                }
                if (departmentfragment.contentDataManager != null)
                {
                    departmentfragment.contentDataManager.invalidateAndForceReloadData();
                    return;
                }
            }
        }

        ContentsSwipeRefreshListener(DepartmentFragment departmentfragment)
        {
            fragmentReference = new WeakReference(departmentfragment);
        }
    }

    static class RecyclerViewHierarchyChangeListener
        implements android.view.ViewGroup.OnHierarchyChangeListener
    {

        private final WeakReference fragmentReference;

        public void onChildViewAdded(View view, View view1)
        {
            byte byte0 = 0;
            view = (DepartmentFragment)fragmentReference.get();
            Object obj;
            if (view != null && view.getView() != null)
            {
                if ((obj = (RecyclerView)view.getView().findViewById(0x7f1002e8)) != null && (view1 = ((RecyclerView) (obj)).getChildViewHolder(view1)) != null)
                {
                    if (view1 instanceof DepartmentTitleViewHolder)
                    {
                        obj = ((android.support.v7.widget.RecyclerView.ViewHolder) (view1)).itemView;
                        if (view.hasCarousel())
                        {
                            byte0 = 4;
                        }
                        ((View) (obj)).setVisibility(byte0);
                        view.addObserver((DepartmentTitleViewHolder)view1, true);
                        return;
                    }
                    if (view1 instanceof NativeAdsViewHolder)
                    {
                        ((NativeAdsViewHolder)view1).doInitialViewAdd(((RecyclerView) (obj)).getWidth());
                        return;
                    }
                    if ((view1 instanceof FeaturedCategoriesViewHolder) && ((DepartmentFragment) (view)).isExpanded)
                    {
                        view1 = ((android.support.v7.widget.RecyclerView.ViewHolder) (view1)).itemView;
                        view1.measure(0, 0);
                        view.getClass();
                        (view. new ResizeAnimation(view1, 0, view1.getMeasuredHeight())).applyTransformation(1.0F, null);
                        return;
                    }
                }
            }
        }

        public void onChildViewRemoved(View view, View view1)
        {
            view = (DepartmentFragment)fragmentReference.get();
            RecyclerView recyclerview;
            if (view != null && view.getView() != null)
            {
                if ((recyclerview = (RecyclerView)view.getView().findViewById(0x7f1002e8)) != null && ((view1 = recyclerview.getChildViewHolder(view1)) != null && (view1 instanceof DepartmentTitleViewHolder)))
                {
                    view.removeObserver((DepartmentTitleViewHolder)view1);
                    return;
                }
            }
        }

        RecyclerViewHierarchyChangeListener(DepartmentFragment departmentfragment)
        {
            fragmentReference = new WeakReference(departmentfragment);
        }
    }

    class RecyclerViewTouchListener extends android.view.GestureDetector.SimpleOnGestureListener
        implements android.support.v7.widget.RecyclerView.OnItemTouchListener
    {

        private final GestureDetector gestureDetector;
        private boolean isScrolling;
        final DepartmentFragment this$0;

        public boolean onFling(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            return false;
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
        {
            return gestureDetector.onTouchEvent(motionevent);
        }

        public boolean onScroll(MotionEvent motionevent, MotionEvent motionevent1, float f, float f1)
        {
            View view = getFeaturedCategoriesView();
            if (view != null)
            {
                int i = view.getHeight();
                if (i > 0 && f1 > 0.0F)
                {
                    isScrolling = true;
                    i = Math.max(i - (int)f1, 0);
                    view.measure(0, 0);
                    int j = view.getMeasuredHeight();
                    (new ResizeAnimation(view, 0, j)).applyTransformation((float)i / (float)j, null);
                    if (i == 0)
                    {
                        motionevent1 = MotionEvent.obtain(motionevent1);
                        motionevent1.setAction(1);
                        departmentRecyclerView.dispatchTouchEvent(motionevent1);
                        motionevent = MotionEvent.obtain(motionevent);
                        motionevent.setLocation(motionevent1.getX(), motionevent1.getY());
                        departmentRecyclerView.dispatchTouchEvent(motionevent);
                        isScrolling = false;
                        isExpanded = false;
                    }
                    return true;
                }
            }
            return false;
        }

        public void onTouchEvent(RecyclerView recyclerview, MotionEvent motionevent)
        {
            if (motionevent.getActionMasked() == 1 && isScrolling)
            {
                isExpanded = false;
                isScrolling = false;
                collapseView(getFeaturedCategoriesView());
            }
            gestureDetector.onTouchEvent(motionevent);
        }

        public RecyclerViewTouchListener()
        {
            this$0 = DepartmentFragment.this;
            super();
            isScrolling = false;
            gestureDetector = new GestureDetector(getBaseActivity(), this);
        }
    }

    class ResizeAnimation extends Animation
    {

        public final int backgroundOffsetY;
        public final float backgroundWeight;
        public final View boundView;
        public final int endHeight;
        public final boolean isGrowing;
        public final int startHeight;
        final DepartmentFragment this$0;

        protected void applyTransformation(float f, Transformation transformation)
        {
            float f1;
            DepartmentFragment departmentfragment;
            int i;
            if (isGrowing)
            {
                f1 = (float)endHeight * f;
            } else
            {
                f1 = (float)startHeight - (float)startHeight * f;
            }
            transformation = boundView.getLayoutParams();
            if (f == 1.0F)
            {
                i = endHeight;
            } else
            {
                i = (int)f1;
            }
            transformation.height = i;
            boundView.requestLayout();
            if (f == 1.0F)
            {
                f1 = endHeight;
            }
            f1 = (float)Math.min((double)(backgroundWeight * f1) - (double)backgroundOffsetY, 0.0D);
            transformation = getView();
            if (transformation != null)
            {
                transformation = (ImageView)transformation.findViewById(0x7f1000c7);
                if (transformation != null)
                {
                    transformation.setY(f1);
                }
            }
            transformation = departmentFragmentDispatcher;
            departmentfragment = DepartmentFragment.this;
            if (!isGrowing)
            {
                f = 1.0F - f;
            }
            transformation.onCategoryExpansion(departmentfragment, f);
        }

        public boolean willChangeBounds()
        {
            return true;
        }

        public ResizeAnimation(View view, int i, int j)
        {
            this$0 = DepartmentFragment.this;
            super();
            boundView = view;
            startHeight = i;
            endHeight = j;
            boolean flag;
            if (i <= j)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            isGrowing = flag;
            backgroundOffsetY = view.getResources().getDimensionPixelSize(0x7f090138);
            backgroundWeight = view.getResources().getFraction(0x7f0f0000, 1, 1);
        }
    }


    private static final String EXTRA_DEPARTMENT_ID = "departmentId";
    private static final String EXTRA_DEPARTMENT_TITLE = "departmentTitle";
    private static final String EXTRA_HEADER_BACKGROUND_URL = "headerBackgroundUrl";
    private static final String EXTRA_IS_DEPARTMENT = "isDepartment";
    private static final String EXTRA_IS_EXPANDED = "isExpanded";
    private static final String EXTRA_LAYOUT_MANAGER_STATE = "layoutManagerState";
    private static final String EXTRA_POSITION = "position";
    private static final int LOADER_ID_RTM_TRACKING = 10;
    public static final int POSITION_NONE = -1;
    private static boolean isTablet;
    private com.ebay.common.content.dm.AdRtmDataManager.KeyParams adRtmDataManagerKeyParams;
    private com.ebay.nautilus.domain.content.dm.ImageDataManager.LoadToken backgroundLoadToken;
    private int backgroundOffset;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener browseCategoriesClickListener;
    private android.view.View.OnClickListener channelErrorClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener collectionsClickListener;
    protected DepartmentContentAdapter contentAdapter;
    protected UssContentsDataManager contentDataManager;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener dealsClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener dealsDetailsClickListener;
    private ChannelDispatcher departmentFragmentDispatcher;
    protected String departmentId;
    private int departmentLevel;
    private RecyclerView departmentRecyclerView;
    protected String departmentTitle;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener departmentTitleClickListener;
    protected View errorLayout;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener eventsClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener featuredCategoriesClickListener;
    private boolean hasFailedContentLoading;
    private String headerBackgroundUrl;
    private boolean isDepartment;
    private boolean isExpanded;
    protected View loadingIndicator;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener moreCollectionsClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener moreDealsClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener moreEventsClickListener;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener nativeAdClickListener;
    private float pixelDensity;
    private int position;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener promoClickListener;
    protected SwipeRefreshLayout refreshLayout;
    private com.ebay.mobile.common.view.ViewModel.OnClickListener trendingClickListener;

    public DepartmentFragment()
    {
        departmentFragmentDispatcher = new ChannelDispatcher();
        departmentLevel = 0;
        position = -1;
        isExpanded = false;
        channelErrorClickListener = new android.view.View.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view)
            {
                if (view.getId() == 0x7f10022c)
                {
                    loadingIndicator.setVisibility(0);
                    errorLayout.setVisibility(8);
                    contentDataManager.invalidateAndForceReloadData();
                }
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        dealsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof ListingViewModel)
                {
                    long l = NumberUtil.safeParseLong(((ListingViewModel)viewmodel).listingId, -1L);
                    if (l > 0L)
                    {
                        view = TrackingData.sanitize(departmentId);
                        ItemViewActivity.invalidateCache(l, (Long)null);
                        viewmodel = new Intent(getActivity(), com/ebay/mobile/viewitem/ItemViewActivity);
                        viewmodel.putExtra("item_view_id", l);
                        viewmodel.putExtra("item_view_kind", com.ebay.common.ConstantsCommon.ItemKind.Deals.toString());
                        viewmodel.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "deals", view));
                        getActivity().startActivity(viewmodel);
                    }
                }
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        dealsDetailsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
label0:
                {
                    if (viewmodel instanceof ListOfListingsViewModel)
                    {
                        view = getActivity();
                        if (view != null)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                DealsDetailsActivity.startActivity(view, departmentTitle, departmentId, false);
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        moreDealsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (!(viewmodel instanceof ListOfListingsViewModel)) goto _L2; else goto _L1
_L1:
                Object obj;
                Object obj1;
                obj = (ListOfListingsViewModel)viewmodel;
                obj1 = getActivity();
                if (obj1 != null) goto _L4; else goto _L3
_L3:
                return;
_L4:
                if (departmentId.equals(ChannelEnum.DEALS.name()))
                {
                    DealsDetailsActivity.startActivity(((Activity) (obj1)), ((ListOfListingsViewModel) (obj)).listingsTitle, ((ListOfListingsViewModel) (obj)).categoryId, true);
                } else
                {
                    Intent intent1 = new Intent(((Context) (obj1)), com/ebay/mobile/deals/BrowseDealsActivity);
                    intent1.putExtra("top_level_channel", ChannelEnum.SHOP.name());
                    if (hasCarousel())
                    {
                        intent1.putExtra("browse_type", ChannelEnum.DEPARTMENT.name());
                    } else
                    {
                        intent1.putExtra("browse_type", "SUB_DEPARTMENT");
                    }
                    intent1.putExtra("department_id", ((ListOfListingsViewModel) (obj)).categoryId);
                    intent1.putExtra("department_title", departmentTitle);
                    intent1.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "deals", TrackingData.sanitize(departmentId)));
                    ((Activity) (obj1)).startActivity(intent1);
                }
_L2:
                if (viewmodel instanceof FeaturedCategoriesViewModel)
                {
                    obj = (FeaturedCategoriesViewModel)viewmodel;
                    if (view != null)
                    {
                        viewmodel = (String)view.getTag(0x7f10000a);
                        view = null;
                        obj = ((FeaturedCategoriesViewModel) (obj)).featuredCategories.iterator();
                        do
                        {
                            if (!((Iterator) (obj)).hasNext())
                            {
                                break;
                            }
                            obj1 = (com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord)((Iterator) (obj)).next();
                            if (((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj1)).category != null && ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj1)).category.id == viewmodel)
                            {
                                view = ((com.ebay.nautilus.domain.data.UnifiedStream.Contents.ContentGroup.ContentRecord) (obj1)).category;
                            }
                        } while (true);
                        if (view != null)
                        {
                            viewmodel = getActivity();
                            if (viewmodel != null)
                            {
                                Intent intent = new Intent(viewmodel, com/ebay/mobile/deals/BrowseDealsActivity);
                                intent.putExtra("top_level_channel", ChannelEnum.SHOP.name());
                                if (hasCarousel())
                                {
                                    intent.putExtra("browse_type", ChannelEnum.DEPARTMENT.name());
                                } else
                                {
                                    intent.putExtra("browse_type", "SUB_DEPARTMENT");
                                }
                                intent.putExtra("department_id", ((Category) (view)).id);
                                intent.putExtra("department_title", ((Category) (view)).name.content);
                                intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "deals", TrackingData.sanitize(((Category) (view)).id)));
                                viewmodel.startActivity(intent);
                                return;
                            }
                        }
                    }
                }
                if (true) goto _L3; else goto _L5
_L5:
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        eventsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof EventViewModel)
                {
                    EventViewModel eventviewmodel = (EventViewModel)viewmodel;
                    Activity activity = getActivity();
                    view = "HomePage";
                    if (!hasCarousel())
                    {
                        view = "SubDepartment";
                    }
                    viewmodel = null;
                    Resources resources = activity.getResources();
                    if (eventviewmodel.showTimer)
                    {
                        viewmodel = EventTimeLeftHelper.getEndsInTimeMaxUnitString(resources, EventTimeLeftHelper.getRemainingDuration(eventviewmodel.endDate), true);
                        viewmodel = String.format(resources.getString(0x7f0701f4), new Object[] {
                            viewmodel
                        });
                    }
                    EventItemsActivity.startActivity(activity, eventviewmodel, departmentId, viewmodel, new SourceIdentification(view, "salesevents", TrackingData.sanitize(departmentId)));
                }
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        moreEventsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
label0:
                {
                    if (viewmodel instanceof ListOfEventGroupsViewModel)
                    {
                        view = getActivity();
                        if (view != null)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                viewmodel = new Intent(view, com/ebay/mobile/events/BrowseEventsActivity);
                viewmodel.putExtra("top_level_channel", ChannelEnum.SHOP.name());
                if (hasCarousel())
                {
                    viewmodel.putExtra("browse_type", ChannelEnum.DEPARTMENT.name());
                } else
                {
                    viewmodel.putExtra("browse_type", "SUB_DEPARTMENT");
                }
                viewmodel.putExtra("department_id", departmentId);
                viewmodel.putExtra("department_title", departmentTitle);
                viewmodel.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "salesevents", TrackingData.sanitize(departmentId)));
                view.startActivity(viewmodel);
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        collectionsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof CollectionViewModel)
                {
                    int i = view.getId();
                    Activity activity = getActivity();
                    if (activity != null)
                    {
                        viewmodel = (CollectionViewModel)viewmodel;
                        if (i == 0x7f1000f7)
                        {
                            UserDetailActivity.StartActivity(activity, null, ((CollectionViewModel) (viewmodel)).username, null, null, false, true, false, false, null, false, null);
                            return;
                        }
                        view = "HomePage";
                        if (!hasCarousel())
                        {
                            view = "SubDepartment";
                        }
                        String s = TrackingData.sanitize(departmentId);
                        if (!TextUtils.isEmpty(((CollectionViewModel) (viewmodel)).collectionId))
                        {
                            CollectionDetailsActivity.startActivity(activity, ((CollectionViewModel) (viewmodel)).collectionId, s, new SourceIdentification(view, "collections", s));
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        moreCollectionsClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
label0:
                {
                    if (viewmodel instanceof ListOfCollectionsViewModel)
                    {
                        view = getActivity();
                        if (view != null)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                viewmodel = new Intent(view, com/ebay/mobile/collections/BrowseCollectionsActivity);
                viewmodel.putExtra("top_level_channel", ChannelEnum.SHOP.name());
                if (hasCarousel())
                {
                    viewmodel.putExtra("browse_type", ChannelEnum.DEPARTMENT.name());
                } else
                {
                    viewmodel.putExtra("browse_type", "SUB_DEPARTMENT");
                }
                viewmodel.putExtra("department_id", departmentId);
                viewmodel.putExtra("department_title", departmentTitle);
                viewmodel.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "collections", TrackingData.sanitize(departmentId)));
                view.startActivity(viewmodel);
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        departmentTitleClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof DepartmentTitleViewModel)
                {
                    toggleFeaturedCategories();
                }
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        featuredCategoriesClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if ((viewmodel instanceof FeaturedCategoriesViewModel) && view != null)
                {
                    viewmodel = view.getContext();
                    ContentTypeEnum contenttypeenum = (ContentTypeEnum)view.getTag(0x7f10000c);
                    String s = (String)view.getTag(0x7f10000a);
                    Object obj = (String)view.getTag(0x7f100009);
                    String s1 = (String)view.getTag(0x7f10000b);
                    if (contenttypeenum != null && s != null && !s.isEmpty())
                    {
                        String s2 = TrackingData.sanitize(departmentId);
                        SourceIdentification sourceidentification = new SourceIdentification(getTrackingEventName(), "featcat", s2);
                        static class _cls15
                        {

                            static final int $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[];
                            static final int $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[];

                            static 
                            {
                                $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum = new int[ChannelEnum.values().length];
                                try
                                {
                                    $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[ChannelEnum.ACTIVITY.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror4) { }
                                try
                                {
                                    $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[ChannelEnum.SHOP.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror3) { }
                                try
                                {
                                    $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[ChannelEnum.SELL.ordinal()] = 3;
                                }
                                catch (NoSuchFieldError nosuchfielderror2) { }
                                $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum = new int[ContentTypeEnum.values().length];
                                try
                                {
                                    $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.DEPARTMENT.ordinal()] = 1;
                                }
                                catch (NoSuchFieldError nosuchfielderror1) { }
                                try
                                {
                                    $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ContentTypeEnum[ContentTypeEnum.CATEGORY.ordinal()] = 2;
                                }
                                catch (NoSuchFieldError nosuchfielderror)
                                {
                                    return;
                                }
                            }
                        }

                        switch (_cls15..SwitchMap.com.ebay.nautilus.domain.data.UnifiedStream.ContentTypeEnum[contenttypeenum.ordinal()])
                        {
                        default:
                            return;

                        case 1: // '\001'
                            view = new Intent(viewmodel, com/ebay/mobile/home/departments/DepartmentFragmentActivity);
                            view.putExtra("departmentId", s);
                            view.putExtra("departmentTitle", s1);
                            view.putExtra("backgroundUrl", ((String) (obj)));
                            view.putExtra("isDepartment", true);
                            view.putExtra("parentDepartmentId", s2);
                            view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                            viewmodel.startActivity(view);
                            return;

                        case 2: // '\002'
                            obj = eBayDictionaryProvider.getLockedSearchParameters(viewmodel, null);
                            break;
                        }
                        obj.category = new EbayCategorySummary(NumberUtil.safeParseLong(s).longValue(), ((TextView)view).getText().toString());
                        view = ActivityStarter.getSearchResultListIntent(viewmodel, ((SearchParameters) (obj)), null);
                        view.putExtra("com.ebay.mobile.analytics.sid", sourceidentification);
                        viewmodel.startActivity(view);
                        return;
                    }
                }
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        browseCategoriesClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (view != null && viewmodel != null && (viewmodel instanceof CategoriesViewModel))
                {
                    viewmodel = (Category)view.getTag(0x7f10000d);
                    if (viewmodel != null)
                    {
                        if (com.ebay.nautilus.domain.data.UnifiedStream.Category.Destination.SRP.equals(((Category) (viewmodel)).destination))
                        {
                            SearchParameters searchparameters = eBayDictionaryProvider.getLockedSearchParameters(view.getContext(), null);
                            searchparameters.category = new EbayCategorySummary(NumberUtil.safeParseLong(((Category) (viewmodel)).id).longValue(), ((Category) (viewmodel)).name.content);
                            view = ActivityStarter.getSearchResultListIntent(view.getContext(), searchparameters, null);
                            view.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), "browsecat", TrackingData.sanitize(departmentId)));
                            startActivity(view);
                            return;
                        } else
                        {
                            departmentFragmentDispatcher.onCategorySelected(DepartmentFragment.this, viewmodel);
                            return;
                        }
                    }
                }
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        trendingClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof ListOfTrendingViewModel)
                {
                    int i = ((ListOfTrendingViewModel)viewmodel).trendAnchor;
                    viewmodel = getActivity();
                    Intent intent = new Intent(viewmodel, com/ebay/mobile/trend/TrendingActivity);
                    intent.putExtra("trend_topic_anchors", i);
                    if (i >= 0)
                    {
                        view = (new StringBuilder()).append("trend").append(String.valueOf(i + 1)).toString();
                    } else
                    {
                        view = "moretrending";
                    }
                    intent.putExtra("com.ebay.mobile.analytics.sid", new SourceIdentification(getTrackingEventName(), view, TrackingData.sanitize(departmentId)));
                    viewmodel.startActivity(intent);
                }
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        nativeAdClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

            public void onClick(View view, ViewModel viewmodel)
            {
                if (viewmodel instanceof NativeAdsViewModel)
                {
                    view = (NativeAdsViewModel)viewmodel;
                    viewmodel = new TrackingData("AdClick", TrackingType.EVENT);
                    viewmodel.addKeyValuePair("adid", view.getAdID());
                    viewmodel.addKeyValuePair("adtype", "1");
                    viewmodel.addSourceIdentification(new SourceIdentification(getTrackingEventName(), "ad", TrackingData.sanitize(departmentId)));
                    viewmodel.send(MyApp.getApp().getApplicationContext(), null);
                }
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
        promoClickListener = new com.ebay.mobile.common.view.ViewModel.OnClickListener() {

            final DepartmentFragment this$0;

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
label0:
                {
                    if (viewmodel instanceof RTMViewModel)
                    {
                        viewmodel = (RTMViewModel)viewmodel;
                        sendRtmTracking(viewmodel);
                        view = getActivity();
                        if (view != null)
                        {
                            break label0;
                        }
                    }
                    return;
                }
                if (((RTMViewModel) (viewmodel)).viewType == 11 && !TextUtils.isEmpty(((RTMViewModel) (viewmodel)).logoUrl) && (view instanceof com.ebay.mobile.home.StartFragment.StartChannelHost))
                {
                    try
                    {
                        viewmodel = ChannelEnum.valueOf(((RTMViewModel) (viewmodel)).logoUrl.toUpperCase(Locale.US));
                        switch (_cls15..SwitchMap.com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum[viewmodel.ordinal()])
                        {
                        case 1: // '\001'
                        case 2: // '\002'
                        case 3: // '\003'
                            ((com.ebay.mobile.home.StartFragment.StartChannelHost)view).navigateToChannel(viewmodel, true, true);
                            return;
                        }
                    }
                    // Misplaced declaration of an exception variable
                    catch (View view)
                    {
                        return;
                    }
                } else
                {
                    view.startActivity(viewmodel.getIntent(view));
                    return;
                }
            }

            
            {
                this$0 = DepartmentFragment.this;
                super();
            }
        };
    }

    public static DepartmentFragment create(String s, String s1, String s2, boolean flag, int i)
    {
        Object obj;
        Bundle bundle;
        if (TextUtils.equals(ChannelEnum.DEALS.name(), s))
        {
            obj = new DealsHubFragment();
        } else
        {
            obj = new DepartmentFragment();
        }
        bundle = new Bundle();
        bundle.putString("departmentId", s);
        bundle.putString("departmentTitle", s1);
        bundle.putString("headerBackgroundUrl", s2);
        bundle.putBoolean("isDepartment", flag);
        bundle.putInt("position", i);
        ((DepartmentFragment) (obj)).setArguments(bundle);
        return ((DepartmentFragment) (obj));
    }

    private View getFeaturedCategoriesView()
    {
        int i = contentAdapter.getPositionForViewType(1);
        if (i >= 0)
        {
            android.support.v7.widget.RecyclerView.ViewHolder viewholder = departmentRecyclerView.findViewHolderForAdapterPosition(i);
            if (viewholder != null)
            {
                return viewholder.itemView;
            }
        }
        return null;
    }

    private void sendTrendingTrackingData()
    {
        int i = contentAdapter.getPositionForViewType(15);
        if (i >= 0)
        {
            TrackingData trackingdata = new TrackingData("TrendingCard", TrackingType.EVENT);
            trackingdata.addKeyValuePair("chnl", ChannelEnum.SHOP.name());
            trackingdata.addKeyValuePair("subchnl", departmentId, true);
            trackingdata.addKeyValuePair("tcrank", String.valueOf(i));
            trackingdata.send(getActivity());
        }
    }

    private void showError(ResultStatus resultstatus, boolean flag)
    {
        if (!Util.hasNetwork() || NetworkUtil.isConnectionError(resultstatus))
        {
            Activity activity = getActivity();
            if (MyApp.getPrefs().isSignedIn() && EbayErrorUtil.userNotLoggedIn(resultstatus.getMessages()))
            {
                EbayErrorHandler.handleResultStatus(this, 0, resultstatus);
            } else
            if ((activity instanceof CoreActivity) && !activity.isFinishing() && flag)
            {
                resultstatus.setCanRetry(true);
                ((CoreActivity)activity).showMessage(this, 0, resultstatus);
                return;
            }
        }
    }

    public void addObserver(ChannelObserver channelobserver, boolean flag)
    {
        departmentFragmentDispatcher.register(channelobserver);
        if (flag && channelobserver != null)
        {
            channelobserver.onContentLoaded(this);
            float f;
            int i;
            if (isExpanded)
            {
                f = 1.0F;
            } else
            {
                f = 0.0F;
            }
            channelobserver.onCategoryExpansion(this, f);
            if (hasScrollOffset())
            {
                i = 1;
            } else
            {
                i = 0;
            }
            channelobserver.onScrollChanged(this, 0, i);
        }
    }

    protected void collapseView(View view)
    {
        if (view != null)
        {
            int i = view.getHeight();
            ResizeAnimation resizeanimation = new ResizeAnimation(view, i, 0);
            resizeanimation.setDuration((int)((float)Math.abs(0 - i) / pixelDensity));
            view.clearAnimation();
            view.startAnimation(resizeanimation);
        }
    }

    public void dispatchCategoryExpansion(float f)
    {
        if (departmentFragmentDispatcher != null)
        {
            departmentFragmentDispatcher.onCategoryExpansion(this, f);
        }
    }

    protected void expandView(View view)
    {
        if (view != null)
        {
            view.measure(0, 0);
            int i = view.getHeight();
            int j = view.getMeasuredHeight();
            ResizeAnimation resizeanimation = new ResizeAnimation(view, i, j);
            resizeanimation.setDuration((int)((float)Math.abs(j - i) / pixelDensity));
            view.clearAnimation();
            view.startAnimation(resizeanimation);
        }
    }

    public String getDepartmentId()
    {
        return departmentId;
    }

    public int getPositionInParent()
    {
        return position;
    }

    public String getTrackingEventName()
    {
        if (hasCarousel())
        {
            return "HomePage";
        } else
        {
            return "SubDepartment";
        }
    }

    public boolean hasCarousel()
    {
        return departmentLevel == 0;
    }

    public boolean hasScrollOffset()
    {
        boolean flag;
label0:
        {
            boolean flag1 = false;
            flag = flag1;
            if (departmentRecyclerView == null)
            {
                break label0;
            }
            android.support.v7.widget.RecyclerView.LayoutManager layoutmanager = departmentRecyclerView.getLayoutManager();
            flag = flag1;
            if (layoutmanager == null)
            {
                break label0;
            }
            flag = flag1;
            if (!(layoutmanager instanceof LinearLayoutManager))
            {
                break label0;
            }
            int i = ((LinearLayoutManager)layoutmanager).findFirstCompletelyVisibleItemPosition();
            if (i <= 0)
            {
                flag = flag1;
                if (i != -1)
                {
                    break label0;
                }
            }
            flag = true;
        }
        return flag;
    }

    public boolean hasSubChannels()
    {
        return contentAdapter.getPositionForViewType(1) >= 0;
    }

    public boolean isExpanded()
    {
        return isExpanded;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        if (!(activity instanceof eBay)) goto _L2; else goto _L1
_L1:
        departmentLevel = 0;
_L4:
        if (activity instanceof ChannelObserver)
        {
            addObserver((ChannelObserver)activity, false);
        }
        return;
_L2:
        if (activity instanceof DepartmentFragmentActivity)
        {
            departmentLevel = 1;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Resources resources = getResources();
        pixelDensity = resources.getDisplayMetrics().density;
        backgroundOffset = resources.getDimensionPixelSize(0x7f090138);
        isTablet = resources.getBoolean(0x7f0b0006);
        if (bundle == null) goto _L2; else goto _L1
_L1:
        departmentId = bundle.getString("departmentId");
        departmentTitle = bundle.getString("departmentTitle");
        headerBackgroundUrl = bundle.getString("headerBackgroundUrl");
        isDepartment = bundle.getBoolean("isDepartment", false);
        isExpanded = bundle.getBoolean("isExpanded", false);
        position = bundle.getInt("position", -1);
_L4:
        initDataManagers();
        return;
_L2:
        bundle = getArguments();
        if (bundle != null)
        {
            departmentId = bundle.getString("departmentId");
            departmentTitle = bundle.getString("departmentTitle");
            headerBackgroundUrl = bundle.getString("headerBackgroundUrl");
            isDepartment = bundle.getBoolean("isDepartment", false);
            isExpanded = bundle.getBoolean("isExpanded", false);
            position = bundle.getInt("position", -1);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030126, viewgroup, false);
        viewgroup = (ImageView)layoutinflater.findViewById(0x7f1000c7);
        if (viewgroup != null)
        {
            viewgroup.setY(-backgroundOffset);
        }
        errorLayout = layoutinflater.findViewById(0x7f1002e4);
        loadingIndicator = layoutinflater.findViewById(0x7f1002e5);
        departmentRecyclerView = (RecyclerView)layoutinflater.findViewById(0x7f1002e8);
        errorLayout.findViewById(0x7f10022c).setOnClickListener(channelErrorClickListener);
        contentAdapter = new DepartmentContentAdapter(getBaseActivity(), departmentTitle);
        viewgroup = contentAdapter;
        boolean flag;
        if (departmentLevel > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        viewgroup.isSubDepartment = flag;
        contentAdapter.isDepartment = isDepartment;
        contentAdapter.setOnClickListener(dealsClickListener, new int[] {
            2
        });
        contentAdapter.setOnClickListener(dealsClickListener, new int[] {
            14
        });
        contentAdapter.setOnClickListener(moreDealsClickListener, new int[] {
            5
        });
        contentAdapter.setOnClickListener(dealsDetailsClickListener, new int[] {
            12
        });
        contentAdapter.setOnClickListener(eventsClickListener, new int[] {
            3
        });
        contentAdapter.setOnClickListener(moreEventsClickListener, new int[] {
            6
        });
        contentAdapter.setOnClickListener(collectionsClickListener, new int[] {
            4
        });
        contentAdapter.setOnClickListener(collectionsClickListener, new int[] {
            13
        });
        contentAdapter.setOnClickListener(moreCollectionsClickListener, new int[] {
            7
        });
        contentAdapter.setOnClickListener(departmentTitleClickListener, new int[] {
            0
        });
        contentAdapter.setOnClickListener(featuredCategoriesClickListener, new int[] {
            1
        });
        contentAdapter.setOnClickListener(browseCategoriesClickListener, new int[] {
            8
        });
        contentAdapter.setOnClickListener(nativeAdClickListener, new int[] {
            9
        });
        contentAdapter.setOnClickListener(promoClickListener, new int[] {
            10
        });
        contentAdapter.setOnClickListener(trendingClickListener, new int[] {
            16
        });
        departmentRecyclerView.setLayoutManager(contentAdapter.createLayoutManager());
        departmentRecyclerView.addOnItemTouchListener(new RecyclerViewTouchListener());
        departmentRecyclerView.setAdapter(contentAdapter);
        departmentRecyclerView.addOnScrollListener(new ContentScrollListener(this, departmentFragmentDispatcher));
        departmentRecyclerView.setOnHierarchyChangeListener(new RecyclerViewHierarchyChangeListener(this));
        refreshLayout = (SwipeRefreshLayout)layoutinflater.findViewById(0x7f1002e1);
        refreshLayout.setOnRefreshListener(new ContentsSwipeRefreshListener(this));
        if (isTablet)
        {
            departmentRecyclerView.addItemDecoration(contentAdapter.itemDecorator);
        }
        return layoutinflater;
    }

    public void onDestroyView()
    {
        DataManagerContainer datamanagercontainer = getDataManagerContainer();
        if (datamanagercontainer != null)
        {
            if (adRtmDataManagerKeyParams != null)
            {
                datamanagercontainer.delete(adRtmDataManagerKeyParams);
            }
            if (contentDataManager != null && contentDataManager.getParams() != null)
            {
                datamanagercontainer.delete(contentDataManager.getParams());
            }
            datamanagercontainer.delete(ImageDataManager.KEY);
        }
        contentDataManager = null;
        departmentRecyclerView = null;
        contentAdapter = null;
        errorLayout = null;
        loadingIndicator = null;
        refreshLayout = null;
        adRtmDataManagerKeyParams = null;
        departmentFragmentDispatcher.unregisterAll();
        super.onDestroyView();
    }

    public void onDetach()
    {
        Activity activity = getActivity();
        if (activity != null && (activity instanceof ChannelObserver))
        {
            removeObserver((ChannelObserver)activity);
        }
        super.onDetach();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        if (!TextUtils.equals(ChannelEnum.DEALS.name(), departmentId))
        {
            AdRtmObserver adrtmobserver = new AdRtmObserver(this);
            if (adRtmDataManagerKeyParams != null)
            {
                datamanagercontainer.delete(adRtmDataManagerKeyParams);
            }
            adRtmDataManagerKeyParams = new com.ebay.common.content.dm.AdRtmDataManager.KeyParams();
            AdRtmDataManager adrtmdatamanager = (AdRtmDataManager)datamanagercontainer.initialize(adRtmDataManagerKeyParams, adrtmobserver);
            Preferences preferences = MyApp.getPrefs();
            Object obj = preferences.getAuthentication();
            Pair pair;
            com.ebay.nautilus.domain.EbaySite ebaysite;
            if (obj != null)
            {
                obj = ((Authentication) (obj)).iafToken;
            } else
            {
                obj = null;
            }
            ebaysite = preferences.getCurrentSite();
            pair = AdUtil.adsEnabledForShopSubChannel(isDepartment, departmentId, getFwActivity().getEbayContext());
            if (pair != null && ((Boolean)pair.first).equals(Boolean.TRUE))
            {
                String s;
                String s2;
                if (isDepartment)
                {
                    s = "20223";
                } else
                {
                    s = "20255";
                }
                if (isDepartment)
                {
                    s2 = "20381";
                } else
                {
                    s2 = "20379";
                }
                adrtmdatamanager.getAdsRtmContext(preferences, ebaysite, ((String) (obj)), s, s2, adrtmobserver);
            } else
            {
                String s1;
                if (isDepartment)
                {
                    s1 = "20381";
                } else
                {
                    s1 = "20379";
                }
                adrtmdatamanager.getPromoRtmContext(preferences, ebaysite, ((String) (obj)), s1, adrtmobserver);
            }
        }
        backgroundLoadToken = ((ImageDataManager)datamanagercontainer.initialize(ImageDataManager.KEY, this)).loadImage(this, headerBackgroundUrl);
        loadingIndicator.setVisibility(0);
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        if (!content.getStatus().hasError())
        {
            imagedatamanager = (com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData();
            if (backgroundLoadToken != null && backgroundLoadToken.equals(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo) (imagedatamanager)).loadToken))
            {
                content = (ImageView)getView().findViewById(0x7f1000c7);
                if (content != null)
                {
                    content.setImageBitmap(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo) (imagedatamanager)).image);
                }
            }
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("departmentId", departmentId);
        bundle.putString("departmentTitle", departmentTitle);
        bundle.putString("headerBackgroundUrl", headerBackgroundUrl);
        bundle.putBoolean("isDepartment", isDepartment);
        bundle.putBoolean("isExpanded", isExpanded);
        bundle.putInt("position", position);
        bundle.putParcelable("layoutManagerState", departmentRecyclerView.getLayoutManager().onSaveInstanceState());
    }

    public void onStreamChanged(UssContentsDataManager usscontentsdatamanager, Content content, boolean flag, boolean flag1)
    {
        usscontentsdatamanager = getActivity();
        if (getView() == null || usscontentsdatamanager == null || usscontentsdatamanager.isFinishing() || usscontentsdatamanager.isDestroyed())
        {
            return;
        }
        hasFailedContentLoading = false;
        refreshLayout.setRefreshing(false);
        usscontentsdatamanager = content.getStatus();
        float f;
        int i;
        if (!usscontentsdatamanager.hasError())
        {
            errorLayout.setVisibility(8);
            departmentRecyclerView.setVisibility(0);
            if (contentAdapter != null)
            {
                contentAdapter.setContents((Contents)content.getData());
                sendTrendingTrackingData();
            }
        } else
        {
            errorLayout.setVisibility(0);
            departmentRecyclerView.setVisibility(8);
            if (EbayErrorUtil.userNotLoggedIn(usscontentsdatamanager.getMessages()) && MyApp.getPrefs().isSignedIn())
            {
                MyApp.signOutForIafTokenFailure(getActivity());
            } else
            {
                hasFailedContentLoading = true;
            }
        }
        departmentFragmentDispatcher.onContentLoaded(this);
        flag = hasScrollOffset();
        usscontentsdatamanager = departmentFragmentDispatcher;
        if (isExpanded && !flag)
        {
            f = 1.0F;
        } else
        {
            f = 0.0F;
        }
        usscontentsdatamanager.onCategoryExpansion(this, f);
        usscontentsdatamanager = departmentFragmentDispatcher;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        usscontentsdatamanager.onScrollChanged(this, 0, i);
        loadingIndicator.setVisibility(8);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        super.onTaskComplete(i, fwloader);
    }

    public void removeObserver(ChannelObserver channelobserver)
    {
        departmentFragmentDispatcher.unregister(channelobserver);
    }

    public void setSelected(boolean flag)
    {
        if (flag)
        {
            if (hasFailedContentLoading && contentDataManager != null)
            {
                contentDataManager.loadData(this);
                loadingIndicator.setVisibility(0);
            }
        } else
        {
            if (isExpanded)
            {
                if (hasSubChannels())
                {
                    View view = getFeaturedCategoriesView();
                    if (view != null)
                    {
                        (new ResizeAnimation(view, 0, view.getHeight())).applyTransformation(0.0F, null);
                    }
                }
                isExpanded = false;
            }
            if (getView() != null)
            {
                ImageView imageview = (ImageView)getView().findViewById(0x7f1000c7);
                if (imageview != null)
                {
                    imageview.setY(-backgroundOffset);
                }
            }
            if (departmentRecyclerView != null)
            {
                departmentRecyclerView.scrollToPosition(0);
                departmentFragmentDispatcher.onScrollChanged(this, 0, 0);
                return;
            }
        }
    }

    public void setTitleVisibility(boolean flag)
    {
        int i = 0;
        if (departmentRecyclerView != null)
        {
            RecyclerContentAdapter recyclercontentadapter = (RecyclerContentAdapter)departmentRecyclerView.getAdapter();
            if (recyclercontentadapter != null)
            {
                int j = recyclercontentadapter.getPositionForViewType(0);
                if (j >= 0)
                {
                    Object obj = (DepartmentTitleViewHolder)departmentRecyclerView.findViewHolderForAdapterPosition(j);
                    if (obj != null && ((DepartmentTitleViewHolder) (obj)).itemView != null)
                    {
                        obj = ((DepartmentTitleViewHolder) (obj)).itemView;
                        if (!flag)
                        {
                            i = 4;
                        }
                        ((View) (obj)).setVisibility(i);
                    }
                }
            }
        }
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        setSelected(flag);
    }

    public void toggleFeaturedCategories()
    {
        boolean flag = false;
        if (hasSubChannels())
        {
            if (isExpanded)
            {
                collapseView(getFeaturedCategoriesView());
            } else
            if (hasScrollOffset())
            {
                departmentRecyclerView.scrollToPosition(0);
                expandView(getFeaturedCategoriesView());
            } else
            {
                expandView(getFeaturedCategoriesView());
            }
            if (!isExpanded)
            {
                flag = true;
            }
            isExpanded = flag;
        }
    }







/*
    static boolean access$402(DepartmentFragment departmentfragment, boolean flag)
    {
        departmentfragment.isExpanded = flag;
        return flag;
    }

*/


}
