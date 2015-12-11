// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


public final class t> extends Enum
{

    public static final k a;
    public static final k b;
    public static final k c;
    public static final k d;
    public static final k e;
    public static final k f;
    public static final k g;
    public static final k h;
    public static final k i;
    public static final k j;
    public static final k k;
    private static final k l[];

    public static t> valueOf(String s)
    {
        return (t>)Enum.valueOf(com/flurry/sdk/d$a, s);
    }

    public static eOf[] values()
    {
        return (eOf[])l.clone();
    }

    static 
    {
        a = new <init>("kOnFetched", 0);
        b = new <init>("kOnFetchFailed", 1);
        c = new <init>("kOnRendered", 2);
        d = new <init>("kOnRenderFailed", 3);
        e = new <init>("kOnOpen", 4);
        f = new <init>("kOnClose", 5);
        g = new <init>("kOnAppExit", 6);
        h = new <init>("kOnClicked", 7);
        i = new <init>("kOnClickFailed", 8);
        j = new <init>("kOnImpressionLogged", 9);
        k = new <init>("kOnVideoCompleted", 10);
        l = (new l[] {
            a, b, c, d, e, f, g, h, i, j, 
            k
        });
    }

    private (String s, int i1)
    {
        super(s, i1);
    }
}
