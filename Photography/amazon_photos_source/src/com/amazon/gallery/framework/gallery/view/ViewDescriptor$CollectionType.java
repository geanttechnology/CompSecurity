// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view;


// Referenced classes of package com.amazon.gallery.framework.gallery.view:
//            ViewDescriptor

public static final class  extends Enum
{

    private static final CUSTOM_DATA_SET $VALUES[];
    public static final CUSTOM_DATA_SET CUSTOM_DATA_SET;
    public static final CUSTOM_DATA_SET DYNAMIC_ALBUM;
    public static final CUSTOM_DATA_SET EVERYTHING;
    public static final CUSTOM_DATA_SET MEDIA_PROPERTY;
    public static final CUSTOM_DATA_SET MEDIA_TYPE;
    public static final CUSTOM_DATA_SET TAG;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/gallery/view/ViewDescriptor$CollectionType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        EVERYTHING = new <init>("EVERYTHING", 0);
        MEDIA_PROPERTY = new <init>("MEDIA_PROPERTY", 1);
        MEDIA_TYPE = new <init>("MEDIA_TYPE", 2);
        TAG = new <init>("TAG", 3);
        DYNAMIC_ALBUM = new <init>("DYNAMIC_ALBUM", 4);
        CUSTOM_DATA_SET = new <init>("CUSTOM_DATA_SET", 5);
        $VALUES = (new .VALUES[] {
            EVERYTHING, MEDIA_PROPERTY, MEDIA_TYPE, TAG, DYNAMIC_ALBUM, CUSTOM_DATA_SET
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
