// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;


// Referenced classes of package com.target.ui.analytics.a:
//            d, y

public class ab extends d
{

    public static final int ADD_TO_LIST = 1;
    public static final int PICK_UP = 2;
    public static final int SHIP = 3;

    protected ab(y y1, Integer integer, Integer integer1)
    {
        super(y1, integer, integer1);
    }

    public static ab a(int i, int j)
    {
        y y1 = y.Unknown;
        i;
        JVM INSTR tableswitch 1 3: default 32
    //                   1 51
    //                   2 58
    //                   3 65;
           goto _L1 _L2 _L3 _L4
_L1:
        return new ab(y1, Integer.valueOf(j + 2), Integer.valueOf(0));
_L2:
        y1 = y.AddToList;
        continue; /* Loop/switch isn't completed */
_L3:
        y1 = y.PickUpInStore;
        continue; /* Loop/switch isn't completed */
_L4:
        y1 = y.ShipToMe;
        if (true) goto _L1; else goto _L5
_L5:
    }
}
