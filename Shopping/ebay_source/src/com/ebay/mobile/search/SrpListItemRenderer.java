// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ebay.android.widget.RemoteImageView;
import com.ebay.common.CurrencyConversionCache;
import com.ebay.common.Preferences;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.idealmodel.SrpListItemViewModel;
import com.ebay.common.util.LruHistoryCache;
import com.ebay.common.view.RegularItemViewHolder;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.Date;

// Referenced classes of package com.ebay.mobile.search:
//            SearchUtil, LruVisitedItemCache

public class SrpListItemRenderer
{

    public static final int TITLE_MAX_LINES_DEFAULT = 3;
    public static final int TITLE_MAX_LINES_PROMOTED = 2;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo currencyLog = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("CurrencyConversion", 3, "Log CurrencyConversion");
    private final EbayContext ebayContext;
    protected final EbayCountry preferredCountry = MyApp.getPrefs().getCurrentCountry();
    protected final String preferredCurrencyCode;
    private final SearchParameters searchParameters;

    public SrpListItemRenderer(EbayContext ebaycontext, SearchParameters searchparameters)
    {
        ebayContext = ebaycontext;
        preferredCurrencyCode = preferredCountry.getCurrency().getCurrencyCode();
        searchParameters = searchparameters;
    }

    private ItemCurrency convertPrice(ItemCurrency itemcurrency)
    {
        ItemCurrency itemcurrency2 = itemcurrency;
        ItemCurrency itemcurrency1 = itemcurrency2;
        if (itemcurrency != null)
        {
            itemcurrency1 = itemcurrency2;
            if (itemcurrency.code != null)
            {
                CurrencyConversionRate currencyconversionrate = CurrencyConversionCache.getConversionRate(ebayContext, itemcurrency.code, preferredCurrencyCode);
                if (currencyLog.isLoggable)
                {
                    currencyLog.log((new StringBuilder()).append("getConvertedPrice query rate for ").append(itemcurrency.code).append(" to ").append(preferredCurrencyCode).toString());
                }
                if (currencyconversionrate != null && currencyconversionrate.isExchangeRateAvailable)
                {
                    itemcurrency = (new CurrencyAmount(itemcurrency)).multiplyBy(currencyconversionrate.conversionFactor);
                    itemcurrency = new ItemCurrency(preferredCurrencyCode, String.valueOf(itemcurrency.getValueAsDouble()));
                    itemcurrency1 = itemcurrency;
                    if (currencyLog.isLoggable)
                    {
                        currencyLog.log((new StringBuilder()).append("found ").append(currencyconversionrate).toString());
                        itemcurrency1 = itemcurrency;
                    }
                } else
                {
                    itemcurrency1 = itemcurrency2;
                    if (currencyLog.isLoggable)
                    {
                        currencyLog.log("Not found or not available");
                        return itemcurrency2;
                    }
                }
            }
        }
        return itemcurrency1;
    }

    private int getEbnResourceForSrp()
    {
        return !"GB".equals(preferredCountry.getCountryCode()) ? 0x7f070383 : 0x7f0700db;
    }

    private String getPriceFromCurrency(ItemCurrency itemcurrency, int i)
    {
        Object obj = null;
        String s = obj;
        if (itemcurrency != null)
        {
            s = obj;
            if (itemcurrency.code != null)
            {
                s = obj;
                if (itemcurrency.value != null)
                {
                    try
                    {
                        double d = Double.parseDouble(itemcurrency.value);
                        s = EbayCurrencyUtil.formatDisplay(itemcurrency.code, d, i);
                    }
                    // Misplaced declaration of an exception variable
                    catch (ItemCurrency itemcurrency)
                    {
                        return null;
                    }
                }
            }
        }
        return s;
    }

    private void setShipping(RegularItemViewHolder regularitemviewholder, SrpListItemViewModel srplistitemviewmodel)
    {
        double d;
        EbayCurrency ebaycurrency;
        boolean flag;
        regularitemviewholder.shippingText.setVisibility(0);
        flag = DeviceConfiguration.getAsync().get(DcsBoolean.eBayNow);
        if (searchParameters.ebnOnly && srplistitemviewmodel.isEbn && flag)
        {
            regularitemviewholder.shippingText.setText(getEbnResourceForSrp());
            return;
        }
        if (searchParameters.inStorePickupOnly && srplistitemviewmodel.isIspu)
        {
            regularitemviewholder.shippingText.setText(SearchUtil.getInStorePickupResourceForCountry(preferredCountry));
            return;
        }
        if (searchParameters.inStorePickupOnly && srplistitemviewmodel.isPudo)
        {
            regularitemviewholder.shippingText.setText(SearchUtil.getPudoResourceForCountry(preferredCountry));
            return;
        }
        if (searchParameters.localPickupOnly && srplistitemviewmodel.isLocal)
        {
            regularitemviewholder.shippingText.setText(0x7f0700b7);
            return;
        }
        if (!MyApp.getPrefs().isSignedIn() || searchParameters.hideShipping || srplistitemviewmodel.shipping == null || srplistitemviewmodel.price == null)
        {
            break MISSING_BLOCK_LABEL_282;
        }
        try
        {
            d = Double.parseDouble(srplistitemviewmodel.shipping.value);
            ebaycurrency = EbayCurrency.getInstance(srplistitemviewmodel.shipping.code);
            if (ebaycurrency.isInsignificant(d))
            {
                regularitemviewholder.shippingText.setText(0x7f070422);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (SrpListItemViewModel srplistitemviewmodel)
        {
            regularitemviewholder.shippingText.setVisibility(8);
            return;
        }
        srplistitemviewmodel = EbayCurrencyUtil.formatDisplay(ebaycurrency, d, getCurrencyFormatFlags(isPriceConverted(srplistitemviewmodel.price, srplistitemviewmodel.shipping)));
        regularitemviewholder.shippingText.setText((new StringBuilder()).append("+ ").append(srplistitemviewmodel).toString());
        return;
        if (srplistitemviewmodel.isEbn && flag)
        {
            regularitemviewholder.shippingText.setText(getEbnResourceForSrp());
            return;
        }
        if (srplistitemviewmodel.isPudo)
        {
            regularitemviewholder.shippingText.setText(SearchUtil.getPudoResourceForCountry(preferredCountry));
            return;
        }
        if (srplistitemviewmodel.isIspu)
        {
            regularitemviewholder.shippingText.setText(SearchUtil.getInStorePickupResourceForCountry(preferredCountry));
            return;
        }
        if (srplistitemviewmodel.isLocal)
        {
            regularitemviewholder.shippingText.setText(0x7f0700b7);
            return;
        } else
        {
            regularitemviewholder.shippingText.setVisibility(8);
            return;
        }
    }

    private void setTimeLeft(Context context, TextView textview, SrpListItemViewModel srplistitemviewmodel)
    {
        int i;
        long l;
label0:
        {
            textview.setVisibility(8);
            if (srplistitemviewmodel.endDate != null && (srplistitemviewmodel.hasAuction || "EndTimeSoonest".equals(searchParameters.sortOrder) || "StartTimeNewest".equals(searchParameters.sortOrder)))
            {
                l = EbayResponse.currentHostTime();
                l = srplistitemviewmodel.endDate.getTime() - l;
                srplistitemviewmodel = context.getResources();
                i = ThemeUtil.resolveThemeColor(srplistitemviewmodel, context.getTheme(), 0x1010038);
                if (l < 0x7528ad000L)
                {
                    break label0;
                }
            }
            return;
        }
        context = Util.formatDayHourMinSec(textview.getContext(), l, false);
        if (srplistitemviewmodel.getString(0x7f0703c3).equals(context))
        {
            textview.setTextColor(i);
        } else
        {
            if (l < 0x36ee80L)
            {
                i = srplistitemviewmodel.getColor(0x7f0d00f0);
            }
            textview.setTextColor(i);
        }
        textview.setText(context);
        textview.setVisibility(0);
    }

    protected void formatPrices(Context context, RegularItemViewHolder regularitemviewholder, SrpListItemViewModel srplistitemviewmodel, ItemCurrency itemcurrency)
    {
        boolean flag = isPriceConverted(srplistitemviewmodel.price, srplistitemviewmodel.strikeThruPrice);
        boolean flag1 = isPriceConverted(srplistitemviewmodel.price, itemcurrency);
        itemcurrency = context.getResources();
        int i = itemcurrency.getColor(0x7f0d00e9);
        int j = itemcurrency.getColor(0x7f0d00f0);
        int k = ThemeUtil.resolveThemeColor(itemcurrency, context.getTheme(), 0x1010036);
        if (regularitemviewholder.priceText != null && srplistitemviewmodel.isMap)
        {
            itemcurrency = setStrikethrough(new SpannableStringBuilder(regularitemviewholder.priceText.getText()));
            context = itemcurrency;
            if (flag)
            {
                context = setItalicization(itemcurrency);
            }
            regularitemviewholder.priceText.setText(context);
        } else
        if (regularitemviewholder.priceText != null && flag1)
        {
            context = setItalicization(new SpannableStringBuilder(regularitemviewholder.priceText.getText()));
            regularitemviewholder.priceText.setText(context);
        }
        if (srplistitemviewmodel.isSold)
        {
            regularitemviewholder.priceText.setTextColor(i);
        } else
        if (srplistitemviewmodel.isEndedWithoutSale)
        {
            regularitemviewholder.priceText.setTextColor(j);
        } else
        {
            regularitemviewholder.priceText.setTextColor(k);
        }
        if (regularitemviewholder.unitText != null && !TextUtils.isEmpty(srplistitemviewmodel.unitPriceQuantity) && flag1)
        {
            context = setItalicization(new SpannableStringBuilder(regularitemviewholder.unitText.getText()));
            regularitemviewholder.unitText.setText(context);
        }
        if (regularitemviewholder.strikethroughText != null && srplistitemviewmodel.strikeThruPrice != null)
        {
            itemcurrency = setStrikethrough(new SpannableStringBuilder(regularitemviewholder.strikethroughText.getText().toString()));
            context = itemcurrency;
            if (flag)
            {
                context = setItalicization(itemcurrency);
            }
            regularitemviewholder.strikethroughText.setText(context);
        }
        if (regularitemviewholder.shippingText != null && !searchParameters.hideShipping && isPriceConverted(srplistitemviewmodel.price, srplistitemviewmodel.shipping))
        {
            context = setItalicization(new SpannableStringBuilder(regularitemviewholder.shippingText.getText()));
            regularitemviewholder.shippingText.setText(context);
        }
    }

    protected int getCurrencyFormatFlags(boolean flag)
    {
        int i = 2;
        if (flag)
        {
            i = 2 | 1;
        }
        return i;
    }

    protected boolean isPriceConverted(ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
    {
        return itemcurrency != null && !TextUtils.isEmpty(itemcurrency.code) && itemcurrency1 != null && !itemcurrency.code.equals(itemcurrency1.code);
    }

    public void markItemAsVisited(View view, long l)
    {
        if (view != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Object obj;
        int k;
        int i1;
        obj = view.getContext().getTheme();
        int i = ThemeUtil.resolveThemeResId(((android.content.res.Resources.Theme) (obj)), 0x7f010059, 0x7f01005b);
        int j = ThemeUtil.resolveThemeResId(((android.content.res.Resources.Theme) (obj)), 0x7f01005a, 0x7f0d00f9);
        k = ThemeUtil.resolveThemeResId(((android.content.res.Resources.Theme) (obj)), 0x7f01005b, 0);
        i1 = ThemeUtil.resolveThemeResId(((android.content.res.Resources.Theme) (obj)), 0x101030e, 0x7f01005b);
        obj = (FrameLayout)view.findViewById(0x7f100131);
        if (!LruVisitedItemCache.get().contains(Long.valueOf(l)))
        {
            break; /* Loop/switch isn't completed */
        }
        view.setBackgroundResource(i);
        if (obj != null)
        {
            ((FrameLayout) (obj)).setBackgroundResource(j);
            return;
        }
        if (true) goto _L1; else goto _L3
_L3:
        view.setBackgroundResource(i1);
        if (obj != null)
        {
            ((FrameLayout) (obj)).setBackgroundResource(k);
            return;
        }
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void onFragmentTimerTick(View view, SrpListItemViewModel srplistitemviewmodel)
    {
        view = (TextView)view.findViewById(0x7f10080a);
        if (view != null)
        {
            setTimeLeft(view.getContext(), view, srplistitemviewmodel);
        }
    }

    protected SpannableStringBuilder setItalicization(SpannableStringBuilder spannablestringbuilder)
    {
        if (!TextUtils.isEmpty(spannablestringbuilder))
        {
            spannablestringbuilder.append(" ");
            spannablestringbuilder.setSpan(new StyleSpan(2), 0, spannablestringbuilder.length(), 33);
        }
        return spannablestringbuilder;
    }

    public void setItem(RegularItemViewHolder regularitemviewholder, SrpListItemViewModel srplistitemviewmodel)
    {
        Context context = regularitemviewholder.titleText.getContext();
        regularitemviewholder.image.setRemoteImageUrl(srplistitemviewmodel.imageUrl, srplistitemviewmodel.imageZoomGuid, srplistitemviewmodel.imageZoomMd5);
        regularitemviewholder.titleText.setText(srplistitemviewmodel.title);
        ItemCurrency itemcurrency = setPrice(regularitemviewholder, srplistitemviewmodel);
        setShipping(regularitemviewholder, srplistitemviewmodel);
        setUnitPrice(regularitemviewholder, srplistitemviewmodel, itemcurrency);
        if (srplistitemviewmodel.isMap)
        {
            regularitemviewholder.detailsLabel.setVisibility(0);
            regularitemviewholder.strikethroughText.setVisibility(8);
        } else
        {
            regularitemviewholder.detailsLabel.setVisibility(8);
            setStrikethroughPrice(regularitemviewholder, srplistitemviewmodel);
        }
        if (srplistitemviewmodel.bidCount != null)
        {
            regularitemviewholder.bidCountText.setText(context.getResources().getQuantityString(0x7f080013, srplistitemviewmodel.bidCount.intValue(), new Object[] {
                srplistitemviewmodel.bidCount
            }));
            regularitemviewholder.bidCountText.setVisibility(0);
        } else
        {
            regularitemviewholder.bidCountText.setVisibility(8);
        }
        if ((searchParameters.maxDistance > 0 || "DistanceNearest".equals(searchParameters.sortOrder)) && srplistitemviewmodel.distanceUnit != null)
        {
            String s;
            if ("km".equals(srplistitemviewmodel.distanceUnit))
            {
                s = (new StringBuilder()).append("< ").append((int)srplistitemviewmodel.distanceLength).append(" ").append(context.getResources().getString(0x7f070514)).toString();
            } else
            if ("mi".equals(srplistitemviewmodel.distanceUnit))
            {
                s = (new StringBuilder()).append("< ").append((int)srplistitemviewmodel.distanceLength).append(" ").append(context.getResources().getString(0x7f070637)).toString();
            } else
            {
                s = (new StringBuilder()).append("< ").append((int)srplistitemviewmodel.distanceLength).append(" ").append(srplistitemviewmodel.distanceUnit).toString();
            }
            regularitemviewholder.distanceText.setText(s);
            regularitemviewholder.distanceText.setVisibility(0);
        } else
        {
            regularitemviewholder.distanceText.setVisibility(8);
        }
        if (!TextUtils.isEmpty(srplistitemviewmodel.eekRating))
        {
            regularitemviewholder.eekText.setText((new StringBuilder()).append(context.getString(0x7f070087)).append(" ").append(srplistitemviewmodel.eekRating).toString());
            regularitemviewholder.eekText.setVisibility(0);
        } else
        {
            regularitemviewholder.eekText.setVisibility(8);
        }
        if (srplistitemviewmodel.isPromoted)
        {
            regularitemviewholder.titleText.setMaxLines(2);
            regularitemviewholder.promotedLabel.setVisibility(0);
            if (srplistitemviewmodel.promotedLabel != null)
            {
                regularitemviewholder.promotedLabel.setText(srplistitemviewmodel.promotedLabel);
            }
        } else
        {
            regularitemviewholder.titleText.setMaxLines(3);
            regularitemviewholder.promotedLabel.setVisibility(8);
        }
        if (srplistitemviewmodel.isBestOffer)
        {
            regularitemviewholder.oboLabel.setVisibility(0);
        } else
        {
            regularitemviewholder.oboLabel.setVisibility(8);
        }
        if (srplistitemviewmodel.isAbin)
        {
            regularitemviewholder.binLabel.setVisibility(0);
        } else
        {
            regularitemviewholder.binLabel.setVisibility(8);
        }
        if (srplistitemviewmodel.isMsku)
        {
            regularitemviewholder.optionsLabel.setVisibility(0);
        } else
        {
            regularitemviewholder.optionsLabel.setVisibility(8);
        }
        if (srplistitemviewmodel.isClassified)
        {
            regularitemviewholder.classifiedLabel.setVisibility(0);
        } else
        {
            regularitemviewholder.classifiedLabel.setVisibility(8);
        }
        if (srplistitemviewmodel.isEbayPlus)
        {
            regularitemviewholder.ebayPlusBadge.setVisibility(0);
        } else
        {
            regularitemviewholder.ebayPlusBadge.setVisibility(8);
        }
        setTimeLeft(context, regularitemviewholder.timeLeftText, srplistitemviewmodel);
        formatPrices(context, regularitemviewholder, srplistitemviewmodel, itemcurrency);
        markItemAsVisited(regularitemviewholder.rootView, srplistitemviewmodel.id);
    }

    protected ItemCurrency setPrice(RegularItemViewHolder regularitemviewholder, SrpListItemViewModel srplistitemviewmodel)
    {
        ItemCurrency itemcurrency;
label0:
        {
            itemcurrency = null;
            if ((srplistitemviewmodel.convertedPrice == null || TextUtils.isEmpty(srplistitemviewmodel.convertedPrice.value)) && (srplistitemviewmodel.price == null || TextUtils.isEmpty(srplistitemviewmodel.price.value)) && (!srplistitemviewmodel.isMap || srplistitemviewmodel.strikeThruPrice == null))
            {
                regularitemviewholder.priceText.setVisibility(8);
            } else
            if (srplistitemviewmodel.isMap)
            {
                itemcurrency = srplistitemviewmodel.strikeThruPrice;
            } else
            if (srplistitemviewmodel.convertedPrice != null && preferredCurrencyCode.equals(srplistitemviewmodel.convertedPrice.code))
            {
                itemcurrency = srplistitemviewmodel.convertedPrice;
            } else
            if (srplistitemviewmodel.price != null && preferredCurrencyCode.equals(srplistitemviewmodel.price.code))
            {
                itemcurrency = srplistitemviewmodel.price;
            } else
            {
                itemcurrency = convertPrice(srplistitemviewmodel.price);
            }
            if (itemcurrency != null)
            {
                srplistitemviewmodel = getPriceFromCurrency(itemcurrency, getCurrencyFormatFlags(isPriceConverted(srplistitemviewmodel.price, itemcurrency)));
                if (srplistitemviewmodel == null)
                {
                    break label0;
                }
                regularitemviewholder.priceText.setVisibility(0);
                regularitemviewholder.priceText.setText(srplistitemviewmodel);
            }
            return itemcurrency;
        }
        regularitemviewholder.priceText.setVisibility(8);
        return itemcurrency;
    }

    protected SpannableStringBuilder setStrikethrough(SpannableStringBuilder spannablestringbuilder)
    {
        if (!TextUtils.isEmpty(spannablestringbuilder))
        {
            spannablestringbuilder.setSpan(new StrikethroughSpan(), 0, TextUtils.getTrimmedLength(spannablestringbuilder), 33);
        }
        return spannablestringbuilder;
    }

    protected void setStrikethroughPrice(RegularItemViewHolder regularitemviewholder, SrpListItemViewModel srplistitemviewmodel)
    {
        if (srplistitemviewmodel.strikeThruPrice != null && !TextUtils.isEmpty(srplistitemviewmodel.strikeThruPrice.value) && !TextUtils.isEmpty(srplistitemviewmodel.strikeThruPrice.code))
        {
            boolean flag = isPriceConverted(srplistitemviewmodel.price, srplistitemviewmodel.strikeThruPrice);
            srplistitemviewmodel = getPriceFromCurrency(srplistitemviewmodel.strikeThruPrice, getCurrencyFormatFlags(flag));
            if (!TextUtils.isEmpty(srplistitemviewmodel))
            {
                regularitemviewholder.strikethroughText.setText(srplistitemviewmodel);
                regularitemviewholder.strikethroughText.setVisibility(0);
                return;
            } else
            {
                regularitemviewholder.strikethroughText.setVisibility(8);
                return;
            }
        } else
        {
            regularitemviewholder.strikethroughText.setVisibility(8);
            return;
        }
    }

    protected void setUnitPrice(RegularItemViewHolder regularitemviewholder, SrpListItemViewModel srplistitemviewmodel, ItemCurrency itemcurrency)
    {
        if (DeviceConfiguration.getAsync().get(DcsBoolean.EU_BASE_UNIT_PRICE) && !TextUtils.isEmpty(srplistitemviewmodel.unitPriceQuantity) && !TextUtils.isEmpty(srplistitemviewmodel.unitPriceType))
        {
            if (itemcurrency != null && !TextUtils.isEmpty(itemcurrency.value))
            {
                try
                {
                    boolean flag = isPriceConverted(srplistitemviewmodel.price, itemcurrency);
                    double d = Double.parseDouble(itemcurrency.value) / Double.parseDouble(srplistitemviewmodel.unitPriceQuantity);
                    itemcurrency = EbayCurrencyUtil.formatDisplay(itemcurrency.code, d, getCurrencyFormatFlags(flag));
                    srplistitemviewmodel = (new StringBuilder()).append("(").append(itemcurrency).append(" / ").append(srplistitemviewmodel.unitPriceType).append(")").toString();
                    regularitemviewholder.unitText.setText(srplistitemviewmodel);
                    regularitemviewholder.unitText.setVisibility(0);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (SrpListItemViewModel srplistitemviewmodel)
                {
                    regularitemviewholder.unitText.setVisibility(8);
                }
                return;
            } else
            {
                regularitemviewholder.unitText.setVisibility(8);
                return;
            }
        } else
        {
            regularitemviewholder.unitText.setVisibility(8);
            return;
        }
    }

}
