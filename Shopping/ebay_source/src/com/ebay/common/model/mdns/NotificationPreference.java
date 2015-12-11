// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;

import com.ebay.nautilus.domain.data.NameValue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class NotificationPreference
{
    public static final class AlertType extends Enum
    {

        private static final AlertType $VALUES[];
        public static final AlertType AskSellerQuestion;
        public static final AlertType AuctionCheckoutComplete;
        public static final AlertType BestOffer;
        public static final AlertType BestOfferDeclined;
        public static final AlertType BidItemEndingSoon;
        public static final AlertType BidReceived;
        public static final AlertType BucksExpiringSoon;
        public static final AlertType CounterOfferReceived;
        public static final AlertType CouponAvailable;
        public static final AlertType ItemMarkedPaid;
        public static final AlertType ItemMarkedShipped;
        public static final AlertType ItemSold;
        public static final AlertType ItemWon;
        public static final AlertType OutBid;
        public static final AlertType WatchedItemEndingSoon;
        public static final AlertType WebnextMobilePhotoSync;
        public final boolean defaultValue;
        public final int id;
        public final boolean supported;

        public static AlertType valueOf(String s)
        {
            return (AlertType)Enum.valueOf(com/ebay/common/model/mdns/NotificationPreference$AlertType, s);
        }

        public static AlertType[] values()
        {
            return (AlertType[])$VALUES.clone();
        }

        static 
        {
            OutBid = new AlertType("OutBid", 0, 0, true, true);
            WatchedItemEndingSoon = new AlertType("WatchedItemEndingSoon", 1, 1, true, true);
            BestOffer = new AlertType("BestOffer", 2, 3, true, true);
            BestOfferDeclined = new AlertType("BestOfferDeclined", 3, 4, true, true);
            CounterOfferReceived = new AlertType("CounterOfferReceived", 4, 5, true, true);
            ItemWon = new AlertType("ItemWon", 5, 6, true, true);
            ItemSold = new AlertType("ItemSold", 6, 7, true, true);
            ItemMarkedPaid = new AlertType("ItemMarkedPaid", 7, 8, true, false);
            ItemMarkedShipped = new AlertType("ItemMarkedShipped", 8, 9, true, true);
            BidReceived = new AlertType("BidReceived", 9, 10, true, false);
            AskSellerQuestion = new AlertType("AskSellerQuestion", 10, 12, false, true);
            AuctionCheckoutComplete = new AlertType("AuctionCheckoutComplete", 11, 13, false, false);
            BidItemEndingSoon = new AlertType("BidItemEndingSoon", 12, 17, false, false);
            CouponAvailable = new AlertType("CouponAvailable", 13, 18, false, false);
            WebnextMobilePhotoSync = new AlertType("WebnextMobilePhotoSync", 14, 19, false, false);
            BucksExpiringSoon = new AlertType("BucksExpiringSoon", 15, 20, false, false);
            $VALUES = (new AlertType[] {
                OutBid, WatchedItemEndingSoon, BestOffer, BestOfferDeclined, CounterOfferReceived, ItemWon, ItemSold, ItemMarkedPaid, ItemMarkedShipped, BidReceived, 
                AskSellerQuestion, AuctionCheckoutComplete, BidItemEndingSoon, CouponAvailable, WebnextMobilePhotoSync, BucksExpiringSoon
            });
        }

        private AlertType(String s, int i, int j, boolean flag, boolean flag1)
        {
            super(s, i);
            id = j;
            supported = flag;
            defaultValue = flag1;
            if (flag)
            {
                NotificationPreference.supportedPollEventNames.add(name());
            }
        }
    }

    public static final class DeliveryPolicyType extends Enum
    {

        private static final DeliveryPolicyType $VALUES[];
        public static final DeliveryPolicyType DEFERRED;
        public static final DeliveryPolicyType QUIET_PERIOD;
        public static final DeliveryPolicyType REAL_TIME;
        public String apiValue;

        public static DeliveryPolicyType valueOf(String s)
        {
            return (DeliveryPolicyType)Enum.valueOf(com/ebay/common/model/mdns/NotificationPreference$DeliveryPolicyType, s);
        }

        public static DeliveryPolicyType[] values()
        {
            return (DeliveryPolicyType[])$VALUES.clone();
        }

        static 
        {
            REAL_TIME = new DeliveryPolicyType("REAL_TIME", 0, "RealTime");
            QUIET_PERIOD = new DeliveryPolicyType("QUIET_PERIOD", 1, "QuietPeriod");
            DEFERRED = new DeliveryPolicyType("DEFERRED", 2, "Deferred");
            $VALUES = (new DeliveryPolicyType[] {
                REAL_TIME, QUIET_PERIOD, DEFERRED
            });
        }

        private DeliveryPolicyType(String s, int i, String s1)
        {
            super(s, i);
            apiValue = s1;
        }
    }

    public static final class EventType extends Enum
    {

        private static final EventType $VALUES[];
        public static final EventType ADDPHOTO;
        public static final EventType BESTOFR;
        public static final EventType BIDITEM;
        public static final EventType BIDRCVD;
        public static final EventType BOACCPTD;
        public static final EventType BODECLND;
        public static final EventType BUCKSEXP;
        public static final EventType BYRNOSHW;
        public static final EventType CARTONSALE;
        public static final EventType CNTROFFR;
        public static final EventType COACCPTED;
        public static final EventType COCMPLT;
        public static final EventType CODECLND;
        public static final EventType COUPONAVLBL;
        public static final EventType DailyDeals;
        public static final EventType DealsFrenzy;
        public static final EventType EBNORDCNCL;
        public static final EventType EBNORDPICKED;
        public static final EventType INTERNAL_BADGE;
        public static final EventType ITMOUTSTK;
        public static final EventType ITMPAID;
        public static final EventType ITMPICKUP;
        public static final EventType ITMSHPD;
        public static final EventType ITMSOLD;
        public static final EventType ITMWON;
        public static final EventType MSGEBAYMSGHDR;
        public static final EventType MSGM2MMSGHDR;
        public static final EventType OFRDCLNDACPT;
        public static final EventType OFREXPIRED;
        public static final EventType OFRRETRACTED;
        public static final EventType OUTBID;
        public static final EventType PAYREM;
        public static final EventType PING;
        public static final EventType SHOPCARTITM;
        public static final EventType SVDSRCH;
        public static final EventType WATCHITM;
        public static final EventType WATCHONSALE;
        public final boolean defaultValue;
        public final DeliveryPolicyType deliveryPolicyType;
        public final int id;
        public final boolean supported;
        public final boolean uiVisible;

        public static EventType valueOf(String s)
        {
            return (EventType)Enum.valueOf(com/ebay/common/model/mdns/NotificationPreference$EventType, s);
        }

        public static EventType[] values()
        {
            return (EventType[])$VALUES.clone();
        }

        public boolean isUiVisible()
        {
            return uiVisible;
        }

        static 
        {
            OUTBID = new EventType("OUTBID", 0, 0, true, true);
            WATCHITM = new EventType("WATCHITM", 1, 1, true, true);
            SVDSRCH = new EventType("SVDSRCH", 2, 2, true, true, false);
            BESTOFR = new EventType("BESTOFR", 3, 3, true, true);
            BODECLND = new EventType("BODECLND", 4, 4, true, true);
            CNTROFFR = new EventType("CNTROFFR", 5, 5, true, true);
            ITMWON = new EventType("ITMWON", 6, 6, true, true);
            ITMSOLD = new EventType("ITMSOLD", 7, 7, true, true);
            ITMPAID = new EventType("ITMPAID", 8, 8, true, true);
            ITMSHPD = new EventType("ITMSHPD", 9, 9, true, true);
            BIDRCVD = new EventType("BIDRCVD", 10, 10, true, true);
            MSGEBAYMSGHDR = new EventType("MSGEBAYMSGHDR", 11, 11, false, false);
            MSGM2MMSGHDR = new EventType("MSGM2MMSGHDR", 12, 12, true, true);
            COCMPLT = new EventType("COCMPLT", 13, 13, true, true);
            BIDITEM = new EventType("BIDITEM", 14, 17, true, true);
            COUPONAVLBL = new EventType("COUPONAVLBL", 15, 18, true, true);
            ADDPHOTO = new EventType("ADDPHOTO", 16, 19, true, true, false);
            BUCKSEXP = new EventType("BUCKSEXP", 17, 20, true, true);
            SHOPCARTITM = new EventType("SHOPCARTITM", 18, 35, true, true, false);
            DailyDeals = new EventType("DailyDeals", 19, 36, true, false, true);
            DealsFrenzy = new EventType("DealsFrenzy", 20, 37, true, false, true);
            ITMPICKUP = new EventType("ITMPICKUP", 21, 21, true, true, false);
            ITMOUTSTK = new EventType("ITMOUTSTK", 22, 22, true, true, false);
            BYRNOSHW = new EventType("BYRNOSHW", 23, 23, true, true, false);
            PAYREM = new EventType("PAYREM", 24, 24, true, true, false);
            EBNORDPICKED = new EventType("EBNORDPICKED", 25, 25, true, true, false);
            EBNORDCNCL = new EventType("EBNORDCNCL", 26, 26, true, true, false);
            PING = new EventType("PING", 27, 27, false, true, false);
            INTERNAL_BADGE = new EventType("INTERNAL_BADGE", 28, 28, true, true, false, DeliveryPolicyType.REAL_TIME);
            BOACCPTD = new EventType("BOACCPTD", 29, 29, false, false, false);
            COACCPTED = new EventType("COACCPTED", 30, 30, false, false, false);
            CODECLND = new EventType("CODECLND", 31, 31, false, false, false);
            OFRDCLNDACPT = new EventType("OFRDCLNDACPT", 32, 32, false, false, false);
            OFREXPIRED = new EventType("OFREXPIRED", 33, 33, false, false, false);
            OFRRETRACTED = new EventType("OFRRETRACTED", 34, 34, false, false, false);
            WATCHONSALE = new EventType("WATCHONSALE", 35, 38, true, true, true);
            CARTONSALE = new EventType("CARTONSALE", 36, 39, true, true, true);
            $VALUES = (new EventType[] {
                OUTBID, WATCHITM, SVDSRCH, BESTOFR, BODECLND, CNTROFFR, ITMWON, ITMSOLD, ITMPAID, ITMSHPD, 
                BIDRCVD, MSGEBAYMSGHDR, MSGM2MMSGHDR, COCMPLT, BIDITEM, COUPONAVLBL, ADDPHOTO, BUCKSEXP, SHOPCARTITM, DailyDeals, 
                DealsFrenzy, ITMPICKUP, ITMOUTSTK, BYRNOSHW, PAYREM, EBNORDPICKED, EBNORDCNCL, PING, INTERNAL_BADGE, BOACCPTD, 
                COACCPTED, CODECLND, OFRDCLNDACPT, OFREXPIRED, OFRRETRACTED, WATCHONSALE, CARTONSALE
            });
        }

        private EventType(String s, int i, int j, boolean flag, boolean flag1)
        {
            this(s, i, j, flag, flag1, true, null);
        }

        private EventType(String s, int i, int j, boolean flag, boolean flag1, boolean flag2)
        {
            this(s, i, j, flag, flag1, flag2, null);
        }

        private EventType(String s, int i, int j, boolean flag, boolean flag1, boolean flag2, DeliveryPolicyType deliverypolicytype)
        {
            super(s, i);
            id = j;
            supported = flag;
            defaultValue = flag1;
            if (flag)
            {
                NotificationPreference.supportedPushEventNames.add(name());
            }
            uiVisible = flag2;
            deliveryPolicyType = deliverypolicytype;
        }
    }

    public static final class PropertyType extends Enum
    {

        private static final PropertyType $VALUES[];
        public static final PropertyType DisabledSavedSearchIds;
        public static final PropertyType EnableSavedSearches;
        public static final PropertyType EnabledSavedSearchIds;
        public static final PropertyType TimeLeft;

        public static PropertyType valueOf(String s)
        {
            return (PropertyType)Enum.valueOf(com/ebay/common/model/mdns/NotificationPreference$PropertyType, s);
        }

        public static PropertyType[] values()
        {
            return (PropertyType[])$VALUES.clone();
        }

        static 
        {
            TimeLeft = new PropertyType("TimeLeft", 0);
            EnableSavedSearches = new PropertyType("EnableSavedSearches", 1);
            EnabledSavedSearchIds = new PropertyType("EnabledSavedSearchIds", 2);
            DisabledSavedSearchIds = new PropertyType("DisabledSavedSearchIds", 3);
            $VALUES = (new PropertyType[] {
                TimeLeft, EnableSavedSearches, EnabledSavedSearchIds, DisabledSavedSearchIds
            });
        }

        private PropertyType(String s, int i)
        {
            super(s, i);
        }
    }


    public static final int EVENT_ID_BESTOFR = 3;
    public static final int EVENT_ID_BIDDING_ITEMS_ENDING_SOON = 17;
    public static final int EVENT_ID_BIDRCVD = 10;
    public static final int EVENT_ID_BOACCPTD = 29;
    public static final int EVENT_ID_BODECLND = 4;
    public static final int EVENT_ID_BOPIS_BUYER_NO_SHOW = 23;
    public static final int EVENT_ID_BOPIS_OUT_OF_STOCK = 22;
    public static final int EVENT_ID_BOPIS_READY_FOR_PICKUP = 21;
    public static final int EVENT_ID_BUCKS_EXPIRING = 20;
    public static final int EVENT_ID_BidPlaced = 14;
    public static final int EVENT_ID_CARTONSALE = 39;
    public static final int EVENT_ID_CNTROFFR = 5;
    public static final int EVENT_ID_COACCPTED = 30;
    public static final int EVENT_ID_COCMPLT = 13;
    public static final int EVENT_ID_CODECLND = 31;
    public static final int EVENT_ID_COUPON_AVAILABLE = 18;
    public static final int EVENT_ID_DAILYDEALS = 36;
    public static final int EVENT_ID_DEALSFRENZY = 37;
    public static final int EVENT_ID_EBN_ORDER_CANCELED = 26;
    public static final int EVENT_ID_EBN_ORDER_PICKED_UP = 25;
    public static final int EVENT_ID_INTERNAL_BADGE = 28;
    public static final int EVENT_ID_ITMPAID = 8;
    public static final int EVENT_ID_ITMSHPD = 9;
    public static final int EVENT_ID_ITMSOLD = 7;
    public static final int EVENT_ID_ITMWON = 6;
    public static final int EVENT_ID_ItemAddedToWatchList = 15;
    public static final int EVENT_ID_ItemRemovedFromWatchList = 16;
    public static final int EVENT_ID_MSGEBAYMSGHDR = 11;
    public static final int EVENT_ID_MSGM2MMSGHDR = 12;
    public static final int EVENT_ID_OFRDCLNDACPT = 32;
    public static final int EVENT_ID_OFREXPIRED = 33;
    public static final int EVENT_ID_OFRRETRACTED = 34;
    public static final int EVENT_ID_OTHER = -1;
    public static final int EVENT_ID_OUTBID = 0;
    public static final int EVENT_ID_PAYMENT_REMINDER = 24;
    public static final int EVENT_ID_PHOTO_SYNC = 19;
    public static final int EVENT_ID_PING = 27;
    public static final int EVENT_ID_SHOPCARTITM = 35;
    public static final int EVENT_ID_SVDSRCH = 2;
    public static final int EVENT_ID_WATCHITM = 1;
    public static final int EVENT_ID_WATCHONSALE = 38;
    public static final String EVENT_NAME_OTHER = "OTHER";
    public static final String USERLOGOUT = "USERLOGOUT";
    protected static ArrayList supportedPollEventNames = new ArrayList();
    protected static ArrayList supportedPushEventNames = new ArrayList();
    public DeliveryPolicyType deliveryPolicyType;
    public String eventType;
    public boolean isEnabled;
    public ArrayList properties;
    public ArrayList savedSearchSettings;

    public NotificationPreference()
    {
        eventType = EventType.WATCHITM.name();
        properties = new ArrayList();
        savedSearchSettings = null;
    }

    public static String clientAlertNameToEventName(String s)
    {
        return idToName(clientAlertNameToId(s));
    }

    public static int clientAlertNameToId(String s)
    {
        AlertType aalerttype[] = AlertType.values();
        int j = aalerttype.length;
        for (int i = 0; i < j; i++)
        {
            AlertType alerttype = aalerttype[i];
            if (alerttype.name().equals(s))
            {
                return alerttype.id;
            }
        }

        return -1;
    }

    public static List getSupportedPollEventNames()
    {
        return supportedPollEventNames;
    }

    public static List getSupportedPushEventNames()
    {
        return supportedPushEventNames;
    }

    public static String idToClientAlertName(int i)
    {
        AlertType aalerttype[] = AlertType.values();
        int k = aalerttype.length;
        for (int j = 0; j < k; j++)
        {
            AlertType alerttype = aalerttype[j];
            if (alerttype.id == i)
            {
                return alerttype.name();
            }
        }

        return "OTHER";
    }

    public static String idToName(int i)
    {
        EventType aeventtype[] = EventType.values();
        int k = aeventtype.length;
        for (int j = 0; j < k; j++)
        {
            EventType eventtype = aeventtype[j];
            if (eventtype.id == i)
            {
                return eventtype.name();
            }
        }

        return "OTHER";
    }

    public static int nameToId(String s)
    {
        EventType aeventtype[] = EventType.values();
        int j = aeventtype.length;
        for (int i = 0; i < j; i++)
        {
            EventType eventtype = aeventtype[i];
            if (eventtype.name().equals(s))
            {
                return eventtype.id;
            }
        }

        return !s.equals("M2MMSGHDR") ? -1 : 12;
    }

    public List getSavedSearchSettings()
    {
        if (!eventType.equals(EventType.SVDSRCH.name()) || savedSearchSettings != null) goto _L2; else goto _L1
_L1:
        Iterator iterator;
        savedSearchSettings = new ArrayList();
        iterator = properties.iterator();
_L5:
        Object obj;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (NameValue)iterator.next();
        obj = new JSONArray(((NameValue) (obj)).getValue());
        int i = 0;
_L4:
        if (i >= ((JSONArray) (obj)).length())
        {
            continue; /* Loop/switch isn't completed */
        }
        Object obj1 = ((JSONArray) (obj)).getJSONObject(i);
        String s = ((JSONObject) (obj1)).getString("id");
        obj1 = ((JSONObject) (obj1)).getString("enabled");
        savedSearchSettings.add(new NameValue(s, ((String) (obj1))));
        i++;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        exception.printStackTrace();
        if (true) goto _L5; else goto _L2
_L2:
        return savedSearchSettings;
    }

    public String toString()
    {
        return eventType;
    }

}
