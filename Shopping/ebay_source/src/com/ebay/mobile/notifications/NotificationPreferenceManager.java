// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.notifications;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ebay.common.util.SharedPreferencesCompat;
import com.ebay.mobile.common.EbayUtil;
import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.dcs.DcsPropBoolean;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.util.FwLog;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.ebay.mobile.notifications:
//            DevLog

public class NotificationPreferenceManager
{
    public static final class CombinedEvent extends Enum
    {

        private static final CombinedEvent $VALUES[];
        public static final CombinedEvent BUYING_AUCTION_UPDATES;
        public static final CombinedEvent BUYING_ITEM_DISCOUNTS;
        public static final CombinedEvent BUYING_ITEM_ENDING;
        public static final CombinedEvent BUYING_OFFER_UPDATES;
        public static final CombinedEvent BUYING_ORDER_UPDATES;
        public static final CombinedEvent GENERAL_DEALS;
        public static final CombinedEvent SELLING_ORDER_UPDATES;
        public static final CombinedEvent UNDEFINED;
        protected final String eventTypeNames[];
        private final DcsPropBoolean isSupportedProperty;

        public static CombinedEvent valueOf(String s)
        {
            return (CombinedEvent)Enum.valueOf(com/ebay/mobile/notifications/NotificationPreferenceManager$CombinedEvent, s);
        }

        public static CombinedEvent[] values()
        {
            return (CombinedEvent[])$VALUES.clone();
        }

        public boolean isSupported()
        {
            if (isSupportedProperty != null)
            {
                return DeviceConfiguration.getAsync().get(isSupportedProperty);
            } else
            {
                return true;
            }
        }

        static 
        {
            UNDEFINED = new CombinedEvent("UNDEFINED", 0, new String[0]);
            BUYING_ITEM_DISCOUNTS = new CombinedEvent("BUYING_ITEM_DISCOUNTS", 1, com.ebay.mobile.dcs.Dcs.Connect.B.dealMakerNotification, new String[] {
                com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHONSALE.name(), com.ebay.common.model.mdns.NotificationPreference.EventType.CARTONSALE.name()
            });
            GENERAL_DEALS = new CombinedEvent("GENERAL_DEALS", 2, DcsBoolean.Verticals_dealsNotifications, new String[] {
                com.ebay.common.model.mdns.NotificationPreference.EventType.DailyDeals.name(), com.ebay.common.model.mdns.NotificationPreference.EventType.DealsFrenzy.name()
            });
            BUYING_ITEM_ENDING = new CombinedEvent("BUYING_ITEM_ENDING", 3, new String[] {
                "WATCHITM", "BIDITEM"
            });
            BUYING_AUCTION_UPDATES = new CombinedEvent("BUYING_AUCTION_UPDATES", 4, new String[] {
                "OUTBID", "ITMWON"
            });
            BUYING_OFFER_UPDATES = new CombinedEvent("BUYING_OFFER_UPDATES", 5, new String[] {
                "BODECLND", "CNTROFFR"
            });
            BUYING_ORDER_UPDATES = new CombinedEvent("BUYING_ORDER_UPDATES", 6, new String[] {
                "ITMPAID", "ITMSHPD"
            });
            SELLING_ORDER_UPDATES = new CombinedEvent("SELLING_ORDER_UPDATES", 7, new String[] {
                "ITMSOLD", "COCMPLT"
            });
            $VALUES = (new CombinedEvent[] {
                UNDEFINED, BUYING_ITEM_DISCOUNTS, GENERAL_DEALS, BUYING_ITEM_ENDING, BUYING_AUCTION_UPDATES, BUYING_OFFER_UPDATES, BUYING_ORDER_UPDATES, SELLING_ORDER_UPDATES
            });
        }

        private transient CombinedEvent(String s, int i, DcsPropBoolean dcspropboolean, String as[])
        {
            super(s, i);
            eventTypeNames = as;
            isSupportedProperty = dcspropboolean;
        }

        private transient CombinedEvent(String s, int i, String as[])
        {
            this(s, i, null, as);
        }
    }


    private static final String ACTIVE_WITH_MDNS = "active_with_mdns";
    public static final String APP_VERSION_CODE = "appVersion";
    public static final String BID_ENDING_TIME_LEFT_DEFAULT = "15";
    protected static final String C2DM_REG_ID = "EBAY_C2DM_REG_ID";
    public static final String CART_TIME_LEFT_DEFAULT = "15";
    protected static final String GCM_REG_ID = "EBAY_GCM_REG_ID";
    private static final String HAS_POLLING_SETTINGS = "has_polling_settings";
    private static final String HAS_PUSH_SETTINGS = "has_push_settings";
    private static final String HAS_SIMPLIFIED_SETTINGS_UPGRADES = "has_simplified_settings_upgrades";
    private static final String LAST_ACTIVATE_WITH_MDNS = "last_activate_with_mdns";
    private static final String LAST_GOOGLE_AUTH = "google_auth_last_update";
    private static final String MFTD_POLL_TIME = "mftd_poll_time";
    private static final String MFTD_SERVICE = "MessageForTheDayService";
    private static final String QUIET_TIMES = "quiet_times";
    private static final String QUIET_TIMES_END_LOCAL = "quiet_times_end_local";
    private static final String QUIET_TIMES_START_LOCAL = "quiet_times_start_local";
    public static final String WATCHED_ENDING_TIME_LEFT_DEFAULT = "15";
    private final String PREFS_FILE;
    private final Context _context;
    private final SharedPreferences prefs;

    public NotificationPreferenceManager(Context context)
    {
        String s;
        if (NautilusKernel.isQaMode())
        {
            s = "com.ebay.mobile.service.qa.PushService.prefs";
        } else
        {
            s = "com.ebay.mobile.service.PushService.prefs";
        }
        PREFS_FILE = s;
        _context = context;
        prefs = _context.getSharedPreferences(PREFS_FILE, 0);
    }

    public static boolean isAlwaysOn(com.ebay.common.model.mdns.NotificationPreference.EventType eventtype)
    {
        return eventtype != null && !eventtype.uiVisible && eventtype.defaultValue;
    }

    public static boolean isAlwaysOn(String s)
    {
        boolean flag;
        try
        {
            flag = isAlwaysOn(com.ebay.common.model.mdns.NotificationPreference.EventType.valueOf(s));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return flag;
    }

    protected static final String makeKey(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
            stringbuilder.append(".");
        }
        stringbuilder.append(s1);
        return stringbuilder.toString();
    }

    protected static final String makeKeySave(String s, String s1)
    {
        StringBuilder stringbuilder = new StringBuilder("save");
        if (!TextUtils.isEmpty(s))
        {
            stringbuilder.append(s);
            stringbuilder.append(".");
        }
        stringbuilder.append(s1);
        return stringbuilder.toString();
    }

    public void addNotifyEnabledSavedSearchId(String s, String s1)
    {
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("addNotifyEnabledSavedSearchId: adding enabled saved searchID:").append(s1).toString());
        }
        ArrayList arraylist = getNotifyEnabledSavedSearchIdList(s);
        arraylist.add(s1);
        setNotifyEnabledSavedSearchIdList(s, arraylist);
    }

    public void cleanupNotificationPreferences()
    {
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, "cleanupNotificationPreferences: removing notification preferences to force reregistration");
        }
        Object obj = prefs.getAll();
        if (obj != null && ((Map) (obj)).size() != 0)
        {
            boolean flag = false;
            android.content.SharedPreferences.Editor editor = prefs.edit();
            obj = ((Map) (obj)).keySet().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                String s = (String)((Iterator) (obj)).next();
                if (s.endsWith("last_activate_with_mdns") || s.endsWith("active_with_mdns"))
                {
                    editor.remove(s);
                    flag = true;
                }
            } while (true);
            if (flag)
            {
                editor.commit();
                return;
            }
        }
    }

    protected void clearAllNotificationPreference(String s)
    {
        com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[] = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
        int j = aeventtype.length;
        int i = 0;
        while (i < j) 
        {
            com.ebay.common.model.mdns.NotificationPreference.EventType eventtype = aeventtype[i];
            if (eventtype.id == 2)
            {
                if (EbayUtil.isPushActive(_context, s, "AEAPP"))
                {
                    clearNotifyEnabledSavedSearchIdList(s);
                }
            } else
            {
                setEventEnabled(s, eventtype.name(), false);
            }
            i++;
        }
    }

    public void clearNotifyEnabledSavedSearchIdList(String s)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.remove(makeKey(s, com.ebay.common.model.mdns.NotificationPreference.EventType.SVDSRCH.name()));
        SharedPreferencesCompat.apply(editor);
    }

    public long getLastGoogleNowAuthorization()
    {
        return prefs.getLong(makeKey(null, "google_auth_last_update"), 0L);
    }

    public long getMftdPollTime()
    {
        return prefs.getLong(makeKey("MessageForTheDayService", "mftd_poll_time"), 0L);
    }

    public String getNotificationEnabledStringForTracking(String s)
    {
        s = prefs.getString(makeKey(s, "ALLNOTIFICATIONS"), "default");
        if ("default".equals(s) || Boolean.parseBoolean(s))
        {
            return "1";
        } else
        {
            return "0";
        }
    }

    public ArrayList getNotifyEnabledSavedSearchIdList(String s)
    {
        return (ArrayList)EbayUtil.unflattenString(prefs.getString(makeKey(s, com.ebay.common.model.mdns.NotificationPreference.EventType.SVDSRCH.name()), ""));
    }

    public String getQuietEndTimeLocal(String s)
    {
        if (!isUserQuietTimeEnabled(s))
        {
            return null;
        } else
        {
            return prefs.getString(makeKey(s, "quiet_times_end_local"), null);
        }
    }

    public String getQuietStartTimeLocal(String s)
    {
        if (!isUserQuietTimeEnabled(s))
        {
            return null;
        } else
        {
            return prefs.getString(makeKey(s, "quiet_times_start_local"), null);
        }
    }

    public int getVersionCode()
    {
        return prefs.getInt("appVersion", -1);
    }

    public boolean hasPollingSettings(String s)
    {
        return Boolean.parseBoolean(prefs.getString(makeKey(s, "has_polling_settings"), "false"));
    }

    public boolean hasPushSettings(String s, String s1)
    {
        SharedPreferences sharedpreferences = prefs;
        s = (new StringBuilder()).append(s);
        if (s1 == null)
        {
            s1 = "";
        }
        return Boolean.parseBoolean(sharedpreferences.getString(makeKey(s.append(s1).toString(), "has_push_settings"), "false"));
    }

    public boolean hasSimplifiedSettingsUpgrades(String s)
    {
        return Boolean.parseBoolean(prefs.getString(makeKey(s, "has_simplified_settings_upgrades"), "false"));
    }

    public boolean isBidItemEndingEnabled(String s)
    {
        return Boolean.parseBoolean(prefs.getString(makeKey(s, com.ebay.common.model.mdns.NotificationPreference.EventType.BIDITEM.name()), "false"));
    }

    public boolean isEventEnabled(String s, CombinedEvent combinedevent)
    {
        boolean flag1 = false;
        combinedevent = combinedevent.eventTypeNames;
        int j = combinedevent.length;
        int i = 0;
        do
        {
label0:
            {
                boolean flag = flag1;
                if (i < j)
                {
                    if (!isEventEnabled(s, combinedevent[i]))
                    {
                        break label0;
                    }
                    flag = true;
                }
                return flag;
            }
            i++;
        } while (true);
    }

    public boolean isEventEnabled(String s, String s1)
    {
        if (isAlwaysOn(s1))
        {
            return true;
        }
        if (com.ebay.common.model.mdns.NotificationPreference.EventType.BUCKSEXP.name().equals(s1))
        {
            return Boolean.parseBoolean(prefs.getString(makeKey(s, com.ebay.common.model.mdns.NotificationPreference.EventType.COUPONAVLBL.name()), "false"));
        } else
        {
            return Boolean.parseBoolean(prefs.getString(makeKey(s, s1), "false"));
        }
    }

    public boolean isEventEnabledSave(String s, String s1)
    {
        if (isAlwaysOn(s1))
        {
            return true;
        } else
        {
            return Boolean.parseBoolean(prefs.getString(makeKeySave(s, s1), "false"));
        }
    }

    public boolean isNotificationEnabled(String s)
    {
        com.ebay.common.model.mdns.NotificationPreference.EventType aeventtype[] = com.ebay.common.model.mdns.NotificationPreference.EventType.values();
        int j = aeventtype.length;
        for (int i = 0; i < j; i++)
        {
            com.ebay.common.model.mdns.NotificationPreference.EventType eventtype = aeventtype[i];
            if (eventtype.id != 2 && isEventEnabled(s, eventtype.name()))
            {
                return true;
            }
        }

        return false;
    }

    public boolean isNotifyEnabledForSavedSearch(String s, String s1)
    {
        if (TextUtils.isEmpty(s1))
        {
            return false;
        } else
        {
            return getNotifyEnabledSavedSearchIdList(s).contains(s1);
        }
    }

    public boolean isOutbidEnabled(String s)
    {
        return Boolean.parseBoolean(prefs.getString(makeKey(s, com.ebay.common.model.mdns.NotificationPreference.EventType.OUTBID.name()), "false"));
    }

    public boolean isOutbidOrBidEndingOrWatchedEndingEnabled(String s)
    {
        return isOutbidEnabled(s) || isWatchedEndingEnabled(s) || isBidItemEndingEnabled(s);
    }

    public boolean isQuietTime(String s, Calendar calendar)
    {
        if (!isUserQuietTimeEnabled(s))
        {
            return false;
        }
        Object obj = getQuietStartTimeLocal(s);
        s = getQuietEndTimeLocal(s);
        if (obj == null || s == null)
        {
            return false;
        }
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(11, Integer.valueOf(((String) (obj)).substring(0, 2)).intValue());
        calendar1.set(12, Integer.valueOf(((String) (obj)).substring(2)).intValue());
        calendar1.set(13, 0);
        obj = Calendar.getInstance();
        ((Calendar) (obj)).set(11, Integer.valueOf(s.substring(0, 2)).intValue());
        ((Calendar) (obj)).set(12, Integer.valueOf(s.substring(2)).intValue());
        ((Calendar) (obj)).set(13, 0);
        long l4 = calendar.getTimeInMillis();
        long l2 = calendar1.getTimeInMillis();
        long l3 = ((Calendar) (obj)).getTimeInMillis();
        long l = l3;
        long l1 = l2;
        if (l2 > l3)
        {
            if (l2 > l4)
            {
                l1 = l2 - 0x5265c00L;
                l = l3;
            } else
            {
                l = l3;
                l1 = l2;
                if (l2 < l4)
                {
                    l = l3 + 0x5265c00L;
                    l1 = l2;
                }
            }
        }
        return l4 >= l1 && l4 <= l;
    }

    public boolean isTimeToActivateWithMdns(String s, String s1)
    {
        boolean flag = false;
        SharedPreferences sharedpreferences = prefs;
        s = (new StringBuilder()).append(s);
        long l;
        if (s1 == null)
        {
            s1 = "";
        }
        l = sharedpreferences.getLong(makeKey(s.append(s1).toString(), "last_activate_with_mdns"), 0L);
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("isTimeToActivateWithMdns: timestamp=").append(l).append("; last update date=").append((new Date(l)).toString()).toString());
        }
        if (l == 0L)
        {
            flag = true;
        }
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("isTimeToActivateWithMdns: returning ").append(flag).toString());
        }
        return flag;
    }

    public boolean isUpgradeIndicated(int i)
    {
        return getVersionCode() != i;
    }

    public boolean isUserActiveWithMdns(String s, String s1)
    {
        SharedPreferences sharedpreferences = prefs;
        StringBuilder stringbuilder = (new StringBuilder()).append(s);
        String s2;
        boolean flag;
        if (s1 != null)
        {
            s2 = s1;
        } else
        {
            s2 = "";
        }
        flag = Boolean.parseBoolean(sharedpreferences.getString(makeKey(stringbuilder.append(s2).toString(), "active_with_mdns"), "false"));
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("isUserActiveWithMdns userId=").append(s).append(", clientId=").append(s1).append(", active=").append(flag).toString());
        }
        return flag;
    }

    public boolean isUserQuietTimeEnabled(String s)
    {
        boolean flag;
        if (!DeviceConfiguration.getAsync().get(DcsBoolean.NotificationQuietTimes))
        {
            flag = false;
        } else
        {
            boolean flag1 = Boolean.parseBoolean(prefs.getString(makeKey(s, "quiet_times"), "false"));
            flag = flag1;
            if (DevLog.logNotifications.isLoggable)
            {
                FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("isUserQuietTimeEnabled userId=").append(s).append(", active=").append(flag1).toString());
                return flag1;
            }
        }
        return flag;
    }

    public boolean isWatchedEndingEnabled(String s)
    {
        return Boolean.parseBoolean(prefs.getString(makeKey(s, com.ebay.common.model.mdns.NotificationPreference.EventType.WATCHITM.name()), "false"));
    }

    public void onApplicationUpgradeBackground(int i)
    {
        if (isUpgradeIndicated(i))
        {
            cleanupNotificationPreferences();
            setVersionCode(i);
        }
    }

    public void putHasPollingSettings(String s)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putString(makeKey(s, "has_polling_settings"), "true");
        SharedPreferencesCompat.apply(editor);
    }

    public void putHasPushSettings(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        s = (new StringBuilder()).append(s);
        if (s1 == null)
        {
            s1 = "";
        }
        editor.putString(makeKey(s.append(s1).toString(), "has_push_settings"), "true");
        SharedPreferencesCompat.apply(editor);
    }

    public void putHasSimplifiedSettingsUpgrades(String s)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putString(makeKey(s, "has_simplified_settings_upgrades"), "true");
        SharedPreferencesCompat.apply(editor);
    }

    public void removeMdnsActivationTime(String s, String s1)
    {
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("removeMdnsActivationTime removing last MDNS activation time: userid=").append(s).append(";clientId=").append(s1).toString());
        }
        android.content.SharedPreferences.Editor editor = prefs.edit();
        s = (new StringBuilder()).append(s);
        if (s1 == null)
        {
            s1 = "";
        }
        editor.remove(makeKey(s.append(s1).toString(), "last_activate_with_mdns"));
        SharedPreferencesCompat.apply(editor);
    }

    public void removeNotifyEnabledSavedSearchId(String s, String s1)
    {
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("removeNotifyEnabledSavedSearchId: removing enabled saved searchID:").append(s1).toString());
        }
        ArrayList arraylist = getNotifyEnabledSavedSearchIdList(s);
        arraylist.remove(s1);
        setNotifyEnabledSavedSearchIdList(s, arraylist);
    }

    public void setActiveWithMdns(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        StringBuilder stringbuilder = (new StringBuilder()).append(s);
        String s2;
        if (s1 != null)
        {
            s2 = s1;
        } else
        {
            s2 = "";
        }
        editor.putString(makeKey(stringbuilder.append(s2).toString(), "active_with_mdns"), "true");
        s = (new StringBuilder()).append(s);
        if (s1 == null)
        {
            s1 = "";
        }
        editor.putLong(makeKey(s.append(s1).toString(), "last_activate_with_mdns"), System.currentTimeMillis());
        SharedPreferencesCompat.apply(editor);
    }

    public void setEventEnabled(String s, CombinedEvent combinedevent, boolean flag)
    {
        combinedevent = combinedevent.eventTypeNames;
        int j = combinedevent.length;
        for (int i = 0; i < j; i++)
        {
            setEventEnabled(s, combinedevent[i], flag);
        }

    }

    public void setEventEnabled(String s, String s1, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putString(makeKey(s, s1), String.valueOf(flag));
        SharedPreferencesCompat.apply(editor);
    }

    public void setEventEnabledSave(String s, String s1, boolean flag)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putString(makeKeySave(s, s1), String.valueOf(flag));
        SharedPreferencesCompat.apply(editor);
    }

    public void setInactiveWithMdns(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        StringBuilder stringbuilder = (new StringBuilder()).append(s);
        String s2;
        if (s1 != null)
        {
            s2 = s1;
        } else
        {
            s2 = "";
        }
        editor.putString(makeKey(stringbuilder.append(s2).toString(), "active_with_mdns"), "false");
        s = (new StringBuilder()).append(s);
        if (s1 == null)
        {
            s1 = "";
        }
        editor.remove(makeKey(s.append(s1).toString(), "last_activate_with_mdns"));
        SharedPreferencesCompat.apply(editor);
    }

    public void setLastActivationTimeMdns(String s, String s1, long l)
    {
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("setLastActivationTimeMdns setting last MDNS activation time: userid=").append(s).append(";clientId=").append(s1).append(";time=").append(l).toString());
        }
        android.content.SharedPreferences.Editor editor = prefs.edit();
        s = (new StringBuilder()).append(s);
        if (s1 == null)
        {
            s1 = "";
        }
        editor.putLong(makeKey(s.append(s1).toString(), "last_activate_with_mdns"), l);
        SharedPreferencesCompat.apply(editor);
    }

    public void setLastGoogleNowAuthorization(long l)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(makeKey(null, "google_auth_last_update"), l);
        editor.commit();
    }

    public void setMftdPollTime(long l)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putLong(makeKey("MessageForTheDayService", "mftd_poll_time"), l);
        SharedPreferencesCompat.apply(editor);
    }

    protected void setNotifyEnabledSavedSearchIdList(String s, List list)
    {
        list = EbayUtil.flattenString(list);
        if (DevLog.logNotifications.isLoggable)
        {
            FwLog.println(DevLog.logNotifications, (new StringBuilder()).append("setNotifyEnabledSavedSearchIdList: new enabled saved searchIDs:").append(list).toString());
        }
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putString(makeKey(s, com.ebay.common.model.mdns.NotificationPreference.EventType.SVDSRCH.name()), list);
        SharedPreferencesCompat.apply(editor);
    }

    public void setUserQuietTimeDisabled(String s)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putString(makeKey(s, "quiet_times"), "false");
        editor.commit();
    }

    public void setUserQuietTimeEnabled(String s)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putString(makeKey(s, "quiet_times"), "true");
        editor.commit();
    }

    public void setUserQuietTimeEnd(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putString(makeKey(s, "quiet_times_end_local"), s1);
        editor.commit();
    }

    public void setUserQuietTimeStart(String s, String s1)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putString(makeKey(s, "quiet_times_start_local"), s1);
        editor.commit();
    }

    public void setVersionCode(int i)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.putInt("appVersion", i);
        editor.commit();
    }

    public void unregister(String s)
    {
        android.content.SharedPreferences.Editor editor = prefs.edit();
        editor.remove(makeKey(s, "EBAY_C2DM_REG_ID"));
        SharedPreferencesCompat.apply(editor);
    }

    public void upgradeNotificationPreferences(String s)
    {
        CombinedEvent acombinedevent[] = CombinedEvent.values();
        int i1 = acombinedevent.length;
        for (int i = 0; i < i1; i++)
        {
            CombinedEvent combinedevent = acombinedevent[i];
            Boolean boolean1 = null;
            int l = 0;
            String as1[] = combinedevent.eventTypeNames;
            int j1 = as1.length;
            int j = 0;
            while (j < j1) 
            {
                String s1 = as1[j];
                Boolean boolean2;
                if (boolean1 == null)
                {
                    boolean2 = Boolean.valueOf(isEventEnabled(s, s1));
                } else
                {
                    boolean2 = boolean1;
                    if (boolean1.booleanValue() != isEventEnabled(s, s1))
                    {
                        l = 1;
                        boolean2 = boolean1;
                    }
                }
                j++;
                boolean1 = boolean2;
            }
            if (!l)
            {
                continue;
            }
            String as[] = combinedevent.eventTypeNames;
            l = as.length;
            for (int k = 0; k < l; k++)
            {
                setEventEnabled(s, as[k], true);
            }

        }

        putHasSimplifiedSettingsUpgrades(s);
    }
}
