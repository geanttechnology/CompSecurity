// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            SQLiteDaoUtil

public static final class  extends Enum
{

    private static final HiddenColumnMissing $VALUES[];
    public static final HiddenColumnMissing HiddenColumnMissing;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/data/dao/sqlite/SQLiteDaoUtil$MetricEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        HiddenColumnMissing = new <init>("HiddenColumnMissing", 0);
        $VALUES = (new .VALUES[] {
            HiddenColumnMissing
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
