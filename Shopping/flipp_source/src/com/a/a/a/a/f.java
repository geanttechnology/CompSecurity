// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

// Referenced classes of package com.a.a.a.a:
//            g

final class f
{

    private static final ThreadLocal a = new g();
    private static final String b[] = {
        "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", 
        "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"
    };
    private static final DateFormat c[] = new DateFormat[14];

    public static String a(Date date)
    {
        return ((DateFormat)a.get()).format(date);
    }

    public static Date a(String s)
    {
        Object obj = ((DateFormat)a.get()).parse(s);
        return ((Date) (obj));
        ParseException parseexception;
        parseexception;
        String as[] = b;
        as;
        JVM INSTR monitorenter ;
        int j = b.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        DateFormat dateformat = c[i];
        parseexception = dateformat;
        if (dateformat != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        parseexception = new SimpleDateFormat(b[i], Locale.US);
        c[i] = parseexception;
        parseexception = parseexception.parse(s);
        as;
        JVM INSTR monitorexit ;
        return parseexception;
        s;
        as;
        JVM INSTR monitorexit ;
        throw s;
        parseexception;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        as;
        JVM INSTR monitorexit ;
        return null;
    }

}
