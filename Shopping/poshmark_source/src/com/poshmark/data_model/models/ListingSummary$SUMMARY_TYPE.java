// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.data_model.models;


// Referenced classes of package com.poshmark.data_model.models:
//            ListingSummary

public static final class  extends Enum
{

    private static final SOCIAL_OLDEST $VALUES[];
    public static final SOCIAL_OLDEST DEFAULT;
    public static final SOCIAL_OLDEST SOCIAL_OLDEST;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/poshmark/data_model/models/ListingSummary$SUMMARY_TYPE, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        DEFAULT = new <init>("DEFAULT", 0);
        SOCIAL_OLDEST = new <init>("SOCIAL_OLDEST", 1);
        $VALUES = (new .VALUES[] {
            DEFAULT, SOCIAL_OLDEST
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
