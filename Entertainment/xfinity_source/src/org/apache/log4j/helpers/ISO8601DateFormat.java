// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.log4j.helpers;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;

// Referenced classes of package org.apache.log4j.helpers:
//            AbsoluteTimeDateFormat

public class ISO8601DateFormat extends AbsoluteTimeDateFormat
{

    private static long lastTime;
    private static char lastTimeString[] = new char[20];

    public ISO8601DateFormat()
    {
    }

    public StringBuffer format(Date date, StringBuffer stringbuffer, FieldPosition fieldposition)
    {
        int i;
        int j;
        long l;
        l = date.getTime();
        i = (int)(l % 1000L);
        if (l - (long)i == lastTime && lastTimeString[0] != 0)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        super.calendar.setTime(date);
        j = stringbuffer.length();
        stringbuffer.append(super.calendar.get(1));
        super.calendar.get(2);
        JVM INSTR tableswitch 0 11: default 132
    //                   0 356
    //                   1 362
    //                   2 368
    //                   3 374
    //                   4 380
    //                   5 386
    //                   6 392
    //                   7 398
    //                   8 404
    //                   9 410
    //                   10 416
    //                   11 422;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12 _L13
_L1:
        date = "-NA-";
_L14:
        stringbuffer.append(date);
        int k = super.calendar.get(5);
        if (k < 10)
        {
            stringbuffer.append('0');
        }
        stringbuffer.append(k);
        stringbuffer.append(' ');
        k = super.calendar.get(11);
        if (k < 10)
        {
            stringbuffer.append('0');
        }
        stringbuffer.append(k);
        stringbuffer.append(':');
        k = super.calendar.get(12);
        if (k < 10)
        {
            stringbuffer.append('0');
        }
        stringbuffer.append(k);
        stringbuffer.append(':');
        k = super.calendar.get(13);
        if (k < 10)
        {
            stringbuffer.append('0');
        }
        stringbuffer.append(k);
        stringbuffer.append(',');
        stringbuffer.getChars(j, stringbuffer.length(), lastTimeString, 0);
        lastTime = l - (long)i;
_L15:
        if (i < 100)
        {
            stringbuffer.append('0');
        }
        if (i < 10)
        {
            stringbuffer.append('0');
        }
        stringbuffer.append(i);
        return stringbuffer;
_L2:
        date = "-01-";
          goto _L14
_L3:
        date = "-02-";
          goto _L14
_L4:
        date = "-03-";
          goto _L14
_L5:
        date = "-04-";
          goto _L14
_L6:
        date = "-05-";
          goto _L14
_L7:
        date = "-06-";
          goto _L14
_L8:
        date = "-07-";
          goto _L14
_L9:
        date = "-08-";
          goto _L14
_L10:
        date = "-09-";
          goto _L14
_L11:
        date = "-10-";
          goto _L14
_L12:
        date = "-11-";
          goto _L14
_L13:
        date = "-12-";
          goto _L14
        stringbuffer.append(lastTimeString);
          goto _L15
    }

    public Date parse(String s, ParsePosition parseposition)
    {
        return null;
    }

}
