// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.library.services;

import android.util.Log;
import com.aviary.android.feather.common.utils.IDisposable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.aviary.android.feather.library.services:
//            IAviaryController, BaseContextService

public class ServiceLoader
    implements IDisposable
{

    private static final String TAG = "ServiceLoader";
    IAviaryController mContext;
    final ConcurrentHashMap mMap = new ConcurrentHashMap();
    final ConcurrentHashMap mServices = new ConcurrentHashMap();

    public ServiceLoader(IAviaryController iaviarycontroller)
    {
        mContext = iaviarycontroller;
    }

    private BaseContextService createService(Class class1, IAviaryController iaviarycontroller)
        throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        return (BaseContextService)class1.getConstructor(new Class[] {
            com/aviary/android/feather/library/services/IAviaryController
        }).newInstance(new Object[] {
            iaviarycontroller
        });
    }

    private BaseContextService get(String s, IAviaryController iaviarycontroller)
        throws IllegalAccessException, InstantiationException
    {
        Log.i("ServiceLoader", (new StringBuilder()).append("get: ").append(s).toString());
        if (!mMap.containsKey(s)) goto _L2; else goto _L1
_L1:
        s = (Class)mMap.get(s);
        s = createService(s, iaviarycontroller);
        return s;
        s;
        s.printStackTrace();
_L4:
        return null;
_L2:
        Log.w("ServiceLoader", (new StringBuilder()).append(s).append(" not registered").toString());
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void dispose()
    {
        for (Iterator iterator = mServices.keySet().iterator(); iterator.hasNext(); ((BaseContextService)mServices.get(iterator.next())).internalDispose()) { }
        break MISSING_BLOCK_LABEL_57;
        Object obj;
        obj;
        ((Exception) (obj)).printStackTrace();
        mServices.clear();
        return;
        mServices.clear();
        return;
        obj;
        mServices.clear();
        throw obj;
    }

    public BaseContextService getService(Class class1)
        throws IllegalAccessException
    {
        String s = class1.getName();
        if (mServices.containsKey(s))
        {
            return (BaseContextService)mServices.get(s);
        }
        if (!mMap.containsKey(s))
        {
            Log.v("ServiceLoader", "class not yet registered, register it...");
            register(class1);
        }
        try
        {
            class1 = get(s, mContext);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            class1.printStackTrace();
            throw new IllegalAccessException(class1.getMessage());
        }
        if (class1 != null)
        {
            register(class1);
            return class1;
        } else
        {
            Log.w("ServiceLoader", "service is not registered!");
            return null;
        }
    }

    public BaseContextService register(BaseContextService basecontextservice)
    {
        String s = basecontextservice.getClass().getName();
        Log.i("ServiceLoader", (new StringBuilder()).append("register: ").append(s).toString());
        return (BaseContextService)mServices.put(s, basecontextservice);
    }

    public Class register(Class class1)
    {
        return (Class)mMap.put(class1.getName(), class1);
    }

    public boolean remove(BaseContextService basecontextservice)
    {
        basecontextservice = basecontextservice.getClass().getName();
        basecontextservice = (BaseContextService)mServices.remove(basecontextservice);
        if (basecontextservice != null)
        {
            basecontextservice.internalDispose();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean remove(Class class1)
    {
        class1 = class1.getName();
        BaseContextService basecontextservice = (BaseContextService)mServices.remove(class1);
        if (basecontextservice != null)
        {
            basecontextservice.internalDispose();
        }
        mMap.remove(class1);
        return true;
    }
}
