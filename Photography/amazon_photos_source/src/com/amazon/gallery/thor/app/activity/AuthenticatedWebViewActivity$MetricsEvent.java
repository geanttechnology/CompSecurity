// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.app.activity;


// Referenced classes of package com.amazon.gallery.thor.app.activity:
//            AuthenticatedWebViewActivity

public static final class  extends Enum
{

    private static final ManageStorageLoadFailed $VALUES[];
    public static final ManageStorageLoadFailed ManageStorageLoadFailed;
    public static final ManageStorageLoadFailed ManageStorageWebViewLoaded;
    public static final ManageStorageLoadFailed PromotionLoadFailed;
    public static final ManageStorageLoadFailed PromotionWebViewLoaded;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/thor/app/activity/AuthenticatedWebViewActivity$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        PromotionWebViewLoaded = new <init>("PromotionWebViewLoaded", 0);
        PromotionLoadFailed = new <init>("PromotionLoadFailed", 1);
        ManageStorageWebViewLoaded = new <init>("ManageStorageWebViewLoaded", 2);
        ManageStorageLoadFailed = new <init>("ManageStorageLoadFailed", 3);
        $VALUES = (new .VALUES[] {
            PromotionWebViewLoaded, PromotionLoadFailed, ManageStorageWebViewLoaded, ManageStorageLoadFailed
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
