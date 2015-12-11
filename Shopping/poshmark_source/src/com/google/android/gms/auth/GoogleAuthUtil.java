// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.auth;

import android.accounts.AccountManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.a;
import com.google.android.gms.internal.do;
import com.google.android.gms.internal.er;
import com.google.android.gms.internal.s;
import java.io.IOException;
import java.net.URISyntaxException;

// Referenced classes of package com.google.android.gms.auth:
//            UserRecoverableNotifiedException, GoogleAuthException, GooglePlayServicesAvailabilityException, UserRecoverableAuthException

public final class GoogleAuthUtil
{

    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    public static final String KEY_CALLER_UID = "callerUid";
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    private static final ComponentName vo;
    private static final ComponentName vp;
    private static final Intent vq;
    private static final Intent vr;

    private GoogleAuthUtil()
    {
    }

    private static boolean K(String s1)
    {
        return "NetworkError".equals(s1) || "ServiceUnavailable".equals(s1) || "Timeout".equals(s1);
    }

    private static boolean L(String s1)
    {
        return "BadAuthentication".equals(s1) || "CaptchaRequired".equals(s1) || "DeviceManagementRequiredOrSyncDisabled".equals(s1) || "NeedPermission".equals(s1) || "NeedsBrowser".equals(s1) || "UserCancel".equals(s1) || "AppDownloadRequired".equals(s1);
    }

    private static String a(Context context, String s1, String s2, Bundle bundle)
        throws IOException, UserRecoverableNotifiedException, GoogleAuthException
    {
        Bundle bundle1;
        bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        s1 = getToken(context, s1, s2, bundle1);
        return s1;
        bundle;
        int i;
        android.app.PendingIntent pendingintent = GooglePlayServicesUtil.getErrorPendingIntent(bundle.getConnectionStatusCode(), context, 0);
        Resources resources = context.getResources();
        Notification notification = new Notification(0x108008a, resources.getString(com.google.android.gms.R.string.auth_client_play_services_err_notification_msg), System.currentTimeMillis());
        notification.flags = notification.flags | 0x10;
        s2 = context.getApplicationInfo().name;
        s1 = s2;
        if (TextUtils.isEmpty(s2))
        {
            s1 = context.getPackageName();
            PackageManager packagemanager = context.getApplicationContext().getPackageManager();
            try
            {
                s2 = packagemanager.getApplicationInfo(context.getPackageName(), 0);
            }
            // Misplaced declaration of an exception variable
            catch (String s2)
            {
                s2 = null;
            }
            if (s2 != null)
            {
                s1 = packagemanager.getApplicationLabel(s2).toString();
            }
        }
        s1 = resources.getString(com.google.android.gms.R.string.auth_client_requested_by_msg, new Object[] {
            s1
        });
        bundle.getConnectionStatusCode();
        JVM INSTR tableswitch 1 3: default 184
    //                   1 237
    //                   2 245
    //                   3 253;
           goto _L1 _L2 _L3 _L4
_L1:
        i = com.google.android.gms.R.string.auth_client_using_bad_version_title;
_L6:
        notification.setLatestEventInfo(context, resources.getString(i), s1, pendingintent);
        ((NotificationManager)context.getSystemService("notification")).notify(39789, notification);
        throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
_L2:
        i = com.google.android.gms.R.string.auth_client_needs_installation_title;
        continue; /* Loop/switch isn't completed */
_L3:
        i = com.google.android.gms.R.string.auth_client_needs_update_title;
        continue; /* Loop/switch isn't completed */
_L4:
        i = com.google.android.gms.R.string.auth_client_needs_enabling_title;
        if (true) goto _L6; else goto _L5
_L5:
        context;
        throw new UserRecoverableNotifiedException("User intervention required. Notification has been pushed.");
    }

    private static void b(Intent intent)
    {
        if (intent == null)
        {
            throw new IllegalArgumentException("Callack cannot be null.");
        }
        intent = intent.toUri(1);
        try
        {
            Intent.parseUri(intent, 1);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Intent intent)
        {
            throw new IllegalArgumentException("Parameter callback contains invalid data. It must be serializable using toUri() and parseUri().");
        }
    }

    public static void clearToken(Context context, String s1)
        throws GooglePlayServicesAvailabilityException, GoogleAuthException, IOException
    {
        Context context1;
        Object obj;
        context1 = context.getApplicationContext();
        er.ad("Calling this from your main thread can lead to deadlock");
        s(context1);
        obj = new Bundle();
        context = context.getApplicationInfo().packageName;
        ((Bundle) (obj)).putString("clientPackageName", context);
        if (!((Bundle) (obj)).containsKey(KEY_ANDROID_PACKAGE_NAME))
        {
            ((Bundle) (obj)).putString(KEY_ANDROID_PACKAGE_NAME, context);
        }
        context = new a();
        if (!context1.bindService(vq, context, 1))
        {
            break MISSING_BLOCK_LABEL_168;
        }
        s1 = com.google.android.gms.internal.s.a.a(context.dm()).a(s1, ((Bundle) (obj)));
        obj = s1.getString(do.wf);
        if (!s1.getBoolean("booleanResult"))
        {
            throw new GoogleAuthException(((String) (obj)));
        }
        break MISSING_BLOCK_LABEL_150;
        s1;
        Log.i("GoogleAuthUtil", "GMS remote exception ", s1);
        throw new IOException("remote exception");
        s1;
        context1.unbindService(context);
        throw s1;
        context1.unbindService(context);
        return;
        s1;
        throw new GoogleAuthException("Interrupted");
        throw new IOException("Could not bind to service with the given context.");
    }

    public static String getToken(Context context, String s1, String s2)
        throws IOException, UserRecoverableAuthException, GoogleAuthException
    {
        return getToken(context, s1, s2, new Bundle());
    }

    public static String getToken(Context context, String s1, String s2, Bundle bundle)
        throws IOException, UserRecoverableAuthException, GoogleAuthException
    {
        Context context1;
        context1 = context.getApplicationContext();
        er.ad("Calling this from your main thread can lead to deadlock");
        s(context1);
        boolean flag;
        if (bundle == null)
        {
            bundle = new Bundle();
        } else
        {
            bundle = new Bundle(bundle);
        }
        context = context.getApplicationInfo().packageName;
        bundle.putString("clientPackageName", context);
        if (!bundle.containsKey(KEY_ANDROID_PACKAGE_NAME))
        {
            bundle.putString(KEY_ANDROID_PACKAGE_NAME, context);
        }
        context = new a();
        if (!context1.bindService(vq, context, 1))
        {
            break MISSING_BLOCK_LABEL_244;
        }
        s1 = com.google.android.gms.internal.s.a.a(context.dm()).a(s1, s2, bundle);
        s2 = s1.getString("authtoken");
        flag = TextUtils.isEmpty(s2);
        if (!flag)
        {
            context1.unbindService(context);
            return s2;
        }
        s2 = s1.getString("Error");
        s1 = (Intent)s1.getParcelable("userRecoveryIntent");
        if (L(s2))
        {
            throw new UserRecoverableAuthException(s2, s1);
        }
        break MISSING_BLOCK_LABEL_207;
        s1;
        Log.i("GoogleAuthUtil", "GMS remote exception ", s1);
        throw new IOException("remote exception");
        s1;
        context1.unbindService(context);
        throw s1;
        if (K(s2))
        {
            throw new IOException(s2);
        }
        break MISSING_BLOCK_LABEL_235;
        s1;
        throw new GoogleAuthException("Interrupted");
        throw new GoogleAuthException(s2);
        throw new IOException("Could not bind to service with the given context.");
    }

    public static String getTokenWithNotification(Context context, String s1, String s2, Bundle bundle)
        throws IOException, UserRecoverableNotifiedException, GoogleAuthException
    {
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putBoolean("handle_notification", true);
        return a(context, s1, s2, bundle1);
    }

    public static String getTokenWithNotification(Context context, String s1, String s2, Bundle bundle, Intent intent)
        throws IOException, UserRecoverableNotifiedException, GoogleAuthException
    {
        b(intent);
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putParcelable("callback_intent", intent);
        bundle1.putBoolean("handle_notification", true);
        return a(context, s1, s2, bundle1);
    }

    public static String getTokenWithNotification(Context context, String s1, String s2, Bundle bundle, String s3, Bundle bundle1)
        throws IOException, UserRecoverableNotifiedException, GoogleAuthException
    {
        if (TextUtils.isEmpty(s3))
        {
            throw new IllegalArgumentException("Authority cannot be empty or null.");
        }
        Bundle bundle2 = bundle;
        if (bundle == null)
        {
            bundle2 = new Bundle();
        }
        bundle = bundle1;
        if (bundle1 == null)
        {
            bundle = new Bundle();
        }
        ContentResolver.validateSyncExtrasBundle(bundle);
        bundle2.putString("authority", s3);
        bundle2.putBundle("sync_extras", bundle);
        bundle2.putBoolean("handle_notification", true);
        return a(context, s1, s2, bundle2);
    }

    public static void invalidateToken(Context context, String s1)
    {
        AccountManager.get(context).invalidateAuthToken("com.google", s1);
    }

    private static void s(Context context)
        throws GooglePlayServicesAvailabilityException, GoogleAuthException
    {
        try
        {
            GooglePlayServicesUtil.s(context);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new GooglePlayServicesAvailabilityException(context.getConnectionStatusCode(), context.getMessage(), context.getIntent());
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            throw new GoogleAuthException(context.getMessage());
        }
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT < 11);
        if (android.os.Build.VERSION.SDK_INT < 14);
        vo = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        vp = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
        vq = (new Intent()).setPackage("com.google.android.gms").setComponent(vo);
        vr = (new Intent()).setPackage("com.google.android.gms").setComponent(vp);
    }
}
