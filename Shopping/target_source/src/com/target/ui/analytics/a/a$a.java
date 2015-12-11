// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.target.ui.analytics.a:
//            a, s

class levels
{

    final List levels;
    final String platform = "android";
    final s screen;
    final String siteSection;
    final a this$0;

    public String a()
    {
        StringBuilder stringbuilder = new StringBuilder();
        getClass();
        stringbuilder.append("android");
        if (siteSection != null)
        {
            stringbuilder.append(": ");
            stringbuilder.append(siteSection);
        }
        if (levels != null && !levels.isEmpty())
        {
            String s;
            for (Iterator iterator = levels.iterator(); iterator.hasNext(); stringbuilder.append(s))
            {
                s = (String)iterator.next();
                stringbuilder.append(": ");
            }

        }
        return stringbuilder.toString();
    }

    public (s s, String s1, List list)
    {
        this$0 = a.this;
        super();
        screen = s;
        siteSection = s1;
        levels = list;
    }
}
