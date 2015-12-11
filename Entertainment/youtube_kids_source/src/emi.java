// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.nio.ByteBuffer;

final class emi extends elp
{

    private int a;
    private int b;

    emi(int i)
    {
        super(4);
        a = i;
        b = 0;
    }

    protected final void a(ByteBuffer bytebuffer)
    {
        int i = emh.a(bytebuffer.getInt());
        a = emh.a(a, i);
        b = b + 4;
    }

    public final els b()
    {
        return emh.b(a, b);
    }

    protected final void b(ByteBuffer bytebuffer)
    {
        int i = 0;
        b = b + bytebuffer.remaining();
        int j = 0;
        while (bytebuffer.hasRemaining()) 
        {
            j ^= a.a(bytebuffer.get()) << i;
            i += 8;
        }
        a = a ^ emh.a(j);
    }
}
