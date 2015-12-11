// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.text.format.DateFormat;
import java.util.Date;

// Referenced classes of package com.groupon.util:
//            HumanReadableCountdownFormat

public class HumanReadableTimerFormat extends HumanReadableCountdownFormat
{

    private static final int DAYS_LIMIT_TIMER_FORMAT = 7;
    private static final String US_CA_DATE_FORMAT = "MM/dd";
    private Context context;

    public HumanReadableTimerFormat()
    {
    }

    protected void doFormat(StringBuffer stringbuffer, int i, int j, int k, int l)
    {
        if (i > 0)
        {
            Object obj;
            if (i > 7 && relativeTo != null)
            {
                obj = DateFormat.format("MM/dd", relativeTo.getTime());
            } else
            {
                obj = context.getString(0x7f08011f, new Object[] {
                    String.valueOf(i)
                });
            }
            stringbuffer.append(((CharSequence) (obj)));
            return;
        }
        if (j > 0)
        {
            stringbuffer.append(context.getString(0x7f08022b, new Object[] {
                String.valueOf(j)
            }));
            return;
        }
        if (k > 0)
        {
            stringbuffer.append(context.getString(0x7f08026a, new Object[] {
                String.valueOf(k)
            }));
            return;
        }
        if (l > 0)
        {
            stringbuffer.append(context.getString(0x7f080349, new Object[] {
                String.valueOf(l)
            }));
            return;
        } else
        {
            stringbuffer.append(context.getString(0x7f080349, new Object[] {
                String.valueOf(l)
            }));
            return;
        }
    }

    public String getReadableTimer(Date date)
    {
        relativeTo = date;
        return format(new Date());
    }
}
