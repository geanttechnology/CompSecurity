// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package org.apache.commons.lang3:
//            CharSequenceUtils, ArrayUtils

public class StringUtils
{

    private static final Pattern WHITESPACE_BLOCK = Pattern.compile("\\s+");

    public static int indexOfIgnoreCase(CharSequence charsequence, CharSequence charsequence1)
    {
        return indexOfIgnoreCase(charsequence, charsequence1, 0);
    }

    public static int indexOfIgnoreCase(CharSequence charsequence, CharSequence charsequence1, int i)
    {
        if (charsequence != null && charsequence1 != null) goto _L2; else goto _L1
_L1:
        int j = -1;
_L4:
        return j;
_L2:
        j = i;
        if (i < 0)
        {
            j = 0;
        }
        int k = (charsequence.length() - charsequence1.length()) + 1;
        if (j > k)
        {
            return -1;
        }
        if (charsequence1.length() == 0)
        {
            return j;
        }
        i = j;
label0:
        do
        {
label1:
            {
                if (i >= k)
                {
                    break label1;
                }
                j = i;
                if (CharSequenceUtils.regionMatches(charsequence, true, i, charsequence1, 0, charsequence1.length()))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L4; else goto _L3
_L3:
        return -1;
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

    public static String join(Object aobj[], String s)
    {
        if (aobj == null)
        {
            return null;
        } else
        {
            return join(aobj, s, 0, aobj.length);
        }
    }

    public static String join(Object aobj[], String s, int i, int j)
    {
        if (aobj == null)
        {
            return null;
        }
        String s1 = s;
        if (s == null)
        {
            s1 = "";
        }
        int k = j - i;
        if (k <= 0)
        {
            return "";
        }
        s = new StringBuilder(k * 16);
        for (int l = i; l < j; l++)
        {
            if (l > i)
            {
                s.append(s1);
            }
            if (aobj[l] != null)
            {
                s.append(aobj[l]);
            }
        }

        return s.toString();
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

    public static String normalizeSpace(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return WHITESPACE_BLOCK.matcher(trim(s)).replaceAll(" ");
        }
    }

    public static String remove(String s, String s1)
    {
        if (isEmpty(s) || isEmpty(s1))
        {
            return s;
        } else
        {
            return replace(s, s1, "", -1);
        }
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

    public static String replace(String s, String s1, String s2, int i)
    {
        int j = 64;
        if (!isEmpty(s) && !isEmpty(s1) && s2 != null && i != 0)
        {
            boolean flag = false;
            int l = s.indexOf(s1, 0);
            if (l != -1)
            {
                int k1 = s1.length();
                int j1 = s2.length() - k1;
                int k = j1;
                if (j1 < 0)
                {
                    k = 0;
                }
                StringBuilder stringbuilder;
                if (i < 0)
                {
                    j = 16;
                } else
                if (i <= 64)
                {
                    j = i;
                }
                stringbuilder = new StringBuilder(s.length() + k * j);
                j = i;
                i = ((flag) ? 1 : 0);
                k = l;
                do
                {
label0:
                    {
                        int i1 = i;
                        if (k != -1)
                        {
                            stringbuilder.append(s.substring(i, k)).append(s2);
                            i = k + k1;
                            j--;
                            if (j != 0)
                            {
                                break label0;
                            }
                            i1 = i;
                        }
                        stringbuilder.append(s.substring(i1));
                        return stringbuilder.toString();
                    }
                    k = s.indexOf(s1, i);
                } while (true);
            }
        }
        return s;
    }

    public static String[] split(String s)
    {
        return split(s, null, -1);
    }

    public static String[] split(String s, char c)
    {
        return splitWorker(s, c, false);
    }

    public static String[] split(String s, String s1)
    {
        return splitWorker(s, s1, -1, false);
    }

    public static String[] split(String s, String s1, int i)
    {
        return splitWorker(s, s1, i, false);
    }

    private static String[] splitWorker(String s, char c, boolean flag)
    {
        if (s == null)
        {
            return null;
        }
        int k = s.length();
        if (k == 0)
        {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        ArrayList arraylist = new ArrayList();
        int i = 0;
        int j = 0;
        boolean flag2 = false;
        boolean flag1 = false;
        while (i < k) 
        {
            if (s.charAt(i) == c)
            {
                if (flag2 || flag)
                {
                    arraylist.add(s.substring(j, i));
                    flag2 = false;
                    flag1 = true;
                }
                i++;
                j = i;
            } else
            {
                flag1 = false;
                flag2 = true;
                i++;
            }
        }
        if (flag2 || flag && flag1)
        {
            arraylist.add(s.substring(j, i));
        }
        return (String[])arraylist.toArray(new String[arraylist.size()]);
    }

    private static String[] splitWorker(String s, String s1, int i, boolean flag)
    {
        ArrayList arraylist;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        int l1;
        int i2;
        int j2;
        int k2;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        if (s == null)
        {
            return null;
        }
        j1 = s.length();
        if (j1 == 0)
        {
            return ArrayUtils.EMPTY_STRING_ARRAY;
        }
        arraylist = new ArrayList();
        j = 0;
        flag3 = false;
        l1 = 0;
        k2 = 0;
        k1 = 0;
        flag2 = false;
        i2 = 0;
        j2 = 0;
        i1 = 0;
        k = 0;
        flag1 = false;
        l = 0;
        if (s1 != null) goto _L2; else goto _L1
_L1:
        k = 1;
        k1 = ((flag2) ? 1 : 0);
        j = l1;
        do
        {
            k2 = j;
            j2 = l;
            l1 = i1;
            i2 = k;
            i2 = k1;
            if (j >= j1)
            {
                break;
            }
            if (Character.isWhitespace(s.charAt(j)))
            {
                if (i1 != 0 || flag)
                {
                    l = 1;
                    i1 = k + 1;
                    if (k == i)
                    {
                        j = j1;
                        l = 0;
                    }
                    arraylist.add(s.substring(k1, j));
                    k1 = 0;
                    k = i1;
                    i1 = k1;
                }
                j++;
                k1 = j;
            } else
            {
                l = 0;
                i1 = 1;
                j++;
            }
        } while (true);
          goto _L3
_L2:
        if (s1.length() != 1)
        {
            break MISSING_BLOCK_LABEL_550;
        }
        j2 = s1.charAt(0);
        k1 = 1;
        i1 = k2;
        l = i2;
        while (j < j1) 
        {
            if (s.charAt(j) == j2)
            {
                if (l != 0 || flag)
                {
                    k = 1;
                    l = k1 + 1;
                    if (k1 == i)
                    {
                        j = j1;
                        k = 0;
                    }
                    arraylist.add(s.substring(i1, j));
                    i1 = 0;
                } else
                {
                    i1 = l;
                    l = k1;
                }
                j++;
                l1 = j;
                k1 = l;
                l = i1;
                i1 = l1;
            } else
            {
                k = 0;
                l = 1;
                j++;
            }
        }
        if (l != 0 || flag && k != 0)
        {
            arraylist.add(s.substring(i1, j));
        }
        return (String[])arraylist.toArray(new String[arraylist.size()]);
_L5:
        k2 = j;
        j2 = k;
        l1 = i1;
        i2 = l;
        i2 = k1;
        if (j < j1)
        {
            if (s1.indexOf(s.charAt(j)) >= 0)
            {
                if (i1 != 0 || flag)
                {
                    k = 1;
                    i1 = l + 1;
                    if (l == i)
                    {
                        j = j1;
                        k = 0;
                    }
                    arraylist.add(s.substring(k1, j));
                    k1 = 0;
                    l = i1;
                    i1 = k1;
                }
                j++;
                k1 = j;
            } else
            {
                k = 0;
                i1 = 1;
                j++;
            }
            continue; /* Loop/switch isn't completed */
        }
_L3:
        j = k2;
        k = j2;
        l = l1;
        i1 = i2;
        break MISSING_BLOCK_LABEL_340;
        l = 1;
        j = ((flag3) ? 1 : 0);
        k = ((flag1) ? 1 : 0);
        i1 = j2;
        if (true) goto _L5; else goto _L4
_L4:
    }

    public static String trim(String s)
    {
        if (s == null)
        {
            return null;
        } else
        {
            return s.trim();
        }
    }

}
