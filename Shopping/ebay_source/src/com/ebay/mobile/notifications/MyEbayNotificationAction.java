// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ebay.mobile.activities.MyEbayLandingActivity;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.sell.lists.SellingListActivity;
import com.ebay.nautilus.domain.data.UnifiedStream.ChannelEnum;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationAction

public class MyEbayNotificationAction
    implements NotificationAction
{

    private final String bidSource;
    private final int eventCount;
    private final List eventReferenceIds;
    private final String eventTypeName;
    private final int iconId;
    private final int myEbayListType;
    private final int notificationTypeId;
    private final Integer notifyTap;
    private final int stringId;

    public MyEbayNotificationAction(int i, int j, int k, int l, int i1, String s, String s1, 
            Integer integer, List list)
    {
        iconId = i;
        stringId = j;
        if (list == null)
        {
            eventReferenceIds = Collections.emptyList();
        } else
        {
            eventReferenceIds = list;
        }
        myEbayListType = k;
        eventCount = l;
        notificationTypeId = i1;
        bidSource = s1;
        eventTypeName = s;
        notifyTap = integer;
    }

    public int getCaptionResourceId()
    {
        return stringId;
    }

    public int getIconResourceId()
    {
        return iconId;
    }

    public PendingIntent getPendingIntent(Context context, int i, int j)
    {
        myEbayListType;
        JVM INSTR tableswitch 0 9: default 60
    //                   0 239
    //                   1 248
    //                   2 260
    //                   3 272
    //                   4 284
    //                   5 296
    //                   6 322
    //                   7 348
    //                   8 374
    //                   9 400;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L1:
        Intent intent;
        intent = new Intent(context, com/ebay/mobile/activities/eBay);
        intent.putExtra("HomeStartChannelTab", ChannelEnum.ACTIVITY);
_L13:
        intent.putExtra("collapsedNotificationCount", eventCount);
        intent.putExtra("noti_rid_list", (Serializable)eventReferenceIds);
        intent.putExtra("noti_type_id", notificationTypeId);
        intent.putExtra("noti_sys_id", i);
        if (notifyTap != null)
        {
            intent.putExtra("notify_tap", notifyTap);
        }
        if (!eventReferenceIds.isEmpty())
        {
            intent.putExtra("noti_rid_list", (Serializable)eventReferenceIds);
        }
        intent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
        if (!TextUtils.isEmpty(bidSource))
        {
            intent.putExtra("com.ebay.mobile.tracking.BidSource", bidSource);
        }
        intent.putExtra("event_type", eventTypeName);
        return PendingIntent.getActivity(context, j, intent, 0x50000000);
_L2:
        intent = MyEbayLandingActivity.getWatchingActivityIntent(context);
        continue; /* Loop/switch isn't completed */
_L3:
        intent = MyEbayLandingActivity.getBuyingActivityIntent(context, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.BIDS);
        continue; /* Loop/switch isn't completed */
_L4:
        intent = MyEbayLandingActivity.getBuyingActivityIntent(context, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.WON);
        continue; /* Loop/switch isn't completed */
_L5:
        intent = MyEbayLandingActivity.getBuyingActivityIntent(context, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.LOST);
        continue; /* Loop/switch isn't completed */
_L6:
        intent = MyEbayLandingActivity.getBuyingActivityIntent(context, com.ebay.mobile.activities.MyEbayLandingActivity.BuyingTarget.OFFERS);
        continue; /* Loop/switch isn't completed */
_L7:
        intent = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
        intent.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.ACTIVE);
        continue; /* Loop/switch isn't completed */
_L8:
        intent = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
        intent.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.SOLD);
        continue; /* Loop/switch isn't completed */
_L9:
        intent = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
        intent.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.UNSOLD);
        continue; /* Loop/switch isn't completed */
_L10:
        intent = new Intent(context, com/ebay/mobile/sell/lists/SellingListActivity);
        intent.putExtra("listType", com.ebay.mobile.sell.lists.SellingListActivity.ListType.SCHEDULED);
        continue; /* Loop/switch isn't completed */
_L11:
        intent = SellingListActivity.getRefinedActiveIntent(context, "NewOffers");
        if (true) goto _L13; else goto _L12
_L12:
    }
}
