// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class FileNameGenerator
{

    public FileNameGenerator()
    {
    }

    private static String bytesToHexString(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder();
        int i = 0;
        do
        {
            if (i >= abyte0.length)
            {
                return stringbuilder.toString();
            }
            String s = Integer.toHexString(abyte0[i] & 0xff);
            if (s.length() == 1)
            {
                stringbuilder.append('0');
            }
            stringbuilder.append(s);
            i++;
        } while (true);
    }

    public static String generator(String s)
    {
        Object obj;
        try
        {
            obj = MessageDigest.getInstance("MD5");
            ((MessageDigest) (obj)).update(s.getBytes());
            obj = bytesToHexString(((MessageDigest) (obj)).digest());
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            return String.valueOf(s.hashCode());
        }
        return ((String) (obj));
    }
}
