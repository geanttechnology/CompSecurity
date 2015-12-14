// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.ftue;

import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.di.BeanAwareActivity;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;

// Referenced classes of package com.amazon.gallery.framework.kindle.ftue:
//            AbstractNoContentOverlay

private class <init> extends AsyncTask
{

    final AbstractNoContentOverlay this$0;

    private void loadEndpoint()
    {
        RestClient restclient = (RestClient)activity.getApplicationBean(Keys.REST_CLIENT);
        try
        {
            restclient.getEndpointManager().getEndpoint();
            return;
        }
        catch (TerminalException terminalexception)
        {
            GLogger.i(AbstractNoContentOverlay.access$400(), "Failed to get endpoint", new Object[0]);
        }
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        loadEndpoint();
        return null;
    }

    protected void onCancelled()
    {
        synchronized (AbstractNoContentOverlay.this)
        {
            AbstractNoContentOverlay.access$202(AbstractNoContentOverlay.this, null);
        }
        return;
        exception;
        abstractnocontentoverlay;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected volatile void onCancelled(Object obj)
    {
        onCancelled((Void)obj);
    }

    protected void onCancelled(Void void1)
    {
        synchronized (AbstractNoContentOverlay.this)
        {
            AbstractNoContentOverlay.access$202(AbstractNoContentOverlay.this, null);
        }
        return;
        exception;
        void1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Void)obj);
    }

    protected void onPostExecute(Void void1)
    {
        GLogger.d("LoadingEndpointAsyncRunner", "Finished", new Object[0]);
        synchronized (AbstractNoContentOverlay.this)
        {
            AbstractNoContentOverlay.access$202(AbstractNoContentOverlay.this, null);
        }
        return;
        exception;
        void1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private ()
    {
        this$0 = AbstractNoContentOverlay.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
