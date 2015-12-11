// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import java.util.regex.Pattern;

// Referenced classes of package org.simpleframework.xml.d:
//            ag

final class ad
    implements ag
{

    private final Pattern a;
    private final String b;

    public ad()
    {
        this(",");
    }

    private ad(String s)
    {
        a = Pattern.compile(s);
        b = s;
    }

    public final Object a(String s)
    {
        return b(s);
    }

    public final volatile String a(Object obj)
    {
        return a((String[])obj);
    }

    public final String a(String as[])
    {
        String s = b;
        StringBuilder stringbuilder = new StringBuilder();
        for (int i = 0; i < as.length; i++)
        {
            String s1 = as[i];
            if (s1 == null)
            {
                continue;
            }
            if (stringbuilder.length() > 0)
            {
                stringbuilder.append(s);
                stringbuilder.append(' ');
            }
            stringbuilder.append(s1);
        }

        return stringbuilder.toString();
    }

    public final String[] b(String s)
    {
        s = a.split(s);
        for (int i = 0; i < s.length; i++)
        {
            String s1 = s[i];
            if (s1 != null)
            {
                s[i] = s1.trim();
            }
        }

        return s;
    }
}
