// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.android.widget.SlidingTabLayout;
import com.ebay.common.Preferences;
import com.ebay.common.UserCache;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.RateThisAppDialogFragment;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.SourceIdentification;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.appspeed.AppSpeedShim;
import com.ebay.mobile.categorybrowser.TopLevelCategoriesFragment;
import com.ebay.mobile.common.view.RecyclerContentAdapter;
import com.ebay.mobile.connection.ucibanner.HomescreenBanner;
import com.ebay.mobile.connection.ucibanner.UciBanner;
import com.ebay.mobile.home.SplashActivity;
import com.ebay.mobile.home.StartFragment;
import com.ebay.mobile.home.channels.ChannelFragment;
import com.ebay.mobile.home.channels.ChannelObserver;
import com.ebay.mobile.home.departments.DepartmentFragmentAdapter;
import com.ebay.mobile.home.departments.DepartmentNameViewHolder;
import com.ebay.mobile.home.departments.DepartmentNamesAdapter;
import com.ebay.mobile.sitespeed.SiteSpeedActivityUtil;
import com.ebay.mobile.util.AdUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.AddressDataManager;
import com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase;
import com.ebay.nautilus.domain.content.dm.UserContextDataManager;
import com.ebay.nautilus.domain.content.dm.UssChannelsDataManager;
import com.ebay.nautilus.domain.data.UnifiedStream.Category;
import com.ebay.nautilus.domain.data.UnifiedStream.Channel;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelsContainer;
import com.ebay.nautilus.domain.data.cos.base.Text;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.experimentation.Treatment;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.net.AsBeaconManager;
import com.ebay.nautilus.kernel.util.NetworkUtil;
import com.ebay.nautilus.kernel.util.NumberUtil;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.server_requests.InstallTracking;
import com.ebay.shared.ui.TaggedFragmentPagerAdapter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity

public class eBay extends BaseActivity
    implements com.ebay.mobile.ErrorDialogFragment.OnDismissMessageListener, com.ebay.mobile.home.StartFragment.StartChannelHost, ChannelObserver, com.ebay.nautilus.domain.content.dm.UserContextDataManager.Observer, com.ebay.nautilus.domain.content.dm.UssChannelsDataManager.Observer
{
    static final class ChannelOnPageChangeListener extends android.support.v4.view.ViewPager.SimpleOnPageChangeListener
    {

        private final WeakReference activityReference;
        private int currentPosition;

        public void onPageSelected(int i)
        {
            eBay ebay = (eBay)activityReference.get();
            if (ebay != null) goto _L2; else goto _L1
_L1:
            return;
_L2:
            Object obj1;
            Object obj2;
            obj2 = null;
            Channel channel = ebay.getChannel(new int[] {
                i
            });
            if (channel != null)
            {
                ebay.overrideChannel = ChannelEnum.valueOf(channel.name);
                MyApp.getPrefs().setLastHomeChannel(ebay.overrideChannel.ordinal());
                obj2 = channel.name;
            }
            obj1 = null;
            channel = ebay.getChannel(new int[] {
                currentPosition
            });
            if (channel != null)
            {
                obj1 = channel.name;
            }
            if (!"SHOP".equals(obj1)) goto _L4; else goto _L3
_L3:
            Object obj;
            Object obj3 = (ViewPager)ebay.findViewById(0x7f1002e6);
            obj = obj1;
            if (obj3 != null)
            {
                obj3 = ebay.getChannel(new int[] {
                    currentPosition, ((ViewPager) (obj3)).getCurrentItem()
                });
                obj = obj1;
                if (obj3 != null)
                {
                    obj = TrackingData.sanitize(((Channel) (obj3)).getTrackingName());
                }
            }
_L5:
            currentPosition = i;
            if (!TextUtils.isEmpty(((CharSequence) (obj2))))
            {
                obj1 = new TrackingData(ebay.getTrackingEventName(), TrackingType.PAGE_IMPRESSION);
                ((TrackingData) (obj1)).addKeyValuePair("chnl", ((String) (obj2)).toLowerCase(Locale.US), true);
                if ("SHOP".equals(obj2))
                {
                    obj2 = (ViewPager)ebay.findViewById(0x7f1002e6);
                    if (obj2 != null)
                    {
                        obj2 = ebay.getChannel(new int[] {
                            i, ((ViewPager) (obj2)).getCurrentItem()
                        });
                        if (obj2 != null)
                        {
                            ((TrackingData) (obj1)).addKeyValuePair("subchnl", TrackingData.sanitize(((Channel) (obj2)).getTrackingName()), true);
                            obj2 = AdUtil.adsEnabledForShopSubChannel(((Channel) (obj2)).isDepartment, ((Channel) (obj2)).getTrackingName(), ebay.getEbayContext());
                            if (obj2 != null)
                            {
                                ((TrackingData) (obj1)).addExperimentServedTags((Treatment)((Pair) (obj2)).second);
                            }
                        }
                    }
                }
                obj2 = ebay.getIntent();
                if (obj2 != null && ((Intent) (obj2)).hasExtra("com.ebay.mobile.analytics.sid"))
                {
                    ((TrackingData) (obj1)).addSourceIdentification(((Intent) (obj2)));
                } else
                {
                    ((TrackingData) (obj1)).addSourceIdentification(new SourceIdentification("HomePage", "carousel", ((String) (obj))));
                }
                ((TrackingData) (obj1)).send(ebay);
                return;
            }
            if (true) goto _L1; else goto _L4
_L4:
            obj = obj1;
            if (obj1 != null)
            {
                obj = ((String) (obj1)).toLowerCase(Locale.US);
            }
              goto _L5
        }

        protected ChannelOnPageChangeListener(eBay ebay)
        {
            currentPosition = -1;
            activityReference = new WeakReference(ebay);
        }
    }

    static class DeviceConfigurationObserver extends DataSetObserver
    {

        private final WeakReference activityReference;

        public void onChanged()
        {
            super.onChanged();
            eBay ebay = (eBay)activityReference.get();
            if (ebay == null)
            {
                return;
            } else
            {
                DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
                ebay.updateBanner();
                ebay.showFirstRunOverlay(deviceconfiguration);
                return;
            }
        }

        DeviceConfigurationObserver(eBay ebay)
        {
            activityReference = new WeakReference(ebay);
        }
    }

    static class HomeTabPagerAdapter extends TaggedFragmentPagerAdapter
    {

        private final List channels = new ArrayList();

        public int getCount()
        {
            if (channels == null)
            {
                return 0;
            } else
            {
                return channels.size();
            }
        }

        public String getFragmentTag(int i)
        {
            if (channels == null)
            {
                return "";
            } else
            {
                return ((Channel)channels.get(i)).name;
            }
        }

        public Fragment getItem(int i)
        {
            StartFragment startfragment = new StartFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("ChannelIndex", i);
            startfragment.setArguments(bundle);
            return startfragment;
        }

        public CharSequence getPageTitle(int i)
        {
            if (channels == null)
            {
                return null;
            } else
            {
                return ((Channel)channels.get(i)).displayName.content;
            }
        }

        public Object instantiateItem(ViewGroup viewgroup, int i)
        {
            viewgroup = ((ViewGroup) (super.instantiateItem(viewgroup, i)));
            if (viewgroup != null && (viewgroup instanceof StartFragment))
            {
                StartFragment startfragment = (StartFragment)viewgroup;
                if (!((Channel)channels.get(i)).equals(startfragment.getChannel()))
                {
                    startfragment.update();
                }
            }
            return viewgroup;
        }

        public HomeTabPagerAdapter(FragmentManager fragmentmanager, List list)
        {
            super(fragmentmanager);
            if (list != null)
            {
                channels.addAll(list);
            }
        }
    }


    private static final String DEFAULT_CHANNEL = "DefaultChannel";
    private static final String EXTRA_CHANNEL_NAME = "ChannelIndex";
    public static final String EXTRA_INITIAL_VIEW_TYPE = "InitialViewType";
    public static final String EXTRA_RTM_CAMPAIGN_SELECTOR = "rtmCampaignSelector";
    private static final String HOMESCREEN_PREFS = "HomeScreenPreferences";
    public static final String HOME_START_CHANNEL_TAB = "HomeStartChannelTab";
    private static final long NANOSECONDS_IN_TWO_SECOND = 0x77359400L;
    private static final String OVERLAY_VERSION = "OverlayVersion";
    private static boolean is_view_feedback_limited = true;
    private AddressDataManager addressDataManager;
    private List channels;
    private HomescreenBanner currentBanner;
    private DeviceConfigurationObserver dcsObserver;
    private android.view.View.OnClickListener errorClickListener;
    private View errorLayout;
    private boolean hasNewIntent;
    private View homeBanner;
    private int initialCardType;
    private boolean isSignedIn;
    private String listingDraftId;
    private android.support.v4.view.ViewPager.OnPageChangeListener onPageChangeTrackingListener;
    protected ChannelEnum overrideChannel;
    private com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Observer shoppingCartDataHandler;
    private ShoppingCartDataManagerBase shoppingCartDataManager;
    private long splashTimestamp;
    private SlidingTabLayout tabStrip;
    private UserCache userCache;
    private UserContextDataManager userContextDm;
    private UssChannelsDataManager ussChannelsDataManager;
    protected ViewPager viewPager;

    public eBay()
    {
        initialCardType = -1;
        hasNewIntent = false;
        onPageChangeTrackingListener = new ChannelOnPageChangeListener(this);
        errorClickListener = new android.view.View.OnClickListener() {

            final eBay this$0;

            public void onClick(View view)
            {
                if (view.getId() == 0x7f10013f && ussChannelsDataManager != null)
                {
                    DeviceConfiguration.getAsync();
                    ussChannelsDataManager.invalidateAndForceReloadData();
                    errorLayout.setVisibility(8);
                }
            }

            
            {
                this$0 = eBay.this;
                super();
            }
        };
    }

    public static boolean IsViewFeedbackLimited()
    {
        return is_view_feedback_limited;
    }

    public static void Kill(Context context)
    {
        Log.e("eBay", "Kill command");
        restartInternal(context, true);
    }

    public static void Restart(Context context)
    {
        restartInternal(context, false);
    }

    private void handleError(ResultStatus resultstatus)
    {
        Object obj1 = getEbayContext();
        com.ebay.nautilus.kernel.content.ResultStatus.Message message = resultstatus.getFirstMessage();
        Object obj = message.getShortMessage(((EbayContext) (obj1)));
        obj1 = message.getLongMessage(((EbayContext) (obj1)));
        ((TextView)errorLayout.findViewById(0x7f10013d)).setText(((CharSequence) (obj)));
        obj = (TextView)errorLayout.findViewById(0x7f10013e);
        if (TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            ((TextView) (obj)).setVisibility(8);
        } else
        {
            ((TextView) (obj)).setText(((CharSequence) (obj1)));
            ((TextView) (obj)).setVisibility(0);
        }
        if (EbayErrorUtil.userNotLoggedIn(resultstatus.getMessages()) && MyApp.getPrefs().isSignedIn())
        {
            MyApp.signOutForIafTokenFailure(this);
            return;
        }
        if (NetworkUtil.isConnectionError(resultstatus))
        {
            errorLayout.setVisibility(0);
            return;
        } else
        {
            resultstatus.setCanRetry(true);
            EbayErrorHandler.handleResultStatus(this, 0, resultstatus);
            return;
        }
    }

    private static void restartInternal(Context context, boolean flag)
    {
        Intent intent = new Intent(context, com/ebay/mobile/activities/eBay);
        intent.putExtra("kill", flag);
        intent.setFlags(0x4000000);
        context.startActivity(intent);
    }

    private void scrollToTopInCurrentFragment()
    {
        Object obj;
        if (viewPager != null)
        {
            if ((obj = getChannel(new int[] {
    viewPager.getCurrentItem()
})) != null && ((obj = getFragmentManager().findFragmentByTag(((Channel) (obj)).name)) != null && (obj instanceof StartFragment)))
            {
                ((StartFragment)obj).scrollToTop();
                return;
            }
        }
    }

    private void scrollToViewTypeInCurrentFragment(int i)
    {
        Object obj;
        if (viewPager != null)
        {
            if ((obj = getChannel(new int[] {
    viewPager.getCurrentItem()
})) != null && ((obj = getFragmentManager().findFragmentByTag(((Channel) (obj)).name)) != null && (obj instanceof StartFragment)))
            {
                ((StartFragment)obj).scrollToViewType(i);
                return;
            }
        }
    }

    private void showFirstRunOverlay(DeviceConfiguration deviceconfiguration)
    {
        if (System.nanoTime() - splashTimestamp < 0x77359400L)
        {
            Object obj = getIntent();
            String s = ((Intent) (obj)).getAction();
            obj = ((Intent) (obj)).getCategories();
            if (obj != null && "android.intent.action.MAIN".equals(s) && ((Set) (obj)).contains("android.intent.category.LAUNCHER"))
            {
                int i = deviceconfiguration.get(com.ebay.mobile.dcs.Dcs.Verticals.I.overlayVersion);
                deviceconfiguration = getSharedPreferences("HomeScreenPreferences", 0);
                if (i > deviceconfiguration.getInt("OverlayVersion", 0))
                {
                    deviceconfiguration = deviceconfiguration.edit();
                    deviceconfiguration.putInt("OverlayVersion", i);
                    deviceconfiguration.apply();
                    startActivity(new Intent(this, com/ebay/mobile/home/SplashActivity));
                }
            }
        }
    }

    private void updateBanner()
    {
        if (homeBanner == null)
        {
            homeBanner.setVisibility(8);
            return;
        }
        if (currentBanner.shouldShowBanner())
        {
            homeBanner.setVisibility(0);
            android.view.View.OnClickListener onclicklistener = new android.view.View.OnClickListener() {

                final eBay this$0;

                public void onClick(View view)
                {
                    switch (view.getId())
                    {
                    default:
                        return;

                    case 2131755508: 
                        currentBanner.onBannerClick(eBay.this);
                        updateBanner();
                        return;

                    case 2131755509: 
                        currentBanner.onBannerDismiss(eBay.this);
                        break;
                    }
                    updateBanner();
                }

            
            {
                this$0 = eBay.this;
                super();
            }
            };
            homeBanner.setOnClickListener(onclicklistener);
            findViewById(0x7f1001f5).setOnClickListener(onclicklistener);
            ((TextView)findViewById(0x7f1001f6)).setText(currentBanner.getText(getResources()));
            return;
        } else
        {
            homeBanner.setVisibility(8);
            return;
        }
    }

    public transient Channel getChannel(int ai[])
    {
        if (ai == null || ai.length <= 0) goto _L2; else goto _L1
_L1:
        List list;
        int i;
        i = 0;
        list = channels;
_L5:
        List list1;
        int j;
        j = i + 1;
        i = ai[i];
        list1 = list;
        if (list != null)
        {
            list1 = list;
            if (i < list.size())
            {
                list1 = list;
                if (i >= 0)
                {
                    Channel channel = (Channel)list.get(i);
                    if (j >= ai.length)
                    {
                        return channel;
                    }
                    list1 = list;
                    if (channel != null)
                    {
                        list1 = channel.subChannels;
                    }
                }
            }
        }
        if (j < ai.length) goto _L3; else goto _L2
_L2:
        return null;
_L3:
        i = j;
        list = list1;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public int getChannelIndex(ChannelEnum channelenum)
    {
        if (channelenum != null && channels != null && !channels.isEmpty())
        {
            for (int i = 0; i < channels.size(); i++)
            {
                if (TextUtils.equals(((Channel)channels.get(i)).name, channelenum.name()))
                {
                    return i;
                }
            }

        }
        return -1;
    }

    public String getTrackingEventName()
    {
        return "HomePage";
    }

    public void navigateToChannel(ChannelEnum channelenum, boolean flag, boolean flag1)
    {
        NautilusKernel.verifyMain();
        overrideChannel = channelenum;
        if (viewPager == null) goto _L2; else goto _L1
_L1:
        PagerAdapter pageradapter = viewPager.getAdapter();
        if (pageradapter != null) goto _L3; else goto _L2
_L2:
        return;
_L3:
        static class _cls6
        {

            static final int $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[];

            static 
            {
                $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum = new int[ChannelEnum.values().length];
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[ChannelEnum.SHOP.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$nautilus$domain$data$UnifiedStream$ChannelEnum[ChannelEnum.SELL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls6..SwitchMap.com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum[channelenum.ordinal()];
        JVM INSTR tableswitch 1 2: default 60
    //                   1 95
    //                   2 116;
           goto _L4 _L5 _L6
_L4:
        viewPager.setCurrentItem(0, flag);
_L7:
        if (flag1)
        {
            if (initialCardType > -1)
            {
                scrollToViewTypeInCurrentFragment(initialCardType);
                initialCardType = -1;
                return;
            } else
            {
                scrollToTopInCurrentFragment();
                return;
            }
        }
        if (true) goto _L2; else goto _L5
_L5:
        if (pageradapter.getCount() > 1)
        {
            viewPager.setCurrentItem(1, flag);
        }
          goto _L7
_L6:
        int i = pageradapter.getCount();
        if (i > 2)
        {
            viewPager.setCurrentItem(2, flag);
        } else
        if (i > 1)
        {
            viewPager.setCurrentItem(1, flag);
        }
          goto _L7
    }

    public void onBackPressed()
    {
        DrawerLayout drawerlayout = getNavigationDrawer();
        if (drawerlayout == null || !drawerlayout.isDrawerOpen(3))
        {
            FragmentManager fragmentmanager = getFragmentManager();
            if (getChannelIndex(ChannelEnum.SHOP) == viewPager.getCurrentItem())
            {
                Object obj = fragmentmanager.findFragmentByTag(getChannel(new int[] {
                    viewPager.getCurrentItem()
                }).getTrackingName());
                if (obj != null && ((Fragment) (obj)).getView() != null)
                {
                    Object obj1 = (ViewPager)((Fragment) (obj)).getView().findViewById(0x7f1002e6);
                    obj1 = getChannel(new int[] {
                        viewPager.getCurrentItem(), ((ViewPager) (obj1)).getCurrentItem()
                    });
                    if (obj1 != null)
                    {
                        obj = ((Fragment) (obj)).getChildFragmentManager();
                        if (obj != null && !((FragmentManager) (obj)).isDestroyed())
                        {
                            obj1 = ((FragmentManager) (obj)).findFragmentByTag(((Channel) (obj1)).getTrackingName());
                            if (obj1 != null)
                            {
                                obj1 = ((Fragment) (obj1)).getChildFragmentManager();
                                if (((FragmentManager) (obj1)).getBackStackEntryCount() > 0)
                                {
                                    ((FragmentManager) (obj1)).popBackStack();
                                    return;
                                }
                            }
                            if (((FragmentManager) (obj)).getBackStackEntryCount() > 0)
                            {
                                ((FragmentManager) (obj)).popBackStack();
                                return;
                            }
                        }
                    }
                }
            }
            if (fragmentmanager.getBackStackEntryCount() > 0)
            {
                fragmentmanager.popBackStack();
                return;
            }
        }
        super.onBackPressed();
    }

    public void onCategoryExpansion(ChannelFragment channelfragment, float f)
    {
        RecyclerView recyclerview = (RecyclerView)findViewById(0x7f1002e7);
        ViewPager viewpager = (ViewPager)findViewById(0x7f1002e6);
        if (recyclerview != null && viewpager != null)
        {
            int i = channelfragment.getPositionInParent();
            if (i >= 0)
            {
                DepartmentNameViewHolder departmentnameviewholder = (DepartmentNameViewHolder)recyclerview.findViewHolderForAdapterPosition(i);
                if (departmentnameviewholder != null)
                {
                    departmentnameviewholder.arrowView.setRotation(180F * f);
                }
                if (viewpager.getCurrentItem() == channelfragment.getPositionInParent())
                {
                    if (f == 0.0F && !channelfragment.hasScrollOffset())
                    {
                        recyclerview.setVisibility(0);
                    } else
                    if (recyclerview.getVisibility() != 4)
                    {
                        recyclerview.setVisibility(4);
                        return;
                    }
                }
            }
        }
    }

    public void onCategorySelected(final ChannelFragment departmentId, Category category)
    {
        ViewPager viewpager = (ViewPager)findViewById(0x7f1002e6);
        if (viewpager != null && viewpager.getAdapter() != null)
        {
            final int allCategoriesIndex = ((DepartmentFragmentAdapter)viewpager.getAdapter()).getAllCategoriesIndex();
            final long categoryId = NumberUtil.safeParseLong(category.id, -1L);
            departmentId = departmentId.getDepartmentId();
            viewpager.setCurrentItem(allCategoriesIndex, true);
            viewpager.post(new Runnable() {

                final eBay this$0;
                final int val$allCategoriesIndex;
                final long val$categoryId;
                final String val$departmentId;

                public void run()
                {
                    Object obj = getChannel(new int[] {
                        getChannelIndex(ChannelEnum.SHOP)
                    });
                    if (obj != null)
                    {
                        obj = getFragmentManager().findFragmentByTag(((Channel) (obj)).name);
                        if (obj != null)
                        {
                            Channel channel = getChannel(new int[] {
                                getChannelIndex(ChannelEnum.SHOP), allCategoriesIndex
                            });
                            if (channel != null)
                            {
                                obj = ((Fragment) (obj)).getChildFragmentManager().findFragmentByTag(channel.name);
                                if (obj != null && (obj instanceof TopLevelCategoriesFragment))
                                {
                                    SourceIdentification sourceidentification = new SourceIdentification(getTrackingEventName(), "browsecat", TrackingData.sanitize(departmentId));
                                    ((TopLevelCategoriesFragment)obj).navigateTo(categoryId, sourceidentification);
                                }
                            }
                        }
                    }
                }

            
            {
                this$0 = eBay.this;
                allCategoriesIndex = i;
                departmentId = s;
                categoryId = l;
                super();
            }
            });
        }
    }

    public void onChannelsChanged(UssChannelsDataManager usschannelsdatamanager, Content content, EbayCountry ebaycountry)
    {
        if (!isFinishing() && !isDestroyed())
        {
            usschannelsdatamanager = content.getStatus();
            if (usschannelsdatamanager.hasError())
            {
                handleError(usschannelsdatamanager);
                return;
            }
            content = (ChannelsContainer)content.getData();
            if (content != null && ((ChannelsContainer) (content)).channels != null)
            {
                usschannelsdatamanager = ((ChannelsContainer) (content)).channels;
            } else
            {
                usschannelsdatamanager = Collections.emptyList();
            }
            if (channels == null || viewPager.getAdapter() == null || !channels.equals(usschannelsdatamanager))
            {
                channels = usschannelsdatamanager;
                if (viewPager != null)
                {
                    viewPager.setAdapter(new HomeTabPagerAdapter(getFragmentManager(), channels));
                }
                if (overrideChannel == null && channels != null && content != null && ((ChannelsContainer) (content)).landingChannel != null && !TextUtils.isEmpty(((ChannelsContainer) (content)).landingChannel.name))
                {
                    for (int i = 0; i < channels.size(); i++)
                    {
                        if (((ChannelsContainer) (content)).landingChannel.name.equals(((Channel)channels.get(i)).name))
                        {
                            overrideChannel = ChannelEnum.valueOf(((ChannelsContainer) (content)).landingChannel.name);
                        }
                    }

                }
                tabStrip.setViewPager(viewPager);
                if (overrideChannel != null)
                {
                    if (getChannelIndex(overrideChannel) == 0)
                    {
                        onPageChangeTrackingListener.onPageSelected(0);
                    }
                    navigateToChannel(overrideChannel, false, false);
                }
            }
            usschannelsdatamanager = (ViewGroup)tabStrip.getChildAt(0);
            int j;
            final int ii;
            if (usschannelsdatamanager != null)
            {
                j = usschannelsdatamanager.getChildCount();
            } else
            {
                j = 0;
            }
            for (ii = 0; ii < j; ii++)
            {
                usschannelsdatamanager.getChildAt(ii).setOnClickListener(new android.view.View.OnClickListener() {

                    final eBay this$0;
                    final int val$ii;

                    public void onClick(View view)
                    {
                        viewPager.setCurrentItem(ii, false);
                        scrollToTopInCurrentFragment();
                    }

            
            {
                this$0 = eBay.this;
                ii = i;
                super();
            }
                });
            }

            if (!TextUtils.isEmpty(listingDraftId))
            {
                usschannelsdatamanager = getChannel(new int[] {
                    getChannelIndex(ChannelEnum.SELL)
                });
                if (usschannelsdatamanager != null)
                {
                    usschannelsdatamanager = getFragmentManager().findFragmentByTag(((Channel) (usschannelsdatamanager)).name);
                    if (usschannelsdatamanager != null && (usschannelsdatamanager instanceof StartFragment))
                    {
                        ((StartFragment)usschannelsdatamanager).openDraft(listingDraftId);
                        listingDraftId = null;
                        return;
                    }
                }
            }
        }
    }

    public void onContentLoaded(ChannelFragment channelfragment)
    {
        Object obj = (RecyclerView)findViewById(0x7f1002e7);
        if (obj != null)
        {
            obj = (RecyclerContentAdapter)((RecyclerView) (obj)).getAdapter();
            if (obj != null && (obj instanceof DepartmentNamesAdapter))
            {
                ((DepartmentNamesAdapter)obj).setArrowEnabled(channelfragment.getPositionInParent(), channelfragment.hasSubChannels());
            }
        }
    }

    protected void onCreate(Bundle bundle)
    {
        Object obj;
        SiteSpeedActivityUtil.skipCreate(this);
        super.onCreate(bundle);
        setContentView(0x7f0300b9);
        errorLayout = findViewById(0x7f10013c);
        errorLayout.setVisibility(8);
        errorLayout.setBackgroundColor(-1);
        obj = (Button)errorLayout.findViewById(0x7f10013f);
        ((Button) (obj)).setOnClickListener(errorClickListener);
        ((Button) (obj)).setVisibility(0);
        viewPager = (ViewPager)findViewById(0x7f1001f3);
        viewPager.setOffscreenPageLimit(2);
        tabStrip = (SlidingTabLayout)findViewById(0x7f1001f2);
        tabStrip.setDistributeEvenly(true);
        tabStrip.setCustomTabView(0x7f0300ac, 0x7f1001c1);
        tabStrip.setOnPageChangeListener(onPageChangeTrackingListener);
        tabStrip.setCustomTabColorizer(new com.ebay.android.widget.SlidingTabLayout.TabColorizer() {

            private final int indicatorColor;
            final eBay this$0;

            public int getDividerColor(int j)
            {
                return 0;
            }

            public int getIndicatorColor(int j)
            {
                return indicatorColor;
            }

            
            {
                this$0 = eBay.this;
                super();
                indicatorColor = getResources().getColor(0x7f0d00dd);
            }
        });
        tabStrip.setViewPager(viewPager);
        obj = MyApp.getPrefs();
        if (bundle == null) goto _L2; else goto _L1
_L1:
        String s = bundle.getString("ChannelIndex");
        if (!TextUtils.isEmpty(s))
        {
            overrideChannel = ChannelEnum.valueOf(s);
        }
_L4:
        userCache = new UserCache(this);
        isSignedIn = ((Preferences) (obj)).isSignedIn();
        if (bundle == null && isSignedIn)
        {
            userCache.refreshAll();
        }
        homeBanner = findViewById(0x7f1001f4);
        currentBanner = new UciBanner();
        updateBanner();
        if (RateThisAppDialogFragment.shouldShowDialog())
        {
            (new RateThisAppDialogFragment()).show(getFragmentManager(), RateThisAppDialogFragment.FRAGMENT_MANAGER_TAG);
        }
        return;
_L2:
        InstallTracking.testFirstRun(this);
        Intent intent = getIntent();
        if (intent.hasExtra("HomeStartChannelTab"))
        {
            overrideChannel = (ChannelEnum)intent.getSerializableExtra("HomeStartChannelTab");
            initialCardType = intent.getIntExtra("InitialViewType", -1);
            if (ChannelEnum.SELL.equals(overrideChannel))
            {
                listingDraftId = intent.getStringExtra("RedirectDraftId");
            }
        } else
        {
            overrideChannel = null;
            int i = MyApp.getPrefs().getLastHomeChannel();
            ChannelEnum achannelenum[] = ChannelEnum.values();
            if (i < achannelenum.length)
            {
                overrideChannel = achannelenum[i];
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onCurrentCountryChanged(UserContextDataManager usercontextdatamanager, EbayCountry ebaycountry)
    {
        updateBanner();
    }

    public void onCurrentUserChanged(UserContextDataManager usercontextdatamanager, String s, String s1, boolean flag)
    {
        updateBanner();
    }

    public void onDismissMessage(int i, boolean flag)
    {
        if (ussChannelsDataManager != null && flag)
        {
            ussChannelsDataManager.loadData(this);
            return;
        } else
        {
            errorLayout.setVisibility(0);
            return;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        userContextDm = (UserContextDataManager)datamanagercontainer.initialize(UserContextDataManager.KEY, this);
        if (userContextDm.getCurrentCountry() == null)
        {
            EbayCountry ebaycountry = EbayCountryManager.detectCountry();
            userContextDm.setCurrentCountry(ebaycountry);
        }
        ussChannelsDataManager = (UssChannelsDataManager)datamanagercontainer.initialize(UssChannelsDataManager.KEY, this);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        hasNewIntent = true;
    }

    protected void onPause()
    {
        super.onPause();
        DeviceConfiguration.unregisterObserver(dcsObserver);
    }

    public void onResume()
    {
        super.onResume();
        splashTimestamp = System.nanoTime();
        showFirstRunOverlay(DeviceConfiguration.getAsync());
        if (dcsObserver == null)
        {
            dcsObserver = new DeviceConfigurationObserver(this);
        }
        DeviceConfiguration.registerObserver(dcsObserver);
        Preferences preferences = MyApp.getPrefs();
        if (preferences.getCountryAutoDetected())
        {
            EbayCountry ebaycountry = preferences.getCurrentCountry();
            EbayCountry ebaycountry1 = EbayCountryManager.detectCountry();
            if (!ebaycountry1.equals(ebaycountry))
            {
                userContextDm.setCurrentCountry(ebaycountry1);
            }
        }
        preferences.removeUserPref("searchLastKeywords");
        if (TextUtils.isEmpty(listingDraftId)) goto _L2; else goto _L1
_L1:
        Object obj = getChannel(new int[] {
            getChannelIndex(ChannelEnum.SELL)
        });
        if (obj == null) goto _L2; else goto _L3
_L3:
        obj = getFragmentManager().findFragmentByTag(((Channel) (obj)).name);
        if (obj == null || !(obj instanceof StartFragment)) goto _L2; else goto _L4
_L4:
        ((StartFragment)obj).openDraft(listingDraftId);
        listingDraftId = null;
_L6:
        return;
_L2:
        if (hasNewIntent)
        {
            Intent intent = getIntent();
            TrackingData trackingdata;
            if (intent != null && intent.hasExtra("HomeStartChannelTab"))
            {
                ChannelEnum channelenum = (ChannelEnum)intent.getSerializableExtra("HomeStartChannelTab");
                initialCardType = intent.getIntExtra("InitialViewType", -1);
                navigateToChannel(channelenum, false, true);
                if (ChannelEnum.SELL.equals(channelenum))
                {
                    listingDraftId = intent.getStringExtra("RedirectDraftId");
                }
            } else
            {
                scrollToTopInCurrentFragment();
            }
            trackingdata = new TrackingData(getTrackingEventName(), TrackingType.EVENT);
            trackingdata.addSourceIdentification(intent);
            trackingdata.send(this);
            hasNewIntent = false;
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        if (viewPager != null)
        {
            Channel channel = getChannel(new int[] {
                viewPager.getCurrentItem()
            });
            if (channel != null)
            {
                bundle.putString("ChannelIndex", channel.name);
            }
        }
    }

    public void onScrollChanged(ChannelFragment channelfragment, int i, int j)
    {
        boolean flag = false;
        ViewPager viewpager = (ViewPager)findViewById(0x7f1002e6);
        RecyclerView recyclerview = (RecyclerView)findViewById(0x7f1002e7);
        if (recyclerview != null && viewpager.getCurrentItem() == channelfragment.getPositionInParent())
        {
            if (j > 0)
            {
                i = 4;
            } else
            {
                i = 0;
            }
            recyclerview.setVisibility(i);
            if (j > 0)
            {
                flag = true;
            }
            channelfragment.setTitleVisibility(flag);
        }
    }

    protected void onStart()
    {
        AsBeaconManager asbeaconmanager;
        super.onStart();
        asbeaconmanager = (AsBeaconManager)getEbayContext().getExtension(com/ebay/nautilus/kernel/net/AsBeaconManager);
        break MISSING_BLOCK_LABEL_18;
        if (asbeaconmanager != null && asbeaconmanager.currentBeacon() == null)
        {
            AppSpeedShim appspeedshim = (AppSpeedShim)getShim(com/ebay/mobile/appspeed/AppSpeedShim);
            if (appspeedshim != null)
            {
                appspeedshim.init();
                return;
            }
        }
        return;
    }

    public void onUserSignedInStatusChanged(UserContextDataManager usercontextdatamanager, String s, String s1, String s2)
    {
        isSignedIn = MyApp.getPrefs().isSignedIn();
        updateBanner();
    }







}
