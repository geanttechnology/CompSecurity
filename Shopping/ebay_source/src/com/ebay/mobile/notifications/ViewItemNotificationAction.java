// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.model.mdns.PlatformNotificationsEvent;
import com.ebay.mobile.activities.eBay;
import com.ebay.mobile.viewitem.ItemViewActivity;

// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationAction

public class ViewItemNotificationAction
    implements NotificationAction
{

    public final String eventTypeName;
    public final int iconId;
    public final String itemId;
    public final com.ebay.common.ConstantsCommon.ItemKind itemKind;
    public final int notificationTypeId;
    public final Integer notifyTap;
    public final String referenceId;
    public final int stringId;
    public final com.ebay.mobile.viewitem.ItemViewActivity.UserAction userAction;

    public ViewItemNotificationAction(int i, int j, PlatformNotificationsEvent platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind itemkind, com.ebay.mobile.viewitem.ItemViewActivity.UserAction useraction, Integer integer)
    {
        this(i, j, platformnotificationsevent.itemId, itemkind, NotificationPreference.nameToId(platformnotificationsevent.eventType), useraction, platformnotificationsevent.eventType, integer, platformnotificationsevent.refId);
    }

    public ViewItemNotificationAction(int i, int j, String s, com.ebay.common.ConstantsCommon.ItemKind itemkind, int k, com.ebay.mobile.viewitem.ItemViewActivity.UserAction useraction, String s1, 
            Integer integer, String s2)
    {
        iconId = i;
        stringId = j;
        itemId = s;
        itemKind = itemkind;
        notificationTypeId = k;
        userAction = useraction;
        eventTypeName = s1;
        referenceId = s2;
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
        Intent intent = new Intent(context, com/ebay/mobile/viewitem/ItemViewActivity);
        intent.putExtra("item_id", itemId);
        intent.putExtra("item_kind", itemKind.toString());
        intent.putExtra("noti_type_id", notificationTypeId);
        intent.putExtra("noti_sys_id", i);
        intent.putExtra("user_action", userAction.toString());
        intent.putExtra("event_type", eventTypeName);
        if (notifyTap != null)
        {
            intent.putExtra("notify_tap", notifyTap.intValue());
        }
        if (referenceId != null)
        {
            intent.putExtra("rid", referenceId);
        }
        intent.putExtra("com.ebay.mobile.menu.NAVIGATE_UP", new ComponentName(context, com/ebay/mobile/activities/eBay));
        return PendingIntent.getActivity(context, j, intent, 0x50000000);
    }
}
