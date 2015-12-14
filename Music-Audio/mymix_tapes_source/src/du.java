// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class du
{

    private static final bm a = d.a(du);

    public du()
    {
    }

    public static dt a(byte abyte0[])
    {
        short word0 = (short)(((abyte0[1] & 0xff) << 8) + (abyte0[0] & 0xff));
        byte abyte1[] = new byte[abyte0.length - 2];
        System.arraycopy(abyte0, 2, abyte1, 0, abyte1.length);
        switch (word0)
        {
        case 29187: 
        case 29188: 
        default:
            a.e((new StringBuilder("PDXMessageFactory.createMessage() Unknown command: ")).append(word0).append(". ").toString());
            return null;

        case 29185: 
            return new ea(abyte1);

        case 29186: 
            return new dy(abyte1);

        case 29189: 
            return new eb(abyte1);
        }
    }

}
