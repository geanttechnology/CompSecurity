// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.rdio.android.app.notifications;

import com.rdio.android.api.models.ApiModel;
import com.rdio.android.api.models.generated.BaseSimpleComment;
import com.rdio.android.api.models.generated.BaseUser;
import java.util.List;

// Referenced classes of package com.rdio.android.app.notifications:
//            NotificationItem, NotificationType

public class Notification
{

    public List items;
    public NotificationType notificationType;

    public Notification()
    {
    }

    public BaseUser getAvatarModel()
    {
        NotificationItem notificationitem = getFirstNotificationItem();
        if (notificationitem != null)
        {
            return notificationitem.notifier;
        } else
        {
            return null;
        }
    }

    public BaseSimpleComment getComment()
    {
        NotificationItem notificationitem = getFirstNotificationItem();
        if (notificationitem != null)
        {
            return notificationitem.comment;
        } else
        {
            return null;
        }
    }

    public NotificationItem getFirstNotificationItem()
    {
        if (items == null || items.size() == 0)
        {
            return null;
        } else
        {
            return (NotificationItem)items.get(0);
        }
    }

    public String getMessage()
    {
        NotificationItem notificationitem = getFirstNotificationItem();
        if (notificationitem != null)
        {
            return notificationitem.message;
        } else
        {
            return null;
        }
    }

    public ApiModel getSourceModel()
    {
        NotificationItem notificationitem = getFirstNotificationItem();
        if (notificationitem != null)
        {
            return notificationitem.source;
        } else
        {
            return null;
        }
    }
}
