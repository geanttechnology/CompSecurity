// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.ConnectionAcquisitionFailedException;
import amazon.communication.DuplicateHandlerException;
import amazon.communication.MessageHandler;
import amazon.communication.MissingCredentialsException;
import amazon.communication.RegistrationFailedException;
import amazon.communication.SecurePortNotDefinedException;
import amazon.communication.TCommServiceDownException;
import amazon.communication.WiFiUnavailableException;
import amazon.communication.connection.Connection;
import amazon.communication.connection.ConnectionPolicy;
import amazon.communication.connection.Policy;
import amazon.communication.identity.EndpointIdentity;
import amazon.communication.identity.IdentityResolver;
import android.os.RemoteException;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.communication.authentication.MapAccountManagerWrapper;
import com.amazon.dp.logger.DPFormattedMessage;
import com.amazon.dp.logger.DPLogger;

// Referenced classes of package com.amazon.communication:
//            CommunicationManagerBase, ConnectionProxy, ParcelableStatus, ParcelableEndpointIdentity, 
//            ParcelablePolicy, ICommunicationService, MessageHandlerProxy

public abstract class TCommManager extends CommunicationManagerBase
{

    private static final DPLogger log = new DPLogger("TComm.TCommManager");
    private final MapAccountManagerWrapper mAccountManager;
    private final IdentityResolver mIdentityResolver;

    public TCommManager(IdentityResolver identityresolver, MapAccountManagerWrapper mapaccountmanagerwrapper, MetricsFactory metricsfactory)
    {
        super(metricsfactory);
        mIdentityResolver = identityresolver;
        mAccountManager = mapaccountmanagerwrapper;
    }

    public Connection acquireConnection(EndpointIdentity endpointidentity, ConnectionPolicy connectionpolicy, amazon.communication.connection.Connection.ConnectionListener connectionlistener)
        throws ConnectionAcquisitionFailedException, MissingCredentialsException
    {
        return acquireConnection(endpointidentity, (new amazon.communication.connection.Policy.Builder()).fromConnectionPolicy(connectionpolicy), connectionlistener);
    }

    public Connection acquireConnection(EndpointIdentity endpointidentity, Policy policy, amazon.communication.connection.Connection.ConnectionListener connectionlistener)
        throws ConnectionAcquisitionFailedException, MissingCredentialsException
    {
        log.verbose("acquireConnection", "acquiring connection", new Object[] {
            "destination", EndpointIdentity.logSafe(endpointidentity), "policy", policy
        });
        if (policy == null)
        {
            throw new IllegalArgumentException("Missing policy");
        }
        if (endpointidentity == null)
        {
            throw new IllegalArgumentException("destination must not be null");
        }
        ConnectionProxy connectionproxy = new ConnectionProxy(policy.isRequestResponseOnly());
        if (connectionlistener == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        connectionproxy.addConnectionListener(connectionlistener);
        connectionlistener = new ParcelableStatus();
        policy = getService().acquireConnectionEx(new ParcelableEndpointIdentity(endpointidentity), new ParcelablePolicy(policy), IConnectionListener.Stub.asInterface(connectionproxy), connectionlistener);
        connectionlistener.getStatusCode();
        JVM INSTR tableswitch 0 8: default 384
    //                   0 225
    //                   1 294
    //                   2 284
    //                   3 294
    //                   4 294
    //                   5 327
    //                   6 339
    //                   7 180
    //                   8 372;
           goto _L1 _L2 _L3 _L4 _L3 _L3 _L5 _L6 _L1 _L7
_L1:
        throw new RuntimeException((new StringBuilder()).append("Invalid acquireConnectionStatus '").append(connectionlistener.getStatusCode()).append("'.").toString());
_L2:
        if (policy == null) goto _L9; else goto _L8
_L8:
        connectionproxy.setConnectionInterface(policy);
        return connectionproxy;
_L9:
        try
        {
            throw new ConnectionAcquisitionFailedException("Null IConnection. This is probably caused by an IPC failure. TComm client and service may not be compatible.");
        }
        // Misplaced declaration of an exception variable
        catch (EndpointIdentity endpointidentity)
        {
            throw new ConnectionAcquisitionFailedException(endpointidentity);
        }
        // Misplaced declaration of an exception variable
        catch (Policy policy)
        {
            log.warn("acquireConnection", "TComm service is down", new Object[] {
                "destination", EndpointIdentity.logSafe(endpointidentity)
            });
        }
        throw new ConnectionAcquisitionFailedException(policy);
_L4:
        throw new MissingCredentialsException("No Amazon account on the device");
_L3:
        throw new ConnectionAcquisitionFailedException(DPFormattedMessage.toDPFormat("acquireConnection", connectionlistener.getStatusMessage(), new Object[] {
            "destination", EndpointIdentity.logSafe(endpointidentity)
        }));
_L5:
        throw new WiFiUnavailableException(connectionlistener.getStatusMessage());
_L6:
        throw new SecurePortNotDefinedException(DPFormattedMessage.toDPFormat("acquireConnection", connectionlistener.getStatusMessage(), new Object[] {
            "destination", EndpointIdentity.logSafe(endpointidentity)
        }));
_L7:
        throw new TCommServiceDownException(connectionlistener.getStatusMessage());
    }

    public void deregisterMessageHandler(int i)
        throws RegistrationFailedException
    {
        try
        {
            getService().deregisterMessageHandler(i);
            return;
        }
        catch (RemoteException remoteexception)
        {
            log.warn("deregisterMessageHandler", "error deregistering handler", new Object[] {
                "channel", Integer.valueOf(i)
            });
            throw new RegistrationFailedException("Unable to contact service");
        }
        catch (TCommServiceDownException tcommservicedownexception)
        {
            log.warn("deregisterMessageHandler", "TComm service is down", new Object[0]);
            throw new RegistrationFailedException(tcommservicedownexception);
        }
    }

    public IdentityResolver getIdentityResolver()
    {
        IdentityResolver identityresolver;
        try
        {
            if (!getService().isInitialized())
            {
                log.warn("getIdentityResolver", "CommunicationService has not finished initialization", new Object[0]);
            }
            identityresolver = mIdentityResolver;
        }
        catch (TCommServiceDownException tcommservicedownexception)
        {
            log.warn("getIdentityResolver", "TComm service is down", new Object[] {
                tcommservicedownexception
            });
            return null;
        }
        catch (RemoteException remoteexception)
        {
            log.warn("getIdentityResolver", "RemoteException while checking CommunicationService status", new Object[] {
                remoteexception
            });
            return null;
        }
        return identityresolver;
    }

    protected abstract ICommunicationService getService()
        throws TCommServiceDownException;

    public void registerMessageHandler(int i, MessageHandler messagehandler)
        throws RegistrationFailedException
    {
        int j;
        try
        {
            j = getService().registerMessageHandler(i, new MessageHandlerProxy(messagehandler));
        }
        // Misplaced declaration of an exception variable
        catch (MessageHandler messagehandler)
        {
            log.warn("registerMessageHandler", "error registering handler", new Object[] {
                "channel", Integer.valueOf(i)
            });
            throw new RegistrationFailedException(messagehandler);
        }
        // Misplaced declaration of an exception variable
        catch (MessageHandler messagehandler)
        {
            log.warn("registerMessageHandler", "TComm service is down", new Object[0]);
            throw new RegistrationFailedException(messagehandler);
        }
        if (j != 0)
        {
            if (j == 2000)
            {
                throw new DuplicateHandlerException("Cannot register duplicate handler");
            } else
            {
                throw new RegistrationFailedException("Internal error during registration");
            }
        } else
        {
            return;
        }
    }

}
