// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            DataManagerInitializationHelper, BaseActivity, DataManagerContainer

class ializationHelper extends DataManagerInitializationHelper
{

    final BaseActivity this$0;

    public EbayContext getEbayContext()
    {
        return BaseActivity.this.getEbayContext();
    }

    public void initializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        dataManagerContainer = datamanagercontainer;
        onInitializeDataManagers(datamanagercontainer);
    }

    ainer()
    {
        this$0 = BaseActivity.this;
        super();
    }
}
