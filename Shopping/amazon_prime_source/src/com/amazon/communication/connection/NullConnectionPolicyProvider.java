// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.connection;

import amazon.communication.Priority;
import amazon.communication.connection.ConnectionPolicy;
import amazon.communication.connection.ConnectionPolicyBuilder;
import amazon.communication.connection.ConnectionPolicyException;

public final class NullConnectionPolicyProvider
{

    public static final NullConnectionPolicyProvider INSTANCE = new NullConnectionPolicyProvider();

    private NullConnectionPolicyProvider()
    {
    }

    public ConnectionPolicy getConnectionPolicy()
        throws ConnectionPolicyException
    {
        return null;
    }

    public ConnectionPolicyBuilder getConnectionPolicyBuilder()
    {
        return new ConnectionPolicyBuilder() {

            final NullConnectionPolicyProvider this$0;

            public ConnectionPolicy build()
            {
                return null;
            }

            public ConnectionPolicyBuilder setCompressionOption(amazon.communication.connection.ConnectionPolicy.CompressionOption compressionoption)
                throws IllegalAccessException
            {
                return this;
            }

            public ConnectionPolicyBuilder setIsAnonymousCredentialsAllowed(boolean flag)
                throws IllegalAccessException
            {
                return this;
            }

            public ConnectionPolicyBuilder setIsClearText(boolean flag)
                throws IllegalAccessException
            {
                return this;
            }

            public ConnectionPolicyBuilder setIsLowLatencyNecessary(boolean flag)
                throws IllegalAccessException
            {
                return this;
            }

            public ConnectionPolicyBuilder setIsRequestResponseOnly(boolean flag)
                throws IllegalAccessException
            {
                return this;
            }

            public ConnectionPolicyBuilder setIsRoamingAllowed(boolean flag)
                throws IllegalAccessException
            {
                return this;
            }

            public ConnectionPolicyBuilder setIsShortLived(boolean flag)
                throws IllegalAccessException
            {
                return this;
            }

            public ConnectionPolicyBuilder setIsWiFiNecessary(boolean flag)
                throws IllegalAccessException
            {
                return this;
            }

            public ConnectionPolicyBuilder setPriority(Priority priority)
                throws IllegalAccessException
            {
                return this;
            }

            public ConnectionPolicyBuilder setPriority(amazon.communication.connection.Priority priority)
                throws IllegalAccessException
            {
                return this;
            }

            
            {
                this$0 = NullConnectionPolicyProvider.this;
                super();
            }
        };
    }

}
