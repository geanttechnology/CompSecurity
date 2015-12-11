// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

abstract class elo extends elx
{

    elo()
    {
        ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN);
    }

    protected abstract void a(byte byte0);

    protected void a(byte abyte0[], int i, int j)
    {
        for (int k = i; k < i + j; k++)
        {
            a(abyte0[k]);
        }

    }

    public final elx b(byte abyte0[], int i, int j)
    {
        f.a(0, j + 0, 1024);
        a(abyte0, 0, j);
        return this;
    }
}
