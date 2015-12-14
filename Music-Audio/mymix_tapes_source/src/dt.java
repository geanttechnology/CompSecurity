// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class dt extends cq
{

    private static final bm a = d.a(dt);
    private short b;

    public dt(short word0)
    {
        b = word0;
    }

    public dt(short word0, byte abyte0[])
    {
        super(abyte0);
        b = word0;
    }

    public final byte[] d()
    {
        ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
        bytearrayoutputstream.write(b & 0xff);
        bytearrayoutputstream.write(b >> 8 & 0xff);
        try
        {
            bytearrayoutputstream.write(super.d());
        }
        catch (IOException ioexception)
        {
            a.e((new StringBuilder("PDXMessage.toByteArray() ")).append(ioexception.toString()).append(". ").toString());
        }
        return bytearrayoutputstream.toByteArray();
    }

    public final short e()
    {
        return b;
    }

    public final byte[] f()
    {
        return super.d();
    }

}
