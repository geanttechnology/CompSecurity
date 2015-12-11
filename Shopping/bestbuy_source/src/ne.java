// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.text.SimpleDateFormat;
import java.util.Date;

public class ne
{

    public static long a(String s, String s1)
    {
label0:
        {
            String s2 = (new StringBuilder()).append(s).append(" ").append(d(s1)).toString();
            s1 = null;
            if (!s2.contains("am"))
            {
                s = s2;
                if (!s2.contains("pm"))
                {
                    break label0;
                }
            }
            s = s2.replace("am", "").replace("pm", "");
        }
        try
        {
            s = a(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s = s1;
        }
        return s.getTime();
    }

    public static String a()
    {
        return (new SimpleDateFormat("MM/dd/yyyy")).format(new Date());
    }

    public static String a(String s, Date date)
    {
        return (new SimpleDateFormat(s)).format(date);
    }

    public static Date a(String s)
    {
        return (new SimpleDateFormat("MM/dd/yyyy hh:mm a")).parse(s);
    }

    public static Date b(String s)
    {
        SimpleDateFormat simpledateformat = new SimpleDateFormat("MM/dd/yyyy");
        try
        {
            s = simpledateformat.parse(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            kf.a("Date Time Convertion : ", s);
            return null;
        }
        return s;
    }

    public static String c(String s)
    {
        return a(s, new Date());
    }

    private static String d(String s)
    {
        String s1 = "";
        if (s.contains("am") || s.contains("pm"))
        {
            s1 = s.replace("am", " AM").replace("pm", " PM");
        }
        return s1;
    }
}
