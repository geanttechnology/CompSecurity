// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.device;


public class MAN
{

    public static final String DISCOVER = "ssdp:discover";

    public MAN()
    {
    }

    public static final boolean isDiscover(String s)
    {
        if (s == null)
        {
            return false;
        }
        if (s.equals("ssdp:discover"))
        {
            return true;
        } else
        {
            return s.equals("\"ssdp:discover\"");
        }
    }
}
