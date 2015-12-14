// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.appsearch.patchupdate;

import java.io.File;
import java.io.FileInputStream;

public final class Utility
{

    private static final String TAG = "Utility";

    private Utility()
    {
    }

    public static String bytesToHexString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        if (abyte0 == null || abyte0.length <= 0)
        {
            return null;
        }
        for (int i = 0; i < abyte0.length; i++)
        {
            String s = Integer.toHexString(abyte0[i] & 0xff);
            if (s.length() < 2)
            {
                stringbuilder.append(0);
            }
            stringbuilder.append(s);
        }

        return stringbuilder.toString();
    }

    public static boolean isGzipFile(String s)
    {
        s = new File(s);
        if (s.exists())
        {
            byte abyte0[] = new byte[4];
            boolean flag;
            try
            {
                (new FileInputStream(s)).read(abyte0);
                flag = "1F8B0800".equalsIgnoreCase(bytesToHexString(abyte0));
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                return false;
            }
            if (flag)
            {
                return true;
            }
        }
        return false;
    }
}
