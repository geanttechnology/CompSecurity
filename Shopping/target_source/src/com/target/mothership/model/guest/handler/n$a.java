// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.guest.handler;


// Referenced classes of package com.target.mothership.model.guest.handler:
//            n

private static final class  extends Enum
{

    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN CANCELED;
    public static final UNKNOWN EMAIL_GIFTCARD;
    public static final UNKNOWN MOBILE_GIFTCARD;
    public static final UNKNOWN PICK_UP;
    public static final UNKNOWN SHIP_HOME;
    public static final UNKNOWN UNKNOWN;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/target/mothership/model/guest/handler/n$a, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SHIP_HOME = new <init>("SHIP_HOME", 0);
        PICK_UP = new <init>("PICK_UP", 1);
        EMAIL_GIFTCARD = new <init>("EMAIL_GIFTCARD", 2);
        MOBILE_GIFTCARD = new <init>("MOBILE_GIFTCARD", 3);
        CANCELED = new <init>("CANCELED", 4);
        UNKNOWN = new <init>("UNKNOWN", 5);
        $VALUES = (new .VALUES[] {
            SHIP_HOME, PICK_UP, EMAIL_GIFTCARD, MOBILE_GIFTCARD, CANCELED, UNKNOWN
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
