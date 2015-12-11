// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.content.EbayBroadcast;
import com.ebay.common.model.ClientAlertsAuthToken;
import com.ebay.common.model.ClientAlertsSession;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.model.mdns.PlatformNotificationsEvent;
import com.ebay.common.net.api.ca.ClientAlerts;
import com.ebay.common.net.api.trading.EbayTradingApiHelper;
import com.ebay.common.util.SharedPreferencesCompat;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.ui_stuff.Util;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.content.DataManager;
import com.ebay.nautilus.domain.content.dm.SymbanDataManager;
import com.ebay.nautilus.domain.dcs.DcsState;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.BaseIntentService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import junit.framework.Assert;

// Referenced classes of package com.ebay.mobile.notifications:
//            ItemCache, NotificationPreferenceManager, EbayNotificationManager, PollAlarmReceiver, 
//            PollServiceListCache, EbaySmartNotificationManager, SharedWakeLock, NotificationUtil, 
//            NotificationTrackingUtil

public class PollService extends BaseIntentService
{
    public static class SavedSearchPollData
    {

        public int newItemCount;
        public long pollTime;
        public String searchId;
        public String searchName;
        public long sinceTime;
        public long viewTime;

        public SavedSearchPollData()
        {
        }
    }


    public static final String ADD_ITEM_LOCAL_NOTIFICATIONS_CART = "com.ebay.mobile.service.ADD_ITEM_LOCAL_NOTIFICATIONS_CART";
    public static final String ADD_MY_EBAY_ITEMS_TO_LOCAL_NOTIFICATIONS = "com.ebay.mobile.service.ADD_MY_EBAY_ITEMS_TO_LOCAL_NOTIFICATIONS";
    private static final long CHECK_OTHER_NOTIFICATION_OPTIONS_INTERVAL = 0x5265c00L;
    private static final String CURRENT_CA_SESSION_DATA = "EBAY_CA_SESSION_DATA";
    private static final String CURRENT_CA_SESSION_ID = "EBAY_CA_SESSION_ID";
    private static final String CURRENT_CA_SESSION_TS = "EBAY_CA_SESSION_TS";
    private static final String CURRENT_CA_SESSION_USER = "EBAY_CA_SESSION_USER";
    private static final String CURRENT_CA_TOKEN = "EBAY_CA_TOKEN";
    private static final String CURRENT_CA_TOKEN_EXPIRY = "EBAY_CA_TOKEN_EXPIRY";
    public static final String DISABLE_NOTIFICATIONS = "com.ebay.mobile.service.DISABLE_NOTIFICATIONS";
    public static final String DISABLE_POLLING = "com.ebay.mobile.service.DISABLE_POLLING";
    public static final String DO_POLL = "com.ebay.mobile.service.DO_POLL";
    public static final String ENABLE_POLLING = "com.ebay.mobile.service.ENABLE_POLLING";
    public static final long INITIAL_WAKE_UP_INTERVAL = 30000L;
    public static final int INVALID_AUTH_N_AUTH_TOKEN = 0x14e6d11;
    private static final String LAST_POLL_TIME = "LAST_POLL_TS";
    private static final String LAST_POLL_TIME_SAVED_SEARCH = "SS_LAST_POLL_TS";
    private static final String LAST_UPGRADE_TIME = "LAST_UPGRADE_TS";
    private static final String LN_PREPEND_TEXT = "LN: ";
    public static final String LOCAL_NOTIFICATIONS = "com.ebay.mobile.service.LOCAL_NOTIFICATIONS";
    public static final long MILLISECONDS_TIL_START = 1L;
    public static final long MILLISECONDS_TIL_START_PUSH_SS_REFRESHER = 0x927c0L;
    private static final String NAME = "PollService";
    private static final int POLL_INTERVAL = 0x5265c0;
    public static final int POLL_SERVICE_ALARM = 0;
    public static final String PREFS_LOCAL_NOTIFICATIONS = "surfaceLocalNotifications";
    public static final String RESET_LOCAL_NOTIFICATIONS_TIMER = "com.ebay.mobile.service.RESET_LOCAL_NOTIFICATIONS_TIMER";
    protected static final long SAVED_SEARCH_DEFAULT_SINCE_THRESHOLD = 0x36ee80L;
    protected static final int SAVED_SEARCH_ELAPSED_THRESHOLD_HRS = 12;
    protected static final int SAVED_SEARCH_PSEUDO_JITTER_FACTOR = 2;
    protected static final int SAVED_SEARCH_WINDOW_DURATION_HRS = 2;
    protected static final int SAVED_SEARCH_WINDOW_START_HR = 6;
    public static final String SET_PREFERENCES = "com.ebay.mobile.service.SET_PREFERENCES";
    public static final String UPDATE_LOCAL_NOTIFICATIONS_CART = "com.ebay.mobile.service.UPDATE_LOCAL_NOTIFICATIONS_CART";
    public static final long WAKE_UP_INTERVAL = 0x493e0L;
    public static final long WAKE_UP_INTERVAL_PUSH_SS_REFRESHER = 0x5265c00L;
    public static final String WAKE_UP_SOON = "com.ebay.mobile.service.WAKE_UP_SOON";
    public static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("PollService", 3, "PollService log");
    private final String PREFS_FILE = getPrefsName();
    private NotificationPreferenceManager notificationPrefs;
    private SharedPreferences sharedPrefs;

    public PollService()
    {
        super("PollService");
    }

    private void createLocalNotifications(List list)
    {
        if (list == null || list.isEmpty())
        {
            log("No events, exit createLocalNotifications");
            return;
        }
        ItemCache itemcache;
        String s;
        Object obj;
        itemcache = new ItemCache(this);
        s = MyApp.getPrefs().getCurrentUser();
        obj = itemcache.findUnreceivedEvents(list);
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (!((List) (obj)).isEmpty()) goto _L3; else goto _L2
_L2:
        log("No local notifications to surface");
        return;
        list;
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "PollService Exception inserting events", list);
        }
_L10:
        log("Events sent to cache");
        return;
_L3:
        itemcache.insertPlatformNotificationsEvent(((java.util.Collection) (obj)));
        log((new StringBuilder()).append("Inserted new events, total=").append(((List) (obj)).size()).toString());
        list.clear();
        obj = ((List) (obj)).iterator();
_L7:
        if (!((Iterator) (obj)).hasNext()) goto _L5; else goto _L4
_L4:
        Object obj1 = (PlatformNotificationsEvent)((Iterator) (obj)).next();
        if (!notificationPrefs.isEventEnabled(s, ((PlatformNotificationsEvent) (obj1)).eventType)) goto _L7; else goto _L6
_L6:
        obj1 = itemcache.getUnviewedEvents(String.valueOf(NotificationPreference.nameToId(((PlatformNotificationsEvent) (obj1)).eventType)));
        if (obj1 == null) goto _L7; else goto _L8
_L8:
        list.addAll(((java.util.Collection) (obj1)));
          goto _L7
_L5:
        if (list.size() <= 0) goto _L10; else goto _L9
_L9:
        if (logTag.isLoggable)
        {
            ((PlatformNotificationsEvent)list.get(0)).title = (new StringBuilder()).append("LN: ").append(((PlatformNotificationsEvent)list.get(0)).title).toString();
        }
        EbayNotificationManager ebaynotificationmanager = new EbayNotificationManager(this, getEbayContext());
        ebaynotificationmanager.setCurrentUser(MyApp.getPrefs().getCurrentUser());
        ebaynotificationmanager.createNotifications(list);
        log("Sent notifications to EbayNotificationsManager");
          goto _L10
    }

    private void createNotifications(List list)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        log("No events, exit createNotifications");
_L7:
        return;
_L2:
        Object obj;
        Object obj1;
        obj = new ItemCache(this);
        obj1 = ((ItemCache) (obj)).findUnreceivedEvents(list);
        if (obj1 == null) goto _L4; else goto _L3
_L3:
        if (!((List) (obj1)).isEmpty()) goto _L5; else goto _L4
_L4:
        log("No local notifications to surface");
        return;
_L8:
        log((new StringBuilder()).append("Got unviewed events total=").append(((ArrayList) (obj1)).size()).toString());
        list.clear();
        obj = MyApp.getPrefs().getCurrentUser();
        obj1 = ((ArrayList) (obj1)).iterator();
        do
        {
            if (!((Iterator) (obj1)).hasNext())
            {
                break;
            }
            PlatformNotificationsEvent platformnotificationsevent = (PlatformNotificationsEvent)((Iterator) (obj1)).next();
            if (notificationPrefs.isEventEnabled(((String) (obj)), platformnotificationsevent.eventType))
            {
                list.add(platformnotificationsevent);
            }
        } while (true);
        try
        {
            EbayNotificationManager ebaynotificationmanager = new EbayNotificationManager(this, getEbayContext());
            ebaynotificationmanager.setCurrentUser(MyApp.getPrefs().getCurrentUser());
            ebaynotificationmanager.createNotifications(list);
            log("Sent notifications to EbayNotificationsManager");
        }
        // Misplaced declaration of an exception variable
        catch (List list)
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "PollService Exception inserting events", list);
            }
        }
        log("Events sent to cache");
        return;
_L5:
        ((ItemCache) (obj)).insertPlatformNotificationsEvent(((java.util.Collection) (obj1)));
        log((new StringBuilder()).append("Inserted new events, total=").append(((List) (obj1)).size()).toString());
        obj1 = ((ItemCache) (obj)).getUnviewedEvents(0x5265c0L);
        if (obj1 == null) goto _L7; else goto _L6
_L6:
        if (((ArrayList) (obj1)).isEmpty()) goto _L7; else goto _L8
    }

    protected static void createSavedSearchNotification(Context context, EbayContext ebaycontext, com.ebay.common.model.mdns.PlatformNotificationsEvent.SavedSearchEvent savedsearchevent)
    {
        (new ItemCache(context)).insertEventOnDuplicateUpdate(savedsearchevent);
        ebaycontext = new EbayNotificationManager(context, ebaycontext);
        String s = MyApp.getPrefs().getCurrentUser();
        ebaycontext.setCurrentUser(s);
        ebaycontext.createSavedSearchNotification(savedsearchevent, EbayNotificationManager.isQuietTime(context, s));
        log("Sent notifications to EbayNotificationsManager");
_L2:
        log("Events sent to cache");
        return;
        context;
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "PollService Exception inserting events", context);
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private ClientAlertsAuthToken getCaToken()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException, com.ebay.nautilus.kernel.net.Connector.ParseResponseDataException, com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException, com.ebay.nautilus.kernel.net.Connector.HostErrorException, IOException, InterruptedException
    {
        log("Getting CA token...");
        Object obj = MyApp.getPrefs().getAuthentication();
        if (obj == null)
        {
            return null;
        } else
        {
            obj = EbayApiUtil.getTradingApi(this, ((Authentication) (obj)));
            return EbayTradingApiHelper.getClientAlertsToken(getEbayContext(), ((com.ebay.nautilus.domain.net.api.trading.EbayTradingApi) (obj)));
        }
    }

    private String getIafToken()
    {
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            return authentication.iafToken;
        } else
        {
            return null;
        }
    }

    private static PendingIntent getLocalNotificationsAlarmIntent(Context context)
    {
        Intent intent = new Intent(context, com/ebay/mobile/notifications/PollAlarmReceiver);
        intent.setAction("com.ebay.mobile.service.LOCAL_NOTIFICATIONS");
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }

    private SharedPreferences getPollServicePrefs()
    {
        return getSharedPreferences(PREFS_FILE, 0);
    }

    static String getPrefsName()
    {
        if (NautilusKernel.isQaMode())
        {
            return "com.ebay.mobile.service.qa.PollService.prefs";
        } else
        {
            return "com.ebay.mobile.service.PollService.prefs";
        }
    }

    private long getSavedSearchLastPollTime()
    {
        String s = (new ItemCache(this)).getNameValue(NotificationPreferenceManager.makeKey(MyApp.getPrefs().getCurrentUser(), "SS_LAST_POLL_TS"));
        if (TextUtils.isEmpty(s))
        {
            return 0L;
        }
        long l;
        try
        {
            l = Long.parseLong(s);
        }
        catch (Exception exception)
        {
            return 0L;
        }
        return l;
    }

    private long getUpgradeLastAttemptTime()
    {
        String s = (new ItemCache(this)).getNameValue(NotificationPreferenceManager.makeKey(MyApp.getPrefs().getCurrentUser(), "LAST_UPGRADE_TS"));
        long l;
        if (!TextUtils.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_41;
        }
        l = System.currentTimeMillis();
        setUpgradeLastAttemptTime(l);
        return l;
        long l1;
        try
        {
            l1 = Long.parseLong(s);
        }
        catch (Exception exception)
        {
            return 0L;
        }
        return l1;
    }

    private void handleEbayResponseErrors(com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException ebayrequesterrorexception)
    {
        if (userNotLoggedIn(ebayrequesterrorexception.getErrors()) && MyApp.getPrefs().isSignedIn())
        {
            MyApp.signOutForIafTokenFailure(null);
        }
    }

    protected static final boolean isSavedSearchPollingWindowOpen(Calendar calendar, Calendar calendar1, int i)
    {
        if (i < 0 || i > 100)
        {
            throw new IllegalArgumentException("invalid jitter value");
        }
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        calendar2.add(10, 12);
        if (!calendar1.before(calendar2))
        {
            calendar = Calendar.getInstance();
            Calendar calendar3 = Calendar.getInstance();
            calendar.setTimeInMillis(calendar1.getTimeInMillis());
            calendar.set(10, 6);
            calendar.set(12, 0);
            calendar.set(13, 0);
            calendar.set(14, 0);
            calendar.add(12, i * 2);
            calendar3.setTimeInMillis(calendar.getTimeInMillis());
            calendar3.add(10, 2);
            if (calendar.before(calendar1) && calendar3.after(calendar1))
            {
                return true;
            }
        }
        return false;
    }

    private void killLocalNotificationsAlarm()
    {
        ((AlarmManager)getSystemService("alarm")).cancel(getLocalNotificationsAlarmIntent(this));
    }

    private void killPollAlarm()
    {
        AlarmManager alarmmanager = (AlarmManager)getSystemService("alarm");
        Intent intent = new Intent(this, com/ebay/mobile/notifications/PollAlarmReceiver);
        intent.setAction("com.ebay.mobile.service.DO_POLL");
        alarmmanager.cancel(PendingIntent.getBroadcast(this, 0, intent, 0));
    }

    private static void log(String s)
    {
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("PollService ").append(s).toString());
        }
    }

    private void pollAlerts2()
    {
        long l = System.currentTimeMillis();
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "PollService pollAlerts2: Polling client alerts?");
        }
        ArrayList arraylist = new ArrayList();
        log("pollAlerts2, We need to poll!");
        boolean flag = false;
        if (MyApp.getPrefs().isSignedIn())
        {
            boolean flag1 = pollClientAlerts(arraylist);
            flag = flag1;
            if (!flag1)
            {
                log("pollAlerts2: Unsuccessful poll");
                flag = flag1;
            }
        }
        if (!flag)
        {
            Log.w("PollService", "pollAlerts2: Polling unsuccesful, reset and hope for the best on the next poll");
            resetPollingPreferences();
        } else
        {
            createNotifications(arraylist);
            log((new StringBuilder()).append("pollAlerts2: after calling createNotifications, event count = ").append(arraylist.size()).toString());
        }
        log((new StringBuilder()).append("we just polled, saving last poll time: ").append((new Date(l)).toString()).toString());
        saveUserAndLastTime();
    }

    private boolean pollClientAlerts(ArrayList arraylist)
    {
        ClientAlertsAuthToken clientalertsauthtoken;
        boolean flag;
        log("Polling client alerts...");
        flag = true;
        clientalertsauthtoken = new ClientAlertsAuthToken();
        clientalertsauthtoken.token = sharedPrefs.getString("EBAY_CA_TOKEN", null);
        clientalertsauthtoken.expiry = sharedPrefs.getLong("EBAY_CA_TOKEN_EXPIRY", 0L);
        if (clientalertsauthtoken.isValid() && sameUser()) goto _L2; else goto _L1
_L1:
        log("Either no current CA token, token expired or user changed");
        clientalertsauthtoken = getCaToken();
        log("Got new CA token");
        if (clientalertsauthtoken == null) goto _L4; else goto _L3
_L3:
        if (clientalertsauthtoken.isValid()) goto _L5; else goto _L4
_L5:
        android.content.SharedPreferences.Editor editor = sharedPrefs.edit();
        Assert.assertNotNull("PollingService prefs editor should not be null!", editor);
        editor.putString("EBAY_CA_TOKEN", clientalertsauthtoken.token);
        editor.putLong("EBAY_CA_TOKEN_EXPIRY", clientalertsauthtoken.expiry);
        editor.putString("EBAY_CA_SESSION_USER", MyApp.getPrefs().getCurrentUser());
        SharedPreferencesCompat.apply(editor);
        log("Saved new CA token");
_L11:
        boolean flag1 = true;
        ClientAlertsSession clientalertssession = new ClientAlertsSession();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_260;
        }
        clientalertssession.id = sharedPrefs.getString("EBAY_CA_SESSION_ID", null);
        clientalertssession.data = sharedPrefs.getString("EBAY_CA_SESSION_DATA", null);
        clientalertssession.timestamp = sharedPrefs.getLong("EBAY_CA_SESSION_TS", 0L);
        if (!clientalertssession.isValid())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        log((new StringBuilder()).append("No new token needed, needNewSession=").append(flag1).toString());
        if (!flag1) goto _L7; else goto _L6
_L6:
        log("Need new CA session...");
        clientalertssession = ClientAlerts.login(getEbayContext(), clientalertsauthtoken.token);
        if (clientalertssession == null) goto _L9; else goto _L8
_L8:
        if (clientalertssession.isValid()) goto _L10; else goto _L9
_L9:
        Log.w("PollService", "Got null session, so bad token");
        return false;
_L2:
        log("Current CA token is valid");
        flag = false;
          goto _L11
_L10:
        log((new StringBuilder()).append("Got new CA session: ").append(clientalertssession.id).toString());
        clientalertssession.timestamp = System.currentTimeMillis();
        saveCaSession(clientalertssession);
        log((new StringBuilder()).append("Saved new CA session: ").append(clientalertssession.toString()).toString());
_L7:
        log("Getting current user alerts");
        arraylist.addAll(ClientAlerts.getUserAlerts(getEbayContext(), clientalertssession));
        if (arraylist.isEmpty()) goto _L13; else goto _L12
_L12:
        log((new StringBuilder()).append("GetUserAlerts #events=").append(arraylist.size()).toString());
        PlatformNotificationsEvent platformnotificationsevent;
        for (arraylist = arraylist.iterator(); arraylist.hasNext(); log((new StringBuilder()).append("Event from GetUserAlerts: ").append(platformnotificationsevent).toString()))
        {
            platformnotificationsevent = (PlatformNotificationsEvent)arraylist.next();
        }

          goto _L14
        arraylist;
        if (arraylist.getErrors() == null || arraylist.getErrors().size() != 1) goto _L16; else goto _L15
_L15:
        handleEbayResponseErrors(arraylist);
        if (!((EbayResponseError)arraylist.getErrors().get(0)).code.equals("11.3")) goto _L16; else goto _L17
_L17:
        saveCaSession(new ClientAlertsSession());
        return false;
_L13:
        log("GetUserAlerts returned null");
_L14:
        saveCaSession(clientalertssession);
        return true;
_L16:
        log("Got user alerts (events)");
_L18:
        return false;
        arraylist;
        if (arraylist.getErrors() != null)
        {
            EbayResponseError ebayresponseerror;
            for (Iterator iterator = arraylist.getErrors().iterator(); iterator.hasNext(); Log.w("PollService", (new StringBuilder()).append("Exception from API: ").append(ebayresponseerror.longMessage).toString(), arraylist))
            {
                ebayresponseerror = (EbayResponseError)iterator.next();
            }

            handleEbayResponseErrors(arraylist);
        }
        continue; /* Loop/switch isn't completed */
        arraylist;
        Log.w("PollService", "Exception getting CA user alerts", arraylist);
        if (true) goto _L18; else goto _L4
_L4:
        return false;
    }

    private void pollSavedSearch(long l)
        throws com.ebay.common.net.EbayRequestHelper.EbayRequestErrorException
    {
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "PollService Polling saved search? YES, we are polling");
        }
        PollServiceListCache.refreshSavedSearchListAndNewItemCounts(this, getEbayContext(), getIafToken(), l);
    }

    private void pollSymbanNotifications()
    {
        if (!DeviceConfiguration.getAsync().get(DcsBoolean.Symban))
        {
            return;
        }
        final SymbanDataManager symbanDataManager = (SymbanDataManager)DataManager.getIfExists(getEbayContext(), SymbanDataManager.KEY);
        if (symbanDataManager != null)
        {
            (new Handler(MyApp.getApp().getMainLooper())).post(new Runnable() {

                final PollService this$0;
                final SymbanDataManager val$symbanDataManager;

                public void run()
                {
                    symbanDataManager.reloadCount();
                }

            
            {
                this$0 = PollService.this;
                symbanDataManager = symbandatamanager;
                super();
            }
            });
        }
        EbayBroadcast.sendSymbanUpdateBroadcast(this);
    }

    private void resetPollingPreferences()
    {
        android.content.SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.clear();
        SharedPreferencesCompat.apply(editor);
    }

    private boolean sameUser()
    {
        boolean flag = true;
        if (getIafToken() != null)
        {
            flag = sharedPrefs.getString("EBAY_CA_SESSION_USER", "").equals(MyApp.getPrefs().getCurrentUser());
        }
        return flag;
    }

    private void saveCaSession(ClientAlertsSession clientalertssession)
    {
        android.content.SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString("EBAY_CA_SESSION_ID", clientalertssession.id);
        editor.putString("EBAY_CA_SESSION_DATA", clientalertssession.data);
        editor.putLong("EBAY_CA_SESSION_TS", clientalertssession.timestamp);
        SharedPreferencesCompat.apply(editor);
    }

    private void saveUserAndLastTime()
    {
        android.content.SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putLong("LAST_POLL_TS", System.currentTimeMillis());
        editor.putString("EBAY_CA_SESSION_USER", MyApp.getPrefs().getCurrentUser());
        SharedPreferencesCompat.apply(editor);
    }

    private static void scheduleLocalNotificationsAlarm(Context context, long l)
    {
        log("Local notifications alarm scheduled");
        ((AlarmManager)context.getSystemService("alarm")).set(0, l, getLocalNotificationsAlarmIntent(context));
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("PollService Scheduled local notification alarm to wake up at ").append((new Date(l)).toString()).toString());
        }
    }

    private static void schedulePollAlarm(Context context)
    {
        log("Poll alarm scheduled");
        AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
        Intent intent = new Intent(context, com/ebay/mobile/notifications/PollAlarmReceiver);
        intent.setAction("com.ebay.mobile.service.DO_POLL");
        context = PendingIntent.getBroadcast(context, 0, intent, 0);
        alarmmanager.setRepeating(2, SystemClock.elapsedRealtime() + 1L, 0x493e0L, context);
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "PollService Scheduled PollService for DO_POLL to run every 300000 ms");
        }
    }

    private static void scheduleWakeUpAlarm(Context context)
    {
        log("Wake up alarm scheduled");
        AlarmManager alarmmanager = (AlarmManager)context.getSystemService("alarm");
        Intent intent = new Intent(context, com/ebay/mobile/notifications/PollAlarmReceiver);
        intent.setAction("com.ebay.mobile.service.SET_PREFERENCES");
        context = PendingIntent.getBroadcast(context, 0, intent, 0);
        alarmmanager.set(2, SystemClock.elapsedRealtime() + 30000L, context);
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "PollService Scheduled PollService to wake up once in 30000 ms");
        }
    }

    private void setNextLocalNotificationsTimer(ItemCache itemcache)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        if (itemcache.isPollingForLocalNotificationsNecessary()) goto _L2; else goto _L1
_L1:
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "Local notifications db has 0 active items; no need to check these now");
        }
_L4:
        return;
_L2:
        String s = MyApp.getPrefs().getCurrentUser();
        if (notificationPrefs.isEventEnabled(s, com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHITM.name()) || notificationPrefs.isEventEnabled(s, com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM.name()) || notificationPrefs.isEventEnabled(s, com.ebay.common.model.mdns.NotificationPreference.EventType.SHOPCARTITM.name()))
        {
            break; /* Loop/switch isn't completed */
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "User does not want to be notified for watch/bid/cart ending soon");
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        long l;
        long l1;
        l1 = (Integer.valueOf("15").intValue() - 1) * 60 * 1000;
        long l2 = (Integer.valueOf("15").intValue() - 1) * 60 * 1000;
        long l3 = Integer.valueOf("15").intValue() * 60 * 1000;
        l = System.currentTimeMillis();
        l1 = itemcache.getLocalNotificationsNextAlarmTime(l, l1, l2, l3);
        if (l1 <= 0L || l1 != l) goto _L6; else goto _L5
_L5:
        scheduleLocalNotificationsAlarm(this, System.currentTimeMillis() + 5000L);
_L8:
        itemcache.deleteEndedLocalNotificationsItem();
        itemcache.setPollingPreferencesForLocalNotifications();
        return;
_L6:
        if (l1 > 0L && l1 > System.currentTimeMillis())
        {
            scheduleLocalNotificationsAlarm(this, l1);
        } else
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("Next potential item ends at ").append(l1).append(" which is greater than our next poll interval, not setting single timer").toString());
        }
        if (true) goto _L8; else goto _L7
_L7:
    }

    private void setSavedSearchLastPollTime(long l)
    {
        (new ItemCache(this)).setNameValue(NotificationPreferenceManager.makeKey(MyApp.getPrefs().getCurrentUser(), "SS_LAST_POLL_TS"), String.valueOf(l));
    }

    private void setUpgradeLastAttemptTime(long l)
    {
        (new ItemCache(this)).setNameValue(NotificationPreferenceManager.makeKey(MyApp.getPrefs().getCurrentUser(), "LAST_UPGRADE_TS"), String.valueOf(l));
    }

    private boolean shouldPoll2()
    {
        log("shouldPoll2: Determining if we should poll");
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication == null)
        {
            return false;
        }
        if (EbayUtil.isPushActive(getApplicationContext(), authentication.user, "AEAPP"))
        {
            log("We are registered with MDNS, no polling for notifications");
            return false;
        }
        boolean flag = Util.hasNetwork();
        log((new StringBuilder()).append("shouldPoll2: gotNetwork?").append(flag).toString());
        if (flag && getIafToken() != null)
        {
            if (!sameUser())
            {
                log("shouldPoll2: user changed, force polling!");
                return true;
            }
            log("shouldPoll2: Got net work and user logged in, checking schedule");
            long l1 = sharedPrefs.getLong("LAST_POLL_TS", 0L);
            log((new StringBuilder()).append("shouldPoll2: last poll time is ").append((new Date(l1)).toString()).toString());
            String s = MyApp.getPrefs().getCurrentUser();
            long l;
            boolean flag1;
            boolean flag2;
            if (notificationPrefs.isOutbidOrBidEndingOrWatchedEndingEnabled(s))
            {
                l = 0x493e0L;
            } else
            {
                l = 0x5265c0L;
            }
            log((new StringBuilder()).append("shouldPoll2: interval is ").append(l).toString());
            if (System.currentTimeMillis() >= l1 + l)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            flag2 = flag1;
            if (!flag1)
            {
                if (System.currentTimeMillis() >= (l1 + l) - l / 10L)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                flag2 = flag1;
                if (flag1)
                {
                    log("shouldPoll2: within threshold of fuzzy time, changing to should poll");
                    flag2 = flag1;
                }
            }
            log((new StringBuilder()).append("shouldPoll2: need to poll ? ").append(flag2).toString());
            return flag2;
        } else
        {
            log("shouldPoll2: Either no network or user not logged in, so no polling");
            return false;
        }
    }

    private boolean shouldPollSavedSearch(Calendar calendar)
    {
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "PollService shouldPollSavedSearch: Determining if we should poll");
        }
        if (DeviceConfiguration.getAsync().get(DcsBoolean.savedSearchPolling)) goto _L2; else goto _L1
_L1:
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "PollServiceshouldPollSavedSearch: DCS disabled");
        }
_L4:
        return false;
_L2:
        if (Util.hasNetwork())
        {
            break; /* Loop/switch isn't completed */
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "PollService shouldPollSavedSearch: no network, do no poll");
            return false;
        }
        if (true) goto _L4; else goto _L3
_L3:
        ArrayList arraylist = notificationPrefs.getNotifyEnabledSavedSearchIdList(MyApp.getPrefs().getCurrentUser());
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("PollService shouldPollSavedSearch: # of notify-enabled SS: ").append(arraylist.size()).toString());
        }
        if (arraylist.isEmpty())
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "PollService shouldPollSavedSearch: do not poll, 0 notify-enabled SS");
                return false;
            }
        } else
        {
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTimeInMillis(getSavedSearchLastPollTime());
            return isSavedSearchPollingWindowOpen(calendar1, calendar, DeviceConfiguration.getNoSync().getState().rolloutThreshold);
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    private boolean shouldTryUpgrade()
    {
        boolean flag4 = true;
        log("shouldTryUpgrade: Determining if we should try to upgrade notification platform");
        boolean flag = true;
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication == null)
        {
            return false;
        }
        if (EbayUtil.isPushActive(getApplicationContext(), authentication.user, "AEAPP"))
        {
            flag = false;
        }
        boolean flag3 = flag;
        if (flag)
        {
            DeviceConfiguration deviceconfiguration = DeviceConfiguration.getAsync();
            boolean flag1;
            boolean flag2;
            if (!EbaySmartNotificationManager.isGCMSupportOnDevice(this) || !deviceconfiguration.get(DcsBoolean.GCM))
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (flag1)
            {
                log("shouldTryUpgrade: We are polling but GCM not available on device or DCS disabled");
            }
            if (EbayUtil.deviceSupportsC2dm() && (EbaySmartNotificationManager.canIgnoreC2DMStateViaDCS() || deviceconfiguration.get(DcsBoolean.C2DM)))
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            if (flag2)
            {
                log("shouldTryUpgrade: We are polling but C2DM not available on device or DCS disabled");
            }
            flag3 = flag;
            if (flag1)
            {
                flag3 = flag;
                if (flag2)
                {
                    flag3 = false;
                }
            }
        }
        if (!flag3)
        {
            setUpgradeLastAttemptTime(System.currentTimeMillis());
            return false;
        }
        boolean flag5 = Util.hasNetwork();
        log((new StringBuilder()).append("shouldTryUpgrade: gotNetwork?").append(flag5).toString());
        if (flag5 && getIafToken() != null)
        {
            log("shouldTryUpgrade: Got net work and user logged in, checking schedule");
            long l = getUpgradeLastAttemptTime();
            log((new StringBuilder()).append("shouldTryUpgrade: last upgrade time is ").append((new Date(l)).toString()).toString());
            if (System.currentTimeMillis() < 0x5265c00L + l)
            {
                flag4 = false;
            }
            log((new StringBuilder()).append("shouldTryUpgrade: need to attempt upgrade ? ").append(flag4).toString());
            return flag4;
        } else
        {
            log("shouldTryUpgrade: Either no network or user not logged in, so no upgrade notification platform");
            return false;
        }
    }

    private void surfaceLocalNotifications(ItemCache itemcache)
    {
        if (logTag.isLoggable)
        {
            FwLog.logMethod(logTag, new Object[0]);
        }
        if (!itemcache.isPollingForLocalNotificationsNecessary())
        {
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "Local notifications db has 0 active items; no need to check these now");
            }
        } else
        {
            String s = MyApp.getPrefs().getCurrentUser();
            if (!notificationPrefs.isEventEnabled(s, com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHITM.name()) && !notificationPrefs.isEventEnabled(s, com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM.name()) && !notificationPrefs.isEventEnabled(s, com.ebay.common.model.mdns.NotificationPreference.EventType.SHOPCARTITM.name()))
            {
                if (logTag.isLoggable)
                {
                    FwLog.println(logTag, "User does not want to be notified for watch/bid/cart ending soon");
                    return;
                }
            } else
            {
                long l = (Integer.valueOf("15").intValue() - 1) * 60 * 1000;
                long l1 = (Integer.valueOf("15").intValue() - 1) * 60 * 1000;
                long l2 = Integer.valueOf("15").intValue() * 60 * 1000;
                long al[] = new long[3];
                al[0] = l;
                al[1] = l1;
                al[2] = l2;
                String as[] = new String[3];
                as[0] = com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHITM.name();
                as[1] = com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM.name();
                as[2] = com.ebay.common.model.mdns.NotificationPreference.EventType.SHOPCARTITM.name();
                int i = 0;
                while (i < as.length) 
                {
                    Object obj = itemcache.getLocalNotificationsItems(al[i], as[i], s);
                    if (obj == null || ((List) (obj)).size() == 0)
                    {
                        if (logTag.isLoggable)
                        {
                            FwLog.println(logTag, (new StringBuilder()).append("No potential items to notify for ").append(as[i]).append(" within interval ").append(al[i]).toString());
                        }
                    } else
                    {
                        if (logTag.isLoggable)
                        {
                            FwLog.println(logTag, (new StringBuilder()).append("Found ").append(((List) (obj)).size()).append(" potential items to notify user for ").append(as[i]).toString());
                        }
                        createLocalNotifications(((List) (obj)));
                        obj = ((List) (obj)).iterator();
                        while (((Iterator) (obj)).hasNext()) 
                        {
                            itemcache.deleteLocalNotificationsItem(Long.parseLong(((PlatformNotificationsEvent)((Iterator) (obj)).next()).itemId));
                        }
                    }
                    i++;
                }
                itemcache.deleteEndedLocalNotificationsItem();
                itemcache.setPollingPreferencesForLocalNotifications();
                return;
            }
        }
    }

    private boolean userNotLoggedIn(List list)
    {
        if (list != null && !list.isEmpty()) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                continue;
            }
            switch (((EbayResponseError)list.next()).getId())
            {
            case 21916945: 
            case 21916984: 
            case 21917053: 
                return true;
            }
        } while (true);
          goto _L3
        if (true) goto _L1; else goto _L3
_L3:
    }

    protected void onHandleIntent(Intent intent)
    {
        Object obj1 = intent.getAction();
        Object obj = obj1;
        if (!TextUtils.isEmpty(((CharSequence) (obj1))))
        {
            break MISSING_BLOCK_LABEL_23;
        }
        log("onHandleIntent action empty, assuming DO_POLL");
        obj = "com.ebay.mobile.service.DO_POLL";
        log((new StringBuilder()).append("onHandleIntent action=").append(((String) (obj))).toString());
        if (!((String) (obj)).equalsIgnoreCase("com.ebay.mobile.service.DISABLE_POLLING"))
        {
            break MISSING_BLOCK_LABEL_73;
        }
        log("Disabling polling; exiting");
        killPollAlarm();
        killLocalNotificationsAlarm();
        SharedWakeLock.releaseLock();
        return;
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication != null)
        {
            break MISSING_BLOCK_LABEL_96;
        }
        log("onHandleIntent, no authenticated user, returning");
        SharedWakeLock.releaseLock();
        return;
        Calendar calendar;
        DeviceConfiguration deviceconfiguration;
        calendar = Calendar.getInstance();
        sharedPrefs = getPollServicePrefs();
        notificationPrefs = new NotificationPreferenceManager(this);
        obj1 = new ItemCache(this);
        deviceconfiguration = DeviceConfiguration.getAsync();
        if (!deviceconfiguration.get(DcsBoolean.KillSwitch))
        {
            break MISSING_BLOCK_LABEL_164;
        }
        log("onHandleIntent: kill switch enabled, killing poll alarm");
        killPollAlarm();
        killLocalNotificationsAlarm();
        SharedWakeLock.releaseLock();
        return;
        if (!((String) (obj)).equalsIgnoreCase("com.ebay.mobile.service.WAKE_UP_SOON"))
        {
            break MISSING_BLOCK_LABEL_181;
        }
        scheduleWakeUpAlarm(this);
        SharedWakeLock.releaseLock();
        return;
        if (!((String) (obj)).equalsIgnoreCase("com.ebay.mobile.service.ENABLE_POLLING"))
        {
            break MISSING_BLOCK_LABEL_204;
        }
        log("Enabling polling");
        schedulePollAlarm(this);
        SharedWakeLock.releaseLock();
        return;
        if (!((String) (obj)).equalsIgnoreCase("com.ebay.mobile.service.LOCAL_NOTIFICATIONS"))
        {
            break MISSING_BLOCK_LABEL_244;
        }
        if (deviceconfiguration.get(DcsBoolean.LocalNotifications))
        {
            log("Local notifications alarm called");
            surfaceLocalNotifications(((ItemCache) (obj1)));
            setNextLocalNotificationsTimer(((ItemCache) (obj1)));
        }
        SharedWakeLock.releaseLock();
        return;
        if (!((String) (obj)).equalsIgnoreCase("com.ebay.mobile.service.RESET_LOCAL_NOTIFICATIONS_TIMER"))
        {
            break MISSING_BLOCK_LABEL_273;
        }
        if (deviceconfiguration.get(DcsBoolean.LocalNotifications))
        {
            setNextLocalNotificationsTimer(((ItemCache) (obj1)));
        }
        SharedWakeLock.releaseLock();
        return;
        if (!((String) (obj)).equalsIgnoreCase("com.ebay.mobile.service.UPDATE_LOCAL_NOTIFICATIONS_CART"))
        {
            break MISSING_BLOCK_LABEL_317;
        }
        if (!deviceconfiguration.get(DcsBoolean.LocalNotifications))
        {
            break MISSING_BLOCK_LABEL_313;
        }
        intent = intent.getExtras();
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        ((ItemCache) (obj1)).addShoppingCartListToLocalNotificationsDatabase(intent.getParcelableArrayList("cart_item_ending_events"));
        SharedWakeLock.releaseLock();
        return;
        if (!((String) (obj)).equalsIgnoreCase("com.ebay.mobile.service.ADD_ITEM_LOCAL_NOTIFICATIONS_CART"))
        {
            break MISSING_BLOCK_LABEL_364;
        }
        if (!deviceconfiguration.get(DcsBoolean.LocalNotifications))
        {
            break MISSING_BLOCK_LABEL_360;
        }
        intent = intent.getExtras();
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        ((ItemCache) (obj1)).addShoppingCartListToLocalNotificationsDatabase((com.ebay.common.model.mdns.PlatformNotificationsEvent.CartItemEndingEvent)intent.getParcelable("cart_item_ending_events"));
        SharedWakeLock.releaseLock();
        return;
        if (!((String) (obj)).equalsIgnoreCase("com.ebay.mobile.service.ADD_MY_EBAY_ITEMS_TO_LOCAL_NOTIFICATIONS"))
        {
            break MISSING_BLOCK_LABEL_428;
        }
        if (!deviceconfiguration.get(DcsBoolean.LocalNotifications))
        {
            break MISSING_BLOCK_LABEL_424;
        }
        intent = intent.getExtras();
        if (intent == null)
        {
            break MISSING_BLOCK_LABEL_424;
        }
        int i;
        obj = intent.getParcelableArrayList("my_ebay_items");
        i = intent.getInt("my_ebay_list_type", -1);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_424;
        }
        ((ItemCache) (obj1)).addMyEbayListToLocalNotificationsDatabase(((List) (obj)), i);
        SharedWakeLock.releaseLock();
        return;
        if (!((String) (obj)).equalsIgnoreCase("com.ebay.mobile.service.SET_PREFERENCES"))
        {
            break MISSING_BLOCK_LABEL_557;
        }
        if (!EbayUtil.isPushActive(this, authentication.user, "AEAPP"))
        {
            break MISSING_BLOCK_LABEL_462;
        }
        log("Woke up after WAKE_UP_SOON and found MDNS under the tree; ignoring SET_PREFERENCES request");
        SharedWakeLock.releaseLock();
        return;
        schedulePollAlarm(this);
        ((ItemCache) (obj1)).resetSettingsLoadingState();
        log("onHandleIntent: set loading state busy ");
        NotificationUtil.loadClientAlertPreferences(this);
        ((ItemCache) (obj1)).setSettingsLoadingReady();
        if (deviceconfiguration.get(DcsBoolean.NotificationTracking))
        {
            NotificationTrackingUtil.sendEvent(this, NotificationTrackingUtil.createNotificationModeChangeTrackingData("0"));
        }
        intent = new Bundle();
        intent.putSerializable("type", EbaySmartNotificationManager.NotificationType.POLL);
        ServiceStarter.instructNotificationManagerService(this, 4, intent);
_L2:
        SharedWakeLock.releaseLock();
        return;
        intent;
        Log.w("PollService", "Exception setting client alerts", intent);
        if (true) goto _L2; else goto _L1
_L1:
        intent;
        handleEbayResponseErrors(intent);
        SharedWakeLock.releaseLock();
        return;
        if (!((String) (obj)).equalsIgnoreCase("com.ebay.mobile.service.DISABLE_NOTIFICATIONS"))
        {
            break MISSING_BLOCK_LABEL_580;
        }
        log("Handling disable notifications request");
        resetPollingPreferences();
        SharedWakeLock.releaseLock();
        return;
        if (!TextUtils.isEmpty(getIafToken()))
        {
            break MISSING_BLOCK_LABEL_600;
        }
        log("user not signed in, do not poll");
        SharedWakeLock.releaseLock();
        return;
        if (shouldPollSavedSearch(calendar))
        {
            setSavedSearchLastPollTime(calendar.getTimeInMillis());
            pollSavedSearch(calendar.getTimeInMillis());
        }
        if (((ItemCache) (obj1)).isSettingsLoaded()) goto _L4; else goto _L3
_L3:
        Log.w("PollService", (new StringBuilder()).append("loadClientAlertPreferences has not finished yet, skip this action: ").append(((String) (obj))).toString());
_L6:
        boolean flag;
        if (!deviceconfiguration.get(DcsBoolean.LocalNotifications))
        {
            break MISSING_BLOCK_LABEL_743;
        }
        flag = TextUtils.isEmpty(getIafToken());
        if (flag)
        {
            SharedWakeLock.releaseLock();
            return;
        }
        break MISSING_BLOCK_LABEL_738;
_L4:
        if (!notificationPrefs.isNotificationEnabled(MyApp.getPrefs().getCurrentUser()) || !shouldPoll2()) goto _L6; else goto _L5
_L5:
        pollAlerts2();
        pollSymbanNotifications();
          goto _L6
        intent;
        logTag.logAsError("PollService exception", intent);
        SharedWakeLock.releaseLock();
        return;
        setNextLocalNotificationsTimer(((ItemCache) (obj1)));
        if (!EbayUtil.isPushActive(this, authentication.user, "AEAPP") && shouldTryUpgrade())
        {
            setUpgradeLastAttemptTime(System.currentTimeMillis());
            ServiceStarter.instructNotificationManagerService(this, 1);
        }
        SharedWakeLock.releaseLock();
        return;
        intent;
        SharedWakeLock.releaseLock();
        throw intent;
    }

}
