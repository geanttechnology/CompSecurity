// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.WindowManager;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// Referenced classes of package com.amazon.device.ads:
//            InternalAdRegistration, IInternalAdRegistration, AndroidTargetUtils, Log

class Utils
{

    private static final String DISABLED_APP_SERVER_MESSAGE = "DISABLED_APP";
    private static final String LOG_TAG = com/amazon/device/ads/Utils.getSimpleName();
    private static int rotationArray[][] = {
        {
            1, 0, 9, 8
        }, {
            0, 9, 8, 1
        }
    };

    private Utils()
    {
    }

    public static final long convertToMillisecondsFromNanoseconds(long l)
    {
        return l / 0xf4240L;
    }

    public static final long convertToNsFromS(long l)
    {
        return 0x3b9aca00L * l;
    }

    public static int determineCanonicalScreenOrientation()
    {
        Context context = InternalAdRegistration.getInstance().getApplicationContext();
        int j = AndroidTargetUtils.getOrientation(((WindowManager)context.getSystemService("window")).getDefaultDisplay());
        int i = context.getResources().getConfiguration().orientation;
        if (i == 1)
        {
            if (j == 0 || j == 2)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        if (i == 2)
        {
            if (j == 1 || j == 3)
            {
                i = 1;
            } else
            {
                i = 0;
            }
        } else
        {
            i = 1;
        }
        if (i != 0)
        {
            i = 0;
        } else
        {
            i = 1;
        }
        return rotationArray[i][j];
    }

    public static final String getDisabledAppServerMessage()
    {
        return "DISABLED_APP";
    }

    public static final String getURLDecodedString(String s)
    {
        if (s == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = URLDecoder.decode(s, "UTF-8");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            Log.d(LOG_TAG, "getURLDecodedString threw: %s", new Object[] {
                unsupportedencodingexception
            });
            return s;
        }
        return s1;
    }

    public static final String getURLEncodedString(String s)
    {
        if (s == null)
        {
            return null;
        }
        String s1;
        try
        {
            s1 = URLEncoder.encode(s, "UTF-8").replace("+", "%20").replace("*", "%2A").replace("%7E", "~");
        }
        catch (UnsupportedEncodingException unsupportedencodingexception)
        {
            Log.d(LOG_TAG, "getURLEncodedString threw: %s", new Object[] {
                unsupportedencodingexception
            });
            return s;
        }
        return s1;
    }

    public static boolean isAtLeastAndroidAPI(int i)
    {
        return android.os.Build.VERSION.SDK_INT >= i;
    }

    public static final boolean isNullOrEmpty(String s)
    {
        return s == null || s.equals("");
    }

    public static final boolean isNullOrWhiteSpace(String s)
    {
        return isNullOrEmpty(s) || s.trim().equals("");
    }

    public static int parseInt(String s, int i)
    {
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return i;
        }
        return j;
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
