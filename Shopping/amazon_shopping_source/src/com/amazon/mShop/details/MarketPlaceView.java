// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.details;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.AmazonBrandedWebView;
import com.amazon.mShop.TitleProvider;
import com.amazon.mShop.control.item.ProductController;
import com.amazon.mShop.control.item.ProductSubscriber;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.ConditionalOffersSummary;
import com.amazon.rio.j2me.client.services.mShop.OffersSummary;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.details:
//            MarketPlaceOffersAdapter, ProductSubscriberBase

public class MarketPlaceView extends TabHost
    implements TitleProvider
{

    private final AmazonActivity amazonActivity;
    private final android.widget.TabHost.OnTabChangeListener mTabChangeListener = new android.widget.TabHost.OnTabChangeListener() {

        final MarketPlaceView this$0;

        public void onTabChanged(String s)
        {
            String s1 = null;
            if (!"All Offers".equals(s)) goto _L2; else goto _L1
_L1:
            s1 = "dp_olp_a";
_L4:
            if (!Util.isEmpty(s1))
            {
                RefMarkerObserver.logRefMarker(s1);
            }
            return;
_L2:
            if ("New".equals(s))
            {
                s1 = "dp_olp_n";
            } else
            if ("Used".equals(s))
            {
                s1 = "dp_olp_u";
            } else
            if ("Refurbished".equals(s))
            {
                s1 = "dp_olp_r";
            } else
            if ("Collectible".equals(s))
            {
                s1 = "dp_olp_c";
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

            
            {
                this$0 = MarketPlaceView.this;
                super();
            }
    };
    private final ProductController productController;
    private final ProductSubscriber productSubscriber = new ProductSubscriberBase() {

        final MarketPlaceView this$0;

        public void onProductUpdated()
        {
            update();
        }

            
            {
                this$0 = MarketPlaceView.this;
                super();
            }
    };
    private final android.widget.TabHost.TabContentFactory tabContentFactory = new android.widget.TabHost.TabContentFactory() {

        final MarketPlaceView this$0;
        final Map views = new HashMap(4);

        public View createTabContent(String s)
        {
            View view1 = (View)views.get(s);
            View view = view1;
            if (view1 == null)
            {
                view = MarketPlaceOffersAdapter.getMarketPlaceOffersView(amazonActivity, productController, s);
                views.put(s, view);
            }
            return view;
        }

            
            {
                this$0 = MarketPlaceView.this;
                super();
            }
    };

    public MarketPlaceView(final AmazonActivity amazonActivity, ProductController productcontroller)
    {
        super(amazonActivity, null);
        this.amazonActivity = amazonActivity;
        productController = productcontroller;
        View.inflate(amazonActivity, com.amazon.mShop.android.lib.R.layout.marketplace, this);
        setup();
        setOnTabChangedListener(mTabChangeListener);
        productcontroller = findViewById(com.amazon.mShop.android.lib.R.id.mp_a_to_z_safe_buying_guarantee);
        if (ConfigUtils.isEnabled(com.amazon.mShop.android.lib.R.string.config_hasA2Zlink))
        {
            productcontroller.setVisibility(0);
            productcontroller.setOnClickListener(new android.view.View.OnClickListener() {

                final MarketPlaceView this$0;
                final AmazonActivity val$amazonActivity;

                public void onClick(View view)
                {
                    view = amazonActivity.getString(com.amazon.mShop.android.lib.R.string.mp_a_to_z_safe_buying_guarantee_url);
                    String s = amazonActivity.getString(com.amazon.mShop.android.lib.R.string.mp_a_to_z_safe_buying_guarantee);
                    amazonActivity.pushView(new AmazonBrandedWebView(amazonActivity, view, s));
                }

            
            {
                this$0 = MarketPlaceView.this;
                amazonActivity = amazonactivity;
                super();
            }
            });
            return;
        } else
        {
            productcontroller.setVisibility(8);
            return;
        }
    }

    private void customizeTabIndicator(View view)
    {
        view.setLayoutParams(new android.widget.LinearLayout.LayoutParams(-2, getContext().getResources().getDimensionPixelSize(com.amazon.mShop.android.lib.R.dimen.tab_height), 1.0F));
        fineTuneTabWidget(getTabWidget());
        view.setBackgroundResource(com.amazon.mShop.android.lib.R.drawable.tab_indicator);
        view = view.findViewById(0x1020016);
        if (view instanceof TextView)
        {
            view = (TextView)view;
            view.setMarqueeRepeatLimit(2);
            if (view.getParent() instanceof RelativeLayout)
            {
                android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-2, -2);
                layoutparams.addRule(13);
                view.setLayoutParams(layoutparams);
            }
        }
    }

    private void fineTuneTabWidget(TabWidget tabwidget)
    {
        Field field;
        Field field1;
        if (android.os.Build.VERSION.SDK_INT >= 8)
        {
            break MISSING_BLOCK_LABEL_83;
        }
        field = tabwidget.getClass().getDeclaredField("mBottomLeftStrip");
        field1 = tabwidget.getClass().getDeclaredField("mBottomRightStrip");
_L1:
        if (!field.isAccessible())
        {
            field.setAccessible(true);
        }
        if (!field1.isAccessible())
        {
            field1.setAccessible(true);
        }
        field.set(tabwidget, getResources().getDrawable(com.amazon.mShop.android.lib.R.drawable.transparent_drawable));
        field1.set(tabwidget, getResources().getDrawable(com.amazon.mShop.android.lib.R.drawable.transparent_drawable));
        return;
        try
        {
            field = tabwidget.getClass().getDeclaredField("mLeftStrip");
            field1 = tabwidget.getClass().getDeclaredField("mRightStrip");
        }
        // Misplaced declaration of an exception variable
        catch (TabWidget tabwidget)
        {
            Log.i("MarketPlaceView", "Error occurs while fine-tuning TabWidget");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TabWidget tabwidget)
        {
            Log.i("MarketPlaceView", "Error occurs while fine-tuning TabWidget");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TabWidget tabwidget)
        {
            Log.i("MarketPlaceView", "Error occurs while fine-tuning TabWidget");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TabWidget tabwidget)
        {
            Log.i("MarketPlaceView", "Error occurs while fine-tuning TabWidget");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (TabWidget tabwidget)
        {
            Log.i("MarketPlaceView", "Error occurs while fine-tuning TabWidget");
            return;
        }
          goto _L1
    }

    public volatile CharSequence getTitle()
    {
        return getTitle();
    }

    public String getTitle()
    {
        if (AppLocale.getInstance().getCurrentLocaleName().equals("en_IN"))
        {
            ConditionalOffersSummary conditionalofferssummary = productController.getConditionalOffersSummary("All Offers");
            int i;
            if (conditionalofferssummary != null && conditionalofferssummary.getSummary() != null)
            {
                i = conditionalofferssummary.getSummary().getCount();
            } else
            {
                i = 0;
            }
            return amazonActivity.getString(com.amazon.mShop.android.lib.R.string.mp_new_and_used_offers, new Object[] {
                Integer.valueOf(i)
            });
        } else
        {
            return amazonActivity.getString(com.amazon.mShop.android.lib.R.string.mp_new_and_used_offers);
        }
    }

    protected void onAttachedToWindow()
    {
        super.onAttachedToWindow();
        productController.addSubscriber(productSubscriber);
        productController.tryStartRequest();
        update();
    }

    protected void onDetachedFromWindow()
    {
        super.onDetachedFromWindow();
        productController.removeSubscriber(productSubscriber);
    }

    public void onTouchModeChanged(boolean flag)
    {
        if (getVisibility() == 0)
        {
            super.onTouchModeChanged(flag);
        }
    }

    public void update()
    {
        TabWidget tabwidget = getTabWidget();
        clearAllTabs();
        ConditionalOffersSummary aconditionalofferssummary[] = productController.getConditionalOffersSummaryList();
        if (aconditionalofferssummary != null)
        {
            int j = aconditionalofferssummary.length;
            for (int i = 0; i < j; i++)
            {
                String s = aconditionalofferssummary[i].getCondition();
                android.widget.TabHost.TabSpec tabspec = newTabSpec(s);
                tabspec.setIndicator(s);
                tabspec.setContent(tabContentFactory);
                addTab(tabspec);
                if (tabwidget.getChildCount() > 0)
                {
                    customizeTabIndicator(tabwidget.getChildAt(tabwidget.getChildCount() - 1));
                }
            }

        }
    }


}
