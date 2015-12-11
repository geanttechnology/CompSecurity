// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.CurrencyConversionCache;
import com.ebay.common.Preferences;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.util.LruHistoryCache;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.search.LruVisitedItemCache;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.FwContext;
import java.util.Date;

// Referenced classes of package com.ebay.common.view:
//            ItemAdapter, ViewCache

public class DefaultItemAdapter extends ItemAdapter
{

    protected static final long DAY = 0x5265c00L;
    protected static final long HOUR = 0x36ee80L;
    protected static final long SECOND = 1000L;
    protected static final long YEAR = 0x757b12c00L;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo currencyLog = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CurrencyConversion", 3, "Log CurrencyConversion");
    private final Spannable binOrBestOffer;
    protected final int buyingFormat;
    protected final int colorPriceSold;
    protected final int colorPriceUnsold;
    protected final int colorPrimary;
    protected final int colorSecondary;
    protected final int colorShippingFree;
    protected final int colorTimeWarning;
    protected final boolean distinguishRecentlyViewed;
    private final EbayContext ebayContext;
    private final int numberGridColumns;
    private final int recentlyViewedBackgroundResId;
    private final int recentlyViewedColorResId;
    private final int selectableBackgroundResId;
    protected final boolean showFreeShipping;
    protected final boolean showShipping;
    private final int standardItemBackgroundResId;
    protected final String strDays;
    protected final String strHours;
    protected final String strMinutes;
    protected final String strSeconds;
    private android.content.res.Resources.Theme theme;
    private final boolean useLargeImages;
    private String userCurrencyCode;

    public DefaultItemAdapter(Activity activity, boolean flag, boolean flag1, boolean flag2)
    {
        this(activity, flag, flag1, flag2, 7, false);
    }

    public DefaultItemAdapter(Activity activity, boolean flag, boolean flag1, boolean flag2, int i, boolean flag3)
    {
        super(activity.getResources());
        theme = null;
        ebayContext = ((FwContext)activity).getEbayContext();
        theme = activity.getTheme();
        useLargeImages = flag3;
        colorSecondary = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010038);
        colorShippingFree = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010038);
        colorPrimary = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010036);
        colorPriceSold = resources.getColor(0x7f0d00e9);
        colorPriceUnsold = resources.getColor(0x7f0d00f0);
        colorTimeWarning = resources.getColor(0x7f0d00f0);
        strDays = resources.getString(0x7f070049);
        strHours = resources.getString(0x7f07004c);
        strMinutes = resources.getString(0x7f07004f);
        strSeconds = resources.getString(0x7f070052);
        showShipping = flag;
        showFreeShipping = flag1;
        distinguishRecentlyViewed = flag2;
        buyingFormat = i;
        binOrBestOffer = getBinOrBestOfferText();
        recentlyViewedBackgroundResId = ThemeUtil.resolveThemeResId(theme, 0x7f010059, 0x7f01005b);
        standardItemBackgroundResId = ThemeUtil.resolveThemeResId(theme, 0x7f01005b, 0);
        recentlyViewedColorResId = ThemeUtil.resolveThemeResId(theme, 0x7f01005a, 0x7f0d00f9);
        selectableBackgroundResId = ThemeUtil.resolveThemeResId(theme, 0x101030e, 0x7f01005b);
        userCurrencyCode = MyApp.getPrefs().getCurrentCountry().getCurrency().getCurrencyCode();
        numberGridColumns = resources.getInteger(0x7f0c0003);
    }

    private int computeListViewBackgroundResId(int i)
    {
        while (numberGridColumns == 1 || (i & 1) != 1) 
        {
            return 0x7f02026f;
        }
        return 0x7f0202b9;
    }

    private Spannable getBinOrBestOfferText()
    {
        int i = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010038);
        Object obj = resources.getString(0x7f0701b7);
        String s = resources.getString(0x7f070742);
        int j = ((String) (obj)).length() + 1;
        int k = j + s.length();
        obj = new SpannableString((new StringBuilder(((String) (obj)))).append('\n').append(s));
        ((Spannable) (obj)).setSpan(new ForegroundColorSpan(i), j, k, 33);
        ((Spannable) (obj)).setSpan(new StyleSpan(1), j, k, 33);
        ((Spannable) (obj)).setSpan(new AbsoluteSizeSpan(10, true), j, k, 33);
        return ((Spannable) (obj));
    }

    private ItemCurrency getConvertedPrice(ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
    {
        if (itemcurrency != null && itemcurrency.code != null && itemcurrency.value != null) goto _L2; else goto _L1
_L1:
        Object obj = null;
_L4:
        return ((ItemCurrency) (obj));
_L2:
        ItemCurrency itemcurrency2;
        obj = itemcurrency;
        itemcurrency2 = ((ItemCurrency) (obj));
        if (itemcurrency1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        itemcurrency2 = ((ItemCurrency) (obj));
        if (itemcurrency1.code == null)
        {
            break; /* Loop/switch isn't completed */
        }
        itemcurrency2 = ((ItemCurrency) (obj));
        if (itemcurrency1.value == null)
        {
            break; /* Loop/switch isn't completed */
        }
        itemcurrency2 = itemcurrency1;
        obj = itemcurrency2;
        if (itemcurrency1.code.equals(userCurrencyCode)) goto _L4; else goto _L3
_L3:
        obj = itemcurrency.code;
        if (userCurrencyCode.equals(obj))
        {
            return itemcurrency;
        }
        itemcurrency1 = CurrencyConversionCache.getConversionRate(ebayContext, ((String) (obj)), userCurrencyCode);
        if (currencyLog.isLoggable)
        {
            currencyLog.log((new StringBuilder()).append("getConvertedPrice query rate for ").append(((String) (obj))).append(" to ").append(userCurrencyCode).toString());
        }
        if (itemcurrency1 == null || !((CurrencyConversionRate) (itemcurrency1)).isExchangeRateAvailable)
        {
            break; /* Loop/switch isn't completed */
        }
        itemcurrency = (new CurrencyAmount(itemcurrency)).multiplyBy(((CurrencyConversionRate) (itemcurrency1)).conversionFactor);
        itemcurrency = new ItemCurrency(userCurrencyCode, String.valueOf(itemcurrency.getValueAsDouble()));
        obj = itemcurrency;
        if (currencyLog.isLoggable)
        {
            currencyLog.log((new StringBuilder()).append("found ").append(itemcurrency1).toString());
            return itemcurrency;
        }
        if (true) goto _L4; else goto _L5
_L5:
        obj = itemcurrency2;
        if (currencyLog.isLoggable)
        {
            currencyLog.log("Not found or not available");
            return itemcurrency2;
        }
        if (true) goto _L4; else goto _L6
_L6:
    }

    private Spannable getOrBuyItNowText(String s)
    {
        int i = colorSecondary;
        String s1 = resources.getString(0x7f070743);
        int j = s.length() + 1;
        int k = j + s1.length();
        s = new SpannableString((new StringBuilder(s)).append('\n').append(s1));
        s.setSpan(new ForegroundColorSpan(i), j, k, 33);
        s.setSpan(new StyleSpan(1), j, k, 33);
        s.setSpan(new AbsoluteSizeSpan(10, true), j, k, 33);
        return s;
    }

    private Spannable getPriceSpannable(String s, String s1, EbaySearchListItem ebaysearchlistitem, boolean flag)
    {
        int j = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010038);
        int i;
        int k;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        try
        {
            s = EbayCurrencyUtil.formatDisplay(s, Double.parseDouble(ebaysearchlistitem.currentPrice.value) / Double.parseDouble(ebaysearchlistitem.unitPriceQuantity), i | 2);
            ebaysearchlistitem = (new StringBuilder()).append("(").append(s).append(" / ").append(ebaysearchlistitem.unitPriceType).append(")").toString();
            i = s1.length() + 1;
            k = i + ebaysearchlistitem.length();
            s = new StyleSpan(1);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_130;
        }
        s = new StyleSpan(3);
        s1 = new SpannableString((new StringBuilder(s1)).append('\n').append(ebaysearchlistitem));
        s1.setSpan(new ForegroundColorSpan(j), i, k, 33);
        s1.setSpan(s, i, k, 33);
        s1.setSpan(new AbsoluteSizeSpan(10, true), i, k, 33);
        return s1;
    }

    private Spannable getPriceSpannableAuctionWithBin(String s, String s1, EbaySearchListItem ebaysearchlistitem, boolean flag)
    {
        int j = ThemeUtil.resolveThemeForegroundColor(resources, theme, 0x1010038);
        ItemCurrency itemcurrency;
        int i;
        int k;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        if (ebaysearchlistitem.convertedBuyItNowPrice == null)
        {
            break MISSING_BLOCK_LABEL_229;
        }
        itemcurrency = ebaysearchlistitem.convertedBuyItNowPrice;
_L1:
        s = EbayCurrencyUtil.formatDisplay(s, Double.parseDouble(itemcurrency.value) / Double.parseDouble(ebaysearchlistitem.unitPriceQuantity), i | 2);
        ebaysearchlistitem = (new StringBuilder()).append("(").append(s).append(" / ").append(ebaysearchlistitem.unitPriceType).append(")").toString();
        i = s1.length() + 1;
        k = i + ebaysearchlistitem.length();
        s = new StyleSpan(1);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_146;
        }
        s = new StyleSpan(3);
        s1 = new SpannableString((new StringBuilder(s1)).append('\n').append(ebaysearchlistitem));
        s1.setSpan(new ForegroundColorSpan(j), i, k, 33);
        s1.setSpan(s, i, k, 33);
        s1.setSpan(new AbsoluteSizeSpan(10, true), i, k, 33);
        return s1;
        try
        {
            itemcurrency = ebaysearchlistitem.buyItNowPrice;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
          goto _L1
    }

    private boolean isUnitPriceAvailable(EbaySearchListItem ebaysearchlistitem)
    {
        return DeviceConfiguration.getAsync().get(DcsBoolean.EU_BASE_UNIT_PRICE) && (ebaysearchlistitem.listingType == 3 || ebaysearchlistitem.listingType == 5 || ebaysearchlistitem.listingType == 6) && !TextUtils.isEmpty(ebaysearchlistitem.unitPriceQuantity) && !TextUtils.isEmpty(ebaysearchlistitem.unitPriceType);
    }

    private boolean notifyCurrencyConversion(EbaySearchListItem ebaysearchlistitem)
    {
        if (ebaysearchlistitem == null || ebaysearchlistitem.currentPrice == null)
        {
            return false;
        } else
        {
            ebaysearchlistitem = ebaysearchlistitem.currentPrice.code;
            return CurrencyConversionCache.willFetch(ebayContext, ebaysearchlistitem, userCurrencyCode);
        }
    }

    private String resolveImageUrl(EbaySearchListItem ebaysearchlistitem)
    {
        String s1 = ebaysearchlistitem.imageUrl;
        String s = s1;
        if (!ebaysearchlistitem.isFromSaaS)
        {
            if (useLargeImages && !TextUtils.isEmpty(ebaysearchlistitem.superSizeImageUrl))
            {
                s = ebaysearchlistitem.superSizeImageUrl;
            } else
            {
                s = s1;
                if (useLargeImages)
                {
                    s = s1;
                    if (!TextUtils.isEmpty(ebaysearchlistitem.masterImageUrl))
                    {
                        return ebaysearchlistitem.masterImageUrl;
                    }
                }
            }
        }
        return s;
    }

    private boolean setItemPricing(ViewCache viewcache, EbaySearchListItem ebaysearchlistitem)
    {
        boolean flag2;
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
                        {
                            boolean flag;
                            boolean flag1;
                            boolean flag3;
                            boolean flag4;
label4:
                            {
                                flag1 = false;
                                flag = false;
                                flag4 = false;
                                flag3 = false;
                                boolean flag5 = isUnitPriceAvailable(ebaysearchlistitem);
                                flag2 = flag5;
                                if (!flag5)
                                {
                                    break label4;
                                }
                                Double double1 = EbayCurrencyUtil.parseApiValue(ebaysearchlistitem.unitPriceQuantity);
                                if (double1 != null)
                                {
                                    flag2 = flag5;
                                    if (double1.doubleValue() > 0.0D)
                                    {
                                        break label4;
                                    }
                                }
                                flag2 = false;
                            }
                            switch (ebaysearchlistitem.listingType)
                            {
                            case 4: // '\004'
                            default:
                                flag2 = setCurrency(viewcache.rightColumnText1, ebaysearchlistitem.currentPrice, ebaysearchlistitem.convertedCurrentPrice, flag2, ebaysearchlistitem);
                                if (ebaysearchlistitem.isEbn || ebaysearchlistitem.isInStorePickup || ebaysearchlistitem.isPickupAndDropOff)
                                {
                                    viewcache.rightColumnText3.setVisibility(8);
                                } else
                                {
                                    viewcache.rightColumnText3.setVisibility(0);
                                    viewcache.rightColumnText3.setText("");
                                }
                                break;

                            case 2: // '\002'
                                break label2;

                            case 3: // '\003'
                                break label3;

                            case 5: // '\005'
                            case 6: // '\006'
                                break label1;
                            }
                        }
                        if (flag3)
                        {
                            viewcache.rightColumnText1.setText(0x7f0705ab);
                        }
                        if (flag)
                        {
                            setCurrency(viewcache.rightColumnText5, ebaysearchlistitem.originalRetailPrice, null);
                            viewcache.rightColumnText5.setVisibility(0);
                        } else
                        {
                            viewcache.rightColumnText5.setVisibility(8);
                        }
                        if (ebaysearchlistitem.bestOfferEnabled)
                        {
                            if (!ebaysearchlistitem.isEbn && !ebaysearchlistitem.isInStorePickup && !ebaysearchlistitem.isPickupAndDropOff)
                            {
                                break label0;
                            }
                            viewcache.rightColumnText3.setVisibility(8);
                        }
                        return flag2;
                    }
                    if (ebaysearchlistitem.buyItNowAvailable && (ebaysearchlistitem.buyItNowPrice != null || ebaysearchlistitem.convertedBuyItNowPrice != null) && (buyingFormat & 1) == 0)
                    {
                        flag2 = setCurrency(viewcache.rightColumnText1, ebaysearchlistitem.buyItNowPrice, ebaysearchlistitem.convertedBuyItNowPrice, flag2, ebaysearchlistitem);
                        if (ebaysearchlistitem.isEbn || ebaysearchlistitem.isInStorePickup || ebaysearchlistitem.isPickupAndDropOff)
                        {
                            viewcache.rightColumnText3.setVisibility(8);
                        } else
                        {
                            viewcache.rightColumnText3.setVisibility(0);
                            viewcache.rightColumnText3.setText(0x7f070529);
                        }
                        break MISSING_BLOCK_LABEL_147;
                    }
                }
                if (flag2 && ebaysearchlistitem.buyItNowAvailable && (ebaysearchlistitem.buyItNowPrice != null || ebaysearchlistitem.convertedBuyItNowPrice != null))
                {
                    flag2 = setCurrencyWithBaseUnitPriceAuctionWithBin(viewcache.rightColumnText1, ebaysearchlistitem.currentPrice, ebaysearchlistitem.convertedCurrentPrice, ebaysearchlistitem.buyItNowPrice, ebaysearchlistitem.convertedBuyItNowPrice, flag2, ebaysearchlistitem);
                } else
                {
                    flag2 = setCurrency(viewcache.rightColumnText1, ebaysearchlistitem.currentPrice, ebaysearchlistitem.convertedCurrentPrice, false, null);
                }
                if (ebaysearchlistitem.isEbn || ebaysearchlistitem.isInStorePickup || ebaysearchlistitem.isPickupAndDropOff)
                {
                    viewcache.rightColumnText3.setVisibility(8);
                } else
                {
                    viewcache.rightColumnText3.setVisibility(0);
                    if (ebaysearchlistitem.buyItNowAvailable)
                    {
                        viewcache.rightColumnText3.setText(getOrBuyItNowText(resources.getQuantityString(0x7f080013, ebaysearchlistitem.bidCount, new Object[] {
                            Integer.valueOf(ebaysearchlistitem.bidCount)
                        })));
                    } else
                    {
                        viewcache.rightColumnText3.setText(resources.getQuantityString(0x7f080013, ebaysearchlistitem.bidCount, new Object[] {
                            Integer.valueOf(ebaysearchlistitem.bidCount)
                        }));
                    }
                }
                break MISSING_BLOCK_LABEL_147;
            }
            flag3 = flag4;
            flag = flag1;
            if (ebaysearchlistitem.originalRetailPrice != null)
            {
                flag3 = flag4;
                flag = flag1;
                if (ebaysearchlistitem.originalRetailPrice.code != null)
                {
                    flag3 = flag4;
                    flag = flag1;
                    if (ebaysearchlistitem.originalRetailPrice.value != null)
                    {
                        flag3 = "MAP".equals(ebaysearchlistitem.pricingTreatment);
                        if (flag3 || "STP".equals(ebaysearchlistitem.pricingTreatment))
                        {
                            flag = true;
                        } else
                        {
                            flag = false;
                        }
                    }
                }
            }
            flag2 = setCurrency(viewcache.rightColumnText1, ebaysearchlistitem.currentPrice, ebaysearchlistitem.convertedCurrentPrice, flag2, ebaysearchlistitem);
            if (ebaysearchlistitem.isEbn || ebaysearchlistitem.isInStorePickup || ebaysearchlistitem.isPickupAndDropOff)
            {
                viewcache.rightColumnText3.setVisibility(8);
            } else
            {
                viewcache.rightColumnText3.setVisibility(0);
                viewcache.rightColumnText3.setText(0x7f070529);
            }
            break MISSING_BLOCK_LABEL_147;
        }
        viewcache.rightColumnText3.setVisibility(0);
        viewcache.rightColumnText3.setText(binOrBestOffer);
        return flag2;
    }

    private void setShippingLabel(ViewCache viewcache, EbaySearchListItem ebaysearchlistitem, boolean flag)
    {
        int i;
        EbayCountry ebaycountry;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        ebaycountry = MyApp.getPrefs().getCurrentCountry();
        if (showEbayNowLabel(ebaysearchlistitem))
        {
            viewcache.rightColumnText2.setText(SearchUtil.getEbayNowResourceForCountry(ebaycountry));
            viewcache.rightColumnText2.setTextColor(colorSecondary);
            viewcache.rightColumnText2.setVisibility(0);
            return;
        }
        if (showPickupDropOffLabel(ebaysearchlistitem))
        {
            viewcache.rightColumnText2.setText(SearchUtil.getPudoResourceForCountry(ebaycountry));
            viewcache.rightColumnText2.setTextColor(colorSecondary);
            viewcache.rightColumnText2.setVisibility(0);
            return;
        }
        if (showInStorePickupLabel(ebaysearchlistitem))
        {
            viewcache.rightColumnText2.setText(SearchUtil.getInStorePickupResourceForCountry(ebaycountry));
            viewcache.rightColumnText2.setTextColor(colorSecondary);
            viewcache.rightColumnText2.setVisibility(0);
            return;
        }
        if (showLocalPickupLabel(ebaysearchlistitem))
        {
            viewcache.rightColumnText2.setText(0x7f0700b7);
            viewcache.rightColumnText2.setTextColor(colorSecondary);
            viewcache.rightColumnText2.setVisibility(0);
            return;
        }
        if (!showShipping || ebaysearchlistitem.shippingCost == null || ebaysearchlistitem.shippingCost.code == null || ebaysearchlistitem.shippingCost.value == null) goto _L2; else goto _L1
_L1:
        int j = colorSecondary;
        boolean flag1;
        boolean flag2;
        flag2 = false;
        flag1 = false;
        double d;
        d = Double.parseDouble(ebaysearchlistitem.shippingCost.value);
        ebaysearchlistitem = EbayCurrency.getInstance(ebaysearchlistitem.shippingCost.code);
        if (!ebaysearchlistitem.isInsignificant(d)) goto _L4; else goto _L3
_L3:
        if (!showFreeShipping) goto _L6; else goto _L5
_L5:
        j = colorShippingFree;
        viewcache.rightColumnText2.setText(0x7f070422);
        i = ((flag1) ? 1 : 0);
_L7:
        try
        {
            viewcache.rightColumnText2.setTypeface(Typeface.DEFAULT, i);
            viewcache.rightColumnText2.setTextColor(j);
            viewcache.rightColumnText2.setVisibility(0);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EbaySearchListItem ebaysearchlistitem)
        {
            viewcache.rightColumnText2.setVisibility(8);
        }
        return;
_L6:
        viewcache.rightColumnText2.setText("");
        i = ((flag1) ? 1 : 0);
        continue; /* Loop/switch isn't completed */
_L4:
        String s = EbayCurrencyUtil.formatDisplay(ebaysearchlistitem, d, i | 2);
        i = ((flag2) ? 1 : 0);
        ebaysearchlistitem = s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_390;
        }
        i = 2;
        ebaysearchlistitem = (new StringBuilder()).append(s).append(" ").toString();
        viewcache.rightColumnText2.setText(ebaysearchlistitem);
        if (true) goto _L7; else goto _L2
_L2:
        viewcache.rightColumnText2.setVisibility(8);
        return;
    }

    public void init(ViewCache viewcache)
    {
        viewcache.text.setTextColor(colorPrimary);
        viewcache.rightColumnText1.setTextColor(colorPrimary);
        viewcache.rightColumnText3.setTextColor(colorSecondary);
        viewcache.rightColumnText5.setPaintFlags(viewcache.rightColumnText5.getPaintFlags() | 0x10);
        super.init(viewcache);
    }

    public void markItemAsVisited(View view, EbaySearchListItem ebaysearchlistitem)
    {
        FrameLayout framelayout = (FrameLayout)view.findViewById(0x7f100131);
        View view1 = view.findViewById(0x7f10013b);
        if (distinguishRecentlyViewed && LruVisitedItemCache.get().contains(Long.valueOf(ebaysearchlistitem.id)))
        {
            view.setBackgroundResource(recentlyViewedBackgroundResId);
            if (framelayout != null)
            {
                framelayout.setBackgroundResource(recentlyViewedColorResId);
            }
            if (view1 != null)
            {
                view1.setBackgroundResource(recentlyViewedBackgroundResId);
            }
        } else
        {
            view.setBackgroundResource(0);
            if (framelayout != null)
            {
                framelayout.setBackgroundResource(standardItemBackgroundResId);
            }
            if (view1 != null)
            {
                view1.setBackgroundResource(selectableBackgroundResId);
                return;
            }
        }
    }

    public volatile void markItemAsVisited(View view, Object obj)
    {
        markItemAsVisited(view, (EbaySearchListItem)obj);
    }

    public void refresh(AbsListView abslistview)
    {
        long l = EbayResponse.currentHostTime();
        int j = abslistview.getChildCount();
        int i = 0;
        while (i < j) 
        {
            Object obj = abslistview.getChildAt(i);
            if (obj != null)
            {
                obj = (ViewCache)((View) (obj)).getTag();
                if (obj != null)
                {
                    EbaySearchListItem ebaysearchlistitem = (EbaySearchListItem)((ViewCache) (obj)).object;
                    if (ebaysearchlistitem != null)
                    {
                        if (((ViewCache) (obj)).isCurrencyConversionPending)
                        {
                            if (currencyLog.isLoggable)
                            {
                                currencyLog.log((new StringBuilder()).append("refresh - found pending currency item: ").append(ebaysearchlistitem.title).toString());
                            }
                            obj.isCurrencyConversionPending = notifyCurrencyConversion(ebaysearchlistitem);
                            if (!((ViewCache) (obj)).isCurrencyConversionPending)
                            {
                                setItemPricing(((ViewCache) (obj)), ebaysearchlistitem);
                            }
                        }
                        if (ebaysearchlistitem.isEbn || ebaysearchlistitem.isInStorePickup || ebaysearchlistitem.isPickupAndDropOff)
                        {
                            ((ViewCache) (obj)).rightColumnText4.setVisibility(8);
                        } else
                        {
                            ((ViewCache) (obj)).rightColumnText4.setVisibility(0);
                            setTimeLeft(((ViewCache) (obj)).rightColumnText4, ebaysearchlistitem.endDate, l);
                        }
                    }
                }
            }
            i++;
        }
    }

    public void refresh(ExpandableListView expandablelistview)
    {
    }

    protected boolean setCurrency(TextView textview, ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
    {
        return setCurrency(textview, itemcurrency, itemcurrency1, false, null);
    }

    protected boolean setCurrency(TextView textview, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, boolean flag, EbaySearchListItem ebaysearchlistitem)
    {
        ItemCurrency itemcurrency2 = getConvertedPrice(itemcurrency, itemcurrency1);
        if (itemcurrency2 != null)
        {
            Object obj;
            int i;
            boolean flag1;
            boolean flag2;
            if (!itemcurrency2.code.equals(itemcurrency.code))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            itemcurrency1 = formatCurrency(itemcurrency2.value, itemcurrency2.code, i | 2);
            flag1 = true;
            i = ((flag1) ? 1 : 0);
            itemcurrency = itemcurrency1;
            if (flag2)
            {
                i = ((flag1) ? 1 : 0);
                itemcurrency = itemcurrency1;
                if (itemcurrency1 != null)
                {
                    i = 2;
                    itemcurrency = (new StringBuilder()).append(itemcurrency1).append(" ").toString();
                }
            }
            obj = null;
            itemcurrency1 = obj;
            if (DeviceConfiguration.getAsync().get(DcsBoolean.EU_BASE_UNIT_PRICE))
            {
                itemcurrency1 = obj;
                if (flag)
                {
                    itemcurrency1 = obj;
                    if (ebaysearchlistitem != null)
                    {
                        itemcurrency1 = getPriceSpannable(itemcurrency2.code, itemcurrency, ebaysearchlistitem, flag2);
                    }
                }
            }
            if (itemcurrency1 == null)
            {
                textview.setTypeface(Typeface.DEFAULT, i);
                textview.setText(itemcurrency);
                return flag2;
            } else
            {
                textview.setText(itemcurrency1);
                return flag2;
            }
        } else
        {
            textview.setText(null);
            return false;
        }
    }

    protected boolean setCurrencyWithBaseUnitPriceAuctionWithBin(TextView textview, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, ItemCurrency itemcurrency2, ItemCurrency itemcurrency3, boolean flag, EbaySearchListItem ebaysearchlistitem)
    {
        itemcurrency1 = getConvertedPrice(itemcurrency, itemcurrency1);
        if (itemcurrency1 != null)
        {
            Object obj;
            int i;
            boolean flag1;
            boolean flag2;
            if (!itemcurrency1.code.equals(itemcurrency.code))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            itemcurrency1 = formatCurrency(itemcurrency1.value, itemcurrency1.code, i | 2);
            flag1 = true;
            i = ((flag1) ? 1 : 0);
            itemcurrency = itemcurrency1;
            if (flag2)
            {
                i = ((flag1) ? 1 : 0);
                itemcurrency = itemcurrency1;
                if (itemcurrency1 != null)
                {
                    i = 2;
                    itemcurrency = (new StringBuilder()).append(itemcurrency1).append(" ").toString();
                }
            }
            obj = null;
            itemcurrency1 = obj;
            if (DeviceConfiguration.getAsync().get(DcsBoolean.EU_BASE_UNIT_PRICE))
            {
                itemcurrency1 = obj;
                if (flag)
                {
                    itemcurrency1 = obj;
                    if (ebaysearchlistitem != null)
                    {
                        itemcurrency3 = getConvertedPrice(itemcurrency2, itemcurrency3);
                        itemcurrency1 = obj;
                        if (itemcurrency3 != null)
                        {
                            flag = itemcurrency3.code.equals(itemcurrency2.code);
                            itemcurrency1 = getPriceSpannableAuctionWithBin(itemcurrency3.code, itemcurrency, ebaysearchlistitem, flag);
                        }
                    }
                }
            }
            if (itemcurrency1 == null)
            {
                textview.setTypeface(Typeface.DEFAULT, i);
                textview.setText(itemcurrency);
                return flag2;
            } else
            {
                textview.setText(itemcurrency1);
                return flag2;
            }
        } else
        {
            textview.setText(null);
            return false;
        }
    }

    public void setItem(ViewCache viewcache, EbaySearchListItem ebaysearchlistitem)
    {
        throw new UnsupportedOperationException();
    }

    public void setItem(ViewCache viewcache, EbaySearchListItem ebaysearchlistitem, int i)
    {
        if (ebaysearchlistitem != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        viewcache.isCurrencyConversionPending = notifyCurrencyConversion(ebaysearchlistitem);
        viewcache.image.setRemoteImageUrl(resolveImageUrl(ebaysearchlistitem));
        if (!TextUtils.isEmpty(ebaysearchlistitem.eekRating))
        {
            viewcache.specialText.setVisibility(0);
            viewcache.specialText.setText((new StringBuilder()).append(resources.getString(0x7f070087)).append(" ").append(ebaysearchlistitem.eekRating).toString());
        } else
        {
            viewcache.specialText.setVisibility(8);
        }
        viewcache.text.setText(ebaysearchlistitem.title);
        if (ebaysearchlistitem.isEbn || ebaysearchlistitem.isInStorePickup || ebaysearchlistitem.isPickupAndDropOff)
        {
            viewcache.rightColumnText4.setVisibility(8);
        } else
        {
            viewcache.rightColumnText4.setVisibility(0);
            setTimeLeft(viewcache.rightColumnText4, ebaysearchlistitem.endDate, EbayResponse.currentHostTime());
        }
        switch (ebaysearchlistitem.sellingState)
        {
        default:
            break;

        case 4: // '\004'
            break; /* Loop/switch isn't completed */

        case 5: // '\005'
            break;
        }
        break MISSING_BLOCK_LABEL_256;
_L4:
        setShippingLabel(viewcache, ebaysearchlistitem, setItemPricing(viewcache, ebaysearchlistitem));
        markItemAsVisited(viewcache.rootView, ebaysearchlistitem);
        if (!useLargeImages && viewcache.rootCellLayout != null)
        {
            viewcache.rootCellLayout.setBackgroundResource(computeListViewBackgroundResId(i));
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        viewcache.rightColumnText1.setTextColor(colorPriceSold);
          goto _L4
        viewcache.rightColumnText1.setTextColor(colorPriceUnsold);
          goto _L4
    }

    public volatile void setItem(ViewCache viewcache, Object obj)
    {
        setItem(viewcache, (EbaySearchListItem)obj);
    }

    public volatile void setItem(ViewCache viewcache, Object obj, int i)
    {
        setItem(viewcache, (EbaySearchListItem)obj, i);
    }

    protected void setTimeLeft(TextView textview, Date date, long l)
    {
        int i;
        if (date != null)
        {
            l = date.getTime() - l;
        } else
        {
            l = 0L;
        }
        if (l > 0L && l < 0x36ee80L)
        {
            i = colorTimeWarning;
        } else
        {
            i = colorSecondary;
        }
        textview.setTextColor(i);
        if (l >= 0x757b12c00L)
        {
            textview.setText(null);
            return;
        }
        if (l > 0L)
        {
            l /= 1000L;
            int j = (int)(l % 60L);
            l /= 60L;
            int k = (int)(l % 60L);
            l /= 60L;
            int i1 = (int)(l % 24L);
            int j1 = (int)(l / 24L);
            date = new StringBuilder();
            if (j1 > 0)
            {
                date.append(j1).append(strDays).append(' ').append(i1).append(strHours);
            } else
            if (i1 > 0)
            {
                date.append(i1).append(strHours).append(' ').append(k).append(strMinutes);
            } else
            if (k > 0)
            {
                date.append(k).append(strMinutes).append(' ').append(j).append(strSeconds);
            } else
            {
                date.append(j).append(strSeconds);
            }
            textview.setText(date.toString());
            return;
        } else
        {
            textview.setText(0x7f0703c3);
            return;
        }
    }

    protected boolean showEbayNowLabel(EbaySearchListItem ebaysearchlistitem)
    {
        return false;
    }

    protected boolean showInStorePickupLabel(EbaySearchListItem ebaysearchlistitem)
    {
        return false;
    }

    protected boolean showLocalPickupLabel(EbaySearchListItem ebaysearchlistitem)
    {
        return false;
    }

    protected boolean showPickupDropOffLabel(EbaySearchListItem ebaysearchlistitem)
    {
        return false;
    }

}
