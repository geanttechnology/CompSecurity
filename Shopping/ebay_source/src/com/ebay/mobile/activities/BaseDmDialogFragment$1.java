// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.app.DataManagerContainer;
import com.ebay.nautilus.shell.app.DataManagerInitializationHelper;
import com.ebay.nautilus.shell.app.FwActivity;

// Referenced classes of package com.ebay.mobile.activities:
//            BaseDmDialogFragment

class ionHelper extends DataManagerInitializationHelper
{

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

    ionHelper()
    {
        this$0 = BaseDmDialogFragment.this;
        super();
    }
}
