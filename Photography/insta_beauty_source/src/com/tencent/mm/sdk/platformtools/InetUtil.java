// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.sdk.platformtools;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InetUtil
{

    private static final Pattern X = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
    private static final Pattern Y = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
    private static final Pattern Z = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");

    private InetUtil()
    {
    }

    public static InetAddress getByDottedAddress(String s)
    {
        if (isIPv4Address(s))
        {
            return InetAddress.getByName(s);
        }
        if (isIPv6Address(s))
        {
            return InetAddress.getByName(s);
        } else
        {
            throw new UnknownHostException("invalid ipv4 or ipv6 dotted string");
        }
    }

    public static boolean isIPv4Address(String s)
    {
        return X.matcher(s).matches();
    }

    public static boolean isIPv6Address(String s)
    {
        return isIPv6StdAddress(s) || isIPv6HexCompressedAddress(s);
    }

    public static boolean isIPv6HexCompressedAddress(String s)
    {
        return Z.matcher(s).matches();
    }

    public static boolean isIPv6StdAddress(String s)
    {
        return Y.matcher(s).matches();
    }

}
