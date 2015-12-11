// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class bvf extends Enum
{

    private static bvf a;
    private static bvf b;
    private static bvf c;
    private static bvf d;
    private static bvf e;
    private static final bvf g[];
    private int f;

    private bvf(String s, int i, int j)
    {
        super(s, i);
        f = j;
    }

    public static bvf valueOf(String s)
    {
        return (bvf)Enum.valueOf(bvf, s);
    }

    public static bvf[] values()
    {
        return (bvf[])g.clone();
    }

    public final String toString()
    {
        return String.valueOf(f);
    }

    static 
    {
        a = new bvf("REASON_CLIENT_OFFLINE_INSTREAM_FREQUENCY_CAP", 0, 16);
        b = new bvf("REASON_CLIENT_OFFLINE_AD_ASSET_FREQUENCY_CAP", 1, 17);
        c = new bvf("REASON_CLIENT_OFFLINE_AD_ASSET_EXPIRED", 2, 18);
        d = new bvf("REASON_CLIENT_OFFLINE_INACTIVE_USER", 3, 19);
        e = new bvf("REASON_CLIENT_OFFLINE_AD_ASSET_NOT_READY", 4, 23);
        g = (new bvf[] {
            a, b, c, d, e
        });
    }
}
