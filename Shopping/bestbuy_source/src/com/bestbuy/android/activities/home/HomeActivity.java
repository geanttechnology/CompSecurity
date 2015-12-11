// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import ahr;
import ahx;
import ahy;
import android.app.ActionBar;
import android.app.Activity;
import android.app.SearchManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.StateListDrawable;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.text.Layout;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import bw;
import cd;
import cf;
import cg;
import ch;
import ci;
import cj;
import cl;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.appsettings.AppSettingsFragment;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.dnm.DNMListFragmentContainer;
import com.bestbuy.android.activities.giftcard.ManualEnterGiftCardDetailsFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.activities.mybby.MyBBYHomeActivity;
import com.bestbuy.android.activities.registry.EmptyWeddingRegistryContainer;
import com.bestbuy.android.activities.registry.MyWeddingRegistryFragment;
import com.bestbuy.android.activities.registry.RegistryAndGiftsFragment;
import com.bestbuy.android.activities.registry.RegistryFragmentContainer;
import com.bestbuy.android.activities.registry.WishListFragmentContainer;
import com.bestbuy.android.activities.stores.StoreSearchMapFragment;
import com.bestbuy.android.activities.stores.StoreTabContainer;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYTextView;
import com.bestbuy.android.providers.SuggestionProvider;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import ct;
import cu;
import cv;
import dp;
import dz;
import fr;
import ht;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jg;
import kb;
import kc;
import kf;
import la;
import lj;
import ll;
import lu;
import mf;
import mq;
import mr;
import mu;
import mw;
import mx;
import my;
import na;
import nb;
import ni;
import pp;
import qm;
import qn;
import qo;
import qp;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeTabFragment, SplashActivity, HomeTabContainer, HomeFragment

public class HomeActivity extends BBYBaseFragmentActivity
    implements ahx, android.view.View.OnClickListener, bw, cl, ct, cu, cv, dp, qo, qp
{

    public static final String CHAT_STATUS = "chatstatus";
    private static final int EXITAPP_DELAY = 3000;
    private static final String TAG = com/bestbuy/android/activities/home/HomeActivity.getSimpleName();
    private static long backpress;
    public static boolean inDNMFragment = false;
    public static boolean inLifeEventsFragment = false;
    public static boolean inListIdSearchFragment = false;
    public static boolean inPDPFragment = false;
    public static boolean inStoresFragment = false;
    public static boolean inWrapperFragment = false;
    private static String productShareURL = "http;//www.bestbuy.com";
    private BBYTextView actionBarTitle;
    private cf actionIconClickListener;
    private RelativeLayout activateBanner;
    private MenuItem addToItem;
    private LinearLayout addToItemLayout;
    private nb appData;
    private BBYProduct bbyProduct;
    private String breadCrumb;
    private BroadcastReceiver chatMessageReceiver;
    private cj clearReviewsClickListener;
    private MenuItem clearReviewsItem;
    private LinearLayout clearReviewsLayout;
    private MenuItem geoLocateItem;
    private boolean hasOptionsMenu;
    private HomeTabFragment homeTabFragment;
    private boolean isFromNotification;
    private boolean isFromPLPFragment;
    private boolean isFromRecommendations;
    private boolean isNavigationDrawerOpened;
    private MenuItem lifeEventsMenuItem;
    private LinearLayout lifeEventsMenuItemLayout;
    private String lifeEventsMenuItemTitle;
    private cg lifeEventsNavigationListener;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private kc mDrawerToggle;
    private qm mGoogleApiClient;
    private mr myBBY;
    private View myBBYMenuItemView;
    private cd onDNMSearchListener;
    private String option;
    private String pageName;
    private String payloadStr;
    private String query;
    private mq recommendations;
    private RegistryWishList registryData;
    private ch searchIconClickListener;
    private MenuItem searchMenuItem;
    private SearchView searchView;
    private MenuItem shareItem;
    private LinearLayout shareItemll;
    private FrameLayout spinnerLayout;
    private MenuItem storeAvailability;
    private ci storeAvailabiltyClickListener;
    private MenuItem switchToListItem;
    private MenuItem switchToMap;
    private String tipsString;
    private List wishListData;
    private MenuItem wrapperOptionsItem;
    private LinearLayout wrapperOptionsItemLayout;

    public HomeActivity()
    {
        myBBY = null;
        isNavigationDrawerOpened = false;
        isFromNotification = false;
        tipsString = "&#8226 \t Try using fewer or less-specific keywords.<br/> &#8226 \t Double-check your spelling.<br/> &#8226 \t Make sure to add spaces between words.";
        hasOptionsMenu = false;
        recommendations = new mq();
        isFromRecommendations = false;
        isFromPLPFragment = false;
        payloadStr = null;
        chatMessageReceiver = new BroadcastReceiver() {

            final HomeActivity a;

            public void onReceive(Context context, Intent intent)
            {
                a.buildSideMenu();
            }

            
            {
                a = HomeActivity.this;
                super();
            }
        };
    }

    private android.support.v4.app.FragmentManager.OnBackStackChangedListener getListener()
    {
        return new android.support.v4.app.FragmentManager.OnBackStackChangedListener() {

            final HomeActivity a;

            public void onBackStackChanged()
            {
                FragmentManager fragmentmanager = a.getSupportFragmentManager();
                if (fragmentmanager != null)
                {
                    int i = fragmentmanager.getBackStackEntryCount();
                    if (i == 0)
                    {
                        a.finish();
                    } else
                    if (((Fragment)fragmentmanager.getFragments().get(i - 1) instanceof HomeTabFragment) && a.homeTabFragment.b().getCurrentTab() == 2)
                    {
                        a.onStoresFramentLaunch();
                        return;
                    }
                }
            }

            
            {
                a = HomeActivity.this;
                super();
            }
        };
    }

    private List getSlideInMenuView(my my1)
    {
        ArrayList arraylist = new ArrayList();
        if (my1 != null)
        {
            int i = 0;
            do
            {
                if (i >= my1.a().size())
                {
                    break;
                }
                Object obj = (mx)my1.a().get(i);
                String s = ((mx) (obj)).a();
                if (!s.isEmpty() && (fr.c() != null && !fr.c().isEmpty() && !s.equals("ACCOUNT") || fr.c() != null && fr.c().isEmpty() || fr.c() == null))
                {
                    mu mu1 = new mu();
                    mu1.a(s);
                    arraylist.add(mu1);
                }
                for (obj = ((mx) (obj)).b().iterator(); ((Iterator) (obj)).hasNext();)
                {
                    mw mw1 = (mw)((Iterator) (obj)).next();
                    if (!ChatRunningStatus.getChatRunning() || !mw1.i().equalsIgnoreCase("AskBlueShirt"))
                    {
                        arraylist.add(mw1);
                        if (mw1.i().equalsIgnoreCase("MyEmptyWeddingRegistryList"))
                        {
                            if (fr.c() == null)
                            {
                                arraylist.remove(mw1);
                            } else
                            if (fr.c() != null && !Boolean.valueOf(fr.g()).booleanValue())
                            {
                                arraylist.remove(mw1);
                            }
                        }
                        if (mw1.i().equalsIgnoreCase("MobileDevices"))
                        {
                            arraylist.remove(mw1);
                        }
                        if (!na.a && mw1.i().equalsIgnoreCase("AppSettings"))
                        {
                            arraylist.remove(mw1);
                        }
                    }
                }

                i++;
            } while (true);
        }
        return arraylist;
    }

    private boolean isGPSEnabled()
    {
        return ((LocationManager)getSystemService("location")).isProviderEnabled("gps");
    }

    private void onDrawerAction()
    {
        boolean flag1 = true;
        if (getSupportFragmentManager().findFragmentById(0x7f0c0033) instanceof HomeTabFragment)
        {
            MenuItem menuitem = searchMenuItem;
            boolean flag;
            if (!isNavigationDrawerOpened)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            menuitem.setVisible(flag);
            if (inStoresFragment)
            {
                MenuItem menuitem1 = switchToListItem;
                if (!isNavigationDrawerOpened)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                menuitem1.setVisible(flag);
                menuitem1 = geoLocateItem;
                if (!isNavigationDrawerOpened)
                {
                    flag = flag1;
                } else
                {
                    flag = false;
                }
                menuitem1.setVisible(flag);
            }
        }
    }

    private void openWebFragment(String s)
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        MdotWebFragment mdotwebfragment = new MdotWebFragment(true, true);
        Bundle bundle = new Bundle();
        bundle.putString("mDotURL", s);
        mdotwebfragment.setArguments(bundle);
        s = fragmentmanager.beginTransaction();
        s.add(0x7f0c0033, mdotwebfragment, "MdotWebFragment");
        s.addToBackStack(null);
        s.commit();
    }

    private void productSearch(String s)
    {
        if (homeTabFragment != null)
        {
            ((BBYBaseFragment)homeTabFragment.e()).a(s, spinnerLayout);
        }
    }

    private void selectItem(int i)
    {
        homeTabFragment = new HomeTabFragment();
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        fragmenttransaction.add(0x7f0c0033, homeTabFragment, "HomeTabFragment");
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commitAllowingStateLoss();
        mDrawerList.setItemChecked(i, true);
        mDrawerLayout.closeDrawer(mDrawerList);
    }

    private void showLifeEventsTopNavigationButton()
    {
        inLifeEventsFragment = true;
        switchToListItem.setVisible(false);
        geoLocateItem.setVisible(false);
        searchMenuItem.setVisible(false);
        shareItem.setVisible(false);
        addToItem.setVisible(false);
        lifeEventsMenuItem.setVisible(true);
    }

    public void addFragment(int i, Fragment fragment, String s)
    {
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        fragmenttransaction.add(i, fragment, s);
        fragmenttransaction.addToBackStack(null);
        fragmenttransaction.commit();
    }

    public void buildSideMenu()
    {
        Object obj;
        try
        {
            obj = ni.a(getAssets().open("sidemenucards.json"));
            nb.a().b().edit().putString("Sidemenu", ((String) (obj))).commit();
            obj = new my(nb.a().b().getString("Sidemenu", ""), "Sidemenu");
        }
        catch (Exception exception)
        {
            kf.e(TAG, (new StringBuilder()).append("Could not load Sidemenu data: ").append(exception.getLocalizedMessage()).toString());
            exception = null;
        }
        obj = new dz(this, getSlideInMenuView(((my) (obj))));
        mDrawerList.setAdapter(((android.widget.ListAdapter) (obj)));
    }

    public void changeOptionsVisibility(boolean flag)
    {
    }

    public void changeSearchBarVisibility(boolean flag)
    {
label0:
        {
            if (searchMenuItem != null)
            {
                if (!flag)
                {
                    break label0;
                }
                searchMenuItem.setVisible(false);
            }
            return;
        }
        searchMenuItem.setVisible(true);
    }

    public void changeStoresSearchVisibility(boolean flag)
    {
label0:
        {
            if (searchMenuItem != null)
            {
                if (!flag)
                {
                    break label0;
                }
                searchMenuItem.setVisible(false);
                geoLocateItem.setVisible(false);
                switchToListItem.setVisible(false);
            }
            return;
        }
        searchMenuItem.setVisible(true);
        geoLocateItem.setVisible(true);
        switchToListItem.setVisible(true);
    }

    public void closeSideMenu()
    {
        mDrawerLayout.closeDrawers();
    }

    public void customerAlsoBoughtRecommendations(ArrayList arraylist)
    {
        recommendations.a(arraylist);
    }

    public void customerAlsoViewedRecommendations(ArrayList arraylist)
    {
        recommendations.b(arraylist);
    }

    public void disableNextButton()
    {
    }

    public void enableNextButton()
    {
    }

    public void fragmentHasOptionsMenu(boolean flag)
    {
    }

    public RelativeLayout getActivateLayout()
    {
        return activateBanner;
    }

    public MenuItem getStoreAvailability()
    {
        return storeAvailability;
    }

    public void hideLifeEventsTopNavigationButton()
    {
        inLifeEventsFragment = false;
        if (!inStoresFragment)
        {
            if (switchToListItem != null)
            {
                switchToListItem.setVisible(false);
            }
            if (geoLocateItem != null)
            {
                geoLocateItem.setVisible(false);
            }
        }
        shareItem.setVisible(false);
        addToItem.setVisible(false);
        lifeEventsMenuItem.setVisible(false);
    }

    public void instantiateSearch()
    {
        searchMenuItem.setVisible(true);
        searchView.setVisibility(0);
        searchMenuItem.expandActionView();
        searchView.setIconified(false);
        searchView.requestFocus();
    }

    public void instantiateSearch(String s)
    {
        instantiateSearch();
        if (searchView != null)
        {
            searchView.setQueryHint(s);
        }
    }

    public void loadMostPopularRecommendations(String s, String s1, ArrayList arraylist)
    {
        recommendations.c(arraylist);
        sendRecommendations(s1, ((BBYProduct)arraylist.get(0)).getEp(), s);
    }

    public void loadTrendingNowRecommendations(String s, String s1, ArrayList arraylist)
    {
        recommendations.d(arraylist);
        sendRecommendations(s1, ((BBYProduct)arraylist.get(0)).getEp(), s);
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        i;
        JVM INSTR lookupswitch 6: default 68
    //                   1111: 69
    //                   2222: 79
    //                   3456: 110
    //                   7890: 145
    //                   7891: 184
    //                   7892: 223;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return;
_L2:
        if (j == -1)
        {
            buildSideMenu();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (j == -1)
        {
            openPDP(intent.getExtras().getString("sku"), intent.getExtras().getString("productId"), false);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (j == -1)
        {
            openPDP(intent.getExtras().getString("sku"), "", intent.getExtras().getString("productId"), false, true);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (j == -1)
        {
            intent = getSupportFragmentManager().findFragmentById(0x7f0c0033);
            if (intent != null && (intent instanceof HomeTabFragment))
            {
                ((HomeTabFragment)intent).d();
            }
            buildSideMenu();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        if (j == -1)
        {
            (new jg(this, null, (ProgressBar)findViewById(0x7f0c0230), "wishlist")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (j == -1)
        {
            (new jg(this, null, (ProgressBar)findViewById(0x7f0c0230), "weddingregistry")).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        }
        if (true) goto _L1; else goto _L8
_L8:
    }

    public void onBackPressed()
    {
        Object obj;
        Object obj1;
        obj = (InputMethodManager)getSystemService("input_method");
        if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null)
        {
            ((InputMethodManager) (obj)).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
        }
        obj1 = getSupportFragmentManager();
        obj = ((FragmentManager) (obj1)).findFragmentById(0x7f0c0033);
        if (!(obj instanceof HomeTabFragment)) goto _L2; else goto _L1
_L1:
        obj = (HomeTabFragment)obj;
        obj1 = ((HomeTabFragment) (obj)).b().getCurrentTabTag();
        if (!((BaseTabContainer)((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag(((String) (obj1)))).a(((String) (obj1))))
        {
            if (backpress + 3000L > System.currentTimeMillis())
            {
                super.onBackPressed();
            } else
            {
                Toast.makeText(getBaseContext(), getResources().getString(0x7f080198), 0).show();
            }
            backpress = System.currentTimeMillis();
            onUserLeaveHint();
        }
_L4:
        return;
_L2:
        if (obj instanceof MdotWebFragment)
        {
            obj = (MdotWebFragment)obj;
            if (((MdotWebFragment) (obj)).d())
            {
                ((MdotWebFragment) (obj)).e();
                return;
            } else
            {
                super.onBackPressed();
                return;
            }
        }
        if (obj instanceof AppSettingsFragment)
        {
            ((AppSettingsFragment)obj).a();
            super.onBackPressed();
            return;
        }
        if (!(obj instanceof ManualEnterGiftCardDetailsFragment))
        {
            break; /* Loop/switch isn't completed */
        }
        while (obj instanceof ManualEnterGiftCardDetailsFragment) 
        {
            ((FragmentManager) (obj1)).popBackStackImmediate();
            obj = ((FragmentManager) (obj1)).findFragmentById(0x7f0c0033);
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!(obj instanceof MyWeddingRegistryFragment))
        {
            break; /* Loop/switch isn't completed */
        }
        if (((MyWeddingRegistryFragment)obj).b())
        {
            super.onBackPressed();
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (obj instanceof BaseFragmentContainer)
        {
            if (!((BaseFragmentContainer)obj).e())
            {
                super.onBackPressed();
                return;
            }
        } else
        {
            super.onBackPressed();
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    public void onClick(View view)
    {
        if (view != addToItemLayout) goto _L2; else goto _L1
_L1:
        ProgressBar progressbar;
        view = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        progressbar = (ProgressBar)findViewById(0x7f0c0230);
        if (fr.c() == null) goto _L4; else goto _L3
_L3:
        (new jg(this, (BBYBaseFragment)view, progressbar, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
_L6:
        return;
_L4:
        (new la(this, view, PDPFragment.e())).show();
        return;
_L2:
        if (view == lifeEventsMenuItemLayout)
        {
            view = (InputMethodManager)getSystemService("input_method");
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null)
            {
                view.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
            lifeEventsNavigationListener.g();
            return;
        }
        if (view == shareItemll)
        {
            view = new Intent();
            view.setAction("android.intent.action.SEND");
            if (productShareURL != null)
            {
                view.putExtra("android.intent.extra.TEXT", productShareURL);
            }
            view.setType("text/plain");
            startActivity(Intent.createChooser(view, getResources().getText(0x7f080309)));
            return;
        }
        if (view == wrapperOptionsItemLayout)
        {
            showPopup();
            return;
        }
        if (view == clearReviewsLayout)
        {
            view = (InputMethodManager)getSystemService("input_method");
            if (getCurrentFocus() != null && getCurrentFocus().getWindowToken() != null)
            {
                view.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
            }
            clearReviewsClickListener.b();
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        mDrawerToggle.onConfigurationChanged(configuration);
    }

    public void onConnected(Bundle bundle)
    {
        ahy.b.a(mGoogleApiClient, BBYBaseFragmentActivity.REQUEST, this);
    }

    public void onConnectionFailed(pp pp1)
    {
        if (pp1.a())
        {
            try
            {
                pp1.a(this, 9000);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (pp pp1)
            {
                pp1.printStackTrace();
            }
            return;
        } else
        {
            kf.b(TAG, (new StringBuilder()).append("Location services connection failed with code ").append(pp1.c()).toString());
            return;
        }
    }

    public void onConnectionSuspended(int i)
    {
        kf.b(TAG, (new StringBuilder()).append("Location services suspended cause:  ").append(i).toString());
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        appData = nb.a();
        appData.f(true);
        HashMap hashmap = new HashMap();
        hashmap.put(lu.bo, "browse,home");
        hashmap.put(lu.bp, "GHP");
        lu.b(lu.a, hashmap);
        if (nb.a().o() != null && nb.a().o().get("maintenance_shutdown") != null && ((String)nb.a().o().get("maintenance_shutdown")).equals("true"))
        {
            appData.a(true);
            startActivity(new Intent(this, com/bestbuy/android/activities/home/SplashActivity));
            finish();
        } else
        {
            if (isGPSEnabled())
            {
                mGoogleApiClient = (new qn(this)).a(ahy.a).a(this).a(this).b();
                mGoogleApiClient.b();
            }
            setContentView(0x7f030054);
            getWindow().setSoftInputMode(3);
            getActionBar().setDisplayShowTitleEnabled(false);
            getActionBar().setDisplayShowCustomEnabled(true);
            getActionBar().setCustomView(0x7f03000e);
            actionBarTitle = (BBYTextView)findViewById(0x7f0c0059);
            findViewById(0x7f0c0058).setOnClickListener(new android.view.View.OnClickListener() {

                final HomeActivity a;

                public void onClick(View view)
                {
                    a.onBackPressed();
                }

            
            {
                a = HomeActivity.this;
                super();
            }
            });
            spinnerLayout = (FrameLayout)findViewById(0x7f0c0064);
            showActionBarHome();
            getActionBar().setBackgroundDrawable(new ColorDrawable(0xff003b64));
            getSupportFragmentManager().addOnBackStackChangedListener(getListener());
            mDrawerLayout = (DrawerLayout)findViewById(0x7f0c0130);
            mDrawerList = (ListView)findViewById(0x7f0c0135);
            mDrawerList.setVerticalScrollBarEnabled(false);
            mDrawerLayout.setDrawerShadow(0x7f0200b9, 0x800003);
            mDrawerToggle = new kc(this, mDrawerLayout, 0x7f020114, 0x7f08017b, 0x7f08017a) {

                final HomeActivity a;

                public void onDrawerClosed(View view)
                {
                    a.isNavigationDrawerOpened = false;
                    a.onDrawerAction();
                }

                public void onDrawerOpened(View view)
                {
                    view = new HashMap();
                    view.put(lu.bo, "browse,more");
                    view.put(lu.bp, "NAV");
                    lu.b(lu.g, view);
                    a.isNavigationDrawerOpened = true;
                    a.onDrawerAction();
                }

            
            {
                a = HomeActivity.this;
                super(activity, drawerlayout, i, j, k);
            }
            };
            mDrawerLayout.setDrawerListener(mDrawerToggle);
            buildSideMenu();
            LocalBroadcastManager.getInstance(this).registerReceiver(chatMessageReceiver, new IntentFilter("chatstatus"));
            if (bundle == null)
            {
                selectItem(0);
            }
            appData = nb.a();
            myBBY = appData.w();
            if (getIntent().getAction() != null && getIntent().getAction().equals("com.bestbuy.android.NOTIFICATION"))
            {
                showNotification(getIntent().getExtras());
            }
            if (getIntent() != null && getIntent().getExtras() != null)
            {
                if (getIntent().getExtras().containsKey("push_received_payload"))
                {
                    payloadStr = getIntent().getExtras().getString("push_received_payload");
                    return;
                }
                if (getIntent().getExtras().containsKey("_x"))
                {
                    bundle = getIntent().getExtras().getString("_x");
                } else
                if (getIntent().getExtras().containsKey("_od"))
                {
                    bundle = getIntent().getExtras().getString("_od");
                } else
                {
                    bundle = null;
                    setTitle("No website URL found in payload.");
                }
                if (bundle != null)
                {
                    openWebFragment(bundle);
                    return;
                }
            }
        }
    }

    public void onCreateMyEmptyRegistryFragmentExit()
    {
    }

    public void onCreateMyEmptyRegistryFragmentLaunch()
    {
        showLifeEventsTopNavigationButton();
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(0x7f0f0004, menu);
        searchMenuItem = menu.findItem(0x7f0c044f);
        searchView = (SearchView)searchMenuItem.getActionView();
        android.app.SearchableInfo searchableinfo = ((SearchManager)getSystemService("search")).getSearchableInfo(getComponentName());
        searchView.setSearchableInfo(searchableinfo);
        try
        {
            int i = searchView.getContext().getResources().getIdentifier("android:id/search_src_text", null, null);
            Object obj = (TextView)searchView.findViewById(i);
            ((TextView) (obj)).setTextColor(-1);
            ((TextView) (obj)).setHintTextColor(0xff888888);
            searchMenuItem.setShowAsActionFlags(10);
            obj = (AutoCompleteTextView)searchView.findViewById(i);
            Field field = android/widget/TextView.getDeclaredField("mCursorDrawableRes");
            field.setAccessible(true);
            field.set(obj, Integer.valueOf(0));
            searchView.setOnFocusChangeListener(new android.view.View.OnFocusChangeListener() {

                final HomeActivity a;

                public void onFocusChange(View view, boolean flag)
                {
                    a.searchView.postDelayed(new Runnable(this) {

                        final _cls3 a;

                        public void run()
                        {
                            ((InputMethodManager)a.a.getSystemService("input_method")).showSoftInput(a.a.searchView, 2);
                        }

            
            {
                a = _pcls3;
                super();
            }
                    }, 1000L);
                }

            
            {
                a = HomeActivity.this;
                super();
            }
            });
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        searchView.setOnQueryTextFocusChangeListener(new android.view.View.OnFocusChangeListener() {

            final HomeActivity a;

            public void onFocusChange(View view, boolean flag)
            {
                if (flag)
                {
                    if (HomeActivity.inStoresFragment)
                    {
                        if (a.switchToListItem != null)
                        {
                            a.switchToListItem.setVisible(false);
                        }
                        if (a.geoLocateItem != null)
                        {
                            a.geoLocateItem.setVisible(false);
                        }
                    }
                } else
                {
                    a.searchMenuItem.collapseActionView();
                    if (HomeActivity.inLifeEventsFragment)
                    {
                        a.searchMenuItem.setVisible(false);
                    }
                    a.getActionBar().setDisplayShowHomeEnabled(true);
                    if (HomeActivity.inStoresFragment)
                    {
                        if (a.switchToListItem != null)
                        {
                            a.switchToListItem.setVisible(true);
                        }
                        if (a.geoLocateItem != null)
                        {
                            a.geoLocateItem.setVisible(true);
                            return;
                        }
                    }
                }
            }

            
            {
                a = HomeActivity.this;
                super();
            }
        });
        searchView.setOnSearchClickListener(new android.view.View.OnClickListener() {

            final HomeActivity a;

            public void onClick(View view)
            {
                if ((a.isFromPLPFragment || HomeActivity.inLifeEventsFragment || HomeActivity.inStoresFragment || HomeActivity.inDNMFragment) && a.query != null)
                {
                    a.searchView.setQuery(a.query, false);
                }
            }

            
            {
                a = HomeActivity.this;
                super();
            }
        });
        geoLocateItem = menu.findItem(0x7f0c0450);
        switchToListItem = menu.findItem(0x7f0c0451);
        switchToMap = menu.findItem(0x7f0c0452);
        shareItem = menu.findItem(0x7f0c0454);
        lifeEventsMenuItem = menu.findItem(0x7f0c0455);
        addToItem = menu.findItem(0x7f0c0453);
        clearReviewsItem = menu.findItem(0x7f0c0456);
        clearReviewsLayout = (LinearLayout)clearReviewsItem.getActionView();
        clearReviewsLayout.setOnClickListener(this);
        storeAvailability = menu.findItem(0x7f0c044e);
        addToItemLayout = (LinearLayout)addToItem.getActionView();
        addToItemLayout.setOnClickListener(this);
        lifeEventsMenuItemLayout = (LinearLayout)lifeEventsMenuItem.getActionView();
        lifeEventsMenuItemLayout.setOnClickListener(this);
        ((BBYTextView)lifeEventsMenuItemLayout.findViewById(0x7f0c0150)).setText(lifeEventsMenuItemTitle);
        shareItemll = (LinearLayout)shareItem.getActionView();
        shareItemll.setOnClickListener(this);
        wrapperOptionsItem = menu.findItem(0x7f0c03b3);
        wrapperOptionsItemLayout = (LinearLayout)wrapperOptionsItem.getActionView();
        wrapperOptionsItemLayout.setOnClickListener(this);
        return true;
    }

    public void onCreateRegistryFragmentExit()
    {
    }

    public void onCreateRegistryFragmentLaunch()
    {
        showLifeEventsTopNavigationButton();
    }

    public void onCreateWishListFragmentExit()
    {
        hideLifeEventsTopNavigationButton();
    }

    public void onCreateWishListFragmentLaunch()
    {
        showLifeEventsTopNavigationButton();
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mGoogleApiClient != null && mGoogleApiClient.d())
        {
            mGoogleApiClient.c();
        }
        query = "";
    }

    public boolean onKeyDown(int i, KeyEvent keyevent)
    {
        if (i == 4)
        {
            searchMenuItem.collapseActionView();
        }
        getWindow().setSoftInputMode(3);
        return super.onKeyDown(i, keyevent);
    }

    public void onLocationChanged(Location location)
    {
        if (location != null)
        {
            appData.a(location.getLatitude());
            appData.b(location.getLongitude());
            if (mGoogleApiClient.d())
            {
                ahy.b.a(mGoogleApiClient, this);
                mGoogleApiClient.c();
            }
        }
    }

    public void onMenuClick(mw mw1)
    {
        Object obj;
        Object obj3;
        boolean flag;
        flag = false;
        mDrawerLayout.closeDrawers();
        onStoresFramentExit();
        obj3 = getSupportFragmentManager();
        obj = ((FragmentManager) (obj3)).beginTransaction();
        getWindow().setSoftInputMode(32);
        if (!mw1.e().equals("bbyDIViewController") && !mw1.e().equals("bbyWebViewController")) goto _L2; else goto _L1
_L1:
        getWindow().setSoftInputMode(16);
        Object obj1 = new HashMap();
        if (mw1.d().equals("Order Status"))
        {
            ((HashMap) (obj1)).put(lu.bo, "profile,orderListing");
            ((HashMap) (obj1)).put(lu.bp, "MAO");
            lu.b(lu.h, ((HashMap) (obj1)));
        } else
        if (mw1.d().equals("Upgrade Checker"))
        {
            ((HashMap) (obj1)).put(lu.bo, "browse,service");
            ((HashMap) (obj1)).put(lu.bp, "SERV");
            lu.b(lu.i, ((HashMap) (obj1)));
        } else
        if (mw1.d().equals("Trade-In Center"))
        {
            ((HashMap) (obj1)).put(lu.bo, "browse,service");
            ((HashMap) (obj1)).put(lu.bp, "SERV");
            lu.b(lu.j, ((HashMap) (obj1)));
        } else
        if (mw1.d().equals("Product Recalls"))
        {
            ((HashMap) (obj1)).put(lu.bo, "browse,service");
            ((HashMap) (obj1)).put(lu.bp, "SERV");
            lu.b(lu.k, ((HashMap) (obj1)));
        } else
        if (mw1.d().equals("Contact Best Buy"))
        {
            lu.a(lu.o);
        } else
        if (mw1.d().equals("Submit Feedback"))
        {
            ((HashMap) (obj1)).put(lu.bo, "browse,service");
            ((HashMap) (obj1)).put(lu.bp, "SERV");
            lu.b(lu.u, ((HashMap) (obj1)));
        }
        obj1 = mw1.f();
        mw1 = mw1.j();
        if (mw1 != null && !mw1.isEmpty())
        {
            mw1 = new MdotWebFragment(true, true, mw1);
        } else
        {
            mw1 = new MdotWebFragment(true, true);
        }
        obj3 = new Bundle();
        ((Bundle) (obj3)).putString("mDotURL", ((String) (obj1)));
        mw1.setArguments(((Bundle) (obj3)));
        ((FragmentTransaction) (obj)).add(0x7f0c0033, mw1, "MdotWebFragment");
        ((FragmentTransaction) (obj)).addToBackStack(null);
        ((FragmentTransaction) (obj)).commit();
_L4:
        return;
_L2:
        if (mw1.e().equals("bbyScanViewController"))
        {
            mw1 = new HashMap();
            mw1.put(lu.bo, "browse,service");
            mw1.put(lu.bp, "SERV");
            lu.b(lu.l, mw1);
            (new mf()).a(this, "CODE_SCAN", "");
            return;
        }
        if (mw1.e().equals("bbyGiftCardScanViewController"))
        {
            mw1 = new HashMap();
            mw1.put(lu.bo, "browse,service");
            mw1.put(lu.bp, "GCB");
            lu.b(lu.m, mw1);
            ((FragmentTransaction) (obj)).add(0x7f0c0033, new ManualEnterGiftCardDetailsFragment(), "ManualEnterGiftCardDetailsFragment");
            ((FragmentTransaction) (obj)).addToBackStack(null);
            ((FragmentTransaction) (obj)).commit();
            return;
        }
        if (mw1.e().equals("MyEmptyWeddingRegistryList"))
        {
            ((FragmentTransaction) (obj)).add(0x7f0c0033, new EmptyWeddingRegistryContainer(), "EmptyWeddingRegistryContainer");
            ((FragmentTransaction) (obj)).addToBackStack(null);
            ((FragmentTransaction) (obj)).commit();
            return;
        }
        if (mw1.e().equals("MyWishListsFragment"))
        {
            if (fr.c() != null)
            {
                ((FragmentTransaction) (obj)).add(0x7f0c0033, new WishListFragmentContainer(option), "WishListFragmentContainer");
                ((FragmentTransaction) (obj)).addToBackStack(null);
                ((FragmentTransaction) (obj)).commit();
                return;
            } else
            {
                startActivityForResult(new Intent(this, com/bestbuy/android/activities/mybby/MyBBYHomeActivity), 7890);
                overridePendingTransition(0x7f04000e, 0x7f040005);
                return;
            }
        }
        if (mw1.e().equals("HelpMenuActivity"))
        {
            mw1 = new Intent(getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity);
            mw1.putExtra(nb.k, nb.m);
            startActivity(mw1);
            overridePendingTransition(0x7f04000e, 0x7f040005);
            return;
        }
        if (mw1.e().equals("RegistryAndGiftsFragment"))
        {
            mw1 = new RegistryFragmentContainer();
            RegistryAndGiftsFragment registryandgiftsfragment = new RegistryAndGiftsFragment();
            ((FragmentTransaction) (obj)).add(0x7f0c0033, mw1, "RegistryFragmentContainer");
            ((FragmentTransaction) (obj)).addToBackStack(null);
            ((FragmentTransaction) (obj)).commit();
            mw1.a(registryandgiftsfragment, true, "RegistryAndGiftsFragment");
            return;
        }
        if (mw1.e().equals("bbyAlertViewController"))
        {
            mw1 = new HashMap();
            mw1.put(lu.bo, "browse,promo");
            mw1.put(lu.bp, "PRPT");
            lu.b(lu.n, mw1);
            mw1 = new MdotWebFragment(true, true);
            Bundle bundle = new Bundle();
            bundle.putString("mDotURL", appData.d());
            mw1.setArguments(bundle);
            ((FragmentTransaction) (obj)).add(0x7f0c0033, mw1, "MdotWebFragment");
            ((FragmentTransaction) (obj)).addToBackStack(null);
            ((FragmentTransaction) (obj)).commit();
            return;
        }
        if (mw1.e().equals("ContactBestBuyFragment"))
        {
            mw1 = new Intent("android.intent.action.SEND");
            mw1.setType("text/html");
            mw1.putExtra("android.intent.extra.EMAIL", new String[] {
                "onlinestore@bestbuy.com"
            });
            try
            {
                mw1.putExtra("android.intent.extra.SUBJECT", (new StringBuilder()).append("Best Buy Mobile App Feedback (").append(getPackageManager().getPackageInfo(getPackageName(), 0).versionName).append(")").toString());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                ((android.content.pm.PackageManager.NameNotFoundException) (obj)).printStackTrace();
            }
            mw1.putExtra("android.intent.extra.TEXT", "");
            startActivity(Intent.createChooser(mw1, ""));
            return;
        }
        mw1 = mw1.e();
        if (mw1.equals("HomeTabFragment"))
        {
            int i1 = getSupportFragmentManager().getBackStackEntryCount();
            for (int i = 0; i < i1 - 1; i++)
            {
                ((FragmentManager) (obj3)).popBackStackImmediate();
            }

        }
        if (!mw1.equals("StoreSearchMapFragment"))
        {
            break; /* Loop/switch isn't completed */
        }
        onStoresFramentLaunch();
        mw1 = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (mw1 instanceof HomeTabFragment)
        {
            mw1 = (HomeTabFragment)mw1;
            mw1.b().setCurrentTab(2);
            mw1 = mw1.e();
            if (mw1 != null && (mw1 instanceof StoreTabContainer))
            {
                ((BaseTabContainer)mw1).c();
                return;
            }
        } else
        {
            int j1 = getSupportFragmentManager().getBackStackEntryCount();
            for (int j = ((flag) ? 1 : 0); j < j1 - 1; j++)
            {
                ((FragmentManager) (obj3)).popBackStackImmediate();
            }

            mw1 = getSupportFragmentManager().findFragmentById(0x7f0c0033);
            if (mw1 instanceof HomeTabFragment)
            {
                ((HomeTabFragment)mw1).b().setCurrentTab(2);
                return;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (!mw1.equals("bbyRZViewController"))
        {
            break; /* Loop/switch isn't completed */
        }
        if (fr.c() == null)
        {
            startActivityForResult(new Intent(this, com/bestbuy/android/activities/mybby/MyBBYHomeActivity), 7890);
            overridePendingTransition(0x7f04000e, 0x7f040005);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
        if (mw1.equals("GameTradeInFragment"))
        {
            Object obj2 = kb.a("GameTradeInFragment");
            mw1 = getSupportFragmentManager().findFragmentById(0x7f0c0033);
            if (mw1 instanceof HomeTabFragment)
            {
                appData.g(true);
                appData.a(((Fragment) (obj2)));
                obj = (HomeTabFragment)mw1;
                ((HomeTabFragment) (obj)).a(1);
            } else
            {
                int l = getSupportFragmentManager().getBackStackEntryCount();
                for (int k = 0; k < l - 1; k++)
                {
                    ((FragmentManager) (obj3)).popBackStackImmediate();
                }

                mw1 = getSupportFragmentManager().findFragmentById(0x7f0c0033);
                if (mw1 instanceof HomeTabFragment)
                {
                    obj = (HomeTabFragment)mw1;
                    ((HomeTabFragment) (obj)).a(1);
                } else
                {
                    obj = null;
                }
            }
            if (mw1 instanceof HomeTabFragment)
            {
                if (((HomeTabFragment) (obj)).b().getCurrentTab() == 1)
                {
                    mw1 = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("PRODUCTS");
                    if (mw1 instanceof ProductTabContainer)
                    {
                        ((BaseTabContainer)(ProductTabContainer)mw1).a(((Fragment) (obj2)), true);
                        return;
                    }
                } else
                {
                    appData.g(true);
                    appData.a(((Fragment) (obj2)));
                    ((HomeTabFragment)mw1).a(1);
                    return;
                }
            }
        } else
        {
            if (mw1.equals("AppSettingsFragment") || mw1.equals("PrivacyTermsFragment"))
            {
                if (!mw1.equals("AppSettingsFragment"));
                obj2 = getCurrentActionBarTitle();
                appData.i(((String) (obj2)));
                updateActionBarTitle("");
                hideActionBarHomeAndSearchBox(this);
            }
            ((FragmentTransaction) (obj)).add(0x7f0c0033, kb.a(mw1), mw1);
            ((FragmentTransaction) (obj)).addToBackStack(null);
            ((FragmentTransaction) (obj)).commit();
            return;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    protected void onNewIntent(Intent intent)
    {
        if (!"android.intent.action.SEARCH".equals(intent.getAction())) goto _L2; else goto _L1
_L1:
        Object obj = intent.getStringExtra("query");
        PLPFragmentContainer plpfragmentcontainer;
        if (obj == null)
        {
            intent = intent.getDataString();
        } else
        {
            intent = ((Intent) (obj));
        }
        (new SuggestionProvider()).a(this, intent);
        searchMenuItem.collapseActionView();
        if (intent.compareTo("ProductScan") != 0) goto _L4; else goto _L3
_L3:
        (new mf()).a(this, "CODE_SCAN", "");
_L6:
        return;
_L4:
        if (intent != null && !intent.isEmpty())
        {
            if (!inStoresFragment)
            {
                obj = getSupportFragmentManager().findFragmentById(0x7f0c0033);
                if (obj instanceof PLPFragmentContainer)
                {
                    productSearch(intent);
                    return;
                }
                if (obj instanceof HomeTabFragment)
                {
                    obj = (HomeTabFragment)obj;
                    if (((HomeTabFragment) (obj)).e() instanceof HomeTabContainer)
                    {
                        if (((HomeTabContainer)((HomeTabFragment) (obj)).e()).b() instanceof DNMListFragmentContainer)
                        {
                            onDNMSearchListener.a(intent);
                            query = intent;
                            inDNMFragment = true;
                            return;
                        } else
                        {
                            productSearch(intent);
                            return;
                        }
                    }
                    if (((HomeTabFragment) (obj)).e() instanceof StoreTabContainer)
                    {
                        if (((StoreTabContainer)((HomeTabFragment) (obj)).e()).b() instanceof DNMListFragmentContainer)
                        {
                            onDNMSearchListener.a(intent);
                            query = intent;
                            inDNMFragment = true;
                            return;
                        } else
                        {
                            plpfragmentcontainer = new PLPFragmentContainer();
                            intent = new PLPFragment(intent, false);
                            ((BaseTabContainer)((HomeTabFragment) (obj)).e()).a(plpfragmentcontainer, true);
                            plpfragmentcontainer.a(intent, true);
                            return;
                        }
                    } else
                    {
                        productSearch(intent);
                        return;
                    }
                } else
                {
                    productSearch(intent);
                    return;
                }
            } else
            {
                showActionBarHome();
                actionIconClickListener.a(intent);
                query = intent;
                return;
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if ("com.bestbuy.android.NOTIFICATION".equals(intent.getAction()))
        {
            showNotification(intent.getExtras());
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (mDrawerToggle.onOptionsItemSelected(menuitem))
        {
            return true;
        }
        menuitem.getItemId();
        JVM INSTR lookupswitch 6: default 76
    //                   2131493811: 346
    //                   2131493966: 200
    //                   2131493968: 82
    //                   2131493969: 100
    //                   2131493972: 122
    //                   2131493973: 184;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7
_L1:
        return super.onOptionsItemSelected(menuitem);
_L4:
        if (!StoreSearchMapFragment.b)
        {
            actionIconClickListener.b();
        }
        continue; /* Loop/switch isn't completed */
_L5:
        if (!StoreSearchMapFragment.b)
        {
            invalidateOptionsMenu();
            actionIconClickListener.c();
        }
        continue; /* Loop/switch isn't completed */
_L6:
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        if (productShareURL != null)
        {
            intent.putExtra("android.intent.extra.TEXT", productShareURL);
        }
        intent.setType("text/plain");
        startActivity(Intent.createChooser(intent, getResources().getText(0x7f080309)));
        continue; /* Loop/switch isn't completed */
_L7:
        invalidateOptionsMenu();
        lifeEventsNavigationListener.g();
        continue; /* Loop/switch isn't completed */
_L3:
        StateListDrawable statelistdrawable;
        int i;
        boolean flag;
        if (!menuitem.isChecked())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        nb.a().b().edit().putBoolean("show_availability", flag).commit();
        menuitem.setChecked(flag);
        statelistdrawable = (StateListDrawable)getResources().getDrawable(0x7f020014);
        if (menuitem.isChecked())
        {
            i = 0x10100a0;
        } else
        {
            i = 0x10100a9;
        }
        statelistdrawable.setState(new int[] {
            i
        });
        menuitem.setIcon(statelistdrawable.getCurrent());
        if (menuitem.isChecked())
        {
            storeAvailabiltyClickListener.a(true);
        } else
        {
            storeAvailabiltyClickListener.a(false);
        }
        if (true) goto _L1; else goto _L2
_L2:
        showPopup();
        return true;
    }

    public void onPDPFragmentExit()
    {
        inPDPFragment = false;
        if (shareItem != null)
        {
            shareItem.setVisible(false);
        }
        if (addToItem != null)
        {
            addToItem.setVisible(false);
        }
    }

    public void onPDPFragmentLaunch()
    {
        inPDPFragment = true;
        if (searchMenuItem != null)
        {
            searchMenuItem.setVisible(false);
        }
        if (switchToListItem != null)
        {
            switchToListItem.setVisible(false);
        }
        if (geoLocateItem != null)
        {
            geoLocateItem.setVisible(false);
        }
        if (shareItem != null)
        {
            shareItem.setVisible(true);
        }
    }

    public void onPause()
    {
        super.onPause();
        lu.a();
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        mDrawerToggle.syncState();
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean flag = true;
        if (!isNavigationDrawerOpened)
        {
            switchToMap.setVisible(false);
            searchMenuItem.setVisible(true);
            storeAvailability.setVisible(false);
            wrapperOptionsItem.setVisible(false);
            shareItem.setVisible(false);
            lifeEventsMenuItem.setVisible(false);
            addToItem.setVisible(false);
            clearReviewsItem.setVisible(false);
            if (inStoresFragment)
            {
                if (!StoreSearchMapFragment.b)
                {
                    flag = nb.a().b().getBoolean("IS_MAP_VIEW", false);
                    if (searchView != null)
                    {
                        String s = getResources().getString(0x7f080352);
                        searchView.setQueryHint(s);
                    }
                    if (flag)
                    {
                        switchToListItem.setIcon(0x7f02010f);
                        nb.a().b().edit().putBoolean("IS_MAP_VIEW", false).commit();
                    } else
                    {
                        switchToListItem.setIcon(0x7f020107);
                        nb.a().b().edit().putBoolean("IS_MAP_VIEW", true).commit();
                    }
                }
            } else
            if (inLifeEventsFragment && inPDPFragment)
            {
                switchToListItem.setVisible(false);
                geoLocateItem.setVisible(false);
                searchMenuItem.setVisible(false);
                storeAvailability.setVisible(false);
                shareItem.setVisible(false);
                addToItem.setVisible(false);
                clearReviewsItem.setVisible(false);
                lifeEventsMenuItem.setVisible(true);
                wrapperOptionsItem.setVisible(false);
            } else
            if (inPDPFragment)
            {
                switchToListItem.setVisible(false);
                geoLocateItem.setVisible(false);
                lifeEventsMenuItem.setVisible(false);
                searchMenuItem.setVisible(false);
                storeAvailability.setVisible(false);
                shareItem.setVisible(true);
                wrapperOptionsItem.setVisible(false);
                clearReviewsItem.setVisible(false);
            } else
            if (inLifeEventsFragment)
            {
                switchToListItem.setVisible(false);
                geoLocateItem.setVisible(false);
                searchMenuItem.setVisible(false);
                storeAvailability.setVisible(false);
                shareItem.setVisible(false);
                addToItem.setVisible(false);
                clearReviewsItem.setVisible(false);
                lifeEventsMenuItem.setVisible(true);
                wrapperOptionsItem.setVisible(false);
            } else
            if (inWrapperFragment)
            {
                switchToListItem.setVisible(false);
                geoLocateItem.setVisible(false);
                searchMenuItem.setVisible(false);
                storeAvailability.setVisible(false);
                shareItem.setVisible(false);
                addToItem.setVisible(false);
                clearReviewsItem.setVisible(false);
                lifeEventsMenuItem.setVisible(false);
                wrapperOptionsItem.setVisible(true);
            } else
            {
                switchToListItem.setVisible(false);
                geoLocateItem.setVisible(false);
                storeAvailability.setVisible(false);
                shareItem.setVisible(false);
                MenuItem menuitem = searchMenuItem;
                if (isActionBarHidden())
                {
                    flag = false;
                }
                menuitem.setVisible(flag);
                addToItem.setVisible(false);
                clearReviewsItem.setVisible(false);
                lifeEventsMenuItem.setVisible(false);
                wrapperOptionsItem.setVisible(false);
            }
        } else
        {
            switchToListItem.setVisible(false);
            geoLocateItem.setVisible(false);
            switchToMap.setVisible(false);
            storeAvailability.setVisible(false);
            searchMenuItem.setVisible(false);
            shareItem.setVisible(false);
            addToItem.setVisible(false);
            clearReviewsItem.setVisible(false);
            lifeEventsMenuItem.setVisible(false);
            wrapperOptionsItem.setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    public void onResume()
    {
        super.onResume();
        lu.a(this);
        if (getIntent().getAction() != null && getIntent().getAction().equals("com.bestbuy.android.NOTIFICATION"))
        {
            showNotification(getIntent().getExtras());
        }
    }

    public void onStoreDetailsExit()
    {
    }

    public void onStoreDetailsLaunch()
    {
    }

    public void onStoresFramentExit()
    {
        inStoresFragment = false;
        if (switchToListItem != null)
        {
            switchToListItem.setVisible(false);
        }
        if (geoLocateItem != null)
        {
            geoLocateItem.setVisible(false);
        }
        if (searchView != null)
        {
            String s = getResources().getString(0x7f0802ef);
            searchView.setQueryHint(s);
        }
    }

    public void onStoresFramentLaunch()
    {
        inStoresFragment = true;
        if (switchToListItem != null)
        {
            switchToListItem.setVisible(true);
            String s;
            if (nb.a().b().getBoolean("IS_MAP_VIEW", false))
            {
                switchToListItem.setIcon(0x7f020107);
            } else
            {
                switchToListItem.setIcon(0x7f02010f);
            }
        }
        if (geoLocateItem != null)
        {
            geoLocateItem.setVisible(true);
        }
        if (searchView != null)
        {
            s = getResources().getString(0x7f080352);
            searchView.setQueryHint(s);
        }
    }

    public void onStoresListShown()
    {
        switchToListItem.setIcon(0x7f02010f);
        nb.a().b().edit().putBoolean("IS_MAP_VIEW", false).commit();
    }

    public void openLeftNavigation()
    {
        mDrawerLayout.openDrawer(3);
        mDrawerList.setSelection(0);
    }

    public void openPDP(String s, String s1, String s2, boolean flag, DNMProduct dnmproduct, boolean flag1, boolean flag2, 
            boolean flag3, String s3)
    {
        String s4 = getCurrentActionBarTitle();
        FragmentManager fragmentmanager = getSupportFragmentManager();
        Fragment fragment = fragmentmanager.findFragmentById(0x7f0c0033);
        if (flag)
        {
            s = new PDPFragment(dnmproduct.getSkuId(), dnmproduct.getProductId(), true, dnmproduct, flag1);
        } else
        {
            s = new PDPFragment(s, s2, flag1);
        }
        s2 = new Bundle();
        s2.putString("availability_storeid", s1);
        s.setArguments(s2);
        s.b(flag2);
        s.a(flag3, bbyProduct, pageName, s3);
        s1 = new PDPFragmentContainer(s4);
        if (fragment instanceof HomeTabFragment)
        {
            ((BaseTabContainer)((HomeTabFragment)fragment).e()).a(s1, true);
        } else
        {
            s2 = fragmentmanager.beginTransaction();
            s2.add(0x7f0c0033, s1, "PDPFragment");
            s2.addToBackStack(null);
            s2.commit();
        }
        s1.a(s, true);
    }

    public void openPDP(String s, String s1, String s2, boolean flag, boolean flag1)
    {
        isFromRecommendations = false;
        bbyProduct = null;
        pageName = "Life Events";
        openPDP(s, s1, s2, false, null, flag, flag1, false, "");
    }

    public void openPDP(String s, String s1, boolean flag)
    {
        isFromRecommendations = false;
        bbyProduct = null;
        pageName = "";
        openPDP(s, "", s1, false, null, flag, false, false, "");
    }

    public void openPDP(String s, String s1, boolean flag, boolean flag1, boolean flag2, String s2, BBYProduct bbyproduct)
    {
        isFromRecommendations = flag2;
        bbyProduct = bbyproduct;
        pageName = s2;
        openPDP(s, "", s1, false, null, flag, flag1, false, "");
    }

    public void openPDP(String s, boolean flag, String s1, boolean flag1, BBYProduct bbyproduct, String s2, String s3)
    {
        isFromRecommendations = flag1;
        bbyProduct = bbyproduct;
        pageName = s2;
        breadCrumb = s3;
        openPDP(s, "", s1, false, null, flag, false, flag1, s3);
    }

    public void popCurrentFragment()
    {
        FragmentManager fragmentmanager = getSupportFragmentManager();
        if (!(fragmentmanager.findFragmentById(0x7f0c0033) instanceof HomeTabFragment))
        {
            fragmentmanager.popBackStack();
        }
    }

    public void postOnTwitter(String s, boolean flag)
    {
        if (flag)
        {
            s = (new StringBuilder()).append(getResources().getString(0x7f08011c)).append(" ").append(fr.e()).append(" ").append(fr.f()).append(getResources().getString(0x7f08011e)).append(" ").append(s).toString();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.TEXT", s);
            intent.putExtra("android.intent.extra.SUBJECT", "A wish list has been shared with you");
            intent.setType("text/plain");
            startActivity(Intent.createChooser(intent, "Share WishList To..."));
            return;
        } else
        {
            s = (new StringBuilder()).append(getResources().getString(0x7f08011c)).append(" ").append(fr.e()).append(" ").append(fr.f()).append(getResources().getString(0x7f08011d)).append(" ").append(s).toString();
            Intent intent1 = new Intent("android.intent.action.SEND");
            intent1.putExtra("android.intent.extra.TEXT", s);
            intent1.putExtra("android.intent.extra.SUBJECT", "A wedding registry has been shared with you");
            intent1.setType("text/plain");
            startActivity(Intent.createChooser(intent1, "Share Registry To..."));
            return;
        }
    }

    public void recreateHomeScreen(boolean flag)
    {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("HomeTabFragment");
        if (fragment instanceof HomeTabFragment)
        {
            homeTabFragment = (HomeTabFragment)fragment;
            if (homeTabFragment != null)
            {
                if (homeTabFragment.e() instanceof HomeTabContainer)
                {
                    Fragment fragment1 = ((HomeTabContainer)homeTabFragment.e()).b();
                    if (fragment1 instanceof HomeFragment)
                    {
                        ((HomeFragment)fragment1).f();
                    }
                }
                if (flag)
                {
                    nb.a().b().edit().putInt(getResources().getString(0x7f080031), 0).commit();
                    homeTabFragment.c();
                }
            }
        }
    }

    public void refreshHomeCard()
    {
        Fragment fragment = getSupportFragmentManager().findFragmentByTag("HomeTabFragment");
        if (fragment instanceof HomeTabFragment)
        {
            homeTabFragment = (HomeTabFragment)fragment;
            if (homeTabFragment.e() instanceof HomeTabContainer)
            {
                Fragment fragment1 = ((HomeTabContainer)homeTabFragment.e()).b();
                if (fragment1 instanceof HomeFragment)
                {
                    fragment1 = (Fragment)((HomeFragment)fragment1).getChildFragmentManager().getFragments().get(0);
                    if (fragment1 != null)
                    {
                        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
                        fragmenttransaction.detach(fragment1);
                        fragmenttransaction.attach(fragment1);
                        fragmenttransaction.commitAllowingStateLoss();
                    }
                }
            }
        }
    }

    public void replaceFragment(int i, Fragment fragment, String s)
    {
        FragmentTransaction fragmenttransaction = getSupportFragmentManager().beginTransaction();
        fragmenttransaction.replace(i, fragment, s);
        fragmenttransaction.addToBackStack(s);
        fragmenttransaction.commit();
    }

    public void sendActivateLayout(RelativeLayout relativelayout)
    {
        activateBanner = relativelayout;
    }

    public void sendRecommendations(String s)
    {
        (new ht(this, recommendations, s)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void sendRecommendations(String s, String s1, BBYProduct bbyproduct)
    {
        (new ht(this, recommendations, s, s1, bbyproduct)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void sendRecommendations(String s, String s1, String s2)
    {
        (new ht(this, recommendations, s, s1, s2)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void sendRecommendations(String s, String s1, String s2, BBYProduct bbyproduct)
    {
        (new ht(this, recommendations, s, s1, s2, bbyproduct)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void setAddToVisible(boolean flag)
    {
label0:
        {
            if (addToItem != null)
            {
                if (!flag)
                {
                    break label0;
                }
                addToItem.setVisible(true);
            }
            return;
        }
        addToItem.setVisible(false);
    }

    public void setCheckedStatus()
    {
        boolean flag = nb.a().b().getBoolean("show_availability", false);
        if (!isGPSEnabled())
        {
            flag = false;
        }
        StateListDrawable statelistdrawable = (StateListDrawable)getResources().getDrawable(0x7f020014);
        int i;
        if (flag)
        {
            i = 0x10100a0;
        } else
        {
            i = 0x10100a9;
        }
        statelistdrawable.setState(new int[] {
            i
        });
        storeAvailability.setIcon(statelistdrawable.getCurrent());
        storeAvailability.setChecked(flag);
    }

    public void setClearVisible(boolean flag)
    {
label0:
        {
            if (clearReviewsItem != null)
            {
                if (!flag)
                {
                    break label0;
                }
                clearReviewsItem.setVisible(true);
            }
            return;
        }
        clearReviewsItem.setVisible(false);
    }

    public void setMyBBYSection(View view)
    {
        myBBYMenuItemView = view;
    }

    public void setNavigationModeForActivity()
    {
        getActionBar().setNavigationMode(0);
        getActionBar().setDisplayShowHomeEnabled(false);
        getActionBar().setDisplayShowTitleEnabled(false);
    }

    public void setOnActionIconClickListener(cf cf1)
    {
        actionIconClickListener = cf1;
    }

    public void setOnClearReviewsListener(cj cj1)
    {
        clearReviewsClickListener = cj1;
    }

    public void setOnDNMSearchListener(cd cd1)
    {
        onDNMSearchListener = cd1;
    }

    public void setOnLifeEventsTopNavigationListener(cg cg1, String s, boolean flag)
    {
        LinearLayout linearlayout;
label0:
        {
            if (lifeEventsMenuItem != null)
            {
                linearlayout = (LinearLayout)lifeEventsMenuItem.getActionView();
                if (!flag)
                {
                    break label0;
                }
                lifeEventsNavigationListener = cg1;
                if (((BBYTextView)linearlayout.findViewById(0x7f0c0150)).getVisibility() == 4 || ((BBYTextView)linearlayout.findViewById(0x7f0c0150)).getVisibility() == 8)
                {
                    ((BBYTextView)linearlayout.findViewById(0x7f0c0150)).setVisibility(0);
                }
                ((BBYTextView)linearlayout.findViewById(0x7f0c0150)).setText(s);
                lifeEventsMenuItemTitle = s;
                lifeEventsMenuItem.setVisible(flag);
            }
            return;
        }
        onCreateWishListFragmentExit();
        ((BBYTextView)linearlayout.findViewById(0x7f0c0150)).setVisibility(8);
    }

    public void setOnListIdSearchClickListener(ch ch)
    {
        searchIconClickListener = ch;
    }

    public void setOnStoreAvailabiltyClickListener(ci ci1)
    {
        storeAvailabiltyClickListener = ci1;
    }

    public void setSearchAndQueryVisible(boolean flag, String s)
    {
label0:
        {
            if (searchMenuItem != null)
            {
                if (!flag)
                {
                    break label0;
                }
                searchMenuItem.setVisible(true);
                query = s;
                isFromPLPFragment = true;
            }
            return;
        }
        searchMenuItem.setVisible(false);
    }

    public void setSearchVisible(boolean flag)
    {
label0:
        {
            if (searchMenuItem != null)
            {
                if (!flag)
                {
                    break label0;
                }
                searchMenuItem.setVisible(true);
            }
            return;
        }
        searchMenuItem.setVisible(false);
    }

    public void setShareURL(String s)
    {
        productShareURL = s;
    }

    public void setShareVisible(boolean flag)
    {
label0:
        {
            if (shareItem != null)
            {
                if (!flag)
                {
                    break label0;
                }
                shareItem.setVisible(true);
            }
            return;
        }
        shareItem.setVisible(false);
    }

    public void setStoreAvailabilityVisible(boolean flag)
    {
        if (storeAvailability != null)
        {
            storeAvailability.setVisible(flag);
        }
    }

    public void showErrorBanner(String s)
    {
        Object obj = new HashMap();
        ((HashMap) (obj)).put("bb.failedSearchTerm", s);
        ((HashMap) (obj)).put("bb.numResults", "zero");
        ((HashMap) (obj)).put(lu.bo, "browse,list,search,failed");
        ((HashMap) (obj)).put(lu.bp, "SRCL");
        lu.b(lu.d, ((HashMap) (obj)));
        obj = (LinearLayout)findViewById(0x7f0c0034);
        ((BBYTextView)findViewById(0x7f0c0131)).setText((new StringBuilder()).append("We couldn't find any matches for: \n \"").append(s).append("\"").toString());
        ((BBYTextView)findViewById(0x7f0c0132)).setText(Html.fromHtml(tipsString));
        ll.b(((View) (obj)));
    }

    public void showMyBBYData()
    {
        String s = fr.e();
        fr.h();
        ImageView imageview = (ImageView)myBBYMenuItemView.findViewById(0x7f0c0139);
        BBYTextView bbytextview = (BBYTextView)myBBYMenuItemView.findViewById(0x7f0c0137);
        if (s != null)
        {
            if (s.length() >= 20)
            {
                bbytextview.setText(s);
                bbytextview.setSingleLine();
                bbytextview.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
                bbytextview.getViewTreeObserver().addOnGlobalLayoutListener(new android.view.ViewTreeObserver.OnGlobalLayoutListener(bbytextview) {

                    final BBYTextView a;
                    final HomeActivity b;

                    public void onGlobalLayout()
                    {
                        a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        if (a.getLineCount() > 0)
                        {
                            int i = a.getLayout().getLineEnd(1);
                            String s1 = (new StringBuilder()).append(a.getText().subSequence(0, i - 10)).append("...").toString();
                            a.setText(s1);
                        }
                    }

            
            {
                b = HomeActivity.this;
                a = bbytextview;
                super();
            }
                });
            } else
            {
                bbytextview.setText(s);
                bbytextview.setSingleLine();
                bbytextview.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
            }
        }
        imageview.setImageResource(0x7f02012a);
        bbytextview.setText(s);
        if (bbytextview.length() > 20)
        {
            bbytextview.setSingleLine();
            bbytextview.setEllipsize(android.text.TextUtils.TruncateAt.MARQUEE);
        }
    }

    public void showNotification(Bundle bundle)
    {
label0:
        {
            if (bundle != null && bundle.containsKey("IS_CALLED_FROM_NOTIFICATION"))
            {
                isFromNotification = bundle.getBoolean("IS_CALLED_FROM_NOTIFICATION", false);
                Object obj = bundle.getString("TAB_NAME", "");
                Object obj1;
                MdotWebFragment mdotwebfragment;
                Bundle bundle1;
                if (bundle.containsKey(getResources().getString(0x7f080055)))
                {
                    bundle = bundle.getString(getResources().getString(0x7f080055));
                } else
                {
                    bundle = null;
                }
                mDrawerLayout.closeDrawers();
                if (isFromNotification)
                {
                    obj1 = getSupportFragmentManager();
                    Object obj2 = ((FragmentManager) (obj1)).findFragmentById(0x7f0c0033);
                    if (!(obj2 instanceof HomeTabFragment))
                    {
                        break label0;
                    }
                    if (((String) (obj)).equals("ProductTab"))
                    {
                        obj = ((HomeTabFragment)obj2).e();
                        obj1 = kb.a("MdotWebFragment");
                        obj2 = new Bundle();
                        ((Bundle) (obj2)).putString("mDotURL", bundle);
                        ((Bundle) (obj2)).putBoolean("IS_DOD", true);
                        ((Fragment) (obj1)).setArguments(((Bundle) (obj2)));
                        ((BaseTabContainer)obj).a(((Fragment) (obj1)), true);
                    } else
                    {
                        ((HomeTabFragment)obj2).a(2);
                    }
                    isFromNotification = false;
                }
            }
            return;
        }
        mdotwebfragment = new MdotWebFragment(true, true);
        bundle1 = new Bundle();
        bundle1.putString("mDotURL", bundle);
        if (((String) (obj)).equals("ProductTab"))
        {
            bundle1.putBoolean("IS_DOD", true);
        }
        mdotwebfragment.setArguments(bundle1);
        bundle = ((FragmentManager) (obj1)).beginTransaction();
        bundle.add(0x7f0c0033, mdotwebfragment, "MdotWebFragment");
        bundle.addToBackStack(null);
        bundle.commit();
        isFromNotification = false;
    }

    public void showPopup()
    {
        (new lj(this)).show();
    }

    public void showWishListData(ArrayList arraylist, String s)
    {
        int i;
        if (wishListData == null)
        {
            wishListData = new ArrayList();
        } else
        {
            wishListData.clear();
        }
        i = 0;
        while (i < arraylist.size()) 
        {
            RegistryWishList registrywishlist = (RegistryWishList)arraylist.get(i);
            if (!registrywishlist.getType().equals("weddingregistrylists"))
            {
                wishListData.add(registrywishlist);
            } else
            {
                registryData = registrywishlist;
            }
            i++;
        }
        Collections.sort(wishListData);
        if (s != null && (s == null || !s.equalsIgnoreCase("wishlist") || wishListData.size() <= 0) && (s == null || !s.equalsIgnoreCase("weddingregistry") || registryData == null)) goto _L2; else goto _L1
_L1:
        arraylist = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        s = PDPFragment.e();
        s.put("WishListData", wishListData);
        s.put("RegistryData", registryData);
        s.put("RegistryName", fr.k());
        if (s.get("WishListData") != null)
        {
            (new la(this, arraylist, s)).show();
        }
_L4:
        return;
_L2:
        if (!s.equalsIgnoreCase("wishlist"))
        {
            continue; /* Loop/switch isn't completed */
        }
        arraylist = new WishListFragmentContainer(true, nb.a().ab());
        s = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(s instanceof HomeTabFragment))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!(((HomeTabFragment)s).e() instanceof BaseTabContainer)) goto _L4; else goto _L3
_L3:
        addFragment(0x7f0c0033, arraylist, "WishListFragmentContainer");
        return;
        if (!(s instanceof PDPFragmentContainer)) goto _L4; else goto _L5
_L5:
        addFragment(0x7f0c0033, arraylist, "WishListFragmentContainer");
        return;
        if (!s.equalsIgnoreCase("weddingregistry")) goto _L4; else goto _L6
_L6:
        arraylist = new RegistryFragmentContainer(true, nb.a().ab());
        s = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(s instanceof HomeTabFragment))
        {
            continue; /* Loop/switch isn't completed */
        }
        if (!(((HomeTabFragment)s).e() instanceof HomeTabContainer)) goto _L4; else goto _L7
_L7:
        addFragment(0x7f0c0033, arraylist, "RegistryFragmentContainer");
        return;
        if (!(s instanceof PDPFragmentContainer)) goto _L4; else goto _L8
_L8:
        addFragment(0x7f0c0033, arraylist, "RegistryFragmentContainer");
        return;
    }

    public void updateActionBarTitle(String s)
    {
        if (actionBarTitle != null)
        {
            actionBarTitle.setText(s);
        }
    }

    public void updateSearchHint(String s)
    {
        searchView.setQueryHint(s);
    }



/*
    static boolean access$002(HomeActivity homeactivity, boolean flag)
    {
        homeactivity.isNavigationDrawerOpened = flag;
        return flag;
    }

*/








}
