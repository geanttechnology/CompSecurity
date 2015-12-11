// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.magicpiano.suggestions;

import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.magicpiano.suggestions:
//            a

class b
{

    public int a;
    public int b;
    final a c;

    b(a a1, String s)
    {
        c = a1;
        super();
        a = -1;
        b = -1;
        if (s == null || s.length() == 0)
        {
            aa.b(a.a, "empty range string!");
            return;
        }
        a1 = s.split("-");
        try
        {
            if (a1.length == 1)
            {
                a = Integer.valueOf(a1[0]).intValue();
                b = a;
                return;
            }
        }
        // Misplaced declaration of an exception variable
        catch (a a1)
        {
            aa.b(a.a, "invalid range format");
            return;
        }
        a = Integer.valueOf(a1[0]).intValue();
        b = Integer.valueOf(a1[1]).intValue();
        return;
    }

    public Boolean a(int i)
    {
        boolean flag;
        if (i >= a && i <= b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        return Boolean.valueOf(flag);
    }
}
