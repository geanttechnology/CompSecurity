// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class bs
{

    private static final bm d = d.a(bs);
    public byte a;
    public short b;
    public int c;
    private byte e;

    public bs(byte byte0, byte byte1, short word0, int i)
    {
        if (d.b())
        {
            d.b((new StringBuilder("Constructing XModeMsgHeader(protocol=")).append(byte0).append(", version=").append(byte1).append(", cmd=").append(word0).append(", len=").append(i).append(")").toString());
        }
        a = byte0;
        e = byte1;
        b = word0;
        c = i;
    }

    public bs(byte abyte0[])
    {
        if (d.b())
        {
            d.b("Constructing XModeMsgHeader(byte[])");
            d.a(abyte0);
        }
        a = abyte0[0];
        e = abyte0[1];
        b = bu.a(abyte0, 2);
        c = bu.b(abyte0, 4);
    }

    public final byte[] a()
    {
        if (d.b())
        {
            d.b("XModeMsgHeader.getBytes()");
        }
        byte abyte0[] = new byte[8];
        abyte0[0] = a;
        abyte0[1] = e;
        bu.a(b, abyte0, 2);
        bu.a(c, abyte0, 4);
        if (d.b())
        {
            d.a("Generated: ");
            d.a(abyte0);
        }
        return abyte0;
    }

}
