// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.services;

import android.app.Service;
import android.content.Intent;
import android.content.res.Configuration;
import com.amazon.mShop.android.platform.services.api.IAndroidServiceProxy;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public class ServiceDelegateBase
{

    protected final Service mServiceProxy;

    public ServiceDelegateBase(Service service)
    {
        mServiceProxy = service;
    }

    public void dump_impl(FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        ((IAndroidServiceProxy)mServiceProxy).superDump(filedescriptor, printwriter, as);
    }

    public Service getProxy()
    {
        return mServiceProxy;
    }

    public void onConfigurationChanged_impl(Configuration configuration)
    {
        ((IAndroidServiceProxy)mServiceProxy).superOnConfigurationChanged(configuration);
    }

    public void onCreate_impl()
    {
        ((IAndroidServiceProxy)mServiceProxy).superOnCreate();
    }

    public void onDestroy_impl()
    {
        ((IAndroidServiceProxy)mServiceProxy).superOnDestroy();
    }

    public void onLowMemory_impl()
    {
        ((IAndroidServiceProxy)mServiceProxy).superOnLowMemory();
    }

    public void onRebind_impl(Intent intent)
    {
        ((IAndroidServiceProxy)mServiceProxy).superOnRebind(intent);
    }

    public int onStartCommand_impl(Intent intent, int i, int j)
    {
        return ((IAndroidServiceProxy)mServiceProxy).superOnStartCommand(intent, i, j);
    }

    public void onStart_impl(Intent intent, int i)
    {
        ((IAndroidServiceProxy)mServiceProxy).superOnStart(intent, i);
    }

    public void onTaskRemoved_impl(Intent intent)
    {
        ((IAndroidServiceProxy)mServiceProxy).superOnTaskRemoved(intent);
    }

    public void onTrimMemory_impl(int i)
    {
        ((IAndroidServiceProxy)mServiceProxy).superOnTrimMemory(i);
    }

    public boolean onUnbind_impl(Intent intent)
    {
        return ((IAndroidServiceProxy)mServiceProxy).superOnUnbind(intent);
    }
}
