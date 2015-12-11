// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class I extends Enum
{

    private static final ANCHOR $VALUES[];
    public static final ANCHOR ANCHOR;
    public static final ANCHOR BASIC;
    public static final ANCHOR PROFESSIONAL;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$StoreLevelEnum, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        BASIC = new <init>("BASIC", 0);
        PROFESSIONAL = new <init>("PROFESSIONAL", 1);
        ANCHOR = new <init>("ANCHOR", 2);
        $VALUES = (new .VALUES[] {
            BASIC, PROFESSIONAL, ANCHOR
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
