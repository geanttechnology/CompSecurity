// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public class cu extends cp
{

    private static final bm a = d.a(cu);
    private String b;

    public cu(String s)
    {
        super((short)193);
        b = s;
    }

    public cu(byte abyte0[])
    {
        super((short)193);
        try
        {
            b = new String(abyte0, "UTF-8");
            return;
        }
        catch (Exception exception)
        {
            a.e((new StringBuilder("PDXUTF8String() ")).append(exception.getMessage()).toString());
        }
        b = new String(abyte0);
    }

    public final String a()
    {
        return b;
    }

    public final byte[] b()
    {
        byte abyte0[];
        try
        {
            abyte0 = super.a(b.getBytes("UTF-8"));
        }
        catch (Exception exception)
        {
            a.e((new StringBuilder("PDXUTF8String().toByteArray() ")).append(exception.getMessage()).toString());
            return super.a(b.getBytes());
        }
        return abyte0;
    }

}
