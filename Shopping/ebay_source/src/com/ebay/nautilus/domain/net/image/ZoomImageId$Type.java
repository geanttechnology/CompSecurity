// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;


// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ZoomImageId

public static final class _cls9 extends Enum
{

    private static final MD5 $VALUES[];
    public static final MD5 GUID;
    public static final MD5 MD5;

    public static _cls9 valueOf(String s)
    {
        return (_cls9)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomImageId$Type, s);
    }

    public static _cls9[] values()
    {
        return (_cls9[])$VALUES.clone();
    }

    static 
    {
        GUID = new <init>("GUID", 0);
        MD5 = new <init>("MD5", 1);
        $VALUES = (new .VALUES[] {
            GUID, MD5
        });
    }

    private _cls9(String s, int i)
    {
        super(s, i);
    }
}
