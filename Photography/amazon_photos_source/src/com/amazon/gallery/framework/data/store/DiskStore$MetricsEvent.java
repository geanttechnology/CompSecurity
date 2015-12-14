// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.store;


// Referenced classes of package com.amazon.gallery.framework.data.store:
//            DiskStore

public static final class  extends Enum
{

    private static final CacheMiss $VALUES[];
    public static final CacheMiss CacheEvict;
    public static final CacheMiss CacheHit;
    public static final CacheMiss CacheMiss;
    public static final CacheMiss CachePartialHit;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/data/store/DiskStore$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CacheEvict = new <init>("CacheEvict", 0);
        CacheHit = new <init>("CacheHit", 1);
        CachePartialHit = new <init>("CachePartialHit", 2);
        CacheMiss = new <init>("CacheMiss", 3);
        $VALUES = (new .VALUES[] {
            CacheEvict, CacheHit, CachePartialHit, CacheMiss
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
