// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn;

import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.InetAddress;

// Referenced classes of package cz.msebera.android.httpclient.conn:
//            OperatedClientConnection

public interface ClientConnectionOperator
{

    public abstract OperatedClientConnection createConnection();

    public abstract void openConnection(OperatedClientConnection operatedclientconnection, HttpHost httphost, InetAddress inetaddress, HttpContext httpcontext, HttpParams httpparams)
        throws IOException;

    public abstract void updateSecureConnection(OperatedClientConnection operatedclientconnection, HttpHost httphost, HttpContext httpcontext, HttpParams httpparams)
        throws IOException;
}
