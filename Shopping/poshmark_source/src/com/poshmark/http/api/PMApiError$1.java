// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.api;

import com.poshmark.data_model.models.PMErrorType;
import java.io.InterruptedIOException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.HashMap;
import javax.net.ssl.SSLException;
import org.apache.http.NoHttpResponseException;
import org.apache.http.conn.HttpHostConnectException;

// Referenced classes of package com.poshmark.http.api:
//            PMApiError

static final class rorType.CONNECTION_TIMEOUT extends HashMap
{

    tException()
    {
        put(org/apache/http/NoHttpResponseException, PMErrorType.CONNECTION_FAILURE);
        put(java/net/UnknownHostException, PMErrorType.CONNECTION_FAILURE);
        put(org/apache/http/conn/HttpHostConnectException, PMErrorType.CONNECTION_FAILURE);
        put(java/net/SocketException, PMErrorType.CONNECTION_FAILURE);
        put(javax/net/ssl/SSLException, PMErrorType.CONNECTION_FAILURE);
        put(java/io/InterruptedIOException, PMErrorType.CONNECTION_TIMEOUT);
        put(java/net/SocketTimeoutException, PMErrorType.CONNECTION_TIMEOUT);
    }
}
