// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.DialogFragment;
import android.os.Bundle;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.DataManagerInitializationHelper;
import com.ebay.nautilus.shell.app.FwActivity;

public class BaseDmDialogFragment extends DialogFragment
{

    DataManagerContainer dataManagerContainer;
    private DataManagerInitializationHelper initDataManagers;

    public BaseDmDialogFragment()
    {
        dataManagerContainer = null;
        initDataManagers = null;
    }

    protected final DataManagerContainer getDataManagerContainer()
    {
        return dataManagerContainer;
    }

    protected final void initDataManagers()
    {
        initDataManagers = new DataManagerInitializationHelper() {

            final BaseDmDialogFragment this$0;

            public EbayContext getEbayContext()
            {
                return ((FwActivity)getActivity()).getEbayContext();
            }

            public void initializeDataManagers(DataManagerContainer datamanagercontainer)
            {
                dataManagerContainer = datamanagercontainer;
                onInitializeDataManagers(datamanagercontainer);
            }

            
            {
                this$0 = BaseDmDialogFragment.this;
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
