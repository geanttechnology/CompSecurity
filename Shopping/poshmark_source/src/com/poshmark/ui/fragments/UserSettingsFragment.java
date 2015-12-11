// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.poshmark.analytics.Analytics;
import com.poshmark.application.PMApplicationSession;
import com.poshmark.config.Env;
import com.poshmark.config.EnvConfig;
import com.poshmark.http.api.PMApi;
import com.poshmark.notifications.PMNotificationManager;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            PMFragment, MappPageFragment, ShareFragment, FindPeopleFragment, 
//            ClosetFragment, MyLikesFragment, EditProfileFormFragment, MySizeFragment, 
//            SharingSettingsFragment, AboutFragment

public class UserSettingsFragment extends PMFragment
{
    class SettingsButtonInfo
    {

        public Bundle fragmentData;
        public Class fragmentToLaunch;
        final UserSettingsFragment this$0;
        public String trackingLabel;

        SettingsButtonInfo()
        {
            this$0 = UserSettingsFragment.this;
            super();
            fragmentData = new Bundle();
        }
    }


    Button aboutButton;
    Button commandsButton;
    Button earnCashButton;
    Button faqButton;
    Button findPeopleButton;
    Button guideToPoshmarkButton;
    android.view.View.OnClickListener listener;
    Button logoutButton;
    Button myAddressButton;
    Button myBalanceButton;
    Button myClosetButton;
    Button myClosetStatsButton;
    Button myLikesButton;
    Button myProfileButton;
    Button myPurchasesButton;
    Button mySalesButton;
    Button mySellerDiscountButton;
    Button mySizeButton;
    Button notificationsButton;
    Button poshEtiquetteButton;
    Button sharingSettingsButton;
    Button supportCenterButton;

    public UserSettingsFragment()
    {
        listener = new android.view.View.OnClickListener() {

            final UserSettingsFragment this$0;

            public void onClick(View view)
            {
                view = (SettingsButtonInfo)view.getTag();
                if (view != null)
                {
                    launchUrl(view);
                }
            }

            
            {
                this$0 = UserSettingsFragment.this;
                super();
            }
        };
    }

    private void launchUrl(SettingsButtonInfo settingsbuttoninfo)
    {
        ((PMActivity)getActivity()).launchFragmentInNewActivity(settingsbuttoninfo.fragmentData, settingsbuttoninfo.fragmentToLaunch, null);
        if (settingsbuttoninfo.trackingLabel != null)
        {
            Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", settingsbuttoninfo.trackingLabel, null);
        }
    }

    private void setupButtons()
    {
        SettingsButtonInfo settingsbuttoninfo = new SettingsButtonInfo();
        guideToPoshmarkButton = (Button)getView().findViewById(0x7f0c02f9);
        guideToPoshmarkButton.setText(getString(0x7f0602d2));
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", "https://www.poshmark.com/mapp/posh_guide");
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "posh_guide_screen");
        guideToPoshmarkButton.setTag(settingsbuttoninfo);
        guideToPoshmarkButton.setOnClickListener(listener);
        poshEtiquetteButton = (Button)getView().findViewById(0x7f0c02fa);
        poshEtiquetteButton.setText(getString(0x7f06020d));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", "https://www.poshmark.com/mapp/posh_etiquette");
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "posh_etiquette_screen");
        poshEtiquetteButton.setTag(settingsbuttoninfo);
        poshEtiquetteButton.setOnClickListener(listener);
        earnCashButton = (Button)getView().findViewById(0x7f0c02fb);
        earnCashButton.setText(getString(0x7f060158));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/ShareFragment;
        settingsbuttoninfo.fragmentData.putString("MODE", com.poshmark.utils.ShareManager_Old.SHARE_MODE.SHARE_MODE_INVITE_FRIENDS.name());
        earnCashButton.setTag(settingsbuttoninfo);
        earnCashButton.setOnClickListener(listener);
        findPeopleButton = (Button)getView().findViewById(0x7f0c003a);
        findPeopleButton.setText(getString(0x7f060129));
        findPeopleButton.setOnClickListener(listener);
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/FindPeopleFragment;
        findPeopleButton.setTag(settingsbuttoninfo);
        findPeopleButton.setOnClickListener(listener);
        myClosetButton = (Button)getView().findViewById(0x7f0c02fc);
        myClosetButton.setText(getString(0x7f0601af));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/ClosetFragment;
        settingsbuttoninfo.fragmentData.putString("NAME", PMApplicationSession.GetPMSession().getDisplayHandle());
        myClosetButton.setTag(settingsbuttoninfo);
        myClosetButton.setOnClickListener(listener);
        myLikesButton = (Button)getView().findViewById(0x7f0c02cb);
        myLikesButton.setText(getString(0x7f0601b2));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MyLikesFragment;
        settingsbuttoninfo.fragmentData.putBoolean("callFromUserSettings", true);
        myLikesButton.setTag(settingsbuttoninfo);
        myLikesButton.setOnClickListener(listener);
        myProfileButton = (Button)getView().findViewById(0x7f0c02fd);
        myProfileButton.setText(getString(0x7f0601b5));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/EditProfileFormFragment;
        settingsbuttoninfo.fragmentData.putInt("MODE", EditProfileFormFragment.PROFILE_MODE.PROFILE_MODE_EDIT.ordinal());
        myProfileButton.setTag(settingsbuttoninfo);
        myProfileButton.setOnClickListener(listener);
        mySizeButton = (Button)getView().findViewById(0x7f0c02fe);
        mySizeButton.setText(getString(0x7f0601ba));
        mySizeButton.setOnClickListener(listener);
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MySizeFragment;
        settingsbuttoninfo.fragmentData = null;
        mySizeButton.setTag(settingsbuttoninfo);
        myPurchasesButton = (Button)getView().findViewById(0x7f0c0300);
        myPurchasesButton.setText(getString(0x7f0601b6));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/purchases").toString());
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "items_bought_screen");
        myPurchasesButton.setTag(settingsbuttoninfo);
        myPurchasesButton.setOnClickListener(listener);
        mySalesButton = (Button)getView().findViewById(0x7f0c0301);
        mySalesButton.setText(getString(0x7f0601b7));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/sales").toString());
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "items_sold_screen");
        mySalesButton.setTag(settingsbuttoninfo);
        mySalesButton.setOnClickListener(listener);
        myBalanceButton = (Button)getView().findViewById(0x7f0c0302);
        myBalanceButton.setText(getString(0x7f0601ad));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/account_list").append("?pageName=USER_ACCOUNT-account_list").toString());
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "account_balances_screen");
        settingsbuttoninfo.trackingLabel = "account_balance_row_tapped";
        myBalanceButton.setTag(settingsbuttoninfo);
        myBalanceButton.setOnClickListener(listener);
        myClosetStatsButton = (Button)getView().findViewById(0x7f0c0304);
        myClosetStatsButton.setText(getString(0x7f0601b0));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/closet_stats").toString());
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "my_selling_tools");
        myClosetStatsButton.setTag(settingsbuttoninfo);
        myClosetStatsButton.setOnClickListener(listener);
        mySellerDiscountButton = (Button)getView().findViewById(0x7f0c0303);
        mySellerDiscountButton.setText(getString(0x7f0601b8));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/seller_tools/seller_discounts").toString());
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "my_selling_tools");
        mySellerDiscountButton.setTag(settingsbuttoninfo);
        mySellerDiscountButton.setOnClickListener(listener);
        myAddressButton = (Button)getView().findViewById(0x7f0c02ff);
        myAddressButton.setText(getString(0x7f0601ac));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/address/address_book").append("?pageType=new&pageName=ADDRESS_BOOK").toString());
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "my_address_screen");
        myAddressButton.setTag(settingsbuttoninfo);
        myAddressButton.setOnClickListener(listener);
        sharingSettingsButton = (Button)getView().findViewById(0x7f0c0305);
        sharingSettingsButton.setText(getString(0x7f06025e));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/SharingSettingsFragment;
        sharingSettingsButton.setTag(settingsbuttoninfo);
        sharingSettingsButton.setOnClickListener(listener);
        notificationsButton = (Button)getView().findViewById(0x7f0c0306);
        notificationsButton.setText(getString(0x7f0601d5));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/notification_settings").toString());
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "notification_settings_screen");
        notificationsButton.setTag(settingsbuttoninfo);
        notificationsButton.setOnClickListener(listener);
        logoutButton = (Button)getView().findViewById(0x7f0c0307);
        logoutButton.setText(getString(0x7f060199));
        logoutButton.setOnClickListener(new android.view.View.OnClickListener() {

            final UserSettingsFragment this$0;

            public void onClick(View view)
            {
                PMApi.logout(null);
                PMNotificationManager.fireNotification("com.poshmark.intents.INITIATE_LOGOUT");
            }

            
            {
                this$0 = UserSettingsFragment.this;
                super();
            }
        });
        supportCenterButton = (Button)getView().findViewById(0x7f0c0308);
        supportCenterButton.setText(getString(0x7f060215));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", "https://www.poshmark.com/mapp/support_center");
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "support_center_screen");
        supportCenterButton.setTag(settingsbuttoninfo);
        supportCenterButton.setOnClickListener(listener);
        faqButton = (Button)getView().findViewById(0x7f0c0309);
        faqButton.setText(getString(0x7f060137));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
        settingsbuttoninfo.fragmentData.putString("URL", "https://www.poshmark.com/mapp/faqs");
        settingsbuttoninfo.fragmentData.putString("ANALYTICS_PAGE_NAME", "faqs_screen");
        faqButton.setTag(settingsbuttoninfo);
        faqButton.setOnClickListener(listener);
        aboutButton = (Button)getView().findViewById(0x7f0c0217);
        aboutButton.setText(getString(0x7f06002c));
        settingsbuttoninfo = new SettingsButtonInfo();
        settingsbuttoninfo.fragmentToLaunch = com/poshmark/ui/fragments/AboutFragment;
        settingsbuttoninfo.fragmentData = null;
        aboutButton.setTag(settingsbuttoninfo);
        aboutButton.setOnClickListener(listener);
        commandsButton = (Button)getView().findViewById(0x7f0c030a);
        if (EnvConfig.ENV != Env.RC && EnvConfig.ENV != Env.PRODUCTION)
        {
            commandsButton.setText(getString(0x7f06008c));
            SettingsButtonInfo settingsbuttoninfo1 = new SettingsButtonInfo();
            settingsbuttoninfo1.fragmentToLaunch = com/poshmark/ui/fragments/MappPageFragment;
            settingsbuttoninfo1.fragmentData.putString("URL", "https://www.poshmark.com/mapp/test/webcommands");
            settingsbuttoninfo1.fragmentData.putString("ANALYTICS_PAGE_NAME", "webcommand_webview_screen");
            commandsButton.setTag(settingsbuttoninfo1);
            commandsButton.setOnClickListener(listener);
            return;
        } else
        {
            commandsButton.setVisibility(8);
            return;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        return layoutinflater.inflate(0x7f0300cc, viewgroup, false);
    }

    public void onPMResume()
    {
        super.onPMResume();
        setupButtons();
    }

    public void setViewNameForAnalytics()
    {
        viewNameForAnalytics = "settings_screen";
    }

    public void setupActionBar()
    {
        super.setupActionBar();
        if (PMApplicationSession.GetPMSession().isLoggedIn())
        {
            setTitle((new StringBuilder()).append("@").append(PMApplicationSession.GetPMSession().getUserName()).toString());
            setCutomRightImageButton(getActivity().getResources().getDrawable(0x7f0200f0), new android.view.View.OnClickListener() {

                final UserSettingsFragment this$0;

                public void onClick(View view)
                {
                    Analytics.getInstance().trackEvent(viewNameForAnalytics, "user", "account_balance_button_tapped", null);
                    view = new Bundle();
                    view.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/users/").append(PMApplicationSession.GetPMSession().getUserId()).append("/account_list").append("?pageName=USER_ACCOUNT-account_list").toString());
                    view.putString("ANALYTICS_PAGE_NAME", "account_balances_screen");
                    ((PMActivity)getActivity()).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/MappPageFragment, null);
                }

            
            {
                this$0 = UserSettingsFragment.this;
                super();
            }
            });
            return;
        } else
        {
            setTitle(0x7f06024d);
            return;
        }
    }

}
