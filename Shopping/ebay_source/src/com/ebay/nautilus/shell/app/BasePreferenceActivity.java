// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.shell.content.FwLoader;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            FwActivity, ActivityShimManager, FwLoaderManager, DataManagerInitializationHelper, 
//            DataManagerContainer, ActivityShim

public abstract class BasePreferenceActivity extends PreferenceActivity
    implements FwActivity
{
    private final class LoaderCallback
        implements FwLoaderManager.Callback
    {

        final BasePreferenceActivity this$0;

        public Context getContext()
        {
            return BasePreferenceActivity.this;
        }

        public void onCanceled(int i, FwLoader fwloader)
        {
            BasePreferenceActivity.this.onCanceled(i, fwloader);
        }

        public void onTaskComplete(int i, FwLoader fwloader)
        {
            BasePreferenceActivity.this.onTaskComplete(i, fwloader);
        }

        public void onTaskStarted(int i, FwLoader fwloader)
        {
            BasePreferenceActivity.this.onTaskStarted(i, fwloader);
        }

        private LoaderCallback()
        {
            this$0 = BasePreferenceActivity.this;
            super();
        }

    }


    private FwActivity.ActivityContext activityContext;
    DataManagerContainer dataManagerContainer;
    private boolean initComplete;
    private FwLoaderManager loaderManager;
    private final ActivityShimManager shim = ActivityShimManager.createShimManager(this);
    private boolean stateSaved;

    public BasePreferenceActivity()
    {
    }

    public final EbayContext getEbayContext()
    {
        this;
        JVM INSTR monitorenter ;
        FwActivity.ActivityContext activitycontext;
        if (activityContext == null)
        {
            activityContext = new FwActivity.ActivityContext(this);
        }
        activitycontext = activityContext;
        this;
        JVM INSTR monitorexit ;
        return activitycontext;
        Exception exception;
        exception;
        throw exception;
    }

    protected final FwLoaderManager getFwLoaderManager()
    {
        if (loaderManager == null)
        {
            LoaderCallback loadercallback;
            if (initComplete)
            {
                loadercallback = new LoaderCallback();
            } else
            {
                loadercallback = null;
            }
            loaderManager = new FwLoaderManager(loadercallback);
        }
        return loaderManager;
    }

    protected final Object getLastFwNonConfigurationInstance()
    {
        BaseActivity.NonConfigInstance nonconfiginstance = (BaseActivity.NonConfigInstance)getLastNonConfigurationInstance();
        if (nonconfiginstance != null)
        {
            return nonconfiginstance.obj;
        } else
        {
            return null;
        }
    }

    public final ActivityShim getShim(Class class1)
    {
        return shim.getShim(class1);
    }

    protected final void initDataManagers()
    {
        (new DataManagerInitializationHelper() {

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

            
            {
                this$0 = BasePreferenceActivity.this;
                super();
            }
        }).init(getLoaderManager());
    }

    public final boolean isStateSaved()
    {
        return stateSaved;
    }

    protected void onActivityResult(int i, int j, Intent intent)
    {
        super.onActivityResult(i, j, intent);
        shim.onActivityResult(i, j, intent);
    }

    protected void onCanceled(int i, FwLoader fwloader)
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        shim.onConfigurationChanged(configuration);
    }

    public void onContentChanged()
    {
        super.onContentChanged();
        shim.onContentChanged();
    }

    protected void onCreate(Bundle bundle)
    {
        BaseActivity.NonConfigInstance nonconfiginstance;
        shim.preOnCreate(bundle);
        nonconfiginstance = (BaseActivity.NonConfigInstance)getLastNonConfigurationInstance();
        if (nonconfiginstance == null) goto _L2; else goto _L1
_L1:
        loaderManager = nonconfiginstance.lm;
        this;
        JVM INSTR monitorenter ;
        activityContext = nonconfiginstance.c;
        this;
        JVM INSTR monitorexit ;
_L2:
        super.onCreate(bundle);
        stateSaved = false;
        shim.onCreate(bundle);
        return;
        bundle;
        this;
        JVM INSTR monitorexit ;
        throw bundle;
    }

    protected void onDestroy()
    {
        shim.preOnDestroy();
        if (loaderManager != null)
        {
            if (isFinishing())
            {
                loaderManager.cancelAll(true);
            }
            loaderManager.setHandler(null);
        }
        super.onDestroy();
        shim.onDestroy();
    }

    protected void onInitializeDataManagers(DataManagerContainer datamanagercontainer)
    {
    }

    protected void onPause()
    {
        shim.preOnPause();
        super.onPause();
        shim.onPause();
    }

    protected void onPostCreate(Bundle bundle)
    {
        super.onPostCreate(bundle);
        shim.onPostCreate(bundle);
    }

    protected void onPostResume()
    {
        super.onPostResume();
        shim.onPostResume();
        initComplete = true;
        if (loaderManager != null)
        {
            loaderManager.setHandler(new LoaderCallback());
        }
    }

    protected void onRestart()
    {
        shim.preOnRestart();
        super.onRestart();
        stateSaved = false;
        shim.onRestart();
    }

    protected void onRestoreInstanceState(Bundle bundle)
    {
        super.onRestoreInstanceState(bundle);
        shim.onRestoreInstanceState(bundle);
    }

    protected void onResume()
    {
        shim.preOnResume();
        super.onResume();
        stateSaved = false;
        shim.onResume();
    }

    protected Object onRetainFwNonConfigurationInstance()
    {
        return null;
    }

    public final Object onRetainNonConfigurationInstance()
    {
        Object obj;
        Object obj1;
        if (loaderManager != null && loaderManager.hasRunningLoaders())
        {
            obj = loaderManager;
        } else
        {
            obj = null;
        }
        obj1 = onRetainFwNonConfigurationInstance();
        this;
        JVM INSTR monitorenter ;
        if (obj != null || obj1 != null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        if (activityContext == null)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        obj = new BaseActivity.NonConfigInstance(obj1, ((FwLoaderManager) (obj)), activityContext);
        this;
        JVM INSTR monitorexit ;
        return obj;
        this;
        JVM INSTR monitorexit ;
        return null;
        obj;
        this;
        JVM INSTR monitorexit ;
        throw obj;
    }

    protected void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        stateSaved = true;
        shim.onSaveInstanceState(bundle);
    }

    protected void onStart()
    {
        shim.preOnStart();
        super.onStart();
        stateSaved = false;
        shim.onStart();
    }

    protected void onStop()
    {
        shim.preOnStop();
        super.onStop();
        shim.onStop();
    }

    protected void onTaskComplete(int i, FwLoader fwloader)
    {
    }

    protected void onTaskStarted(int i, FwLoader fwloader)
    {
    }
}
