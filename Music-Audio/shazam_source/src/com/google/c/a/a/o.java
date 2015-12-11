// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.c.a.a:
//            j, i

public final class o extends j
{

    private static final Pattern a = Pattern.compile("[a-zA-Z][a-zA-Z0-9+-.]+:");
    private static final Pattern b = Pattern.compile("([a-zA-Z0-9\\-]+\\.)+[a-zA-Z]{2,}(:\\d{1,5})?(/|\\?|$)");

    public o()
    {
    }

    static boolean b(String s)
    {
        if (!s.contains(" "))
        {
            Matcher matcher = a.matcher(s);
            if (matcher.find() && matcher.start() == 0)
            {
                return true;
            }
            s = b.matcher(s);
            if (s.find() && s.start() == 0)
            {
                return true;
            }
        }
        return false;
    }

    protected final i a()
    {
        return i.c;
    }

    public final boolean a(String s)
    {
        s = c(s);
        if (s.startsWith("URL:") || s.startsWith("URI:"))
        {
            return true;
        } else
        {
            return b(s.trim());
        }
    }

}
