// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.util;

import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.exceptions.InvalidParameterException;
import com.amazon.gallery.framework.network.exceptions.TerminalException;
import com.amazon.gallery.framework.network.http.adrive.operations.StorageInformation;
import com.amazon.gallery.framework.network.http.rest.RestClient;

// Referenced classes of package com.amazon.gallery.framework.kindle.util:
//            StorageInformationFetcher

class this._cls1
    implements com.amazon.gallery.framework.network._cls1._cls1
{

    final rmation this$1;

    public void onFailure(TerminalException terminalexception)
    {
        StorageInformationFetcher.access$300(_fld0);
        StorageInformationFetcher.access$200(_fld0);
    }

    public void onSuccess(StorageInformation storageinformation)
    {
        StorageInformationFetcher.access$100(_fld0, storageinformation);
        StorageInformationFetcher.access$200(_fld0);
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((StorageInformation)obj);
    }

    is._cls0()
    {
        this$1 = this._cls1.this;
        super();
    }

    // Unreferenced inner class com/amazon/gallery/framework/kindle/util/StorageInformationFetcher$1

/* anonymous class */
    class StorageInformationFetcher._cls1
        implements Runnable
    {

        final StorageInformationFetcher this$0;

        public void run()
        {
            try
            {
                StorageInformationFetcher.access$000(StorageInformationFetcher.this);
                StorageInformationFetcher.access$400(StorageInformationFetcher.this).executeForeground(getRestClient().getUserStorageInformation(), new StorageInformationFetcher._cls1._cls1());
                return;
            }
            catch (InvalidParameterException invalidparameterexception)
            {
                GLogger.e(StorageInformationFetcher.access$500(), "Failed to get the storage information : %s", new Object[] {
                    invalidparameterexception.getMessage()
                });
            }
        }

            
            {
                this$0 = StorageInformationFetcher.this;
                super();
            }
    }

}
