// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.xip.ams;


// Referenced classes of package com.comcast.cim.cmasl.xip.ams:
//            AmsHttpErrorException

public static final class  extends Enum
{

    private static final INCREMENT $VALUES[];
    public static final INCREMENT INCREMENT;
    public static final INCREMENT STOP;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STOP = new <init>("STOP", 0);
        INCREMENT = new <init>("INCREMENT", 1);
        $VALUES = (new .VALUES[] {
            STOP, INCREMENT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
