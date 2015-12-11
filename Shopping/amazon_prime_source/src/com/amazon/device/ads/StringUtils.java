// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Referenced classes of package com.amazon.device.ads:
//            MobileAdsLoggerFactory, MobileAdsLogger

class StringUtils
{

    private static final String LOGTAG = com/amazon/device/ads/StringUtils.getSimpleName();
    private static final MobileAdsLogger logger = (new MobileAdsLoggerFactory()).createMobileAdsLogger(LOGTAG);

    private StringUtils()
    {
    }

    public static boolean containsRegEx(String s, String s1)
    {
        return Pattern.compile(s).matcher(s1).find();
    }

    protected static boolean doesExceptionContainLockedDatabaseMessage(Exception exception)
    {
        if (exception == null || exception.getMessage() == null)
        {
            return false;
        } else
        {
            return exception.getMessage().contains("database is locked");
        }
    }

    public static String getFirstMatch(String s, String s1)
    {
        s = Pattern.compile(s).matcher(s1);
        if (s.find())
        {
            return s.group();
        } else
        {
            return null;
        }
    }

    public static final boolean isNullOrEmpty(String s)
    {
        return s == null || s.equals("");
    }

    public static final boolean isNullOrWhiteSpace(String s)
    {
        return isNullOrEmpty(s) || s.trim().equals("");
    }

    public static String readStringFromInputStream(InputStream inputstream)
    {
        StringBuilder stringbuilder;
        byte abyte0[];
        if (inputstream == null)
        {
            return null;
        }
        stringbuilder = new StringBuilder();
        abyte0 = new byte[4096];
_L1:
        int i = inputstream.read(abyte0);
        if (i == -1)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        stringbuilder.append(new String(abyte0, 0, i));
          goto _L1
        IOException ioexception;
        ioexception;
        logger.e("Unable to read the stream.");
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            logger.e("IOException while trying to close the stream.");
        }
        return stringbuilder.toString();
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            logger.e("IOException while trying to close the stream.");
        }
        if (true)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        Exception exception;
        exception;
        try
        {
            inputstream.close();
        }
        // Misplaced declaration of an exception variable
        catch (InputStream inputstream)
        {
            logger.e("IOException while trying to close the stream.");
        }
        throw exception;
    }

    public static String sha1(String s)
    {
        Object obj;
        int i;
        try
        {
            obj = MessageDigest.getInstance("SHA-1");
            ((MessageDigest) (obj)).update(s.getBytes());
            s = ((MessageDigest) (obj)).digest();
            obj = new StringBuilder();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        i = 0;
        if (i >= s.length)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuilder) (obj)).append(Integer.toHexString(s[i] & 0xff | 0x100).substring(1));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_29;
_L1:
        s = ((StringBuilder) (obj)).toString();
        return s;
    }

}
