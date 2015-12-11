// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Service;
import com.ebay.nautilus.kernel.content.EbayContextWrapper;
import com.ebay.nautilus.kernel.content.KernelContext;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            FwService

public static class gleBaseContext extends EbayContextWrapper
{

    public (Service service)
    {
        super(KernelContext.getSingleBaseContext(service.getApplication()));
    }
}
