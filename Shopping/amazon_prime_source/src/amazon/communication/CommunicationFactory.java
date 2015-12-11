// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package amazon.communication;

import amazon.communication.connection.Policy;
import amazon.communication.devicetodevice.DeviceToDeviceCommunicationManager;
import amazon.communication.identity.IdentityResolver;
import amazon.communication.srr.DeviceTCommSrrManager;
import amazon.communication.srr.SrrManager;
import android.content.Context;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.client.metrics.NullMetricsFactory;
import com.amazon.communication.AndroidTCommManager;
import com.amazon.communication.authentication.DcpOAuthRequestSigner;
import com.amazon.communication.authentication.DcpRequestSigner;
import com.amazon.dp.logger.DPLogger;
import com.dp.utils.FailFast;

// Referenced classes of package amazon.communication:
//            CommunicationManager

public final class CommunicationFactory
{

    private static final MetricsFactory NULL_METRICS_FACTORY = new NullMetricsFactory();
    private static final DPLogger log = new DPLogger("TComm.CommunicationFactory");
    private static AndroidTCommManager sCommunicationManager = null;
    private static DeviceToDeviceCommunicationManager sD2dCommunicationManager = null;
    private static DcpOAuthRequestSigner sDcpOAuthRequestSigner = null;
    private static DcpRequestSigner sDcpRequestSigner = null;
    private static IdentityResolver sIdentityResolver = null;
    private static SrrManager sSrrManager = null;

    public CommunicationFactory()
    {
    }

    public static CommunicationManager getCommunicationManager(Context context)
    {
        amazon/communication/CommunicationFactory;
        JVM INSTR monitorenter ;
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("Context must not be null");
        context;
        amazon/communication/CommunicationFactory;
        JVM INSTR monitorexit ;
        throw context;
        if (sCommunicationManager == null)
        {
            MetricsFactory metricsfactory = getMetricsFactory(context, "getCommunicationManager");
            sCommunicationManager = new AndroidTCommManager(context.getApplicationContext(), metricsfactory);
        }
        context = sCommunicationManager;
        amazon/communication/CommunicationFactory;
        JVM INSTR monitorexit ;
        return context;
    }

    private static MetricsFactory getMetricsFactory(Context context, String s)
    {
        s = null;
        try
        {
            context = AndroidMetricsFactoryImpl.getInstance(context.getApplicationContext());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            log.warn("getCommunicationManager", "exception getting MetricsFactory instance", new Object[] {
                context
            });
            context = s;
        }
        s = context;
        if (context == null)
        {
            log.warn("getCommunicationManager", "failed to obtain MetricsFactory instance - will use NullMetricsFactory instead", new Object[0]);
            s = NULL_METRICS_FACTORY;
        }
        return s;
    }

    public static SrrManager getSrrManager(Context context)
    {
        amazon/communication/CommunicationFactory;
        JVM INSTR monitorenter ;
        if (context != null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        throw new IllegalArgumentException("Context must not be null");
        context;
        amazon/communication/CommunicationFactory;
        JVM INSTR monitorexit ;
        throw context;
        if (sSrrManager == null)
        {
            sSrrManager = new DeviceTCommSrrManager(getCommunicationManager(context), Policy.ONE_SHOT);
        }
        FailFast.expectNotNull(sSrrManager, new Object[] {
            "Unable to get SrrManager implementation"
        });
        context = sSrrManager;
        amazon/communication/CommunicationFactory;
        JVM INSTR monitorexit ;
        return context;
    }

}
