// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.t;

import com.bumptech.glide.load.b;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import myobfuscated.aj.g;
import myobfuscated.aj.j;

public final class q
{

    private final g a = new g(1000);

    public q()
    {
    }

    private static String b(b b1)
    {
        try
        {
            MessageDigest messagedigest = MessageDigest.getInstance("SHA-256");
            b1.a(messagedigest);
            b1 = j.a(messagedigest.digest());
        }
        // Misplaced declaration of an exception variable
        catch (b b1)
        {
            throw new RuntimeException(b1);
        }
        return b1;
    }

    public final String a(b b1)
    {
        String s;
        synchronized (a)
        {
            s = (String)a.b(b1);
        }
        obj = s;
        if (s == null)
        {
            obj = b(b1);
        }
        synchronized (a)
        {
            a.b(b1, obj);
        }
        return ((String) (obj));
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
        b1;
        g1;
        JVM INSTR monitorexit ;
        throw b1;
    }
}
