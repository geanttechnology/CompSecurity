// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import android.text.TextUtils;
import java.text.CharacterIterator;
import java.text.StringCharacterIterator;

// Referenced classes of package com.ebay.nautilus.domain.data:
//            CreditCard

public static class 
{

    private static String formatFifteenString(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            if (i == 4 || i == 10)
            {
                stringbuilder.append(' ');
            }
            stringbuilder.append(s.charAt(i));
        }

        return stringbuilder.toString();
    }

    private static String formatSixteenString(String s)
    {
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
        {
            if (i != 0 && i % 4 == 0)
            {
                stringbuilder.append(' ');
            }
            stringbuilder.append(s.charAt(i));
        }

        return stringbuilder.toString();
    }

    public static String formatString(String s)
    {
        return formatString(s, true, null);
    }

    public static String formatString(String s, boolean flag, formatString formatstring)
    {
        String s1;
        formatString formatstring1;
        int i;
        if (flag)
        {
            s1 = CreditCard.getDigitsOnlyString(s);
        } else
        {
            s1 = s;
        }
        formatstring1 = formatstring;
        if (formatstring == null)
        {
            formatstring1 = omCardNumber(s1);
        }
        i = formatstring1.mberLength();
        formatstring = s;
        if (s1.length() > 0)
        {
            if (i == 16)
            {
                formatstring = formatSixteenString(s1);
            } else
            {
                formatstring = s;
                if (i == 15)
                {
                    return formatFifteenString(s1);
                }
            }
        }
        return formatstring;
    }

    public static boolean hasFullLength(String s)
    {
        if (!TextUtils.isEmpty(s))
        {
            s = CreditCard.getDigitsOnlyString(s);
            formatFifteenString formatfifteenstring = omCardNumber(s);
            if (s.length() == formatfifteenstring.mberLength())
            {
                return true;
            }
        }
        return false;
    }

    public static boolean passesLuhnChecksum(String s)
    {
        boolean flag = true;
        if (!TextUtils.isEmpty(s)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j;
        Object obj = CreditCard.getDigitsOnlyString(s);
        j = 0;
        s = (new int[] {
            0, 1, 2, 3, 4, 5, 6, 7, 8, 9
        });
        int ai[] = {
            0, 2, 4, 6, 8, 1, 3, 5, 7, 9
        };
        obj = new StringCharacterIterator(((String) (obj)));
        char c = ((CharacterIterator) (obj)).last();
        int i = 0;
label0:
        do
        {
label1:
            {
                if (c == '\uFFFF')
                {
                    break label1;
                }
                if (!Character.isDigit(c))
                {
                    break label0;
                }
                j += (new int[][] {
                    s, ai
                })[i & 1][c - 48];
                c = ((CharacterIterator) (obj)).previous();
                i++;
            }
        } while (true);
        if (true) goto _L1; else goto _L3
_L3:
        if (j % 10 != 0)
        {
            flag = false;
        }
        return flag;
    }

    public ()
    {
    }
}
