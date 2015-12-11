// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package netswipe;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class di
{

    public static String a(byte abyte0[], long l)
    {
        byte abyte1[] = new byte[abyte0.length];
        (new Random(l)).nextBytes(abyte1);
        for (int i = 0; i < abyte0.length; i++)
        {
            abyte1[i] = (byte)(abyte1[i] ^ abyte0[i]);
        }

        try
        {
            abyte0 = new String(abyte1, "UTF8");
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            return new String(abyte1);
        }
        return abyte0;
    }
}
