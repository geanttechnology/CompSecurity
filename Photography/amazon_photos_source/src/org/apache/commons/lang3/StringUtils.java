// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

// Referenced classes of package org.apache.commons.lang3:
//            CharSequenceUtils, ArrayUtils

public class StringUtils
{

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("(?: |\\u00A0|\\s|[\\s&&[^ ]])\\s*");

    public static boolean contains(CharSequence charsequence, CharSequence charsequence1)
    {
        while (charsequence == null || charsequence1 == null || CharSequenceUtils.indexOf(charsequence, charsequence1, 0) < 0) 
        {
            return false;
        }
        return true;
    }

    public static boolean equals(CharSequence charsequence, CharSequence charsequence1)
    {
        boolean flag1 = false;
        boolean flag;
        if (charsequence == charsequence1)
        {
            flag = true;
        } else
        {
            flag = flag1;
            if (charsequence != null)
            {
                flag = flag1;
                if (charsequence1 != null)
                {
                    if ((charsequence instanceof String) && (charsequence1 instanceof String))
                    {
                        return charsequence.equals(charsequence1);
                    } else
                    {
                        return CharSequenceUtils.regionMatches(charsequence, false, 0, charsequence1, 0, Math.max(charsequence.length(), charsequence1.length()));
                    }
                }
            }
        }
        return flag;
    }

    public static boolean equalsIgnoreCase(CharSequence charsequence, CharSequence charsequence1)
    {
        if (charsequence != null && charsequence1 != null) goto _L2; else goto _L1
_L1:
        if (charsequence != charsequence1) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (charsequence != charsequence1)
        {
            if (charsequence.length() != charsequence1.length())
            {
                return false;
            } else
            {
                return CharSequenceUtils.regionMatches(charsequence, true, 0, charsequence1, 0, charsequence.length());
            }
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public static boolean isBlank(CharSequence charsequence)
    {
        if (charsequence != null)
        {
            int j = charsequence.length();
            if (j != 0)
            {
                int i = 0;
                while (i < j) 
                {
                    if (!Character.isWhitespace(charsequence.charAt(i)))
                    {
                        return false;
                    }
                    i++;
                }
            }
        }
        return true;
    }

    public static boolean isEmpty(CharSequence charsequence)
    {
        return charsequence == null || charsequence.length() == 0;
    }

    public static boolean isNotBlank(CharSequence charsequence)
    {
        return !isBlank(charsequence);
    }

    public static boolean isNotEmpty(CharSequence charsequence)
    {
        return !isEmpty(charsequence);
    }

    public static boolean isNumeric(CharSequence charsequence)
    {
        if (!isEmpty(charsequence)) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        int j = charsequence.length();
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
                if (!Character.isDigit(charsequence.charAt(i)))
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

    public static String join(Object aobj[], char c)
    {
        if (aobj == null)
        {
            return null;
        } else
        {
            return join(aobj, c, 0, aobj.length);
        }
    }

    public static String join(Object aobj[], char c, int i, int j)
    {
        if (aobj == null)
        {
            return null;
        }
        int k = j - i;
        if (k <= 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder(k * 16);
        for (int l = i; l < j; l++)
        {
            if (l > i)
            {
                stringbuilder.append(c);
            }
            if (aobj[l] != null)
            {
                stringbuilder.append(aobj[l]);
            }
        }

        return stringbuilder.toString();
    }

    public static String leftPad(String s, int i, char c)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            int j = i - s.length();
            s1 = s;
            if (j > 0)
            {
                if (j > 8192)
                {
                    return leftPad(s, i, String.valueOf(c));
                } else
                {
                    return repeat(c, j).concat(s);
                }
            }
        }
        return s1;
    }

    public static String leftPad(String s, int i, String s1)
    {
        if (s == null)
        {
            s1 = null;
        } else
        {
            String s2 = s1;
            if (isEmpty(s1))
            {
                s2 = " ";
            }
            int j = s2.length();
            int k = i - s.length();
            s1 = s;
            if (k > 0)
            {
                if (j == 1 && k <= 8192)
                {
                    return leftPad(s, i, s2.charAt(0));
                }
                if (k == j)
                {
                    return s2.concat(s);
                }
                if (k < j)
                {
                    return s2.substring(0, k).concat(s);
                }
                s1 = new char[k];
                char ac[] = s2.toCharArray();
                for (i = 0; i < k; i++)
                {
                    s1[i] = ac[i % j];
                }

                return (new String(s1)).concat(s);
            }
        }
        return s1;
    }

    public static String repeat(char c, int i)
    {
        char ac[] = new char[i];
        for (i--; i >= 0; i--)
        {
            ac[i] = c;
        }

        return new String(ac);
    }

    public static String repeat(String s, int i)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            if (i <= 0)
            {
                return "";
            }
            int j = s.length();
            s1 = s;
            if (i != 1)
            {
                s1 = s;
                if (j != 0)
                {
                    if (j == 1 && i <= 8192)
                    {
                        return repeat(s.charAt(0), i);
                    }
                    int l = j * i;
                    StringBuilder stringbuilder;
                    switch (j)
                    {
                    default:
                        stringbuilder = new StringBuilder(l);
                        for (int k = 0; k < i; k++)
                        {
                            stringbuilder.append(s);
                        }

                        break;

                    case 1: // '\001'
                        return repeat(s.charAt(0), i);

                    case 2: // '\002'
                        char c = s.charAt(0);
                        char c1 = s.charAt(1);
                        s = new char[l];
                        for (i = i * 2 - 2; i >= 0; i = i - 1 - 1)
                        {
                            s[i] = c;
                            s[i + 1] = c1;
                        }

                        return new String(s);
                    }
                    return stringbuilder.toString();
                }
            }
        }
        return s1;
    }

    public static String rightPad(String s, int i, char c)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            int j = i - s.length();
            s1 = s;
            if (j > 0)
            {
                if (j > 8192)
                {
                    return rightPad(s, i, String.valueOf(c));
                } else
                {
                    return s.concat(repeat(c, j));
                }
            }
        }
        return s1;
    }

    public static String rightPad(String s, int i, String s1)
    {
        if (s == null)
        {
            s1 = null;
        } else
        {
            String s2 = s1;
            if (isEmpty(s1))
            {
                s2 = " ";
            }
            int j = s2.length();
            int k = i - s.length();
            s1 = s;
            if (k > 0)
            {
                if (j == 1 && k <= 8192)
                {
                    return rightPad(s, i, s2.charAt(0));
                }
                if (k == j)
                {
                    return s.concat(s2);
                }
                if (k < j)
                {
                    return s.concat(s2.substring(0, k));
                }
                s1 = new char[k];
                char ac[] = s2.toCharArray();
                for (i = 0; i < k; i++)
                {
                    s1[i] = ac[i % j];
                }

                return s.concat(new String(s1));
            }
        }
        return s1;
    }

    public static boolean startsWith(CharSequence charsequence, CharSequence charsequence1)
    {
        return startsWith(charsequence, charsequence1, false);
    }

    private static boolean startsWith(CharSequence charsequence, CharSequence charsequence1, boolean flag)
    {
        boolean flag2 = false;
        boolean flag1;
        if (charsequence == null || charsequence1 == null)
        {
            flag1 = flag2;
            if (charsequence == null)
            {
                flag1 = flag2;
                if (charsequence1 == null)
                {
                    flag1 = true;
                }
            }
        } else
        {
            flag1 = flag2;
            if (charsequence1.length() <= charsequence.length())
            {
                return CharSequenceUtils.regionMatches(charsequence, flag, 0, charsequence1, 0, charsequence1.length());
            }
        }
        return flag1;
    }

    public static boolean startsWithIgnoreCase(CharSequence charsequence, CharSequence charsequence1)
    {
        return startsWith(charsequence, charsequence1, true);
    }

    public static String substringAfter(String s, String s1)
    {
        if (isEmpty(s))
        {
            return s;
        }
        if (s1 == null)
        {
            return "";
        }
        int i = s.indexOf(s1);
        if (i == -1)
        {
            return "";
        } else
        {
            return s.substring(s1.length() + i);
        }
    }

    public static String[] substringsBetween(String s, String s1, String s2)
    {
        if (s != null && !isEmpty(s1) && !isEmpty(s2)) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        ArrayList arraylist;
        int i;
        int j;
        int k;
        int l;
        j = s.length();
        if (j == 0)
        {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        k = s2.length();
        l = s1.length();
        arraylist = new ArrayList();
        i = 0;
_L7:
        if (i >= j - k) goto _L4; else goto _L3
_L3:
        i = s.indexOf(s1, i);
        if (i >= 0) goto _L5; else goto _L4
_L4:
        if (!arraylist.isEmpty())
        {
            return (String[])arraylist.toArray(new String[arraylist.size()]);
        }
          goto _L1
_L5:
        int i1;
        i += l;
        i1 = s.indexOf(s2, i);
        if (i1 < 0) goto _L4; else goto _L6
_L6:
        arraylist.add(s.substring(i, i1));
        i = i1 + k;
          goto _L7
    }

}
