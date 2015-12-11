// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.lang3;

import java.util.Iterator;

// Referenced classes of package org.apache.commons.lang3:
//            CharSequenceUtils, ObjectUtils

public class StringUtils
{

    public static final String CR = "\r";
    public static final String EMPTY = "";
    public static final int INDEX_NOT_FOUND = -1;
    public static final String LF = "\n";
    private static final int PAD_LIMIT = 8192;
    public static final String SPACE = " ";

    public StringUtils()
    {
    }

    public static String abbreviate(String s, int i)
    {
        return abbreviate(s, 0, i);
    }

    public static String abbreviate(String s, int i, int j)
    {
        String s1;
        if (s == null)
        {
            s1 = null;
        } else
        {
            if (j < 4)
            {
                throw new IllegalArgumentException("Minimum abbreviation width is 4");
            }
            s1 = s;
            if (s.length() > j)
            {
                int k = i;
                if (i > s.length())
                {
                    k = s.length();
                }
                i = k;
                if (s.length() - k < j - 3)
                {
                    i = s.length() - (j - 3);
                }
                if (i <= 4)
                {
                    return (new StringBuilder()).append(s.substring(0, j - 3)).append("...").toString();
                }
                if (j < 7)
                {
                    throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
                }
                if ((i + j) - 3 < s.length())
                {
                    return (new StringBuilder("...")).append(abbreviate(s.substring(i), j - 3)).toString();
                } else
                {
                    return (new StringBuilder("...")).append(s.substring(s.length() - (j - 3))).toString();
                }
            }
        }
        return s1;
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
        boolean flag1 = false;
        if (charsequence == null) goto _L2; else goto _L1
_L1:
        int j = charsequence.length();
        if (j != 0) goto _L3; else goto _L2
_L2:
        boolean flag = true;
_L5:
        return flag;
_L3:
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
                flag = flag1;
                if (!Character.isWhitespace(charsequence.charAt(i)))
                {
                    break label0;
                }
                i++;
            }
        } while (true);
        if (true) goto _L5; else goto _L4
_L4:
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

    public static boolean isNumericSpace(CharSequence charsequence)
    {
        if (charsequence != null) goto _L2; else goto _L1
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
                if (!Character.isDigit(charsequence.charAt(i)) && charsequence.charAt(i) != ' ')
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

    public static String join(Iterable iterable, char c)
    {
        if (iterable == null)
        {
            return null;
        } else
        {
            return join(iterable.iterator(), c);
        }
    }

    public static String join(Iterable iterable, String s)
    {
        if (iterable == null)
        {
            return null;
        } else
        {
            return join(iterable.iterator(), s);
        }
    }

    public static String join(Iterator iterator, char c)
    {
        if (iterator == null)
        {
            return null;
        }
        if (!iterator.hasNext())
        {
            return "";
        }
        Object obj = iterator.next();
        if (!iterator.hasNext())
        {
            return ObjectUtils.toString(obj);
        }
        StringBuilder stringbuilder = new StringBuilder(256);
        if (obj != null)
        {
            stringbuilder.append(obj);
        }
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            stringbuilder.append(c);
            Object obj1 = iterator.next();
            if (obj1 != null)
            {
                stringbuilder.append(obj1);
            }
        } while (true);
        return stringbuilder.toString();
    }

    public static String join(Iterator iterator, String s)
    {
        if (iterator == null)
        {
            return null;
        }
        if (!iterator.hasNext())
        {
            return "";
        }
        Object obj = iterator.next();
        if (!iterator.hasNext())
        {
            return ObjectUtils.toString(obj);
        }
        StringBuilder stringbuilder = new StringBuilder(256);
        if (obj != null)
        {
            stringbuilder.append(obj);
        }
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            if (s != null)
            {
                stringbuilder.append(s);
            }
            Object obj1 = iterator.next();
            if (obj1 != null)
            {
                stringbuilder.append(obj1);
            }
        } while (true);
        return stringbuilder.toString();
    }

    public static String join(byte abyte0[], char c)
    {
        if (abyte0 == null)
        {
            return null;
        } else
        {
            return join(abyte0, c, 0, abyte0.length);
        }
    }

    public static String join(byte abyte0[], char c, int i, int j)
    {
        if (abyte0 == null)
        {
            return null;
        }
        int k = j - i;
        if (k <= 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder(k << 4);
        for (int l = i; l < j; l++)
        {
            if (l > i)
            {
                stringbuilder.append(c);
            }
            stringbuilder.append(abyte0[l]);
        }

        return stringbuilder.toString();
    }

    public static String join(char ac[], char c)
    {
        if (ac == null)
        {
            return null;
        } else
        {
            return join(ac, c, 0, ac.length);
        }
    }

    public static String join(char ac[], char c, int i, int j)
    {
        if (ac == null)
        {
            return null;
        }
        int k = j - i;
        if (k <= 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder(k << 4);
        for (int l = i; l < j; l++)
        {
            if (l > i)
            {
                stringbuilder.append(c);
            }
            stringbuilder.append(ac[l]);
        }

        return stringbuilder.toString();
    }

    public static String join(double ad[], char c)
    {
        if (ad == null)
        {
            return null;
        } else
        {
            return join(ad, c, 0, ad.length);
        }
    }

    public static String join(double ad[], char c, int i, int j)
    {
        if (ad == null)
        {
            return null;
        }
        int k = j - i;
        if (k <= 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder(k << 4);
        for (int l = i; l < j; l++)
        {
            if (l > i)
            {
                stringbuilder.append(c);
            }
            stringbuilder.append(ad[l]);
        }

        return stringbuilder.toString();
    }

    public static String join(float af[], char c)
    {
        if (af == null)
        {
            return null;
        } else
        {
            return join(af, c, 0, af.length);
        }
    }

    public static String join(float af[], char c, int i, int j)
    {
        if (af == null)
        {
            return null;
        }
        int k = j - i;
        if (k <= 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder(k << 4);
        for (int l = i; l < j; l++)
        {
            if (l > i)
            {
                stringbuilder.append(c);
            }
            stringbuilder.append(af[l]);
        }

        return stringbuilder.toString();
    }

    public static String join(int ai[], char c)
    {
        if (ai == null)
        {
            return null;
        } else
        {
            return join(ai, c, 0, ai.length);
        }
    }

    public static String join(int ai[], char c, int i, int j)
    {
        if (ai == null)
        {
            return null;
        }
        int k = j - i;
        if (k <= 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder(k << 4);
        for (int l = i; l < j; l++)
        {
            if (l > i)
            {
                stringbuilder.append(c);
            }
            stringbuilder.append(ai[l]);
        }

        return stringbuilder.toString();
    }

    public static String join(long al[], char c)
    {
        if (al == null)
        {
            return null;
        } else
        {
            return join(al, c, 0, al.length);
        }
    }

    public static String join(long al[], char c, int i, int j)
    {
        if (al == null)
        {
            return null;
        }
        int k = j - i;
        if (k <= 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder(k << 4);
        for (int l = i; l < j; l++)
        {
            if (l > i)
            {
                stringbuilder.append(c);
            }
            stringbuilder.append(al[l]);
        }

        return stringbuilder.toString();
    }

    public static transient String join(Object aobj[])
    {
        return join(aobj, ((String) (null)));
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
        StringBuilder stringbuilder = new StringBuilder(k << 4);
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
        s = new StringBuilder(k << 4);
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

    public static String join(short aword0[], char c)
    {
        if (aword0 == null)
        {
            return null;
        } else
        {
            return join(aword0, c, 0, aword0.length);
        }
    }

    public static String join(short aword0[], char c, int i, int j)
    {
        if (aword0 == null)
        {
            return null;
        }
        int k = j - i;
        if (k <= 0)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder(k << 4);
        for (int l = i; l < j; l++)
        {
            if (l > i)
            {
                stringbuilder.append(c);
            }
            stringbuilder.append(aword0[l]);
        }

        return stringbuilder.toString();
    }
}
