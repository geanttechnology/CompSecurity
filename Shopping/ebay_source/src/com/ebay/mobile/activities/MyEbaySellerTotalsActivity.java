// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.net.api.aps.UserActivitySummary;
import com.ebay.common.net.api.trading.GetMyEbaySellerTotalsNetLoader;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.viewitem.ItemViewCommonProgressAndError;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.SellerTotals;
import com.ebay.nautilus.domain.net.api.trading.GetMyEbayResponse;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;
import com.ebay.nautilus.shell.content.FwNetLoader;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseActivity, ErrorDialogActivity

public class MyEbaySellerTotalsActivity extends BaseActivity
    implements android.view.View.OnClickListener
{

    public static final int LOADER_ID_GET_TOTALS = 1;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("MyEbaySellerTotals", 3, "Log My eBay");
    private CurrencyAmount notReceived;
    private CurrencyAmount received;
    private Button retry;
    private SellerTotals sellerTotals;
    private List soldItems;
    private UserActivitySummary userActivitySummary;

    public MyEbaySellerTotalsActivity()
    {
    }

    private void calculatePayments()
    {
        received = null;
        notReceived = null;
        CurrencyAmount currencyamount = null;
        if (soldItems != null && soldItems.size() > 0)
        {
            long l = System.currentTimeMillis();
            long l1 = sellerTotals.soldDurationInDays;
            Iterator iterator = soldItems.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                MyEbayListItem myebaylistitem = (MyEbayListItem)iterator.next();
                if (myebaylistitem != null && myebaylistitem.transaction != null && myebaylistitem.endTimestamp >= l - l1 * 0x5265c00L)
                {
                    if (ItemTransaction.isPaid(myebaylistitem.transaction.paidStatus) || ItemTransaction.isPaidUsingTradingQuirk(myebaylistitem.transaction.paidStatus, myebaylistitem.transaction.paidTime))
                    {
                        if (received == null)
                        {
                            received = new CurrencyAmount(myebaylistitem.transaction.totalTransactionPrice);
                        } else
                        {
                            received = received.add(myebaylistitem.transaction.totalTransactionPrice);
                        }
                    } else
                    if (notReceived == null)
                    {
                        notReceived = new CurrencyAmount(myebaylistitem.transaction.totalTransactionPrice);
                    } else
                    {
                        notReceived = notReceived.add(myebaylistitem.transaction.totalTransactionPrice);
                    }
                    if (currencyamount == null)
                    {
                        currencyamount = new CurrencyAmount(myebaylistitem.transaction.totalTransactionPrice);
                    } else
                    {
                        currencyamount = currencyamount.add(myebaylistitem.transaction.totalTransactionPrice);
                    }
                }
            } while (true);
        }
        if (received == null || notReceived == null)
        {
            EbaySite ebaysite = MyApp.getPrefs().getCurrentSite();
            if (received == null)
            {
                received = new CurrencyAmount(new ItemCurrency(ebaysite.getCurrency().getCurrencyCode(), "0.00"));
            }
            if (notReceived == null)
            {
                notReceived = new CurrencyAmount(new ItemCurrency(ebaysite.getCurrency().getCurrencyCode(), "0.00"));
            }
        }
    }

    private void getSellerTotals()
    {
        ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
        Object obj = EbayApiUtil.getTradingApi(this, MyApp.getPrefs().getAuthentication());
        obj = new GetMyEbaySellerTotalsNetLoader(getEbayContext(), ((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)));
        getFwLoaderManager().start(1, ((FwLoader) (obj)), false);
    }

    public static boolean isIAFTokenError(FwLoader fwloader)
    {
        if (fwloader instanceof EbaySimpleNetLoader)
        {
            if (Util.checkForIAFTokenError((EbaySimpleNetLoader)fwloader))
            {
                return true;
            }
            break MISSING_BLOCK_LABEL_107;
        }
        if (!(fwloader instanceof FwNetLoader))
        {
            break MISSING_BLOCK_LABEL_107;
        }
        fwloader = ((FwNetLoader)fwloader).getException();
        if (fwloader instanceof com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException)
        {
            if (EbayErrorUtil.userNotLoggedIn(((com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException)fwloader).getErrors()))
            {
                return true;
            }
            break MISSING_BLOCK_LABEL_107;
        }
        if (fwloader == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        boolean flag;
        if (fwloader.getMessage() == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if (fwloader.getMessage().contains(EbayErrorUtil.EXPIRED_IAF_TOKEN_STR))
        {
            break MISSING_BLOCK_LABEL_95;
        }
        flag = fwloader.getMessage().contains(EbayErrorUtil.INVALID_IAF_TOKEN_STR);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        return true;
        fwloader;
        logTag.logAsError("isIAFTokenError exception", fwloader);
        return false;
    }

    private void resumeUi()
    {
label0:
        {
            calculatePayments();
            if (sellerTotals != null)
            {
                Object obj = findViewById(0x7f1003cb);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f0705e3));
                ((TextView)((View) (obj)).findViewById(0x7f1003da)).setText(String.valueOf(userActivitySummary.sellingActiveCount));
                obj = findViewById(0x7f1003cc);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f070bc0));
                ((TextView)((View) (obj)).findViewById(0x7f1003da)).setText(String.valueOf(sellerTotals.activeAuctionCount));
                obj = findViewById(0x7f1003cd);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f070190));
                ((TextView)((View) (obj)).findViewById(0x7f1003da)).setText(String.valueOf(sellerTotals.auctionBidCount));
                obj = findViewById(0x7f1003ce);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f07016a));
                ((TextView)((View) (obj)).findViewById(0x7f1003da)).setText(EbayCurrencyUtil.formatDisplay(sellerTotals.totalAuctionSellingValue, 0));
                ((TextView)findViewById(0x7f1003cf)).setText((new StringBuilder()).append(getString(0x7f070ad2)).append(" ").append(getString(0x7f0705d4, new Object[] {
                    Integer.valueOf(sellerTotals.soldDurationInDays)
                })).toString());
                obj = findViewById(0x7f1003d0);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f0705e3));
                ((TextView)((View) (obj)).findViewById(0x7f1003da)).setText(String.valueOf(userActivitySummary.sellingSoldCount + userActivitySummary.sellingUnsoldCount));
                obj = findViewById(0x7f1003d1);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f070ad2));
                ((TextView)((View) (obj)).findViewById(0x7f1003da)).setText(String.valueOf(userActivitySummary.sellingSoldCount));
                obj = findViewById(0x7f1003d2);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f07016a));
                ((TextView)((View) (obj)).findViewById(0x7f1003da)).setText(EbayCurrencyUtil.formatDisplay(sellerTotals.totalSoldValue, 0));
                ((TextView)findViewById(0x7f1003d3)).setText((new StringBuilder()).append(getString(0x7f070a00)).append(" ").append(getString(0x7f0705d4, new Object[] {
                    Integer.valueOf(sellerTotals.soldDurationInDays)
                })).toString());
                obj = findViewById(0x7f1003d4);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f0708d7));
                obj = (TextView)((View) (obj)).findViewById(0x7f1003da);
                ((TextView) (obj)).setText(EbayCurrencyUtil.formatDisplay(received, 0));
                ((TextView) (obj)).setTextColor(getResources().getColor(0x7f0d0063));
                obj = findViewById(0x7f1003d5);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f07068b));
                obj = (TextView)((View) (obj)).findViewById(0x7f1003da);
                ((TextView) (obj)).setText(EbayCurrencyUtil.formatDisplay(notReceived, 0));
                ((TextView) (obj)).setTextColor(getResources().getColor(0x7f0d0064));
                obj = findViewById(0x7f1003d6);
                TextView textview = (TextView)((View) (obj)).findViewById(0x7f10005f);
                textview.setText(getString(0x7f070b7c));
                textview.setTypeface(Typeface.DEFAULT, 1);
                obj = (TextView)((View) (obj)).findViewById(0x7f1003da);
                ((TextView) (obj)).setText(EbayCurrencyUtil.formatDisplay(sellerTotals.totalSoldValue, 0));
                ((TextView) (obj)).setTypeface(Typeface.DEFAULT, 1);
                if (sellerTotals.quantityLimitRemaining <= 0 || sellerTotals.amountLimitRemaining == null)
                {
                    break label0;
                }
                obj = findViewById(0x7f1003d8);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f0708c4));
                obj = (TextView)((View) (obj)).findViewById(0x7f1003da);
                ((TextView) (obj)).setText(String.valueOf(sellerTotals.quantityLimitRemaining));
                ((TextView) (obj)).setTextColor(getResources().getColor(0x7f0d0064));
                obj = findViewById(0x7f1003d9);
                ((TextView)((View) (obj)).findViewById(0x7f10005f)).setText(getString(0x7f0709ff));
                obj = (TextView)((View) (obj)).findViewById(0x7f1003da);
                ((TextView) (obj)).setText(EbayCurrencyUtil.formatDisplay(sellerTotals.amountLimitRemaining, 0));
                ((TextView) (obj)).setTypeface(Typeface.DEFAULT, 1);
                findViewById(0x7f1003d7).setVisibility(0);
            }
            return;
        }
        findViewById(0x7f1003d7).setVisibility(8);
    }

    public String getTrackingEventName()
    {
        return "MyEbaySellerTotals";
    }

    public void onClick(View view)
    {
        switch (view.getId())
        {
        default:
            return;

        case 2131755327: 
            getSellerTotals();
            break;
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030172);
        getSellerTotals();
        userActivitySummary = (UserActivitySummary)getIntent().getSerializableExtra("user_activity_summary_object");
        retry = (Button)findViewById(0x7f10013f);
        if (retry != null)
        {
            retry.setOnClickListener(this);
        }
    }

    protected void onResume()
    {
        super.onResume();
        (new TrackingData(getTrackingEventName(), TrackingType.PAGE_IMPRESSION)).send(this);
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
        ItemViewCommonProgressAndError.showLayouts(this, com.ebay.mobile.viewitem.ItemViewCommonProgressAndError.LayoutState.NORMAL);
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[] {
                Integer.valueOf(i)
            });
        }
        if (!isFinishing()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        FwNetLoader fwnetloader = (FwNetLoader)fwloader;
        if (!fwnetloader.isError() || fwnetloader.isCanceled())
        {
            continue; /* Loop/switch isn't completed */
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("onTaskComplete: loader reports service error for id=").append(i).toString());
        }
        if (isIAFTokenError(fwloader))
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "onTaskComplete: IAF token is invalid");
            }
            handleIafTokenExpiration();
            return;
        }
        boolean flag = false;
        i = ((flag) ? 1 : 0);
        if (fwnetloader instanceof EbaySimpleNetLoader)
        {
            fwloader = MyApp.getDisplayableServiceError(getEbayContext(), (EbaySimpleNetLoader)fwnetloader);
            i = ((flag) ? 1 : 0);
            if (!TextUtils.isEmpty(fwloader))
            {
                i = 1;
                ErrorDialogActivity.StartActivity(this, MyApp.getMaintenanceTitle(this), fwloader, false);
            }
        }
        if (i == 0 && !Util.hasNetwork())
        {
            showNetworkErrorToast();
            return;
        }
        continue; /* Loop/switch isn't completed */
        if (isFinishing() || fwloader.isCanceled()) goto _L1; else goto _L3
_L3:
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            fwloader = (GetMyEbaySellerTotalsNetLoader)fwloader;
            break;
        }
        if (fwloader.getResponse() != null)
        {
            sellerTotals = ((GetMyEbayResponse)fwloader.getResponse()).sellerTotals;
            if (((GetMyEbayResponse)fwloader.getResponse()).resultItemList != null)
            {
                soldItems = ((GetMyEbayResponse)fwloader.getResponse()).resultItemList;
            } else
            {
                soldItems = null;
            }
            resumeUi();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

}
