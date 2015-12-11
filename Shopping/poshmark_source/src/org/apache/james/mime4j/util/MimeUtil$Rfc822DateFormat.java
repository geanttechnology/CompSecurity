// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.james.mime4j.util;

import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package org.apache.james.mime4j.util:
//            MimeUtil

private static final class  extends SimpleDateFormat
{

    private static final long serialVersionUID = 1L;

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        date = super.format(date, stringbuffer, fieldposition);
        int i = (calendar.get(15) + calendar.get(16)) / 1000 / 60;
        if (i < 0)
        {
            date.append('-');
            i = -i;
        } else
        {
            date.append('+');
        }
        date.append(String.format("%02d%02d", new Object[] {
            Integer.valueOf(i / 60), Integer.valueOf(i % 60)
        }));
        return date;
    }

    public ()
    {
        super("EEE, d MMM yyyy HH:mm:ss ", Locale.US);
    }
}
