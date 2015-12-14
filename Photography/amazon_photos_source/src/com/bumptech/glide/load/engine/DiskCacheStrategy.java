// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load.engine;


public final class DiskCacheStrategy extends Enum
{

    private static final DiskCacheStrategy $VALUES[];
    public static final DiskCacheStrategy ALL;
    public static final DiskCacheStrategy NONE;
    public static final DiskCacheStrategy RESULT;
    public static final DiskCacheStrategy SOURCE;
    private final boolean cacheResult;
    private final boolean cacheSource;

    private DiskCacheStrategy(String s, int i, boolean flag, boolean flag1)
    {
        super(s, i);
        cacheSource = flag;
        cacheResult = flag1;
    }

    public static DiskCacheStrategy valueOf(String s)
    {
        return (DiskCacheStrategy)Enum.valueOf(com/bumptech/glide/load/engine/DiskCacheStrategy, s);
    }

    public static DiskCacheStrategy[] values()
    {
        return (DiskCacheStrategy[])$VALUES.clone();
    }

    public boolean cacheResult()
    {
        return cacheResult;
    }

    public boolean cacheSource()
    {
        return cacheSource;
    }

    static 
    {
        ALL = new DiskCacheStrategy("ALL", 0, true, true);
        NONE = new DiskCacheStrategy("NONE", 1, false, false);
        SOURCE = new DiskCacheStrategy("SOURCE", 2, true, false);
        RESULT = new DiskCacheStrategy("RESULT", 3, false, true);
        $VALUES = (new DiskCacheStrategy[] {
            ALL, NONE, SOURCE, RESULT
        });
    }
}
