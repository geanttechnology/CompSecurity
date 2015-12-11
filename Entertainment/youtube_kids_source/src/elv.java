// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

public final class elv extends els
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private long a;

    public elv(long l)
    {
        a = l;
    }

    public final int a()
    {
        return (int)a;
    }

    public final byte[] b()
    {
        return (new byte[] {
            (byte)(int)a, (byte)(int)(a >> 8), (byte)(int)(a >> 16), (byte)(int)(a >> 24), (byte)(int)(a >> 32), (byte)(int)(a >> 40), (byte)(int)(a >> 48), (byte)(int)(a >> 56)
        });
    }
}
