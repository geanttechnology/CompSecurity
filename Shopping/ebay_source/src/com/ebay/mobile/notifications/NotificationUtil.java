// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import com.ebay.common.Preferences;
import com.ebay.common.content.dm.FollowedEntityDataManager;
import com.ebay.common.model.mdns.NotificationPreference;
import com.ebay.common.net.api.mdns.EbayMdnsApi;
import com.ebay.common.net.api.trading.EbayTradingApiHelper;
import com.ebay.common.util.EnvironmentUtils;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.ServiceStarter;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.mobile.search.SearchUtil;
import com.ebay.mobile.util.EbayApiUtil;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.app.Authentication;
import com.ebay.nautilus.domain.data.NameValue;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.domain.net.EbayResponse;
import com.ebay.nautilus.domain.net.EbayResponseError;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.ebay.nautilus.kernel.content.ResultStatus;
import com.ebay.nautilus.kernel.util.FwLog;
import com.ebay.nautilus.shell.app.BaseIntentService;
import com.ebay.nautilus.shell.app.FwContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

// Referenced classes of package com.ebay.mobile.notifications:
//            NotificationPreferenceManager, ItemCache, EbaySmartNotificationManager

public class NotificationUtil
{
    public static class NotificationModule
    {

        public final Authentication auth;
        public final String clientId;
        public final String metaCategories;
        public final EbaySmartNotificationManager.NotificationType type;

        public SubscriptionArgs asSubscriptionArgs(Context context)
        {
            return NotificationUtil.checkAndGetArgs(context, auth, clientId, metaCategories, type);
        }

        public NotificationModule(String s, Authentication authentication, String s1, EbaySmartNotificationManager.NotificationType notificationtype)
        {
            clientId = s;
            auth = authentication;
            metaCategories = s1;
            type = notificationtype;
        }
    }

    private static final class SetClientAlertAsyncTask extends AsyncTask
    {

        protected transient Boolean doInBackground(Object aobj[])
        {
            Context context;
            Authentication authentication;
            context = (Context)aobj[0];
            aobj = (EbayContext)aobj[1];
            authentication = MyApp.getPrefs().getAuthentication();
            if (authentication == null)
            {
                break MISSING_BLOCK_LABEL_104;
            }
            NotificationPreferenceManager notificationpreferencemanager = new NotificationPreferenceManager(context);
            EbayTradingApiHelper.setClientAlertsPreferences(((EbayContext) (aobj)), EbayApiUtil.getTradingApi(context, authentication), NotificationUtil.buildClientAlertNames(notificationpreferencemanager, authentication.user), NotificationUtil.getWatchedTimeLeft(notificationpreferencemanager, authentication.user), NotificationUtil.getBidTimeLeft(notificationpreferencemanager, authentication.user));
            if (NotificationUtil.logTag.isLoggable)
            {
                FwLog.println(NotificationUtil.logTag, "setClientAlertPreferences: Client alerts preferences set");
            }
            return Boolean.valueOf(true);
            aobj;
            Log.w("NotificationUtil", "SetClientAlertAsyncTask: Exception setting client alerts", ((Throwable) (aobj)));
            return Boolean.valueOf(false);
        }

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground(aobj);
        }

        protected void onPostExecute(Boolean boolean1)
        {
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((Boolean)obj);
        }

        private SetClientAlertAsyncTask()
        {
        }

    }

    private static class SubscriptionArgs
    {

        public String clientId;
        public String iafToken;
        public String language;
        public String metaCategories;
        public EbaySmartNotificationManager.NotificationType notificationType;
        public String regId;
        public EbaySite site;
        public String userId;

        SubscriptionArgs(String s, String s1, String s2, String s3, String s4, String s5, EbaySmartNotificationManager.NotificationType notificationtype, 
                EbaySite ebaysite)
        {
            iafToken = s;
            userId = s1;
            regId = s2;
            language = s3;
            clientId = s4;
            metaCategories = s5;
            notificationType = notificationtype;
            site = ebaysite;
        }
    }


    private static final String LOG_TAG = "NotificationUtil";
    public static final String MOTORS_META_CATEGORIES = "6000";
    protected static final com.ebay.nautilus.kernel.util.FwLog.LogInfo logTag = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("NotificationUtil", 3, "Log NotificationUtil info");

    public NotificationUtil()
    {
    }

    public static boolean activateAndSetMdnsPrefs(Context context, EbaySmartNotificationManager.NotificationType notificationtype)
    {
        NotificationModule notificationmodule = new NotificationModule("AEAPP", MyApp.getPrefs().getAuthentication(), null, notificationtype);
        if (!"AEAPP".equals(notificationmodule.clientId))
        {
            warn((new StringBuilder()).append("activateAndSetMdnsPrefs: appCredentials null for ").append(notificationmodule.clientId).toString());
        } else
        {
            if (notificationmodule.auth == null)
            {
                warn((new StringBuilder()).append("activateAndSetMdnsPrefs: auth null for ").append(notificationmodule.clientId).toString());
            }
            if (activateModule(context, notificationmodule))
            {
                ServiceStarter.instructNotificationManagerService(context, 3);
                Bundle bundle = new Bundle();
                bundle.putSerializable("type", notificationtype);
                ServiceStarter.instructNotificationManagerService(context, 4, bundle);
                return true;
            }
        }
        return false;
    }

    protected static boolean activateModule(Context context, NotificationModule notificationmodule)
    {
        SubscriptionArgs subscriptionargs;
        FwLog.logMethod(logTag, new Object[0]);
        subscriptionargs = notificationmodule.asSubscriptionArgs(context);
        if (subscriptionargs != null) goto _L2; else goto _L1
_L1:
        boolean flag;
        logTag.log("activateModule: checkAndGetArgs returned null, failing");
        flag = false;
_L10:
        return flag;
_L2:
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag3 = false;
        flag4 = false;
        flag = false;
        flag1 = flag3;
        flag2 = flag4;
        String s = getClientIdForNotificationType(notificationmodule.type, notificationmodule.clientId);
        flag1 = flag3;
        flag2 = flag4;
        NotificationPreferenceManager notificationpreferencemanager = new NotificationPreferenceManager(context);
        flag1 = flag3;
        flag2 = flag4;
        if (!notificationpreferencemanager.isUserActiveWithMdns(subscriptionargs.userId, s))
        {
            break MISSING_BLOCK_LABEL_120;
        }
        flag1 = flag3;
        flag2 = flag4;
        logTag.log("User is activated already, return");
        return true;
        flag1 = flag3;
        flag2 = flag4;
        EbayMdnsApi ebaymdnsapi = new EbayMdnsApi(((FwContext)context).getEbayContext());
        flag1 = flag3;
        flag2 = flag4;
        if (notificationpreferencemanager.hasPushSettings(subscriptionargs.userId, notificationmodule.clientId)) goto _L4; else goto _L3
_L3:
        flag1 = flag3;
        flag2 = flag4;
        if (!notificationpreferencemanager.hasPollingSettings(subscriptionargs.userId)) goto _L6; else goto _L5
_L5:
        flag1 = flag3;
        flag2 = flag4;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_223;
        }
        flag1 = flag3;
        flag2 = flag4;
        FwLog.println(logTag, "Migrating POLL preferences to MDNS and saving to server.");
        flag1 = flag3;
        flag2 = flag4;
        context = migratePollPrefsToMdns(notificationpreferencemanager, subscriptionargs.userId, notificationmodule);
_L8:
        flag1 = flag3;
        flag2 = flag4;
        if (!setMdnsSubscriptions(ebaymdnsapi, subscriptionargs, context))
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag3;
        flag2 = flag4;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_313;
        }
        flag1 = flag3;
        flag2 = flag4;
        FwLog.println(logTag, (new StringBuilder()).append("Successfully sent MDNS settings to the server clientId=").append(notificationmodule.clientId).toString());
        flag1 = flag3;
        flag2 = flag4;
        context = getClientIdForNotificationType(subscriptionargs.notificationType, subscriptionargs.clientId);
        flag1 = flag3;
        flag2 = flag4;
        flag3 = ebaymdnsapi.activateUserOnDevice(subscriptionargs.iafToken, subscriptionargs.userId, subscriptionargs.regId, subscriptionargs.language, context, subscriptionargs.metaCategories, subscriptionargs.site);
        if (!flag3)
        {
            break; /* Loop/switch isn't completed */
        }
        flag1 = flag3;
        flag2 = flag3;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_428;
        }
        flag1 = flag3;
        flag2 = flag3;
        FwLog.println(logTag, (new StringBuilder()).append("User was activated successfully clientId=").append(s).toString());
        flag1 = flag3;
        flag2 = flag3;
        notificationpreferencemanager.setActiveWithMdns(subscriptionargs.userId, s);
        return flag3;
_L6:
        flag1 = flag3;
        flag2 = flag4;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_570;
        }
        flag1 = flag3;
        flag2 = flag4;
        FwLog.println(logTag, "Initializing MDNS preferences to defaults and saving to server.");
        flag1 = flag3;
        flag2 = flag4;
        try
        {
            context = buildAndSaveDefaultPreferences(context, subscriptionargs.userId, notificationmodule);
            continue; /* Loop/switch isn't completed */
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            flag = flag1;
            if (context.getErrors() == null)
            {
                continue; /* Loop/switch isn't completed */
            }
            context = context.getErrors().iterator();
            do
            {
                flag = flag1;
                if (!context.hasNext())
                {
                    continue; /* Loop/switch isn't completed */
                }
                notificationmodule = (EbayResponseError)context.next();
                if (logTag.isLoggable)
                {
                    FwLog.println(logTag, (new StringBuilder()).append("activateAndSetMdnsPrefs error: ").append(notificationmodule.toString()).toString());
                }
                handleEbayResponseErrors(notificationmodule, true);
            } while (true);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            flag = flag2;
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "activateAndSetMdnsPrefs: Exception calling activateAndGet: ", context);
                return flag2;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        flag1 = flag3;
        flag2 = flag4;
        context = buildPreferences(context, subscriptionargs.userId, null);
        if (true) goto _L8; else goto _L7
_L7:
        flag = flag3;
        flag1 = flag3;
        flag2 = flag3;
        if (!logTag.isLoggable)
        {
            continue; /* Loop/switch isn't completed */
        }
        flag1 = flag3;
        flag2 = flag3;
        FwLog.println(logTag, (new StringBuilder()).append("activateUserOnDevice failed for clientId=").append(s).toString());
        return flag3;
        if (true) goto _L10; else goto _L9
_L9:
        flag1 = flag3;
        flag2 = flag4;
        if (!logTag.isLoggable) goto _L10; else goto _L11
_L11:
        flag1 = flag3;
        flag2 = flag4;
        FwLog.println(logTag, (new StringBuilder()).append("Failed to send MDNS settings to the server clientId=").append(s).toString());
        return false;
    }

    private static List buildAndSaveDefaultClientAlertNames(NotificationPreferenceManager notificationpreferencemanager, String s)
    {
        ArrayList arraylist = new ArrayList();
        com.ebay.common.model.mdns.NotificationPreference.AlertType aalerttype[] = com.ebay.common.model.mdns.NotificationPreference.AlertType.values();
        int j = aalerttype.length;
        for (int i = 0; i < j; i++)
        {
            com.ebay.common.model.mdns.NotificationPreference.AlertType alerttype = aalerttype[i];
            if (!alerttype.supported || !alerttype.defaultValue)
            {
                continue;
            }
            arraylist.add(alerttype.name());
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("buildAndSaveDefaultClientAlertNames: alert default enabled, name: ").append(alerttype.name()).toString());
            }
            notificationpreferencemanager.setEventEnabled(s, NotificationPreference.clientAlertNameToEventName(alerttype.name()), true);
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("buildAndSaveDefaultClientAlertNames: alert default enabled snd saved to shared pref, name: ").append(alerttype.name()).toString());
            }
        }

        return arraylist;
    }

    private static List buildAndSaveDefaultPreferences(Context context, String s, NotificationModule notificationmodule)
    {
        ArrayList arraylist = new ArrayList();
        context = new NotificationPreferenceManager(context);
        com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[] = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
        int j = aeventtype.length;
        for (int i = 0; i < j; i++)
        {
            com.ebay.common.model.mdns.NotificationPreference.EventType eventtype = aeventtype[i];
            if (!eventtype.supported)
            {
                continue;
            }
            NotificationPreference notificationpreference = new NotificationPreference();
            notificationpreference.eventType = eventtype.name();
            notificationpreference.isEnabled = eventtype.defaultValue;
            if (eventtype.id == 2)
            {
                notificationpreference.properties = new ArrayList(1);
                notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.EnableSavedSearches.name(), Boolean.toString(true)));
            }
            if (eventtype.id == 1)
            {
                notificationpreference.properties = new ArrayList(1);
                notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name(), "15"));
            }
            if (eventtype.id == 17)
            {
                notificationpreference.properties = new ArrayList(1);
                notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name(), "15"));
            }
            if (eventtype.id == 35)
            {
                notificationpreference.properties = new ArrayList(1);
                notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name(), "15"));
            }
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("buildAndSaveDefaultPreferences: pref default enabled and saved to shared pref, type: ").append(notificationpreference.eventType).toString());
            }
            arraylist.add(notificationpreference);
            if (eventtype.id != 2)
            {
                context.setEventEnabled(s, eventtype.name(), notificationpreference.isEnabled);
            }
        }

        context.putHasPushSettings(s, notificationmodule.clientId);
        return arraylist;
    }

    protected static List buildClientAlertNames(NotificationPreferenceManager notificationpreferencemanager, String s)
    {
        ArrayList arraylist = new ArrayList();
        com.ebay.common.model.mdns.NotificationPreference.AlertType aalerttype[] = com.ebay.common.model.mdns.NotificationPreference.AlertType.values();
        int j = aalerttype.length;
        for (int i = 0; i < j; i++)
        {
            com.ebay.common.model.mdns.NotificationPreference.AlertType alerttype = aalerttype[i];
            if (alerttype.supported && notificationpreferencemanager.isEventEnabled(s, NotificationPreference.idToName(alerttype.id)))
            {
                arraylist.add(alerttype.name());
            }
        }

        return arraylist;
    }

    private static void buildForSavedSearch(Context context, List list, NotificationPreference notificationpreference)
    {
        context = (new ItemCache(context)).getSavedSearches();
        if (useFollowForSavedSearch())
        {
            context = Collections.emptySet();
        } else
        {
            context = context.keySet();
        }
        notificationpreference.properties = new ArrayList();
        notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.EnableSavedSearches.name(), "true"));
        if (!useFollowForSavedSearch())
        {
            if (list != null && !list.isEmpty())
            {
                String s = EbayUtil.flattenString(list, ",");
                notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.EnabledSavedSearchIds.name(), s));
                if (logTag.isLoggable)
                {
                    FwLog.println(logTag, (new StringBuilder()).append("buildPreferences: SVDSRCH - EnabledSavedSearchIds: ").append(s).toString());
                }
                for (list = list.iterator(); list.hasNext(); context.remove(Long.valueOf(Long.parseLong((String)list.next())))) { }
            }
            if (!context.isEmpty())
            {
                list = new ArrayList();
                for (context = context.iterator(); context.hasNext(); list.add(((Long)context.next()).toString())) { }
                context = EbayUtil.flattenString(list, ",");
                notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.DisabledSavedSearchIds.name(), context));
                if (logTag.isLoggable)
                {
                    FwLog.println(logTag, (new StringBuilder()).append("buildPreferences: SVDSRCH - DisabledSavedSearchIds: ").append(context).toString());
                    return;
                }
            }
        }
    }

    private static List buildPreferences(Context context, String s, List list)
    {
        ArrayList arraylist;
        NotificationPreferenceManager notificationpreferencemanager;
        com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[];
        int i;
        int j;
        arraylist = new ArrayList();
        notificationpreferencemanager = new NotificationPreferenceManager(context);
        aeventtype = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
        j = aeventtype.length;
        i = 0;
_L9:
        if (i >= j) goto _L2; else goto _L1
_L1:
        Object obj;
        com.ebay.common.model.mdns.NotificationPreference.EventType eventtype;
        eventtype = aeventtype[i];
        obj = list;
        if (!eventtype.supported) goto _L4; else goto _L3
_L3:
        NotificationPreference notificationpreference;
        boolean flag = notificationpreferencemanager.isEventEnabled(s, eventtype.name());
        notificationpreference = new NotificationPreference();
        notificationpreference.eventType = eventtype.name();
        notificationpreference.isEnabled = flag;
        notificationpreference.deliveryPolicyType = eventtype.deliveryPolicyType;
        if (eventtype.id != 1) goto _L6; else goto _L5
_L5:
        notificationpreference.properties = new ArrayList(1);
        notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name(), "15"));
        obj = list;
_L7:
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("buildPreferences:  pref enabled, type: ").append(notificationpreference.eventType).toString());
        }
        arraylist.add(notificationpreference);
_L4:
        i++;
        list = ((List) (obj));
        continue; /* Loop/switch isn't completed */
_L6:
        if (eventtype.id == 17)
        {
            notificationpreference.properties = new ArrayList(1);
            notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name(), "15"));
            obj = list;
            continue; /* Loop/switch isn't completed */
        }
        if (eventtype.id == 35)
        {
            notificationpreference.properties = new ArrayList(1);
            notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name(), "15"));
            obj = list;
            continue; /* Loop/switch isn't completed */
        }
        if (eventtype.id == 2)
        {
            obj = list;
            if (list == null)
            {
                obj = notificationpreferencemanager.getNotifyEnabledSavedSearchIdList(s);
            }
            buildForSavedSearch(context, ((List) (obj)), notificationpreference);
            continue; /* Loop/switch isn't completed */
        }
        if (eventtype.id != 37)
        {
            obj = list;
            if (eventtype.id != 36)
            {
                continue; /* Loop/switch isn't completed */
            }
        }
        obj = list;
        if (!DeviceConfiguration.getAsync().get(DcsBoolean.Verticals_dealsNotifications))
        {
            obj = list;
            if (notificationpreference.isEnabled)
            {
                notificationpreferencemanager.setEventEnabled(s, eventtype.name(), false);
                notificationpreference.isEnabled = false;
                obj = list;
            }
        }
        if (true) goto _L7; else goto _L2
_L2:
        return arraylist;
        if (true) goto _L9; else goto _L8
_L8:
    }

    protected static SubscriptionArgs checkAndGetArgs(Context context, Authentication authentication, String s, String s1, EbaySmartNotificationManager.NotificationType notificationtype)
    {
        if (authentication == null)
        {
            warn("checkAndGetArgs: Not signed in, cannot call MDNS/clientAlert");
            return null;
        }
        String s2 = authentication.iafToken;
        if (s2 == null)
        {
            warn("checkAndGetArgs: No IAF Token, cannot call MDNS/clientAlert");
            return null;
        }
        authentication = authentication.user;
        if (authentication == null)
        {
            warn("checkAndGetArgs: No User ID, cannot call MDNS/clientAlert");
            return null;
        }
        context = new ItemCache(context);
        String s3;
        if (notificationtype == EbaySmartNotificationManager.NotificationType.GCM)
        {
            context = context.getGCMRegistrationId(authentication);
        } else
        if (notificationtype == EbaySmartNotificationManager.NotificationType.GOOGLE_NOW)
        {
            context = null;
        } else
        {
            context = context.getRegistrationId(authentication);
        }
        s3 = MyApp.getPrefs().getCurrentCountry().site.getLocale().toString().replaceAll("_", "-");
        if (s3 == null)
        {
            warn("checkAndGetArgs: No language, cannot deactivate MDNS/clientAlert");
            return null;
        }
        if (s == null)
        {
            warn("checkAndGetArgs: No client ID specified, cannot call MDNS/clientAlert");
            return null;
        } else
        {
            return new SubscriptionArgs(s2, authentication, context, s3, s, s1, notificationtype, MyApp.getPrefs().getCurrentSite());
        }
    }

    private static Authentication checkAndGetAuth()
    {
        Authentication authentication1 = MyApp.getPrefs().getAuthentication();
        Authentication authentication;
        if (authentication1 == null)
        {
            warn("checkAndGetAuth: Not signed in, cannot call MDNS/clientAlert");
            authentication = null;
        } else
        {
            if (authentication1.iafToken == null)
            {
                warn("checkAndGetAuth: No IAF Token, cannot call MDNS/clientAlert");
                return null;
            }
            authentication = authentication1;
            if (authentication1.user == null)
            {
                warn("checkAndGetAuth: No User ID, cannot call MDNS/clientAlert");
                return null;
            }
        }
        return authentication;
    }

    public static boolean deactivateMdns(Context context, EbaySmartNotificationManager.NotificationType notificationtype, Authentication authentication, String s, String s1)
    {
        authentication = new NotificationModule(s, authentication, null, notificationtype);
        if (authentication == null) goto _L2; else goto _L1
_L1:
        if (!"AEAPP".equals(((NotificationModule) (authentication)).clientId) && !"GOOGLENOW".equals(((NotificationModule) (authentication)).clientId))
        {
            warn((new StringBuilder()).append("deactivateMdns: appCredentials null for ").append(((NotificationModule) (authentication)).clientId).toString());
            return true;
        }
        if (((NotificationModule) (authentication)).auth == null)
        {
            warn((new StringBuilder()).append("deactivateMdns: auth null for ").append(((NotificationModule) (authentication)).clientId).toString());
            return true;
        }
        authentication = authentication.asSubscriptionArgs(context);
        if (authentication == null)
        {
            return true;
        }
        notificationtype = getClientIdForNotificationType(notificationtype, ((SubscriptionArgs) (authentication)).clientId);
        s = new NotificationPreferenceManager(context);
        s.setInactiveWithMdns(((SubscriptionArgs) (authentication)).userId, notificationtype);
        s.removeMdnsActivationTime(((SubscriptionArgs) (authentication)).userId, notificationtype);
        if ((new EbayMdnsApi(((FwContext)context).getEbayContext())).deactivateUserOnDevice(((SubscriptionArgs) (authentication)).iafToken, ((SubscriptionArgs) (authentication)).userId, ((SubscriptionArgs) (authentication)).regId, ((SubscriptionArgs) (authentication)).language, notificationtype, ((SubscriptionArgs) (authentication)).metaCategories, ((SubscriptionArgs) (authentication)).site, s1)) goto _L4; else goto _L3
_L3:
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("Failed to deactivateUserOnDevice for clientid=").append(notificationtype).toString());
        }
          goto _L5
_L4:
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("deactivateMdns: Deactivation complete! uid=").append(((SubscriptionArgs) (authentication)).userId).append(";regId=").append(((SubscriptionArgs) (authentication)).regId).append(";clientId=").append(notificationtype).toString());
        }
        return true;
        context;
        Log.w("NotificationUtil", "deactivateMdns: Request Error calling MDNS deactivate", context);
_L2:
        return false;
        context;
        Log.w("NotificationUtil", "deactivateMdns: Exception calling MDNS deactivate", context);
        if (true) goto _L2; else goto _L5
_L5:
        return false;
    }

    public static boolean deactivateMdnsOldToken(Context context, String s, EbaySmartNotificationManager.NotificationType notificationtype)
    {
        Object obj;
        obj = new NotificationModule("AEAPP", MyApp.getPrefs().getAuthentication(), null, notificationtype);
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        if (!"AEAPP".equals(((NotificationModule) (obj)).clientId))
        {
            warn((new StringBuilder()).append("deactivateMdnsOldToken: appCredentials null for ").append(((NotificationModule) (obj)).clientId).toString());
            return true;
        }
        if (((NotificationModule) (obj)).auth == null)
        {
            warn((new StringBuilder()).append("deactivateMdnsOldToken: auth null for ").append(((NotificationModule) (obj)).clientId).toString());
            return true;
        }
        obj = ((NotificationModule) (obj)).asSubscriptionArgs(context);
        if (obj == null)
        {
            return true;
        }
        obj.regId = s;
        if (!(new EbayMdnsApi(((FwContext)context).getEbayContext())).deactivateUserOnDevice(((SubscriptionArgs) (obj)).iafToken, ((SubscriptionArgs) (obj)).userId, ((SubscriptionArgs) (obj)).regId, ((SubscriptionArgs) (obj)).language, getClientIdForNotificationType(notificationtype, ((SubscriptionArgs) (obj)).clientId), ((SubscriptionArgs) (obj)).metaCategories, ((SubscriptionArgs) (obj)).site, "C2DM"))
        {
            return false;
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("deactivateMdnsOldToken: Deactivation complete! uid=").append(((SubscriptionArgs) (obj)).userId).append(";regId=").append(((SubscriptionArgs) (obj)).regId).append(";clientId=").append(((SubscriptionArgs) (obj)).clientId).toString());
        }
        return true;
        context;
        Log.w("NotificationUtil", "deactivateMdnsOldToken: Request Error calling MDNS deactivate", context);
_L2:
        return false;
        context;
        Log.w("NotificationUtil", "deactivateMdnsOldToken: Exception calling MDNS deactivate", context);
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected static String getBidTimeLeft(NotificationPreferenceManager notificationpreferencemanager, String s)
    {
        if (notificationpreferencemanager.isEventEnabled(s, com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM.name()))
        {
            return "15";
        } else
        {
            return null;
        }
    }

    public static String getClientIdForNotificationType(EbaySmartNotificationManager.NotificationType notificationtype, String s)
    {
        if (!EnvironmentUtils.isBlackberry() || notificationtype != EbaySmartNotificationManager.NotificationType.C2DM) goto _L2; else goto _L1
_L1:
        if (!s.equals("AEAPP")) goto _L4; else goto _L3
_L3:
        String s1 = "AEAPP_BB";
_L6:
        return s1;
_L4:
        if (s.equals("AMOTORS"))
        {
            return "AMOTORS_BB";
        }
_L2:
        s1 = s;
        if (notificationtype == EbaySmartNotificationManager.NotificationType.GCM)
        {
            if (s.equals("AEAPP"))
            {
                return "AEAPP_GCM";
            }
            s1 = s;
            if (s.equals("AMOTORS"))
            {
                return "AMOTORS_GCM";
            }
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    protected static String getWatchedTimeLeft(NotificationPreferenceManager notificationpreferencemanager, String s)
    {
        if (notificationpreferencemanager.isEventEnabled(s, com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHITM.name()))
        {
            return "15";
        } else
        {
            return null;
        }
    }

    private static void handleEbayResponseErrors(com.ebay.nautilus.kernel.content.ResultStatus.Message message, boolean flag)
    {
        if (!flag && 11002 == message.getId())
        {
            MyApp.signOutForIafTokenFailure(null);
        }
    }

    protected static void loadClientAlertPreferences(BaseIntentService baseintentservice)
    {
        Authentication authentication;
        NotificationPreferenceManager notificationpreferencemanager;
label0:
        {
            authentication = checkAndGetAuth();
            if (authentication != null)
            {
                try
                {
                    notificationpreferencemanager = new NotificationPreferenceManager(baseintentservice);
                    if (!notificationpreferencemanager.hasPollingSettings(authentication.user))
                    {
                        break label0;
                    }
                    if (logTag.isLoggable)
                    {
                        FwLog.println(logTag, "loadClientAlertPreferences: device has settings already, skip Set");
                        return;
                    }
                }
                // Misplaced declaration of an exception variable
                catch (BaseIntentService baseintentservice)
                {
                    Log.w("NotificationUtil", "loadClientAlertPreferences: Exception getting client alerts", baseintentservice);
                    return;
                }
            }
        }
_L1:
        return;
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "loadClientAlertPreferences: device has NO settings locally, calling SET now");
        }
        EbayContext ebaycontext = baseintentservice.getEbayContext();
        if (setDefaultClientAlertPreferences(baseintentservice, ebaycontext))
        {
            baseintentservice = EbayTradingApiHelper.getClientAlertsPreferences(ebaycontext, EbayApiUtil.getTradingApi(baseintentservice, authentication));
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, "loadClientAlertPreferences: Client alerts preferences get is called");
            }
            setToSharedPreferences(notificationpreferencemanager, baseintentservice, authentication.user);
            notificationpreferencemanager.putHasPollingSettings(authentication.user);
            return;
        }
          goto _L1
    }

    private static ArrayList migratePollPrefsToMdns(NotificationPreferenceManager notificationpreferencemanager, String s, NotificationModule notificationmodule)
    {
        List list;
        ArrayList arraylist;
        com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[];
        int i;
        int k;
        list = buildClientAlertNames(notificationpreferencemanager, s);
        arraylist = new ArrayList();
        aeventtype = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
        k = aeventtype.length;
        i = 0;
_L2:
        com.ebay.common.model.mdns.NotificationPreference.EventType eventtype;
        if (i >= k)
        {
            break MISSING_BLOCK_LABEL_447;
        }
        eventtype = aeventtype[i];
        if (eventtype.supported && eventtype.id != 2)
        {
            break; /* Loop/switch isn't completed */
        }
_L8:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        NotificationPreference notificationpreference;
        Iterator iterator;
        boolean flag;
        notificationpreference = new NotificationPreference();
        notificationpreference.eventType = eventtype.name();
        if (eventtype.id == 1)
        {
            notificationpreference.properties = new ArrayList(1);
            notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name(), "15"));
        }
        if (eventtype.id == 17)
        {
            notificationpreference.properties = new ArrayList(1);
            notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name(), "15"));
        }
        if (eventtype.id == 35)
        {
            notificationpreference.properties = new ArrayList(1);
            notificationpreference.properties.add(new NameValue(com.ebay.common.model.mdns.NotificationPreference.PropertyType.TimeLeft.name(), "15"));
        }
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, (new StringBuilder()).append("migratePollPrefsToMdns: pref migrated and saved to shared pref, type: ").append(notificationpreference.eventType).toString());
        }
        flag = true;
        iterator = list.iterator();
_L6:
        int j = ((flag) ? 1 : 0);
        if (!iterator.hasNext()) goto _L4; else goto _L3
_L3:
        String s1 = (String)iterator.next();
        if (!eventtype.name().equals(NotificationPreference.clientAlertNameToEventName(s1))) goto _L6; else goto _L5
_L5:
        arraylist.add(notificationpreference);
        notificationpreferencemanager.setEventEnabled(s, eventtype.name(), true);
        j = 0;
_L4:
        if (!j) goto _L8; else goto _L7
_L7:
        com.ebay.common.model.mdns.NotificationPreference.AlertType aalerttype[];
        boolean flag2;
        int l;
        flag2 = true;
        aalerttype = com.ebay.common.model.mdns.NotificationPreference.AlertType.values();
        l = aalerttype.length;
        j = 0;
_L9:
label0:
        {
            boolean flag1 = flag2;
            if (j < l)
            {
                com.ebay.common.model.mdns.NotificationPreference.AlertType alerttype = aalerttype[j];
                if (!alerttype.supported || eventtype.id != alerttype.id)
                {
                    break label0;
                }
                flag1 = false;
            }
            if (flag1)
            {
                arraylist.add(notificationpreference);
                notificationpreferencemanager.setEventEnabled(s, eventtype.name(), eventtype.defaultValue);
            }
        }
          goto _L8
        j++;
          goto _L9
        notificationpreferencemanager.putHasPushSettings(s, notificationmodule.clientId);
        return arraylist;
          goto _L8
    }

    protected static void setClientAlertPreferences(Context context, EbayContext ebaycontext)
    {
        (new SetClientAlertAsyncTask()).execute(new Object[] {
            context, ebaycontext
        });
    }

    protected static boolean setDefaultClientAlertPreferences(Context context, EbayContext ebaycontext)
    {
        boolean flag2 = false;
        boolean flag = false;
        Authentication authentication = MyApp.getPrefs().getAuthentication();
        if (authentication == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        boolean flag1 = flag2;
        NotificationPreferenceManager notificationpreferencemanager;
        try
        {
            notificationpreferencemanager = new NotificationPreferenceManager(context);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            Log.w("NotificationUtil", "setDefaultClientAlertPreferences: Exception setting client alerts", context);
            return flag1;
        }
        flag1 = flag2;
        flag2 = EbayTradingApiHelper.setClientAlertsPreferences(ebaycontext, EbayApiUtil.getTradingApi(context, authentication), buildAndSaveDefaultClientAlertNames(notificationpreferencemanager, authentication.user), getWatchedTimeLeft(notificationpreferencemanager, authentication.user), getBidTimeLeft(notificationpreferencemanager, authentication.user));
        flag = flag2;
        flag1 = flag2;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        flag1 = flag2;
        FwLog.println(logTag, "setDefaultClientAlertPreferences: Client alerts default values set");
        flag = flag2;
        return flag;
    }

    private static void setFollowSubscriptions(EbayContext ebaycontext, List list)
    {
        ebaycontext = SearchUtil.getFollowedEntityDataManager(ebaycontext);
        String s = checkAndGetAuth().iafToken;
        HashMap hashmap = new HashMap();
        if (list != null)
        {
            List list1 = MyApp.getDeviceConfiguration().getFollowNotificationTypes();
            for (list = list.iterator(); list.hasNext(); hashmap.put((String)list.next(), list1)) { }
        }
        ebaycontext.updateSavedSearchNotifications(s, MyApp.getPrefs().getCurrentSite(), hashmap);
    }

    public static boolean setGoogleNowSubscription(Context context, String s, List list)
    {
        EbayMdnsApi ebaymdnsapi = new EbayMdnsApi(((FwContext)context).getEbayContext());
        context = (new NotificationModule("GOOGLENOW", MyApp.getPrefs().getAuthentication(), null, EbaySmartNotificationManager.NotificationType.GOOGLE_NOW)).asSubscriptionArgs(context);
        if (context == null)
        {
            return false;
        } else
        {
            context.language = Locale.getDefault().toString().replaceAll("_", "-");
            context.regId = s;
            return setGoogleNowSubscription(ebaymdnsapi, ((SubscriptionArgs) (context)), list);
        }
    }

    protected static boolean setGoogleNowSubscription(EbayMdnsApi ebaymdnsapi, SubscriptionArgs subscriptionargs, List list)
    {
        int i;
        com.ebay.common.net.api.mdns.EbayMdnsApi.NotificationParams notificationparams = new com.ebay.common.net.api.mdns.EbayMdnsApi.NotificationParams();
        notificationparams.iafToken = subscriptionargs.iafToken;
        notificationparams.userId = subscriptionargs.userId;
        notificationparams.deviceType = "GOOGLENOW";
        notificationparams.registrationId = subscriptionargs.regId;
        notificationparams.language = subscriptionargs.language;
        notificationparams.clientId = "GOOGLENOW";
        notificationparams.metaCategories = subscriptionargs.metaCategories;
        notificationparams.prefs = new ArrayList(list);
        notificationparams.site = subscriptionargs.site;
        i = ebaymdnsapi.setDeviceNotificationSubscriptions(notificationparams).ackCode;
        return i == 1;
        ebaymdnsapi;
        Log.w("NotificationUtil", "setGoogleNowSubscription: Request Error calling MDNS set", ebaymdnsapi);
_L2:
        return false;
        ebaymdnsapi;
        Log.w("NotificationUtil", "setGoogleNowSubscription: Exception calling MDNS set", ebaymdnsapi);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static ResultStatus setMdnsSubsFromSave(Context context, EbayContext ebaycontext, SubscriptionArgs subscriptionargs, List list)
    {
        Iterator iterator;
        com.ebay.nautilus.kernel.content.ResultStatus.Message message;
        List list1;
        message = null;
        iterator = null;
        list1 = buildPreferences(context, subscriptionargs.userId, list);
        context = iterator;
        list = message;
        EbayMdnsApi ebaymdnsapi = new EbayMdnsApi(ebaycontext);
        context = iterator;
        list = message;
        com.ebay.common.net.api.mdns.EbayMdnsApi.NotificationParams notificationparams = new com.ebay.common.net.api.mdns.EbayMdnsApi.NotificationParams();
        context = iterator;
        list = message;
        notificationparams.iafToken = subscriptionargs.iafToken;
        context = iterator;
        list = message;
        notificationparams.userId = subscriptionargs.userId;
        context = iterator;
        list = message;
        notificationparams.registrationId = subscriptionargs.regId;
        context = iterator;
        list = message;
        notificationparams.language = subscriptionargs.language;
        context = iterator;
        list = message;
        notificationparams.deviceType = "C2DM";
        context = iterator;
        list = message;
        notificationparams.clientId = getClientIdForNotificationType(subscriptionargs.notificationType, subscriptionargs.clientId);
        context = iterator;
        list = message;
        notificationparams.metaCategories = subscriptionargs.metaCategories;
        context = iterator;
        list = message;
        notificationparams.prefs = new ArrayList(list1);
        context = iterator;
        list = message;
        notificationparams.site = subscriptionargs.site;
        context = iterator;
        list = message;
        subscriptionargs = ebaymdnsapi.setDeviceNotificationSubscriptions(notificationparams).getResultStatus();
        context = subscriptionargs;
        list = subscriptionargs;
        if (!subscriptionargs.hasError()) goto _L2; else goto _L1
_L1:
        context = subscriptionargs;
        list = subscriptionargs;
        iterator = subscriptionargs.getMessages().iterator();
_L3:
        context = subscriptionargs;
        list = subscriptionargs;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        context = subscriptionargs;
        list = subscriptionargs;
        message = (com.ebay.nautilus.kernel.content.ResultStatus.Message)iterator.next();
        context = subscriptionargs;
        list = subscriptionargs;
        Log.w("NotificationUtil", (new StringBuilder()).append("setMdnsSubs: Error from eBay API=").append(message.getShortMessage(ebaycontext)).toString());
        context = subscriptionargs;
        list = subscriptionargs;
        handleEbayResponseErrors(message, false);
        if (true) goto _L3; else goto _L2
        subscriptionargs;
        ebaycontext = context;
        if (subscriptionargs.getErrors() != null)
        {
            subscriptionargs = subscriptionargs.getErrors().iterator();
            do
            {
                ebaycontext = context;
                if (!subscriptionargs.hasNext())
                {
                    break;
                }
                ebaycontext = (EbayResponseError)subscriptionargs.next();
                Log.w("NotificationUtil", (new StringBuilder()).append("setMdnsSubs: Error from eBay API=").append(ebaycontext.toString()).toString());
                handleEbayResponseErrors(ebaycontext, false);
            } while (true);
        }
        break MISSING_BLOCK_LABEL_462;
_L2:
        context = subscriptionargs;
        list = subscriptionargs;
        ebaycontext = subscriptionargs;
        if (!logTag.isLoggable)
        {
            break MISSING_BLOCK_LABEL_462;
        }
        context = subscriptionargs;
        list = subscriptionargs;
        if (!subscriptionargs.hasError())
        {
            break MISSING_BLOCK_LABEL_434;
        }
        context = subscriptionargs;
        list = subscriptionargs;
        FwLog.println(logTag, "setMdnsSubs: Device notification preferences failed!");
        return subscriptionargs;
        context = subscriptionargs;
        list = subscriptionargs;
        FwLog.println(logTag, "setMdnsSubs: Device notification preferences set!");
        return subscriptionargs;
        context;
        Log.w("NotificationUtil", "setMdnsSubs: Exception setting MDNS prefs", context);
        ebaycontext = list;
        return ebaycontext;
    }

    private static ResultStatus setMdnsSubscriptions(Context context, EbayContext ebaycontext, List list, EbaySmartNotificationManager.NotificationType notificationtype)
    {
        notificationtype = new NotificationModule("AEAPP", MyApp.getPrefs().getAuthentication(), null, notificationtype);
        if (!"AEAPP".equals(((NotificationModule) (notificationtype)).clientId))
        {
            warn((new StringBuilder()).append("setMdnsSubscriptions: appCredentials null for ").append(((NotificationModule) (notificationtype)).clientId).toString());
            return null;
        }
        if (((NotificationModule) (notificationtype)).auth == null)
        {
            warn((new StringBuilder()).append("setMdnsSubscriptions: auth null for ").append(((NotificationModule) (notificationtype)).clientId).toString());
            return ResultStatus.SUCCESS;
        }
        SubscriptionArgs subscriptionargs = notificationtype.asSubscriptionArgs(context);
        if (subscriptionargs == null)
        {
            warn((new StringBuilder()).append("setMdnsSubscriptions: checkAndGetArgs returned null for ").append(((NotificationModule) (notificationtype)).clientId).toString());
            return null;
        }
        notificationtype = list;
        if (list == null)
        {
            notificationtype = (new NotificationPreferenceManager(context)).getNotifyEnabledSavedSearchIdList(subscriptionargs.userId);
        }
        return setMdnsSubsFromSave(context, ebaycontext, subscriptionargs, notificationtype);
    }

    protected static boolean setMdnsSubscriptions(EbayMdnsApi ebaymdnsapi, SubscriptionArgs subscriptionargs, List list)
    {
        int i;
        com.ebay.common.net.api.mdns.EbayMdnsApi.NotificationParams notificationparams = new com.ebay.common.net.api.mdns.EbayMdnsApi.NotificationParams();
        notificationparams.iafToken = subscriptionargs.iafToken;
        notificationparams.userId = subscriptionargs.userId;
        notificationparams.deviceType = "C2DM";
        notificationparams.registrationId = subscriptionargs.regId;
        notificationparams.language = subscriptionargs.language;
        notificationparams.clientId = getClientIdForNotificationType(subscriptionargs.notificationType, subscriptionargs.clientId);
        notificationparams.metaCategories = subscriptionargs.metaCategories;
        notificationparams.prefs = new ArrayList(list);
        notificationparams.site = subscriptionargs.site;
        i = ebaymdnsapi.setDeviceNotificationSubscriptions(notificationparams).ackCode;
        return i == 1;
        ebaymdnsapi;
        Log.w("NotificationUtil", "setMdnsSubscriptions: Request Error calling MDNS set", ebaymdnsapi);
_L2:
        return false;
        ebaymdnsapi;
        Log.w("NotificationUtil", "setMdnsSubscriptions: Exception calling MDNS set", ebaymdnsapi);
        if (true) goto _L2; else goto _L1
_L1:
    }

    private static void setToSharedPreferences(NotificationPreferenceManager notificationpreferencemanager, List list, String s)
    {
        notificationpreferencemanager.clearAllNotificationPreference(s);
        list = list.iterator();
        do
        {
            if (!list.hasNext())
            {
                break;
            }
            Object obj = (NotificationPreference)list.next();
            if (logTag.isLoggable)
            {
                FwLog.println(logTag, (new StringBuilder()).append("setToSharedPreferences: enabled type: ").append(((NotificationPreference) (obj)).toString()).toString());
            }
            if (((NotificationPreference) (obj)).eventType.equals(com.ebay.common.model.mdns.NotificationPreference.EventType.SVDSRCH.name()))
            {
                Object obj1 = ((NotificationPreference) (obj)).getSavedSearchSettings();
                if (((List) (obj1)).size() > 0)
                {
                    obj = new ArrayList();
                    obj1 = ((List) (obj1)).iterator();
                    do
                    {
                        if (!((Iterator) (obj1)).hasNext())
                        {
                            break;
                        }
                        NameValue namevalue = (NameValue)((Iterator) (obj1)).next();
                        String s1 = namevalue.getName();
                        boolean flag = Boolean.valueOf(namevalue.getValue()).booleanValue();
                        if (logTag.isLoggable)
                        {
                            FwLog.println(logTag, String.format("setToSharedPreferences: saved search ID: %s, enabled: %s", new Object[] {
                                s1, Boolean.valueOf(flag)
                            }));
                        }
                        if (flag)
                        {
                            ((List) (obj)).add(s1);
                        }
                    } while (true);
                    if (logTag.isLoggable)
                    {
                        FwLog.println(logTag, (new StringBuilder()).append("setToSharedPreferences: # of SS enabled: ").append(((List) (obj)).size()).toString());
                    }
                    notificationpreferencemanager.setNotifyEnabledSavedSearchIdList(s, ((List) (obj)));
                }
            } else
            {
                notificationpreferencemanager.setEventEnabled(s, ((NotificationPreference) (obj)).eventType, true);
            }
        } while (true);
    }

    public static void stopNotification(Context context, EbaySmartNotificationManager.NotificationType notificationtype, Authentication authentication)
    {
        ItemCache itemcache = new ItemCache(context);
        itemcache.resetSettingsLoadingState();
        if (logTag.isLoggable)
        {
            FwLog.println(logTag, "stopNotification: signed out, cleared loading state");
        }
        itemcache.removeAllData();
        if (authentication == null)
        {
            return;
        }
        if (!EbayUtil.isPushActive(context, authentication.user, "AEAPP"))
        {
            ServiceStarter.startPollService(context, "com.ebay.mobile.service.DISABLE_NOTIFICATIONS");
            return;
        }
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[];

            static 
            {
                $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType = new int[EbaySmartNotificationManager.NotificationType.values().length];
                try
                {
                    $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[EbaySmartNotificationManager.NotificationType.GCM.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$mobile$notifications$EbaySmartNotificationManager$NotificationType[EbaySmartNotificationManager.NotificationType.C2DM.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.ebay.mobile.notifications.EbaySmartNotificationManager.NotificationType[notificationtype.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
        case 2: // '\002'
            deactivateMdns(context, notificationtype, authentication, "AEAPP", "C2DM");
            break;
        }
    }

    public static ResultStatus updateNotificationSubscriptions(Context context, EbayContext ebaycontext, EbaySmartNotificationManager.NotificationType notificationtype)
    {
        if (notificationtype == EbaySmartNotificationManager.NotificationType.POLL)
        {
            setClientAlertPreferences(context, ebaycontext);
            return ResultStatus.SUCCESS;
        } else
        {
            return setMdnsSubscriptions(context, ebaycontext, null, notificationtype);
        }
    }

    public static boolean updateNotificationSubscriptions(Context context, EbayContext ebaycontext, List list)
    {
        if (useFollowForSavedSearch())
        {
            setFollowSubscriptions(ebaycontext, list);
        } else
        {
            EbaySmartNotificationManager.NotificationType notificationtype = EbaySmartNotificationManager.getCurrentConfiguration(context);
            if (notificationtype != EbaySmartNotificationManager.NotificationType.POLL)
            {
                context = setMdnsSubscriptions(context, ebaycontext, list, notificationtype);
                if (context == null || context.hasError())
                {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean useFollowForSavedSearch()
    {
        return DeviceConfiguration.getAsync().get(DcsBoolean.searchSavedSearchUseFollowInterest);
    }

    private static void warn(String s)
    {
        Log.w("NotificationUtil", s);
    }

}
