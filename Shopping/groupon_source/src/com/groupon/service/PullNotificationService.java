// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.commonsware.cwac.wakeful.WakefulIntentService;
import com.crittercism.app.Crittercism;
import com.groupon.Channel;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.models.DealSummary;
import com.groupon.foundations.service.BaseIntentService;
import com.groupon.models.country.Country;
import com.groupon.provider.LocalizedSharedPreferencesProvider;
import com.groupon.receiver.PullNotificationReceiver;
import com.groupon.service.core.AbTestService;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.events.GeneralEvent;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.CurrencyFormatter;
import com.groupon.util.Dates;
import com.groupon.util.NotificationFactory;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            GCMNotificationService

public class PullNotificationService extends BaseIntentService
{

    private static int APP_CREATE_REQUEST_CODE = 0;
    private static final String LOG_BY_ABTEST = "by_abtest";
    private static final String LOG_BY_USER_MIGRATION_DISABLED_NOTIFICATION = "by_user_migration_disabled_notification";
    private static final String LOG_FROM_PREFS = "from_prefs";
    private static final String LOG_MISSING_DATA = "missing_data";
    private static final String LOG_NO_DEALS_IN_DB = "no_deals_in_db";
    private static final String LOG_PREVIOUSLY_SEEN = "previously_seen";
    public static final String NOTIFICATION_PURCHASE_URI_TEMPLATE = "/purchase/%1$s?option_id=%2$s&showDealDetail=%3$s";
    public static final String NOTIFICATION_URI_TEMPLATE = "/channel/featured?deal_id=%1$s";
    private AbTestService abTestService;
    private Binder binder;
    private CurrentCountryManager currentCountryManager;
    private LocalizedSharedPreferencesProvider locationPreferenceManager;
    private Logger logger;
    private SharedPreferences prefs;

    public PullNotificationService()
    {
        super(com/groupon/service/PullNotificationService.getCanonicalName());
        binder = new Binder();
    }

    public static void cancelAlarm(Context context)
    {
        ((AlarmManager)context.getSystemService("alarm")).cancel(getIntentForAppCreate(context));
    }

    private static PendingIntent getIntentForAppCreate(Context context)
    {
        Intent intent = new Intent(context, com/groupon/service/PullNotificationService);
        return PendingIntent.getService(context, APP_CREATE_REQUEST_CODE, intent, 0x8000000);
    }

    public IBinder onBind(Intent intent)
    {
        return binder;
    }

    public void onCreate()
    {
        super.onCreate();
        Ln.d("PullNotificationService onCreate()", new Object[0]);
    }

    protected void onHandleIntent(Intent intent)
    {
        logger.logGeneralEvent("notifications", "service_start", "n10n", 1, Logger.NULL_NST_FIELD);
        if (currentCountryManager.getCurrentCountry() != null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        logger.logGeneralEvent("notifications", "suppress", "no_location_set", 0, Logger.NULL_NST_FIELD);
        PullNotificationReceiver.completeWakefulIntent(intent);
        return;
        boolean flag;
        boolean flag1;
        if (!Strings.equalsIgnoreCase(abTestService.getVariant("newEnableDailyServerPushNotifications1510USCA"), "on"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        flag1 = prefs.getBoolean("pushNotificationEnabled", false);
        if (!currentCountryManager.getCurrentCountry().isUSACompatible() || flag)
        {
            break MISSING_BLOCK_LABEL_141;
        }
        Ln.i("Not showing local notifications for US because server push is A/B test enabled", new Object[0]);
        logger.logGeneralEvent("notifications", "suppress", "by_abtest", 1, Logger.NULL_NST_FIELD);
        PullNotificationReceiver.completeWakefulIntent(intent);
        return;
        if (prefs.getBoolean("dealNotification", true))
        {
            break MISSING_BLOCK_LABEL_179;
        }
        logger.logGeneralEvent("notifications", "suppress", "from_prefs", 1, Logger.NULL_NST_FIELD);
        PullNotificationReceiver.completeWakefulIntent(intent);
        return;
        if (!prefs.getBoolean("userMigrationDisabledNotification", false))
        {
            break MISSING_BLOCK_LABEL_217;
        }
        logger.logGeneralEvent("notifications", "suppress", "by_user_migration_disabled_notification", 1, Logger.NULL_NST_FIELD);
        PullNotificationReceiver.completeWakefulIntent(intent);
        return;
        if (!flag || !flag1)
        {
            break MISSING_BLOCK_LABEL_263;
        }
        Intent intent1 = new Intent(getApplicationContext(), com/groupon/service/GCMNotificationService);
        intent1.setAction("com.groupon.REGISTER");
        Ln.d("GCM_Notification: Disabling daily deal push notification because AB test changed. Will still get second touch push notification ", new Object[0]);
        WakefulIntentService.sendWakefulWork(this, intent1);
        Object obj = null;
        Object obj1 = ((DaoDealSummary)RoboGuice.getInjector(this).getInstance(com/groupon/db/dao/DaoDealSummary)).getPullNotificationDealByChannelId(Channel.PULLNOTIFICATION.name());
        obj = obj1;
_L2:
        if (obj != null)
        {
            break; /* Loop/switch isn't completed */
        }
        logger.logGeneralEvent("notifications", "suppress", "no_deals_in_db", 1, Logger.NULL_NST_FIELD);
        Ln.i("Not posting notification because db is empty", new Object[0]);
        PullNotificationReceiver.completeWakefulIntent(intent);
        return;
        SQLException sqlexception;
        sqlexception;
        Ln.d(sqlexception);
        if (true) goto _L2; else goto _L1
        obj;
        sqlexception = new GeneralEvent("notifications", "exception_suppress", Log.getStackTraceString(((Throwable) (obj))), 1, Logger.NULL_NST_FIELD);
        Crittercism.logHandledException(((Throwable) (obj)));
        logger.log(sqlexception);
        throw obj;
        obj;
        PullNotificationReceiver.completeWakefulIntent(intent);
        throw obj;
_L1:
        Object obj2;
        int i;
        i = (int)(((DealSummary) (obj)).modificationDate.getTime() - Dates.midnightThisMorning().getTimeInMillis());
        logger.logGeneralEvent("notifications", "deal_timestamp", "", i, Logger.NULL_NST_FIELD);
        obj2 = (CurrencyFormatter)RoboGuice.getInjector(this).getInstance(com/groupon/util/CurrencyFormatter);
        if (((DealSummary) (obj)).derivedValueAmount != 0) goto _L4; else goto _L3
_L3:
        sqlexception = "";
_L11:
        String s;
        String s1;
        com.groupon.util.ArraySharedPreferences arraysharedpreferences;
        String s2;
        String s3;
        s2 = ((CurrencyFormatter) (obj2)).formatWithQuantity(((DealSummary) (obj)).derivedPriceAmount, ((DealSummary) (obj)).derivedPriceCurrencyCode, ((DealSummary) (obj)).derivedMinimumPurchaseQuantity, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
        arraysharedpreferences = locationPreferenceManager.get();
        obj2 = arraysharedpreferences.getString("lastDealShortTitleNotified", null);
        s = ((DealSummary) (obj)).announcementTitle;
        s1 = ((DealSummary) (obj)).remoteId;
        s3 = ((DealSummary) (obj)).largeImageUrl;
        Ln.d("Previous deal title: \"%s\"", new Object[] {
            obj2
        });
        Ln.d("New deal title: \"%s\"", new Object[] {
            s
        });
        if (Strings.equals(obj2, s) && prefs.getBoolean("hidePreviouslySeenDealsFromNotifications", true)) goto _L6; else goto _L5
_L5:
        Ln.i("Posting notification: %s", new Object[] {
            s
        });
        if (!Strings.notEmpty(s1)) goto _L8; else goto _L7
_L7:
        if (!Strings.notEmpty(s) || s3 == null) goto _L10; else goto _L9
_L9:
        Object obj3;
        obj3 = null;
        obj2 = obj3;
        if (Strings.equals(((DealSummary) (obj)).channel, Channel.TRAVEL.name()))
        {
            break MISSING_BLOCK_LABEL_729;
        }
        obj2 = obj3;
        if (Strings.equals(((DealSummary) (obj)).channel, Channel.GETAWAYS.name()))
        {
            break MISSING_BLOCK_LABEL_729;
        }
        obj2 = obj3;
        if (Strings.equals(((DealSummary) (obj)).channel, Channel.HOTELS.name()))
        {
            break MISSING_BLOCK_LABEL_729;
        }
        obj2 = obj3;
        if (!((DealSummary) (obj)).isTravelBookableDeal)
        {
            obj2 = String.format((new StringBuilder()).append(currentCountryManager.getCurrentCountry().shortName).append("/purchase/%1$s?option_id=%2$s&showDealDetail=%3$s").toString(), new Object[] {
                s1, ((DealSummary) (obj)).defaultOptionId, "true"
            });
        }
        obj = new com.groupon.util.NotificationFactory.NotificationDetail(s, "", String.format((new StringBuilder()).append(currentCountryManager.getCurrentCountry().shortName).append("/channel/featured?deal_id=%1$s").toString(), new Object[] {
            s1
        }), ((String) (obj2)), s3, s2, sqlexception, true, com.groupon.util.NotificationFactory.NotificationDetail.NotificationType.CLIENT_PULL, ((DealSummary) (obj)));
        ((NotificationFactory)RoboGuice.getInjector(this).getInstance(com/groupon/util/NotificationFactory)).sendLocalNotification(this, ((com.groupon.util.NotificationFactory.NotificationDetail) (obj)));
_L8:
        arraysharedpreferences.edit().putString("lastDealShortTitleNotified", s).apply();
_L12:
        PullNotificationReceiver.completeWakefulIntent(intent);
        return;
_L4:
        sqlexception = ((CurrencyFormatter) (obj2)).formatWithQuantity(((DealSummary) (obj)).derivedValueAmount, ((DealSummary) (obj)).derivedValueCurrencyCode, ((DealSummary) (obj)).derivedMinimumPurchaseQuantity, com.groupon.util.CurrencyFormatter.DecimalStripBehavior.OnlyIfZero);
          goto _L11
_L10:
        logger.logGeneralEvent("notifications", "suppress", "missing_data", 1, Logger.NULL_NST_FIELD);
          goto _L8
_L6:
        logger.logGeneralEvent("notifications", "suppress", "previously_seen", 1, Logger.NULL_NST_FIELD);
        sqlexception = new HashMap(3);
        obj = obj2;
        if (obj2 == null)
        {
            obj = "null";
        }
        sqlexception.put("prev_title", obj);
        if (s == null)
        {
            obj = "null";
        } else
        {
            obj = s;
        }
        sqlexception.put("title", obj);
        obj = s1;
        if (s1 == null)
        {
            obj = "null";
        }
        sqlexception.put("id", obj);
        sqlexception.put("deal_updated", Integer.toString(i));
        obj = new ObjectMapper();
        try
        {
            obj = ((ObjectMapper) (obj)).writeValueAsString(sqlexception);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            obj = "json_creation_failed";
        }
        logger.logGeneralEvent("notifications", "previously_seen_suppress", ((String) (obj)), 1, Logger.NULL_NST_FIELD);
        Ln.i("Not posting notification for previously seen deal: %s", new Object[] {
            s
        });
          goto _L12
    }

    static 
    {
        APP_CREATE_REQUEST_CODE = 0;
    }
}
