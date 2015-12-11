// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;


final class gn extends Enum
{

    public static final gn iI;
    public static final gn iJ;
    public static final gn iK;
    public static final gn iL;
    public static final gn iM;
    private static final gn iN[];

    private gn(String s, int i)
    {
        super(s, i);
    }

    public static gn[] bL()
    {
        return (gn[])iN.clone();
    }

    static 
    {
        iI = new gn("PENDING_DB", 0);
        iJ = new gn("SERVER_DB", 1);
        iK = new gn("REGISTERED_DB", 2);
        iL = new gn("SEARCH_DATA_DB", 3);
        iM = new gn("SEARCH_ITEMS_DATA_DB", 4);
        iN = (new gn[] {
            iI, iJ, iK, iL, iM
        });
    }
}
