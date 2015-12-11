// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;
import java.util.Calendar;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            CreditCard

public static class _cls9
{

    public static String format(String s)
    {
        s = CreditCard.getDigitsOnlyString(s);
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (i == 0 && c != '0' && c != '1')
            {
                stringbuilder.append('0');
                stringbuilder.append(c);
                return stringbuilder.toString();
            }
            if (i == 1 && s.charAt(0) == '1' && c > '2')
            {
                return stringbuilder.toString();
            }
            if (i == 2)
            {
                stringbuilder.append('/');
            }
            stringbuilder.append(c);
        }

        return stringbuilder.toString();
    }

    public static boolean hasFullLength(String s)
    {
        while (TextUtils.isEmpty(s) || CreditCard.getDigitsOnlyString(s).length() != 4) 
        {
            return false;
        }
        return true;
    }

    public static boolean isDateValid(int i, int j)
    {
        if (i >= 1 && 12 >= i)
        {
            Calendar calendar = Calendar.getInstance();
            int k = calendar.get(1) % 100;
            int l = calendar.get(2);
            if (j >= k && (j != k || i >= l + 1) && j <= k + 15)
            {
                return true;
            }
        }
        return false;
    }

    public static boolean isValid(String s)
    {
        if (TextUtils.isEmpty(s))
        {
            return false;
        } else
        {
            s = CreditCard.getDigitsOnlyString(s);
            return isDateValid(Integer.parseInt(s.substring(0, 2)), Integer.parseInt(s.substring(2)));
        }
    }

    public _cls9()
    {
    }
}
