// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.util.Linkify;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.EbayTimer;
import com.ebay.common.Preferences;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.viewitem.message.PlaceOfferResultStatus;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.content.dm.ImageDataManager;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ViewItemShippingInfo, ItemViewCommonProgressAndError, ViewItemViewData, 
//            ViewItemPlaceBidActivity, ViewItemDataManager, ItemViewActivity

public class ViewItemConfirmActivity extends ItemViewBaseActivity
    implements android.view.View.OnClickListener, ViewItemDataManager.Observer
{

    public static final String PARAM_API_ERROR_MESSAGE = "bidTooLowErrorMessage";
    static final String PARAM_BID_PRICE = "bidPrice";
    static final String PARAM_BIN_ACTION = "binAction";
    public static final String PARAM_CURRENT_PRICE = "current_price";
    static final String PARAM_INCREMENTAL_BID = "incrementalBid";
    public static final String PARAM_NEW_UI = "use_new_ui";
    static final String PARAM_QUANTITY = "quantity";
    static final String PARAM_USE_LONG_THRESHOLD = "useLongThreshold";
    public static final int RESULT_BID_TOO_LOW = 505;
    public static final int RESULT_INVALID = 503;
    public static final int RESULT_OUTBID = 504;
    public static final int RESULT_PPA_REQUIRED = 502;
    private static String endedString;
    private TextView bidCountView;
    private CurrencyAmount bidPrice;
    private String bidSource;
    private boolean binAction;
    private Button confirmButton;
    private TextView convertedCurrentPriceView;
    private TextView currencyCodeLeftView;
    private TextView currencyCodeRightView;
    private TextView currencyCodeView;
    private TextView currentPriceView;
    private boolean incrementalBid;
    private LayoutInflater inflater;
    private EbayCurrency itemCurrency;
    private EbaySite itemSite;
    private int quantity;
    private String referrer;
    private View reserveNotMetView;
    private TextView timeLeftTextView;
    private final EbayTimer timer = new EbayTimer(1000L);
    private TextView titleTextView;
    private ItemCurrency totalCostWithShipping;
    private boolean useLongThreshold;
    private boolean useNewUi;

    public ViewItemConfirmActivity()
    {
    }

    public static void StartActivity(Activity activity, Fragment fragment, boolean flag, ViewItemViewData viewitemviewdata, int i, CurrencyAmount currencyamount, boolean flag1, String s, 
            String s1, boolean flag2, boolean flag3, int j)
    {
        Object obj;
        if (fragment != null)
        {
            obj = fragment.getActivity();
        } else
        {
            obj = activity;
        }
        obj = new Intent(((Context) (obj)), com/ebay/mobile/viewitem/ViewItemConfirmActivity);
        ((Intent) (obj)).putExtra("view_item_view_data", viewitemviewdata);
        ((Intent) (obj)).putExtra("quantity", i);
        ((Intent) (obj)).putExtra("bidPrice", currencyamount);
        ((Intent) (obj)).putExtra("binAction", flag1);
        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.Referrer", s);
        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.BidSource", s1);
        ((Intent) (obj)).putExtra("incrementalBid", flag2);
        ((Intent) (obj)).putExtra("useLongThreshold", flag3);
        ((Intent) (obj)).putExtra("use_new_ui", flag);
        if (fragment != null)
        {
            fragment.startActivityForResult(((Intent) (obj)), j);
            return;
        } else
        {
            activity.startActivityForResult(((Intent) (obj)), j);
            return;
        }
    }

    private ViewGroup appendLayout(ViewGroup viewgroup, String s, String s1, String s2)
    {
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f030081, viewgroup, false);
        ((TextView)viewgroup1.findViewById(0x7f1000ec)).setText(s);
        s = (TextView)viewgroup1.findViewById(0x7f1000ed);
        if (!TextUtils.isEmpty(s2))
        {
            s1 = (new StringBuilder()).append(s1).append("\n").append(s2).toString();
        }
        s.setText(s1);
        viewgroup.addView(viewgroup1);
        return viewgroup1;
    }

    private CurrencyAmount computeSalesTaxAmount(CurrencyAmount currencyamount, CurrencyAmount currencyamount1)
    {
        CurrencyAmount currencyamount2;
        Object obj;
        Object obj1;
        obj = null;
        currencyamount2 = null;
        obj1 = item.salesTaxPercent;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        currencyamount2 = obj;
        DecimalFormat decimalformat = (DecimalFormat)NumberFormat.getInstance();
        currencyamount2 = obj;
        decimalformat.setParseBigDecimal(true);
        currencyamount2 = obj;
        obj1 = ((BigDecimal)decimalformat.parseObject(((String) (obj1)))).divide(BigDecimal.valueOf(100L));
        currencyamount2 = obj;
        currencyamount = new CurrencyAmount(currencyamount);
        if (!item.isSalesTaxAppliedToShipping)
        {
            break MISSING_BLOCK_LABEL_93;
        }
        currencyamount1 = currencyamount.add(currencyamount1);
        currencyamount = currencyamount1;
        currencyamount2 = currencyamount;
        currencyamount = currencyamount.multiplyBy(((BigDecimal) (obj1)));
        currencyamount2 = currencyamount;
        return currencyamount2;
        currencyamount;
_L2:
        currencyamount.printStackTrace();
        return currencyamount2;
        currencyamount1;
        currencyamount2 = currencyamount;
        currencyamount = currencyamount1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private CurrencyAmount doShipping(ViewGroup viewgroup)
    {
        Object obj = item.shippingInfo;
        ViewItemShippingInfo viewitemshippinginfo = ((ViewItemShippingInfo) (obj));
        if (quantity > 1)
        {
            viewitemshippinginfo = ((ViewItemShippingInfo) (obj));
            if (item.shippingInfoUpdated != null)
            {
                viewitemshippinginfo = item.shippingInfoUpdated;
            }
        }
        obj = getTotalShippingCost(getResources(), item, quantity);
        ViewGroup viewgroup1 = (ViewGroup)inflater.inflate(0x7f03013b, viewgroup, false);
        viewitemshippinginfo.setupShipping(this, item, viewgroup1, ThemeUtil.resolveThemeForegroundColorResId(getTheme(), 0x1010036), false, true);
        viewgroup.addView(viewgroup1);
        viewgroup = viewgroup.findViewById(0x7f10031e);
        if (viewgroup != null && item.isGspItem)
        {
            viewgroup.setOnClickListener(this);
        }
        return ((CurrencyAmount) (obj));
    }

    private String getButtonTitleString()
    {
        binAction = getIntent().getBooleanExtra("binAction", false);
        int i;
        if (binAction)
        {
            i = 0x7f070084;
        } else
        {
            i = 0x7f070085;
        }
        if (MyApp.getPrefs().getCurrentSite().isEuSite())
        {
            if (binAction)
            {
                i = 0x7f070069;
            } else
            {
                i = 0x7f07006a;
            }
        }
        return getString(i);
    }

    private CurrencyAmount getSalesTax(CurrencyAmount currencyamount, CurrencyAmount currencyamount1)
    {
        CurrencyAmount currencyamount2 = null;
        if (!item.isVatIncluded())
        {
            currencyamount2 = computeSalesTaxAmount(currencyamount, currencyamount1);
        }
        return currencyamount2;
    }

    public static CurrencyAmount getTotalShippingCost(Resources resources, Item item, int i)
    {
        Object obj = item.shippingInfo;
        ViewItemShippingInfo viewitemshippinginfo = ((ViewItemShippingInfo) (obj));
        if (i > 1)
        {
            viewitemshippinginfo = ((ViewItemShippingInfo) (obj));
            if (item.shippingInfoUpdated != null)
            {
                viewitemshippinginfo = item.shippingInfoUpdated;
            }
        }
        Object obj1 = null;
        obj = obj1;
        if (!ViewItemShippingInfo.IsLocalPickupOnly(item))
        {
            resources = ViewItemShippingInfo.getShippingService(resources, item);
            obj = obj1;
            if (viewitemshippinginfo.shippingServiceCost != null)
            {
                obj = obj1;
                if (!TextUtils.isEmpty(resources))
                {
                    resources = new CurrencyAmount(viewitemshippinginfo.shippingServiceCost);
                    obj = resources;
                    if (item.isGspItem)
                    {
                        obj = resources.add(new CurrencyAmount(viewitemshippinginfo.importCharge));
                    }
                }
            }
        }
        return ((CurrencyAmount) (obj));
    }

    private void setUI()
    {
        if (item == null)
        {
            return;
        }
        if (useNewUi)
        {
            setUIReviewBidDesign();
            return;
        } else
        {
            setUIBINorOldPlaceBid();
            return;
        }
    }

    private void setUIBINorOldPlaceBid()
    {
        ViewGroup viewgroup = (ViewGroup)findViewById(0x7f100307);
        viewgroup.removeAllViews();
        ViewGroup viewgroup1 = (ViewGroup)findViewById(0x7f100308);
        viewgroup1.removeAllViews();
        Object obj = (Button)findViewById(0x7f10030a);
        ((Button) (obj)).setVisibility(0);
        ((Button) (obj)).setOnClickListener(this);
        ((Button) (obj)).setText(getButtonTitleString());
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
        setTakeActionButtonEnabled(this, true);
        int i;
        int j;
        if (item.isDisplayPriceCurrencyCode)
        {
            i = 0;
        } else
        {
            i = 2;
        }
        obj = findViewById(0x7f100309);
        if (item.isUserConsentRequired)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        ((View) (obj)).setVisibility(j);
        boolean flag;
        if (binAction)
        {
            Object obj1 = item.buyItNowPrice;
            ItemCurrency itemcurrency = ((ItemCurrency) (obj1));
            if (item.isMultiSku)
            {
                itemcurrency = ((ItemCurrency) (obj1));
                if (item.hasMultiSkuValues(viewData.nameValueList))
                {
                    itemcurrency = item.currentPriceForType(getEbayContext(), viewData, false);
                }
            }
            ((TextView)appendLayout(viewgroup, getString(0x7f0701b7), EbayCurrencyUtil.formatDisplay(itemcurrency, i), null).findViewById(0x7f1000ed)).setTypeface(null, 1);
            if (quantity > 1)
            {
                appendLayout(viewgroup, getString(0x7f0708c4), (new StringBuilder()).append("").append(quantity).toString(), null);
            }
            if (viewData.nameValueList != null && !viewData.nameValueList.isEmpty())
            {
                obj1 = new StringBuilder();
                NameValue namevalue;
                for (Iterator iterator = viewData.nameValueList.iterator(); iterator.hasNext(); ((StringBuilder) (obj1)).append(namevalue.getName()).append(": ").append(namevalue.getValue()))
                {
                    namevalue = (NameValue)iterator.next();
                    if (((StringBuilder) (obj1)).length() != 0)
                    {
                        ((StringBuilder) (obj1)).append(", ");
                    }
                }

                appendLayout(viewgroup, getString(0x7f070740), ((StringBuilder) (obj1)).toString(), null);
            }
            CurrencyAmount currencyamount1 = doShipping(viewgroup);
            CurrencyAmount currencyamount = (new CurrencyAmount(itemcurrency)).multiplyBy(quantity);
            CurrencyAmount currencyamount2 = getSalesTax(currencyamount, currencyamount1);
            obj1 = currencyamount;
            if (currencyamount2 != null)
            {
                appendLayout(viewgroup, getString(0x7f0704e0), (new StringBuilder()).append("").append(currencyamount2).toString(), null);
                obj1 = currencyamount.add(currencyamount2);
            }
            currencyamount = ((CurrencyAmount) (obj1));
            if (currencyamount1 != null)
            {
                currencyamount = ((CurrencyAmount) (obj1)).add(currencyamount1);
            }
            obj1 = Item.convertDepositAmountToString(item);
            if (!TextUtils.isEmpty(((CharSequence) (obj1))))
            {
                appendLayout(viewgroup, getString(0x7f07028d), ((String) (obj1)), null);
            }
            totalCostWithShipping = currencyamount.toItemCurrency();
            obj1 = inflater.inflate(0x7f030138, viewgroup, false);
            viewgroup1.addView(((View) (obj1)));
            ((TextView)((View) (obj1)).findViewById(0x7f10030c)).setText(0x7f0707b1);
            ((TextView)((View) (obj1)).findViewById(0x7f10030d)).setText(EbayCurrencyUtil.formatDisplay(itemcurrency, i));
            if (quantity > 1)
            {
                ((View) (obj1)).findViewById(0x7f10030e).setVisibility(0);
                ((TextView)((View) (obj1)).findViewById(0x7f10030f)).setText(String.valueOf(quantity));
            }
            if (currencyamount1 != null)
            {
                ((View) (obj1)).findViewById(0x7f100310).setVisibility(0);
                ((TextView)((View) (obj1)).findViewById(0x7f100311)).setText(EbayCurrencyUtil.formatDisplay(currencyamount1, i));
            }
            if (currencyamount2 != null)
            {
                ((View) (obj1)).findViewById(0x7f100312).setVisibility(0);
                ((TextView)((View) (obj1)).findViewById(0x7f100313)).setText(EbayCurrencyUtil.formatDisplay(currencyamount2, i));
            }
            ((TextView)((View) (obj1)).findViewById(0x7f100314)).setText(0x7f070b7a);
            ((TextView)((View) (obj1)).findViewById(0x7f100315)).setText(EbayCurrencyUtil.formatDisplay(currencyamount, i));
        } else
        {
            doShipping(viewgroup);
            View view = inflater.inflate(0x7f030138, viewgroup, false);
            viewgroup1.addView(view);
            ((TextView)view.findViewById(0x7f10030d)).setText(EbayCurrencyUtil.formatDisplay(item.currentPrice, 0));
            ((TextView)view.findViewById(0x7f100315)).setText(EbayCurrencyUtil.formatDisplay(bidPrice, i));
        }
        appendLayout(viewgroup, "", "", null).setId(0x7f100893);
        updateTimeLeft();
        setupWarningText();
        if (!binAction)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        headerStart(0x7f03012e, flag, quantity);
    }

    private void setUIReviewBidDesign()
    {
        Object obj1 = (ViewGroup)findViewById(0x7f1004c3);
        Object obj;
        int i;
        if (obj1 == null || ((ViewGroup) (obj1)).getChildCount() == 0)
        {
            findViewById(0x7f1004d4).setVisibility(8);
            confirmButton = (Button)findViewById(0x7f1004d7);
            confirmButton.setVisibility(0);
            confirmButton.setOnClickListener(this);
            confirmButton.setText(getButtonTitleString());
            obj = obj1;
            if (obj1 == null)
            {
                obj = (ViewGroup)findViewById(0x7f1004c3);
            }
            boolean flag;
            if (item.isDisplayPriceCurrencyCode)
            {
                i = 0x7f03028d;
            } else
            {
                i = 0x7f03028f;
            }
            obj = View.inflate(this, i, ((ViewGroup) (obj)));
            findViewById(0x7f1004c5).setVisibility(8);
            if (titleTextView == null)
            {
                titleTextView = (TextView)findViewById(0x7f10005f);
            }
            if (bidCountView == null)
            {
                bidCountView = (TextView)findViewById(0x7f100374);
            }
            currencyCodeLeftView = (TextView)findViewById(0x7f1004c8);
            currencyCodeRightView = (TextView)findViewById(0x7f1004ca);
            itemSite = EbaySite.getInstanceFromId(item.site);
            itemCurrency = itemSite.getCurrency();
            if (itemCurrency.isSymbolOnLeft())
            {
                currencyCodeView = currencyCodeLeftView;
            } else
            {
                currencyCodeView = currencyCodeRightView;
                currencyCodeLeftView.setVisibility(8);
                currencyCodeRightView.setVisibility(0);
            }
            obj1 = (TextView)findViewById(0x7f1004c9);
            if (obj1 != null)
            {
                String s = item.getCurrencySymbol(itemCurrency);
                currencyCodeView.setText(s);
                ((TextView) (obj1)).setText(ViewItemPlaceBidActivity.getBidAmountTerse(bidPrice.getValueAsString()));
            }
            if (reserveNotMetView == null)
            {
                reserveNotMetView = findViewById(0x7f1008ae);
            }
            ((TextView)findViewById(0x7f1004c6)).setText(getString(0x7f070937));
            if (currentPriceView == null)
            {
                currentPriceView = (TextView)((View) (obj)).findViewById(0x7f1008ac);
            }
            if (item.isDisplayPriceCurrencyCode && convertedCurrentPriceView == null)
            {
                convertedCurrentPriceView = (TextView)((View) (obj)).findViewById(0x7f1008ad);
            }
        }
        if (titleTextView != null)
        {
            obj = titleTextView;
            if (item.isShowTitleBidFlow)
            {
                i = 0;
            } else
            {
                i = 8;
            }
            ((TextView) (obj)).setVisibility(i);
            if (item.isShowTitleBidFlow)
            {
                titleTextView.setText(item.title.getContent(DeviceConfiguration.getAsync().get(DcsBoolean.itemTitleTranslationEnabled)));
            }
        }
        if (bidCountView != null)
        {
            bidCountView.setText(String.format(getResources().getQuantityString(0x7f08001b, item.bidCount), new Object[] {
                Integer.valueOf(item.bidCount)
            }));
        }
        if (reserveNotMetView != null)
        {
            obj = reserveNotMetView;
            if (item.isReserveMet)
            {
                i = 8;
            } else
            {
                i = 0;
            }
            ((View) (obj)).setVisibility(i);
        }
        currentPriceView.setText(item.displayCurrentPrice);
        findViewById(0x7f1004cb).setVisibility(0);
        obj = (TextView)findViewById(0x7f10031a);
        if (!TextUtils.isEmpty(item.displayShippingAmountItemCard))
        {
            ((TextView) (obj)).setText(String.format(getString(0x7f070933), new Object[] {
                item.displayShippingAmountItemCard
            }));
        } else
        {
            ((TextView) (obj)).setVisibility(8);
        }
        if (convertedCurrentPriceView != null)
        {
            convertedCurrentPriceView.setText(item.getApproximatelyString(getEbayContext(), 0x7f07016e, item.displayCurrentPriceConverted));
        }
        if (item.isDisplayPriceCurrencyCode)
        {
            TextView textview = (TextView)findViewById(0x7f1004cd);
            obj = viewItemDataManager.getCurrencyConversionRate();
            if (obj != null)
            {
                obj1 = String.valueOf(Double.valueOf(bidPrice.getValueAsDouble()));
                ItemCurrency itemcurrency = Item.convertCurrency(getEbayContext(), ViewItemPlaceBidActivity.getEnteredBidAmount(bidPrice.getCurrencyCode(), ((String) (obj1))), ((com.ebay.common.model.currency.CurrencyConversionRate) (obj)));
                if (itemcurrency != null)
                {
                    flag = false;
                    obj = item.displayPriceShippingConvertedRaw;
                    Object obj2 = obj;
                    i = ((flag) ? 1 : 0);
                    if (TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        if (!TextUtils.isEmpty(item.displayPriceShippingConverted))
                        {
                            obj = item.displayPriceShippingConverted;
                        }
                        obj2 = obj;
                        i = ((flag) ? 1 : 0);
                        if (TextUtils.isEmpty(((CharSequence) (obj))))
                        {
                            i = 1;
                            obj2 = obj;
                        }
                    }
                    if (i != 0)
                    {
                        obj = new SpannableStringBuilder(item.getShippingMessage(this, 0, 0));
                        obj2 = new SpannableStringBuilder(String.format(getString(0x7f07016f), new Object[] {
                            EbayCurrencyUtil.formatDisplay(itemcurrency, item.getCurrencyUtilFlag())
                        }));
                        if (((SpannableStringBuilder) (obj)).length() > 0)
                        {
                            ((SpannableStringBuilder) (obj)).append("\n");
                            ((SpannableStringBuilder) (obj2)).insert(0, ((CharSequence) (obj)));
                        }
                        textview.setText(((CharSequence) (obj2)), android.widget.TextView.BufferType.SPANNABLE);
                    } else
                    {
                        textview.setText(String.format(getString(0x7f070930), new Object[] {
                            EbayCurrencyUtil.formatDisplay(itemcurrency, item.getCurrencyUtilFlag()), obj2
                        }));
                    }
                    textview.setVisibility(0);
                }
            }
        }
        if (item.shippingInfo != null && item.shippingInfo.shippingServiceCost != null)
        {
            obj = new CurrencyAmount(item.shippingInfo.shippingServiceCost);
        } else
        {
            obj = null;
        }
        obj = getSalesTax(bidPrice, ((CurrencyAmount) (obj)));
        if (obj != null)
        {
            obj2 = (TextView)findViewById(0x7f1004ce);
            ((TextView) (obj2)).setText(String.format(getString(0x7f070932), new Object[] {
                EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), item.getCurrencyUtilFlag())
            }));
            ((TextView) (obj2)).setVisibility(0);
        }
        if (item.importCharges != null)
        {
            obj = (TextView)findViewById(0x7f1004cc);
            ((TextView) (obj)).setText(String.format(getString(0x7f070931), new Object[] {
                item.displayPriceImportCharges
            }));
            ((TextView) (obj)).setVisibility(0);
        }
        if (item.isGspItem)
        {
            obj = (TextView)findViewById(0x7f1004d3);
            Linkify.addLinks(((TextView) (obj)), 15);
            ((TextView) (obj)).setOnClickListener(this);
            ((TextView) (obj)).setText(getString(0x7f070b53));
            ((TextView) (obj)).setVisibility(0);
        }
        obj = (TextView)findViewById(0x7f1004d5);
        if (obj != null)
        {
            ViewItemPlaceBidActivity.setBidAgreementBlurb(this, item, ((TextView) (obj)));
        }
        obj = findViewById(0x7f100309);
        if (item.isUserConsentRequired)
        {
            i = 0;
        } else
        {
            i = 8;
        }
        ((View) (obj)).setVisibility(i);
        findViewById(0x7f1004d8).setVisibility(8);
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
        setTakeActionButtonEnabled(this, true);
    }

    private void setupTimer()
    {
        timer.setOnTimerEvent(new com.ebay.common.EbayTimer.OnTimerEvent() {

            final ViewItemConfirmActivity this$0;

            public void OnTimer()
            {
                updateTimeLeft();
            }

            
            {
                this$0 = ViewItemConfirmActivity.this;
                super();
            }
        });
    }

    private void setupWarningText()
    {
        TextView textview = (TextView)findViewById(0x7f10030b);
        if (item.isGspItem)
        {
            String s;
            String s1;
            if (MyApp.getPrefs().getCurrentSite().isEuSite())
            {
                int i;
                if (binAction)
                {
                    i = 0x7f070060;
                } else
                {
                    i = 0x7f07005f;
                }
                s = getString(i);
                s1 = getString(0x7f070073);
            } else
            {
                int j;
                if (binAction)
                {
                    j = 0x7f070095;
                } else
                {
                    j = 0x7f070094;
                }
                s = getString(j);
                s1 = getString(0x7f070092);
            }
            Util.buildTextViewWithHyperLink(textview, s, getGspTermsAndConditionsUrl(item), s1);
            return;
        }
        int k;
        if (MyApp.getPrefs().getCurrentSite().isEuSite())
        {
            if (binAction)
            {
                k = 0x7f070075;
            } else
            {
                k = 0x7f070074;
            }
        } else
        if (binAction)
        {
            k = 0x7f0700ab;
        } else
        {
            k = 0x7f0700aa;
        }
        textview.setText(Html.fromHtml(getString(k)));
    }

    private void updateTimeLeft()
    {
        if (!binAction && item.isShowReviewBid)
        {
            if (timeLeftTextView == null)
            {
                timeLeftTextView = (TextView)findViewById(0x7f1002f4);
            }
            ViewItemPlaceBidActivity.updateTimeLeft(this, timeLeftTextView, viewData, item, false, useLongThreshold);
            if (item != null && item.isAuctionEnded || timeLeftTextView != null && timeLeftTextView.getText().toString().equals(endedString))
            {
                animateFinishItemEnded();
            }
        } else
        {
            ViewGroup viewgroup = (ViewGroup)findViewById(0x7f100893);
            UpdateTimeLeft(this, viewData, item, viewgroup, false, useLongThreshold);
            if (!item.isScheduled && item.isAuctionEnded && !viewItemDataManager.isLoadingComplete())
            {
                ItemViewCommonProgressAndError.setPrimaryErrorMessage(this, getString(0x7f07017b));
                ItemViewCommonProgressAndError.setOkNotRetry(this).setOnClickListener(this);
                setTakeActionButtonEnabled(this, false);
                ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.CUSTOM_ERROR);
                return;
            }
        }
    }

    public void UpdateTimeLeft(Context context, ViewItemViewData viewitemviewdata, Item item, ViewGroup viewgroup, boolean flag, boolean flag1)
    {
        TextView textview = (TextView)viewgroup.findViewById(0x7f1000ec);
        TextView textview1 = (TextView)viewgroup.findViewById(0x7f1000ed);
        Resources resources = context.getResources();
        int j = context.getResources().getColor(ThemeUtil.resolveThemeForegroundColorResId(context.getTheme(), 0x7f01004e));
        int k = context.getResources().getColor(0x7f0d0005);
        if (item.isScheduled)
        {
            if (textview != null)
            {
                textview.setText(resources.getString(0x7f070188));
            }
            textview1.setText(item.getRenderedDate(context, viewitemviewdata.kind, item.startDate, j, k, flag, flag1));
            return;
        }
        int i = 0x7f070b5a;
        if (item.isAuctionEnded)
        {
            i = 0x7f0703c3;
        }
        if (textview != null)
        {
            textview.setText(resources.getString(i));
        }
        if (item.endDate != null)
        {
            textview1.setText(item.getRenderedDate(context, viewitemviewdata.kind, item.endDate, j, k, flag, flag1));
        }
        if (item.endDate == null || item.isHideTimeLeft)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        viewgroup.setVisibility(i);
    }

    public void onBidUpdated(ViewItemDataManager viewitemdatamanager, Content content)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                content
            });
        }
        while (isFinishing() || !DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidFlow)) 
        {
            return;
        }
        if (!content.getStatus().hasError())
        {
            item = ((ViewItemDataManager.ViewItemLiteInfo)content.getData()).item;
            if (item == null && ItemViewActivity.logTag.isLoggable)
            {
                ItemViewActivity.logTag.logAsError("onBidUpdated set item to null");
            }
            viewitemdatamanager = ((ViewItemDataManager.ViewItemLiteInfo)content.getData()).bidEvent;
            if (((ViewItemDataManager.BidEvent) (viewitemdatamanager)).changed && ((ViewItemDataManager.BidEvent) (viewitemdatamanager)).vibrate)
            {
                Util.vibratePhone(this);
            }
            if (item.isAuctionEnded)
            {
                setResult(20);
                finish();
                overridePendingTransition(0, 0x7f04000c);
                return;
            } else
            {
                setUI();
                return;
            }
        } else
        {
            EbayErrorHandler.handleResultStatus(this, 0, content.getStatus());
            return;
        }
    }

    public void onClick(View view)
    {
        view.getId();
        JVM INSTR lookupswitch 8: default 80
    //                   2131755327: 91
    //                   2131755328: 81
    //                   2131755356: 86
    //                   2131755786: 91
    //                   2131755806: 291
    //                   2131756228: 86
    //                   2131756243: 291
    //                   2131756247: 91;
           goto _L1 _L2 _L3 _L4 _L2 _L5 _L4 _L5 _L2
_L1:
        return;
_L3:
        finish();
        return;
_L4:
        finish();
        return;
_L2:
        if (!Util.hasNetwork())
        {
            showButterBarMessage(view.getId(), getNetworkErrorToastString(), true);
            return;
        }
        com.ebay.nautilus.domain.app.Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            if (view.getId() == 0x7f1004d7)
            {
                trackBidEvent("ViewItemConfirmBidTap");
            }
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
            setTakeActionButtonEnabled(this, false);
            String s;
            if (binAction)
            {
                s = "Purchase";
            } else
            {
                s = "Bid";
            }
            if (binAction)
            {
                if (item.isMultiSku)
                {
                    view = item.currentPriceForType(getEbayContext(), viewData, false);
                } else
                {
                    view = item.buyItNowPrice;
                }
            } else
            {
                view = bidPrice.toItemCurrency();
            }
            if (viewItemDataManager != null)
            {
                viewItemDataManager.placeOffer(EbayApiUtil.getTradingApi(this, authentication), item.id, s, view, quantity, viewData.nameValueList, null, null, false, totalCostWithShipping, bidSource, referrer, incrementalBid, item.isUserConsentRequired);
                return;
            }
        }
          goto _L1
_L5:
        showGspTermsAndConditions();
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        inflater = (LayoutInflater)getSystemService("layout_inflater");
        bundle = getIntent();
        viewData = (ViewItemViewData)bundle.getParcelableExtra("view_item_view_data");
        quantity = bundle.getIntExtra("quantity", 1);
        bidPrice = (CurrencyAmount)bundle.getParcelableExtra("bidPrice");
        referrer = bundle.getStringExtra("com.ebay.mobile.tracking.Referrer");
        bidSource = bundle.getStringExtra("com.ebay.mobile.tracking.BidSource");
        incrementalBid = bundle.getBooleanExtra("incrementalBid", false);
        useLongThreshold = bundle.getBooleanExtra("useLongThreshold", false);
        useNewUi = bundle.getBooleanExtra("use_new_ui", false);
        int i;
        if (useNewUi)
        {
            i = 0x7f0301a2;
        } else
        {
            i = 0x7f030137;
        }
        setContentView(i);
        if (useNewUi)
        {
            findViewById(0x7f1004c4).setOnClickListener(this);
        }
        endedString = getString(0x7f0703c3);
        initDataManagers();
        setResult(0);
        bundle = findViewById(0x7f10013f);
        if (bundle != null)
        {
            bundle.setOnClickListener(this);
        }
    }

    public void onDataChanged(ViewItemDataManager viewitemdatamanager, Content content, ViewItemDataManager.ActionHandled actionhandled, boolean flag)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                content, actionhandled, Boolean.valueOf(flag)
            });
        }
        if (isFinishing())
        {
            return;
        }
        super.onDataChanged(viewitemdatamanager, content, actionhandled, flag);
        if (!content.getStatus().hasError())
        {
            static class _cls2
            {

                static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

                static 
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror) { }
                }
            }

            switch (_cls2..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()])
            {
            default:
                return;

            case 1: // '\001'
                setupTimer();
                break;
            }
            setUI();
            return;
        } else
        {
            EbayErrorHandler.handleResultStatus(this, actionhandled.ordinal(), content.getStatus());
            return;
        }
    }

    public void onDismissMessage(int i, boolean flag)
    {
        if (flag)
        {
            onClick(findViewById(i));
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        super.onInitializeDataManagers(datamanagercontainer);
        viewItemDataManager = (ViewItemDataManager)datamanagercontainer.initialize(viewData.keyParams, this);
        viewItemDataManager.loadData(this, viewData);
        if (ItemViewActivity.logTag.isLoggable)
        {
            ItemViewActivity.logTag.log((new StringBuilder()).append("onInitializeDataManagers, viewItemDataManager=").append(viewItemDataManager.toString()).toString());
        }
    }

    public void onLoadImageComplete(ImageDataManager imagedatamanager, Content content)
    {
        while (isFinishing() || content == null) 
        {
            return;
        }
        headerSetThumbnail(((com.ebay.nautilus.domain.content.dm.ImageDataManager.ImageInfo)content.getData()).image);
    }

    protected void onPause()
    {
        timer.stop();
        super.onPause();
    }

    public void onPlaceOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content)
    {
        if (!isFinishing())
        {
            if (!content.getStatus().hasError() || content.getData() != null && ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus != null && (((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus.getResultCode() == 505 || ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus.getResultCode() == 502))
            {
                PlaceOfferResultStatus placeofferresultstatus = ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus;
                Intent intent = new Intent();
                item = (Item)((ViewItemDataManager.PlaceOfferInfo)content.getData()).item.getData();
                if (viewData.keyParams.transactionId == null && item.transactionId != null || viewData.keyParams.transactionId != null && item.transactionId != null && !item.transactionId.equals(viewData.keyParams.transactionId))
                {
                    intent.putExtra("transaction_id", item.transactionId);
                }
                int i;
                if (binAction)
                {
                    viewitemdatamanager = item.buyItNowPrice;
                } else
                {
                    viewitemdatamanager = bidPrice.toItemCurrency();
                }
                i = ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus.getResultCode();
                if (i != 505 && i != 502)
                {
                    if (binAction)
                    {
                        viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.Won;
                    } else
                    {
                        viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.Bidding;
                    }
                    viewItemDataManager.setBidItemMaxPrice(item.id, viewData.nameValueList, viewitemdatamanager);
                }
                intent.putExtra("view_item_view_data", viewData);
                if (i == 505)
                {
                    viewitemdatamanager = ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus.getBundle();
                    intent.putExtra("current_price", viewitemdatamanager.getParcelable("current_price"));
                    intent.putExtra("bidTooLowErrorMessage", viewitemdatamanager.getString("bidTooLowErrorMessage"));
                }
                setResult(placeofferresultstatus.getResultCode(), intent);
                MyEbayLandingActivity.setBuyingInvalid(getEbayContext());
                if (placeofferresultstatus.isFinish())
                {
                    finish();
                    return;
                }
            } else
            {
                if (MyApp.getPrefs().isSignedIn() && EbayErrorUtil.userNotLoggedIn(content.getStatus().getMessages()))
                {
                    EbayErrorHandler.handleResultStatus(this, 0, content.getStatus());
                    return;
                }
                ItemViewCommonProgressAndError.LayoutState layoutstate = ItemViewCommonProgressAndError.updateLayoutForLoaderError(this, content.getStatus());
                viewitemdatamanager = layoutstate;
                if (layoutstate != ItemViewCommonProgressAndError.LayoutState.CONNECTION_ERROR)
                {
                    content = ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus.getBundle().getString(PlaceOfferResultStatus.KEY_MSG);
                    viewitemdatamanager = layoutstate;
                    if (!TextUtils.isEmpty(content))
                    {
                        ItemViewCommonProgressAndError.setPrimaryErrorMessage(this, content);
                        ItemViewCommonProgressAndError.setOkNotRetry(this).setOnClickListener(this);
                        viewitemdatamanager = ItemViewCommonProgressAndError.LayoutState.CUSTOM_ERROR;
                    }
                }
                setTakeActionButtonEnabled(this, false);
                ItemViewCommonProgressAndError.showLayouts(this, viewitemdatamanager);
                return;
            }
        }
    }

    public boolean onPrepareOptionsMenu(Menu menu)
    {
        menu.clear();
        return true;
    }

    protected void onResume()
    {
        super.onResume();
        timer.start();
        (new TrackingData("ViewItemConfirmBidDialog", TrackingType.PAGE_IMPRESSION)).send(this);
    }

}
