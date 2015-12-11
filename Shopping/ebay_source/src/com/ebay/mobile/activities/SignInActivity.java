// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.ebay.common.TabsAdapter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.dcs.DcsHelper;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, SignInFragment, RegisterFragment

public class SignInActivity extends BaseActivity
    implements android.widget.TabHost.OnTabChangeListener, com.ebay.common.TabsAdapter.TabsAdapterGetter, RegisterFragment.OnRegisterListener
{

    private static final int DEFAULT_TAB_MODE = 0;
    public static final String EXTRA_CLIENT_INT = "client_int";
    public static final String EXTRA_FROM_HOME = "fromHome";
    public static final String EXTRA_PREV_USERNAME = "prevUser";
    public static final String EXTRA_REDIRECT_INTENTS = "redirect_intents";
    public static final String EXTRA_TAB_MODE = "ebayTabMode";
    public static final String EXTRA_USER = "user";
    public static final int TAB_MODE_REGISTER = 1;
    public static final int TAB_MODE_SIGN_IN = 0;
    private static final String TAB_TAG_REGISTER = "ebayTabRegister";
    private static final String TAB_TAG_SIGN_IN = "ebayTabSignIn";
    private TabsAdapter adapter;
    boolean canShowDialog;
    private TabHost tabHost;
    private int tabMode;

    public SignInActivity()
    {
        canShowDialog = true;
    }

    private void addTab(int i, String s, Class class1)
    {
        View view = ((LayoutInflater)getSystemService("layout_inflater")).inflate(0x7f030268, tabHost.getTabWidget(), false);
        ((TextView)view.findViewById(0x7f10005f)).setText(i);
        adapter.addTab(tabHost.newTabSpec(s).setIndicator(view), class1, getIntent().getExtras());
    }

    public static String regUrlFromHome()
    {
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        String s1 = dcshelper.ppaRegistrationUrl();
        String s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = dcshelper.fpaRegistrationUrl();
        }
        return s;
    }

    public TabsAdapter getTabsAdaptor()
    {
        return adapter;
    }

    public String getTrackingEventName()
    {
        return "SignInEntry";
    }

    public void onBackPressed()
    {
        TrackingData trackingdata = new TrackingData("SignInExit", TrackingType.EVENT);
        trackingdata.addKeyValuePair("isBack", "1");
        trackingdata.send(this);
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030269);
        tabMode = getIntent().getIntExtra("ebayTabMode", 0);
        tabHost = (TabHost)findViewById(0x1020012);
        tabHost.setup();
        tabHost.getTabWidget().setStripEnabled(false);
        bundle = (ViewPager)findViewById(0x7f10055a);
        adapter = new TabsAdapter(this, tabHost, bundle);
        addTab(0x7f070ac8, "ebayTabSignIn", com/ebay/mobile/activities/SignInFragment);
        addTab(0x7f070909, "ebayTabRegister", com/ebay/mobile/activities/RegisterFragment);
        adapter.startListening(tabMode);
    }

    protected void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        setIntent(intent);
        ((SignInFragment)adapter.getItem(0)).onNewIntent(intent);
        tabHost.setCurrentTab(0);
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        super.onPrepareOptionsMenu(menu);
        for (int i = 0; i < menu.size(); i++)
        {
            MenuItem menuitem = menu.getItem(i);
            menuitem.setEnabled(false);
            menuitem.setVisible(false);
        }

        return true;
    }

    public void onRegister(String s)
    {
        tabMode = 0;
        adapter.startListening(tabMode);
        SignInFragment signinfragment = (SignInFragment)adapter.getItem(tabMode);
        if (signinfragment != null)
        {
            signinfragment.setUsername(s);
        }
    }

    protected void onResume()
    {
        super.onResume();
        canShowDialog = true;
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).addSourceIdentification(getIntent()).send(this);
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        canShowDialog = false;
    }

    public void onTabChanged(String s)
    {
        if (!"ebayTabSignIn".equals(s)) goto _L2; else goto _L1
_L1:
        setTitle(0x7f070ab9);
_L4:
        s = findViewById(0x7f100548);
        if (s != null)
        {
            s.requestFocus();
        }
        return;
_L2:
        if ("ebayTabRegister".equals(s))
        {
            setTitle(0x7f070903);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void showTabs(boolean flag)
    {
        TabHost tabhost = tabHost;
        int i;
        if (flag)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        tabhost.setVisibility(i);
    }
}
