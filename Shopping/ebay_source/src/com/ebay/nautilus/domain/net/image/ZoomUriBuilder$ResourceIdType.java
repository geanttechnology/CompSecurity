// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;


// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ZoomUriBuilder

public static final class designator extends Enum
{

    private static final ATMOS_ID $VALUES[];
    public static final ATMOS_ID ATMOS_ID;
    public static final ATMOS_ID GUID;
    public static final ATMOS_ID ITEM_ID;
    public static final ATMOS_ID MD5_HASH;
    protected final String designator;

    public static designator valueOf(String s)
    {
        return (designator)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$ResourceIdType, s);
    }

    public static designator[] values()
    {
        return (designator[])$VALUES.clone();
    }

    static 
    {
        ITEM_ID = new <init>("ITEM_ID", 0, "i");
        MD5_HASH = new <init>("MD5_HASH", 1, "m");
        GUID = new <init>("GUID", 2, "g");
        ATMOS_ID = new <init>("ATMOS_ID", 3, "a");
        $VALUES = (new .VALUES[] {
            ITEM_ID, MD5_HASH, GUID, ATMOS_ID
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        designator = s1;
    }
}
