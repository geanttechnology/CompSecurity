// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;


// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            SortOrder

public static final class SQL_STRING extends Enum
{

    private static final NOCASE_DESC $VALUES[];
    public static final NOCASE_DESC ASC;
    public static final NOCASE_DESC DESC;
    public static final NOCASE_DESC NOCASE_ASC;
    public static final NOCASE_DESC NOCASE_DESC;
    private final String SQL_STRING;

    public static SQL_STRING valueOf(String s)
    {
        return (SQL_STRING)Enum.valueOf(com/amazon/gallery/framework/data/dao/SortOrder$Order, s);
    }

    public static SQL_STRING[] values()
    {
        return (SQL_STRING[])$VALUES.clone();
    }

    public String toString()
    {
        return SQL_STRING;
    }

    static 
    {
        ASC = new <init>("ASC", 0, "ASC");
        DESC = new <init>("DESC", 1, "DESC");
        NOCASE_ASC = new <init>("NOCASE_ASC", 2, "COLLATE NOCASE ASC");
        NOCASE_DESC = new <init>("NOCASE_DESC", 3, "COLLATE NOCASE DESC");
        $VALUES = (new .VALUES[] {
            ASC, DESC, NOCASE_ASC, NOCASE_DESC
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        SQL_STRING = s1;
    }
}
