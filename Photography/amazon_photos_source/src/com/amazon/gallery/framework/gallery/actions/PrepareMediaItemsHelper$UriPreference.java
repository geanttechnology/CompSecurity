// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;


// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            PrepareMediaItemsHelper

public static final class  extends Enum
{

    private static final DIRECT_LINK $VALUES[];
    public static final DIRECT_LINK CLOUD;
    public static final DIRECT_LINK CONTENT;
    public static final DIRECT_LINK DIRECT_LINK;
    public static final DIRECT_LINK FILE;
    public static final DIRECT_LINK THUMBNAIL;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/actions/PrepareMediaItemsHelper$UriPreference, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        CONTENT = new <init>("CONTENT", 0);
        FILE = new <init>("FILE", 1);
        THUMBNAIL = new <init>("THUMBNAIL", 2);
        CLOUD = new <init>("CLOUD", 3);
        DIRECT_LINK = new <init>("DIRECT_LINK", 4);
        $VALUES = (new .VALUES[] {
            CONTENT, FILE, THUMBNAIL, CLOUD, DIRECT_LINK
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
