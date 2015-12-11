// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.httpcomponentsandroid.conn;

import com.comcast.cim.httpcomponentsandroid.HttpEntity;
import com.comcast.cim.httpcomponentsandroid.entity.HttpEntityWrapper;
import com.comcast.cim.httpcomponentsandroid.util.EntityUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.comcast.cim.httpcomponentsandroid.conn:
//            ConnectionReleaseTrigger, EofSensorWatcher, ManagedClientConnection, EofSensorInputStream

public class BasicManagedEntity extends HttpEntityWrapper
    implements ConnectionReleaseTrigger, EofSensorWatcher
{

    protected final boolean attemptReuse;
    protected ManagedClientConnection managedConn;

    public BasicManagedEntity(HttpEntity httpentity, ManagedClientConnection managedclientconnection, boolean flag)
    {
        super(httpentity);
        if (managedclientconnection == null)
        {
            throw new IllegalArgumentException("Connection may not be null.");
        } else
        {
            managedConn = managedclientconnection;
            attemptReuse = flag;
            return;
        }
    }

    private void ensureConsumed()
        throws IOException
    {
        if (managedConn == null)
        {
            return;
        }
        if (attemptReuse)
        {
            EntityUtils.consume(wrappedEntity);
            managedConn.markReusable();
        }
        releaseManagedConnection();
        return;
        Exception exception;
        exception;
        releaseManagedConnection();
        throw exception;
    }

    public void abortConnection()
        throws IOException
    {
        if (managedConn == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        managedConn.abortConnection();
        managedConn = null;
        return;
        Exception exception;
        exception;
        managedConn = null;
        throw exception;
    }

    public boolean eofDetected(InputStream inputstream)
        throws IOException
    {
        if (attemptReuse && managedConn != null)
        {
            inputstream.close();
            managedConn.markReusable();
        }
        releaseManagedConnection();
        return false;
        inputstream;
        releaseManagedConnection();
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
        ensureConsumed();
    }

    protected void releaseManagedConnection()
        throws IOException
    {
        if (managedConn == null)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        managedConn.releaseConnection();
        managedConn = null;
        return;
        Exception exception;
        exception;
        managedConn = null;
        throw exception;
    }

    public boolean streamAbort(InputStream inputstream)
        throws IOException
    {
        if (managedConn != null)
        {
            managedConn.abortConnection();
        }
        return false;
    }

    public boolean streamClosed(InputStream inputstream)
        throws IOException
    {
        if (attemptReuse && managedConn != null)
        {
            inputstream.close();
            managedConn.markReusable();
        }
        releaseManagedConnection();
        return false;
        inputstream;
        releaseManagedConnection();
        throw inputstream;
    }

    public void writeTo(OutputStream outputstream)
        throws IOException
    {
        super.writeTo(outputstream);
        ensureConsumed();
    }
}
