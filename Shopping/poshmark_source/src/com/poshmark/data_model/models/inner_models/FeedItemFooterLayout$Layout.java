// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models.inner_models;


// Referenced classes of package com.poshmark.data_model.models.inner_models:
//            FeedItemFooterLayout

public static final class  extends Enum
{

    private static final invalid $VALUES[];
    public static final invalid LEGACY_FOOTER;
    public static final invalid SIMPLE_LAUNCH_FOOTER;
    public static final invalid SOCIAL_ACTIONS_FOOTER;
    public static final invalid invalid;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/data_model/models/inner_models/FeedItemFooterLayout$Layout, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        SOCIAL_ACTIONS_FOOTER = new <init>("SOCIAL_ACTIONS_FOOTER", 0);
        SIMPLE_LAUNCH_FOOTER = new <init>("SIMPLE_LAUNCH_FOOTER", 1);
        LEGACY_FOOTER = new <init>("LEGACY_FOOTER", 2);
        invalid = new <init>("invalid", 3);
        $VALUES = (new .VALUES[] {
            SOCIAL_ACTIONS_FOOTER, SIMPLE_LAUNCH_FOOTER, LEGACY_FOOTER, invalid
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
