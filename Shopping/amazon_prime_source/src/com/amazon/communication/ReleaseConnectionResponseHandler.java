// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.RequestFailedException;
import amazon.communication.ResponseHandler;
import amazon.communication.connection.Connection;
import amazon.communication.identity.EndpointIdentity;
import com.amazon.dp.logger.DPLogger;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpRequestBase;

public class ReleaseConnectionResponseHandler
    implements ResponseHandler
{

    private static final DPLogger log = new DPLogger("TComm.ReleaseConnectionResponseHandler");
    private Connection mConnection;
    private ResponseHandler mDecoratedResponseHandler;

    public ReleaseConnectionResponseHandler(Connection connection, ResponseHandler responsehandler)
    {
        if (connection == null)
        {
            throw new IllegalArgumentException("Connection can not be null");
        }
        if (responsehandler == null)
        {
            throw new IllegalArgumentException("Decorated ResponseHandler can not be null");
        } else
        {
            mConnection = connection;
            mDecoratedResponseHandler = responsehandler;
            return;
        }
    }

    private void releaseConnection()
    {
        this;
        JVM INSTR monitorenter ;
        if (mConnection == null) goto _L2; else goto _L1
_L1:
        log.verbose("releaseConnection", "releasing", new Object[] {
            "mConnection", mConnection
        });
        mConnection.release();
        mConnection = null;
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        log.verbose("releaseConnection", "connection is already released", new Object[0]);
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void onError(HttpRequestBase httprequestbase, RequestFailedException requestfailedexception)
    {
        if (mDecoratedResponseHandler == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        mDecoratedResponseHandler.onError(httprequestbase, requestfailedexception);
        releaseConnection();
        mDecoratedResponseHandler = null;
        return;
        throw new IllegalStateException((new StringBuilder()).append("onResponse/onError has already been invoked for the ResponseHandler:").append(this).toString());
        httprequestbase;
        releaseConnection();
        mDecoratedResponseHandler = null;
        throw httprequestbase;
    }

    public void onResponse(EndpointIdentity endpointidentity, HttpResponse httpresponse, int i, List list)
    {
        if (mDecoratedResponseHandler == null)
        {
            break MISSING_BLOCK_LABEL_31;
        }
        mDecoratedResponseHandler.onResponse(endpointidentity, httpresponse, i, list);
        releaseConnection();
        mDecoratedResponseHandler = null;
        return;
        throw new IllegalStateException((new StringBuilder()).append("onResponse/onError has already been invoked for the ResponseHandler:").append(this).toString());
        endpointidentity;
        releaseConnection();
        mDecoratedResponseHandler = null;
        throw endpointidentity;
    }

}
