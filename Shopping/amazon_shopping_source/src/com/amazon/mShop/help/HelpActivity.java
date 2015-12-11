// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.help;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.appstore.AppstoreUtils;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.navigation.AppNavigator;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.util.MenuUtil;

public class HelpActivity extends AmazonActivity
{

    private final UserListener mUserListener = new UserListener() {

        final HelpActivity this$0;

        public void userSignedIn(User user)
        {
            setPrimeInstantVideoPageContentVisibility(getCurrentView());
        }

        public void userSignedOut()
        {
        }

        public void userUpdated(User user)
        {
            setPrimeInstantVideoPageContentVisibility(getCurrentView());
        }

            
            {
                this$0 = HelpActivity.this;
                super();
            }
    };

    public HelpActivity()
    {
    }

    private View getAIVHelpView()
    {
        return View.inflate(this, com.amazon.mShop.android.lib.R.layout.help_amazon_instant_video, null);
    }

    private View getContactUsView()
    {
        View view = View.inflate(this, com.amazon.mShop.android.lib.R.layout.contact_us_root, null);
        Button button = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.help_provide_app_feadback_button);
        button.setText((new StringBuilder()).append(getResources().getString(com.amazon.mShop.android.lib.R.string.help_contact_us_feedback_header)).append("\n\n").append(getResources().getString(com.amazon.mShop.android.lib.R.string.more_provide_feedback_button)).toString());
        button.setOnClickListener(new android.view.View.OnClickListener() {

            final HelpActivity this$0;

            public void onClick(View view1)
            {
                RefMarkerObserver.logRefMarker("mr_app_fbk");
                MenuUtil.provideFeedBack(HelpActivity.this);
            }

            
            {
                this$0 = HelpActivity.this;
                super();
            }
        });
        return view;
    }

    private View getRootView()
    {
        setTitle(com.amazon.mShop.android.lib.R.string.help_and_about_title);
        setStopBehavior(0);
        View view = View.inflate(this, com.amazon.mShop.android.lib.R.layout.help_root, null);
        Button button = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.help_root_using_amazon_remembers_button);
        Button button1 = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.help_using_amazon_remembers_help_with_barcode_scans_button);
        Button button2 = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.help_root_your_account_and_settings_button);
        Button button3 = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.help_root_your_account_and_settings_button_no_prime);
        Button button4 = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.help_root_shipping_and_delivery_button);
        Button button5 = (Button)view.findViewById(com.amazon.mShop.android.lib.R.id.help_root_shipping_and_delivery_button_no_free_super_saver_shipping);
        LinearLayout linearlayout = (LinearLayout)view.findViewById(com.amazon.mShop.android.lib.R.id.help_fba_group);
        LinearLayout linearlayout1 = (LinearLayout)view.findViewById(com.amazon.mShop.android.lib.R.id.help_atoz_guarantee_group);
        LinearLayout linearlayout2 = (LinearLayout)view.findViewById(com.amazon.mShop.android.lib.R.id.help_more_amazon_apps_group);
        LinearLayout linearlayout3 = (LinearLayout)view.findViewById(com.amazon.mShop.android.lib.R.id.help_aiv_group);
        LinearLayout linearlayout4 = (LinearLayout)view.findViewById(com.amazon.mShop.android.lib.R.id.help_appstore_group);
        if (ConfigUtils.isEnabled(this, com.amazon.mShop.android.lib.R.string.config_hasRemembers))
        {
            button.setVisibility(0);
            button1.setVisibility(8);
        } else
        {
            button.setVisibility(8);
            button1.setVisibility(0);
        }
        if (ConfigUtils.isEnabled(this, com.amazon.mShop.android.lib.R.string.config_hasPrime))
        {
            button2.setVisibility(0);
            button3.setVisibility(8);
        } else
        {
            button3.setVisibility(0);
            button2.setVisibility(8);
        }
        if (ConfigUtils.isEnabled(this, com.amazon.mShop.android.lib.R.string.config_hasHelpOnFreeSuperSaverShipping))
        {
            button4.setVisibility(0);
            button5.setVisibility(8);
        } else
        {
            button4.setVisibility(8);
            button5.setVisibility(0);
        }
        if (ConfigUtils.isEnabled(this, com.amazon.mShop.android.lib.R.string.config_hasHelpOnFBA))
        {
            linearlayout.setVisibility(0);
        } else
        {
            linearlayout.setVisibility(8);
        }
        if (ConfigUtils.isEnabled(this, com.amazon.mShop.android.lib.R.string.config_hasHelpOnAtoZGuarantee))
        {
            linearlayout1.setVisibility(0);
        } else
        {
            linearlayout1.setVisibility(8);
        }
        if (ConfigUtils.isEnabled(this, com.amazon.mShop.android.lib.R.string.config_hasMoreAmazonAppsMenu))
        {
            linearlayout2.setVisibility(0);
        } else
        {
            linearlayout2.setVisibility(8);
        }
        if (AIVAvailabilityUtils.isAIVAvailable())
        {
            linearlayout3.setVisibility(0);
        } else
        {
            linearlayout3.setVisibility(8);
        }
        if (AppstoreUtils.isAppstoreAvailable())
        {
            linearlayout4.setVisibility(0);
        } else
        {
            linearlayout4.setVisibility(8);
        }
        ((Button)view.findViewById(com.amazon.mShop.android.lib.R.id.help_root_contacting_us_button)).setOnClickListener(new android.view.View.OnClickListener() {

            final HelpActivity this$0;

            public void onClick(View view1)
            {
                ActivityUtils.startContactUsActivity(HelpActivity.this);
            }

            
            {
                this$0 = HelpActivity.this;
                super();
            }
        });
        return view;
    }

    private void navigateToView()
    {
        String s = getIntent().getStringExtra("source");
        if ("aiv_help".equals(s))
        {
            setRootView(getAIVHelpView());
            getGNODrawer().focusOn("mshop:aiv");
            return;
        }
        if ("menu_contact_us".equals(s))
        {
            setRootView(getContactUsView());
            return;
        } else
        {
            setRootView(getRootView());
            return;
        }
    }

    private void setPrimeInstantVideoPageContentVisibility(View view)
    {
        if (com.amazon.mShop.android.lib.R.id.help_aiv_prime_instant_video == view.getId())
        {
            User user = User.getUser();
            if (user != null && !user.isPrimeEligible())
            {
                view.findViewById(com.amazon.mShop.android.lib.R.id.help_aiv_prime_instant_video_button).setVisibility(8);
                view.findViewById(com.amazon.mShop.android.lib.R.id.help_aiv_not_prime_member).setVisibility(8);
            }
        }
    }

    public void aivGoldButtonsOnClick(View view)
    {
        int i = view.getId();
        if (com.amazon.mShop.android.lib.R.id.help_aiv_prime_instant_video_button == i)
        {
            AppNavigator.navigate(this, com.amazon.mShop.navigation.AppNavigator.Target.prime_upsell, null);
        } else
        {
            if (com.amazon.mShop.android.lib.R.id.help_aiv_your_watchlist_button == i)
            {
                AppNavigator.navigate(this, com.amazon.mShop.navigation.AppNavigator.Target.aiv_webview, Maps.of("url", getResources().getString(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_wl_url), "forceClearHistory", Boolean.valueOf(false)));
                return;
            }
            if (com.amazon.mShop.android.lib.R.id.help_aiv_your_video_library_button == i)
            {
                AppNavigator.navigate(this, com.amazon.mShop.navigation.AppNavigator.Target.aiv_webview, Maps.of("url", getResources().getString(com.amazon.mShop.android.lib.R.string.mshop_nav_menu_aiv_yvl_url), "forceClearHistory", Boolean.valueOf(false)));
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        navigateToView();
        User.addUserListener(mUserListener);
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if ("aiv_help".equals(getIntent().getStringExtra("source")))
        {
            getGNODrawer().resetPosition();
        }
        User.removeUserListener(mUserListener);
    }

    protected void onNewIntent(Intent intent)
    {
        setIntent(intent);
        super.onNewIntent(intent);
        navigateToView();
    }

    protected void onResume()
    {
        super.onResume();
        if ("aiv_help".equals(getIntent().getStringExtra("source")))
        {
            getGNODrawer().focusOn("mshop:aiv");
        }
    }

    protected void onViewPopped(View view, View view1)
    {
        if (view != null && view.getId() == com.amazon.mShop.android.lib.R.id.help_amazon_instant_video_layout)
        {
            getGNODrawer().resetPosition();
        }
    }

    public void pushView(int i)
    {
        View view = View.inflate(this, i, null);
        super.pushView(view);
        if (i == com.amazon.mShop.android.lib.R.layout.help_amazon_instant_video)
        {
            getGNODrawer().focusOn("mshop:aiv");
            return;
        } else
        {
            setPrimeInstantVideoPageContentVisibility(view);
            return;
        }
    }

}
