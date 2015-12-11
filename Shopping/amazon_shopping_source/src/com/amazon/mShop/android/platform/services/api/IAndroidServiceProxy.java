// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.android.platform.services.api;

import android.content.Intent;
import android.content.res.Configuration;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface IAndroidServiceProxy
{

    public abstract void superDump(FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract void superOnConfigurationChanged(Configuration configuration);

    public abstract void superOnCreate();

    public abstract void superOnDestroy();

    public abstract void superOnLowMemory();

    public abstract void superOnRebind(Intent intent);

    public abstract void superOnStart(Intent intent, int i);

    public abstract int superOnStartCommand(Intent intent, int i, int j);

    public abstract void superOnTaskRemoved(Intent intent);

    public abstract void superOnTrimMemory(int i);

    public abstract boolean superOnUnbind(Intent intent);
}
