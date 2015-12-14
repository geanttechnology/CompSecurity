// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.thisday;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.senna.model.ContactInfo;
import java.util.Calendar;

// Referenced classes of package com.amazon.gallery.thor.thisday:
//            ThisDaySharedPrefsManager

public class ThisDayUtils
{

    private static final String TAG = com/amazon/gallery/thor/thisday/ThisDayUtils.getName();

    private ThisDayUtils()
    {
    }

    public static String getDateString(Context context)
    {
        return DateUtils.formatDateTime(context, getThisDayDate(context).getTimeInMillis(), 24);
    }

    public static String getDateStringLong(Context context, long l)
    {
        if (l <= 0L)
        {
            return "";
        } else
        {
            return DateUtils.formatDateTime(context, l, 16);
        }
    }

    public static String getSubTitleForThisDayCollectionView(Context context, int i)
    {
        String s1 = getDateString(context);
        String s = s1;
        switch (i)
        {
        default:
            s = "";
            // fall through

        case 0: // '\0'
            return s;

        case 1: // '\001'
            return context.getResources().getString(0x7f0e021b, new Object[] {
                s1
            });

        case 2: // '\002'
            return "";
        }
    }

    public static Calendar getThisDayDate(Context context)
    {
        return Calendar.getInstance();
    }

    public static String getTitleForThisDayCard(Context context, int i)
    {
        int j = Calendar.getInstance().get(1);
        if (j > i)
        {
            i = j - i;
            if (i > 1)
            {
                return context.getResources().getString(0x7f0e021c, new Object[] {
                    Integer.valueOf(i)
                });
            } else
            {
                return context.getResources().getString(0x7f0e0213);
            }
        } else
        {
            return context.getResources().getString(0x7f0e0164);
        }
    }

    public static String getTitleForThisDayCollectionView(Context context)
    {
        return context.getResources().getString(0x7f0e0164);
    }

    public static void prefetchCustomerEmailAddress(Context context, RestClient restclient)
    {
        try
        {
            restclient = restclient.getContactInfo();
            NetworkExecutor.getInstance().executeForeground(restclient, new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler(context) {

                final Context val$context;

                public void onFailure(TerminalException terminalexception)
                {
                }

                public void onSuccess(ContactInfo contactinfo)
                {
                    (new ThisDaySharedPrefsManager(context)).setCustomerEmailAddress(contactinfo.getEmail());
                }

                public volatile void onSuccess(Object obj)
                {
                    onSuccess((ContactInfo)obj);
                }

            
            {
                context = context1;
                super();
            }
            });
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            GLogger.ex(TAG, "Failed to get contact info", context);
        }
    }

}
