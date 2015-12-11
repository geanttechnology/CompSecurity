// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.Map;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            StaticSearchConfiguration, SearchConfigurationSet, SearchConfiguration

public class SearchConfigurationManager
{

    public static final String AMAZON_CONFIG = "amazon";
    public static final String BETA_CONFIG = "rsp-beta";
    public static final String GAMMA_CONFIG = "rsp-gamma";
    public static final String HOUDINI_CONFIG = "houdini";
    public static final String HOUDINI_TEST1_CONFIG = "houdini-test1";
    public static final String HOUDINI_TEST2_CONFIG = "houdini-test2";
    public static final String TEST1_CONFIG = "test1";
    public static final String TEST2_CONFIG = "test2";
    public static final String TEST3_CONFIG = "test3";
    public static final String TEST4_CONFIG = "test4";
    public static final String TEST5_CONFIG = "test5";
    public static final String TEST6_CONFIG = "test6";
    private static volatile SearchConfigurationManager instance;
    private volatile SearchConfiguration config;
    private final SearchConfigurationSet configs;

    public SearchConfigurationManager(SearchConfigurationSet searchconfigurationset)
    {
        configs = searchconfigurationset;
    }

    public static SearchConfigurationManager getInstance()
    {
        com/amazon/searchapp/retailsearch/client/SearchConfigurationManager;
        JVM INSTR monitorenter ;
        SearchConfigurationManager searchconfigurationmanager;
        if (instance == null)
        {
            instance = new SearchConfigurationManager(StaticSearchConfiguration.build());
        }
        searchconfigurationmanager = instance;
        com/amazon/searchapp/retailsearch/client/SearchConfigurationManager;
        JVM INSTR monitorexit ;
        return searchconfigurationmanager;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setInstance(SearchConfigurationManager searchconfigurationmanager)
    {
        com/amazon/searchapp/retailsearch/client/SearchConfigurationManager;
        JVM INSTR monitorenter ;
        instance = searchconfigurationmanager;
        com/amazon/searchapp/retailsearch/client/SearchConfigurationManager;
        JVM INSTR monitorexit ;
        return;
        searchconfigurationmanager;
        throw searchconfigurationmanager;
    }

    public SearchConfiguration getConfiguration()
    {
        this;
        JVM INSTR monitorenter ;
        SearchConfiguration searchconfiguration;
        if (config == null)
        {
            config = getConfigurationById("amazon");
        }
        searchconfiguration = config;
        this;
        JVM INSTR monitorexit ;
        return searchconfiguration;
        Exception exception;
        exception;
        throw exception;
    }

    public SearchConfiguration getConfigurationById(String s)
    {
        return (SearchConfiguration)configs.getConfigurations().get(s);
    }

    public SearchConfigurationSet getConfigurationSet()
    {
        return configs;
    }

    public void setConfiguration(SearchConfiguration searchconfiguration)
    {
        this;
        JVM INSTR monitorenter ;
        config = searchconfiguration;
        this;
        JVM INSTR monitorexit ;
        return;
        searchconfiguration;
        throw searchconfiguration;
    }

    public void setConfigurationId(String s)
    {
        setConfiguration(getConfigurationById(s));
    }
}
