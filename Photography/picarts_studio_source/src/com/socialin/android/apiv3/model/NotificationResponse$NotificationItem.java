// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.apiv3.model;

import com.socialin.android.c;
import com.socialin.gson.Gson;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.socialin.android.apiv3.model:
//            NotificationResponse, ImageItem, ViewerUser

public class checked
{

    public String action;
    public boolean checked;
    public Date createdAt;
    public String data;
    public String id;
    public ImageItem item;
    public int lastHighVersion;
    public int lastLowVersion;
    public String message;
    public int read;
    public type sysParams;
    public String type;
    public ViewerUser user;
    public ViewerUser user1;
    public long userId;

    public boolean checkActionValidity(String s)
    {
        boolean flag1 = false;
        String as[] = NotificationResponse.NOTIFICATION_TYPES;
        int j = as.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!as[i].equals(s))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public S cloneWithJson()
    {
        return (S)c.a().fromJson(c.a().toJson(this), getClass());
    }

    public int getAppLastVersion()
    {
        int i = android.os.onse.NotificationItem;
        if (i >= 8 && i < 14)
        {
            return lastLowVersion;
        } else
        {
            return lastHighVersion;
        }
    }

    public boolean isKnownType()
    {
        return action != null && Arrays.asList(NotificationResponse.NOTIFICATION_TYPES).contains(action) || isSystemType();
    }

    public boolean isSystemType()
    {
        boolean flag;
        if (action != null && ("none".equals(action) || "open_url".equals(action) || "start_activity".equals(action)))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return type != null && Arrays.asList(NotificationResponse.NOTIFICATION_SYS_TYPES).contains(type) || flag;
    }

    public String toString()
    {
        return c.a().toJson(this);
    }

    public ()
    {
        id = null;
        userId = 0L;
        read = 0;
        checked = false;
    }
}
