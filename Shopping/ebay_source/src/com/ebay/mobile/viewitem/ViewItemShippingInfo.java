// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.common.Preferences;
import com.ebay.common.model.ItemTransaction;
import com.ebay.common.model.OrderShippingInfo;
import com.ebay.common.model.ShippingCostsTaxJurisdiction;
import com.ebay.common.view.util.EbayCountryManager;
import com.ebay.mobile.Item;
import com.ebay.mobile.ItemViewPayPalable;
import com.ebay.mobile.ItemViewShipping;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.common.LocalUtil;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.data.PostalCodeSpecification;
import com.ebay.nautilus.domain.data.ShippingCostsShippingOption;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.FwContext;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ViewItemShippingInfo extends BaseDataMapped
    implements Parcelable
{

    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public ViewItemShippingInfo createFromParcel(Parcel parcel)
        {
            return (ViewItemShippingInfo)DataMapperFactory.readParcelJson(parcel, com/ebay/mobile/viewitem/ViewItemShippingInfo);
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public ViewItemShippingInfo[] newArray(int i)
        {
            return new ViewItemShippingInfo[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final String EBAY_NOW_LOGISTICS_TYPE_KEY = "EBN";
    public static final String ISPU_LOGISTICS_TYPE_KEY = "ISPU";
    public static final int MAIN_VIP_MAX_ITEMS = 3;
    public static final String NOT_SPECIFIED = "NotSpecified";
    public static final String PUDO_LOGISTICS_TYPE_KEY = "PUDO";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("VIPShippingInfo", 3, "Shipping");
    public List ebnOptions;
    public ItemCurrency importCharge;
    public boolean isDomesticShippingAvailable;
    public boolean isInternationalShippingAvailable;
    public boolean isSalesTaxAppliedToShipping;
    public boolean isShipToHomeAvailable;
    public boolean isShipToHomeOnly;
    public List ispuOptions;
    public List orderedOptions;
    public List pudoOptions;
    public List shipToHomeOptions;
    public ItemCurrency shippingServiceAdditionalCost;
    public ItemCurrency shippingServiceCost;
    public String summaryShippingServiceName;
    public String summaryShippingType;
    public ArrayList taxTable;

    public ViewItemShippingInfo()
    {
        summaryShippingType = "NotSpecified";
        taxTable = new ArrayList();
    }

    public static boolean IsLocalPickupOnly(Item item)
    {
        if (useTransactedShipping(item))
        {
            return IsShippingServiceLocal(item.iTransaction.selectedShippingOption.shippingServiceName);
        } else
        {
            return item.isLocalPickupOnly;
        }
    }

    public static boolean IsShippingServiceLocal(String s)
    {
        return "AT_Pickup".equals(s) || "AU_Pickup".equals(s) || "BEFR_Pickup".equals(s) || "BENL_Pickup".equals(s) || "CA_Pickup".equals(s) || "CH_Pickup".equals(s) || "DE_Pickup".equals(s) || "ES_Pickup".equals(s) || "FR_Pickup".equals(s) || "FR_RemiseEnMainPropre".equals(s) || "HK_LocalPickUpOnly".equals(s) || "IT_Pickup".equals(s) || "LocalDelivery".equals(s) || "NL_Pickup".equals(s) || "Pickup".equals(s) || "PL_Pickup".equals(s) || "SG_Delivery".equals(s) || "SG_LocalPickUpOnly".equals(s) || "TW_SelfPickup".equals(s) || "UK_CollectInPerson".equals(s);
    }

    public static boolean areShippingOptionsDomestic(Item item)
    {
        return item.shippingInfo.isDomesticShippingAvailable && (item.isTransacted || !item.isSeller);
    }

    public static boolean displayShippingCost(Item item, EbayContext ebaycontext, int i, SpannableStringBuilder spannablestringbuilder, ItemCurrency itemcurrency, boolean flag, boolean flag1, boolean flag2)
    {
        Resources resources = ((Context)ebaycontext.getExtension(android/content/Context)).getResources();
        int j = spannablestringbuilder.length();
        if (itemcurrency != null)
        {
            if ((new CurrencyAmount(itemcurrency)).isZero())
            {
                if (!item.isFreight)
                {
                    spannablestringbuilder.append(resources.getString(0x7f070422));
                    spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(i)), j, spannablestringbuilder.length(), 33);
                }
            } else
            {
                item.computeDisplayPrice(resources, spannablestringbuilder, itemcurrency, null, Item.convertCurrency(ebaycontext, itemcurrency), null, false, i, flag, null, null, flag1, flag2);
            }
        } else
        if (item.isFreight)
        {
            if (!item.isSeller)
            {
                spannablestringbuilder.append(resources.getString(0x7f070175));
                spannablestringbuilder.setSpan(new ForegroundColorSpan(resources.getColor(0x106000c)), j, spannablestringbuilder.length(), 33);
            }
            return true;
        }
        return itemcurrency != null;
    }

    public static CharSequence displayShippingCostSane(Item item, EbayContext ebaycontext, int i, ItemCurrency itemcurrency, boolean flag, boolean flag1, boolean flag2)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (itemcurrency == null) goto _L2; else goto _L1
_L1:
        if (!(new CurrencyAmount(itemcurrency)).isZero()) goto _L4; else goto _L3
_L3:
        if (!item.isFreight)
        {
            spannablestringbuilder.append(ebaycontext.getString(0x7f070422));
            spannablestringbuilder.setSpan(new ForegroundColorSpan(i), 0, spannablestringbuilder.length(), 33);
        }
_L6:
        return spannablestringbuilder;
_L4:
        ItemCurrency itemcurrency1 = Item.convertCurrency(ebaycontext, itemcurrency);
        item.computeDisplayPriceUsingTextColor(((Context)ebaycontext.getExtension(android/content/Context)).getResources(), spannablestringbuilder, itemcurrency, null, itemcurrency1, null, false, i, flag, null, null, flag1, flag2);
        return spannablestringbuilder;
_L2:
        if (item.isFreight && !item.isSeller)
        {
            spannablestringbuilder.append(ebaycontext.getString(0x7f070175));
            spannablestringbuilder.setSpan(new ForegroundColorSpan(i), 0, spannablestringbuilder.length(), 33);
            return spannablestringbuilder;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static List getAllShippingOptions(Item item)
    {
label0:
        {
            ArrayList arraylist = null;
            if (item != null)
            {
                if (!useTransactedShipping(item))
                {
                    break label0;
                }
                arraylist = new ArrayList();
                arraylist.add(item.iTransaction.selectedShippingOption);
            }
            return arraylist;
        }
        if (item.isSeller)
        {
            return item.sellerShippingOptions;
        } else
        {
            return item.shippingInfo.orderedOptions;
        }
    }

    public static CharSequence getBopisSynopsis(Context context, int i, int j)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append(Util.RenderString(context.getString(SearchUtil.getInStorePickupResourceForCountry(MyApp.getPrefs().getCurrentCountry())), i, 0));
        spannablestringbuilder.append('\n');
        spannablestringbuilder.append(Util.RenderString(context.getString(0x7f070421), i, 0));
        return spannablestringbuilder;
    }

    public static List getCarrierShippingOptions(Item item)
    {
        LinkedList linkedlist = new LinkedList();
        item = getAllShippingOptions(item);
        if (item != null)
        {
            item = item.iterator();
            do
            {
                if (!item.hasNext())
                {
                    break;
                }
                ShippingCostsShippingOption shippingcostsshippingoption = (ShippingCostsShippingOption)item.next();
                if (shippingcostsshippingoption.logisticsPlanType == null || shippingcostsshippingoption.logisticsPlanType != com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.EBN && shippingcostsshippingoption.logisticsPlanType != com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.ISPU && shippingcostsshippingoption.logisticsPlanType != com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.PUDO)
                {
                    linkedlist.add(shippingcostsshippingoption);
                }
            } while (true);
        }
        return linkedlist;
    }

    public static String getEarliestEbnDelivery(Context context, Date date, boolean flag)
    {
label0:
        {
label1:
            {
                String s = null;
                Date date1 = Calendar.getInstance().getTime();
                long l = date.getTime() - date1.getTime();
                if (l > 0L)
                {
                    switch ((int)(l / 0x5265c00L))
                    {
                    default:
                        int i;
                        if (flag)
                        {
                            i = 0x7f0704f7;
                        } else
                        {
                            i = 0x7f0704f6;
                        }
                        s = context.getString(i, new Object[] {
                            DateUtils.formatDateTime(context, date.getTime(), 24)
                        });
                        break;

                    case 0: // '\0'
                        break label1;

                    case 1: // '\001'
                        break label0;
                    }
                }
                return s;
            }
            if (flag)
            {
                i = 0x7f0704fc;
            } else
            {
                i = 0x7f0704fb;
            }
            return context.getString(i);
        }
        if (flag)
        {
            i = 0x7f0704fa;
        } else
        {
            i = 0x7f0704f9;
        }
        return context.getString(i);
    }

    public static List getEbayNowShippingOptions(Item item)
    {
        if (item.shippingInfo.ebnOptions != null)
        {
            return item.shippingInfo.ebnOptions;
        } else
        {
            return new LinkedList();
        }
    }

    public static CharSequence getEbnShippingCost(EbayContext ebaycontext, Item item, ItemCurrency itemcurrency, ItemCurrency itemcurrency1, int i)
    {
        if (itemcurrency1 != null && !itemcurrency.equals(itemcurrency1))
        {
            return String.format(ebaycontext.getString(0x7f0704b5), new Object[] {
                displayShippingCostSane(item, ebaycontext, i, itemcurrency, true, false, false)
            });
        } else
        {
            return displayShippingCostSane(item, ebaycontext, i, itemcurrency, true, false, false);
        }
    }

    public static String[] getEstimatedDeliveryDates(Context context, Item item)
    {
        return getEstimatedDeliveryDates(context, item, false);
    }

    public static String[] getEstimatedDeliveryDates(Context context, Item item, boolean flag)
    {
        Object obj;
        Object obj1;
        Object obj2;
        String as[];
        obj1 = null;
        as = new String[3];
        as[0] = null;
        as[1] = null;
        as[2] = null;
        obj = null;
        obj2 = null;
        boolean flag1;
        if (item.iTransaction != null && item.iTransaction.orderShippingInfo != null && item.iTransaction.orderShippingInfo.shippedDate != null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!flag1) goto _L2; else goto _L1
_L1:
        obj1 = Util.getDeliveryDateFormat(context, false);
        as[0] = DateFormat.format(((CharSequence) (obj1)), item.iTransaction.orderShippingInfo.shippedDate).toString();
        if (item.iTransaction.orderShippingInfo.actualDeliveryDate != null)
        {
            as[1] = context.getString(0x7f070205, new Object[] {
                DateFormat.format(((CharSequence) (obj1)), item.iTransaction.orderShippingInfo.actualDeliveryDate).toString()
            });
            item = obj2;
        } else
        {
            obj = item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate;
            obj1 = item.iTransaction.orderShippingInfo.estimatedMinDeliveryDate;
            item = ((Item) (obj));
            obj = obj1;
        }
_L4:
        if (obj != null && item != null)
        {
            as[1] = Util.getDeliveryDateString(context, ((Date) (obj)), item, flag);
        }
        return as;
_L2:
        if (useTransactedShipping(item) && item.iTransaction.orderShippingInfo != null)
        {
            obj = item.iTransaction.orderShippingInfo.estimatedMaxDeliveryDate;
            obj1 = item.iTransaction.orderShippingInfo.estimatedMinDeliveryDate;
            item = ((Item) (obj));
            obj = obj1;
        } else
        {
            Object obj3 = getCarrierShippingOptions(item);
            item = obj2;
            if (!((List) (obj3)).isEmpty())
            {
                obj3 = (ShippingCostsShippingOption)((List) (obj3)).get(0);
                obj = ((ShippingCostsShippingOption) (obj3)).estimatedDeliveryMinTime;
                Date date = ((ShippingCostsShippingOption) (obj3)).estimatedDeliveryMaxTime;
                item = ((Item) (obj1));
                if (((ShippingCostsShippingOption) (obj3)).fastAndFree)
                {
                    item = "true";
                }
                as[2] = item;
                item = date;
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getEstimatedShippingDates(Context context, Item item, boolean flag)
    {
        Object obj = null;
        Date date = null;
        String s = null;
        List list = getCarrierShippingOptions(item);
        item = s;
        if (!list.isEmpty())
        {
            item = (ShippingCostsShippingOption)list.get(0);
            date = ((ShippingCostsShippingOption) (item)).estimatedDeliveryMinTime;
            item = ((ShippingCostsShippingOption) (item)).estimatedDeliveryMaxTime;
        }
        s = obj;
        if (date != null)
        {
            s = obj;
            if (item != null)
            {
                s = Util.getDeliveryDateString(context, date, item, flag);
            }
        }
        return s;
    }

    public static String getExcludedShipLocationsAsLocalizedString(Resources resources, Item item)
    {
        return getLocalizedListOfLocations(resources, item.excludeShipToLocations);
    }

    public static String getFormattedEbnEstimatedDelivery(Context context, Item item)
    {
label0:
        {
label1:
            {
                Object obj1 = null;
                List list = getAllShippingOptions(item);
                Object obj = obj1;
                if (list != null)
                {
                    item = null;
                    obj = list.iterator();
                    do
                    {
                        if (!((Iterator) (obj)).hasNext())
                        {
                            break;
                        }
                        ShippingCostsShippingOption shippingcostsshippingoption = (ShippingCostsShippingOption)((Iterator) (obj)).next();
                        if (shippingcostsshippingoption.logisticsPlanType != null && shippingcostsshippingoption.logisticsPlanType == com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.EBN && (item == null || item.after(shippingcostsshippingoption.estimatedDeliveryMaxTime)))
                        {
                            item = shippingcostsshippingoption.estimatedDeliveryMaxTime;
                        }
                    } while (true);
                    obj = obj1;
                    if (item != null)
                    {
                        obj = Calendar.getInstance().getTime();
                        long l = item.getTime() - ((Date) (obj)).getTime();
                        obj = obj1;
                        if (l > 0L)
                        {
                            switch ((int)(l / 0x5265c00L))
                            {
                            default:
                                obj = context.getString(0x7f0704f8, new Object[] {
                                    DateUtils.formatDateTime(context, item.getTime(), 24)
                                });
                                break;

                            case 0: // '\0'
                                break label1;

                            case 1: // '\001'
                                break label0;
                            }
                        }
                    }
                }
                return ((String) (obj));
            }
            return context.getString(0x7f0704fd);
        }
        return context.getString(0x7f0704f9);
    }

    public static CharSequence getFormattedEbnShippingOption(EbayContext ebaycontext, Item item, int i, List list, boolean flag)
    {
        Object obj1;
label0:
        {
            obj1 = null;
            Object obj2 = getAllShippingOptions(item);
            if (obj2 == null)
            {
                break label0;
            }
            Object obj = null;
            Date date = null;
            ItemCurrency itemcurrency1 = null;
            ItemCurrency itemcurrency = null;
            Iterator iterator = ((List) (obj2)).iterator();
label1:
            do
            {
                ShippingCostsShippingOption shippingcostsshippingoption;
label2:
                {
                    if (!iterator.hasNext())
                    {
                        break label1;
                    }
                    shippingcostsshippingoption = (ShippingCostsShippingOption)iterator.next();
                    if (shippingcostsshippingoption.logisticsPlanType == null || shippingcostsshippingoption.logisticsPlanType != com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.EBN)
                    {
                        continue;
                    }
                    obj1 = obj;
                    if (obj == null)
                    {
                        obj1 = ebaycontext.getString(0x7f0704f4);
                    }
                    if (date != null)
                    {
                        obj2 = date;
                        if (!date.after(shippingcostsshippingoption.estimatedDeliveryMaxTime))
                        {
                            break label2;
                        }
                    }
                    obj2 = shippingcostsshippingoption.estimatedDeliveryMaxTime;
                }
                ItemCurrency itemcurrency2;
                CurrencyAmount currencyamount;
label3:
                {
                    currencyamount = new CurrencyAmount(shippingcostsshippingoption.shippingServiceCost);
                    if (itemcurrency1 != null)
                    {
                        itemcurrency2 = itemcurrency1;
                        if ((new CurrencyAmount(itemcurrency1)).compareTo(currencyamount) <= 0)
                        {
                            break label3;
                        }
                    }
                    itemcurrency2 = shippingcostsshippingoption.shippingServiceCost;
                }
                if (itemcurrency != null)
                {
                    date = ((Date) (obj2));
                    itemcurrency1 = itemcurrency2;
                    obj = obj1;
                    if ((new CurrencyAmount(itemcurrency)).compareTo(currencyamount) >= 0)
                    {
                        continue;
                    }
                }
                itemcurrency = shippingcostsshippingoption.shippingServiceCost;
                date = ((Date) (obj2));
                itemcurrency1 = itemcurrency2;
                obj = obj1;
            } while (true);
            obj2 = new SpannableStringBuilder();
            list = list.iterator();
            do
            {
                obj1 = obj2;
                if (!list.hasNext())
                {
                    break;
                }
                obj1 = (com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder)list.next();
                if (((SpannableStringBuilder) (obj2)).length() > 0)
                {
                    ((SpannableStringBuilder) (obj2)).append("\n");
                }
                static class _cls2
                {

                    static final int $SwitchMap$com$ebay$mobile$ItemViewShipping$ShippingDisplayOrderEnum[];
                    static final int $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[];

                    static 
                    {
                        $SwitchMap$com$ebay$mobile$ItemViewShipping$ShippingDisplayOrderEnum = new int[com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.values().length];
                        try
                        {
                            $SwitchMap$com$ebay$mobile$ItemViewShipping$ShippingDisplayOrderEnum[com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.EDD.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror8) { }
                        try
                        {
                            $SwitchMap$com$ebay$mobile$ItemViewShipping$ShippingDisplayOrderEnum[com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.COST.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror7) { }
                        try
                        {
                            $SwitchMap$com$ebay$mobile$ItemViewShipping$ShippingDisplayOrderEnum[com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.LOCATION.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror6) { }
                        try
                        {
                            $SwitchMap$com$ebay$mobile$ItemViewShipping$ShippingDisplayOrderEnum[com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum.SERVICE_NAME.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror5) { }
                        $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum = new int[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.values().length];
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.GSP.ordinal()] = 1;
                        }
                        catch (NoSuchFieldError nosuchfielderror4) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.SHIP_TO_HOME.ordinal()] = 2;
                        }
                        catch (NoSuchFieldError nosuchfielderror3) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.PUDO.ordinal()] = 3;
                        }
                        catch (NoSuchFieldError nosuchfielderror2) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.EBN.ordinal()] = 4;
                        }
                        catch (NoSuchFieldError nosuchfielderror1) { }
                        try
                        {
                            $SwitchMap$com$ebay$nautilus$domain$net$api$viewlisting$Listing$LogisticsPlanTypeEnum[com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.ISPU.ordinal()] = 5;
                        }
                        catch (NoSuchFieldError nosuchfielderror)
                        {
                            return;
                        }
                    }
                }

                switch (_cls2..SwitchMap.com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum[((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj1)).type.ordinal()])
                {
                case 1: // '\001'
                    if (date != null)
                    {
                        String s = getEarliestEbnDelivery((Context)ebaycontext.getExtension(android/content/Context), date, flag);
                        if (!TextUtils.isEmpty(s))
                        {
                            ((SpannableStringBuilder) (obj2)).append(Util.RenderString(s, ((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj1)).colorId, 0));
                        }
                    }
                    break;

                case 2: // '\002'
                    if (itemcurrency1 != null)
                    {
                        obj1 = getEbnShippingCost(ebaycontext, item, itemcurrency1, itemcurrency, ((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj1)).colorId);
                        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
                        {
                            ((SpannableStringBuilder) (obj2)).append(((CharSequence) (obj1)));
                        }
                    }
                    break;

                case 4: // '\004'
                    if (obj != null)
                    {
                        ((SpannableStringBuilder) (obj2)).append(Util.RenderString(((String) (obj)), ((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj1)).colorId, 0));
                    }
                    break;
                }
            } while (true);
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            return ((CharSequence) (obj1));
        } else
        {
            return null;
        }
    }

    public static CharSequence getFormattedMoneyBackGuaranteeString(String s, String s1, int i, int j)
    {
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append(Util.RenderString(s, i, 0));
        spannablestringbuilder.append('\n');
        spannablestringbuilder.append(Util.RenderString(s1, j, 0));
        if (!TextUtils.isEmpty(spannablestringbuilder))
        {
            return spannablestringbuilder;
        } else
        {
            return null;
        }
    }

    public static CharSequence getFormattedShippingNode(EbayContext ebaycontext, Item item, ShippingCostsShippingOption shippingcostsshippingoption, int i, List list)
    {
        Context context = (Context)ebaycontext.getExtension(android/content/Context);
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(shippingcostsshippingoption.shippingServiceName))
        {
            boolean flag = true;
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                Object obj = (com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder)list.next();
                if (spannablestringbuilder.length() > 0 && flag)
                {
                    spannablestringbuilder.append("\n");
                }
                boolean flag1 = true;
                switch (_cls2..SwitchMap.com.ebay.mobile.ItemViewShipping.ShippingDisplayOrderEnum[((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj)).type.ordinal()])
                {
                default:
                    flag = flag1;
                    break;

                case 1: // '\001'
                    if (shippingcostsshippingoption.estimatedDeliveryMaxTime != null && shippingcostsshippingoption.estimatedDeliveryMinTime != null)
                    {
                        spannablestringbuilder.append(Util.RenderString(Util.getDeliveryDateString(context, shippingcostsshippingoption.estimatedDeliveryMinTime, shippingcostsshippingoption.estimatedDeliveryMaxTime, ((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj)).eddReturnJustDates, ((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj)).eddIncludeDayOfWeek), ((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj)).colorId, 0));
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                    break;

                case 2: // '\002'
                    CharSequence charsequence = displayShippingCostSane(item, ebaycontext, ((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj)).colorId, shippingcostsshippingoption.shippingServiceCost, true, false, item.isDisplayPriceCurrencyCode);
                    if (TextUtils.isEmpty(charsequence))
                    {
                        spannablestringbuilder.append(getShippingError(context, item));
                    } else
                    {
                        spannablestringbuilder.append(charsequence);
                    }
                    flag = flag1;
                    if (((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj)).costShowEachAdditional)
                    {
                        flag = flag1;
                        if (!ItemCurrency.isEmpty(shippingcostsshippingoption.shippingServiceAdditionalCost))
                        {
                            flag = flag1;
                            if (item.quantity > 1)
                            {
                                flag = flag1;
                                if (!(new CurrencyAmount(shippingcostsshippingoption.shippingServiceAdditionalCost)).isZero())
                                {
                                    spannablestringbuilder.append('\n');
                                    spannablestringbuilder.append(Util.RenderString(ebaycontext.getString(0x7f070aee), i)).append(" ");
                                    obj = displayShippingCostSane(item, ebaycontext, i, shippingcostsshippingoption.shippingServiceAdditionalCost, true, false, item.isDisplayPriceCurrencyCode);
                                    flag = flag1;
                                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                                    {
                                        spannablestringbuilder.append(((CharSequence) (obj)));
                                        flag = flag1;
                                    }
                                }
                            }
                        }
                    }
                    break;

                case 3: // '\003'
                    if (!TextUtils.isEmpty(item.location))
                    {
                        spannablestringbuilder.append(getLocationAsFrom(context, item, ((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj)).colorId));
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                    break;

                case 4: // '\004'
                    String s = getPrettyShippingServiceName(item.site, shippingcostsshippingoption.shippingServiceName);
                    if (!TextUtils.isEmpty(s))
                    {
                        spannablestringbuilder.append(Util.RenderString(s, ((com.ebay.mobile.ItemViewShipping.ShippingDisplayOrder) (obj)).colorId, 0));
                        flag = flag1;
                    } else
                    {
                        flag = false;
                    }
                    break;
                }
            } while (true);
        }
        return spannablestringbuilder;
    }

    public static String getHACKPrettyShippingServiceName(String s, String s1)
    {
        String s2 = "";
        if ("eBayMotors".equals(s))
        {
            s = "0";
        } else
        {
            EbaySite ebaysite = EbaySite.getInstanceFromId(s);
            s = s2;
            if (ebaysite != null)
            {
                s = ebaysite.id;
            }
        }
        s = (String)ItemViewShipping.shippingNameMap.get((new StringBuilder()).append(s).append("_").append(s1).toString());
        if (s == null)
        {
            return s1;
        } else
        {
            return s;
        }
    }

    public static String getHandlingTime(Resources resources, Item item)
    {
        if (item.isHandlingTimeSameDayAvailable)
        {
            return resources.getString(0x7f07093e);
        }
        if (item.handlingTime != null)
        {
            if (item.handlingTime.value == 0L)
            {
                return resources.getString(0x7f070096);
            } else
            {
                return resources.getString(0x7f0704c1, new Object[] {
                    item.handlingTime.toString(resources)
                });
            }
        } else
        {
            return resources.getString(0x7f070b07);
        }
    }

    public static String getLocalizedListOfLocations(Resources resources, List list)
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        while (i < list.size()) 
        {
            if (i > 0)
            {
                stringbuilder.append(", ");
            }
            String s2 = (String)list.get(i);
            String s1 = EbayCountryManager.getShippingRegionsMapping(resources, s2);
            String s = s1;
            if (s1 == null)
            {
                if (EbayCountry.isValidCountryCode(s2))
                {
                    s = EbayCountryManager.getCountryWithLanguageName(resources, EbayCountry.getInstance(s2));
                } else
                {
                    s = s1;
                    if ("PO Box".equals(s2))
                    {
                        String s3 = resources.getString(0x7f0704d8);
                        s = s1;
                        if (!TextUtils.isEmpty(s3))
                        {
                            s = s3;
                        }
                    }
                }
            }
            s1 = s;
            if (s == null)
            {
                s1 = s2;
            }
            stringbuilder.append(s1);
            i++;
        }
        return stringbuilder.toString();
    }

    public static CharSequence getLocationAsFrom(Context context, Item item, int i)
    {
        context = new SpannableStringBuilder(String.format(context.getString(0x7f070bab), new Object[] {
            item.location
        }));
        context.setSpan(new ForegroundColorSpan(i), 0, context.length(), 33);
        return context;
    }

    public static Pair getLogisticsPlanTypeAndEstimatedDeliveryDate(Item item, ShippingCostsShippingOption shippingcostsshippingoption)
    {
        com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type type;
        Date date;
        type = null;
        date = null;
        if (!item.isBopisable) goto _L2; else goto _L1
_L1:
        type = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.ISPU;
_L4:
        return new Pair(type, date);
_L2:
        if (item.isPudoable)
        {
            type = com.ebay.common.model.cart.LogisticsPlans.LogisticsPlan.Type.PUDO;
            date = shippingcostsshippingoption.estimatedDeliveryMaxTime;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static String getPrettyShippingServiceName(String s, String s1)
    {
        String s2 = s1;
        Object obj = s2;
        if (s1 != null)
        {
            Map map = (Map)ItemViewShipping.siteSpecificShippingNamesMap.get(s);
            obj = s2;
            if (map != null)
            {
                obj = (com.ebay.common.model.EbayDetail.ShippingServiceDetail)map.get(s1);
                String s3;
                if (obj != null)
                {
                    s3 = ((com.ebay.common.model.EbayDetail.ShippingServiceDetail) (obj)).description;
                } else
                {
                    s3 = null;
                }
                obj = s3;
                if (s3 == null)
                {
                    obj = getHACKPrettyShippingServiceName(s, s1);
                }
            }
        }
        return ((String) (obj));
    }

    public static CharSequence getPudoSynopsis(Context context, int i, int j, Date date)
    {
        EbayCountry ebaycountry = MyApp.getPrefs().getCurrentCountry();
        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
        spannablestringbuilder.append(Util.RenderString(context.getString(LocalUtil.getPudoResourceForCountry(ebaycountry)), i, 0));
        spannablestringbuilder.append('\n');
        spannablestringbuilder.append(Util.RenderString(context.getString(0x7f070421), i, 0));
        if (date != null)
        {
            spannablestringbuilder.append('\n');
            spannablestringbuilder.append(Util.RenderString(Util.getEstimatedPickupDateString(context, date, false), j, 0));
        }
        return spannablestringbuilder;
    }

    public static String getShipToLocationsAsLocalizedString(Resources resources, Item item)
    {
        if (item.shipToLocations.size() == 1 && "None".equals(item.shipToLocations.get(0)))
        {
            return resources.getString(0x7f07010f);
        } else
        {
            return getLocalizedListOfLocations(resources, item.shipToLocations);
        }
    }

    public static String getShippingError(Context context, Item item)
    {
        if (item.isSeller)
        {
            if (item.isFreight)
            {
                return context.getString(0x7f070427);
            } else
            {
                return context.getString(0x7f0701ca);
            }
        }
        if (item.buyerResponsibleForLogistics)
        {
            if (!TextUtils.isEmpty(item.displayBuyerResponsibleForLogistics))
            {
                return item.displayBuyerResponsibleForLogistics;
            } else
            {
                return context.getString(0x7f070c6e);
            }
        }
        PostalCodeSpecification postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
        boolean flag = item.isValidShippingCountry(item.buyerCountryCode);
        if (postalcodespecification == null || TextUtils.isEmpty(postalcodespecification.countryCode))
        {
            return context.getString(0x7f070501);
        }
        if (item.isFreight && flag)
        {
            return String.format(context.getString(0x7f070426), new Object[] {
                context.getString(0x7f070427), context.getString(0x7f070175)
            });
        }
        if (flag && (item.shippingInfo.orderedOptions == null || item.shippingInfo.orderedOptions.isEmpty()))
        {
            return context.getString(0x7f070175);
        }
        if (!ItemViewPayPalable.shipsToCountry(context.getResources(), item.buyerCountryCode, item))
        {
            return context.getString(0x7f07048f);
        } else
        {
            return context.getString(0x7f070175);
        }
    }

    public static String getShippingService(Resources resources, Item item)
    {
        String s;
        PostalCodeSpecification postalcodespecification;
        if (useTransactedShipping(item))
        {
            s = item.iTransaction.selectedShippingOption.shippingServiceName;
        } else
        if (item.isSeller && !item.sellerShippingOptions.isEmpty())
        {
            s = ((ShippingCostsShippingOption)item.sellerShippingOptions.get(0)).shippingServiceName;
        } else
        {
            s = item.shippingInfo.summaryShippingServiceName;
        }
        s = getPrettyShippingServiceName(item.site, s);
        postalcodespecification = MyApp.getPrefs().getShipToPostalCode();
        if (s != null && item.isGspItem && postalcodespecification != null)
        {
            return resources.getString(0x7f07008f, new Object[] {
                s, postalcodespecification.countryCode
            });
        } else
        {
            return s;
        }
    }

    public static String getShippingType(Item item)
    {
        if (useTransactedShipping(item))
        {
            return item.iTransaction.shippingType;
        }
        if (item.isIspuOnly)
        {
            return "NotSpecified";
        }
        if (!item.isLocalPickupOnly)
        {
            return item.shippingInfo.summaryShippingType;
        } else
        {
            return item.shippingType;
        }
    }

    public static CharSequence getUpToEnFormattedShippingOptions(EbayContext ebaycontext, Item item, int i, int j, List list)
    {
        Object obj1 = null;
        List list1 = getCarrierShippingOptions(item);
        Object obj = obj1;
        if (!list1.isEmpty())
        {
            int k = i;
            if (i < 0)
            {
                k = list1.size();
            }
            k = Math.min(k, list1.size());
            obj = obj1;
            if (k > 0)
            {
                SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
                i = 0;
                do
                {
                    obj = spannablestringbuilder;
                    if (i >= k)
                    {
                        break;
                    }
                    obj = getFormattedShippingNode(ebaycontext, item, (ShippingCostsShippingOption)list1.get(i), j, list);
                    if (!TextUtils.isEmpty(((CharSequence) (obj))))
                    {
                        if (!TextUtils.isEmpty(spannablestringbuilder))
                        {
                            spannablestringbuilder.append("\n\n");
                        }
                        spannablestringbuilder.append(((CharSequence) (obj)));
                    }
                    i++;
                } while (true);
            }
        }
        if (!TextUtils.isEmpty(((CharSequence) (obj))))
        {
            return ((CharSequence) (obj));
        } else
        {
            return null;
        }
    }

    private List mapPlans(Context context, com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlan logisticsplan, Item item)
    {
        Object obj2 = null;
        Object obj = null;
        Object obj1 = obj2;
        if (logisticsplan != null)
        {
            obj1 = obj2;
            if (logisticsplan.steps != null)
            {
                boolean flag1 = false;
                boolean flag4 = DeviceConfiguration.getAsync().get(com.ebay.mobile.dcs.Dcs.App.B.ebayPlus);
                Iterator iterator = logisticsplan.steps.iterator();
label0:
                do
                {
                    obj1 = obj;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    obj1 = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsStep)iterator.next();
                    if (obj1 == null)
                    {
                        continue;
                    }
                    if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsStep) (obj1)).stepExtension instanceof com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingStepExtension)
                    {
                        Iterator iterator1 = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingStepExtension)((com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsStep) (obj1)).stepExtension).shippingOption.iterator();
                        boolean flag = flag1;
                        obj1 = obj;
                        do
                        {
                            do
                            {
                                obj = obj1;
                                flag1 = flag;
                                if (!iterator1.hasNext())
                                {
                                    continue label0;
                                }
                                obj = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption)iterator1.next();
                            } while (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingMethod == null);
                            ShippingCostsShippingOption shippingcostsshippingoption1 = new ShippingCostsShippingOption();
                            shippingcostsshippingoption1.logisticsPlanType = logisticsplan.planType;
                            shippingcostsshippingoption1.shippingServiceNameValue = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingMethod.shippingMethodCode.value;
                            shippingcostsshippingoption1.shippingServiceName = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingMethod.shippingMethodCode.displayName.decode();
                            if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).deliveryEstimate != null)
                            {
                                if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).deliveryEstimate.timeEstimate != null)
                                {
                                    shippingcostsshippingoption1.estimatedDeliveryMinTime = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).deliveryEstimate.timeEstimate.minDate;
                                    shippingcostsshippingoption1.estimatedDeliveryMaxTime = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).deliveryEstimate.timeEstimate.maxDate;
                                    shippingcostsshippingoption1.shippingTimeMin = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).deliveryEstimate.timeEstimate.minDays;
                                    shippingcostsshippingoption1.shippingTimeMax = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).deliveryEstimate.timeEstimate.maxDays;
                                }
                                if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).deliveryEstimate.estimateTreatment != null && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).deliveryEstimate.estimateTreatment.size() > 0)
                                {
                                    Iterator iterator2 = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).deliveryEstimate.estimateTreatment.iterator();
                                    do
                                    {
                                        if (!iterator2.hasNext())
                                        {
                                            break;
                                        }
                                        com.ebay.nautilus.domain.net.api.viewlisting.Listing.DeliveryEstimateTreatmentEnum deliveryestimatetreatmentenum = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.DeliveryEstimateTreatmentEnum)iterator2.next();
                                        if (com.ebay.nautilus.domain.net.api.viewlisting.Listing.DeliveryEstimateTreatmentEnum.FAST_AND_FREE == deliveryestimatetreatmentenum)
                                        {
                                            shippingcostsshippingoption1.fastAndFree = true;
                                        }
                                    } while (true);
                                }
                            }
                            if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).totalCostToBuyer != null)
                            {
                                shippingcostsshippingoption1.shippingServiceCost = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).totalCostToBuyer.getAmount();
                            }
                            if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan != null)
                            {
                                if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.additionalUnitShippingCost != null)
                                {
                                    shippingcostsshippingoption1.shippingServiceAdditionalCost = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.additionalUnitShippingCost.getAmount();
                                }
                                if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.importCharges != null)
                                {
                                    shippingcostsshippingoption1.importCharge = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.importCharges.getAmount();
                                }
                                if (shippingcostsshippingoption1.importCharge != null && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.shippingCost != null)
                                {
                                    shippingcostsshippingoption1.shippingServiceCost = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.shippingCost.getAmount();
                                }
                            }
                            if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan != null && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.discount != null && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.discount.communicatedAsMessage != null)
                            {
                                if (TextUtils.isEmpty(item.promotionalShippingDiscountDesc) && TextUtils.isEmpty(item.shippingDiscountDesc) && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.discount.communicatedAsMessage.size() > 1)
                                {
                                    item.promotionalShippingDiscountDesc = ((com.ebay.nautilus.domain.data.BaseCommonType.Text)((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.discount.communicatedAsMessage.get(1)).decode();
                                }
                                if (TextUtils.isEmpty(item.shippingDiscountDesc) && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.discount.communicatedAsMessage.size() > 0)
                                {
                                    item.shippingDiscountDesc = ((com.ebay.nautilus.domain.data.BaseCommonType.Text)((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.discount.communicatedAsMessage.get(0)).decode();
                                }
                            }
                            if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).insurance != null && com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingInsuranceOptionEnum.REQUIRED.equals(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).insurance.insuranceOption) && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).insurance.insuranceCost != null)
                            {
                                shippingcostsshippingoption1.shippingInsuranceCost = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).insurance.insuranceCost.getAmount();
                            }
                            boolean flag2;
                            boolean flag3;
                            if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingMethod != null && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingMethod.domesticOrInternational.equals("INTERNATIONAL"))
                            {
                                flag1 = true;
                            } else
                            {
                                flag1 = false;
                            }
                            if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingMethod != null && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingMethod.domesticOrInternational.equals("DOMESTIC"))
                            {
                                flag2 = true;
                            } else
                            {
                                flag2 = false;
                            }
                            if (isInternationalShippingAvailable || flag1)
                            {
                                flag3 = true;
                            } else
                            {
                                flag3 = false;
                            }
                            isInternationalShippingAvailable = flag3;
                            if (isDomesticShippingAvailable || flag2)
                            {
                                flag3 = true;
                            } else
                            {
                                flag3 = false;
                            }
                            isDomesticShippingAvailable = flag3;
                            flag1 = flag;
                            if (!flag)
                            {
                                Iterator iterator3;
                                Object obj3;
                                if (!TextUtils.isEmpty(((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.costPlanType))
                                {
                                    summaryShippingType = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).shippingCostPlan.costPlanType;
                                } else
                                {
                                    summaryShippingType = "FLAT";
                                }
                                summaryShippingServiceName = shippingcostsshippingoption1.shippingServiceName;
                                flag1 = true;
                            }
                            if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).properties != null && flag4)
                            {
                                iterator3 = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).properties.iterator();
                                do
                                {
                                    if (!iterator3.hasNext())
                                    {
                                        break;
                                    }
                                    obj3 = (com.ebay.nautilus.domain.data.BaseCommonType.Property)iterator3.next();
                                    if ("eligibleForEbayPlusPromo".equals(((com.ebay.nautilus.domain.data.BaseCommonType.Property) (obj3)).propertyName))
                                    {
                                        obj3 = (com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue)((com.ebay.nautilus.domain.data.BaseCommonType.Property) (obj3)).propertyValues.get(0);
                                        if (((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj3)).booleanValue != null)
                                        {
                                            shippingcostsshippingoption1.isEligibleForEbayPlusPromo = ((com.ebay.nautilus.domain.data.BaseCommonType.PropertyValue) (obj3)).booleanValue.booleanValue();
                                        }
                                    }
                                } while (true);
                            }
                            if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).handlingPolicyOverride != null)
                            {
                                shippingcostsshippingoption1.isHandlingTimeSameDayAvailable = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).handlingPolicyOverride.sameDayHandling;
                                shippingcostsshippingoption1.sameDayCutOff = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.ShippingOption) (obj)).handlingPolicyOverride.sameDayCutOff;
                            }
                            obj = obj1;
                            if (obj1 == null)
                            {
                                obj = new ArrayList();
                            }
                            if (shippingcostsshippingoption1 != null && shippingcostsshippingoption1.shippingServiceNameValue != null && "eBayPlus".equals(shippingcostsshippingoption1.shippingServiceNameValue))
                            {
                                item.isEbayPlusEligible = flag4;
                                obj1 = obj;
                                flag = flag1;
                                if (!flag4)
                                {
                                    continue;
                                }
                            }
                            ((List) (obj)).add(shippingcostsshippingoption1);
                            obj1 = obj;
                            flag = flag1;
                        } while (true);
                    }
                    if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsStep) (obj1)).stepExtension instanceof com.ebay.nautilus.domain.net.api.viewlisting.Listing.FreightStepExtension)
                    {
                        item.isFreight = true;
                    } else
                    if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsStep) (obj1)).stepExtension instanceof com.ebay.nautilus.domain.net.api.viewlisting.Listing.PickupStepExtension)
                    {
                        obj1 = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.PickupStepExtension)((com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsStep) (obj1)).stepExtension;
                        ShippingCostsShippingOption shippingcostsshippingoption = new ShippingCostsShippingOption();
                        shippingcostsshippingoption.shippingServiceName = context.getString(0x7f0700b7);
                        shippingcostsshippingoption.logisticsPlanType = logisticsplan.planType;
                        if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.PickupStepExtension) (obj1)).pickupCost != null)
                        {
                            shippingcostsshippingoption.shippingServiceCost = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.PickupStepExtension) (obj1)).pickupCost.getAmount();
                        }
                        if (((com.ebay.nautilus.domain.net.api.viewlisting.Listing.PickupStepExtension) (obj1)).deliveryEstimate != null && ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.PickupStepExtension) (obj1)).deliveryEstimate.timeEstimate != null)
                        {
                            shippingcostsshippingoption.estimatedDeliveryMaxTime = ((com.ebay.nautilus.domain.net.api.viewlisting.Listing.PickupStepExtension) (obj1)).deliveryEstimate.timeEstimate.maxDate;
                        }
                        obj1 = obj;
                        if (obj == null)
                        {
                            obj1 = new ArrayList();
                        }
                        ((List) (obj1)).add(shippingcostsshippingoption);
                        obj = obj1;
                    }
                } while (true);
            }
        }
        return ((List) (obj1));
    }

    private void postProcessLocalPickupOnlyOptions(Context context, List list, Item item)
    {
        boolean flag2 = true;
        Object obj = null;
        com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlan logisticsplan = obj;
        if (list != null)
        {
            logisticsplan = obj;
            if (!list.isEmpty())
            {
                logisticsplan = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlan)list.get(0);
            }
        }
        if (orderedOptions != null && logisticsplan != null && list.size() == 1 && com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum.LOCAL_PICKUP.equals(logisticsplan.planType))
        {
            item.isLocalPickupOnly = true;
            boolean flag1 = true;
            Iterator iterator = orderedOptions.iterator();
            boolean flag;
            do
            {
                flag = flag1;
                if (!iterator.hasNext())
                {
                    break;
                }
                ShippingCostsShippingOption shippingcostsshippingoption = (ShippingCostsShippingOption)iterator.next();
                if (!context.getString(0x7f0700b7).equals(shippingcostsshippingoption.shippingServiceName) || shippingcostsshippingoption.shippingServiceCost == null || !(new CurrencyAmount(shippingcostsshippingoption.shippingServiceCost)).isGreaterThanZero())
                {
                    continue;
                }
                flag = false;
                break;
            } while (true);
            if (flag)
            {
                shipToHomeOptions = null;
            }
        }
        if (item != null)
        {
            if (item.isLocalPickupOnly)
            {
                summaryShippingServiceName = "Pickup";
                summaryShippingType = "Pickup";
            }
            if (list == null || list.size() != 1 || !item.isFreight)
            {
                flag2 = false;
            }
            item.isFreight = flag2;
            if (item.isFreight)
            {
                item.shippingType = "Freight";
            }
        }
    }

    public static boolean useTransactedShipping(Item item)
    {
        return item != null && item.iTransaction != null && !"NotSpecified".equals(item.iTransaction.shippingType) && item.iTransaction.selectedShippingOption != null;
    }

    public ShippingCostsShippingOption getEbayPlusOption()
    {
        Object obj = null;
        ShippingCostsShippingOption shippingcostsshippingoption = obj;
        if (shipToHomeOptions != null)
        {
            Iterator iterator = shipToHomeOptions.iterator();
            do
            {
                shippingcostsshippingoption = obj;
                if (!iterator.hasNext())
                {
                    break;
                }
                shippingcostsshippingoption = (ShippingCostsShippingOption)iterator.next();
            } while (!"eBayPlus".equalsIgnoreCase(shippingcostsshippingoption.shippingServiceNameValue));
        }
        return shippingcostsshippingoption;
    }

    public List getOrderedOptions()
    {
        return getOrderedOptions(3, true);
    }

    public List getOrderedOptions(int i, boolean flag)
    {
        if (orderedOptions == null || orderedOptions.size() == 0)
        {
            return null;
        }
        int j = Math.min(i, orderedOptions.size());
        i = j;
        if (isShipToHomeOnly)
        {
            i = j;
            if (orderedOptions.size() > 1)
            {
                i = 1;
            }
        }
        if (i <= 1 || !flag)
        {
            return Collections.unmodifiableList(orderedOptions.subList(0, i));
        }
        ArrayList arraylist = new ArrayList();
        HashMap hashmap = new HashMap();
        Iterator iterator = orderedOptions.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            ShippingCostsShippingOption shippingcostsshippingoption = (ShippingCostsShippingOption)iterator.next();
            if (arraylist.size() == 0 || !hashmap.containsKey(shippingcostsshippingoption.logisticsPlanType))
            {
                arraylist.add(shippingcostsshippingoption);
                hashmap.put(shippingcostsshippingoption.logisticsPlanType, Boolean.valueOf(true));
            }
        } while (arraylist.size() != i);
        return Collections.unmodifiableList(arraylist);
    }

    public void initialize(Context context, List list, Item item)
    {
        boolean flag2 = false;
        if (list == null) goto _L2; else goto _L1
_L1:
        Iterator iterator = list.iterator();
_L13:
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlan logisticsplan;
        List list1;
        logisticsplan = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlan)iterator.next();
        if (logisticsplan == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        list1 = mapPlans(context, logisticsplan, item);
        if (logisticsplan.planType == null) goto _L6; else goto _L5
_L5:
        _cls2..SwitchMap.com.ebay.nautilus.domain.net.api.viewlisting.Listing.LogisticsPlanTypeEnum[logisticsplan.planType.ordinal()];
        JVM INSTR tableswitch 1 5: default 108
    //                   1 146
    //                   2 151
    //                   3 263
    //                   4 306
    //                   5 349;
           goto _L6 _L7 _L8 _L9 _L10 _L11
_L6:
        if (list1 != null)
        {
            if (orderedOptions == null)
            {
                orderedOptions = new ArrayList();
            }
            orderedOptions.addAll(list1);
        }
        continue; /* Loop/switch isn't completed */
_L7:
        item.isGspItem = true;
_L8:
        if (logisticsplan.handlingPolicy != null)
        {
            if (logisticsplan.handlingPolicy.handlingTime != null)
            {
                item.handlingTime = logisticsplan.handlingPolicy.handlingTime;
            }
            if (logisticsplan.handlingPolicy.sameDayCutOffTime != null)
            {
                item.isHandlingTimeSameDayAvailable = true;
            }
        }
        boolean flag;
        if (isShipToHomeAvailable || list1 != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        isShipToHomeAvailable = flag;
        if (list1 != null)
        {
            if (shipToHomeOptions == null)
            {
                shipToHomeOptions = new ArrayList();
            }
            shipToHomeOptions.addAll(list1);
        }
        continue; /* Loop/switch isn't completed */
_L9:
        item.availableForPickupAndDropoff = true;
        if (list1 != null)
        {
            if (pudoOptions == null)
            {
                pudoOptions = new ArrayList();
            }
            pudoOptions.addAll(list1);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        item.availableForEbayNow = true;
        if (list1 != null)
        {
            if (ebnOptions == null)
            {
                ebnOptions = new ArrayList();
            }
            ebnOptions.addAll(list1);
        }
        continue; /* Loop/switch isn't completed */
_L11:
        item.availableForPickupInStore = true;
        isDomesticShippingAvailable = true;
        if (list1 != null)
        {
            if (ispuOptions == null)
            {
                ispuOptions = new ArrayList();
            }
            ispuOptions.addAll(list1);
        }
        if (true) goto _L6; else goto _L4
_L4:
        postProcessLocalPickupOnlyOptions(context, list, item);
_L2:
        boolean flag1 = flag2;
        if (shipToHomeOptions != null)
        {
            flag1 = flag2;
            if (shipToHomeOptions.size() > 0)
            {
                flag1 = true;
            }
        }
        isShipToHomeAvailable = flag1;
        if (isShipToHomeAvailable && !item.availableForEbayNow && !item.availableForPickupAndDropoff && !item.availableForPickupInStore && !item.isLocalPickup && !item.isLocalPickupOnly)
        {
            isShipToHomeOnly = true;
        }
        setShippingCost(item);
        return;
        if (true) goto _L13; else goto _L12
_L12:
    }

    public boolean isShippable(Resources resources, Item item)
    {
        return shippingServiceCost != null && !TextUtils.isEmpty(getShippingService(resources, item));
    }

    public void removeEbayPlusOption(List list)
    {
        if (list != null)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                ShippingCostsShippingOption shippingcostsshippingoption = (ShippingCostsShippingOption)list.next();
                if (shippingcostsshippingoption != null && "eBayPlus".equalsIgnoreCase(shippingcostsshippingoption.shippingServiceNameValue))
                {
                    list.remove();
                }
            } while (true);
        }
    }

    public void removeEbayPlusOptions()
    {
        removeEbayPlusOption(shipToHomeOptions);
        removeEbayPlusOption(orderedOptions);
    }

    public void setShippingCost(Item item)
    {
        List list = getCarrierShippingOptions(item);
        if (!list.isEmpty())
        {
            item = (ShippingCostsShippingOption)list.get(0);
            shippingServiceCost = ((ShippingCostsShippingOption) (item)).shippingServiceCost;
            shippingServiceAdditionalCost = ((ShippingCostsShippingOption) (item)).shippingServiceAdditionalCost;
            importCharge = ((ShippingCostsShippingOption) (item)).importCharge;
        } else
        if (item != null)
        {
            shippingServiceCost = item.shippingCost;
            return;
        }
    }

    public void setupShipping(Activity activity, Item item, ViewGroup viewgroup, int i, boolean flag, boolean flag1)
    {
        TextView textview2 = (TextView)viewgroup.findViewById(0x7f10031a);
        Object obj = viewgroup.findViewById(0x7f10031b);
        TextView textview4 = (TextView)viewgroup.findViewById(0x7f10031c);
        TextView textview3 = (TextView)viewgroup.findViewById(0x7f10031f);
        View view1 = viewgroup.findViewById(0x7f100320);
        TextView textview = (TextView)viewgroup.findViewById(0x7f100321);
        View view2 = viewgroup.findViewById(0x7f100322);
        TextView textview1 = (TextView)viewgroup.findViewById(0x7f100323);
        View view = viewgroup.findViewById(0x7f100324);
        viewgroup = viewgroup.findViewById(0x7f10031d);
        ((View) (obj)).setVisibility(8);
        viewgroup.setVisibility(8);
        view.setVisibility(8);
        view1.setVisibility(8);
        view2.setVisibility(8);
        if (IsLocalPickupOnly(item))
        {
            textview2.setText(activity.getString(0x7f0700b7));
        } else
        {
            if (item.shippingInfo.orderedOptions == null || item.shippingInfo.orderedOptions.isEmpty())
            {
                textview2.setText(getShippingError(activity, item));
            } else
            {
                SpannableStringBuilder spannablestringbuilder1 = new SpannableStringBuilder();
                String s = getShippingService(activity.getResources(), item);
                if (shippingServiceCost != null && !TextUtils.isEmpty(s))
                {
                    displayShippingCost(item, ((FwContext)activity).getEbayContext(), i, spannablestringbuilder1, shippingServiceCost, true, flag, true);
                    if (!item.isTransacted && shippingServiceAdditionalCost != null && item.quantity > 1 && !(new CurrencyAmount(shippingServiceAdditionalCost)).isZero())
                    {
                        ((View) (obj)).setVisibility(0);
                        obj = new SpannableStringBuilder();
                        displayShippingCost(item, ((FwContext)activity).getEbayContext(), i, ((SpannableStringBuilder) (obj)), shippingServiceAdditionalCost, true, false, true);
                        ((SpannableStringBuilder) (obj)).append('\n').append(s);
                        textview4.setText(((CharSequence) (obj)), android.widget.TextView.BufferType.SPANNABLE);
                    } else
                    {
                        if (spannablestringbuilder1.length() > 0)
                        {
                            spannablestringbuilder1.append('\n');
                        }
                        spannablestringbuilder1.append(s);
                    }
                    if (importCharge != null && item.isGspItem)
                    {
                        SpannableStringBuilder spannablestringbuilder = new SpannableStringBuilder();
                        displayShippingCost(item, ((FwContext)activity).getEbayContext(), i, spannablestringbuilder, importCharge, true, false, flag1);
                        textview3.setText(spannablestringbuilder, android.widget.TextView.BufferType.SPANNABLE);
                        viewgroup.setVisibility(0);
                    }
                } else
                {
                    spannablestringbuilder1.append(getShippingError(activity, item));
                }
                textview2.setText(spannablestringbuilder1, android.widget.TextView.BufferType.SPANNABLE);
            }
            activity = getEstimatedDeliveryDates(activity, item);
            if (activity[0] != null)
            {
                view1.setVisibility(0);
                textview.setText(activity[0]);
                view2.setVisibility(0);
                textview1.setText(activity[1]);
            }
            if (activity[1] != null)
            {
                view2.setVisibility(0);
                textview1.setText(activity[1]);
            }
            if (item.isShowFastAndFree && activity[2] != null)
            {
                activity = Util.getFastAndFreeText();
                if (activity != null)
                {
                    ((TextView)view.findViewById(0x7f100325)).setText(activity);
                    view.setVisibility(0);
                    return;
                }
            }
        }
    }

    public void setupTaxTable(List list)
    {
        taxTable.clear();
        if (list != null && list.size() > 0)
        {
            list = list.iterator();
            do
            {
                if (!list.hasNext())
                {
                    break;
                }
                com.ebay.nautilus.domain.net.api.viewlisting.Listing.ApplicableTax applicabletax = (com.ebay.nautilus.domain.net.api.viewlisting.Listing.ApplicableTax)list.next();
                if (applicabletax.jurisdiction != null)
                {
                    ShippingCostsTaxJurisdiction shippingcoststaxjurisdiction = new ShippingCostsTaxJurisdiction();
                    shippingcoststaxjurisdiction.salesTaxPercent = (float)applicabletax.taxRate;
                    shippingcoststaxjurisdiction.jurisdictionId = applicabletax.jurisdiction.regionName;
                    if (applicabletax.salesTaxAppliedToShipping != null)
                    {
                        shippingcoststaxjurisdiction.shippingIncludedInTax = applicabletax.salesTaxAppliedToShipping.booleanValue();
                    }
                    taxTable.add(shippingcoststaxjurisdiction);
                }
            } while (true);
        }
    }

}
