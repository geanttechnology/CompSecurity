// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.device;


public class NTS
{

    public static final String ALIVE = "ssdp:alive";
    public static final String BYEBYE = "ssdp:byebye";
    public static final String PROPCHANGE = "upnp:propchange";

    public NTS()
    {
    }

    public static final boolean isAlive(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return s.startsWith("ssdp:alive");
        }
    }

    public static final boolean isByeBye(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return s.startsWith("ssdp:byebye");
        }
    }
}
