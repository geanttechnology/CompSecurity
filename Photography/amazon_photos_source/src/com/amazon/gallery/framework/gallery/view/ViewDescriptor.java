// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.view;

import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.filter.DaoFilter;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.thisday.ThisDayViewDescriptor;

public class ViewDescriptor
{
    public static final class CollectionType extends Enum
    {

        private static final CollectionType $VALUES[];
        public static final CollectionType CUSTOM_DATA_SET;
        public static final CollectionType DYNAMIC_ALBUM;
        public static final CollectionType EVERYTHING;
        public static final CollectionType MEDIA_PROPERTY;
        public static final CollectionType MEDIA_TYPE;
        public static final CollectionType TAG;

        public static CollectionType valueOf(String s)
        {
            return (CollectionType)Enum.valueOf(com/amazon/gallery/framework/gallery/view/ViewDescriptor$CollectionType, s);
        }

        public static CollectionType[] values()
        {
            return (CollectionType[])$VALUES.clone();
        }

        static 
        {
            EVERYTHING = new CollectionType("EVERYTHING", 0);
            MEDIA_PROPERTY = new CollectionType("MEDIA_PROPERTY", 1);
            MEDIA_TYPE = new CollectionType("MEDIA_TYPE", 2);
            TAG = new CollectionType("TAG", 3);
            DYNAMIC_ALBUM = new CollectionType("DYNAMIC_ALBUM", 4);
            CUSTOM_DATA_SET = new CollectionType("CUSTOM_DATA_SET", 5);
            $VALUES = (new CollectionType[] {
                EVERYTHING, MEDIA_PROPERTY, MEDIA_TYPE, TAG, DYNAMIC_ALBUM, CUSTOM_DATA_SET
            });
        }

        private CollectionType(String s, int i)
        {
            super(s, i);
        }
    }


    private int collectionSize;
    private CollectionType collectionType;
    private boolean collectionTypeChanged;
    private MediaItemCollection customDataSet;
    private int focusedMediaItemIndex;
    private boolean isHidden;
    private boolean isPreload;
    private boolean localOnly;
    private ObjectID mediaItem;
    private MediaItemSortType mediaItemSortType;
    private MediaType mediaItemType;
    private MediaProperty mediaProperty;
    private MediaType mediaType;
    private boolean sdCardOnly;
    private boolean sortingChanged;
    private boolean syncingAfterCameraClick;
    protected Tag tag;
    private ThisDayViewDescriptor thisDayViewDescriptor;
    private boolean timeLineEnabled;

    public ViewDescriptor()
    {
        collectionType = CollectionType.EVERYTHING;
        mediaProperty = null;
        mediaType = null;
        mediaItemType = null;
        tag = null;
        customDataSet = null;
        mediaItem = null;
        mediaItemSortType = null;
        isHidden = false;
        timeLineEnabled = true;
        localOnly = false;
        sdCardOnly = false;
        isPreload = false;
    }

    private void clearAll()
    {
        tag = null;
        mediaProperty = null;
        customDataSet = null;
        mediaType = null;
        mediaItemSortType = null;
    }

    private void setCollectionType(CollectionType collectiontype)
    {
        if (collectionType != collectiontype)
        {
            collectionTypeChanged = true;
        }
        collectionType = collectiontype;
    }

    private void setupContent(Object obj, CollectionType collectiontype)
    {
        if (obj != null)
        {
            timeLineEnabled = false;
            setCollectionType(collectiontype);
            clearAll();
        } else
        if (getCollectionType() == collectiontype)
        {
            timeLineEnabled = true;
            setCollectionType(CollectionType.EVERYTHING);
            return;
        }
    }

    public int getCollectionSize()
    {
        return collectionSize;
    }

    public CollectionType getCollectionType()
    {
        return collectionType;
    }

    public MediaItemCollection getCustomDataSet()
    {
        return customDataSet;
    }

    public int getFocusedIndex()
    {
        return focusedMediaItemIndex;
    }

    public ObjectID getMediaItem()
    {
        return mediaItem;
    }

    public MediaItemSortType getMediaItemSortType()
    {
        return mediaItemSortType;
    }

    public MediaType getMediaItemType()
    {
        return mediaItemType;
    }

    public MediaProperty getMediaProperty()
    {
        return mediaProperty;
    }

    public MediaType getMediaType()
    {
        return mediaType;
    }

    public String getSortId()
    {
        static class _cls1
        {

            static final int $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType = new int[CollectionType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[CollectionType.EVERYTHING.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[CollectionType.MEDIA_PROPERTY.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[CollectionType.MEDIA_TYPE.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[CollectionType.TAG.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[CollectionType.DYNAMIC_ALBUM.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$gallery$view$ViewDescriptor$CollectionType[CollectionType.CUSTOM_DATA_SET.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        switch (_cls1..SwitchMap.com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType[getCollectionType().ordinal()])
        {
        default:
            return "";

        case 1: // '\001'
            return "all";

        case 2: // '\002'
            return "camera_roll";

        case 3: // '\003'
            return "video";

        case 4: // '\004'
        case 5: // '\005'
            return getTag().getObjectId().toString();
        }
    }

    public boolean getSyncingAfterCameraClick()
    {
        return syncingAfterCameraClick;
    }

    public Tag getTag()
    {
        return tag;
    }

    public ThisDayViewDescriptor getThisDayViewDescriptor()
    {
        return thisDayViewDescriptor;
    }

    public boolean getTimeLineVisbility()
    {
        return timeLineEnabled;
    }

    public boolean hasCollectionTypeChanged()
    {
        return collectionTypeChanged;
    }

    public boolean hasSortingChanged()
    {
        return sortingChanged;
    }

    public boolean inLocalCollection()
    {
        return localOnly || collectionType == CollectionType.MEDIA_PROPERTY && mediaProperty == CommonMediaProperty.LOCAL || collectionType == CollectionType.MEDIA_PROPERTY && mediaProperty == CommonMediaProperty.CAMERA || collectionType == CollectionType.TAG && tag.getType() == TagType.LOCAL_FOLDER;
    }

    public boolean isInHiddenMode()
    {
        return isHidden;
    }

    public boolean isLocalOnly()
    {
        return localOnly;
    }

    public boolean isPreload()
    {
        return isPreload;
    }

    public boolean isSdCardOnly()
    {
        return sdCardOnly;
    }

    public void setCollectionSize(int i)
    {
        collectionSize = i;
    }

    public void setCollectionTypeChanged(boolean flag)
    {
        collectionTypeChanged = flag;
    }

    public void setDynamicAlbumTag(Tag tag1)
    {
        setupContent(tag1, CollectionType.DYNAMIC_ALBUM);
        tag = tag1;
    }

    public void setFocusedIndex(int i)
    {
        focusedMediaItemIndex = i;
    }

    public void setLocalOnly(boolean flag)
    {
        localOnly = flag;
    }

    public void setMediaFilter(DaoFilter daofilter)
    {
        if (daofilter.getFilter() instanceof MediaType)
        {
            setMediaType((MediaType)daofilter.getFilter());
        }
    }

    public void setMediaItem(ObjectID objectid)
    {
        mediaItem = objectid;
    }

    public void setMediaItemSortType(MediaItemSortType mediaitemsorttype)
    {
        mediaItemSortType = mediaitemsorttype;
        sortingChanged = true;
    }

    public void setMediaItemType(MediaType mediatype)
    {
        mediaItemType = mediatype;
    }

    public void setMediaProperty(MediaProperty mediaproperty)
    {
        setupContent(mediaproperty, CollectionType.MEDIA_PROPERTY);
        mediaProperty = mediaproperty;
    }

    public void setMediaType(MediaType mediatype)
    {
        setupContent(mediatype, CollectionType.MEDIA_TYPE);
        mediaType = mediatype;
    }

    public void setPreload(boolean flag)
    {
        isPreload = flag;
    }

    public void setSdCardOnly(boolean flag)
    {
        sdCardOnly = flag;
    }

    public void setShowHiddenMode(boolean flag)
    {
        isHidden = flag;
    }

    public void setSortingChanged(boolean flag)
    {
        sortingChanged = flag;
    }

    public void setSyncingAfterCameraClick(boolean flag)
    {
        syncingAfterCameraClick = flag;
    }

    public void setTag(Tag tag1)
    {
        setupContent(tag1, CollectionType.TAG);
        tag = tag1;
    }

    public void setThisDayViewDescriptor(ThisDayViewDescriptor thisdayviewdescriptor)
    {
        thisDayViewDescriptor = thisdayviewdescriptor;
    }

    public void setTimeLineVisbility(boolean flag)
    {
        timeLineEnabled = flag;
    }
}
