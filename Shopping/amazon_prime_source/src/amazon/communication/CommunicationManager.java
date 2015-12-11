// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;

import amazon.communication.connection.Connection;
import amazon.communication.connection.Policy;
import amazon.communication.identity.EndpointIdentity;
import amazon.communication.identity.IdentityResolver;

// Referenced classes of package amazon.communication:
//            ConnectionAcquisitionFailedException, MissingCredentialsException, RegistrationFailedException, MessageHandler

public interface CommunicationManager
{

    public abstract Connection acquireConnectedConnection(EndpointIdentity endpointidentity, Policy policy, amazon.communication.connection.Connection.ConnectionListener connectionlistener, int i)
        throws ConnectionAcquisitionFailedException, MissingCredentialsException;

    public abstract Connection acquireConnection(EndpointIdentity endpointidentity, Policy policy, amazon.communication.connection.Connection.ConnectionListener connectionlistener)
        throws ConnectionAcquisitionFailedException, MissingCredentialsException;

    public abstract void deregisterMessageHandler(int i)
        throws RegistrationFailedException;

    public abstract IdentityResolver getIdentityResolver();

    public abstract void registerMessageHandler(int i, MessageHandler messagehandler)
        throws RegistrationFailedException;
}
