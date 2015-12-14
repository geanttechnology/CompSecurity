// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.widget;

import android.widget.BaseAdapter;

public abstract class GalleryBaseAdapter extends BaseAdapter
    implements com.amazon.gallery.framework.data.model.TimelineModel.ChangeListener
{
    public static final class ItemViewType extends Enum
    {

        private static final ItemViewType $VALUES[];
        public static final ItemViewType BANNER;
        public static final ItemViewType DIVIDER;
        public static final ItemViewType MEDIA_ITEM;

        public static ItemViewType valueOf(String s)
        {
            return (ItemViewType)Enum.valueOf(com/amazon/gallery/framework/gallery/widget/GalleryBaseAdapter$ItemViewType, s);
        }

        public static ItemViewType[] values()
        {
            return (ItemViewType[])$VALUES.clone();
        }

        static 
        {
            DIVIDER = new ItemViewType("DIVIDER", 0);
            MEDIA_ITEM = new ItemViewType("MEDIA_ITEM", 1);
            BANNER = new ItemViewType("BANNER", 2);
            $VALUES = (new ItemViewType[] {
                DIVIDER, MEDIA_ITEM, BANNER
            });
        }

        private ItemViewType(String s, int i)
        {
            super(s, i);
        }
    }


    public GalleryBaseAdapter()
    {
    }

    public abstract int getGridItemIndexForLayoutFocus(int i);

    public abstract int getMediaItemIndex(int i);
}
