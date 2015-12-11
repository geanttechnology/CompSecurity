// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.amazon.ADMUtils;
import com.urbanairship.analytics.EventService;
import com.urbanairship.google.PlayServicesUtils;
import com.urbanairship.json.JsonException;
import com.urbanairship.richpush.RichPushManager;
import com.urbanairship.util.UAHttpStatusUtil;
import com.urbanairship.util.UAStringUtil;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

// Referenced classes of package com.urbanairship.push:
//            ChannelAPIClient, PushManager, ChannelResponse, NamedUser, 
//            ChannelRegistrationPayload, PushPreferences, PushService, GCMRegistrar

class ChannelServiceDelegate extends com.urbanairship.BaseIntentService.Delegate
{

    private static final long CHANNEL_REREGISTRATION_INTERVAL_MS = 0x5265c00L;
    private static final String LAST_REGISTRATION_PAYLOAD_KEY = "com.urbanairship.push.LAST_REGISTRATION_PAYLOAD";
    private static final String LAST_REGISTRATION_TIME_KEY = "com.urbanairship.push.LAST_REGISTRATION_TIME";
    private static boolean isPushRegistering = false;
    private static boolean isRegistrationStarted = false;
    private final UAirship airship;
    private final ChannelAPIClient channelClient;
    private final PushManager pushManager;
    private final PushPreferences pushPreferences;

    public ChannelServiceDelegate(Context context, PreferenceDataStore preferencedatastore)
    {
        this(context, preferencedatastore, new ChannelAPIClient(), UAirship.shared());
    }

    public ChannelServiceDelegate(Context context, PreferenceDataStore preferencedatastore, ChannelAPIClient channelapiclient, UAirship uairship)
    {
        super(context, preferencedatastore);
        channelClient = channelapiclient;
        airship = uairship;
        pushManager = uairship.getPushManager();
        pushPreferences = uairship.getPushManager().getPreferences();
    }

    private void createChannel(Intent intent, ChannelRegistrationPayload channelregistrationpayload)
    {
        if (pushManager.isChannelCreationDelayEnabled())
        {
            Logger.info("Channel registration is currently disabled.");
            return;
        }
        ChannelResponse channelresponse = channelClient.createChannelWithPayload(channelregistrationpayload);
        if (channelresponse == null || UAHttpStatusUtil.inServerErrorRange(channelresponse.getStatus()))
        {
            Logger.error("Channel registration failed, will retry.");
            retryIntent(intent);
            return;
        }
        if (channelresponse.getStatus() == 200 || channelresponse.getStatus() == 201)
        {
            if (!UAStringUtil.isEmpty(channelresponse.getChannelLocation()) && !UAStringUtil.isEmpty(channelresponse.getChannelId()))
            {
                Logger.info((new StringBuilder("Channel creation succeeded with status: ")).append(channelresponse.getStatus()).append(" channel ID: ").append(channelresponse.getChannelId()).toString());
                pushManager.setChannel(channelresponse.getChannelId(), channelresponse.getChannelLocation());
                setLastRegistrationPayload(channelregistrationpayload);
                sendRegistrationFinishedBroadcast(true);
                if (channelresponse.getStatus() == 200 && airship.getAirshipConfigOptions().clearNamedUser)
                {
                    pushManager.getNamedUser().disassociateNamedUserIfNull();
                }
                pushManager.getNamedUser().startUpdateService();
                pushManager.updateRegistration();
                pushManager.startUpdateTagsService();
                airship.getRichPushManager().updateUser(true);
                intent = (new Intent(getContext(), com/urbanairship/analytics/EventService)).setAction("com.urbanairship.analytics.SEND");
                getContext().startService(intent);
                return;
            } else
            {
                Logger.error((new StringBuilder("Failed to register with channel ID: ")).append(channelresponse.getChannelId()).append(" channel location: ").append(channelresponse.getChannelLocation()).toString());
                sendRegistrationFinishedBroadcast(false);
                return;
            }
        } else
        {
            Logger.error((new StringBuilder("Channel registration failed with status: ")).append(channelresponse.getStatus()).toString());
            sendRegistrationFinishedBroadcast(false);
            return;
        }
    }

    private URL getChannelLocationURL()
    {
        String s;
        s = pushManager.getChannelLocation();
        if (UAStringUtil.isEmpty(s))
        {
            break MISSING_BLOCK_LABEL_47;
        }
        URL url = new URL(s);
        return url;
        MalformedURLException malformedurlexception;
        malformedurlexception;
        Logger.error((new StringBuilder("Channel location from preferences was invalid: ")).append(s).toString(), malformedurlexception);
        return null;
    }

    private ChannelRegistrationPayload getLastRegistrationPayload()
    {
        Object obj = getDataStore().getString("com.urbanairship.push.LAST_REGISTRATION_PAYLOAD", null);
        try
        {
            obj = ChannelRegistrationPayload.parseJson(((String) (obj)));
        }
        catch (JsonException jsonexception)
        {
            Logger.error("ChannelServiceDelegate - Failed to parse payload from JSON.", jsonexception);
            return null;
        }
        return ((ChannelRegistrationPayload) (obj));
    }

    private long getLastRegistrationTime()
    {
        long l = getDataStore().getLong("com.urbanairship.push.LAST_REGISTRATION_TIME", 0L);
        if (l > System.currentTimeMillis())
        {
            getDataStore().put("com.urbanairship.push.LAST_REGISTRATION_TIME", 0);
            return 0L;
        } else
        {
            return l;
        }
    }

    private boolean isPushRegistrationAllowed()
    {
        switch (airship.getPlatformType())
        {
        default:
            return false;

        case 2: // '\002'
            if (!airship.getAirshipConfigOptions().isTransportAllowed("GCM"))
            {
                Logger.info("Unable to register for push. GCM transport type is not allowed.");
                return false;
            } else
            {
                return true;
            }

        case 1: // '\001'
            break;
        }
        if (!airship.getAirshipConfigOptions().isTransportAllowed("ADM"))
        {
            Logger.info("Unable to register for push. ADM transport type is not allowed.");
            return false;
        } else
        {
            return true;
        }
    }

    private boolean needsPushRegistration()
    {
        if (UAirship.getPackageInfo().versionCode == pushPreferences.getAppVersionCode()) goto _L2; else goto _L1
_L1:
        Logger.verbose((new StringBuilder("ChannelServiceDelegate - Version code changed to ")).append(UAirship.getPackageInfo().versionCode).append(". Push re-registration required.").toString());
_L7:
        return true;
_L2:
        if (!PushManager.getSecureId(getContext()).equals(pushPreferences.getDeviceId()))
        {
            Logger.verbose("ChannelServiceDelegate - Device ID changed. Push re-registration required.");
            return true;
        }
        airship.getPlatformType();
        JVM INSTR tableswitch 1 2: default 108
    //                   1 205
    //                   2 110;
           goto _L3 _L4 _L5
_L4:
        continue; /* Loop/switch isn't completed */
_L3:
        return false;
_L5:
        if (UAStringUtil.isEmpty(pushManager.getGcmId()) || UAStringUtil.isEmpty(pushManager.getGcmToken())) goto _L7; else goto _L6
_L6:
        Set set = airship.getAirshipConfigOptions().getGCMSenderIds();
        Set set1 = pushPreferences.getRegisteredGcmSenderIds();
        if (set1 != null && !set1.equals(set))
        {
            Logger.verbose("ChannelServiceDelegate - GCM sender IDs changed. Push re-registration required.");
            return true;
        } else
        {
            Logger.verbose((new StringBuilder("ChannelServiceDelegate - GCM already registered with ID: ")).append(pushManager.getGcmId()).toString());
            return false;
        }
        if (UAStringUtil.isEmpty(pushManager.getAdmId())) goto _L7; else goto _L8
_L8:
        Logger.verbose((new StringBuilder("ChannelServiceDelegate - ADM already registered with ID: ")).append(pushManager.getAdmId()).toString());
        return false;
    }

    private void onAdmRegistrationFinished(Intent intent)
    {
        if (airship.getPlatformType() != 1 || !ADMUtils.isADMAvailable())
        {
            Logger.error("Received intent from invalid transport acting as ADM.");
            return;
        }
        intent = (Intent)intent.getParcelableExtra("com.urbanairship.push.EXTRA_INTENT");
        if (intent == null)
        {
            Logger.error("ChannelServiceDelegate - Received ADM message missing original intent.");
            return;
        }
        if (!intent.hasExtra("error")) goto _L2; else goto _L1
_L1:
        Logger.error((new StringBuilder("ADM error occurred: ")).append(intent.getStringExtra("error")).toString());
_L4:
        isPushRegistering = false;
        intent = (new Intent(getContext(), com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION");
        getContext().startService(intent);
        return;
_L2:
        intent = intent.getStringExtra("registration_id");
        if (intent != null)
        {
            Logger.info((new StringBuilder("ADM registration successful. Registration ID: ")).append(intent).toString());
            pushManager.setAdmId(intent);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void onStartRegistration()
    {
        if (isRegistrationStarted)
        {
            return;
        }
        isRegistrationStarted = true;
        if (isPushRegistrationAllowed() && needsPushRegistration())
        {
            isPushRegistering = true;
            Intent intent = (new Intent(getContext(), com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_UPDATE_PUSH_REGISTRATION");
            getContext().startService(intent);
            return;
        } else
        {
            Intent intent1 = (new Intent(getContext(), com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION");
            getContext().startService(intent1);
            return;
        }
    }

    private void onUpdateChannelRegistration(Intent intent)
    {
        if (isPushRegistering)
        {
            Logger.verbose("ChannelServiceDelegate - Push registration in progress, skipping registration update.");
            return;
        }
        Logger.verbose("ChannelServiceDelegate - Performing channel registration.");
        ChannelRegistrationPayload channelregistrationpayload = pushManager.getNextChannelRegistrationPayload();
        String s = pushManager.getChannelId();
        URL url = getChannelLocationURL();
        if (url != null && !UAStringUtil.isEmpty(s))
        {
            updateChannel(intent, url, channelregistrationpayload);
            return;
        } else
        {
            createChannel(intent, channelregistrationpayload);
            return;
        }
    }

    private void onUpdatePushRegistration(Intent intent)
    {
        isPushRegistering = false;
        airship.getPlatformType();
        JVM INSTR tableswitch 1 2: default 32
    //                   1 167
    //                   2 75;
           goto _L1 _L2 _L3
_L1:
        Logger.error("Unknown platform type. Unable to register for push.");
_L5:
        if (!isPushRegistering)
        {
            intent = (new Intent(getContext(), com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION");
            getContext().startService(intent);
        }
        return;
_L3:
        if (intent.getBooleanExtra("com.urbanairship.push.EXTRA_GCM_TOKEN_REFRESH", false))
        {
            pushManager.setGcmToken(null);
            intent.removeExtra("com.urbanairship.push.EXTRA_GCM_TOKEN_REFRESH");
        }
        if (!PlayServicesUtils.isGoogleCloudMessagingDependencyAvailable())
        {
            Logger.error("GCM is unavailable. Unable to register for push notifications. If using the modular Google Play Services dependencies, make sure the application includes the com.google.android.gms:play-services-gcm dependency.");
        } else
        {
            try
            {
                if (!GCMRegistrar.register())
                {
                    Logger.error("GCM registration failed.");
                }
            }
            catch (IOException ioexception)
            {
                Logger.error((new StringBuilder("GCM registration failed, will retry. GCM error: ")).append(ioexception.getMessage()).toString());
                isPushRegistering = true;
                retryIntent(intent);
            }
        }
        continue; /* Loop/switch isn't completed */
_L2:
        if (ADMUtils.isADMSupported())
        {
            ADMUtils.startRegistration(getContext());
            isPushRegistering = true;
        } else
        {
            Logger.error("ADM is not supported on this device.");
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    private void sendRegistrationFinishedBroadcast(boolean flag)
    {
        Intent intent = (new Intent("com.urbanairship.push.CHANNEL_UPDATED")).putExtra("com.urbanairship.push.EXTRA_CHANNEL_ID", pushManager.getChannelId()).addCategory(UAirship.getPackageName()).setPackage(UAirship.getPackageName());
        if (!flag)
        {
            intent.putExtra("com.urbanairship.push.EXTRA_ERROR", true);
        }
        getContext().sendBroadcast(intent, UAirship.getUrbanAirshipPermission());
    }

    private void setLastRegistrationPayload(ChannelRegistrationPayload channelregistrationpayload)
    {
        getDataStore().put("com.urbanairship.push.LAST_REGISTRATION_PAYLOAD", channelregistrationpayload);
        getDataStore().put("com.urbanairship.push.LAST_REGISTRATION_TIME", System.currentTimeMillis());
    }

    private boolean shouldUpdateRegistration(ChannelRegistrationPayload channelregistrationpayload)
    {
        ChannelRegistrationPayload channelregistrationpayload1 = getLastRegistrationPayload();
        long l = System.currentTimeMillis();
        long l1 = getLastRegistrationTime();
        return !channelregistrationpayload.equals(channelregistrationpayload1) || l - l1 >= 0x5265c00L;
    }

    private void updateChannel(Intent intent, URL url, ChannelRegistrationPayload channelregistrationpayload)
    {
        if (!shouldUpdateRegistration(channelregistrationpayload))
        {
            Logger.verbose("ChannelServiceDelegate - Channel already up to date.");
            return;
        }
        url = channelClient.updateChannelWithPayload(url, channelregistrationpayload);
        if (url == null || UAHttpStatusUtil.inServerErrorRange(url.getStatus()))
        {
            Logger.error("Channel registration failed, will retry.");
            retryIntent(intent);
            return;
        }
        if (UAHttpStatusUtil.inSuccessRange(url.getStatus()))
        {
            Logger.info((new StringBuilder("Channel registration succeeded with status: ")).append(url.getStatus()).toString());
            setLastRegistrationPayload(channelregistrationpayload);
            sendRegistrationFinishedBroadcast(true);
            return;
        }
        if (url.getStatus() == 409)
        {
            pushManager.setChannel(null, null);
            intent = (new Intent(getContext(), com/urbanairship/push/PushService)).setAction("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION");
            getContext().startService(intent);
            return;
        } else
        {
            Logger.error((new StringBuilder("Channel registration failed with status: ")).append(url.getStatus()).toString());
            sendRegistrationFinishedBroadcast(false);
            return;
        }
    }

    protected void onHandleIntent(Intent intent)
    {
        String s;
        byte byte0;
        s = intent.getAction();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 4: default 52
    //                   -1003583816: 85
    //                   -901120150: 100
    //                   720921569: 115
    //                   1402665321: 130;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        break; /* Loop/switch isn't completed */
_L5:
        break MISSING_BLOCK_LABEL_130;
_L6:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            onStartRegistration();
            return;

        case 1: // '\001'
            onUpdatePushRegistration(intent);
            return;

        case 2: // '\002'
            onAdmRegistrationFinished(intent);
            return;

        case 3: // '\003'
            onUpdateChannelRegistration(intent);
            break;
        }
        break MISSING_BLOCK_LABEL_167;
_L2:
        if (s.equals("com.urbanairship.push.ACTION_START_REGISTRATION"))
        {
            byte0 = 0;
        }
          goto _L6
_L3:
        if (s.equals("com.urbanairship.push.ACTION_UPDATE_PUSH_REGISTRATION"))
        {
            byte0 = 1;
        }
          goto _L6
_L4:
        if (s.equals("com.urbanairship.push.ACTION_ADM_REGISTRATION_FINISHED"))
        {
            byte0 = 2;
        }
          goto _L6
        if (s.equals("com.urbanairship.push.ACTION_UPDATE_CHANNEL_REGISTRATION"))
        {
            byte0 = 3;
        }
          goto _L6
    }

}
