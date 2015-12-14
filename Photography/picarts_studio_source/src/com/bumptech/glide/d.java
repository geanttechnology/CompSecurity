// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.engine.m;
import com.bumptech.glide.request.e;

// Referenced classes of package com.bumptech.glide:
//            Registry

public final class d extends ContextWrapper
    implements ComponentCallbacks2
{

    public final Registry a;
    final e b;
    final m c;
    public final int d;
    private final ComponentCallbacks2 e;

    public d(Context context, Registry registry, myobfuscated.ag.d d1, e e1, m m, ComponentCallbacks2 componentcallbacks2, int i)
    {
        super(context.getApplicationContext());
        a = registry;
        b = e1;
        c = m;
        e = componentcallbacks2;
        d = i;
        new Handler(Looper.getMainLooper());
    }

    public final void onConfigurationChanged(Configuration configuration)
    {
        e.onConfigurationChanged(configuration);
    }

    public final void onLowMemory()
    {
        e.onLowMemory();
    }

    public final void onTrimMemory(int i)
    {
        e.onTrimMemory(i);
    }
}
