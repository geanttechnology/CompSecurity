// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.gcm.GoogleCloudMessaging;
import com.google.android.gms.iid.InstanceID;
import com.urbanairship.AirshipConfigOptions;
import com.urbanairship.Logger;
import com.urbanairship.UAirship;
import com.urbanairship.google.PlayServicesUtils;
import com.urbanairship.util.ManifestUtils;
import java.util.Set;

// Referenced classes of package com.urbanairship.push:
//            PushManager, PushPreferences

class GCMRegistrar
{

    GCMRegistrar()
    {
    }

    private static boolean isGCMAvailable()
    {
label0:
        {
            if (!PlayServicesUtils.isGoogleCloudMessagingDependencyAvailable())
            {
                Logger.error("Google Play services for GCM is unavailable.");
                return false;
            }
            try
            {
                if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(UAirship.getApplicationContext()) == 0)
                {
                    break label0;
                }
                Logger.error("Google Play services is currently unavailable.");
            }
            catch (IllegalStateException illegalstateexception)
            {
                Logger.error((new StringBuilder("Unable to register with GCM:  ")).append(illegalstateexception.getMessage()).toString());
                return false;
            }
            return false;
        }
        if (!ManifestUtils.isPermissionKnown("com.google.android.c2dm.permission.RECEIVE"))
        {
            Logger.error("com.google.android.c2dm.permission.RECEIVE is unknown to PackageManager. Note that an AVD emulator may not support GCM.");
            Logger.error("If you're running in an emulator, you need to install the appropriate image through the Android SDK and AVM manager. See http://developer.android.com/guide/google/gcm/ for further details.");
            return false;
        }
        if (UAirship.shared().getAirshipConfigOptions().gcmSender == null)
        {
            Logger.error("The GCM sender ID is not set. Unable to register.");
            return false;
        } else
        {
            return true;
        }
    }

    public static boolean register()
    {
        Logger.verbose("Registering with GCM.");
        if (!isGCMAvailable())
        {
            return false;
        }
        Object obj = GoogleCloudMessaging.getInstance(UAirship.getApplicationContext());
        Set set = UAirship.shared().getAirshipConfigOptions().getGCMSenderIds();
        Object obj1 = UAirship.shared().getPushManager().getPreferences().getRegisteredGcmSenderIds();
        if (obj1 != null && !((Set) (obj1)).equals(set))
        {
            Logger.debug((new StringBuilder("GCMRegistrar - Unregistering GCM Sender IDs:  ")).append(obj1).toString());
            ((GoogleCloudMessaging) (obj)).unregister();
        }
        Logger.debug((new StringBuilder("GCMRegistrar - Registering GCM Sender IDs:  ")).append(set).toString());
        obj = ((GoogleCloudMessaging) (obj)).register((String[])set.toArray(new String[set.size()]));
        obj1 = InstanceID.getInstance(UAirship.getApplicationContext()).getToken(UAirship.shared().getAirshipConfigOptions().gcmSender, "GCM", null);
        if (obj != null && obj1 != null)
        {
            Logger.info((new StringBuilder("GCM registration successful security token: ")).append(((String) (obj1))).append(" registration ID: ").append(((String) (obj))).toString());
            UAirship.shared().getPushManager().setGcmToken(((String) (obj1)));
            UAirship.shared().getPushManager().setGcmId(((String) (obj)));
            UAirship.shared().getPushManager().getPreferences().setRegisteredGcmSenderIds(set);
        }
        return true;
    }
}
