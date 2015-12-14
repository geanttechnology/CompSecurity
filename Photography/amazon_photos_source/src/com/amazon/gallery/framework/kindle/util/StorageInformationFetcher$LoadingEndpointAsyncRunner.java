// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;

// Referenced classes of package com.amazon.gallery.framework.kindle.util:
//            StorageInformationFetcher

private class this._cls0 extends AsyncTask
{

    private Runnable runnable;
    final StorageInformationFetcher this$0;

    protected transient Endpoint doInBackground(Void avoid[])
    {
        try
        {
            avoid = StorageInformationFetcher.access$700(StorageInformationFetcher.this).getEndpointManager().getEndpoint();
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            GLogger.ex(StorageInformationFetcher.access$500(), "Failed to get Endpoint", avoid);
            return null;
        }
        return avoid;
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected void onPostExecute(Endpoint endpoint)
    {
        StorageInformationFetcher.access$602(StorageInformationFetcher.this, endpoint);
        GLogger.e("LoadingEndpointAsyncRunner", "Finished", new Object[0]);
        runnable.run();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Endpoint)obj);
    }

    public void setPostExecutatable(Runnable runnable1)
    {
        runnable = runnable1;
    }

    public ()
    {
        this$0 = StorageInformationFetcher.this;
        super();
    }
}
