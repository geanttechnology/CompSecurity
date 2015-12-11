// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.image;


// Referenced classes of package com.ebay.nautilus.domain.net.image:
//            ZoomUriBuilder

public static final class level extends Enum
{

    private static final _40 $VALUES[];
    public static final _40 NORMAL;
    public static final _40 _40;
    public static final _40 _50;
    public static final _40 _60;
    public static final _40 _70;
    protected final int level;

    public static level valueOf(String s)
    {
        return (level)Enum.valueOf(com/ebay/nautilus/domain/net/image/ZoomUriBuilder$Quality, s);
    }

    public static level[] values()
    {
        return (level[])$VALUES.clone();
    }

    static 
    {
        NORMAL = new <init>("NORMAL", 0, 80);
        _70 = new <init>("_70", 1, 70);
        _60 = new <init>("_60", 2, 60);
        _50 = new <init>("_50", 3, 50);
        _40 = new <init>("_40", 4, 40);
        $VALUES = (new .VALUES[] {
            NORMAL, _70, _60, _50, _40
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        level = j;
    }
}
