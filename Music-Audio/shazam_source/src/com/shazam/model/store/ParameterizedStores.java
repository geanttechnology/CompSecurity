// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import java.util.Collections;
import java.util.Map;

// Referenced classes of package com.shazam.model.store:
//            Stores

public class ParameterizedStores
{
    public static class Builder
    {

        public Stores stores;
        public Map urlParameters;

        public static Builder a()
        {
            return new Builder();
        }

        static Map a(Builder builder)
        {
            return builder.urlParameters;
        }

        static Stores b(Builder builder)
        {
            return builder.stores;
        }

        public final ParameterizedStores b()
        {
            return new ParameterizedStores(this, null);
        }

        public Builder()
        {
            urlParameters = Collections.emptyMap();
        }
    }


    public final Stores stores;
    public final Map urlParameters;

    private ParameterizedStores(Builder builder)
    {
        urlParameters = Builder.a(builder);
        stores = Builder.b(builder);
    }

    ParameterizedStores(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
