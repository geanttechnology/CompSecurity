// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.arellomobile.android.push;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.RemoteException;
import com.pushwoosh.support.v4.app.LocalBroadcastManager;
import com.radiusnetworks.ibeacon.IBeaconConsumer;
import com.radiusnetworks.ibeacon.IBeaconManager;
import com.radiusnetworks.ibeacon.MonitorNotifier;
import com.radiusnetworks.ibeacon.Region;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

// Referenced classes of package com.arellomobile.android.push:
//            PushManager, DeviceFeature2_5

public class PushBeaconService extends Service
    implements IBeaconConsumer, MonitorNotifier
{
    private class GetConfigTask extends AsyncTask
    {

        final PushBeaconService this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient JSONObject doInBackground(Void avoid[])
        {
            try
            {
                avoid = DeviceFeature2_5.getBeacons(PushBeaconService.this);
            }
            // Misplaced declaration of an exception variable
            catch (Void avoid[])
            {
                return new JSONObject();
            }
            return avoid;
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((JSONObject)obj);
        }

        protected void onPostExecute(JSONObject jsonobject)
        {
            boolean flag = false;
            mListeningRegions = new ArrayList();
            mConfig = jsonobject;
            JSONArray jsonarray = mConfig.optJSONArray("beacons");
            String s = mConfig.optString("uuid", null);
            mIndoorOffset = Integer.valueOf(mConfig.optInt("indoor_offset", 0));
            if (s == null)
            {
                return;
            }
            jsonobject = jsonarray;
            int i = ((flag) ? 1 : 0);
            if (jsonarray == null)
            {
                jsonobject = new JSONArray();
                i = ((flag) ? 1 : 0);
            }
            for (; i < jsonobject.length(); i++)
            {
                Object obj = jsonobject.optJSONObject(i);
                if (obj != null && ((JSONObject) (obj)).has("major_number"))
                {
                    int j = ((JSONObject) (obj)).optInt("major_number");
                    obj = new Region((new StringBuilder()).append(getPackageName()).append(s).append(j).toString(), s, Integer.valueOf(j), null);
                    mListeningRegions.add(obj);
                }
            }

            initService();
        }

        private GetConfigTask()
        {
            this$0 = PushBeaconService.this;
            super();
        }

    }

    private class InsideRunnable
        implements Runnable
    {

        private Region mRegion;
        final PushBeaconService this$0;

        public void run()
        {
            PushBeaconService.mInsideRegions.remove(mRegion);
            onInsideRegion(mRegion);
        }

        public InsideRunnable(Region region)
        {
            this$0 = PushBeaconService.this;
            super();
            mRegion = region;
        }
    }


    public static final String BACKGROUND_MODE = "backgroundMode";
    private static final Map mInsideRegions = new ConcurrentHashMap();
    private IBeaconManager mBeaconManager;
    private JSONObject mConfig;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private Integer mIndoorOffset;
    private List mListeningRegions;

    public PushBeaconService()
    {
        mBeaconManager = IBeaconManager.getInstanceForApplication(this);
    }

    private void initService()
    {
        mBeaconManager.bind(this);
    }

    private void onAddRegion(Region region)
    {
        PushManager.processBeacon(getApplicationContext(), region.getProximityUuid(), region.getMajor().toString(), null, "came");
        Intent intent = new Intent("beacon");
        intent.putExtra("Status", (new StringBuilder()).append("Add ").append(regionToString(region)).toString());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void onInsideRegion(Region region)
    {
        PushManager.processBeacon(getApplicationContext(), region.getProximityUuid(), region.getMajor().toString(), null, "indoor");
        Intent intent = new Intent("beacon");
        intent.putExtra("Status", (new StringBuilder()).append("Inside ").append(regionToString(region)).toString());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private void onRemoveRegion(Region region)
    {
        PushManager.processBeacon(getApplicationContext(), region.getProximityUuid(), region.getMajor().toString(), null, "cameout");
        Intent intent = new Intent("beacon");
        intent.putExtra("Status", (new StringBuilder()).append("Remove ").append(regionToString(region)).toString());
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }

    private String regionToString(Region region)
    {
        return (new StringBuilder()).append("Region: ").append(region.getProximityUuid()).append(", major: ").append(region.getMajor()).append(", minor: ").append(region.getMinor()).toString();
    }

    public void didDetermineStateForRegion(int i, Region region)
    {
    }

    public void didEnterRegion(Region region)
    {
        onAddRegion(region);
        if (mIndoorOffset.intValue() > 0)
        {
            InsideRunnable insiderunnable = new InsideRunnable(region);
            mHandler.postDelayed(insiderunnable, mIndoorOffset.intValue() * 1000);
            mInsideRegions.put(region, insiderunnable);
        }
    }

    public void didExitRegion(Region region)
    {
        Runnable runnable = (Runnable)mInsideRegions.remove(region);
        if (runnable != null)
        {
            mHandler.removeCallbacks(runnable);
        }
        onRemoveRegion(region);
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        mHandlerThread = new HandlerThread(getPackageName());
        mHandlerThread.start();
        mHandler = new Handler(mHandlerThread.getLooper());
    }

    public void onDestroy()
    {
        try
        {
            Region region;
            for (Iterator iterator = mListeningRegions.iterator(); iterator.hasNext(); mHandler.removeCallbacks((Runnable)mInsideRegions.get(region)))
            {
                region = (Region)iterator.next();
                mBeaconManager.stopRangingBeaconsInRegion(region);
            }

        }
        catch (RemoteException remoteexception) { }
        mHandlerThread.quit();
        mBeaconManager.unBind(this);
        super.onDestroy();
    }

    public void onIBeaconServiceConnect()
    {
        mBeaconManager.setMonitorNotifier(this);
        try
        {
            Region region;
            for (Iterator iterator = mListeningRegions.iterator(); iterator.hasNext(); mBeaconManager.startMonitoringBeaconsInRegion(region))
            {
                region = (Region)iterator.next();
            }

        }
        catch (RemoteException remoteexception) { }
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        super.onStartCommand(intent, i, j);
        if (intent.hasExtra("backgroundMode"))
        {
            mBeaconManager.setBackgroundMode(this, intent.getBooleanExtra("backgroundMode", true));
            return 1;
        } else
        {
            (new GetConfigTask()).execute(new Void[0]);
            return 1;
        }
    }






/*
    static List access$302(PushBeaconService pushbeaconservice, List list)
    {
        pushbeaconservice.mListeningRegions = list;
        return list;
    }

*/



/*
    static JSONObject access$402(PushBeaconService pushbeaconservice, JSONObject jsonobject)
    {
        pushbeaconservice.mConfig = jsonobject;
        return jsonobject;
    }

*/


/*
    static Integer access$502(PushBeaconService pushbeaconservice, Integer integer)
    {
        pushbeaconservice.mIndoorOffset = integer;
        return integer;
    }

*/

}
