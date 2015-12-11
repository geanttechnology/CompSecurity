// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a.a;


// Referenced classes of package com.a.a.a.a:
//            c

final class b
{

    public static int a(String s)
    {
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1;
        }
        if (l > 0x7fffffffL)
        {
            return 0x7fffffff;
        }
        if (l < 0L)
        {
            return 0;
        } else
        {
            return (int)l;
        }
    }

    public static int a(String s, int i)
    {
        do
        {
            if (i >= s.length())
            {
                break;
            }
            char c1 = s.charAt(i);
            if (c1 != ' ' && c1 != '\t')
            {
                break;
            }
            i++;
        } while (true);
        return i;
    }

    public static int a(String s, int i, String s1)
    {
        for (; i < s.length() && s1.indexOf(s.charAt(i)) == -1; i++) { }
        return i;
    }

    public static void a(String s, c c1)
    {
        for (int i = 0; i < s.length();)
        {
            int j = a(s, i, "=,");
            String s2 = s.substring(i, j).trim();
            if (j == s.length() || s.charAt(j) == ',')
            {
                i = j + 1;
                c1.a(s2, null);
            } else
            {
                j = a(s, j + 1);
                String s1;
                if (j < s.length() && s.charAt(j) == '"')
                {
                    i = j + 1;
                    j = a(s, i, "\"");
                    s1 = s.substring(i, j);
                    i = j + 1;
                } else
                {
                    i = a(s, j, ",");
                    s1 = s.substring(j, i).trim();
                }
                c1.a(s2, s1);
            }
        }

    }
}
