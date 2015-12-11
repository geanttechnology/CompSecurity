// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.abtest;

import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.groupon.abtest:
//            TabOrderAbTestHelper

public static class <init>
{

    private final String defaultTab;
    private final String tabs[];

    public String getDefaultChannel()
    {
        return defaultTab;
    }

    public String[] getTabs()
    {
        return tabs;
    }

    public boolean isDefaultChannelInTabs()
    {
        return Arrays.asList(tabs).contains(defaultTab);
    }

    private (String s, String as[])
    {
        defaultTab = s;
        tabs = as;
    }

    tabs(String s, String as[], tabs tabs1)
    {
        this(s, as);
    }
}
