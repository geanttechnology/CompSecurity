// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import android.content.Intent;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;

// Referenced classes of package com.amazon.gallery.framework.kindle.util:
//            StorageInformationFetcher

public class UploadUtils
{

    public static Intent getManageStorageWebIntent(RestClient restclient, NetworkExecutor networkexecutor, NetworkConnectivity networkconnectivity)
    {
        StorageInformationFetcher storageinformationfetcher = new StorageInformationFetcher();
        storageinformationfetcher.setRestClient(restclient);
        storageinformationfetcher.setNetworkExecutor(networkexecutor);
        storageinformationfetcher.setNetworkConnectivity(networkconnectivity);
        storageinformationfetcher.loadEndpoint(new Runnable() {

            public void run()
            {
            }

        });
        return storageinformationfetcher.getBuyStorageIntent();
    }
}
