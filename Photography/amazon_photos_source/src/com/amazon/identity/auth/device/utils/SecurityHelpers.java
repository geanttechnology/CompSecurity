// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Binder;
import com.amazon.identity.auth.device.framework.AndroidUser;
import com.amazon.identity.auth.device.framework.MAPApplicationInformationQueryer;
import com.amazon.identity.auth.device.framework.RemoteMapInfo;
import com.amazon.identity.auth.device.framework.TrustedPackageManager;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import com.amazon.identity.platform.setting.PlatformSettings;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            MAPLog

public final class SecurityHelpers
{
    private static class BroadcastTimer extends BroadcastReceiver
    {

        final PlatformMetricsTimer mTimer;

        public void onReceive(Context context, Intent intent)
        {
            mTimer.stop();
        }

        BroadcastTimer(Intent intent)
        {
            mTimer = MetricsHelper.startTimer("BroadcastDelay", intent.getAction());
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/utils/SecurityHelpers.getName();

    private SecurityHelpers()
    {
    }

    public static void checkCaller(Context context)
    {
        if (!(new TrustedPackageManager(context)).isTrustedUid(Binder.getCallingUid()))
        {
            MAPLog.e(TAG, "Unauthorized caller");
            throw new SecurityException();
        } else
        {
            return;
        }
    }

    public static void checkCallingPackagePermissions(Context context, String s)
    {
        if (!(new TrustedPackageManager(context)).isTrustedPackage(s))
        {
            MAPLog.e(TAG, String.format("Package %s is an unauthorized caller", new Object[] {
                s
            }));
            throw new SecurityException();
        } else
        {
            return;
        }
    }

    public static void checkCallingPackagePermissionsOrSystem(Activity activity)
    {
        ComponentName componentname = activity.getCallingActivity();
        if (componentname == null)
        {
            MAPLog.i(TAG, String.format("Android System called activity %s in package %s", new Object[] {
                activity.getClass().getName(), activity.getPackageName()
            }));
            return;
        } else
        {
            checkCallingPackagePermissions(activity, componentname.getPackageName());
            return;
        }
    }

    public static void checkIsAmazonOwnedContentProvider(Context context, Uri uri)
    {
        ProviderInfo providerinfo = context.getPackageManager().resolveContentProvider(uri.getAuthority(), 0);
        if (providerinfo == null)
        {
            throw new IllegalStateException(String.format("Authority %s does not exist on the device", new Object[] {
                uri.getAuthority()
            }));
        } else
        {
            checkCallingPackagePermissions(context, providerinfo.packageName);
            return;
        }
    }

    public static String[] getCallingPackages(Context context)
    {
        int i = Binder.getCallingPid();
        Iterator iterator = ((ActivityManager)context.getSystemService("activity")).getRunningAppProcesses().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break MISSING_BLOCK_LABEL_66;
            }
            context = (android.app.ActivityManager.RunningAppProcessInfo)iterator.next();
        } while (((android.app.ActivityManager.RunningAppProcessInfo) (context)).pid != i);
_L1:
        if (context == null)
        {
            MAPLog.e(TAG, "Calling process could not be found. Cannot find it's package");
            return new String[0];
        } else
        {
            return ((android.app.ActivityManager.RunningAppProcessInfo) (context)).pkgList;
        }
        context = null;
          goto _L1
    }

    public static boolean isSystemApplication(Context context)
    {
        boolean flag = false;
        int i;
        try
        {
            i = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0).flags;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            MAPLog.e(TAG, "Cannot calculate whether current app is a system app or not", context);
            return false;
        }
        if ((i & 1) != 0)
        {
            flag = true;
        }
        return flag;
    }

    public static void secureSendBroadcast(Context context, Intent intent, String s, AndroidUser androiduser)
    {
        if (isSystemApplication(context)) goto _L2; else goto _L1
_L1:
        boolean flag;
        if (intent != null && (intent.getPackage() != null || intent.getComponent() != null))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag) goto _L3; else goto _L2
_L2:
        String s1 = TAG;
        sendBroadcast(context, intent, s, androiduser);
_L5:
        return;
_L3:
        if (androiduser != null)
        {
            throw new IllegalStateException("We can only fire a broadcast to a user if we are a system app");
        }
        Object obj = MAPApplicationInformationQueryer.getInstance(context).getAllMapApplication();
        androiduser = new TrustedPackageManager(context);
        obj = ((Collection) (obj)).iterator();
        while (((Iterator) (obj)).hasNext()) 
        {
            String s2 = ((RemoteMapInfo)((Iterator) (obj)).next()).getPackageName();
            if (!androiduser.isTrustedPackage(s2))
            {
                MAPLog.formattedError(TAG, "%s cannot listen to intent %s because it is not signed with the same signature", new Object[] {
                    s2, intent.toString()
                });
            } else
            {
                Intent intent1 = new Intent(intent);
                intent1.setPackage(s2);
                sendBroadcast(context, intent1, s, null);
            }
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    private static void sendBroadcast(Context context, Intent intent, String s, AndroidUser androiduser)
    {
        if (androiduser != null)
        {
            if (shouldUseOrderedBroadcast(context))
            {
                String s1 = TAG;
                (new StringBuilder("sendOrderedBroadcastAsUser ")).append(intent.getAction()).toString();
                context.sendOrderedBroadcastAsUser(intent, androiduser.getUserHandle(), s, new BroadcastTimer(intent), null, -1, null, null);
                return;
            } else
            {
                String s2 = TAG;
                (new StringBuilder("sendBroadcastAsUser ")).append(intent.getAction()).toString();
                context.sendBroadcastAsUser(intent, androiduser.getUserHandle(), s);
                return;
            }
        }
        if (shouldUseOrderedBroadcast(context))
        {
            androiduser = TAG;
            (new StringBuilder("sendOrderedBroadcast ")).append(intent.getAction()).toString();
            context.sendOrderedBroadcast(intent, s, new BroadcastTimer(intent), null, -1, null, null);
            return;
        } else
        {
            androiduser = TAG;
            (new StringBuilder("sendBroadcast ")).append(intent.getAction()).toString();
            context.sendBroadcast(intent, s);
            return;
        }
    }

    private static boolean shouldUseOrderedBroadcast(Context context)
    {
        return PlatformSettings.getInstance(context).getSettingBoolean("ordered.broadcast", true);
    }

}
