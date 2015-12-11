// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.app.Application;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            MapsPreloader, MapsInitializationOptions

public class MapsPreloadApplication extends Application
{

    MapsPreloader mPreloader;

    public MapsPreloadApplication()
    {
        mPreloader = new MapsPreloader();
    }

    public void onCreate()
    {
        super.onCreate();
        mPreloader.preload(this);
    }

    protected void setInitializationParams(MapsInitializationOptions mapsinitializationoptions)
    {
        mPreloader.setInitializationParams(mapsinitializationoptions);
    }

    protected void setPreloadExecutor(Executor executor)
    {
        mPreloader.setPreloadExecutor(executor);
    }
}
