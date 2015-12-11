// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp;

import org.cybergarage.net.HostInterface;
import org.cybergarage.soap.SOAP;
import org.cybergarage.upnp.ssdp.SSDP;
import org.cybergarage.util.Debug;
import org.cybergarage.xml.Parser;

public class UPnP
{

    public static final int DEFAULT_EXPIRED_DEVICE_EXTRA_TIME = 60;
    public static final int DEFAULT_TTL = 4;
    public static final String INMPR03 = "INMPR03";
    public static final int INMPR03_DISCOVERY_OVER_WIRELESS_COUNT = 4;
    public static final String INMPR03_VERSION = "1.0";
    public static final String NAME = "CyberLinkJava";
    public static final int SERVER_RETRY_COUNT = 100;
    public static final int USE_IPV6_ADMINISTRATIVE_SCOPE = 5;
    public static final int USE_IPV6_GLOBAL_SCOPE = 7;
    public static final int USE_IPV6_LINK_LOCAL_SCOPE = 3;
    public static final int USE_IPV6_SITE_LOCAL_SCOPE = 6;
    public static final int USE_IPV6_SUBNET_SCOPE = 4;
    public static final int USE_LOOPBACK_ADDR = 2;
    public static final int USE_ONLY_IPV4_ADDR = 9;
    public static final int USE_ONLY_IPV6_ADDR = 1;
    public static final int USE_SSDP_SEARCHRESPONSE_MULTIPLE_INTERFACES = 8;
    public static final String VERSION = "1.8";
    public static final String XML_CLASS_PROPERTTY = "cyberlink.upnp.xml.parser";
    public static final String XML_DECLARATION = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
    private static int timeToLive = 4;
    private static Parser xmlParser;

    public UPnP()
    {
    }

    public static final String createUUID()
    {
        long l = System.currentTimeMillis();
        long l1 = (long)((double)System.currentTimeMillis() * Math.random());
        return (new StringBuilder(String.valueOf(toUUID((int)(l & 65535L))))).append("-").append(toUUID((int)(l >> 32 | 40960L) & 0xffff)).append("-").append(toUUID((int)(l1 & 65535L))).append("-").append(toUUID((int)(l1 >> 32 | 57344L) & 0xffff)).toString();
    }

    public static final String getServerName()
    {
        String s = System.getProperty("os.name");
        String s1 = System.getProperty("os.version");
        return (new StringBuilder(String.valueOf(s))).append("/").append(s1).append(" UPnP/1.0 ").append("CyberLinkJava").append("/").append("1.8").toString();
    }

    public static final int getTimeToLive()
    {
        return timeToLive;
    }

    public static final Parser getXMLParser()
    {
        if (xmlParser == null)
        {
            xmlParser = loadDefaultXMLParser();
            if (xmlParser == null)
            {
                throw new RuntimeException("No XML parser defined. And unable to laod any. \nTry to invoke UPnP.setXMLParser before UPnP.getXMLParser");
            }
            SOAP.setXMLParser(xmlParser);
        }
        return xmlParser;
    }

    public static final void initialize()
    {
    }

    public static final boolean isEnabled(int i)
    {
        switch (i)
        {
        default:
            return false;

        case 1: // '\001'
            return HostInterface.USE_ONLY_IPV6_ADDR;

        case 9: // '\t'
            return HostInterface.USE_ONLY_IPV4_ADDR;

        case 2: // '\002'
            return HostInterface.USE_LOOPBACK_ADDR;
        }
    }

    private static Parser loadDefaultXMLParser()
    {
        String as[];
        int i;
        as = new String[5];
        as[0] = System.getProperty("cyberlink.upnp.xml.parser");
        as[1] = "org.cybergarage.xml.parser.XmlPullParser";
        as[2] = "org.cybergarage.xml.parser.JaxpParser";
        as[3] = "org.cybergarage.xml.parser.kXML2Parser";
        as[4] = "org.cybergarage.xml.parser.XercesParser";
        i = 0;
_L2:
        if (i >= as.length)
        {
            return null;
        }
        if (as[i] != null)
        {
            break; /* Loop/switch isn't completed */
        }
_L3:
        i++;
        if (true) goto _L2; else goto _L1
_L1:
        Parser parser = (Parser)Class.forName(as[i]).newInstance();
        return parser;
        Throwable throwable;
        throwable;
        Debug.warning((new StringBuilder("Unable to load ")).append(as[i]).append(" as XMLParser due to ").append(throwable).toString());
          goto _L3
    }

    public static final void setDisable(int i)
    {
        switch (i)
        {
        default:
            return;

        case 1: // '\001'
            HostInterface.USE_ONLY_IPV6_ADDR = false;
            return;

        case 9: // '\t'
            HostInterface.USE_ONLY_IPV4_ADDR = false;
            return;

        case 2: // '\002'
            HostInterface.USE_LOOPBACK_ADDR = false;
            return;
        }
    }

    public static final void setEnable(int i)
    {
        switch (i)
        {
        case 8: // '\b'
        default:
            return;

        case 1: // '\001'
            HostInterface.USE_ONLY_IPV6_ADDR = true;
            return;

        case 9: // '\t'
            HostInterface.USE_ONLY_IPV4_ADDR = true;
            return;

        case 2: // '\002'
            HostInterface.USE_LOOPBACK_ADDR = true;
            return;

        case 3: // '\003'
            SSDP.setIPv6Address("FF02::C");
            return;

        case 4: // '\004'
            SSDP.setIPv6Address("FF03::C");
            return;

        case 5: // '\005'
            SSDP.setIPv6Address("FF04::C");
            return;

        case 6: // '\006'
            SSDP.setIPv6Address("FF05::C");
            return;

        case 7: // '\007'
            SSDP.setIPv6Address("FF0E::C");
            return;
        }
    }

    public static final void setTimeToLive(int i)
    {
        timeToLive = i;
    }

    public static final void setXMLParser(Parser parser)
    {
        xmlParser = parser;
        SOAP.setXMLParser(parser);
    }

    private static final String toUUID(int i)
    {
        String s1 = Integer.toString(0xffff & i, 16);
        int j = s1.length();
        String s = "";
        i = 0;
        do
        {
            if (i >= 4 - j)
            {
                return (new StringBuilder(String.valueOf(s))).append(s1).toString();
            }
            s = (new StringBuilder(String.valueOf(s))).append("0").toString();
            i++;
        } while (true);
    }

    static 
    {
        setTimeToLive(4);
    }
}
