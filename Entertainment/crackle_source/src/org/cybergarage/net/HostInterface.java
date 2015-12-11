// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.net;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;
import org.cybergarage.util.Debug;

public class HostInterface
{

    public static final int IPV4_BITMASK = 1;
    public static final int IPV6_BITMASK = 16;
    public static final int LOCAL_BITMASK = 256;
    public static boolean USE_LOOPBACK_ADDR = false;
    public static boolean USE_ONLY_IPV4_ADDR = false;
    public static boolean USE_ONLY_IPV6_ADDR = false;
    private static String ifAddress = "";

    public HostInterface()
    {
    }

    public static final String getHostAddress(int i)
    {
        int j;
        if (hasAssignedInterface())
        {
            return getInterface();
        }
        j = 0;
        Object obj = NetworkInterface.getNetworkInterfaces();
_L4:
        boolean flag = ((Enumeration) (obj)).hasMoreElements();
        if (flag) goto _L2; else goto _L1
_L1:
        return "";
_L2:
        Enumeration enumeration = ((NetworkInterface)((Enumeration) (obj)).nextElement()).getInetAddresses();
        int k = j;
_L5:
        j = k;
        if (!enumeration.hasMoreElements()) goto _L4; else goto _L3
_L3:
        InetAddress inetaddress = (InetAddress)enumeration.nextElement();
        if (isUsableAddress(inetaddress))
        {
label0:
            {
                if (k >= i)
                {
                    break label0;
                }
                k++;
            }
        }
          goto _L5
        obj = inetaddress.getHostAddress();
        return ((String) (obj));
        Exception exception;
        exception;
          goto _L1
    }

    public static final String getHostURL(String s, int i, String s1)
    {
        String s2 = s;
        if (isIPv6Address(s))
        {
            s2 = (new StringBuilder("[")).append(s).append("]").toString();
        }
        return (new StringBuilder("http://")).append(s2).append(":").append(Integer.toString(i)).append(s1).toString();
    }

    public static final String getIPv4Address()
    {
        int i;
        int j;
        j = getNHostAddresses();
        i = 0;
_L6:
        if (i < j) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        return s;
_L2:
        String s1;
        s1 = getHostAddress(i);
        s = s1;
        if (isIPv4Address(s1)) goto _L4; else goto _L3
_L3:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static final String getIPv6Address()
    {
        int i;
        int j;
        j = getNHostAddresses();
        i = 0;
_L6:
        if (i < j) goto _L2; else goto _L1
_L1:
        String s = "";
_L4:
        return s;
_L2:
        String s1;
        s1 = getHostAddress(i);
        s = s1;
        if (isIPv6Address(s1)) goto _L4; else goto _L3
_L3:
        i++;
        if (true) goto _L6; else goto _L5
_L5:
    }

    public static final InetAddress[] getInetAddress(int i, String as[])
    {
        if (as == null) goto _L2; else goto _L1
_L1:
        Object obj;
        int j;
        obj = new Vector();
        j = 0;
_L5:
        if (j < as.length) goto _L4; else goto _L3
_L3:
        as = ((Vector) (obj)).elements();
_L7:
        obj = new ArrayList();
_L8:
        if (!as.hasMoreElements())
        {
            return (InetAddress[])((ArrayList) (obj)).toArray(new InetAddress[0]);
        }
        break MISSING_BLOCK_LABEL_97;
_L4:
        NetworkInterface networkinterface = NetworkInterface.getByName(as[j]);
        if (networkinterface != null)
        {
            ((Vector) (obj)).add(networkinterface);
        }
_L6:
        j++;
          goto _L5
        SocketException socketexception;
        socketexception;
          goto _L6
_L2:
        try
        {
            as = NetworkInterface.getNetworkInterfaces();
        }
        // Misplaced declaration of an exception variable
        catch (String as[])
        {
            return null;
        }
          goto _L7
        Enumeration enumeration = ((NetworkInterface)as.nextElement()).getInetAddresses();
        while (enumeration.hasMoreElements()) 
        {
            InetAddress inetaddress = (InetAddress)enumeration.nextElement();
            if ((i & 0x100) != 0 || !inetaddress.isLoopbackAddress())
            {
                if ((i & 1) != 0 && (inetaddress instanceof Inet4Address))
                {
                    ((ArrayList) (obj)).add(inetaddress);
                } else
                if ((i & 0x10) != 0 && (inetaddress instanceof InetAddress))
                {
                    ((ArrayList) (obj)).add(inetaddress);
                }
            }
        }
          goto _L8
    }

    public static final String getInterface()
    {
        return ifAddress;
    }

    public static final int getNHostAddresses()
    {
        if (!hasAssignedInterface()) goto _L2; else goto _L1
_L1:
        int k = 1;
_L4:
        return k;
_L2:
        int j = 0;
        int i = 0;
        Enumeration enumeration;
        Enumeration enumeration1;
        boolean flag;
        try
        {
            enumeration = NetworkInterface.getNetworkInterfaces();
        }
        catch (Exception exception)
        {
            Debug.warning(exception);
            return j;
        }
        k = i;
        j = i;
        if (!enumeration.hasMoreElements()) goto _L4; else goto _L3
_L3:
        j = i;
        enumeration1 = ((NetworkInterface)enumeration.nextElement()).getInetAddresses();
        k = i;
_L6:
        i = k;
        j = k;
        if (!enumeration1.hasMoreElements())
        {
            break MISSING_BLOCK_LABEL_20;
        }
        j = k;
        flag = isUsableAddress((InetAddress)enumeration1.nextElement());
        if (flag)
        {
            k++;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private static final boolean hasAssignedInterface()
    {
        return ifAddress.length() > 0;
    }

    public static final boolean hasIPv4Addresses()
    {
        int j = getNHostAddresses();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return false;
            }
            if (isIPv4Address(getHostAddress(i)))
            {
                return true;
            }
            i++;
        } while (true);
    }

    public static final boolean hasIPv6Addresses()
    {
        int j = getNHostAddresses();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return false;
            }
            if (isIPv6Address(getHostAddress(i)))
            {
                return true;
            }
            i++;
        } while (true);
    }

    public static final boolean isIPv4Address(String s)
    {
        boolean flag = false;
        boolean flag1;
        try
        {
            flag1 = InetAddress.getByName(s) instanceof Inet4Address;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (flag1)
        {
            flag = true;
        }
        return flag;
    }

    public static final boolean isIPv6Address(String s)
    {
        boolean flag = false;
        boolean flag1;
        try
        {
            flag1 = InetAddress.getByName(s) instanceof Inet6Address;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        if (flag1)
        {
            flag = true;
        }
        return flag;
    }

    private static final boolean isUsableAddress(InetAddress inetaddress)
    {
        while (!USE_LOOPBACK_ADDR && inetaddress.isLoopbackAddress() || USE_ONLY_IPV4_ADDR && (inetaddress instanceof Inet6Address) || USE_ONLY_IPV6_ADDR && (inetaddress instanceof Inet4Address)) 
        {
            return false;
        }
        return true;
    }

    public static final void setInterface(String s)
    {
        ifAddress = s;
    }

}
