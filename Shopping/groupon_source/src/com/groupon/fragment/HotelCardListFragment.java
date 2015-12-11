// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.LoaderManager;
import android.content.Intent;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.Outline;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.text.Spannable;
import android.text.format.DateFormat;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewPropertyAnimator;
import android.view.ViewTreeObserver;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.google.android.gms.maps.MapsInitializer;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.adapter.HotelPagerAdapter;
import com.groupon.animation.ActivityTransitionUtils;
import com.groupon.db.models.Hotel;
import com.groupon.db.models.MarketRateResult;
import com.groupon.getaways.carousel.HotelDealCardViewPresenter;
import com.groupon.manager.MarketRateSyncManager;
import com.groupon.mapview.HotelMapView;
import com.groupon.models.nst.ImpressionClickMetadata;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.service.LocationService;
import com.groupon.service.core.AbTestService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.GeoUtils;
import com.groupon.util.HotelsMultiColumnListAdapter;
import com.groupon.util.LoggingUtils;
import com.groupon.util.MarketRateUtil;
import com.groupon.util.OnBackPressListener;
import com.groupon.view.HotelsLoadingScreen;
import com.groupon.view.dealcards.HotelSmallDealCard;
import commonlib.adapter.JavaListAdapter;
import commonlib.adapter.PendingAdapterInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BaseCardListFragment, HotelListLoaderCallbacks, DealCardEndlessAdapter

public abstract class HotelCardListFragment extends BaseCardListFragment
    implements OnBackPressListener
{
    public class HotelDealCardEndlessAdapter extends DealCardEndlessAdapter
    {

        final HotelCardListFragment this$0;

        public View createPendingView(ViewGroup viewgroup)
        {
            viewgroup = super.createPendingView(viewgroup);
            if (isHotelsMap1503USCA)
            {
                viewgroup.setBackgroundColor(getResources().getColor(0x7f0e00e2));
            }
            return viewgroup;
        }

        public HotelDealCardEndlessAdapter(DealsAndMyGrouponsBaseEndlessAdapter.PaginatedSyncManagerProvider paginatedsyncmanagerprovider, commonlib.manager.SyncManager.SyncUiCallbacks syncuicallbacks, BaseAdapter baseadapter)
        {
            this$0 = HotelCardListFragment.this;
            super(paginatedsyncmanagerprovider, syncuicallbacks, baseadapter);
        }
    }

    private static class MarketRateDealImpressionObject
    {

        private final int index;
        private final boolean isRaODeal;
        private final String nstChannel;
        private final String productType;
        private final String remoteId;

        public int getIndex()
        {
            return index;
        }

        public String getNstChannel()
        {
            return nstChannel;
        }

        public String getProductType()
        {
            return productType;
        }

        public String getRemoteId()
        {
            return remoteId;
        }

        public boolean isRaODeal()
        {
            return isRaODeal;
        }


        public MarketRateDealImpressionObject(String s, String s1, int i, String s2, boolean flag)
        {
            nstChannel = s;
            remoteId = s1;
            index = i;
            productType = s2;
            isRaODeal = flag;
        }
    }


    private static final long ANIMATION_DURATION = 300L;
    private static final String HOTEL_PAGER_MODE_ACTIVATED = "hotel_pager_mode_activated";
    private static final String HOTEL_PAGER_MODE_ONLY = "hotel_pager_mode_only";
    private static final String MIN_COUNT_FOR_LISTVIEW = "min_count_for_listview";
    private static final String SELECTED_HOTEL_ID = "selected_hotel_id";
    private static final String SELECTED_HOTEL_INDEX = "selected_hotel_index";
    private AbTestService abTestService;
    protected int adults;
    protected Date checkInDate;
    protected Date checkOutDate;
    protected int children;
    private CurrencyFormatter currencyFormatter;
    private DataSetObserver dataSetObserver;
    private HotelDealCardEndlessAdapter endlessAdapter;
    private GeoUtils geoUtils;
    private JavaListAdapter hotelListAdapter;
    ViewPager hotelPager;
    private HotelPagerAdapter hotelPagerAdapter;
    ViewGroup hotelPagerContainer;
    private boolean hotelPagerModeAnimationLock;
    ImageButton hotelPagerModeDeactivatorButton;
    HotelMapView hotelsMapView;
    protected LayoutInflater inflater;
    private boolean isClickingHotel;
    private boolean isHotelMapSetUp;
    protected boolean isHotelPagerModeActivated;
    protected boolean isHotelPagerModeOnly;
    protected boolean isHotelsMap1503USCA;
    protected boolean isLandscape;
    private boolean isLoading;
    private boolean isMapFloatingButtonABTestEnabled;
    private boolean isMapFloatingButtonVisible;
    private boolean isRaOEnabled;
    protected boolean isSearchFlow;
    ListView list;
    private AnimatorSet listAndPagerAnimatorSet;
    HotelsLoadingScreen loadingView;
    private LocationService locationService;
    ImageButton mapFloatingActionButton;
    private boolean mapFloatingButtonLock;
    private int minCountForListView;
    private List pendingMarketRateDealImpressionLogs;
    private HotelDealCardViewPresenter presenter;
    ViewGroup scrollableContent;
    private String selectedHotelId;
    private int selectedHotelIndex;
    protected Channel sourceChannel;

    public HotelCardListFragment(Channel channel)
    {
        super(channel);
        pendingMarketRateDealImpressionLogs = new ArrayList();
        isHotelPagerModeActivated = false;
        isHotelPagerModeOnly = false;
        selectedHotelIndex = 0;
        isMapFloatingButtonVisible = false;
        mapFloatingButtonLock = false;
        hotelPagerModeAnimationLock = false;
        isLoading = false;
        isHotelMapSetUp = false;
    }

    private boolean checkIfShouldBeHotelPagerModeOnly()
    {
        int i = hotelListAdapter.getCount();
        return i > 0 && i < minCountForListView;
    }

    private void ensureSelectedHotel()
    {
        if (hotelListAdapter != null && (selectedHotelIndex >= hotelListAdapter.getCount() || !((MarketRateResult)hotelListAdapter.getItem(selectedHotelIndex)).remoteId.equals(selectedHotelId)))
        {
            setSelectedHotel(0);
        }
    }

    private Intent getDealDetailsIntent(MarketRateResult marketrateresult, com.groupon.util.ViewUtils.Size size)
    {
        return ((IntentFactory)intentFactory.get()).newDealIntent(marketrateresult, Channel.GETAWAYS, false, checkInDate, checkOutDate, size);
    }

    private Intent getHotelDetailsIntent(MarketRateResult marketrateresult, com.groupon.util.ViewUtils.Size size)
    {
        Channel channel;
        String s;
        if (isSearchFlow)
        {
            channel = Channel.MARKET_RATE;
        } else
        {
            channel = Channel.HOTELS;
        }
        if (isSearchFlow)
        {
            s = pagerChannelAndSubchannel;
        } else
        {
            s = "";
        }
        return ((IntentFactory)intentFactory.get()).newHotelDealDetailsIntent(marketrateresult, DateFormat.format("yyyy-MM-dd", checkInDate).toString(), DateFormat.format("yyyy-MM-dd", checkOutDate).toString(), adults, children, isSearchFlow, channel, s, size);
    }

    private View getHotelSmallDealCardView(View view, MarketRateResult marketrateresult)
    {
        if (view != null && (view instanceof HotelSmallDealCard))
        {
            view = (HotelSmallDealCard)view;
        } else
        {
            view = new HotelSmallDealCard(activity);
        }
        presenter.present(view, marketrateresult);
        return view;
    }

    private void onViewReady()
    {
        if (!isHotelsMap1503USCA || isLandscape)
        {
            return;
        }
        loadingView.setY(getInitialScrollableContentYPosition());
        if (getView().getHeight() > 0)
        {
            float f = getResources().getDimension(0x7f0b016a);
            float f1 = getResources().getDimension(0x7f0b018e);
            minCountForListView = (int)Math.ceil(((float)getView().getHeight() - f1) / f);
            if (hotelListAdapter != null)
            {
                isHotelPagerModeOnly = checkIfShouldBeHotelPagerModeOnly();
            }
        }
        boolean flag;
        if (isHotelPagerModeOnly || isHotelPagerModeActivated)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        setHotelPagerMode(flag, false, true);
    }

    private void setHotelPagerMode(boolean flag, boolean flag1, boolean flag2)
    {
        if (getView() == null || isLandscape || !isHotelsMap1503USCA || isHotelPagerModeActivated == flag && !flag2 || isHotelPagerModeOnly && !flag)
        {
            return;
        }
        stopHotelPagerModeAnimation();
        isHotelPagerModeActivated = flag;
        ensureSelectedHotel();
        if (flag)
        {
            Object obj = hotelPagerModeDeactivatorButton;
            String s;
            LoggingUtils loggingutils;
            byte byte0;
            if (isHotelPagerModeOnly)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            ((ImageButton) (obj)).setVisibility(byte0);
            hotelPagerContainer.setVisibility(0);
            if (isHotelMapSetUp)
            {
                hotelsMapView.setSelectedMarker(selectedHotelIndex, true, true);
            }
            hotelPager.setCurrentItem(selectedHotelIndex, false);
            startHotelPagerModeAnimation(true, flag1);
            setMapFloatingActionButtonShown(false, flag1);
            if (isLandscape)
            {
                obj = "hotel_map_landscape_view";
            } else
            {
                obj = "hotel_map_view";
            }
            loggingutils = loggingUtils;
            if (pagerChannel != null)
            {
                s = pagerChannel.toString();
            } else
            {
                s = "";
            }
            loggingutils.logImpression("", "hotel", ((String) (obj)), s, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
            return;
        }
        mapFloatingButtonLock = true;
        ListView listview = list;
        int i;
        if (selectedHotelIndex == 0)
        {
            i = 0;
        } else
        {
            i = selectedHotelIndex + 1;
        }
        listview.setSelection(i);
        scrollableContent.setVisibility(0);
        startHotelPagerModeAnimation(false, flag1);
        adjustCameraToFitMap();
    }

    private void setMapFloatingActionButtonOutline(final int size)
    {
        ViewOutlineProvider viewoutlineprovider = new ViewOutlineProvider() {

            final HotelCardListFragment this$0;
            final int val$size;

            public void getOutline(View view, Outline outline)
            {
                outline.setOval(0, 0, size, size);
            }

            
            {
                this$0 = HotelCardListFragment.this;
                size = i;
                super();
            }
        };
        mapFloatingActionButton.setOutlineProvider(viewoutlineprovider);
    }

    private void setMapFloatingActionButtonShown(final boolean shown, boolean flag)
    {
        if (getView() == null || shown == isMapFloatingButtonVisible || !isMapFloatingButtonABTestEnabled || mapFloatingActionButton == null)
        {
            return;
        }
        mapFloatingActionButton.animate().cancel();
        isMapFloatingButtonVisible = shown;
        float f;
        ViewPropertyAnimator viewpropertyanimator;
        long l;
        if (shown)
        {
            mapFloatingActionButton.setVisibility(0);
            f = 1.0F;
        } else
        {
            f = 0.0F;
        }
        viewpropertyanimator = mapFloatingActionButton.animate().scaleX(f).scaleY(f);
        if (flag)
        {
            l = 300L;
        } else
        {
            l = 0L;
        }
        viewpropertyanimator.setDuration(l).setListener(new android.animation.Animator.AnimatorListener() {

            final HotelCardListFragment this$0;
            final boolean val$shown;

            private void handleVisibility()
            {
                while (shown != isMapFloatingButtonVisible || isMapFloatingButtonVisible) 
                {
                    return;
                }
                mapFloatingActionButton.setVisibility(4);
            }

            public void onAnimationCancel(Animator animator)
            {
                handleVisibility();
            }

            public void onAnimationEnd(Animator animator)
            {
                handleVisibility();
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = HotelCardListFragment.this;
                shown = flag;
                super();
            }
        });
    }

    private void setSelectedHotel(int i)
    {
        selectedHotelIndex = i;
        String s;
        if (i >= 0 && i < hotelListAdapter.getCount())
        {
            s = ((MarketRateResult)hotelListAdapter.getItem(i)).remoteId;
        } else
        {
            s = null;
        }
        selectedHotelId = s;
    }

    private void setUpDataSetObserver()
    {
        if (!isHotelsMap1503USCA)
        {
            return;
        } else
        {
            dataSetObserver = new DataSetObserver() {

                final HotelCardListFragment this$0;

                public void onChanged()
                {
                    boolean flag1 = true;
                    super.onChanged();
                    if (hotelsMapView != null)
                    {
                        ensureSelectedHotel();
                        if (isHotelMapSetUp)
                        {
                            hotelsMapView.setHotels(hotelListAdapter.getListCopy());
                            if (isLandscape || isHotelPagerModeActivated)
                            {
                                hotelsMapView.setSelectedMarker(selectedHotelIndex, true, true);
                            }
                        }
                        if (isLandscape)
                        {
                            list.setItemChecked(selectedHotelIndex, true);
                            list.setSelection(selectedHotelIndex);
                        }
                    }
                    if (!isLandscape)
                    {
                        hotelPagerAdapter.notifyDataSetChanged();
                        boolean flag2 = isHotelPagerModeOnly;
                        if (minCountForListView > 0)
                        {
                            isHotelPagerModeOnly = checkIfShouldBeHotelPagerModeOnly();
                        }
                        HotelCardListFragment hotelcardlistfragment = HotelCardListFragment.this;
                        boolean flag;
                        if (isHotelPagerModeOnly || isHotelPagerModeActivated)
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                        if (flag2 == isHotelPagerModeOnly)
                        {
                            flag1 = false;
                        }
                        hotelcardlistfragment.setHotelPagerMode(flag, false, flag1);
                    }
                }

            
            {
                this$0 = HotelCardListFragment.this;
                super();
            }
            };
            return;
        }
    }

    private void setUpHeaderView()
    {
        View view = getHeaderView();
        if (isHotelsMap1503USCA)
        {
            if (!isLandscape)
            {
                view.setOnClickListener(new android.view.View.OnClickListener() {

                    final HotelCardListFragment this$0;

                    public void onClick(View view1)
                    {
                        if (hotelPagerModeAnimationLock || isLoading)
                        {
                            return;
                        }
                        LoggingUtils loggingutils = loggingUtils;
                        if (pagerChannel != null)
                        {
                            view1 = pagerChannel.toString();
                        } else
                        {
                            view1 = "";
                        }
                        loggingutils.logClickWithMetadata("", "show_full_map_click", view1, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
                        setHotelPagerMode(true, true);
                    }

            
            {
                this$0 = HotelCardListFragment.this;
                super();
            }
                });
            }
            return;
        }
        TextView textview = (TextView)view.findViewById(0x7f1003bb);
        view.setOnClickListener(new android.view.View.OnClickListener() {

            final HotelCardListFragment this$0;

            public void onClick(View view1)
            {
                onDatesSelectorClicked();
            }

            
            {
                this$0 = HotelCardListFragment.this;
                super();
            }
        });
        if (checkInDate != null && checkOutDate != null)
        {
            textview.setText(MarketRateUtil.getReservationDatesString(getActivity(), checkInDate, checkOutDate));
            return;
        } else
        {
            String s = getString(0x7f080359);
            Spannable spannable = android.text.Spannable.Factory.getInstance().newSpannable(String.format("%s %s", new Object[] {
                s, getString(0x7f0802cb)
            }));
            spannable.setSpan(new ForegroundColorSpan(getResources().getColor(0x7f0e00c2)), 0, s.length(), 18);
            spannable.setSpan(new StyleSpan(1), 0, s.length(), 18);
            textview.setText(spannable);
            return;
        }
    }

    private void setUpHotelPager()
    {
        if (!isHotelsMap1503USCA || hotelPager == null || isLandscape)
        {
            return;
        } else
        {
            int i = (int)getResources().getDimension(0x7f0b0216);
            hotelPagerAdapter = new HotelPagerAdapter(i);
            hotelPager.setPageMargin(-i);
            hotelPager.setOffscreenPageLimit(2);
            hotelPager.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

                final HotelCardListFragment this$0;

                public void onPageScrollStateChanged(int j)
                {
                }

                public void onPageScrolled(int j, float f, int k)
                {
                }

                public void onPageSelected(int j)
                {
                    if (isHotelPagerModeActivated && isHotelMapSetUp)
                    {
                        if (!isClickingHotel)
                        {
                            LoggingUtils loggingutils = loggingUtils;
                            String s;
                            if (pagerChannel != null)
                            {
                                s = (new StringBuilder()).append(pagerChannel.toString()).append(":").append(j).toString();
                            } else
                            {
                                s = Integer.toString(j);
                            }
                            loggingutils.logClickWithMetadata("", "map_carousel_swipe_click", s, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
                        }
                        hotelsMapView.setSelectedMarker(j, true, false);
                    }
                    setSelectedHotel(j);
                }

            
            {
                this$0 = HotelCardListFragment.this;
                super();
            }
            });
            hotelPager.setAdapter(hotelPagerAdapter);
            return;
        }
    }

    private void setUpHotelPagerMode()
    {
        if (isHotelsMap1503USCA && !isLandscape)
        {
            scrollableContent.setVisibility(4);
            hotelPagerContainer.setVisibility(4);
            if (disableScrollHelper)
            {
                getView().getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

                    final HotelCardListFragment this$0;

                    public void onGlobalLayout()
                    {
                        onViewReady();
                        getView().getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }

            
            {
                this$0 = HotelCardListFragment.this;
                super();
            }
                });
            }
        }
    }

    private void setUpHotelPagerModeDeactivatorButton()
    {
        if (!isHotelsMap1503USCA || hotelPagerModeDeactivatorButton == null)
        {
            return;
        } else
        {
            hotelPagerModeDeactivatorButton.setOnClickListener(new android.view.View.OnClickListener() {

                final HotelCardListFragment this$0;

                public void onClick(View view)
                {
                    if (hotelPagerModeAnimationLock)
                    {
                        return;
                    }
                    LoggingUtils loggingutils = loggingUtils;
                    if (pagerChannel != null)
                    {
                        view = pagerChannel.toString();
                    } else
                    {
                        view = "";
                    }
                    loggingutils.logClickWithMetadata("", "show_mini_map_click", view, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
                    setHotelPagerMode(false, true);
                }

            
            {
                this$0 = HotelCardListFragment.this;
                super();
            }
            });
            return;
        }
    }

    private void setUpList()
    {
        if (isHotelsMap1503USCA)
        {
            if (!isLandscape)
            {
                list.setOnScrollListener(new android.widget.AbsListView.OnScrollListener() {

                    final HotelCardListFragment this$0;

                    public void onScroll(AbsListView abslistview, int i, int j, int k)
                    {
                        if (list.isShown() || mapFloatingButtonLock)
                        {
                            if (i >= 1)
                            {
                                setMapFloatingActionButtonShown(true, true);
                                return;
                            }
                            if (i == 0)
                            {
                                setMapFloatingActionButtonShown(false, true);
                                return;
                            }
                        }
                    }

                    public void onScrollStateChanged(AbsListView abslistview, int i)
                    {
                    }

            
            {
                this$0 = HotelCardListFragment.this;
                super();
            }
                });
                return;
            }
            if (hotelsMapView != null)
            {
                list.setChoiceMode(1);
                return;
            }
        }
    }

    private void setUpMapFloatingActionButton()
    {
        boolean flag1 = true;
        if (isHotelsMap1503USCA && mapFloatingActionButton != null)
        {
            mapFloatingActionButton.setVisibility(4);
            if (isMapFloatingButtonABTestEnabled)
            {
                mapFloatingActionButton.setOnClickListener(new android.view.View.OnClickListener() {

                    final HotelCardListFragment this$0;

                    public void onClick(View view)
                    {
                        if (hotelPagerModeAnimationLock)
                        {
                            return;
                        }
                        LoggingUtils loggingutils = loggingUtils;
                        if (pagerChannel != null)
                        {
                            view = pagerChannel.toString();
                        } else
                        {
                            view = "";
                        }
                        loggingutils.logClickWithMetadata("", "show_full_map_floating_button_click", view, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
                        setHotelPagerMode(true, true);
                    }

            
            {
                this$0 = HotelCardListFragment.this;
                super();
            }
                });
                int i = getResources().getDimensionPixelSize(0x7f0b00ef);
                if (android.os.Build.VERSION.SDK_INT >= 21)
                {
                    setMapFloatingActionButtonOutline(i);
                }
                mapFloatingActionButton.setPivotX(i / 2);
                mapFloatingActionButton.setPivotY(i / 2);
                boolean flag;
                if (isMapFloatingButtonVisible || !isHotelPagerModeActivated && list.getFirstVisiblePosition() >= 1)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if (flag)
                {
                    flag1 = false;
                }
                isMapFloatingButtonVisible = flag1;
                setMapFloatingActionButtonShown(flag, false);
                return;
            }
        }
    }

    private void startHotelPagerModeAnimation(final boolean activate, final boolean animated)
    {
        hotelPagerModeAnimationLock = true;
        float f;
        float f1;
        Object obj;
        ObjectAnimator objectanimator;
        long l;
        if (activate)
        {
            f1 = getView().getHeight();
            f = getView().getHeight() - hotelPagerContainer.getHeight();
        } else
        {
            f1 = getInitialScrollableContentYPosition();
            f = getView().getHeight();
        }
        obj = ObjectAnimator.ofFloat(scrollableContent, "y", new float[] {
            f1
        });
        objectanimator = ObjectAnimator.ofFloat(hotelPagerContainer, "y", new float[] {
            f
        });
        listAndPagerAnimatorSet = new AnimatorSet();
        listAndPagerAnimatorSet.playTogether(new Animator[] {
            obj, objectanimator
        });
        obj = listAndPagerAnimatorSet;
        if (animated)
        {
            l = 300L;
        } else
        {
            l = 0L;
        }
        ((AnimatorSet) (obj)).setDuration(l);
        listAndPagerAnimatorSet.addListener(new android.animation.Animator.AnimatorListener() {

            final HotelCardListFragment this$0;
            final boolean val$activate;
            final boolean val$animated;

            private void handleVisibility()
            {
                if (activate != isHotelPagerModeActivated)
                {
                    return;
                }
                if (!activate) goto _L2; else goto _L1
_L1:
                scrollableContent.setVisibility(4);
_L4:
                if (isHotelMapSetUp)
                {
                    hotelsMapView.setMapGesturesEnabled(activate);
                }
                hotelPagerModeAnimationLock = false;
                return;
_L2:
                mapFloatingButtonLock = false;
                if (list.getFirstVisiblePosition() > 0)
                {
                    setMapFloatingActionButtonShown(true, animated);
                }
                hotelPagerContainer.setVisibility(4);
                hotelPager.setCurrentItem(0, false);
                if (isHotelMapSetUp)
                {
                    hotelsMapView.setSelectedMarker(-1, false, false);
                }
                if (true) goto _L4; else goto _L3
_L3:
            }

            public void onAnimationCancel(Animator animator)
            {
                handleVisibility();
            }

            public void onAnimationEnd(Animator animator)
            {
                handleVisibility();
            }

            public void onAnimationRepeat(Animator animator)
            {
            }

            public void onAnimationStart(Animator animator)
            {
            }

            
            {
                this$0 = HotelCardListFragment.this;
                activate = flag;
                animated = flag1;
                super();
            }
        });
        listAndPagerAnimatorSet.start();
    }

    private void stopHotelPagerModeAnimation()
    {
        if (listAndPagerAnimatorSet != null)
        {
            if (listAndPagerAnimatorSet.isRunning())
            {
                listAndPagerAnimatorSet.cancel();
            }
            listAndPagerAnimatorSet.removeAllListeners();
        }
    }

    protected void adjustCameraToFitMap()
    {
    }

    public void configureSyncManager()
    {
        ((MarketRateSyncManager)getSyncManager()).setCheckInDate(checkInDate);
        ((MarketRateSyncManager)getSyncManager()).setCheckOutDate(checkOutDate);
        ((MarketRateSyncManager)getSyncManager()).setSearchFlow(isSearchFlow);
    }

    protected final View createHeaderView()
    {
        if (isHotelsMap1503USCA)
        {
            if (!isLandscape)
            {
                View view = new View(getActivity());
                view.setMinimumHeight((int)getResources().getDimension(0x7f0b018e));
                return view;
            } else
            {
                return null;
            }
        } else
        {
            return createListHeaderView();
        }
    }

    protected View createListHeaderView()
    {
        return null;
    }

    public PendingAdapterInterface getAppendingAdapter()
    {
        return dealCardEndlessAdapter;
    }

    protected View getCardView(ListAdapter listadapter, int i, View view, ViewGroup viewgroup)
    {
        listadapter = (MarketRateResult)listadapter.getItem(i);
        boolean flag;
        if (isRaOEnabled && ((MarketRateResult) (listadapter)).hasRaO)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (getUserVisibleHint())
        {
            loggingUtils.logMarketRateDealImpression(nstChannel, ((MarketRateResult) (listadapter)).remoteId, i, ((MarketRateResult) (listadapter)).productType, flag);
        } else
        {
            pendingMarketRateDealImpressionLogs.add(new MarketRateDealImpressionObject(nstChannel, ((MarketRateResult) (listadapter)).remoteId, i, ((MarketRateResult) (listadapter)).productType, flag));
        }
        return getHotelSmallDealCardView(view, listadapter);
    }

    protected DealCardEndlessAdapter getDealCardEndlessAdapter(BaseAdapter baseadapter, BaseCardListFragment basecardlistfragment)
    {
        baseadapter = new HotelDealCardEndlessAdapter(this, this, new HotelsMultiColumnListAdapter(baseadapter, 1) {

            final HotelCardListFragment this$0;

            public void onMarketRateDealCardClicked(int i, View view, MarketRateResult marketrateresult)
            {
                String s = marketrateresult.remoteId;
                LoggingUtils loggingutils = loggingUtils;
                Object obj;
                if (pagerChannel != null)
                {
                    obj = pagerChannel.toString();
                } else
                {
                    obj = "";
                }
                loggingutils.logClickWithMetadata("", "impression_click", ((String) (obj)), new ImpressionClickMetadata(s, "", i, "hotel"));
                obj = view.findViewById(0x7f100121);
                if (android.os.Build.VERSION.SDK_INT >= 21)
                {
                    obj = ActivityTransitionUtils.getDealToDetailsActivityOptions(getActivity(), ((View) (obj)));
                } else
                {
                    obj = null;
                }
                view = ((HotelSmallDealCard)((com.groupon.util.MultiColumnListAdapter.RowItemWrapper)view).getWrappedView()).getImageViewSize();
                if (Strings.equalsIgnoreCase(marketrateresult.source, "HOTEL"))
                {
                    view = getHotelDetailsIntent(marketrateresult, view);
                } else
                {
                    view = getDealDetailsIntent(marketrateresult, view);
                }
                startActivity(view, ((Bundle) (obj)));
            }

            
            {
                this$0 = HotelCardListFragment.this;
                super(listadapter, i);
            }
        });
        if (isHotelsMap1503USCA)
        {
            if (hotelPagerAdapter != null)
            {
                hotelPagerAdapter.setAdapter(baseadapter);
            }
            if (endlessAdapter != null)
            {
                endlessAdapter.unregisterDataSetObserver(dataSetObserver);
            }
            endlessAdapter = baseadapter;
            endlessAdapter.registerDataSetObserver(dataSetObserver);
        }
        return baseadapter;
    }

    protected float getInitialScrollableContentYPosition()
    {
        return 0.0F;
    }

    protected abstract String getOriginatingChannel();

    public void initLoader(JavaListAdapter javalistadapter)
    {
        if (isHotelsMap1503USCA)
        {
            hotelListAdapter = javalistadapter;
        }
        getLoaderManager().initLoader(0, null, new HotelListLoaderCallbacks(javalistadapter, this));
    }

    protected boolean isHeaderSelectable()
    {
        return true;
    }

    public boolean isMapAvailable()
    {
        return isHotelsMap1503USCA && hotelsMapView != null && isHotelMapSetUp;
    }

    protected void logDealImpression(String s, String s1, Hotel hotel, int i, JsonEncodedNSTField jsonencodednstfield, String s2, AbTestService abtestservice, 
            boolean flag, boolean flag1)
    {
    }

    protected volatile void logDealImpression(String s, String s1, Object obj, int i, JsonEncodedNSTField jsonencodednstfield, String s2, AbTestService abtestservice, 
            boolean flag, boolean flag1)
    {
        logDealImpression(s, s1, (Hotel)obj, i, jsonencodednstfield, s2, abtestservice, flag, flag1);
    }

    public boolean onBackPressed()
    {
        if (isHotelPagerModeActivated && !isHotelPagerModeOnly)
        {
            setHotelPagerMode(false, true);
            return true;
        } else
        {
            return false;
        }
    }

    public void onCreate(Bundle bundle)
    {
        Object obj = null;
        super.onCreate(bundle);
        isLandscape = getResources().getBoolean(0x7f090006);
        isMapFloatingButtonABTestEnabled = abTestService.isVariantEnabled("hotelsMap1503USCA", "onWithFloatingButton");
        Bundle bundle1;
        boolean flag;
        if (abTestService.isVariantEnabled("hotelsMap1503USCA", "on") || isMapFloatingButtonABTestEnabled)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isHotelsMap1503USCA = flag;
        isRaOEnabled = abTestService.isVariantEnabledAndUSCA("getawaysRequestAnOffer1508USCA", "on");
        bundle1 = getArguments();
        if (bundle1 != null)
        {
            isSearchFlow = bundle1.getBoolean("search_flow", false);
            sourceChannel = (Channel)bundle1.getParcelable("sourceChannel");
            long l = bundle1.getLong("check_in_date");
            long l1 = bundle1.getLong("check_out_date");
            Date date;
            if (l != 0L)
            {
                date = new Date(l);
            } else
            {
                date = null;
            }
            checkInDate = date;
            date = obj;
            if (l1 != 0L)
            {
                date = new Date(l1);
            }
            checkOutDate = date;
            adults = bundle1.getInt("adults");
            children = bundle1.getInt("children");
        }
        adults = 2;
        children = 0;
        if (bundle != null && isHotelsMap1503USCA)
        {
            selectedHotelIndex = bundle.getInt("selected_hotel_index", 0);
            selectedHotelId = bundle.getString("selected_hotel_id");
            isHotelPagerModeActivated = bundle.getBoolean("hotel_pager_mode_activated", false);
            isHotelPagerModeOnly = bundle.getBoolean("hotel_pager_mode_only", false);
            minCountForListView = bundle.getInt("min_count_for_listview");
        }
        presenter = (new HotelDealCardViewPresenter(currencyFormatter)).setLocationProviders(locationService, geoUtils).setIsRaoOffer(isRaOEnabled);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        int i;
        if (isHotelsMap1503USCA)
        {
            i = 0x7f03013e;
        } else
        {
            i = 0x7f03013c;
        }
        layoutinflater = layoutinflater.inflate(i, viewgroup, false);
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    protected abstract void onDatesSelectorClicked();

    public void onDestroyView()
    {
        stopHotelPagerModeAnimation();
        if (hotelPagerAdapter != null)
        {
            hotelPagerAdapter.setAdapter(null);
        }
        if (isMapAvailable())
        {
            hotelsMapView.release();
            isHotelMapSetUp = false;
        }
        hotelListAdapter = null;
        if (endlessAdapter != null && dataSetObserver != null)
        {
            endlessAdapter.unregisterDataSetObserver(dataSetObserver);
        }
        endlessAdapter = null;
        dataSetObserver = null;
        if (mapFloatingActionButton != null)
        {
            mapFloatingActionButton.animate().cancel();
            mapFloatingActionButton.animate().setListener(null);
        }
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        if (isMapAvailable())
        {
            hotelsMapView.onLowMemory();
        }
    }

    public void onPause()
    {
        if (isMapAvailable())
        {
            hotelsMapView.onPause();
        }
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (isMapAvailable())
        {
            hotelsMapView.onResume();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (isHotelsMap1503USCA)
        {
            bundle.putInt("selected_hotel_index", selectedHotelIndex);
            bundle.putString("selected_hotel_id", selectedHotelId);
            bundle.putBoolean("hotel_pager_mode_activated", isHotelPagerModeActivated);
            bundle.putBoolean("hotel_pager_mode_only", isHotelPagerModeOnly);
            bundle.putInt("min_count_for_listview", minCountForListView);
        }
    }

    public void onToolBarInitialized()
    {
        super.onToolBarInitialized();
        onViewReady();
    }

    public void onViewCreated(View view, Bundle bundle)
    {
        super.onViewCreated(view, bundle);
        setUpList();
        setUpHotelPager();
        setUpDataSetObserver();
        setUpHeaderView();
        setUpHotelPagerModeDeactivatorButton();
        setUpMapFloatingActionButton();
        setUpHotelPagerMode();
        showLoadingView(true);
    }

    protected void setHotelPagerMode(boolean flag, boolean flag1)
    {
        setHotelPagerMode(flag, flag1, false);
    }

    public void setUpHotelMap()
    {
        if (!isHotelsMap1503USCA || hotelsMapView == null || isHotelMapSetUp)
        {
            return;
        }
        long l = SystemClock.elapsedRealtime();
        MapsInitializer.initialize(getActivity());
        hotelsMapView.onCreate(null);
        hotelsMapView.onResume();
        isHotelMapSetUp = true;
        if (hotelListAdapter != null)
        {
            hotelsMapView.setHotels(hotelListAdapter.getListCopy());
        }
        hotelsMapView.setOnHotelClickListener(new com.groupon.mapview.HotelMapView.OnHotelClickListener() {

            final HotelCardListFragment this$0;

            public void onHotelClicked(int i)
            {
                LoggingUtils loggingutils = loggingUtils;
                String s;
                if (pagerChannel != null)
                {
                    s = (new StringBuilder()).append(pagerChannel.toString()).append(":").append(i).toString();
                } else
                {
                    s = Integer.toString(i);
                }
                loggingutils.logClickWithMetadata("", "map_deal_icon_click", s, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
                isClickingHotel = true;
                if (isLandscape)
                {
                    list.setItemChecked(i, true);
                    list.setSelection(i);
                } else
                {
                    hotelPager.setCurrentItem(i, true);
                }
                setSelectedHotel(i);
                isClickingHotel = false;
            }

            
            {
                this$0 = HotelCardListFragment.this;
                super();
            }
        });
        hotelsMapView.setMyLocationEnabled(true);
        Object obj = hotelsMapView;
        boolean flag;
        if (isLandscape || isHotelPagerModeActivated)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((HotelMapView) (obj)).setMapGesturesEnabled(flag);
        ensureSelectedHotel();
        if (isLandscape || isHotelPagerModeActivated)
        {
            hotelsMapView.setSelectedMarker(selectedHotelIndex, true, true);
        }
        if (isLandscape)
        {
            list.setItemChecked(selectedHotelIndex, true);
            list.setSelection(selectedHotelIndex);
        }
        adjustCameraToFitMap();
        obj = getClass().getSimpleName();
        logger.logGeneralEvent("android_events", "map_setup", ((String) (obj)), (int)(SystemClock.elapsedRealtime() - l), Logger.NULL_NST_FIELD);
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (flag)
        {
            MarketRateDealImpressionObject marketratedealimpressionobject;
            for (Iterator iterator = pendingMarketRateDealImpressionLogs.iterator(); iterator.hasNext(); loggingUtils.logMarketRateDealImpression(marketratedealimpressionobject.getNstChannel(), marketratedealimpressionobject.remoteId, marketratedealimpressionobject.getIndex(), marketratedealimpressionobject.getProductType(), marketratedealimpressionobject.isRaODeal()))
            {
                marketratedealimpressionobject = (MarketRateDealImpressionObject)iterator.next();
            }

            pendingMarketRateDealImpressionLogs.clear();
        }
    }

    public void showLoadingView(boolean flag)
    {
        if (getView() != null)
        {
            HotelsLoadingScreen hotelsloadingscreen = loadingView;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            hotelsloadingscreen.setVisibility(i);
        }
        isLoading = flag;
    }

    protected void tracking(String s, Hotel hotel, int i, JsonEncodedNSTField jsonencodednstfield)
    {
    }

    protected volatile void tracking(String s, Object obj, int i, JsonEncodedNSTField jsonencodednstfield)
    {
        tracking(s, (Hotel)obj, i, jsonencodednstfield);
    }














/*
    static boolean access$302(HotelCardListFragment hotelcardlistfragment, boolean flag)
    {
        hotelcardlistfragment.mapFloatingButtonLock = flag;
        return flag;
    }

*/





/*
    static boolean access$602(HotelCardListFragment hotelcardlistfragment, boolean flag)
    {
        hotelcardlistfragment.hotelPagerModeAnimationLock = flag;
        return flag;
    }

*/



/*
    static boolean access$702(HotelCardListFragment hotelcardlistfragment, boolean flag)
    {
        hotelcardlistfragment.isClickingHotel = flag;
        return flag;
    }

*/


}
