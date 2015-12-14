// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.auth;

import com.amazon.clouddrive.exceptions.CloudDriveException;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public interface AuthenticatedURLConnectionFactory
{

    public abstract HttpURLConnection createHttpURLConnection(URL url)
        throws IOException, CloudDriveException, InterruptedException;
}
