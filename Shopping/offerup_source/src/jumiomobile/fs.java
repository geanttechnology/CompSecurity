// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;

import com.jumio.netswipe.sdk.enums.CreditCardType;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package jumiomobile:
//            ft

public class fs
{

    private static int a = 6;
    private static int b = 4;
    private static Pattern c = Pattern.compile("^(34|37)\\d{0,13}$");
    private static Pattern d = Pattern.compile("^(34|37)\\d{13}$");
    private static Pattern e = Pattern.compile("^(62(([4-6]\\d{0,13})|(8[2-8]\\d{0,12})|(2((12[6-9])|(1[3-9][0-9])|([2-8][0-9]{2})|(9(((0|1)[0-9])|(2[0-5]))))\\d{0,10})))$");
    private static Pattern f = Pattern.compile("^(62(([4-6]\\d{13})|(8[2-8]\\d{12})|(2((12[6-9])|(1[3-9][0-9])|([2-8][0-9]{2})|(9(((0|1)[0-9])|(2[0-5]))))\\d{10})))$");
    private static Pattern g = Pattern.compile("^((36\\d{0,12})|((38|39)\\d{0,14})|(3095\\d{0,12})|(30[0-5]\\d{0,13}))$");
    private static Pattern h = Pattern.compile("^((36\\d{12})|((38|39)\\d{14})|(3095\\d{12})|(30[0-5]\\d{13}))$");
    private static Pattern i = Pattern.compile("^((6011(0[0-9]|[2-4][0-9]|7(4|[7-9])|8[6-9]|9[0-9])\\d{0,10})|(64([4-9])\\d{0,13})|(65\\d{0,14}))$");
    private static Pattern j = Pattern.compile("^((6011(0[0-9]|[2-4][0-9]|7(4|[7-9])|8[6-9]|9[0-9])\\d{10})|(64([4-9])\\d{13})|(65\\d{14}))$");
    private static Pattern k = Pattern.compile("^(((1800|2131)\\d{0,11})|(35((2[8,9])|([3-8][0-9]))\\d{0,12}))$");
    private static Pattern l = Pattern.compile("^(((1800|2131)\\d{11})|(35((2[8,9])|([3-8][0-9]))\\d{12}))$");
    private static Pattern m = Pattern.compile("^5[1-5]\\d{0,14}$");
    private static Pattern n = Pattern.compile("^5[1-5]\\d{14}$");
    private static Pattern o = Pattern.compile("^4\\d{0,15}$");
    private static Pattern p = Pattern.compile("^4\\d{15}$");
    private static Pattern q = Pattern.compile("^(504662|602052|603009|603459|603460|603461|603462|603464|601917|601918|601919|601920|601921)\\d{0,10}$");
    private static Pattern r = Pattern.compile("^(504662|602052|603009|603459|603460|603461|603462|603464|601917|601918|601919|601920|601921)\\d{10}$");

    public static int a(StringBuilder stringbuilder, boolean flag, CreditCardType creditcardtype)
    {
        byte byte1 = 2;
        byte byte0 = 3;
        boolean flag1 = false;
        switch (ft.a[creditcardtype.ordinal()])
        {
        default:
            return 16;

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 7: // '\007'
            if (!flag)
            {
                byte0 = 0;
            }
            return byte0 + 16;

        case 8: // '\b'
            byte0 = flag1;
            if (flag)
            {
                byte0 = 2;
            }
            return byte0 + 15;

        case 6: // '\006'
            if (stringbuilder.subSequence(0, 4).equals("2131") || stringbuilder.subSequence(0, 4).equals("1800"))
            {
                if (!flag)
                {
                    byte0 = 0;
                }
                return byte0 + 15;
            }
            if (!flag)
            {
                byte0 = 0;
            }
            return byte0 + 16;

        case 9: // '\t'
            break;
        }
        if (stringbuilder.subSequence(0, 2).equals("36"))
        {
            if (flag)
            {
                byte0 = byte1;
            } else
            {
                byte0 = 0;
            }
            return byte0 + 14;
        }
        if (!flag)
        {
            byte0 = 0;
        }
        return byte0 + 16;
    }

    public static String a()
    {
        String s = (new SimpleDateFormat("MM", Locale.getDefault())).format(new Date());
        String s2 = (new SimpleDateFormat("yy", Locale.getDefault())).format(new Date());
        String s1;
        String s3;
        int i1;
        if (Integer.valueOf(s).intValue() > 9)
        {
            s = (new StringBuilder()).append("((").append("(1[").append(s.charAt(1)).append("-2])").toString();
        } else
        {
            s = (new StringBuilder()).append("((").append("(0[").append(s.charAt(1)).append("-9]|1[0-2])").toString();
        }
        s3 = (new StringBuilder()).append(s).append("\\s/\\s").toString();
        s1 = String.valueOf(Integer.valueOf(s2).intValue() + 1);
        s = s1;
        if (s1.length() == 1)
        {
            s = (new StringBuilder("0")).append(s1).toString();
        }
        i1 = Integer.valueOf(s2).intValue();
        s1 = (new StringBuilder()).append(s3).append("(").append(s2).append(")").toString();
        s1 = (new StringBuilder()).append(s1).append(")|(").toString();
        s1 = (new StringBuilder()).append(s1).append("(0[1-9]|1[0-2])").toString();
        s1 = (new StringBuilder()).append(s1).append("\\s/\\s").toString();
        s = (new StringBuilder()).append(s1).append("(").append(s.charAt(0)).append("[").append(s.charAt(1)).append("-9]|[").append(String.valueOf(i1 + 10).charAt(0)).append("-9][0-9])").toString();
        return (new StringBuilder()).append(s).append("))").toString();
    }

    public static void a(StringBuilder stringbuilder)
    {
        a(stringbuilder, b(stringbuilder));
    }

    public static void a(StringBuilder stringbuilder, CreditCardType creditcardtype)
    {
        if (stringbuilder != null && stringbuilder.length() >= 4) goto _L2; else goto _L1
_L1:
        return;
_L2:
        h(stringbuilder);
        ft.a[creditcardtype.ordinal()];
        JVM INSTR tableswitch 1 9: default 76
    //                   1 107
    //                   2 107
    //                   3 107
    //                   4 107
    //                   5 107
    //                   6 107
    //                   7 107
    //                   8 114
    //                   9 121;
           goto _L3 _L4 _L4 _L4 _L4 _L4 _L4 _L4 _L5 _L6
_L6:
        break MISSING_BLOCK_LABEL_121;
_L3:
        break; /* Loop/switch isn't completed */
_L4:
        break; /* Loop/switch isn't completed */
_L8:
        if (stringbuilder.charAt(stringbuilder.length() - 1) == ' ')
        {
            stringbuilder.delete(stringbuilder.length() - 1, stringbuilder.length());
            return;
        }
        if (true) goto _L1; else goto _L7
_L7:
        f(stringbuilder);
          goto _L8
_L5:
        g(stringbuilder);
          goto _L8
        if (stringbuilder.subSequence(0, 2).equals("36"))
        {
            g(stringbuilder);
        } else
        {
            f(stringbuilder);
        }
          goto _L8
    }

    public static CreditCardType b(StringBuilder stringbuilder)
    {
        h(stringbuilder);
        if (stringbuilder.length() < 2)
        {
            return CreditCardType.UNKNOWN;
        }
        if (o.matcher(stringbuilder).matches())
        {
            return CreditCardType.VISA;
        }
        if (m.matcher(stringbuilder).matches())
        {
            return CreditCardType.MASTER_CARD;
        }
        if (c.matcher(stringbuilder).matches())
        {
            return CreditCardType.AMERICAN_EXPRESS;
        }
        if (e.matcher(stringbuilder).matches())
        {
            return CreditCardType.CHINA_UNIONPAY;
        }
        if (k.matcher(stringbuilder).matches())
        {
            return CreditCardType.JCB;
        }
        if (g.matcher(stringbuilder).matches())
        {
            return CreditCardType.DINERS_CLUB;
        }
        if (i.matcher(stringbuilder).matches())
        {
            return CreditCardType.DISCOVER;
        }
        if (q.matcher(stringbuilder).matches())
        {
            return CreditCardType.PRIVATE_LABEL;
        } else
        {
            return CreditCardType.UNKNOWN;
        }
    }

    public static boolean c(StringBuilder stringbuilder)
    {
        return p.matcher(stringbuilder).matches() || n.matcher(stringbuilder).matches() || d.matcher(stringbuilder).matches() || f.matcher(stringbuilder).matches() || l.matcher(stringbuilder).matches() || h.matcher(stringbuilder).matches() || j.matcher(stringbuilder).matches() || r.matcher(stringbuilder).matches();
    }

    public static boolean d(StringBuilder stringbuilder)
    {
        boolean flag = false;
        StringBuilder stringbuilder1 = new StringBuilder();
        stringbuilder1.append(stringbuilder);
        h(stringbuilder1);
        stringbuilder1.reverse();
        int k1 = 0;
        int i1 = 0;
        int j1 = 0;
        while (k1 < stringbuilder1.length()) 
        {
            int j2 = Character.digit(stringbuilder1.charAt(k1), 10);
            int l1;
            if (k1 % 2 == 0)
            {
                l1 = j1 + j2;
            } else
            {
                int i2 = i1 + j2 * 2;
                i1 = i2;
                l1 = j1;
                if (j2 >= 5)
                {
                    i1 = i2 - 9;
                    l1 = j1;
                }
            }
            k1++;
            j1 = l1;
        }
        stringbuilder1.delete(0, stringbuilder1.length());
        if ((j1 + i1) % 10 == 0)
        {
            flag = true;
        }
        return flag;
    }

    public static void e(StringBuilder stringbuilder)
    {
        h(stringbuilder);
        for (int i1 = a; i1 < stringbuilder.length() - b; i1++)
        {
            if (stringbuilder.charAt(i1) != ' ')
            {
                stringbuilder.setCharAt(i1, 'X');
            }
        }

    }

    private static void f(StringBuilder stringbuilder)
    {
        int j1 = stringbuilder.length() / 4;
        for (int i1 = 1; i1 <= j1; i1++)
        {
            stringbuilder.insert((i1 * 4 + i1) - 1, " ");
        }

    }

    private static void g(StringBuilder stringbuilder)
    {
        if (stringbuilder.length() > 10)
        {
            stringbuilder.insert(10, " ");
        }
        if (stringbuilder.length() > 4)
        {
            stringbuilder.insert(4, " ");
        }
    }

    private static void h(StringBuilder stringbuilder)
    {
        do
        {
            int i1 = stringbuilder.indexOf(" ");
            if (i1 >= 0)
            {
                stringbuilder.delete(i1, i1 + 1);
            } else
            {
                return;
            }
        } while (true);
    }

}
