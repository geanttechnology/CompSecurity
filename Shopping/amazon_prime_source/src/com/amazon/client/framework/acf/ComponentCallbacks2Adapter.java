// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;

public abstract class ComponentCallbacks2Adapter
    implements ComponentCallbacks2
{

    public ComponentCallbacks2Adapter()
    {
    }

    public void onConfigurationChanged(Configuration configuration)
    {
    }

    public void onLowMemory()
    {
        onTrimMemory(80);
    }
}
