// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.cds;

import com.amazon.clouddrive.auth.AuthenticatedURLConnectionFactory;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TraceableMAPAuthenticatedURLConnectionFactory
    implements AuthenticatedURLConnectionFactory
{

    private final AuthenticatedURLConnectionFactory connectionFactory;

    public TraceableMAPAuthenticatedURLConnectionFactory(AuthenticatedURLConnectionFactory authenticatedurlconnectionfactory)
    {
        connectionFactory = authenticatedurlconnectionfactory;
    }

    public HttpURLConnection createHttpURLConnection(URL url)
        throws IOException, CloudDriveException, InterruptedException
    {
        return connectionFactory.createHttpURLConnection(url);
    }
}
