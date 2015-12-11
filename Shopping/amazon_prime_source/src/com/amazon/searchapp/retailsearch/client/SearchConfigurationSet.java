// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import java.util.Map;

public class SearchConfigurationSet
{
    public static final class Builder
    {

        private Map configs;

        public SearchConfigurationSet build()
        {
            return new SearchConfigurationSet(this);
        }

        public Map getConfigurations()
        {
            return configs;
        }

        public Builder setConfigurations(Map map)
        {
            configs = map;
            return this;
        }


        public Builder()
        {
        }
    }


    private final Map configs;

    private SearchConfigurationSet(Builder builder)
    {
        configs = builder.configs;
    }


    public Map getConfigurations()
    {
        return configs;
    }
}
