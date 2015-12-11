// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.execchain;

import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.conn.EofSensorInputStream;
import cz.msebera.android.httpclient.conn.EofSensorWatcher;
import cz.msebera.android.httpclient.entity.HttpEntityWrapper;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketException;

// Referenced classes of package cz.msebera.android.httpclient.impl.execchain:
//            ConnectionHolder

class ResponseEntityProxy extends HttpEntityWrapper
    implements EofSensorWatcher
{

    private final ConnectionHolder connHolder;

    ResponseEntityProxy(HttpEntity httpentity, ConnectionHolder connectionholder)
    {
        super(httpentity);
        connHolder = connectionholder;
    }

    private void cleanup()
    {
        if (connHolder != null)
        {
            connHolder.abortConnection();
        }
    }

    public static void enchance(HttpResponse httpresponse, ConnectionHolder connectionholder)
    {
        HttpEntity httpentity = httpresponse.getEntity();
        if (httpentity != null && httpentity.isStreaming() && connectionholder != null)
        {
            httpresponse.setEntity(new ResponseEntityProxy(httpentity, connectionholder));
        }
    }

    public void consumeContent()
        throws IOException
    {
        releaseConnection();
    }

    public boolean eofDetected(InputStream inputstream)
        throws IOException
    {
        inputstream.close();
        releaseConnection();
        cleanup();
        return false;
        inputstream;
        cleanup();
        throw inputstream;
    }

    public InputStream getContent()
        throws IOException
    {
        return new EofSensorInputStream(wrappedEntity.getContent(), this);
    }

    public boolean isRepeatable()
    {
        return false;
    }

    public void releaseConnection()
        throws IOException
    {
        if (connHolder == null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        if (connHolder.isReusable())
        {
            connHolder.releaseConnection();
        }
        cleanup();
        return;
        Exception exception;
        exception;
        cleanup();
        throw exception;
    }

    public boolean streamAbort(InputStream inputstream)
        throws IOException
    {
        cleanup();
        return false;
    }

    public boolean streamClosed(InputStream inputstream)
        throws IOException
    {
        if (connHolder == null) goto _L2; else goto _L1
_L1:
        boolean flag1 = connHolder.isReleased();
        if (flag1) goto _L2; else goto _L3
_L3:
        boolean flag = true;
_L7:
        inputstream.close();
        releaseConnection();
_L5:
        cleanup();
        return false;
_L2:
        flag = false;
        continue; /* Loop/switch isn't completed */
        inputstream;
        if (!flag) goto _L5; else goto _L4
_L4:
        throw inputstream;
        inputstream;
        cleanup();
        throw inputstream;
        if (true) goto _L7; else goto _L6
_L6:
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder("ResponseEntityProxy{");
        stringbuilder.append(wrappedEntity);
        stringbuilder.append('}');
        return stringbuilder.toString();
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        wrappedEntity.writeTo(outputstream);
        releaseConnection();
        cleanup();
        return;
        outputstream;
        cleanup();
        throw outputstream;
    }
}
