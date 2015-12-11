// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.contentprovider;


// Referenced classes of package com.amazon.mShop.contentprovider:
//            WidgetDatabaseHelper

private static class <init> extends Enum
{

    private static final AIV_CONTENT_CATEGORY $VALUES[];
    public static final AIV_CONTENT_CATEGORY AIV_CONTENT_CATEGORY;
    public static final AIV_CONTENT_CATEGORY MSHOP_CONTENT_CATEGORY;

    public static <init> valueOf(String s)
    {
        return (<init>)Enum.valueOf(com/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory, s);
    }

    public static <init>[] values()
    {
        return (<init>[])$VALUES.clone();
    }

    static 
    {
        MSHOP_CONTENT_CATEGORY = new WidgetDatabaseHelper.FeaturedCategory("MSHOP_CONTENT_CATEGORY", 0) {

            public String toString()
            {
                return "mshop_shoveler_item";
            }

        };
        AIV_CONTENT_CATEGORY = new WidgetDatabaseHelper.FeaturedCategory("AIV_CONTENT_CATEGORY", 1) {

            public String toString()
            {
                return "aiv_shoveler_item";
            }

        };
        $VALUES = (new .VALUES[] {
            MSHOP_CONTENT_CATEGORY, AIV_CONTENT_CATEGORY
        });
    }

    private _cls2(String s, int i)
    {
        super(s, i);
    }

    _cls2(String s, int i, _cls2 _pcls2)
    {
        this(s, i);
    }
}
