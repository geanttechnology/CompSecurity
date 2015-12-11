// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.client.methods;

import com.comcast.cim.httpcomponentsandroid.ProtocolVersion;
import com.comcast.cim.httpcomponentsandroid.RequestLine;
import com.comcast.cim.httpcomponentsandroid.client.utils.CloneUtils;
import com.comcast.cim.httpcomponentsandroid.conn.ClientConnectionRequest;
import com.comcast.cim.httpcomponentsandroid.conn.ConnectionReleaseTrigger;
import com.comcast.cim.httpcomponentsandroid.message.AbstractHttpMessage;
import com.comcast.cim.httpcomponentsandroid.message.BasicRequestLine;
import com.comcast.cim.httpcomponentsandroid.message.HeaderGroup;
import com.comcast.cim.httpcomponentsandroid.params.HttpParams;
import com.comcast.cim.httpcomponentsandroid.params.HttpProtocolParams;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.client.methods:
//            AbortableHttpRequest, HttpUriRequest

public abstract class HttpRequestBase extends AbstractHttpMessage
    implements AbortableHttpRequest, HttpUriRequest, Cloneable
{

    private Lock abortLock;
    private boolean aborted;
    private ClientConnectionRequest connRequest;
    private ConnectionReleaseTrigger releaseTrigger;
    private URI uri;

    public HttpRequestBase()
    {
        abortLock = new ReentrantLock();
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        HttpRequestBase httprequestbase = (HttpRequestBase)super.clone();
        httprequestbase.abortLock = new ReentrantLock();
        httprequestbase.aborted = false;
        httprequestbase.releaseTrigger = null;
        httprequestbase.connRequest = null;
        httprequestbase.headergroup = (HeaderGroup)CloneUtils.clone(headergroup);
        httprequestbase.params = (HttpParams)CloneUtils.clone(params);
        return httprequestbase;
    }

    public abstract String getMethod();

    public ProtocolVersion getProtocolVersion()
    {
        return HttpProtocolParams.getVersion(getParams());
    }

    public RequestLine getRequestLine()
    {
        Object obj;
        String s1;
        ProtocolVersion protocolversion;
label0:
        {
            s1 = getMethod();
            protocolversion = getProtocolVersion();
            obj = getURI();
            String s = null;
            if (obj != null)
            {
                s = ((URI) (obj)).toASCIIString();
            }
            if (s != null)
            {
                obj = s;
                if (s.length() != 0)
                {
                    break label0;
                }
            }
            obj = "/";
        }
        return new BasicRequestLine(s1, ((String) (obj)), protocolversion);
    }

    public URI getURI()
    {
        return uri;
    }

    public boolean isAborted()
    {
        return aborted;
    }

    public void setConnectionRequest(ClientConnectionRequest clientconnectionrequest)
        throws IOException
    {
        abortLock.lock();
        if (aborted)
        {
            throw new IOException("Request already aborted");
        }
        break MISSING_BLOCK_LABEL_38;
        clientconnectionrequest;
        abortLock.unlock();
        throw clientconnectionrequest;
        releaseTrigger = null;
        connRequest = clientconnectionrequest;
        abortLock.unlock();
        return;
    }

    public void setReleaseTrigger(ConnectionReleaseTrigger connectionreleasetrigger)
        throws IOException
    {
        abortLock.lock();
        if (aborted)
        {
            throw new IOException("Request already aborted");
        }
        break MISSING_BLOCK_LABEL_38;
        connectionreleasetrigger;
        abortLock.unlock();
        throw connectionreleasetrigger;
        connRequest = null;
        releaseTrigger = connectionreleasetrigger;
        abortLock.unlock();
        return;
    }

    public void setURI(URI uri1)
    {
        uri = uri1;
    }
}
