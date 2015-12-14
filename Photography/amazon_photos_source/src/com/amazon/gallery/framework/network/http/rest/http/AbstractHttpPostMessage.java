// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.network.http.rest.http;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.zip.GZIPOutputStream;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONObject;

// Referenced classes of package com.amazon.gallery.framework.network.http.rest.http:
//            AbstractHttpMessage, HttpFactory

public abstract class AbstractHttpPostMessage extends AbstractHttpMessage
{

    public static long DEFAULT_SYNC_MIN_GZIP_BYTES = 256L;
    private static final String TAG = com/amazon/gallery/framework/network/http/rest/http/AbstractHttpPostMessage.getName();
    protected boolean allowGZIP;

    public AbstractHttpPostMessage(HttpFactory httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent metricsevent)
        throws InvalidParameterException
    {
        this(httpfactory, metricsevent, null);
    }

    public AbstractHttpPostMessage(HttpFactory httpfactory, com.amazon.gallery.framework.network.http.rest.RestClient.MetricsEvent metricsevent, String s)
        throws InvalidParameterException
    {
        super(httpfactory.getHttpPostRequest(), metricsevent, s, httpfactory.getSourceInfo());
        allowGZIP = false;
    }

    public void constructBody(HttpEntityEnclosingRequestBase httpentityenclosingrequestbase)
        throws TerminalException
    {
        Object obj;
        ByteArrayOutputStream bytearrayoutputstream;
        GZIPOutputStream gzipoutputstream;
        try
        {
            obj = getRequestBody();
        }
        // Misplaced declaration of an exception variable
        catch (HttpEntityEnclosingRequestBase httpentityenclosingrequestbase)
        {
            GLogger.w(TAG, "Error building post request: ", new Object[] {
                httpentityenclosingrequestbase
            });
            throw new TerminalException(httpentityenclosingrequestbase);
        }
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_133;
        }
        httpentityenclosingrequestbase.setHeader("Content-Type", "application/x-www-form-urlencoded");
        obj = ((JSONObject) (obj)).toString().getBytes();
        if (allowGZIP && (long)obj.length >= DEFAULT_SYNC_MIN_GZIP_BYTES)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        obj = new ByteArrayEntity(((byte []) (obj)));
_L2:
        httpentityenclosingrequestbase.setEntity(((org.apache.http.HttpEntity) (obj)));
        return;
        bytearrayoutputstream = new ByteArrayOutputStream();
        gzipoutputstream = new GZIPOutputStream(bytearrayoutputstream);
        gzipoutputstream.write(((byte []) (obj)));
        gzipoutputstream.close();
        obj = new ByteArrayEntity(bytearrayoutputstream.toByteArray());
        ((AbstractHttpEntity) (obj)).setContentEncoding("gzip");
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected abstract JSONObject getRequestBody()
        throws TerminalException;

    protected abstract URI getURI(Endpoint endpoint);

    public void populateRequest(Endpoint endpoint)
        throws TerminalException
    {
        super.populateRequest(endpoint);
        HttpEntityEnclosingRequestBase httpentityenclosingrequestbase = (HttpEntityEnclosingRequestBase)request;
        httpentityenclosingrequestbase.setURI(getURI(endpoint));
        constructBody(httpentityenclosingrequestbase);
    }

}
