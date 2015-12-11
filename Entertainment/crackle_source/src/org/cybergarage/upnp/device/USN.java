// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.device;


public class USN
{

    public static final String ROOTDEVICE = "upnp:rootdevice";

    public USN()
    {
    }

    public static final String getUDN(String s)
    {
        if (s == null)
        {
            return "";
        }
        int i = s.indexOf("::");
        if (i < 0)
        {
            return s.trim();
        } else
        {
            return (new String(s.getBytes(), 0, i)).trim();
        }
    }

    public static final boolean isRootDevice(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return s.endsWith("upnp:rootdevice");
        }
    }
}
