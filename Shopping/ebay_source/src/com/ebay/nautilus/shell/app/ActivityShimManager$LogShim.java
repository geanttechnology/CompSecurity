// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.os.Bundle;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            ActivityShim, ActivityShimManager, BaseActivity

static class  extends ActivityShim
{

    protected final transient void logMethod(com.ebay.nautilus.kernel.util. , Object aobj[])
    {
        BaseActivity.logMethodInfo(, getActivity().getClass(), 6, aobj);
    }

    protected void preOnCreate(Bundle bundle)
    {
        logMethod(ActivityShimManager.logLifecycle, new Object[] {
            bundle
        });
    }

    protected void preOnDestroy()
    {
        logMethod(ActivityShimManager.logLifecycle, new Object[0]);
    }

    protected void preOnPause()
    {
        logMethod(ActivityShimManager.logLifecycle, new Object[0]);
    }

    protected void preOnRestart()
    {
        logMethod(ActivityShimManager.logLifecycle, new Object[0]);
    }

    protected void preOnResume()
    {
        logMethod(ActivityShimManager.logLifecycle, new Object[0]);
    }

    protected void preOnStart()
    {
        logMethod(ActivityShimManager.logLifecycle, new Object[0]);
    }

    protected void preOnStop()
    {
        logMethod(ActivityShimManager.logLifecycle, new Object[0]);
    }

    ()
    {
    }
}
