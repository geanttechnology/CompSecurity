// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.analytics.event;

import com.shazam.model.analytics.event.EventParameterKey;

public class StringEventParameterKey
    implements EventParameterKey
{
    public static class Builder
    {

        private String parameterKey;

        static String a(Builder builder)
        {
            return builder.parameterKey;
        }

        public static Builder stringEventParameterKey()
        {
            return new Builder();
        }

        public StringEventParameterKey build()
        {
            return new StringEventParameterKey(this, (byte)0);
        }

        public Builder withParameterKey(String s)
        {
            parameterKey = s;
            return this;
        }

        public Builder()
        {
        }
    }


    private final String parameterKey;

    private StringEventParameterKey(Builder builder)
    {
        parameterKey = Builder.a(builder);
    }

    StringEventParameterKey(Builder builder, byte byte0)
    {
        this(builder);
    }

    public String getParameterKey()
    {
        return parameterKey;
    }

    public String toString()
    {
        return parameterKey;
    }
}
