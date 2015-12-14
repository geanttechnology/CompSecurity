// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class axv
{

    protected static MessageDigest a = null;
    private static final char b[] = {
        '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 
        'A', 'B', 'C', 'D', 'E', 'F'
    };

    public axv()
    {
    }

    public static String a(String s)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("MD5");
            messagedigest.update(s.getBytes());
            s = a(messagedigest.digest());
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return "";
        }
        return s;
    }

    private static String a(byte abyte0[])
    {
        StringBuilder stringbuilder = new StringBuilder(abyte0.length * 2);
        for (int i = 0; i < abyte0.length; i++)
        {
            stringbuilder.append(b[(abyte0[i] & 0xf0) >>> 4]);
            stringbuilder.append(b[abyte0[i] & 0xf]);
        }

        return stringbuilder.toString();
    }

    static 
    {
        try
        {
            a = MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException nosuchalgorithmexception)
        {
            System.err.println((new StringBuilder()).append(axv.getName()).append("\u521D\u59CB\u5316\u5931\u8D25\uFF0CMessageDigest\u4E0D\u652F\u6491MD5Util\u3002").toString());
        }
    }
}
