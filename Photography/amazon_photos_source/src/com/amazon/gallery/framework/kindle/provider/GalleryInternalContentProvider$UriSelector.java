// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.provider;


// Referenced classes of package com.amazon.gallery.framework.kindle.provider:
//            GalleryInternalContentProvider

private static final class  extends Enum
{

    private static final AUDIT $VALUES[];
    public static final AUDIT AUDIT;
    public static final AUDIT COLLECTION_ID;
    public static final AUDIT COLLECTION_ID_MEDIA;
    public static final AUDIT DYNAMIC_ALBUM_MEDIA;
    public static final AUDIT FRAME;
    public static final AUDIT MEDIA_ITEM;
    public static final AUDIT MEDIA_ITEM_ID;
    public static final AUDIT MEDIA_PROPERTY_ID_MEDIA;
    public static final AUDIT METADATA_MEDIA;
    public static final AUDIT SORT_TYPE;
    public static final AUDIT TAG;
    public static final AUDIT TAG_ID;
    public static final AUDIT TAG_ID_MEDIA;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/provider/GalleryInternalContentProvider$UriSelector, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        MEDIA_ITEM = new <init>("MEDIA_ITEM", 0);
        MEDIA_ITEM_ID = new <init>("MEDIA_ITEM_ID", 1);
        MEDIA_PROPERTY_ID_MEDIA = new <init>("MEDIA_PROPERTY_ID_MEDIA", 2);
        METADATA_MEDIA = new <init>("METADATA_MEDIA", 3);
        TAG = new <init>("TAG", 4);
        TAG_ID = new <init>("TAG_ID", 5);
        TAG_ID_MEDIA = new <init>("TAG_ID_MEDIA", 6);
        COLLECTION_ID = new <init>("COLLECTION_ID", 7);
        COLLECTION_ID_MEDIA = new <init>("COLLECTION_ID_MEDIA", 8);
        DYNAMIC_ALBUM_MEDIA = new <init>("DYNAMIC_ALBUM_MEDIA", 9);
        FRAME = new <init>("FRAME", 10);
        SORT_TYPE = new <init>("SORT_TYPE", 11);
        AUDIT = new <init>("AUDIT", 12);
        $VALUES = (new .VALUES[] {
            MEDIA_ITEM, MEDIA_ITEM_ID, MEDIA_PROPERTY_ID_MEDIA, METADATA_MEDIA, TAG, TAG_ID, TAG_ID_MEDIA, COLLECTION_ID, COLLECTION_ID_MEDIA, DYNAMIC_ALBUM_MEDIA, 
            FRAME, SORT_TYPE, AUDIT
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
