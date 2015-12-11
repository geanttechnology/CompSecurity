// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.RemoteViews;
import com.ebay.common.Preferences;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.model.mdns.NotificationStringResources;
import com.ebay.common.model.mdns.PlatformNotificationsEvent;
import com.ebay.common.util.ImageCache;
import com.ebay.mobile.ActivityStarter;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.activities.EbnOrderDetailsActivity;
import com.ebay.mobile.activities.MessagesActivity;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.activities.OrderSummaryActivity;
import com.ebay.mobile.activities.SignInModalActivity;
import com.ebay.mobile.activities.UserDetailActivity;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.myebay.ReminderItemsActivity;
import com.ebay.mobile.myebay.RemindersActivity;
import com.ebay.mobile.sell.ListingFragmentActivity;
import com.ebay.mobile.sell.lists.SellingListActivity;
import com.ebay.mobile.shoppingcart.ShoppingCartActivity;
import com.ebay.mobile.viewitem.ItemViewActivity;
import com.ebay.mobile.viewitem.ItemViewBidTracking;
import com.ebay.mobile.viewitem.ViewItemViewData;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.ImageRequest;
import com.ebay.nautilus.domain.net.ImageResponse;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.kernel.util.NumberUtil;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.IllegalFormatConversionException;
import java.util.IllegalFormatException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.Set;
import java.util.regex.Pattern;

// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationPreferenceManager, ItemCache, ViewItemNotificationAction, NotificationActionUtil, 
//            NotificationAction, EventService

public class EbayNotificationManager
{
    private static class Builder
    {

        private static final int ID_CONSTANT_MODIFIER = 31771;
        private static final int NO_OVERRIDE = 0;
        private final String bidSource;
        PendingIntent contentIntent;
        String contentText;
        String contentTitle;
        private final int eventId;
        Intent futureIntent;
        private final int idOverride;
        private final String itemKind;
        private final int myEbayListType;
        private final NotificationStringResources stringResources;
        String tickerText;

        private static final RemoteViews buildCustomNotificationHeader(Context context, int i, String s, String s1, long l, int j)
        {
            context = new RemoteViews(context.getPackageName(), i);
            context.setTextViewText(0x7f100405, s);
            context.setTextViewText(0x7f100407, s1);
            if (j > 1)
            {
                context.setTextViewText(0x7f100408, Integer.toString(j));
            }
            context.setLong(0x7f100406, "setTime", l);
            context.setImageViewResource(0x7f10018d, 0x7f02020d);
            return context;
        }

        private RemoteViews buildExpandedNotification(Context context, EbayContext ebaycontext, String s, String s1, long l, List list)
        {
            switch (eventId)
            {
            default:
                return buildCustomNotificationHeader(context, 0x7f030181, s, s1, l, -1);

            case 0: // '\0'
            case 1: // '\001'
            case 36: // '$'
            case 37: // '%'
                return buildMultiImageBigContent(context, ebaycontext, s, s1, l, getDefaultNotificationId(), list);
            }
        }

        private final Notification buildForAddPhoto(Context context, EbayContext ebaycontext, PlatformNotificationsEvent platformnotificationsevent, int i, String s)
        {
            i = stringResources.singleContentResourceId;
            contentTitle = context.getString(stringResources.singleTitleResourceId);
            long l;
            if (TextUtils.isEmpty(platformnotificationsevent.title))
            {
                tickerText = context.getString(0x7f07069b);
            } else
            {
                tickerText = platformnotificationsevent.title;
            }
            contentText = tickerText;
            if (contentText.startsWith(contentTitle))
            {
                contentText = contentText.substring(contentTitle.length()).trim();
            }
            futureIntent = new Intent(context, com/ebay/mobile/sell/ListingFragmentActivity);
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            futureIntent.putExtra("draft_id", platformnotificationsevent.draftId);
            futureIntent.putExtra("listing_mode", platformnotificationsevent.listingMode);
            futureIntent.putExtra("site", EbaySite.getInstanceFromId(Integer.parseInt(platformnotificationsevent.siteId)));
            futureIntent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            futureIntent.putExtra("rid", platformnotificationsevent.refId);
            futureIntent.putExtra("noti_type_id", NotificationPreference.nameToId(platformnotificationsevent.eventType));
            l = i;
            try
            {
                l = Long.parseLong(platformnotificationsevent.draftId);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                l = i;
            }
            contentIntent = PendingIntent.getActivity(context, (int)l, futureIntent, getPendingIntentFlags());
            if (platformnotificationsevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = platformnotificationsevent.timestamp;
            }
            return buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, Arrays.asList(new PlatformNotificationsEvent[] {
                platformnotificationsevent
            }));
        }

        private final Notification buildForBucksExpiring(Context context, EbayContext ebaycontext, PlatformNotificationsEvent platformnotificationsevent, int i, String s)
        {
            int j;
            long l;
            if (i == 1)
            {
                j = stringResources.singleContentResourceId;
            } else
            {
                j = stringResources.finiteContentResourceId;
            }
            futureIntent = new Intent(context, com/ebay/mobile/activities/UserDetailActivity);
            futureIntent.putExtra("user_id", s);
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            futureIntent.putExtra("user_name", s);
            futureIntent.putExtra("event_type", platformnotificationsevent.eventType);
            futureIntent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            futureIntent.putExtra("rid", platformnotificationsevent.refId);
            futureIntent.putExtra("noti_type_id", NotificationPreference.nameToId(platformnotificationsevent.eventType));
            if (TextUtils.isEmpty(platformnotificationsevent.title))
            {
                tickerText = context.getString(0x7f0706ae);
            } else
            {
                tickerText = context.getString(stringResources.singleContentResourceId, new Object[] {
                    platformnotificationsevent.title
                });
            }
            contentTitle = context.getString(stringResources.singleTitleResourceId);
            contentText = platformnotificationsevent.title;
            contentIntent = PendingIntent.getActivity(context, j, futureIntent, getPendingIntentFlags());
            if (platformnotificationsevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = platformnotificationsevent.timestamp;
            }
            context = buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, Arrays.asList(new PlatformNotificationsEvent[] {
                platformnotificationsevent
            }));
            if (i >= 2)
            {
                context.number = i;
            }
            return context;
        }

        private final Notification buildForCartItemOnSale(Context context, EbayContext ebaycontext, List list)
        {
            int i = list.size();
            com.ebay.common.model.mdns.PlatformNotificationsEvent.DealsEvent dealsevent = (com.ebay.common.model.mdns.PlatformNotificationsEvent.DealsEvent)list.get(0);
            tickerText = dealsevent.getTickerString(context, null, i);
            contentTitle = dealsevent.getTitleString(context, null, i);
            contentText = dealsevent.getContentString(context, null, i);
            futureIntent = new Intent(context, com/ebay/mobile/shoppingcart/ShoppingCartActivity);
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            futureIntent.putExtra("rid", dealsevent.refId);
            futureIntent.putExtra("noti_type_id", NotificationPreference.nameToId(dealsevent.eventType));
            contentIntent = PendingIntent.getActivity(context, 0, futureIntent, getPendingIntentFlags());
            long l;
            if (dealsevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = dealsevent.timestamp;
            }
            return buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, list);
        }

        private final Notification buildForCoupon(Context context, EbayContext ebaycontext, com.ebay.common.model.mdns.PlatformNotificationsEvent.CouponAvailableEvent couponavailableevent, int i, String s)
        {
            int j;
            long l;
            if (i == 1)
            {
                j = stringResources.singleContentResourceId;
            } else
            {
                j = stringResources.finiteContentResourceId;
            }
            if (i == 1)
            {
                if (TextUtils.isEmpty(couponavailableevent.title))
                {
                    tickerText = context.getString(0x7f0706b5);
                } else
                {
                    tickerText = context.getString(stringResources.singleContentResourceId, new Object[] {
                        couponavailableevent.title
                    });
                }
                contentTitle = context.getString(stringResources.singleTitleResourceId);
                contentText = couponavailableevent.title;
                futureIntent = new Intent(context, com/ebay/mobile/myebay/ReminderItemsActivity);
                futureIntent.putExtra("reminders_type", -1);
                futureIntent.putExtra("message_id", couponavailableevent.code);
                futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/myebay/RemindersActivity));
                futureIntent.putExtra("rid", couponavailableevent.refId);
                futureIntent.putExtra("noti_type_id", NotificationPreference.nameToId(couponavailableevent.eventType));
            } else
            {
                tickerText = context.getString(stringResources.finiteContentResourceId, new Object[] {
                    Integer.valueOf(i)
                });
                contentTitle = tickerText;
                contentText = context.getString(0x7f0706d9);
                futureIntent = new Intent(context, com/ebay/mobile/activities/eBay);
                futureIntent.putExtra("user_name", s);
            }
            futureIntent.putExtra("event_type", couponavailableevent.eventType);
            futureIntent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            contentIntent = PendingIntent.getActivity(context, j, futureIntent, getPendingIntentFlags());
            if (couponavailableevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = couponavailableevent.timestamp;
            }
            context = buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, Arrays.asList(new PlatformNotificationsEvent[] {
                couponavailableevent
            }));
            if (i >= 2)
            {
                context.number = i;
            }
            return context;
        }

        private final Notification buildForEbayNow(Context context, EbayContext ebaycontext, PlatformNotificationsEvent platformnotificationsevent)
        {
            tickerText = platformnotificationsevent.title;
            contentTitle = context.getString(stringResources.singleTitleResourceId);
            contentText = platformnotificationsevent.title;
            Long long1 = NumberUtil.safeParseLong(platformnotificationsevent.transactionId);
            ViewItemViewData viewitemviewdata = new ViewItemViewData(context);
            viewitemviewdata.keyParams = new com.ebay.mobile.viewitem.ViewItemDataManager.KeyParams(Long.parseLong(platformnotificationsevent.itemId), long1);
            futureIntent = new Intent(context, com/ebay/mobile/activities/EbnOrderDetailsActivity);
            futureIntent.putExtra("rid", platformnotificationsevent.refId);
            futureIntent.putExtra("noti_type_id", NotificationPreference.nameToId(platformnotificationsevent.eventType));
            futureIntent.putExtra("event_type", platformnotificationsevent.eventType);
            futureIntent.putExtra("item_id", Long.parseLong(platformnotificationsevent.itemId));
            futureIntent.putExtra("transaction_id", platformnotificationsevent.transactionId);
            futureIntent.putExtra("param_view_data", viewitemviewdata);
            futureIntent.putExtra("order_id", platformnotificationsevent.orderId);
            if (!TextUtils.isEmpty(bidSource))
            {
                futureIntent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            }
            contentIntent = PendingIntent.getActivity(context, convertStringToIntForMessageId(platformnotificationsevent.transactionId, stringResources.singleTitleResourceId), futureIntent, getPendingIntentFlags());
            return buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, System.currentTimeMillis(), Arrays.asList(new PlatformNotificationsEvent[] {
                platformnotificationsevent
            }));
        }

        private final Notification buildForMessage(Context context, EbayContext ebaycontext, PlatformNotificationsEvent platformnotificationsevent, int i, String s, List list)
        {
            int j;
            if (i == 1)
            {
                j = stringResources.singleContentResourceId;
            } else
            {
                j = stringResources.finiteContentResourceId;
            }
            if (i != 1)
            {
                break MISSING_BLOCK_LABEL_339;
            }
            if (!TextUtils.isEmpty(platformnotificationsevent.itemId)) goto _L2; else goto _L1
_L1:
            Log.e("LOG_TAG", (new StringBuilder()).append("buildForMessage: notification has no msg ID, title: ").append(platformnotificationsevent.title).toString());
            context = null;
_L4:
            return context;
_L2:
            long l;
            if (TextUtils.isEmpty(platformnotificationsevent.title))
            {
                tickerText = context.getString(0x7f0706d4);
            } else
            {
                tickerText = context.getString(stringResources.singleContentResourceId, new Object[] {
                    platformnotificationsevent.title
                });
            }
            contentTitle = context.getString(stringResources.singleTitleResourceId);
            contentText = platformnotificationsevent.title;
            futureIntent = new Intent(context, com/ebay/mobile/activities/MessagesActivity);
            futureIntent.putExtra("message_id", platformnotificationsevent.itemId);
            futureIntent.putExtra("rid", platformnotificationsevent.refId);
_L5:
            futureIntent.putExtra("noti_type_id", NotificationPreference.nameToId(platformnotificationsevent.eventType));
            futureIntent.putExtra("event_type", platformnotificationsevent.eventType);
            futureIntent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            contentIntent = PendingIntent.getActivity(context, j, futureIntent, getPendingIntentFlags());
            if (platformnotificationsevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = platformnotificationsevent.timestamp;
            }
            ebaycontext = buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, Arrays.asList(new PlatformNotificationsEvent[] {
                platformnotificationsevent
            }));
            context = ebaycontext;
            if (i < 2) goto _L4; else goto _L3
_L3:
            ebaycontext.number = i;
            return ebaycontext;
            tickerText = context.getString(stringResources.finiteContentResourceId, new Object[] {
                Integer.valueOf(i)
            });
            contentTitle = tickerText;
            contentText = context.getString(0x7f0706d9);
            futureIntent = new Intent(context, com/ebay/mobile/activities/MessagesActivity);
            futureIntent.putExtra("user_name", s);
            futureIntent.putExtra("message_id", "notification.multiple.messages");
            futureIntent.putExtra("noti_rid_list", (Serializable)mapEventsToIds(list));
            futureIntent.putExtra("collapsedNotificationCount", i);
              goto _L5
        }

        private final Notification buildForMyEbayOrViewItem(Context context, EbayContext ebaycontext, PlatformNotificationsEvent platformnotificationsevent, List list, int i, ArrayList arraylist, ArrayList arraylist1, 
                String s)
        {
            int j;
            int k;
            if (i == 1)
            {
                j = stringResources.singleContentResourceId;
            } else
            {
                j = stringResources.finiteContentResourceId;
            }
            if (EbayNotificationManager.logTag.isLoggable)
            {
                FwLog.println(EbayNotificationManager.logTag, (new StringBuilder()).append("buildForMyEbay: item id=").append(platformnotificationsevent.itemId).append(", type=").append(platformnotificationsevent.eventType).toString());
            }
            k = NotificationPreference.nameToId(platformnotificationsevent.eventType);
            try
            {
                tickerText = platformnotificationsevent.getTickerString(context, stringResources, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                tickerText = context.getString(stringResources.singleTitleResourceId);
                if (EbayNotificationManager.logTag.isLoggable)
                {
                    FwLog.println(EbayNotificationManager.logTag, (new StringBuilder()).append("unable to format ").append(platformnotificationsevent.title).append(": ").append(s).toString());
                }
            }
            try
            {
                contentText = platformnotificationsevent.getContentString(context, stringResources, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                if (s.getKey().equals("title"))
                {
                    contentText = context.getString(0x7f07069f, new Object[] {
                        platformnotificationsevent.itemId
                    });
                } else
                {
                    contentText = "";
                }
            }
            try
            {
                contentTitle = platformnotificationsevent.getTitleString(context, stringResources, i);
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                contentTitle = context.getString(stringResources.singleTitleResourceId);
            }
            if (i != 1) goto _L2; else goto _L1
_L1:
            if (!TextUtils.isEmpty(platformnotificationsevent.itemId)) goto _L4; else goto _L3
_L3:
            Log.e("eBayNotifications", (new StringBuilder()).append("buildForMyEbay: notification has no item ID, type: ").append(platformnotificationsevent.eventType).append(", title: ").append(platformnotificationsevent.title).toString());
            context = null;
_L6:
            return context;
_L4:
            long l;
            boolean flag;
            if (!TextUtils.isEmpty(platformnotificationsevent.transactionId))
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (!flag && myEbayListType == 2)
            {
                futureIntent = MyEbayLandingActivity.getBuyingActivityIntent(context, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.WON);
            } else
            if (!flag && myEbayListType == 6)
            {
                futureIntent = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
                futureIntent.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD);
            } else
            {
                futureIntent = new Intent(context, com/ebay/mobile/viewitem/ItemViewActivity);
                futureIntent.putExtra("item_id", platformnotificationsevent.itemId);
                futureIntent.putExtra("item_kind", itemKind);
                futureIntent.putExtra("transaction_id", platformnotificationsevent.transactionId);
                futureIntent.addFlags(0x4000000);
            }
_L20:
            futureIntent.putExtra("noti_type_id", k);
            futureIntent.putExtra("rid", platformnotificationsevent.refId);
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            futureIntent.putExtra("event_type", platformnotificationsevent.eventType);
            if (!TextUtils.isEmpty(bidSource))
            {
                futureIntent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            }
            contentIntent = PendingIntent.getActivity(context, j, futureIntent, getPendingIntentFlags());
            if (platformnotificationsevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = platformnotificationsevent.timestamp;
            }
            ebaycontext = buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, list);
            context = ebaycontext;
            if (i < 2) goto _L6; else goto _L5
_L5:
            ebaycontext.number = i;
            return ebaycontext;
_L2:
            myEbayListType;
            JVM INSTR tableswitch 0 9: default 712
        //                       0 849
        //                       1 860
        //                       2 874
        //                       3 888
        //                       4 902
        //                       5 916
        //                       6 948
        //                       7 980
        //                       8 1012
        //                       9 1044;
               goto _L7 _L8 _L9 _L10 _L11 _L12 _L13 _L14 _L15 _L16 _L17
_L7:
            futureIntent = new Intent(context, com/ebay/mobile/activities/eBay);
            futureIntent.putExtra("HomeStartChannelTab", ChannelEnum.ACTIVITY);
_L19:
            if (k == 0 || k == 1 || k == 17)
            {
                futureIntent.putExtra("outbid_item_id_list", arraylist);
                futureIntent.putExtra("ending_item_id_list", arraylist1);
            }
            futureIntent.putExtra("collapsedNotificationCount", i);
            arraylist = new ArrayList();
            for (arraylist1 = list.iterator(); arraylist1.hasNext(); arraylist.add(((PlatformNotificationsEvent)arraylist1.next()).refId)) { }
            break; /* Loop/switch isn't completed */
_L8:
            futureIntent = MyEbayLandingActivity.getWatchingActivityIntent(context);
            continue; /* Loop/switch isn't completed */
_L9:
            futureIntent = MyEbayLandingActivity.getBuyingActivityIntent(context, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.BIDS);
            continue; /* Loop/switch isn't completed */
_L10:
            futureIntent = MyEbayLandingActivity.getBuyingActivityIntent(context, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.WON);
            continue; /* Loop/switch isn't completed */
_L11:
            futureIntent = MyEbayLandingActivity.getBuyingActivityIntent(context, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.LOST);
            continue; /* Loop/switch isn't completed */
_L12:
            futureIntent = MyEbayLandingActivity.getBuyingActivityIntent(context, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.OFFERS);
            continue; /* Loop/switch isn't completed */
_L13:
            futureIntent = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
            futureIntent.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.ACTIVE);
            continue; /* Loop/switch isn't completed */
_L14:
            futureIntent = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
            futureIntent.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD);
            continue; /* Loop/switch isn't completed */
_L15:
            futureIntent = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
            futureIntent.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.UNSOLD);
            continue; /* Loop/switch isn't completed */
_L16:
            futureIntent = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
            futureIntent.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.SCHEDULED);
            continue; /* Loop/switch isn't completed */
_L17:
            futureIntent = SellingListActivity.getRefinedActiveIntent(context, "NewOffers");
            if (true) goto _L19; else goto _L18
_L18:
            futureIntent.putExtra("noti_rid_list", (Serializable)arraylist);
              goto _L20
        }

        private final Notification buildForOrder(Context context, EbayContext ebaycontext, PlatformNotificationsEvent platformnotificationsevent, Builder builder)
        {
            tickerText = platformnotificationsevent.title;
            contentTitle = context.getString(builder.stringResources.singleTitleResourceId);
            contentText = platformnotificationsevent.title;
            futureIntent = new Intent(context, com/ebay/mobile/activities/OrderSummaryActivity);
            futureIntent.putExtra("order_id", platformnotificationsevent.orderId);
            futureIntent.putExtra("rid", platformnotificationsevent.refId);
            futureIntent.putExtra("event_type", platformnotificationsevent.eventType);
            if (!TextUtils.isEmpty(bidSource))
            {
                futureIntent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            }
            futureIntent.putExtra("noti_type_id", NotificationPreference.nameToId(platformnotificationsevent.eventType));
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            contentIntent = PendingIntent.getActivity(context, convertStringToIntForMessageId(platformnotificationsevent.orderId, builder.stringResources.singleTitleResourceId), futureIntent, getPendingIntentFlags());
            long l = System.currentTimeMillis();
            return buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, Arrays.asList(new PlatformNotificationsEvent[] {
                platformnotificationsevent
            }));
        }

        private final Notification buildForPayNow(Context context, EbayContext ebaycontext, PlatformNotificationsEvent platformnotificationsevent, List list, int i, ArrayList arraylist, ArrayList arraylist1, 
                String s)
        {
            int j;
            int k;
            boolean flag;
            if (i == 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (flag)
            {
                j = stringResources.singleContentResourceId;
            } else
            {
                j = stringResources.finiteContentResourceId;
            }
            if (EbayNotificationManager.logTag.isLoggable)
            {
                FwLog.println(EbayNotificationManager.logTag, (new StringBuilder()).append("buildForPayNow: item id=").append(platformnotificationsevent.itemId).append(", type=").append(platformnotificationsevent.eventType).toString());
            }
            k = NotificationPreference.nameToId(platformnotificationsevent.eventType);
            if (!flag)
            {
                break MISSING_BLOCK_LABEL_626;
            }
            if (!TextUtils.isEmpty(platformnotificationsevent.itemId)) goto _L2; else goto _L1
_L1:
            Log.e("eBayNotifications", (new StringBuilder()).append("buildForPayNow: notification has no item ID, type: ").append(platformnotificationsevent.eventType).append(", title: ").append(platformnotificationsevent.title).toString());
            context = null;
_L4:
            return context;
_L2:
            long l;
            boolean flag1;
            if (TextUtils.isEmpty(platformnotificationsevent.title))
            {
                tickerText = context.getString(stringResources.singleTitleResourceId);
                if (!TextUtils.isEmpty(platformnotificationsevent.itemId))
                {
                    contentText = context.getString(0x7f07069f, new Object[] {
                        platformnotificationsevent.itemId
                    });
                } else
                {
                    contentText = "";
                }
            } else
            {
                try
                {
                    tickerText = context.getString(stringResources.singleContentResourceId, new Object[] {
                        platformnotificationsevent.title
                    });
                }
                // Misplaced declaration of an exception variable
                catch (ArrayList arraylist)
                {
                    tickerText = context.getString(stringResources.singleTitleResourceId);
                    if (EbayNotificationManager.logTag.isLoggable)
                    {
                        FwLog.println(EbayNotificationManager.logTag, (new StringBuilder()).append("unable to format ").append(platformnotificationsevent.title).append(": ").append(arraylist).toString());
                    }
                }
                contentText = platformnotificationsevent.title;
            }
            contentTitle = context.getString(stringResources.singleTitleResourceId);
            if (!TextUtils.isEmpty(platformnotificationsevent.transactionId))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            futureIntent = new Intent(context, com/ebay/mobile/viewitem/ItemViewActivity);
            futureIntent.putExtra("item_id", platformnotificationsevent.itemId);
            futureIntent.putExtra("item_kind", itemKind);
            if (flag1)
            {
                futureIntent.putExtra("transaction_id", platformnotificationsevent.transactionId);
                futureIntent.putExtra("user_action", com.ebay.mobile.viewitem.ItemViewActivity.UserAction.PAY_NOW.name());
            } else
            {
                futureIntent.putExtra("user_action", com.ebay.mobile.viewitem.ItemViewActivity.UserAction.NONE.name());
            }
_L5:
            futureIntent.putExtra("noti_type_id", k);
            futureIntent.putExtra("rid", platformnotificationsevent.refId);
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            futureIntent.putExtra("event_type", platformnotificationsevent.eventType);
            if (!TextUtils.isEmpty(bidSource))
            {
                futureIntent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            }
            contentIntent = PendingIntent.getActivity(context, j, futureIntent, getPendingIntentFlags());
            if (platformnotificationsevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = platformnotificationsevent.timestamp;
            }
            ebaycontext = buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, list);
            context = ebaycontext;
            if (i < 2) goto _L4; else goto _L3
_L3:
            ebaycontext.number = i;
            return ebaycontext;
            if (MyApp.getDeviceConfiguration().isShoppingCartEnabled())
            {
                tickerText = context.getString(stringResources.finiteContentResourceId, new Object[] {
                    Integer.valueOf(i)
                });
                contentTitle = tickerText;
                contentText = context.getString(0x7f0706d8);
                futureIntent = new Intent(context, com/ebay/mobile/shoppingcart/ShoppingCartActivity);
                arraylist = new ArrayList();
                for (arraylist1 = list.iterator(); arraylist1.hasNext(); arraylist.add(((PlatformNotificationsEvent)arraylist1.next()).refId)) { }
                futureIntent.putExtra("noti_rid_list", (Serializable)arraylist);
            } else
            {
                tickerText = context.getString(stringResources.finiteContentResourceId, new Object[] {
                    Integer.valueOf(i)
                });
                contentTitle = tickerText;
                contentText = context.getString(0x7f0706da);
                futureIntent = MyEbayLandingActivity.getBuyingActivityIntent(context, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.WON);
                futureIntent.putExtra("collapsedNotificationCount", i);
                arraylist = new ArrayList();
                for (arraylist1 = list.iterator(); arraylist1.hasNext(); arraylist.add(((PlatformNotificationsEvent)arraylist1.next()).refId)) { }
                futureIntent.putExtra("noti_rid_list", (Serializable)arraylist);
            }
              goto _L5
        }

        private final Notification buildForShoppingCart(Context context, EbayContext ebaycontext, List list)
        {
            int i = list.size();
            PlatformNotificationsEvent platformnotificationsevent;
            boolean flag;
            long l;
            if (i > 1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            platformnotificationsevent = (PlatformNotificationsEvent)list.get(0);
            futureIntent = new Intent(context, com/ebay/mobile/shoppingcart/ShoppingCartActivity);
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            if (!flag)
            {
                if (TextUtils.isEmpty(platformnotificationsevent.title))
                {
                    tickerText = context.getString(0x7f0706af);
                } else
                {
                    tickerText = context.getString(stringResources.singleContentResourceId, new Object[] {
                        platformnotificationsevent.title
                    });
                }
                contentTitle = context.getString(stringResources.singleTitleResourceId);
                contentText = platformnotificationsevent.title;
            } else
            {
                tickerText = context.getString(stringResources.finiteContentResourceId, new Object[] {
                    Integer.valueOf(i)
                });
                contentTitle = tickerText;
                contentText = context.getString(0x7f0706b2);
                futureIntent.putExtra("collapsedNotificationCount", i);
            }
            futureIntent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            futureIntent.putExtra("rid", platformnotificationsevent.refId);
            futureIntent.putExtra("noti_type_id", NotificationPreference.nameToId(platformnotificationsevent.eventType));
            contentIntent = PendingIntent.getActivity(context, stringResources.singleTitleResourceId, futureIntent, getPendingIntentFlags());
            if (platformnotificationsevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = platformnotificationsevent.timestamp;
            }
            context = buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, list);
            if (i >= 2)
            {
                context.number = i;
            }
            return context;
        }

        private final Notification buildForUnknown(Context context, EbayContext ebaycontext, PlatformNotificationsEvent platformnotificationsevent, String s)
        {
            int i = stringResources.singleContentResourceId;
            if (EbayNotificationManager.logTag.isLoggable)
            {
                FwLog.println(EbayNotificationManager.logTag, (new StringBuilder()).append("buildForUnknown: item id=").append(platformnotificationsevent.itemId).append(", type=").append(platformnotificationsevent.eventType).toString());
            }
            if (TextUtils.isEmpty(platformnotificationsevent.title))
            {
                Log.e("eBayNotifications", "buildForUnknown: title empty, discarding");
                return null;
            }
            tickerText = platformnotificationsevent.title;
            contentText = platformnotificationsevent.title;
            contentTitle = platformnotificationsevent.title;
            futureIntent = new Intent(context, com/ebay/mobile/activities/eBay);
            futureIntent.putExtra("noti_type_id", 0);
            futureIntent.putExtra("rid", platformnotificationsevent.refId);
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            contentIntent = PendingIntent.getActivity(context, i, futureIntent, getPendingIntentFlags());
            long l;
            if (platformnotificationsevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = platformnotificationsevent.timestamp;
            }
            return buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, Arrays.asList(new PlatformNotificationsEvent[] {
                platformnotificationsevent
            }));
        }

        private final Notification buildForUserLoggedOut(Context context, EbayContext ebaycontext)
        {
            tickerText = context.getString(0x7f0706fb);
            contentTitle = context.getString(0x7f0706fa);
            contentText = context.getString(0x7f0706f9);
            futureIntent = SignInModalActivity.getIntentForSignIn("UserSignOut", context);
            futureIntent.putExtra("event_type", "USERLOGOUT");
            contentIntent = PendingIntent.getActivity(context, 1, futureIntent, getPendingIntentFlags());
            long l = System.currentTimeMillis();
            return buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, Collections.emptyList());
        }

        private final Notification buildForWatchItemOnSale(Context context, EbayContext ebaycontext, List list)
        {
            int i = list.size();
            com.ebay.common.model.mdns.PlatformNotificationsEvent.DealsEvent dealsevent = (com.ebay.common.model.mdns.PlatformNotificationsEvent.DealsEvent)list.get(0);
            tickerText = dealsevent.getTickerString(context, null, i);
            contentTitle = dealsevent.getTitleString(context, null, i);
            contentText = dealsevent.getContentString(context, null, i);
            futureIntent = new Intent(context, com/ebay/mobile/viewitem/ItemViewActivity);
            futureIntent.addFlags(0x4000000);
            futureIntent.putExtra("item_id", dealsevent.itemId);
            futureIntent.putExtra("rid", dealsevent.refId);
            futureIntent.putExtra("item_kind", itemKind);
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            futureIntent.putExtra("noti_type_id", NotificationPreference.nameToId(dealsevent.eventType));
            contentIntent = PendingIntent.getActivity(context, 0, futureIntent, getPendingIntentFlags());
            long l;
            if (dealsevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = dealsevent.timestamp;
            }
            return buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, list);
        }

        private static final RemoteViews buildMultiImageBigContent(Context context, EbayContext ebaycontext, String s, String s1, long l, int i, List list)
        {
            RemoteViews remoteviews = buildCustomNotificationHeader(context, 0x7f030184, s, s1, l, -1);
            String s2 = MyApp.getDeviceConfiguration().getGalleryImageHost();
            int i1 = Math.min(1024, context.getResources().getDisplayMetrics().widthPixels);
            int j1 = Math.min(3, list.size());
            for (int j = 0; j < j1; j++)
            {
                Object obj = (PlatformNotificationsEvent)list.get(j);
                s = null;
                s1 = ItemCache.getItemPictureImageUrl(context, ((PlatformNotificationsEvent) (obj)).itemId);
                if (s1 != null)
                {
                    s = ImageCache.rewriteThumbs(s2, EbayNotificationManager.pattern, s1);
                }
                s1 = s;
                if (TextUtils.isEmpty(s))
                {
                    s1 = s;
                    if (s2 != null)
                    {
                        s1 = String.format(Locale.US, "http://%1$s/d/l%2$d/pict/%3$s.jpg", new Object[] {
                            s2, Integer.valueOf(i1), ((PlatformNotificationsEvent) (obj)).itemId
                        });
                    }
                }
                s = EbayNotificationManager.getBitmapFromURL(ebaycontext, s1);
                if (s == null || s.getWidth() < 100)
                {
                    continue;
                }
                s1 = new RemoteViews(context.getPackageName(), 0x7f030183);
                obj = new ViewItemNotificationAction(0, 0, ((PlatformNotificationsEvent) (obj)), com.ebay.common.ConstantsCommon.ItemKind.Unknown, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.NONE, Integer.valueOf(1));
                int k1 = EbayNotificationManager.counter;
                EbayNotificationManager.counter = k1 + 1;
                obj = ((ViewItemNotificationAction) (obj)).getPendingIntent(context, i, k1);
                s1.setImageViewBitmap(0x7f100409, s);
                if (j > 0)
                {
                    s1.setViewVisibility(0x7f10040a, 0);
                }
                s1.setOnClickPendingIntent(0x7f100409, ((PendingIntent) (obj)));
                remoteviews.addView(0x7f10040b, s1);
            }

            if (j1 > 0)
            {
                ebaycontext = NotificationActionUtil.getActions(list);
                for (s = ebaycontext.iterator(); s.hasNext(); remoteviews.addView(0x7f10040d, list))
                {
                    s1 = (NotificationAction)s.next();
                    list = new RemoteViews(context.getPackageName(), 0x7f030180);
                    list.setTextViewText(0x7f100404, context.getString(s1.getCaptionResourceId()));
                    setTextViewCompoundDrawables(list, 0x7f100404, s1.getIconResourceId(), 0, 0, 0);
                    int k = EbayNotificationManager.counter;
                    EbayNotificationManager.counter = k + 1;
                    list.setOnClickPendingIntent(0x7f100404, s1.getPendingIntent(context, i, k));
                }

                if (ebaycontext.isEmpty())
                {
                    i = 8;
                } else
                {
                    i = 0;
                }
                remoteviews.setViewVisibility(0x7f10040d, i);
            }
            return remoteviews;
        }

        private Notification buildStandardNotification(Context context, EbayContext ebaycontext, String s, String s1, String s2, long l, 
                List list)
        {
            android.support.v4.app.NotificationCompat.Builder builder = new android.support.v4.app.NotificationCompat.Builder(context);
            int i;
            if (eventId == com.ebay.common.model.mdns.NotificationPreference.EventType.OUTBID.id || eventId == com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHITM.id || eventId == com.ebay.common.model.mdns.NotificationPreference.EventType.DailyDeals.id || eventId == com.ebay.common.model.mdns.NotificationPreference.EventType.DealsFrenzy.id)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            builder.setSmallIcon(0x7f02023a);
            builder.setContentTitle(s);
            builder.setContentText(s1);
            builder.setTicker(s2);
            builder.setWhen(l);
            builder.setContentIntent(contentIntent);
            if (i != 0)
            {
                i = -1;
            } else
            {
                i = list.size();
            }
            builder.setContent(buildCustomNotificationHeader(context, 0x7f030182, s, s1, l, i));
            s2 = builder.build();
            if (DeviceConfiguration.getAsync().get(DcsBoolean.JellyBeanNotifications))
            {
                setBigContentView(s2, buildExpandedNotification(context, ebaycontext, s, s1, l, list));
            }
            return s2;
        }

        private int convertStringToIntForMessageId(String s, int i)
        {
            String s1;
            long l;
            l = i;
            s1 = s;
            long l1;
            if (s.contains("-"))
            {
                s1 = s.replaceAll("-", "");
            }
            l1 = Long.parseLong(s1);
            l = l1;
_L2:
            return (int)l;
            s;
            if (true) goto _L2; else goto _L1
_L1:
        }

        private int getDefaultNotificationId()
        {
            if (idOverride == 0)
            {
                return stringResources.singleTitleResourceId;
            } else
            {
                return idOverride;
            }
        }

        private static int getPendingIntentFlags()
        {
            return 0x14000000;
        }

        private static List mapEventsToIds(List list)
        {
            if (list != null) goto _L2; else goto _L1
_L1:
            list = Collections.emptyList();
_L4:
            return list;
_L2:
            ArrayList arraylist = new ArrayList(list.size());
            Iterator iterator = list.iterator();
            do
            {
                list = arraylist;
                if (!iterator.hasNext())
                {
                    continue;
                }
                arraylist.add(((PlatformNotificationsEvent)iterator.next()).refId.toString());
            } while (true);
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void publishNotification(Context context, NotificationManager notificationmanager, Notification notification, boolean flag, PlatformNotificationsEvent platformnotificationsevent)
        {
            int j;
            int k;
            j = -1;
            if (platformnotificationsevent != null)
            {
                j = NotificationPreference.nameToId(platformnotificationsevent.eventType);
            }
            EbayNotificationManager.setSoundsAndVibrateFlash(context, notification, flag, j);
            k = getDefaultNotificationId();
            if (platformnotificationsevent == null || j < 21 || j > 23) goto _L2; else goto _L1
_L1:
            int i = convertStringToIntForMessageId(platformnotificationsevent.orderId, getDefaultNotificationId());
_L4:
            Intent intent = new Intent(context, com/ebay/mobile/notifications/EventService);
            intent.setAction("clearNotificationCache");
            if (platformnotificationsevent != null)
            {
                intent.putExtra("noti_type_id", j);
                intent.putExtra("event_type", platformnotificationsevent.eventType);
                intent.putExtra("rid", platformnotificationsevent.refId);
                intent.putExtra("noti_sys_id", i);
                j = futureIntent.getIntExtra("collapsedNotificationCount", 1);
                if (j > 1)
                {
                    platformnotificationsevent = (List)futureIntent.getSerializableExtra("noti_rid_list");
                    intent.putExtra("collapsedNotificationCount", j);
                    intent.putExtra("noti_rid_list", (Serializable)platformnotificationsevent);
                }
            }
            j = EbayNotificationManager.counter;
            EbayNotificationManager.counter = j + 1;
            notification.deleteIntent = PendingIntent.getService(context, j, intent, 0x40000000);
            if (EbayNotificationManager.logTag.isLoggable)
            {
                FwLog.println(EbayNotificationManager.logTag, "Sending notification to NotificationManager");
            }
            notificationmanager.cancel(i);
            notificationmanager.notify(i, notification);
            return;
_L2:
            i = k;
            if (platformnotificationsevent != null)
            {
                i = k;
                if (platformnotificationsevent.eventType.equals(com.ebay.common.model.mdns.NotificationPreference.EventType.ADDPHOTO.name()))
                {
                    i = convertStringToIntForMessageId(platformnotificationsevent.draftId, getDefaultNotificationId());
                }
            }
            if (true) goto _L4; else goto _L3
_L3:
        }

        private void publishSignedOutNotification(Context context, NotificationManager notificationmanager, Notification notification)
        {
            publishNotification(context, notificationmanager, notification, false);
        }

        private static void setBigContentView(Notification notification, RemoteViews remoteviews)
        {
            if (notification != null && android.os.Build.VERSION.SDK_INT >= 16)
            {
                notification.bigContentView = remoteviews;
            }
        }

        private static void setTextViewCompoundDrawables(RemoteViews remoteviews, int i, int j, int k, int l, int i1)
        {
            if (remoteviews != null && android.os.Build.VERSION.SDK_INT >= 16)
            {
                remoteviews.setTextViewCompoundDrawables(i, j, k, l, i1);
            }
        }

        protected final Notification buildForSavedSearch(Context context, EbayContext ebaycontext, com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent savedsearchevent)
        {
            String as[] = savedsearchevent.searchIdsToArray();
            int i;
            long l;
            if (as.length == 1)
            {
                i = stringResources.singleContentResourceId;
            } else
            {
                i = stringResources.finiteContentResourceId;
            }
            if (as.length == 1)
            {
                String s = savedsearchevent.title;
                tickerText = context.getString(stringResources.singleContentResourceId, new Object[] {
                    s
                });
                contentTitle = context.getString(stringResources.singleTitleResourceId);
                contentText = context.getString(0x7f0706f6, new Object[] {
                    s
                });
                futureIntent = ActivityStarter.getSavedSearchIntent(context, ebaycontext, as[0], null);
                futureIntent.putExtra("rid", savedsearchevent.refId);
                if (EbayNotificationManager.logTag.isLoggable)
                {
                    FwLog.println(EbayNotificationManager.logTag, (new StringBuilder()).append("buildForSavedSearch, single search ID = ").append(as[0]).toString());
                }
                futureIntent.putExtra("first_time_run_ss", true);
                futureIntent.putExtra("noti_type_id", NotificationPreference.nameToId(savedsearchevent.eventType));
            } else
            {
                tickerText = context.getString(stringResources.finiteContentResourceId);
                contentTitle = context.getString(stringResources.singleTitleResourceId);
                contentText = context.getString(0x7f0706db);
                futureIntent = ActivityStarter.getSavedSearchIntent(context, ebaycontext, null, null);
            }
            futureIntent.putExtra("saved_search_from_notification", true);
            futureIntent.putExtra("event_type", savedsearchevent.eventType);
            futureIntent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
            futureIntent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
            contentIntent = PendingIntent.getActivity(context, i, futureIntent, getPendingIntentFlags());
            if (savedsearchevent.timestamp == 0L)
            {
                l = System.currentTimeMillis();
            } else
            {
                l = savedsearchevent.timestamp;
            }
            return buildStandardNotification(context, ebaycontext, contentTitle, contentText, tickerText, l, Arrays.asList(new PlatformNotificationsEvent[] {
                savedsearchevent
            }));
        }

        public final void create(Context context, EbayContext ebaycontext, NotificationManager notificationmanager, ArrayList arraylist, String s, ArrayList arraylist1, ArrayList arraylist2, 
                String s1)
        {
label0:
            {
label1:
                {
label2:
                    {
label3:
                        {
label4:
                            {
label5:
                                {
label6:
                                    {
label7:
                                        {
label8:
                                            {
label9:
                                                {
label10:
                                                    {
                                                        PlatformNotificationsEvent platformnotificationsevent;
                                                        boolean flag;
                                                        {
                                                            int i = arraylist.size();
                                                            platformnotificationsevent = (PlatformNotificationsEvent)arraylist.get(0);
                                                            flag = EbayNotificationManager.isQuietTime(context, s);
                                                            switch (eventId)
                                                            {
                                                            default:
                                                                if (eventId == -1)
                                                                {
                                                                    ebaycontext = buildForUnknown(context, ebaycontext, platformnotificationsevent, s1);
                                                                } else
                                                                {
                                                                    ebaycontext = buildForMyEbayOrViewItem(context, ebaycontext, platformnotificationsevent, arraylist, i, arraylist1, arraylist2, s1);
                                                                }
                                                                break;

                                                            case 2: // '\002'
                                                                break label10;

                                                            case 11: // '\013'
                                                            case 12: // '\f'
                                                                break label9;

                                                            case 18: // '\022'
                                                                break label8;

                                                            case 19: // '\023'
                                                                break label7;

                                                            case 20: // '\024'
                                                                break label6;

                                                            case 21: // '\025'
                                                            case 22: // '\026'
                                                            case 23: // '\027'
                                                                break label4;

                                                            case 24: // '\030'
                                                                break label2;

                                                            case 25: // '\031'
                                                            case 26: // '\032'
                                                                break label3;

                                                            case 35: // '#'
                                                                break label5;

                                                            case 38: // '&'
                                                                break label0;

                                                            case 39: // '\''
                                                                break label1;
                                                            }
                                                        }
                                                        if (ebaycontext == null)
                                                        {
                                                            return;
                                                        } else
                                                        {
                                                            publishNotification(context, notificationmanager, ebaycontext, flag, platformnotificationsevent);
                                                            return;
                                                        }
                                                    }
                                                    ebaycontext = buildForSavedSearch(context, ebaycontext, (com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent)platformnotificationsevent);
                                                    break MISSING_BLOCK_LABEL_179;
                                                }
                                                ebaycontext = buildForMessage(context, ebaycontext, platformnotificationsevent, i, s, arraylist);
                                                break MISSING_BLOCK_LABEL_179;
                                            }
                                            ebaycontext = buildForCoupon(context, ebaycontext, (com.ebay.common.model.mdns.PlatformNotificationsEvent.CouponAvailableEvent)platformnotificationsevent, i, s);
                                            break MISSING_BLOCK_LABEL_179;
                                        }
                                        ebaycontext = buildForAddPhoto(context, ebaycontext, platformnotificationsevent, i, s);
                                        break MISSING_BLOCK_LABEL_179;
                                    }
                                    ebaycontext = buildForBucksExpiring(context, ebaycontext, platformnotificationsevent, i, s);
                                    break MISSING_BLOCK_LABEL_179;
                                }
                                ebaycontext = buildForShoppingCart(context, ebaycontext, arraylist);
                                break MISSING_BLOCK_LABEL_179;
                            }
                            ebaycontext = buildForOrder(context, ebaycontext, platformnotificationsevent, this);
                            break MISSING_BLOCK_LABEL_179;
                        }
                        ebaycontext = buildForEbayNow(context, ebaycontext, platformnotificationsevent);
                        break MISSING_BLOCK_LABEL_179;
                    }
                    ebaycontext = buildForPayNow(context, ebaycontext, platformnotificationsevent, arraylist, i, arraylist1, arraylist2, s1);
                    break MISSING_BLOCK_LABEL_179;
                }
                ebaycontext = buildForCartItemOnSale(context, ebaycontext, arraylist);
                break MISSING_BLOCK_LABEL_179;
            }
            ebaycontext = buildForWatchItemOnSale(context, ebaycontext, arraylist);
            break MISSING_BLOCK_LABEL_179;
        }

        public final void createSignOutNotification(Context context, EbayContext ebaycontext, NotificationManager notificationmanager)
        {
            publishSignedOutNotification(context, notificationmanager, buildForUserLoggedOut(context, ebaycontext));
        }

        protected void publishNotification(Context context, NotificationManager notificationmanager, Notification notification, boolean flag)
        {
            publishNotification(context, notificationmanager, notification, flag, null);
        }

        public Builder()
        {
            this(0, 0, 0, 0, EbayNotificationManager.ID_SIGN_OUT_NOTIFICATION, EbayNotificationManager.ID_SIGN_OUT_NOTIFICATION, EbayNotificationManager.ID_SIGN_OUT_NOTIFICATION, com.ebay.common.ConstantsCommon.ItemKind.Unknown.toString(), 0, "");
        }

        public Builder(int i, int j, int k, int l, int i1, int j1, int k1, 
                String s, int l1, String s1)
        {
            tickerText = null;
            contentTitle = null;
            contentText = null;
            contentIntent = null;
            eventId = i;
            stringResources = new NotificationStringResources(j, k, l, i1, j1, k1, 0x7f0706fe);
            itemKind = s;
            myEbayListType = l1;
            bidSource = s1;
            if (j == 0 && i != -1)
            {
                idOverride = i + 31771;
                return;
            } else
            {
                idOverride = 0;
                return;
            }
        }

        public Builder(int i, int j, int k, int l, String s)
        {
            this(i, j, l, 0, k, 0, 0, com.ebay.common.ConstantsCommon.ItemKind.Unknown.toString(), 0, s);
        }

        public Builder(int i, int j, int k, int l, String s, int i1, String s1)
        {
            this(i, j, l, 0, k, 0, 0, s, i1, s1);
        }
    }


    public static int ID_SIGN_OUT_NOTIFICATION = 0;
    private static final String LOG_TAG = "eBayNotifications";
    private static final int MINIMUM_IMAGE_WIDTH = 100;
    protected static int counter = 1;
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("eBayNotifications", 3, "EbayNotificationManager log");
    private static HashMap notifBuilderMap;
    protected static Pattern pattern = Pattern.compile("(http[s]?://)(thumbs[1-9]?\\.ebaystatic\\.com)(.*)");
    private final Context ctx;
    private final EbayContext ebayContext;
    private final NotificationManager mgr;
    private String userId;

    public EbayNotificationManager(Context context, EbayContext ebaycontext)
    {
        ctx = context;
        ebayContext = ebaycontext;
        mgr = (NotificationManager)context.getSystemService("notification");
    }

    private ArrayList buildItemIdLists(ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        if (arraylist != null && !arraylist.isEmpty())
        {
            arraylist = arraylist.iterator();
            while (arraylist.hasNext()) 
            {
                arraylist1.add(((PlatformNotificationsEvent)arraylist.next()).itemId);
            }
        }
        return arraylist1;
    }

    protected static Bitmap getBitmapFromURL(EbayContext ebaycontext, String s)
    {
        Object obj = null;
        ImageResponse imageresponse;
        try
        {
            imageresponse = (ImageResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(ebaycontext, new ImageRequest(new URL(s)));
        }
        // Misplaced declaration of an exception variable
        catch (EbayContext ebaycontext)
        {
            Log.e("eBayNotifications", (new StringBuilder()).append("getBitmapFromURL failed for src ").append(s).toString(), ebaycontext);
            return null;
        }
        ebaycontext = obj;
        if (imageresponse.hasSuccessResponseCode())
        {
            ebaycontext = imageresponse.getImage();
        }
        return ebaycontext;
    }

    public static Uri getNotificationSound(int i)
    {
        i;
        JVM INSTR tableswitch 0 39: default 176
    //                   0 186
    //                   1 186
    //                   2 206
    //                   3 196
    //                   4 186
    //                   5 186
    //                   6 186
    //                   7 196
    //                   8 186
    //                   9 186
    //                   10 196
    //                   11 176
    //                   12 176
    //                   13 196
    //                   14 176
    //                   15 176
    //                   16 176
    //                   17 186
    //                   18 186
    //                   19 176
    //                   20 186
    //                   21 186
    //                   22 186
    //                   23 186
    //                   24 186
    //                   25 186
    //                   26 186
    //                   27 176
    //                   28 176
    //                   29 176
    //                   30 176
    //                   31 176
    //                   32 176
    //                   33 176
    //                   34 176
    //                   35 186
    //                   36 176
    //                   37 176
    //                   38 186
    //                   39 186;
           goto _L1 _L2 _L2 _L3 _L4 _L2 _L2 _L2 _L4 _L2 _L2 _L4 _L1 _L1 _L4 _L1 _L1 _L1 _L2 _L2 _L1 _L2 _L2 _L2 _L2 _L2 _L2 _L2 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L1 _L2 _L1 _L1 _L2 _L2
_L1:
        return Uri.parse(MyApp.getPrefs().getNotificationsGeneralTone());
_L2:
        return Uri.parse(MyApp.getPrefs().getNotificationsBuyingTone());
_L4:
        return Uri.parse(MyApp.getPrefs().getNotificationsSellingTone());
_L3:
        Uri uri = Uri.parse(MyApp.getPrefs().getNotificationsSavedSearchTone());
        return uri;
        NullPointerException nullpointerexception;
        nullpointerexception;
        Log.e("eBayNotifications", "getNotificationSound exception", nullpointerexception);
        return null;
    }

    private String getTargetClientId(Map map)
    {
        String s;
        String s1;
        s1 = "AEAPP";
        s = "AEAPP";
        HashMap hashmap;
        Iterator iterator;
        hashmap = new HashMap();
        iterator = map.keySet().iterator();
_L11:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Iterator iterator1 = ((List)map.get((String)iterator.next())).iterator();
_L9:
        PlatformNotificationsEvent platformnotificationsevent;
        Integer integer;
        if (!iterator1.hasNext())
        {
            continue; /* Loop/switch isn't completed */
        }
        platformnotificationsevent = (PlatformNotificationsEvent)iterator1.next();
        s = platformnotificationsevent.clientId;
        integer = (Integer)hashmap.get(platformnotificationsevent.clientId);
        if (integer != null) goto _L4; else goto _L3
_L3:
        try
        {
            hashmap.put(platformnotificationsevent.clientId, Integer.valueOf(1));
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Map map)
        {
            FwLog.println(logTag, "getTargetClientId exception", map);
            map = s1;
        }
_L6:
        return map;
_L4:
        hashmap.put(platformnotificationsevent.clientId, Integer.valueOf(integer.intValue() + 1));
        continue; /* Loop/switch isn't completed */
_L2:
        map = s1;
        if (hashmap.keySet().size() != 1) goto _L6; else goto _L5
_L5:
        map = s;
        if (s != null) goto _L6; else goto _L7
_L7:
        return "AEAPP";
        if (true) goto _L9; else goto _L8
_L8:
        if (true) goto _L11; else goto _L10
_L10:
    }

    public static boolean isQuietTime(Context context, String s)
    {
        boolean flag = (new NotificationPreferenceManager(context)).isQuietTime(s, Calendar.getInstance());
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("isQuietTime for userId=").append(s).append(" ret=").append(flag).toString());
        }
        return flag;
    }

    protected static void setSoundsAndVibrateFlash(Context context, Notification notification, boolean flag, int i)
    {
        notification.flags = notification.flags | 0x10;
        context = MyApp.getPrefs();
        boolean flag1;
        if (context.isNotificationSoundEnabled() && !flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1)
        {
            notification.sound = getNotificationSound(i);
        }
        if (context.isNotificationLedFlashEnabled())
        {
            notification.flags = notification.flags | 1;
            notification.ledARGB = 0xff00ff00;
            notification.ledOnMS = 300;
            notification.ledOffMS = 1000;
        }
        if (!flag && context.isNotificationVibrationEnabled())
        {
            notification.defaults = notification.defaults | 2;
        }
    }

    public static boolean shouldNotifyUser(PlatformNotificationsEvent platformnotificationsevent)
    {
        return NotificationPreference.getSupportedPushEventNames().contains(platformnotificationsevent.eventType);
    }

    public void cancelAllNotifications()
    {
        mgr.cancelAll();
    }

    public void cancelNotification(int i)
    {
        mgr.cancel(i);
    }

    public final void createNotifications(Collection collection)
    {
        if (collection != null && !collection.isEmpty())
        {
            Object obj = new HashMap();
            Iterator iterator = collection.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                PlatformNotificationsEvent platformnotificationsevent = (PlatformNotificationsEvent)iterator.next();
                if ("OTHER".equals(platformnotificationsevent.eventType) || shouldNotifyUser(platformnotificationsevent))
                {
                    ArrayList arraylist2 = (ArrayList)((HashMap) (obj)).get(platformnotificationsevent.eventType);
                    ArrayList arraylist = arraylist2;
                    if (arraylist2 == null)
                    {
                        String s = platformnotificationsevent.eventType;
                        arraylist = new ArrayList(collection.size());
                        ((HashMap) (obj)).put(s, arraylist);
                    }
                    arraylist.add(platformnotificationsevent);
                    if (logTag.isLoggable)
                    {
                        FwLog.println(logTag, (new StringBuilder()).append("createNotifications: item id=").append(platformnotificationsevent.itemId).append(";type=").append(platformnotificationsevent.eventType).toString());
                    }
                }
            } while (true);
            collection = buildItemIdLists((ArrayList)((HashMap) (obj)).get(com.ebay.common.model.mdns.NotificationPreference.EventType.OUTBID.name()));
            ArrayList arraylist1 = buildItemIdLists((ArrayList)((HashMap) (obj)).get(com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHITM.name()));
            arraylist1.addAll(buildItemIdLists((ArrayList)((HashMap) (obj)).get(com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM.name())));
            String s1 = getTargetClientId(((Map) (obj)));
            obj = ((HashMap) (obj)).entrySet().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)((Iterator) (obj)).next();
                Builder builder = (Builder)notifBuilderMap.get(entry.getKey());
                if (builder != null)
                {
                    builder.create(ctx, ebayContext, mgr, (ArrayList)entry.getValue(), userId, collection, arraylist1, s1);
                }
            }
        }
    }

    public final void createSavedSearchNotification(com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent savedsearchevent, boolean flag)
    {
        if (shouldNotifyUser(savedsearchevent))
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("createNotifications: item id=").append(savedsearchevent.itemId).append(";type=").append(savedsearchevent.eventType).append(";searchIds=").append(savedsearchevent.searchIds).toString());
            }
            Builder builder = (Builder)notifBuilderMap.get(savedsearchevent.eventType);
            if (builder != null)
            {
                savedsearchevent = builder.buildForSavedSearch(ctx, ebayContext, savedsearchevent);
                if (!flag)
                {
                    savedsearchevent.sound = getNotificationSound(2);
                } else
                {
                    savedsearchevent.sound = null;
                }
                builder.publishNotification(ctx, mgr, savedsearchevent, flag);
                return;
            }
        }
    }

    public final void createUserLoggedOutNotification()
    {
        (new Builder()).createSignOutNotification(ctx, ebayContext, mgr);
    }

    protected void setCurrentUser(String s)
    {
        userId = s;
    }

    static 
    {
        ID_SIGN_OUT_NOTIFICATION = 51180;
        notifBuilderMap = new HashMap();
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.OUTBID.name(), new Builder(0, 0x7f0706f3, 0x7f0706c5, 0x7f0706c5, 0x7f0706f2, 0x7f0706bb, 0x7f0706c4, com.ebay.common.ConstantsCommon.ItemKind.Bidding.name(), 1, ItemViewBidTracking.BID_SOURCE_OUTBID_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHITM.name(), new Builder(1, 0x7f0706c9, 0x7f0706c3, 0x7f0706c3, 0x7f0706c8, 0x7f0706ba, 0x7f0706c2, com.ebay.common.ConstantsCommon.ItemKind.Watched.name(), 0, ItemViewBidTracking.BID_SOURCE_WATCHED_ITEM_ENDING_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM.name(), new Builder(17, 0x7f07069c, 0x7f0706c3, 0x7f0706c3, 0x7f070cf4, 0x7f0706ba, 0x7f0706c2, com.ebay.common.ConstantsCommon.ItemKind.Bidding.name(), 1, ItemViewBidTracking.BID_SOURCE_BID_ITEM_ENDING_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.BESTOFR.name(), new Builder(3, 0x7f0706ef, 0x7f0706ee, 0x7f0706e6, com.ebay.common.ConstantsCommon.ItemKind.Selling.name(), 9, ItemViewBidTracking.BID_SOURCE_BESTOFR_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.BODECLND.name(), new Builder(4, 0x7f0706ed, 0x7f0706ec, 0x7f0706e5, com.ebay.common.ConstantsCommon.ItemKind.Bidding.name(), 4, ItemViewBidTracking.BID_SOURCE_BODECLND_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.CNTROFFR.name(), new Builder(5, 0x7f0706eb, 0x7f0706ea, 0x7f0706e4, com.ebay.common.ConstantsCommon.ItemKind.Bidding.name(), 4, ItemViewBidTracking.BID_SOURCE_CNTROFFR_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.ITMWON.name(), new Builder(6, 0x7f0706d1, 0x7f0706d0, 0x7f0706e2, com.ebay.common.ConstantsCommon.ItemKind.Won.name(), 2, ItemViewBidTracking.BID_SOURCE_ITMWON_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.ITMSOLD.name(), new Builder(7, 0x7f0706cf, 0x7f0706ce, 0x7f0706e1, com.ebay.common.ConstantsCommon.ItemKind.Sold.name(), 6, ItemViewBidTracking.BID_SOURCE_ITMSOLD_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.ITMPAID.name(), new Builder(8, 0x7f0706cb, 0x7f0706ca, 0x7f0706df, com.ebay.common.ConstantsCommon.ItemKind.Won.name(), 2, ItemViewBidTracking.BID_SOURCE_ITMPAID_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.ITMSHPD.name(), new Builder(9, 0x7f0706cd, 0x7f0706cc, 0x7f0706e0, com.ebay.common.ConstantsCommon.ItemKind.Won.name(), 2, ItemViewBidTracking.BID_SOURCE_ITMSHPD_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.BIDRCVD.name(), new Builder(10, 0x7f07069e, 0x7f07069d, 0x7f0706d6, com.ebay.common.ConstantsCommon.ItemKind.Selling.name(), 5, ItemViewBidTracking.BID_SOURCE_BIDRCVD_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.COCMPLT.name(), new Builder(13, 0x7f0706c7, 0x7f0706c6, 0x7f0706de, com.ebay.common.ConstantsCommon.ItemKind.Sold.name(), 6, ItemViewBidTracking.BID_SOURCE_COCMPLT_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.MSGM2MMSGHDR.name(), new Builder(12, 0x7f0706d3, 0x7f0706d2, 0x7f0706e3, ItemViewBidTracking.BID_SOURCE_MSGM2MMSGHDR_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.MSGEBAYMSGHDR.name(), new Builder(11, 0x7f0706b7, 0x7f0706b6, 0x7f0706dd, ItemViewBidTracking.BID_SOURCE_MSGEBAYMSGHDR_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.SVDSRCH.name(), new Builder(2, 0x7f0706f8, 0x7f0706f7, 0x7f0706e8, ItemViewBidTracking.BID_SOURCE_SVDSRCH_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.COUPONAVLBL.name(), new Builder(18, 0x7f0706b4, 0x7f0706b3, 0x7f0706dc, ItemViewBidTracking.BID_SOURCE_COUPON_AVAILABLE));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.ADDPHOTO.name(), new Builder(19, 0x7f07069a, 0x7f070699, 0x7f0706d5, ItemViewBidTracking.BID_SOURCE_ADD_PHOTO));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.BUCKSEXP.name(), new Builder(20, 0x7f0706ad, 0x7f0706ac, 0x7f0706d7, ItemViewBidTracking.BID_SOURCE_BUCKS_EXPIRING));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.SHOPCARTITM.name(), new Builder(35, 0x7f0706b0, 0x7f0706af, 0x7f0706b1, ItemViewBidTracking.BID_SOURCE_SHOPCARTITM_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.ITMPICKUP.name(), new Builder(21, 0x7f0706aa, 0x7f0706a9, 0x7f0706a5, ItemViewBidTracking.BID_SOURCE_ITMPICKUP));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.ITMOUTSTK.name(), new Builder(22, 0x7f0706a7, 0x7f0706a6, 0x7f0706a4, ItemViewBidTracking.BID_SOURCE_ITMOUTSTK));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.BYRNOSHW.name(), new Builder(22, 0x7f0706a1, 0x7f0706a0, 0x7f0706a3, ItemViewBidTracking.BID_SOURCE_BYRNOSHW));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.PAYREM.name(), new Builder(24, 0x7f0706f5, 0x7f0706f4, 0x7f0706e7, com.ebay.common.ConstantsCommon.ItemKind.Won.toString(), 2, ItemViewBidTracking.BID_SOURCE_PAYREM));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.EBNORDPICKED.name(), new Builder(25, 0, 0x7f0706b9, 0, ItemViewBidTracking.BID_SOURCE_EBN_ORDER_PICKED_UP));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.EBNORDCNCL.name(), new Builder(26, 0, 0x7f0706b8, 0, ItemViewBidTracking.BID_SOURCE_EBN_ORDER_CANCELED));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.DailyDeals.name(), new Builder(36, 0, 0, 0, ItemViewBidTracking.BID_SOURCE_DAILYDEALS_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.DealsFrenzy.name(), new Builder(37, 0, 0, 0, ItemViewBidTracking.BID_SOURCE_DEALSFRENZY_NOTIFICATION));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHONSALE.name(), new Builder(38, 0, 0, 0, ""));
        notifBuilderMap.put(com.ebay.common.model.mdns.NotificationPreference.EventType.CARTONSALE.name(), new Builder(39, 0, 0, 0, ""));
        notifBuilderMap.put("OTHER", new Builder(-1, 0, 0, 0, null));
    }
}
