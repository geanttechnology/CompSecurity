// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.sell;

import android.app.Activity;
import com.ebay.nautilus.domain.EbaySite;

// Referenced classes of package com.ebay.mobile.sell:
//            EditShippingServiceDialogFragment

static final class categoryIdentifier extends Enum
{

    private static final NONE $VALUES[];
    public static final NONE EBAY_SHIPPING;
    public static final NONE ECONOMY;
    public static final NONE EXPEDITED;
    public static final NONE NONE;
    public static final NONE ONE_DAY;
    public static final NONE OTHER;
    public static final NONE PICKUP;
    public static final NONE STANDARD;
    final String categoryIdentifier;

    public static String getCategoryCaption(categoryIdentifier categoryidentifier, Activity activity, int i)
    {
        String s = activity.getString(0x7f0709e8);
        switch (.sell.EditShippingServiceDialogFragment.ShippingServiceCategoryType[categoryidentifier.ordinal()])
        {
        default:
            return s;

        case 1: // '\001'
            return activity.getString(0x7f0709e0);

        case 2: // '\002'
            return activity.getString(0x7f0709e1);

        case 3: // '\003'
            return activity.getString(0x7f0709e7);

        case 4: // '\004'
            return activity.getString(0x7f0709e2);

        case 5: // '\005'
            return activity.getString(0x7f0709e3);

        case 6: // '\006'
            return activity.getString(0x7f0709e6);

        case 7: // '\007'
            return getSiteBasedOthersCaptionString(i, activity);
        }
    }

    private static String getSiteBasedOthersCaptionString(int i, Activity activity)
    {
        switch (i)
        {
        default:
            return String.format(activity.getString(0x7f0709e5), new Object[] {
                EbaySite.getInstanceFromId(i).localeCountry
            });

        case 77: // 'M'
            return activity.getString(0x7f0709e4);
        }
    }

    public static getSiteBasedOthersCaptionString parseString(String s)
    {
        if (EBAY_SHIPPING.getCategoryIdentifier().equals(s))
        {
            return EBAY_SHIPPING;
        }
        if (ECONOMY.getCategoryIdentifier().equals(s))
        {
            return ECONOMY;
        }
        if (STANDARD.getCategoryIdentifier().equals(s))
        {
            return STANDARD;
        }
        if (EXPEDITED.getCategoryIdentifier().equals(s))
        {
            return EXPEDITED;
        }
        if (ONE_DAY.getCategoryIdentifier().equals(s))
        {
            return ONE_DAY;
        }
        if (PICKUP.getCategoryIdentifier().equals(s))
        {
            return PICKUP;
        }
        if (OTHER.getCategoryIdentifier().equals(s))
        {
            return OTHER;
        } else
        {
            return NONE;
        }
    }

    public static NONE valueOf(String s)
    {
        return (NONE)Enum.valueOf(com/ebay/mobile/sell/EditShippingServiceDialogFragment$ShippingServiceCategoryType, s);
    }

    public static NONE[] values()
    {
        return (NONE[])$VALUES.clone();
    }

    public String getCategoryIdentifier()
    {
        return categoryIdentifier;
    }

    static 
    {
        EBAY_SHIPPING = new <init>("EBAY_SHIPPING", 0, "EBAY_SHIPPING");
        ECONOMY = new <init>("ECONOMY", 1, "ECONOMY");
        STANDARD = new <init>("STANDARD", 2, "STANDARD");
        EXPEDITED = new <init>("EXPEDITED", 3, "EXPEDITED");
        ONE_DAY = new <init>("ONE_DAY", 4, "ONE_DAY");
        PICKUP = new <init>("PICKUP", 5, "Pickup");
        OTHER = new <init>("OTHER", 6, "OTHER");
        NONE = new <init>("NONE", 7, "NONE");
        $VALUES = (new .VALUES[] {
            EBAY_SHIPPING, ECONOMY, STANDARD, EXPEDITED, ONE_DAY, PICKUP, OTHER, NONE
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        categoryIdentifier = s1;
    }
}
