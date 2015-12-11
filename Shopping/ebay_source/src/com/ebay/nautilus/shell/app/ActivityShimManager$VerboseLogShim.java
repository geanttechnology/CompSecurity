// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            ActivityShimManager

static final class  extends 
{

    protected void onActivityResult(int i, int j, Intent intent)
    {
        logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
            Integer.valueOf(i), Integer.valueOf(j), intent
        });
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
            configuration
        });
    }

    protected void onContentChanged()
    {
        logMethod(ActivityShimManager.logCommonCallbacks, new Object[0]);
    }

    protected void onPostCreate(Bundle bundle)
    {
        logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
            bundle
        });
    }

    protected void onPostResume()
    {
        logMethod(ActivityShimManager.logCommonCallbacks, new Object[0]);
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
            bundle
        });
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
            bundle
        });
    }

    ()
    {
    }
}
