// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;
import com.mopub.common.MoPubBrowser;
import com.mopub.common.logging.MoPubLog;
import com.mopub.mobileads.MoPubActivity;
import com.mopub.mobileads.MraidActivity;
import com.mopub.mobileads.MraidVideoPlayerActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.mopub.common.util:
//            Intents, VersionCode, Utils

public class ManifestUtils
{
    private static class ActivityConfigChanges
    {

        public boolean hasKeyboardHidden;
        public boolean hasOrientation;
        public boolean hasScreenSize;

        private ActivityConfigChanges()
        {
        }

    }

    static class FlagCheckUtil
    {

        public boolean hasFlag(Class class1, int i, int j)
        {
            return Utils.bitMaskContainsFlag(i, j);
        }

        FlagCheckUtil()
        {
        }
    }


    private static final List REQUIRED_NATIVE_SDK_ACTIVITIES;
    private static final List REQUIRED_WEB_VIEW_SDK_ACTIVITIES;
    private static FlagCheckUtil sFlagCheckUtil = new FlagCheckUtil();

    private ManifestUtils()
    {
    }

    public static void checkNativeActivitiesDeclared(Context context)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(context, "context is not allowed to be null"))
        {
            return;
        } else
        {
            displayWarningForMissingActivities(context, REQUIRED_NATIVE_SDK_ACTIVITIES);
            displayWarningForMisconfiguredActivities(context, REQUIRED_NATIVE_SDK_ACTIVITIES);
            return;
        }
    }

    public static void checkWebViewActivitiesDeclared(Context context)
    {
        if (!com.mopub.common.Preconditions.NoThrow.checkNotNull(context, "context is not allowed to be null"))
        {
            return;
        } else
        {
            displayWarningForMissingActivities(context, REQUIRED_WEB_VIEW_SDK_ACTIVITIES);
            displayWarningForMisconfiguredActivities(context, REQUIRED_WEB_VIEW_SDK_ACTIVITIES);
            return;
        }
    }

    static void displayWarningForMisconfiguredActivities(Context context, List list)
    {
        list = getMisconfiguredActivities(context, filterDeclaredActivities(context, list, true));
        if (list.isEmpty())
        {
            return;
        } else
        {
            logWarningToast(context);
            logMisconfiguredActivities(context, list);
            return;
        }
    }

    static void displayWarningForMissingActivities(Context context, List list)
    {
        list = filterDeclaredActivities(context, list, false);
        if (list.isEmpty())
        {
            return;
        } else
        {
            logWarningToast(context);
            logMissingActivities(list);
            return;
        }
    }

    private static List filterDeclaredActivities(Context context, List list, boolean flag)
    {
        ArrayList arraylist = new ArrayList();
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Class class1 = (Class)list.next();
            if (Intents.deviceCanHandleIntent(context, new Intent(context, class1)) == flag)
            {
                arraylist.add(class1);
            }
        } while (true);
        return arraylist;
    }

    private static ActivityConfigChanges getActivityConfigChanges(Context context, Class class1)
        throws android.content.pm.PackageManager.NameNotFoundException
    {
        ActivityInfo activityinfo = context.getPackageManager().getActivityInfo(new ComponentName(context, class1.getName()), 0);
        ActivityConfigChanges activityconfigchanges = new ActivityConfigChanges();
        activityconfigchanges.hasKeyboardHidden = sFlagCheckUtil.hasFlag(class1, activityinfo.configChanges, 32);
        activityconfigchanges.hasOrientation = sFlagCheckUtil.hasFlag(class1, activityinfo.configChanges, 128);
        activityconfigchanges.hasScreenSize = true;
        if (VersionCode.currentApiLevel().isAtLeast(VersionCode.HONEYCOMB_MR2) && context.getApplicationInfo().targetSdkVersion >= VersionCode.HONEYCOMB_MR2.getApiLevel())
        {
            activityconfigchanges.hasScreenSize = sFlagCheckUtil.hasFlag(class1, activityinfo.configChanges, 1024);
        }
        return activityconfigchanges;
    }

    private static List getMisconfiguredActivities(Context context, List list)
    {
        ArrayList arraylist;
        arraylist = new ArrayList();
        list = list.iterator();
_L2:
        Class class1;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        class1 = (Class)list.next();
        ActivityConfigChanges activityconfigchanges = getActivityConfigChanges(context, class1);
        if (!activityconfigchanges.hasKeyboardHidden || !activityconfigchanges.hasOrientation || !activityconfigchanges.hasScreenSize)
        {
            arraylist.add(class1);
        }
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
        return arraylist;
    }

    static List getRequiredNativeSdkActivities()
    {
        return REQUIRED_NATIVE_SDK_ACTIVITIES;
    }

    static List getRequiredWebViewSdkActivities()
    {
        return REQUIRED_WEB_VIEW_SDK_ACTIVITIES;
    }

    public static boolean isDebuggable(Context context)
    {
        return Utils.bitMaskContainsFlag(context.getApplicationInfo().flags, 2);
    }

    private static void logMisconfiguredActivities(Context context, List list)
    {
        StringBuilder stringbuilder;
        stringbuilder = new StringBuilder("In AndroidManifest, the android:configChanges param is missing values for the following MoPub activities:\n");
        list = list.iterator();
_L2:
        Class class1;
        if (!list.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        class1 = (Class)list.next();
        ActivityConfigChanges activityconfigchanges = getActivityConfigChanges(context, class1);
        if (!activityconfigchanges.hasKeyboardHidden)
        {
            stringbuilder.append((new StringBuilder()).append("\n\tThe android:configChanges param for activity ").append(class1.getName()).append(" must include keyboardHidden.").toString());
        }
        if (!activityconfigchanges.hasOrientation)
        {
            stringbuilder.append((new StringBuilder()).append("\n\tThe android:configChanges param for activity ").append(class1.getName()).append(" must include orientation.").toString());
        }
        if (!activityconfigchanges.hasScreenSize)
        {
            stringbuilder.append((new StringBuilder()).append("\n\tThe android:configChanges param for activity ").append(class1.getName()).append(" must include screenSize.").toString());
        }
        continue; /* Loop/switch isn't completed */
        android.content.pm.PackageManager.NameNotFoundException namenotfoundexception;
        namenotfoundexception;
        if (true) goto _L2; else goto _L1
_L1:
        stringbuilder.append("\n\nPlease update your manifest to include them.");
        MoPubLog.w(stringbuilder.toString());
        return;
    }

    private static void logMissingActivities(List list)
    {
        StringBuilder stringbuilder = new StringBuilder("AndroidManifest permissions for the following required MoPub activities are missing:\n");
        Class class1;
        for (list = list.iterator(); list.hasNext(); stringbuilder.append("\n\t").append(class1.getName()))
        {
            class1 = (Class)list.next();
        }

        stringbuilder.append("\n\nPlease update your manifest to include them.");
        MoPubLog.w(stringbuilder.toString());
    }

    private static void logWarningToast(Context context)
    {
        if (isDebuggable(context))
        {
            context = Toast.makeText(context, "ERROR: YOUR MOPUB INTEGRATION IS INCOMPLETE.\nCheck logcat and update your AndroidManifest.xml with the correct activities and configuration.", 1);
            context.setGravity(7, 0, 0);
            context.show();
        }
    }

    static void setFlagCheckUtil(FlagCheckUtil flagcheckutil)
    {
        sFlagCheckUtil = flagcheckutil;
    }

    static 
    {
        REQUIRED_WEB_VIEW_SDK_ACTIVITIES = new ArrayList(4);
        REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(com/mopub/mobileads/MoPubActivity);
        REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(com/mopub/mobileads/MraidActivity);
        REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(com/mopub/mobileads/MraidVideoPlayerActivity);
        REQUIRED_WEB_VIEW_SDK_ACTIVITIES.add(com/mopub/common/MoPubBrowser);
        REQUIRED_NATIVE_SDK_ACTIVITIES = new ArrayList(1);
        REQUIRED_NATIVE_SDK_ACTIVITIES.add(com/mopub/common/MoPubBrowser);
    }
}
