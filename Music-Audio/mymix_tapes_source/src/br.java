// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class br
{

    private static final bm a = d.a(br);

    public br()
    {
    }

    public static byte[] a(byte byte0, byte byte1, short word0, byte abyte0[])
    {
        if (a.b())
        {
            a.b((new StringBuilder("Building XMode buffer: protocol=")).append(byte0).append(" version=").append(byte1).append(" cmd=").append(word0).append(" payload len:").append(abyte0.length).toString());
            a.a(abyte0);
        }
        int i = abyte0.length;
        byte abyte1[] = new byte[i + 8];
        System.arraycopy((new bs(byte0, byte1, word0, i)).a(), 0, abyte1, 0, 8);
        System.arraycopy(abyte0, 0, abyte1, 8, i);
        return abyte1;
    }

    public static byte[] a(byte abyte0[], byte abyte1[])
    {
        if (a.b())
        {
            a.b("Appending session ID");
            a.a(abyte1);
            a.a(abyte0);
        }
        byte abyte2[] = new byte[abyte0.length + 16];
        System.arraycopy(abyte1, 0, abyte2, 0, 16);
        System.arraycopy(abyte0, 0, abyte2, 16, abyte0.length);
        return abyte2;
    }

}
