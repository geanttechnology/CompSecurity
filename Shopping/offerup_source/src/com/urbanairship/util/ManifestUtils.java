// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.util;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.CoreActivity;
import com.urbanairship.CoreReceiver;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.UrbanAirshipProvider;
import com.urbanairship.actions.ActionActivity;
import com.urbanairship.actions.ActionService;
import com.urbanairship.analytics.EventService;
import com.urbanairship.push.BaseIntentReceiver;
import com.urbanairship.push.PushService;
import com.urbanairship.richpush.RichPushUpdateService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ManifestUtils
{

    private static final String BASE_INTENT_RECEIVER_ACTIONS[] = {
        "com.urbanairship.push.RECEIVED", "com.urbanairship.push.OPENED", "com.urbanairship.push.CHANNEL_UPDATED", "com.urbanairship.push.DISMISSED"
    };

    public ManifestUtils()
    {
    }

    public static void checkRequiredPermission(String s)
    {
        if (-1 == UAirship.getPackageManager().checkPermission(s, UAirship.getPackageName()))
        {
            Logger.error((new StringBuilder("AndroidManifest.xml missing required permission: ")).append(s).toString());
        }
    }

    public static ActivityInfo getActivityInfo(Class class1)
    {
        class1 = new ComponentName(UAirship.getPackageName(), class1.getCanonicalName());
        try
        {
            class1 = UAirship.getPackageManager().getActivityInfo(class1, 128);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public static ComponentInfo getProviderInfo(String s)
    {
        return UAirship.getPackageManager().resolveContentProvider(s, 0);
    }

    public static ComponentInfo getReceiverInfo(Class class1)
    {
        class1 = new ComponentName(UAirship.getPackageName(), class1.getCanonicalName());
        try
        {
            class1 = UAirship.getPackageManager().getReceiverInfo(class1, 128);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public static ComponentInfo getServiceInfo(Class class1)
    {
        class1 = new ComponentName(UAirship.getPackageName(), class1.getCanonicalName());
        try
        {
            class1 = UAirship.getPackageManager().getServiceInfo(class1, 128);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    private static Map getUrbanAirshipComponentInfoMap()
    {
        return new _cls1();
    }

    public static boolean isPermissionGranted(String s)
    {
        return UAirship.getPackageManager().checkPermission(s, UAirship.getPackageName()) == 0;
    }

    public static boolean isPermissionKnown(String s)
    {
        try
        {
            UAirship.getPackageManager().getPermissionInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    private static void validateBaseIntentReceiver(ActivityInfo activityinfo)
    {
        Object obj;
        String as[];
        int i;
        int l;
        if (activityinfo.exported)
        {
            Logger.error((new StringBuilder("Receiver ")).append(activityinfo.name).append(" is exported. This might allow outside applications to message the receiver. Make sure the intent is protected by a ").append("permission or prevent the receiver from being exported.").toString());
        }
        obj = new ArrayList();
        as = BASE_INTENT_RECEIVER_ACTIONS;
        l = as.length;
        i = 0;
_L3:
        if (i >= l) goto _L2; else goto _L1
_L1:
        String s1;
        int k;
        s1 = as[i];
        Object obj1 = (new Intent(s1)).addCategory(UAirship.getPackageName());
        obj1 = UAirship.getPackageManager().queryBroadcastReceivers(((Intent) (obj1)), 0).iterator();
        ResolveInfo resolveinfo;
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break MISSING_BLOCK_LABEL_345;
            }
            resolveinfo = (ResolveInfo)((Iterator) (obj1)).next();
        } while (resolveinfo.activityInfo == null || resolveinfo.activityInfo.name == null || !resolveinfo.activityInfo.name.equals(activityinfo.name));
        k = 1;
_L4:
        if (k == 0)
        {
            ((List) (obj)).add(s1);
        }
        i++;
          goto _L3
_L2:
        if (((List) (obj)).isEmpty())
        {
            return;
        }
        Logger.error((new StringBuilder("Receiver ")).append(activityinfo.name).append(" unable to receive intents for actions: ").append(obj).toString());
        obj = new StringBuilder();
        ((StringBuilder) (obj)).append("Update the manifest entry for ").append(activityinfo.name).append(" to:\n<receiver android:name=\"").append(activityinfo.name).append("\" exported=\"false\">\n\t<intent-filter> ");
        activityinfo = BASE_INTENT_RECEIVER_ACTIONS;
        k = activityinfo.length;
        for (int j = 0; j < k; j++)
        {
            String s = activityinfo[j];
            ((StringBuilder) (obj)).append("\n\t\t<action android:name=\"").append(s).append("\" />");
        }

        ((StringBuilder) (obj)).append("\n\t\t<!-- Replace ${applicationId} with ").append(UAirship.getPackageName()).append(" if not using Android Gradle plugin -->\n\t\t<category android:name=\"${applicationId}\" />").append("\n\t</intent-filter>\n</receiver>");
        Logger.error(((StringBuilder) (obj)).toString());
        return;
        k = 0;
          goto _L4
    }

    public static void validateManifest(AirshipConfigOptions airshipconfigoptions)
    {
        ActivityInfo activityinfo;
        Map map;
        activityinfo = null;
        checkRequiredPermission("android.permission.INTERNET");
        checkRequiredPermission("android.permission.ACCESS_NETWORK_STATE");
        int i;
        int j;
        if (isPermissionKnown(UAirship.getUrbanAirshipPermission()))
        {
            checkRequiredPermission(UAirship.getUrbanAirshipPermission());
        } else
        {
            Logger.error((new StringBuilder("AndroidManifest.xml does not define and require permission: ")).append(UAirship.getUrbanAirshipPermission()).toString());
        }
        map = getUrbanAirshipComponentInfoMap();
        if (map.get(com/urbanairship/CoreReceiver) == null)
        {
            Logger.error((new StringBuilder("AndroidManifest.xml missing required receiver: ")).append(com/urbanairship/CoreReceiver.getCanonicalName()).toString());
            break MISSING_BLOCK_LABEL_67;
        } else
        {
            ComponentInfo componentinfo1 = (ComponentInfo)map.get(com/urbanairship/CoreReceiver);
            obj = (new Intent("com.urbanairship.push.OPENED")).addCategory(UAirship.getPackageName());
            Iterator iterator = UAirship.getPackageManager().queryBroadcastReceivers(((Intent) (obj)), 0).iterator();
            obj = null;
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ResolveInfo resolveinfo = (ResolveInfo)iterator.next();
                if (resolveinfo.activityInfo != null && resolveinfo.activityInfo.name != null && resolveinfo.activityInfo.name.equals(componentinfo1.name))
                {
                    obj = resolveinfo;
                }
            } while (true);
            if (obj == null)
            {
                Logger.error((new StringBuilder("AndroidManifest.xml's ")).append(com/urbanairship/CoreReceiver.getCanonicalName()).append(" declaration missing required intent-filter: <intent-filter android:priority=\"-999\"><action android:name=\"").append("com.urbanairship.push.OPENED\"/>").append("<category android:name=\"").append(UAirship.getPackageName()).append("\"/></intent-filter>").toString());
            } else
            if (((ResolveInfo) (obj)).priority != -999)
            {
                Logger.error("CoreReceiver's intent filter priority should be set to -999 in order to let the application launch any activities before Urban Airship performs any actions or falls back to launching the application launch intent.");
            }
            continue;
        }
        do
        {
            Object obj;
            try
            {
                obj = UAirship.getPackageManager().getPackageInfo(UAirship.getPackageName(), 2).receivers;
            }
            catch (Exception exception)
            {
                Logger.error("Unable to query the application's receivers.", exception);
                exception = activityinfo;
            }
            if (obj != null)
            {
                j = obj.length;
                i = 0;
                while (i < j) 
                {
                    activityinfo = obj[i];
                    try
                    {
                        if (com/urbanairship/push/BaseIntentReceiver.isAssignableFrom(Class.forName(activityinfo.name)))
                        {
                            validateBaseIntentReceiver(activityinfo);
                        }
                    }
                    catch (ClassNotFoundException classnotfoundexception)
                    {
                        Logger.debug((new StringBuilder("ManifestUtils - Unable to find class: ")).append(activityinfo.name).toString(), classnotfoundexception);
                    }
                    i++;
                }
            }
            if (map.get(com/urbanairship/CoreActivity) == null)
            {
                Logger.error((new StringBuilder("AndroidManifest.xml missing required activity: ")).append(com/urbanairship/CoreActivity.getCanonicalName()).toString());
            }
            if (airshipconfigoptions.analyticsEnabled && map.get(com/urbanairship/analytics/EventService) == null)
            {
                Logger.error((new StringBuilder("AndroidManifest.xml missing required service: ")).append(com/urbanairship/analytics/EventService.getCanonicalName()).toString());
            }
            if (map.get(com/urbanairship/push/PushService) == null)
            {
                Logger.error((new StringBuilder("AndroidManifest.xml missing required service: ")).append(com/urbanairship/push/PushService.getCanonicalName()).toString());
            }
            if (map.get(com/urbanairship/richpush/RichPushUpdateService) == null)
            {
                Logger.error((new StringBuilder("AndroidManifest.xml missing required service: ")).append(com/urbanairship/richpush/RichPushUpdateService.getCanonicalName()).toString());
            }
            if (map.get(com/urbanairship/actions/ActionService) == null)
            {
                Logger.error((new StringBuilder("AndroidManifest.xml missing required service: ")).append(com/urbanairship/actions/ActionService.getCanonicalName()).toString());
            }
            if (map.get(com/urbanairship/actions/ActionActivity) == null)
            {
                Logger.warn("AndroidManifest.xml missing ActionActivity.  Action.startActivityForResult will not work.");
            }
            airshipconfigoptions = (new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION", Uri.parse("http://"))).setPackage(UAirship.getPackageName()).addFlags(0x10000000).addCategory("android.intent.category.DEFAULT");
            if (UAirship.getPackageManager().resolveActivity(airshipconfigoptions, 0) == null)
            {
                Logger.warn("AndroidManifest.xml missing activity with an intent filter for action com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION, category android.intent.category.DEFAULT, and data with scheme http.  Landing page action may not function properly.");
            }
            airshipconfigoptions = (new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION", Uri.parse("https://"))).setPackage(UAirship.getPackageName()).addFlags(0x10000000).addCategory("android.intent.category.DEFAULT");
            if (UAirship.getPackageManager().resolveActivity(airshipconfigoptions, 0) == null)
            {
                Logger.error("AndroidManifest.xml missing activity with an intent filter for action com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION, category android.intent.category.DEFAULT, and data with scheme https. Landing page action may not function properly.");
            }
            airshipconfigoptions = (new Intent("com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION", Uri.parse("message://"))).setPackage(UAirship.getPackageName()).addFlags(0x10000000).addCategory("android.intent.category.DEFAULT");
            if (UAirship.getPackageManager().resolveActivity(airshipconfigoptions, 0) == null)
            {
                Logger.error("AndroidManifest.xml missing activity with an intent filter for action com.urbanairship.actions.SHOW_LANDING_PAGE_INTENT_ACTION, category android.intent.category.DEFAULT, and data with scheme message. Landing page action may not function properly.");
            }
            if (UAirship.getAppInfo() == null)
            {
                airshipconfigoptions = UAirship.getPackageName();
            } else
            {
                airshipconfigoptions = UAirship.getAppInfo().processName;
            }
            exception = map.keySet().iterator();
            do
            {
                if (!exception.hasNext())
                {
                    break;
                }
                Class class1 = (Class)exception.next();
                ComponentInfo componentinfo = (ComponentInfo)map.get(class1);
                if (componentinfo != null && !airshipconfigoptions.equals(componentinfo.processName))
                {
                    Logger.warn((new StringBuilder("A separate process is detected for: ")).append(class1.getCanonicalName()).append(". In the AndroidManifest.xml, remove the android:process attribute.").toString());
                }
            } while (true);
            if (map.get(com/urbanairship/UrbanAirshipProvider) == null)
            {
                throw new IllegalStateException("Unable to resolve UrbanAirshipProvider. Please check that the provider is defined in your AndroidManifest.xml, and that the authority string is set to  \"YOUR_PACKAGENAME.urbanairship.provider\"");
            }
            return;
        } while (true);
    }


    private class _cls1 extends HashMap
    {

        _cls1()
        {
            put(com/urbanairship/analytics/EventService, ManifestUtils.getServiceInfo(com/urbanairship/analytics/EventService));
            put(com/urbanairship/push/PushService, ManifestUtils.getServiceInfo(com/urbanairship/push/PushService));
            put(com/urbanairship/richpush/RichPushUpdateService, ManifestUtils.getServiceInfo(com/urbanairship/richpush/RichPushUpdateService));
            put(com/urbanairship/actions/ActionService, ManifestUtils.getServiceInfo(com/urbanairship/actions/ActionService));
            put(com/urbanairship/location/LocationService, ManifestUtils.getServiceInfo(com/urbanairship/location/LocationService));
            put(com/urbanairship/CoreReceiver, ManifestUtils.getReceiverInfo(com/urbanairship/CoreReceiver));
            put(com/urbanairship/UrbanAirshipProvider, ManifestUtils.getProviderInfo(UrbanAirshipProvider.getAuthorityString()));
            put(com/urbanairship/actions/ActionActivity, ManifestUtils.getActivityInfo(com/urbanairship/actions/ActionActivity));
            put(com/urbanairship/CoreActivity, ManifestUtils.getActivityInfo(com/urbanairship/CoreActivity));
        }
    }

}
