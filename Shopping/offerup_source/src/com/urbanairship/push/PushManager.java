// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.util.Log;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.BaseManager;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.push.notifications.DefaultNotificationFactory;
import com.urbanairship.push.notifications.NotificationActionButtonGroup;
import com.urbanairship.push.notifications.NotificationFactory;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.richpush.RichPushUser;
import com.urbanairship.util.UAStringUtil;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.urbanairship.push:
//            PushPreferences, NamedUser, NotificationActionButtonGroupFactory, TagUtils, 
//            PushService, TagGroupsEditor, ChannelRegistrationPayload

public class PushManager extends BaseManager
{

    public static final String ACTION_CHANNEL_UPDATED = "com.urbanairship.push.CHANNEL_UPDATED";
    public static final String ACTION_NOTIFICATION_BUTTON_OPENED_PROXY = "com.urbanairship.ACTION_NOTIFICATION_BUTTON_OPENED_PROXY";
    public static final String ACTION_NOTIFICATION_DISMISSED = "com.urbanairship.push.DISMISSED";
    public static final String ACTION_NOTIFICATION_DISMISSED_PROXY = "com.urbanairship.ACTION_NOTIFICATION_DISMISSED_PROXY";
    public static final String ACTION_NOTIFICATION_OPENED = "com.urbanairship.push.OPENED";
    public static final String ACTION_NOTIFICATION_OPENED_PROXY = "com.urbanairship.ACTION_NOTIFICATION_OPENED_PROXY";
    public static final String ACTION_PUSH_RECEIVED = "com.urbanairship.push.RECEIVED";
    public static final String EXTRA_CHANNEL_ID = "com.urbanairship.push.EXTRA_CHANNEL_ID";
    public static final String EXTRA_ERROR = "com.urbanairship.push.EXTRA_ERROR";
    public static final String EXTRA_NOTIFICATION_ACTION_BUTTON_DESCRIPTION = "com.urbanairship.push.EXTRA_NOTIFICATION_ACTION_BUTTON_DESCRIPTION";
    public static final String EXTRA_NOTIFICATION_BUTTON_ACTIONS_PAYLOAD = "com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ACTIONS_PAYLOAD";
    public static final String EXTRA_NOTIFICATION_BUTTON_FOREGROUND = "com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_FOREGROUND";
    public static final String EXTRA_NOTIFICATION_BUTTON_ID = "com.urbanairship.push.EXTRA_NOTIFICATION_BUTTON_ID";
    public static final String EXTRA_NOTIFICATION_CONTENT_INTENT = "com.urbanairship.push.EXTRA_NOTIFICATION_CONTENT_INTENT";
    public static final String EXTRA_NOTIFICATION_DELETE_INTENT = "com.urbanairship.push.EXTRA_NOTIFICATION_DELETE_INTENT";
    public static final String EXTRA_NOTIFICATION_ID = "com.urbanairship.push.NOTIFICATION_ID";
    public static final String EXTRA_PUSH_MESSAGE = "com.urbanairship.push.EXTRA_PUSH_MESSAGE";
    private final String DEFAULT_TAG_GROUP;
    private final String UA_NOTIFICATION_BUTTON_GROUP_PREFIX;
    private final Map actionGroupMap;
    private boolean channelCreationDelayEnabled;
    private boolean channelTagRegistrationEnabled;
    private final AirshipConfigOptions configOptions;
    private final NamedUser namedUser;
    private NotificationFactory notificationFactory;
    private final PushPreferences preferences;

    public PushManager(Context context, PreferenceDataStore preferencedatastore, AirshipConfigOptions airshipconfigoptions)
    {
        this(context, new PushPreferences(preferencedatastore), new NamedUser(preferencedatastore), airshipconfigoptions);
    }

    PushManager(Context context, PushPreferences pushpreferences, NamedUser nameduser, AirshipConfigOptions airshipconfigoptions)
    {
        UA_NOTIFICATION_BUTTON_GROUP_PREFIX = "ua_";
        DEFAULT_TAG_GROUP = "device";
        actionGroupMap = new HashMap();
        channelTagRegistrationEnabled = true;
        preferences = pushpreferences;
        notificationFactory = new DefaultNotificationFactory(context);
        namedUser = nameduser;
        configOptions = airshipconfigoptions;
        if (Logger.logLevel < 7 && !UAStringUtil.isEmpty(getChannelId()))
        {
            Log.d((new StringBuilder()).append(UAirship.getAppName()).append(" Channel ID").toString(), getChannelId());
        }
        actionGroupMap.putAll(NotificationActionButtonGroupFactory.createUrbanAirshipGroups());
    }

    static String getSecureId(Context context)
    {
        return android.provider.Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public void addNotificationActionButtonGroup(String s, NotificationActionButtonGroup notificationactionbuttongroup)
    {
        if (s.startsWith("ua_"))
        {
            Logger.warn("Unable to add any notification button groups that starts with the reserved Urban Airship prefix ua_");
            return;
        } else
        {
            actionGroupMap.put(s, notificationactionbuttongroup);
            return;
        }
    }

    public TagGroupsEditor editTagGroups()
    {
        return new _cls1("com.urbanairship.push.ACTION_UPDATE_CHANNEL_TAG_GROUPS");
    }

    public void enableChannelCreation()
    {
        if (isChannelCreationDelayEnabled())
        {
            channelCreationDelayEnabled = false;
            updateRegistration();
        }
    }

    public String getAdmId()
    {
        return preferences.getAdmId();
    }

    public String getAlias()
    {
        return preferences.getAlias();
    }

    public String getChannelId()
    {
        return preferences.getChannelId();
    }

    String getChannelLocation()
    {
        return preferences.getChannelLocation();
    }

    public boolean getChannelTagRegistrationEnabled()
    {
        return channelTagRegistrationEnabled;
    }

    public boolean getDeviceTagsEnabled()
    {
        return getChannelTagRegistrationEnabled();
    }

    public String getGcmId()
    {
        return preferences.getGcmId();
    }

    public String getGcmToken()
    {
        return preferences.getGcmToken();
    }

    public String getLastReceivedSendId()
    {
        return preferences.getLastReceivedSendId();
    }

    public NamedUser getNamedUser()
    {
        return namedUser;
    }

    ChannelRegistrationPayload getNextChannelRegistrationPayload()
    {
        ChannelRegistrationPayload.Builder builder;
        builder = (new ChannelRegistrationPayload.Builder()).setAlias(getAlias()).setTags(getChannelTagRegistrationEnabled(), getTags()).setOptIn(isOptIn());
        boolean flag;
        if (isPushEnabled() && isPushAvailable())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        builder = builder.setBackgroundEnabled(flag).setUserId(UAirship.shared().getRichPushManager().getRichPushUser().getId()).setApid(preferences.getApid());
        UAirship.shared().getPlatformType();
        JVM INSTR tableswitch 1 2: default 108
    //                   1 136
    //                   2 118;
           goto _L1 _L2 _L3
_L1:
        return builder.build();
_L3:
        builder.setDeviceType("android").setPushAddress(getGcmToken());
        continue; /* Loop/switch isn't completed */
_L2:
        builder.setDeviceType("amazon").setPushAddress(getAdmId());
        if (true) goto _L1; else goto _L4
_L4:
    }

    public NotificationActionButtonGroup getNotificationActionGroup(String s)
    {
        return (NotificationActionButtonGroup)actionGroupMap.get(s);
    }

    public NotificationFactory getNotificationFactory()
    {
        return notificationFactory;
    }

    PushPreferences getPreferences()
    {
        return preferences;
    }

    public Date[] getQuietTimeInterval()
    {
        return preferences.getQuietTimeInterval();
    }

    public Set getTags()
    {
        Set set = preferences.getTags();
        Set set1 = TagUtils.normalizeTags(set);
        if (set.size() != set1.size())
        {
            setTags(set1);
        }
        return set1;
    }

    public boolean getUserNotificationsEnabled()
    {
        return preferences.getUserNotificationsEnabled();
    }

    protected void init()
    {
        preferences.migratePushEnabledSettings();
        Intent intent;
        if (preferences.getChannelId() == null && configOptions.channelCreationDelayEnabled)
        {
            channelCreationDelayEnabled = true;
        } else
        {
            channelCreationDelayEnabled = false;
        }
        intent = (new Intent(UAirship.getApplicationContext(), com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_START_REGISTRATION");
        UAirship.getApplicationContext().startService(intent);
        if (getChannelId() != null)
        {
            startUpdateTagsService();
        }
        namedUser.startUpdateService();
        if (namedUser.getId() != null)
        {
            namedUser.startUpdateTagsService();
        }
    }

    boolean isChannelCreationDelayEnabled()
    {
        return channelCreationDelayEnabled;
    }

    public boolean isInQuietTime()
    {
        return preferences.isInQuietTime();
    }

    public boolean isOptIn()
    {
        return isPushEnabled() && isPushAvailable() && getUserNotificationsEnabled();
    }

    public boolean isPushAvailable()
    {
        boolean flag = true;
        UAirship.shared().getPlatformType();
        JVM INSTR tableswitch 1 2: default 32
    //                   1 36
    //                   2 51;
           goto _L1 _L2 _L3
_L1:
        flag = false;
_L5:
        return flag;
_L2:
        if (UAStringUtil.isEmpty(getPreferences().getAdmId()))
        {
            return false;
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (UAStringUtil.isEmpty(getPreferences().getGcmToken()))
        {
            return false;
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public boolean isPushEnabled()
    {
        return preferences.isPushEnabled();
    }

    public boolean isQuietTimeEnabled()
    {
        return preferences.isQuietTimeEnabled();
    }

    public boolean isSoundEnabled()
    {
        return preferences.isSoundEnabled();
    }

    public boolean isVibrateEnabled()
    {
        return preferences.isVibrateEnabled();
    }

    public void removeNotificationActionButtonGroup(String s)
    {
        if (s.startsWith("ua_"))
        {
            Logger.error("Unable to remove any reserved Urban Airship actions groups that begin with ua_");
            return;
        } else
        {
            actionGroupMap.remove(s);
            return;
        }
    }

    void setAdmId(String s)
    {
        preferences.setAppVersionCode(UAirship.getPackageInfo().versionCode);
        preferences.setAdmId(s);
        preferences.setDeviceId(getSecureId(UAirship.getApplicationContext()));
    }

    public void setAlias(String s)
    {
        String s1 = s;
        if (s != null)
        {
            s1 = s.trim();
        }
        if (!UAStringUtil.equals(s1, preferences.getAlias()))
        {
            preferences.setAlias(s1);
            updateRegistration();
        }
    }

    public void setAliasAndTags(String s, Set set)
    {
        boolean flag1 = true;
        if (set == null)
        {
            throw new IllegalArgumentException("Tags must be non-null.");
        }
        set = TagUtils.normalizeTags(set);
        boolean flag = false;
        if (!UAStringUtil.equals(s, preferences.getAlias()))
        {
            preferences.setAlias(s);
            flag = true;
        }
        if (!set.equals(preferences.getTags()))
        {
            preferences.setTags(set);
            flag = flag1;
        }
        if (flag)
        {
            updateRegistration();
        }
    }

    void setChannel(String s, String s1)
    {
        preferences.setChannelId(s);
        preferences.setChannelLocation(s1);
    }

    public void setChannelTagRegistrationEnabled(boolean flag)
    {
        channelTagRegistrationEnabled = flag;
    }

    public void setDeviceTagsEnabled(boolean flag)
    {
        setChannelTagRegistrationEnabled(flag);
    }

    void setGcmId(String s)
    {
        preferences.setGcmId(s);
    }

    void setGcmToken(String s)
    {
        preferences.setGcmToken(s);
        preferences.setAppVersionCode(UAirship.getPackageInfo().versionCode);
        preferences.setDeviceId(getSecureId(UAirship.getApplicationContext()));
    }

    void setLastReceivedSendId(String s)
    {
        preferences.setLastReceivedSendId(s);
    }

    public void setNotificationFactory(NotificationFactory notificationfactory)
    {
        notificationFactory = notificationfactory;
    }

    public void setPushEnabled(boolean flag)
    {
        preferences.setPushEnabled(flag);
        updateRegistration();
    }

    public void setQuietTimeEnabled(boolean flag)
    {
        preferences.setQuietTimeEnabled(flag);
    }

    public void setQuietTimeInterval(Date date, Date date1)
    {
        preferences.setQuietTimeInterval(date, date1);
    }

    public void setSoundEnabled(boolean flag)
    {
        preferences.setSoundEnabled(flag);
    }

    public void setTags(Set set)
    {
        if (set == null)
        {
            throw new IllegalArgumentException("Tags must be non-null.");
        }
        set = TagUtils.normalizeTags(set);
        if (!set.equals(preferences.getTags()))
        {
            preferences.setTags(set);
            updateRegistration();
        }
    }

    public void setUserNotificationsEnabled(boolean flag)
    {
        preferences.setUserNotificationsEnabled(flag);
        updateRegistration();
    }

    public void setVibrateEnabled(boolean flag)
    {
        preferences.setVibrateEnabled(flag);
    }

    void startUpdateTagsService()
    {
        Intent intent = (new Intent(UAirship.getApplicationContext(), com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_TAG_GROUPS");
        UAirship.getApplicationContext().startService(intent);
    }

    public void updateRegistration()
    {
        Context context = UAirship.getApplicationContext();
        Intent intent = new Intent(context, com/urbanairship/push/PushService);
        intent.setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION");
        context.startService(intent);
    }


    private class _cls1 extends TagGroupsEditor
    {

        final PushManager this$0;

        public TagGroupsEditor addTag(String s, String s1)
        {
            if (channelTagRegistrationEnabled && "device".equals(s))
            {
                Logger.error((new StringBuilder("Unable to add tag ")).append(s1).append(" to device tag group when channelTagRegistrationEnabled is true.").toString());
                return this;
            } else
            {
                return super.addTag(s, s1);
            }
        }

        public TagGroupsEditor addTags(String s, Set set)
        {
            if (channelTagRegistrationEnabled && "device".equals(s))
            {
                Logger.error((new StringBuilder("Unable to add tags { ")).append(set).append(" } to device tag group when channelTagRegistrationEnabled is true.").toString());
                return this;
            } else
            {
                return super.addTags(s, set);
            }
        }

        public TagGroupsEditor removeTag(String s, String s1)
        {
            if (channelTagRegistrationEnabled && "device".equals(s))
            {
                Logger.error((new StringBuilder("Unable to remove tag ")).append(s1).append(" from device tag group when channelTagRegistrationEnabled is true.").toString());
                return this;
            } else
            {
                return super.removeTag(s, s1);
            }
        }

        public TagGroupsEditor removeTags(String s, Set set)
        {
            if (channelTagRegistrationEnabled && "device".equals(s))
            {
                Logger.error((new StringBuilder("Unable to remove tags { ")).append(set).append(" } from device tag group when channelTagRegistrationEnabled is true.").toString());
                return this;
            } else
            {
                return super.removeTags(s, set);
            }
        }

        _cls1(String s)
        {
            this$0 = PushManager.this;
            super(s);
        }
    }

}
