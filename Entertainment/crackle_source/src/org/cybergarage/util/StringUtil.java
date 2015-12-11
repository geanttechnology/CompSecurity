// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.util;


// Referenced classes of package org.cybergarage.util:
//            Debug

public final class StringUtil
{

    public StringUtil()
    {
    }

    public static final int findFirstNotOf(String s, String s1)
    {
        return findOf(s, s1, 0, s.length() - 1, 1, false);
    }

    public static final int findFirstOf(String s, String s1)
    {
        return findOf(s, s1, 0, s.length() - 1, 1, true);
    }

    public static final int findLastNotOf(String s, String s1)
    {
        return findOf(s, s1, s.length() - 1, 0, -1, false);
    }

    public static final int findLastOf(String s, String s1)
    {
        return findOf(s, s1, s.length() - 1, 0, -1, true);
    }

    public static final int findOf(String s, String s1, int i, int j, int k, boolean flag)
    {
        if (k != 0) goto _L2; else goto _L1
_L1:
        int i1 = -1;
_L7:
        return i1;
_L2:
        int k1 = s1.length();
_L3:
        int l;
        int j1;
        char c;
        if (k <= 0 ? i < j : j < i)
        {
            return -1;
        }
        c = s.charAt(i);
        l = 0;
        j1 = 0;
_L8:
label0:
        {
            if (j1 < k1)
            {
                break label0;
            }
            i += k;
        }
          goto _L3
        char c1 = s1.charAt(j1);
        if (!flag) goto _L5; else goto _L4
_L4:
        i1 = i;
        if (c == c1) goto _L7; else goto _L6
_L6:
        j1++;
          goto _L8
_L5:
        i1 = l;
        if (c != c1)
        {
            i1 = l + 1;
        }
        l = i1;
        if (i1 != k1) goto _L6; else goto _L9
_L9:
        return i;
          goto _L3
    }

    public static final boolean hasData(String s)
    {
        while (s == null || s.length() <= 0) 
        {
            return false;
        }
        return true;
    }

    public static final int toInteger(String s)
    {
        int i;
        try
        {
            i = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Debug.warning(s);
            return 0;
        }
        return i;
    }

    public static final long toLong(String s)
    {
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Debug.warning(s);
            return 0L;
        }
        return l;
    }

    public static final String trim(String s, String s1)
    {
        int i = findFirstNotOf(s, s1);
        if (i < 0)
        {
            return s;
        }
        s = s.substring(i, s.length());
        i = findLastNotOf(s, s1);
        if (i < 0)
        {
            return s;
        } else
        {
            return s.substring(0, i + 1);
        }
    }
}
