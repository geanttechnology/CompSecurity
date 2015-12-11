// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.content.Context;
import android.os.Bundle;
import com.amazon.client.framework.acf.util.Preconditions;
import com.amazon.geo.mapsv2.MapsInitializer;
import com.amazon.geo.mapsv2.pvt.InternalEngineLoader;
import com.amazon.geo.mapsv2.pvt.RoutingAwareEngineLoader;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.geo.mapsv2.util:
//            MapsInitializationOptions, AmazonMapsRuntimeUtil

public final class MapsInitializerInternal
{
    public static interface PreloadController
    {

        public abstract void cancel();
    }

    public static interface PreloadObserver
    {

        public abstract void onPreloadEnd(PreloadResult preloadresult);

        public abstract void onPreloadProgress(PreloadController preloadcontroller, int i, int j);

        public abstract void onPreloadStart(PreloadController preloadcontroller);
    }

    public static final class PreloadResult extends Enum
    {

        private static final PreloadResult $VALUES[];
        public static final PreloadResult CANCELED;
        public static final PreloadResult FAILED;
        public static final PreloadResult OK;

        public static PreloadResult valueOf(String s)
        {
            return (PreloadResult)Enum.valueOf(com/amazon/geo/mapsv2/util/MapsInitializerInternal$PreloadResult, s);
        }

        public static PreloadResult[] values()
        {
            return (PreloadResult[])$VALUES.clone();
        }

        static 
        {
            OK = new PreloadResult("OK", 0);
            CANCELED = new PreloadResult("CANCELED", 1);
            FAILED = new PreloadResult("FAILED", 2);
            $VALUES = (new PreloadResult[] {
                OK, CANCELED, FAILED
            });
        }

        private PreloadResult(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String APP_PROVIDED_ACCOUNT_KEY = "com.amazon.geo.mapsv2.appProvidesAccountInfo";
    public static final String ASSET_NAME_OVERRIDE = "com.amazon.geo.mapsv2.engineAssetName";
    public static final String DEFAULT_ENGINE_ASSET_NAME = "amazon/geo/MapsAPIClientServices.apk";
    public static final String FORCE_LOCAL_ENGINE_ALWAYS_EXPAND_KEY = "com.amazon.geo.mapsv2.forceAlwaysLoadEngineFromAssetsOnLaunch";
    public static final String FORCE_LOCAL_ENGINE_KEY = "com.amazon.geo.mapsv2.forceLoadEngineFromAssets";
    public static final String FORCE_LOCAL_KEY_MANAGER = "com.amazon.geo.mapsv2.forceLocalKeyManagement";
    public static final String FORCE_NO_ACCOUNT_KEY = "com.amazon.geo.mapsv2.forceNoAccount";
    private static InternalEngineLoader sLoader;

    public MapsInitializerInternal()
    {
    }

    private static InternalEngineLoader getOrCreateEngineLoader(Context context, Bundle bundle)
    {
        if (sLoader == null)
        {
            setEngineLoader(new RoutingAwareEngineLoader(context, bundle));
        }
        return sLoader;
    }

    public static int initialize(Context context)
    {
        preload(context, null);
        return MapsInitializer.initialize(context);
    }

    public static int initialize(Context context, MapsInitializationOptions mapsinitializationoptions)
    {
        preload(context, mapsinitializationoptions.toBundle());
        return MapsInitializer.initialize(context);
    }

    static boolean isAssetAvailable(Context context)
    {
        return getOrCreateEngineLoader(context, null).isAssetAvailable();
    }

    public static boolean isPreloaded(Context context)
    {
        if (sLoader != null)
        {
            return sLoader.isPreloaded(context);
        } else
        {
            return false;
        }
    }

    public static void preload(Context context)
    {
        preload(context, null);
    }

    public static void preload(Context context, Bundle bundle)
    {
        preload(context, bundle, null);
    }

    public static void preload(Context context, Bundle bundle, PreloadObserver preloadobserver)
    {
        preload(context, bundle, preloadobserver, null);
    }

    public static void preload(Context context, Bundle bundle, PreloadObserver preloadobserver, Executor executor)
    {
        Preconditions.isMainThread();
        InternalEngineLoader internalengineloader = getOrCreateEngineLoader(context, bundle);
        if (preloadobserver != null)
        {
            internalengineloader.addPreloadObserver(preloadobserver);
        }
        internalengineloader.startPreload(context, bundle, executor);
    }

    static void setEngineLoader(InternalEngineLoader internalengineloader)
    {
        sLoader = internalengineloader;
        internalengineloader = AmazonMapsRuntimeUtil.resetBuddyModuleFactory(sLoader);
        sLoader.setDefaultFactory(internalengineloader);
    }
}
