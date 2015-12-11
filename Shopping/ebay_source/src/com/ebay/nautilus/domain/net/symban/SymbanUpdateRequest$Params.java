// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.symban;

import com.ebay.nautilus.domain.data.EbayCosDateTime;
import com.ebay.nautilus.domain.data.SymbanNotification;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.symban:
//            SymbanUpdateRequest

public static class lastRetrievalTime
{
    private static class UpdateNotification
    {

        private final String notificationId;
        private final String status;

        public UpdateNotification(String s, String s1)
        {
            notificationId = s;
            status = s1;
        }
    }


    private final EbayCosDateTime lastRetrievalTime;
    private Boolean markAllRead;
    private List notifications;

    public UpdateNotification addNotification(SymbanNotification symbannotification, com.ebay.nautilus.domain.data.um um)
    {
        if (notifications == null)
        {
            notifications = new ArrayList(1);
        }
        symbannotification = new UpdateNotification(symbannotification.getNotificationId(), um.name());
        notifications.add(symbannotification);
        return this;
    }

    public Date getDate()
    {
        return lastRetrievalTime.getValue();
    }

    public Boolean isMarkAllRead()
    {
        boolean flag;
        if (markAllRead == null)
        {
            flag = false;
        } else
        {
            flag = markAllRead.booleanValue();
        }
        return Boolean.valueOf(flag);
    }

    public markAllRead setMarkAllRead(boolean flag)
    {
        markAllRead = Boolean.valueOf(flag);
        return this;
    }

    public UpdateNotification.status(Date date)
    {
        markAllRead = null;
        lastRetrievalTime = new EbayCosDateTime(date);
    }
}
