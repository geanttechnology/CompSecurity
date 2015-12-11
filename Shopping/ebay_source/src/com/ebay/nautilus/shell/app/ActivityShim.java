// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            ActivityShimManager, FwActivity

public abstract class ActivityShim
{

    private ActivityShimManager manager;

    public ActivityShim()
    {
        manager = null;
    }

    protected final Activity getActivity()
    {
        return manager.getActivity();
    }

    protected final FwActivity getFwActivity()
    {
        return manager.getFwActivity();
    }

    protected final ActivityShimManager getManager()
    {
        return manager;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
    }

    protected void onContentChanged()
    {
    }

    protected void onCreate(Bundle bundle)
    {
    }

    protected void onDestroy()
    {
    }

    protected void onPause()
    {
    }

    protected void onPostCreate(Bundle bundle)
    {
    }

    protected void onPostResume()
    {
    }

    protected void onRestart()
    {
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
    }

    protected void onResume()
    {
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
    }

    protected void onStart()
    {
    }

    protected void onStop()
    {
    }

    protected void onWindowFocusChanged(boolean flag)
    {
    }

    protected void preOnCreate(Bundle bundle)
    {
    }

    protected void preOnDestroy()
    {
    }

    protected void preOnPause()
    {
    }

    protected void preOnRestart()
    {
    }

    protected void preOnResume()
    {
    }

    protected void preOnStart()
    {
    }

    protected void preOnStop()
    {
    }

    final void setManager(ActivityShimManager activityshimmanager)
    {
        manager = activityshimmanager;
    }
}
