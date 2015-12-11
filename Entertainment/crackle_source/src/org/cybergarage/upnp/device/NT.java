// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.device;


public class NT
{

    public static final String EVENT = "upnp:event";
    public static final String ROOTDEVICE = "upnp:rootdevice";

    public NT()
    {
    }

    public static final boolean isRootDevice(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return s.startsWith("upnp:rootdevice");
        }
    }
}
