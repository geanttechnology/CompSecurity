// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.Map;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            SearchConfigurationSet

public static final class 
{

    private Map configs;

    public SearchConfigurationSet build()
    {
        return new SearchConfigurationSet(this, null);
    }

    public Map getConfigurations()
    {
        return configs;
    }

    public configs setConfigurations(Map map)
    {
        configs = map;
        return this;
    }


    public ()
    {
    }
}
