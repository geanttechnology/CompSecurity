// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.c.a.a;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.google.c.a.a:
//            a, i

public final class g extends a
{

    private static final Pattern a = Pattern.compile("[a-zA-Z0-9@.!#$%&'*+\\-/=?^_`{|}~]+");

    public g()
    {
    }

    static boolean b(String s)
    {
        return s != null && a.matcher(s).matches() && s.indexOf('@') >= 0;
    }

    protected final i a()
    {
        return i.b;
    }

    public final boolean a(String s)
    {
        s = c(s);
        if (s.startsWith("MATMSG:")) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        if ((s = com.google.c.a.a.a.a("TO:", s, true)) != null)
        {
            int k = s.length;
            int j = 0;
label0:
            do
            {
label1:
                {
                    if (j >= k)
                    {
                        break label1;
                    }
                    if (!b(s[j]))
                    {
                        break label0;
                    }
                    j++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        return true;
    }

}
