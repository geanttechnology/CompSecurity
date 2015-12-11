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
import com.google.android.gms.internal.eg;
import com.google.android.gms.internal.o;
import java.io.IOException;
import java.net.URISyntaxException;

// Referenced classes of package com.google.android.gms.auth:
//            UserRecoverableNotifiedException, GoogleAuthException, GooglePlayServicesAvailabilityException, UserRecoverableAuthException

public final class GoogleAuthUtil
{

    public static final String GOOGLE_ACCOUNT_TYPE = "com.google";
    public static final String KEY_ANDROID_PACKAGE_NAME = "androidPackageName";
    public static final String KEY_CALLER_UID = "callerUid";
    public static final String KEY_CLIENT_PACKAGE_NAME = "clientPackageName";
    public static final String KEY_REQUEST_ACTIONS = "request_visible_actions";
    public static final String KEY_REQUEST_VISIBLE_ACTIVITIES = "request_visible_actions";
    public static final String KEY_SUPPRESS_PROGRESS_SCREEN = "suppressProgressScreen";
    public static final String OEM_ONLY_KEY_TARGET_ANDROID_ID = "oauth2_target_device_id";
    public static final String OEM_ONLY_KEY_VERIFIER = "oauth2_authcode_verifier";
    public static final String OEM_ONLY_SCOPE_ACCOUNT_BOOTSTRAP = "_account_setup";
    private static final ComponentName kb;
    private static final ComponentName kc;
    private static final Intent kd;
    private static final Intent ke;

    private GoogleAuthUtil()
    {
    }

    private static String a(Context context, String s, String s1, Bundle bundle)
        throws IOException, UserRecoverableNotifiedException, GoogleAuthException
    {
        Bundle bundle1;
        bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        s = getToken(context, s, s1, bundle1);
        return s;
        bundle;
        int i;
        android.app.PendingIntent pendingintent = GooglePlayServicesUtil.getErrorPendingIntent(bundle.getConnectionStatusCode(), context, 0);
        Resources resources = context.getResources();
        Notification notification = new Notification(0x108008a, resources.getString(com.google.android.gms.R.string.auth_client_play_services_err_notification_msg), System.currentTimeMillis());
        notification.flags = notification.flags | 0x10;
        s1 = context.getApplicationInfo().name;
        s = s1;
        if (TextUtils.isEmpty(s1))
        {
            s = context.getPackageName();
            PackageManager packagemanager = context.getApplicationContext().getPackageManager();
            try
            {
                s1 = packagemanager.getApplicationInfo(context.getPackageName(), 0);
            }
            // Misplaced declaration of an exception variable
            catch (String s1)
            {
                s1 = null;
            }
            if (s1 != null)
            {
                s = packagemanager.getApplicationLabel(s1).toString();
            }
        }
        s = resources.getString(com.google.android.gms.R.string.auth_client_requested_by_msg, new Object[] {
            s
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
        notification.setLatestEventInfo(context, resources.getString(i), s, pendingintent);
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

    public static String getToken(Context context, String s, String s1)
        throws IOException, UserRecoverableAuthException, GoogleAuthException
    {
        return getToken(context, s, s1, new Bundle());
    }

    public static String getToken(Context context, String s, String s1, Bundle bundle)
        throws IOException, UserRecoverableAuthException, GoogleAuthException
    {
        Context context1;
        context1 = context.getApplicationContext();
        eg.O("Calling this from your main thread can lead to deadlock");
        m(context1);
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
        if (!context1.bindService(kd, context, 1))
        {
            break MISSING_BLOCK_LABEL_242;
        }
        s = com.google.android.gms.internal.o.a.a(context.bg()).a(s, s1, bundle);
        s1 = s.getString("authtoken");
        flag = TextUtils.isEmpty(s1);
        if (!flag)
        {
            context1.unbindService(context);
            return s1;
        }
        s1 = s.getString("Error");
        s = (Intent)s.getParcelable("userRecoveryIntent");
        if (x(s1))
        {
            throw new UserRecoverableAuthException(s1, s);
        }
        break MISSING_BLOCK_LABEL_205;
        s;
        Log.i("GoogleAuthUtil", "GMS remote exception ", s);
        throw new IOException("remote exception");
        s;
        context1.unbindService(context);
        throw s;
        if (w(s1))
        {
            throw new IOException(s1);
        }
        break MISSING_BLOCK_LABEL_233;
        s;
        throw new GoogleAuthException("Interrupted");
        throw new GoogleAuthException(s1);
        throw new IOException("Could not bind to service with the given context.");
    }

    public static String getTokenWithNotification(Context context, String s, String s1, Bundle bundle)
        throws IOException, UserRecoverableNotifiedException, GoogleAuthException
    {
        Bundle bundle1 = bundle;
        if (bundle == null)
        {
            bundle1 = new Bundle();
        }
        bundle1.putBoolean("handle_notification", true);
        return a(context, s, s1, bundle1);
    }

    public static String getTokenWithNotification(Context context, String s, String s1, Bundle bundle, Intent intent)
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
        return a(context, s, s1, bundle1);
    }

    public static String getTokenWithNotification(Context context, String s, String s1, Bundle bundle, String s2, Bundle bundle1)
        throws IOException, UserRecoverableNotifiedException, GoogleAuthException
    {
        if (TextUtils.isEmpty(s2))
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
        bundle2.putString("authority", s2);
        bundle2.putBundle("sync_extras", bundle);
        bundle2.putBoolean("handle_notification", true);
        return a(context, s, s1, bundle2);
    }

    public static void invalidateToken(Context context, String s)
    {
        AccountManager.get(context).invalidateAuthToken("com.google", s);
    }

    private static void m(Context context)
        throws GooglePlayServicesAvailabilityException, GoogleAuthException
    {
        try
        {
            GooglePlayServicesUtil.m(context);
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

    private static boolean w(String s)
    {
        return "NetworkError".equals(s) || "ServiceUnavailable".equals(s) || "Timeout".equals(s);
    }

    private static boolean x(String s)
    {
        return "BadAuthentication".equals(s) || "CaptchaRequired".equals(s) || "DeviceManagementRequiredOrSyncDisabled".equals(s) || "NeedPermission".equals(s) || "NeedsBrowser".equals(s) || "UserCancel".equals(s) || "AppDownloadRequired".equals(s);
    }

    static 
    {
        if (android.os.Build.VERSION.SDK_INT < 11);
        if (android.os.Build.VERSION.SDK_INT < 14);
        kb = new ComponentName("com.google.android.gms", "com.google.android.gms.auth.GetToken");
        kc = new ComponentName("com.google.android.gms", "com.google.android.gms.recovery.RecoveryService");
        kd = (new Intent()).setPackage("com.google.android.gms").setComponent(kb);
        ke = (new Intent()).setPackage("com.google.android.gms").setComponent(kc);
    }
}
