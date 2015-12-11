// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.rdio;

import com.shazam.model.streaming.SubscriptionType;

public class RdioUser
{
    public static class Builder
    {

        public boolean is48hTrialAvailable;
        public SubscriptionType subscriptionType;

        public static Builder a()
        {
            return new Builder();
        }

        static SubscriptionType a(Builder builder)
        {
            return builder.subscriptionType;
        }

        static boolean b(Builder builder)
        {
            return builder.is48hTrialAvailable;
        }

        public Builder()
        {
        }
    }


    public final boolean is48hTrialAvailable;
    public final SubscriptionType subscriptionType;

    private RdioUser(Builder builder)
    {
        subscriptionType = Builder.a(builder);
        is48hTrialAvailable = Builder.b(builder);
    }

}
