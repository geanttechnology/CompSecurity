// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package myobfuscated.s;


// Referenced classes of package myobfuscated.s:
//            b

public final class j
{

    private b a;

    public j()
    {
        this((byte)0);
    }

    private j(byte byte0)
    {
        a = new b(0x400000);
    }

    public final void a(byte abyte0[])
    {
        this;
        JVM INSTR monitorenter ;
        a.a(abyte0, [B);
        this;
        JVM INSTR monitorexit ;
        return;
        abyte0;
        throw abyte0;
    }

    public final byte[] a(int i)
    {
        return (byte[])a.a(i, [B);
    }
}
