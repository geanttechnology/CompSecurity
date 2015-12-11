// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Fragment;
import android.os.Bundle;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            FwActivity, DataManagerInitializationHelper, DataManagerContainer

public class BaseFragment extends Fragment
{

    DataManagerContainer dataManagerContainer;
    private DataManagerInitializationHelper initDataManagers;

    public BaseFragment()
    {
        initDataManagers = null;
        dataManagerContainer = null;
    }

    protected final DataManagerContainer getDataManagerContainer()
    {
        return dataManagerContainer;
    }

    public final FwActivity getFwActivity()
    {
        return (FwActivity)getActivity();
    }

    protected final void initDataManagers()
    {
        initDataManagers = new DataManagerInitializationHelper() {

            final BaseFragment this$0;

            public EbayContext getEbayContext()
            {
                return getFwActivity().getEbayContext();
            }

            public void initializeDataManagers(DataManagerContainer datamanagercontainer)
            {
                dataManagerContainer = datamanagercontainer;
                onInitializeDataManagers(datamanagercontainer);
            }

            
            {
                this$0 = BaseFragment.this;
                super();
            }
        };
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (initDataManagers != null)
        {
            initDataManagers.init(getLoaderManager());
            initDataManagers = null;
        }
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
    }
}
