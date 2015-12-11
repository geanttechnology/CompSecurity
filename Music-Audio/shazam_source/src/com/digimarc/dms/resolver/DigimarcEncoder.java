// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digimarc.dms.resolver;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

// Referenced classes of package com.digimarc.dms.resolver:
//            HomeBrewBase64

class DigimarcEncoder
{
    public static final class ALGORITHM_TYPE extends Enum
    {

        private static final ALGORITHM_TYPE $VALUES[];
        public static final ALGORITHM_TYPE SHA256;
        public static final ALGORITHM_TYPE SHA512;

        public static ALGORITHM_TYPE valueOf(String s)
        {
            return (ALGORITHM_TYPE)Enum.valueOf(com/digimarc/dms/resolver/DigimarcEncoder$ALGORITHM_TYPE, s);
        }

        public static ALGORITHM_TYPE[] values()
        {
            return (ALGORITHM_TYPE[])$VALUES.clone();
        }

        static 
        {
            SHA256 = new ALGORITHM_TYPE("SHA256", 0);
            SHA512 = new ALGORITHM_TYPE("SHA512", 1);
            $VALUES = (new ALGORITHM_TYPE[] {
                SHA256, SHA512
            });
        }

        private ALGORITHM_TYPE(String s, int i)
        {
            super(s, i);
        }
    }


    DigimarcEncoder()
    {
    }

    protected static String encodeString(String s, String s1, ALGORITHM_TYPE algorithm_type)
    {
        String s2 = "HMACSHA256";
        if (algorithm_type == ALGORITHM_TYPE.SHA512)
        {
            s2 = "HMACSHA512";
        }
        try
        {
            s1 = new SecretKeySpec(s1.getBytes(), s2);
            algorithm_type = Mac.getInstance(s2);
            algorithm_type.init(s1);
            algorithm_type.update(s.getBytes());
            s = HomeBrewBase64.encodeToString(algorithm_type.doFinal(), HomeBrewBase64.NO_WRAP);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            s.printStackTrace();
            return "";
        }
        return s;
    }
}
