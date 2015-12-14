// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.jivesoftware.smack.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package org.jivesoftware.smack.util:
//            s

public class XmppDateTime
{

    private static final DateFormatType a;
    private static final Pattern b;
    private static final DateFormatType c;
    private static final Pattern d;
    private static final DateFormatType e;
    private static final Pattern f;
    private static final DateFormatType g;
    private static final Pattern h;
    private static final DateFormatType i;
    private static final Pattern j;
    private static final DateFormatType k;
    private static final Pattern l;
    private static final DateFormatType m;
    private static final Pattern n;
    private static final DateFormat o;
    private static final DateFormat p;
    private static final DateFormat q;
    private static final DateFormat r;
    private static final Pattern s = Pattern.compile("^\\d+T\\d+:\\d+:\\d+$");
    private static final List t;

    public static String a(Date date)
    {
        synchronized (k)
        {
            date = k.a(date);
        }
        return date;
        date;
        dateformattype;
        JVM INSTR monitorexit ;
        throw date;
    }

    public static String a(TimeZone timezone)
    {
        int i1 = timezone.getRawOffset();
        int j1 = i1 / 0x36ee80;
        return String.format("%+d:%02d", new Object[] {
            Integer.valueOf(j1), Integer.valueOf(Math.abs(i1 / 60000 - j1 * 60))
        });
    }

    private static Calendar a(String s1, DateFormat dateformat)
    {
        dateformat;
        JVM INSTR monitorenter ;
        dateformat.parse(s1);
        s1 = dateformat.getCalendar();
        dateformat;
        JVM INSTR monitorexit ;
        return s1;
        s1;
        dateformat;
        JVM INSTR monitorexit ;
        try
        {
            throw s1;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            return null;
        }
    }

    private static Calendar a(Calendar calendar, List list)
    {
        Collections.sort(list, new _cls1(calendar));
        return (Calendar)list.get(0);
    }

    public static Date a(String s1)
    {
        if (s.matcher(s1).matches())
        {
            int i1 = s1.split("T")[0].length();
            if (i1 < 8)
            {
                Date date = a(s1, i1);
                if (date != null)
                {
                    return date;
                }
            } else
            {
                synchronized (o)
                {
                    s1 = o.parse(s1);
                }
                return s1;
            }
            break MISSING_BLOCK_LABEL_117;
        }
        break MISSING_BLOCK_LABEL_66;
        s1;
        dateformat;
        JVM INSTR monitorexit ;
        throw s1;
        Iterator iterator = t.iterator();
        s s2;
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_117;
            }
            s2 = (s)iterator.next();
        } while (!s2.a.matcher(s1).matches());
        return s2.b.a(s1);
        synchronized (m)
        {
            s1 = m.a(s1);
        }
        return s1;
        s1;
        dateformattype;
        JVM INSTR monitorexit ;
        throw s1;
    }

    private static Date a(String s1, int i1)
    {
        if (i1 == 6)
        {
            synchronized (p)
            {
                s1 = p.parse(s1);
            }
            return s1;
        }
        break MISSING_BLOCK_LABEL_29;
        s1;
        dateformat;
        JVM INSTR monitorexit ;
        throw s1;
        Calendar calendar = Calendar.getInstance();
        s1 = a(calendar, new Calendar[] {
            a(s1, q), a(s1, r)
        });
        if (!s1.isEmpty())
        {
            return a(calendar, ((List) (s1))).getTime();
        } else
        {
            return null;
        }
    }

    private static transient List a(Calendar calendar, Calendar acalendar[])
    {
        ArrayList arraylist = new ArrayList();
        int j1 = acalendar.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            Calendar calendar1 = acalendar[i1];
            if (calendar1 != null && calendar1.before(calendar))
            {
                arraylist.add(calendar1);
            }
        }

        return arraylist;
    }

    public static String b(String s1)
    {
        if (s1.charAt(s1.length() - 1) == 'Z')
        {
            return s1.replace("Z", "+0000");
        } else
        {
            return s1.replaceAll("([\\+\\-]\\d\\d):(\\d\\d)", "$1$2");
        }
    }

    public static String c(String s1)
    {
        int i1 = s1.length();
        String s2 = s1.substring(0, i1 - 2);
        s2 = (new StringBuilder()).append(s2).append(':').toString();
        return (new StringBuilder()).append(s2).append(s1.substring(i1 - 2, i1)).toString();
    }

    static 
    {
        a = DateFormatType.a;
        b = Pattern.compile("^\\d+-\\d+-\\d+$");
        c = DateFormatType.g;
        d = Pattern.compile("^(\\d+:){2}\\d+.\\d+(Z|([+-](\\d+:\\d+)))$");
        e = DateFormatType.f;
        f = Pattern.compile("^(\\d+:){2}\\d+.\\d+$");
        g = DateFormatType.e;
        h = Pattern.compile("^(\\d+:){2}\\d+(Z|([+-](\\d+:\\d+)))$");
        i = DateFormatType.d;
        j = Pattern.compile("^(\\d+:){2}\\d+$");
        k = DateFormatType.c;
        l = Pattern.compile("^\\d+(-\\d+){2}+T(\\d+:){2}\\d+.\\d+(Z|([+-](\\d+:\\d+)))?$");
        m = DateFormatType.b;
        n = Pattern.compile("^\\d+(-\\d+){2}+T(\\d+:){2}\\d+(Z|([+-](\\d+:\\d+)))?$");
        o = new SimpleDateFormat("yyyyMMdd'T'HH:mm:ss");
        p = new SimpleDateFormat("yyyyMd'T'HH:mm:ss");
        q = new SimpleDateFormat("yyyyMdd'T'HH:mm:ss");
        r = new SimpleDateFormat("yyyyMMd'T'HH:mm:ss");
        t = new ArrayList();
        TimeZone timezone = TimeZone.getTimeZone("UTC");
        o.setTimeZone(timezone);
        p.setTimeZone(timezone);
        q.setTimeZone(timezone);
        q.setLenient(false);
        r.setTimeZone(timezone);
        r.setLenient(false);
        t.add(new s(b, a));
        t.add(new s(l, k));
        t.add(new s(n, m));
        t.add(new s(d, c));
        t.add(new s(f, e));
        t.add(new s(h, g));
        t.add(new s(j, i));
    }

    /* member class not found */
    class DateFormatType {}


    /* member class not found */
    class _cls1 {}

}
