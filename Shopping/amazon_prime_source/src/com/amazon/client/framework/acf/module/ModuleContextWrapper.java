// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf.module;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// Referenced classes of package com.amazon.client.framework.acf.module:
//            IsolatingClassLoader

class ModuleContextWrapper extends ContextWrapper
{

    private static final ReadWriteLock sLoadersLock = new ReentrantReadWriteLock();
    private static final Map sModuleClassLoaders = new HashMap();
    private final Context mAppContext;
    private final ClassLoader mClassLoader;
    private final LayoutInflater mInflater;

    ModuleContextWrapper(Context context, Context context1, ClassLoader classloader)
    {
        super(context1);
        mAppContext = context;
        mClassLoader = classloader;
        mInflater = LayoutInflater.from(context1).cloneInContext(this);
    }

    ModuleContextWrapper(Context context, ClassLoader classloader)
    {
        this(null, context, classloader);
    }

    private static ClassLoader getModuleClassLoaderUnguarded(String s, boolean flag)
    {
        s = (WeakReference)sModuleClassLoaders.get(s);
        String s1;
        if (s == null)
        {
            s = null;
        } else
        {
            s = (ClassLoader)s.get();
        }
        s1 = s;
        if (flag)
        {
            s1 = s;
            if (!(s instanceof IsolatingClassLoader))
            {
                s1 = null;
            }
        }
        return s1;
    }

    private static ClassLoader makeModuleClassLoader(String s, String s1, String s2, String s3, ClassLoader classloader, Bundle bundle)
    {
        boolean flag;
        flag = true;
        if (bundle != null)
        {
            flag = bundle.getBoolean("kuromame.Module.isolate", true);
        }
        sLoadersLock.readLock().lock();
        bundle = getModuleClassLoaderUnguarded(s, flag);
        Object obj;
        sLoadersLock.readLock().unlock();
        obj = bundle;
        if (bundle != null) goto _L2; else goto _L1
_L1:
        sLoadersLock.writeLock().lock();
        obj = getModuleClassLoaderUnguarded(s, flag);
        bundle = ((Bundle) (obj));
        if (obj != null) goto _L4; else goto _L3
_L3:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_165;
        }
        bundle = new IsolatingClassLoader(s1, s2, s3, classloader);
_L5:
        sModuleClassLoaders.put(s, new WeakReference(bundle));
_L4:
        sLoadersLock.writeLock().unlock();
        obj = bundle;
_L2:
        return ((ClassLoader) (obj));
        s;
        sLoadersLock.readLock().unlock();
        throw s;
        bundle = new DexClassLoader(s1, s2, s3, classloader);
          goto _L5
        s;
        sLoadersLock.writeLock().unlock();
        throw s;
    }

    static ModuleContextWrapper wrapModuleContext(Context context, ClassLoader classloader, Context context1, Bundle bundle)
    {
        String s = context1.getPackageName();
        File file = context.getApplicationContext().getDir((new StringBuilder()).append(s).append(".code_cache").toString(), 0);
        String s1 = context1.getPackageCodePath();
        String s2 = context1.getApplicationInfo().nativeLibraryDir;
        return new ModuleContextWrapper(context.getApplicationContext(), context1, makeModuleClassLoader(s, s1, file.getAbsolutePath(), s2, classloader, bundle));
    }

    public Context getApplicationContext()
    {
        if (mAppContext == null)
        {
            return super.getApplicationContext();
        } else
        {
            return mAppContext;
        }
    }

    public ClassLoader getClassLoader()
    {
        return mClassLoader;
    }

    public Object getSystemService(String s)
    {
        if ("layout_inflater".equals(s))
        {
            return mInflater;
        } else
        {
            return super.getSystemService(s);
        }
    }

}
