// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            DataManagerInitializationHelper, BasePreferenceActivity, DataManagerContainer

class Helper extends DataManagerInitializationHelper
{

    final BasePreferenceActivity this$0;

    public EbayContext getEbayContext()
    {
        return BasePreferenceActivity.this.getEbayContext();
    }

    public void initializeDataManagers(DataManagerContainer datamanagercontainer)
    {
        dataManagerContainer = datamanagercontainer;
        onInitializeDataManagers(datamanagercontainer);
    }

    Helper()
    {
        this$0 = BasePreferenceActivity.this;
        super();
    }
}
