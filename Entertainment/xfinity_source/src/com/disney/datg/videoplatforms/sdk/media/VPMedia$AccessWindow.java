// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.disney.datg.videoplatforms.sdk.media;


// Referenced classes of package com.disney.datg.videoplatforms.sdk.media:
//            VPMedia

public static final class  extends Enum
{

    private static final UNDEFINED $VALUES[];
    public static final UNDEFINED FREE;
    public static final UNDEFINED MARKET;
    public static final UNDEFINED SUBSCRIPTION;
    public static final UNDEFINED UNDEFINED;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SUBSCRIPTION = new <init>("SUBSCRIPTION", 0);
        FREE = new <init>("FREE", 1);
        MARKET = new <init>("MARKET", 2);
        UNDEFINED = new <init>("UNDEFINED", 3);
        $VALUES = (new .VALUES[] {
            SUBSCRIPTION, FREE, MARKET, UNDEFINED
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
