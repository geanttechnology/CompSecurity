// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.notifications;

import android.app.Notification;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.bk;
import android.support.v4.app.bl;
import android.support.v4.app.bx;
import com.urbanairship.Logger;
import com.urbanairship.push.PushMessage;
import com.urbanairship.util.NotificationIDGenerator;
import com.urbanairship.util.UAStringUtil;
import java.io.IOException;

// Referenced classes of package com.urbanairship.push.notifications:
//            NotificationFactory

public class DefaultNotificationFactory extends NotificationFactory
{

    private int accentColor;
    private int constantNotificationId;
    private int largeIcon;
    private int smallIconId;
    private Uri sound;
    private int titleId;

    public DefaultNotificationFactory(Context context)
    {
        super(context);
        sound = null;
        constantNotificationId = -1;
        accentColor = 0;
        titleId = context.getApplicationInfo().labelRes;
        smallIconId = context.getApplicationInfo().icon;
    }

    public Notification createNotification(PushMessage pushmessage, int i)
    {
        if (UAStringUtil.isEmpty(pushmessage.getAlert()))
        {
            return null;
        } else
        {
            return createNotificationBuilder(pushmessage, i, (new bk()).c(pushmessage.getAlert())).a();
        }
    }

    protected bl createNotificationBuilder(PushMessage pushmessage, int i, bx bx)
    {
        bl bl1;
        Object obj;
        bx bx1;
        byte byte0;
        if (UAStringUtil.isEmpty(pushmessage.getTitle()))
        {
            obj = getDefaultTitle();
        } else
        {
            obj = pushmessage.getTitle();
        }
        bl1 = (new bl(getContext())).a(((CharSequence) (obj))).b(pushmessage.getAlert()).a(true).a(smallIconId).d(accentColor).b(pushmessage.isLocalOnly()).c(pushmessage.getPriority()).a(pushmessage.getCategory()).e(pushmessage.getVisibility());
        obj = createPublicVersionNotification(pushmessage, smallIconId);
        if (obj != null)
        {
            bl1.a(((Notification) (obj)));
        }
        byte0 = 3;
        if (sound != null)
        {
            bl1.a(sound);
            byte0 = 2;
        }
        bl1.b(byte0);
        if (largeIcon > 0)
        {
            bl1.e = BitmapFactory.decodeResource(getContext().getResources(), largeIcon);
        }
        if (pushmessage.getSummary() != null)
        {
            bl1.c(pushmessage.getSummary());
        }
        obj = null;
        bx1 = createNotificationStyle(pushmessage);
        obj = bx1;
_L1:
        IOException ioexception;
        if (obj != null)
        {
            bl1.a(((bx) (obj)));
        } else
        if (bx != null)
        {
            bl1.a(bx);
        }
        if (!pushmessage.isLocalOnly())
        {
            try
            {
                bl1.a(createWearableExtender(pushmessage, i));
            }
            // Misplaced declaration of an exception variable
            catch (bx bx)
            {
                Logger.error("Failed to create wearable extender.", bx);
            }
        }
        bl1.a(createNotificationActionsExtender(pushmessage, i));
        return bl1;
        ioexception;
        Logger.error("Failed to create notification style.", ioexception);
          goto _L1
    }

    public int getColor()
    {
        return accentColor;
    }

    public int getConstantNotificationId()
    {
        return constantNotificationId;
    }

    protected String getDefaultTitle()
    {
        if (getTitleId() == 0)
        {
            return getContext().getPackageManager().getApplicationLabel(getContext().getApplicationInfo()).toString();
        }
        if (getTitleId() > 0)
        {
            return getContext().getString(getTitleId());
        } else
        {
            return "";
        }
    }

    public int getLargeIcon()
    {
        return largeIcon;
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

    public int getSmallIconId()
    {
        return smallIconId;
    }

    public Uri getSound()
    {
        return sound;
    }

    public int getTitleId()
    {
        return titleId;
    }

    public void setColor(int i)
    {
        accentColor = i;
    }

    public void setConstantNotificationId(int i)
    {
        constantNotificationId = i;
    }

    public void setLargeIcon(int i)
    {
        largeIcon = i;
    }

    public void setSmallIconId(int i)
    {
        smallIconId = i;
    }

    public void setSound(Uri uri)
    {
        sound = uri;
    }

    public void setTitleId(int i)
    {
        titleId = i;
    }
}
