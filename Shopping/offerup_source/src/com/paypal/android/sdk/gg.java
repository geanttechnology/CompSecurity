// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.util.Collections;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            gh, js

public final class gg
{

    private final String a[];

    private gg(gh gh1)
    {
        a = (String[])gh.a(gh1).toArray(new String[gh.a(gh1).size()]);
    }

    gg(gh gh1, byte byte0)
    {
        this(gh1);
    }

    public final int a()
    {
        return a.length / 2;
    }

    public final String a(int i)
    {
        i <<= 1;
        if (i < 0 || i >= a.length)
        {
            return null;
        } else
        {
            return a[i];
        }
    }

    public final String a(String s)
    {
        String as[] = a;
        for (int i = as.length - 2; i >= 0; i -= 2)
        {
            if (s.equalsIgnoreCase(as[i]))
            {
                return as[i + 1];
            }
        }

        return null;
    }

    public final gh b()
    {
        gh gh1 = new gh();
        Collections.addAll(gh.a(gh1), a);
        return gh1;
    }

    public final String b(int i)
    {
        i = (i << 1) + 1;
        if (i < 0 || i >= a.length)
        {
            return null;
        } else
        {
            return a[i];
        }
    }

    public final Date b(String s)
    {
        s = a(s);
        if (s != null)
        {
            return js.a(s);
        } else
        {
            return null;
        }
    }

    public final String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        for (int j = a.length / 2; i < j; i++)
        {
            stringbuilder.append(a(i)).append(": ").append(b(i)).append("\n");
        }

        return stringbuilder.toString();
    }
}
