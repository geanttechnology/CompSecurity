// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.i;

import android.util.Log;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class h
{

    public static final SimpleDateFormat a;
    public static final SimpleDateFormat b = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    public static final SimpleDateFormat c = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
    public static final SimpleDateFormat d;
    public static final SimpleDateFormat e = new SimpleDateFormat("dd-MMM-yyyy HH:mm");
    public static final DecimalFormat f;

    public static String a(SimpleDateFormat simpledateformat, String s, int i)
    {
        try
        {
            simpledateformat = simpledateformat.parse(s);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(simpledateformat);
            simpledateformat = new Date(calendar.getTimeInMillis() + (long)i);
            simpledateformat = d.format(simpledateformat);
        }
        // Misplaced declaration of an exception variable
        catch (SimpleDateFormat simpledateformat)
        {
            Log.d("HelpShiftDebug", "addMilliSeconds : ", simpledateformat);
            return s;
        }
        return simpledateformat;
    }

    static 
    {
        a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        d = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        f = new DecimalFormat("0.000", new DecimalFormatSymbols(Locale.US));
        a.setTimeZone(TimeZone.getTimeZone("GMT"));
        d.setTimeZone(TimeZone.getTimeZone("GMT"));
    }
}
