// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.util:
//            HumanReadableCountdownFormat

public class HumanReadableCountdownFormatB extends HumanReadableCountdownFormat
{

    public HumanReadableCountdownFormatB()
    {
    }

    protected void doFormat(StringBuffer stringbuffer, int i, int j, int k, int l)
    {
        Object obj = context.getResources();
        String s = ((Resources) (obj)).getQuantityString(0x7f0c0004, i, new Object[] {
            Integer.valueOf(i)
        });
        if (i > 0)
        {
            stringbuffer.append(s);
            stringbuffer.append(" ");
        }
        if (Strings.equals(context.getResources().getConfiguration().locale, Locale.JAPAN))
        {
            String s1 = ((Resources) (obj)).getQuantityString(0x7f0c0007, j, new Object[] {
                Integer.valueOf(j)
            });
            String s2 = ((Resources) (obj)).getQuantityString(0x7f0c000d, k, new Object[] {
                Integer.valueOf(k)
            });
            obj = ((Resources) (obj)).getQuantityString(0x7f0c0018, l, new Object[] {
                Integer.valueOf(l)
            });
            stringbuffer.append(s1);
            stringbuffer.append(s2);
            stringbuffer.append(((String) (obj)));
            return;
        } else
        {
            stringbuffer.append((new Formatter()).format("%tT", new Object[] {
                new Date(0, 0, 0, j, k, l)
            }));
            return;
        }
    }
}
