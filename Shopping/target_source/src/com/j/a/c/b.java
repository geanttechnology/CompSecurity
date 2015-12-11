// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.c;

import com.j.a.g.w;

public class b
    implements Comparable
{

    private String a;

    public b(String s)
    {
        if (s == null)
        {
            try
            {
                throw new IllegalArgumentException("Version can not be null");
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                w.b("Version number invalid, defaulting to 0", s);
            }
            a = "0";
            return;
        }
        if (!s.matches("[0-9]+(\\.[0-9]+)*"))
        {
            throw new IllegalArgumentException("Invalid version format");
        } else
        {
            a = s;
            return;
        }
    }

    public int a(b b1)
    {
        if (b1 != null) goto _L2; else goto _L1
_L1:
        return 1;
_L2:
        String as[];
        int i;
        int j;
        int k;
        int l;
        try
        {
            as = a().split("\\.");
            b1 = b1.a().split("\\.");
            l = Math.max(as.length, b1.length);
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            return 0;
        }
        i = 0;
        if (i >= l)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        if (i >= as.length) goto _L4; else goto _L3
_L3:
        j = Integer.parseInt(as[i]);
_L5:
        if (i >= b1.length)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        k = Integer.parseInt(b1[i]);
_L6:
        if (j < k)
        {
            return -1;
        }
        continue; /* Loop/switch isn't completed */
_L4:
        j = 0;
          goto _L5
        k = 0;
          goto _L6
        if (j > k) goto _L1; else goto _L7
_L7:
        i++;
        break MISSING_BLOCK_LABEL_37;
        if (true) goto _L1; else goto _L8
_L8:
        return 0;
    }

    public final String a()
    {
        return a;
    }

    public int compareTo(Object obj)
    {
        return a((b)obj);
    }

    public boolean equals(Object obj)
    {
        return this == obj || obj != null && getClass() == obj.getClass() && a((b)obj) == 0;
    }
}
