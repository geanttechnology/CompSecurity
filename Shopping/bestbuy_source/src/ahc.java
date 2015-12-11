// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;

final class ahc
{

    final int a;
    final byte b[];

    ahc(int i, byte abyte0[])
    {
        a = i;
        b = abyte0;
    }

    int a()
    {
        return 0 + ags.h(a) + b.length;
    }

    void a(ags ags1)
    {
        ags1.g(a);
        ags1.d(b);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ahc))
            {
                return false;
            }
            obj = (ahc)obj;
            if (a != ((ahc) (obj)).a || !Arrays.equals(b, ((ahc) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public int hashCode()
    {
        return (a + 527) * 31 + Arrays.hashCode(b);
    }
}
