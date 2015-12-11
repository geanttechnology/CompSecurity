// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import org.chromium.base.ApplicationStatus;

// Referenced classes of package org.chromium.net:
//            NetworkChangeNotifier

public class NetworkChangeNotifierAutoDetect extends BroadcastReceiver
    implements org.chromium.base.ApplicationStatus.ApplicationStateListener
{

    ConnectivityManagerDelegate a;
    private final NetworkConnectivityIntentFilter b;
    private final Observer c;
    private final Context d;
    private WifiManagerDelegate e;
    private boolean f;
    private int g;
    private String h;
    private double i;

    public NetworkChangeNotifierAutoDetect(Observer observer, Context context, boolean flag)
    {
        c = observer;
        d = context.getApplicationContext();
        a = new ConnectivityManagerDelegate(context);
        e = new WifiManagerDelegate(context);
        observer = a.a();
        g = a(observer);
        h = c(observer);
        i = b(observer);
        b = new NetworkConnectivityIntentFilter(e.c);
        if (flag)
        {
            b();
            return;
        } else
        {
            ApplicationStatus.a(this);
            return;
        }
    }

    public static int a(NetworkState networkstate)
    {
        byte byte1 = 5;
        if (networkstate.a) goto _L2; else goto _L1
_L1:
        byte byte0 = 6;
_L4:
        return byte0;
_L2:
        byte0 = byte1;
        switch (networkstate.b)
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 8: // '\b'
        default:
            return 0;

        case 6: // '\006'
            continue; /* Loop/switch isn't completed */

        case 9: // '\t'
            return 1;

        case 1: // '\001'
            return 2;

        case 7: // '\007'
            return 7;

        case 0: // '\0'
            byte0 = byte1;
            break;
        }
        switch (networkstate.c)
        {
        default:
            return 0;

        case 1: // '\001'
        case 2: // '\002'
        case 4: // '\004'
        case 7: // '\007'
        case 11: // '\013'
            return 3;

        case 3: // '\003'
        case 5: // '\005'
        case 6: // '\006'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 12: // '\f'
        case 14: // '\016'
        case 15: // '\017'
            return 4;

        case 13: // '\r'
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    private void b()
    {
        if (!f)
        {
            f = true;
            d.registerReceiver(this, b);
        }
    }

    private String c(NetworkState networkstate)
    {
        if (a(networkstate) == 2) goto _L2; else goto _L1
_L1:
        networkstate = "";
_L4:
        return networkstate;
_L2:
        String s;
        networkstate = e.a.registerReceiver(null, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        if (networkstate == null)
        {
            break; /* Loop/switch isn't completed */
        }
        networkstate = (WifiInfo)networkstate.getParcelableExtra("wifiInfo");
        if (networkstate == null)
        {
            break; /* Loop/switch isn't completed */
        }
        s = networkstate.getSSID();
        networkstate = s;
        if (s != null) goto _L4; else goto _L3
_L3:
        return "";
    }

    private void d(NetworkState networkstate)
    {
        int j = a(networkstate);
        networkstate = c(networkstate);
        if (j == g && networkstate.equals(h))
        {
            return;
        } else
        {
            g = j;
            h = networkstate;
            (new StringBuilder("Network connectivity changed, type is: ")).append(g);
            c.a(j);
            return;
        }
    }

    private void e(NetworkState networkstate)
    {
        double d1 = b(networkstate);
        if (d1 == i)
        {
            return;
        } else
        {
            i = d1;
            c.a(d1);
            return;
        }
    }

    void a()
    {
        if (f)
        {
            f = false;
            d.unregisterReceiver(this);
        }
    }

    public final void a(int j)
    {
        NetworkState networkstate = a.a();
        if (j == 1)
        {
            d(networkstate);
            e(networkstate);
            b();
        } else
        if (j == 2)
        {
            a();
            return;
        }
    }

    public final double b(NetworkState networkstate)
    {
        byte byte1;
        byte1 = 30;
        if (a(networkstate) == 2)
        {
            Object obj = e;
            int j;
            if (!((WifiManagerDelegate) (obj)).c || ((WifiManagerDelegate) (obj)).b == null)
            {
                j = -1;
            } else
            {
                obj = ((WifiManagerDelegate) (obj)).b.getConnectionInfo();
                if (obj == null)
                {
                    j = -1;
                } else
                {
                    j = ((WifiInfo) (obj)).getLinkSpeed();
                }
            }
            if (j != -1)
            {
                return (double)j;
            }
        }
        if (networkstate.a) goto _L2; else goto _L1
_L1:
        byte byte0 = 31;
_L4:
        return NetworkChangeNotifier.a(byte0);
_L2:
        byte0 = byte1;
        switch (networkstate.b)
        {
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 8: // '\b'
        default:
            byte0 = byte1;
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
        case 6: // '\006'
        case 7: // '\007'
        case 9: // '\t'
            break;

        case 0: // '\0'
            switch (networkstate.c)
            {
            default:
                byte0 = byte1;
                break;

            case 1: // '\001'
                byte0 = 4;
                break;

            case 2: // '\002'
                byte0 = 5;
                break;

            case 4: // '\004'
                byte0 = 2;
                break;

            case 7: // '\007'
                byte0 = 3;
                break;

            case 11: // '\013'
                byte0 = 1;
                break;

            case 3: // '\003'
                byte0 = 6;
                break;

            case 5: // '\005'
                byte0 = 7;
                break;

            case 6: // '\006'
                byte0 = 8;
                break;

            case 8: // '\b'
                byte0 = 11;
                break;

            case 9: // '\t'
                byte0 = 12;
                break;

            case 10: // '\n'
                byte0 = 9;
                break;

            case 12: // '\f'
                byte0 = 10;
                break;

            case 14: // '\016'
                byte0 = 13;
                break;

            case 15: // '\017'
                byte0 = 14;
                break;

            case 13: // '\r'
                byte0 = 15;
                break;
            }
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public void onReceive(Context context, Intent intent)
    {
        context = a.a();
        if ("android.net.conn.CONNECTIVITY_CHANGE".equals(intent.getAction()))
        {
            d(context);
            e(context);
        } else
        if ("android.net.wifi.RSSI_CHANGED".equals(intent.getAction()))
        {
            e(context);
            return;
        }
    }

    private class ConnectivityManagerDelegate
    {

        private final ConnectivityManager a;

        final NetworkState a()
        {
            NetworkInfo networkinfo = a.getActiveNetworkInfo();
            if (networkinfo == null || !networkinfo.isConnected())
            {
                return new NetworkState(false, -1, -1);
            } else
            {
                return new NetworkState(true, networkinfo.getType(), networkinfo.getSubtype());
            }
        }

        ConnectivityManagerDelegate()
        {
            a = null;
        }

        ConnectivityManagerDelegate(Context context)
        {
            a = (ConnectivityManager)context.getSystemService("connectivity");
        }
    }


    private class WifiManagerDelegate
    {

        final Context a;
        final WifiManager b;
        final boolean c;

        WifiManagerDelegate()
        {
            a = null;
            b = null;
            c = false;
        }

        WifiManagerDelegate(Context context)
        {
            a = context;
            boolean flag;
            if (a.getPackageManager().checkPermission("android.permission.ACCESS_WIFI_STATE", a.getPackageName()) == 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            c = flag;
            if (c)
            {
                context = (WifiManager)a.getSystemService("wifi");
            } else
            {
                context = null;
            }
            b = context;
        }
    }


    private class NetworkConnectivityIntentFilter extends IntentFilter
    {

        NetworkConnectivityIntentFilter(boolean flag)
        {
            addAction("android.net.conn.CONNECTIVITY_CHANGE");
            if (flag)
            {
                addAction("android.net.wifi.RSSI_CHANGED");
            }
        }
    }


    private class NetworkState
    {

        final boolean a;
        final int b;
        final int c;

        public NetworkState(boolean flag, int j, int k)
        {
            a = flag;
            b = j;
            c = k;
        }
    }


    private class Observer
    {

        public abstract void a(double d1);

        public abstract void a(int j);
    }

}
