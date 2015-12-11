// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.parse:
//            PushService, GcmBroadcastReceiver, Parse, PushType, 
//            PLog, ParseBroadcastReceiver

class ManifestInfo
{
    static final class ManifestCheckResult extends Enum
    {

        private static final ManifestCheckResult $VALUES[];
        public static final ManifestCheckResult HAS_ALL_DECLARATIONS;
        public static final ManifestCheckResult MISSING_OPTIONAL_DECLARATIONS;
        public static final ManifestCheckResult MISSING_REQUIRED_DECLARATIONS;

        public static ManifestCheckResult valueOf(String s)
        {
            return (ManifestCheckResult)Enum.valueOf(com/parse/ManifestInfo$ManifestCheckResult, s);
        }

        public static ManifestCheckResult[] values()
        {
            return (ManifestCheckResult[])$VALUES.clone();
        }

        static 
        {
            HAS_ALL_DECLARATIONS = new ManifestCheckResult("HAS_ALL_DECLARATIONS", 0);
            MISSING_OPTIONAL_DECLARATIONS = new ManifestCheckResult("MISSING_OPTIONAL_DECLARATIONS", 1);
            MISSING_REQUIRED_DECLARATIONS = new ManifestCheckResult("MISSING_REQUIRED_DECLARATIONS", 2);
            $VALUES = (new ManifestCheckResult[] {
                HAS_ALL_DECLARATIONS, MISSING_OPTIONAL_DECLARATIONS, MISSING_REQUIRED_DECLARATIONS
            });
        }

        private ManifestCheckResult(String s, int i)
        {
            super(s, i);
        }
    }


    private static final int NUMBER_OF_PUSH_INTENTS = 3;
    private static final String TAG = "com.parse.ManifestInfo";
    private static String displayName = null;
    private static int iconId = 0;
    private static long lastModified = -1L;
    private static final Object lock = new Object();
    private static PushType pushType;
    private static Boolean pushUsesBroadcastReceivers = null;
    static int versionCode = -1;
    static String versionName = null;

    ManifestInfo()
    {
    }

    private static boolean checkReceiver(Class class1, String s, Intent aintent[])
    {
        ActivityInfo activityinfo;
        activityinfo = getReceiverInfo(class1);
        break MISSING_BLOCK_LABEL_5;
        while (true) 
        {
            do
            {
                return false;
            } while (activityinfo == null || s != null && !s.equals(activityinfo.permission));
            int j = aintent.length;
            int i = 0;
label0:
            do
            {
label1:
                {
                    if (i >= j)
                    {
                        break label1;
                    }
                    s = aintent[i];
                    s = getPackageManager().queryBroadcastReceivers(s, 0);
                    if (s.isEmpty() || !checkResolveInfo(class1, s))
                    {
                        break label0;
                    }
                    i++;
                }
            } while (true);
        }
        return true;
    }

    private static boolean checkResolveInfo(Class class1, List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            ResolveInfo resolveinfo = (ResolveInfo)list.next();
            if (resolveinfo.activityInfo != null && class1.getCanonicalName().equals(resolveinfo.activityInfo.name))
            {
                return true;
            }
        }

        return false;
    }

    private static boolean deviceSupportsGcm()
    {
        return android.os.Build.VERSION.SDK_INT >= 8 && getPackageInfo("com.google.android.gsf") != null;
    }

    private static ManifestCheckResult gcmSupportLevel()
    {
        Object obj = getContext();
        if (getServiceInfo(com/parse/PushService) == null)
        {
            return ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
        }
        if (!hasPermissions(new String[] {
    "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.WAKE_LOCK", "android.permission.GET_ACCOUNTS", "com.google.android.c2dm.permission.RECEIVE", (new StringBuilder()).append(((Context) (obj)).getPackageName()).append(".permission.C2D_MESSAGE").toString()
}))
        {
            return ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
        }
        obj = ((Context) (obj)).getPackageName();
        if (!checkReceiver(com/parse/GcmBroadcastReceiver, "com.google.android.c2dm.permission.SEND", new Intent[] {
    (new Intent("com.google.android.c2dm.intent.RECEIVE")).setPackage(((String) (obj))).addCategory(((String) (obj))), (new Intent("com.google.android.c2dm.intent.REGISTRATION")).setPackage(((String) (obj))).addCategory(((String) (obj)))
}))
        {
            return ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
        }
        if (!hasPermissions(new String[] {
    "android.permission.VIBRATE"
}))
        {
            return ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS;
        } else
        {
            return ManifestCheckResult.HAS_ALL_DECLARATIONS;
        }
    }

    private static ApplicationInfo getApplicationInfo()
    {
        return getContext().getApplicationInfo();
    }

    private static ApplicationInfo getApplicationInfo(Context context, int i)
    {
        try
        {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), i);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return null;
        }
        return context;
    }

    public static Bundle getApplicationMetadata(Context context)
    {
        context = getApplicationInfo(context, 128);
        if (context != null)
        {
            return ((ApplicationInfo) (context)).metaData;
        } else
        {
            return null;
        }
    }

    private static Context getContext()
    {
        return Parse.getApplicationContext();
    }

    public static String getDisplayName(Context context)
    {
        synchronized (lock)
        {
            if (displayName == null)
            {
                ApplicationInfo applicationinfo = context.getApplicationInfo();
                displayName = context.getPackageManager().getApplicationLabel(applicationinfo).toString();
            }
        }
        return displayName;
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }

    private static String getGcmManifestMessage()
    {
        String s = getContext().getPackageName();
        String s1 = (new StringBuilder()).append(s).append(".permission.C2D_MESSAGE").toString();
        return (new StringBuilder()).append("make sure that these permissions are declared as children of the root <manifest> element:\n\n<uses-permission android:name=\"android.permission.INTERNET\" />\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />\n<uses-permission android:name=\"android.permission.VIBRATE\" />\n<uses-permission android:name=\"android.permission.WAKE_LOCK\" />\n<uses-permission android:name=\"android.permission.GET_ACCOUNTS\" />\n<uses-permission android:name=\"com.google.android.c2dm.permission.RECEIVE\" />\n<permission android:name=\"").append(s1).append("\" ").append("android:protectionLevel=\"signature\" />\n").append("<uses-permission android:name=\"").append(s1).append("\" />\n").append("\n").append("Also, please make sure that these services and broadcast receivers are declared as ").append("children of the <application> element:\n").append("\n").append("<service android:name=\"com.parse.PushService\" />\n").append("<receiver android:name=\"com.parse.GcmBroadcastReceiver\" ").append("android:permission=\"com.google.android.c2dm.permission.SEND\">\n").append("  <intent-filter>\n").append("    <action android:name=\"com.google.android.c2dm.intent.RECEIVE\" />\n").append("    <action android:name=\"com.google.android.c2dm.intent.REGISTRATION\" />\n").append("    <category android:name=\"").append(s).append("\" />\n").append("  </intent-filter>\n").append("</receiver>\n").toString();
    }

    public static int getIconId()
    {
        synchronized (lock)
        {
            if (iconId == 0)
            {
                iconId = getApplicationInfo().icon;
            }
        }
        return iconId;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static transient List getIntentReceivers(String as[])
    {
        Context context = getContext();
        String s = context.getPackageName();
        ArrayList arraylist = new ArrayList();
        int k = as.length;
        for (int i = 0; i < k; i++)
        {
            String s1 = as[i];
            arraylist.addAll(context.getPackageManager().queryBroadcastReceivers(new Intent(s1), 32));
        }

        for (int j = arraylist.size() - 1; j >= 0; j--)
        {
            if (!((ResolveInfo)arraylist.get(j)).activityInfo.packageName.equals(s))
            {
                arraylist.remove(j);
            }
        }

        return arraylist;
    }

    public static long getLastModified()
    {
        synchronized (lock)
        {
            if (lastModified == -1L)
            {
                lastModified = (new File(getApplicationInfo().sourceDir)).lastModified();
            }
        }
        return lastModified;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static String getNonePushTypeLogMessage()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        String s;
        if (pushType != PushType.NONE)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        s = (new StringBuilder()).append("Push is not configured for this app because the app manifest is missing required declarations. Please add the following declarations to your app manifest to support either GCM or PPNS for push (or both). To enable GCM support, please ").append(getGcmManifestMessage()).append("To enable PPNS support, please ").append(getPpnsManifestMessage()).toString();
        return s;
        obj;
        JVM INSTR monitorexit ;
        return "";
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static PackageInfo getPackageInfo(String s)
    {
        try
        {
            s = getPackageManager().getPackageInfo(s, 0);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return null;
        }
        return s;
    }

    private static PackageManager getPackageManager()
    {
        return getContext().getPackageManager();
    }

    private static String getPpnsManifestMessage()
    {
        return "make sure that these permissions are declared as children of the root <manifest> element:\n\n<uses-permission android:name=\"android.permission.INTERNET\" />\n<uses-permission android:name=\"android.permission.ACCESS_NETWORK_STATE\" />\n<uses-permission android:name=\"android.permission.RECEIVE_BOOT_COMPLETED\" />\n<uses-permission android:name=\"android.permission.VIBRATE\" />\n<uses-permission android:name=\"android.permission.WAKE_LOCK\" />\n\nAlso, please make sure that these services and broadcast receivers are declared as children of the <application> element:\n\n<service android:name=\"com.parse.PushService\" />\n<receiver android:name=\"com.parse.ParseBroadcastReceiver\">\n  <intent-filter>\n    <action android:name=\"android.intent.action.BOOT_COMPLETED\" />\n    <action android:name=\"android.intent.action.USER_PRESENT\" />\n  </intent-filter>\n</receiver>\n";
    }

    public static PushType getPushType()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        if (pushType != null) goto _L2; else goto _L1
_L1:
        ManifestCheckResult manifestcheckresult;
        ManifestCheckResult manifestcheckresult1;
        boolean flag;
        boolean flag1;
        flag = deviceSupportsGcm();
        flag1 = hasAnyGcmSpecificDeclaration();
        manifestcheckresult = gcmSupportLevel();
        manifestcheckresult1 = ppnsSupportLevel();
        if (!flag) goto _L4; else goto _L3
_L3:
        if (manifestcheckresult == ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS) goto _L4; else goto _L5
_L5:
        pushType = PushType.GCM;
_L10:
        if (Parse.getLogLevel() > 5) goto _L7; else goto _L6
_L6:
        if (pushType != PushType.GCM || manifestcheckresult != ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS) goto _L9; else goto _L8
_L8:
        PLog.w("com.parse.ManifestInfo", (new StringBuilder()).append("Using GCM for push, but the app manifest is missing some optional declarations that should be added for maximum reliability. Please ").append(getGcmManifestMessage()).toString());
_L7:
        if (Parse.getLogLevel() > 6 || pushType != PushType.NONE || !flag1)
        {
            break MISSING_BLOCK_LABEL_183;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_149;
        }
        PLog.e("com.parse.ManifestInfo", (new StringBuilder()).append("Cannot use GCM for push on this device because Google Play Services is not installed. Install Google Play Service from the Play Store, or enable PPNS as a fallback push service. To enable PPNS as a fallback push service on devices without Google Play support, please ").append(getPpnsManifestMessage()).toString());
        if (manifestcheckresult != ManifestCheckResult.HAS_ALL_DECLARATIONS)
        {
            PLog.e("com.parse.ManifestInfo", (new StringBuilder()).append("Cannot use GCM for push because the app manifest is missing some required declarations. Please ").append(getGcmManifestMessage()).toString());
        }
        if (Parse.getLogLevel() <= 2)
        {
            PLog.v("com.parse.ManifestInfo", (new StringBuilder()).append("Using ").append(pushType).append(" for push.").toString());
        }
_L2:
        obj;
        JVM INSTR monitorexit ;
        return pushType;
_L4:
        if (flag1 && flag)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        if (manifestcheckresult1 == ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        pushType = PushType.PPNS;
          goto _L10
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        pushType = PushType.NONE;
          goto _L10
_L9:
        if (pushType != PushType.PPNS || manifestcheckresult1 != ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS) goto _L7; else goto _L11
_L11:
        PLog.w("com.parse.ManifestInfo", (new StringBuilder()).append("Using PPNS for push, but the app manifest is missing some optional declarations that should be added for maximum reliability. Please ").append(getPpnsManifestMessage()).toString());
          goto _L7
    }

    static boolean getPushUsesBroadcastReceivers()
    {
        boolean flag = true;
        if (pushUsesBroadcastReceivers != null)
        {
            return pushUsesBroadcastReceivers.booleanValue();
        }
        int i;
        int j;
        if (hasIntentReceiver("com.parse.push.intent.RECEIVE"))
        {
            j = 1;
        } else
        {
            j = 0;
        }
        i = j;
        if (hasIntentReceiver("com.parse.push.intent.OPEN"))
        {
            i = j + 1;
        }
        j = i;
        if (hasIntentReceiver("com.parse.push.intent.DELETE"))
        {
            j = i + 1;
        }
        if (j != 0 && j != 3)
        {
            throw new SecurityException("The Parse Push BroadcastReceiver must implement a filter for all of com.parse.push.intent.RECEIVE, com.parse.push.intent.OPEN, and com.parse.push.intent.DELETE");
        }
        if (j != 3)
        {
            flag = false;
        }
        pushUsesBroadcastReceivers = Boolean.valueOf(flag);
        return pushUsesBroadcastReceivers.booleanValue();
    }

    private static ActivityInfo getReceiverInfo(Class class1)
    {
        try
        {
            class1 = getPackageManager().getReceiverInfo(new ComponentName(getContext(), class1), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    private static ServiceInfo getServiceInfo(Class class1)
    {
        try
        {
            class1 = getPackageManager().getServiceInfo(new ComponentName(getContext(), class1), 0);
        }
        // Misplaced declaration of an exception variable
        catch (Class class1)
        {
            return null;
        }
        return class1;
    }

    public static int getVersionCode()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        int i = versionCode;
        if (i != -1)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        versionCode = getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionCode;
_L1:
        obj;
        JVM INSTR monitorexit ;
        return versionCode;
        Object obj1;
        obj1;
        PLog.e("com.parse.ManifestInfo", "Couldn't find info about own package", ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public static String getVersionName()
    {
        Object obj = lock;
        obj;
        JVM INSTR monitorenter ;
        String s = versionName;
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_33;
        }
        versionName = getPackageManager().getPackageInfo(getContext().getPackageName(), 0).versionName;
_L1:
        obj;
        JVM INSTR monitorexit ;
        return versionName;
        Object obj1;
        obj1;
        PLog.e("com.parse.ManifestInfo", "Couldn't find info about own package", ((Throwable) (obj1)));
          goto _L1
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    private static boolean hasAnyGcmSpecificDeclaration()
    {
        boolean flag = false;
        if (hasPermissions(new String[] {
    "com.google.android.c2dm.permission.RECEIVE"
}) || hasPermissions(new String[] {
    (new StringBuilder()).append(getContext().getPackageName()).append(".permission.C2D_MESSAGE").toString()
}) || getReceiverInfo(com/parse/GcmBroadcastReceiver) != null)
        {
            flag = true;
        }
        return flag;
    }

    static boolean hasIntentReceiver(String s)
    {
        return !getIntentReceivers(new String[] {
            s
        }).isEmpty();
    }

    private static transient boolean hasPermissions(String as[])
    {
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            if (getPackageManager().checkPermission(s, getContext().getPackageName()) != 0)
            {
                return false;
            }
        }

        return true;
    }

    private static ManifestCheckResult ppnsSupportLevel()
    {
        if (getServiceInfo(com/parse/PushService) == null)
        {
            return ManifestCheckResult.MISSING_REQUIRED_DECLARATIONS;
        }
        if (!hasPermissions(new String[] {
    "android.permission.INTERNET", "android.permission.ACCESS_NETWORK_STATE", "android.permission.VIBRATE", "android.permission.WAKE_LOCK", "android.permission.RECEIVE_BOOT_COMPLETED"
}))
        {
            return ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS;
        }
        String s = getContext().getPackageName();
        if (!checkReceiver(com/parse/ParseBroadcastReceiver, null, new Intent[] {
    (new Intent("android.intent.action.BOOT_COMPLETED")).setPackage(s), (new Intent("android.intent.action.USER_PRESENT")).setPackage(s)
}))
        {
            return ManifestCheckResult.MISSING_OPTIONAL_DECLARATIONS;
        } else
        {
            return ManifestCheckResult.HAS_ALL_DECLARATIONS;
        }
    }

    static void setPushType(PushType pushtype)
    {
        synchronized (lock)
        {
            pushType = pushtype;
        }
        return;
        pushtype;
        obj;
        JVM INSTR monitorexit ;
        throw pushtype;
    }

    public static void setPushUsesBroadcastReceivers(boolean flag)
    {
        pushUsesBroadcastReceivers = Boolean.valueOf(flag);
    }

}
