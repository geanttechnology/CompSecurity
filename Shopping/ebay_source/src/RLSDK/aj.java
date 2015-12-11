// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;

import java.util.Hashtable;

// Referenced classes of package RLSDK:
//            ap

public final class aj extends ap
{

    private static Hashtable a;
    private static Hashtable b;
    private final String c;

    private aj(int i, String s)
    {
        super(i);
        c = s;
    }

    public static aj a(int i)
    {
        if (a == null)
        {
            a = new Hashtable(29);
            b = new Hashtable(29);
            a(0, "Cp437");
            a(1, new String[] {
                "ISO8859_1", "ISO-8859-1"
            });
            a(2, "Cp437");
            a(3, new String[] {
                "ISO8859_1", "ISO-8859-1"
            });
            a(4, "ISO8859_2");
            a(5, "ISO8859_3");
            a(6, "ISO8859_4");
            a(7, "ISO8859_5");
            a(8, "ISO8859_6");
            a(9, "ISO8859_7");
            a(10, "ISO8859_8");
            a(11, "ISO8859_9");
            a(12, "ISO8859_10");
            a(13, "ISO8859_11");
            a(15, "ISO8859_13");
            a(16, "ISO8859_14");
            a(17, "ISO8859_15");
            a(18, "ISO8859_16");
            a(20, new String[] {
                "SJIS", "Shift_JIS"
            });
        }
        if (i < 0 || i >= 900)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad ECI value: ")).append(i).toString());
        } else
        {
            return (aj)a.get(new Integer(i));
        }
    }

    private static void a(int i, String s)
    {
        aj aj1 = new aj(i, s);
        a.put(new Integer(i), aj1);
        b.put(s, aj1);
    }

    private static void a(int i, String as[])
    {
        boolean flag = false;
        aj aj1 = new aj(i, as[0]);
        a.put(new Integer(i), aj1);
        for (i = ((flag) ? 1 : 0); i < as.length; i++)
        {
            b.put(as[i], aj1);
        }

    }

    public final String a()
    {
        return c;
    }
}
