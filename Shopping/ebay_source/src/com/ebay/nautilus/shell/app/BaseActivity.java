// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.shell.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.content.FwLoader;

// Referenced classes of package com.ebay.nautilus.shell.app:
//            FwActivity, ActivityShimManager, FwLoaderManager, DataManagerInitializationHelper, 
//            DataManagerContainer, ActivityShim

public abstract class BaseActivity extends Activity
    implements FwActivity
{
    private final class LoaderCallback
        implements FwLoaderManager.Callback
    {

        final BaseActivity this$0;

        public Context getContext()
        {
            return BaseActivity.this;
        }

        public void onCanceled(int i, FwLoader fwloader)
        {
            BaseActivity.this.onCanceled(i, fwloader);
        }

        public void onTaskComplete(int i, FwLoader fwloader)
        {
            BaseActivity.this.onTaskComplete(i, fwloader);
        }

        public void onTaskStarted(int i, FwLoader fwloader)
        {
            BaseActivity.this.onTaskStarted(i, fwloader);
        }

        private LoaderCallback()
        {
            this$0 = BaseActivity.this;
            super();
        }

    }

    static final class NonConfigInstance
    {

        public final FwActivity.ActivityContext c;
        public final FwLoaderManager lm;
        public final Object obj;

        public NonConfigInstance(Object obj1, FwLoaderManager fwloadermanager, FwActivity.ActivityContext activitycontext)
        {
            obj = obj1;
            lm = fwloadermanager;
            c = activitycontext;
        }
    }


    private FwActivity.ActivityContext activityContext;
    DataManagerContainer dataManagerContainer;
    private boolean initComplete;
    private FwLoaderManager loaderManager;
    private final ActivityShimManager shim = ActivityShimManager.createShimManager(this);
    private boolean stateSaved;

    public BaseActivity()
    {
    }

    static transient void logMethodInfo(com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo, Class class1, int i, Object aobj[])
    {
        StackTraceElement stacktraceelement;
        Object obj;
        StackTraceElement astacktraceelement[];
        StringBuilder stringbuilder;
        boolean flag1;
        astacktraceelement = Thread.currentThread().getStackTrace();
        int j;
        boolean flag;
        int k;
        boolean flag2;
        if (astacktraceelement != null && astacktraceelement.length > i)
        {
            stacktraceelement = astacktraceelement[i];
        } else
        {
            stacktraceelement = null;
        }
        flag1 = false;
        flag2 = false;
        stringbuilder = new StringBuilder();
        obj = stacktraceelement;
        if (stacktraceelement == null) goto _L2; else goto _L1
_L1:
        class1 = class1.getName();
        obj = stacktraceelement.getMethodName();
        j = astacktraceelement.length;
        flag1 = flag2;
_L6:
        if (i < j && !flag1 && ((String) (obj)).equals(astacktraceelement[i].getMethodName())) goto _L4; else goto _L3
_L3:
        stringbuilder.append(class1).append('.');
        stringbuilder.append(((String) (obj))).append('(');
        obj = stacktraceelement;
_L2:
        if (aobj != null && aobj.length != 0)
        {
            flag = true;
            k = aobj.length;
            i = 0;
            while (i < k) 
            {
                class1 = ((Class) (aobj[i]));
                if (flag)
                {
                    flag = false;
                } else
                {
                    stringbuilder.append(", ");
                }
                if (class1 != null && (class1 instanceof CharSequence))
                {
                    stringbuilder.append('"').append((CharSequence)class1).append('"');
                } else
                {
                    stringbuilder.append(class1);
                }
                i++;
            }
        }
        break; /* Loop/switch isn't completed */
_L4:
        stacktraceelement = astacktraceelement[i];
        flag1 = class1.equals(astacktraceelement[i].getClassName());
        i++;
        if (true) goto _L6; else goto _L5
_L5:
        if (obj != null)
        {
            stringbuilder.append(") - ");
            if (flag1)
            {
                if (((StackTraceElement) (obj)).getFileName() != null)
                {
                    stringbuilder.append(((StackTraceElement) (obj)).getFileName()).append(':');
                }
                stringbuilder.append(((StackTraceElement) (obj)).getLineNumber());
            } else
            {
                stringbuilder.append(((StackTraceElement) (obj)).getClassName());
            }
        }
        FwLog.println(loginfo, stringbuilder.toString());
        return;
    }

    protected final DataManagerContainer getDataManagerContainer()
    {
        return dataManagerContainer;
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
            loaderManager.setDefaultPriority(0);
        }
        return loaderManager;
    }

    protected final Object getLastFwNonConfigurationInstance()
    {
        NonConfigInstance nonconfiginstance = (NonConfigInstance)getLastNonConfigurationInstance();
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

            
            {
                this$0 = BaseActivity.this;
                super();
            }
        }).init(getLoaderManager());
    }

    public final boolean isStateSaved()
    {
        return stateSaved;
    }

    final transient void logMethod(com.ebay.nautilus.kernel.util.FwLog.LogInfo loginfo, Object aobj[])
    {
        logMethodInfo(loginfo, getClass(), 4, aobj);
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
        NonConfigInstance nonconfiginstance;
        shim.preOnCreate(bundle);
        nonconfiginstance = (NonConfigInstance)getLastNonConfigurationInstance();
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

    protected void onNewIntent(Intent intent)
    {
        if (ActivityShimManager.logCommonCallbacks.isLoggable)
        {
            logMethod(ActivityShimManager.logCommonCallbacks, new Object[] {
                intent
            });
        }
        super.onNewIntent(intent);
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
        obj = new NonConfigInstance(obj1, ((FwLoaderManager) (obj)), activityContext);
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

    public void onWindowFocusChanged(boolean flag)
    {
        super.onWindowFocusChanged(flag);
        shim.onWindowFocusChanged(flag);
    }
}
