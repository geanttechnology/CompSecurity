// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;

import android.content.Context;
import java.util.IllegalFormatConversionException;
import java.util.MissingResourceException;

// Referenced classes of package com.ebay.common.model.mdns:
//            PlatformNotificationsEvent, NotificationStringResources

public static class  extends PlatformNotificationsEvent
{

    public String getContentString(Context context, NotificationStringResources notificationstringresources, int i)
        throws MissingResourceException
    {
        return content;
    }

    public String getTickerString(Context context, NotificationStringResources notificationstringresources, int i)
        throws IllegalFormatConversionException
    {
        return content;
    }

    public String getTitleString(Context context, NotificationStringResources notificationstringresources, int i)
        throws IllegalFormatConversionException
    {
        return header;
    }

    public (String s)
    {
        super.eventType = s;
    }
}
