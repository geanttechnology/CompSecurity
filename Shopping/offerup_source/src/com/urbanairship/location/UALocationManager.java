// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.location;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.v4.b.h;
import android.util.SparseArray;
import com.urbanairship.BaseManager;
import com.urbanairship.Logger;
import com.urbanairship.PendingResult;
import com.urbanairship.PreferenceDataStore;
import com.urbanairship.UAirship;
import com.urbanairship.analytics.Analytics;
import com.urbanairship.json.JsonException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.urbanairship.location:
//            LocationService, LocationRequestOptions, LocationListener

public class UALocationManager extends BaseManager
{

    static final String BACKGROUND_UPDATES_ALLOWED_KEY = "com.urbanairship.location.BACKGROUND_UPDATES_ALLOWED";
    static final String LOCATION_OPTIONS_KEY = "com.urbanairship.location.LOCATION_OPTIONS";
    static final String LOCATION_UPDATES_ENABLED_KEY = "com.urbanairship.location.LOCATION_UPDATES_ENABLED";
    private final Context context;
    private boolean isBound;
    private boolean isSubscribed;
    private final List locationListeners = new ArrayList();
    private final Messenger messenger = new Messenger(new IncomingHandler(Looper.getMainLooper()));
    private int nextSingleLocationRequestId;
    private final com.urbanairship.PreferenceDataStore.PreferenceChangeListener preferenceChangeListener = new _cls2();
    private final PreferenceDataStore preferenceDataStore;
    private final ServiceConnection serviceConnection = new _cls1();
    private Messenger serviceMessenger;
    private final SparseArray singleLocationRequests = new SparseArray();

    public UALocationManager(Context context1, PreferenceDataStore preferencedatastore)
    {
        nextSingleLocationRequestId = 1;
        context = context1.getApplicationContext();
        preferenceDataStore = preferencedatastore;
    }

    private void bindService()
    {
        this;
        JVM INSTR monitorenter ;
        if (isBound) goto _L2; else goto _L1
_L1:
        Context context1;
        Logger.verbose("UALocationManager - Binding to location service.");
        context1 = UAirship.getApplicationContext();
        if (!context1.bindService(new Intent(context1, com/urbanairship/location/LocationService), serviceConnection, 1)) goto _L4; else goto _L3
_L3:
        isBound = true;
_L2:
        this;
        JVM INSTR monitorexit ;
        return;
_L4:
        Logger.error("Unable to bind to location service. Check that the location service is added to the manifest.");
        if (true) goto _L2; else goto _L5
_L5:
        Exception exception;
        exception;
        throw exception;
    }

    private void onServiceConnected(IBinder ibinder)
    {
        this;
        JVM INSTR monitorenter ;
        serviceMessenger = new Messenger(ibinder);
        ibinder = singleLocationRequests;
        ibinder;
        JVM INSTR monitorenter ;
        int i = 0;
_L2:
        if (i >= singleLocationRequests.size())
        {
            break; /* Loop/switch isn't completed */
        }
        ((SingleLocationRequest)singleLocationRequests.valueAt(i)).sendLocationRequest();
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        ibinder;
        JVM INSTR monitorexit ;
        updateServiceConnection();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        ibinder;
        JVM INSTR monitorexit ;
        throw exception;
        ibinder;
        this;
        JVM INSTR monitorexit ;
        throw ibinder;
    }

    private void onServiceDisconnected()
    {
        this;
        JVM INSTR monitorenter ;
        serviceMessenger = null;
        isSubscribed = false;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private boolean sendMessage(int i, int j, Bundle bundle)
    {
        if (serviceMessenger == null)
        {
            return false;
        }
        Message message = Message.obtain(null, i, j, 0);
        if (bundle != null)
        {
            message.setData(bundle);
        }
        message.replyTo = messenger;
        try
        {
            serviceMessenger.send(message);
        }
        // Misplaced declaration of an exception variable
        catch (Bundle bundle)
        {
            Logger.debug("UALocationManager - Remote exception when sending message to location service");
            return false;
        }
        return true;
    }

    private void subscribeUpdates()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isSubscribed && sendMessage(1, 0, null))
        {
            Logger.info("Subscribing to continuous location updates.");
            isSubscribed = true;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void unbindService()
    {
        this;
        JVM INSTR monitorenter ;
        if (isBound)
        {
            Logger.verbose("UALocationManager - Unbinding to location service.");
            UAirship.getApplicationContext().unbindService(serviceConnection);
            isBound = false;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void unsubscribeUpdates()
    {
        this;
        JVM INSTR monitorenter ;
        if (isSubscribed)
        {
            Logger.info("Unsubscribing from continuous location updates.");
            sendMessage(2, 0, null);
            isSubscribed = false;
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    private void updateServiceConnection()
    {
        if (!isContinuousLocationUpdatesAllowed()) goto _L2; else goto _L1
_L1:
        Object obj = locationListeners;
        obj;
        JVM INSTR monitorenter ;
        if (locationListeners.isEmpty()) goto _L4; else goto _L3
_L3:
        if (!isBound) goto _L6; else goto _L5
_L5:
        subscribeUpdates();
_L4:
        obj = (new Intent(context, com/urbanairship/location/LocationService)).setAction("com.urbanairship.location.ACTION_CHECK_LOCATION_UPDATES");
        if (context.startService(((Intent) (obj))) == null)
        {
            Logger.error("Unable to start location service. Check that the location service is added to the manifest.");
        }
        return;
_L6:
        bindService();
        obj;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
_L2:
        unsubscribeUpdates();
        synchronized (singleLocationRequests)
        {
            if (singleLocationRequests.size() == 0)
            {
                unbindService();
            }
        }
        if (true) goto _L4; else goto _L7
_L7:
        exception1;
        sparsearray;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public void addLocationListener(LocationListener locationlistener)
    {
        synchronized (locationListeners)
        {
            locationListeners.add(locationlistener);
            updateServiceConnection();
        }
        return;
        locationlistener;
        list;
        JVM INSTR monitorexit ;
        throw locationlistener;
    }

    public LocationRequestOptions getLocationRequestOptions()
    {
        LocationRequestOptions locationrequestoptions1 = null;
        String s = preferenceDataStore.getString("com.urbanairship.location.LOCATION_OPTIONS", null);
        LocationRequestOptions locationrequestoptions = locationrequestoptions1;
        if (s != null)
        {
            try
            {
                locationrequestoptions = LocationRequestOptions.parseJson(s);
            }
            catch (JsonException jsonexception)
            {
                Logger.error((new StringBuilder("UALocationManager - Failed parsing LocationRequestOptions from JSON: ")).append(jsonexception.getMessage()).toString());
                jsonexception = locationrequestoptions1;
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                Logger.error((new StringBuilder("UALocationManager - Invalid LocationRequestOptions from JSON: ")).append(illegalargumentexception.getMessage()).toString());
                illegalargumentexception = locationrequestoptions1;
            }
        }
        locationrequestoptions1 = locationrequestoptions;
        if (locationrequestoptions == null)
        {
            locationrequestoptions1 = (new LocationRequestOptions.Builder()).create();
        }
        return locationrequestoptions1;
    }

    PreferenceDataStore getPreferenceDataStore()
    {
        return preferenceDataStore;
    }

    protected void init()
    {
        preferenceDataStore.addListener(preferenceChangeListener);
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.addAction("com.urbanairship.analytics.APP_FOREGROUND");
        intentfilter.addAction("com.urbanairship.analytics.APP_BACKGROUND");
        h.a(context).a(new _cls3(), intentfilter);
        updateServiceConnection();
    }

    public boolean isBackgroundLocationAllowed()
    {
        return preferenceDataStore.getBoolean("com.urbanairship.location.BACKGROUND_UPDATES_ALLOWED", false);
    }

    boolean isContinuousLocationUpdatesAllowed()
    {
        return isLocationUpdatesEnabled() && (isBackgroundLocationAllowed() || UAirship.shared().getAnalytics().isAppInForeground());
    }

    public boolean isLocationUpdatesEnabled()
    {
        return preferenceDataStore.getBoolean("com.urbanairship.location.LOCATION_UPDATES_ENABLED", false);
    }

    public void removeLocationListener(LocationListener locationlistener)
    {
        synchronized (locationListeners)
        {
            locationListeners.remove(locationlistener);
            updateServiceConnection();
        }
        return;
        locationlistener;
        list;
        JVM INSTR monitorexit ;
        throw locationlistener;
    }

    public PendingResult requestSingleLocation()
    {
        return requestSingleLocation(getLocationRequestOptions());
    }

    public PendingResult requestSingleLocation(LocationRequestOptions locationrequestoptions)
    {
        if (locationrequestoptions == null)
        {
            throw new IllegalArgumentException("Location request options cannot be null or invalid");
        }
        synchronized (singleLocationRequests)
        {
            int i = nextSingleLocationRequestId;
            nextSingleLocationRequestId = i + 1;
            locationrequestoptions = new SingleLocationRequest(i, locationrequestoptions);
            singleLocationRequests.put(i, locationrequestoptions);
        }
        this;
        JVM INSTR monitorenter ;
        if (isBound)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        bindService();
_L1:
        this;
        JVM INSTR monitorexit ;
        return locationrequestoptions;
        locationrequestoptions;
        sparsearray;
        JVM INSTR monitorexit ;
        throw locationrequestoptions;
        locationrequestoptions.sendLocationRequest();
          goto _L1
        locationrequestoptions;
        this;
        JVM INSTR monitorexit ;
        throw locationrequestoptions;
    }

    public void setBackgroundLocationAllowed(boolean flag)
    {
        preferenceDataStore.put("com.urbanairship.location.BACKGROUND_UPDATES_ALLOWED", flag);
    }

    public void setLocationRequestOptions(LocationRequestOptions locationrequestoptions)
    {
        preferenceDataStore.put("com.urbanairship.location.LOCATION_OPTIONS", locationrequestoptions);
    }

    public void setLocationUpdatesEnabled(boolean flag)
    {
        preferenceDataStore.put("com.urbanairship.location.LOCATION_UPDATES_ENABLED", flag);
    }

    protected void tearDown()
    {
        preferenceDataStore.removeListener(preferenceChangeListener);
    }







    private class _cls1
        implements ServiceConnection
    {

        final UALocationManager this$0;

        public void onServiceConnected(ComponentName componentname, IBinder ibinder)
        {
            Logger.verbose("Location service connected.");
            UALocationManager.this.onServiceConnected(ibinder);
        }

        public void onServiceDisconnected(ComponentName componentname)
        {
            Logger.verbose("Location service disconnected.");
            UALocationManager.this.onServiceDisconnected();
        }

        _cls1()
        {
            this$0 = UALocationManager.this;
            super();
        }
    }


    private class _cls2
        implements com.urbanairship.PreferenceDataStore.PreferenceChangeListener
    {

        final UALocationManager this$0;

        public void onPreferenceChange(String s)
        {
            byte byte0 = -1;
            s.hashCode();
            JVM INSTR lookupswitch 3: default 40
        //                       56233632: 97
        //                       283482798: 83
        //                       375109006: 69;
               goto _L1 _L2 _L3 _L4
_L1:
            break; /* Loop/switch isn't completed */
_L2:
            break MISSING_BLOCK_LABEL_97;
_L5:
            switch (byte0)
            {
            default:
                return;

            case 0: // '\0'
            case 1: // '\001'
            case 2: // '\002'
                updateServiceConnection();
                break;
            }
            break MISSING_BLOCK_LABEL_118;
_L4:
            if (s.equals("com.urbanairship.location.BACKGROUND_UPDATES_ALLOWED"))
            {
                byte0 = 0;
            }
              goto _L5
_L3:
            if (s.equals("com.urbanairship.location.LOCATION_UPDATES_ENABLED"))
            {
                byte0 = 1;
            }
              goto _L5
            if (s.equals("com.urbanairship.location.LOCATION_OPTIONS"))
            {
                byte0 = 2;
            }
              goto _L5
        }

        _cls2()
        {
            this$0 = UALocationManager.this;
            super();
        }
    }


    private class IncomingHandler extends Handler
    {

        public void handleMessage(Message message)
        {
            Object obj = UAirship.shared().getLocationManager();
            message.what;
            JVM INSTR tableswitch 3 4: default 32
        //                       3 38
        //                       4 102;
               goto _L1 _L2 _L3
_L1:
            super.handleMessage(message);
_L5:
            return;
_L2:
            Location location = (Location)message.obj;
            if (location == null) goto _L5; else goto _L4
_L4:
            message = ((UALocationManager) (obj)).locationListeners;
            message;
            JVM INSTR monitorenter ;
            for (obj = ((UALocationManager) (obj)).locationListeners.iterator(); ((Iterator) (obj)).hasNext(); ((LocationListener)((Iterator) (obj)).next()).onLocationChanged(location)) { }
              goto _L6
            obj;
            message;
            JVM INSTR monitorexit ;
            throw obj;
_L6:
            message;
            JVM INSTR monitorexit ;
            return;
_L3:
            int i;
            location = (Location)message.obj;
            i = message.arg1;
            message = ((UALocationManager) (obj)).singleLocationRequests;
            message;
            JVM INSTR monitorenter ;
            PendingLocationResult pendinglocationresult = (PendingLocationResult)((UALocationManager) (obj)).singleLocationRequests.get(i);
            if (pendinglocationresult == null) goto _L8; else goto _L7
_L7:
            pendinglocationresult.setResult(location);
            ((UALocationManager) (obj)).singleLocationRequests.remove(i);
            ((UALocationManager) (obj)).updateServiceConnection();
_L8:
            message;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            message;
            JVM INSTR monitorexit ;
            throw exception;
        }

        IncomingHandler(Looper looper)
        {
            super(looper);
        }
    }


    private class SingleLocationRequest extends PendingLocationResult
    {

        private final LocationRequestOptions options;
        private final int requestId;
        final UALocationManager this$0;

        protected void onCancel()
        {
            if (!isDone())
            {
                sendMessage(6, requestId, null);
            }
            synchronized (singleLocationRequests)
            {
                singleLocationRequests.remove(requestId);
            }
            return;
            exception;
            sparsearray;
            JVM INSTR monitorexit ;
            throw exception;
        }

        void sendLocationRequest()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag = isDone();
            if (!flag) goto _L2; else goto _L1
_L1:
            this;
            JVM INSTR monitorexit ;
            return;
_L2:
            Bundle bundle = new Bundle();
            bundle.putParcelable("com.urbanairship.location.EXTRA_LOCATION_REQUEST_OPTIONS", options);
            sendMessage(5, requestId, bundle);
            if (true) goto _L1; else goto _L3
_L3:
            Exception exception;
            exception;
            throw exception;
        }

        SingleLocationRequest(int i, LocationRequestOptions locationrequestoptions)
        {
            this$0 = UALocationManager.this;
            super();
            requestId = i;
            options = locationrequestoptions;
        }
    }


    private class _cls3 extends BroadcastReceiver
    {

        final UALocationManager this$0;

        public void onReceive(Context context1, Intent intent)
        {
            updateServiceConnection();
        }

        _cls3()
        {
            this$0 = UALocationManager.this;
            super();
        }
    }

}
