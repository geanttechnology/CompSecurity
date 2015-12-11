// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.actionBar;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.account.LoginActivity;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.fastBrowse.FastBrowseActivity;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.gno.GNODrawer;
import com.amazon.mShop.gno.GNODrawerHelper;
import com.amazon.mShop.home.GatewayActivity;
import com.amazon.mShop.home.HomeView;
import com.amazon.mShop.home.web.MShopWebGatewayActivity;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.model.auth.UserListener;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.search.SearchIntentBuilder;
import com.amazon.mShop.sso.SSOSplashScreenActivity;
import com.amazon.mShop.sso.SigninPromptActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.BitmapUtil;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.UIUtils;
import com.amazon.mShop.web.MShopModalWebActivity;
import com.amazon.mShop.youraccount.OneClickSettingsView;
import com.amazon.retailsearch.android.ui.entry.RetailSearchEntryView;

// Referenced classes of package com.amazon.mShop.actionBar:
//            ActionBarCartView, ActionBarHelper

public class ActionBarViewV2 extends LinearLayout
    implements com.amazon.mShop.gno.GNODrawer.GNODrawerListener, UserListener
{
    private class TopMostViewChangedReceiver extends BroadcastReceiver
    {

        final ActionBarViewV2 this$0;

        public void onReceive(Context context, Intent intent)
        {
            if ("com.amazon.mShop.TopMostViewChangedReceiverIntent".equals(intent.getAction()))
            {
                update();
            }
        }

        private TopMostViewChangedReceiver()
        {
            this$0 = ActionBarViewV2.this;
            super();
        }

    }


    private View mActionBarBurger;
    private ActionBarCartView mActionBarCart;
    private View mActionBarHome;
    private ImageView mActionBarHomeLogo;
    private ImageButton mActionBarSearch;
    private final AmazonActivity mAmazonActivity;
    private TopMostViewChangedReceiver mTopMostViewChangedReceiver;

    public ActionBarViewV2(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        mAmazonActivity = (AmazonActivity)context;
        mTopMostViewChangedReceiver = new TopMostViewChangedReceiver();
        mAmazonActivity.registerReceiver(mTopMostViewChangedReceiver, new IntentFilter("com.amazon.mShop.TopMostViewChangedReceiverIntent"));
    }

    private void onlyShowHomeLogo()
    {
        mActionBarBurger.setVisibility(8);
        mActionBarHomeLogo.setVisibility(0);
        mActionBarSearch.setVisibility(8);
        mActionBarCart.setVisibility(8);
        mAmazonActivity.getGNODrawer().lock(false);
    }

    private void showAllActionBarItems()
    {
        mActionBarBurger.setVisibility(0);
        mActionBarHomeLogo.setVisibility(0);
        mActionBarSearch.setVisibility(0);
        mActionBarCart.setVisibility(0);
        mAmazonActivity.getGNODrawer().unlock();
    }

    private void updateActionBarHomeLogo(User user)
    {
        if (ActivityUtils.isSmileEnabled() && user != null && user.isSmile())
        {
            int i;
            if (user.isPrime())
            {
                i = com.amazon.mShop.android.lib.R.drawable.action_bar_amazon_smile_prime_logo;
            } else
            {
                i = com.amazon.mShop.android.lib.R.drawable.action_bar_amazon_smile_logo;
            }
            BitmapUtil.setImageResource(mActionBarHomeLogo, i);
            return;
        }
        if (user != null && user.isPrime())
        {
            BitmapUtil.setImageResource(mActionBarHomeLogo, com.amazon.mShop.android.lib.R.drawable.action_bar_amazon_prime_logo);
            return;
        }
        user = Features.getInstance().getFeatureState("Android_CN_Amazon_Ten_Years_Logo");
        if (ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_ten_years_anniversary_logo) && "T1".equals(user))
        {
            BitmapUtil.setImageResource(mActionBarHomeLogo, com.amazon.mShop.android.lib.R.drawable.anniversary_action_bar_amazon_logo);
            return;
        } else
        {
            BitmapUtil.setImageResource(mActionBarHomeLogo, com.amazon.mShop.android.lib.R.drawable.action_bar_amazon_logo);
            return;
        }
    }

    private void updateActionBarItem(View view)
    {
        if (!(mAmazonActivity instanceof GatewayActivity)) goto _L2; else goto _L1
_L1:
        if (!(view instanceof HomeView)) goto _L4; else goto _L3
_L3:
        mActionBarSearch.setVisibility(8);
_L6:
        return;
_L4:
        mActionBarSearch.setVisibility(0);
        UIUtils.setAlpha(mActionBarSearch, 1.0F);
        return;
_L2:
        if (mAmazonActivity instanceof SearchActivity)
        {
            if (view instanceof RetailSearchEntryView)
            {
                ActionBarHelper.onOrientationChanged(mAmazonActivity);
                return;
            } else
            {
                setVisibility(0);
                return;
            }
        }
        if (mAmazonActivity instanceof MShopModalWebActivity)
        {
            if (((MShopModalWebActivity)mAmazonActivity).isSupportGNO())
            {
                showAllActionBarItems();
                return;
            } else
            {
                onlyShowHomeLogo();
                return;
            }
        }
        if ((mAmazonActivity instanceof LoginActivity) && ((LoginActivity)mAmazonActivity).isUserForceSignIn())
        {
            if (view instanceof OneClickSettingsView)
            {
                showAllActionBarItems();
                mActionBarHome.setClickable(true);
                return;
            } else
            {
                onlyShowHomeLogo();
                mActionBarHome.setClickable(false);
                return;
            }
        }
        if ((mAmazonActivity instanceof SSOSplashScreenActivity) || (mAmazonActivity instanceof SigninPromptActivity))
        {
            setVisibility(8);
            return;
        }
        if (mAmazonActivity instanceof MShopWebGatewayActivity)
        {
            mActionBarSearch.setVisibility(8);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        User.addUserListener(this);
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        mAmazonActivity.unregisterReceiver(mTopMostViewChangedReceiver);
        mTopMostViewChangedReceiver = null;
        User.removeUserListener(this);
    }

    public void onDrawerClosed(GNODrawer gnodrawer)
    {
        if (mAmazonActivity.isActionBarSearchIconFadeable())
        {
            mActionBarSearch.setVisibility(8);
        }
    }

    public void onDrawerOpened(GNODrawer gnodrawer)
    {
    }

    public void onDrawerSlide(GNODrawer gnodrawer, float f)
    {
label0:
        {
            if (mAmazonActivity.isActionBarSearchIconFadeable())
            {
                if (f <= 0.0F)
                {
                    break label0;
                }
                mActionBarSearch.setVisibility(0);
                UIUtils.setAlpha(mActionBarSearch, (float)Math.pow(f, 7D));
            }
            return;
        }
        mActionBarSearch.setVisibility(8);
    }

    protected void onFinishInflate()
    {
        super.onFinishInflate();
        mActionBarBurger = findViewById(com.amazon.mShop.android.lib.R.id.action_bar_burger);
        mActionBarBurger.setOnClickListener(new android.view.View.OnClickListener() {

            final ActionBarViewV2 this$0;

            public void onClick(View view)
            {
                if (mAmazonActivity instanceof FastBrowseActivity)
                {
                    mAmazonActivity.getGNODrawer().unlock();
                }
                mAmazonActivity.getGNODrawer().toggle();
                RefMarkerObserver.logRefMarker("gno_buger");
            }

            
            {
                this$0 = ActionBarViewV2.this;
                super();
            }
        });
        mActionBarHome = findViewById(com.amazon.mShop.android.lib.R.id.action_bar_home);
        mActionBarHome.setOnClickListener(new android.view.View.OnClickListener() {

            final ActionBarViewV2 this$0;

            public void onClick(View view)
            {
                if (!mAmazonActivity.canLaunchHomeFromActionBar())
                {
                    return;
                } else
                {
                    GNODrawerHelper.closeDrawerAndExecute(mAmazonActivity, true, new Runnable() {

                        final _cls2 this$1;

                        public void run()
                        {
                            ActivityUtils.startHomeActivity(mAmazonActivity);
                            RefMarkerObserver.logRefMarker("gno_logo");
                        }

            
            {
                this$1 = _cls2.this;
                super();
            }
                    });
                    return;
                }
            }

            
            {
                this$0 = ActionBarViewV2.this;
                super();
            }
        });
        mActionBarHomeLogo = (ImageView)findViewById(com.amazon.mShop.android.lib.R.id.action_bar_home_logo);
        updateActionBarHomeLogo(User.getUser());
        mActionBarSearch = (ImageButton)findViewById(com.amazon.mShop.android.lib.R.id.action_bar_search);
        mActionBarSearch.setOnClickListener(new android.view.View.OnClickListener() {

            final ActionBarViewV2 this$0;

            public void onClick(View view)
            {
                GNODrawerHelper.closeDrawerAndExecute(mAmazonActivity, true, new Runnable() {

                    final _cls3 this$1;

                    public void run()
                    {
                        Intent intent = (new SearchIntentBuilder(mAmazonActivity)).showSearchEntryView(true).selectInitialQuery(true).clickStreamOrigin(ClickStreamTag.ORIGIN_SEARCH.getTag()).build();
                        ActivityUtils.startSearchActivity(mAmazonActivity, intent);
                        RefMarkerObserver.logRefMarker("gno_sr");
                    }

            
            {
                this$1 = _cls3.this;
                super();
            }
                });
            }

            
            {
                this$0 = ActionBarViewV2.this;
                super();
            }
        });
        mActionBarCart = (ActionBarCartView)findViewById(com.amazon.mShop.android.lib.R.id.action_bar_cart);
        mActionBarCart.setOnClickListener(new android.view.View.OnClickListener() {

            final ActionBarViewV2 this$0;

            public void onClick(View view)
            {
                GNODrawerHelper.closeDrawerAndExecute(mAmazonActivity, true, new Runnable() {

                    final _cls4 this$1;

                    public void run()
                    {
                        ActivityUtils.startCartActivity(mAmazonActivity);
                        RefMarkerObserver.logRefMarker("gno_cart");
                    }

            
            {
                this$1 = _cls4.this;
                super();
            }
                });
            }

            
            {
                this$0 = ActionBarViewV2.this;
                super();
            }
        });
    }

    public void update()
    {
        updateActionBarItem(mAmazonActivity.getCurrentView());
    }

    public void userSignedIn(User user)
    {
        updateActionBarHomeLogo(user);
    }

    public void userSignedOut()
    {
        updateActionBarHomeLogo(null);
    }

    public void userUpdated(User user)
    {
        updateActionBarHomeLogo(user);
    }

}
