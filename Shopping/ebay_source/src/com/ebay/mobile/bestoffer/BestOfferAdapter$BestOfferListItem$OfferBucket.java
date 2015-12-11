// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.bestoffer;


// Referenced classes of package com.ebay.mobile.bestoffer:
//            BestOfferAdapter

protected static final class  extends Enum
{

    private static final PAST $VALUES[];
    public static final PAST ACCEPTED;
    public static final PAST PAST;
    public static final PAST RECEIVED;
    public static final PAST SENT;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/mobile/bestoffer/BestOfferAdapter$BestOfferListItem$OfferBucket, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SENT = new <init>("SENT", 0);
        RECEIVED = new <init>("RECEIVED", 1);
        ACCEPTED = new <init>("ACCEPTED", 2);
        PAST = new <init>("PAST", 3);
        $VALUES = (new .VALUES[] {
            SENT, RECEIVED, ACCEPTED, PAST
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
