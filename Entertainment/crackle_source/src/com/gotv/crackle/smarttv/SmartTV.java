// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.smarttv;

import android.os.AsyncTask;
import com.gotv.crackle.util.Log;
import java.util.ArrayList;
import java.util.List;
import org.cybergarage.upnp.Device;

// Referenced classes of package com.gotv.crackle.smarttv:
//            SmartTVDiscovery, SmartTVConnection, SmartTVListener

public class SmartTV
{
    class ConnectionTask extends AsyncTask
    {

        final SmartTV this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Device[])aobj);
        }

        protected transient Void doInBackground(Device adevice[])
        {
            mTVConnection.connect(adevice[0].getLocation(), adevice[0].getFriendlyName());
            return null;
        }

        ConnectionTask()
        {
            this$0 = SmartTV.this;
            super();
        }
    }

    class DiscoveryTask extends AsyncTask
    {

        final SmartTV this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient Void doInBackground(Void avoid[])
        {
            if (!mDiscoveryInitialized)
            {
                mDiscovery.init();
                mDiscoveryInitialized = true;
            }
            mDiscovery.search();
            return null;
        }

        DiscoveryTask()
        {
            this$0 = SmartTV.this;
            super();
        }
    }

    class LaunchTask extends AsyncTask
    {

        final SmartTV this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            mTVConnection.connectToTV(as[0], as[1]);
            return null;
        }

        LaunchTask()
        {
            this$0 = SmartTV.this;
            super();
        }
    }

    class SendDataTask extends AsyncTask
    {

        final SmartTV this$0;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((String[])aobj);
        }

        protected transient Void doInBackground(String as[])
        {
            mTVConnection.sendData(as[0]);
            return null;
        }

        SendDataTask()
        {
            this$0 = SmartTV.this;
            super();
        }
    }


    private static final String LOG_TAG = "SmartTV";
    private static SmartTV mInstance = null;
    private Device mCurrentDevice;
    private SmartTVDiscovery mDiscovery;
    private boolean mDiscoveryInitialized;
    private List mListeners;
    private SmartTVConnection mTVConnection;

    private SmartTV()
    {
        mDiscoveryInitialized = false;
        mDiscovery = null;
        mTVConnection = null;
        mListeners = null;
        mCurrentDevice = null;
        mDiscovery = new SmartTVDiscovery();
        mTVConnection = new SmartTVConnection();
        mListeners = new ArrayList();
        Log.d("SmartTV", "SmartTV instance created via Singleton pattern.");
    }

    public static SmartTV getInstance()
    {
        com/gotv/crackle/smarttv/SmartTV;
        JVM INSTR monitorenter ;
        SmartTV smarttv;
        if (mInstance == null)
        {
            mInstance = new SmartTV();
        }
        smarttv = mInstance;
        com/gotv/crackle/smarttv/SmartTV;
        JVM INSTR monitorexit ;
        return smarttv;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isTVEmulator(String s)
    {
        return s != null && s.contains("TV") && s.contains("SDK");
    }

    public void addSmartTVListener(SmartTVListener smarttvlistener)
    {
        if (!mListeners.contains(smarttvlistener))
        {
            Log.d("SmartTV", "adding SmartTVListener");
            mListeners.add(smarttvlistener);
            mDiscovery.setListeners(mListeners);
            mTVConnection.setListeners(mListeners);
        }
    }

    public void connect(int i)
    {
        mCurrentDevice = mDiscovery.getDevice(i);
        (new ConnectionTask()).execute(new Device[] {
            mCurrentDevice
        });
    }

    public void connectToTV(int i, String s)
    {
        mCurrentDevice = mDiscovery.getDevice(i);
        (new LaunchTask()).execute(new String[] {
            mCurrentDevice.getLocation(), s
        });
    }

    public void disconnect()
    {
        (new Thread(new Runnable() {

            final SmartTV this$0;

            public void run()
            {
                mTVConnection.disconnect();
            }

            
            {
                this$0 = SmartTV.this;
                super();
            }
        })).start();
        Log.d("SmartTV", "disconnect background task started");
    }

    public List getDeviceList()
    {
        return mDiscovery.getDeviceList();
    }

    public void removeSmartTVListener(SmartTVListener smarttvlistener)
    {
        if (mListeners.contains(smarttvlistener))
        {
            Log.d("SmartTV", "removing SmartTVListener");
            mListeners.remove(smarttvlistener);
            mDiscovery.setListeners(mListeners);
            mTVConnection.setListeners(mListeners);
        }
    }

    public void sendData(String s)
    {
        (new SendDataTask()).execute(new String[] {
            s
        });
        Log.d("SmartTV", (new StringBuilder()).append("send data background task started = ").append(s).toString());
    }

    public void startDiscovery()
    {
        (new DiscoveryTask()).execute((Void[])null);
        Log.d("SmartTV", "start discovery background task started");
    }

    public void stopDiscovery()
    {
        mDiscovery.stopControlPoint();
        mDiscoveryInitialized = false;
    }





/*
    static boolean access$102(SmartTV smarttv, boolean flag)
    {
        smarttv.mDiscoveryInitialized = flag;
        return flag;
    }

*/

}
