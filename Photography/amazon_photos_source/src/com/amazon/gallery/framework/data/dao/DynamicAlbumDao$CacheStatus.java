// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;


// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            DynamicAlbumDao

public static final class  extends Enum
{

    private static final FULL $VALUES[];
    public static final FULL FILLING;
    public static final FULL FULL;
    public static final FULL NORMAL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/data/dao/DynamicAlbumDao$CacheStatus, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        NORMAL = new <init>("NORMAL", 0);
        FILLING = new <init>("FILLING", 1);
        FULL = new <init>("FULL", 2);
        $VALUES = (new .VALUES[] {
            NORMAL, FILLING, FULL
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
