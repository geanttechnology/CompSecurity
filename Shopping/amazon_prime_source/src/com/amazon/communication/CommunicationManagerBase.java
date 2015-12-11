// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.BlockingConnectionListener;
import amazon.communication.CommunicationManager;
import amazon.communication.ConnectionAcquisitionFailedException;
import amazon.communication.MissingCredentialsException;
import amazon.communication.TimeoutException;
import amazon.communication.connection.Connection;
import amazon.communication.connection.ConnectionPolicy;
import amazon.communication.connection.Policy;
import amazon.communication.identity.EndpointIdentity;
import com.amazon.client.metrics.MetricsFactory;

public abstract class CommunicationManagerBase
    implements CommunicationManager
{

    private final MetricsFactory mMetricsFactory;

    public CommunicationManagerBase(MetricsFactory metricsfactory)
    {
        mMetricsFactory = metricsfactory;
    }

    public Connection acquireConnectedConnection(EndpointIdentity endpointidentity, ConnectionPolicy connectionpolicy, amazon.communication.connection.Connection.ConnectionListener connectionlistener, int i)
        throws ConnectionAcquisitionFailedException, MissingCredentialsException
    {
        return acquireConnectedConnection(endpointidentity, (new amazon.communication.connection.Policy.Builder()).fromConnectionPolicy(connectionpolicy), connectionlistener, i);
    }

    public Connection acquireConnectedConnection(EndpointIdentity endpointidentity, Policy policy, amazon.communication.connection.Connection.ConnectionListener connectionlistener, int i)
        throws ConnectionAcquisitionFailedException, MissingCredentialsException
    {
        connectionlistener = new BlockingConnectionListener(connectionlistener, i);
        policy = acquireConnection(endpointidentity, policy, connectionlistener);
        endpointidentity = mMetricsFactory.createMetricEvent("TComm", "CommunicationManagerBase");
        connectionlistener.waitForConnectionOpen(policy, endpointidentity);
        mMetricsFactory.record(endpointidentity);
        return policy;
        connectionlistener;
        policy.release();
        throw new ConnectionAcquisitionFailedException(connectionlistener);
        policy;
        mMetricsFactory.record(endpointidentity);
        throw policy;
        connectionlistener;
        policy.release();
        throw new ConnectionAcquisitionFailedException(connectionlistener);
    }
}
