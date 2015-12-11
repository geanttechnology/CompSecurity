// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.dagger.application;

import android.net.ConnectivityManager;
import dagger.internal.ProvidesBinding;
import javax.inject.Provider;

// Referenced classes of package com.amazon.android.dagger.application:
//            ContextModule

public static final class setLibrary extends ProvidesBinding
    implements Provider
{

    private final ContextModule module;

    public ConnectivityManager get()
    {
        return module.provideConnectivityManager();
    }

    public volatile Object get()
    {
        return get();
    }

    public (ContextModule contextmodule)
    {
        super("android.net.ConnectivityManager", false, "com.amazon.android.dagger.application.ContextModule", "provideConnectivityManager");
        module = contextmodule;
        setLibrary(true);
    }
}
