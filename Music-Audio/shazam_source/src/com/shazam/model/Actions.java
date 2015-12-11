// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model;

import java.util.List;
import java.util.Map;

public class Actions
{
    public static class Builder
    {

        public List actions;
        public Map urlParams;

        public static Builder a()
        {
            return new Builder();
        }

        static List a(Builder builder)
        {
            return builder.actions;
        }

        static Map b(Builder builder)
        {
            return builder.urlParams;
        }

        public final Actions b()
        {
            return new Actions(this, null);
        }

        public Builder()
        {
        }
    }


    public List actions;
    public Map urlParams;

    private Actions()
    {
    }

    private Actions(Builder builder)
    {
        actions = Builder.a(builder);
        urlParams = Builder.b(builder);
    }

    Actions(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
