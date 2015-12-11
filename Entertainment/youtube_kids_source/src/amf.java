// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class amf extends Enum
{

    public static final amf a;
    public static final amf b;
    public static final amf c;
    private static final amf e[];
    final byte d;

    private amf(String s, int i, byte byte0)
    {
        super(s, i);
        d = byte0;
    }

    public static amf valueOf(String s)
    {
        return (amf)Enum.valueOf(amf, s);
    }

    public static amf[] values()
    {
        return (amf[])e.clone();
    }

    static 
    {
        a = new amf("CLOUD_SCREEN", 0, (byte)0);
        b = new amf("DIAL_SCREEN", 1, (byte)1);
        c = new amf("CAST_SCREEN", 2, (byte)2);
        e = (new amf[] {
            a, b, c
        });
    }
}
