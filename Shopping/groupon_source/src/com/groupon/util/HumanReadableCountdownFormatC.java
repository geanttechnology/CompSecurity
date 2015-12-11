// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Resources;

// Referenced classes of package com.groupon.util:
//            HumanReadableCountdownFormat

public class HumanReadableCountdownFormatC extends HumanReadableCountdownFormat
{

    public HumanReadableCountdownFormatC()
    {
    }

    protected void doFormat(StringBuffer stringbuffer, int i, int j, int k, int l)
    {
        Resources resources = context.getResources();
        if (i > 15)
        {
            return;
        }
        if (i >= 1 && i <= 15)
        {
            stringbuffer.append(resources.getQuantityString(0x7f0c0024, i, new Object[] {
                Integer.valueOf(i)
            }));
            return;
        }
        if (j >= 1 && i < 1)
        {
            stringbuffer.append(resources.getQuantityString(0x7f0c000a, j, new Object[] {
                Integer.valueOf(j)
            }));
            return;
        }
        if (k >= 1 && j < 1)
        {
            stringbuffer.append(resources.getQuantityString(0x7f0c0010, k, new Object[] {
                Integer.valueOf(k)
            }));
            return;
        } else
        {
            stringbuffer.append(resources.getString(0x7f08024b));
            return;
        }
    }
}
