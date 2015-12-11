// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.content.Context;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.content.ResultStatusOwner;
import java.io.IOException;
import java.net.URL;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            Response, AsBeaconManager, AsBeacon, LogTrackError, 
//            IHeaders

public abstract class Request
{
    public static interface Recoverable
    {

        public abstract void clearResponse();

        public abstract int getRetryCount();

        public abstract boolean hasRecoverableError(Response response, IOException ioexception);
    }


    private static final String SUFFIX = "Request";
    protected AsBeacon beacon;
    private volatile transient EbayContext context;
    private transient boolean gzipCompress;
    private transient String operationName;
    private transient String serviceName;
    protected transient int timeout;

    protected Request()
    {
        timeout = 60000;
        String s = getClass().getSimpleName();
        if (s.endsWith("Request"))
        {
            operationName = s.substring(0, s.length() - "Request".length());
        }
    }

    protected Request(String s, String s1)
    {
        timeout = 60000;
        setServiceName(s);
        setOperationName(s1);
    }

    public void appendErrorData(LogTrackError logtrackerror, Response response, IOException ioexception)
    {
    }

    public byte[] buildRequest()
        throws Connector.BuildRequestDataException
    {
        return null;
    }

    public final Context getContext()
    {
        if (context != null)
        {
            return (Context)context.getExtension(android/content/Context);
        } else
        {
            return null;
        }
    }

    public final EbayContext getEbayContext()
    {
        return context;
    }

    protected final com.ebay.nautilus.kernel.content.ResultStatus.Message getFirstResponseError(Response response)
    {
        if (response == null)
        {
            return null;
        } else
        {
            return response.getResultStatus().getFirstError();
        }
    }

    public String getHttpMethod()
    {
        return null;
    }

    public String getOperationName()
    {
        return operationName;
    }

    public abstract URL getRequestUrl();

    public abstract Response getResponse();

    public String getServiceName()
    {
        return serviceName;
    }

    public final int getTimeout()
    {
        return timeout;
    }

    public abstract String getUserAgent();

    protected void initialize(ResultStatusOwner resultstatusowner)
        throws InterruptedException
    {
        if (context != null)
        {
            resultstatusowner = (AsBeaconManager)context.getExtension(com/ebay/nautilus/kernel/net/AsBeaconManager);
            if (resultstatusowner != null)
            {
                beacon = resultstatusowner.currentBeacon();
            }
        }
    }

    public boolean isErrorReportable()
    {
        return true;
    }

    protected final boolean isGzipCompress()
    {
        return gzipCompress;
    }

    public boolean isTrafficReportable()
    {
        return true;
    }

    public void onAddHeaders(IHeaders iheaders)
    {
    }

    final void setContext(EbayContext ebaycontext)
    {
        context = ebaycontext;
    }

    protected final void setGzipCompress(boolean flag)
    {
        gzipCompress = flag;
    }

    public void setOperationName(String s)
    {
        if (s == null)
        {
            throw new IllegalArgumentException("Operation name cannot be null");
        } else
        {
            operationName = s;
            return;
        }
    }

    public void setServiceName(String s)
    {
        serviceName = s;
    }

    public final void setTimeout(int i)
    {
        timeout = i;
    }

    public void validateFailure(EbayContext ebaycontext, Response response)
        throws InterruptedException
    {
    }
}
