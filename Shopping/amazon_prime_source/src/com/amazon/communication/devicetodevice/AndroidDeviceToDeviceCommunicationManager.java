// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.devicetodevice;

import amazon.communication.CommunicationFactory;
import amazon.communication.CommunicationManager;
import amazon.communication.ConnectionAcquisitionFailedException;
import amazon.communication.Message;
import amazon.communication.MessageHandler;
import amazon.communication.MissingCredentialsException;
import amazon.communication.RegistrationFailedException;
import amazon.communication.RequestFailedException;
import amazon.communication.ServiceConnectedHandler;
import amazon.communication.TCommServiceDownException;
import amazon.communication.TimeoutException;
import amazon.communication.connection.Policy;
import amazon.communication.connection.Purpose;
import amazon.communication.devicetodevice.DeviceToDeviceCommunicationManager;
import amazon.communication.devicetodevice.NotificationServiceException;
import amazon.communication.devicetodevice.WakeupConnection;
import amazon.communication.identity.DeviceIdentity;
import amazon.communication.identity.EndpointIdentity;
import amazon.communication.identity.EndpointIdentityFactory;
import amazon.communication.srr.SrrManager;
import android.content.Context;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.communication.AndroidTCommServiceConnection;
import com.amazon.communication.ICommunicationService;
import com.amazon.dp.logger.DPLogger;
import com.dp.framework.StreamCodec;
import java.io.UnsupportedEncodingException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

// Referenced classes of package com.amazon.communication.devicetodevice:
//            WakeupConnectionImpl, D2DApplicationProtocol

public class AndroidDeviceToDeviceCommunicationManager
    implements DeviceToDeviceCommunicationManager
{
    private class EncodeOnlyDeviceD2DApplicationProtocol extends D2DApplicationProtocol
    {

        final AndroidDeviceToDeviceCommunicationManager this$0;

        public void decode(Message message, EndpointIdentity endpointidentity)
        {
            throw new UnsupportedOperationException("This class can only encode!");
        }

        public EncodeOnlyDeviceD2DApplicationProtocol(StreamCodec streamcodec)
        {
            this$0 = AndroidDeviceToDeviceCommunicationManager.this;
            super(streamcodec);
        }
    }


    private static final DPLogger log = new DPLogger("TComm.AndroidDeviceToDeviceCommunicationManager");
    private CommunicationManager mCommunicationManager;
    private final Context mContext;
    private final D2DApplicationProtocol mD2DProtocol;
    private final Policy mPolicy;
    protected final AndroidTCommServiceConnection mServiceConnection;
    private final String mThisApplication;

    public AndroidDeviceToDeviceCommunicationManager(Context context, String s, MetricsFactory metricsfactory, StreamCodec streamcodec)
    {
        mPolicy = (new amazon.communication.connection.Policy.Builder()).setIsLowLatencyNecessary(false).setPurpose(Purpose.D2D_MESSAGING).build();
        if (s == null)
        {
            throw new IllegalArgumentException("applicationIdentifier must not be null");
        } else
        {
            mThisApplication = s;
            mContext = context;
            mServiceConnection = new AndroidTCommServiceConnection(context);
            mServiceConnection.bindTCommService();
            mD2DProtocol = new EncodeOnlyDeviceD2DApplicationProtocol(streamcodec);
            return;
        }
    }

    public WakeupConnection acquireWakeupConnection(DeviceIdentity deviceidentity, amazon.communication.connection.Connection.ConnectionListener connectionlistener)
        throws ConnectionAcquisitionFailedException, MissingCredentialsException
    {
        return new WakeupConnectionImpl(mCommunicationManager.acquireConnection(deviceidentity, mPolicy, connectionlistener), mD2DProtocol, deviceidentity, mThisApplication);
    }

    public void close()
    {
        mServiceConnection.unbindTCommService();
    }

    public void deregisterMessageHandler()
    {
    }

    protected ICommunicationService getService()
        throws TCommServiceDownException
    {
        ICommunicationService icommunicationservice = com.amazon.communication.ICommunicationService.Stub.asInterface(mServiceConnection.getBinder());
        if (icommunicationservice == null)
        {
            throw new TCommServiceDownException("acquired null instance of ICommunicationService");
        } else
        {
            return icommunicationservice;
        }
    }

    public void initializeD2DCommunication()
        throws ConnectionAcquisitionFailedException
    {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void notifyRemoteDeviceForD2DCommunication(DeviceIdentity deviceidentity, String s, String s1)
        throws NotificationServiceException, MissingCredentialsException
    {
        SrrManager srrmanager = CommunicationFactory.getSrrManager(mContext);
        amazon.communication.identity.ServiceIdentity serviceidentity = EndpointIdentityFactory.createServiceIdentity("D2DNotificationService");
        HttpPost httppost = new HttpPost("/makeD2DConnectionRequest");
        String s2 = deviceidentity.getDeviceType();
        deviceidentity = deviceidentity.getDeviceSerialNumber();
        deviceidentity = (new StringBuilder()).append("{\"sourceApplication\": \"").append(mThisApplication).append("\", \"targetDevice\":   {\"deviceType\": \"").append(s2).append("\", \"deviceSerial\": \"").append(deviceidentity).append("\"}, \"targetApplication\": \"").append(s).append("\", \"extra\": \"").append(s1).append("\"}").toString();
        try
        {
            httppost.setEntity(new StringEntity(deviceidentity));
        }
        // Misplaced declaration of an exception variable
        catch (DeviceIdentity deviceidentity)
        {
            throw new IllegalStateException(deviceidentity);
        }
        try
        {
            deviceidentity = (new amazon.communication.srr.SrrRequest.Builder()).setRequest(httppost).setEndpointIdentity(serviceidentity).build();
        }
        // Misplaced declaration of an exception variable
        catch (DeviceIdentity deviceidentity)
        {
            throw new NotificationServiceException(deviceidentity);
        }
        try
        {
            srrmanager.makeRequestSync(deviceidentity);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (DeviceIdentity deviceidentity)
        {
            throw new NotificationServiceException(deviceidentity);
        }
        // Misplaced declaration of an exception variable
        catch (DeviceIdentity deviceidentity)
        {
            throw new NotificationServiceException(deviceidentity);
        }
    }

    public void registerMessageHandler(MessageHandler messagehandler)
        throws RegistrationFailedException
    {
    }

    public void registerServiceConnectedHandler(ServiceConnectedHandler serviceconnectedhandler)
    {
        mServiceConnection.registerServiceConnectedHandler(serviceconnectedhandler);
    }

    public void setCommunicationManager(CommunicationManager communicationmanager)
    {
        mCommunicationManager = communicationmanager;
    }

    public void shutdownD2DCommunication()
    {
        close();
    }

}
