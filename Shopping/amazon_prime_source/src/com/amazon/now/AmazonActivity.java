// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.ViewAnimator;
import com.amazon.now.account.User;
import com.amazon.now.cart.CartActivity;
import com.amazon.now.home.HomeActivity;
import com.amazon.now.location.Location;
import com.amazon.now.nav.NavListAdapter;
import com.amazon.now.nav.NowSlidingPaneLayout;
import com.amazon.now.net.ConnectionLostDialogFragment;
import com.amazon.now.permissions.PermissionsHelper;
import com.amazon.now.search.SearchIntentBuilder;
import com.amazon.now.util.AppUtils;
import com.amazon.now.util.ImageUtil;
import com.amazon.now.util.LocationUtil;
import com.amazon.now.util.UiOOMHandler;
import com.amazon.retailsearch.android.ui.DelayedInitView;
import com.amazon.retailsearch.android.ui.UIUtils;

// Referenced classes of package com.amazon.now:
//            ChromeStyle, ActivityTerminationReceiver

public class AmazonActivity extends Activity
    implements com.amazon.now.location.Store.StoreListener
{
    public final class RetailSearchDelayedInitializer
        implements Runnable
    {

        final AmazonActivity this$0;
        private final DelayedInitView view;

        public void run()
        {
            (new UiOOMHandler(AmazonActivity.this, new com.amazon.now.util.UiOOMHandler.UiRunnable(new Runnable() {

                final RetailSearchDelayedInitializer this$1;

                public void run()
                {
                    view.onPushViewCompleted();
                }

            
            {
                this$1 = RetailSearchDelayedInitializer.this;
                super();
            }
            }, false))).execute();
        }


        public RetailSearchDelayedInitializer(DelayedInitView delayedinitview, boolean flag)
        {
            this$0 = AmazonActivity.this;
            super();
            view = delayedinitview;
            if (flag)
            {
                ((View)delayedinitview).postDelayed(this, getResources().getInteger(0x7f0a0005));
                return;
            } else
            {
                ((View)delayedinitview).post(this);
                return;
            }
        }
    }


    public static final String INTENT_STYLE_KEY = "intentStyleKey";
    private NavListAdapter mAdapter;
    private boolean mFirstResume;
    private int mLocationHash;
    private boolean mSignedIn;
    private NowSlidingPaneLayout mSlidingPaneLayout;
    private ProgressDialog mSpinner;
    private ChromeStyle mStyle;
    private ActivityTerminationReceiver mTerminationReceiver;
    private ViewAnimator mViewAnimator;

    public AmazonActivity()
    {
        mStyle = new ChromeStyle(ChromeStyle.ChromeLayout.NONE);
        mLocationHash = -1;
        mSignedIn = false;
        mFirstResume = true;
    }

    private void search()
    {
        search(null, null);
    }

    private void setLeftNavImage(RelativeLayout relativelayout, int i)
    {
        relativelayout = (ImageView)relativelayout.findViewById(0x7f0e006c);
        if (relativelayout != null)
        {
            String s = Location.getImageUrl();
            if (s != null)
            {
                ImageUtil.setImageFromUrl(new com.amazon.now.util.ImageUtil.ImageReadyCallback(relativelayout), s, i, i, true);
            }
        }
    }

    public View addActionBar(View view)
    {
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(1);
        View view1 = View.inflate(this, 0x7f030000, null);
        view1.setBackgroundColor(mStyle.getColor());
        linearlayout.addView(view1);
        ((ImageView)linearlayout.findViewById(0x7f0e002f)).setOnClickListener(new android.view.View.OnClickListener() {

            final AmazonActivity this$0;

            public void onClick(View view2)
            {
                search();
            }

            
            {
                this$0 = AmazonActivity.this;
                super();
            }
        });
        linearlayout.findViewById(0x7f0e0030).setOnClickListener(new android.view.View.OnClickListener() {

            final AmazonActivity this$0;

            public void onClick(View view2)
            {
                goToCart();
            }

            
            {
                this$0 = AmazonActivity.this;
                super();
            }
        });
        linearlayout.findViewById(0x7f0e002e).setOnClickListener(new android.view.View.OnClickListener() {

            final AmazonActivity this$0;

            public void onClick(View view2)
            {
                AppUtils.goHome(AmazonActivity.this);
            }

            
            {
                this$0 = AmazonActivity.this;
                super();
            }
        });
        linearlayout.addView(view);
        return linearlayout;
    }

    public View addActionBarWithHeaderOnly(View view)
    {
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(1);
        Object obj = View.inflate(this, 0x7f030001, null);
        ((View) (obj)).setBackgroundColor(mStyle.getColor());
        linearlayout.addView(((View) (obj)));
        obj = (TextView)((View) (obj)).findViewById(0x7f0e0037);
        if (obj != null)
        {
            ((TextView) (obj)).setText(mStyle.getHeader());
        }
        linearlayout.addView(view);
        return linearlayout;
    }

    public View addActionBarWithLogoOnly(View view)
    {
        LinearLayout linearlayout = new LinearLayout(this);
        linearlayout.setOrientation(1);
        View view1 = View.inflate(this, 0x7f030000, null);
        view1.setBackgroundColor(mStyle.getColor());
        linearlayout.addView(view1);
        linearlayout.findViewById(0x7f0e002d).setVisibility(8);
        linearlayout.findViewById(0x7f0e002f).setVisibility(8);
        linearlayout.findViewById(0x7f0e0030).setVisibility(8);
        linearlayout.findViewById(0x7f0e002e).setClickable(false);
        linearlayout.addView(view);
        return linearlayout;
    }

    public View addLeftNav(View view)
    {
        final NowSlidingPaneLayout layout = (NowSlidingPaneLayout)View.inflate(this, 0x7f030010, null);
        Object obj = (RelativeLayout)layout.findViewById(0x7f0e006b);
        int i = calculateLeftNavWidth();
        ((RelativeLayout) (obj)).getLayoutParams().width = i;
        setLeftNavImage(((RelativeLayout) (obj)), i);
        ((RelativeLayout) (obj)).requestLayout();
        layout.setSliderFadeColor(getResources().getColor(0x7f0d001d));
        obj = (ListView)layout.findViewById(0x7f0e006d);
        mAdapter = new NavListAdapter(this);
        ((ListView) (obj)).setAdapter(mAdapter);
        ((ListView) (obj)).setOnItemClickListener(mAdapter);
        User.addUserListener(mAdapter);
        layout.addView(view);
        view = (ImageView)view.findViewById(0x7f0e002d);
        if (view != null)
        {
            view.setOnClickListener(new android.view.View.OnClickListener() {

                final AmazonActivity this$0;
                final NowSlidingPaneLayout val$layout;

                public void onClick(View view1)
                {
                    UIUtils.closeSoftKeyboard(view1);
                    if (layout.isOpen())
                    {
                        layout.closePane();
                        return;
                    } else
                    {
                        layout.openPane();
                        return;
                    }
                }

            
            {
                this$0 = AmazonActivity.this;
                layout = nowslidingpanelayout;
                super();
            }
            });
        }
        mSlidingPaneLayout = layout;
        return layout;
    }

    public int calculateLeftNavWidth()
    {
        return (AppUtils.getDeviceDisplayMetrics(getApplicationContext()).widthPixels * 5) / 6;
    }

    public boolean closeLeftNav()
    {
        if (isLeftNavOpen())
        {
            mSlidingPaneLayout.closePane();
            return true;
        } else
        {
            return false;
        }
    }

    public ChromeStyle getChromeStyle()
    {
        return mStyle;
    }

    public View getCurrentView()
    {
        return mViewAnimator.getCurrentView();
    }

    public ViewAnimator getViewAnimator()
    {
        return getViewAnimator(new ChromeStyle(ChromeStyle.ChromeLayout.NORMAL));
    }

    public ViewAnimator getViewAnimator(ChromeStyle chromestyle)
    {
        if (mViewAnimator != null) goto _L2; else goto _L1
_L1:
        ViewAnimator viewanimator;
        mStyle = chromestyle;
        mViewAnimator = new ViewAnimator(this);
        mViewAnimator.setLayoutParams(new android.view.ViewGroup.LayoutParams(-1, -1));
        viewanimator = mViewAnimator;
        static class _cls5
        {

            static final int $SwitchMap$com$amazon$now$ChromeStyle$ChromeLayout[];

            static 
            {
                $SwitchMap$com$amazon$now$ChromeStyle$ChromeLayout = new int[ChromeStyle.ChromeLayout.values().length];
                try
                {
                    $SwitchMap$com$amazon$now$ChromeStyle$ChromeLayout[ChromeStyle.ChromeLayout.LOGO_ONLY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$now$ChromeStyle$ChromeLayout[ChromeStyle.ChromeLayout.NORMAL.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$now$ChromeStyle$ChromeLayout[ChromeStyle.ChromeLayout.HEADER.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$now$ChromeStyle$ChromeLayout[ChromeStyle.ChromeLayout.NONE.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls5..SwitchMap.com.amazon.now.ChromeStyle.ChromeLayout[chromestyle.getLayout().ordinal()];
        JVM INSTR tableswitch 1 3: default 84
    //                   1 96
    //                   2 108
    //                   3 124;
           goto _L3 _L4 _L5 _L6
_L3:
        chromestyle = viewanimator;
_L8:
        super.setContentView(chromestyle);
_L2:
        return mViewAnimator;
_L4:
        chromestyle = addActionBarWithLogoOnly(mViewAnimator);
        continue; /* Loop/switch isn't completed */
_L5:
        chromestyle = addLeftNav(addActionBar(mViewAnimator));
        continue; /* Loop/switch isn't completed */
_L6:
        chromestyle = addActionBarWithHeaderOnly(mViewAnimator);
        if (true) goto _L8; else goto _L7
_L7:
    }

    protected void goToCart()
    {
        CartActivity.startActivity(this);
    }

    public void hideSpinner()
    {
        boolean flag;
        if (mTerminationReceiver == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (mSpinner != null && mSpinner.isShowing() && !isFinishing() && !flag)
        {
            mSpinner.dismiss();
            mSpinner = null;
        }
    }

    public boolean isLeftNavOpen()
    {
        return mSlidingPaneLayout != null && mSlidingPaneLayout.isOpen();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mTerminationReceiver = new ActivityTerminationReceiver();
        registerReceiver(mTerminationReceiver, ActivityTerminationReceiver.INTENT_FILTER);
        setRequestedOrientation(1);
        if (android.os.Build.VERSION.SDK_INT >= 23)
        {
            getWindow().setFlags(8192, 8192);
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if (mTerminationReceiver != null)
        {
            unregisterReceiver(mTerminationReceiver);
            mTerminationReceiver = null;
        }
    }

    public void onLowMemory()
    {
        ImageUtil.clearCache();
    }

    public void onNewIntent(Intent intent)
    {
        super.onNewIntent(intent);
        overridePendingTransition(0, 0);
    }

    public void onPause()
    {
        super.onPause();
        hideSpinner();
        LocationUtil.removeStoreListener(this);
        overridePendingTransition(0, 0);
        if (mAdapter != null)
        {
            User.removeUserListener(mAdapter);
        }
    }

    public void onRequestPermissionsResult(int i, String as[], int ai[])
    {
        PermissionsHelper.handlePermissionRequestResult(this, i, as, ai);
    }

    public void onResume()
    {
        super.onResume();
        LocationUtil.addStoreListener(this);
        if (!mFirstResume) goto _L2; else goto _L1
_L1:
        mSignedIn = User.isSignedIn();
        mFirstResume = false;
        mLocationHash = Location.locationHash();
_L4:
        if (mAdapter != null && !User.containUserListener(mAdapter))
        {
            mAdapter.notifyDataSetChanged();
            User.addUserListener(mAdapter);
        }
        if (!AppUtils.hasNetworkConnection(this))
        {
            ConnectionLostDialogFragment.show(getFragmentManager());
        }
        return;
_L2:
        if (mSignedIn != User.isSignedIn())
        {
            if (this instanceof HomeActivity)
            {
                AppUtils.goHome(this);
            } else
            if (mAdapter != null)
            {
                mAdapter.recreate();
            }
        } else
        if (mLocationHash != Location.locationHash())
        {
            updateLeftNav();
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onStoresUpdated()
    {
        if (mAdapter != null)
        {
            mAdapter.recreate();
        }
    }

    public void popView()
    {
        if (mViewAnimator != null && mViewAnimator.getChildCount() > 1)
        {
            View view = mViewAnimator.getCurrentView();
            mViewAnimator.showPrevious();
            mViewAnimator.removeView(view);
        }
    }

    public void pushView(View view)
    {
        if (mViewAnimator != null)
        {
            mViewAnimator.addView(view);
            mViewAnimator.showNext();
        }
        if (view instanceof DelayedInitView)
        {
            new RetailSearchDelayedInitializer((DelayedInitView)view, true);
        }
    }

    public void search(String s, String s1)
    {
        startActivity((new SearchIntentBuilder(this)).showSearchEntryView(true).merchantId(s).storeDiscriminator(s1).build());
    }

    public void setRootView(View view, ChromeStyle chromestyle)
    {
        if (mViewAnimator == null)
        {
            getViewAnimator(chromestyle);
        } else
        {
            mViewAnimator.removeAllViews();
        }
        if (chromestyle.getLayout() == ChromeStyle.ChromeLayout.NORMAL && view.getBackground() == null)
        {
            view.setBackgroundColor(getResources().getColor(0x7f0d000d));
        }
        mViewAnimator.addView(view);
        mViewAnimator.showNext();
        if (view instanceof DelayedInitView)
        {
            new RetailSearchDelayedInitializer((DelayedInitView)view, true);
        }
    }

    public void showSpinner()
    {
        hideSpinner();
        boolean flag;
        if (mTerminationReceiver == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!isFinishing() && !flag)
        {
            mSpinner = new ProgressDialog(new ContextThemeWrapper(this, 0x7f0c0000));
            mSpinner.setCancelable(false);
            mSpinner.show();
            mSpinner.setContentView(0x7f030019);
            mSpinner.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        }
    }

    public void updateLeftNav()
    {
        if (mAdapter != null)
        {
            mAdapter.recreate();
        }
        if (mSlidingPaneLayout != null)
        {
            RelativeLayout relativelayout = (RelativeLayout)mSlidingPaneLayout.findViewById(0x7f0e006b);
            if (relativelayout != null)
            {
                int i = calculateLeftNavWidth();
                relativelayout.getLayoutParams().width = i;
                setLeftNavImage(relativelayout, i);
            }
        }
    }

}
