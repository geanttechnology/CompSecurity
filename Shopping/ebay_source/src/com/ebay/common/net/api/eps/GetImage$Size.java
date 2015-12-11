// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.eps;


// Referenced classes of package com.ebay.common.net.api.eps:
//            GetImage

public static final class  extends Enum
{

    private static final D800x800 $VALUES[];
    public static final D800x800 D200x200;
    public static final D800x800 D300x300;
    public static final D800x800 D32x32;
    public static final D800x800 D400x400;
    public static final D800x800 D500x500;
    public static final D800x800 D64x64;
    public static final D800x800 D800x800;
    public static final D800x800 D96x96;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/eps/GetImage$Size, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        D32x32 = new <init>("D32x32", 0);
        D64x64 = new <init>("D64x64", 1);
        D96x96 = new <init>("D96x96", 2);
        D200x200 = new <init>("D200x200", 3);
        D300x300 = new <init>("D300x300", 4);
        D400x400 = new <init>("D400x400", 5);
        D500x500 = new <init>("D500x500", 6);
        D800x800 = new <init>("D800x800", 7);
        $VALUES = (new .VALUES[] {
            D32x32, D64x64, D96x96, D200x200, D300x300, D400x400, D500x500, D800x800
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
