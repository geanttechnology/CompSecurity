// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AuthenticatedWebViewActivity

public static final class  extends Enum
{

    private static final DEFAULT $VALUES[];
    public static final DEFAULT DEFAULT;
    public static final DEFAULT MANAGE_STORAGE;
    public static final DEFAULT PROMOTION;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/app/activity/AuthenticatedWebViewActivity$PageType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MANAGE_STORAGE = new <init>("MANAGE_STORAGE", 0);
        PROMOTION = new <init>("PROMOTION", 1);
        DEFAULT = new <init>("DEFAULT", 2);
        $VALUES = (new .VALUES[] {
            MANAGE_STORAGE, PROMOTION, DEFAULT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
