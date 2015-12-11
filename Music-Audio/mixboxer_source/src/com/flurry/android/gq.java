// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


final class gq extends Enum
{

    public static final gq iR;
    public static final gq iS;
    public static final gq iT;
    public static final gq iU;
    private static final gq iV[];

    private gq(String s, int i)
    {
        super(s, i);
    }

    public static gq[] bM()
    {
        return (gq[])iV.clone();
    }

    static 
    {
        iR = new gq("METHOD_POST", 0);
        iS = new gq("METHOD_PUT", 1);
        iT = new gq("METHOD_GET", 2);
        iU = new gq("METHOD_DELETE", 3);
        iV = (new gq[] {
            iR, iS, iT, iU
        });
    }
}
