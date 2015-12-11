// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.event;

import org.cybergarage.upnp.UPnP;

public class Subscription
{

    public static final String INFINITE_STRING = "infinite";
    public static final int INFINITE_VALUE = -1;
    public static final String SUBSCRIBE_METHOD = "SUBSCRIBE";
    public static final String TIMEOUT_HEADER = "Second-";
    public static final String UNSUBSCRIBE_METHOD = "UNSUBSCRIBE";
    public static final String UUID = "uuid:";
    public static final String XMLNS = "urn:schemas-upnp-org:event-1-0";

    public Subscription()
    {
    }

    public static final String createSID()
    {
        return UPnP.createUUID();
    }

    public static final String getSID(String s)
    {
        String s1;
        if (s == null)
        {
            s1 = "";
        } else
        {
            s1 = s;
            if (s.startsWith("uuid:"))
            {
                return s.substring("uuid:".length(), s.length());
            }
        }
        return s1;
    }

    public static final long getTimeout(String s)
    {
        int i = s.indexOf('-');
        long l;
        try
        {
            l = Long.parseLong(s.substring(i + 1, s.length()));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return -1L;
        }
        return l;
    }

    public static final String toSIDHeaderString(String s)
    {
        return (new StringBuilder("uuid:")).append(s).toString();
    }

    public static final String toTimeoutHeaderString(long l)
    {
        if (l == -1L)
        {
            return "infinite";
        } else
        {
            return (new StringBuilder("Second-")).append(Long.toString(l)).toString();
        }
    }
}
