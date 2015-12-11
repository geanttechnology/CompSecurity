// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji;

import android.app.Application;
import com.bitstrips.imoji.util.AppiumLogger;
import com.bitstrips.outfitbuilder.managers.OBUrlsManager;
import com.facebook.FacebookSdk;
import dagger.ObjectGraph;

// Referenced classes of package com.bitstrips.imoji:
//            InjectorApplication, ImojiModule

public class ImojiApplication extends Application
    implements InjectorApplication
{

    private ObjectGraph graph;

    public ImojiApplication()
    {
    }

    protected Object[] getModules()
    {
        return (new Object[] {
            new ImojiModule(this)
        });
    }

    public void inject(Object obj)
    {
        graph.inject(obj);
    }

    public void onCreate()
    {
        super.onCreate();
        FacebookSdk.sdkInitialize(getApplicationContext());
        OBUrlsManager.initialize(getString(0x7f0600cf));
        if ("r2d2".equals("production"))
        {
            AppiumLogger.initLogger();
        }
        graph = ObjectGraph.create(getModules());
    }
}
