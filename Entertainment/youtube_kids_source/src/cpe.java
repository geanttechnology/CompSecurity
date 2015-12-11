// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.util.Base64;
import java.security.InvalidKeyException;
import java.security.Key;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

final class cpe
{

    final String a;
    final byte b[];
    private cpf c;
    private final Key d;

    cpe(String s, byte abyte0[])
    {
        a = b.a(s);
        b = (byte[])((byte[])b.a(abyte0)).clone();
        d = new SecretKeySpec(abyte0, "HmacSHA1");
        c = new cpf(abyte0);
    }

    static byte[] a(Key key, byte abyte0[])
    {
        mac;
        JVM INSTR monitorenter ;
        synchronized (cpg.a)
        {
            cpg.a.init(key);
            key = cpg.a.doFinal(abyte0);
        }
        return key;
        key;
        throw new RuntimeException("Fatal error: hmac key is invalid.", key);
        key;
        mac;
        JVM INSTR monitorexit ;
        throw key;
    }

    final String a(byte abyte0[], int i)
    {
        abyte0 = a(d, abyte0);
        if (i != 20)
        {
            abyte0 = a.a(abyte0, 0, i);
        }
        return new String(Base64.encode(a.a(new byte[][] {
            new byte[] {
                0
            }, (byte[])c.b_(), abyte0
        }), 3));
    }
}
