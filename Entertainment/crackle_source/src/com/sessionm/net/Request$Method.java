// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;


// Referenced classes of package com.sessionm.net:
//            Request

public static final class  extends Enum
{

    public static final eY eU;
    public static final eY eV;
    public static final eY eW;
    public static final eY eX;
    public static final eY eY;
    private static final eY eZ[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sessionm/net/Request$Method, s);
    }

    public static [] values()
    {
        return ([])eZ.clone();
    }

    static 
    {
        eU = new <init>("POST", 0);
        eV = new <init>("GET", 1);
        eW = new <init>("DELETE", 2);
        eX = new <init>("PUT", 3);
        eY = new <init>("GENERIC", 4);
        eZ = (new eZ[] {
            eU, eV, eW, eX, eY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
