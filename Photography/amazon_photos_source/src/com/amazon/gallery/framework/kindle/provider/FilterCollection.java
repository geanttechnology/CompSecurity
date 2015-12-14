// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.provider;

import android.net.Uri;
import com.amazon.gallery.framework.model.media.CommonMediaProperty;
import com.amazon.gallery.framework.model.media.MediaType;

// Referenced classes of package com.amazon.gallery.framework.kindle.provider:
//            GalleryInternalContentProvider, MediaContentConfiguration

public final class FilterCollection extends Enum
{

    private static final FilterCollection $VALUES[];
    public static final FilterCollection ALL;
    public static final FilterCollection CAMERA_ROLL;
    public static final FilterCollection VIDEOS;
    private final Uri mContentUri;
    private final int mLabelID;
    private final MediaContentConfiguration mMediaContentConfiguration;

    private FilterCollection(String s, int i, Uri uri, MediaContentConfiguration mediacontentconfiguration, int j)
    {
        super(s, i);
        mContentUri = uri;
        mMediaContentConfiguration = mediacontentconfiguration;
        mLabelID = j;
    }

    private static Uri createCollectionUri(String s)
    {
        return (new android.net.Uri.Builder()).scheme("content").authority("com.amazon.gallery.provider.internal").appendPath("collection").appendPath(s).build();
    }

    public static FilterCollection valueOf(Uri uri)
    {
        uri = uri.getPath();
        if (uri.equals(ALL.getContentUri().getPath()))
        {
            return ALL;
        }
        if (uri.equals(CAMERA_ROLL.getContentUri().getPath()))
        {
            return CAMERA_ROLL;
        }
        if (uri.equals(VIDEOS.getContentUri().getPath()))
        {
            return VIDEOS;
        } else
        {
            throw new IllegalArgumentException("Uri does not match any FilterCollection.");
        }
    }

    public static FilterCollection valueOf(String s)
    {
        return (FilterCollection)Enum.valueOf(com/amazon/gallery/framework/kindle/provider/FilterCollection, s);
    }

    public static FilterCollection[] values()
    {
        return (FilterCollection[])$VALUES.clone();
    }

    public Uri getContentUri()
    {
        return mContentUri;
    }

    public int getLabelID()
    {
        return mLabelID;
    }

    public MediaContentConfiguration getMediaContentConfiguration()
    {
        return mMediaContentConfiguration;
    }

    public Uri getMediaContentUri()
    {
        return GalleryInternalContentProvider.createCollectionMediaUri(mContentUri);
    }

    static 
    {
        ALL = new FilterCollection("ALL", 0, createCollectionUri("all"), (new MediaContentConfiguration.Builder()).withUri(GalleryInternalContentProvider.MediaItem.CONTENT_URI).build(), 0x7f0e0066);
        CAMERA_ROLL = new FilterCollection("CAMERA_ROLL", 1, createCollectionUri("camera_roll"), (new MediaContentConfiguration.Builder()).withUri(GalleryInternalContentProvider.createMediaPropertyUri(CommonMediaProperty.CAMERA)).build(), 0x7f0e0098);
        VIDEOS = new FilterCollection("VIDEOS", 2, createCollectionUri("videos"), (new MediaContentConfiguration.Builder()).withUri(GalleryInternalContentProvider.MediaItem.CONTENT_URI).appendWhere("type", Integer.valueOf(MediaType.VIDEO.ordinal())).build(), 0x7f0e0073);
        $VALUES = (new FilterCollection[] {
            ALL, CAMERA_ROLL, VIDEOS
        });
    }
}
