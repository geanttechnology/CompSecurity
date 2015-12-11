// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.ConnectivityManager;
import android.util.Log;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;

public class ciy
{

    private static final String b = ciy.getSimpleName();
    private static final ciy c = new ciy();
    public ConnectivityManager a;

    public ciy()
    {
        a = null;
    }

    public static final ciy a()
    {
        return c;
    }

    private static InetAddress b()
    {
        Enumeration enumeration = NetworkInterface.getNetworkInterfaces();
_L2:
        Object obj;
        do
        {
            if (!enumeration.hasMoreElements())
            {
                break MISSING_BLOCK_LABEL_88;
            }
            obj = (NetworkInterface)enumeration.nextElement();
        } while (!((NetworkInterface) (obj)).getName().equals("rmnet_usb0"));
        obj = ((NetworkInterface) (obj)).getInetAddresses();
_L4:
        if (!((Enumeration) (obj)).hasMoreElements()) goto _L2; else goto _L1
_L1:
        InetAddress inetaddress = (InetAddress)((Enumeration) (obj)).nextElement();
        if (inetaddress.isLoopbackAddress()) goto _L4; else goto _L3
_L3:
        boolean flag = inetaddress.isLinkLocalAddress();
        if (flag) goto _L4; else goto _L5
_L5:
        return inetaddress;
        SocketException socketexception;
        socketexception;
        Log.e("ServerActivity", socketexception.toString());
        return null;
    }

    public final boolean a(String s, ciz ciz1)
    {
        if (a == null)
        {
            ciz1 = b;
            String s1 = String.valueOf("connManager is not initialized. The HIPRI Mobile feature will not be used for hostName: ");
            s = String.valueOf(s);
            if (s.length() != 0)
            {
                s = s1.concat(s);
            } else
            {
                s = new String(s1);
            }
            Log.e(ciz1, s);
            return false;
        }
        if (ciz1 != ciz.a)
        {
            ciz1 = b;
            ciz1 = String.valueOf("Android uses the WIFI route by default. Nothing needs to be done here for hostName: ");
            s = String.valueOf(s);
            if (s.length() != 0)
            {
                ciz1.concat(s);
            } else
            {
                new String(ciz1);
            }
            return true;
        }
        HashSet hashset = new HashSet();
        s = InetAddress.getAllByName(s);
        int i = 0;
        while (i < s.length) 
        {
            if (s[i] instanceof Inet4Address)
            {
                hashset.add(s[i].getHostAddress());
                String s3 = b;
                s3 = String.valueOf(s[i].getHostAddress());
                if (s3.length() != 0)
                {
                    "IP added: ".concat(s3);
                } else
                {
                    new String("IP added: ");
                }
            }
            i++;
        }
        Iterator iterator = hashset.iterator();
label0:
        do
        {
label1:
            {
                boolean flag;
label2:
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    String s4 = (String)iterator.next();
                    if (a.startUsingNetworkFeature(0, "enableHIPRI") == -1)
                    {
                        throw new IOException("startUsingNetworkFeature failed.");
                    }
                    s = null;
                    int j = 0;
                    String s2;
                    do
                    {
                        s2 = s;
                        if (j >= 15)
                        {
                            break;
                        }
                        s = b();
                        s2 = s;
                        if (s != null)
                        {
                            break;
                        }
                        j++;
                    } while (true);
                    if (!(s2 instanceof Inet4Address))
                    {
                        break label1;
                    }
                    s = ((Inet4Address)Inet4Address.getByName(s4)).getAddress();
                    byte byte0 = s[3];
                    byte byte1 = s[2];
                    byte byte2 = s[1];
                    byte byte3 = s[0];
                    j = 0;
                    flag = false;
                    do
                    {
                        if (j >= 15)
                        {
                            break label2;
                        }
                        flag = a.requestRouteToHost(5, (byte0 & 0xff) << 24 | (byte1 & 0xff) << 16 | (byte2 & 0xff) << 8 | byte3 & 0xff);
                        s = b;
                        s = String.valueOf(ciz1);
                        (new StringBuilder(String.valueOf(s4).length() + 49 + String.valueOf(s).length())).append("requestRouteToHost: ").append(s4).append("; requestRouteSuccess=").append(flag).append("; ").append(s);
                        if (flag)
                        {
                            break label2;
                        }
                        try
                        {
                            Thread.sleep(1000L);
                        }
                        // Misplaced declaration of an exception variable
                        catch (String s)
                        {
                            Log.e(b, "Error on sleep.");
                            throw new IOException("Error occured during thread.sleep().");
                        }
                        j++;
                    } while (true);
                }
                if (!flag)
                {
                    throw new IOException("Failed to request the route.");
                }
                continue;
            }
            s = b;
        } while (true);
        return true;
    }

}
