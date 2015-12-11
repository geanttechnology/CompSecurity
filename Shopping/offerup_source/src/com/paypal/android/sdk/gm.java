// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class gm
{

    private static final Pattern a = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Pattern b = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");
    private final String c;
    private final String d;

    private gm(String s, String s1)
    {
        c = s;
        d = s1;
    }

    public static gm a(String s)
    {
        Object obj = a.matcher(s);
        if (((Matcher) (obj)).lookingAt()) goto _L2; else goto _L1
_L1:
        return null;
_L2:
        Matcher matcher;
        int i;
        ((Matcher) (obj)).group(1).toLowerCase(Locale.US);
        ((Matcher) (obj)).group(2).toLowerCase(Locale.US);
        matcher = b.matcher(s);
        i = ((Matcher) (obj)).end();
        obj = null;
_L6:
        if (i >= s.length()) goto _L4; else goto _L3
_L3:
        matcher.region(i, s.length());
        if (!matcher.lookingAt()) goto _L1; else goto _L5
_L5:
        String s1 = matcher.group(1);
        String s3;
        if (s1 != null && s1.equalsIgnoreCase("charset"))
        {
            String s2;
            if (matcher.group(2) != null)
            {
                s2 = matcher.group(2);
            } else
            {
                s2 = matcher.group(3);
            }
            s3 = s2;
            if (obj != null)
            {
                s3 = s2;
                if (!s2.equalsIgnoreCase(((String) (obj))))
                {
                    throw new IllegalArgumentException((new StringBuilder("Multiple different charsets: ")).append(s).toString());
                }
            }
        } else
        {
            s3 = ((String) (obj));
        }
        i = matcher.end();
        obj = s3;
          goto _L6
_L4:
        return new gm(s, ((String) (obj)));
    }

    public final Charset a()
    {
        if (d != null)
        {
            return Charset.forName(d);
        } else
        {
            return null;
        }
    }

    public final Charset a(Charset charset)
    {
        if (d != null)
        {
            charset = Charset.forName(d);
        }
        return charset;
    }

    public final boolean equals(Object obj)
    {
        return (obj instanceof gm) && ((gm)obj).c.equals(c);
    }

    public final int hashCode()
    {
        return c.hashCode();
    }

    public final String toString()
    {
        return c;
    }

}
