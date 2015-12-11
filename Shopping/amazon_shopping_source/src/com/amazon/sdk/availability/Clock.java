// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.sdk.availability;

import android.content.Context;

// Referenced classes of package com.amazon.sdk.availability:
//            Preferences, Logger

public final class Clock
{

    private Clock()
    {
    }

    public static long getAdjustedTime(Context context, long l)
    {
        return getAdjustment(context) + l;
    }

    protected static long getAdjustment(Context context)
    {
        long l1 = 0L;
        long l = l1;
        if (context != null)
        {
            context = (new Preferences(context)).get("timeAdjustment");
            l = l1;
            if (context != null)
            {
                try
                {
                    l = Long.parseLong(context);
                }
                catch (NumberFormatException numberformatexception)
                {
                    Logger.e((new StringBuilder()).append("invalid adjustment time format: ").append(context).toString(), numberformatexception);
                    return 0L;
                }
            }
        }
        return l;
    }

    public static long getCurrentTime(Context context)
    {
        return System.currentTimeMillis() + getAdjustment(context);
    }

    public static void updateAdjustment(Context context, long l)
    {
        (new Preferences(context)).put("timeAdjustment", Long.toString(l - System.currentTimeMillis()));
    }
}
