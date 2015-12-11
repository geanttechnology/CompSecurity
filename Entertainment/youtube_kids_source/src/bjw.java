// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

public final class bjw
    implements bkn
{

    public static final bjy a = new bjx();
    private final ConnectivityManager b;
    private final bjy c;
    private final WifiManager d;

    public bjw(ConnectivityManager connectivitymanager, WifiManager wifimanager, bjy bjy1)
    {
        b = (ConnectivityManager)b.a(connectivitymanager);
        d = (WifiManager)b.a(wifimanager);
        c = (bjy)b.a(bjy1);
    }

    private static long a(double d1)
    {
        return (long)((1000000D * d1) / 8D);
    }

    private boolean a(int i)
    {
        NetworkInfo networkinfo = b.getActiveNetworkInfo();
        return networkinfo != null && networkinfo.getType() == i;
    }

    private static long b(double d1)
    {
        return (long)((1000D * d1) / 8D);
    }

    public final boolean a()
    {
        NetworkInfo networkinfo = b.getActiveNetworkInfo();
        return networkinfo != null && networkinfo.isConnected();
    }

    public final boolean b()
    {
        return a() && cn.a(b);
    }

    public final boolean c()
    {
        return a(1);
    }

    public final boolean d()
    {
        return a(9);
    }

    public final boolean e()
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (a(0))
        {
            flag = flag1;
            if (c.e())
            {
                flag = true;
            }
        }
        return flag;
    }

    public final boolean f()
    {
        boolean flag1 = true;
        NetworkInfo networkinfo = b.getActiveNetworkInfo();
        if (networkinfo != null)
        {
            boolean flag = flag1;
            switch (networkinfo.getType())
            {
            default:
                flag = false;
                break;

            case 0: // '\0'
                flag = flag1;
                switch (networkinfo.getSubtype())
                {
                default:
                    return false;

                case 0: // '\0'
                case 1: // '\001'
                case 2: // '\002'
                case 3: // '\003'
                case 4: // '\004'
                case 5: // '\005'
                case 6: // '\006'
                case 7: // '\007'
                case 8: // '\b'
                case 9: // '\t'
                case 10: // '\n'
                case 11: // '\013'
                case 12: // '\f'
                case 14: // '\016'
                case 15: // '\017'
                    return false;

                case 13: // '\r'
                    break;
                }
                break;

            case 1: // '\001'
            case 6: // '\006'
            case 9: // '\t'
                break;
            }
            while (true) 
            {
                return flag;
            }
        }
        return false;
    }

    public final int g()
    {
        NetworkInfo networkinfo;
        byte byte1;
        byte1 = 6;
        networkinfo = b.getActiveNetworkInfo();
        if (networkinfo != null && networkinfo.isConnected()) goto _L2; else goto _L1
_L1:
        byte byte0 = 2;
_L4:
        return byte0;
_L2:
        byte0 = byte1;
        switch (networkinfo.getType())
        {
        default:
            return 1;

        case 6: // '\006'
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            return 3;

        case 0: // '\0'
            byte0 = byte1;
            break;
        }
        switch (networkinfo.getSubtype())
        {
        default:
            return 7;

        case 1: // '\001'
        case 2: // '\002'
            return 4;

        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
        case 9: // '\t'
        case 10: // '\n'
        case 11: // '\013'
        case 12: // '\f'
        case 14: // '\016'
        case 15: // '\017'
            return 5;

        case 13: // '\r'
            break;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final long h()
    {
        NetworkInfo networkinfo = b.getActiveNetworkInfo();
        if (networkinfo == null || !networkinfo.isConnected())
        {
            return 0L;
        }
        switch (networkinfo.getType())
        {
        case 1: // '\001'
            return a(d.getConnectionInfo().getLinkSpeed());

        case 6: // '\006'
            return a(3D);

        case 9: // '\t'
            return a(480D);

        case 0: // '\0'
            switch (networkinfo.getSubtype())
            {
            case 1: // '\001'
                return b(114D);

            case 7: // '\007'
                return b(70D);

            case 4: // '\004'
                return b(115D);

            case 2: // '\002'
                return b(135D);

            case 5: // '\005'
                return b(700D);

            case 6: // '\006'
            case 14: // '\016'
                return b(900D);

            case 8: // '\b'
                return a(1.8D);

            case 9: // '\t'
            case 10: // '\n'
                return a(1.0D);

            case 11: // '\013'
                return b(13D);

            case 3: // '\003'
                return b(384D);

            case 12: // '\f'
                return a(5D);

            case 15: // '\017'
                return a(5D);

            case 13: // '\r'
                return a(5D);
            }
            break;
        }
        while (true) 
        {
            return -1L;
        }
    }

}
