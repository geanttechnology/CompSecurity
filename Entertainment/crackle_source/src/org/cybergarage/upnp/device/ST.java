// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.device;


public class ST
{

    public static final String ALL_DEVICE = "ssdp:all";
    public static final String ROOT_DEVICE = "upnp:rootdevice";
    public static final String URN_DEVICE = "urn:schemas-upnp-org:device:";
    public static final String URN_SERVICE = "urn:schemas-upnp-org:service:";
    public static final String UUID_DEVICE = "uuid";

    public ST()
    {
    }

    public static final boolean isAllDevice(String s)
    {
        if (s == null)
        {
            return false;
        }
        if (s.equals("ssdp:all"))
        {
            return true;
        } else
        {
            return s.equals("\"ssdp:all\"");
        }
    }

    public static final boolean isRootDevice(String s)
    {
        if (s == null)
        {
            return false;
        }
        if (s.equals("upnp:rootdevice"))
        {
            return true;
        } else
        {
            return s.equals("\"upnp:rootdevice\"");
        }
    }

    public static final boolean isURNDevice(String s)
    {
        if (s == null)
        {
            return false;
        }
        if (s.startsWith("urn:schemas-upnp-org:device:"))
        {
            return true;
        } else
        {
            return s.startsWith("\"urn:schemas-upnp-org:device:");
        }
    }

    public static final boolean isURNService(String s)
    {
        if (s == null)
        {
            return false;
        }
        if (s.startsWith("urn:schemas-upnp-org:service:"))
        {
            return true;
        } else
        {
            return s.startsWith("\"urn:schemas-upnp-org:service:");
        }
    }

    public static final boolean isUUIDDevice(String s)
    {
        if (s == null)
        {
            return false;
        }
        if (s.startsWith("uuid"))
        {
            return true;
        } else
        {
            return s.startsWith("\"uuid");
        }
    }
}
