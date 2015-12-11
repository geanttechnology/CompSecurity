// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            FeedItemHeaderLayout

public static final class  extends Enum
{

    private static final invalid $VALUES[];
    public static final invalid DOUBLE_LEVEL_HEADER;
    public static final invalid LEGACY_HEADER;
    public static final invalid SINGLE_LEVEL_HEADER;
    public static final invalid SINGLE_LEVEL_HEADER_POSHPOST;
    public static final invalid invalid;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/data_model/models/inner_models/FeedItemHeaderLayout$Layout, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SINGLE_LEVEL_HEADER = new <init>("SINGLE_LEVEL_HEADER", 0);
        DOUBLE_LEVEL_HEADER = new <init>("DOUBLE_LEVEL_HEADER", 1);
        LEGACY_HEADER = new <init>("LEGACY_HEADER", 2);
        SINGLE_LEVEL_HEADER_POSHPOST = new <init>("SINGLE_LEVEL_HEADER_POSHPOST", 3);
        invalid = new <init>("invalid", 4);
        $VALUES = (new .VALUES[] {
            SINGLE_LEVEL_HEADER, DOUBLE_LEVEL_HEADER, LEGACY_HEADER, SINGLE_LEVEL_HEADER_POSHPOST, invalid
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
