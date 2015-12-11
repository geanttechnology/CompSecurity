// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.DecelerateInterpolator;
import com.f2prateek.dart.Dart;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.inject.Injector;
import com.groupon.Channel;
import com.groupon.GrouponApplication;
import com.groupon.RedirectTracking;
import com.groupon.abtest.LocalizedMobileAppAbTestHelper;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.abtest.SearchAbTestHelper;
import com.groupon.abtest.TabOrderAbTestHelper;
import com.groupon.activity.transition.DealListTransitionController;
import com.groupon.adapter.CarouselFragmentPagerAdapter;
import com.groupon.adapter.InAppMessagesAdapter;
import com.groupon.db.models.InAppMessage;
import com.groupon.deeplink.DeepLinkData;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.deeplink.InvalidDeepLinkException;
import com.groupon.dogfood.DogfoodHelper;
import com.groupon.events.CustomPageViewEvent;
import com.groupon.fragment.Coupons;
import com.groupon.fragment.GrouponFragmentInterface;
import com.groupon.fragment.Hotels;
import com.groupon.fragment.LocalizedMobileAppDialog;
import com.groupon.fragment.NearbyDealsFragment;
import com.groupon.goods.shoppingcart.view.ShoppingCartInAppMessageView;
import com.groupon.loader.InAppMessageLoaderCallbacks;
import com.groupon.manager.InAppMessageSyncManager;
import com.groupon.models.StartupContext;
import com.groupon.models.country.Country;
import com.groupon.models.division.Division;
import com.groupon.models.nst.CouponGenericMetadata;
import com.groupon.models.shoppingCart.ShoppingCartResponse;
import com.groupon.provider.KochavaProvider;
import com.groupon.service.DeepLinkManager;
import com.groupon.service.DefaultShoppingCartServiceListenerImpl;
import com.groupon.service.DeviceConfigurationLogger;
import com.groupon.service.InAppMessageService;
import com.groupon.service.PreferenceLogger;
import com.groupon.service.ShoppingCartService;
import com.groupon.service.SoftwareUpdateService;
import com.groupon.service.UserMigrationController;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.service.startup.StartupDirector;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.ActionBarUtil;
import com.groupon.util.CategoriesUtil;
import com.groupon.util.DivisionUtil;
import com.groupon.util.GeoPoint;
import com.groupon.util.GlobalSearchTextHintProvider;
import com.groupon.util.GrouponPointsUtil;
import com.groupon.util.GrouponSafeAsyncTask;
import com.groupon.util.LoggingUtils;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.OnBackPressListener;
import com.groupon.util.OnInterceptTouchEvent;
import com.groupon.util.SmuggleDealManager;
import com.groupon.util.SmuggleUtil;
import com.groupon.util.UserMigrationManager;
import com.groupon.view.GrouponViewPager;
import com.groupon.view.InAppMessagesView;
import com.groupon.view.PagerSlidingTabStrip;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import roboguice.inject.Lazy;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity, IntentFactory, LoggingPageChangeManager

public class Carousel extends GrouponFragmentActivity
    implements CustomPageViewEvent, commonlib.manager.SyncManager.SyncUiCallbacks
{
    private class CartAnimationEndListener extends AnimatorListenerAdapter
    {

        private final float initialVisibility;
        private final boolean shouldShowCartMessages;
        final Carousel this$0;
        private final View view;

        public void onAnimationEnd(Animator animator)
        {
            super.onAnimationEnd(animator);
            animator = view;
            byte byte0;
            if (initialVisibility == 0.0F)
            {
                byte0 = 8;
            } else
            {
                byte0 = 0;
            }
            animator.setVisibility(byte0);
            if (shouldShowCartMessages && view.getVisibility() != 0)
            {
                showShoppingCartInAppMessages();
            }
        }

        public CartAnimationEndListener(View view1, float f, boolean flag)
        {
            this$0 = Carousel.this;
            super();
            view = view1;
            initialVisibility = f;
            shouldShowCartMessages = flag;
        }
    }

    private class CartServiceListener extends DefaultShoppingCartServiceListenerImpl
    {

        final Carousel this$0;

        public void onSuccess(ShoppingCartResponse shoppingcartresponse)
        {
            updateShoppingCartIcon(getSupportActionBar());
        }

        private CartServiceListener()
        {
            this$0 = Carousel.this;
            super();
        }

    }

    private class DisplaySuggestedUpdateRunnable
        implements Runnable
    {

        final Carousel this$0;

        public void run()
        {
            displaySuggestedUpdate();
        }

        private DisplaySuggestedUpdateRunnable()
        {
            this$0 = Carousel.this;
            super();
        }

    }

    private class GetCityNameFromGeoPointAsyncTask extends GrouponSafeAsyncTask
    {

        private final GeoPoint geoPoint;
        final Carousel this$0;

        public volatile Object call()
            throws Exception
        {
            return call();
        }

        public String call()
            throws Exception
        {
            return ((DivisionUtil)divisionUtil.get()).getCityNameFromGeoPoint(geoPoint);
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((String)obj);
        }

        protected void onSuccess(String s)
            throws Exception
        {
            showLocalizedMobileAppDialog(geoPoint, s);
        }

        public GetCityNameFromGeoPointAsyncTask(GeoPoint geopoint)
        {
            this$0 = Carousel.this;
            super();
            geoPoint = geopoint;
        }
    }

    private static class OnPageChangeListenerGroup
        implements android.support.v4.view.ViewPager.OnPageChangeListener
    {

        private ArrayList listeners;

        public void addOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
        {
            listeners.add(onpagechangelistener);
        }

        public void onPageScrollStateChanged(int i)
        {
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((android.support.v4.view.ViewPager.OnPageChangeListener)iterator.next()).onPageScrollStateChanged(i)) { }
        }

        public void onPageScrolled(int i, float f, int j)
        {
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((android.support.v4.view.ViewPager.OnPageChangeListener)iterator.next()).onPageScrolled(i, f, j)) { }
        }

        public void onPageSelected(int i)
        {
            for (Iterator iterator = listeners.iterator(); iterator.hasNext(); ((android.support.v4.view.ViewPager.OnPageChangeListener)iterator.next()).onPageSelected(i)) { }
        }

        public void removeOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
        {
            listeners.remove(onpagechangelistener);
        }

        private OnPageChangeListenerGroup()
        {
            listeners = new ArrayList();
        }

    }

    private class OnShoppingCartIconClick
        implements android.view.View.OnClickListener
    {

        final Carousel this$0;

        public void onClick(View view)
        {
            hideShoppingCartInAppMessagesDrawer();
            hideInAppMessagesDrawer();
        }

        private OnShoppingCartIconClick()
        {
            this$0 = Carousel.this;
            super();
        }

    }

    private class OnShoppingCartMessageClick
        implements android.view.View.OnClickListener
    {

        final Carousel this$0;

        public void onClick(View view)
        {
            hideShoppingCartInAppMessagesDrawer();
            updateShoppingCartIcon(getSupportActionBar());
        }

        private OnShoppingCartMessageClick()
        {
            this$0 = Carousel.this;
            super();
        }

    }

    private class OnShoppingCartMessageInterceptTouchEvent
        implements OnInterceptTouchEvent
    {

        final Carousel this$0;

        public void onInterceptTouchEvent(MotionEvent motionevent)
        {
            hideShoppingCartInAppMessagesDrawer();
            updateShoppingCartIcon(getSupportActionBar());
        }

        private OnShoppingCartMessageInterceptTouchEvent()
        {
            this$0 = Carousel.this;
            super();
        }

    }


    public static final String COMING_FROM_SPLASH = "COMING_FROM_SPLASH";
    public static final String FROM_ONBOARDING = "FROM_ONBOARDING";
    private static final String IN_APP_MESSAGES = "inAppMessages";
    private static final long IN_APP_MESSAGES_ANIMATION_DURATION = 400L;
    private static final long IN_APP_MESSAGE_DRAWER_DELAY = 2000L;
    private static final String NO = "no";
    private static final String PROPERTY_ROTATION = "rotation";
    private static final String PROPERTY_SCALE_X = "scaleX";
    private static final String PROPERTY_SCALE_Y = "scaleY";
    private static final String YES = "yes";
    private AbTestService abTestService;
    private String cachedCountryCode;
    private NewCartAbTestHelper cartAbTestHelper;
    private Lazy categoriesUtil;
    private CurrentCountryManager currentCountryManager;
    private Division currentDivision;
    private CurrentDivisionManager currentDivisionManager;
    private Lazy deepLinkManager;
    private DeepLinkUtil deepLinkUtil;
    private DisplaySuggestedUpdateRunnable displaySuggestedUpdateRunnable;
    private Lazy divisionUtil;
    private DogfoodHelper dogfoodHelper;
    boolean fromOnboarding;
    private boolean goToSplash;
    private GrouponPointsUtil grouponPointsUtil;
    private Handler handler;
    private View inAppMessageIcon;
    private InAppMessageService inAppMessageService;
    InAppMessagesView inAppMessages;
    private int inAppMessagesCount;
    private InAppMessageSyncManager inAppSyncManager;
    private boolean isMaskDivisions1508;
    private boolean isSearchEnabled;
    private boolean isTabOrderCompressed1505;
    private KochavaProvider kochavaProvider;
    private LocalizedMobileAppAbTestHelper localizedMobileAppAbTestHelper;
    private com.groupon.abtest.LocalizedMobileAppAbTestHelper.LocalizedMobileAppVariant localizedMobileVariant;
    private Logger logger;
    private LoggingPageChangeManager loggingPageChangeManager;
    private Lazy loggingUtils;
    private UserMigrationManager migrationManager;
    private ObjectMapperWrapper objectMapper;
    private final android.support.v4.view.ViewPager.OnPageChangeListener onChannelChangeListener = new android.support.v4.view.ViewPager.OnPageChangeListener() {

        final Carousel this$0;

        public void onPageScrollStateChanged(int i)
        {
            if (i == 0)
            {
                Fragment fragment = pager.getCurrentFragment();
                if (fragment instanceof Hotels)
                {
                    ((Hotels)fragment).setUpHotelMap();
                }
            }
        }

        public void onPageScrolled(int i, float f, int j)
        {
        }

        public void onPageSelected(int i)
        {
            updateGlobalSearchTextHint();
            if (((CarouselFragmentPagerAdapter)pager.getAdapter()).getChannel(i) != Channel.FEATURED)
            {
                GrouponApplication.startupContext.shouldLogGrp24 = false;
            }
            showShoppingCartInAppMessages();
        }

            
            {
                this$0 = Carousel.this;
                super();
            }
    };
    private OnPageChangeListenerGroup onPageChangeListeners;
    GrouponViewPager pager;
    private SharedPreferences prefs;
    private RedirectTracking redirectTracking;
    private SearchAbTestHelper searchAbTestHelper;
    ShoppingCartInAppMessageView shoppingCartInAppMessage;
    private ShoppingCartService shoppingCartService;
    private boolean shouldForceRefresh;
    private SmuggleDealManager smuggleDealManager;
    private SmuggleUtil smuggleUtil;
    private StartupDirector startupDirector;
    private TabOrderAbTestHelper tabOrderAbTestHelper;
    private com.groupon.abtest.TabOrderAbTestHelper.TabOrderVariant tabOrderVariant;
    PagerSlidingTabStrip tabs;
    private DealListTransitionController transitionController;

    public Carousel()
    {
        deepLinkManager = new Lazy(this) {

            final Carousel this$0;

            
            {
                this$0 = Carousel.this;
                super(context);
            }
        };
        divisionUtil = new Lazy(this) {

            final Carousel this$0;

            
            {
                this$0 = Carousel.this;
                super(context);
            }
        };
        categoriesUtil = new Lazy(this) {

            final Carousel this$0;

            
            {
                this$0 = Carousel.this;
                super(context);
            }
        };
        loggingUtils = new Lazy(this) {

            final Carousel this$0;

            
            {
                this$0 = Carousel.this;
                super(context);
            }
        };
        onPageChangeListeners = new OnPageChangeListenerGroup();
        displaySuggestedUpdateRunnable = new DisplaySuggestedUpdateRunnable();
    }

    private boolean comingFromSplash(Intent intent)
    {
        return intent.getBooleanExtra("COMING_FROM_SPLASH", false);
    }

    private void configureInAppMessagesIcon(ActionBar actionbar, android.view.View.OnClickListener onclicklistener)
    {
        View view;
label0:
        {
            if (layoutContainsInAppMessagesIcon(actionbar))
            {
                view = actionbar.getCustomView().findViewById(0x7f1003c2);
                if (!inAppMessageService.isInAppMessagesRedesignEnabled())
                {
                    break label0;
                }
                updateShoppingCartIcon(actionbar);
                view.setVisibility(0);
                view.setOnClickListener(onclicklistener);
                ActionBarUtil.updateInAppMessageCounter(actionbar, prefs.getInt("new_in_app_messages", 0));
            }
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onclicklistener);
    }

    private void enableInAppMessagesIcon(ActionBar actionbar, boolean flag)
    {
        if (layoutContainsInAppMessagesIcon(actionbar))
        {
            actionbar = inAppMessageIcon;
            int i;
            if (flag)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            actionbar.setVisibility(i);
            if (!flag && inAppMessages != null)
            {
                inAppMessages.setVisibility(8);
            }
        }
    }

    private Channel getChannelFromIntent(Intent intent)
    {
        intent = intent.getExtras();
        if (intent != null)
        {
            return (Channel)intent.getParcelable("channel");
        } else
        {
            return null;
        }
    }

    private String getCurrentNstChannel()
    {
        return ((CarouselFragmentPagerAdapter)pager.getAdapter()).getChannel(pager.getCurrentItem()).toString();
    }

    private void goToSplash()
    {
        goToSplash = true;
        startActivity(((IntentFactory)intentFactory.get()).redirectToSplash(getIntent()));
        finish();
    }

    private void handleIntent(Intent intent, boolean flag)
    {
        shouldForceRefresh = true;
        Object obj;
        if (intent.getBooleanExtra("isDeepLinked", false))
        {
            Object obj1 = intent.getStringExtra("category");
            obj = intent.getStringExtra("interest");
            if (Strings.notEmpty(obj1) || Strings.notEmpty(obj))
            {
                CategoriesUtil categoriesutil;
                if (Strings.notEmpty(obj))
                {
                    obj = ((String) (obj)).split(Pattern.quote(","));
                } else
                {
                    obj = null;
                }
                if (obj != null && obj.length > 0)
                {
                    obj = obj[0];
                } else
                {
                    obj = "";
                }
                if (Strings.notEmpty(obj))
                {
                    obj = ((String) (obj)).replaceAll(Pattern.quote("-"), " ");
                } else
                if (Strings.notEmpty(obj1))
                {
                    obj = ((String) (obj1)).replaceAll(Pattern.quote("-"), " ");
                } else
                {
                    obj = "";
                }
                categoriesutil = (CategoriesUtil)categoriesUtil.get();
                if (!Strings.notEmpty(obj1))
                {
                    obj1 = "";
                }
                categoriesutil.saveCategoryToPrefs(((String) (obj1)), ((String) (obj)), intent.getStringExtra("facet_group_filters"), intent.getParcelableExtra("channel").toString());
            }
        }
        if ("android.intent.action.SEARCH".equals(intent.getAction()))
        {
            obj = pager.findFragmentByPositionIfAvailable(pager.getCurrentItem());
            if (obj instanceof NearbyDealsFragment)
            {
                ((NearbyDealsFragment)obj).searchForLocation(intent.getStringExtra("query"));
                shouldForceRefresh = false;
            }
        } else
        {
            setChannelFromIntent(intent, flag);
        }
        obj = getChannelFromIntent(intent);
        if (obj == null)
        {
            obj = getDefaultChannel();
        }
        obj1 = smuggleUtil.getDealsToBeSmuggledFromIntent(intent, ((Channel) (obj)));
        if (obj1 != null)
        {
            intent.removeExtra(Channel.channelDealIdsExtraKey(((Channel) (obj)).name()));
            smuggleDealManager.addDealsToBeSmuggled(((List) (obj1)), ((Channel) (obj)).name());
        }
        if (intent.hasExtra("refreshCarousel"))
        {
            shouldForceRefresh = intent.getBooleanExtra("refreshCarousel", shouldForceRefresh);
            intent.removeExtra("refreshCarousel");
        }
        setIntent(intent);
        if (intent.getExtras() != null && intent.getExtras().getBoolean("open_navigation_drawer"))
        {
            openNavDrawer();
        }
    }

    private void hideInAppMessagesDrawer()
    {
        if (inAppMessages != null && inAppMessages.getVisibility() == 0)
        {
            pager.removeOnInterceptTouchEvent();
            hideInAppMessagesIcon(getSupportActionBar());
            ((InAppMessagesAdapter)inAppMessages.getAdapter()).setOnMessageClickedListener(null);
            float f = getResources().getDimension(0x7f0b0172);
            int i = inAppMessages.getVisibility();
            f = -f;
            startInAppMessagesDrawerAnimation(i, 0.0F, f);
        }
    }

    private void hideInAppMessagesIcon(ActionBar actionbar)
    {
        if (layoutContainsInAppMessagesIcon(actionbar) && inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            actionbar = actionbar.getCustomView();
            View view = actionbar.findViewById(0x7f1003c5);
            int i = view.getVisibility();
            float f = view.getY();
            float f1 = actionbar.getHeight();
            startMessagesIndicatorAnimation(view, i, f, f1);
        }
    }

    private void hideShoppingCartInAppMessagesDrawer()
    {
        if (shoppingCartInAppMessage != null && shoppingCartInAppMessage.getVisibility() == 0)
        {
            pager.removeOnInterceptTouchEvent();
            setShoppingCartCardVisible(false);
            float f = getResources().getDimension(0x7f0b0172);
            int i = shoppingCartInAppMessage.getVisibility();
            f = -f;
            startShoppingCartInAppMessagesDrawerAnimation(i, 0.0F, f);
        }
    }

    private void initializeInAppMessages(Bundle bundle)
    {
label0:
        {
            enableInAppMessagesIcon(getSupportActionBar(), false);
            if (inAppMessageService.isInAppMessagesRedesignEnabled())
            {
                android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

                    final Carousel this$0;

                    public void onClick(View view)
                    {
                        if (shoppingCartInAppMessage.getVisibility() == 0)
                        {
                            hideShoppingCartInAppMessagesDrawer();
                        }
                        toggleMessagesDrawer(false);
                        int i = prefs.getInt("new_in_app_messages", 0);
                        int j = inAppMessagesCount;
                        inAppMessageService.logInAppBellIconClick(getCurrentNstChannel(), i, j - i);
                    }

            
            {
                this$0 = Carousel.this;
                super();
            }
                };
                if (currentCountryManager.getCurrentCountry().isUSACompatible() || isSearchEnabled)
                {
                    configureInAppMessagesIcon(getSupportActionBar(), onclicklistener);
                } else
                {
                    addStandaloneInAppMessagesIcon(getSupportActionBar(), onclicklistener);
                }
                if (bundle != null)
                {
                    break label0;
                }
                (new Handler()).postDelayed(new Runnable() {

                    final Carousel this$0;

                    public void run()
                    {
                        initInAppMessageLoader();
                    }

            
            {
                this$0 = Carousel.this;
                super();
            }
                }, 2000L);
            }
            return;
        }
        initInAppMessageLoader();
    }

    private boolean isCouponSearch(Channel channel)
    {
        return channel == Channel.COUPONS;
    }

    private boolean layoutContainsInAppMessagesIcon(ActionBar actionbar)
    {
        if (inAppMessageIcon != null)
        {
            return true;
        }
        boolean flag;
        if (actionbar.getCustomView() != null)
        {
            actionbar = actionbar.getCustomView().findViewById(0x7f1003c1);
        } else
        {
            actionbar = null;
        }
        inAppMessageIcon = actionbar;
        if (inAppMessageIcon != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return flag;
    }

    private void onFirstActivityCreate()
    {
        ((DeviceConfigurationLogger)injector.getInstance(com/groupon/service/DeviceConfigurationLogger)).logDeviceConfiguration();
        ((PreferenceLogger)injector.getInstance(com/groupon/service/PreferenceLogger)).logAppPrefs(true);
    }

    private void recordStartupTimeOnColdStart()
    {
        StartupContext startupcontext = GrouponApplication.startupContext;
        if (startupcontext.isColdStart && startupcontext.startupTime == 0L)
        {
            startupcontext.shouldLogGrp24 = true;
            startupcontext.startupTime = SystemClock.elapsedRealtime();
        }
    }

    private void setChannelFromIntent(Intent intent, boolean flag)
    {
        Object obj;
        CarouselFragmentPagerAdapter carouselfragmentpageradapter;
        boolean flag1;
label0:
        {
            boolean flag2 = false;
            boolean flag3 = intent.getBooleanExtra("isDeepLinked", false);
            carouselfragmentpageradapter = (CarouselFragmentPagerAdapter)pager.getAdapter();
            obj = getChannelFromIntent(intent);
            intent = getDefaultChannel();
            if (!flag3)
            {
                flag1 = flag2;
                if (!flag)
                {
                    break label0;
                }
            }
            flag1 = flag2;
            if (obj != null)
            {
                flag1 = true;
            }
        }
        int i;
        int j;
        if (!flag1)
        {
            obj = intent;
        }
        j = carouselfragmentpageradapter.getChannelPosition(((Channel) (obj)));
        i = j;
        if (j == -2)
        {
            if (!flag1)
            {
                intent = Channel.FEATURED;
            }
            i = carouselfragmentpageradapter.getChannelPosition(intent);
        }
        pager.setCurrentItem(i);
    }

    private void setShoppingCartCardVisible(boolean flag)
    {
        if (shoppingCartInAppMessage == null)
        {
            return;
        }
        View view = getSupportActionBar().getCustomView();
        View view1 = view.findViewById(0x7f10051f);
        int i = view1.getVisibility();
        float f;
        float f1;
        if (flag)
        {
            f = getResources().getDimension(0x7f0b0173);
            f1 = view.getHeight();
            f = (float)view.getHeight() - f;
            view1.setY(f1);
            view1.setVisibility(0);
        } else
        {
            f1 = view1.getY();
            f = view.getHeight();
        }
        startMessagesIndicatorAnimation(view1, i, f1, f);
    }

    private boolean shouldShowSplash()
    {
        int i = GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);
        Uri uri = getIntent().getData();
        return !startupDirector.isFullyReady() || uri != null && deepLinkUtil.isDeepLink(uri.toString()) || i != 0;
    }

    private void showInAppMessagesDrawer()
    {
        if (inAppMessages.getVisibility() != 0)
        {
            if (shoppingCartInAppMessage.getVisibility() == 0)
            {
                shoppingCartService.setCartInAppMessageViewed(false);
                hideShoppingCartInAppMessagesDrawer();
            }
            pager.setOnInterceptTouchEvent(new OnInterceptTouchEvent() {

                final Carousel this$0;

                public void onInterceptTouchEvent(MotionEvent motionevent)
                {
                    hideInAppMessagesDrawer();
                }

            
            {
                this$0 = Carousel.this;
                super();
            }
            });
            showInAppMessagesIcon(getSupportActionBar());
            float f = getResources().getDimension(0x7f0b0172);
            int i = inAppMessages.getVisibility();
            int j = getSupportActionBar().getHeight();
            float f1 = -f + (float)j;
            InAppMessagesAdapter inappmessagesadapter;
            InAppMessage inappmessage;
            if (getToolbar().getY() == 0.0F)
            {
                f = j;
            } else
            {
                f = tabs.getHeight();
            }
            inAppMessages.setY(f1);
            inAppMessages.setVisibility(0);
            inappmessagesadapter = (InAppMessagesAdapter)inAppMessages.getAdapter();
            inappmessage = inappmessagesadapter.getItemAt(inAppMessages.getCurrentItem());
            inappmessagesadapter.setOnMessageClickedListener(new com.groupon.view.InAppMessagesView.OnMessageClickedListener() {

                final Carousel this$0;

                public void onMessageClicked(InAppMessage inappmessage1, int k)
                {
                    if (k != inAppMessages.getCurrentItem())
                    {
                        inAppMessages.setCurrentItem(k, true);
                        return;
                    }
                    if (Strings.notEmpty(inappmessage1.target))
                    {
                        hideInAppMessagesDrawer();
                        String s = deepLinkUtil.normalizeUrl(inappmessage1.target, true);
                        logger.logDeepLinking("", s, Uri.parse(s).getQueryParameter("cid"), inappmessage1.remoteId, "in_app_message", ((DeepLinkManager)deepLinkManager.get()).constructDeepLinkNSTExtraString(s.toString(), getIntent()));
                        try
                        {
                            DeepLinkData deeplinkdata = deepLinkUtil.getDeepLink(s);
                            deeplinkdata.setAttributionId(inappmessage1.remoteId);
                            deeplinkdata.setAttributionType("in_app_message");
                            if (Uri.parse(deeplinkdata.getParam("url")).getPath().startsWith("/points"))
                            {
                                grouponPointsUtil.appendQueryParams(deeplinkdata);
                                grouponPointsUtil.logPointsNotificationClink(getCurrentNstChannel());
                                grouponPointsUtil.logPointsDeepLinking(s, Uri.parse(s).getQueryParameter("cid"), inappmessage1.remoteId);
                            }
                            ((DeepLinkManager)deepLinkManager.get()).followDeepLink(Carousel.this, deeplinkdata);
                        }
                        catch (InvalidDeepLinkException invaliddeeplinkexception) { }
                        s = "yes";
                    } else
                    {
                        s = "no";
                    }
                    inAppMessageService.onStateChanged(inappmessage1, com.groupon.service.InAppMessageService.EventName.CLICKED);
                    inAppMessageService.logInAppMessageClick(getCurrentNstChannel(), inappmessage1.remoteId, s);
                }

            
            {
                this$0 = Carousel.this;
                super();
            }
            });
            logger.logInAppMessage("", inappmessage.message, inappmessage.target, inappmessage.remoteId, Logger.NULL_NST_FIELD);
            inAppMessages.updateCurrentItemViewState(inappmessage.viewed);
            inAppMessages.updateCurrentItemTimeStamp(inappmessage.timestamp);
            startInAppMessagesDrawerAnimation(i, f1, f);
        }
    }

    private void showInAppMessagesIcon(ActionBar actionbar)
    {
        if (layoutContainsInAppMessagesIcon(actionbar) && inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            actionbar = actionbar.getCustomView();
            View view = actionbar.findViewById(0x7f1003c5);
            float f = getResources().getDimension(0x7f0b0173);
            int i = view.getVisibility();
            float f1 = actionbar.getHeight();
            float f2 = actionbar.getHeight();
            view.setY(f1);
            view.setVisibility(0);
            startMessagesIndicatorAnimation(view, i, f1, f2 - f);
        }
    }

    private void showLocalizedMobileAppDialog(GeoPoint geopoint)
    {
        while (isFinishing() || ((DivisionUtil)divisionUtil.get()).getDivisionFrom(geopoint) == null) 
        {
            return;
        }
        if (isMaskDivisions1508)
        {
            (new GetCityNameFromGeoPointAsyncTask(geopoint)).execute();
            return;
        } else
        {
            showLocalizedMobileAppDialog(geopoint, "");
            return;
        }
    }

    private void showLocalizedMobileAppDialog(GeoPoint geopoint, String s)
    {
        try
        {
            LocalizedMobileAppDialog.newInstance(geopoint, s).show(getFragmentManager(), "localized_mobile_country_dialog");
            prefs.edit().remove("locationChangedNeedsToShowDialog").apply();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (GeoPoint geopoint)
        {
            throw new RuntimeException(geopoint);
        }
    }

    private void showShoppingCartInAppMessages()
    {
        Channel channel = ((CarouselFragmentPagerAdapter)pager.getAdapter()).getChannel(pager.getCurrentItem());
        boolean flag = shoppingCartService.getCartInAppMessageViewed();
        if (channel == Channel.GOODS && cartAbTestHelper.isShoppingCartEnabled() && isShoppingCartVisible() && !flag)
        {
            showShoppingCartInAppMessagesDrawer();
        }
    }

    private void showShoppingCartInAppMessagesDrawer()
    {
        if (shoppingCartInAppMessage.getVisibility() != 0)
        {
            shoppingCartInAppMessage.setOnClickListener(new OnShoppingCartMessageClick());
            pager.setOnInterceptTouchEvent(new OnShoppingCartMessageInterceptTouchEvent());
            setShoppingCartCardVisible(true);
            float f = getResources().getDimension(0x7f0b008a);
            int i = shoppingCartInAppMessage.getVisibility();
            int j = getSupportActionBar().getHeight();
            float f1 = -f + (float)j;
            if (getToolbar().getY() == 0.0F)
            {
                f = j;
            } else
            {
                f = tabs.getHeight();
            }
            shoppingCartInAppMessage.setY(f1);
            shoppingCartInAppMessage.setVisibility(0);
            startShoppingCartInAppMessagesDrawerAnimation(i, f1, f);
            shoppingCartService.setCartInAppMessageViewed(true);
        }
    }

    private void startCouponSearch()
    {
        if (inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            hideInAppMessagesDrawer();
        }
        CouponGenericMetadata coupongenericmetadata = new CouponGenericMetadata();
        coupongenericmetadata.pageId = com/groupon/fragment/Coupons.getSimpleName();
        ((LoggingUtils)loggingUtils.get()).logClickWithMetadata("", "search_icon_click", Channel.COUPONS.toString(), coupongenericmetadata);
        startActivity(((IntentFactory)intentFactory.get()).newCouponSearchIntent());
    }

    private void startGlobalSearch(Channel channel)
    {
        logger.logClick("", "search_icon_click", "global_search", channel.toString());
        if (inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            hideInAppMessagesDrawer();
        }
        if (shoppingCartInAppMessage.getVisibility() == 0)
        {
            hideShoppingCartInAppMessagesDrawer();
        }
        startActivity(((IntentFactory)intentFactory.get()).newGlobalSearchIntent(channel));
    }

    private void startHotelSearch(Channel channel)
    {
        logger.logClick("", "search_icon_click", "market_rate", channel.toString());
        if (inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            hideInAppMessagesDrawer();
        }
        startActivity(((IntentFactory)intentFactory.get()).newHotelSearchIntent(channel));
    }

    private void startInAppMessagesButtonShakeAnimation(ActionBar actionbar)
    {
        if (inAppMessageService.isInAppMessagesRedesignEnabled() && layoutContainsInAppMessagesIcon(actionbar))
        {
            actionbar = actionbar.getCustomView().findViewById(0x7f1003c1).findViewById(0x7f1003c3);
            AnimatorSet animatorset = new AnimatorSet();
            animatorset.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(actionbar, "scaleX", new float[] {
                    1.1F
                }).setDuration(50L), ObjectAnimator.ofFloat(actionbar, "scaleY", new float[] {
                    1.1F
                }).setDuration(50L)
            });
            AnimatorSet animatorset1 = new AnimatorSet();
            animatorset1.playTogether(new Animator[] {
                ObjectAnimator.ofFloat(actionbar, "scaleX", new float[] {
                    1.0F
                }).setDuration(50L), ObjectAnimator.ofFloat(actionbar, "scaleY", new float[] {
                    1.0F
                }).setDuration(50L)
            });
            AnimatorSet animatorset2 = new AnimatorSet();
            animatorset2.playSequentially(new Animator[] {
                animatorset, ObjectAnimator.ofFloat(actionbar, "rotation", new float[] {
                    0.0F, -10F
                }).setDuration(50L), ObjectAnimator.ofFloat(actionbar, "rotation", new float[] {
                    -10F, 10F
                }).setDuration(100L), ObjectAnimator.ofFloat(actionbar, "rotation", new float[] {
                    10F, 0.0F
                }).setDuration(50L), animatorset1
            });
            animatorset2.setInterpolator(new DecelerateInterpolator());
            animatorset2.start();
        }
    }

    private void startInAppMessagesDrawerAnimation(float f, float f1, float f2)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(inAppMessages, "y", new float[] {
            f1, f2
        });
        objectanimator.setInterpolator(new DecelerateInterpolator());
        objectanimator.setDuration(400L);
        objectanimator.addListener(new CartAnimationEndListener(inAppMessages, f, true));
        objectanimator.start();
    }

    private void startMessagesIndicatorAnimation(final View messagesIndicator, final float initialVisibility, float f, float f1)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(messagesIndicator, "y", new float[] {
            f, f1
        });
        objectanimator.setInterpolator(new DecelerateInterpolator());
        objectanimator.setDuration(400L);
        objectanimator.addListener(new AnimatorListenerAdapter() {

            final Carousel this$0;
            final float val$initialVisibility;
            final View val$messagesIndicator;

            public void onAnimationEnd(Animator animator)
            {
                super.onAnimationEnd(animator);
                if (initialVisibility == 0.0F)
                {
                    messagesIndicator.setVisibility(8);
                }
            }

            
            {
                this$0 = Carousel.this;
                initialVisibility = f;
                messagesIndicator = view;
                super();
            }
        });
        objectanimator.start();
    }

    private void startSearch()
    {
        Channel channel = ((CarouselFragmentPagerAdapter)pager.getAdapter()).getChannel(pager.getCurrentItem());
        boolean flag;
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && (Channel.GETAWAYS == channel || Channel.HOTELS == channel))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            startHotelSearch(channel);
            return;
        }
        if (isCouponSearch(channel))
        {
            startCouponSearch();
            return;
        } else
        {
            startGlobalSearch(channel);
            return;
        }
    }

    private void startShoppingCartInAppMessagesDrawerAnimation(float f, float f1, float f2)
    {
        ObjectAnimator objectanimator = ObjectAnimator.ofFloat(shoppingCartInAppMessage, "y", new float[] {
            f1, f2
        });
        objectanimator.setInterpolator(new DecelerateInterpolator());
        objectanimator.setDuration(400L);
        objectanimator.addListener(new CartAnimationEndListener(shoppingCartInAppMessage, f, false));
        objectanimator.start();
    }

    private void toggleMessagesDrawer(boolean flag)
    {
label0:
        {
            if (inAppMessages.getAdapter() != null)
            {
                if (!flag)
                {
                    break label0;
                }
                prefs.edit().putBoolean("show_message_box", false).apply();
                startInAppMessagesButtonShakeAnimation(getSupportActionBar());
                showInAppMessagesDrawer();
            }
            return;
        }
        if (inAppMessages.getVisibility() == 0)
        {
            hideInAppMessagesDrawer();
            return;
        } else
        {
            showInAppMessagesDrawer();
            return;
        }
    }

    private void updateGlobalSearchTextHint()
    {
        if (!currentCountryManager.getCurrentCountry().isUSACompatible() && !isSearchEnabled)
        {
            return;
        }
        Object obj = pager.getCurrentFragment();
        String s = null;
        if (obj instanceof GlobalSearchTextHintProvider)
        {
            s = ((GlobalSearchTextHintProvider)obj).getGlobalSearchTextHint();
        }
        obj = s;
        if (s == null)
        {
            obj = ((CarouselFragmentPagerAdapter)pager.getAdapter()).getChannel(pager.getCurrentItem());
            boolean flag;
            if (currentCountryManager.getCurrentCountry().isUSACompatible() && (Channel.GETAWAYS == obj || Channel.HOTELS == obj))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (searchAbTestHelper.isUniversalSearchChannelSelectorEnabled() && Channel.GETAWAYS == obj)
            {
                obj = getString(0x7f080203);
            } else
            if (flag)
            {
                obj = getString(0x7f080225);
            } else
            if (Channel.COUPONS == obj)
            {
                obj = getString(0x7f0800ef);
            } else
            {
                obj = getString(0x7f080203);
            }
        }
        ActionBarUtil.setGlobalSearchButtonWithRedesign(getSupportActionBar(), ((CharSequence) (obj)));
    }

    private void updateShoppingCartIcon(ActionBar actionbar)
    {
        if (shoppingCartService.getCartInAppMessageViewed())
        {
            ActionBarUtil.updateShoppingCartCounter(actionbar, shoppingCartService.getCartItemsCount());
            return;
        } else
        {
            ActionBarUtil.showShoppingCartNewBadge(actionbar);
            return;
        }
    }

    public void addOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        onPageChangeListeners.addOnPageChangeListener(onpagechangelistener);
    }

    public void addStandaloneInAppMessagesIcon(ActionBar actionbar, android.view.View.OnClickListener onclicklistener)
    {
        if (actionbar != null && inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            ActionBarUtil.setCustomView(actionbar, 0x7f030142);
            configureInAppMessagesIcon(actionbar, onclicklistener);
        }
    }

    public void displaySuggestedUpdate()
    {
        if (!migrationManager.build(this).isEnabled())
        {
            ((SoftwareUpdateService)injector.getInstance(com/groupon/service/SoftwareUpdateService)).checkForSoftwareUpdate();
        }
    }

    public void doSetTabSwipingEnabled(boolean flag)
    {
        if (pager != null)
        {
            pager.setPagingEnabled(flag);
        }
    }

    public void enableSyncProgressIndicator(boolean flag)
    {
    }

    protected Channel getDefaultChannel()
    {
        if (isTabOrderCompressed1505)
        {
            return Channel.safeValueOf(tabOrderVariant.getDefaultChannel());
        } else
        {
            return Channel.FEATURED;
        }
    }

    protected int getSelfNavDrawerItem()
    {
        return 0;
    }

    public GrouponViewPager getViewPager()
    {
        return pager;
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        if (currentCountryManager.getCurrentCountry().isUSACompatible() || isSearchEnabled)
        {
            ActionBarUtil.addGlobalSearchButtonWithRedesign(getSupportActionBar(), getString(0x7f080204));
            getSupportActionBar().getCustomView().findViewById(0x7f100303).setOnClickListener(new android.view.View.OnClickListener() {

                final Carousel this$0;

                public void onClick(View view)
                {
                    startSearch();
                }

            
            {
                this$0 = Carousel.this;
                super();
            }
            });
            configureShoppingCartIconWithIndicator(new OnShoppingCartIconClick());
        } else
        {
            ActionBarUtil.addLogo(getSupportActionBar());
        }
        getToolbar().setNavigationIcon(0x7f0201e7);
        getToolbar().setNavigationOnClickListener(new android.view.View.OnClickListener() {

            final Carousel this$0;

            public void onClick(View view)
            {
                logger.logClick("", "hamburger_button_click", "lollipop_toolbar", Logger.NULL_NST_FIELD);
                openNavDrawer();
            }

            
            {
                this$0 = Carousel.this;
                super();
            }
        });
        initializeInAppMessages(bundle);
        updateGlobalSearchTextHint();
    }

    public void initInAppMessageLoader()
    {
        InAppMessagesAdapter inappmessagesadapter = new InAppMessagesAdapter(this);
        inAppMessages.setAdapter(inappmessagesadapter);
        getLoaderManager().initLoader(0, null, new InAppMessageLoaderCallbacks(inappmessagesadapter, inappmessagesadapter) {

            final Carousel this$0;
            final InAppMessagesAdapter val$inAppAdapter;

            private void update(List list, boolean flag)
            {
                Carousel carousel = Carousel.this;
                ActionBar actionbar = getSupportActionBar();
                int i;
                boolean flag1;
                if (!list.isEmpty())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                carousel.enableInAppMessagesIcon(actionbar, flag1);
                i = getUnreadMessages(list);
                prefs.edit().putInt("new_in_app_messages", i).apply();
                ActionBarUtil.updateInAppMessageCounter(getSupportActionBar(), i);
                if (flag)
                {
                    toggleMessagesDrawer(true);
                }
            }

            public void onInAppMessagesLoaded(List list)
            {
                int i = 0;
                if (list != null && !list.isEmpty())
                {
                    inAppMessagesCount = list.size();
                    boolean flag = prefs.getBoolean("show_message_box", false);
                    InAppMessagesView inappmessagesview = inAppMessages;
                    if (!flag)
                    {
                        i = inAppMessages.getCurrentItem();
                    }
                    inappmessagesview.setCurrentItem(i);
                    ((InAppMessagesAdapter)inAppMessages.getAdapter()).setList(list);
                    inAppMessages.setOnPageChangeListener(new android.support.v4.view.ViewPager.OnPageChangeListener() {

                        final _cls7 this$1;

                        public void onPageScrollStateChanged(int i)
                        {
                        }

                        public void onPageScrolled(int i, float f, int j)
                        {
                        }

                        public void onPageSelected(int i)
                        {
                            InAppMessage inappmessage = inAppAdapter.getItemAt(i);
                            inAppMessages.updateCurrentItemTimeStamp(inappmessage.timestamp);
                            logger.logInAppMessage("", inappmessage.message, inappmessage.target, inappmessage.remoteId, Logger.NULL_NST_FIELD);
                            if (!inappmessage.viewed)
                            {
                                inappmessage.viewed = true;
                                inAppMessages.updateCurrentItemViewState(true);
                                inAppMessageService.updateInAppMessage(inappmessage);
                                update(inAppAdapter.getMessages(), false);
                            }
                        }

            
            {
                this$1 = _cls7.this;
                super();
            }
                    });
                    update(list, flag);
                    return;
                } else
                {
                    enableInAppMessagesIcon(getSupportActionBar(), false);
                    return;
                }
            }


            
            {
                this$0 = Carousel.this;
                inAppAdapter = inappmessagesadapter1;
                super(final_context, inappmessagesadapter);
            }
        });
    }

    public void logPageViewEvent()
    {
    }

    public void onActivityReenter(int i, Intent intent)
    {
        super.onActivityReenter(i, intent);
        transitionController.setReentering(true);
    }

    public void onBackPressed()
    {
        Fragment fragment = pager.getCurrentFragment();
        if ((fragment instanceof OnBackPressListener) && ((OnBackPressListener)fragment).onBackPressed())
        {
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    public void onCreate(Bundle bundle)
    {
        boolean flag2 = true;
        boolean flag = false;
        recordStartupTimeOnColdStart();
        long l = SystemClock.elapsedRealtime();
        super.onCreate(bundle);
        if (GrouponApplication.startupContext.isColdStart)
        {
            kochavaProvider.initInstance();
        }
        dogfoodHelper.logStartupInformation();
        Dart.inject(this);
        if (!comingFromSplash(getIntent()) && !fromOnboarding && shouldShowSplash())
        {
            goToSplash();
            return;
        }
        if (prefs.getBoolean("shouldLogUpgrade", false))
        {
            GrouponApplication.startupContext.shouldLogUpgrade = true;
            prefs.edit().putBoolean("shouldLogUpgrade", false).apply();
        }
        cachedCountryCode = currentCountryManager.getCurrentCountry().isoName;
        currentDivision = currentDivisionManager.getCurrentDivision();
        localizedMobileVariant = localizedMobileAppAbTestHelper.getLocalizedMobileVariant();
        isSearchEnabled = searchAbTestHelper.isSearchEnabled();
        tabOrderVariant = tabOrderAbTestHelper.getTabOrderVariant();
        StartupContext startupcontext;
        CarouselFragmentPagerAdapter carouselfragmentpageradapter;
        int i;
        boolean flag1;
        if (tabOrderVariant != null && tabOrderVariant.isDefaultChannelInTabs())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        isTabOrderCompressed1505 = flag1;
        if (abTestService.isVariantEnabled("maskDivisions1508", "on") && currentCountryManager.getCurrentCountry().isLocationsAutocompleteEnabledCountry())
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
        isMaskDivisions1508 = flag1;
        startupcontext = GrouponApplication.startupContext;
        if (startupcontext.isColdStart)
        {
            onFirstActivityCreate();
            startupcontext.isColdStart = false;
        }
        getLoaderManager();
        if (inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            i = 0x7f03005a;
        } else
        {
            i = 0x7f030059;
        }
        setContentView(i);
        if (android.os.Build.VERSION.SDK_INT >= 21)
        {
            transitionController.setExitSharedElementCallback();
        }
        carouselfragmentpageradapter = new CarouselFragmentPagerAdapter(getFragmentManager(), currentCountryManager, tabOrderAbTestHelper, injector);
        pager.setAdapter(carouselfragmentpageradapter);
        loggingPageChangeManager.init(pager);
        addOnPageChangeListener(loggingPageChangeManager);
        addOnPageChangeListener(onChannelChangeListener);
        tabs.setViewPager(pager);
        tabs.setOnPageChangeListener(onPageChangeListeners);
        handleIntent(getIntent(), false);
        migrationManager.restoreState(bundle);
        if (currentCountryManager.getCurrentCountry().isUSACompatible() && cartAbTestHelper.isShoppingCartEnabled())
        {
            shoppingCartService.getCart(0, new CartServiceListener());
        }
        if (inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            i = ((flag) ? 1 : 0);
            if (bundle != null)
            {
                i = bundle.getInt("inAppMessages", 0);
            }
            inAppMessagesCount = i;
        }
        if (startupcontext.shouldLogGrp24)
        {
            logger.logGeneralEvent("startup", "carousel", "onCreate", (int)(SystemClock.elapsedRealtime() - l), Logger.NULL_NST_FIELD);
        }
        pager.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener() {

            final Carousel this$0;

            public void onGlobalLayout()
            {
                tabs.setY(getToolbar().getY() + (float)getToolbar().getHeight());
                getWindow().setBackgroundDrawable(getResources().getDrawable(0x7f0e00e2));
                pager.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            }

            
            {
                this$0 = Carousel.this;
                super();
            }
        });
    }

    protected void onDestroy()
    {
        if (!goToSplash)
        {
            handler.removeCallbacks(displaySuggestedUpdateRunnable);
            loggingPageChangeManager.destroy();
            removeOnPageChangeListener(onChannelChangeListener);
            removeOnPageChangeListener(loggingPageChangeManager);
        }
        super.onDestroy();
    }

    public void onNewIntent(Intent intent)
    {
        recordStartupTimeOnColdStart();
        if (shouldShowSplash())
        {
            goToSplash();
            return;
        } else
        {
            handleIntent(intent, true);
            return;
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x7f10001c)
        {
            String s = ((CarouselFragmentPagerAdapter)pager.getAdapter()).getChannel(pager.getCurrentItem()).name();
            logger.logClick("", "search_icon_click", "global_search", s);
        }
        return menuitem.getItemId() == 0x102002c || super.onOptionsItemSelected(menuitem);
    }

    protected void onPause()
    {
        super.onPause();
        GrouponApplication.startupContext.shouldLogGrp24 = false;
        if (inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            inAppSyncManager.stopAutomaticSyncs();
            inAppMessageService.shutDownExecutor();
        }
        handler.removeCallbacks(displaySuggestedUpdateRunnable);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        if (inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            hideInAppMessagesDrawer();
        }
        if (shoppingCartInAppMessage.getVisibility() == 0)
        {
            hideShoppingCartInAppMessagesDrawer();
        }
        return super.onPrepareOptionsMenu(menu);
    }

    protected void onResume()
    {
        Object obj;
        Fragment fragment;
        super.onResume();
        boolean flag;
        if (!isFinishing() && inAppMessageService.isInAppMessagesRedesignEnabled() && inAppMessages != null)
        {
            inAppMessageService.initExecutor();
            obj = getSupportActionBar();
            boolean flag1;
            if (inAppMessages.getAdapter() != null && inAppMessages.getAdapter().getCount() > 0)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            enableInAppMessagesIcon(((ActionBar) (obj)), flag1);
            inAppSyncManager.startAutomaticSyncs(this, null, 3000L);
        }
        if (getIntent().getBooleanExtra("EXIT", false))
        {
            System.exit(0);
        }
        if (!currentDivisionManager.getCurrentDivision().equals(currentDivision))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!shouldForceRefresh || !Strings.equals(cachedCountryCode, currentCountryManager.getCurrentCountry().isoName) && !Strings.isEmpty(cachedCountryCode) || flag) goto _L2; else goto _L1
_L1:
        fragment = pager.findFragmentByPositionIfAvailable(pager.getCurrentItem());
        if (fragment == null || !fragment.isResumed() && !fragment.isVisible()) goto _L4; else goto _L3
_L3:
        if (!(fragment instanceof NearbyDealsFragment)) goto _L6; else goto _L5
_L5:
        if (getIntent().getBooleanExtra("isDeepLinked", false))
        {
            obj = com.groupon.fragment.NearbyDealsFragment.ReloadReason.isDeepLinked;
        } else
        {
            obj = com.groupon.fragment.NearbyDealsFragment.ReloadReason.reload;
        }
        ((NearbyDealsFragment)fragment).reload(((com.groupon.fragment.NearbyDealsFragment.ReloadReason) (obj)));
_L4:
        shouldForceRefresh = false;
_L2:
        handler.postDelayed(displaySuggestedUpdateRunnable, 3000L);
        fragment = pager.getCurrentFragment();
        if (fragment != null)
        {
            obj = fragment.getClass().getSimpleName();
        } else
        {
            obj = "NoFragment";
        }
        tabs.setPreviousClassName(((String) (obj)));
        if (fragment instanceof Hotels)
        {
            ((Hotels)fragment).setUpHotelMap();
        }
        if (!localizedMobileVariant.isEnabled() || !prefs.getBoolean("locationChangedNeedsToShowDialog", false))
        {
            break MISSING_BLOCK_LABEL_351;
        }
        obj = prefs.getString("locationChangedInfoJson", "");
        showLocalizedMobileAppDialog((GeoPoint)objectMapper.readValue(((String) (obj)), com/groupon/util/GeoPoint));
        return;
_L6:
        if (fragment instanceof GrouponFragmentInterface)
        {
            ((GrouponFragmentInterface)fragment).forceReload();
        }
        if (true) goto _L4; else goto _L7
_L7:
        IOException ioexception;
        ioexception;
        throw new RuntimeException(ioexception);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        migrationManager.saveState(bundle);
        if (inAppMessageService.isInAppMessagesRedesignEnabled())
        {
            bundle.putInt("inAppMessages", inAppMessagesCount);
        }
        setIntent(getIntent().putExtra("channel", ((CarouselFragmentPagerAdapter)pager.getAdapter()).getChannel(pager.getCurrentItem())));
    }

    public transient void redirectTracking(String s, String s1, String as[])
    {
        redirectTracking.track(s, s1, as);
    }

    public void removeOnPageChangeListener(android.support.v4.view.ViewPager.OnPageChangeListener onpagechangelistener)
    {
        onPageChangeListeners.removeOnPageChangeListener(onpagechangelistener);
    }

    static 
    {
        GrouponApplication.startupContext.isColdStart = true;
    }















/*
    static int access$302(Carousel carousel, int i)
    {
        carousel.inAppMessagesCount = i;
        return i;
    }

*/





}
