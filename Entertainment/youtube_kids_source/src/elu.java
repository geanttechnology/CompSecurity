// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.Serializable;

public final class elu extends els
    implements Serializable
{

    private static final long serialVersionUID = 0L;
    private int a;

    public elu(int i)
    {
        a = i;
    }

    public final int a()
    {
        return a;
    }

    public final byte[] b()
    {
        return (new byte[] {
            (byte)a, (byte)(a >> 8), (byte)(a >> 16), a >> 24
        });
    }
}
