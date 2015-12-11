// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.security.MessageDigest;

final class emd extends elo
{

    private final MessageDigest a;
    private final int b;
    private boolean c;

    emd(MessageDigest messagedigest, int i)
    {
        a = messagedigest;
        b = i;
    }

    private void b()
    {
        boolean flag;
        if (!c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        f.b(flag, "Cannot use Hasher after calling #hash() on it");
    }

    public final els a()
    {
        c = true;
        if (b == a.getDigestLength())
        {
            return a.a(a.digest());
        } else
        {
            byte abyte0[] = new byte[b];
            System.arraycopy(a.digest(), 0, abyte0, 0, b);
            return a.a(abyte0);
        }
    }

    protected final void a(byte byte0)
    {
        b();
        a.update(byte0);
    }

    protected final void a(byte abyte0[], int i, int j)
    {
        b();
        a.update(abyte0, i, j);
    }
}
