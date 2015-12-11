// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.connection.myebay;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.CurrencyConversionCache;
import com.ebay.common.Preferences;
import com.ebay.common.model.currency.CurrencyConversionRate;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.EbayCurrencyUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.mobile.util.ThemeUtil;
import com.ebay.mobile.widget.CompositeArrayRecyclerAdapter;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbayCurrency;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.data.OrderPickupStatus;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.FwContext;
import java.util.ArrayList;
import java.util.Date;

public class MyEbayBaseRecyclerAdapter extends CompositeArrayRecyclerAdapter
{
    public class ConversionViewHolder extends com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ListIndexViewHolder
    {

        private final View currencyText;
        final MyEbayBaseRecyclerAdapter this$0;

        protected void onBindView(int i, int j)
        {
            if (hasCurrencyConversion && j + 1 == getListCount())
            {
                currencyText.setVisibility(0);
                return;
            } else
            {
                currencyText.setVisibility(8);
                return;
            }
        }

        public ConversionViewHolder(View view)
        {
            this$0 = MyEbayBaseRecyclerAdapter.this;
            super(view);
            currencyText = view.findViewById(0x7f1003b8);
        }
    }

    public static interface MyEbayAdapterCallback
    {

        public abstract void onItemPressed(int i);

        public abstract void onNonDeletableOrderInfoClicked();
    }


    private static final String CONVERTED_PRICE_INDICATOR = "*";
    private static final String PICKUP_STATUS_NOT_APPLICABLE = "NotApplicable";
    public static final int TYPE_BUYING_BEST_OFFER = 7;
    public static final int TYPE_BUYING_BIDDING = 4;
    public static final int TYPE_BUYING_NOT_WON = 6;
    public static final int TYPE_BUYING_WON = 5;
    public static final int TYPE_DUMMY_SPACE = 8;
    public static final int TYPE_WATCHING_ACTIVE = 1;
    public static final int TYPE_WATCHING_ALL = 3;
    public static final int TYPE_WATCHING_ENDED = 2;
    private final String buyItNow;
    protected final MyEbayAdapterCallback callback;
    private final String classifiedAd;
    private final int colorEndingSoon;
    protected final int colorPriceReserveNotMet;
    protected final EbayContext ebayContext;
    private int emptyResource;
    private final String freeAllCaps;
    private final String freight;
    protected boolean hasCurrencyConversion;
    protected int headerResource;
    private final String inStorePickup;
    protected final LayoutInflater inflater;
    protected final boolean isBopisEnabled = MyApp.getDeviceConfiguration().isBopisEnabled();
    protected final boolean isShippingDisplayed = shouldShowShippingCosts();
    protected final int itemLayoutResource;
    com.ebay.mobile.common.ListSelector.ListItemSelector itemSelector;
    private final String orBestOffer;
    protected final String orBuyItNow;
    protected final Resources resources;
    private final String seeDescription;
    private final String shippingFormat;
    private final String strDays;
    private final String strHours;
    private final String strMinutes;
    private final String strSeconds;
    protected final int textColorPrimary;
    protected final int textColorSecondary;
    private final String userCurrencyCode;

    public MyEbayBaseRecyclerAdapter(Activity activity, MyEbayAdapterCallback myebayadaptercallback, int i)
    {
        super(activity, i, 0x1020014);
        emptyResource = -1;
        EbayCountry ebaycountry = MyApp.getPrefs().getCurrentCountry();
        callback = myebayadaptercallback;
        itemLayoutResource = i;
        hasCurrencyConversion = false;
        ebayContext = ((FwContext)activity).getEbayContext();
        resources = activity.getResources();
        inflater = LayoutInflater.from(activity);
        userCurrencyCode = ebaycountry.getCurrency().getCurrencyCode();
        orBuyItNow = resources.getString(0x7f070743);
        inStorePickup = resources.getString(SearchUtil.getInStorePickupResourceForCountry(ebaycountry));
        shippingFormat = resources.getString(0x7f0707a3);
        freeAllCaps = resources.getString(0x7f070422);
        seeDescription = resources.getString(0x7f070046);
        freight = resources.getString(0x7f070425);
        buyItNow = resources.getString(0x7f070529);
        orBestOffer = resources.getString(0x7f070742);
        classifiedAd = resources.getString(0x7f070568);
        strDays = resources.getString(0x7f070049);
        strHours = resources.getString(0x7f07004c);
        strMinutes = resources.getString(0x7f07004f);
        strSeconds = resources.getString(0x7f070052);
        colorEndingSoon = resources.getColor(0x7f0d00f0);
        colorPriceReserveNotMet = resources.getColor(0x7f0d00f0);
        textColorPrimary = ThemeUtil.resolveThemeColor(resources, activity.getTheme(), 0x1010036);
        textColorSecondary = ThemeUtil.resolveThemeColor(resources, activity.getTheme(), 0x1010038);
    }

    private boolean shouldShowShippingCosts()
    {
        EbayCountry ebaycountry = EbayApiUtil.getCurrentCountry();
        PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getPostalCode();
        return postalcodespecification != null && ebaycountry != null && ebaycountry.getCountryCode().equals(postalcodespecification.countryCode) && !TextUtils.isEmpty(postalcodespecification.postalCode);
    }

    protected ItemCurrency getConvertedPrice(ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
    {
        if (itemcurrency != null && itemcurrency.code != null && itemcurrency.value != null) goto _L2; else goto _L1
_L1:
        ItemCurrency itemcurrency3 = null;
_L4:
        return itemcurrency3;
_L2:
        ItemCurrency itemcurrency2;
        itemcurrency3 = itemcurrency;
        itemcurrency2 = itemcurrency3;
        if (itemcurrency1 == null)
        {
            break; /* Loop/switch isn't completed */
        }
        itemcurrency2 = itemcurrency3;
        if (itemcurrency1.code == null)
        {
            break; /* Loop/switch isn't completed */
        }
        itemcurrency2 = itemcurrency3;
        if (itemcurrency1.value == null)
        {
            break; /* Loop/switch isn't completed */
        }
        itemcurrency2 = itemcurrency1;
        itemcurrency3 = itemcurrency2;
        if (itemcurrency1.code.equals(userCurrencyCode)) goto _L4; else goto _L3
_L3:
        itemcurrency3 = itemcurrency2;
        if (DeviceConfiguration.getAsync().get(DcsBoolean.CurrencyConversion))
        {
            itemcurrency1 = itemcurrency.code;
            if (userCurrencyCode.equals(itemcurrency1))
            {
                return itemcurrency;
            }
            itemcurrency1 = CurrencyConversionCache.getConversionRate(ebayContext, itemcurrency1, userCurrencyCode);
            itemcurrency3 = itemcurrency2;
            if (itemcurrency1 != null)
            {
                itemcurrency3 = itemcurrency2;
                if (((CurrencyConversionRate) (itemcurrency1)).isExchangeRateAvailable)
                {
                    itemcurrency = (new CurrencyAmount(itemcurrency)).multiplyBy(((CurrencyConversionRate) (itemcurrency1)).conversionFactor);
                    return new ItemCurrency(userCurrencyCode, String.valueOf(itemcurrency.getValueAsDouble()));
                }
            }
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    protected String getMskuStringForItem(MyEbayListItem myebaylistitem)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (myebaylistitem != null && myebaylistitem.nameValueList != null)
        {
            int j = myebaylistitem.nameValueList.size();
            for (int i = 0; i < j; i++)
            {
                stringbuilder.append(((NameValue)myebaylistitem.nameValueList.get(i)).getValue());
                if (i != j - 1)
                {
                    stringbuilder.append(", ");
                }
            }

        }
        return stringbuilder.toString();
    }

    protected void handleCurrencyConversionSetup()
    {
        if (!hasCurrencyConversion)
        {
            hasCurrencyConversion = true;
        }
    }

    protected boolean isBopis(MyEbayListItem myebaylistitem)
    {
        return myebaylistitem != null && myebaylistitem.transaction != null && myebaylistitem.transaction.pickupStatus != null && !TextUtils.isEmpty(myebaylistitem.transaction.pickupStoreId) && !"NotApplicable".equals(myebaylistitem.transaction.pickupStatus.name());
    }

    protected boolean isSelected(MyEbayListItem myebaylistitem)
    {
        if (itemSelector == null || myebaylistitem == null)
        {
            return false;
        } else
        {
            return itemSelector.isSelected(myebaylistitem);
        }
    }

    protected boolean isSelectionEnabled()
    {
        if (itemSelector == null)
        {
            return false;
        } else
        {
            return itemSelector.getIsSelectionEnabled();
        }
    }

    public com.ebay.mobile.widget.CompositeArrayRecyclerAdapter.ListIndexViewHolder onCreateEmptyViewHolder(ViewGroup viewgroup)
    {
        if (emptyResource != -1)
        {
            return new ConversionViewHolder(inflater.inflate(emptyResource, viewgroup, false));
        } else
        {
            return super.onCreateEmptyViewHolder(viewgroup);
        }
    }

    protected boolean setCurrency(TextView textview, ItemCurrency itemcurrency, ItemCurrency itemcurrency1)
    {
        int i = 1;
        itemcurrency1 = getConvertedPrice(itemcurrency, itemcurrency1);
        if (itemcurrency1 != null)
        {
            boolean flag;
            if (!itemcurrency1.code.equals(itemcurrency.code))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag)
            {
                i = 2;
            }
            itemcurrency1 = EbayCurrencyUtil.formatDisplay(itemcurrency1, i);
            itemcurrency = itemcurrency1;
            if (flag)
            {
                itemcurrency = itemcurrency1;
                if (itemcurrency1 != null)
                {
                    textview.setTypeface(Typeface.DEFAULT, 2);
                    itemcurrency = (new StringBuilder()).append(itemcurrency1).append("*").toString();
                }
            }
            textview.setText(itemcurrency);
            return flag;
        } else
        {
            textview.setText(null);
            return false;
        }
    }

    public void setEmptyViewResource(int i)
    {
        super.setEmptyViewResource(i);
        emptyResource = i;
    }

    public void setHeaderViewResource(int i)
    {
        super.setHeaderViewResource(i);
        headerResource = i;
    }

    public void setItemSelector(com.ebay.mobile.common.ListSelector.ListItemSelector listitemselector)
    {
        if (listitemselector == null)
        {
            return;
        } else
        {
            itemSelector = listitemselector;
            itemSelector.setOnSelectionModeChangeListener(new com.ebay.mobile.common.ListSelector.OnSelectionModeChangeListener() {

                final MyEbayBaseRecyclerAdapter this$0;

                public void onSelectionModeChanged(boolean flag)
                {
                    for (int i = 0; i < getItemCount(); i++)
                    {
                        notifyItemChanged(i);
                    }

                }

            
            {
                this$0 = MyEbayBaseRecyclerAdapter.this;
                super();
            }
            });
            return;
        }
    }

    protected void setListingTypeState(MyEbayListItem myebaylistitem, int i, TextView textview, TextView textview1)
    {
        myebaylistitem.listingType;
        JVM INSTR tableswitch 2 6: default 40
    //                   2 54
    //                   3 117
    //                   4 240
    //                   5 165
    //                   6 165;
           goto _L1 _L2 _L3 _L4 _L5 _L5
_L1:
        textview.setVisibility(8);
        textview1.setVisibility(8);
        return;
_L2:
        textview.setText(resources.getQuantityString(0x7f080013, myebaylistitem.bidCount, new Object[] {
            Integer.valueOf(myebaylistitem.bidCount)
        }));
        if (myebaylistitem.buyItNowAvailable)
        {
            textview1.setText(orBuyItNow);
            textview1.setVisibility(0);
            return;
        } else
        {
            textview1.setVisibility(8);
            return;
        }
_L3:
        textview.setText(resources.getQuantityString(0x7f080013, myebaylistitem.bidCount, new Object[] {
            Integer.valueOf(myebaylistitem.bidCount)
        }));
        textview1.setText(orBuyItNow);
        textview1.setVisibility(0);
        return;
_L5:
        i;
        JVM INSTR tableswitch 1 3: default 192
    //                   1 223
    //                   2 223
    //                   3 223;
           goto _L6 _L7 _L7 _L7
_L6:
        textview.setText(buyItNow);
_L8:
        if (myebaylistitem.bestOfferEnabled)
        {
            textview1.setText(orBestOffer);
            textview1.setVisibility(0);
            return;
        } else
        {
            textview1.setVisibility(8);
            return;
        }
_L7:
        textview.setVisibility(8);
          goto _L8
_L4:
        textview.setText(classifiedAd);
        if (myebaylistitem.bestOfferEnabled)
        {
            textview1.setText(orBestOffer);
            textview1.setVisibility(0);
            return;
        } else
        {
            textview1.setVisibility(8);
            return;
        }
    }

    protected void setShippingCost(MyEbayListItem myebaylistitem, TextView textview, boolean flag)
    {
        int i;
label0:
        {
            i = 1;
            if (isShippingDisplayed)
            {
                textview.setVisibility(0);
                if (!isBopisEnabled || !isBopis(myebaylistitem))
                {
                    break label0;
                }
                textview.setText(inStorePickup);
            }
            return;
        }
        if ("NotSpecified".equals(myebaylistitem.shippingType))
        {
            textview.setText(seeDescription);
            return;
        }
        if ("Free".equals(myebaylistitem.shippingType))
        {
            textview.setText(freeAllCaps);
            return;
        }
        if ("Freight".equals(myebaylistitem.shippingType))
        {
            textview.setText(freight);
            return;
        }
        if (myebaylistitem.shippingCost == null || myebaylistitem.shippingCost.code == null || myebaylistitem.shippingCost.value == null)
        {
            break MISSING_BLOCK_LABEL_296;
        }
        try
        {
            double d = Double.parseDouble(myebaylistitem.shippingCost.value);
            if (EbayCurrency.getInstance(myebaylistitem.shippingCost.code).isInsignificant(d))
            {
                textview.setText(freeAllCaps);
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (MyEbayListItem myebaylistitem)
        {
            textview.setVisibility(8);
            return;
        }
        double d1;
        ItemCurrency itemcurrency = getConvertedPrice(myebaylistitem.shippingCost, null);
        setCurrency(textview, myebaylistitem.shippingCost, itemcurrency);
        d1 = Double.parseDouble(itemcurrency.value);
        myebaylistitem = itemcurrency.code;
        String s;
        if (!flag)
        {
            i = 2;
        }
        myebaylistitem = EbayCurrencyUtil.formatDisplay(myebaylistitem, d1, i);
        s = String.format(shippingFormat, new Object[] {
            myebaylistitem
        });
        myebaylistitem = s;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_284;
        }
        textview.setTypeface(Typeface.DEFAULT, 2);
        myebaylistitem = (new StringBuilder()).append(s).append("*").toString();
        textview.setText(myebaylistitem);
        return;
        textview.setVisibility(8);
        return;
    }

    protected void setTimeLeft(TextView textview, Date date, long l)
    {
        if (textview == null)
        {
            return;
        }
        textview.setVisibility(0);
        int i;
        if (date != null)
        {
            l = date.getTime() - l;
        } else
        {
            l = 0L;
        }
        if (l > 0L && l < 0x5265c00L)
        {
            i = colorEndingSoon;
        } else
        {
            i = textColorSecondary;
        }
        textview.setTextColor(i);
        if (l >= 0x757b12c00L)
        {
            textview.setVisibility(8);
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
            textview.setTextColor(textColorSecondary);
            textview.setText(0x7f0700c1);
            return;
        }
    }

    protected void toggleSelection(MyEbayListItem myebaylistitem)
    {
        if (itemSelector == null || myebaylistitem == null)
        {
            return;
        } else
        {
            itemSelector.toggleSelection(myebaylistitem);
            return;
        }
    }

    public void updateTimeRemaining(int i, View view)
    {
        int j = getItemViewType(i);
        int k = getSectionFromItemPosition(i).listType;
        if (j == 0 && (k == 1 || k == 3 || k == 4 || k == 7))
        {
            MyEbayListItem myebaylistitem = (MyEbayListItem)getItem(i);
            view = (TextView)view.findViewById(0x7f1003b7);
            if (view != null)
            {
                setTimeLeft(view, myebaylistitem.endDate, EbayResponse.currentHostTime());
                view.invalidate();
            }
        }
    }
}
