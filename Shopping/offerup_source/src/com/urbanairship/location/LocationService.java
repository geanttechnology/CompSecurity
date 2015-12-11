// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.SparseArray;
import com.urbanairship.Autopilot;
import com.urbanairship.Logger;
import com.urbanairship.PendingResult;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.json.JsonException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.urbanairship.location:
//            UALocationManager, LocationRequestOptions, UALocationProvider

public class LocationService extends Service
{

    static final String ACTION_CHECK_LOCATION_UPDATES = "com.urbanairship.location.ACTION_CHECK_LOCATION_UPDATES";
    static final String ACTION_LOCATION_UPDATE = "com.urbanairship.location.ACTION_LOCATION_UPDATE";
    static final String EXTRA_LOCATION_REQUEST_OPTIONS = "com.urbanairship.location.EXTRA_LOCATION_REQUEST_OPTIONS";
    private static final String LAST_REQUESTED_LOCATION_OPTIONS_KEY = "com.urbanairship.location.LAST_REQUESTED_LOCATION_OPTIONS";
    static final int MSG_CANCEL_SINGLE_LOCATION_REQUEST = 6;
    private static final int MSG_HANDLE_INTENT = 7;
    static final int MSG_NEW_LOCATION_UPDATE = 3;
    static final int MSG_REQUEST_SINGLE_LOCATION = 5;
    static final int MSG_SINGLE_REQUEST_RESULT = 4;
    static final int MSG_SUBSCRIBE_UPDATES = 1;
    static final int MSG_UNSUBSCRIBE_UPDATES = 2;
    private static final long NEW_SUBSCRIBER_LAST_LOCATION_MS = 5000L;
    static boolean areUpdatesStopped = false;
    static LocationRequestOptions lastUpdateOptions = null;
    IncomingHandler handler;
    private Location lastLocationUpdate;
    UALocationProvider locationProvider;
    Looper looper;
    private Messenger messenger;
    private final HashMap pendingResultMap = new HashMap();
    private final Set subscribedClients = new HashSet();

    public LocationService()
    {
    }

    private void addPendingResult(Messenger messenger1, int i, PendingResult pendingresult)
    {
        HashMap hashmap = pendingResultMap;
        hashmap;
        JVM INSTR monitorenter ;
        if (messenger1 == null || i <= 0)
        {
            break MISSING_BLOCK_LABEL_60;
        }
        if (!pendingResultMap.containsKey(messenger1))
        {
            pendingResultMap.put(messenger1, new SparseArray());
        }
        ((SparseArray)pendingResultMap.get(messenger1)).put(i, pendingresult);
        hashmap;
        JVM INSTR monitorexit ;
        return;
        messenger1;
        hashmap;
        JVM INSTR monitorexit ;
        throw messenger1;
    }

    private PendingIntent createLocationUpdateIntent()
    {
        Intent intent = (new Intent(getApplicationContext(), com/urbanairship/location/LocationService)).setAction("com.urbanairship.location.ACTION_LOCATION_UPDATE");
        return PendingIntent.getService(getApplicationContext(), 0, intent, 0x8000000);
    }

    private void onCancelSingleUpdate(Message message)
    {
        int i = message.arg1;
        message = message.replyTo;
        PendingResult pendingresult = removePendingResult(message, i);
        if (pendingresult != null)
        {
            Logger.debug((new StringBuilder("LocationService - Canceled single request for client: ")).append(message).append(" ID: ").append(i).toString());
            pendingresult.cancel();
        }
    }

    private void onCheckLocationUpdates(Intent intent)
    {
        if (UAirship.shared().getLocationManager().isContinuousLocationUpdatesAllowed())
        {
            intent = UAirship.shared().getLocationManager().getLocationRequestOptions();
            if (lastUpdateOptions == null || !lastUpdateOptions.equals(intent))
            {
                Logger.debug("LocationService - Starting updates.");
                UAirship.shared().getLocationManager().getPreferenceDataStore().put("com.urbanairship.location.LAST_REQUESTED_LOCATION_OPTIONS", intent);
                lastUpdateOptions = intent;
                areUpdatesStopped = false;
                PendingIntent pendingintent = createLocationUpdateIntent();
                locationProvider.connect();
                locationProvider.cancelRequests(pendingintent);
                locationProvider.requestLocationUpdates(intent, pendingintent);
            }
        } else
        if (!areUpdatesStopped)
        {
            Logger.debug("LocationService - Stopping updates.");
            locationProvider.cancelRequests(createLocationUpdateIntent());
            lastUpdateOptions = null;
            areUpdatesStopped = true;
            return;
        }
    }

    private void onHandleIntent(Intent intent)
    {
        String s;
        byte byte0;
        if (intent == null || intent.getAction() == null)
        {
            return;
        }
        Logger.verbose((new StringBuilder("LocationService - Received intent with action: ")).append(intent.getAction()).toString());
        s = intent.getAction();
        byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 2: default 72
    //                   -895304300: 103
    //                   569879094: 117;
           goto _L1 _L2 _L3
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_117;
_L4:
        switch (byte0)
        {
        default:
            return;

        case 0: // '\0'
            onCheckLocationUpdates(intent);
            return;

        case 1: // '\001'
            onLocationUpdate(intent);
            break;
        }
        break MISSING_BLOCK_LABEL_136;
_L2:
        if (s.equals("com.urbanairship.location.ACTION_CHECK_LOCATION_UPDATES"))
        {
            byte0 = 0;
        }
          goto _L4
        if (s.equals("com.urbanairship.location.ACTION_LOCATION_UPDATE"))
        {
            byte0 = 1;
        }
          goto _L4
    }

    private void onLocationUpdate(Intent intent)
    {
        if (UAirship.shared().getLocationManager().isContinuousLocationUpdatesAllowed() && !areUpdatesStopped)
        {
            if (lastUpdateOptions == null)
            {
                Object obj = UAirship.shared().getLocationManager().getPreferenceDataStore().getString("com.urbanairship.location.LAST_REQUESTED_LOCATION_OPTIONS", null);
                if (obj != null)
                {
                    try
                    {
                        lastUpdateOptions = LocationRequestOptions.parseJson(((String) (obj)));
                    }
                    catch (JsonException jsonexception)
                    {
                        Logger.error((new StringBuilder("LocationService - Failed parsing LocationRequestOptions from JSON: ")).append(jsonexception.getMessage()).toString());
                    }
                    catch (IllegalArgumentException illegalargumentexception)
                    {
                        Logger.error((new StringBuilder("LocationService - Invalid LocationRequestOptions from JSON: ")).append(illegalargumentexception.getMessage()).toString());
                    }
                }
            }
            if (intent.hasExtra("providerEnabled"))
            {
                Logger.debug("LocationService - Restarting location updates. One of the location providers was enabled or disabled.");
                intent = UAirship.shared().getLocationManager().getLocationRequestOptions();
                obj = createLocationUpdateIntent();
                UAirship.shared().getLocationManager().getPreferenceDataStore().put("com.urbanairship.location.LAST_REQUESTED_LOCATION_OPTIONS", intent);
                locationProvider.connect();
                locationProvider.cancelRequests(((PendingIntent) (obj)));
                locationProvider.requestLocationUpdates(intent, ((PendingIntent) (obj)));
                return;
            }
            Location location;
            if (intent.hasExtra("location"))
            {
                intent = intent.getParcelableExtra("location");
            } else
            {
                intent = intent.getParcelableExtra("com.google.android.location.LOCATION");
            }
            location = (Location)intent;
            if (location != null)
            {
                lastLocationUpdate = location;
                Logger.info((new StringBuilder("Received location update: ")).append(location).toString());
                if (lastUpdateOptions == null)
                {
                    intent = UAirship.shared().getLocationManager().getLocationRequestOptions();
                } else
                {
                    intent = lastUpdateOptions;
                }
                UAirship.shared().getAnalytics().recordLocation(location, intent, com.urbanairship.analytics.LocationEvent.UpdateType.CONTINUOUS);
                intent = (new ArrayList(subscribedClients)).iterator();
                while (intent.hasNext()) 
                {
                    Messenger messenger1 = (Messenger)intent.next();
                    if (!sendClientMessage(messenger1, 3, 0, location))
                    {
                        subscribedClients.remove(messenger1);
                    }
                }
            }
        }
    }

    private void onRequestSingleUpdate(final Message options)
    {
        final int requestId = options.arg1;
        final Messenger client = options.replyTo;
        options = (LocationRequestOptions)options.getData().getParcelable("com.urbanairship.location.EXTRA_LOCATION_REQUEST_OPTIONS");
        if (options == null)
        {
            Logger.warn("Location service unable to perform single location request. Missing request options.");
            sendClientMessage(client, 4, requestId, null);
            return;
        }
        Logger.verbose((new StringBuilder("LocationService - Single location request for client: ")).append(client).append(" ID: ").append(requestId).toString());
        Logger.info((new StringBuilder("Requesting single location update with request options: ")).append(options).toString());
        locationProvider.connect();
        PendingResult pendingresult = locationProvider.requestSingleLocation(options);
        if (pendingresult == null)
        {
            Logger.warn("Location service unable to perform single location request. UALocationProvider failed to request a location.");
            sendClientMessage(client, 4, requestId, null);
            return;
        } else
        {
            addPendingResult(client, requestId, pendingresult);
            pendingresult.onResult(new _cls1());
            return;
        }
    }

    private void onSubscribeUpdates(Message message)
    {
        if (message.replyTo != null)
        {
            Logger.debug((new StringBuilder("LocationService - Client subscribed for updates: ")).append(message.replyTo).toString());
            subscribedClients.add(message.replyTo);
            if (lastLocationUpdate != null && System.currentTimeMillis() - lastLocationUpdate.getTime() < 5000L && !sendClientMessage(message.replyTo, 3, 0, lastLocationUpdate))
            {
                subscribedClients.remove(message.replyTo);
            }
        }
    }

    private void onUnsubscribeUpdates(Message message)
    {
        if (subscribedClients.remove(message.replyTo))
        {
            Logger.debug((new StringBuilder("LocationService - Client unsubscribed from updates: ")).append(message.replyTo).toString());
        }
    }

    private PendingResult removePendingResult(Messenger messenger1, int i)
    {
        PendingResult pendingresult = null;
        this;
        JVM INSTR monitorenter ;
        HashMap hashmap = pendingResultMap;
        hashmap;
        JVM INSTR monitorenter ;
        if (pendingResultMap.containsKey(messenger1)) goto _L2; else goto _L1
_L1:
        messenger1 = pendingresult;
_L4:
        this;
        JVM INSTR monitorexit ;
        return messenger1;
_L2:
        SparseArray sparsearray = (SparseArray)pendingResultMap.get(messenger1);
        if (sparsearray == null)
        {
            break MISSING_BLOCK_LABEL_103;
        }
        pendingresult = (PendingResult)sparsearray.get(i);
        sparsearray.remove(i);
        if (sparsearray.size() == 0)
        {
            pendingResultMap.remove(messenger1);
        }
        hashmap;
        JVM INSTR monitorexit ;
        messenger1 = pendingresult;
        continue; /* Loop/switch isn't completed */
        messenger1;
        hashmap;
        JVM INSTR monitorexit ;
        throw messenger1;
        messenger1;
        this;
        JVM INSTR monitorexit ;
        throw messenger1;
        hashmap;
        JVM INSTR monitorexit ;
        messenger1 = pendingresult;
        if (true) goto _L4; else goto _L3
_L3:
    }

    private boolean sendClientMessage(Messenger messenger1, int i, int j, Object obj)
    {
        if (messenger1 == null)
        {
            return false;
        }
        try
        {
            messenger1.send(Message.obtain(null, i, j, 0, obj));
        }
        // Misplaced declaration of an exception variable
        catch (Messenger messenger1)
        {
            return false;
        }
        return true;
    }

    public IBinder onBind(Intent intent)
    {
        return messenger.getBinder();
    }

    public void onCreate()
    {
        super.onCreate();
        Autopilot.automaticTakeOff(getApplicationContext());
        HandlerThread handlerthread = new HandlerThread("LocationService");
        handlerthread.start();
        looper = handlerthread.getLooper();
        handler = new IncomingHandler(looper);
        messenger = new Messenger(handler);
        locationProvider = new UALocationProvider(getApplicationContext());
        Logger.verbose("LocationService - Service created.");
    }

    public void onDestroy()
    {
        locationProvider.disconnect();
        looper.quit();
        super.onDestroy();
        Logger.verbose("LocationService - Service destroyed.");
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        Message message = handler.obtainMessage();
        message.arg1 = j;
        message.obj = intent;
        message.what = 7;
        handler.sendMessage(message);
        return 2;
    }









    private class _cls1
        implements com.urbanairship.PendingResult.ResultCallback
    {

        final LocationService this$0;
        final Messenger val$client;
        final LocationRequestOptions val$options;
        final int val$requestId;

        public void onResult(Location location)
        {
            Logger.verbose((new StringBuilder("LocationService - Single location received for client: ")).append(client).append(" ID: ").append(requestId).toString());
            Logger.info((new StringBuilder("Received single location update: ")).append(location).toString());
            UAirship.shared().getAnalytics().recordLocation(location, options, com.urbanairship.analytics.LocationEvent.UpdateType.SINGLE);
            sendClientMessage(client, 4, requestId, location);
            removePendingResult(client, requestId);
        }

        public volatile void onResult(Object obj)
        {
            onResult((Location)obj);
        }

        _cls1()
        {
            this$0 = LocationService.this;
            client = messenger1;
            requestId = i;
            options = locationrequestoptions;
            super();
        }
    }


    private class IncomingHandler extends Handler
    {

        final LocationService this$0;

        public void handleMessage(Message message)
        {
            Logger.verbose((new StringBuilder("LocationService - Received message: ")).append(message).toString());
            switch (message.what)
            {
            case 3: // '\003'
            case 4: // '\004'
            default:
                Logger.error((new StringBuilder("LocationService - Unexpected message sent to location service: ")).append(message).toString());
                return;

            case 2: // '\002'
                onUnsubscribeUpdates(message);
                return;

            case 1: // '\001'
                onSubscribeUpdates(message);
                return;

            case 5: // '\005'
                onRequestSingleUpdate(message);
                return;

            case 6: // '\006'
                onCancelSingleUpdate(message);
                return;

            case 7: // '\007'
                onHandleIntent((Intent)message.obj);
                break;
            }
            stopSelf(message.arg1);
        }

        public IncomingHandler(Looper looper1)
        {
            this$0 = LocationService.this;
            super(looper1);
        }
    }

}
