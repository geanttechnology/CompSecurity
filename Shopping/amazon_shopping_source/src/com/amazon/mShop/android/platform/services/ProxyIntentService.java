// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.IBinder;
import com.amazon.mShop.android.platform.dex.ExceptionUtil;
import com.amazon.mShop.android.platform.dex.SecondDexEntry;
import com.amazon.mShop.android.platform.services.api.IAndroidIntentServiceProxy;
import java.io.FileDescriptor;
import java.io.PrintWriter;

// Referenced classes of package com.amazon.mShop.android.platform.services:
//            IntentServiceDelegateBase

public abstract class ProxyIntentService extends IntentService
    implements IAndroidIntentServiceProxy
{

    private IntentServiceDelegateBase mDelegate;

    public ProxyIntentService(String s)
    {
        super(s);
    }

    public void dump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        getDelegate().dump_impl(filedescriptor, printwriter, as);
    }

    public ClassLoader getClassLoader()
    {
        return SecondDexEntry.getInstance().getClassLoader();
    }

    public IntentServiceDelegateBase getDelegate()
    {
        this;
        JVM INSTR monitorenter ;
        IntentServiceDelegateBase intentservicedelegatebase = mDelegate;
        if (intentservicedelegatebase != null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        mDelegate = (IntentServiceDelegateBase)SecondDexEntry.getInstance().createServiceDelegate(this);
_L1:
        intentservicedelegatebase = mDelegate;
        this;
        JVM INSTR monitorexit ;
        return intentservicedelegatebase;
        Object obj;
        obj;
        ExceptionUtil.reportExceptions(getClass().getSimpleName(), ((Exception) (obj)));
        mDelegate = new IntentServiceDelegateBase(this);
        stopSelf();
          goto _L1
        obj;
        throw obj;
    }

    protected SecondDexEntry getDexEntry()
    {
        return SecondDexEntry.getInstance();
    }

    public IBinder onBind(Intent intent)
    {
        return getDelegate().onBind_impl(intent);
    }

    public void onConfigurationChanged(Configuration configuration)
    {
        getDelegate().onConfigurationChanged_impl(configuration);
    }

    public void onCreate()
    {
        getDelegate().onCreate_impl();
    }

    public void onDestroy()
    {
        getDelegate().onDestroy_impl();
    }

    protected void onHandleIntent(Intent intent)
    {
        getDelegate().onHandleIntent_impl(intent);
    }

    public void onLowMemory()
    {
        getDelegate().onLowMemory_impl();
    }

    public void onRebind(Intent intent)
    {
        getDelegate().onRebind_impl(intent);
    }

    public void onStart(Intent intent, int i)
    {
        getDelegate().onStart_impl(intent, i);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        return getDelegate().onStartCommand_impl(intent, i, j);
    }

    public void onTaskRemoved(Intent intent)
    {
        getDelegate().onTaskRemoved_impl(intent);
    }

    public void onTrimMemory(int i)
    {
        getDelegate().onTrimMemory_impl(i);
    }

    public boolean onUnbind(Intent intent)
    {
        return getDelegate().onUnbind_impl(intent);
    }

    public void superDump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        super.dump(filedescriptor, printwriter, as);
    }

    public IBinder superOnBind(Intent intent)
    {
        return super.onBind(intent);
    }

    public void superOnConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
    }

    public void superOnCreate()
    {
        super.onCreate();
    }

    public void superOnDestroy()
    {
        super.onDestroy();
    }

    public void superOnLowMemory()
    {
        super.onLowMemory();
    }

    public void superOnRebind(Intent intent)
    {
        super.onRebind(intent);
    }

    public void superOnStart(Intent intent, int i)
    {
        super.onStart(intent, i);
    }

    public int superOnStartCommand(Intent intent, int i, int j)
    {
        return super.onStartCommand(intent, i, j);
    }

    public void superOnTaskRemoved(Intent intent)
    {
        super.onTaskRemoved(intent);
    }

    public void superOnTrimMemory(int i)
    {
        super.onTrimMemory(i);
    }

    public boolean superOnUnbind(Intent intent)
    {
        return super.onUnbind(intent);
    }

    public void superSetIntentRedelivery(boolean flag)
    {
        super.setIntentRedelivery(flag);
    }
}
