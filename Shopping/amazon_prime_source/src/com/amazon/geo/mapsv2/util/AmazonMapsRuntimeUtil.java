// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.geo.mapsv2.util;

import android.app.Activity;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import com.amazon.geo.mapsv2.AmazonMapsStrictMode;
import com.amazon.geo.mapsv2.internal.IErrorDialogUtil;
import com.amazon.geo.mapsv2.internal.IMapEngineDelegate;
import com.amazon.geo.mapsv2.internal.IMapsApiStrictModePolicy;
import com.amazon.geo.mapsv2.model.pvt.PrimitivesFactory;
import com.amazon.geo.mapsv2.pvt.LazyInitializer;
import com.amazon.geo.mapsv2.pvt.MapsErrorDialogUtil;
import com.amazon.geo.mapsv2.pvt.ReflectionHelper;
import com.amazon.geo.mapsv2.pvt.RemoteContextUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class AmazonMapsRuntimeUtil
{
    private static class MapsStrictModePolicy
        implements IMapsApiStrictModePolicy
    {

        public boolean detectAll()
        {
            com.amazon.geo.mapsv2.AmazonMapsStrictMode.ApiPolicy apipolicy = AmazonMapsStrictMode.getApiPolicy();
            if (apipolicy == null)
            {
                return false;
            } else
            {
                return apipolicy.detectAll;
            }
        }

        public boolean detectUnimplemented()
        {
            com.amazon.geo.mapsv2.AmazonMapsStrictMode.ApiPolicy apipolicy = AmazonMapsStrictMode.getApiPolicy();
            if (apipolicy == null)
            {
                return false;
            } else
            {
                return apipolicy.detectUnimplemented;
            }
        }

        public boolean penaltyLog()
        {
            com.amazon.geo.mapsv2.AmazonMapsStrictMode.ApiPolicy apipolicy = AmazonMapsStrictMode.getApiPolicy();
            if (apipolicy == null)
            {
                return false;
            } else
            {
                return apipolicy.penaltyLog;
            }
        }

        public boolean penaltyThrow()
        {
            com.amazon.geo.mapsv2.AmazonMapsStrictMode.ApiPolicy apipolicy = AmazonMapsStrictMode.getApiPolicy();
            if (apipolicy == null)
            {
                return false;
            } else
            {
                return apipolicy.penaltyThrow;
            }
        }

        public void throwException(String s, Throwable throwable)
        {
            if (s == null && throwable == null)
            {
                throw new com.amazon.geo.mapsv2.AmazonMapsStrictMode.StrictModeException();
            }
            if (s == null)
            {
                throw new com.amazon.geo.mapsv2.AmazonMapsStrictMode.StrictModeException(throwable);
            }
            if (throwable == null)
            {
                throw new com.amazon.geo.mapsv2.AmazonMapsStrictMode.StrictModeException(s);
            } else
            {
                throw new com.amazon.geo.mapsv2.AmazonMapsStrictMode.StrictModeException(s, throwable);
            }
        }

        MapsStrictModePolicy(Context context)
        {
            if (AmazonMapsStrictMode.getApiPolicy() != com.amazon.geo.mapsv2.AmazonMapsStrictMode.ApiPolicy.NOOP) goto _L2; else goto _L1
_L1:
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (context == null) goto _L2; else goto _L3
_L3:
            if (((ApplicationInfo) (context)).metaData == null) goto _L2; else goto _L4
_L4:
            String s = (String)java/lang/String.cast(((ApplicationInfo) (context)).metaData.get("amazon.maps.strictmode.ApiPolicy"));
            if (s == null) goto _L2; else goto _L5
_L5:
            String as[];
            int j;
            context = new com.amazon.geo.mapsv2.AmazonMapsStrictMode.ApiPolicy.Builder();
            context.detectUnimplemented();
            as = s.split(",");
            j = as.length;
            int i = 0;
_L6:
            String s1;
            if (i >= j)
            {
                break MISSING_BLOCK_LABEL_134;
            }
            s1 = as[i];
            if (s1.equals("throw"))
            {
                context.penaltyThrow();
                break MISSING_BLOCK_LABEL_142;
            }
            if (s1.equals("log"))
            {
                context.penaltyLog();
            }
            break MISSING_BLOCK_LABEL_142;
            try
            {
                AmazonMapsStrictMode.setApiPolicy(context.build());
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Context context) { }
            break; /* Loop/switch isn't completed */
            i++;
            if (true) goto _L6; else goto _L2
_L2:
        }
    }


    public static final String AMAZON_MAPS_RUNTIME_PACKAGE = "com.amazon.geo.mapsv2.services";
    public static final String ERROR_DIALOG_TAG = "AmazonMapsErrorDialog";
    private static final String RECESS_ERROR_DIALOG_CLASS = "com.amazon.geo.mapsv2.internal.RecessErrorDialogUtil";
    public static final String TAG = "AmazonMapsV2";
    private static final Class THIS_CLASS;
    private static final LazyInitializer sBuddyModule = new LazyInitializer(new com.amazon.geo.mapsv2.pvt.LazyInitializer.LazyFactory() {

        public transient Context createInstance(Object aobj[])
        {
            if (aobj.length != 1)
            {
                return null;
            }
            aobj = (Context)android/content/Context.cast(aobj[0]);
            try
            {
                aobj = AmazonMapsRuntimeUtil.loadEngineContext(((Context) (aobj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object aobj[])
            {
                Log.v("AmazonMapsV2", "Module threw an exception.", ((Throwable) (aobj)));
                return null;
            }
            return ((Context) (aobj));
        }

        public volatile Object createInstance(Object aobj[])
        {
            return createInstance(aobj);
        }

    });
    private static final IErrorDialogUtil sErrorDialogUtil;

    private AmazonMapsRuntimeUtil()
    {
        throw new UnsupportedOperationException("Cannot instantiate.");
    }

    private static Bundle getApplicationMetaData(Context context)
    {
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new RuntimeException(context);
        }
        return context;
    }

    public static Dialog getErrorDialog(int i, Activity activity, int j)
    {
        if (sErrorDialogUtil != null)
        {
            return sErrorDialogUtil.getErrorDialog(i, activity, j);
        } else
        {
            return null;
        }
    }

    public static Dialog getErrorDialog(int i, Activity activity, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        if (sErrorDialogUtil != null)
        {
            return sErrorDialogUtil.getErrorDialog(i, activity, j, oncancellistener);
        } else
        {
            return null;
        }
    }

    public static PendingIntent getErrorPendingIntent(int i, Context context, int j)
    {
        if (sErrorDialogUtil != null)
        {
            return sErrorDialogUtil.getErrorPendingIntent(i, context, j);
        } else
        {
            return null;
        }
    }

    public static String getErrorString(int i)
    {
        if (sErrorDialogUtil != null)
        {
            return sErrorDialogUtil.getErrorString(i);
        } else
        {
            return "";
        }
    }

    public static String getOpenSourceSoftwareLicenseInfo(Context context)
    {
        if (sErrorDialogUtil != null)
        {
            return sErrorDialogUtil.getOpenSourceSoftwareLicenseInfo(context);
        } else
        {
            return "";
        }
    }

    private static Class getOriginalAmazonMapsRuntimeUtilClass(Context context)
    {
        try
        {
            context = Class.forName(getUnRewrittenClassName(), true, context.getClassLoader());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static Context getRemoteContext(Context context)
    {
        LazyInitializer lazyinitializer = sBuddyModule;
        if (context == null)
        {
            context = null;
        } else
        {
            context = context.getApplicationContext();
        }
        return (Context)lazyinitializer.get(new Object[] {
            context
        });
    }

    public static Resources getRemoteResource(Context context)
    {
        return getRemoteContext(context).getResources();
    }

    private static String getUnRewrittenClassName()
    {
        return (new StringBuilder()).append("com.").append("amazon.").append("geo.").append("mapsv2.").append("util.").append("AmazonMapsRuntimeUtil").toString();
    }

    static void initEngineContext(Context context, Context context1)
    {
        context1 = RemoteContextUtils.getMapEngine(context1);
        if (context1 != null)
        {
            context1.setPrimitivesFactory(new PrimitivesFactory());
            context1.setApiStrictModePolicy(new MapsStrictModePolicy(context));
        }
    }

    public static int isAmazonMapsRuntimeAvailable(Context context)
    {
        int i;
        try
        {
            i = context.getResources().getInteger(com.amazon.geo.mapsv2.support.R.integer.amazon_maps_services_version);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            try
            {
                context.getClassLoader().loadClass("com.amazon.geo.mapsv2.MapsAPIFireOSClassReplacer");
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                throw obj;
            }
            return 0;
        }
        if (!context.getResources().getBoolean(com.amazon.geo.mapsv2.support.R.bool.amazon_maps_class_replacer))
        {
            Bundle bundle = getApplicationMetaData(context);
            verifyRequiredPackageVersionMetaData(bundle, i);
            Object obj;
            int j;
            if (isTheRewrittenClass())
            {
                obj = "true|false";
            } else
            {
                obj = "true";
            }
            verifyMetaDataExists(bundle, "amazon_maps_services_required", ((String) (obj)));
        }
        try
        {
            j = context.getPackageManager().getPackageInfo("com.amazon.geo.mapsv2.services", 0).versionCode;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return 1;
        }
        return j < i && j != 0 ? 2 : 0;
    }

    public static boolean isAmazonSignedUid(PackageManager packagemanager, int i)
    {
        if (packagemanager == null)
        {
            throw new SecurityException("Unknown error: invalid Package Manager");
        } else
        {
            return RemoteContextUtils.verifySignature(packagemanager, i);
        }
    }

    private static boolean isTheRewrittenClass()
    {
        return !THIS_CLASS.getPackage().getName().contains(".amazon.");
    }

    public static boolean isUserRecoverableError(int i)
    {
        if (sErrorDialogUtil != null)
        {
            return sErrorDialogUtil.isUserRecoverableError(i);
        } else
        {
            return false;
        }
    }

    private static Context loadEngineContext(Context context)
    {
        Object obj1 = null;
        Object obj = null;
        int i;
        if (isTheRewrittenClass())
        {
            Log.v("AmazonMapsV2", "Running as google.  Check to see if amazon class is loaded.");
            obj = getOriginalAmazonMapsRuntimeUtilClass(context);
        } else
        {
            Log.v("AmazonMapsV2", "Running as amazon.");
        }
        i = isAmazonMapsRuntimeAvailable(context);
        if (i != 0)
        {
            Log.v("AmazonMapsV2", (new StringBuilder()).append("Maps runtime not available, code = ").append(i).toString());
            return null;
        }
        if (obj != null)
        {
            try
            {
                obj = RemoteContextUtils.loadExistingModule(context, "com.amazon.geo.mapsv2.services", ((Context)android/content/Context.cast(ReflectionHelper.invokeMethodIfExists(((Class) (obj)), null, "getRemoteContext", new com.amazon.geo.mapsv2.pvt.ReflectionHelper.ParameterSet[] {
                    ReflectionHelper.param(android/content/Context, context)
                }))).getClassLoader());
            }
            catch (InvocationTargetException invocationtargetexception)
            {
                invocationtargetexception = obj1;
            }
        } else
        {
            obj = RemoteContextUtils.loadModule(context, "com.amazon.geo.mapsv2.services", null);
        }
        if (obj != null)
        {
            initEngineContext(context, ((Context) (obj)));
        }
        return ((Context) (obj));
    }

    static com.amazon.geo.mapsv2.pvt.LazyInitializer.LazyFactory resetBuddyModuleFactory(com.amazon.geo.mapsv2.pvt.LazyInitializer.LazyFactory lazyfactory)
    {
        return sBuddyModule.reset(lazyfactory);
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, int j)
    {
        if (sErrorDialogUtil != null)
        {
            return sErrorDialogUtil.showErrorDialogFragment(i, activity, j);
        } else
        {
            return false;
        }
    }

    public static boolean showErrorDialogFragment(int i, Activity activity, int j, android.content.DialogInterface.OnCancelListener oncancellistener)
    {
        if (sErrorDialogUtil != null)
        {
            return sErrorDialogUtil.showErrorDialogFragment(i, activity, j, oncancellistener);
        } else
        {
            return false;
        }
    }

    private static void verifyIntegerResourceMetaData(Bundle bundle, String s, int i, String s1)
    {
        verifyMetaDataExists(bundle, s, s1);
        int j = bundle.getInt(s);
        if (j != i)
        {
            throw new IllegalStateException(String.format("A meta-data tag in your AndroidManifest.xml has an incorrect value.%nExpected %d but found %d.%nThe following should have been defined within your <application> element:%n<meta-data android:name=\"%s\" android:value=\"%s\" />%n%nDo you have manifest merging enabled?", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j), s, s1
            }));
        } else
        {
            return;
        }
    }

    private static void verifyMetaDataExists(Bundle bundle, String s, String s1)
    {
        if (bundle == null || !bundle.containsKey(s))
        {
            throw new IllegalStateException(String.format("A required meta-data tag in your AndroidManifest.xml is missing.%nThe following should have been defined within your <application> element:%n<meta-data android:name=\"%s\" android:value=\"%s\" />%n%nDo you have manifest merging enabled?", new Object[] {
                s, s1
            }));
        } else
        {
            return;
        }
    }

    private static void verifyRequiredPackageVersionMetaData(Bundle bundle, int i)
    {
        verifyIntegerResourceMetaData(bundle, "required_amazon_package:com.amazon.geo.mapsv2.services", i, "@integer/amazon_maps_services_version");
    }

    public void showErrorNotification(int i, Context context)
    {
        if (sErrorDialogUtil != null)
        {
            sErrorDialogUtil.showErrorNotification(i, context);
        }
    }

    static 
    {
        THIS_CLASS = com/amazon/geo/mapsv2/util/AmazonMapsRuntimeUtil;
        Object obj;
        if (!isTheRewrittenClass())
        {
            obj = new MapsErrorDialogUtil();
        } else
        {
            try
            {
                obj = (IErrorDialogUtil)Class.forName("com.amazon.geo.mapsv2.internal.RecessErrorDialogUtil", true, THIS_CLASS.getClassLoader()).getConstructor((Class[])null).newInstance(new Object[0]);
            }
            catch (Exception exception)
            {
                Log.w("AmazonMapsV2", "Failed to load Recess error dialog implementation, defaulting to Maps implementation.", exception);
                exception = new MapsErrorDialogUtil();
            }
        }
        sErrorDialogUtil = ((IErrorDialogUtil) (obj));
    }

}
