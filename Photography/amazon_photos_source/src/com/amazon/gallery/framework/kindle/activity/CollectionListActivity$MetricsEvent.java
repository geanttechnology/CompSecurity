// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.activity;


// Referenced classes of package com.amazon.gallery.framework.kindle.activity:
//            CollectionListActivity

public static final class  extends Enum
{

    private static final AlbumsViewAll $VALUES[];
    public static final AlbumsViewAll AlbumsViewAll;
    public static final AlbumsViewAll InCollectionLandscape;
    public static final AlbumsViewAll InCollectionPortrait;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/amazon/gallery/framework/kindle/activity/CollectionListActivity$MetricsEvent, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        InCollectionPortrait = new <init>("InCollectionPortrait", 0);
        InCollectionLandscape = new <init>("InCollectionLandscape", 1);
        AlbumsViewAll = new <init>("AlbumsViewAll", 2);
        $VALUES = (new .VALUES[] {
            InCollectionPortrait, InCollectionLandscape, AlbumsViewAll
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
