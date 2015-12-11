// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package jumiomobile;


public final class hr extends Enum
{

    public static final hr a;
    public static final hr b;
    public static final hr c;
    public static final hr d;
    public static final hr e;
    public static final hr f;
    public static final hr g;
    private static final hr h[];

    private hr(String s, int i)
    {
        super(s, i);
    }

    public static hr valueOf(String s)
    {
        return (hr)Enum.valueOf(jumiomobile/hr, s);
    }

    public static hr[] values()
    {
        return (hr[])h.clone();
    }

    static 
    {
        a = new hr("LOADING", 0);
        b = new hr("COUNTRY", 1);
        c = new hr("COUNTRY_LIST", 2);
        d = new hr("DOCUMENT_TYPE", 3);
        e = new hr("DOCUMENT_VARIANT", 4);
        f = new hr("CAMERA", 5);
        g = new hr("VERIFY", 6);
        h = (new hr[] {
            a, b, c, d, e, f, g
        });
    }
}
