// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.acf;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import com.amazon.client.framework.acf.util.AcfLog;
import com.amazon.client.framework.acf.util.ReflectionHelper;

// Referenced classes of package com.amazon.client.framework.acf:
//            ComponentInjector, ComponentRegistry, Components

public class ComponentInjectors
{

    public static final String COMPONENT_INJECTION_METADATA_NAME = "edamame.ComponentInjector";
    public static final String COMPONENT_INJECTION_METADATA_TAG = "aomame.ComponentInjector";
    public static String TAG = AcfLog.getTag(com/amazon/client/framework/acf/ComponentInjectors);

    public ComponentInjectors()
    {
    }

    private static Bundle getPackageMetadata(Context context, PackageItemInfo packageiteminfo)
    {
        Bundle bundle = packageiteminfo.metaData;
        packageiteminfo = bundle;
        if (bundle == null)
        {
            try
            {
                packageiteminfo = ((PackageItemInfo) (context.getPackageManager().getApplicationInfo(context.getPackageName(), 128))).metaData;
            }
            // Misplaced declaration of an exception variable
            catch (Context context)
            {
                Log.d(TAG, "Activity meta-data not available.  Skipping injection.");
                return bundle;
            }
        }
        return packageiteminfo;
    }

    public static boolean hasComponentInjector(Context context, Bundle bundle)
    {
        boolean flag1 = false;
        Bundle bundle1 = mergeBundles(bundle, getPackageMetadata(context, context.getApplicationInfo()));
        boolean flag = flag1;
        if (bundle1 != null)
        {
            bundle = (String)java/lang/String.cast(bundle1.get("edamame.ComponentInjector"));
            context = bundle;
            if (bundle == null)
            {
                context = (String)java/lang/String.cast(bundle1.get("aomame.ComponentInjector"));
            }
            flag = flag1;
            if (context != null)
            {
                flag = true;
            }
        }
        return flag;
    }

    public static void injectComponents(Activity activity)
    {
        injectComponents(activity, null);
    }

    public static void injectComponents(Activity activity, Bundle bundle)
    {
        android.content.pm.ActivityInfo activityinfo = null;
        android.content.pm.ActivityInfo activityinfo1 = activity.getPackageManager().getActivityInfo(activity.getComponentName(), 128);
        activityinfo = activityinfo1;
_L2:
        injectComponents(((Context) (activity)), ((PackageItemInfo) (activityinfo)), bundle);
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void injectComponents(Application application)
    {
        injectComponents(application, null);
    }

    public static void injectComponents(Application application, Bundle bundle)
    {
        injectPackageComponents(application, bundle);
    }

    public static void injectComponents(Service service)
    {
        injectComponents(service, null);
    }

    public static void injectComponents(Service service, Bundle bundle)
    {
        android.content.pm.ServiceInfo serviceinfo;
        Object obj;
        serviceinfo = null;
        obj = new ComponentName(service, service.getClass());
        obj = service.getPackageManager().getServiceInfo(((ComponentName) (obj)), 128);
        serviceinfo = ((android.content.pm.ServiceInfo) (obj));
_L2:
        injectComponents(((Context) (service)), ((PackageItemInfo) (serviceinfo)), bundle);
        return;
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        Log.d(TAG, "Activity meta-data not available.  Skipping injection.");
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void injectComponents(Context context)
    {
        injectPackageComponents(context, null);
    }

    private static void injectComponents(Context context, PackageItemInfo packageiteminfo, Bundle bundle)
    {
        String s = context.getPackageName();
        Object obj;
        Bundle bundle1;
        if (packageiteminfo == null)
        {
            packageiteminfo = null;
        } else
        {
            packageiteminfo = packageiteminfo.metaData;
        }
        obj = packageiteminfo;
        if (packageiteminfo == null)
        {
            try
            {
                obj = ((PackageItemInfo) (context.getPackageManager().getApplicationInfo(s, 128))).metaData;
            }
            catch (android.content.pm.PackageManager.NameNotFoundException namenotfoundexception)
            {
                namenotfoundexception = packageiteminfo;
            }
        }
        bundle1 = mergeBundles(((Bundle) (obj)), bundle);
        if (bundle1 != null)
        {
            obj = (String)java/lang/String.cast(bundle1.get("edamame.ComponentInjector"));
            packageiteminfo = ((PackageItemInfo) (obj));
            if (obj == null)
            {
                packageiteminfo = (String)java/lang/String.cast(bundle1.get("aomame.ComponentInjector"));
            }
        } else
        {
            Log.d(TAG, "Meta-data not available.  Skipping injection.");
            packageiteminfo = null;
        }
        if (packageiteminfo != null)
        {
            obj = packageiteminfo;
            try
            {
                Class.forName(((String) (obj)), true, context.getClassLoader());
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                obj = (new StringBuilder()).append(s).append(packageiteminfo).toString();
            }
            packageiteminfo = (ComponentInjector)ReflectionHelper.constructObjectIfExists(context, ((String) (obj)), com/amazon/client/framework/acf/ComponentInjector, new com.amazon.client.framework.acf.util.ReflectionHelper.ParameterSet[] {
                ReflectionHelper.param(android/content/Context, context)
            });
            if (packageiteminfo != null)
            {
                packageiteminfo.onInject((ComponentRegistry)Components.required(context, com/amazon/client/framework/acf/ComponentRegistry), bundle);
            }
        }
    }

    public static void injectComponents(Context context, Bundle bundle)
    {
        injectPackageComponents(context, bundle);
    }

    private static void injectPackageComponents(Context context, Bundle bundle)
    {
        injectComponents(context, context.getApplicationInfo(), bundle);
    }

    public static Bundle mergeBundles(Bundle bundle, Bundle bundle1)
    {
        if (bundle == null)
        {
            return bundle1;
        }
        if (bundle1 == null)
        {
            return bundle;
        } else
        {
            Bundle bundle2 = new Bundle();
            bundle2.putAll(bundle);
            bundle2.putAll(bundle1);
            return bundle2;
        }
    }

}
