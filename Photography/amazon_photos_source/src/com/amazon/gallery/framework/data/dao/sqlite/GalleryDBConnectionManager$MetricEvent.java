// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            GalleryDBConnectionManager

public static final class Y extends Enum
{

    private static final DbUpgradeTo55 $VALUES[];
    public static final DbUpgradeTo55 DbConnectionFailure;
    public static final DbUpgradeTo55 DbUpgradeTo55;
    public static final DbUpgradeTo55 HiddenColumnMissingOnUpgrade;

    public static Y valueOf(String s)
    {
        return (Y)Enum.valueOf(com/amazon/gallery/framework/data/dao/sqlite/GalleryDBConnectionManager$MetricEvent, s);
    }

    public static Y[] values()
    {
        return (Y[])$VALUES.clone();
    }

    static 
    {
        DbConnectionFailure = new <init>("DbConnectionFailure", 0);
        HiddenColumnMissingOnUpgrade = new <init>("HiddenColumnMissingOnUpgrade", 1);
        DbUpgradeTo55 = new <init>("DbUpgradeTo55", 2);
        $VALUES = (new .VALUES[] {
            DbConnectionFailure, HiddenColumnMissingOnUpgrade, DbUpgradeTo55
        });
    }

    private Y(String s, int i)
    {
        super(s, i);
    }
}
