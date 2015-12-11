// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.dcs;

import com.ebay.nautilus.domain.dcs.DcsPropInteger;
import com.ebay.nautilus.domain.dcs.DcsState;

public final class DcsInteger extends Enum
    implements DcsPropInteger
{

    private static final DcsInteger $VALUES[];
    public static final DcsInteger BopisGeocoderBiasBoxSize;
    public static final DcsInteger MepQualificationPeriodSeconds;
    public static final DcsInteger PhotoGalleryLruCacheSize;
    public static final DcsInteger SearchPhonePageSize;
    public static final DcsInteger SearchTabletPageSize;
    public static final DcsInteger StorePickerAutocompleteDelayMs;
    public static final DcsInteger StorePickerAutocompleteMinChars;
    public static final DcsInteger StorePickerSearchRadius;
    public static final DcsInteger StorePickerSearchRadiusPudo;
    public static final DcsInteger StorePickerStoresToDisplay;
    public static final DcsInteger checkoutMerchandiseItemsItemsShown;
    public static final DcsInteger viewItemUseMerchV2ItemsShown;
    private final Object defaultValue;

    private DcsInteger(String s, int i)
    {
        super(s, i);
        defaultValue = Integer.valueOf(0);
    }

    private DcsInteger(String s, int i, int j)
    {
        super(s, i);
        defaultValue = Integer.valueOf(j);
    }

    private DcsInteger(String s, int i, String s1)
    {
        super(s, i);
        defaultValue = s1;
    }

    public static DcsInteger valueOf(String s)
    {
        return (DcsInteger)Enum.valueOf(com/ebay/mobile/dcs/DcsInteger, s);
    }

    public static DcsInteger[] values()
    {
        return (DcsInteger[])$VALUES.clone();
    }

    public Object defaultValue(DcsState dcsstate)
    {
        return defaultValue;
    }

    public String key()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$dcs$DcsInteger[];

            static 
            {
                $SwitchMap$com$ebay$mobile$dcs$DcsInteger = new int[DcsInteger.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsInteger[DcsInteger.SearchTabletPageSize.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsInteger[DcsInteger.SearchPhonePageSize.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsInteger[DcsInteger.MepQualificationPeriodSeconds.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsInteger[DcsInteger.viewItemUseMerchV2ItemsShown.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$dcs$DcsInteger[DcsInteger.checkoutMerchandiseItemsItemsShown.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.dcs.DcsInteger[ordinal()])
        {
        default:
            return name();

        case 1: // '\001'
            return "Search.Tablet.Page.Size";

        case 2: // '\002'
            return "Search.Phone.Page.Size";

        case 3: // '\003'
            return "mep.qualification.period.seconds";

        case 4: // '\004'
            return "viewItemUseMerchV2.itemsShown";

        case 5: // '\005'
            return "checkoutMerchandiseItems.itemsShown";
        }
    }

    static 
    {
        SearchTabletPageSize = new DcsInteger("SearchTabletPageSize", 0, 72);
        SearchPhonePageSize = new DcsInteger("SearchPhonePageSize", 1, 50);
        BopisGeocoderBiasBoxSize = new DcsInteger("BopisGeocoderBiasBoxSize", 2, 1000);
        PhotoGalleryLruCacheSize = new DcsInteger("PhotoGalleryLruCacheSize", 3, 50);
        MepQualificationPeriodSeconds = new DcsInteger("MepQualificationPeriodSeconds", 4, 0x14370);
        StorePickerAutocompleteDelayMs = new DcsInteger("StorePickerAutocompleteDelayMs", 5, 500);
        StorePickerSearchRadius = new DcsInteger("StorePickerSearchRadius", 6, 100);
        StorePickerSearchRadiusPudo = new DcsInteger("StorePickerSearchRadiusPudo", 7, 30);
        StorePickerStoresToDisplay = new DcsInteger("StorePickerStoresToDisplay", 8, 5);
        StorePickerAutocompleteMinChars = new DcsInteger("StorePickerAutocompleteMinChars", 9, 3);
        viewItemUseMerchV2ItemsShown = new DcsInteger("viewItemUseMerchV2ItemsShown", 10, 6);
        checkoutMerchandiseItemsItemsShown = new DcsInteger("checkoutMerchandiseItemsItemsShown", 11, 6);
        $VALUES = (new DcsInteger[] {
            SearchTabletPageSize, SearchPhonePageSize, BopisGeocoderBiasBoxSize, PhotoGalleryLruCacheSize, MepQualificationPeriodSeconds, StorePickerAutocompleteDelayMs, StorePickerSearchRadius, StorePickerSearchRadiusPudo, StorePickerStoresToDisplay, StorePickerAutocompleteMinChars, 
            viewItemUseMerchV2ItemsShown, checkoutMerchandiseItemsItemsShown
        });
    }
}
