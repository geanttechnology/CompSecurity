// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.filter;


public final class DataSource extends Enum
{

    private static final DataSource $VALUES[];
    public static final DataSource HAS_CLOUD;
    public static final DataSource HAS_LOCAL;
    public static final DataSource ONLY_CLOUD;
    public static final DataSource ONLY_LOCAL;

    private DataSource(String s, int i)
    {
        super(s, i);
    }

    public static DataSource valueOf(String s)
    {
        return (DataSource)Enum.valueOf(com/amazon/gallery/framework/data/dao/filter/DataSource, s);
    }

    public static DataSource[] values()
    {
        return (DataSource[])$VALUES.clone();
    }

    static 
    {
        ONLY_CLOUD = new DataSource("ONLY_CLOUD", 0);
        ONLY_LOCAL = new DataSource("ONLY_LOCAL", 1);
        HAS_CLOUD = new DataSource("HAS_CLOUD", 2);
        HAS_LOCAL = new DataSource("HAS_LOCAL", 3);
        $VALUES = (new DataSource[] {
            ONLY_CLOUD, ONLY_LOCAL, HAS_CLOUD, HAS_LOCAL
        });
    }
}
