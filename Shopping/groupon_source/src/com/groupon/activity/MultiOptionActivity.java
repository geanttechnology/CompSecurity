// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.app.LoaderManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.Loader;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;
import com.groupon.Channel;
import com.groupon.abtest.NewCartAbTestHelper;
import com.groupon.adapter.OptionsAdapter;
import com.groupon.db.events.DealUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.db.models.ExternalDealProvider;
import com.groupon.db.models.Option;
import com.groupon.events.CustomPageViewEvent;
import com.groupon.goods.shoppingcart.CartSummaryActivity;
import com.groupon.goods.shoppingcart.NewPurchaseCart;
import com.groupon.goods.shoppingcart.ShoppingCartControllerListener;
import com.groupon.goods.shoppingcart.ShoppingCartErrorHelper;
import com.groupon.goods.shoppingcart.ShoppingCartPresenter;
import com.groupon.loader.DealLoader;
import com.groupon.models.country.Country;
import com.groupon.models.nst.MultiOptionClickExtraInfo;
import com.groupon.models.nst.PageViewExtraInfo;
import com.groupon.models.nst.UpBackClickExtraInfo;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.LoggingUtils;
import com.groupon.util.LoginUtil;
import com.groupon.util.UiTreatmentsUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.activity:
//            GrouponFragmentActivity, IntentFactory

public class MultiOptionActivity extends GrouponFragmentActivity
    implements CustomPageViewEvent
{
    private class CartControllerListener
        implements ShoppingCartControllerListener
    {

        final MultiOptionActivity this$0;

        public void onCartCancel()
        {
            finish();
        }

        public void onCartException(Exception exception, boolean flag)
        {
            toggleOptionsListView(true);
            shoppingCartErrorHelper.shoudDisplayErrorDialog(exception, flag);
        }

        public void onCartReady()
        {
            if (deal != null)
            {
                loadingView.setVisibility(8);
            }
        }

        public void onItemAdded()
        {
            if (cartAbTestHelper.shouldSkipSummary())
            {
                startActivity(NewPurchaseCart.openPurchaseCartIntent(MultiOptionActivity.this));
                return;
            } else
            {
                startActivity(CartSummaryActivity.openShoppingCartIntent(MultiOptionActivity.this));
                return;
            }
        }

        private CartControllerListener()
        {
            this$0 = MultiOptionActivity.this;
            super();
        }

    }


    public static final int REQUEST_CODE = 10134;
    private AbTestService abTestService;
    private NewCartAbTestHelper cartAbTestHelper;
    Channel channel;
    Date checkInDate;
    Date checkOutDate;
    boolean comingFromGifting;
    private CurrencyFormatter currencyFormatter;
    private CurrentCountryManager currentCountryManager;
    private Deal deal;
    String dealId;
    String defaultOptionId;
    private IntentFactory intentFactory;
    private boolean isAllowedInCart;
    boolean isDeepLinked;
    private boolean isGdt1503USCA;
    boolean isMobileOnly;
    boolean isMultiOptionSelection;
    private boolean isNavigateUpClicked;
    ProgressBar loadingView;
    private LoggingUtils loggingUtils;
    private LoginUtil loginUtil;
    Intent next;
    private List optionList;
    private OptionsAdapter optionsAdapter;
    ListView optionsListView;
    boolean redirectToEnterCode;
    private ShoppingCartErrorHelper shoppingCartErrorHelper;
    private ShoppingCartPresenter shoppingCartPresenter;
    private UiTreatmentsUtil uiTreatmentsUtil;

    public MultiOptionActivity()
    {
    }

    private void handleExternalUrlPerOption(String s, Deal deal1, Option option, Channel channel1)
    {
        if (!Strings.notEmpty(s)) goto _L2; else goto _L1
_L1:
        String s1 = ((Option)deal1.getOptions().get(0)).remoteId;
        if (!abTestService.isVariantEnabled("thirdPartyLinkout1509", "on")) goto _L4; else goto _L3
_L3:
        if (deal1.externalDealProvider != null) goto _L6; else goto _L5
_L5:
        s1 = "";
_L11:
        if (!uiTreatmentsUtil.isThirdPartyLinkoutDeal(deal1)) goto _L8; else goto _L7
_L7:
        s = intentFactory.newLinkoutDealWebviewIntent(s1, s);
_L9:
        startActivity(s);
        return;
_L6:
        s1 = deal1.externalDealProvider.name;
        continue; /* Loop/switch isn't completed */
_L8:
        s = intentFactory.newGeneralThirdPartyDealWebViewIntent(s);
          goto _L9
_L4:
        try
        {
            startActivity(intentFactory.newExternalUrlIntent(s, dealId, channel1, s1));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s) { }
_L2:
        loginUtil.startPurchaseActivity(deal1, option.remoteId, defaultOptionId, channel1, isMobileOnly, redirectToEnterCode, isDeepLinked);
        return;
        if (true) goto _L11; else goto _L10
_L10:
    }

    private void loadDeal()
    {
        loadingView.setVisibility(0);
        getLoaderManager().initLoader(0, null, new android.app.LoaderManager.LoaderCallbacks() {

            final MultiOptionActivity this$0;

            public Loader onCreateLoader(int i, Bundle bundle)
            {
                return new DealLoader(com/groupon/db/models/Deal, com/groupon/db/events/DealUpdateEvent, MultiOptionActivity.this, dealId);
            }

            public void onLoadFinished(Loader loader, Deal deal1)
            {
                boolean flag = false;
                loadingView.setVisibility(8);
                if (deal1 != null)
                {
                    deal = deal1;
                    optionList = deal1.getOptions();
                    MultiOptionActivity multioptionactivity;
                    byte byte0;
                    boolean flag1;
                    if (!optionList.isEmpty())
                    {
                        loader = ((Option)optionList.get(0)).externalUrl;
                    } else
                    {
                        loader = null;
                    }
                    multioptionactivity = MultiOptionActivity.this;
                    flag1 = isAllowedInCart;
                    if (Strings.isEmpty(loader) && deal1.allowedInCart && cartAbTestHelper.isShoppingCartEnabled())
                    {
                        byte0 = 1;
                    } else
                    {
                        byte0 = 0;
                    }
                    multioptionactivity.isAllowedInCart = byte0 | flag1;
                    if (isAllowedInCart)
                    {
                        shoppingCartPresenter.cacheCart();
                        loader = loadingView;
                        byte0 = flag;
                        if (shoppingCartPresenter.isCartReady())
                        {
                            byte0 = 8;
                        }
                        loader.setVisibility(byte0);
                    }
                    setupAdapter();
                }
            }

            public volatile void onLoadFinished(Loader loader, Object obj)
            {
                onLoadFinished(loader, (Deal)obj);
            }

            public void onLoaderReset(Loader loader)
            {
            }

            
            {
                this$0 = MultiOptionActivity.this;
                super();
            }
        });
    }

    private void setupListener()
    {
        optionsListView.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final MultiOptionActivity this$0;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                view = optionsAdapter.getItem(i);
                Logger logger;
                if (isGdt1503USCA)
                {
                    if (((Option) (view)).specificAttributeDelivery || ((Option) (view)).specificAttributeTakeout)
                    {
                        adapterview = "on";
                    } else
                    {
                        adapterview = "off";
                    }
                } else
                {
                    adapterview = "";
                }
                MultiOptionActivity.this.logger.logMultiOption("", dealId, ((Option) (view)).remoteId, deal.getOptions().size(), i, loggingUtils.getMultiOptionExtraInfoString(adapterview, getPageViewId()));
                logger = MultiOptionActivity.this.logger;
                if (channel != null)
                {
                    adapterview = channel.toString();
                } else
                {
                    adapterview = "";
                }
                logger.logClick("", "deal_option_click", adapterview, Logger.NULL_NST_FIELD, new MultiOptionClickExtraInfo(getPageViewId(), defaultOptionId, ((Option) (view)).remoteId));
                if (next != null)
                {
                    next.putExtra("optionId", ((Option) (view)).remoteId);
                    next.putExtra("channel", channel);
                    startActivity(next);
                    return;
                }
                if (comingFromGifting)
                {
                    loginUtil.startGiftingFlow(deal, view, defaultOptionId, channel, isMobileOnly, false);
                    return;
                }
                if (isAllowedInCart)
                {
                    toggleOptionsListView(false);
                    shoppingCartPresenter.addToCartAndOpen(deal, view);
                    return;
                }
                if (isMultiOptionSelection && !currentCountryManager.getCurrentCountry().isJapan())
                {
                    startActivity(intentFactory.newPurchaseLoginIntent(dealId, ((Option) (view)).remoteId, channel, isDeepLinked));
                    finish();
                    return;
                }
                if (deal.isTravelBookableDeal && !currentCountryManager.getCurrentCountry().isJapan())
                {
                    startActivity(intentFactory.newCalendarBookingIntent(deal, channel, ((Option) (view)).remoteId, checkInDate, checkOutDate, redirectToEnterCode));
                    return;
                } else
                {
                    adapterview = ((Option) (view)).externalUrl;
                    handleExternalUrlPerOption(adapterview, deal, view, channel);
                    return;
                }
            }

            
            {
                this$0 = MultiOptionActivity.this;
                super();
            }
        });
    }

    private void toggleOptionsListView(boolean flag)
    {
        ProgressBar progressbar = loadingView;
        byte byte0;
        if (flag)
        {
            byte0 = 8;
        } else
        {
            byte0 = 0;
        }
        progressbar.setVisibility(byte0);
        optionsListView.setEnabled(flag);
    }

    protected boolean hasCartIcon()
    {
        return true;
    }

    protected void initActionBar(Bundle bundle)
    {
        super.initActionBar(bundle);
        setToolbarTitle(getString(0x7f08035c));
    }

    public void logPageViewEvent()
    {
        logger.logPageView("", getPageViewId(), new PageViewExtraInfo(dealId));
    }

    public void onBackPressed()
    {
        if (!isNavigateUpClicked)
        {
            Logger logger = this.logger;
            String s;
            if (channel != null)
            {
                s = channel.toString();
            } else
            {
                s = "";
            }
            logger.logClick("", "back_arrow_click", s, Logger.NULL_NST_FIELD, new UpBackClickExtraInfo(getPageViewId(), "system_back"));
        }
        super.onBackPressed();
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f03016a);
        isGdt1503USCA = abTestService.isVariantEnabledAndUSCA("GDT1503USCA", "on");
        if (cartAbTestHelper.isShoppingCartEnabled())
        {
            shoppingCartPresenter.setShoppingCartControllerListener(new CartControllerListener());
            shoppingCartErrorHelper.setShoppingCartPresenter(shoppingCartPresenter);
        }
        setupListener();
        loadDeal();
    }

    public void onDestroy()
    {
        optionsListView.setOnItemClickListener(null);
        super.onDestroy();
    }

    public boolean onOptionsItemSelected(MenuItem menuitem)
    {
        if (menuitem.getItemId() == 0x102002c)
        {
            isNavigateUpClicked = true;
            Logger logger = this.logger;
            String s;
            if (channel != null)
            {
                s = channel.toString();
            } else
            {
                s = "";
            }
            logger.logClick("", "back_arrow_click", s, Logger.NULL_NST_FIELD, new UpBackClickExtraInfo(getPageViewId(), "app_back_arrow"));
        }
        return super.onOptionsItemSelected(menuitem);
    }

    public void onResume()
    {
        super.onResume();
        if (isAllowedInCart)
        {
            shoppingCartPresenter.cacheCart();
        }
        if (optionsListView != null && !optionsListView.isEnabled())
        {
            toggleOptionsListView(true);
        }
    }

    protected void setupAdapter()
    {
        boolean flag = currentCountryManager.getCurrentCountry().isUSACompatible();
        optionsAdapter = new OptionsAdapter(getApplicationContext(), deal, optionList, currencyFormatter, flag);
        optionsListView.setAdapter(optionsAdapter);
    }






/*
    static List access$1202(MultiOptionActivity multioptionactivity, List list)
    {
        multioptionactivity.optionList = list;
        return list;
    }

*/






/*
    static Deal access$302(MultiOptionActivity multioptionactivity, Deal deal1)
    {
        multioptionactivity.deal = deal1;
        return deal1;
    }

*/





/*
    static boolean access$602(MultiOptionActivity multioptionactivity, boolean flag)
    {
        multioptionactivity.isAllowedInCart = flag;
        return flag;
    }

*/



}
