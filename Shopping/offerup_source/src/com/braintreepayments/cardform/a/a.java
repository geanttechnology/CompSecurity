// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.braintreepayments.cardform.a;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class a extends Enum
{

    public static final a a;
    public static final a b;
    private static a c;
    private static a d;
    private static a e;
    private static a f;
    private static a g;
    private static a h;
    private static a i;
    private static final int j[] = {
        4, 10
    };
    private static final int k[] = {
        4, 8, 12
    };
    private static final a q[];
    private final Pattern l;
    private final int m;
    private final int n;
    private final int o;
    private final int p;

    private a(String s, int i1, String s1, int j1, int k1, int l1, int i2)
    {
        super(s, i1);
        l = Pattern.compile(s1);
        m = j1;
        n = k1;
        o = l1;
        p = i2;
    }

    public static a b(String s)
    {
        a aa[] = values();
        int j1 = aa.length;
        for (int i1 = 0; i1 < j1; i1++)
        {
            a a1 = aa[i1];
            if (a1.l.matcher(s).matches())
            {
                return a1;
            }
        }

        return b;
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/braintreepayments/cardform/a/a, s);
    }

    public static a[] values()
    {
        return (a[])q.clone();
    }

    public final int a()
    {
        return m;
    }

    public final boolean a(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        }
        int i1 = s.length();
        if (i1 < n || i1 > o)
        {
            return false;
        }
        if (!l.matcher(s).matches())
        {
            return false;
        }
        s = (new StringBuffer(s)).reverse().toString();
        int l1 = s.length();
        i1 = 0;
        int k1 = 0;
        int j1 = 0;
        while (i1 < l1) 
        {
            char c1 = s.charAt(i1);
            if (!Character.isDigit(c1))
            {
                throw new IllegalArgumentException(String.format("Not a digit: '%s'", new Object[] {
                    Character.valueOf(c1)
                }));
            }
            int i2 = Character.digit(c1, 10);
            if (i1 % 2 == 0)
            {
                j1 += i2;
            } else
            {
                k1 += (i2 * 2) % 10 + i2 / 5;
            }
            i1++;
        }
        return (k1 + j1) % 10 == 0;
    }

    public final int b()
    {
        return p;
    }

    public final int c()
    {
        return o;
    }

    public final int[] d()
    {
        if (this == a)
        {
            return j;
        } else
        {
            return k;
        }
    }

    static 
    {
        c = new a("VISA", 0, "^4\\d*", 0x7f0200a0, 16, 16, 3);
        d = new a("MASTERCARD", 1, "^5[1-5]\\d*", 0x7f020098, 16, 16, 3);
        e = new a("DISCOVER", 2, "^(6011|65|64[4-9]|622)\\d*", 0x7f02008e, 16, 16, 3);
        a = new a("AMEX", 3, "^3[47]\\d*", 0x7f020087, 15, 15, 4);
        f = new a("DINERS_CLUB", 4, "^(36|38|30[0-5])\\d*", 0x7f02008d, 14, 14, 3);
        g = new a("JCB", 5, "^35\\d*", 0x7f020090, 16, 16, 3);
        h = new a("MAESTRO", 6, "^(5018|5020|5038|6304|6759|676[1-3])\\d*", 0x7f020097, 12, 19, 3);
        i = new a("UNION_PAY", 7, "^62\\d*", 0x7f020089, 16, 19, 3);
        b = new a("UNKNOWN", 8, "", 0x7f020089, 12, 19, 3);
        q = (new a[] {
            c, d, e, a, f, g, h, i, b
        });
    }
}
