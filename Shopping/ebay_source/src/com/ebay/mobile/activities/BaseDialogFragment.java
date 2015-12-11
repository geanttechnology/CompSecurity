// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.app.DialogFragment;
import android.content.Context;
import android.content.Intent;
import com.ebay.nautilus.shell.app.BaseActivity;
import com.ebay.nautilus.shell.app.FwLoaderManager;
import com.ebay.nautilus.shell.content.FwLoader;

public abstract class BaseDialogFragment extends DialogFragment
{
    private static final class ActivityResult
    {

        public final Intent intent;
        public final int requestCode;
        public final int resultCode;

        public ActivityResult(int i, int j, Intent intent1)
        {
            requestCode = i;
            resultCode = j;
            intent = intent1;
        }
    }

    private final class LoaderCallback
        implements com.ebay.nautilus.shell.app.FwLoaderManager.Callback
    {

        final BaseDialogFragment this$0;

        public Context getContext()
        {
            return getActivity();
        }

        public void onCanceled(int i, FwLoader fwloader)
        {
            BaseDialogFragment.this.onCanceled(i, fwloader);
        }

        public void onTaskComplete(int i, FwLoader fwloader)
        {
            BaseDialogFragment.this.onTaskComplete(i, fwloader);
        }

        public void onTaskStarted(int i, FwLoader fwloader)
        {
            BaseDialogFragment.this.onTaskStarted(i, fwloader);
        }

        private LoaderCallback()
        {
            this$0 = BaseDialogFragment.this;
            super();
        }

    }


    private ActivityResult activityResult;
    private FwLoaderManager loaderManager;

    public BaseDialogFragment()
    {
        loaderManager = null;
    }

    public final BaseActivity getBaseActivity()
    {
        return (BaseActivity)getActivity();
    }

    protected final FwLoaderManager getFwLoaderManager()
    {
        if (loaderManager == null)
        {
            loaderManager = new FwLoaderManager(new LoaderCallback());
            loaderManager.setDefaultPriority(0);
        }
        return loaderManager;
    }

    public void onActivityResult(int i, int j, Intent intent)
    {
        if (isResumed())
        {
            onActivityResultSafe(i, j, intent);
        } else
        {
            activityResult = new ActivityResult(i, j, intent);
        }
        super.onActivityResult(i, j, intent);
    }

    protected void onActivityResultSafe(int i, int j, Intent intent)
    {
    }

    protected void onCanceled(int i, FwLoader fwloader)
    {
    }

    public void onDestroy()
    {
        if (loaderManager != null)
        {
            loaderManager.cancelAll(true);
            loaderManager.setHandler(null);
        }
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        if (loaderManager != null)
        {
            loaderManager.setHandler(new LoaderCallback());
        }
        if (activityResult != null)
        {
            onActivityResultSafe(activityResult.requestCode, activityResult.resultCode, activityResult.intent);
            activityResult = null;
        }
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
    }

    protected void onTaskStarted(int i, FwLoader fwloader)
    {
    }
}
