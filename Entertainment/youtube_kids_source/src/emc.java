// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class emc extends elw
    implements Serializable
{

    private final MessageDigest a;
    private final int b;
    private final boolean c;
    private final String d;

    emc(String s, int i, String s1)
    {
        d = (String)f.b(s1);
        a = a(s);
        int j = a.getDigestLength();
        boolean flag;
        if (i >= 4 && i <= j)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.a(flag, "bytes (%s) must be >= 4 and < %s", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        b = i;
        c = b();
    }

    emc(String s, String s1)
    {
        a = a(s);
        b = a.getDigestLength();
        d = (String)f.b(s1);
        c = b();
    }

    private static MessageDigest a(String s)
    {
        try
        {
            s = MessageDigest.getInstance(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new AssertionError(s);
        }
        return s;
    }

    private boolean b()
    {
        try
        {
            a.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return false;
        }
        return true;
    }

    public final elx a()
    {
        if (!c)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        emd emd1 = new emd((MessageDigest)a.clone(), b);
        return emd1;
        CloneNotSupportedException clonenotsupportedexception;
        clonenotsupportedexception;
        return new emd(a(a.getAlgorithm()), b);
    }

    public final String toString()
    {
        return d;
    }

    final Object writeReplace()
    {
        return new eme(a.getAlgorithm(), b, d);
    }
}
