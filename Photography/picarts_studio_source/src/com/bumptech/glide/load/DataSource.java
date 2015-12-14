// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.load;


public final class DataSource extends Enum
{

    private static final DataSource $VALUES[];
    public static final DataSource DATA_DISK_CACHE;
    public static final DataSource LOCAL;
    public static final DataSource MEMORY_CACHE;
    public static final DataSource REMOTE;
    public static final DataSource RESOURCE_DISK_CACHE;

    private DataSource(String s, int i)
    {
        super(s, i);
    }

    public static DataSource valueOf(String s)
    {
        return (DataSource)Enum.valueOf(com/bumptech/glide/load/DataSource, s);
    }

    public static DataSource[] values()
    {
        return (DataSource[])$VALUES.clone();
    }

    static 
    {
        LOCAL = new DataSource("LOCAL", 0);
        REMOTE = new DataSource("REMOTE", 1);
        DATA_DISK_CACHE = new DataSource("DATA_DISK_CACHE", 2);
        RESOURCE_DISK_CACHE = new DataSource("RESOURCE_DISK_CACHE", 3);
        MEMORY_CACHE = new DataSource("MEMORY_CACHE", 4);
        $VALUES = (new DataSource[] {
            LOCAL, REMOTE, DATA_DISK_CACHE, RESOURCE_DISK_CACHE, MEMORY_CACHE
        });
    }
}
