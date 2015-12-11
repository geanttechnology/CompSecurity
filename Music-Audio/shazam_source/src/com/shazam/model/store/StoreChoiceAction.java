// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import java.util.List;

public class StoreChoiceAction
{
    public static class Builder
    {

        public List defaultActions;
        public List staticActions;

        public static Builder a()
        {
            return new Builder();
        }

        static List a(Builder builder)
        {
            return builder.staticActions;
        }

        static List b(Builder builder)
        {
            return builder.defaultActions;
        }

        public Builder()
        {
        }
    }


    public final List defaultActions;
    public final List staticActions;

    private StoreChoiceAction(Builder builder)
    {
        staticActions = Builder.a(builder);
        defaultActions = Builder.b(builder);
    }

}
