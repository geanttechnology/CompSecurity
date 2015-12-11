// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.shopcase;

import com.ebay.nautilus.domain.data.ErrorMessageDetails;
import com.ebay.nautilus.kernel.content.ResultStatus;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.shopcase:
//            ShopcaseMessage

public final class ShopcaseErrorHandler
{

    public static final int NOTIFICATION_NOT_A_BIN_ITEM = 106;
    public static final int NOTIFICATION_REVISED = 125;
    private final com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action;
    private final String ebayItemId;
    private final Long itemReferenceId;
    private final List messages = new LinkedList();

    public ShopcaseErrorHandler(com.ebay.nautilus.domain.content.dm.ShoppingCartDataManagerBase.Action action1, String s, Long long1)
    {
        action = action1;
        ebayItemId = s;
        itemReferenceId = long1;
    }

    public static com.ebay.nautilus.kernel.content.ResultStatus.Message createIafTokenError(String s)
    {
        ErrorMessageDetails errormessagedetails = new ErrorMessageDetails();
        errormessagedetails.domain = "Security";
        errormessagedetails.code = "11002";
        errormessagedetails.severityCode = "ERROR";
        errormessagedetails.shortMessage = s;
        errormessagedetails.longMessage = s;
        return errormessagedetails;
    }

    public static boolean hasErrorCode(List list, int i)
    {
        if (list != null && !list.isEmpty())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                if (i == ((com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Notification)list.next()).notificationId.intValue())
                {
                    return true;
                }
            }
        }
        return false;
    }

    public void addErrors(List list)
    {
        if (list == null || list.isEmpty())
        {
            return;
        } else
        {
            messages.addAll(list);
            return;
        }
    }

    public void addNotifications(List list)
    {
        if (list != null && !list.isEmpty())
        {
            list = list.iterator();
            while (list.hasNext()) 
            {
                com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Notification notification = (com.ebay.nautilus.domain.net.api.shopcase.models.ShopCart.Notification)list.next();
                messages.add(new ShopcaseMessage(notification, ebayItemId, itemReferenceId));
            }
        }
    }

    public ResultStatus getResultStatus()
    {
        return ResultStatus.create(messages);
    }
}
