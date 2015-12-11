// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.pvt;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;
import com.amazon.client.framework.acf.ComponentInjectors;
import com.amazon.client.framework.acf.WeakRegistrar;
import com.amazon.client.framework.acf.module.ApkAssetExpander;
import com.amazon.client.framework.acf.module.Module;
import com.amazon.client.framework.acf.module.PrivateApk;
import com.amazon.client.framework.acf.util.Preconditions;
import com.amazon.client.framework.androidresparser.AndroidManifest;
import com.amazon.geo.mapsv2.model.pvt.Primitives;
import com.amazon.geo.mapsv2.util.AmazonMapsRuntimeUtilInternal;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

// Referenced classes of package com.amazon.geo.mapsv2.pvt:
//            InternalPrimitiveFactoryImpl

public class InternalEngineLoader
    implements LazyInitializer.LazyFactory
{
    private final class PreloadManager
        implements com.amazon.client.framework.acf.module.ApkAssetExpander.ApkAssetExpanderObserver, com.amazon.client.framework.acf.module.ApkAssetExpander.VersioningAuthority, com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadController
    {

        final InternalEngineLoader this$0;

        public void cancel()
        {
            mExpander.cancel();
        }

        public void onAssetExpansionEnd(ApkAssetExpander apkassetexpander, com.amazon.client.framework.acf.module.ApkAssetExpander.Result result)
        {
            static class _cls1
            {

                static final int $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result[];

                static 
                {
                    $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result = new int[com.amazon.client.framework.acf.module.ApkAssetExpander.Result.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result[com.amazon.client.framework.acf.module.ApkAssetExpander.Result.OK.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    try
                    {
                        $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result[com.amazon.client.framework.acf.module.ApkAssetExpander.Result.OK_NO_CHANGE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$client$framework$acf$module$ApkAssetExpander$Result[com.amazon.client.framework.acf.module.ApkAssetExpander.Result.FAIL_CANCELLED.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1..SwitchMap.com.amazon.client.framework.acf.module.ApkAssetExpander.Result[result.ordinal()];
            JVM INSTR tableswitch 1 3: default 36
        //                       1 91
        //                       2 91
        //                       3 105;
               goto _L1 _L2 _L2 _L3
_L1:
            mLastResult = com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadResult.FAILED;
_L5:
            for (apkassetexpander = mObservers.iterator(); apkassetexpander.hasNext(); ((com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadObserver)apkassetexpander.next()).onPreloadEnd(mLastResult)) { }
            break; /* Loop/switch isn't completed */
_L2:
            mLastResult = com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadResult.OK;
            continue; /* Loop/switch isn't completed */
_L3:
            mLastResult = com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadResult.CANCELED;
            if (true) goto _L5; else goto _L4
_L4:
        }

        public void onAssetExpansionProgress(ApkAssetExpander apkassetexpander, int i, int j)
        {
            for (apkassetexpander = mObservers.iterator(); apkassetexpander.hasNext(); ((com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadObserver)apkassetexpander.next()).onPreloadProgress(this, i, j)) { }
        }

        public void onAssetExpansionStart(ApkAssetExpander apkassetexpander)
        {
            for (apkassetexpander = mObservers.iterator(); apkassetexpander.hasNext(); ((com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadObserver)apkassetexpander.next()).onPreloadStart(this)) { }
        }

        public com.amazon.client.framework.acf.module.ApkAssetExpander.VersionQueryResponse queryUpgradeAction(AndroidManifest androidmanifest, AndroidManifest androidmanifest1)
        {
            return com.amazon.client.framework.acf.module.ApkAssetExpander.VersionQueryResponse.ALWAYS_UPGRADE;
        }

        private PreloadManager()
        {
            this$0 = InternalEngineLoader.this;
            super();
        }

    }

    private static class ThreadPerTaskExecutor
        implements Executor
    {

        public void execute(Runnable runnable)
        {
            (new Thread(runnable)).start();
        }

        private ThreadPerTaskExecutor()
        {
        }

    }


    private static volatile boolean sAssetVerified = false;
    private final String mAssetName;
    private LazyInitializer.LazyFactory mDefaultFactory;
    private Context mExpandedContext;
    private final ApkAssetExpander mExpander;
    private com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadResult mLastResult;
    private final Bundle mMetaData;
    private final WeakRegistrar mObservers;
    private final boolean mPreferLocalEngine;
    private final PreloadManager mPreloadManager;
    private Context mSystemContext;

    public InternalEngineLoader(Context context)
    {
        this(context, null);
    }

    public InternalEngineLoader(Context context, Bundle bundle)
    {
        mObservers = new WeakRegistrar();
        mPreloadManager = new PreloadManager(null);
        boolean flag2 = false;
        boolean flag1 = false;
        boolean flag4 = false;
        boolean flag = false;
        boolean flag5 = false;
        String s = "amazon/geo/MapsAPIClientServices.apk";
        Bundle bundle1 = ComponentInjectors.mergeBundles(getMetaDataFrom(context), bundle);
        mMetaData = bundle1;
        bundle = s;
        boolean flag3 = flag5;
        if (bundle1 != null)
        {
            bundle = ((Bundle) (bundle1.get("com.amazon.geo.mapsv2.forceLoadEngineFromAssets")));
            if (bundle != null)
            {
                flag = Boolean.parseBoolean(bundle.toString());
            }
            bundle = ((Bundle) (bundle1.get("com.amazon.geo.mapsv2.forceAlwaysLoadEngineFromAssetsOnLaunch")));
            if (bundle != null)
            {
                flag1 = Boolean.parseBoolean(bundle.toString());
            }
            flag2 = flag1;
            bundle = s;
            flag3 = flag5;
            flag4 = flag;
            if (bundle1 != null)
            {
                Object obj = bundle1.get("com.amazon.geo.mapsv2.engineAssetName");
                bundle = s;
                if (obj != null)
                {
                    bundle = obj.toString();
                }
                flag3 = bundle1.getBoolean("kuromame.Module.patch", false);
                flag4 = flag;
                flag2 = flag1;
            }
        }
        mPreferLocalEngine = flag4;
        mAssetName = bundle;
        if (flag2)
        {
            mExpander = new ApkAssetExpander(context, mPreloadManager, flag3);
        } else
        {
            mExpander = new ApkAssetExpander(context, flag3);
        }
        mExpander.addApkAssetExpanderObserver(mPreloadManager);
    }

    private static Bundle getMetaDataFrom(Context context)
    {
        Object obj;
        try
        {
            obj = context.getApplicationInfo();
            if (((ApplicationInfo) (obj)).metaData != null)
            {
                return ((ApplicationInfo) (obj)).metaData;
            }
            obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        }
        catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
        {
            Log.w("AmazonMapsV2", String.format("Package %s was not found installed on the system. While not fatal this is odd.", new Object[] {
                context.getPackageName()
            }));
            return null;
        }
        return ((Bundle) (obj));
    }

    private transient Context getSystemEngine(Context context, Object aobj[])
    {
        Preconditions.isMainThread();
        if (mSystemContext != null)
        {
            return mSystemContext;
        }
        if (!mPreferLocalEngine)
        {
            context = mDefaultFactory;
            if (context != null)
            {
                try
                {
                    mSystemContext = (Context)context.createInstance(aobj);
                }
                // Misplaced declaration of an exception variable
                catch (Context context)
                {
                    Log.v("AmazonMapsV2", "Module threw an exception.", context);
                }
            }
        }
        return mSystemContext;
    }

    public void addPreloadObserver(com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadObserver preloadobserver)
    {
        mObservers.add(preloadobserver);
    }

    public transient Context createInstance(Object aobj[])
    {
        Preconditions.isMainThread();
        if (aobj.length == 1) goto _L2; else goto _L1
_L1:
        aobj = null;
_L4:
        return ((Context) (aobj));
_L2:
        Context context;
        Context context1;
        Bundle bundle;
        context1 = (Context)android/content/Context.cast(aobj[0]);
        bundle = mMetaData;
        context = getSystemEngine(context1, aobj);
        aobj = context;
        if (context != null) goto _L4; else goto _L3
_L3:
        if (mExpandedContext != null)
        {
            return mExpandedContext;
        }
        if (mExpander.getStatus() == android.os.AsyncTask.Status.PENDING)
        {
            Log.w("AmazonMapsV2", "About to block the main thread to start loading an Asset engine. You might want to preload the engine to avoid this.");
            mExpander.expandAsset(mAssetName);
        }
        aobj = context;
        if (!ApkAssetExpander.isOk(mExpander.get())) goto _L4; else goto _L5
_L5:
        sAssetVerified = true;
        aobj = mExpander.getExpanded();
        if (((PrivateApk) (aobj)).manifest.getMetaData() != null)
        {
            ((PrivateApk) (aobj)).manifest.getMetaData().putAll(bundle);
        }
        aobj = loadEngineModule(context1, bundle);
        return ((Context) (aobj));
        aobj;
        Log.w("AmazonMapsV2", "Thread was interrupted while waiting for embedded engine to finish expanding.");
        Thread.currentThread().interrupt();
        return context;
        aobj;
        Log.e("AmazonMapsV2", "A fatal error occured while trying to load the embedded engine.", ((Throwable) (aobj)));
        return context;
    }

    public volatile Object createInstance(Object aobj[])
    {
        return createInstance(aobj);
    }

    public boolean isAssetAvailable()
    {
        Object obj;
        String s;
        if (sAssetVerified)
        {
            return sAssetVerified;
        }
        obj = mExpander.getContext();
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        obj = ((Context) (obj)).getAssets();
        s = mAssetName;
        ((AssetManager) (obj)).openFd(s).close();
        sAssetVerified = true;
        return true;
        IOException ioexception;
        ioexception;
        return false;
    }

    public boolean isPreloaded(Context context)
    {
        Preconditions.isMainThread();
        return mLastResult == com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadResult.OK;
    }

    protected Context loadEngineModule(Context context, Bundle bundle)
        throws InterruptedException, ExecutionException
    {
        mExpandedContext = Module.loadModule(context, mExpander.getExpanded(), bundle);
        AmazonMapsRuntimeUtilInternal.initEngineContext(context, mExpandedContext);
        return mExpandedContext;
    }

    public void removePreloadObserver(com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadObserver preloadobserver)
    {
        mObservers.remove(preloadobserver);
    }

    public void setDefaultFactory(LazyInitializer.LazyFactory lazyfactory)
    {
        mDefaultFactory = lazyfactory;
    }

    public void startPreload(Context context)
    {
        startPreload(context, null, null);
    }

    public void startPreload(Context context, Bundle bundle, Executor executor)
    {
label0:
        {
            Preconditions.isMainThread();
            if (mLastResult != com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadResult.OK)
            {
                if (getSystemEngine(context, new Object[] {
    context, bundle
}) != null)
                {
                    mLastResult = com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadResult.OK;
                    for (context = mObservers.iterator(); context.hasNext(); ((com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadObserver)context.next()).onPreloadEnd(mLastResult)) { }
                } else
                {
                    if (mExpander.getStatus() != android.os.AsyncTask.Status.PENDING)
                    {
                        break label0;
                    }
                    context = executor;
                    if (executor == null)
                    {
                        context = new ThreadPerTaskExecutor(null);
                    }
                    mExpander.expandAssetOnExecutor(context, mAssetName);
                }
            }
            return;
        }
        Log.d("AmazonMapsV2", "The preloader is already running or already ran.");
    }

    static 
    {
        Primitives.setInternalPrimitives(new InternalPrimitiveFactoryImpl());
    }





/*
    static com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadResult access$202(InternalEngineLoader internalengineloader, com.amazon.geo.mapsv2.util.MapsInitializerInternal.PreloadResult preloadresult)
    {
        internalengineloader.mLastResult = preloadresult;
        return preloadresult;
    }

*/
}
