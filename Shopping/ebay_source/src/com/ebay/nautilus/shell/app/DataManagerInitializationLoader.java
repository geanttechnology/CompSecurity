// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.content.Context;
import android.content.Loader;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            DataManagerContainer

final class DataManagerInitializationLoader extends Loader
{

    private DataManagerContainer _data;
    private final EbayContext ebayContext;

    public DataManagerInitializationLoader(EbayContext ebaycontext)
    {
        super((Context)ebaycontext.getExtension(android/content/Context));
        ebayContext = ebaycontext;
    }

    private DataManagerContainer load()
    {
        return new DataManagerContainer(ebayContext);
    }

    public void deliverResult(DataManagerContainer datamanagercontainer)
    {
        if (isReset())
        {
            if (datamanagercontainer != null)
            {
                datamanagercontainer.close();
            }
        } else
        {
            DataManagerContainer datamanagercontainer1 = _data;
            _data = datamanagercontainer;
            if (isStarted())
            {
                super.deliverResult(datamanagercontainer);
            }
            if (datamanagercontainer1 != null && datamanagercontainer1 != datamanagercontainer)
            {
                datamanagercontainer1.close();
                return;
            }
        }
    }

    public volatile void deliverResult(Object obj)
    {
        deliverResult((DataManagerContainer)obj);
    }

    protected void onForceLoad()
    {
        deliverResult(load());
    }

    protected void onReset()
    {
        super.onReset();
        onStopLoading();
    }

    protected void onStartLoading()
    {
        if (_data != null)
        {
            deliverResult(_data);
        }
        if (takeContentChanged() || _data == null)
        {
            forceLoad();
        }
    }

    protected void onStopLoading()
    {
        if (_data != null)
        {
            _data.close();
            _data = null;
        }
    }
}
