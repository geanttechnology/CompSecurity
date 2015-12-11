// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.PopupMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import com.f2prateek.dart.Dart;
import com.groupon.abtest.SearchAbTestHelper;
import com.groupon.activity.IntentFactory;
import com.groupon.dogfood.DogfoodHelper;
import com.groupon.foundations.activity.BaseActionBarActivity;
import com.groupon.models.LocationsContainer;
import com.groupon.models.country.Country;
import com.groupon.models.dealbreakdown.DealBreakdownAddress;
import com.groupon.service.LoginService;
import com.groupon.service.ShippingService;
import com.groupon.service.core.AbTestService;
import com.groupon.service.core.UserManager;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.util:
//            VolatileBillingInfoProvider, Function1, ReturningFunction1

public class GrouponNavigationDrawerActivity extends BaseActionBarActivity
{

    protected static final int NAVDRAWER_ICON_RES_ID[] = {
        0x7f020062, 0x7f02028f, 0x7f02028f, 0x7f020290, 0x7f020141, 0x7f020141, 0x7f02003b, 0x7f020180, 0x7f020180, 0x7f0202e9, 
        0x7f0201b8, 0x7f020146, 0x7f02023c, 0x7f0201e8
    };
    private static final int NAVDRAWER_ITEM_ABOUT_GROUPON = 12;
    private static final int NAVDRAWER_ITEM_ADD_PAYMENT_METHOD = 5;
    public static final int NAVDRAWER_ITEM_BROWSE_DEALS = 0;
    private static final int NAVDRAWER_ITEM_CAT_FOOD_AB = 13;
    private static final int NAVDRAWER_ITEM_CUSTOMER_SUPPORT = 11;
    private static final int NAVDRAWER_ITEM_FAVORITE_DEAL_TYPES = 10;
    private static final int NAVDRAWER_ITEM_GROUPON_BUCKS = 7;
    private static final int NAVDRAWER_ITEM_INCENTIVE_TICKETS_JAPAN = 8;
    private static final int NAVDRAWER_ITEM_INVALID = -1;
    private static final int NAVDRAWER_ITEM_MY_ADDRESS_JAPAN = 6;
    private static final int NAVDRAWER_ITEM_MY_GROUPONS = 1;
    private static final int NAVDRAWER_ITEM_MY_PURCHASES = 2;
    private static final int NAVDRAWER_ITEM_MY_SUBSCRIPTIONS = 3;
    private static final int NAVDRAWER_ITEM_PAYMENT_METHOD = 4;
    private static final int NAVDRAWER_ITEM_SEPARATOR = -2;
    private static final int NAVDRAWER_ITEM_SETTINGS = 9;
    private static final int NAVDRAWER_LAUNCH_DELAY = 250;
    private static final int NAVDRAWER_TITLE_RES_ID[] = {
        0x7f08007d, 0x7f08027e, 0x7f080284, 0x7f080286, 0x7f0802d5, 0x7f08004e, 0x7f08027d, 0x7f08021b, 0x7f080236, 0x7f08036f, 
        0x7f0801b0, 0x7f08011c, 0x7f080040, 0x7f080140
    };
    private static final int POPUP_ITEM_SIGNOUT = 0;
    protected AbTestService abTestService;
    private DealBreakdownAddress address;
    protected CurrentCountryManager currentCountryManager;
    private DogfoodHelper dogfoodHelper;
    ViewGroup drawerItemsListContainer;
    DrawerLayout drawerLayout;
    private boolean drawerWasDragged;
    ImageView expandAccount;
    private Handler handler;
    protected Lazy intentFactory;
    private Logger logger;
    ViewGroup loginPromptView;
    private LoginService loginService;
    int navDrawerIconTint;
    private View navDrawerItemViews[];
    private ArrayList navDrawerItems;
    int navDrawerSelectedIconTint;
    int navDrawerSelectedTextColor;
    int navDrawerTextColor;
    private PopupMenu popupMenu;
    ViewGroup profileContentView;
    TextView profileEmail;
    TextView profileName;
    protected SearchAbTestHelper searchAbTestHelper;
    int selectedBackground;
    private ShippingService shippingService;
    private Lazy userManager;
    private Lazy volatileBillingInfo;

    public GrouponNavigationDrawerActivity()
    {
        intentFactory = new Lazy(this) {

            final GrouponNavigationDrawerActivity this$0;

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                super(context);
            }
        };
        userManager = new Lazy(this) {

            final GrouponNavigationDrawerActivity this$0;

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                super(context);
            }
        };
        volatileBillingInfo = new Lazy(this) {

            final GrouponNavigationDrawerActivity this$0;

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                super(context);
            }
        };
        navDrawerItems = new ArrayList();
        drawerWasDragged = false;
    }

    protected void closeNavDrawer()
    {
        if (drawerLayout != null)
        {
            drawerLayout.closeDrawer(0x800003);
        }
    }

    protected void createNavDrawerItems()
    {
        navDrawerItemViews = new View[navDrawerItems.size()];
        drawerItemsListContainer.removeAllViews();
        int i = 0;
        for (Iterator iterator = navDrawerItems.iterator(); iterator.hasNext();)
        {
            int j = ((Integer)iterator.next()).intValue();
            navDrawerItemViews[i] = makeNavDrawerItem(j, drawerItemsListContainer);
            drawerItemsListContainer.addView(navDrawerItemViews[i]);
            i++;
        }

    }

    protected void formatNavDrawerItem(View view, int i, boolean flag)
    {
        if (i == -2)
        {
            return;
        }
        ImageView imageview = (ImageView)view.findViewById(0x7f100079);
        TextView textview = (TextView)view.findViewById(0x7f10007a);
        if (flag)
        {
            view.setBackgroundColor(selectedBackground);
        } else
        if (i == 7)
        {
            view.setBackground(getResources().getDrawable(0x7f020297));
        } else
        {
            view.setBackground(getResources().getDrawable(0x7f020295));
        }
        if (flag)
        {
            i = navDrawerSelectedTextColor;
        } else
        {
            i = navDrawerTextColor;
        }
        textview.setTextColor(i);
        if (flag)
        {
            i = navDrawerSelectedIconTint;
        } else
        {
            i = navDrawerIconTint;
        }
        imageview.setColorFilter(i);
    }

    protected int getSelfNavDrawerItem()
    {
        return -1;
    }

    protected void goToNavDrawerItem(int i)
    {
        switch (i)
        {
        case 7: // '\007'
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            logger.logClick("", "my_groupons_click", "navigation_drawer", Logger.NULL_NST_FIELD);
            startActivity(((IntentFactory)intentFactory.get()).newMyGrouponsIntent());
            return;

        case 3: // '\003'
            logger.logClick("", "my_subscriptions_click", "navigation_drawer", Logger.NULL_NST_FIELD);
            startActivity(((IntentFactory)intentFactory.get()).newEmailSubscriptionsIntent());
            return;

        case 10: // '\n'
            logger.logClick("", "favorite_deal_types_click", "navigation_drawer", Logger.NULL_NST_FIELD);
            startActivity(((IntentFactory)intentFactory.get()).newFavoriteDealTypesIntent());
            return;

        case 4: // '\004'
        case 5: // '\005'
            logger.logClick("", "payment_methods_click", "navigation_drawer", Logger.NULL_NST_FIELD);
            startActivity(((IntentFactory)intentFactory.get()).newMyCreditCardIntent());
            return;

        case 9: // '\t'
            logger.logClick("", "settings_click", "navigation_drawer", Logger.NULL_NST_FIELD);
            startActivity(((IntentFactory)intentFactory.get()).newSettingsIntent());
            return;

        case 12: // '\f'
            logger.logClick("", "about_groupon_click", "navigation_drawer", Logger.NULL_NST_FIELD);
            startActivity(((IntentFactory)intentFactory.get()).newAboutGrouponIntent());
            return;

        case 6: // '\006'
            if (address == null)
            {
                startActivity(((IntentFactory)intentFactory.get()).newShippingAddressIntent(null));
                return;
            } else
            {
                startActivity(((IntentFactory)intentFactory.get()).newShippingAddressIntent(null, address, true));
                return;
            }

        case 8: // '\b'
            startActivity(((IntentFactory)intentFactory.get()).newIncentiveTicketsIntent(false, null));
            logger.logClick("", "view_incentive_tickets", "incentive_ticket_profile", Logger.NULL_NST_FIELD);
            return;

        case 11: // '\013'
            startActivity(((IntentFactory)intentFactory.get()).newCustomerServiceIntent());
            logger.logClick("", "customer_support_click", "navigation_drawer", Logger.NULL_NST_FIELD);
            return;

        case 13: // '\r'
            startActivity(((IntentFactory)intentFactory.get()).newPreconfigedABTestsIntent());
            return;
        }
    }

    protected boolean isNavDrawerOpen()
    {
        return drawerLayout != null && drawerLayout.isDrawerOpen(0x800003);
    }

    protected boolean isViewVisible(View view)
    {
        return view.getVisibility() == 0;
    }

    protected View makeNavDrawerItem(final int itemId, ViewGroup viewgroup)
    {
        int l = 0;
        int i;
        boolean flag;
        if (getSelfNavDrawerItem() == itemId)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (itemId == -2)
        {
            i = 0x7f030176;
        } else
        if (itemId == 0 || itemId == 1)
        {
            i = 0x7f030175;
        } else
        if (itemId == 7)
        {
            i = 0x7f030174;
        } else
        {
            i = 0x7f030173;
        }
        viewgroup = getLayoutInflater().inflate(i, viewgroup, false);
        if (itemId != -2)
        {
            ImageView imageview = (ImageView)viewgroup.findViewById(0x7f100079);
            TextView textview = (TextView)viewgroup.findViewById(0x7f10007a);
            int j;
            int k;
            if (itemId >= 0 && itemId < NAVDRAWER_ICON_RES_ID.length)
            {
                j = NAVDRAWER_ICON_RES_ID[itemId];
            } else
            {
                j = 0;
            }
            if (itemId >= 0 && itemId < NAVDRAWER_TITLE_RES_ID.length)
            {
                k = NAVDRAWER_TITLE_RES_ID[itemId];
            } else
            {
                k = 0;
            }
            if (imageview != null)
            {
                if (j <= 0)
                {
                    l = 4;
                }
                imageview.setVisibility(l);
                if (j > 0)
                {
                    imageview.setImageResource(j);
                }
            }
            textview.setText(getString(k));
            formatNavDrawerItem(viewgroup, itemId, flag);
            viewgroup.setOnClickListener(new android.view.View.OnClickListener() {

                final GrouponNavigationDrawerActivity this$0;
                final int val$itemId;

                public void onClick(View view)
                {
                    onNavDrawerItemClicked(itemId);
                }

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                itemId = i;
                super();
            }
            });
            if (itemId == 7)
            {
                ((TextView)viewgroup.findViewById(0x7f10044a)).setText(loginService.getFormattedGBucksAmount());
                return viewgroup;
            }
        }
        return viewgroup;
    }

    public void onBackPressed()
    {
        if (isNavDrawerOpen())
        {
            closeNavDrawer();
            return;
        } else
        {
            super.onBackPressed();
            return;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        Dart.inject(this);
        handler = new Handler();
    }

    protected void onDestroy()
    {
        RoboGuice.destroyInjector(this);
        super.onDestroy();
    }

    protected void onNavDrawerItemClicked(final int itemId)
    {
        if (itemId == getSelfNavDrawerItem())
        {
            drawerLayout.closeDrawer(0x800003);
        } else
        if (itemId != 7)
        {
            handler.postDelayed(new Runnable() {

                final GrouponNavigationDrawerActivity this$0;
                final int val$itemId;

                public void run()
                {
                    goToNavDrawerItem(itemId);
                }

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                itemId = i;
                super();
            }
            }, 250L);
            drawerLayout.closeDrawer(0x800003);
            return;
        }
    }

    protected void onNavDrawerSlide(float f)
    {
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        if (drawerLayout == null)
        {
            return;
        } else
        {
            setupNavDrawer();
            return;
        }
    }

    protected void onResume()
    {
        super.onResume();
        if (currentCountryManager.getCurrentCountry().isJapan())
        {
            updateUserLocations();
        }
    }

    public void onSupportContentChanged()
    {
        super.onSupportContentChanged();
        ButterKnife.bind(this);
    }

    public void openNavDrawer()
    {
        drawerLayout.openDrawer(0x800003);
    }

    protected void populateNavDrawer()
    {
        navDrawerItems.clear();
        navDrawerItems.add(Integer.valueOf(0));
        ArrayList arraylist = navDrawerItems;
        byte byte0;
        boolean flag;
        if (currentCountryManager.getCurrentCountry().isSellerOfRecordCountry())
        {
            byte0 = 2;
        } else
        {
            byte0 = 1;
        }
        arraylist.add(Integer.valueOf(byte0));
        if (dogfoodHelper.isDogfood())
        {
            navDrawerItems.add(Integer.valueOf(13));
        }
        navDrawerItems.add(Integer.valueOf(-2));
        flag = currentCountryManager.getCurrentCountry().isRussia();
        if (loginService.isLoggedIn())
        {
            boolean flag1 = ((UserManager)userManager.get()).userHasValidBillingRecord();
            boolean flag2;
            if (((UserManager)userManager.get()).getValidBillingRecordCountAtInitialization() > 0)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            flag2 = ((VolatileBillingInfoProvider)volatileBillingInfo.get()).hasCreditCardDetails();
            if (byte0 != 0 || flag1 || flag2)
            {
                byte0 = 1;
            } else
            {
                byte0 = 0;
            }
            if (!flag)
            {
                ArrayList arraylist1 = navDrawerItems;
                if (byte0 != 0)
                {
                    byte0 = 4;
                } else
                {
                    byte0 = 5;
                }
                arraylist1.add(Integer.valueOf(byte0));
                if (loginService.getGBucksAmount().intValue() > 0)
                {
                    navDrawerItems.add(Integer.valueOf(7));
                }
            }
            if (currentCountryManager.getCurrentCountry().isJapan())
            {
                navDrawerItems.add(Integer.valueOf(6));
                navDrawerItems.add(Integer.valueOf(8));
            }
        } else
        {
            profileContentView.setVisibility(8);
            loginPromptView.setVisibility(0);
            if (!flag)
            {
                navDrawerItems.add(Integer.valueOf(5));
            }
            loginPromptView.setOnClickListener(new android.view.View.OnClickListener() {

                final GrouponNavigationDrawerActivity this$0;

                public void onClick(View view)
                {
                    view = ((IntentFactory)intentFactory.get()).newLoginIntent(GrouponNavigationDrawerActivity.this);
                    if (view != null)
                    {
                        startActivity(view);
                        return;
                    } else
                    {
                        setupProfileViewOnNavDrawer();
                        populateNavDrawer();
                        return;
                    }
                }

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                super();
            }
            });
        }
        if (currentCountryManager.getCurrentCountry().isUSACompatible())
        {
            navDrawerItems.add(Integer.valueOf(10));
        }
        if (!currentCountryManager.getCurrentCountry().isJapan())
        {
            navDrawerItems.add(Integer.valueOf(3));
        }
        navDrawerItems.add(Integer.valueOf(9));
        if (currentCountryManager.getCurrentCountry().isUSACompatible() || currentCountryManager.getCurrentCountry().isEuCompatible())
        {
            navDrawerItems.add(Integer.valueOf(11));
        }
        navDrawerItems.add(Integer.valueOf(12));
        createNavDrawerItems();
    }

    protected void setupNavDrawer()
    {
        if (drawerLayout == null)
        {
            return;
        }
        if (getSelfNavDrawerItem() == -1)
        {
            View view = drawerLayout.findViewById(0x7f10044b);
            if (view != null)
            {
                ((ViewGroup)view.getParent()).removeView(view);
            }
            drawerLayout = null;
            return;
        } else
        {
            android.support.v4.widget.DrawerLayout.DrawerListener drawerlistener = new android.support.v4.widget.DrawerLayout.DrawerListener() {

                final GrouponNavigationDrawerActivity this$0;

                public void onDrawerClosed(View view1)
                {
                    invalidateOptionsMenu();
                }

                public void onDrawerOpened(View view1)
                {
                    invalidateOptionsMenu();
                    if (drawerWasDragged)
                    {
                        logger.logUserInteraction("", "swipe_open", "navigation_drawer", "", Logger.NULL_NST_FIELD);
                    }
                    logger.logPageView("", "navigation_drawer", Logger.NULL_NST_FIELD);
                    if (loginService.isLoggedIn() && isViewVisible(loginPromptView) || !loginService.isLoggedIn() && isViewVisible(profileContentView))
                    {
                        populateNavDrawer();
                        setupProfileViewOnNavDrawer();
                    }
                }

                public void onDrawerSlide(View view1, float f)
                {
                    onNavDrawerSlide(f);
                }

                public void onDrawerStateChanged(int i)
                {
                    invalidateOptionsMenu();
                    if (i == 0)
                    {
                        drawerWasDragged = false;
                    } else
                    if (i == 1)
                    {
                        drawerWasDragged = true;
                        return;
                    }
                }

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                super();
            }
            };
            drawerLayout.setDrawerListener(drawerlistener);
            drawerLayout.setDrawerShadow(0x7f02015e, 0x800003);
            populateNavDrawer();
            setupProfileViewOnNavDrawer();
            return;
        }
    }

    protected void setupProfileViewOnNavDrawer()
    {
        if (loginService.isLoggedIn())
        {
            profileContentView.setVisibility(0);
            loginPromptView.setVisibility(8);
            if (profileEmail != null && profileName != null)
            {
                profileEmail.setText(loginService.getEmail());
                profileName.setText(loginService.getFullName());
            }
            popupMenu = new PopupMenu(this, expandAccount);
            popupMenu.getMenu().add(0, 0, 0, getResources().getString(0x7f08025d));
            popupMenu.setOnMenuItemClickListener(new android.support.v7.widget.PopupMenu.OnMenuItemClickListener() {

                final GrouponNavigationDrawerActivity this$0;

                public boolean onMenuItemClick(MenuItem menuitem)
                {
                    menuitem.getItemId();
                    JVM INSTR tableswitch 0 0: default 24
                //                               0 26;
                       goto _L1 _L2
_L1:
                    return false;
_L2:
                    logger.logClick("", "signout_button_click", "navigation_drawer", Logger.NULL_NST_FIELD);
                    loginService.logout();
                    startActivity(((IntentFactory)intentFactory.get()).newSplashIntent(((IntentFactory)intentFactory.get()).newCarouselIntent()));
                    finish();
                    if (true) goto _L1; else goto _L3
_L3:
                }

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                super();
            }
            });
            popupMenu.setOnDismissListener(new android.support.v7.widget.PopupMenu.OnDismissListener() {

                final GrouponNavigationDrawerActivity this$0;

                public void onDismiss(PopupMenu popupmenu)
                {
                    expandAccount.setImageResource(0x7f020043);
                }

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                super();
            }
            });
            profileContentView.setOnClickListener(new android.view.View.OnClickListener() {

                final GrouponNavigationDrawerActivity this$0;

                public void onClick(View view)
                {
                    popupMenu.show();
                    expandAccount.setImageResource(0x7f020041);
                }

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                super();
            }
            });
        } else
        {
            profileContentView.setVisibility(8);
            loginPromptView.setVisibility(0);
        }
        profileContentView.setEnabled(true);
    }

    protected void updateUserLocations()
    {
        shippingService.getLocations(new Function1() {

            final GrouponNavigationDrawerActivity this$0;

            public void execute(LocationsContainer locationscontainer)
            {
                locationscontainer = locationscontainer.getLocations();
                if (locationscontainer != null && locationscontainer.size() > 0)
                {
                    locationscontainer = locationscontainer.iterator();
                    do
                    {
                        if (!locationscontainer.hasNext())
                        {
                            break;
                        }
                        DealBreakdownAddress dealbreakdownaddress = (DealBreakdownAddress)locationscontainer.next();
                        if (dealbreakdownaddress.isMaster())
                        {
                            address = dealbreakdownaddress;
                        }
                    } while (true);
                }
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((LocationsContainer)obj);
            }

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                super();
            }
        }, new ReturningFunction1() {

            final GrouponNavigationDrawerActivity this$0;

            public Boolean execute(Exception exception)
            {
                return Boolean.valueOf(false);
            }

            public volatile Object execute(Object obj)
                throws Exception
            {
                return execute((Exception)obj);
            }

            
            {
                this$0 = GrouponNavigationDrawerActivity.this;
                super();
            }
        }, null);
    }



/*
    static DealBreakdownAddress access$002(GrouponNavigationDrawerActivity grouponnavigationdraweractivity, DealBreakdownAddress dealbreakdownaddress)
    {
        grouponnavigationdraweractivity.address = dealbreakdownaddress;
        return dealbreakdownaddress;
    }

*/



/*
    static boolean access$102(GrouponNavigationDrawerActivity grouponnavigationdraweractivity, boolean flag)
    {
        grouponnavigationdraweractivity.drawerWasDragged = flag;
        return flag;
    }

*/



}
