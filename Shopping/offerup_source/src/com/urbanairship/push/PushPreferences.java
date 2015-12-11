// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.json.JsonList;
import com.urbanairship.json.JsonValue;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class PushPreferences
{

    private static final String ADM_REGISTRATION_ID_KEY = "com.urbanairship.push.ADM_REGISTRATION_ID_KEY";
    private static final String ALIAS_KEY = "com.urbanairship.push.ALIAS";
    private static final String APID_KEY = "com.urbanairship.push.APID";
    private static final String APP_VERSION_KEY = "com.urbanairship.push.APP_VERSION";
    private static final String CHANNEL_ID_KEY = "com.urbanairship.push.CHANNEL_ID";
    private static final String CHANNEL_LOCATION_KEY = "com.urbanairship.push.CHANNEL_LOCATION";
    private static final String DEVICE_ID_KEY = "com.urbanairship.push.DEVICE_ID";
    private static final String GCM_INSTANCE_ID_TOKEN_KEY = "com.urbanairship.push.GCM_INSTANCE_ID_TOKEN_KEY";
    private static final String GCM_REGISTRATION_ID_KEY = "com.urbanairship.push.GCM_REGISTRATION_ID_KEY";
    private static final String KEY_PREFIX = "com.urbanairship.push";
    private static final String LAST_RECEIVED_SEND_ID = "com.urbanairship.push.LAST_RECEIVED_SEND_ID";
    private static final String PUSH_ENABLED_KEY = "com.urbanairship.push.PUSH_ENABLED";
    private static final String PUSH_ENABLED_SETTINGS_MIGRATED_KEY = "com.urbanairship.push.PUSH_ENABLED_SETTINGS_MIGRATED";
    private static final String REGISTERED_GCM_SENDER_IDS = "com.urbanairship.push.REGISTERED_GCM_SENDER_IDS";
    private static final String SOUND_ENABLED_KEY = "com.urbanairship.push.SOUND_ENABLED";
    private static final String TAGS_KEY = "com.urbanairship.push.TAGS";
    private static final String USER_NOTIFICATIONS_ENABLED_KEY = "com.urbanairship.push.USER_NOTIFICATIONS_ENABLED";
    private static final String VIBRATE_ENABLED_KEY = "com.urbanairship.push.VIBRATE_ENABLED";
    private final PreferenceDataStore preferenceDataStore;

    public PushPreferences(PreferenceDataStore preferencedatastore)
    {
        preferenceDataStore = preferencedatastore;
    }

    String getAdmId()
    {
        return preferenceDataStore.getString("com.urbanairship.push.ADM_REGISTRATION_ID_KEY", null);
    }

    String getAlias()
    {
        return preferenceDataStore.getString("com.urbanairship.push.ALIAS", null);
    }

    String getApid()
    {
        return preferenceDataStore.getString("com.urbanairship.push.APID", null);
    }

    int getAppVersionCode()
    {
        return preferenceDataStore.getInt("com.urbanairship.push.APP_VERSION", -1);
    }

    String getChannelId()
    {
        return preferenceDataStore.getString("com.urbanairship.push.CHANNEL_ID", null);
    }

    String getChannelLocation()
    {
        return preferenceDataStore.getString("com.urbanairship.push.CHANNEL_LOCATION", null);
    }

    String getDeviceId()
    {
        return preferenceDataStore.getString("com.urbanairship.push.DEVICE_ID", null);
    }

    String getGcmId()
    {
        return preferenceDataStore.getString("com.urbanairship.push.GCM_REGISTRATION_ID_KEY", null);
    }

    String getGcmToken()
    {
        return preferenceDataStore.getString("com.urbanairship.push.GCM_INSTANCE_ID_TOKEN_KEY", null);
    }

    String getLastReceivedSendId()
    {
        return preferenceDataStore.getString("com.urbanairship.push.LAST_RECEIVED_SEND_ID", null);
    }

    boolean getPushEnabledSettingsMigrated()
    {
        return preferenceDataStore.getBoolean("com.urbanairship.push.PUSH_ENABLED_SETTINGS_MIGRATED", false);
    }

    Date[] getQuietTimeInterval()
    {
        int i = preferenceDataStore.getInt("com.urbanairship.push.QuietTime.START_HOUR", -1);
        int j = preferenceDataStore.getInt("com.urbanairship.push.QuietTime.START_MINUTE", -1);
        int k = preferenceDataStore.getInt("com.urbanairship.push.QuietTime.END_HOUR", -1);
        int l = preferenceDataStore.getInt("com.urbanairship.push.QuietTime.END_MINUTE", -1);
        if (i == -1 || j == -1 || k == -1 || l == -1)
        {
            return null;
        }
        Object obj = Calendar.getInstance();
        ((Calendar) (obj)).set(11, i);
        ((Calendar) (obj)).set(12, j);
        ((Calendar) (obj)).set(13, 0);
        obj = ((Calendar) (obj)).getTime();
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, k);
        calendar.set(12, l);
        calendar.set(13, 0);
        if (k < i)
        {
            calendar.add(5, 1);
        }
        return (new Date[] {
            obj, calendar.getTime()
        });
    }

    Set getRegisteredGcmSenderIds()
    {
        HashSet hashset = new HashSet();
        Object obj = preferenceDataStore.getJsonValue("com.urbanairship.push.REGISTERED_GCM_SENDER_IDS");
        if (((JsonValue) (obj)).isJsonList())
        {
            obj = ((JsonValue) (obj)).getList().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                JsonValue jsonvalue = (JsonValue)((Iterator) (obj)).next();
                if (jsonvalue.isString())
                {
                    hashset.add(jsonvalue.getString());
                }
            } while (true);
        }
        return hashset;
    }

    Set getTags()
    {
        HashSet hashset = new HashSet();
        Object obj = preferenceDataStore.getJsonValue("com.urbanairship.push.TAGS");
        if (((JsonValue) (obj)).isJsonList())
        {
            obj = ((JsonValue) (obj)).getList().iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                JsonValue jsonvalue = (JsonValue)((Iterator) (obj)).next();
                if (jsonvalue.isString())
                {
                    hashset.add(jsonvalue.getString());
                }
            } while (true);
        }
        return hashset;
    }

    boolean getUserNotificationsEnabled()
    {
        return preferenceDataStore.getBoolean("com.urbanairship.push.USER_NOTIFICATIONS_ENABLED", false);
    }

    boolean isInQuietTime()
    {
        if (isQuietTimeEnabled())
        {
            Calendar calendar = Calendar.getInstance();
            int i = preferenceDataStore.getInt("com.urbanairship.push.QuietTime.START_HOUR", -1);
            int j = preferenceDataStore.getInt("com.urbanairship.push.QuietTime.START_MINUTE", -1);
            int k = preferenceDataStore.getInt("com.urbanairship.push.QuietTime.END_HOUR", -1);
            int l = preferenceDataStore.getInt("com.urbanairship.push.QuietTime.END_MINUTE", -1);
            if (-1 != i && -1 != j && -1 != k && -1 != l)
            {
                Calendar calendar1 = Calendar.getInstance();
                calendar1.set(11, i);
                calendar1.set(12, j);
                calendar1.set(13, 0);
                Calendar calendar2 = Calendar.getInstance();
                calendar2.set(11, k);
                calendar2.set(12, l);
                calendar2.set(13, 0);
                if (calendar1.after(calendar) && calendar2.before(calendar1))
                {
                    calendar1.add(6, -1);
                }
                if (calendar2.before(calendar1))
                {
                    calendar2.add(6, 1);
                }
                if (calendar.after(calendar1) && calendar.before(calendar2))
                {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isPushEnabled()
    {
        return preferenceDataStore.getBoolean("com.urbanairship.push.PUSH_ENABLED", true);
    }

    boolean isQuietTimeEnabled()
    {
        return preferenceDataStore.getBoolean("com.urbanairship.push.QuietTime.ENABLED", false);
    }

    boolean isSoundEnabled()
    {
        return preferenceDataStore.getBoolean("com.urbanairship.push.SOUND_ENABLED", true);
    }

    boolean isVibrateEnabled()
    {
        return preferenceDataStore.getBoolean("com.urbanairship.push.VIBRATE_ENABLED", true);
    }

    void migratePushEnabledSettings()
    {
        if (getPushEnabledSettingsMigrated())
        {
            return;
        }
        Logger.info("Migrating push enabled preferences");
        boolean flag = preferenceDataStore.getBoolean("com.urbanairship.push.PUSH_ENABLED", false);
        Logger.info((new StringBuilder("Setting user notifications enabled to ")).append(Boolean.toString(flag)).toString());
        setUserNotificationsEnabled(flag);
        if (!flag)
        {
            Logger.info("Push is now enabled. You can continue to toggle the opt-in state by enabling or disabling user notifications");
        }
        setPushEnabled(true);
        setPushEnabledSettingsMigrated(true);
    }

    void setAdmId(String s)
    {
        preferenceDataStore.put("com.urbanairship.push.ADM_REGISTRATION_ID_KEY", s);
    }

    void setAlias(String s)
    {
        preferenceDataStore.put("com.urbanairship.push.ALIAS", s);
    }

    void setAppVersionCode(int i)
    {
        preferenceDataStore.put("com.urbanairship.push.APP_VERSION", i);
    }

    void setChannelId(String s)
    {
        preferenceDataStore.put("com.urbanairship.push.CHANNEL_ID", s);
    }

    void setChannelLocation(String s)
    {
        preferenceDataStore.put("com.urbanairship.push.CHANNEL_LOCATION", s);
    }

    void setDeviceId(String s)
    {
        preferenceDataStore.put("com.urbanairship.push.DEVICE_ID", s);
    }

    void setGcmId(String s)
    {
        preferenceDataStore.put("com.urbanairship.push.GCM_REGISTRATION_ID_KEY", s);
    }

    void setGcmToken(String s)
    {
        preferenceDataStore.put("com.urbanairship.push.GCM_INSTANCE_ID_TOKEN_KEY", s);
    }

    void setLastReceivedSendId(String s)
    {
        preferenceDataStore.put("com.urbanairship.push.LAST_RECEIVED_SEND_ID", s);
    }

    void setPushEnabled(boolean flag)
    {
        preferenceDataStore.put("com.urbanairship.push.PUSH_ENABLED", flag);
    }

    void setPushEnabledSettingsMigrated(boolean flag)
    {
        preferenceDataStore.put("com.urbanairship.push.PUSH_ENABLED_SETTINGS_MIGRATED", flag);
    }

    void setQuietTimeEnabled(boolean flag)
    {
        preferenceDataStore.put("com.urbanairship.push.QuietTime.ENABLED", flag);
    }

    void setQuietTimeInterval(Date date, Date date1)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int i = calendar.get(11);
        int j = calendar.get(12);
        date = Calendar.getInstance();
        date.setTime(date1);
        int k = date.get(11);
        int l = date.get(12);
        preferenceDataStore.put("com.urbanairship.push.QuietTime.START_HOUR", i);
        preferenceDataStore.put("com.urbanairship.push.QuietTime.START_MINUTE", j);
        preferenceDataStore.put("com.urbanairship.push.QuietTime.END_HOUR", k);
        preferenceDataStore.put("com.urbanairship.push.QuietTime.END_MINUTE", l);
    }

    void setRegisteredGcmSenderIds(Set set)
    {
        preferenceDataStore.put("com.urbanairship.push.REGISTERED_GCM_SENDER_IDS", JsonValue.wrap(set, null));
    }

    void setSoundEnabled(boolean flag)
    {
        preferenceDataStore.put("com.urbanairship.push.SOUND_ENABLED", flag);
    }

    void setTags(Set set)
    {
        if (set == null || set.isEmpty())
        {
            preferenceDataStore.remove("com.urbanairship.push.TAGS");
            return;
        } else
        {
            preferenceDataStore.put("com.urbanairship.push.TAGS", JsonValue.wrap(set, null));
            return;
        }
    }

    void setUserNotificationsEnabled(boolean flag)
    {
        preferenceDataStore.put("com.urbanairship.push.USER_NOTIFICATIONS_ENABLED", flag);
    }

    void setVibrateEnabled(boolean flag)
    {
        preferenceDataStore.put("com.urbanairship.push.VIBRATE_ENABLED", flag);
    }
}
