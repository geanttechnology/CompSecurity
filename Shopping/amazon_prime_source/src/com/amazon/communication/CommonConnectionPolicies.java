// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.connection.ConnectionPolicy;
import amazon.communication.connection.ConnectionPolicyBuilder;
import amazon.communication.connection.ConnectionPolicyException;

public class CommonConnectionPolicies
{

    public CommonConnectionPolicies()
    {
    }

    public static ConnectionPolicy createConnectionPolicyFastBidirectional(ConnectionPolicyBuilder connectionpolicybuilder)
        throws ConnectionPolicyException
    {
        try
        {
            connectionpolicybuilder = connectionpolicybuilder.setIsRoamingAllowed(true).setIsShortLived(false).setIsLowLatencyNecessary(true).setIsRequestResponseOnly(false).build();
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionPolicyBuilder connectionpolicybuilder)
        {
            throw new ConnectionPolicyException(connectionpolicybuilder);
        }
        return connectionpolicybuilder;
    }

    public static ConnectionPolicy createConnectionPolicyFrequentFireAndForget(ConnectionPolicyBuilder connectionpolicybuilder)
        throws ConnectionPolicyException
    {
        try
        {
            connectionpolicybuilder = connectionpolicybuilder.setIsRoamingAllowed(false).setIsShortLived(false).setIsLowLatencyNecessary(false).setIsRequestResponseOnly(false).build();
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionPolicyBuilder connectionpolicybuilder)
        {
            throw new ConnectionPolicyException(connectionpolicybuilder);
        }
        return connectionpolicybuilder;
    }

    public static ConnectionPolicy createConnectionPolicyOccasionalFireAndForget(ConnectionPolicyBuilder connectionpolicybuilder)
        throws ConnectionPolicyException
    {
        try
        {
            connectionpolicybuilder = connectionpolicybuilder.setIsRoamingAllowed(false).setIsShortLived(true).setIsLowLatencyNecessary(false).setIsRequestResponseOnly(false).build();
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionPolicyBuilder connectionpolicybuilder)
        {
            throw new ConnectionPolicyException(connectionpolicybuilder);
        }
        return connectionpolicybuilder;
    }

    public static ConnectionPolicy createConnectionPolicyOneShotRequest(ConnectionPolicyBuilder connectionpolicybuilder)
        throws ConnectionPolicyException
    {
        try
        {
            connectionpolicybuilder = connectionpolicybuilder.setIsRoamingAllowed(true).setIsShortLived(true).setIsLowLatencyNecessary(false).setIsRequestResponseOnly(true).build();
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionPolicyBuilder connectionpolicybuilder)
        {
            throw new ConnectionPolicyException(connectionpolicybuilder);
        }
        return connectionpolicybuilder;
    }

    public static ConnectionPolicy createConnectionPolicySharedBidirectional(ConnectionPolicyBuilder connectionpolicybuilder)
        throws ConnectionPolicyException
    {
        try
        {
            connectionpolicybuilder = connectionpolicybuilder.setIsRoamingAllowed(true).setIsShortLived(false).setIsLowLatencyNecessary(true).setIsRequestResponseOnly(false).build();
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionPolicyBuilder connectionpolicybuilder)
        {
            throw new ConnectionPolicyException(connectionpolicybuilder);
        }
        return connectionpolicybuilder;
    }
}
