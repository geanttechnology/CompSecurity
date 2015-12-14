// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.request;


// Referenced classes of package com.facebook.imagepipeline.request:
//            ImageRequest

public static final class mValue extends Enum
{

    private static final BITMAP_MEMORY_CACHE $VALUES[];
    public static final BITMAP_MEMORY_CACHE BITMAP_MEMORY_CACHE;
    public static final BITMAP_MEMORY_CACHE DISK_CACHE;
    public static final BITMAP_MEMORY_CACHE ENCODED_MEMORY_CACHE;
    public static final BITMAP_MEMORY_CACHE FULL_FETCH;
    private int mValue;

    public static mValue getMax(mValue mvalue, mValue mvalue1)
    {
        if (mvalue.getValue() > mvalue1.getValue())
        {
            return mvalue;
        } else
        {
            return mvalue1;
        }
    }

    public static getValue valueOf(String s)
    {
        return (getValue)Enum.valueOf(com/facebook/imagepipeline/request/ImageRequest$RequestLevel, s);
    }

    public static getValue[] values()
    {
        return (getValue[])$VALUES.clone();
    }

    public int getValue()
    {
        return mValue;
    }

    static 
    {
        FULL_FETCH = new <init>("FULL_FETCH", 0, 1);
        DISK_CACHE = new <init>("DISK_CACHE", 1, 2);
        ENCODED_MEMORY_CACHE = new <init>("ENCODED_MEMORY_CACHE", 2, 3);
        BITMAP_MEMORY_CACHE = new <init>("BITMAP_MEMORY_CACHE", 3, 4);
        $VALUES = (new .VALUES[] {
            FULL_FETCH, DISK_CACHE, ENCODED_MEMORY_CACHE, BITMAP_MEMORY_CACHE
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        mValue = j;
    }
}
