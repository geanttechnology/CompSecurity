// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.huc;

import com.squareup.okhttp.Handshake;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import java.io.IOException;
import java.io.InputStream;
import java.net.SecureCacheResponse;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLPeerUnverifiedException;

// Referenced classes of package com.squareup.okhttp.internal.huc:
//            JavaApiConverter

static final class val.body extends SecureCacheResponse
{

    final ResponseBody val$body;
    final Handshake val$handshake;
    final Headers val$headers;
    final Response val$response;

    public InputStream getBody()
        throws IOException
    {
        if (val$body == null)
        {
            return null;
        } else
        {
            return val$body.byteStream();
        }
    }

    public String getCipherSuite()
    {
        if (val$handshake != null)
        {
            return val$handshake.cipherSuite();
        } else
        {
            return null;
        }
    }

    public Map getHeaders()
        throws IOException
    {
        return OkHeaders.toMultimap(val$headers, StatusLine.get(val$response).toString());
    }

    public List getLocalCertificateChain()
    {
        if (val$handshake == null)
        {
            return null;
        }
        List list = val$handshake.localCertificates();
        if (list.size() <= 0)
        {
            list = null;
        }
        return list;
    }

    public Principal getLocalPrincipal()
    {
        if (val$handshake == null)
        {
            return null;
        } else
        {
            return val$handshake.localPrincipal();
        }
    }

    public Principal getPeerPrincipal()
        throws SSLPeerUnverifiedException
    {
        if (val$handshake == null)
        {
            return null;
        } else
        {
            return val$handshake.peerPrincipal();
        }
    }

    public List getServerCertificateChain()
        throws SSLPeerUnverifiedException
    {
        if (val$handshake == null)
        {
            return null;
        }
        List list = val$handshake.peerCertificates();
        if (list.size() <= 0)
        {
            list = null;
        }
        return list;
    }

    _cls9(Handshake handshake1, Headers headers1, Response response1, ResponseBody responsebody)
    {
        val$handshake = handshake1;
        val$headers = headers1;
        val$response = response1;
        val$body = responsebody;
        super();
    }
}
