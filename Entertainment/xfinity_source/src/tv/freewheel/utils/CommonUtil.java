// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.utils;

import android.os.Process;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CommonUtil
{

    public static final String currentThreadIdentifier()
    {
        return String.format("[0x%x]", new Object[] {
            Integer.valueOf(Process.myTid())
        });
    }

    public static final String md5(String s)
    {
        byte abyte0[];
        StringBuffer stringbuffer;
        int i;
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            abyte0 = messagedigest.digest();
            stringbuffer = new StringBuffer();
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        i = 0;
        if (i >= abyte0.length)
        {
            break; /* Loop/switch isn't completed */
        }
        for (s = Integer.toHexString(abyte0[i] & 0xff); s.length() < 2; s = (new StringBuilder()).append("0").append(s).toString()) { }
        stringbuffer.append(s);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_29;
_L1:
        s = stringbuffer.toString();
        return s;
    }

    public static Boolean parseBoolean(String s, Boolean boolean1)
    {
        Boolean boolean2 = boolean1;
        if (s == null) goto _L2; else goto _L1
_L1:
        s = s.trim().toLowerCase();
        if (!s.equals("true") && !s.equals("on") && !s.equals("yes")) goto _L4; else goto _L3
_L3:
        boolean2 = Boolean.valueOf(true);
_L2:
        return boolean2;
_L4:
        if (s.equals("false") || s.equals("off"))
        {
            break; /* Loop/switch isn't completed */
        }
        boolean2 = boolean1;
        if (!s.equals("no")) goto _L2; else goto _L5
_L5:
        return Boolean.valueOf(false);
    }
}
