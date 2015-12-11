// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.text.format.Time;
import com.groupon.ConsumerDeviceSettings;
import com.groupon.deeplink.DeepLinkUtil;
import com.groupon.google_api.ActivityDetectionRequester;
import com.groupon.google_api.GeofenceSetter;
import com.groupon.http.Http;
import com.groupon.models.GeofenceResponse;
import com.groupon.models.country.Country;
import com.groupon.models.notification.NotificationResponse;
import com.groupon.models.notification.ProximityNotificationResponse;
import com.groupon.service.countryanddivision.CurrentCountryManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.tracking.mobile.sdk.NoScheduledUploadLogger;
import com.groupon.util.DeviceInfoUtil;
import com.groupon.util.Function1;
import com.groupon.util.GeoPoint;
import com.groupon.util.GeoUtils;
import com.groupon.util.GrouponSafeAsyncTask;
import com.groupon.util.NotificationFactory;
import com.groupon.util.ObjectMapperWrapper;
import com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.util.Ln;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.service:
//            GrouponRoboWakefulIntentService, LocationService

public class ProximityNotificationService extends GrouponRoboWakefulIntentService
{
    protected class GeofenceHttp extends Http
    {

        final ProximityNotificationService this$0;

        protected void onException(Exception exception)
        {
            Ln.d((new StringBuilder()).append("Proximity_Notifications: API call unsuccessful. ").append(exception).toString(), new Object[0]);
            logger.logGeneralEvent("proximity_notification", "api_call_exception", null, 0, Logger.NULL_NST_FIELD);
        }

        protected void onSuccess(ProximityNotificationResponse proximitynotificationresponse)
            throws Exception
        {
            if (proximitynotificationresponse != null)
            {
                Ln.d("Proximity_Notifications: API call successful.", new Object[0]);
                processResponse(proximitynotificationresponse);
            }
        }

        protected volatile void onSuccess(Object obj)
            throws Exception
        {
            onSuccess((ProximityNotificationResponse)obj);
        }

        public GeofenceHttp(ArrayList arraylist)
        {
            this$0 = ProximityNotificationService.this;
            super(ProximityNotificationService.this, com/groupon/models/notification/ProximityNotificationResponse, String.format("https:/mobile/location/geofence?%s=%s", new Object[] {
                "lang", deviceInfoUtil.getLanguageFromLocale()
            }), arraylist.toArray());
        }
    }


    private static final long ONE_WEEK_IN_MS = 0x240c8400L;
    private static final String VERSION_NUMBER = "2";
    private ActivityDetectionRequester activityDetectionRequester;
    private ConsumerDeviceSettings consumerDeviceSettings;
    private CurrentCountryManager currentCountryManager;
    private DeepLinkUtil deepLinkUtil;
    private DeviceInfoUtil deviceInfoUtil;
    private GeoUtils geoUtils;
    private GeofenceSetter geofenceSetter;
    private InternetUsDateFormat internetDateFormat;
    private LocationService locationService;
    private NoScheduledUploadLogger logger;
    private NotificationFactory notificationFactory;
    private ObjectMapperWrapper om;
    private SharedPreferences prefs;

    public ProximityNotificationService()
    {
        this(com/groupon/service/ProximityNotificationService.getCanonicalName());
    }

    public ProximityNotificationService(String s)
    {
        super(s);
    }

    private void getGeofenceBreachedLocation(final String transitionType, final String geofenceUUID)
    {
        locationService.getLocationAsync(new Function1() {

            final ProximityNotificationService this$0;
            final String val$geofenceUUID;
            final String val$transitionType;

            public void execute(Location location)
            {
                Ln.d("Proximity_Notifications: Geofence breached, Trying to aquire most recent location", new Object[0]);
                setNewGeofences(null, transitionType, geofenceUUID);
            }

            public volatile void execute(Object obj)
                throws Exception
            {
                execute((Location)obj);
            }

            
            {
                this$0 = ProximityNotificationService.this;
                transitionType = s;
                geofenceUUID = s1;
                super();
            }
        }, 10000);
    }

    private String getNameFromType(int i)
    {
        switch (i)
        {
        default:
            return "unknown";

        case 0: // '\0'
            return "in_vehicle";

        case 1: // '\001'
            return "on_bicycle";

        case 2: // '\002'
            return "on_foot";

        case 3: // '\003'
            return "still";

        case 4: // '\004'
            return "unknown";

        case 5: // '\005'
            return "tilting";
        }
    }

    private boolean isEndpointMuteUntilActive()
    {
        long l = System.currentTimeMillis();
        long l1 = prefs.getLong("proximityEndpointMuteUntilInLong", l);
        StringBuilder stringbuilder = (new StringBuilder()).append("Proximity_Notifications: Endpoint mute value found. Current time: ").append(l).append(" MuteUntil: ").append(l1).append(" isActive: ");
        boolean flag;
        if (l < l1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Ln.d(stringbuilder.append(flag).toString(), new Object[0]);
        return l < l1;
    }

    private void processResponse(ProximityNotificationResponse proximitynotificationresponse)
    {
        ArrayList arraylist = new ArrayList();
        GeofenceResponse geofenceresponse;
        long l;
        for (Iterator iterator = proximitynotificationresponse.geofences.iterator(); iterator.hasNext(); Ln.d((new StringBuilder()).append("Proximity_Notifications: API response with new parsings = geofence: ").append(geofenceresponse.id).append(" lat: ").append(geofenceresponse.lat).append(" lng: ").append(geofenceresponse.lng).append(" radius: ").append(geofenceresponse.radius).append(" expirationTime: ").append(l).toString(), new Object[0]))
        {
            geofenceresponse = (GeofenceResponse)iterator.next();
            Time time = new Time();
            time.parse3339(geofenceresponse.validUntil);
            l = time.normalize(true) - System.currentTimeMillis();
            arraylist.add((new com.google.android.gms.location.Geofence.Builder()).setRequestId(geofenceresponse.id).setTransitionTypes(3).setCircularRegion(geofenceresponse.lat, geofenceresponse.lng, geofenceresponse.radius).setExpirationDuration(l).build());
        }

        logger.logGeneralEvent("proximity_notification", "receive_geofences", "geofences_count", proximitynotificationresponse.geofences.size(), Logger.NULL_NST_FIELD);
        Object obj = proximitynotificationresponse.notification;
        if (obj != null)
        {
            Ln.d("Proximity_Notifications: Found notification hash", new Object[0]);
            String s1 = ((NotificationResponse) (obj)).text;
            String s = ((NotificationResponse) (obj)).imageUri;
            String s2;
            String s3;
            String s4;
            final com.groupon.util.NotificationFactory.NotificationDetail details;
            if (Strings.notEmpty(s))
            {
                s = (new StringBuilder()).append(s).append("t954x610.jpg").toString();
            } else
            {
                s = null;
            }
            s2 = ((NotificationResponse) (obj)).price;
            s3 = ((NotificationResponse) (obj)).value;
            s4 = ((NotificationResponse) (obj)).nid;
            if (Strings.isEmpty(((NotificationResponse) (obj)).link))
            {
                obj = deepLinkUtil.defaultLocalDeeplink(currentCountryManager.getCurrentCountry().shortName.toLowerCase());
            } else
            {
                obj = ((NotificationResponse) (obj)).link;
            }
            details = new com.groupon.util.NotificationFactory.NotificationDetail(s1, s4, ((String) (obj)), null, s, s2, s3, true, com.groupon.util.NotificationFactory.NotificationDetail.NotificationType.PROXIMITY);
            Ln.d((new StringBuilder()).append("Proximity_Notifications: Notification details:  Text ").append(s1).append(" ").append(" ImageURL ").append(s).append(" ").append(" link ").append(((String) (obj))).append(" ").append(" price ").append(s2).append(" ").append(" value ").append(s3).append(" ").append(" nid ").append(s4).append(" ").toString(), new Object[0]);
            (new GrouponSafeAsyncTask() {

                final ProximityNotificationService this$0;
                final com.groupon.util.NotificationFactory.NotificationDetail val$details;

                public volatile Object call()
                    throws Exception
                {
                    return call();
                }

                public Void call()
                    throws Exception
                {
                    notificationFactory.sendLocalNotification(ProximityNotificationService.this, details);
                    Ln.d("Proximity_Notifications: Sending notification", new Object[0]);
                    return null;
                }

            
            {
                this$0 = ProximityNotificationService.this;
                details = notificationdetail;
                super();
            }
            }).execute();
        }
        proximitynotificationresponse = proximitynotificationresponse.muteUntil;
        Ln.d((new StringBuilder()).append("Proximity_Notifications: API response = muteUntil: ").append(proximitynotificationresponse).toString(), new Object[0]);
        setMuteUntil(proximitynotificationresponse);
        if (arraylist.isEmpty())
        {
            Ln.d("Proximity_Notifications: API returned empty geofence list. Exiting.", new Object[0]);
            return;
        }
        try
        {
            Ln.d("Proximity_Notifications: Removing old and setting new geofences.", new Object[0]);
            prefs.edit().putLong("proximityGeofenceSetTime", System.currentTimeMillis()).apply();
            geofenceSetter.setGeofences(arraylist);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ProximityNotificationResponse proximitynotificationresponse)
        {
            Ln.d("Proximity_Notifications: Exception in removing old and setting new geofences. Keeping old geofences", new Object[0]);
        }
        logger.logGeneralEvent("proximity_notification", "set_geofences", "set_geofence_exception", 0, Logger.NULL_NST_FIELD);
    }

    private void setMuteUntil(String s)
    {
        SimpleDateFormat simpledateformat;
        long l;
        simpledateformat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault());
        simpledateformat.setTimeZone(TimeZone.getTimeZone("UTC"));
        if (Strings.notEmpty(s))
        {
            logger.logGeneralEvent("proximity_notification", "set_mute_until", s, 0, Logger.NULL_NST_FIELD);
        }
        l = 0L;
        if (!Strings.notEmpty(s)) goto _L2; else goto _L1
_L1:
        long l1 = simpledateformat.parse(s).getTime();
        l = l1;
_L4:
        long l2 = System.currentTimeMillis() + 0x240c8400L;
        prefs.edit().putLong("proximityEndpointMuteUntilInLong", Math.min(l, l2)).apply();
        Ln.d((new StringBuilder()).append("Proximity_Notifications: Setting muteUntil: ").append(Math.min(l, l2)).toString(), new Object[0]);
        return;
_L2:
        l = 0L;
        continue; /* Loop/switch isn't completed */
        s;
        logger.logGeneralEvent("proximity_notification", "parsing_time_exception", null, 0, Logger.NULL_NST_FIELD);
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void setNewGeofences(String s, String s1, String s2)
    {
        ArrayList arraylist = new ArrayList();
        Object obj1 = locationService.getLocation();
        if (obj1 == null)
        {
            logger.logGeneralEvent("proximity_notification", "trigger_no_api_call", "no_location_found", 2, Logger.NULL_NST_FIELD);
            return;
        }
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "lat", Double.valueOf(((Location) (obj1)).getLatitude())
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "lng", Double.valueOf(((Location) (obj1)).getLongitude())
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "accuracy", Float.valueOf(((Location) (obj1)).getAccuracy())
        }));
        Object obj = new Date();
        ((Date) (obj)).setTime(((Location) (obj1)).getTime());
        obj1 = Calendar.getInstance(TimeZone.getDefault());
        ((Calendar) (obj1)).setTime(((Date) (obj)));
        obj = internetDateFormat.toString(((Calendar) (obj1)), false);
        arraylist.addAll(Arrays.asList(new String[] {
            "time", obj
        }));
        Ln.d((new StringBuilder()).append("Proximity_Notifications: Sending time to API : ").append(((String) (obj))).toString(), new Object[0]);
        Ln.d((new StringBuilder()).append("Proximity_Notifications: Current time on device : ").append(internetDateFormat.toString(System.currentTimeMillis(), TimeZone.getDefault())).toString(), new Object[0]);
        arraylist.addAll(Arrays.asList(new String[] {
            "responseVersion", "2"
        }));
        arraylist.addAll(Arrays.asList(new String[] {
            "bcookie", consumerDeviceSettings.getBcookie()
        }));
        arraylist.addAll(Arrays.asList(new Serializable[] {
            "maxGeofences", Integer.valueOf(10)
        }));
        if (!Strings.isEmpty(s))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "activity", s
            }));
        }
        if (!Strings.isEmpty(s1))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "action", s1
            }));
        }
        if (!Strings.isEmpty(s2))
        {
            arraylist.addAll(Arrays.asList(new String[] {
                "geofenceUUID", s2
            }));
        }
        (new GeofenceHttp(arraylist)).method("POST").execute();
    }

    protected void doWakefulWork(Intent intent)
    {
        if (!prefs.getBoolean("proximityNotificationEnabled", true))
        {
            Ln.d("Proximity_Notifications: User disabled. Exiting", new Object[0]);
            logger.logGeneralEvent("proximity_notification", "suppress", "user_disabled", 1, Logger.NULL_NST_FIELD);
        } else
        {
            Object obj = intent.getAction();
            if (Strings.equals(obj, "com.groupon.DISTANCE_ACTIVITY_CHECK"))
            {
                Ln.d("Proximity_Notifications: Start service", new Object[0]);
                logger.logGeneralEvent("proximity_notification", "start_service", "distance_activity_check", 0, Logger.NULL_NST_FIELD);
                prefs.edit().putBoolean("proximityNotificationSeenByUser", true).apply();
                intent = (LocationInfo)intent.getSerializableExtra("com.littlefluffytoys.littlefluffylocationlibrary.LocationInfo");
                intent = new GeoPoint((int)((double)((LocationInfo) (intent)).lastLat * 1000000D), (int)((double)((LocationInfo) (intent)).lastLong * 1000000D));
                obj = prefs.getString("proximityLocationInfoJson", "");
                try
                {
                    prefs.edit().putString("proximityLocationInfoJson", om.writeValueAsString(intent)).apply();
                    Ln.d((new StringBuilder()).append("Proximity_Notifications: Storing current location. ").append(intent.toString()).toString(), new Object[0]);
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    throw new RuntimeException(intent);
                }
                if (((String) (obj)).isEmpty())
                {
                    Ln.d("Proximity_Notifications: No old location found. Exiting.", new Object[0]);
                    return;
                }
                double d;
                try
                {
                    obj = (GeoPoint)om.readValue(((String) (obj)), com/groupon/util/GeoPoint);
                    Ln.d((new StringBuilder()).append("Proximity_Notifications: Old location found. ").append(((GeoPoint) (obj)).toString()).toString(), new Object[0]);
                }
                // Misplaced declaration of an exception variable
                catch (Intent intent)
                {
                    throw new RuntimeException(intent);
                }
                d = geoUtils.milesBetween(intent, ((GeoPoint) (obj)));
                if (d > 2D)
                {
                    Ln.d("Proximity_Notifications: User is %f miles away from current location. Exiting.", new Object[] {
                        Double.valueOf(d)
                    });
                    logger.logGeneralEvent("proximity_notification", "trigger_no_api_call", "distance_check_failed", 1, Logger.NULL_NST_FIELD);
                    return;
                }
                Ln.d("Proximity_Notifications: User is %f miles away from current location. This is within the 2miles radius.", new Object[] {
                    Double.valueOf(d)
                });
                if (isEndpointMuteUntilActive())
                {
                    Ln.d("Proximity_Notifications: Endpoint mute is active.", new Object[0]);
                    return;
                } else
                {
                    Ln.d("Proximity_Notifications: Requesting updates.", new Object[0]);
                    activityDetectionRequester.requestUpdates();
                    Ln.d("Proximity_Notifications: Ending service call #1.", new Object[0]);
                    return;
                }
            }
            if (Strings.equals(obj, "com.groupon.SET_GEOFENCE"))
            {
                int i = intent.getIntExtra("activity_name", 4);
                int k = intent.getIntExtra("activity_confidence", 0);
                logger.logGeneralEvent("proximity_notification", "start_service", "activity_found", i, Logger.NULL_NST_FIELD);
                Ln.d("Proximity_Notifications: Service/Geofence block: Activity detected %s with confidence %d", new Object[] {
                    Integer.valueOf(i), Integer.valueOf(k)
                });
                if (i == 2 || i == 7 || i == 3 || i == 5)
                {
                    Ln.d("Proximity_Notifications: Detected activity detected satisfies requirements to make an API call ", new Object[0]);
                    if (k < 50)
                    {
                        logger.logGeneralEvent("proximity_notification", "no_api_call_no_confidence", getNameFromType(i), 1, Logger.NULL_NST_FIELD);
                        return;
                    }
                } else
                {
                    logger.logGeneralEvent("proximity_notification", "no_api_call_invalid_activity", getNameFromType(i), 1, Logger.NULL_NST_FIELD);
                    return;
                }
                if (isEndpointMuteUntilActive())
                {
                    Ln.d("Proximity_Notifications: Endpoint mute is active.", new Object[0]);
                    return;
                }
                long l = prefs.getLong("proximityActivityPollTime", 0L);
                if (System.currentTimeMillis() < 10000L + l)
                {
                    Ln.d("Proximity_Notifications: API call due to activity detection within 10seconds. Exiting to prevent multiple api call.", new Object[0]);
                    return;
                } else
                {
                    prefs.edit().putLong("proximityActivityPollTime", System.currentTimeMillis()).apply();
                    setNewGeofences(getNameFromType(i), null, null);
                    return;
                }
            }
            if (Strings.equals(obj, "com.groupon.GEOFENCE_TRIGGERED"))
            {
                obj = intent.getStringExtra("transition_type");
                intent = intent.getStringExtra("transition_geofence_uuid");
                NoScheduledUploadLogger noscheduleduploadlogger = logger;
                int j;
                long l1;
                if (((String) (obj)).equals("Entered"))
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                noscheduleduploadlogger.logGeneralEvent("proximity_notification", "start_service", "geofence_transition", j, Logger.NULL_NST_FIELD);
                l1 = prefs.getLong("proximityGeofenceSetTime", 0L);
                if (System.currentTimeMillis() < 10000L + l1)
                {
                    Ln.d("Proximity_Notifications: Geofence triggered within 10seconds. Exiting to prevent loop.", new Object[0]);
                    return;
                }
                Ln.d("Proximity_Notifications: Found %s on %s geofence. Calling geofencesetter again.", new Object[] {
                    obj, intent
                });
                if (isEndpointMuteUntilActive())
                {
                    Ln.d("Proximity_Notifications: Endpoint mute is active.", new Object[0]);
                    return;
                } else
                {
                    getGeofenceBreachedLocation(((String) (obj)), intent);
                    return;
                }
            }
            if (Strings.equals(obj, "com.groupon.CLEAR_GEOFENCE_ABTEST_CHANGE") && prefs.getBoolean("proximityNotificationSeenByUser", false))
            {
                geofenceSetter.clearGeofences();
                prefs.edit().putBoolean("proximityNotificationSeenByUser", false).apply();
                return;
            }
        }
    }





}
