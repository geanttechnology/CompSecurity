// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.text.TextUtils;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class atp
{

    public static final int a;
    private static final Pattern b = Pattern.compile("(\\d\\d\\d\\d)\\-(\\d\\d)\\-(\\d\\d)[Tt](\\d\\d):(\\d\\d):(\\d\\d)(\\.(\\d+))?([Zz]|((\\+|\\-)(\\d\\d):(\\d\\d)))?");
    private static final Pattern c = Pattern.compile("^(-)?P(([0-9]*)Y)?(([0-9]*)M)?(([0-9]*)D)?(T(([0-9]*)H)?(([0-9]*)M)?(([0-9.]*)S)?)?$");

    public static long a(long l, long l1, long l2)
    {
        if (l2 >= 0xf4240L && l2 % 0xf4240L == 0L)
        {
            return l / (l2 / 0xf4240L);
        }
        if (l2 < 0xf4240L && 0xf4240L % l2 == 0L)
        {
            return (0xf4240L / l2) * l;
        } else
        {
            return (long)((1000000D / (double)l2) * (double)l);
        }
    }

    public static Uri a(Uri uri, String s)
    {
        if (s == null)
        {
            return uri;
        }
        if (uri == null)
        {
            return Uri.parse(s);
        }
        if (s.startsWith("/"))
        {
            s = s.substring(1);
            return (new android.net.Uri.Builder()).scheme(uri.getScheme()).authority(uri.getAuthority()).appendEncodedPath(s).build();
        }
        Uri uri1 = Uri.parse(s);
        if (uri1.isAbsolute())
        {
            return uri1;
        } else
        {
            return Uri.withAppendedPath(uri, s);
        }
    }

    public static ExecutorService a(String s)
    {
        return Executors.newSingleThreadExecutor(new atq(s));
    }

    public static void a(art art1)
    {
        try
        {
            art1.a();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (art art1)
        {
            return;
        }
    }

    public static boolean a(Object obj, Object obj1)
    {
        if (obj == null)
        {
            return obj1 == null;
        } else
        {
            return obj.equals(obj1);
        }
    }

    public static String b(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.toLowerCase(Locale.US);
        }
    }

    public static long c(String s)
    {
        boolean flag = true;
        double d6 = 0.0D;
        Matcher matcher = c.matcher(s);
        if (matcher.matches())
        {
            double d1;
            double d2;
            double d3;
            double d4;
            double d5;
            long l;
            if (TextUtils.isEmpty(matcher.group(1)))
            {
                flag = false;
            }
            s = matcher.group(3);
            if (s != null)
            {
                d1 = Double.parseDouble(s) * 31556908D;
            } else
            {
                d1 = 0.0D;
            }
            s = matcher.group(5);
            if (s != null)
            {
                d2 = Double.parseDouble(s) * 2629739D;
            } else
            {
                d2 = 0.0D;
            }
            s = matcher.group(7);
            if (s != null)
            {
                d3 = Double.parseDouble(s) * 86400D;
            } else
            {
                d3 = 0.0D;
            }
            s = matcher.group(10);
            if (s != null)
            {
                d4 = Double.parseDouble(s) * 3600D;
            } else
            {
                d4 = 0.0D;
            }
            s = matcher.group(12);
            if (s != null)
            {
                d5 = Double.parseDouble(s) * 60D;
            } else
            {
                d5 = 0.0D;
            }
            s = matcher.group(14);
            if (s != null)
            {
                d6 = Double.parseDouble(s);
            }
            l = (long)((d5 + (d2 + d1 + d3 + d4) + d6) * 1000D);
            if (flag)
            {
                return -l;
            } else
            {
                return l;
            }
        } else
        {
            return (long)(Double.parseDouble(s) * 3600D * 1000D);
        }
    }

    public static long d(String s)
    {
        Matcher matcher = b.matcher(s);
        if (!matcher.matches())
        {
            s = String.valueOf(s);
            if (s.length() != 0)
            {
                s = "Invalid date/time format: ".concat(s);
            } else
            {
                s = new String("Invalid date/time format: ");
            }
            throw new ParseException(s, 0);
        }
        GregorianCalendar gregoriancalendar;
        int i;
        if (matcher.group(9) == null)
        {
            i = 0;
        } else
        if (matcher.group(9).equalsIgnoreCase("Z"))
        {
            i = 0;
        } else
        {
            i = Integer.parseInt(matcher.group(12)) * 60 + Integer.parseInt(matcher.group(13));
            if (matcher.group(11).equals("-"))
            {
                i = -i;
            }
        }
        gregoriancalendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        gregoriancalendar.clear();
        gregoriancalendar.set(Integer.parseInt(matcher.group(1)), Integer.parseInt(matcher.group(2)) - 1, Integer.parseInt(matcher.group(3)), Integer.parseInt(matcher.group(4)), Integer.parseInt(matcher.group(5)), Integer.parseInt(matcher.group(6)));
        if (!TextUtils.isEmpty(matcher.group(8)))
        {
            s = String.valueOf(matcher.group(8));
            long l;
            long l1;
            if (s.length() != 0)
            {
                s = "0.".concat(s);
            } else
            {
                s = new String("0.");
            }
            gregoriancalendar.set(14, (new BigDecimal(s)).movePointRight(3).intValue());
        }
        l1 = gregoriancalendar.getTimeInMillis();
        l = l1;
        if (i != 0)
        {
            l = l1 - (long)(60000 * i);
        }
        return l;
    }

    static 
    {
        a = android.os.Build.VERSION.SDK_INT;
    }
}
