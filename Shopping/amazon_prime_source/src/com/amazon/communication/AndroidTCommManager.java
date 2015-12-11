// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.ConnectionAcquisitionFailedException;
import amazon.communication.DuplicateHandlerException;
import amazon.communication.GatewayConnectivity;
import amazon.communication.MissingCredentialsException;
import amazon.communication.RegistrationFailedException;
import amazon.communication.RemoteCommunicationManager;
import amazon.communication.ServiceConnectedHandler;
import amazon.communication.ServiceConnectivityListener;
import amazon.communication.TCommServiceDownException;
import amazon.communication.connection.Policy;
import amazon.communication.identity.EndpointIdentity;
import amazon.communication.rlm.AckHandler;
import amazon.communication.rlm.ReliableCommunicationManager;
import amazon.communication.rlm.ReliableConnection;
import android.content.Context;
import android.os.RemoteException;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.communication.rlm.AckHandlerProxy;
import com.amazon.dp.logger.DPLogger;

// Referenced classes of package com.amazon.communication:
//            TCommManager, AndroidIdentityResolver, AndroidTCommServiceConnection, GatewayConnectivityImpl, 
//            ParcelableStatus, ICommunicationService

public class AndroidTCommManager extends TCommManager
    implements RemoteCommunicationManager, ReliableCommunicationManager, android.os.IBinder.DeathRecipient
{

    private static final DPLogger log = new DPLogger("TComm.AndroidTCommManager");
    private GatewayConnectivityImpl mGatewayConnectivity;
    private Object mGatewayConnectivityLock;
    protected final AndroidTCommServiceConnection mServiceConnection;

    public AndroidTCommManager(Context context, MetricsFactory metricsfactory)
    {
        super(new AndroidIdentityResolver(context), null, metricsfactory);
        mGatewayConnectivityLock = new Object();
        mServiceConnection = new AndroidTCommServiceConnection(context);
        mServiceConnection.bindTCommService();
    }

    private void resetGatewayConnectivity()
    {
        synchronized (mGatewayConnectivityLock)
        {
            mGatewayConnectivity = null;
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public ReliableConnection acquireConnectedReliableConnection(EndpointIdentity endpointidentity, Policy policy, amazon.communication.connection.Connection.ConnectionListener connectionlistener, int i)
        throws ConnectionAcquisitionFailedException, MissingCredentialsException
    {
        return (ReliableConnection)acquireConnectedConnection(endpointidentity, policy, connectionlistener, i);
    }

    public ReliableConnection acquireReliableConnection(EndpointIdentity endpointidentity, Policy policy, amazon.communication.connection.Connection.ConnectionListener connectionlistener)
        throws ConnectionAcquisitionFailedException, MissingCredentialsException
    {
        return (ReliableConnection)acquireConnection(endpointidentity, policy, connectionlistener);
    }

    public void binderDied()
    {
        resetGatewayConnectivity();
    }

    public void close()
    {
        mServiceConnection.unbindTCommService();
    }

    public void deregisterServiceConnectivityListener(ServiceConnectivityListener serviceconnectivitylistener)
    {
        mServiceConnection.deregisterServiceConnectivityListener(serviceconnectivitylistener);
    }

    public GatewayConnectivity getGatewayConnectivity()
        throws TCommServiceDownException
    {
        Object obj = mGatewayConnectivityLock;
        obj;
        JVM INSTR monitorenter ;
        Object obj1;
        IGatewayConnectivity igatewayconnectivity;
        if (mGatewayConnectivity != null)
        {
            break MISSING_BLOCK_LABEL_77;
        }
        mGatewayConnectivity = new GatewayConnectivityImpl();
        obj1 = new ParcelableStatus();
        igatewayconnectivity = getService().getGatewayConnectivity(IConnectionListener.Stub.asInterface(mGatewayConnectivity), ((ParcelableStatus) (obj1)));
        if (igatewayconnectivity == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        mGatewayConnectivity.setGatewayConnectivityInterface(igatewayconnectivity);
        log.debug("getGatewayConnectivity", "gateway connectivity object created", new Object[0]);
        obj;
        JVM INSTR monitorexit ;
        try
        {
            obj = mGatewayConnectivity;
        }
        catch (RemoteException remoteexception)
        {
            resetGatewayConnectivity();
            throw new TCommServiceDownException(remoteexception);
        }
        return ((GatewayConnectivity) (obj));
        if (((ParcelableStatus) (obj1)).getStatusCode() == 8)
        {
            resetGatewayConnectivity();
            throw new TCommServiceDownException(((ParcelableStatus) (obj1)).getStatusMessage());
        }
        break MISSING_BLOCK_LABEL_130;
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
        resetGatewayConnectivity();
        throw new TCommServiceDownException((new StringBuilder()).append("Unknown error occurred getting the GatewayConnectivity object from the service: ").append(((ParcelableStatus) (obj1)).getStatusMessage()).toString());
    }

    protected ICommunicationService getService()
        throws TCommServiceDownException
    {
        ICommunicationService icommunicationservice = ICommunicationService.Stub.asInterface(mServiceConnection.getBinder());
        if (icommunicationservice == null)
        {
            throw new TCommServiceDownException("acquired null instance of ICommunicationService");
        } else
        {
            return icommunicationservice;
        }
    }

    public void registerServiceConnectedHandler(ServiceConnectedHandler serviceconnectedhandler)
    {
        mServiceConnection.registerServiceConnectedHandler(serviceconnectedhandler);
    }

    public void registerServiceConnectivityListener(ServiceConnectivityListener serviceconnectivitylistener)
    {
        mServiceConnection.registerServiceConnectivityListener(serviceconnectivitylistener);
    }

    public void removeAckHandler()
        throws RegistrationFailedException
    {
        try
        {
            getService().removeAckHandler();
            return;
        }
        catch (RemoteException remoteexception)
        {
            log.warn("removeAckHandler", "error deregistering handler", new Object[0]);
            throw new RegistrationFailedException("Unable to contact service");
        }
        catch (TCommServiceDownException tcommservicedownexception)
        {
            log.warn("removeAckHander", "TComm service is down", new Object[0]);
            throw new RegistrationFailedException(tcommservicedownexception);
        }
    }

    public void setAckHandler(AckHandler ackhandler)
        throws RegistrationFailedException
    {
        int i;
        try
        {
            i = getService().setAckHandler(new AckHandlerProxy(ackhandler));
        }
        // Misplaced declaration of an exception variable
        catch (AckHandler ackhandler)
        {
            log.warn("setAckHandler", "error registering handler", new Object[0]);
            throw new RegistrationFailedException(ackhandler);
        }
        // Misplaced declaration of an exception variable
        catch (AckHandler ackhandler)
        {
            log.warn("setAckHandler", "TComm service is down", new Object[0]);
            throw new RegistrationFailedException(ackhandler);
        }
        if (i != 0)
        {
            if (i == 2000)
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
