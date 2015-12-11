// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;

public final class euo
{

    final int a;
    final byte b[];

    euo(int i, byte abyte0[])
    {
        a = i;
        b = abyte0;
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof euo))
            {
                return false;
            }
            obj = (euo)obj;
            if (a != ((euo) (obj)).a || !Arrays.equals(b, ((euo) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        int j = a + 527;
        for (int i = 0; i < b.length; i++)
        {
            j = j * 31 + b[i];
        }

        return j;
    }
}
