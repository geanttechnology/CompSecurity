// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.LoaderManager;
import android.content.Loader;
import android.os.Bundle;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            DataManagerInitializationLoader, DataManagerContainer

public abstract class DataManagerInitializationHelper
    implements android.app.LoaderManager.LoaderCallbacks
{

    private static final int LOADER_ID = 0xf423f;
    private DataManagerContainer initializer;

    public DataManagerInitializationHelper()
    {
    }

    public abstract EbayContext getEbayContext();

    public final void init(LoaderManager loadermanager)
    {
        loadermanager.initLoader(0xf423f, null, this);
    }

    public abstract void initializeDataManagers(DataManagerContainer datamanagercontainer);

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new DataManagerInitializationLoader(getEbayContext());
    }

    public void onLoadFinished(Loader loader, DataManagerContainer datamanagercontainer)
    {
        if (initializer != datamanagercontainer)
        {
            initializer = datamanagercontainer;
            if (datamanagercontainer != null)
            {
                initializeDataManagers(datamanagercontainer);
                return;
            }
        }
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (DataManagerContainer)obj);
    }

    public void onLoaderReset(Loader loader)
    {
        initializer = null;
    }
}
