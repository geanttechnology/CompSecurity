// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.server.legacy.orbitconfig;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ConfigElements
    implements Serializable
{
    public static class Builder
    {

        private Map values;

        public static Builder configElements()
        {
            return new Builder();
        }

        public ConfigElements build()
        {
            return new ConfigElements(this, null);
        }

        public Builder put(String s, String s1)
        {
            values.put(s, s1);
            return this;
        }

        public Builder withValues(Map map)
        {
            values = map;
            return this;
        }


        public Builder()
        {
            values = new HashMap();
        }
    }


    private Map values;

    private ConfigElements()
    {
    }

    private ConfigElements(Builder builder)
    {
        values = builder.values;
    }

    ConfigElements(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public Map getValues()
    {
        if (values == null)
        {
            return Collections.emptyMap();
        } else
        {
            return values;
        }
    }
}
