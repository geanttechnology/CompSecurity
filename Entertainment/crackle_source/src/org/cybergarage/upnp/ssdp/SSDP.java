// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import org.cybergarage.util.Debug;

public class SSDP
{

    public static final String ADDRESS = "239.255.255.250";
    public static final int DEFAULT_MSEARCH_MX = 3;
    private static String IPV6_ADDRESS;
    public static final String IPV6_ADMINISTRATIVE_ADDRESS = "FF04::C";
    public static final String IPV6_GLOBAL_ADDRESS = "FF0E::C";
    public static final String IPV6_LINK_LOCAL_ADDRESS = "FF02::C";
    public static final String IPV6_SITE_LOCAL_ADDRESS = "FF05::C";
    public static final String IPV6_SUBNET_ADDRESS = "FF03::C";
    public static final int PORT = 1900;
    public static final int RECV_MESSAGE_BUFSIZE = 1024;

    public SSDP()
    {
    }

    public static final String getIPv6Address()
    {
        return IPV6_ADDRESS;
    }

    public static final int getLeaseTime(String s)
    {
        int i = 0;
        int k = s.indexOf("max-age");
        if (k >= 0)
        {
            int j = s.indexOf(',', k);
            i = j;
            if (j < 0)
            {
                i = s.length();
            }
            try
            {
                i = Integer.parseInt(s.substring(s.indexOf("=", k) + 1, i).trim());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                Debug.warning(s);
                return 0;
            }
        }
        return i;
    }

    public static final void setIPv6Address(String s)
    {
        IPV6_ADDRESS = s;
    }

    static 
    {
        setIPv6Address("FF02::C");
    }
}
