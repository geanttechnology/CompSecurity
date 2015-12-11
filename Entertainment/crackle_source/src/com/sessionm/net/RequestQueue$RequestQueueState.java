// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;


// Referenced classes of package com.sessionm.net:
//            RequestQueue

public static final class  extends Enum
{

    public static final fY fX;
    public static final fY fY;
    private static final fY fZ[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sessionm/net/RequestQueue$RequestQueueState, s);
    }

    public static [] values()
    {
        return ([])fZ.clone();
    }

    static 
    {
        fX = new <init>("STOPPED", 0);
        fY = new <init>("STARTED", 1);
        fZ = (new fZ[] {
            fX, fY
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
