// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.net.api.mdns.DeviceNotificationSubscriptions;
import com.ebay.common.net.api.mdns.EbayMdnsApi;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsLong;
import com.ebay.mobile.notifications.NotificationPreferenceManager;
import com.ebay.mobile.notifications.NotificationUtil;
import com.ebay.mobile.notifications.SharedWakeLock;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.api.google.oauth.RevokeTokenRequest;
import com.ebay.nautilus.domain.net.api.google.oauth.RevokeTokenResponse;
import com.ebay.nautilus.shell.app.BaseIntentService;
import com.google.android.now.NowAuthService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public final class GoogleNowAuthenticationService extends BaseIntentService
{

    private static final String ACTION_REFRESH = "com.ebay.mobile.service.action.REFRESH";
    private static final String ACTION_START = "com.ebay.mobile.service.action.START";
    private static final String ACTION_STOP = "com.ebay.mobile.service.action.STOP";
    private static final String CLIENT_ID = "510718330363-qj5v2pofgfidnsqldqhk3phe7a5vrmdp.apps.googleusercontent.com";
    private static final String EXTRA_AUTH = "com.ebay.mobile.service.auth";
    private static final String LOG_TAG = "GoogleNowAuthService";
    private AlarmManager alarmManager;
    private DeviceConfiguration deviceConfig;
    private long maxRefreshFrequencyInMillis;
    private NotificationPreferenceManager preferenceManager;

    public GoogleNowAuthenticationService()
    {
        super("GoogleNowAuthenticationService");
    }

    private PendingIntent createPendingAlarmIntent()
    {
        Intent intent = new Intent(getApplicationContext(), com/ebay/mobile/service/GoogleNowAuthenticationService);
        intent.setAction("com.ebay.mobile.service.action.REFRESH");
        return PendingIntent.getService(getApplicationContext(), 0, intent, 0x8000000);
    }

    private long getTimeUtcInMillis()
    {
        return Calendar.getInstance(TimeZone.getTimeZone("UTC")).getTimeInMillis();
    }

    private boolean hasRefreshToken(String s, String s1, EbaySite ebaysite)
    {
        EbayMdnsApi ebaymdnsapi = new EbayMdnsApi(getEbayContext());
        com.ebay.common.net.api.mdns.EbayMdnsApi.NotificationParams notificationparams = new com.ebay.common.net.api.mdns.EbayMdnsApi.NotificationParams();
        notificationparams.iafToken = s1;
        notificationparams.userId = s;
        notificationparams.site = ebaysite;
        notificationparams.deviceType = "GOOGLENOW";
        notificationparams.clientId = "GOOGLENOW";
        s = ebaymdnsapi.getDeviceNotificationSubscriptions(notificationparams);
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_79;
        }
        boolean flag = ((DeviceNotificationSubscriptions) (s)).isActive;
        if (flag)
        {
            return true;
        }
        return false;
        s;
_L2:
        if (Log.isLoggable("GoogleNowAuthService", 6))
        {
            Log.e("GoogleNowAuthService", "Could not acquire token state from MDNS due to user authentication error.");
        }
        alarmManager.cancel(createPendingAlarmIntent());
        return true;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void refresh(Context context)
    {
        Intent intent = new Intent(context, com/ebay/mobile/service/GoogleNowAuthenticationService);
        intent.setAction("com.ebay.mobile.service.action.REFRESH");
        context.startService(intent);
    }

    private String requestAuthToken()
    {
        String s = NowAuthService.getAuthCode(getApplicationContext(), "510718330363-qj5v2pofgfidnsqldqhk3phe7a5vrmdp.apps.googleusercontent.com");
        return s;
        Object obj;
        obj;
        if (Log.isLoggable("GoogleNowAuthService", 6))
        {
            Log.e("GoogleNowAuthService", "General error requesting OAuth token", ((Throwable) (obj)));
        }
_L2:
        return null;
        obj;
        if (Log.isLoggable("GoogleNowAuthService", 4))
        {
            Log.i("GoogleNowAuthService", (new StringBuilder()).append("ClientId is not authorized to request an OAuth token: ").append(((com.google.android.now.NowAuthService.UnauthorizedException) (obj)).getMessage()).toString());
        }
        alarmManager.cancel(createPendingAlarmIntent());
        continue; /* Loop/switch isn't completed */
        obj;
        if (Log.isLoggable("GoogleNowAuthService", 4))
        {
            Log.i("GoogleNowAuthService", (new StringBuilder()).append("Too many requests, we're being throttled: ").append(((com.google.android.now.NowAuthService.TooManyRequestsException) (obj)).getMessage()).toString());
        }
        preferenceManager.setLastGoogleNowAuthorization(((com.google.android.now.NowAuthService.TooManyRequestsException) (obj)).getNextRetryTimestampMillis());
        continue; /* Loop/switch isn't completed */
        obj;
        if (Log.isLoggable("GoogleNowAuthService", 4))
        {
            Log.i("GoogleNowAuthService", (new StringBuilder()).append("Token already associated with this user. Revoking token: ").append(((com.google.android.now.NowAuthService.HaveTokenAlreadyException) (obj)).getMessage()).toString());
        }
        if (revokeToken(((com.google.android.now.NowAuthService.HaveTokenAlreadyException) (obj)).getAccessToken()))
        {
            refresh(this);
        }
        continue; /* Loop/switch isn't completed */
        obj;
        if (Log.isLoggable("GoogleNowAuthService", 4))
        {
            Log.i("GoogleNowAuthService", (new StringBuilder()).append("Google Now card interface is disabled: ").append(((com.google.android.now.NowAuthService.DisabledException) (obj)).getMessage()).toString());
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private boolean revokeToken(String s)
    {
        s = new RevokeTokenRequest(s);
        boolean flag = ((RevokeTokenResponse)com.ebay.nautilus.kernel.net.Connector.Legacy.sendRequest(getEbayContext(), s)).hasSuccessResponseCode();
        return flag;
        s;
_L2:
        if (Log.isLoggable("GoogleNowAuthService", 6))
        {
            Log.e("GoogleNowAuthService", "Error while revoking a refreshToken from Google OAuth", s);
        }
        return false;
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public static void start(Context context)
    {
        Intent intent = new Intent(context, com/ebay/mobile/service/GoogleNowAuthenticationService);
        intent.setAction("com.ebay.mobile.service.action.START");
        context.startService(intent);
    }

    public static void stop(Context context, Authentication authentication)
    {
        Intent intent = new Intent(context, com/ebay/mobile/service/GoogleNowAuthenticationService);
        intent.setAction("com.ebay.mobile.service.action.STOP");
        intent.putExtra("com.ebay.mobile.service.auth", authentication);
        context.startService(intent);
    }

    public void onCreate()
    {
        super.onCreate();
        alarmManager = (AlarmManager)getSystemService("alarm");
        preferenceManager = new NotificationPreferenceManager(this);
        deviceConfig = DeviceConfiguration.getAsync();
        maxRefreshFrequencyInMillis = deviceConfig.get(DcsLong.GoogleNowCardAuthMaxRefreshFrequency);
    }

    protected void onHandleIntent(Intent intent)
    {
        SharedWakeLock.acquireLock(this);
        if (deviceConfig.get(DcsBoolean.GoogleNowCards))
        {
            break MISSING_BLOCK_LABEL_32;
        }
        alarmManager.cancel(createPendingAlarmIntent());
        SharedWakeLock.releaseLock();
        return;
        if (intent == null) goto _L2; else goto _L1
_L1:
        Object obj;
        String s;
        s = intent.getAction();
        obj = (Authentication)intent.getParcelableExtra("com.ebay.mobile.service.auth");
        intent = ((Intent) (obj));
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        intent = MyApp.getPrefs().getAuthentication();
        long l;
        long l1;
        obj = MyApp.getPrefs().getCurrentSite();
        l = getTimeUtcInMillis();
        l1 = preferenceManager.getLastGoogleNowAuthorization();
        l1 = Math.max(0L, maxRefreshFrequencyInMillis - (l - l1));
        byte byte0 = -1;
        int i = s.hashCode();
        i;
        JVM INSTR lookupswitch 3: default 148
    //                   -1468158180: 195
    //                   -688704703: 210
    //                   124977379: 180;
           goto _L3 _L4 _L5 _L6
_L3:
        byte0;
        JVM INSTR tableswitch 0 2: default 176
    //                   0 225
    //                   1 298
    //                   2 544;
           goto _L2 _L7 _L8 _L9
_L2:
        SharedWakeLock.releaseLock();
        return;
_L6:
        if (!s.equals("com.ebay.mobile.service.action.START")) goto _L3; else goto _L10
_L10:
        byte0 = 0;
          goto _L3
_L4:
        if (!s.equals("com.ebay.mobile.service.action.REFRESH")) goto _L3; else goto _L11
_L11:
        byte0 = 1;
          goto _L3
_L5:
        if (!s.equals("com.ebay.mobile.service.action.STOP")) goto _L3; else goto _L12
_L12:
        byte0 = 2;
          goto _L3
_L7:
        alarmManager.setInexactRepeating(3, l1, maxRefreshFrequencyInMillis, createPendingAlarmIntent());
        if (Log.isLoggable("GoogleNowAuthService", 2))
        {
            Log.v("GoogleNowAuthService", String.format(Locale.US, "Scheduled recurring alarm to start in %1$d ms and every %2$d ms thereafter.", new Object[] {
                Long.valueOf(l1), Long.valueOf(maxRefreshFrequencyInMillis)
            }));
        }
          goto _L2
        intent;
        SharedWakeLock.releaseLock();
        throw intent;
_L8:
        if (intent == null) goto _L14; else goto _L13
_L13:
        if (!TextUtils.isEmpty(((Authentication) (intent)).user) && !TextUtils.isEmpty(((Authentication) (intent)).iafToken) && obj != null) goto _L15; else goto _L14
_L14:
        if (Log.isLoggable("GoogleNowAuthService", 3))
        {
            Log.d("GoogleNowAuthService", "Ebay user is not logged in. Unable to acquire Google now card auth.");
        }
        SharedWakeLock.releaseLock();
        return;
_L15:
        preferenceManager.setLastGoogleNowAuthorization(l);
        if (hasRefreshToken(((Authentication) (intent)).user, ((Authentication) (intent)).iafToken, ((EbaySite) (obj)))) goto _L17; else goto _L16
_L16:
        if (Log.isLoggable("GoogleNowAuthService", 3))
        {
            Log.d("GoogleNowAuthService", "No valid refreshToken for Google Now account. Acquiring.");
        }
        intent = requestAuthToken();
        if (TextUtils.isEmpty(intent)) goto _L2; else goto _L18
_L18:
        if (Log.isLoggable("GoogleNowAuthService", 3))
        {
            Log.d("GoogleNowAuthService", "Acquired OAuth token for Google account. Sending to MDNS.");
        }
        obj = new ArrayList();
        NotificationPreference notificationpreference = new NotificationPreference();
        notificationpreference.eventType = com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM.name();
        notificationpreference.isEnabled = true;
        ((List) (obj)).add(notificationpreference);
        notificationpreference = new NotificationPreference();
        notificationpreference.eventType = com.ebay.common.model.mdns.NotificationPreference.EventType.SVDSRCH.name();
        notificationpreference.isEnabled = true;
        ((List) (obj)).add(notificationpreference);
        if (NotificationUtil.setGoogleNowSubscription(this, intent, ((List) (obj)))) goto _L2; else goto _L19
_L19:
        if (Log.isLoggable("GoogleNowAuthService", 6))
        {
            Log.e("GoogleNowAuthService", "Failed to deliver OAuth to MDNS");
        }
        SharedWakeLock.releaseLock();
        return;
_L17:
        if (!Log.isLoggable("GoogleNowAuthService", 3)) goto _L2; else goto _L20
_L20:
        Log.d("GoogleNowAuthService", "Refresh token is still valid. Going back to sleep.");
          goto _L2
_L9:
        if (Log.isLoggable("GoogleNowAuthService", 2))
        {
            Log.v("GoogleNowAuthService", "Cancelling refresh alarm.");
        }
        alarmManager.cancel(createPendingAlarmIntent());
        NotificationUtil.deactivateMdns(this, com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType.GOOGLE_NOW, intent, "GOOGLENOW", "GOOGLENOW");
          goto _L2
    }
}
