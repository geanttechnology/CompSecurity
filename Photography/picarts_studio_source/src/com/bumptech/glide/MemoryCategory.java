// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide;


public final class MemoryCategory extends Enum
{

    private static final MemoryCategory $VALUES[];
    public static final MemoryCategory HIGH;
    public static final MemoryCategory LOW;
    public static final MemoryCategory NORMAL;
    private float multiplier;

    private MemoryCategory(String s, int i, float f)
    {
        super(s, i);
        multiplier = f;
    }

    public static MemoryCategory valueOf(String s)
    {
        return (MemoryCategory)Enum.valueOf(com/bumptech/glide/MemoryCategory, s);
    }

    public static MemoryCategory[] values()
    {
        return (MemoryCategory[])$VALUES.clone();
    }

    public final float getMultiplier()
    {
        return multiplier;
    }

    static 
    {
        LOW = new MemoryCategory("LOW", 0, 0.5F);
        NORMAL = new MemoryCategory("NORMAL", 1, 1.0F);
        HIGH = new MemoryCategory("HIGH", 2, 1.5F);
        $VALUES = (new MemoryCategory[] {
            LOW, NORMAL, HIGH
        });
    }
}
