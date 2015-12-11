// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.base;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.text.Html;
import android.view.View;
import android.widget.TextView;
import com.bestbuy.android.activities.askexpert.HelpMenuActivity;
import com.bestbuy.android.activities.browseproduct.BrowseCategoryFragment;
import com.bestbuy.android.activities.browseproduct.BrowseSuperSubCategoryFragment;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.cart.CartTabContainer;
import com.bestbuy.android.activities.dnm.DNMListFragment;
import com.bestbuy.android.activities.dnm.DNMListFragmentContainer;
import com.bestbuy.android.activities.dnm.DNMSearchFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeFragment;
import com.bestbuy.android.activities.home.HomeTabContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.activities.registry.EmptyWeddingRegistryContainer;
import com.bestbuy.android.activities.registry.RegistryFragmentContainer;
import com.bestbuy.android.activities.registry.WishListFragmentContainer;
import com.bestbuy.android.activities.stores.StoreSearchMapFragment;
import com.bestbuy.android.activities.stores.StoreTabContainer;
import com.google.android.gms.location.LocationRequest;
import com.inc247.ApplicationStatusModel.ChatRunningStatus;
import com.inc247.ChatSDK;
import java.util.ArrayList;
import java.util.Stack;
import lu;
import mf;
import nb;
import p;

// Referenced classes of package com.bestbuy.android.base:
//            BaseFragmentContainer, BBYApplication

public class BBYBaseFragmentActivity extends FragmentActivity
{

    public static int GC_SCAN_SUCCESS = 200;
    public static int MANUAL_ENTER = 100;
    public static int PRODUCT_SCAN = 300;
    public static final LocationRequest REQUEST = LocationRequest.a().a(10000L).b(1000L).a(100);
    private static String TAG = com/bestbuy/android/base/BBYBaseFragmentActivity.getSimpleName();
    public static BBYBaseFragmentActivity baseFragmentActivity;
    private String BACKGROUND;
    private String FOREGROUND;
    public nb appData;
    private boolean isActionBarHidden;

    public BBYBaseFragmentActivity()
    {
        BACKGROUND = "Background";
        FOREGROUND = "Foreground";
        isActionBarHidden = false;
    }

    private void enableAfterCheck(Fragment fragment, Fragment fragment1)
    {
        if (fragment1 instanceof PLPFragmentContainer)
        {
            fragment = ((PLPFragmentContainer)fragment1).b();
            if (fragment instanceof PLPFragment)
            {
                ((PLPFragment)fragment).b();
            }
        }
        if (fragment1 instanceof PDPFragmentContainer)
        {
            fragment = ((PDPFragmentContainer)fragment1).b();
            if (fragment instanceof PDPFragment)
            {
                ((PDPFragment)fragment).h();
            }
        } else
        {
            if (fragment1 instanceof BrowseSuperSubCategoryFragment)
            {
                ((BrowseSuperSubCategoryFragment)fragment1).c();
                return;
            }
            if (fragment1 instanceof BrowseCategoryFragment)
            {
                ((BrowseCategoryFragment)fragment1).c();
                return;
            }
            if (fragment1 instanceof HomeFragment)
            {
                ((HomeFragment)fragment1).b();
                return;
            }
        }
    }

    public void changeActionBarAddToVisibility(Activity activity, boolean flag)
    {
        if (activity instanceof HomeActivity)
        {
            ((HomeActivity)activity).setAddToVisible(flag);
        }
    }

    public void changeActionBarClearVisibility(Activity activity, boolean flag)
    {
        ((HomeActivity)activity).setClearVisible(flag);
    }

    public void changeActionBarSearchAndQueryVisibility(Activity activity, boolean flag, String s)
    {
        ((HomeActivity)activity).setSearchAndQueryVisible(flag, s);
    }

    public void changeActionBarSearchVisibility(Activity activity, boolean flag)
    {
        ((HomeActivity)activity).setSearchVisible(flag);
    }

    public void changeActionBarShareVisibility(Activity activity, boolean flag)
    {
        ((HomeActivity)activity).setShareVisible(flag);
    }

    public void disablePullDown()
    {
        Object obj = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (obj instanceof HomeTabFragment)
        {
            obj = (HomeTabFragment)obj;
            if (((HomeTabFragment) (obj)).b().getCurrentTab() == 0)
            {
                obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("HOME");
                if (obj instanceof HomeTabContainer)
                {
                    obj = ((HomeTabContainer)obj).b();
                    if (obj instanceof HomeFragment)
                    {
                        ((HomeFragment)obj).c();
                    }
                }
            }
        }
    }

    public String getCurrentActionBarTitle()
    {
        View view = getActionBar().getCustomView();
        if (view != null)
        {
            return ((TextView)view.findViewById(0x7f0c0059)).getText().toString();
        } else
        {
            return null;
        }
    }

    public void hideActionBarHome()
    {
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        getActionBar().setHomeButtonEnabled(false);
        View view = getActionBar().getCustomView();
        if (view != null)
        {
            isActionBarHidden = true;
            view.findViewById(0x7f0c0058).setVisibility(0);
            ((HomeActivity)this).changeSearchBarVisibility(false);
            view.findViewById(0x7f0c0059).setPadding(30, 0, 0, 0);
            ((TextView)view.findViewById(0x7f0c0059)).setGravity(3);
        }
    }

    public void hideActionBarHomeAndSearchBox(Activity activity)
    {
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        getActionBar().setHomeButtonEnabled(false);
        View view = getActionBar().getCustomView();
        if (view != null)
        {
            isActionBarHidden = true;
            view.findViewById(0x7f0c0058).setVisibility(0);
            ((HomeActivity)activity).changeSearchBarVisibility(true);
            view.findViewById(0x7f0c0059).setPadding(30, 0, 0, 0);
            ((TextView)view.findViewById(0x7f0c0059)).setGravity(3);
        }
    }

    public void hideStoresSearchActionBar(Activity activity)
    {
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        getActionBar().setHomeButtonEnabled(false);
        View view = getActionBar().getCustomView();
        if (view != null)
        {
            isActionBarHidden = true;
            view.findViewById(0x7f0c0058).setVisibility(0);
            ((HomeActivity)activity).changeStoresSearchVisibility(true);
            view.findViewById(0x7f0c0059).setPadding(30, 0, 0, 0);
            ((TextView)view.findViewById(0x7f0c0059)).setGravity(3);
        }
    }

    public boolean isActionBarHidden()
    {
        return isActionBarHidden;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        if (i != 4444) goto _L2; else goto _L1
_L1:
        Object obj = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(obj instanceof HomeTabFragment)) goto _L2; else goto _L3
_L3:
        obj = (HomeTabFragment)obj;
        if (((HomeTabFragment) (obj)).b().getCurrentTab() != 2) goto _L5; else goto _L4
_L4:
        obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("STORES");
        if (obj instanceof StoreTabContainer)
        {
            obj = ((StoreTabContainer)obj).b();
            if (obj instanceof DNMListFragmentContainer)
            {
                ((DNMListFragment)((DNMListFragmentContainer)obj).b()).onActivityResult(i, j, intent);
            }
        }
_L2:
        if (i != 1000) goto _L7; else goto _L6
_L6:
        obj = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (obj instanceof HomeTabFragment)
        {
            obj = (HomeTabFragment)obj;
            if (((HomeTabFragment) (obj)).b().getCurrentTab() == 2)
            {
                obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("STORES");
                if (obj instanceof StoreTabContainer)
                {
                    obj = ((StoreTabContainer)obj).b();
                    if (obj instanceof StoreSearchMapFragment)
                    {
                        ((StoreSearchMapFragment)obj).onActivityResult(i, j, intent);
                    }
                }
            }
        }
_L9:
        return;
_L5:
        if (((HomeTabFragment) (obj)).b().getCurrentTab() == 0)
        {
            obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("HOME");
            if (obj instanceof HomeTabContainer)
            {
                obj = ((HomeTabContainer)obj).b();
                if (obj instanceof DNMListFragmentContainer)
                {
                    ((DNMListFragment)((DNMListFragmentContainer)obj).b()).onActivityResult(i, j, intent);
                }
            }
        }
        continue; /* Loop/switch isn't completed */
_L7:
        if (i != 9999 && i != 5000)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(obj instanceof HomeTabFragment))
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = (HomeTabFragment)obj;
        if (((HomeTabFragment) (obj)).b().getCurrentTab() != 1)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("PRODUCTS");
        if (obj instanceof ProductTabContainer)
        {
            obj = ((ProductTabContainer)obj).b();
            if (obj instanceof PLPFragmentContainer)
            {
                obj = ((PLPFragmentContainer)obj).b();
                if (obj instanceof PLPFragment)
                {
                    ((PLPFragment)obj).onActivityResult(i, j, intent);
                    return;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
        if (((HomeTabFragment) (obj)).b().getCurrentTab() != 0) goto _L9; else goto _L8
_L8:
        obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("HOME");
        if (obj instanceof HomeTabContainer)
        {
            obj = ((HomeTabContainer)obj).b();
            if (obj instanceof DNMListFragmentContainer)
            {
                ((DNMListFragment)((DNMListFragmentContainer)obj).b()).onActivityResult(i, j, intent);
                return;
            }
            if (obj instanceof PLPFragmentContainer)
            {
                obj = ((PLPFragmentContainer)obj).b();
                if (obj instanceof PLPFragment)
                {
                    ((PLPFragment)obj).onActivityResult(i, j, intent);
                    return;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
        if (!(obj instanceof PLPFragmentContainer)) goto _L9; else goto _L10
_L10:
        obj = ((PLPFragmentContainer)obj).b();
        if (obj instanceof PLPFragment)
        {
            ((PLPFragment)obj).onActivityResult(i, j, intent);
            return;
        }
        if (true) goto _L9; else goto _L11
_L11:
        if (i != 3333)
        {
            break; /* Loop/switch isn't completed */
        }
        obj = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (obj instanceof HomeTabFragment)
        {
            obj = (HomeTabFragment)obj;
            if (((HomeTabFragment) (obj)).b().getCurrentTab() != 0)
            {
                continue; /* Loop/switch isn't completed */
            }
            obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("HOME");
            if (obj instanceof HomeTabContainer)
            {
                obj = ((HomeTabContainer)obj).b();
                if (obj instanceof DNMListFragmentContainer)
                {
                    ((DNMSearchFragment)((DNMListFragmentContainer)obj).b()).onActivityResult(i, j, intent);
                    return;
                }
            }
        }
        continue; /* Loop/switch isn't completed */
        if (((HomeTabFragment) (obj)).b().getCurrentTab() != 2) goto _L9; else goto _L12
_L12:
        obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("STORES");
        if (obj instanceof StoreTabContainer)
        {
            obj = ((StoreTabContainer)obj).b();
            if (obj instanceof StoreSearchMapFragment)
            {
                ((StoreSearchMapFragment)obj).onActivityResult(i, j, intent);
                return;
            }
        }
        if (true) goto _L9; else goto _L13
_L13:
        Fragment fragment;
        if (i == 1111)
        {
            ((HomeActivity)this).buildSideMenu();
            return;
        }
        if (i == 7890)
        {
            if (intent != null && intent.getExtras() != null && intent.getExtras().get("ACTION") != null)
            {
                fragment = ((HomeActivity)this).getSupportFragmentManager().findFragmentById(0x7f0c0033);
                obj = new MdotWebFragment(false);
                if (intent.getExtras().get("ACTION").equals("CREATE_ACCOUNT"))
                {
                    intent = new Bundle();
                    intent.putString("mDotURL", ((HomeActivity)this).getResources().getString(0x7f08014e));
                    ((MdotWebFragment) (obj)).setArguments(intent);
                } else
                if (intent.getExtras().get("ACTION").equals("FORGOT_PWD"))
                {
                    intent = new Bundle();
                    intent.putString("mDotURL", appData.k());
                    ((MdotWebFragment) (obj)).setArguments(intent);
                } else
                if (intent.getExtras().get("ACTION").equals("TERMS_OF_USE"))
                {
                    intent = new Bundle();
                    intent.putString("mDotURL", getResources().getString(0x7f08012f));
                    ((MdotWebFragment) (obj)).setArguments(intent);
                }
                if (!(fragment instanceof HomeTabFragment))
                {
                    continue; /* Loop/switch isn't completed */
                }
                intent = (HomeTabFragment)fragment;
                intent = intent.getChildFragmentManager().findFragmentByTag(intent.b().getCurrentTabTag());
                if (intent != null)
                {
                    if (intent instanceof HomeTabContainer)
                    {
                        ((HomeTabContainer)intent).a(((Fragment) (obj)), true);
                    }
                    if (intent instanceof ProductTabContainer)
                    {
                        ((ProductTabContainer)intent).a(((Fragment) (obj)), true);
                    }
                    if (intent instanceof StoreTabContainer)
                    {
                        ((StoreTabContainer)intent).a(((Fragment) (obj)), true);
                    }
                    if (intent instanceof CartTabContainer)
                    {
                        ((CartTabContainer)intent).a(((Fragment) (obj)), true);
                        return;
                    }
                }
            }
            continue; /* Loop/switch isn't completed */
        }
        break MISSING_BLOCK_LABEL_1044;
        if (!(fragment instanceof RegistryFragmentContainer)) goto _L9; else goto _L14
_L14:
        ((RegistryFragmentContainer)fragment).a(((Fragment) (obj)), true);
        return;
        if (i != 3456)
        {
            break; /* Loop/switch isn't completed */
        }
        if (intent != null && intent.getExtras() != null && intent.getExtras().get("ACTION") != null)
        {
            if (intent.getExtras().get("ACTION").equals("BROWSE_PRODUCTS"))
            {
                FragmentManager fragmentmanager = ((HomeActivity)this).getSupportFragmentManager();
                Object obj2 = (EmptyWeddingRegistryContainer)fragmentmanager.findFragmentByTag("EmptyWeddingRegistryContainer");
                Object obj1 = obj2;
                if (obj2 == null)
                {
                    obj1 = (WishListFragmentContainer)fragmentmanager.findFragmentByTag("WishListFragmentContainer");
                }
                obj2 = obj1;
                if (obj1 == null)
                {
                    obj2 = (RegistryFragmentContainer)fragmentmanager.findFragmentByTag("RegistryFragmentContainer");
                }
                if (obj2 instanceof BaseFragmentContainer)
                {
                    ((BaseFragmentContainer) (obj2)).a(new BrowseCategoryFragment(true), true);
                }
            }
            if (intent.getExtras().get("ACTION").equals("SEARCH_PRODUCTS"))
            {
                ((HomeActivity)this).instantiateSearch();
            }
            if (intent.getExtras().get("ACTION").equals("START_SCAN"))
            {
                (new mf()).a(this, "LIFE_EVENTS_PRODUCT_SCAN", "", intent.getExtras().getString("ListUid"), intent.getExtras().getString("ListType"));
            }
            if (!intent.getExtras().get("ACTION").equals("CLOSE"));
            if (intent.getExtras().get("ACTION").equals("SCAN_HISTORY"))
            {
                intent = intent.getExtras().getStringArrayList("skuList");
                if (intent != null && intent.size() > 0)
                {
                    intent = new PLPFragment(true, intent, "Scan History", true);
                    ((HomeActivity)this).addFragment(0x7f0c0033, intent, "PLPFragment");
                    return;
                }
            }
        }
        if (true) goto _L9; else goto _L15
_L15:
        (new mf()).a(i, j, intent, this);
        return;
        if (true) goto _L2; else goto _L16
_L16:
    }

    public void onCreate(Bundle bundle)
    {
        p.a(this);
        super.onCreate(bundle);
        appData = nb.a();
    }

    public void onDestroy()
    {
        p.d(this);
        super.onDestroy();
    }

    public void onPause()
    {
        p.g(this);
        super.onPause();
        lu.a();
        if (HelpMenuActivity.a)
        {
            stopService(new Intent(getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService));
        }
    }

    protected void onRestart()
    {
        super.onRestart();
        p.e(this);
    }

    public void onResume()
    {
        p.f(this);
        super.onResume();
        lu.a(this);
        baseFragmentActivity = this;
        String s = appData.A();
        if (!(this instanceof HelpMenuActivity) && (s.isEmpty() || s.equals(BACKGROUND)))
        {
            appData.c(FOREGROUND);
            String s1 = nb.a().b().getString("shake_your_device", "Off");
            if (s1 != null && !s1.equalsIgnoreCase("Off"))
            {
                BBYApplication.getInstance().registerSensor();
            }
        }
        if (ChatRunningStatus.getChatRunning())
        {
            ChatSDK.getSDKInstance().addChat(this);
        }
        if (HelpMenuActivity.a)
        {
            startService(new Intent(getApplicationContext(), com/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService));
        }
    }

    public void onStart()
    {
        p.b(this);
        super.onStart();
    }

    protected void onStop()
    {
        p.c(this);
        super.onStop();
    }

    public void onUserLeaveHint()
    {
        super.onUserLeaveHint();
        if (appData.A().equals(FOREGROUND))
        {
            appData.c(BACKGROUND);
            BBYApplication.getInstance().unRegisterSensor();
        }
    }

    public void reEnablePullDown()
    {
        Fragment fragment = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(fragment instanceof HomeTabFragment)) goto _L2; else goto _L1
_L1:
        Object obj = (HomeTabFragment)fragment;
        if (((HomeTabFragment) (obj)).b().getCurrentTab() != 1) goto _L4; else goto _L3
_L3:
        obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("PRODUCTS");
        if (obj instanceof ProductTabContainer)
        {
            enableAfterCheck(fragment, ((ProductTabContainer)obj).b());
        }
_L6:
        return;
_L4:
        if (((HomeTabFragment) (obj)).b().getCurrentTab() != 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("HOME");
        if (obj instanceof HomeTabContainer)
        {
            enableAfterCheck(fragment, ((HomeTabContainer)obj).b());
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (((HomeTabFragment) (obj)).b().getCurrentTab() != 2) goto _L6; else goto _L5
_L5:
        obj = ((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag("STORES");
        if (obj instanceof StoreTabContainer)
        {
            enableAfterCheck(fragment, ((StoreTabContainer)obj).b());
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (!(fragment instanceof PLPFragmentContainer))
        {
            break; /* Loop/switch isn't completed */
        }
        fragment = ((PLPFragmentContainer)fragment).b();
        if (fragment instanceof PLPFragment)
        {
            ((PLPFragment)fragment).b();
            return;
        }
        if (true) goto _L6; else goto _L7
_L7:
        if (!(fragment instanceof PDPFragmentContainer))
        {
            break; /* Loop/switch isn't completed */
        }
        fragment = ((PDPFragmentContainer)fragment).b();
        if (fragment instanceof PDPFragment)
        {
            ((PDPFragment)fragment).h();
            return;
        }
        if (true) goto _L6; else goto _L8
_L8:
        if (!(fragment instanceof EmptyWeddingRegistryContainer))
        {
            continue; /* Loop/switch isn't completed */
        }
        fragment = ((EmptyWeddingRegistryContainer)fragment).b();
        if (fragment instanceof PLPFragment)
        {
            ((PLPFragment)fragment).b();
            return;
        }
        if (fragment instanceof BrowseCategoryFragment)
        {
            ((BrowseCategoryFragment)fragment).c();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (!(fragment instanceof BaseFragmentContainer)) goto _L6; else goto _L9
_L9:
        fragment = ((BaseFragmentContainer)fragment).b();
        if (fragment instanceof PLPFragment)
        {
            ((PLPFragment)fragment).b();
            return;
        }
        if (fragment instanceof BrowseCategoryFragment)
        {
            ((BrowseCategoryFragment)fragment).c();
            return;
        }
        if (fragment instanceof BrowseSuperSubCategoryFragment)
        {
            ((BrowseSuperSubCategoryFragment)fragment).c();
            return;
        }
        if (true) goto _L6; else goto _L10
_L10:
    }

    public void setContentView(int i)
    {
        super.setContentView(i);
    }

    public void showActionBarHome()
    {
        getActionBar().setDisplayShowHomeEnabled(true);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        isActionBarHidden = false;
        if (!(this instanceof HomeActivity)) goto _L2; else goto _L1
_L1:
        Object obj;
        ((HomeActivity)this).changeSearchBarVisibility(false);
        obj = getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(obj instanceof HomeTabFragment)) goto _L4; else goto _L3
_L3:
        obj = (HomeTabFragment)obj;
        if (((HomeTabFragment) (obj)).b() == null || ((HomeTabFragment) (obj)).b().getCurrentTab() != 2 || !HomeActivity.inStoresFragment) goto _L6; else goto _L5
_L5:
        ((HomeActivity)this).changeStoresSearchVisibility(false);
_L4:
        ((HomeActivity)this).setShareVisible(false);
        ((HomeActivity)this).setAddToVisible(false);
_L2:
        obj = getActionBar().getCustomView();
        if (obj != null)
        {
            ((View) (obj)).findViewById(0x7f0c0058).setVisibility(8);
            ((View) (obj)).findViewById(0x7f0c0059).setPadding(30, 0, 0, 0);
            ((TextView)((View) (obj)).findViewById(0x7f0c0059)).setGravity(3);
        }
        return;
_L6:
        if (((HomeTabFragment) (obj)).b() != null && ((HomeTabFragment) (obj)).b().getCurrentTab() == 0)
        {
            appData.U().clear();
            appData.U().push("Home");
            ((HomeActivity)this).updateActionBarTitle((String)appData.U().peek());
        }
        if (true) goto _L4; else goto _L7
_L7:
    }

    public void showSearchBarWithBackButton()
    {
        getActionBar().setDisplayShowHomeEnabled(false);
        getActionBar().setDisplayHomeAsUpEnabled(false);
        getActionBar().setHomeButtonEnabled(false);
        isActionBarHidden = false;
        if (this instanceof HomeActivity)
        {
            ((HomeActivity)this).changeSearchBarVisibility(true);
            getSupportFragmentManager().findFragmentById(0x7f0c0033);
            ((HomeActivity)this).setShareVisible(false);
            ((HomeActivity)this).setAddToVisible(false);
        }
        View view = getActionBar().getCustomView();
        if (view != null)
        {
            view.findViewById(0x7f0c0058).setVisibility(0);
            view.findViewById(0x7f0c0059).setPadding(30, 0, 0, 0);
            ((TextView)view.findViewById(0x7f0c0059)).setGravity(3);
        }
    }

    public void updateActionBarTitle(String s)
    {
        View view = getActionBar().getCustomView();
        if (view != null && s != null)
        {
            ((TextView)view.findViewById(0x7f0c0059)).setText(s);
        }
    }

    public void updateActionBarTitleAndSubTitle(String s, String s1)
    {
        View view = getActionBar().getCustomView();
        if (s != null && s.length() > 0)
        {
            ((TextView)view.findViewById(0x7f0c0059)).setSingleLine(false);
            ((TextView)view.findViewById(0x7f0c0059)).setMaxLines(2);
            ((TextView)view.findViewById(0x7f0c0059)).setText(Html.fromHtml((new StringBuilder()).append("<small>").append(s).append("<br/>").append(s1).append("</small>").toString()));
        }
    }

    public void updateOverviewActionBarTitle(String s, int i)
    {
        View view = getActionBar().getCustomView();
        if (s != null && s.length() > 0)
        {
            ((TextView)view.findViewById(0x7f0c0059)).setEms(i);
            ((TextView)view.findViewById(0x7f0c0059)).setText(s);
        }
    }

}
