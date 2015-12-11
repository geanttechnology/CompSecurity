// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Activity;
import com.ebay.nautilus.kernel.content.EbayContextWrapper;
import com.ebay.nautilus.kernel.content.KernelContext;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            FwContext, ActivityShim

public interface FwActivity
    extends FwContext
{
    public static class ActivityContext extends EbayContextWrapper
    {

        public ActivityContext(Activity activity)
        {
            super(KernelContext.getSingleBaseContext(activity.getApplication()));
        }
    }


    public abstract ActivityShim getShim(Class class1);

    public abstract boolean isStateSaved();
}
