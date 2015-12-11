// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.content.dm;


// Referenced classes of package com.ebay.nautilus.domain.content.dm:
//            ListingDraftDataManager

public static final class  extends Enum
{

    private static final BLOCKING_CHANGE_COMPLETE $VALUES[];
    public static final BLOCKING_CHANGE_COMPLETE ACK;
    public static final BLOCKING_CHANGE_COMPLETE BLOCKING_CHANGE_ACK;
    public static final BLOCKING_CHANGE_COMPLETE BLOCKING_CHANGE_COMPLETE;
    public static final BLOCKING_CHANGE_COMPLETE COMPLETE;
    public static final BLOCKING_CHANGE_COMPLETE CREATE_COMPLETE;
    public static final BLOCKING_CHANGE_COMPLETE CREATE_RELIST_COMPLETE;
    public static final BLOCKING_CHANGE_COMPLETE PUBLISH_ACK;
    public static final BLOCKING_CHANGE_COMPLETE PUBLISH_COMPLETE;
    public static final BLOCKING_CHANGE_COMPLETE VALIDATE_ACK;
    public static final BLOCKING_CHANGE_COMPLETE VALIDATE_COMPLETE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/content/dm/ListingDraftDataManager$DispatchType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ACK = new <init>("ACK", 0);
        COMPLETE = new <init>("COMPLETE", 1);
        CREATE_COMPLETE = new <init>("CREATE_COMPLETE", 2);
        CREATE_RELIST_COMPLETE = new <init>("CREATE_RELIST_COMPLETE", 3);
        VALIDATE_ACK = new <init>("VALIDATE_ACK", 4);
        VALIDATE_COMPLETE = new <init>("VALIDATE_COMPLETE", 5);
        PUBLISH_ACK = new <init>("PUBLISH_ACK", 6);
        PUBLISH_COMPLETE = new <init>("PUBLISH_COMPLETE", 7);
        BLOCKING_CHANGE_ACK = new <init>("BLOCKING_CHANGE_ACK", 8);
        BLOCKING_CHANGE_COMPLETE = new <init>("BLOCKING_CHANGE_COMPLETE", 9);
        $VALUES = (new .VALUES[] {
            ACK, COMPLETE, CREATE_COMPLETE, CREATE_RELIST_COMPLETE, VALIDATE_ACK, VALIDATE_COMPLETE, PUBLISH_ACK, PUBLISH_COMPLETE, BLOCKING_CHANGE_ACK, BLOCKING_CHANGE_COMPLETE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
