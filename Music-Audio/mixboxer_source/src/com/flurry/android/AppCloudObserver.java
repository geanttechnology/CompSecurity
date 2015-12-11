// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


// Referenced classes of package com.flurry.android:
//            AppCloudValueUpdateHandler

public interface AppCloudObserver
{

    public abstract void addObserverForKey(String s, AppCloudValueUpdateHandler appcloudvalueupdatehandler);

    public abstract boolean containsObserver();

    public abstract boolean isAutoSyncEnabled();

    public abstract boolean removeAllObservers();

    public abstract boolean removeObserver(AppCloudValueUpdateHandler appcloudvalueupdatehandler);

    public abstract boolean removeObserverForKey(String s);

    public abstract boolean setAutoSyncEnabled(boolean flag);
}
