// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Html;
import android.text.InputFilter;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import com.ebay.common.EbayTimer;
import com.ebay.common.Preferences;
import com.ebay.common.model.AllBiddersData;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.util.Debug;
import com.ebay.common.util.EbayErrorUtil;
import com.ebay.common.view.EbayErrorHandler;
import com.ebay.mobile.Item;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.BaseActivity;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.notifications.NotificationTrackingUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.viewitem.fragments.ViewItemFragmentBiddingUtil;
import com.ebay.mobile.viewitem.message.PlaceOfferResultStatus;
import com.ebay.mobile.widget.PriceView;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.analytics.DeviceInfoUtil;
import com.ebay.nautilus.domain.content.Content;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBaseActivity, ViewItemDataManager, ItemViewActivity, ItemViewBidTracking, 
//            ViewItemConfirmActivity, ItemViewCommonProgressAndError, ViewItemViewData

public class ViewItemPlaceBidActivity extends ItemViewBaseActivity
    implements TextWatcher, android.view.View.OnClickListener, android.view.View.OnKeyListener, android.view.View.OnTouchListener, android.widget.TextView.OnEditorActionListener, ViewItemDataManager.Observer
{
    protected static class DecimalDigitsInputFilter
        implements InputFilter
    {

        static final Pattern pattern = Pattern.compile("\\d*([\\,\\.][\\d]{0,1})?");

        public CharSequence filter(CharSequence charsequence, int i, int j, Spanned spanned, int k, int l)
        {
            if (!pattern.matcher(spanned).matches())
            {
                return "";
            } else
            {
                return null;
            }
        }


        protected DecimalDigitsInputFilter()
        {
        }
    }

    private class PowerBidValueInfo
    {

        public final ItemCurrency amount;
        public final String amountStr;
        public final View layout;
        public final TextView textview;
        final ViewItemPlaceBidActivity this$0;

        public PowerBidValueInfo(TextView textview1, View view, String s, ItemCurrency itemcurrency)
        {
            this$0 = ViewItemPlaceBidActivity.this;
            super();
            textview = textview1;
            layout = view;
            amountStr = s;
            amount = itemcurrency;
        }
    }


    private static final String PARAM_CURRENCY_SYMBOL = "currency_symbol";
    private static final String PARAM_ITEM_CURRENCY = "item_currency";
    private static final String PARAM_PRICE_VIEW_PBV = "priceViewIsPbv";
    private static final String PARAM_PRICE_VIEW_STRING = "priceViewString";
    private static final String PARAM_USE_LONG_THRESHOLD = "useLongThreshold";
    private static int defaultColor;
    private static String endedString;
    private static int shortTimeColor;
    private TextView bidAmountConvertedView;
    private TextView bidAmountView;
    private TextView bidCountView;
    private String bidSource;
    private TextView confirmButton;
    private TextView convertedCurrentPriceView;
    private TextView currencyCodeLeftView;
    private TextView currencyCodeRightView;
    private TextView currencyCodeView;
    private String currencySymbol;
    private TextView currentPriceView;
    private TextView errorTextView;
    private EbayCurrency itemCurrency;
    private String itemCurrencyCode;
    private ItemCurrency pbvAmountEntered;
    private View powerBidValue1Layout;
    private TextView powerBidValue1View;
    private View powerBidValue2Layout;
    private TextView powerBidValue2View;
    private View powerBidValue3Layout;
    private TextView powerBidValue3View;
    private View powerBidValuesLayout;
    private PriceView priceView;
    private String priceViewString;
    private String referrer;
    private View reserveNotMetView;
    private TextView reviewButton;
    private TextView timeLeftTextView;
    private final EbayTimer timer = new EbayTimer(1000L);
    private TextView titleTextView;
    private boolean useLongThreshold;
    private String userCurrencyCode;

    public ViewItemPlaceBidActivity()
    {
    }

    private void doFadeAnimation(View view, final List values)
    {
        if (!isFinishing())
        {
            final Animation fadeInAnimation = AnimationUtils.loadAnimation(this, 0x7f04000a);
            Animation animation = AnimationUtils.loadAnimation(this, 0x7f04000b);
            if (view != null && values != null)
            {
                animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                    final ViewItemPlaceBidActivity this$0;
                    final Animation val$fadeInAnimation;
                    final List val$values;

                    public void onAnimationEnd(Animation animation1)
                    {
                        if (!isFinishing())
                        {
                            int i = 0;
                            for (animation1 = values.iterator(); animation1.hasNext();)
                            {
                                PowerBidValueInfo powerbidvalueinfo = (PowerBidValueInfo)animation1.next();
                                powerbidvalueinfo.textview.setText(powerbidvalueinfo.amountStr);
                                powerbidvalueinfo.textview.setContentDescription(powerbidvalueinfo.amountStr);
                                powerbidvalueinfo.layout.setTag(powerbidvalueinfo.amount);
                                powerbidvalueinfo.layout.setTag(0x7f070b7e, Integer.valueOf(i));
                                powerbidvalueinfo.layout.setOnClickListener(ViewItemPlaceBidActivity.this);
                                i++;
                            }

                            if (fadeInAnimation != null)
                            {
                                fadeInAnimation.start();
                            }
                        }
                    }

                    public void onAnimationRepeat(Animation animation1)
                    {
                    }

                    public void onAnimationStart(Animation animation1)
                    {
                    }

            
            {
                this$0 = ViewItemPlaceBidActivity.this;
                values = list;
                fadeInAnimation = animation;
                super();
            }
                });
                view.startAnimation(animation);
                return;
            }
        }
    }

    private void doFadeAnimation(final TextView view, final String value)
    {
        if (!isFinishing())
        {
            final Animation fadeInAnimation = AnimationUtils.loadAnimation(this, 0x7f04000a);
            Animation animation = AnimationUtils.loadAnimation(this, 0x7f04000b);
            if (view != null)
            {
                animation.setAnimationListener(new android.view.animation.Animation.AnimationListener() {

                    final ViewItemPlaceBidActivity this$0;
                    final Animation val$fadeInAnimation;
                    final String val$value;
                    final TextView val$view;

                    public void onAnimationEnd(Animation animation1)
                    {
                        if (!isFinishing())
                        {
                            view.setText(value);
                            if (fadeInAnimation != null)
                            {
                                fadeInAnimation.start();
                            }
                        }
                    }

                    public void onAnimationRepeat(Animation animation1)
                    {
                    }

                    public void onAnimationStart(Animation animation1)
                    {
                    }

            
            {
                this$0 = ViewItemPlaceBidActivity.this;
                view = textview;
                value = s;
                fadeInAnimation = animation;
                super();
            }
                });
                view.startAnimation(animation);
                return;
            }
        }
    }

    private String getBidAmountString()
    {
        return bidAmountView.getText().toString().replaceAll(",", ".");
    }

    public static String getBidAmountTerse(String s)
    {
        if (s != null) goto _L2; else goto _L1
_L1:
        String s1 = "0";
_L4:
        return s1;
_L2:
        if (s.endsWith(".00") || s.endsWith(",00") || s.endsWith(".0"))
        {
            break; /* Loop/switch isn't completed */
        }
        s1 = s;
        if (!s.endsWith(",0")) goto _L4; else goto _L3
_L3:
        int i = s.lastIndexOf(".00");
        if (i != -1)
        {
            return s.substring(0, i);
        }
        i = s.lastIndexOf(",00");
        if (i != -1)
        {
            return s.substring(0, i);
        }
        i = s.lastIndexOf(".0");
        if (i != -1)
        {
            return s.substring(0, i);
        }
        i = s.lastIndexOf(",0");
        s1 = s;
        if (i != -1)
        {
            return s.substring(0, i);
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    public static ItemCurrency getEnteredBidAmount(String s, String s1)
    {
        return new ItemCurrency(s, s1);
    }

    private String getInvalidBidMessage()
    {
        CurrencyAmount currencyamount = item.minimumToBid.lowerBound;
        String s = getBidAmountString();
        Object obj = currencyamount;
        if (!isAboveMaxBid(s))
        {
            double d = Double.parseDouble(s);
            obj = currencyamount;
            if (item.isUserHighBidder)
            {
                obj = currencyamount;
                if (Item.isValidBid(item, Double.valueOf(d).doubleValue()))
                {
                    obj = viewItemDataManager.getMaxBid(item);
                    obj = (new CurrencyAmount(((ItemCurrency) (obj)))).add(new CurrencyAmount(".01", ((ItemCurrency) (obj)).code));
                }
            }
        }
        return String.format(getString(0x7f07079e), new Object[] {
            EbayCurrencyUtil.formatDisplay(((CurrencyAmount) (obj)), item.getCurrencyUtilFlag())
        });
    }

    private boolean isAboveMaxBid(String s)
    {
label0:
        {
            if (item != null && !TextUtils.isEmpty(s))
            {
                Object obj = viewItemDataManager.getMaxBid(item);
                if (obj != null)
                {
                    s = getEnteredBidAmount(itemCurrencyCode, s);
                    obj = new CurrencyAmount(((ItemCurrency) (obj)));
                    if ((new CurrencyAmount(s)).compareTo(((CurrencyAmount) (obj))) != 1)
                    {
                        break label0;
                    }
                }
            }
            return true;
        }
        return false;
    }

    private boolean isValidBid()
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
        }
        String s = getBidAmountString();
        double d = Double.parseDouble(s);
        boolean flag1 = Item.isValidBid(item, Double.valueOf(d).doubleValue());
        boolean flag = flag1;
        if (flag1)
        {
            flag = isAboveMaxBid(s);
        }
        return flag;
    }

    private void processOutbidMessage()
    {
        setOutbidOrBidTooLowMessage(new SpannableStringBuilder(getString(0x7f070cde)), true);
        render();
    }

    private void render()
    {
        render(false);
    }

    private void render(boolean flag)
    {
        Object obj;
        Object obj1;
        View view1;
        Object obj3;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        byte byte1;
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
        }
        boolean flag5 = item.isDisplayPriceCurrencyCode;
        int i;
        if (bidCountView == null)
        {
            obj = (ViewGroup)findViewById(0x7f1004c3);
            ((ViewGroup) (obj)).setOnClickListener(this);
            String s;
            int k;
            if (item.isDisplayPriceCurrencyCode)
            {
                i = 0x7f03028d;
            } else
            {
                i = 0x7f03028f;
            }
            obj = View.inflate(this, i, ((ViewGroup) (obj)));
            bidCountView = (TextView)((View) (obj)).findViewById(0x7f100374);
            currentPriceView = (TextView)((View) (obj)).findViewById(0x7f1008ac);
            if (flag5)
            {
                convertedCurrentPriceView = (TextView)((View) (obj)).findViewById(0x7f1008ad);
            }
            reserveNotMetView = ((View) (obj)).findViewById(0x7f1008ae);
            titleTextView = (TextView)((View) (obj)).findViewById(0x7f10005f);
            powerBidValuesLayout = findViewById(0x7f1004d8);
            findViewById(0x7f1004c6).setOnClickListener(this);
            findViewById(0x7f1004c7).setOnClickListener(this);
            findViewById(0x7f1004cf).setOnClickListener(this);
            findViewById(0x7f1004d2).setOnClickListener(this);
        }
        if (currencySymbol == null)
        {
            currencySymbol = item.getCurrencySymbol(itemCurrency);
        }
        if (pbvAmountEntered != null)
        {
            bidAmountView.setText(pbvAmountEntered.value);
        }
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
        if (flag)
        {
            doFadeAnimation(currentPriceView, item.displayCurrentPrice);
        } else
        {
            currentPriceView.setText(item.displayCurrentPrice);
        }
        if (flag5)
        {
            obj = item.getApproximatelyString(getEbayContext(), 0x7f07016e, item.displayCurrentPriceConverted);
            if (flag)
            {
                doFadeAnimation(convertedCurrentPriceView, ((String) (obj)));
            } else
            {
                convertedCurrentPriceView.setText(((CharSequence) (obj)));
            }
        }
        currencyCodeView.setText(currencySymbol);
        if (bidCountView != null)
        {
            obj = String.format(getResources().getQuantityString(0x7f08001b, item.bidCount), new Object[] {
                Integer.valueOf(item.bidCount)
            });
            if (flag)
            {
                doFadeAnimation(bidCountView, ((String) (obj)));
            } else
            {
                bidCountView.setText(((CharSequence) (obj)));
            }
        }
        if (item.isShowReviewBid)
        {
            findViewById(0x7f1004d5).setVisibility(8);
            reviewButton.setVisibility(0);
            confirmButton.setVisibility(8);
        } else
        {
            obj = (TextView)findViewById(0x7f1004d5);
            if (obj != null)
            {
                setBidAgreementBlurb(this, item, ((TextView) (obj)));
            }
        }
        if (ItemViewActivity.logTag.isLoggable)
        {
            ItemViewActivity.logTag.log((new StringBuilder()).append("PBV ").append(item.powerBidValues).toString());
        }
        view1 = null;
        obj = null;
        if ((getResources().getConfiguration().screenLayout & 0xf) > 1)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        flag1 = false;
        k = 0;
        flag2 = flag1;
        flag3 = i;
        obj1 = view1;
        if (i == 0)
        {
            break MISSING_BLOCK_LABEL_1153;
        }
        flag2 = flag1;
        flag3 = i;
        obj1 = view1;
        if (item.powerBidValues == null)
        {
            break MISSING_BLOCK_LABEL_1153;
        }
        obj3 = null;
        view1 = null;
        flag2 = false;
        flag1 = i;
        i = k;
        k = ((flag2) ? 1 : 0);
_L5:
        flag2 = i;
        flag3 = flag1;
        obj1 = obj;
        if (k >= item.powerBidValues.size())
        {
            break MISSING_BLOCK_LABEL_1153;
        }
        byte1 = 8;
        k;
        JVM INSTR tableswitch 0 2: default 692
    //                   0 1057
    //                   1 1071
    //                   2 1085;
           goto _L1 _L2 _L3 _L4
_L1:
        obj1 = obj3;
_L6:
        flag3 = i;
        boolean flag4 = flag1;
        Object obj2 = obj;
        byte byte0 = byte1;
        if (obj1 != null)
        {
            flag3 = i;
            flag4 = flag1;
            obj2 = obj;
            byte0 = byte1;
            if (view1 != null)
            {
                obj3 = (ItemCurrency)item.powerBidValues.get(k);
                flag2 = i;
                if (flag)
                {
                    flag2 = i;
                    if (i == 0)
                    {
                        flag2 = i;
                        if (obj3 != null)
                        {
                            obj2 = (ItemCurrency)view1.getTag();
                            flag2 = i;
                            if (obj2 != null)
                            {
                                flag2 = i;
                                if ((new CurrencyAmount(((ItemCurrency) (obj2)))).compareTo(new CurrencyAmount(((ItemCurrency) (obj3)))) != 0)
                                {
                                    flag2 = true;
                                }
                            }
                        }
                    }
                }
                s = EbayCurrencyUtil.formatDisplay(((ItemCurrency) (obj3)), item.getCurrencyUtilFlag());
                flag3 = flag2;
                flag4 = flag1;
                obj2 = obj;
                byte0 = byte1;
                if (s != null)
                {
                    String s1 = getBidAmountTerse(s);
                    if (!flag)
                    {
                        byte0 = 0;
                        flag4 = true;
                        ((TextView) (obj1)).setText(s1);
                        ((TextView) (obj1)).setContentDescription(s1);
                        view1.setTag(obj3);
                        view1.setTag(0x7f070b7e, Integer.valueOf(k));
                        view1.setOnClickListener(this);
                        obj2 = obj;
                        flag3 = flag2;
                    } else
                    {
                        obj2 = obj;
                        if (obj == null)
                        {
                            obj2 = new ArrayList();
                        }
                        ((List) (obj2)).add(new PowerBidValueInfo(((TextView) (obj1)), view1, s1, ((ItemCurrency) (obj3))));
                        flag3 = flag2;
                        flag4 = flag1;
                        byte0 = byte1;
                    }
                }
            }
        }
        if (!flag && view1 != null)
        {
            view1.setVisibility(byte0);
        }
        k++;
        obj3 = obj1;
        i = ((flag3) ? 1 : 0);
        flag1 = flag4;
        obj = obj2;
        if (true) goto _L5; else goto _L2
_L2:
        obj1 = powerBidValue1View;
        view1 = powerBidValue1Layout;
          goto _L6
_L3:
        obj1 = powerBidValue2View;
        view1 = powerBidValue2Layout;
          goto _L6
_L4:
        obj1 = powerBidValue3View;
        view1 = powerBidValue3Layout;
          goto _L6
        View view = powerBidValuesLayout;
        int j;
        if (flag3)
        {
            j = 0;
        } else
        {
            j = 8;
        }
        view.setVisibility(j);
        if (flag2)
        {
            doFadeAnimation(powerBidValuesLayout, ((List) (obj1)));
        }
        return;
    }

    private void resetPriceValue()
    {
        bidAmountView.setText("0");
        priceView.clear();
    }

    public static void setBidAgreementBlurb(Context context, Item item, TextView textview)
    {
        if (item != null && textview != null)
        {
            if (item.isGspItem)
            {
                if (MyApp.getPrefs().getCurrentSite().isEuSite())
                {
                    context = context.getString(0x7f070442);
                } else
                {
                    context = context.getString(0x7f070441);
                }
                textview.setText(context);
            } else
            {
                context = context.getString(0x7f07018e);
            }
            textview.setText(Html.fromHtml(context));
        }
    }

    private void setOutbidOrBidTooLowMessage(CharSequence charsequence, boolean flag)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                charsequence, Boolean.valueOf(flag)
            });
        }
        if (bidAmountConvertedView != null)
        {
            bidAmountConvertedView.setVisibility(8);
        }
        errorTextView.setText(charsequence, android.widget.TextView.BufferType.SPANNABLE);
        errorTextView.setVisibility(0);
        if (flag)
        {
            pbvAmountEntered = null;
            priceView.removeTextChangedListener(this);
            resetPriceValue();
            priceView.addTextChangedListener(this);
        }
    }

    private void setupBidVariables()
    {
        if (item != null && (itemCurrency == null || TextUtils.isEmpty(itemCurrencyCode)))
        {
            itemCurrency = EbaySite.getInstanceFromId(item.site).getCurrency();
            if (itemCurrency.isSymbolOnLeft())
            {
                currencyCodeView = currencyCodeLeftView;
            } else
            {
                currencyCodeView = currencyCodeRightView;
                currencyCodeLeftView.setVisibility(8);
                currencyCodeRightView.setVisibility(0);
            }
            itemCurrencyCode = itemCurrency.getCurrencyCode();
            if (itemCurrencyCode != null && !"USD".equals(itemCurrencyCode))
            {
                priceView.setCurrency(itemCurrencyCode);
            }
        }
    }

    private void setupTimer()
    {
        timer.setOnTimerEvent(new com.ebay.common.EbayTimer.OnTimerEvent() {

            final ViewItemPlaceBidActivity this$0;

            public void OnTimer()
            {
                updateTimeLeft();
            }

            
            {
                this$0 = ViewItemPlaceBidActivity.this;
                super();
            }
        });
    }

    private void showSoftInput()
    {
        if (priceView != null)
        {
            priceView.setInputType(8194);
            priceView.setCurrency(itemCurrencyCode);
            priceView.setOnKeyListener(this);
            Util.showSoftInput(this, priceView);
        }
    }

    public static void startActivity(BaseActivity baseactivity, Fragment fragment, ViewItemViewData viewitemviewdata, String s, String s1, int i, boolean flag)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
        }
        Object obj;
        if (fragment != null)
        {
            obj = fragment.getActivity();
        } else
        {
            obj = baseactivity;
        }
        obj = new Intent(((Context) (obj)), com/ebay/mobile/viewitem/ViewItemPlaceBidActivity);
        ((Intent) (obj)).putExtra("view_item_view_data", viewitemviewdata);
        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.Referrer", s);
        ((Intent) (obj)).putExtra("com.ebay.mobile.tracking.BidSource", s1);
        ((Intent) (obj)).putExtra("useLongThreshold", flag);
        if (fragment != null)
        {
            fragment.startActivityForResult(((Intent) (obj)), i);
            return;
        } else
        {
            baseactivity.startActivityForResult(((Intent) (obj)), i);
            return;
        }
    }

    private void startConfirmActivity()
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
        }
        CurrencyAmount currencyamount;
        boolean flag;
        if (pbvAmountEntered != null)
        {
            currencyamount = new CurrencyAmount(pbvAmountEntered.value, pbvAmountEntered.code);
        } else
        {
            currencyamount = ViewItemFragmentBiddingUtil.getBidForConfirm(item, priceView);
        }
        flag = ItemViewBidTracking.isIncrementalBid(item, viewItemDataManager, currencyamount);
        ViewItemConfirmActivity.StartActivity(this, null, true, viewData, 1, currencyamount, false, referrer, bidSource, flag, useLongThreshold, 1);
    }

    private void startConfirmFlow()
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
        }
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
        if (item.isGspItem)
        {
            com.ebay.nautilus.domain.data.PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
            if (viewItemDataManager != null)
            {
                CurrencyAmount currencyamount = ViewItemFragmentBiddingUtil.getBidForConfirm(item, priceView);
                viewItemDataManager.getShippingCosts(postalcodespecification, 1, currencyamount.toItemCurrency());
            }
            return;
        } else
        {
            startConfirmActivity();
            return;
        }
    }

    private void trackItemViewEvent(String s)
    {
        boolean flag = getTrackingEventName().equals(s);
        Object obj;
        if (flag)
        {
            obj = TrackingType.PAGE_IMPRESSION;
        } else
        {
            obj = TrackingType.EVENT;
        }
        obj = new TrackingData(s, "ViewItemFlags", ((TrackingType) (obj)));
        if (item != null)
        {
            if (flag)
            {
                ((TrackingData) (obj)).addSourceIdentification(getIntent());
                int i;
                if (DeviceInfoUtil.isPortrait(this))
                {
                    s = "p";
                } else
                {
                    s = "l";
                }
                ((TrackingData) (obj)).addKeyValuePair("ort", s);
            }
            ((TrackingData) (obj)).addKeyValuePair("itm", item.getIdString());
            ((TrackingData) (obj)).addKeyValuePair("itmtitle", item.title.getSourceContent());
            ((TrackingData) (obj)).addKeyValuePair("shipsiteid", item.site);
            ((TrackingData) (obj)).addKeyValuePair("leaf", Long.toString(item.primaryCategoryId));
            s = item.currentPriceForType(getEbayContext(), viewData);
            if (s != null)
            {
                ((TrackingData) (obj)).addKeyValuePair("curprice", String.format(Locale.US, "%.2f", new Object[] {
                    Double.valueOf(Double.parseDouble(((ItemCurrency) (s)).value))
                }));
            }
            if (item.isBidOnly || item.isBidWithBin)
            {
                ((TrackingData) (obj)).addKeyValuePair("bc", Integer.toString(item.bidCount));
                if (item.allBidders != null)
                {
                    ((TrackingData) (obj)).addKeyValuePair("bdrs", Integer.toString(item.allBidders.countBidders()));
                }
                if (item.minimumToBid != null && item.currentPrice != null)
                {
                    ((TrackingData) (obj)).addKeyValuePair("bi", Double.toString(item.minimumToBid.lowerBound.subtract(new CurrencyAmount(item.currentPrice)).getValueAsDouble()));
                }
            }
            if (item.productId != null)
            {
                ((TrackingData) (obj)).addKeyValuePair("pri", item.productId);
            }
            if (item.endDate != null)
            {
                ((TrackingData) (obj)).addKeyValuePair("tr", Long.toString((item.endDate.getTime() - System.currentTimeMillis()) / 1000L));
            }
            ((TrackingData) (obj)).addKeyValuePair("nw", Integer.toString(item.watchCount));
            if (item.isActive)
            {
                ((TrackingData) (obj)).addFlag(23);
            }
            ((TrackingData) (obj)).addKeyValuePair("trknvpsvc", item.vlsResponseTrackingData);
            ((TrackingData) (obj)).addKeyValuePair("rq", item.vlsResponseTrackingCorrelationId);
            ((TrackingData) (obj)).addKeyValuePair("vls", "1");
            if (item.nectarRewards != null)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            ((TrackingData) (obj)).addKeyValuePair("Nectar", s);
            if (item.bucksRewards != null)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            ((TrackingData) (obj)).addKeyValuePair("eBayBucks", s);
            if (item.isPudoable)
            {
                s = "1";
            } else
            {
                s = "0";
            }
            ((TrackingData) (obj)).addKeyValuePair("pudo", s);
        }
        s = getIntent();
        i = s.getIntExtra("noti_type_id", -1);
        if (i != -1)
        {
            NotificationTrackingUtil.addNotificationTracking(this, ((TrackingData) (obj)), s, NotificationPreference.idToName(i));
        }
        ((TrackingData) (obj)).send(this);
    }

    private void updateConvertedBidAmount()
    {
        updateConvertedBidAmount(null);
    }

    private void updateConvertedBidAmount(ItemCurrency itemcurrency)
    {
label0:
        {
            int i;
label1:
            {
                boolean flag1 = false;
                if (ItemViewActivity.logTag.isLoggable)
                {
                    FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
                }
                if (item == null || !item.isDisplayPriceCurrencyCode || bidAmountConvertedView == null)
                {
                    break label0;
                }
                boolean flag2 = false;
                boolean flag = flag2;
                if (viewItemDataManager == null)
                {
                    break label1;
                }
                if (priceView == null || priceView.getPrice() <= 0.0D)
                {
                    flag = flag2;
                    if (itemcurrency == null)
                    {
                        break label1;
                    }
                }
                com.ebay.common.model.currency.CurrencyConversionRate currencyconversionrate = viewItemDataManager.getCurrencyConversionRate();
                flag = flag2;
                if (currencyconversionrate != null)
                {
                    if (userCurrencyCode == null && MyApp.getPrefs().getCurrentSite() != null && MyApp.getPrefs().getCurrentSite().getCurrency() != null)
                    {
                        userCurrencyCode = MyApp.getPrefs().getCurrentSite().getCurrency().getCurrencyCode();
                    }
                    flag = flag2;
                    if (userCurrencyCode != null)
                    {
                        if (priceView != null && priceView.getPrice() > 0.0D)
                        {
                            itemcurrency = priceView.getPriceAsString();
                        } else
                        {
                            itemcurrency = itemcurrency.value;
                        }
                        itemcurrency = Item.convertCurrency(getEbayContext(), new ItemCurrency(userCurrencyCode, itemcurrency), currencyconversionrate);
                        flag = flag2;
                        if (itemcurrency != null)
                        {
                            flag = true;
                            bidAmountConvertedView.setText(item.getApproximatelyString(getEbayContext(), 0x7f07016f, EbayCurrencyUtil.formatDisplay(itemcurrency, item.getCurrencyUtilFlag())));
                        }
                    }
                }
            }
            itemcurrency = bidAmountConvertedView;
            if (flag)
            {
                i = ((flag1) ? 1 : 0);
            } else
            {
                i = 4;
            }
            itemcurrency.setVisibility(i);
            errorTextView.setVisibility(8);
        }
    }

    private void updateTimeLeft()
    {
        if (timeLeftTextView == null)
        {
            timeLeftTextView = (TextView)findViewById(0x7f1002f4);
        }
        if (item != null && item.isAuctionEnded || timeLeftTextView != null && timeLeftTextView.getText().toString().equals(endedString))
        {
            animateFinishItemEnded();
        } else
        {
            updateTimeLeft(((Context) (this)), timeLeftTextView, viewData, item, false, useLongThreshold);
            if (item.isAuctionEnded)
            {
                reviewButton.setEnabled(false);
                return;
            }
        }
    }

    public static void updateTimeLeft(Context context, TextView textview, ViewItemViewData viewitemviewdata, Item item, boolean flag, boolean flag1)
    {
        int i;
        if (item.endDate != null)
        {
            viewitemviewdata = item.getRenderedDate(context, viewitemviewdata.kind, item.endDate, defaultColor, shortTimeColor, flag, flag1);
            String s = viewitemviewdata.toString();
            if (item.isAuctionEnded || endedString.equals(s))
            {
                textview.setText(viewitemviewdata, android.widget.TextView.BufferType.SPANNABLE);
            } else
            {
                context = String.format(context.getString(0x7f070653), new Object[] {
                    "REPLACEME"
                });
                SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder(context);
                i = context.indexOf("REPLACEME");
                spannablestringbuilder.replace(i, "REPLACEME".length() + i, viewitemviewdata);
                if (item.isTimeLeftDisplayColorRed(item.endDate, flag1))
                {
                    i = shortTimeColor;
                } else
                {
                    i = defaultColor;
                }
                spannablestringbuilder.setSpan(new ForegroundColorSpan(i), 0, spannablestringbuilder.length(), 0);
                textview.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
            }
        }
        if (item.endDate == null || item.isHideTimeLeft)
        {
            i = 8;
        } else
        {
            i = 0;
        }
        textview.setVisibility(i);
    }

    public void afterTextChanged(Editable editable)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                editable
            });
        }
        if (item == null) goto _L2; else goto _L1
_L1:
        String s;
        pbvAmountEntered = null;
        s = editable.toString();
        if (!TextUtils.isEmpty(s)) goto _L4; else goto _L3
_L3:
        editable = "0";
_L6:
        bidAmountView.setText(editable);
        updateConvertedBidAmount();
_L2:
        return;
_L4:
        if (s.equals("."))
        {
            editable = "0.";
        } else
        {
            editable = s;
            if (s.equals(","))
            {
                editable = "0,";
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public void beforeTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public String getTrackingEventName()
    {
        return "BiddingEnterBidAmount";
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), intent
            });
        }
        i;
        JVM INSTR lookupswitch 2: default 64
    //                   1: 92
    //                   11: 65;
           goto _L1 _L2 _L3
_L1:
        return;
_L3:
        if (viewItemDataManager != null)
        {
            ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
            viewItemDataManager.forceReloadData(viewData);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L2:
        setResult(j);
        if (-1 == j)
        {
            getWindow().setSoftInputMode(3);
            setResult(-1, intent);
            finish();
            return;
        }
        if (503 == j)
        {
            finish();
            return;
        }
        if (502 == j)
        {
            setResult(j, intent);
            finish();
            return;
        }
        if (505 == j && intent != null)
        {
            setOutbidOrBidTooLowMessage(getInvalidBidMessage(), true);
            intent = (ItemCurrency)intent.getParcelableExtra("current_price");
            if (item != null && intent != null)
            {
                item.currentPrice = intent;
            }
            render();
            return;
        }
        if (504 == j)
        {
            processOutbidMessage();
            return;
        }
        if (j == 20)
        {
            animateFinishItemEnded();
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onBackPressed()
    {
        trackBidEvent("ViewItemBidCloseTap");
        animateFinish();
        super.onBackPressed();
    }

    public void onBidUpdated(ViewItemDataManager viewitemdatamanager, Content content)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                content
            });
        }
        if (isFinishing())
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
            if (item != null && item.isAuctionEnded)
            {
                animateFinishItemEnded();
                return;
            } else
            {
                setupBidVariables();
                render(DeviceConfiguration.getAsync().get(DcsBoolean.VI_featureNewBidAnimations));
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
        JVM INSTR lookupswitch 14: default 128
    //                   2131755328: 129
    //                   2131755356: 129
    //                   2131756227: 573
    //                   2131756228: 129
    //                   2131756230: 573
    //                   2131756231: 573
    //                   2131756233: 573
    //                   2131756239: 573
    //                   2131756242: 573
    //                   2131756244: 327
    //                   2131756246: 536
    //                   2131756249: 141
    //                   2131756251: 141
    //                   2131756253: 141;
           goto _L1 _L2 _L2 _L3 _L2 _L3 _L3 _L3 _L3 _L3 _L4 _L5 _L6 _L6 _L6
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_573;
_L7:
        return;
_L2:
        trackBidEvent("ViewItemBidCloseTap");
        animateFinish();
        return;
_L6:
        Object obj = view.getTag();
        if (obj != null && (obj instanceof ItemCurrency))
        {
            pbvAmountEntered = (ItemCurrency)obj;
            bidAmountView.setText(getBidAmountTerse(pbvAmountEntered.value));
            priceView.removeTextChangedListener(this);
            priceView.clear();
            priceView.addTextChangedListener(this);
            updateConvertedBidAmount(pbvAmountEntered);
            obj = new TrackingData("ViewItemPowerBidValue", TrackingType.EVENT);
            if (item != null)
            {
                ((TrackingData) (obj)).addKeyValuePair("itm", item.getIdString());
            }
            ((TrackingData) (obj)).addKeyValuePair("PBVamount", pbvAmountEntered.value);
            if (item.powerBidValues != null)
            {
                ((TrackingData) (obj)).addKeyValuePair("maxPBV", String.valueOf(item.powerBidValues.size()));
            }
            if (view.getTag(0x7f070b7e) != null)
            {
                ((TrackingData) (obj)).addKeyValuePair("numPBV", String.valueOf(view.getTag(0x7f070b7e)));
            }
            ((TrackingData) (obj)).send(this);
            return;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        if (!Util.hasNetwork())
        {
            showButterBarMessage(view.getId(), getNetworkErrorToastString(), true);
            return;
        }
        com.ebay.nautilus.domain.app.Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            if (isValidBid())
            {
                trackBidEvent("ViewItemConfirmBidTap");
                ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.TRANSLUCENT_PROGRESS);
                setTakeActionButtonEnabled(this, false);
                ItemCurrency itemcurrency = pbvAmountEntered;
                view = itemcurrency;
                if (itemcurrency == null)
                {
                    view = getEnteredBidAmount(itemCurrencyCode, getBidAmountString());
                }
                if (viewItemDataManager != null)
                {
                    Object obj1 = ViewItemConfirmActivity.getTotalShippingCost(getResources(), item, 1);
                    if (obj1 != null)
                    {
                        obj1 = ((CurrencyAmount) (obj1)).toItemCurrency();
                    } else
                    {
                        obj1 = null;
                    }
                    viewItemDataManager.placeOffer(EbayApiUtil.getTradingApi(this, authentication), item.id, "Bid", view, 1, viewData.nameValueList, null, null, false, ((ItemCurrency) (obj1)), bidSource, referrer, ItemViewBidTracking.isIncrementalBid(item, viewItemDataManager, new CurrencyAmount(view)), item.isUserConsentRequired);
                    return;
                }
            } else
            {
                setOutbidOrBidTooLowMessage(getInvalidBidMessage(), true);
                return;
            }
        } else
        {
            startActivityForResult(SignInModalActivity.getIntentForSignIn(getTrackingEventName(), this), 11);
            return;
        }
        if (true) goto _L7; else goto _L5
_L5:
        if (isValidBid())
        {
            trackBidEvent("ViewItemReviewBidTap");
            Util.hideSoftInput(this, priceView);
            startConfirmFlow();
            return;
        } else
        {
            setOutbidOrBidTooLowMessage(getInvalidBidMessage(), true);
            return;
        }
        showSoftInput();
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f0301a2);
        setTitle(null);
        Object obj = getIntent();
        viewData = (ViewItemViewData)((Intent) (obj)).getParcelableExtra("view_item_view_data");
        referrer = ((Intent) (obj)).getStringExtra("com.ebay.mobile.tracking.Referrer");
        bidSource = ((Intent) (obj)).getStringExtra("com.ebay.mobile.tracking.BidSource");
        useLongThreshold = ((Intent) (obj)).getBooleanExtra("useLongThreshold", false);
        obj = ItemViewCommonProgressAndError.setOkNotRetry(this);
        ((Button) (obj)).setVisibility(8);
        ((Button) (obj)).setOnClickListener(this);
        findViewById(0x7f1004c4).setOnClickListener(this);
        priceView = (PriceView)findViewById(0x7f1004c5);
        priceView.setOnEditorActionListener(this);
        priceView.setFilters(new InputFilter[] {
            new DecimalDigitsInputFilter()
        });
        priceView.addTextChangedListener(this);
        priceView.setFocusable(true);
        priceView.setOnKeyListener(this);
        if (bundle != null)
        {
            priceViewString = bundle.getString("priceViewString");
            pbvAmountEntered = (ItemCurrency)bundle.getParcelable("priceViewIsPbv");
            currencySymbol = bundle.getString("currency_symbol");
            itemCurrency = (EbayCurrency)bundle.getParcelable("item_currency");
        }
        errorTextView = (TextView)findViewById(0x7f1004d1);
        currencyCodeLeftView = (TextView)findViewById(0x7f1004c8);
        currencyCodeRightView = (TextView)findViewById(0x7f1004ca);
        bidAmountConvertedView = (TextView)findViewById(0x7f1004d0);
        bidAmountView = (TextView)findViewById(0x7f1004c9);
        bidAmountView.setOnTouchListener(this);
        bidAmountView.setOnClickListener(this);
        powerBidValue1View = (TextView)findViewById(0x7f1004da);
        powerBidValue2View = (TextView)findViewById(0x7f1004dc);
        powerBidValue3View = (TextView)findViewById(0x7f1004de);
        powerBidValue1Layout = findViewById(0x7f1004d9);
        powerBidValue2Layout = findViewById(0x7f1004db);
        powerBidValue3Layout = findViewById(0x7f1004dd);
        confirmButton = (TextView)findViewById(0x7f1004d4);
        confirmButton.setOnClickListener(this);
        confirmButton.setEnabled(true);
        reviewButton = (TextView)findViewById(0x7f1004d6);
        reviewButton.setOnClickListener(this);
        reviewButton.setEnabled(true);
        endedString = getString(0x7f0703c3);
        defaultColor = getResources().getColor(0x7f0d00e7);
        shortTimeColor = getResources().getColor(0x7f0d0005);
        initDataManagers();
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
        if (content.getStatus().hasError()) goto _L2; else goto _L1
_L1:
        static class _cls4
        {

            static final int $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[];

            static 
            {
                $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled = new int[ViewItemDataManager.ActionHandled.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.INITIAL_LOAD.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$viewitem$ViewItemDataManager$ActionHandled[ViewItemDataManager.ActionHandled.SHIPPING_COSTS.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls4..SwitchMap.com.ebay.mobile.viewitem.ViewItemDataManager.ActionHandled[actionhandled.ordinal()];
        JVM INSTR tableswitch 1 2: default 92
    //                   1 111
    //                   2 168;
           goto _L3 _L4 _L5
_L3:
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
        findViewById(0x7f100016).setVisibility(0);
        return;
_L4:
        setupBidVariables();
        if (!TextUtils.isEmpty(priceViewString))
        {
            priceView.setPriceRaw(priceViewString);
            priceViewString = null;
        }
        render();
        updateTimeLeft();
        setupTimer();
        trackItemViewEvent(getTrackingEventName());
        showSoftInput();
        continue; /* Loop/switch isn't completed */
_L5:
        ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
        startConfirmActivity();
        continue; /* Loop/switch isn't completed */
_L2:
        setTakeActionButtonEnabled(this, false);
        showMessage(0, content.getStatus());
        if (true) goto _L3; else goto _L6
_L6:
    }

    public boolean onEditorAction(TextView textview, int i, KeyEvent keyevent)
    {
        return false;
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

    public boolean onKey(View view, int i, KeyEvent keyevent)
    {
        if (keyevent.getKeyCode() == 67 && pbvAmountEntered != null)
        {
            pbvAmountEntered = null;
            resetPriceValue();
        }
        return false;
    }

    protected void onPause()
    {
        super.onPause();
        timer.stop();
    }

    public void onPlaceOfferCompleted(ViewItemDataManager viewitemdatamanager, Content content)
    {
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[] {
                content
            });
        }
        if (!isFinishing())
        {
            if (!content.getStatus().hasError() || content.getData() != null && ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus != null && (((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus.getResultCode() == 505 || ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus.getResultCode() == 502))
            {
                ItemViewCommonProgressAndError.showLayouts(this, ItemViewCommonProgressAndError.LayoutState.NORMAL);
                setTakeActionButtonEnabled(this, false);
                viewitemdatamanager = ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus;
                Intent intent = new Intent();
                item = (Item)((ViewItemDataManager.PlaceOfferInfo)content.getData()).item.getData();
                if (viewData.keyParams.transactionId == null && item.transactionId != null || viewData.keyParams.transactionId != null && item.transactionId != null && !item.transactionId.equals(viewData.keyParams.transactionId))
                {
                    intent.putExtra("transaction_id", item.transactionId);
                }
                ItemCurrency itemcurrency = getEnteredBidAmount(itemCurrencyCode, getBidAmountString());
                int i = ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus.getResultCode();
                if (i != 505 && i != 502)
                {
                    viewData.kind = com.ebay.common.ConstantsCommon.ItemKind.Bidding;
                    viewItemDataManager.setBidItemMaxPrice(item.id, viewData.nameValueList, itemcurrency);
                }
                if (i == 502)
                {
                    Util.hideSoftInput(this, priceView);
                }
                intent.putExtra("view_item_view_data", viewData);
                if (i == 504)
                {
                    processOutbidMessage();
                    return;
                }
                if (i == 505)
                {
                    viewitemdatamanager = ((ViewItemDataManager.PlaceOfferInfo)content.getData()).resultStatus.getBundle();
                    item.currentPrice = (ItemCurrency)viewitemdatamanager.getParcelable("current_price");
                    if (item.isDisplayPriceCurrencyCode)
                    {
                        item.convertedCurrentPrice = Item.convertCurrency(getEbayContext(), item.currentPrice, viewItemDataManager.getCurrencyConversionRate());
                    }
                    setOutbidOrBidTooLowMessage(viewitemdatamanager.getString("bidTooLowErrorMessage"), true);
                    render();
                    return;
                }
                setResult(viewitemdatamanager.getResultCode(), intent);
                MyEbayLandingActivity.setBuyingInvalid(getEbayContext());
                if (viewitemdatamanager.isFinish())
                {
                    animateFinish();
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
        if (ItemViewActivity.logTag.isLoggable)
        {
            FwLog.logMethod(ItemViewActivity.logTag, new Object[0]);
        }
        if (Debug.logBidTracking.isLoggable)
        {
            FwLog.println(Debug.logBidTracking, (new StringBuilder()).append(com/ebay/mobile/viewitem/ViewItemPlaceBidActivity.getSimpleName()).append(" referrer:").append(referrer).append(" bidSource:").append(bidSource).toString());
        }
        if (!timer.isTimerRunning())
        {
            timer.start();
        }
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        bundle.putString("priceViewString", priceView.getPriceAsString());
        bundle.putParcelable("priceViewIsPbv", pbvAmountEntered);
        bundle.putParcelable("item_currency", itemCurrency);
        bundle.putString("currency_symbol", currencySymbol);
    }

    public void onTextChanged(CharSequence charsequence, int i, int j, int k)
    {
    }

    public boolean onTouch(View view, MotionEvent motionevent)
    {
        showSoftInput();
        if (motionevent.getAction() == 1)
        {
            view.performClick();
        }
        if (motionevent.getAction() == 1)
        {
            view.performClick();
        }
        return false;
    }

}
