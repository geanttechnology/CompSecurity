// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.SimpleTimeZone;

// Referenced classes of package com.parse:
//            PLog

class ParseImpreciseDateFormat
{

    private static final ParseImpreciseDateFormat INSTANCE = new ParseImpreciseDateFormat();
    private static final String TAG = "ParseDateFormat";
    private final DateFormat dateFormat;
    private final Object lock = new Object();

    private ParseImpreciseDateFormat()
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US);
        simpledateformat.setTimeZone(new SimpleTimeZone(0, "GMT"));
        dateFormat = simpledateformat;
    }

    public static ParseImpreciseDateFormat getInstance()
    {
        return INSTANCE;
    }

    String format(Date date)
    {
        synchronized (lock)
        {
            date = dateFormat.format(date);
        }
        return date;
        date;
        obj;
        JVM INSTR monitorexit ;
        throw date;
    }

    Date parse(String s)
    {
        obj;
        JVM INSTR monitorenter ;
        Date date;
        synchronized (lock)
        {
            date = dateFormat.parse(s);
        }
        return date;
        ParseException parseexception;
        parseexception;
        PLog.e("ParseDateFormat", (new StringBuilder()).append("could not parse date: ").append(s).toString(), parseexception);
        obj;
        JVM INSTR monitorexit ;
        return null;
        s;
        obj;
        JVM INSTR monitorexit ;
        throw s;
    }

}
