// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.location.Location;
import android.os.SystemClock;
import com.crittercism.app.Crittercism;
import com.f2prateek.dart.Dart;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.groupon.ConsumerDeviceSettings;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.foundations.service.BaseIntentService;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.models.GenericAmount;
import com.groupon.models.country.Country;
import com.groupon.models.country.EnabledFeatures;
import com.groupon.models.notification.GCMNotificationExtra;
import com.groupon.models.notification.LocationMetadata;
import com.groupon.receiver.GcmReceiver;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.service.countryanddivision.CurrentCountryService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.NotificationFactory;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PlayServicesUtils;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            LocationService, LoginService

public class GCMNotificationService extends BaseIntentService
{

    private static final String DEFAULT_PREFIX = "groupon:///dispatch";
    private static final String EXTRA = "extra";
    private static final String GCM_SENDER_ID = "169314272487";
    private static final String IMAGE_URI = "imageUri";
    private static int INSTALL_EXCEPTION_ALARMS_REQUEST_CODE = 0;
    public static final String INTENT_EXTRA_COUNTRY_TO_BE_UNSUBSCRIBED = "countryToBeUnsubscribed";
    private static final String LINK = "link";
    private static int MAX_RETRY = 5;
    private static int REFRESH_LOCATION_TIMEOUT_IN_MS = 60000;
    private static long RETRY_BASE_TIME = 0x1b7740L;
    private AbTestService abTestService;
    private ConsumerDeviceSettings consumerDeviceSettings;
    protected Country countryToBeUnsubscribed;
    private CurrentCountryManager currentCountryManager;
    private CurrentCountryService currentCountryService;
    private DeepLinkUtil deepLinkUtil;
    private GoogleCloudMessaging gcm;
    private boolean isGcmRegisterToken1508INTL;
    private Location knownLocation;
    private LocationService locationService;
    private Logger logger;
    private LoginService loginService;
    private NotificationFactory notificationFactory;
    private ObjectMapperWrapper objectMapper;
    private PackageInfo packageInfo;
    private SharedPreferences sharedPreferences;

    public GCMNotificationService()
    {
        super(com/groupon/service/GCMNotificationService.getCanonicalName());
        knownLocation = null;
    }

    private String getAppInfo()
    {
        return String.format("Groupon/%s (Android %s / Play %s)", new Object[] {
            packageInfo.versionName, android.os.Build.VERSION.RELEASE, Integer.valueOf(PlayServicesUtils.getGooglePlayServicesVersion(this))
        });
    }

    private void handlePushMessage(Intent intent)
    {
        String s;
        Ln.d("GCM_Notification: Received push notification with intent: %s", new Object[] {
            intent
        });
        s = gcm.getMessageType(intent);
        if (!Strings.equals("send_error", s)) goto _L2; else goto _L1
_L1:
        logger.logGeneralEvent("push_notifications", "message_send_error", "send_error", 1, Logger.NULL_NST_FIELD);
_L4:
        return;
_L2:
        if (Strings.equals("deleted_messages", s))
        {
            logger.logGeneralEvent("push_notifications", "message_deleted", "deleted_messages", 1, Logger.NULL_NST_FIELD);
            return;
        }
        if (!Strings.equals("gcm", s)) goto _L4; else goto _L3
_L3:
        String s1;
        String s3;
        String s4;
        s3 = intent.getStringExtra("alert");
        String s2 = intent.getStringExtra("link");
        s = intent.getStringExtra("imageUri");
        Object obj;
        Object obj1;
        com.groupon.models.notification.GCMNotificationExtra.Deal deal;
        if (Strings.notEmpty(s))
        {
            s1 = (new StringBuilder()).append(s).append("t954x610.jpg").toString();
        } else
        {
            s1 = null;
        }
        if (Strings.isEmpty(s2))
        {
            s = deepLinkUtil.defaultLocalDeeplink(currentCountryManager.getCurrentCountry().shortName.toLowerCase());
            Ln.d("GCM_Notification: Link in the payload was empty. Sending default link: %s", new Object[] {
                s
            });
        } else
        {
            s = s2;
            if (!s2.startsWith("groupon:///dispatch"))
            {
                s = deepLinkUtil.normalizeUrl(s2, true);
            }
        }
        intent = (GCMNotificationExtra)objectMapper.readValue(intent.getStringExtra("extra"), com/groupon/models/notification/GCMNotificationExtra);
        s4 = ((GCMNotificationExtra) (intent)).nid;
        deal = ((GCMNotificationExtra) (intent)).deal;
        if (deal == null)
        {
            break MISSING_BLOCK_LABEL_394;
        }
        obj = null;
        obj1 = null;
        s2 = obj;
        intent = obj1;
        if (deal.price == null)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        s2 = obj;
        intent = obj1;
        if (deal.value != null)
        {
            s2 = deal.price.getFormattedAmount();
            intent = deal.value.getFormattedAmount();
        }
        intent = new com.groupon.util.NotificationFactory.NotificationDetail(s3, s4, s, null, s1, s2, intent, true, com.groupon.util.NotificationFactory.NotificationDetail.NotificationType.SERVER_PUSH);
        notificationFactory.sendLocalNotification(this, intent);
        return;
        intent;
        Ln.d(intent);
        logger.logGeneralEvent("push_notifications", "not_delivered", "message_block_error", 1, Logger.NULL_NST_FIELD);
        logger.logGeneralEvent("push_notifications", "message_block_error", intent.getClass().getSimpleName(), 1, Logger.NULL_NST_FIELD);
        if (!(intent instanceof IOException))
        {
            Crittercism.logHandledException(intent);
            return;
        }
          goto _L4
        intent = new com.groupon.util.NotificationFactory.NotificationDetail(s3, s4, s, null, s1, null, null, false, com.groupon.util.NotificationFactory.NotificationDetail.NotificationType.SERVER_PUSH);
        notificationFactory.sendLocalNotification(this, intent);
        return;
          goto _L4
    }

    private void handleRegistration(Intent intent)
    {
        String s;
        String s1;
        String s2;
        String s3;
        String s4;
        String s5;
        String s6;
        boolean flag;
        boolean flag1;
        s6 = intent.getAction();
        s4 = sharedPreferences.getString("gcmAppInfo", "");
        s2 = getAppInfo();
        s5 = sharedPreferences.getString("push_country", null);
        s3 = sharedPreferences.getString("gcmUploadedToken", "");
        s1 = sharedPreferences.getString("gcmRegId", "");
        if (Strings.notEmpty(s1))
        {
            sharedPreferences.edit().putBoolean("gcmHadToken", true).apply();
        }
        s = null;
        flag = Strings.equalsIgnoreCase(abTestService.getVariant("newEnableDailyServerPushNotifications1510USCA"), "on");
        flag1 = sharedPreferences.getBoolean("pushNotificationEnabled", false);
        if (!Strings.equals(s6, "com.google.android.c2dm.intent.REGISTRATION")) goto _L2; else goto _L1
_L1:
        s = intent.getStringExtra("registration_id");
        if (!Strings.isEmpty(s) && !Strings.equals(s, s1)) goto _L4; else goto _L3
_L3:
        Ln.d("GCM_Notification: reg id from com.google.android.c2dm.intent.REGISTRATION is empty or same as the previous reg id", new Object[0]);
_L6:
        return;
_L4:
        Ln.d((new StringBuilder()).append("GCM_Notification: received reg id ").append(s).append(" from ").append("com.google.android.c2dm.intent.REGISTRATION").append(" should re-register").toString(), new Object[0]);
_L2:
        if (Strings.equalsIgnoreCase(s4, s2) && Strings.equals(s5, currentCountryManager.getCurrentCountry().isoName) && sharedPreferences.contains("pushNotificationEnabled") && flag == flag1 && Strings.notEmpty(s3))
        {
            if (Strings.notEmpty(s))
            {
                s1 = s;
            }
            if (s3.equals(s1))
            {
                Ln.d("GCM_Notification: App info/country has not changed and device token was uploaded in the last run", new Object[0]);
                logger.logGeneralEvent("push_notifications", "no_updates", "device_token_post", 1, Logger.NULL_NST_FIELD);
                return;
            }
        }
        Ln.d("GCM_Notification: App info/current country has changed or token was not uploaded. Clearing the registration id locally", new Object[0]);
        invalidateDeviceTokenRegistration();
        s1 = s;
        if (Strings.isEmpty(s))
        {
            s1 = registerGcm(intent, s2);
        }
        if (Strings.notEmpty(s1))
        {
            uploadRegistrationId(intent, s1);
            return;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private boolean isGcmTokenRegistrationEnabledForCountry(Country country)
    {
        return country.isUSACompatible() || isGcmRegisterToken1508INTL && country.enabledFeatures.subscriptions && !country.isLATAMCompatible();
    }

    private String registerGcm(Intent intent, String s)
    {
        String s1;
        String s2;
        s2 = null;
        s1 = s2;
        Ln.d("GCM_Notification: Registering with GCM servers", new Object[0]);
        s1 = s2;
        s2 = gcm.register(new String[] {
            "169314272487"
        });
        s1 = s2;
        sharedPreferences.edit().putString("gcmRegId", s2).putString("gcmAppInfo", s).apply();
        s1 = s2;
        try
        {
            Ln.d((new StringBuilder()).append("GCM_Notification:Saved registration id ").append(s2).append(" and app info ").append(s).append(" to prefs.").toString(), new Object[0]);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Ln.d((new StringBuilder()).append("GCM_Notification: There was an issue with gcm registration on Google servers. WIll try again on next app launch. Exception: ").append(s).toString(), new Object[0]);
            logger.logGeneralEvent("push_notifications", "registration_error", "push_n10n", 1, Logger.NULL_NST_FIELD);
            logger.logGeneralEvent("push_notifications", "registration_error", s.getClass().getSimpleName(), 1, Logger.NULL_NST_FIELD);
            s2 = s1;
            if (!retryWhenException(this, intent, "com.groupon.REGISTER", ""))
            {
                logger.logGeneralEvent("push_notifications", "registration_error", "too_many_retries", 1, Logger.NULL_NST_FIELD);
                return s1;
            }
        }
        return s2;
    }

    private void uploadRegistrationId(Intent intent, String s)
    {
        Object obj;
        boolean flag1;
        flag1 = Strings.equalsIgnoreCase(abTestService.getVariant("newEnableDailyServerPushNotifications1510USCA"), "on");
        obj = sharedPreferences.getString("gcmUploadedToken", "");
        if (!Strings.notEmpty(s) || Strings.equals(s, obj)) goto _L2; else goto _L1
_L1:
        Ln.d((new StringBuilder()).append("GCM_Notification: new reg id ").append(s).append(" is different to the last uploaded reg id ").append(((String) (obj))).append(", processing upload").toString(), new Object[0]);
        Country country;
        Context context;
        long l;
        long l1;
        context = getApplicationContext();
        country = currentCountryManager.getCurrentCountry();
        l = System.currentTimeMillis();
        knownLocation = locationService.getLocation(REFRESH_LOCATION_TIMEOUT_IN_MS);
        l1 = System.currentTimeMillis();
        obj = new LocationMetadata();
        Object obj1;
        boolean flag;
        if (knownLocation != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        obj.hadLocation = flag;
        obj.hadToken = sharedPreferences.getBoolean("gcmHadToken", false);
        obj.locationEnabled = locationService.isAGpsProviderEnabled();
        logger.logGeneralEvent("push_notifications", "location_refresh_duration", ((LocationMetadata) (obj)).toEncodedString(), (int)(l1 - l), Logger.NULL_NST_FIELD);
        obj1 = consumerDeviceSettings.getBcookie();
        if (!flag1) goto _L4; else goto _L3
_L3:
        obj = context.getString(0x7f08050e);
_L10:
        obj = new ArrayList(Arrays.asList(new Object[] {
            "device_id", obj1, "push_contract_version", obj, "token", s
        }));
        if (sharedPreferences.getBoolean("dealNotification", true))
        {
            ((ArrayList) (obj)).addAll(Arrays.asList(new String[] {
                "event", "activate"
            }));
        }
        if (loginService.isLoggedIn())
        {
            ((ArrayList) (obj)).addAll(Arrays.asList(new String[] {
                "user_id", loginService.getUserId()
            }));
        }
        if (knownLocation != null)
        {
            ((ArrayList) (obj)).addAll(Arrays.asList(new Serializable[] {
                "lat", Double.valueOf(knownLocation.getLatitude()), "lng", Double.valueOf(knownLocation.getLongitude())
            }));
        }
        (new SyncHttp(context, java/lang/Void, String.format("%s/device_tokens", new Object[] {
            currentCountryService.getBaseUrl(country)
        }), ((ArrayList) (obj)).toArray())).method("POST").call();
        obj1 = (new StringBuilder()).append("GCM_Notification: Pushed reg id to groupon servers with push contract version ");
        if (!flag1) goto _L6; else goto _L5
_L5:
        obj = context.getString(0x7f08050e);
_L8:
        Ln.d(((StringBuilder) (obj1)).append(((String) (obj))).toString(), new Object[0]);
        Ln.d("GCM_Notification: Updated push subscription", new Object[0]);
        if (knownLocation != null)
        {
            sharedPreferences.edit().putString("push_country", country.isoName).putString("gcmUploadedToken", s).putBoolean("pushNotificationEnabled", flag1).apply();
            logger.logGeneralEvent("push_notifications", "registration_completed", "update_push_subscription", 0, Logger.NULL_NST_FIELD);
            return;
        }
          goto _L7
_L4:
        obj = context.getString(0x7f08050d);
        continue; /* Loop/switch isn't completed */
_L6:
        obj = context.getString(0x7f08050d);
          goto _L8
_L7:
        try
        {
            logger.logGeneralEvent("push_notifications", "registration_completed_without_location", "update_push_subscription", 0, Logger.NULL_NST_FIELD);
            return;
        }
        catch (Exception exception)
        {
            sharedPreferences.edit().remove("gcmUploadedToken").apply();
            logger.logGeneralEvent("push_notifications", "http_exception", "device_token_post", 1, Logger.NULL_NST_FIELD);
            logger.logGeneralEvent("push_notifications", "device_token_post", exception.getClass().getSimpleName(), 1, Logger.NULL_NST_FIELD);
            if (!(exception instanceof IOException))
            {
                Crittercism.logHandledException(exception);
            }
        }
        if (!retryWhenException(this, intent, "com.groupon.UPLOAD_REG_ID", s))
        {
            logger.logGeneralEvent("push_notifications", "device_token_post", "too_many_retries", 1, Logger.NULL_NST_FIELD);
        }
_L2:
        return;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public void invalidateDeviceTokenRegistration()
    {
        sharedPreferences.edit().remove("gcmRegId").remove("gcmUploadedToken").remove("push_country").remove("pushNotificationEnabled").remove("gcmAppInfo").apply();
    }

    public boolean isAlarmSet(Context context)
    {
        Intent intent = new Intent(context, com/groupon/receiver/GcmReceiver);
        return PendingIntent.getBroadcast(context, INSTALL_EXCEPTION_ALARMS_REQUEST_CODE, intent, 0x20000000) != null;
    }

    protected void onHandleIntent(Intent intent)
    {
        if (intent == null)
        {
            return;
        }
        Dart.inject(this, intent.getExtras());
        Object obj;
        Country country;
        obj = intent.getAction();
        gcm = GoogleCloudMessaging.getInstance(this);
        country = currentCountryManager.getCurrentCountry();
        isGcmRegisterToken1508INTL = abTestService.isVariantEnabled("gcmRegisterToken1508INTL", "on");
        if (country != null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        Ln.d("GCM_Notification: Country is not set", new Object[0]);
        if (gcm != null)
        {
            gcm.close();
        }
        GcmReceiver.completeWakefulIntent(intent);
        return;
        if (isGcmTokenRegistrationEnabledForCountry(country) || Strings.equals(obj, "com.groupon.UNSUBSCRIBE_PUSH"))
        {
            break MISSING_BLOCK_LABEL_142;
        }
        Ln.d("GCM_Notification: Country %s doesn't support subscriptions and action is not unsubscribe", new Object[] {
            country.isoName
        });
        if (gcm != null)
        {
            gcm.close();
        }
        GcmReceiver.completeWakefulIntent(intent);
        return;
        if (!Strings.isEmpty(sharedPreferences.getString("gcmRegId", "")) || !Strings.equals(obj, "com.groupon.UNSUBSCRIBE_PUSH"))
        {
            break MISSING_BLOCK_LABEL_204;
        }
        Ln.d("GCM_Notification: There exists no GCM ID to unsubscribe", new Object[0]);
        if (gcm != null)
        {
            gcm.close();
        }
        GcmReceiver.completeWakefulIntent(intent);
        return;
        if (Strings.equals(obj, "com.groupon.UNSUBSCRIBE_PUSH") || sharedPreferences.getBoolean("dealNotification", true))
        {
            break MISSING_BLOCK_LABEL_261;
        }
        Ln.d("GCM_Notification: push notification disabled", new Object[0]);
        if (gcm != null)
        {
            gcm.close();
        }
        GcmReceiver.completeWakefulIntent(intent);
        return;
        logger.logGeneralEvent("push_notifications", "service_start", "", 0, Logger.NULL_NST_FIELD);
        if (!Strings.equals(obj, "com.groupon.REGISTER") && !Strings.equals(obj, "com.google.android.c2dm.intent.REGISTRATION")) goto _L2; else goto _L1
_L1:
        handleRegistration(intent);
_L3:
        if (gcm != null)
        {
            gcm.close();
        }
        GcmReceiver.completeWakefulIntent(intent);
        return;
_L2:
        if (!Strings.equals(obj, "com.groupon.UPLOAD_REG_ID"))
        {
            break MISSING_BLOCK_LABEL_405;
        }
        uploadRegistrationId(intent, intent.getStringExtra("gcmRegId"));
          goto _L3
        obj;
        logger.logGeneralEvent("push_notifications", "unknown", obj.getClass().getSimpleName(), 1, Logger.NULL_NST_FIELD);
        if (!(obj instanceof IOException))
        {
            Crittercism.logHandledException(((Throwable) (obj)));
        }
        if (gcm != null)
        {
            gcm.close();
        }
        GcmReceiver.completeWakefulIntent(intent);
        return;
        if (!Strings.equals(obj, "com.google.android.c2dm.intent.RECEIVE")) goto _L5; else goto _L4
_L4:
        handlePushMessage(intent);
          goto _L3
        obj;
        if (gcm != null)
        {
            gcm.close();
        }
        GcmReceiver.completeWakefulIntent(intent);
        throw obj;
_L5:
        if (!Strings.equals(obj, "com.groupon.UNSUBSCRIBE_PUSH")) goto _L3; else goto _L6
_L6:
        removeDeviceTokenAndUnsubscribe();
          goto _L3
    }

    public void removeDeviceTokenAndUnsubscribe()
    {
        String s;
        s = sharedPreferences.getString("gcmRegId", "");
        if (!Strings.notEmpty(s))
        {
            break MISSING_BLOCK_LABEL_354;
        }
        Ln.d("GCM_Notification: Removing subscriptions and device token from the server.", new Object[0]);
        Country country;
        if (countryToBeUnsubscribed == null)
        {
            break MISSING_BLOCK_LABEL_289;
        }
        country = countryToBeUnsubscribed;
_L2:
        Context context = getApplicationContext();
        knownLocation = locationService.getLocation();
        ArrayList arraylist = new ArrayList(Arrays.asList(new Object[] {
            "event", "deactivate", "device_id", consumerDeviceSettings.getBcookie()
        }));
        if (loginService.isLoggedIn())
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "user_id", loginService.getUserId()
            }));
        }
        if (knownLocation != null)
        {
            arraylist.addAll(Arrays.asList(new Serializable[] {
                "lat", Double.valueOf(knownLocation.getLatitude()), "lng", Double.valueOf(knownLocation.getLongitude())
            }));
        }
        (new SyncHttp(context, java/lang/Void, String.format("%s/device_tokens/%s", new Object[] {
            currentCountryService.getBaseUrl(country), s
        }), arraylist.toArray())).method("PUT").call();
        invalidateDeviceTokenRegistration();
        Ln.d("GCM_Notification: Removed device token with push contract version", new Object[0]);
        logger.logGeneralEvent("push_notifications", "clear_subscription_completed", "update_push_subscription", 0, Logger.NULL_NST_FIELD);
        return;
        country = currentCountryManager.getCurrentCountry();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        logger.logGeneralEvent("push_notifications", "http_exception", "device_token_put", 1, Logger.NULL_NST_FIELD);
        logger.logGeneralEvent("push_notifications", "device_token_put", exception.getClass().getSimpleName(), 1, Logger.NULL_NST_FIELD);
        if (!(exception instanceof IOException))
        {
            Crittercism.logHandledException(exception);
        }
    }

    public boolean retryWhenException(Context context, Intent intent, String s, String s1)
    {
        int i = intent.getIntExtra("request_retries", 0);
        if (i < MAX_RETRY && !isAlarmSet(context))
        {
            long l = SystemClock.elapsedRealtime() + (long)((double)RETRY_BASE_TIME * Math.pow(2D, i));
            ((AlarmManager)context.getSystemService("alarm")).set(2, l, PendingIntent.getBroadcast(context, INSTALL_EXCEPTION_ALARMS_REQUEST_CODE, (new Intent(context, com/groupon/receiver/GcmReceiver)).putExtras(intent).setAction(s).putExtra("request_retries", i + 1).putExtra("gcmRegId", s1), 0x8000000));
            Ln.d((new StringBuilder()).append("GCM_Notification: retry registration in ").append(l).append(" retry count ").append(i).toString(), new Object[0]);
            return true;
        } else
        {
            return false;
        }
    }

    static 
    {
        INSTALL_EXCEPTION_ALARMS_REQUEST_CODE = 1000;
    }
}
