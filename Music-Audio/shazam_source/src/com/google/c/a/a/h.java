// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.c.a.a:
//            j, i

public final class h extends j
{

    private static final Pattern a = Pattern.compile("geo:([\\-0-9.]+),([\\-0-9.]+)(?:,([\\-0-9.]+))?(?:\\?(.*))?", 2);

    public h()
    {
    }

    protected final i a()
    {
        return i.e;
    }

    public final boolean a(String s)
    {
        s = c(s);
        s = a.matcher(s);
        if (s.matches()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        double d;
        try
        {
            d = Double.parseDouble(s.group(1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (d > 90D || d < -90D) goto _L1; else goto _L3
_L3:
        d = Double.parseDouble(s.group(2));
        if (d > 180D || d < -180D) goto _L1; else goto _L4
_L4:
        if (s.group(3) == null)
        {
            break; /* Loop/switch isn't completed */
        }
        d = Double.parseDouble(s.group(3));
        if (d < 0.0D) goto _L1; else goto _L5
_L5:
        return true;
    }

}
