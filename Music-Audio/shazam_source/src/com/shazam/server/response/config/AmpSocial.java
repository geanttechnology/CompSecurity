// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.response.config;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AmpSocial
    implements Serializable
{
    public static class Builder
    {

        private final Map hrefMap = new HashMap();

        public static Builder ampSocial()
        {
            return new Builder();
        }

        public AmpSocial build()
        {
            return new AmpSocial(this);
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

    private AmpSocial()
    {
    }

    private AmpSocial(Builder builder)
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
