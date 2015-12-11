// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import java.util.Date;

// Referenced classes of package com.groupon.util:
//            HumanReadableCountdownFormat

public class HumanReadableTimerFormatExtension extends HumanReadableCountdownFormat
{

    private static final String US_CA_DATE_FORMAT = "MM/dd";
    private Context context;

    public HumanReadableTimerFormatExtension()
    {
    }

    protected void doFormat(StringBuffer stringbuffer, int i, int j, int k, int l)
    {
        int i1 = i / 365;
        int j1 = i / 30;
        Object obj = context.getResources();
        if (i1 > 0)
        {
            stringbuffer.append(((Resources) (obj)).getQuantityString(0x7f0c0020, i1, new Object[] {
                Integer.valueOf(i1)
            }));
            return;
        }
        if (j1 > 0)
        {
            stringbuffer.append(((Resources) (obj)).getQuantityString(0x7f0c0012, j1, new Object[] {
                Integer.valueOf(j1)
            }));
            return;
        }
        if (i > 0)
        {
            stringbuffer.append(((Resources) (obj)).getQuantityString(0x7f0c0006, i, new Object[] {
                Integer.valueOf(i)
            }));
            return;
        }
        if (j > 0)
        {
            stringbuffer.append(((Resources) (obj)).getQuantityString(0x7f0c0009, j, new Object[] {
                Integer.valueOf(j)
            }));
            return;
        }
        if (k > 0)
        {
            stringbuffer.append(((Resources) (obj)).getQuantityString(0x7f0c000f, k, new Object[] {
                Integer.valueOf(k)
            }));
            return;
        }
        if (l > 0)
        {
            stringbuffer.append(((Resources) (obj)).getQuantityString(0x7f0c0019, l, new Object[] {
                Integer.valueOf(l)
            }));
            return;
        }
        if (relativeTo != null)
        {
            obj = DateFormat.format("MM/dd", relativeTo.getTime());
        } else
        {
            obj = ((Resources) (obj)).getQuantityString(0x7f0c0019, l, new Object[] {
                Integer.valueOf(l)
            });
        }
        stringbuffer.append(((CharSequence) (obj)));
    }

    public String getReadableTimer(Date date)
    {
        relativeTo = date;
        return format(new Date());
    }
}
