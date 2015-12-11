// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk;


// Referenced classes of package com.appnexus.opensdk:
//            o

public static final class  extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    public static final i g;
    public static final i h;
    public static final i i;
    private static final i j[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/appnexus/opensdk/o$a, s);
    }

    public static [] values()
    {
        return ([])j.clone();
    }

    final int a()
    {
        switch (a[ordinal()])
        {
        case 5: // '\005'
        default:
            return 17;

        case 1: // '\001'
            return 51;

        case 2: // '\002'
            return 49;

        case 3: // '\003'
            return 53;

        case 4: // '\004'
            return 19;

        case 6: // '\006'
            return 21;

        case 7: // '\007'
            return 83;

        case 8: // '\b'
            return 81;

        case 9: // '\t'
            return 85;
        }
    }

    static 
    {
        a = new <init>("TOP_LEFT", 0);
        b = new <init>("TOP_CENTER", 1);
        c = new <init>("TOP_RIGHT", 2);
        d = new <init>("CENTER_LEFT", 3);
        e = new <init>("CENTER", 4);
        f = new <init>("CENTER_RIGHT", 5);
        g = new <init>("BOTTOM_LEFT", 6);
        h = new <init>("BOTTOM_CENTER", 7);
        i = new <init>("BOTTOM_RIGHT", 8);
        j = (new j[] {
            a, b, c, d, e, f, g, h, i
        });
    }

    private (String s, int k)
    {
        super(s, k);
    }
}
