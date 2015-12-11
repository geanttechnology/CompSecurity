// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import com.shazam.b.a.d;
import com.shazam.b.a.e;
import com.shazam.b.e.a;
import com.shazam.model.analytics.event.EventParameterKey;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EventParameters
{
    public static class Builder
    {

        private Map parameters;

        static Map a(Builder builder)
        {
            return builder.parameters;
        }

        public static Builder eventParameters()
        {
            return new Builder();
        }

        public Builder appendParametersFrom(EventParameters eventparameters)
        {
            parameters.putAll(eventparameters.getParameters());
            return this;
        }

        public EventParameters build()
        {
            return new EventParameters(this, (byte)0);
        }

        public Builder eventParametersFrom(EventParameters eventparameters)
        {
            parameters = eventparameters.getParameters();
            return this;
        }

        public Builder putNotEmptyOrNullParameter(EventParameterKey eventparameterkey, String s)
        {
            if (com.shazam.b.e.a.c(s))
            {
                parameters.put(eventparameterkey.getParameterKey(), s);
            }
            return this;
        }

        public Builder putNotEmptyOrNullParameters(Map map)
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); putNotEmptyOrNullParameter((EventParameterKey)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

            return this;
        }

        public Builder putNotEmptyOrNullParametersWithUndefinedKeys(Map map)
        {
            java.util.Map.Entry entry;
            for (map = map.entrySet().iterator(); map.hasNext(); putNotEmptyOrNullParameter(StringEventParameterKey.Builder.stringEventParameterKey().withParameterKey((String)entry.getKey()).build(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)map.next();
            }

            return this;
        }

        public Builder withNotEmptyOrNullParameters(Map map)
        {
            e e1 = new e(this) {

                final Builder a;

                public volatile boolean apply(Object obj)
                {
                    return apply((String)obj);
                }

                public boolean apply(String s)
                {
                    return com.shazam.b.e.a.c(s);
                }

            
            {
                a = builder;
                super();
            }
            };
            d.a(map);
            d.a(e1);
            HashMap hashmap = new HashMap(map.size());
            map = map.entrySet().iterator();
            do
            {
                if (!map.hasNext())
                {
                    break;
                }
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                if (e1.apply(entry.getValue()))
                {
                    hashmap.put(entry.getKey(), entry.getValue());
                }
            } while (true);
            parameters = com.shazam.android.analytics.event.EventParameters.a(hashmap);
            return this;
        }

        public Builder()
        {
            parameters = new HashMap();
        }
    }


    public static final EventParameters EMPTY_PARAMETERS = Builder.eventParameters().build();
    private final Map parameters;

    private EventParameters(Builder builder)
    {
        parameters = com.shazam.android.analytics.event.Builder.a(builder);
    }

    EventParameters(Builder builder, byte byte0)
    {
        this(builder);
    }

    static Map a(Map map)
    {
        return stringMapFromEventParameters(map);
    }

    private static Map stringMapFromEventParameters(Map map)
    {
        com.shazam.o.k.a a1 = new com.shazam.o.k.a() {

            public final volatile Object transformKey(Object obj)
            {
                return transformKey((EventParameterKey)obj);
            }

            public final String transformKey(EventParameterKey eventparameterkey)
            {
                return eventparameterkey.getParameterKey();
            }

        };
        HashMap hashmap = new HashMap();
        java.util.Map.Entry entry;
        for (map = map.entrySet().iterator(); map.hasNext(); hashmap.put(a1.transformKey(entry.getKey()), entry.getValue()))
        {
            entry = (java.util.Map.Entry)map.next();
        }

        return hashmap;
    }

    public Map getParameters()
    {
        return parameters;
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("EventParameters{parameters=");
        String s;
        if (parameters != null)
        {
            s = Arrays.toString(parameters.entrySet().toArray());
        } else
        {
            s = "null";
        }
        return stringbuilder.append(s).append('}').toString();
    }

}
