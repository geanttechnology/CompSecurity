// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.StringUtil;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public final class PIDGenerator
{

    private static final String TAG = com/amazon/identity/kcpsdk/auth/PIDGenerator.getName();

    private PIDGenerator()
    {
    }

    public static String getPid(String s)
    {
        if (s == null)
        {
            return null;
        }
        try
        {
            s = StringUtil.hashSHA256ToHex(s).substring(23, 31);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "SHA-256 algorithm does not exist.  PANICK!", s);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            MAPLog.e(TAG, "Can't get PID: unsupported encoding");
            return null;
        }
        return s;
    }

}
