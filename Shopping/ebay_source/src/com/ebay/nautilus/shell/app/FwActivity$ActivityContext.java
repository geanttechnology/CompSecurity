// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Activity;
import com.ebay.nautilus.kernel.content.EbayContextWrapper;
import com.ebay.nautilus.kernel.content.KernelContext;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            FwActivity

public static class eBaseContext extends EbayContextWrapper
{

    public (Activity activity)
    {
        super(KernelContext.getSingleBaseContext(activity.getApplication()));
    }
}
