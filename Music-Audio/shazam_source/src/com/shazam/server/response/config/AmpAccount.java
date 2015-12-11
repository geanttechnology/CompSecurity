// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AmpAccount
    implements Serializable
{
    public static class Builder
    {

        private final Map hrefMap = new HashMap();

        public static Builder ampAccount()
        {
            return new Builder();
        }

        public AmpAccount build()
        {
            return new AmpAccount(this);
        }

        public Builder withHrefMap(Map map)
        {
            hrefMap.clear();
            hrefMap.putAll(map);
            return this;
        }


        public Builder()
        {
        }
    }


    private Map hrefMap;

    private AmpAccount()
    {
    }

    private AmpAccount(Builder builder)
    {
        hrefMap = builder.hrefMap;
    }


    public Map getHrefMap()
    {
        if (hrefMap != null)
        {
            return hrefMap;
        } else
        {
            return new HashMap();
        }
    }
}
