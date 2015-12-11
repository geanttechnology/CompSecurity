// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.model.mdns.PlatformNotificationsEvent;
import com.ebay.mobile.viewitem.ItemViewBidTracking;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.ebay.mobile.notifications:
//            MyEbayNotificationAction, ViewItemNotificationAction

public class NotificationActionUtil
{

    public NotificationActionUtil()
    {
    }

    public static List getActions(List list)
    {
        if (list == null || list.isEmpty()) goto _L2; else goto _L1
_L1:
        NotificationPreference.nameToId(((PlatformNotificationsEvent)list.get(0)).eventType);
        JVM INSTR lookupswitch 3: default 64
    //                   0: 68
    //                   1: 73
    //                   24: 78;
           goto _L2 _L3 _L4 _L5
_L2:
        return Collections.emptyList();
_L3:
        return getOutBidActions(list);
_L4:
        return getWatchItemEndingActions(list);
_L5:
        return getPaymentReminderActions(list);
    }

    private static List getOutBidActions(List list)
    {
        LinkedList linkedlist;
        PlatformNotificationsEvent platformnotificationsevent;
label0:
        {
            int i;
            if (list == null)
            {
                i = 0;
            } else
            {
                i = list.size();
            }
            linkedlist = new LinkedList();
            if (i > 0)
            {
                platformnotificationsevent = (PlatformNotificationsEvent)list.get(0);
                int j = NotificationPreference.nameToId(platformnotificationsevent.eventType);
                if (i <= 1)
                {
                    break label0;
                }
                ArrayList arraylist = new ArrayList(i);
                for (list = list.iterator(); list.hasNext(); arraylist.add(((PlatformNotificationsEvent)list.next()).refId)) { }
                linkedlist.add(new MyEbayNotificationAction(0x7f020286, 0x7f070698, 1, i, j, platformnotificationsevent.eventType, ItemViewBidTracking.BID_SOURCE_OUTBID_NOTIFICATION, Integer.valueOf(2), arraylist));
            }
            return linkedlist;
        }
        if (platformnotificationsevent.itemType != null)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$ebay$common$model$mdns$PlatformNotificationsEvent$ItemListingType[];

                static 
                {
                    $SwitchMap$com$ebay$common$model$mdns$PlatformNotificationsEvent$ItemListingType = new int[com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemListingType.values().length];
                    try
                    {
                        $SwitchMap$com$ebay$common$model$mdns$PlatformNotificationsEvent$ItemListingType[com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemListingType.BINONLY.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$ebay$common$model$mdns$PlatformNotificationsEvent$ItemListingType[com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemListingType.BIDONLY.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$ebay$common$model$mdns$PlatformNotificationsEvent$ItemListingType[com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemListingType.BIDWITHBIN.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls1..SwitchMap.com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemListingType[platformnotificationsevent.itemType.ordinal()])
            {
            default:
                return linkedlist;

            case 1: // '\001'
                linkedlist.add(new ViewItemNotificationAction(0x7f020286, 0x7f070697, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Bidding, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.NONE, Integer.valueOf(2)));
                return linkedlist;

            case 2: // '\002'
                linkedlist.add(new ViewItemNotificationAction(0x7f020286, 0x7f070697, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Bidding, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.NONE, Integer.valueOf(2)));
                linkedlist.add(new ViewItemNotificationAction(0x7f020282, 0x7f070696, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Bidding, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.PLACE_BID_AMOUNT, Integer.valueOf(4)));
                return linkedlist;

            case 3: // '\003'
                linkedlist.add(new ViewItemNotificationAction(0x7f020282, 0x7f070696, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Bidding, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.PLACE_BID_AMOUNT, Integer.valueOf(4)));
                break;
            }
            linkedlist.add(new ViewItemNotificationAction(0x7f020283, 0x7f070694, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Bidding, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.BUY_IT_NOW, Integer.valueOf(5)));
            return linkedlist;
        } else
        {
            linkedlist.add(new ViewItemNotificationAction(0x7f020286, 0x7f070697, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Bidding, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.NONE, Integer.valueOf(2)));
            return linkedlist;
        }
    }

    private static List getPaymentReminderActions(List list)
    {
        LinkedList linkedlist;
        int i;
        if (list == null)
        {
            i = 0;
        } else
        {
            i = list.size();
        }
        linkedlist = new LinkedList();
        if (i > 0)
        {
            list = (PlatformNotificationsEvent)list.get(0);
            if (((PlatformNotificationsEvent) (list)).itemType != null)
            {
                linkedlist.add(new ViewItemNotificationAction(0x7f020286, 0x7f070697, list, com.ebay.common.ConstantsCommon.ItemKind.Won, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.NONE, Integer.valueOf(2)));
                linkedlist.add(new ViewItemNotificationAction(0x7f020283, 0x7f070764, list, com.ebay.common.ConstantsCommon.ItemKind.Won, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.PAY_NOW, Integer.valueOf(5)));
            }
        }
        return linkedlist;
    }

    private static List getWatchItemEndingActions(List list)
    {
        LinkedList linkedlist;
        PlatformNotificationsEvent platformnotificationsevent;
label0:
        {
            int i;
            if (list == null)
            {
                i = 0;
            } else
            {
                i = list.size();
            }
            linkedlist = new LinkedList();
            if (i > 0)
            {
                platformnotificationsevent = (PlatformNotificationsEvent)list.get(0);
                int j = NotificationPreference.nameToId(platformnotificationsevent.eventType);
                if (i <= 1)
                {
                    break label0;
                }
                ArrayList arraylist = new ArrayList(i);
                for (list = list.iterator(); list.hasNext(); arraylist.add(((PlatformNotificationsEvent)list.next()).refId)) { }
                linkedlist.add(new MyEbayNotificationAction(0x7f020286, 0x7f070698, 0, i, j, platformnotificationsevent.eventType, ItemViewBidTracking.BID_SOURCE_WATCHED_ITEM_ENDING_NOTIFICATION, Integer.valueOf(2), arraylist));
            }
            return linkedlist;
        }
        if (platformnotificationsevent.itemType != null)
        {
            switch (_cls1..SwitchMap.com.ebay.common.model.mdns.PlatformNotificationsEvent.ItemListingType[platformnotificationsevent.itemType.ordinal()])
            {
            default:
                return linkedlist;

            case 1: // '\001'
                linkedlist.add(new ViewItemNotificationAction(0x7f020286, 0x7f070697, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Watched, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.NONE, Integer.valueOf(2)));
                linkedlist.add(new ViewItemNotificationAction(0x7f020283, 0x7f070694, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Watched, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.BUY_IT_NOW, Integer.valueOf(5)));
                return linkedlist;

            case 2: // '\002'
                linkedlist.add(new ViewItemNotificationAction(0x7f020286, 0x7f070697, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Watched, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.NONE, Integer.valueOf(2)));
                linkedlist.add(new ViewItemNotificationAction(0x7f020282, 0x7f070695, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Watched, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.PLACE_BID_AMOUNT, Integer.valueOf(3)));
                return linkedlist;

            case 3: // '\003'
                linkedlist.add(new ViewItemNotificationAction(0x7f020282, 0x7f070695, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Watched, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.PLACE_BID_AMOUNT, Integer.valueOf(3)));
                break;
            }
            linkedlist.add(new ViewItemNotificationAction(0x7f020283, 0x7f070694, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Watched, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.BUY_IT_NOW, Integer.valueOf(5)));
            return linkedlist;
        } else
        {
            linkedlist.add(new ViewItemNotificationAction(0x7f020286, 0x7f070697, platformnotificationsevent, com.ebay.common.ConstantsCommon.ItemKind.Bidding, com.ebay.mobile.viewitem.ItemViewActivity.UserAction.NONE, Integer.valueOf(2)));
            return linkedlist;
        }
    }
}
