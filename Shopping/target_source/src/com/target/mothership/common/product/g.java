// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class g extends Enum
{

    private static final g $VALUES[];
    public static final g CATEGORY_ID;
    public static final g DIMENSION_ID;
    public static final g ENDECA_ID;
    public static final g UNKNOWN;
    public static final g URL;
    private String mValue;

    private g(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static g valueOf(String s)
    {
        return (g)Enum.valueOf(com/target/mothership/common/product/g, s);
    }

    public static g[] values()
    {
        return (g[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        DIMENSION_ID = new g("DIMENSION_ID", 0, "dimensionId");
        ENDECA_ID = new g("ENDECA_ID", 1, "endecaId");
        CATEGORY_ID = new g("CATEGORY_ID", 2, "categoryId");
        URL = new g("URL", 3, "url");
        UNKNOWN = new g("UNKNOWN", 4, "unknown");
        $VALUES = (new g[] {
            DIMENSION_ID, ENDECA_ID, CATEGORY_ID, URL, UNKNOWN
        });
    }
}
