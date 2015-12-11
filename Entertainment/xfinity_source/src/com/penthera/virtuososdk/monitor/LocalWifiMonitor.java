// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.monitor;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import com.penthera.virtuososdk.utility.CommonUtil;
import java.lang.ref.SoftReference;
import java.util.Iterator;
import java.util.Vector;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

public class LocalWifiMonitor extends BroadcastReceiver
{
    public static interface IWifiCheckObserver
    {

        public abstract void isOkay(boolean flag);
    }


    private static final String LOG_TAG = com/penthera/virtuososdk/monitor/LocalWifiMonitor.getName();
    private static String PING_URL = "http://www.google.com";
    private static Handler iAlarmHandler = null;
    private static boolean iDisconnectedWifi = false;
    private static SoftReference iInstance = null;
    private static boolean iResetRequested = false;
    private static int iUnknownHostCount = 0;
    private Vector iObservers;

    private LocalWifiMonitor()
    {
        iObservers = null;
        iObservers = new Vector();
        SetupHandler();
        registerReceivers();
    }

    private void RequestDelayedAlarm(int i)
    {
        iAlarmHandler.removeMessages(1);
        Message message = iAlarmHandler.obtainMessage(1);
        iAlarmHandler.sendMessageDelayed(message, i);
    }

    private void SetupHandler()
    {
        iAlarmHandler = new Handler() {

            final LocalWifiMonitor this$0;

            public void handleMessage(Message message)
            {
                switch (message.what)
                {
                default:
                    com.penthera.virtuososdk.utility.CommonUtil.Log.e(LocalWifiMonitor.LOG_TAG, (new StringBuilder("c[] Wrong message ")).append(message.what).toString());
                    return;

                case 1: // '\001'
                    handleAlarm();
                    break;
                }
            }

            
            {
                this$0 = LocalWifiMonitor.this;
                super();
            }
        };
        RequestDelayedAlarm(0x249f0);
    }

    private void disconnectWifi()
    {
        WifiManager wifimanager = (WifiManager)CommonUtil.getApplicationContext().getSystemService("wifi");
        if (wifimanager != null) goto _L2; else goto _L1
_L1:
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, "disconnectWifi(): Could not access the Wifi manager");
_L4:
        return;
_L2:
        if (!wifimanager.isWifiEnabled()) goto _L4; else goto _L3
_L3:
        SupplicantState supplicantstate;
        supplicantstate = wifimanager.getConnectionInfo().getSupplicantState();
        if (supplicantstate == null)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, "disconnectWifi(): Could not access supplicant state");
            return;
        }
        com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("disconnectWifi(): supplicantState")).append(supplicantstate).toString());
        if (supplicantstate == SupplicantState.DISCONNECTED) goto _L4; else goto _L5
_L5:
        wifimanager.disconnect();
        iDisconnectedWifi = true;
        return;
        Exception exception;
        exception;
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("disconnectWifi(): Caught exception disconnecting WIFI")).append(exception).toString());
        return;
    }

    private void handleAlarm()
    {
        if (iUnknownHostCount >= 3 || iResetRequested)
        {
            (new Thread(new Runnable() {

                final LocalWifiMonitor this$0;

                public void run()
                {
                    boolean flag = pingWifi(LocalWifiMonitor.PING_URL);
                    if (!flag)
                    {
                        disconnectWifi();
                    }
                    notifyObservers(flag);
                    LocalWifiMonitor.iUnknownHostCount = 0;
                    LocalWifiMonitor.iResetRequested = false;
                }

            
            {
                this$0 = LocalWifiMonitor.this;
                super();
            }
            })).start();
        }
        RequestDelayedAlarm(0x249f0);
    }

    private void handleConnectionGain(NetworkInfo networkinfo)
    {
        if (networkinfo != null && networkinfo.getType() == 1)
        {
            iDisconnectedWifi = false;
        }
    }

    private void handleConnectionLoss()
    {
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "handleConnectionLoss()");
        if (iDisconnectedWifi)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, "attempting reconnect()");
            reconnectWifi();
        }
    }

    private void handleConnectivity()
    {
        Object obj = CommonUtil.getApplicationContext();
        if (obj != null)
        {
            if ((obj = (ConnectivityManager)((Context) (obj)).getSystemService("connectivity")) != null)
            {
                obj = ((ConnectivityManager) (obj)).getActiveNetworkInfo();
                if (obj == null || !((NetworkInfo) (obj)).isConnected())
                {
                    handleConnectionLoss();
                    return;
                } else
                {
                    handleConnectionGain(((NetworkInfo) (obj)));
                    return;
                }
            }
        }
    }

    private void handleReset()
    {
        iResetRequested = true;
    }

    private void handleUnknownHost()
    {
        iUnknownHostCount++;
    }

    public static LocalWifiMonitor instance()
    {
        com/penthera/virtuososdk/monitor/LocalWifiMonitor;
        JVM INSTR monitorenter ;
        LocalWifiMonitor localwifimonitor = null;
        if (iInstance != null)
        {
            localwifimonitor = (LocalWifiMonitor)iInstance.get();
        }
        LocalWifiMonitor localwifimonitor1;
        localwifimonitor1 = localwifimonitor;
        if (localwifimonitor != null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        localwifimonitor1 = new LocalWifiMonitor();
        iInstance = new SoftReference(localwifimonitor1);
        com/penthera/virtuososdk/monitor/LocalWifiMonitor;
        JVM INSTR monitorexit ;
        return localwifimonitor1;
        Exception exception;
        exception;
        throw exception;
    }

    private void notifyObservers(boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        Iterator iterator = iObservers.iterator();
_L4:
        if (iterator.hasNext()) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        IWifiCheckObserver iwificheckobserver = (IWifiCheckObserver)iterator.next();
        if (iwificheckobserver == null) goto _L4; else goto _L3
_L3:
        iwificheckobserver.isOkay(flag);
          goto _L4
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private boolean pingWifi(String s)
    {
        boolean flag = false;
        s = new HttpGet(s);
        Object obj = new BasicHttpParams();
        HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj)), 30000);
        HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj)), 30000);
        obj = new DefaultHttpClient(((org.apache.http.params.HttpParams) (obj)));
        try
        {
            s = ((DefaultHttpClient) (obj)).execute(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (s.getStatusLine().getStatusCode() == 200)
        {
            flag = true;
        }
        return flag;
    }

    private void reconnectWifi()
    {
        WifiManager wifimanager = (WifiManager)CommonUtil.getApplicationContext().getSystemService("wifi");
        if (wifimanager != null)
        {
            SupplicantState supplicantstate = wifimanager.getConnectionInfo().getSupplicantState();
            if (!wifimanager.isWifiEnabled())
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, "reconnectWifi(): Wifi not enabled");
            } else
            if (supplicantstate == null)
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, "reconnectWifi(): Could not access supplicant state");
            } else
            {
                com.penthera.virtuososdk.utility.CommonUtil.Log.i(LOG_TAG, (new StringBuilder("reconnectWifi(): supplicantState")).append(supplicantstate).toString());
                try
                {
                    wifimanager.reassociate();
                }
                catch (Exception exception)
                {
                    com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("reconnectWifi(): Caught exception disconnecting WIFI")).append(exception).toString());
                }
            }
        } else
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, "reconnectWifi(): Could not access the Wifi manager");
        }
        iDisconnectedWifi = false;
        iUnknownHostCount = 0;
    }

    private void registerReceivers()
    {
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.registerLocalReceiver(this, new IntentFilter("virtuoso.intent.action.WIFI_RESET"));
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.registerLocalReceiver(this, new IntentFilter("virtuoso.intent.action.UNKNOWN_HOST"));
        com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public void addObserver(IWifiCheckObserver iwificheckobserver)
    {
        this;
        JVM INSTR monitorenter ;
        if (iwificheckobserver == null)
        {
            break MISSING_BLOCK_LABEL_26;
        }
        if (!iObservers.contains(iwificheckobserver))
        {
            iObservers.add(iwificheckobserver);
        }
        this;
        JVM INSTR monitorexit ;
        return;
        iwificheckobserver;
        throw iwificheckobserver;
    }

    protected void finalize()
        throws Throwable
    {
        iObservers.clear();
        super.finalize();
    }

    public void onReceive(Context context, Intent intent)
    {
        this;
        JVM INSTR monitorenter ;
        RequestDelayedAlarm(15000);
        context = intent.getAction();
        if (context != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("WifiMonitor(): received action: ")).append(context).toString());
        if (!context.equals("android.net.conn.CONNECTIVITY_CHANGE"))
        {
            break MISSING_BLOCK_LABEL_66;
        }
        handleConnectivity();
          goto _L1
        context;
        throw context;
label0:
        {
            if (!context.equals("virtuoso.intent.action.UNKNOWN_HOST"))
            {
                break label0;
            }
            handleUnknownHost();
        }
          goto _L1
label1:
        {
            if (!context.equals("virtuoso.intent.action.WIFI_MONITOR_ALARM"))
            {
                break label1;
            }
            handleAlarm();
        }
          goto _L1
label2:
        {
            if (!context.equals("virtuoso.intent.action.WIFI_RESET"))
            {
                break label2;
            }
            handleReset();
        }
          goto _L1
        com.penthera.virtuososdk.utility.CommonUtil.Log.w(LOG_TAG, (new StringBuilder("WifiMonitor(): Unknown broadcast action: ")).append(context).toString());
          goto _L1
    }

    public void release()
    {
        try
        {
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.unregisterLocalReceiver(this);
            com.penthera.virtuososdk.utility.CommonUtil.Broadcasts.unregisterReceiver(this);
        }
        catch (Exception exception) { }
        iAlarmHandler.removeMessages(1);
    }









}
