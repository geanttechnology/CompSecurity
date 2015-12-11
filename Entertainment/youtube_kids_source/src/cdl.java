// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.net.Uri;
import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public final class cdl
{

    public final String a;
    public final byte b[];
    private volatile int c;

    public cdl(String s, byte abyte0[])
    {
        b.a(s, "deviceId cannot be empty");
        b.a(abyte0);
        boolean flag;
        if (abyte0.length == 20)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag, "deviceKey must be 20 bytes");
        a = s;
        b = abyte0;
    }

    private static String a(String s, byte abyte0[])
    {
        abyte0 = new SecretKeySpec(abyte0, "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(abyte0);
        s = (new String(Base64.encode(mac.doFinal(s.getBytes()), 0))).trim();
        return s;
        s;
        bmo.a("error signing request", s);
_L2:
        return null;
        s;
        bmo.a("error signing request", s);
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final String a(Uri uri)
    {
        StringBuilder stringbuilder = new StringBuilder(uri.getEncodedPath());
        uri = uri.getEncodedQuery();
        if (uri != null)
        {
            stringbuilder.append("?").append(uri);
        }
        uri = a(stringbuilder.toString(), b);
        return String.format("device-id=\"%s\", data=\"%s\"", new Object[] {
            a, uri
        });
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof cdl)
        {
            if (a.equals(((cdl) (obj = (cdl)obj)).a) && Arrays.equals(b, ((cdl) (obj)).b))
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        int j = c;
        int i = j;
        if (j == 0)
        {
            i = (a.hashCode() + 527) * 31 + Arrays.hashCode(b);
            c = i;
        }
        return i;
    }
}
