// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.ButterKnife;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.VisibleRegion;
import com.groupon.Channel;
import com.groupon.abtest.GtgAbTestHelper;
import com.groupon.abtest.SnapAbTestHelper;
import com.groupon.activity.Carousel;
import com.groupon.activity.DontRestartOnConfigurationChange;
import com.groupon.activity.IntentFactory;
import com.groupon.activity.SnapOfferGridActivity;
import com.groupon.adapter.BaseGoodsCategoryAdapter;
import com.groupon.adapter.DealClickListener;
import com.groupon.adapter.GoodsCategoriesAdapter;
import com.groupon.adapter.GoodsCategoryDecoration;
import com.groupon.adapter.LocationIndexerAdapter;
import com.groupon.adapter.listener.OnCategoryImpressionEventListener;
import com.groupon.adapter.listener.OnCategoryItemClickListener;
import com.groupon.adapter.listener.OnRecyclerItemTouchListener;
import com.groupon.db.models.DealSummary;
import com.groupon.http.Http;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.manager.AnyChannelSyncManager;
import com.groupon.manager.NearbySyncManager;
import com.groupon.mapview.DealsMapView;
import com.groupon.models.FilterCategory;
import com.groupon.models.Place;
import com.groupon.models.category.Category;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.models.error.GrouponException;
import com.groupon.models.gdt.GtgMockCategory;
import com.groupon.models.nst.JsonEncodedNSTField;
import com.groupon.models.nst.NearbyMapRedoSearchMetadata;
import com.groupon.service.CategoryService;
import com.groupon.service.DealTypeService;
import com.groupon.service.LocationService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.gdt.GdtService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.BuyUtils;
import com.groupon.util.CategoriesUtil;
import com.groupon.util.CountryUtil;
import com.groupon.util.Function1;
import com.groupon.util.GeoPoint;
import com.groupon.util.GeoUtils;
import com.groupon.util.GetPlaceByCoordinates;
import com.groupon.util.LocationAutocompleteClient;
import com.groupon.util.LocationsAutocompleteServiceWrapper;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ScrollToolBarHelper;
import com.groupon.util.ViewUtils;
import com.groupon.view.BrowseByCategoryBar;
import com.groupon.view.FilterBar;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.SpinnerButton;
import commonlib.manager.PaginatedSyncManager;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import roboguice.inject.ContextScopedProvider;
import roboguice.inject.Lazy;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            DealCardListFragment, OnPagerSelectionChange, DealCardEndlessAdapter

public class NearbyDealsFragment extends DealCardListFragment
    implements android.view.View.OnTouchListener, DontRestartOnConfigurationChange, DealClickListener, OnPagerSelectionChange, com.groupon.mapview.DealsMapView.OnChangeListener, LocationAutocompleteClient
{
    protected class CategoriesAdapter extends ArrayAdapter
    {

        private List categories;
        private LayoutInflater inflater;
        final NearbyDealsFragment this$0;

        public int getCount()
        {
            return categories.size() + 1;
        }

        public final Category getItem(int i)
        {
            if (i == 0)
            {
                return null;
            } else
            {
                return (Category)categories.get(i - 1);
            }
        }

        public volatile Object getItem(int i)
        {
            return getItem(i);
        }

        public long getItemId(int i)
        {
            return (long)i;
        }

        public int getItemViewType(int i)
        {
            return 0;
        }

        public View getView(int i, View view, ViewGroup viewgroup)
        {
            View view1 = view;
            if (view == null)
            {
                view1 = inflater.inflate(0x7f030178, viewgroup, false);
            }
            view = (TextView)view1.findViewById(0x7f100458);
            viewgroup = view1.findViewById(0x7f100327);
            Category category = getItem(i);
            viewgroup.setVisibility(8);
            if (category == null)
            {
                view.setText(0x7f08005e);
                return view1;
            }
            if (isGTGOnNearby && Strings.equals(category.id, "gtg_mock_category_id"))
            {
                if (isGTGNewFlagDivision)
                {
                    viewgroup.setVisibility(0);
                }
                view.setText(0x7f08012f);
                return view1;
            } else
            {
                view.setText(category.name);
                return view1;
            }
        }

        public int getViewTypeCount()
        {
            return 1;
        }

        public void setCategories(List list)
        {
            categories = list;
        }

        public CategoriesAdapter(Context context)
        {
            this$0 = NearbyDealsFragment.this;
            super(context, 0x1090006);
            inflater = (LayoutInflater)context.getSystemService("layout_inflater");
            categories = new ArrayList();
        }
    }

    private class OnCategoryBarClickListener
        implements android.view.View.OnClickListener
    {

        final NearbyDealsFragment this$0;

        public void onClick(View view)
        {
            loggingUtils.logCategoryBarClick("browse_by_category", nstChannel, Channel.NEARBY.toString());
            view = ((IntentFactory)intentFactory.get()).newGlobalSearchIntent(getChannel());
            view.putExtra("browse_by_category", isSingleNearbyCategorySelector);
            startActivity(view);
        }

        private OnCategoryBarClickListener()
        {
            this$0 = NearbyDealsFragment.this;
            super();
        }

    }

    private class OnNearbyCategoryImpressionEventListener
        implements OnCategoryImpressionEventListener
    {

        final NearbyDealsFragment this$0;

        public void onImpressionEvent(Category category)
        {
            loggingUtils.logGoodsCategoryImpression(category.id);
        }

        private OnNearbyCategoryImpressionEventListener()
        {
            this$0 = NearbyDealsFragment.this;
            super();
        }

    }

    private class OnNearbyCategoryItemClickListener
        implements OnCategoryItemClickListener
    {

        final NearbyDealsFragment this$0;

        public void onItemClick(View view, int i)
        {
            view = (Category)nearbyCategories.get(i);
            if (view == null)
            {
                return;
            }
            loggingUtils.logCategoryCarouselClick("category_click", nstChannel, Channel.NEARBY.toString(), view);
            if (isGTGOnNearby && Strings.equals(((Category) (view)).id, "gtg_mock_category_id"))
            {
                startActivity(((IntentFactory)intentFactory.get()).newGrouponWebViewIntent(gdtService.getGtgEntryUrl(), false, true, true, true, false));
                return;
            }
            if (((Category) (view)).id.equals(NearbyDealsFragment.SNAP_GROCERY_ID))
            {
                startActivity(((IntentFactory)intentFactory.get()).newSnapOfferGridIntent((new StringBuilder()).append(Channel.SNAP_GROCERY).append(com/groupon/activity/SnapOfferGridActivity.getSimpleName()).toString(), Channel.SNAP_GROCERY));
                return;
            } else
            {
                startActivity(((IntentFactory)intentFactory.get()).newCategoryCarouselGlobalSearchResultIntent(channel, view, 1, true, false));
                return;
            }
        }

        private OnNearbyCategoryItemClickListener()
        {
            this$0 = NearbyDealsFragment.this;
            super();
        }

    }

    private class OnRecyclerScrollListener extends android.support.v7.widget.RecyclerView.OnScrollListener
    {

        final NearbyDealsFragment this$0;

        public void onScrollStateChanged(RecyclerView recyclerview, int i)
        {
            boolean flag = true;
            recyclerview = NearbyDealsFragment.this;
            if (i == 1)
            {
                flag = false;
            }
            recyclerview.setPullToRefreshEnabled(flag);
        }

        private OnRecyclerScrollListener()
        {
            this$0 = NearbyDealsFragment.this;
            super();
        }

    }

    protected static class RefreshRunnable
        implements Runnable
    {

        private WeakReference fragmentRef;

        public void run()
        {
            NearbyDealsFragment nearbydealsfragment = (NearbyDealsFragment)fragmentRef.get();
            if (nearbydealsfragment == null)
            {
                return;
            } else
            {
                nearbydealsfragment.handler.postDelayed(this, 0x36ee80L);
                nearbydealsfragment.refresh(ReloadReason.periodicReload);
                return;
            }
        }

        public RefreshRunnable(NearbyDealsFragment nearbydealsfragment)
        {
            fragmentRef = new WeakReference(nearbydealsfragment);
        }
    }

    public static final class ReloadReason extends Enum
    {

        private static final ReloadReason $VALUES[];
        public static final ReloadReason filterModified;
        public static final ReloadReason isDeepLinked;
        public static final ReloadReason locationSet;
        public static final ReloadReason periodicReload;
        public static final ReloadReason reload;
        public static final ReloadReason signInSignOut;
        public static final ReloadReason userInitiated;
        public String searchOrigin;
        public boolean spanLocations;

        public static boolean isFilterModified(ReloadReason reloadreason)
        {
            return reloadreason == filterModified || reloadreason == locationSet;
        }

        public static boolean useMapCenter(ReloadReason reloadreason)
        {
            return reloadreason != reload && reloadreason != locationSet;
        }

        public static ReloadReason valueOf(String s)
        {
            return (ReloadReason)Enum.valueOf(com/groupon/fragment/NearbyDealsFragment$ReloadReason, s);
        }

        public static ReloadReason[] values()
        {
            return (ReloadReason[])$VALUES.clone();
        }

        static 
        {
            userInitiated = new ReloadReason("userInitiated", 0, "refresh-user-initiated");
            periodicReload = new ReloadReason("periodicReload", 1, "refresh-auto");
            signInSignOut = new ReloadReason("signInSignOut", 2, "refresh-auto");
            reload = new ReloadReason("reload", 3, "refresh-reload-activity");
            locationSet = new ReloadReason("locationSet", 4, null);
            filterModified = new ReloadReason("filterModified", 5, null);
            isDeepLinked = new ReloadReason("isDeepLinked", 6, null);
            $VALUES = (new ReloadReason[] {
                userInitiated, periodicReload, signInSignOut, reload, locationSet, filterModified, isDeepLinked
            });
        }

        private ReloadReason(String s, int i, String s1)
        {
            super(s, i);
            spanLocations = true;
            searchOrigin = s1;
        }
    }


    private static final String FOOD_AND_DRINK_CATEGORY_ID = "food-and-drink";
    private static final int GTG_CATEGORY_CAROUSEL_ENTRY_POSITION = 0;
    private static final long HOUR = 0x36ee80L;
    private static final long MINUTE = 60000L;
    private static String SNAP_GROCERY_ID = "groceries";
    String ALL_DEALS;
    String CURRENT_LOCATION;
    String MAP_LOCATION;
    String SELECT_CATEGORY;
    private Activity activity;
    private ListView autocompleteListView;
    BrowseByCategoryBar browseByCategoryBar;
    BrowseByCategoryBar browseByCategoryBarFromMap;
    private Bundle bundleForMapView;
    private Lazy buyUtil;
    private LatLng cameraPosition;
    private CategoriesAdapter categoriesAdapter;
    private View categoriesContainer;
    private RecyclerView categoriesList;
    private CategoriesUtil categoriesUtil;
    FilterBar categoryFilter;
    private Lazy categoryService;
    private CountryUtil countryUtil;
    private CurrentCountryManager currentCountryManager;
    private CurrentDivisionManager currentDivisionManager;
    List dealListGlobal;
    ListView dealListView;
    FrameLayout dealMapSection;
    private ContextScopedProvider dealTypeService;
    private float downEventX;
    private float downEventY;
    private FilterCategory filterCategory;
    LinearLayout filtersBar;
    private String fragmentKey;
    private GdtService gdtService;
    private Lazy geoUtils;
    private Geocoder geocoder;
    private GtgAbTestHelper gtgAbTestHelper;
    private Handler handler;
    FrameLayout iconContainer;
    private LayoutInflater inflater;
    private Lazy intentFactory;
    private boolean isCarouselNearbyCategorySelector;
    protected boolean isGTGNewFlagDivision;
    protected boolean isGTGOnNearby;
    private boolean isSingleNearbyCategorySelector;
    protected boolean isSnapNearbyCarouselCategoryEnabled;
    protected boolean isSnapNearbyCategoryEnabled;
    RelativeLayout listIcon;
    TextView listIconText;
    private LocationsAutocompleteServiceWrapper locationAutocompleteServiceWrapper;
    private EditText locationEditText;
    FilterBar locationFilter;
    private LocationService locationService;
    protected boolean locationServicesEnabled;
    private Logger logger;
    FrameLayout mapControls;
    RelativeLayout mapIcon;
    TextView mapIconText;
    private DealsMapView mapView;
    private GeoPoint myLocation;
    private List nearbyCategories;
    private boolean nearbyCategoryAnimationDisplayed;
    SpinnerButton nearbyMapRefreshButton;
    View noDealsMessageView;
    private PopupWindow popupWindow;
    private SharedPreferences prefs;
    private boolean previousFullMapMode;
    private Runnable refreshTimer;
    SpinnerButton reloadButton;
    private ScrollToolBarHelper scrollToolBarHelper;
    private GeoPoint searchLocation;
    private SearchManager searchManager;
    private SnapAbTestHelper snapAbTestHelper;
    SwipeRefreshLayout swipeLayout;
    private NearbySyncManager syncManager;

    public NearbyDealsFragment()
    {
        super(Channel.NEARBY);
        refreshTimer = new RefreshRunnable(this);
        categoriesAdapter = null;
    }

    private void addDeals(List list)
    {
        Place place = getPlaceForMap();
        mapView.addDeals(list, new GeoPoint((int)(place.lat * 1000000D), (int)(place.lng * 1000000D)));
        ((DealTypeService)dealTypeService.get(getActivity())).preProcessDealListNew(list);
    }

    private void adjustToFullMapMode(boolean flag)
    {
        boolean flag2 = true;
        boolean flag3 = isPageSelected();
        boolean flag1;
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        enableApplicationOverlaysAndSwipes(flag1);
        if (mapView != null)
        {
            mapView.enableMapDealDetails(flag);
            if (flag)
            {
                if (mapView.getParent() == null)
                {
                    dealMapSection.addView(mapView, 0);
                }
            } else
            {
                dealMapSection.removeView(mapView);
            }
        }
        if (flag3 && flag)
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        enableMyLocation(flag);
    }

    private PopupWindow createListPopup(final LinearLayout popupWindow, ListView listview, int i)
    {
        popupWindow = new PopupWindow(popupWindow, i, -2, true);
        listview.measure(0, 0);
        popupWindow.setBackgroundDrawable(getResources().getDrawable(0x7f0e01a9));
        popupWindow.setFocusable(true);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchInterceptor(new android.view.View.OnTouchListener() {

            final NearbyDealsFragment this$0;
            final PopupWindow val$popupWindow;

            public boolean onTouch(View view, MotionEvent motionevent)
            {
                if (motionevent.getAction() == 4)
                {
                    popupWindow.dismiss();
                    return true;
                } else
                {
                    return false;
                }
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                popupWindow = popupwindow;
                super();
            }
        });
        return popupWindow;
    }

    private void doStartCategoryCarouselAnimation()
    {
        if (!nearbyCategoryAnimationDisplayed && getUserVisibleHint() && isAdded())
        {
            ObjectAnimator objectanimator = ObjectAnimator.ofFloat(categoriesList, "x", new float[] {
                0.0F, getResources().getDimension(0x7f0b0152) / 2.0F
            });
            objectanimator.setInterpolator(new DecelerateInterpolator());
            objectanimator.setDuration(400L);
            objectanimator.setRepeatCount(1);
            objectanimator.setRepeatMode(2);
            objectanimator.setStartDelay(200L);
            objectanimator.start();
            nearbyCategoryAnimationDisplayed = true;
        }
    }

    private void enableApplicationOverlaysAndSwipes(boolean flag)
    {
        Object obj = (Carousel)activity;
        if (obj != null)
        {
            obj = ((Carousel) (obj)).getWindow();
            if (obj != null)
            {
                obj = (GrouponViewPager)((Window) (obj)).findViewById(0x7f1000ad);
                if (obj != null)
                {
                    ((GrouponViewPager) (obj)).setPagingEnabled(flag);
                }
            }
        }
    }

    private void enableMyLocation(boolean flag)
    {
        boolean flag2 = false;
        if (mapView != null)
        {
            Object obj = mapView.getGoogleMap();
            if (obj != null)
            {
                ((GoogleMap) (obj)).setMyLocationEnabled(flag);
                ((GoogleMap) (obj)).getUiSettings().setMyLocationButtonEnabled(false);
                obj = ((GoogleMap) (obj)).getUiSettings();
                boolean flag1 = flag2;
                if (flag)
                {
                    flag1 = flag2;
                    if (myLocation != null)
                    {
                        flag1 = true;
                    }
                }
                ((UiSettings) (obj)).setCompassEnabled(flag1);
            }
        }
    }

    private void enteringFullMapMode()
    {
        initMapView();
        adjustToFullMapMode(true);
        Carousel carousel;
        String s1;
        carousel = (Carousel)activity;
        s1 = fragmentKey;
        String s;
        if (previousFullMapMode)
        {
            s = "map";
        } else
        {
            s = "list";
        }
        try
        {
            carousel.redirectTracking(s1, "now_transition", new String[] {
                "oldmode", s, "newmode", "map"
            });
        }
        catch (Exception exception)
        {
            Ln.e(exception);
        }
        previousFullMapMode = true;
        return;
    }

    private void getCarouselCategories(double d)
    {
        ((CategoryService)categoryService.get()).getNearbyDealCategories(getActivity(), channel, searchLocation, d, new Function1() {

            final NearbyDealsFragment this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                boolean flag = true;
                setCategoryCarouselVisible(true);
                nearbyCategories = categoriesUtil.getNearbyCategories(list);
                getArguments().putParcelableArrayList("categories_list", (ArrayList)nearbyCategories);
                if (nearbyCategories.size() < 2)
                {
                    flag = false;
                }
                if (isGTGOnNearby)
                {
                    list = new GtgMockCategory();
                    list.friendlyName = getString(0x7f08012f);
                    list.friendlyNameShort = getString(0x7f08012f);
                    list.imageResId = 0x7f020256;
                    list.relevanceContext = "mobile_local";
                    list.isSubcategory = false;
                    String s;
                    int i;
                    if (isGTGNewFlagDivision)
                    {
                        i = 0;
                    } else
                    {
                        i = 8;
                    }
                    list.visibility = i;
                    nearbyCategories.add(0, list);
                }
                if (isSnapNearbyCarouselCategoryEnabled)
                {
                    list = new Category();
                    s = getString(0x7f0804e1);
                    list.id = NearbyDealsFragment.SNAP_GROCERY_ID;
                    list.friendlyName = s;
                    list.friendlyNameShort = s;
                    list.name = s;
                    list.isSubcategory = false;
                    list.imageResId = 0x7f0201e9;
                    nearbyCategories.add(list);
                }
                if (flag)
                {
                    list = new GoodsCategoriesAdapter(getActivity(), nearbyCategories);
                    list.setOnItemClickListener(new OnNearbyCategoryItemClickListener());
                    categoriesList.setAdapter(list);
                    categoriesContainer.getLayoutParams().height = (int)getResources().getDimension(0x7f0b0148);
                    return;
                } else
                {
                    categoriesContainer.getLayoutParams().height = -2;
                    return;
                }
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
    }

    private String getCategoryModeKey()
    {
        return (new StringBuilder()).append(Channel.NEARBY.name()).append("categoryMode").toString();
    }

    private Place getPlaceForMap()
    {
        return locationAutocompleteServiceWrapper.getCurrentlySelectedPlace();
    }

    private void initMapView()
    {
        if (mapView == null)
        {
            mapView = new DealsMapView(getActivity());
            MapsInitializer.initialize(getActivity());
            mapView.onCreate(bundleForMapView);
            mapView.onResume();
            mapView.setDealClickListener(this);
            if (locationService.isAGpsProviderEnabled())
            {
                mapView.resetCamera();
            } else
            {
                Place place = locationAutocompleteServiceWrapper.getCurrentLocationOrDivisionPlace();
                mapView.moveCameraFitMapRadius(new LatLng(place.lat, place.lng), false);
            }
        }
        if (dealListGlobal != null)
        {
            addDeals(dealListGlobal);
        }
    }

    private void initMode(boolean flag)
    {
        adjustToFullMapMode(flag);
        previousFullMapMode = flag;
        if (flag)
        {
            dealMapSection.setVisibility(0);
            mapControls.setVisibility(0);
            listIcon.setVisibility(0);
            swipeLayout.setVisibility(8);
            return;
        } else
        {
            swipeLayout.setVisibility(0);
            mapIcon.setVisibility(0);
            dealMapSection.setVisibility(8);
            mapControls.setVisibility(8);
            listIcon.setVisibility(8);
            return;
        }
    }

    private boolean isFullListMode()
    {
        return swipeLayout.getVisibility() == 0;
    }

    private boolean isFullMapMode()
    {
        return swipeLayout.getVisibility() == 8;
    }

    private boolean isPageSelected()
    {
        boolean flag;
        try
        {
            flag = ((GrouponViewPager)activity.getWindow().findViewById(0x7f1000ad)).isSelected(Channel.NEARBY);
        }
        catch (Exception exception)
        {
            Ln.v(exception);
            return false;
        }
        return flag;
    }

    private void leavingFullMapMode()
    {
        adjustToFullMapMode(false);
        Carousel carousel;
        String s1;
        carousel = (Carousel)activity;
        s1 = fragmentKey;
        String s;
        if (previousFullMapMode)
        {
            s = "map";
        } else
        {
            s = "list";
        }
        try
        {
            carousel.redirectTracking(s1, "now_transition", new String[] {
                "oldmode", s, "newmode", "list"
            });
        }
        catch (Exception exception)
        {
            Ln.e(exception);
        }
        previousFullMapMode = false;
        return;
    }

    private void newLocationSearch(String s)
    {
        Intent intent = new Intent("android.intent.action.SEARCH");
        intent.setComponent(new ComponentName(activity, com/groupon/activity/Carousel));
        intent.putExtra("query", s);
        startActivity(intent);
    }

    private void setCategoryCarouselVisible(boolean flag)
    {
        if (categoriesList != null)
        {
            RecyclerView recyclerview = categoriesList;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            recyclerview.setVisibility(i);
        }
    }

    private void setupClicks()
    {
        mapIcon.setOnClickListener(new android.view.View.OnClickListener() {

            final NearbyDealsFragment this$0;

            public void onClick(View view)
            {
                loggingUtils.logClick("", "map_list_view_click", "nearby_tab", "{Page:Map}\u200B");
                switchToMap();
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
        listIcon.setOnClickListener(new android.view.View.OnClickListener() {

            final NearbyDealsFragment this$0;

            public void onClick(View view)
            {
                loggingUtils.logClick("", "map_list_view_click", "nearby_tab", "{Page:Deals_list}\u200B");
                switchToList();
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
        categoryFilter.setOnClickListener(new android.view.View.OnClickListener() {

            final NearbyDealsFragment this$0;

            public void onClick(View view)
            {
                initiateCategoriesPickerPopupWindow(categoryFilter);
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
        locationFilter.setOnClickListener(new android.view.View.OnClickListener() {

            final NearbyDealsFragment this$0;

            public void onClick(View view)
            {
                initiateLocationPickerPopupWindow(locationFilter);
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
        reloadButton.setOnClickListener(new android.view.View.OnClickListener() {

            final NearbyDealsFragment this$0;

            public void onClick(View view)
            {
                loggingUtils.logClick("", "redo_search_area_click", "nearby_tab", "map");
                reloadButton.startSpinning();
                refresh(ReloadReason.userInitiated);
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
    }

    private void switchToList()
    {
        if (isSingleNearbyCategorySelector)
        {
            filtersBar.setVisibility(8);
        }
        leavingFullMapMode();
        swipeLayout.setVisibility(0);
        dealMapSection.setVisibility(8);
        mapControls.setVisibility(8);
        transitionComplete(false);
    }

    private void switchToMap()
    {
        if (isSingleNearbyCategorySelector)
        {
            filtersBar.setVisibility(0);
        }
        dealMapSection.setVisibility(0);
        mapControls.setVisibility(0);
        swipeLayout.setVisibility(8);
        swipeLayout.clearAnimation();
        swipeLayout.setRefreshing(false);
        enteringFullMapMode();
        transitionComplete(true);
    }

    private void transitionComplete(boolean flag)
    {
        boolean flag1 = false;
        int i;
        if (mapIcon != null)
        {
            RelativeLayout relativelayout = mapIcon;
            if (flag)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            relativelayout.setVisibility(i);
        }
        if (listIcon != null)
        {
            relativelayout = listIcon;
            if (flag)
            {
                i = ((flag1) ? 1 : 0);
            } else
            {
                i = 8;
            }
            relativelayout.setVisibility(i);
        }
    }

    private void updateFiltersBarForCategoryCarousel()
    {
        locationFilter.setVisibility(8);
        categoryFilter.setVisibility(8);
        nearbyMapRefreshButton.setVisibility(8);
        iconContainer.getLayoutParams().width = -1;
        iconContainer.getLayoutParams().height = -2;
        mapIcon.getLayoutParams().width = -1;
        listIcon.getLayoutParams().width = -1;
        mapIconText.setTypeface(null, 0);
        mapIconText.setVisibility(0);
        listIconText.setTypeface(null, 0);
        listIconText.setVisibility(0);
    }

    protected void afterOnLoadFinished(List list)
    {
        swipeLayout.setRefreshing(false);
        if (list == null || list.size() <= 0) goto _L2; else goto _L1
_L1:
        dealListGlobal = list;
        dealListView.setVisibility(0);
_L4:
        if (isFullMapMode() && mapView != null)
        {
            nearbyMapRefreshButton.stopSpinning();
            reloadButton.stopSpinning();
            if (locationServicesEnabled)
            {
                reloadButton.setVisibility(8);
            }
            initMapView();
            adjustToFullMapMode(true);
        }
        return;
_L2:
        if (filterCategory.getCategoryName() != null && filterCategory.getCategoryName().equals(ALL_DEALS) && (list == null || list.isEmpty()))
        {
            dealListView.setVisibility(8);
            noDealsMessageView.setVisibility(0);
        } else
        if (!Strings.equals(filterCategory.getDisplayText(activity), SELECT_CATEGORY))
        {
            changeCategory(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void changeCategory(boolean flag)
    {
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        filterCategory = new FilterCategory(ALL_DEALS, null);
        logger.logClick("", "category_click", Channel.NEARBY.toString(), ALL_DEALS);
        updateCategoriesButtonText();
        reload(ReloadReason.filterModified);
        return;
        Exception exception;
        exception;
        Ln.d(exception);
        return;
    }

    public View createHeaderView()
    {
        if (isCarouselNearbyCategorySelector)
        {
            updateFiltersBarForCategoryCarousel();
            ArrayList arraylist = new ArrayList();
            categoriesContainer = LayoutInflater.from(getActivity()).inflate(0x7f030114, getListView(), false);
            categoriesList = (RecyclerView)categoriesContainer.findViewById(0x7f100328);
            Object obj = arraylist;
            if (nearbyCategories != null)
            {
                obj = arraylist;
                if (!nearbyCategories.isEmpty())
                {
                    obj = nearbyCategories;
                }
            }
            categoriesList.setAdapter(new GoodsCategoriesAdapter(getActivity(), ((List) (obj))));
            categoriesList.addItemDecoration(new GoodsCategoryDecoration(getActivity()));
            categoriesList.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
            categoriesList.setOnScrollListener(new OnRecyclerScrollListener());
            categoriesList.addOnItemTouchListener(new OnRecyclerItemTouchListener((Carousel)activity));
            return categoriesContainer;
        } else
        {
            return null;
        }
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
        if (!flag && isAdded())
        {
            nearbyMapRefreshButton.stopSpinning();
            reloadButton.stopSpinning();
            reloadButton.setVisibility(8);
            swipeLayout.setRefreshing(false);
            dealCardEndlessAdapter.enableAppending(true);
        }
    }

    public void forceReload()
    {
    }

    protected void getCategories(double d)
    {
        ((CategoryService)categoryService.get()).getNearbyDealCategories(getActivity(), channel, searchLocation, d, new Function1() {

            final NearbyDealsFragment this$0;

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((List)obj);
            }

            public void execute(List list)
            {
                if (!isGTGOnNearby) goto _L2; else goto _L1
_L1:
                int j;
                int k;
                k = list.size();
                j = k;
                if (list.size() <= 0) goto _L4; else goto _L3
_L3:
                int i = 0;
_L9:
                j = k;
                if (i >= list.size()) goto _L4; else goto _L5
_L5:
                if (!Strings.equalsIgnoreCase(((Category)list.get(i)).id, "food-and-drink")) goto _L7; else goto _L6
_L6:
                j = i + 1;
_L4:
                list.add(j, new GtgMockCategory());
_L2:
                if (isSnapNearbyCategoryEnabled)
                {
                    Category category = new Category();
                    category.id = NearbyDealsFragment.SNAP_GROCERY_ID;
                    category.isAllDeals = false;
                    category.name = getString(0x7f0804e1);
                    list.add(category);
                }
                categoriesAdapter.setCategories(list);
                reloadIfNewCategoriesMissingCurrent(list, filterCategory.getCategoryId());
                (new Handler()).post(new Runnable() {

                    final _cls18 this$1;

                    public void run()
                    {
                        if (categoriesAdapter != null)
                        {
                            categoriesAdapter.notifyDataSetChanged();
                        }
                    }

            
            {
                this$1 = _cls18.this;
                super();
            }
                });
                return;
_L7:
                i++;
                if (true) goto _L9; else goto _L8
_L8:
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
    }

    protected LocationIndexerAdapter getLocationIndexerAdapter(List list)
    {
        Object obj = list;
        if (list == null)
        {
            obj = new ArrayList();
        }
        return new LocationIndexerAdapter(activity, 0x7f030155, ((List) (obj))) {

            final NearbyDealsFragment this$0;

            public View getView(int i, View view, ViewGroup viewgroup)
            {
                Place place = (Place)originalObjects.get(i);
                if (view == null)
                {
                    view = inflater.inflate(0x7f030155, viewgroup, false);
                }
                view = (TextView)view.findViewById(0x7f100204);
                view.setText(locationAutocompleteServiceWrapper.getLocationDisplayLabel(place));
                view.setOnClickListener(place. new android.view.View.OnClickListener() {

                    final _cls21 this$1;
                    final Place val$suggestion;

                    public void onClick(View view)
                    {
                        locationAutocompleteServiceWrapper.saveRecentLocation(suggestion);
                        popupWindow.dismiss();
                        view.setBackgroundColor(getResources().getColor(0x7f0e00be));
                        autocompleteListView.requestFocus();
                        logger.logClick("", "suggestion_selected", Channel.NEARBY.toString(), suggestion.value);
                        setLocationAndReload(suggestion, ReloadReason.locationSet);
                    }

            
            {
                this$1 = final__pcls21;
                suggestion = Place.this;
                super();
            }
                });
                return view;
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super(context, i, list);
            }
        };
    }

    protected List getPlaces()
    {
        ArrayList arraylist = new ArrayList(1);
        arraylist.add(locationAutocompleteServiceWrapper.getCurrentlySelectedPlace());
        return arraylist;
    }

    public volatile AnyChannelSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    public NearbySyncManager getSyncManager()
    {
        return syncManager;
    }

    public volatile PaginatedSyncManager getSyncManager()
    {
        return getSyncManager();
    }

    protected void initReload(Place place, ReloadReason reloadreason)
    {
        this;
        JVM INSTR monitorenter ;
        reload(reloadreason);
        reloadreason = new LatLng(place.lat, place.lng);
        if (mapView == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        mapView.moveCamera(reloadreason);
_L1:
        Ln.d("mapzoom: set2 %s,%s", new Object[] {
            Double.valueOf(place.lat), Double.valueOf(place.lng)
        });
        updateLocationButtonText();
        updateCategoriesAdapter();
        updateCategoriesCarousel();
        this;
        JVM INSTR monitorexit ;
        return;
        cameraPosition = reloadreason;
          goto _L1
        place;
        throw place;
    }

    protected void initiateCategoriesPickerPopupWindow(View view)
    {
        LinearLayout linearlayout = (LinearLayout)inflater.inflate(0x7f03005e, null);
        autocompleteListView = (ListView)linearlayout.findViewById(0x7f100187);
        ListView listview = autocompleteListView;
        Object obj;
        boolean flag;
        boolean flag1;
        int i;
        int j;
        if (categoriesAdapter == null)
        {
            obj = new CategoriesAdapter(activity);
        } else
        {
            obj = categoriesAdapter;
        }
        listview.setAdapter(((ListAdapter) (obj)));
        if (isGTGOnNearby && isGTGNewFlagDivision)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        j = view.getWidth();
        if (getResources().getConfiguration().orientation == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj = autocompleteListView;
        i = j;
        if (flag)
        {
            i = j;
            if (flag1)
            {
                i = j + j / 4;
            }
        }
        popupWindow = createListPopup(linearlayout, ((ListView) (obj)), i);
        try
        {
            autocompleteListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

                final NearbyDealsFragment this$0;

                public void onItemClick(AdapterView adapterview, View view1, int k, long l)
                {
                    adapterview = autocompleteListView.getAdapter();
                    if (adapterview == null)
                    {
                        return;
                    }
                    Category category = (Category)adapterview.getItem(k);
                    if (isGTGOnNearby && category != null && Strings.equals(category.id, "gtg_mock_category_id"))
                    {
                        adapterview = getString(0x7f08012f);
                        filterCategory = new FilterCategory(adapterview, null);
                        view1.setBackgroundColor(getResources().getColor(0x7f0e00be));
                        popupWindow.dismiss();
                        loggingUtils.logClick("", "gtg_on_nearby_click", Channel.NEARBY.toString(), Logger.NULL_NST_FIELD, JsonEncodedNSTField.NULL_JSON_NST_FIELD);
                        startActivity(((IntentFactory)intentFactory.get()).newGrouponWebViewIntent(gdtService.getGtgEntryUrl(), false, true, true, true, false));
                        return;
                    }
                    if (category == null)
                    {
                        adapterview = ALL_DEALS;
                        filterCategory = new FilterCategory(ALL_DEALS, null);
                    } else
                    {
                        if (category.id.equals(NearbyDealsFragment.SNAP_GROCERY_ID))
                        {
                            adapterview = category.id;
                            logger.logClick("", "category_click", Channel.NEARBY.toString(), adapterview);
                            startActivity(((IntentFactory)intentFactory.get()).newSnapOfferGridIntent((new StringBuilder()).append(Channel.SNAP_GROCERY).append(com/groupon/activity/SnapOfferGridActivity.getSimpleName()).toString(), Channel.SNAP_GROCERY));
                            return;
                        }
                        adapterview = category.id;
                        filterCategory = new FilterCategory(category.name, adapterview);
                    }
                    logger.logClick("", "category_click", Channel.NEARBY.toString(), adapterview);
                    view1.setBackgroundColor(getResources().getColor(0x7f0e00be));
                    updateCategoriesButtonText();
                    popupWindow.dismiss();
                    reload(ReloadReason.filterModified);
                }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
            });
            popupWindow.showAsDropDown(view, 0, (int)getResources().getDimension(0x7f0b01be) * -1);
        }
        // Misplaced declaration of an exception variable
        catch (View view)
        {
            Ln.e(view);
        }
        popupWindow.setOnDismissListener(new android.widget.PopupWindow.OnDismissListener() {

            final NearbyDealsFragment this$0;

            public void onDismiss()
            {
                updateCategoriesButtonText();
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
    }

    protected void initiateLocationPickerPopupWindow(View view)
    {
        LinearLayout linearlayout = (LinearLayout)inflater.inflate(0x7f030156, null);
        autocompleteListView = (ListView)linearlayout.findViewById(0x7f1003e8);
        popupWindow = createListPopup(linearlayout, autocompleteListView, view.getWidth());
        locationAutocompleteServiceWrapper.searchLocation("");
        logger.logClick("", "location_click", Channel.NEARBY.toString(), locationAutocompleteServiceWrapper.getCurrentlySelectedPlace().value);
        locationEditText = (EditText)linearlayout.findViewById(0x7f1003e7);
        locationEditText.setOnKeyListener(new android.view.View.OnKeyListener() {

            final NearbyDealsFragment this$0;

            public boolean onKey(View view1, int i, KeyEvent keyevent)
            {
                if (i != 66) goto _L2; else goto _L1
_L1:
                popupWindow.dismiss();
                view1 = Strings.toString(locationEditText.getText());
                if (!currentCountryManager.getCurrentCountry().isLocationsAutocompleteEnabledCountry()) goto _L4; else goto _L3
_L3:
                setLocationAndReload(locationAutocompleteServiceWrapper.getTopListSearchLocation(), ReloadReason.locationSet);
_L5:
                locationEditText.clearFocus();
                return true;
_L4:
                if (Strings.equalsIgnoreCase(CURRENT_LOCATION, view1))
                {
                    setLocationAndReload(locationAutocompleteServiceWrapper.getCurrentLocationOrDivisionPlace(), ReloadReason.locationSet);
                } else
                if (Strings.notEmpty(view1))
                {
                    newLocationSearch(view1);
                }
                if (true) goto _L5; else goto _L2
_L2:
                return false;
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
        if (currentCountryManager.getCurrentCountry().isLocationsAutocompleteEnabledCountry())
        {
            locationEditText.addTextChangedListener(locationAutocompleteServiceWrapper.getTextWatcher());
        }
        locationEditText.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final NearbyDealsFragment this$0;

            public void onFocusChange(View view1, boolean flag)
            {
                ViewUtils.forceShowKeyboard(getActivity(), flag);
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
        popupWindow.showAsDropDown(view, 0, (int)getResources().getDimension(0x7f0b01be) * -1);
    }

    public boolean isAutocomplete()
    {
        return true;
    }

    public boolean isTextEmpty()
    {
        return Strings.isEmpty(locationEditText.getText());
    }

    public void locationReadyCallback(Location location)
    {
        while (!isAdded() || !Strings.equals(locationFilter.getText().toString(), getResources().getString(0x7f080256))) 
        {
            return;
        }
        String s = locationAutocompleteServiceWrapper.getCurrentLocationOrDivisionPlace().value;
        locationFilter.setText(s);
        if (location != null || myLocation == null)
        {
            if (location != null)
            {
                location = new GeoPoint(location);
            } else
            {
                location = currentDivisionManager.getCurrentDivision().geoPoint;
            }
            setMyLocation(location);
        }
        initReload(locationAutocompleteServiceWrapper.getCurrentlySelectedPlace(), ReloadReason.locationSet);
    }

    public void locationSearchReady(List list)
    {
        autocompleteListView.setAdapter(null);
        autocompleteListView.setAdapter(getLocationIndexerAdapter(list));
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        intentFactory = new Lazy(getActivity()) {

            final NearbyDealsFragment this$0;

            
            {
                this$0 = NearbyDealsFragment.this;
                super(context);
            }
        };
        buyUtil = new Lazy(getActivity()) {

            final NearbyDealsFragment this$0;

            
            {
                this$0 = NearbyDealsFragment.this;
                super(context);
            }
        };
        geoUtils = new Lazy(getActivity()) {

            final NearbyDealsFragment this$0;

            
            {
                this$0 = NearbyDealsFragment.this;
                super(context);
            }
        };
        categoryService = new Lazy(getActivity()) {

            final NearbyDealsFragment this$0;

            
            {
                this$0 = NearbyDealsFragment.this;
                super(context);
            }
        };
        if (bundle != null)
        {
            bundleForMapView = new Bundle(bundle);
            bundleForMapView.remove("place");
        }
        locationAutocompleteServiceWrapper.reinit();
        locationAutocompleteServiceWrapper.setLocationAutocompleteClient(this);
        swipeLayout.setOnRefreshListener(new android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener() {

            final NearbyDealsFragment this$0;

            public void onRefresh()
            {
                refresh(ReloadReason.userInitiated);
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
        fragmentKey = getClass().getSimpleName();
        dealListView.setEmptyView(noDealsMessageView);
        noDealsMessageView.setVisibility(8);
        nearbyMapRefreshButton.setProgress(getResources().getDrawable(0x7f0202bb));
        nearbyMapRefreshButton.setOnClickListener(new android.view.View.OnClickListener() {

            final NearbyDealsFragment this$0;

            public void onClick(View view)
            {
                nearbyMapRefreshButton.startSpinning();
                refresh(ReloadReason.userInitiated);
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                super();
            }
        });
        Intent intent = activity.getIntent();
        boolean flag;
        if (intent != null)
        {
            if (intent.getBooleanExtra("isDeepLinked", false) && (Strings.notEmpty(intent.getStringExtra("category")) || Strings.notEmpty(intent.getStringExtra("interest"))))
            {
                flag = true;
            } else
            {
                flag = false;
            }
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            prefs.edit().putString(getCategoryModeKey(), "").apply();
        }
        initMode(false);
        setupClicks();
        filterCategory = new FilterCategory();
        updateCategoriesButtonText();
        updateLocationButtonText();
        restoreState(bundle);
        if (activity instanceof Carousel)
        {
            scrollToolBarHelper.initToolBar((Carousel)activity, this);
        }
        if (isSingleNearbyCategorySelector)
        {
            locationFilter.setVisibility(8);
            categoryFilter.setVisibility(8);
            browseByCategoryBar.setVisibility(0);
            browseByCategoryBar.setOnClickListener(new OnCategoryBarClickListener());
            browseByCategoryBarFromMap.setOnClickListener(new OnCategoryBarClickListener());
        }
    }

    public void onChange()
    {
        NearbyMapRedoSearchMetadata nearbymapredosearchmetadata = new NearbyMapRedoSearchMetadata("move_map\u200B");
        loggingUtils.logImpression("", "redo_search_area_imp", "nearby_map", "bottom_center", nearbymapredosearchmetadata);
        reloadButton.setVisibility(0);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
        geocoder = new Geocoder(activity, countryUtil.getLocale(currentCountryManager.getCurrentCountry()));
        searchManager = (SearchManager)activity.getSystemService("search");
        isGTGNewFlagDivision = gtgAbTestHelper.isGtgNewFlagDivision();
        isGTGOnNearby = gtgAbTestHelper.isGtgOnNearby();
        isSingleNearbyCategorySelector = categoriesUtil.isSingleNearbyCategorySelectorEnabled();
        isCarouselNearbyCategorySelector = categoriesUtil.isCarouselNearbyCategorySelectorEnabled();
        isSnapNearbyCategoryEnabled = snapAbTestHelper.isSnapEntryPointNearbyEnabled();
        isSnapNearbyCarouselCategoryEnabled = snapAbTestHelper.isSnapNearbyCarouselCategoryEnabled();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        int i;
        if (isSingleNearbyCategorySelector)
        {
            i = 0x7f03017e;
        } else
        {
            i = 0x7f03017d;
        }
        layoutinflater = layoutinflater.inflate(i, viewgroup, false);
        if (isSingleNearbyCategorySelector)
        {
            ((ListView)layoutinflater.findViewById(0x102000a)).addHeaderView((LinearLayout)LayoutInflater.from(getActivity()).inflate(0x7f030179, null));
        }
        ButterKnife.bind(this, layoutinflater);
        return layoutinflater;
    }

    public void onDealClicked(int i, DealSummary dealsummary)
    {
        if (dealsummary == null)
        {
            return;
        }
        boolean flag;
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = dealsummary.optionDimensionsCount(flag, currentCountryManager.getCurrentCountry().isUSACompatible());
        if (((BuyUtils)buyUtil.get()).showOptionsWithImages(dealsummary, activity))
        {
            startActivity(((IntentFactory)intentFactory.get()).newGoodsMultiOptionIntent(dealsummary.remoteId, channel, i));
        } else
        {
            startActivity(((IntentFactory)intentFactory.get()).newDealIntent(dealsummary, channel, null));
        }
        loggingUtils.logClick("", "search_result_click", channel.toString(), dealsummary.remoteId);
    }

    public void onDestroy()
    {
        if (mapView != null)
        {
            mapView.release();
        }
        if (dealListView != null)
        {
            dealListView.setAdapter(new ArrayAdapter(activity, 0));
        }
        super.onDestroy();
    }

    public void onDestroyView()
    {
        if (mapView != null)
        {
            dealMapSection.removeView(mapView);
        }
        ButterKnife.unbind(this);
        super.onDestroyView();
    }

    public void onLowMemory()
    {
        super.onLowMemory();
        if (mapView != null)
        {
            mapView.onLowMemory();
        }
    }

    public void onPause()
    {
        enableMyLocation(false);
        handler.removeCallbacks(refreshTimer);
        if (popupWindow != null && popupWindow.isShowing())
        {
            popupWindow.dismiss();
        }
        super.onPause();
    }

    public void onResume()
    {
        if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity) != 0)
        {
            Toast.makeText(activity, 0x7f080199, 0).show();
            activity.finish();
        }
        super.onResume();
        boolean flag = gtgAbTestHelper.isGtgOnNearby();
        if (isGTGOnNearby != flag)
        {
            isGTGOnNearby = flag;
            updateCategoriesAdapter();
            updateCategoriesCarousel();
        }
        onSelectionChange(((GrouponViewPager)activity.getWindow().findViewById(0x7f1000ad)).isSelected(Channel.NEARBY));
        Place place;
        try
        {
            ((Carousel)activity).redirectTracking(fragmentKey, "LargeCard", new String[0]);
        }
        catch (Exception exception)
        {
            Ln.e(exception);
        }
        place = locationAutocompleteServiceWrapper.getLocationForValue(locationFilter.getText());
        if (place != null && !Strings.equals(place.value, locationAutocompleteServiceWrapper.getLastUsedLocation().value))
        {
            locationAutocompleteServiceWrapper.saveRecentLocation(place);
        }
        updateCategoryFilterAndReloadIfNecessary();
        handler.postDelayed(refreshTimer, 0x36ee80L);
        locationServicesEnabled = locationService.isAGpsProviderEnabled();
        if (isCarouselNearbyCategorySelector)
        {
            updateFiltersBarForCategoryCarousel();
        }
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (mapView != null)
        {
            mapView.onSaveInstanceState(bundle);
            GoogleMap googlemap = mapView.getGoogleMap();
            if (googlemap != null)
            {
                ArrayList arraylist = new ArrayList();
                arraylist.add(Integer.valueOf((int)googlemap.getProjection().getVisibleRegion().nearLeft.latitude));
                arraylist.add(Integer.valueOf((int)googlemap.getProjection().getVisibleRegion().nearLeft.longitude));
                arraylist.add(Integer.valueOf((int)googlemap.getProjection().getVisibleRegion().nearRight.latitude));
                arraylist.add(Integer.valueOf((int)googlemap.getProjection().getVisibleRegion().nearRight.longitude));
                arraylist.add(Integer.valueOf((int)googlemap.getProjection().getVisibleRegion().farLeft.latitude));
                arraylist.add(Integer.valueOf((int)googlemap.getProjection().getVisibleRegion().farLeft.longitude));
                arraylist.add(Integer.valueOf((int)googlemap.getProjection().getVisibleRegion().farRight.latitude));
                arraylist.add(Integer.valueOf((int)googlemap.getProjection().getVisibleRegion().farRight.longitude));
                bundle.putIntegerArrayList("map", arraylist);
            }
        }
        if (filterCategory != null)
        {
            bundle.putAll(filterCategory.getExtras());
        }
        boolean flag;
        if (dealListView == null || isFullListMode())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        bundle.putBoolean("nearbyConfiguration", flag);
        if (locationAutocompleteServiceWrapper.getCurrentlySelectedPlace() != null)
        {
            bundle.putParcelable("place", locationAutocompleteServiceWrapper.getCurrentlySelectedPlace());
        }
    }

    public void onSelectionChange(boolean flag)
    {
        boolean flag2 = true;
        super.onSelectionChange(flag);
        boolean flag1;
        if (!isFullMapMode() || !flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        enableApplicationOverlaysAndSwipes(flag1);
        if (flag && isFullMapMode())
        {
            flag = flag2;
        } else
        {
            flag = false;
        }
        enableMyLocation(flag);
    }

    public void onStop()
    {
        super.onStop();
        searchManager.stopSearch();
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 1: default 28
    //                   0 30
    //                   1 48;
           goto _L1 _L2 _L3
_L1:
        return false;
_L2:
        downEventX = motionevent.getX();
        downEventY = motionevent.getY();
        return false;
_L3:
        if (downEventX != motionevent.getX() || downEventY != motionevent.getY())
        {
            reloadButton.setVisibility(0);
            return false;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    protected void refresh(ReloadReason reloadreason)
    {
        if (isFullMapMode())
        {
            Object obj = mapView.getGoogleMap();
            if (obj != null)
            {
                obj = ((GoogleMap) (obj)).getCameraPosition().target;
                (new GetPlaceByCoordinates(((LatLng) (obj)), reloadreason, ((LatLng) (obj))) {

                    final NearbyDealsFragment this$0;
                    final LatLng val$coordinates;
                    final ReloadReason val$reason;

                    protected void onException(Exception exception)
                        throws RuntimeException
                    {
                        Ln.w(exception, (new StringBuilder()).append("Unable to get city for ").append(coordinates).toString(), new Object[0]);
                        exception = new Place(MAP_LOCATION, MAP_LOCATION, coordinates.latitude, coordinates.longitude);
                        setLocationAndReload(exception, reason);
                    }

                    protected void onSuccess(Place place)
                        throws Exception
                    {
                        setLocationAndReload(place, reason);
                    }

                    protected volatile void onSuccess(Object obj1)
                        throws Exception
                    {
                        onSuccess((Place)obj1);
                    }

            
            {
                this$0 = NearbyDealsFragment.this;
                reason = reloadreason;
                coordinates = latlng1;
                super(final_context, final_locale, latlng);
            }
                }).execute();
            }
            return;
        } else
        {
            reload(reloadreason);
            return;
        }
    }

    public void reload(ReloadReason reloadreason)
    {
        boolean flag1 = false;
        this;
        JVM INSTR monitorenter ;
        boolean flag2;
        if (reloadreason == ReloadReason.userInitiated || reloadreason == ReloadReason.filterModified || reloadreason == ReloadReason.locationSet)
        {
            swipeLayout.setRefreshing(true);
        }
        flag2 = ReloadReason.useMapCenter(reloadreason);
        if (mapView == null || mapView.getGoogleMap() == null) goto _L2; else goto _L1
_L1:
        Object obj = mapView.getGoogleMap().getCameraPosition().target;
_L7:
        Place place;
        boolean flag;
        if (((LatLng) (obj)).latitude == 0.0D && ((LatLng) (obj)).longitude == 0.0D)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag2 || flag) goto _L4; else goto _L3
_L3:
        if (!ReloadReason.isFilterModified(reloadreason)) goto _L5; else goto _L4
_L4:
        place = locationAutocompleteServiceWrapper.getCurrentlySelectedPlace();
        if (place != null) goto _L5; else goto _L6
_L6:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
label0:
        {
            if (cameraPosition == null)
            {
                break label0;
            }
            obj = cameraPosition;
        }
          goto _L7
        obj = new LatLng(0.0D, 0.0D);
          goto _L7
_L5:
        if (!flag2 || flag)
        {
            break MISSING_BLOCK_LABEL_241;
        }
        if (!isFullMapMode())
        {
            break MISSING_BLOCK_LABEL_241;
        }
        obj = new GeoPoint((int)(((LatLng) (obj)).latitude * 1000000D), (int)(((LatLng) (obj)).longitude * 1000000D));
_L8:
        searchLocation = ((GeoPoint) (obj));
        if (searchLocation != null)
        {
            break MISSING_BLOCK_LABEL_252;
        }
        swipeLayout.setRefreshing(false);
        if (dealListView != null)
        {
            dealListView.setEmptyView(noDealsMessageView);
        }
          goto _L6
        reloadreason;
        throw reloadreason;
        obj = locationAutocompleteServiceWrapper.getSelectedLocationOrDivisionGeoPoint();
          goto _L8
        if (mapView == null || ReloadReason.isFilterModified(reloadreason))
        {
            break MISSING_BLOCK_LABEL_290;
        }
        obj = mapView;
        if (!flag2 || flag)
        {
            flag1 = true;
        }
        ((DealsMapView) (obj)).measureMapSpan(flag1);
        if (!ReloadReason.isFilterModified(reloadreason))
        {
            break MISSING_BLOCK_LABEL_425;
        }
        obj = locationAutocompleteServiceWrapper.getCurrentlySelectedPlace().source;
_L9:
        syncManager.setSearchLocation(searchLocation);
        if (reloadreason == ReloadReason.filterModified || reloadreason == ReloadReason.userInitiated || reloadreason == ReloadReason.locationSet || reloadreason == ReloadReason.isDeepLinked)
        {
            if (mapView != null)
            {
                mapView.clearDeals();
                syncManager.setRadius(mapView.getRadius());
            }
            syncManager.setSearchOrigin(((String) (obj)));
            syncManager.setFilterModified(true);
            syncManager.setFilterCategory(filterCategory);
            syncManager.setLocationAutocompleteServiceWrapper(locationAutocompleteServiceWrapper);
            syncManager.requestSync(this, null);
        }
          goto _L6
        obj = reloadreason.searchOrigin;
          goto _L9
    }

    protected void reloadIfNewCategoriesMissingCurrent(List list, String s)
    {
        if (list != null && !Strings.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return;
_L2:
        boolean flag;
        boolean flag1 = false;
        list = list.iterator();
        do
        {
            flag = flag1;
            if (!list.hasNext())
            {
                continue; /* Loop/switch isn't completed */
            }
        } while (!Strings.equals(((Category)list.next()).id, s));
        flag = true;
        if (flag) goto _L1; else goto _L3
_L3:
        filterCategory = new FilterCategory();
        updateCategoriesButtonText();
        refresh(ReloadReason.userInitiated);
        return;
    }

    public void restoreState(Bundle bundle)
    {
        if (bundle != null)
        {
            Object obj = FilterCategory.createFilterCategory(bundle);
            if (obj != null)
            {
                filterCategory = ((FilterCategory) (obj));
            }
            updateCategoriesButtonText();
            obj = (Place)bundle.getParcelable("place");
            if (obj != null)
            {
                locationAutocompleteServiceWrapper.setCurrentlySelectedPlace(((Place) (obj)));
            }
            updateLocationButtonText();
            if (!bundle.getBoolean("nearbyConfiguration"))
            {
                switchToMap();
            }
            if (bundle.containsKey("map"))
            {
                bundle = bundle.getIntegerArrayList("map");
                if (bundle.size() == 8)
                {
                    bundle = LatLngBounds.builder().include(new LatLng(((Integer)bundle.get(0)).intValue(), ((Integer)bundle.get(1)).intValue())).include(new LatLng(((Integer)bundle.get(2)).intValue(), ((Integer)bundle.get(3)).intValue())).include(new LatLng(((Integer)bundle.get(4)).intValue(), ((Integer)bundle.get(5)).intValue())).include(new LatLng(((Integer)bundle.get(6)).intValue(), ((Integer)bundle.get(7)).intValue())).build();
                    if (mapView != null)
                    {
                        mapView.moveCamera(CameraUpdateFactory.newLatLngBounds(bundle, 0), false);
                    }
                }
            }
        }
        setLocationAndReload(locationAutocompleteServiceWrapper.getCurrentlySelectedPlace(), ReloadReason.reload);
    }

    public void searchForLocation(String s)
    {
        this;
        JVM INSTR monitorenter ;
        (new Http(null, s) {

            final NearbyDealsFragment this$0;
            final String val$keyword;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public List call()
                throws Exception
            {
                List list;
                try
                {
                    list = geocoder.getFromLocationName(Strings.toString(keyword), 1);
                }
                catch (IOException ioexception)
                {
                    ((GeoUtils)geoUtils.get()).logGeocodeException(ioexception, getClass().getSimpleName());
                    throw new GrouponException(getString(0x7f080162));
                }
                return list;
            }

            protected void onException(Exception exception)
            {
                setLocationAndReload(null, ReloadReason.locationSet);
                super.onException(exception);
            }

            protected volatile void onSuccess(Object obj)
                throws Exception
            {
                onSuccess((List)obj);
            }

            protected void onSuccess(List list)
                throws Exception
            {
                String s1 = null;
                if (list != null && list.size() > 0)
                {
                    list = (Address)list.get(0);
                    s1 = ((GeoUtils)geoUtils.get()).toString(list);
                    list = new Place(s1, s1, list.getLatitude(), list.getLongitude());
                    locationAutocompleteServiceWrapper.saveRecentLocation(list);
                } else
                {
                    Toast.makeText(activity.getApplicationContext(), getString(0x7f080155), 1).show();
                    list = s1;
                }
                setLocationAndReload(list, ReloadReason.locationSet);
            }

            
            {
                this$0 = NearbyDealsFragment.this;
                keyword = s;
                super(final_context, synchttp);
            }
        }).execute();
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    protected void setLocationAndReload(Place place, ReloadReason reloadreason)
    {
        this;
        JVM INSTR monitorenter ;
        if (place != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        locationAutocompleteServiceWrapper.setCurrentlySelectedPlace(place);
        if (!locationAutocompleteServiceWrapper.isCurrentLocation(place))
        {
            break MISSING_BLOCK_LABEL_53;
        }
        locationFilter.setText(0x7f080256);
        locationAutocompleteServiceWrapper.getMostRecentCurrentLocationAndReload();
          goto _L1
        place;
        throw place;
        initReload(place, reloadreason);
          goto _L1
    }

    public void setMyLocation(GeoPoint geopoint)
    {
        myLocation = geopoint;
        boolean flag;
        if (isPageSelected() && isFullMapMode())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        enableMyLocation(flag);
    }

    public void setUserVisibleHint(boolean flag)
    {
        super.setUserVisibleHint(flag);
        if (!flag)
        {
            enableApplicationOverlaysAndSwipes(true);
        }
        if (flag)
        {
            String s = getClass().getSimpleName();
            logger.logPageView("", s, Logger.NULL_NST_FIELD);
            abTestService.isVariantEnabled("AAonNearbyTab1510", "On");
        }
        if (categoriesUtil != null && isCarouselNearbyCategorySelector && categoriesList != null && categoriesList.getAdapter() != null)
        {
            BaseGoodsCategoryAdapter basegoodscategoryadapter = (BaseGoodsCategoryAdapter)categoriesList.getAdapter();
            OnNearbyCategoryImpressionEventListener onnearbycategoryimpressioneventlistener;
            if (flag)
            {
                onnearbycategoryimpressioneventlistener = new OnNearbyCategoryImpressionEventListener();
            } else
            {
                onnearbycategoryimpressioneventlistener = null;
            }
            basegoodscategoryadapter.setOnImpressionEventListener(onnearbycategoryimpressioneventlistener);
            basegoodscategoryadapter.notifyDataSetChanged();
            if (flag && categoriesList.getAdapter().getItemCount() >= 2)
            {
                doStartCategoryCarouselAnimation();
            }
        }
    }

    protected boolean syncAutomaticallyOnResume()
    {
        return false;
    }

    protected void updateCategoriesAdapter()
    {
        if (searchLocation != null)
        {
            if (categoriesAdapter == null)
            {
                categoriesAdapter = new CategoriesAdapter(activity);
            }
            double d;
            if (mapView == null)
            {
                d = 15D;
            } else
            {
                d = mapView.getRadius();
            }
            getCategories(d);
            return;
        } else
        {
            categoriesAdapter = new CategoriesAdapter(activity);
            return;
        }
    }

    protected void updateCategoriesButtonText()
    {
        categoryFilter.setText(filterCategory.getDisplayText(activity));
    }

    protected void updateCategoriesCarousel()
    {
        if (isCarouselNearbyCategorySelector)
        {
            if (categoriesList.getAdapter() != null && categoriesList.getAdapter().getItemCount() > 2)
            {
                setCategoryCarouselVisible(true);
            }
            double d;
            if (mapView == null)
            {
                d = 15D;
            } else
            {
                d = mapView.getRadius();
            }
            getCarouselCategories(d);
        }
    }

    protected void updateCategoryFilterAndReloadIfNecessary()
    {
        if (Strings.notEmpty(prefs.getString(getCategoryModeKey(), "")))
        {
            filterCategory = categoriesUtil.getCategoriesFilter(Channel.NEARBY.name());
            updateCategoriesButtonText();
            reload(ReloadReason.filterModified);
            prefs.edit().putString(getCategoryModeKey(), "").apply();
        }
    }

    protected void updateLocationButtonText()
    {
        String s;
        if (locationAutocompleteServiceWrapper.getCurrentlySelectedPlace() != null)
        {
            s = locationAutocompleteServiceWrapper.getCurrentlySelectedPlace().value;
        } else
        {
            s = locationAutocompleteServiceWrapper.getCurrentLocationOrDivisionPlace().value;
        }
        locationFilter.setText(s);
    }







/*
    static FilterCategory access$1302(NearbyDealsFragment nearbydealsfragment, FilterCategory filtercategory)
    {
        nearbydealsfragment.filterCategory = filtercategory;
        return filtercategory;
    }

*/



















/*
    static List access$302(NearbyDealsFragment nearbydealsfragment, List list)
    {
        nearbydealsfragment.nearbyCategories = list;
        return list;
    }

*/




}
