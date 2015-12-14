// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.internal;

import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.exceptions.NoRetryException;
import com.amazon.clouddrive.internal.utils.Closer;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;

// Referenced classes of package com.amazon.clouddrive.internal:
//            PostRequestWriter

class BodyConnectionHelper
{

    static void addPostInput(HttpURLConnection httpurlconnection, PostRequestWriter postrequestwriter)
        throws CloudDriveException, InterruptedException
    {
        OutputStream outputstream;
        OutputStream outputstream1;
        OutputStream outputstream2;
        outputstream = null;
        outputstream2 = null;
        outputstream1 = null;
        OutputStream outputstream3 = httpurlconnection.getOutputStream();
        outputstream1 = outputstream3;
        outputstream = outputstream3;
        outputstream2 = outputstream3;
        httpurlconnection.connect();
        outputstream1 = outputstream3;
        outputstream = outputstream3;
        outputstream2 = outputstream3;
        postrequestwriter.writeRequest(outputstream3);
        outputstream1 = outputstream3;
        outputstream = outputstream3;
        outputstream2 = outputstream3;
        outputstream3.flush();
        Closer.closeQuietly(outputstream3);
        return;
        httpurlconnection;
        outputstream = outputstream1;
        throw new InterruptedException();
        httpurlconnection;
        Closer.closeQuietly(outputstream);
        throw httpurlconnection;
        httpurlconnection;
        outputstream = outputstream2;
        throw new NoRetryException("Failed to write request to connection.");
    }

    static void setConnectionParameters(HttpURLConnection httpurlconnection, String s)
        throws ProtocolException
    {
        if ("PATCH".equals(s))
        {
            httpurlconnection.setRequestMethod("POST");
            httpurlconnection.addRequestProperty("X-HTTP-Method-Override", "PATCH");
        } else
        {
            httpurlconnection.setRequestMethod(s);
        }
        httpurlconnection.addRequestProperty("Connection", "Keep-Alive");
        httpurlconnection.setUseCaches(false);
        httpurlconnection.setDoInput(true);
        httpurlconnection.setDoOutput(true);
    }
}
