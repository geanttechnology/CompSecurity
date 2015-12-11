// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.conn.ClientConnectionOperator;
import cz.msebera.android.httpclient.conn.OperatedClientConnection;
import cz.msebera.android.httpclient.conn.routing.HttpRoute;
import cz.msebera.android.httpclient.conn.routing.RouteTracker;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.Args;
import cz.msebera.android.httpclient.util.Asserts;
import java.io.IOException;
import java.io.InterruptedIOException;

public abstract class AbstractPoolEntry
{

    protected final ClientConnectionOperator connOperator;
    protected final OperatedClientConnection connection;
    protected volatile HttpRoute route;
    protected volatile Object state;
    protected volatile RouteTracker tracker;

    protected AbstractPoolEntry(ClientConnectionOperator clientconnectionoperator, HttpRoute httproute)
    {
        Args.notNull(clientconnectionoperator, "Connection operator");
        connOperator = clientconnectionoperator;
        connection = clientconnectionoperator.createConnection();
        route = httproute;
        tracker = null;
    }

    public Object getState()
    {
        return state;
    }

    public void layerProtocol(HttpContext httpcontext, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(httpparams, "HTTP parameters");
        Asserts.notNull(tracker, "Route tracker");
        Asserts.check(tracker.isConnected(), "Connection not open");
        Asserts.check(tracker.isTunnelled(), "Protocol layering without a tunnel not supported");
        HttpHost httphost;
        boolean flag;
        if (!tracker.isLayered())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Asserts.check(flag, "Multiple protocol layering not supported");
        httphost = tracker.getTargetHost();
        connOperator.updateSecureConnection(connection, httphost, httpcontext, httpparams);
        tracker.layerProtocol(connection.isSecure());
    }

    public void open(HttpRoute httproute, HttpContext httpcontext, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(httproute, "Route");
        Args.notNull(httpparams, "HTTP parameters");
        HttpHost httphost;
        HttpHost httphost1;
        if (tracker != null)
        {
            ClientConnectionOperator clientconnectionoperator;
            OperatedClientConnection operatedclientconnection;
            boolean flag;
            if (!tracker.isConnected())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            Asserts.check(flag, "Connection already open");
        }
        tracker = new RouteTracker(httproute);
        httphost1 = httproute.getProxyHost();
        clientconnectionoperator = connOperator;
        operatedclientconnection = connection;
        if (httphost1 != null)
        {
            httphost = httphost1;
        } else
        {
            httphost = httproute.getTargetHost();
        }
        clientconnectionoperator.openConnection(operatedclientconnection, httphost, httproute.getLocalAddress(), httpcontext, httpparams);
        httproute = tracker;
        if (httproute == null)
        {
            throw new InterruptedIOException("Request aborted");
        }
        if (httphost1 == null)
        {
            httproute.connectTarget(connection.isSecure());
            return;
        } else
        {
            httproute.connectProxy(httphost1, connection.isSecure());
            return;
        }
    }

    public void setState(Object obj)
    {
        state = obj;
    }

    protected void shutdownEntry()
    {
        tracker = null;
        state = null;
    }

    public void tunnelProxy(HttpHost httphost, boolean flag, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(httphost, "Next proxy");
        Args.notNull(httpparams, "Parameters");
        Asserts.notNull(tracker, "Route tracker");
        Asserts.check(tracker.isConnected(), "Connection not open");
        connection.update(null, httphost, flag, httpparams);
        tracker.tunnelProxy(httphost, flag);
    }

    public void tunnelTarget(boolean flag, HttpParams httpparams)
        throws IOException
    {
        Args.notNull(httpparams, "HTTP parameters");
        Asserts.notNull(tracker, "Route tracker");
        Asserts.check(tracker.isConnected(), "Connection not open");
        boolean flag1;
        if (!tracker.isTunnelled())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        Asserts.check(flag1, "Connection is already tunnelled");
        connection.update(null, tracker.getTargetHost(), flag, httpparams);
        tracker.tunnelTarget(flag);
    }
}
