// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.mothership.util.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Referenced classes of package com.target.ui.analytics.a:
//            f, s

public class aw extends f
{

    private final String mCustomPageTitle;

    private aw(String s1)
    {
        mCustomPageTitle = s1;
    }

    public static aw a(String s1)
    {
        return new aw(s1);
    }

    protected s c()
    {
        return s.Browse;
    }

    protected List d()
    {
        if (o.g(mCustomPageTitle))
        {
            ArrayList arraylist = new ArrayList();
            arraylist.add(mCustomPageTitle);
            return arraylist;
        } else
        {
            return Collections.emptyList();
        }
    }

    protected Long i()
    {
        return Long.valueOf(0L);
    }
}
