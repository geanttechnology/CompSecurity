// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Arrays;

public final class ena
{

    private final int a;
    private final byte b[];

    public ena(int i, byte abyte0[])
    {
        boolean flag;
        if (i >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            throw new IllegalStateException(String.valueOf("source"));
        }
        a = i;
        if (abyte0 == null)
        {
            throw new NullPointerException(String.valueOf("name"));
        } else
        {
            b = (byte[])abyte0;
            return;
        }
    }

    public final boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ena))
            {
                return false;
            }
            obj = (ena)obj;
            if (a != ((ena) (obj)).a || !Arrays.equals(b, ((ena) (obj)).b))
            {
                return false;
            }
        }
        return true;
    }

    public final int hashCode()
    {
        return a ^ Arrays.hashCode(b);
    }

    public final String toString()
    {
        int i = a;
        String s = emz.a(b);
        return (new StringBuilder(String.valueOf(s).length() + 20)).append("Oid: <").append(i).append(", ").append(s).append(">").toString();
    }
}
