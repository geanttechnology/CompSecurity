// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.util;

import android.util.Base64;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileUtil
{

    public FileUtil()
    {
    }

    public static boolean recursiveDelete(File file, boolean flag)
    {
        if (file.isDirectory())
        {
            File afile[] = file.listFiles();
            if (afile != null)
            {
                int j = afile.length;
                for (int i = 0; i < j; i++)
                {
                    recursiveDelete(afile[i], true);
                }

            }
        }
        if (flag)
        {
            return file.delete();
        } else
        {
            return false;
        }
    }

    public static String safeName(String s)
    {
        s = s.getBytes();
        byte abyte0[];
        MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
        messagedigest.update(s);
        abyte0 = messagedigest.digest();
        s = abyte0;
_L2:
        return Base64.encodeToString(s, 10);
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
