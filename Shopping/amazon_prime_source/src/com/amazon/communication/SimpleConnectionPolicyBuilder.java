// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.Priority;
import amazon.communication.connection.ConnectionPolicy;
import amazon.communication.connection.ConnectionPolicyBuilder;

// Referenced classes of package com.amazon.communication:
//            SimpleConnectionPolicy

public class SimpleConnectionPolicyBuilder
    implements ConnectionPolicyBuilder
{

    protected final SimpleConnectionPolicy mPolicy = constructPolicy();

    public SimpleConnectionPolicyBuilder()
    {
    }

    public ConnectionPolicy build()
    {
        mPolicy.setIsInstanceLocked(true);
        return mPolicy;
    }

    protected SimpleConnectionPolicy constructPolicy()
    {
        return new SimpleConnectionPolicy();
    }

    public ConnectionPolicyBuilder setCompressionOption(amazon.communication.connection.ConnectionPolicy.CompressionOption compressionoption)
        throws IllegalAccessException
    {
        if (mPolicy.isInstanceLocked())
        {
            throw new IllegalAccessException();
        } else
        {
            mPolicy.setCompressionOption(compressionoption);
            return this;
        }
    }

    public ConnectionPolicyBuilder setIsAnonymousCredentialsAllowed(boolean flag)
        throws IllegalAccessException
    {
        if (mPolicy.isInstanceLocked())
        {
            throw new IllegalAccessException();
        } else
        {
            mPolicy.setIsAnonymousCredentialsAllowed(flag);
            return this;
        }
    }

    public ConnectionPolicyBuilder setIsClearText(boolean flag)
        throws IllegalAccessException
    {
        if (mPolicy.isInstanceLocked())
        {
            throw new IllegalAccessException();
        } else
        {
            mPolicy.setIsClearText(flag);
            return this;
        }
    }

    public ConnectionPolicyBuilder setIsLowLatencyNecessary(boolean flag)
        throws IllegalAccessException
    {
        if (mPolicy.isInstanceLocked())
        {
            throw new IllegalAccessException();
        } else
        {
            mPolicy.setIsLowLatencyNecessary(flag);
            return this;
        }
    }

    public ConnectionPolicyBuilder setIsRequestResponseOnly(boolean flag)
        throws IllegalAccessException
    {
        if (mPolicy.isInstanceLocked())
        {
            throw new IllegalAccessException();
        } else
        {
            mPolicy.setIsRequestResponseOnly(flag);
            return this;
        }
    }

    public ConnectionPolicyBuilder setIsRoamingAllowed(boolean flag)
        throws IllegalAccessException
    {
        if (mPolicy.isInstanceLocked())
        {
            throw new IllegalAccessException();
        } else
        {
            mPolicy.setIsRoamingAllowed(flag);
            return this;
        }
    }

    public ConnectionPolicyBuilder setIsShortLived(boolean flag)
        throws IllegalAccessException
    {
        if (mPolicy.isInstanceLocked())
        {
            throw new IllegalAccessException();
        } else
        {
            mPolicy.setIsShortLived(flag);
            return this;
        }
    }

    public ConnectionPolicyBuilder setIsWiFiNecessary(boolean flag)
        throws IllegalAccessException
    {
        if (mPolicy.isInstanceLocked())
        {
            throw new IllegalAccessException();
        } else
        {
            mPolicy.setIsWiFiNecessary(flag);
            return this;
        }
    }

    public ConnectionPolicyBuilder setPriority(Priority priority)
        throws IllegalAccessException
    {
        return setPriority(priority.convertToConnectionPriority());
    }

    public ConnectionPolicyBuilder setPriority(amazon.communication.connection.Priority priority)
        throws IllegalAccessException
    {
        if (mPolicy.isInstanceLocked())
        {
            throw new IllegalAccessException();
        } else
        {
            mPolicy.setPriority(priority);
            return this;
        }
    }
}
