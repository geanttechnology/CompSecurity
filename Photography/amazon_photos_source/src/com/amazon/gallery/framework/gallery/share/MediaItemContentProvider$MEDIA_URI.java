// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.share;


// Referenced classes of package com.amazon.gallery.framework.gallery.share:
//            MediaItemContentProvider

public static final class  extends Enum
{

    private static final tag $VALUES[];
    public static final tag media;
    public static final tag tag;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/share/MediaItemContentProvider$MEDIA_URI, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        media = new <init>("media", 0);
        tag = new <init>("tag", 1);
        $VALUES = (new .VALUES[] {
            media, tag
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
