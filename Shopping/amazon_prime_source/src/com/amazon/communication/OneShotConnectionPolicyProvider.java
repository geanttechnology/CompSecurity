// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.connection.ConnectionPolicy;
import amazon.communication.connection.ConnectionPolicyBuilder;
import amazon.communication.connection.ConnectionPolicyException;

// Referenced classes of package com.amazon.communication:
//            SimpleConnectionPolicyBuilder

public class OneShotConnectionPolicyProvider
{

    private final ConnectionPolicy mOneShotPolicy;

    public OneShotConnectionPolicyProvider()
        throws ConnectionPolicyException
    {
        try
        {
            mOneShotPolicy = getConnectionPolicyBuilder().setIsRoamingAllowed(true).setIsShortLived(true).setIsLowLatencyNecessary(false).setIsRequestResponseOnly(true).setIsClearText(true).build();
            return;
        }
        catch (IllegalAccessException illegalaccessexception)
        {
            throw new ConnectionPolicyException(illegalaccessexception);
        }
    }

    public ConnectionPolicy getConnectionPolicy()
    {
        return mOneShotPolicy;
    }

    public ConnectionPolicyBuilder getConnectionPolicyBuilder()
    {
        return new SimpleConnectionPolicyBuilder();
    }
}
