// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.preference;

import android.os.Handler;
import android.os.Looper;
import android.preference.Preference;
import android.preference.PreferenceGroup;
import android.preference.PreferenceScreen;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.location.UALocationManager;
import com.urbanairship.push.PushManager;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.richpush.RichPushUser;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.urbanairship.preference:
//            UAPreference

public class UAPreferenceAdapter
{

    private static final int CHANNEL_ID_MAX_RETRIES = 4;
    private static final int CHANNEL_ID_RETRY_DELAY = 1000;
    private int channelIdRetryCount;
    private final Map preferences = new HashMap();

    public UAPreferenceAdapter(PreferenceScreen preferencescreen)
    {
        channelIdRetryCount = 0;
        checkForUAPreferences(preferencescreen);
    }

    private void checkForUAPreferences(PreferenceGroup preferencegroup)
    {
        if (preferencegroup != null)
        {
            int i = 0;
            while (i < preferencegroup.getPreferenceCount()) 
            {
                Preference preference = preferencegroup.getPreference(i);
                if (preference instanceof PreferenceGroup)
                {
                    checkForUAPreferences((PreferenceGroup)preference);
                } else
                if (preference instanceof UAPreference)
                {
                    trackPreference((UAPreference)preference);
                }
                i++;
            }
        }
    }

    private Object getInternalPreference(UAPreference.PreferenceType preferencetype)
    {
        UAirship uairship = UAirship.shared();
        _cls3..SwitchMap.com.urbanairship.preference.UAPreference.PreferenceType[preferencetype.ordinal()];
        JVM INSTR tableswitch 1 11: default 72
    //                   1 74
    //                   2 85
    //                   3 96
    //                   4 107
    //                   5 118
    //                   6 140
    //                   7 162
    //                   8 173
    //                   9 184
    //                   10 192
    //                   11 203;
           goto _L1 _L2 _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11 _L12
_L9:
        break MISSING_BLOCK_LABEL_173;
_L10:
        break MISSING_BLOCK_LABEL_184;
_L11:
        break MISSING_BLOCK_LABEL_192;
_L1:
        break; /* Loop/switch isn't completed */
_L12:
        break MISSING_BLOCK_LABEL_203;
_L13:
        return null;
_L2:
        return Boolean.valueOf(uairship.getLocationManager().isLocationUpdatesEnabled());
_L3:
        return Boolean.valueOf(uairship.getLocationManager().isBackgroundLocationAllowed());
_L4:
        return Boolean.valueOf(uairship.getPushManager().getUserNotificationsEnabled());
_L5:
        return Boolean.valueOf(uairship.getPushManager().isQuietTimeEnabled());
_L6:
        preferencetype = uairship.getPushManager().getQuietTimeInterval();
        if (preferencetype != null)
        {
            return Long.valueOf(preferencetype[1].getTime());
        }
        continue; /* Loop/switch isn't completed */
_L7:
        preferencetype = uairship.getPushManager().getQuietTimeInterval();
        if (preferencetype != null)
        {
            return Long.valueOf(preferencetype[0].getTime());
        }
        if (true) goto _L13; else goto _L8
_L8:
        return Boolean.valueOf(uairship.getPushManager().isSoundEnabled());
        return Boolean.valueOf(uairship.getPushManager().isVibrateEnabled());
        return uairship.getPushManager().getChannelId();
        return uairship.getRichPushManager().getRichPushUser().getId();
        return Boolean.valueOf(uairship.getAnalytics().isEnabled());
    }

    private void setInternalPreference(UAPreference.PreferenceType preferencetype, Object obj)
    {
        UAirship uairship = UAirship.shared();
        switch (_cls3..SwitchMap.com.urbanairship.preference.UAPreference.PreferenceType[preferencetype.ordinal()])
        {
        case 9: // '\t'
        case 10: // '\n'
        default:
            return;

        case 2: // '\002'
            uairship.getLocationManager().setBackgroundLocationAllowed(((Boolean)obj).booleanValue());
            return;

        case 1: // '\001'
            uairship.getLocationManager().setLocationUpdatesEnabled(((Boolean)obj).booleanValue());
            return;

        case 3: // '\003'
            uairship.getPushManager().setUserNotificationsEnabled(((Boolean)obj).booleanValue());
            return;

        case 4: // '\004'
            uairship.getPushManager().setQuietTimeEnabled(((Boolean)obj).booleanValue());
            return;

        case 7: // '\007'
            uairship.getPushManager().setSoundEnabled(((Boolean)obj).booleanValue());
            return;

        case 8: // '\b'
            uairship.getPushManager().setVibrateEnabled(((Boolean)obj).booleanValue());
            return;

        case 5: // '\005'
            preferencetype = uairship.getPushManager().getQuietTimeInterval();
            if (preferencetype != null)
            {
                preferencetype = preferencetype[0];
            } else
            {
                preferencetype = new Date();
            }
            uairship.getPushManager().setQuietTimeInterval(preferencetype, new Date(((Long)obj).longValue()));
            return;

        case 6: // '\006'
            preferencetype = uairship.getPushManager().getQuietTimeInterval();
            if (preferencetype != null)
            {
                preferencetype = preferencetype[1];
            } else
            {
                preferencetype = new Date();
            }
            uairship.getPushManager().setQuietTimeInterval(new Date(((Long)obj).longValue()), preferencetype);
            return;

        case 11: // '\013'
            uairship.getAnalytics().setEnabled(((Boolean)obj).booleanValue());
            return;
        }
    }

    private void trackPreference(final UAPreference preference)
    {
        Object obj1 = UAirship.shared().getPushManager();
        final UAPreference.PreferenceType preferenceType = preference.getPreferenceType();
        if (preferenceType == null)
        {
            Logger.warn((new StringBuilder("Preference returned a null preference type. Ignoring preference ")).append(preference).toString());
            return;
        }
        Object obj = getInternalPreference(preferenceType);
        if (obj != null)
        {
            try
            {
                preference.setValue(obj);
            }
            // Misplaced declaration of an exception variable
            catch (Object obj1)
            {
                Logger.warn((new StringBuilder("Exception setting value ")).append(obj).append(". Ignoring preference ").append(preference).toString(), ((Throwable) (obj1)));
                return;
            }
        } else
        if (preferenceType == UAPreference.PreferenceType.CHANNEL_ID && ((PushManager) (obj1)).isPushEnabled() && channelIdRetryCount < 4)
        {
            channelIdRetryCount = channelIdRetryCount + 1;
            (new Handler(Looper.getMainLooper())).postDelayed(new _cls1(), 1000L);
            return;
        }
        ((Preference)preference).setOnPreferenceChangeListener(new _cls2());
    }

    public void applyUrbanAirshipPreferences()
    {
        Iterator iterator = preferences.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            UAPreference.PreferenceType preferencetype = (UAPreference.PreferenceType)iterator.next();
            Object obj = preferences.get(preferencetype);
            if (obj != null)
            {
                try
                {
                    setInternalPreference(preferencetype, obj);
                }
                catch (Exception exception)
                {
                    Logger.warn((new StringBuilder("Unable to set ")).append(preferencetype).append(", invalid value ").append(obj).toString(), exception);
                }
            }
        } while (true);
    }



    private class _cls3
    {

        static final int $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[];

        static 
        {
            $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType = new int[UAPreference.PreferenceType.values().length];
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.LOCATION_UPDATES_ENABLED.ordinal()] = 1;
            }
            catch (NoSuchFieldError nosuchfielderror10) { }
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.LOCATION_BACKGROUND_UPDATES_ALLOWED.ordinal()] = 2;
            }
            catch (NoSuchFieldError nosuchfielderror9) { }
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.USER_NOTIFICATIONS_ENABLED.ordinal()] = 3;
            }
            catch (NoSuchFieldError nosuchfielderror8) { }
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.QUIET_TIME_ENABLED.ordinal()] = 4;
            }
            catch (NoSuchFieldError nosuchfielderror7) { }
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.QUIET_TIME_END.ordinal()] = 5;
            }
            catch (NoSuchFieldError nosuchfielderror6) { }
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.QUIET_TIME_START.ordinal()] = 6;
            }
            catch (NoSuchFieldError nosuchfielderror5) { }
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.SOUND_ENABLED.ordinal()] = 7;
            }
            catch (NoSuchFieldError nosuchfielderror4) { }
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.VIBRATE_ENABLED.ordinal()] = 8;
            }
            catch (NoSuchFieldError nosuchfielderror3) { }
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.CHANNEL_ID.ordinal()] = 9;
            }
            catch (NoSuchFieldError nosuchfielderror2) { }
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.USER_ID.ordinal()] = 10;
            }
            catch (NoSuchFieldError nosuchfielderror1) { }
            try
            {
                $SwitchMap$com$urbanairship$preference$UAPreference$PreferenceType[UAPreference.PreferenceType.ANALYTICS_ENABLED.ordinal()] = 11;
            }
            catch (NoSuchFieldError nosuchfielderror)
            {
                return;
            }
        }
    }


    private class _cls2
        implements android.preference.Preference.OnPreferenceChangeListener
    {

        final UAPreferenceAdapter this$0;
        final UAPreference.PreferenceType val$preferenceType;

        public boolean onPreferenceChange(Preference preference, Object obj)
        {
            preferences.put(preferenceType, obj);
            return true;
        }

        _cls2()
        {
            this$0 = UAPreferenceAdapter.this;
            preferenceType = preferencetype;
            super();
        }
    }


    private class _cls1
        implements Runnable
    {

        final UAPreferenceAdapter this$0;
        final UAPreference val$preference;

        public void run()
        {
            trackPreference(preference);
        }

        _cls1()
        {
            this$0 = UAPreferenceAdapter.this;
            preference = uapreference;
            super();
        }
    }

}
