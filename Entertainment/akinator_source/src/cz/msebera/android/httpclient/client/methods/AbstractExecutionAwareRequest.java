// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.client.methods;

import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.client.utils.CloneUtils;
import cz.msebera.android.httpclient.concurrent.Cancellable;
import cz.msebera.android.httpclient.conn.ClientConnectionRequest;
import cz.msebera.android.httpclient.conn.ConnectionReleaseTrigger;
import cz.msebera.android.httpclient.message.AbstractHttpMessage;
import cz.msebera.android.httpclient.message.HeaderGroup;
import cz.msebera.android.httpclient.params.HttpParams;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

// Referenced classes of package cz.msebera.android.httpclient.client.methods:
//            HttpExecutionAware, AbortableHttpRequest

public abstract class AbstractExecutionAwareRequest extends AbstractHttpMessage
    implements HttpExecutionAware, AbortableHttpRequest, Cloneable, HttpRequest
{

    private final AtomicBoolean aborted = new AtomicBoolean(false);
    private final AtomicReference cancellableRef = new AtomicReference(null);

    protected AbstractExecutionAwareRequest()
    {
    }

    public void abort()
    {
        if (aborted.compareAndSet(false, true))
        {
            Cancellable cancellable = (Cancellable)cancellableRef.getAndSet(null);
            if (cancellable != null)
            {
                cancellable.cancel();
            }
        }
    }

    public Object clone()
        throws CloneNotSupportedException
    {
        AbstractExecutionAwareRequest abstractexecutionawarerequest = (AbstractExecutionAwareRequest)super.clone();
        abstractexecutionawarerequest.headergroup = (HeaderGroup)CloneUtils.cloneObject(headergroup);
        abstractexecutionawarerequest.params = (HttpParams)CloneUtils.cloneObject(params);
        return abstractexecutionawarerequest;
    }

    public void completed()
    {
        cancellableRef.set(null);
    }

    public boolean isAborted()
    {
        return aborted.get();
    }

    public void reset()
    {
        Cancellable cancellable = (Cancellable)cancellableRef.getAndSet(null);
        if (cancellable != null)
        {
            cancellable.cancel();
        }
        aborted.set(false);
    }

    public void setCancellable(Cancellable cancellable)
    {
        if (!aborted.get())
        {
            cancellableRef.set(cancellable);
        }
    }

    public void setConnectionRequest(final ClientConnectionRequest connRequest)
    {
        setCancellable(new Cancellable() {

            final AbstractExecutionAwareRequest this$0;
            final ClientConnectionRequest val$connRequest;

            public boolean cancel()
            {
                connRequest.abortRequest();
                return true;
            }

            
            {
                this$0 = AbstractExecutionAwareRequest.this;
                connRequest = clientconnectionrequest;
                super();
            }
        });
    }

    public void setReleaseTrigger(final ConnectionReleaseTrigger releaseTrigger)
    {
        setCancellable(new Cancellable() {

            final AbstractExecutionAwareRequest this$0;
            final ConnectionReleaseTrigger val$releaseTrigger;

            public boolean cancel()
            {
                try
                {
                    releaseTrigger.abortConnection();
                }
                catch (IOException ioexception)
                {
                    return false;
                }
                return true;
            }

            
            {
                this$0 = AbstractExecutionAwareRequest.this;
                releaseTrigger = connectionreleasetrigger;
                super();
            }
        });
    }
}
