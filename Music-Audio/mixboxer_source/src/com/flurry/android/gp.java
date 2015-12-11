// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


final class gp extends Enum
{

    public static final gp iO;
    public static final gp iP;
    public static final gp iQ;
    private int dO;

    private gp(String s, int i, int j)
    {
        super(s, i);
        dO = j;
    }

    final int getValue()
    {
        return dO;
    }

    static 
    {
        iO = new gp("NONE_OR_UNKNOWN", 0, 0);
        iP = new gp("WIFI", 1, 1);
        iQ = new gp("CELL", 2, 2);
        gp gp1 = iO;
        gp1 = iP;
        gp1 = iQ;
    }
}
