// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.simpleframework.xml.d;

import java.util.Locale;
import java.util.regex.Pattern;

// Referenced classes of package org.simpleframework.xml.d:
//            ag, w

final class x
    implements ag
{

    private final Pattern a = Pattern.compile("_");

    public x()
    {
    }

    public final Object a(String s)
    {
        String as[] = a.split(s);
        if (as.length <= 0)
        {
            throw new w("Invalid locale %s", new Object[] {
                s
            });
        }
        s = new String[3];
        s[0] = "";
        s[1] = "";
        s[2] = "";
        for (int i = 0; i < 3; i++)
        {
            if (i < as.length)
            {
                s[i] = as[i];
            }
        }

        return new Locale(s[0], s[1], s[2]);
    }

    public final String a(Object obj)
    {
        return ((Locale)obj).toString();
    }
}
