// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.dex;

import android.app.Activity;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import dalvik.system.DexClassLoader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.mShop.android.platform.dex:
//            DexUtils

public class SecondDexEntry
{
    private static class ExtractAndFillClassLoader
        implements Runnable
    {

        private final ThreadPoolExecutor mExecutor;

        public void run()
        {
            SecondDexEntry.getInstance().extractDexAndLoad(mExecutor);
        }

        public ExtractAndFillClassLoader(ThreadPoolExecutor threadpoolexecutor)
        {
            mExecutor = threadpoolexecutor;
        }
    }

    private static class SingletonHolder
    {

        public static final SecondDexEntry INSTANCE = new SecondDexEntry();


        private SingletonHolder()
        {
        }
    }


    protected DexClassLoader mClassLoader;
    protected Context mContext;
    private final CountDownLatch mDexPathUpdatedLatch;
    private boolean mIsDebuggable;

    private SecondDexEntry()
    {
        mDexPathUpdatedLatch = new CountDownLatch(1);
        mIsDebuggable = false;
    }


    private ClassLoader getClassLoader(long l)
    {
        waitForLoad(l);
        if (mClassLoader == null)
        {
            return super.getClass().getClassLoader();
        } else
        {
            return mClassLoader;
        }
    }

    private String getDelegateName(Object obj)
    {
        return obj.getClass().getCanonicalName().replace("Proxy", "Delegate");
    }

    public static SecondDexEntry getInstance()
    {
        return SingletonHolder.INSTANCE;
    }

    private static boolean getIsDebuggableFlag(Context context)
    {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    private static void throwRuntimeException(Exception exception)
    {
        throw new RuntimeException(exception);
    }

    private void waitForLoad(long l)
    {
        if (mContext == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        if (l <= -1L)
        {
            try
            {
                mDexPathUpdatedLatch.await();
                return;
            }
            catch (Exception exception)
            {
                Thread.currentThread().interrupt();
                throwRuntimeException(exception);
                return;
            }
        }
        mDexPathUpdatedLatch.await(l, TimeUnit.SECONDS);
        return;
        throw new IllegalStateException("The secondary dex hasn't been initialized before using it");
    }

    public Object createActivityDelegate(Activity activity)
    {
        return createDelegate(activity);
    }

    public Object createBroadcastReceiveDelegate(BroadcastReceiver broadcastreceiver)
    {
        return createDelegate(broadcastreceiver, 4L);
    }

    public Object createContentProviderDelegate(ContentProvider contentprovider)
    {
        return createDelegate(contentprovider, 4L);
    }

    public Object createDelegate(Object obj)
    {
        return createDelegate(obj, -1L);
    }

    public Object createDelegate(Object obj, long l)
    {
        try
        {
            String s = getDelegateName(obj);
            obj = getClassLoader(l).loadClass(s).getConstructor(new Class[] {
                obj.getClass()
            }).newInstance(new Object[] {
                obj
            });
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throwRuntimeException(((Exception) (obj)));
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throwRuntimeException(((Exception) (obj)));
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throwRuntimeException(((Exception) (obj)));
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throwRuntimeException(((Exception) (obj)));
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throwRuntimeException(((Exception) (obj)));
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            throwRuntimeException(((Exception) (obj)));
            return null;
        }
        return obj;
    }

    public Object createServiceDelegate(Service service)
    {
        return createDelegate(service, 4L);
    }

    protected void extractDexAndLoad(ThreadPoolExecutor threadpoolexecutor)
    {
        String s1 = DexUtils.copyJarsToAppPrivateFolder(mContext, threadpoolexecutor);
        threadpoolexecutor = null;
        String s = DexUtils.getAppPrivateNativeLibsPath(mContext);
        threadpoolexecutor = s;
_L2:
        try
        {
            mClassLoader = new DexClassLoader(s1, DexUtils.getPrivateDexCachePath(mContext), threadpoolexecutor, mContext.getClassLoader());
        }
        // Misplaced declaration of an exception variable
        catch (ThreadPoolExecutor threadpoolexecutor)
        {
            Log.d("SecondDexEntry", "Copying jar has error", threadpoolexecutor);
        }
        mDexPathUpdatedLatch.countDown();
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public ClassLoader getClassLoader()
    {
        return getClassLoader(-1L);
    }

    public void init(Context context)
    {
        this;
        JVM INSTR monitorenter ;
        Context context1 = mContext;
        if (context1 == null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        mContext = context;
        mIsDebuggable = getIsDebuggableFlag(context);
        loadDex();
          goto _L1
        context;
        throwRuntimeException(context);
          goto _L1
        context;
        throw context;
        context;
        throwRuntimeException(context);
          goto _L1
    }

    public boolean isDebuggable()
    {
        return mIsDebuggable;
    }

    protected void loadDex()
        throws IOException, InterruptedException
    {
        int i = Math.max(Runtime.getRuntime().availableProcessors(), 2);
        LinkedBlockingQueue linkedblockingqueue = new LinkedBlockingQueue();
        (new Thread(new ExtractAndFillClassLoader(new ThreadPoolExecutor(i, i, 1L, TimeUnit.SECONDS, linkedblockingqueue)))).start();
    }
}
