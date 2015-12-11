// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.dcs.DcsPropBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationPreferenceManager

public static final class <init> extends Enum
{

    private static final SELLING_ORDER_UPDATES $VALUES[];
    public static final SELLING_ORDER_UPDATES BUYING_AUCTION_UPDATES;
    public static final SELLING_ORDER_UPDATES BUYING_ITEM_DISCOUNTS;
    public static final SELLING_ORDER_UPDATES BUYING_ITEM_ENDING;
    public static final SELLING_ORDER_UPDATES BUYING_OFFER_UPDATES;
    public static final SELLING_ORDER_UPDATES BUYING_ORDER_UPDATES;
    public static final SELLING_ORDER_UPDATES GENERAL_DEALS;
    public static final SELLING_ORDER_UPDATES SELLING_ORDER_UPDATES;
    public static final SELLING_ORDER_UPDATES UNDEFINED;
    protected final String eventTypeNames[];
    private final DcsPropBoolean isSupportedProperty;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/ebay/mobile/notifications/NotificationPreferenceManager$CombinedEvent, s);
    }

    public static <init>[] values()
    {
        return (<init>[])$VALUES.clone();
    }

    public boolean isSupported()
    {
        if (isSupportedProperty != null)
        {
            return DeviceConfiguration.getAsync().get(isSupportedProperty);
        } else
        {
            return true;
        }
    }

    static 
    {
        UNDEFINED = new <init>("UNDEFINED", 0, new String[0]);
        BUYING_ITEM_DISCOUNTS = new <init>("BUYING_ITEM_DISCOUNTS", 1, com.ebay.mobile.dcs.inedEvent, new String[] {
            com.ebay.common.model.mdns..(), com.ebay.common.model.mdns..()
        });
        GENERAL_DEALS = new <init>("GENERAL_DEALS", 2, DcsBoolean.Verticals_dealsNotifications, new String[] {
            com.ebay.common.model.mdns.nt.nt(), com.ebay.common.model.mdns..()
        });
        BUYING_ITEM_ENDING = new <init>("BUYING_ITEM_ENDING", 3, new String[] {
            "WATCHITM", "BIDITEM"
        });
        BUYING_AUCTION_UPDATES = new <init>("BUYING_AUCTION_UPDATES", 4, new String[] {
            "OUTBID", "ITMWON"
        });
        BUYING_OFFER_UPDATES = new <init>("BUYING_OFFER_UPDATES", 5, new String[] {
            "BODECLND", "CNTROFFR"
        });
        BUYING_ORDER_UPDATES = new <init>("BUYING_ORDER_UPDATES", 6, new String[] {
            "ITMPAID", "ITMSHPD"
        });
        SELLING_ORDER_UPDATES = new <init>("SELLING_ORDER_UPDATES", 7, new String[] {
            "ITMSOLD", "COCMPLT"
        });
        $VALUES = (new .VALUES[] {
            UNDEFINED, BUYING_ITEM_DISCOUNTS, GENERAL_DEALS, BUYING_ITEM_ENDING, BUYING_AUCTION_UPDATES, BUYING_OFFER_UPDATES, BUYING_ORDER_UPDATES, SELLING_ORDER_UPDATES
        });
    }

    private transient (String s, int i, DcsPropBoolean dcspropboolean, String as[])
    {
        super(s, i);
        eventTypeNames = as;
        isSupportedProperty = dcspropboolean;
    }

    private transient isSupportedProperty(String s, int i, String as[])
    {
        this(s, i, null, as);
    }
}
