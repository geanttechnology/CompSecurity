// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class cn extends cp
{

    private String a;

    public cn(String s)
    {
        super((short)22);
        a = s;
    }

    public cn(byte abyte0[])
    {
        super((short)22);
        a = new String(abyte0);
    }

    public final String a()
    {
        return a;
    }

    public final byte[] b()
    {
        return super.a(a.getBytes());
    }
}
