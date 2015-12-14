// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;


public final class  extends Enum
{

    public static final o a;
    public static final o b;
    public static final o c;
    public static final o d;
    public static final o e;
    public static final o f;
    public static final o g;
    public static final o h;
    public static final o i;
    public static final o j;
    public static final o k;
    public static final o l;
    public static final o m;
    public static final o n;
    public static final o o;
    private static final o p[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/cyberlink/youcammakeup/utility/PanelDataCenter$LocaleEnum, s);
    }

    public static [] values()
    {
        return ([])p.clone();
    }

    static 
    {
        a = new <init>("enu", 0);
        b = new <init>("cht", 1);
        c = new <init>("chs", 2);
        d = new <init>("jpn", 3);
        e = new <init>("kor", 4);
        f = new <init>("deu", 5);
        g = new <init>("esp", 6);
        h = new <init>("fra", 7);
        i = new <init>("ita", 8);
        j = new <init>("plk", 9);
        k = new <init>("ptg", 10);
        l = new <init>("ptb", 11);
        m = new <init>("rus", 12);
        n = new <init>("nld", 13);
        o = new <init>("def", 14);
        p = (new p[] {
            a, b, c, d, e, f, g, h, i, j, 
            k, l, m, n, o
        });
    }

    private (String s, int i1)
    {
        super(s, i1);
    }
}
