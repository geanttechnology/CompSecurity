// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.mdns;

import android.content.Context;
import android.text.TextUtils;
import com.ebay.nautilus.domain.data.CurrencyAmount;
import java.util.IllegalFormatConversionException;
import java.util.MissingResourceException;

// Referenced classes of package com.ebay.common.model.mdns:
//            PlatformNotificationsEvent, NotificationStringResources

public static abstract class  extends PlatformNotificationsEvent
{

    private static final int FINITE_LOWER_BOUND = 2;
    private static final int FINITE_UPPER_BOUND = 0x7fffffff;

    public String getContentString(Context context, NotificationStringResources notificationstringresources, int i)
        throws MissingResourceException
    {
        if (i < 2)
        {
            String s = context.getString(notificationstringresources.singleContentResourceId);
            if (currentPrice == null || currentPrice.isZero())
            {
                return s;
            } else
            {
                return TextUtils.join(context.getString(notificationstringresources.contentDelimiterResourceId), new String[] {
                    context.getString(notificationstringresources.singleContentResourceId), currentPrice.toString()
                });
            }
        } else
        {
            return context.getString(notificationstringresources.infiniteContentResourceId);
        }
    }

    public String getTickerString(Context context, NotificationStringResources notificationstringresources, int i)
        throws IllegalFormatConversionException
    {
        if (i < 2)
        {
            return getContentString(context, notificationstringresources, i);
        } else
        {
            return getTitleString(context, notificationstringresources, i);
        }
    }

    public String getTitleString(Context context, NotificationStringResources notificationstringresources, int i)
        throws IllegalFormatConversionException
    {
        if (i >= 2 && i <= 0x7fffffff)
        {
            return context.getString(notificationstringresources.finiteTitleResourceId, new Object[] {
                Integer.valueOf(i)
            });
        }
        if (i > 0x7fffffff)
        {
            return context.getString(notificationstringresources.infiniteTitleResourceId);
        } else
        {
            return context.getString(notificationstringresources.singleTitleResourceId, new Object[] {
                title
            });
        }
    }

    public ()
    {
    }
}
