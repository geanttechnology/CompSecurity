// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.notifications;

import android.app.Notification;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.support.v4.app.bl;
import android.widget.RemoteViews;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.NotificationIDGenerator;
import java.io.IOException;

// Referenced classes of package com.urbanairship.push.notifications:
//            NotificationFactory

public class CustomLayoutNotificationFactory extends NotificationFactory
{

    public int constantNotificationId;
    public int layout;
    public int layoutIconDrawableId;
    public int layoutIconId;
    public int layoutMessageId;
    public int layoutSubjectId;
    public Uri soundUri;
    public int statusBarIconDrawableId;

    public CustomLayoutNotificationFactory(Context context)
    {
        super(context);
        constantNotificationId = -1;
        int i = context.getApplicationInfo().icon;
        statusBarIconDrawableId = i;
        layoutIconDrawableId = i;
    }

    public Notification createNotification(PushMessage pushmessage, int i)
    {
        Object obj1 = null;
        Object obj2 = pushmessage.getAlert();
        if (obj2 == null || ((String) (obj2)).length() == 0)
        {
            return null;
        }
        RemoteViews remoteviews = new RemoteViews(getContext().getPackageName(), layout);
        if (layoutIconId == 0 || layoutSubjectId == 0 || layoutMessageId == 0)
        {
            Logger.error((new StringBuilder("The CustomLayoutNotificationFactory object contains an invalid identifier (value of 0). layoutIconId: ")).append(layoutIconId).append(" layoutSubjectId: ").append(layoutSubjectId).append(" layoutMessageId: ").append(layoutMessageId).toString());
            throw new IllegalArgumentException("Unable to build notification. CustomLayoutNotificationFactory missing required parameter.");
        }
        int j = layoutSubjectId;
        Object obj;
        if (pushmessage.getTitle() != null)
        {
            obj = pushmessage.getTitle();
        } else
        {
            obj = UAirship.getAppName();
        }
        remoteviews.setTextViewText(j, ((CharSequence) (obj)));
        remoteviews.setTextViewText(layoutMessageId, ((CharSequence) (obj2)));
        remoteviews.setImageViewResource(layoutIconId, layoutIconDrawableId);
        obj = new bl(getContext());
        ((bl) (obj)).q.contentView = remoteviews;
        obj2 = ((bl) (obj)).a(true).a(statusBarIconDrawableId).b(pushmessage.isLocalOnly()).c(pushmessage.getPriority()).a(pushmessage.getCategory()).e(pushmessage.getVisibility());
        obj = createPublicVersionNotification(pushmessage, layoutIconId);
        if (obj != null)
        {
            ((bl) (obj2)).a(((Notification) (obj)));
        }
        j = 3;
        if (soundUri != null)
        {
            ((bl) (obj2)).a(soundUri);
            j = 2;
        }
        ((bl) (obj2)).b(j);
        try
        {
            obj = createNotificationStyle(pushmessage);
        }
        catch (IOException ioexception)
        {
            Logger.error("Failed to create notification style.", ioexception);
            ioexception = obj1;
        }
        if (obj != null)
        {
            ((bl) (obj2)).a(((android.support.v4.app.bx) (obj)));
        }
        if (!pushmessage.isLocalOnly())
        {
            try
            {
                ((bl) (obj2)).a(createWearableExtender(pushmessage, i));
            }
            catch (IOException ioexception1)
            {
                Logger.error("Failed to create wearable extender.", ioexception1);
            }
        }
        ((bl) (obj2)).a(createNotificationActionsExtender(pushmessage, i));
        pushmessage = ((bl) (obj2)).a();
        pushmessage.contentView = remoteviews;
        return pushmessage;
    }

    public int getNextId(PushMessage pushmessage)
    {
        if (constantNotificationId > 0)
        {
            return constantNotificationId;
        } else
        {
            return NotificationIDGenerator.nextID();
        }
    }
}
