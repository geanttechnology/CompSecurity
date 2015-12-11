// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.kcpsdk.auth;

import com.amazon.identity.auth.device.utils.MAPLog;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
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
        Object obj;
        int i;
        int j;
        try
        {
            s = s.getBytes("UTF-8");
            obj = MessageDigest.getInstance("SHA-256");
            ((MessageDigest) (obj)).update(s);
            s = ((MessageDigest) (obj)).digest();
            obj = new StringBuilder(s.length * 2);
            j = s.length;
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
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        ((StringBuilder) (obj)).append(String.format("%02X", new Object[] {
            Integer.valueOf(s[i] & 0xff)
        }));
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_46;
_L1:
        s = ((StringBuilder) (obj)).substring(23, 31);
        return s;
    }

}
