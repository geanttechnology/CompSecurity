// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final Friends $VALUES[];
    public static final Friends Friends;
    public static final Friends InvitationOnly;
    public static final Friends Public;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$ListingVisibilityEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        Public = new <init>("Public", 0);
        InvitationOnly = new <init>("InvitationOnly", 1);
        Friends = new <init>("Friends", 2);
        $VALUES = (new .VALUES[] {
            Public, InvitationOnly, Friends
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
