// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.adrive.operations.StorageInformation;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.http.rest.account.Endpoint;
import com.amazon.gallery.framework.network.http.rest.account.EndpointManager;

// Referenced classes of package com.amazon.gallery.framework.kindle.util:
//            StorageInformationLoadedListener

public class StorageInformationFetcher
{
    private class LoadingEndpointAsyncRunner extends AsyncTask
    {

        private Runnable runnable;
        final StorageInformationFetcher this$0;

        protected transient Endpoint doInBackground(Void avoid[])
        {
            try
            {
                avoid = restClient.getEndpointManager().getEndpoint();
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                GLogger.ex(StorageInformationFetcher.TAG, "Failed to get Endpoint", avoid);
                return null;
            }
            return avoid;
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(Endpoint endpoint1)
        {
            endpoint = endpoint1;
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

        public LoadingEndpointAsyncRunner()
        {
            this$0 = StorageInformationFetcher.this;
            super();
        }
    }


    private static final String TAG = com/amazon/gallery/framework/kindle/util/StorageInformationFetcher.getName();
    private Endpoint endpoint;
    private NetworkConnectivity networkConnectivity;
    private NetworkExecutor networkExecutor;
    private Runnable postFetchRunnable;
    private RestClient restClient;
    private StorageInformationLoadedListener storageInformationLoadedListener;

    public StorageInformationFetcher()
    {
        endpoint = null;
    }

    private void executePostFetchRunnable()
    {
        if (postFetchRunnable != null)
        {
            postFetchRunnable.run();
        }
    }

    private void onStorageInformationFailedToLoad()
    {
    }

    private void onStorageInformationLoaded(StorageInformation storageinformation)
    {
        if (storageInformationLoadedListener != null)
        {
            storageInformationLoadedListener.onStorageInformationLoaded(storageinformation);
        }
    }

    private void setupBuyStoragePreference()
    {
        Intent intent = getBuyStorageIntent();
        if (intent == null)
        {
            return;
        } else
        {
            storageInformationLoadedListener.onSetBuyStorageInformation(intent);
            return;
        }
    }

    public void fetchStorageInformation()
    {
        loadEndpoint(new Runnable() {

            final StorageInformationFetcher this$0;

            public void run()
            {
                try
                {
                    setupBuyStoragePreference();
                    networkExecutor.executeForeground(getRestClient().getUserStorageInformation(), new com.amazon.gallery.framework.network.NetworkExecutor.ResultHandler() {

                        final _cls1 this$1;

                        public void onFailure(TerminalException terminalexception)
                        {
                            onStorageInformationFailedToLoad();
                            executePostFetchRunnable();
                        }

                        public void onSuccess(StorageInformation storageinformation)
                        {
                            onStorageInformationLoaded(storageinformation);
                            executePostFetchRunnable();
                        }

                        public volatile void onSuccess(Object obj)
                        {
                            onSuccess((StorageInformation)obj);
                        }

            
            {
                this$1 = _cls1.this;
                super();
            }
                    });
                    return;
                }
                catch (InvalidParameterException invalidparameterexception)
                {
                    GLogger.e(StorageInformationFetcher.TAG, "Failed to get the storage information : %s", new Object[] {
                        invalidparameterexception.getMessage()
                    });
                }
            }

            
            {
                this$0 = StorageInformationFetcher.this;
                super();
            }
        });
    }

    public Intent getBuyStorageIntent()
    {
        if (endpoint == null)
        {
            GLogger.e(TAG, "Failed to get account information", new Object[0]);
            return null;
        }
        Object obj = new android.net.Uri.Builder();
        ((android.net.Uri.Builder) (obj)).scheme("https").authority(endpoint.getHttpHostString()).appendEncodedPath("gp/photos/storage").appendQueryParameter("hide_nav", "1");
        obj = ((android.net.Uri.Builder) (obj)).build().toString();
        if (obj == null)
        {
            GLogger.w(TAG, (new StringBuilder()).append("Missing manage url for endpoint: ").append(endpoint.getExactMarketplace()).toString(), new Object[0]);
            return null;
        } else
        {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(((String) (obj))));
            return intent;
        }
    }

    public NetworkConnectivity getNetworkConnectivity()
    {
        return networkConnectivity;
    }

    public RestClient getRestClient()
    {
        return restClient;
    }

    public void loadEndpoint(Runnable runnable)
    {
        endpoint = restClient.getEndpointManager().getCachedEndpoint();
        if (endpoint == null && getNetworkConnectivity().getConnectionStatus() != com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.ConnectionStatus.NONE)
        {
            LoadingEndpointAsyncRunner loadingendpointasyncrunner = new LoadingEndpointAsyncRunner();
            loadingendpointasyncrunner.setPostExecutatable(runnable);
            loadingendpointasyncrunner.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return;
        } else
        {
            runnable.run();
            return;
        }
    }

    public void setNetworkConnectivity(NetworkConnectivity networkconnectivity)
    {
        networkConnectivity = networkconnectivity;
    }

    public void setNetworkExecutor(NetworkExecutor networkexecutor)
    {
        networkExecutor = networkexecutor;
    }

    public void setRestClient(RestClient restclient)
    {
        restClient = restclient;
    }

    public void setStorageInformationLoadedListener(StorageInformationLoadedListener storageinformationloadedlistener)
    {
        storageInformationLoadedListener = storageinformationloadedlistener;
    }









/*
    static Endpoint access$602(StorageInformationFetcher storageinformationfetcher, Endpoint endpoint1)
    {
        storageinformationfetcher.endpoint = endpoint1;
        return endpoint1;
    }

*/

}
