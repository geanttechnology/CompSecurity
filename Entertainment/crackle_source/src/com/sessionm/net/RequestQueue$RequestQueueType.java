// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sessionm.net;


// Referenced classes of package com.sessionm.net:
//            RequestQueue

public static final class  extends Enum
{

    public static final gb ga;
    public static final gb gb;
    private static final gb gc[];

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/sessionm/net/RequestQueue$RequestQueueType, s);
    }

    public static [] values()
    {
        return ([])gc.clone();
    }

    static 
    {
        ga = new <init>("FAST_FAIL", 0);
        gb = new <init>("BEST_EFFORT", 1);
        gc = (new gc[] {
            ga, gb
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
