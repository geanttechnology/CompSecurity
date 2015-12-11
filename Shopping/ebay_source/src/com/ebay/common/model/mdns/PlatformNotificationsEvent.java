// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import com.ebay.nautilus.domain.datamapping.BaseDataMapped;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.IllegalFormatConversionException;
import java.util.MissingResourceException;
import org.json.JSONObject;

// Referenced classes of package com.ebay.common.model.mdns:
//            NotificationStringResources

public class PlatformNotificationsEvent extends BaseDataMapped
{
    public static abstract class ActiveNotificationsEvent extends PlatformNotificationsEvent
    {

        private static final int FINITE_LOWER_BOUND = 2;
        private static final int FINITE_UPPER_BOUND = 0x7fffffff;

        public String getContentString(Context context, NotificationStringResources notificationstringresources, int i)
            throws MissingResourceException
        {
            if (i < 2)
            {
                String s = context.getString(notificationstringresources.singleContentResourceId);
                if (currentPrice == null || currentPrice.isZero())
                {
                    return s;
                } else
                {
                    return TextUtils.join(context.getString(notificationstringresources.contentDelimiterResourceId), new String[] {
                        context.getString(notificationstringresources.singleContentResourceId), currentPrice.toString()
                    });
                }
            } else
            {
                return context.getString(notificationstringresources.infiniteContentResourceId);
            }
        }

        public String getTickerString(Context context, NotificationStringResources notificationstringresources, int i)
            throws IllegalFormatConversionException
        {
            if (i < 2)
            {
                return getContentString(context, notificationstringresources, i);
            } else
            {
                return getTitleString(context, notificationstringresources, i);
            }
        }

        public String getTitleString(Context context, NotificationStringResources notificationstringresources, int i)
            throws IllegalFormatConversionException
        {
            if (i >= 2 && i <= 0x7fffffff)
            {
                return context.getString(notificationstringresources.finiteTitleResourceId, new Object[] {
                    Integer.valueOf(i)
                });
            }
            if (i > 0x7fffffff)
            {
                return context.getString(notificationstringresources.infiniteTitleResourceId);
            } else
            {
                return context.getString(notificationstringresources.singleTitleResourceId, new Object[] {
                    title
                });
            }
        }

        public ActiveNotificationsEvent()
        {
        }
    }

    public static class BidItemEndingEvent extends ActiveNotificationsEvent
    {

        public BidItemEndingEvent()
        {
            super.eventType = NotificationPreference.EventType.BIDITEM.name();
        }
    }

    public static class CartItemEndingEvent extends PlatformNotificationsEvent
        implements Parcelable
    {

        public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

            public CartItemEndingEvent createFromParcel(Parcel parcel)
            {
                return (CartItemEndingEvent)DataMapperFactory.readParcelJson(parcel, com/ebay/common/model/mdns/PlatformNotificationsEvent$CartItemEndingEvent);
            }

            public volatile Object createFromParcel(Parcel parcel)
            {
                return createFromParcel(parcel);
            }

            public CartItemEndingEvent[] newArray(int i)
            {
                return new CartItemEndingEvent[i];
            }

            public volatile Object[] newArray(int i)
            {
                return newArray(i);
            }

        };


        public CartItemEndingEvent()
        {
            eventType = NotificationPreference.EventType.SHOPCARTITM.name();
        }

        public CartItemEndingEvent(com.ebay.nautilus.domain.data.ShoppingCart.Item item)
        {
            this(item.ebayItemId, item.itemEndTime, item.title, item.imageUrl);
        }

        public CartItemEndingEvent(Long long1, Date date, String s, String s1)
        {
            this();
            long l;
            if (long1 != null)
            {
                long1 = long1.toString();
            } else
            {
                long1 = "";
            }
            itemId = long1;
            if (date != null)
            {
                l = date.getTime();
            } else
            {
                l = 0L;
            }
            endTimestamp = l;
            if (date != null)
            {
                long1 = date.toString();
            } else
            {
                long1 = "";
            }
            endTime = long1;
            if (s == null)
            {
                s = "";
            }
            title = s;
            if (s1 == null)
            {
                s1 = "";
            }
            galleryUrl = s1;
        }
    }

    public static class ClientAlertsData
    {

        public ArrayList events;
        public String sessionData;

        public ClientAlertsData()
        {
            events = new ArrayList();
        }
    }

    public static class CouponAvailableEvent extends PlatformNotificationsEvent
    {

        public void setInfo(Intent intent)
        {
            code = intent.getStringExtra("code");
        }

        public CouponAvailableEvent()
        {
            eventType = NotificationPreference.EventType.COUPONAVLBL.name();
        }
    }

    public static class DealsEvent extends PlatformNotificationsEvent
    {

        public String getContentString(Context context, NotificationStringResources notificationstringresources, int i)
            throws MissingResourceException
        {
            return content;
        }

        public String getTickerString(Context context, NotificationStringResources notificationstringresources, int i)
            throws IllegalFormatConversionException
        {
            return content;
        }

        public String getTitleString(Context context, NotificationStringResources notificationstringresources, int i)
            throws IllegalFormatConversionException
        {
            return header;
        }

        public DealsEvent(String s)
        {
            eventType = s;
        }
    }

    public static class ItemAddedToWatchListEvent extends PlatformNotificationsEvent
    {

        public int quantity;

        public ItemAddedToWatchListEvent()
        {
        }
    }

    public static final class ItemListingType extends Enum
    {

        private static final ItemListingType $VALUES[];
        public static final ItemListingType BIDONLY;
        public static final ItemListingType BIDWITHBIN;
        public static final ItemListingType BINONLY;
        private final int value;

        public static ItemListingType fromListingType(String s, boolean flag)
        {
            if (s != null)
            {
                if (s.equals("FixedPriceItem"))
                {
                    return BINONLY;
                }
                if (s.equals("Chinese"))
                {
                    if (flag)
                    {
                        return BIDWITHBIN;
                    } else
                    {
                        return BIDONLY;
                    }
                }
            }
            return null;
        }

        public static ItemListingType get(int i)
        {
            ItemListingType aitemlistingtype[] = values();
            int k = aitemlistingtype.length;
            for (int j = 0; j < k; j++)
            {
                ItemListingType itemlistingtype = aitemlistingtype[j];
                if (i == itemlistingtype.getValue())
                {
                    return itemlistingtype;
                }
            }

            return null;
        }

        public static ItemListingType valueOf(String s)
        {
            return (ItemListingType)Enum.valueOf(com/ebay/common/model/mdns/PlatformNotificationsEvent$ItemListingType, s);
        }

        public static ItemListingType[] values()
        {
            return (ItemListingType[])$VALUES.clone();
        }

        public int getValue()
        {
            return value;
        }

        static 
        {
            BINONLY = new ItemListingType("BINONLY", 0, 1);
            BIDWITHBIN = new ItemListingType("BIDWITHBIN", 1, 2);
            BIDONLY = new ItemListingType("BIDONLY", 2, 3);
            $VALUES = (new ItemListingType[] {
                BINONLY, BIDWITHBIN, BIDONLY
            });
        }

        private ItemListingType(String s, int i, int j)
        {
            super(s, i);
            value = j;
        }
    }

    public static class OutbidEvent extends ActiveNotificationsEvent
    {

        public String highBidderEiasToken;
        public String highBidderUserId;
        public CurrencyAmount minimumToBid;

        public OutbidEvent()
        {
            super.eventType = NotificationPreference.EventType.OUTBID.name();
        }
    }

    public static class SavedSearchEvent extends PlatformNotificationsEvent
    {

        public String searchIds;

        public String[] searchIdsToArray()
        {
            if (searchIds == null)
            {
                return new String[0];
            } else
            {
                return searchIds.split(",");
            }
        }

        public SavedSearchEvent()
        {
            eventType = NotificationPreference.EventType.SVDSRCH.name();
        }
    }

    public static class WatchedItemEndingEvent extends ActiveNotificationsEvent
    {

        public WatchedItemEndingEvent()
        {
            super.eventType = NotificationPreference.EventType.WATCHITM.name();
        }
    }


    public static final String BUY_IT_NOW_AVAILABLE = "buyItNowAvailable";
    public static final String COLLAPSE_KEY = "collapse_key";
    public static final String CONTENT = "content";
    public static final String CURRENCY_CODE = "currency";
    public static final String CURRENT_BID = "curbid";
    public static final String DEVICE = "device";
    public static final String DRAFT_ID = "did";
    public static final String EVENT_KEY = "evt";
    public static final String FOLLOW_IDS = "instid";
    public static final String HEADER = "header";
    public static final String INTERNAL_BADGE_COUNT = "badge";
    public static final String ITEM_ID = "itm";
    public static final String LISTING_END_TIME = "\titemEndTime";
    public static final String LISTING_MODE = "lmode";
    public static final String LISTING_TITLE = "itemTitle";
    public static final String LISTING_TYPE = "itemListingType";
    public static final String ORDER_ID = "odr";
    public static final String REF_ID = "rid";
    public static final String SEARCH_IDS = "sid";
    public static final String SITE_ID = "site";
    public static final String TITLE = "title";
    public static final String TRANSACTION_ID = "tid";
    public static final String USER = "usr";
    public int bidCount;
    public String clientId;
    public String code;
    public String content;
    public CurrencyAmount currentPrice;
    public String deviceId;
    public String draftId;
    public String endTime;
    public long endTimestamp;
    public String eventType;
    public String galleryUrl;
    public String header;
    public String itemId;
    public ItemListingType itemType;
    public String listingMode;
    public String orderId;
    public String pictureUrl;
    public String refId;
    public String sellerUserId;
    public String siteId;
    public long timestamp;
    public String title;
    public String transactionId;
    public String username;
    public boolean viewed;

    public PlatformNotificationsEvent()
    {
        viewed = true;
    }

    public static PlatformNotificationsEvent createEvent(int i, String s)
    {
        switch (i)
        {
        default:
            PlatformNotificationsEvent platformnotificationsevent = new PlatformNotificationsEvent();
            platformnotificationsevent.eventType = s;
            return platformnotificationsevent;

        case 0: // '\0'
            return new OutbidEvent();

        case 2: // '\002'
            return new SavedSearchEvent();

        case 18: // '\022'
            return new CouponAvailableEvent();

        case 1: // '\001'
            return new WatchedItemEndingEvent();

        case 17: // '\021'
            return new BidItemEndingEvent();

        case 36: // '$'
        case 37: // '%'
        case 38: // '&'
        case 39: // '\''
            return new DealsEvent(s);
        }
    }

    public String getContentString(Context context, NotificationStringResources notificationstringresources, int i)
        throws MissingResourceException
    {
        if (TextUtils.isEmpty(title))
        {
            throw new MissingResourceException("Event title was empty!", getClass().getSimpleName(), "title");
        } else
        {
            return title;
        }
    }

    public long getSafeItemId()
    {
        long l;
        l = -1L;
        if (TextUtils.isEmpty(itemId))
        {
            return -1L;
        }
        long l1 = Long.parseLong(itemId);
        l = l1;
_L2:
        return l;
        NumberFormatException numberformatexception;
        numberformatexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public String getTickerString(Context context, NotificationStringResources notificationstringresources, int i)
        throws IllegalFormatConversionException
    {
        if (TextUtils.isEmpty(title))
        {
            return context.getString(notificationstringresources.singleContentResourceId);
        } else
        {
            return context.getString(notificationstringresources.singleContentResourceId, new Object[] {
                title
            });
        }
    }

    public String getTitleString(Context context, NotificationStringResources notificationstringresources, int i)
        throws IllegalFormatConversionException
    {
        return context.getString(notificationstringresources.singleTitleResourceId, new Object[] {
            title
        });
    }

    public int hashCode()
    {
        return toString().hashCode();
    }

    public String toString()
    {
        HashMap hashmap = new HashMap();
        hashmap.put("itemId", itemId);
        hashmap.put("eventType", eventType);
        hashmap.put("timestamp", (new StringBuilder()).append("").append(timestamp).toString());
        hashmap.put("viewed", (new StringBuilder()).append("").append(viewed).toString());
        String s;
        if (code != null)
        {
            s = code;
        } else
        {
            s = "<null>";
        }
        hashmap.put("code", s);
        if (clientId != null)
        {
            s = clientId;
        } else
        {
            s = "<null>";
        }
        hashmap.put("clientId", s);
        if (title != null)
        {
            s = title;
        } else
        {
            s = "<null>";
        }
        hashmap.put("title", s);
        if (deviceId != null)
        {
            s = deviceId;
        } else
        {
            s = "<null>";
        }
        hashmap.put("deviceId", s);
        if (username != null)
        {
            s = username;
        } else
        {
            s = "<null>";
        }
        hashmap.put("username", s);
        if (transactionId != null)
        {
            s = transactionId;
        } else
        {
            s = "<null>";
        }
        hashmap.put("transactionId", s);
        if (draftId != null)
        {
            s = draftId;
        } else
        {
            s = "<null>";
        }
        hashmap.put("draftId", s);
        if (listingMode != null)
        {
            s = listingMode;
        } else
        {
            s = "<null>";
        }
        hashmap.put("listingMode", s);
        if (siteId != null)
        {
            s = siteId;
        } else
        {
            s = "<null>";
        }
        hashmap.put("siteId", s);
        hashmap.put("endTimeStamp", (new StringBuilder()).append("").append(endTimestamp).toString());
        if (refId != null)
        {
            s = refId;
        } else
        {
            s = "<null>";
        }
        hashmap.put("refId", s);
        hashmap.put("galleryUrl", (new StringBuilder()).append("").append(galleryUrl).toString());
        hashmap.put("pictureUrl", pictureUrl);
        hashmap.put("orderId", orderId);
        if (itemType != null)
        {
            s = itemType.name();
        } else
        {
            s = "<null>";
        }
        hashmap.put("itemType", s);
        return (new JSONObject(hashmap)).toString();
    }
}
