// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.util;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import b.a.a.a.f;
import b.a.a.ad;
import b.a.a.d.a;
import b.a.a.d.aa;
import b.a.a.d.d;
import com.wishabi.flipp.app.FlippApplication;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

// Referenced classes of package com.wishabi.flipp.util:
//            k, g

public final class q
{

    private static final d a = aa.a();

    public static Spanned a(String s, boolean flag)
    {
        Object obj = Locale.getDefault().toString();
        if (((String) (obj)).equals("en_US") || ((String) (obj)).equals("es_US") || ((String) (obj)).equals("en_CA") || ((String) (obj)).equals("fr_CA")) goto _L2; else goto _L1
_L1:
        Object obj1 = new SpannedString(s);
_L8:
        return ((Spanned) (obj1));
_L2:
        boolean flag1 = ((String) (obj)).equals("fr_CA");
        BigDecimal bigdecimal;
        DecimalFormat decimalformat;
        DecimalFormat decimalformat1;
        obj = new DecimalFormatSymbols();
        ((DecimalFormatSymbols) (obj)).setDecimalSeparator('.');
        ((DecimalFormatSymbols) (obj)).setMonetaryDecimalSeparator('.');
        obj1 = new DecimalFormat();
        ((DecimalFormat) (obj1)).setDecimalFormatSymbols(((DecimalFormatSymbols) (obj)));
        ((DecimalFormat) (obj1)).setParseBigDecimal(true);
        obj1 = (BigDecimal)((DecimalFormat) (obj1)).parse(s);
        obj = new BigDecimal(100);
        bigdecimal = ((BigDecimal) (obj1)).multiply(((BigDecimal) (obj)));
        obj1 = bigdecimal.remainder(((BigDecimal) (obj)));
        bigdecimal = bigdecimal.divideToIntegralValue(((BigDecimal) (obj)));
        decimalformat = new DecimalFormat();
        decimalformat.setMinimumIntegerDigits(2);
        decimalformat1 = new DecimalFormat();
        decimalformat1.setGroupingSize(3);
        decimalformat1.setGroupingUsed(true);
        if (!flag1) goto _L4; else goto _L3
_L3:
        obj = new SpannableStringBuilder();
_L9:
        ((SpannableStringBuilder) (obj)).append(decimalformat1.format(bigdecimal.toBigIntegerExact()));
        if (!flag) goto _L6; else goto _L5
_L5:
        int i = ((SpannableStringBuilder) (obj)).length();
        ((SpannableStringBuilder) (obj)).append(decimalformat.format(((BigDecimal) (obj1)).toBigIntegerExact()));
        int j = ((SpannableStringBuilder) (obj)).length();
        ((SpannableStringBuilder) (obj)).setSpan(new StringHelper._cls1(), i, j, 33);
_L10:
        obj1 = obj;
        if (!flag1) goto _L8; else goto _L7
_L7:
        ((SpannableStringBuilder) (obj)).append("$");
        return ((Spanned) (obj));
        obj;
_L11:
        if (flag1)
        {
            return new SpannedString((new StringBuilder()).append(s).append("$").toString());
        } else
        {
            return new SpannedString((new StringBuilder("$")).append(s).toString());
        }
_L4:
        obj = new SpannableStringBuilder("$");
          goto _L9
_L6:
        ((SpannableStringBuilder) (obj)).append(".");
        ((SpannableStringBuilder) (obj)).append(decimalformat.format(((BigDecimal) (obj1)).toBigIntegerExact()));
          goto _L10
        ArithmeticException arithmeticexception;
        arithmeticexception;
          goto _L11
    }

    public static String a()
    {
        Context context = FlippApplication.b();
        if (context == null)
        {
            return null;
        }
        String s = com.wishabi.flipp.util.k.a(null);
        if (k.b(s))
        {
            return context.getString(0x7f0e00bc);
        }
        if (k.c(s))
        {
            return context.getString(0x7f0e015c);
        } else
        {
            return context.getString(0x7f0e00bc);
        }
    }

    public static String a(double d1)
    {
        return a(Double.toString(d1), false).toString();
    }

    public static String a(float f1)
    {
        return a(Float.toString(f1), false).toString();
    }

    public static String a(String s)
    {
        s = s.split(" ");
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length; i++)
        {
            String s1 = s[i];
            if (s1.isEmpty())
            {
                continue;
            }
            stringbuilder.append(Character.toUpperCase(s1.charAt(0)));
            if (s1.length() > 1)
            {
                stringbuilder.append(s[i].substring(1).toLowerCase());
            }
            if (i < s.length - 1)
            {
                stringbuilder.append(' ');
            }
        }

        return stringbuilder.toString();
    }

    public static String a(String s, int i, String s1)
    {
        String s2 = "";
        for (int j = 1; j <= i; j++)
        {
            String s3 = (new StringBuilder()).append(s2).append(s).toString();
            s2 = s3;
            if (j < i)
            {
                s2 = (new StringBuilder()).append(s3).append(s1).toString();
            }
        }

        return s2;
    }

    public static String a(String s, String s1)
    {
        if (TextUtils.isEmpty(s) || TextUtils.isEmpty(s1))
        {
            return null;
        }
        d d1 = aa.a();
        b.a.a.b b1 = d1.a(s);
        s1 = d1.a(s1);
        int i = ((f) (ad.a(s1, b1))).p;
        if (Locale.getDefault().equals(Locale.CANADA_FRENCH))
        {
            if (i != 0)
            {
                s = "yyyy-MM-dd";
            } else
            {
                s = "dd MMM";
            }
        } else
        if (i != 0)
        {
            s = "yyyy-MM-dd";
        } else
        {
            s = "MMM dd";
        }
        s = b.a.a.d.a.a(s).a(com.wishabi.flipp.util.g.a);
        return FlippApplication.b().getString(0x7f0e0088, new Object[] {
            s.a(b1), s.a(s1)
        });
    }

    public static String a(List list, String s)
    {
        boolean flag1 = true;
        boolean flag = false;
        if (list.isEmpty())
        {
            return null;
        }
        int j = list.size();
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(list.get(0));
        int i = ((flag1) ? 1 : 0);
        if (!TextUtils.isEmpty(s))
        {
            flag = true;
            i = ((flag1) ? 1 : 0);
        }
        for (; i < j; i++)
        {
            if (flag)
            {
                stringbuilder.append(s);
            }
            stringbuilder.append(list.get(i));
        }

        return stringbuilder.toString();
    }

    public static String a(int ai[], String s)
    {
        boolean flag1 = true;
        boolean flag = false;
        int j = ai.length;
        if (j == 0)
        {
            return null;
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(ai[0]);
        int i = ((flag1) ? 1 : 0);
        if (!TextUtils.isEmpty(s))
        {
            flag = true;
            i = ((flag1) ? 1 : 0);
        }
        for (; i < j; i++)
        {
            if (flag)
            {
                stringbuilder.append(s);
            }
            stringbuilder.append(ai[i]);
        }

        return stringbuilder.toString();
    }

    public static boolean a(String as[])
    {
        if (as.length != 0) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = as.length;
        int i = 0;
label0:
        do
        {
label1:
            {
                if (i >= j)
                {
                    break label1;
                }
                if (!b(as[i]))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

    public static String[] a(List list)
    {
        String as[] = new String[list.size()];
        int i = 0;
        for (list = list.iterator(); list.hasNext();)
        {
            as[i] = list.next().toString();
            i++;
        }

        return as;
    }

    public static String[] a(int ai[])
    {
        if (ai == null)
        {
            return null;
        }
        String as[] = new String[ai.length];
        for (int i = 0; i < ai.length; i++)
        {
            as[i] = Integer.toString(ai[i]);
        }

        return as;
    }

    public static String[] a(long al[])
    {
        if (al == null)
        {
            return null;
        }
        String as[] = new String[al.length];
        for (int i = 0; i < al.length; i++)
        {
            as[i] = Long.toString(al[i]);
        }

        return as;
    }

    public static String b()
    {
        Context context = FlippApplication.b();
        if (context == null)
        {
            return null;
        }
        String s = com.wishabi.flipp.util.k.a(null);
        if (k.b(s))
        {
            return context.getString(0x7f0e00be);
        }
        if (k.c(s))
        {
            return context.getString(0x7f0e015d);
        } else
        {
            return context.getString(0x7f0e00be);
        }
    }

    public static boolean b(String s)
    {
        try
        {
            Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public static boolean c(String s)
    {
        try
        {
            Double.parseDouble(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public static boolean d(String s)
    {
        try
        {
            Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public static String e(String s)
    {
        String s1;
        b.a.a.i i;
        if (Locale.getDefault().equals(Locale.CANADA_FRENCH))
        {
            s1 = "dd MMM, yyyy";
        } else
        {
            s1 = "MMM dd, yyyy";
        }
        i = com.wishabi.flipp.util.g.a;
        if (TextUtils.isEmpty(s))
        {
            return null;
        }
        if (TextUtils.isEmpty(s1))
        {
            return null;
        }
        if (i == null)
        {
            return null;
        } else
        {
            s = a.a(s);
            return b.a.a.d.a.a(s1).a(i).a(s);
        }
    }

}
