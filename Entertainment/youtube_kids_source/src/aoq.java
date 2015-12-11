// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.nio.ByteBuffer;

public final class aoq
{

    public final anf a = new anf();
    public ByteBuffer b;
    public int c;
    public int d;
    public long e;
    public boolean f;
    private final int g;

    public aoq(int i)
    {
        g = i;
    }

    public final boolean a(int i)
    {
        switch (g)
        {
        default:
            return false;

        case 1: // '\001'
            b = ByteBuffer.allocate(i);
            return true;

        case 2: // '\002'
            b = ByteBuffer.allocateDirect(i);
            break;
        }
        return true;
    }
}
