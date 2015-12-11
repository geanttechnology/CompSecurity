// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.webkit.android;

import android.content.Context;
import com.amazon.android.webkit.AmazonPluginManager;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.android.webkit.android:
//            Reflect

public class AndroidPluginManager
    implements AmazonPluginManager
{

    private static final Method GET_INSTANCE;
    private static final Class PLUGIN_MANAGER;
    private static final Method REFRESH_PLUGINS;
    private final Object receiver;

    public AndroidPluginManager(Context context)
    {
        receiver = Reflect.invokeMethod(GET_INSTANCE, null, new Object[] {
            context
        });
    }

    public void refreshPlugins(boolean flag)
    {
        Reflect.invokeMethod(REFRESH_PLUGINS, receiver, new Object[] {
            Boolean.valueOf(flag)
        });
    }

    static 
    {
        try
        {
            PLUGIN_MANAGER = Class.forName("android.webkit.PluginManager");
            GET_INSTANCE = Reflect.getRequiredMethod(PLUGIN_MANAGER, "getInstance", new Class[] {
                android/content/Context
            });
            REFRESH_PLUGINS = Reflect.getRequiredMethod(PLUGIN_MANAGER, "refreshPlugins", new Class[] {
                Boolean.TYPE
            });
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            throw new AssertionError(classnotfoundexception);
        }
    }
}
