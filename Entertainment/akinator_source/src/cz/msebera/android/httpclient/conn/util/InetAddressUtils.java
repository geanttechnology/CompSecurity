// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.conn.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InetAddressUtils
{

    private static final char COLON_CHAR = 58;
    private static final String IPV4_BASIC_PATTERN_STRING = "(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])";
    private static final Pattern IPV4_MAPPED_IPV6_PATTERN = Pattern.compile("^::[fF]{4}:(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    private static final Pattern IPV4_PATTERN = Pattern.compile("^(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])$");
    private static final Pattern IPV6_HEX_COMPRESSED_PATTERN = Pattern.compile("^(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)::(([0-9A-Fa-f]{1,4}(:[0-9A-Fa-f]{1,4}){0,5})?)$");
    private static final Pattern IPV6_STD_PATTERN = Pattern.compile("^[0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4}){7}$");
    private static final int MAX_COLON_COUNT = 7;

    private InetAddressUtils()
    {
    }

    public static boolean isIPv4Address(String s)
    {
        return IPV4_PATTERN.matcher(s).matches();
    }

    public static boolean isIPv4MappedIPv64Address(String s)
    {
        return IPV4_MAPPED_IPV6_PATTERN.matcher(s).matches();
    }

    public static boolean isIPv6Address(String s)
    {
        return isIPv6StdAddress(s) || isIPv6HexCompressedAddress(s);
    }

    public static boolean isIPv6HexCompressedAddress(String s)
    {
        int j = 0;
        for (int i = 0; i < s.length();)
        {
            int k = j;
            if (s.charAt(i) == ':')
            {
                k = j + 1;
            }
            i++;
            j = k;
        }

        return j <= 7 && IPV6_HEX_COMPRESSED_PATTERN.matcher(s).matches();
    }

    public static boolean isIPv6StdAddress(String s)
    {
        return IPV6_STD_PATTERN.matcher(s).matches();
    }

}
