// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;


// Referenced classes of package com.poshmark.utils:
//            SearchFilterModel

public class max
{

    String max;
    String min;
    final SearchFilterModel this$0;

    public String getDisplay()
    {
        String s1 = "";
        String s = s1;
        if (min != null)
        {
            s = s1;
            if (min.length() > 0)
            {
                s = (new StringBuilder()).append("").append(min).toString();
            }
        }
        if (s.length() > 0)
        {
            min = (new StringBuilder()).append(min).append("-").toString();
        }
        s1 = s;
        if (max != null)
        {
            s1 = s;
            if (max.length() > 0)
            {
                s1 = (new StringBuilder()).append(s).append(max).toString();
            }
        }
        return s1;
    }

    protected (String s, String s1)
    {
        this$0 = SearchFilterModel.this;
        super();
        if (s != null && s.length() > 0)
        {
            min = s;
        }
        if (s1 != null && s1.length() > 0)
        {
            max = s1;
        }
    }
}
