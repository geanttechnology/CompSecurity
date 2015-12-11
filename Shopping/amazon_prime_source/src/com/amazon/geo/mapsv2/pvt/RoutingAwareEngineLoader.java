// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// Referenced classes of package com.amazon.geo.mapsv2.pvt:
//            InternalEngineLoader

public class RoutingAwareEngineLoader extends InternalEngineLoader
{

    private static final String DEBUG_PACKAGE = "com.amazon.geo.client.maps.debug";
    private static final String GET_ENGINE_CONTEXT_METHOD = "getEngineContext";
    private static final String ROUTING_ENGINE_UTIL_CLASS = "com.amazon.geo.routing.RoutingEngineUtil";
    private static Boolean ROUTING_SUPPORT_LIBRARY_LOADED = null;
    private static final String TAG = com/amazon/geo/mapsv2/pvt/RoutingAwareEngineLoader.getName();
    private boolean mIsLoadingRouting;

    public RoutingAwareEngineLoader(Context context)
    {
        this(context, null);
    }

    public RoutingAwareEngineLoader(Context context, Bundle bundle)
    {
        super(context, bundle);
        mIsLoadingRouting = false;
    }

    public static boolean isRoutingSupportLibraryLoaded(Context context)
    {
        if (ROUTING_SUPPORT_LIBRARY_LOADED == null)
        {
            context = context.getApplicationContext().getClassLoader();
            try
            {
                context.loadClass("com.amazon.geo.routing.RoutingEngineUtil");
                ROUTING_SUPPORT_LIBRARY_LOADED = Boolean.valueOf(true);
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                ROUTING_SUPPORT_LIBRARY_LOADED = Boolean.valueOf(false);
            }
        }
        return ROUTING_SUPPORT_LIBRARY_LOADED.booleanValue();
    }

    public transient Context createInstance(Object aobj[])
    {
        Context context = super.createInstance(aobj);
        if (context == null)
        {
            aobj = null;
        } else
        {
            aobj = context;
            if (!mIsLoadingRouting)
            {
                aobj = context;
                if (isRoutingSupportLibraryLoaded(context))
                {
                    aobj = context;
                    if (isDebugLibraryAvailable(context))
                    {
                        mIsLoadingRouting = true;
                        try
                        {
                            Class.forName("com.amazon.geo.routing.RoutingEngineUtil").getMethod("getEngineContext", new Class[] {
                                android/content/Context
                            }).invoke(null, new Object[] {
                                context.getApplicationContext()
                            });
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object aobj[])
                        {
                            Log.w(TAG, "Unable to find class com.amazon.geo.routing.RoutingEngineUtil", ((Throwable) (aobj)));
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object aobj[])
                        {
                            Log.w(TAG, "Unable to find method getEngineContext", ((Throwable) (aobj)));
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object aobj[])
                        {
                            Log.w(TAG, "Unable to access method getEngineContext", ((Throwable) (aobj)));
                        }
                        // Misplaced declaration of an exception variable
                        catch (Object aobj[])
                        {
                            Log.w(TAG, "Unable to invoke method getEngineContext on target.", ((Throwable) (aobj)));
                        }
                        mIsLoadingRouting = false;
                        return context;
                    }
                }
            }
        }
        return ((Context) (aobj));
    }

    public volatile Object createInstance(Object aobj[])
    {
        return createInstance(aobj);
    }

    public boolean isDebugLibraryAvailable(Context context)
    {
        try
        {
            context.getPackageManager().getPackageInfo("com.amazon.geo.client.maps.debug", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        return true;
    }

}
