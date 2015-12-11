// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.shazam.server.response.config:
//            Charts

public static class chartList
{

    private List chartList;

    public static chartList charts()
    {
        return new <init>();
    }

    public Charts build()
    {
        return new Charts(this, null);
    }

    public <init> withChartList(List list)
    {
        if (list != null)
        {
            chartList = list;
        }
        return this;
    }


    public ()
    {
        chartList = new ArrayList();
    }
}
