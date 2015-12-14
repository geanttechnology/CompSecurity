// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.provider;

import android.net.Uri;
import com.amazon.gallery.framework.data.dao.DynamicAlbumDao;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.model.TimelineQueryImpl;
import com.amazon.gallery.framework.gallery.view.ContentConfiguration;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.TimelineQuery;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.amazon.gallery.framework.kindle.provider:
//            GalleryInternalContentProvider

public class MediaContentConfiguration
    implements ContentConfiguration
{
    public static class Builder
    {

        private String label;
        private String projection[];
        private StringBuilder selection;
        private List selectionArgs;
        private MediaItemSortType sortType;
        private Uri uri;
        private ViewDescriptor viewDescriptor;

        public Builder appendWhere(String s)
        {
            if (selection == null)
            {
                selection = new StringBuilder();
            } else
            {
                selection.append("AND ");
            }
            selection.append((new StringBuilder()).append(s).append(" ").toString());
            return this;
        }

        public Builder appendWhere(String s, Object obj)
        {
            if (selectionArgs == null)
            {
                selectionArgs = new ArrayList();
            }
            selectionArgs.add(obj.toString());
            return appendWhere((new StringBuilder()).append(s).append(" = ? ").toString());
        }

        public transient Builder appendWhereIn(String s, Object aobj[])
        {
            if (aobj == null)
            {
                return this;
            }
            if (selectionArgs == null)
            {
                selectionArgs = new ArrayList();
            }
            StringBuilder stringbuilder = new StringBuilder("(");
            int i = 0;
            while (i < aobj.length) 
            {
                Object obj = aobj[i];
                selectionArgs.add(obj.toString());
                if (i == 0)
                {
                    obj = "?";
                } else
                {
                    obj = ", ?";
                }
                stringbuilder.append(((String) (obj)));
                i++;
            }
            stringbuilder.append(") ");
            return appendWhere((new StringBuilder()).append(s).append(" IN ").append(stringbuilder.toString()).toString());
        }

        public MediaContentConfiguration build()
        {
            String s;
            String as[];
            if (selection != null)
            {
                s = selection.toString();
            } else
            {
                s = null;
            }
            if (selectionArgs != null)
            {
                as = (String[])selectionArgs.toArray(new String[selectionArgs.size()]);
            } else
            {
                as = null;
            }
            return new MediaContentConfiguration(uri, projection, s, as, sortType, label, viewDescriptor);
        }

        public Builder withLabel(String s)
        {
            label = s;
            return this;
        }

        public transient Builder withProjection(String as[])
        {
            projection = as;
            return this;
        }

        public Builder withSortType(MediaItemSortType mediaitemsorttype)
        {
            sortType = mediaitemsorttype;
            return this;
        }

        public Builder withUri(Uri uri1)
        {
            uri = (Uri)Validate.notNull(uri1);
            return this;
        }

        public Builder withViewDescriptor(ViewDescriptor viewdescriptor)
        {
            Tag tag;
label0:
            {
                viewDescriptor = viewdescriptor;
                tag = viewdescriptor.getTag();
                if (tag != null)
                {
                    if (!viewdescriptor.getCollectionType().equals(com.amazon.gallery.framework.gallery.view.ViewDescriptor.CollectionType.DYNAMIC_ALBUM) || !((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY)).isNetworkConnected() && !((DynamicAlbumDao)ThorGalleryApplication.getBean(Keys.DYNAMIC_ALBUM_DAO)).contains(tag.getId()))
                    {
                        break label0;
                    }
                    withUri(GalleryInternalContentProvider.createDynamicAlbumMediaUri(tag.getId()));
                }
                return this;
            }
            withUri(GalleryInternalContentProvider.createTagMediaUri(GalleryInternalContentProvider.createTagUri(tag.getId())));
            return this;
        }

        public Builder()
        {
            projection = GalleryInternalContentProvider.MediaItem.Columns.ALL_PROJECTION;
        }
    }


    private final String label;
    private final String projection[];
    private final String selection;
    private final String selectionArgs[];
    private MediaItemSortType sortType;
    private TimelineQuery timelineQuery;
    private final Uri uri;
    private final ViewDescriptor viewDescriptor;

    private MediaContentConfiguration(Uri uri1, String as[], String s, String as1[], MediaItemSortType mediaitemsorttype, String s1, ViewDescriptor viewdescriptor)
    {
        uri = (Uri)Validate.notNull(uri1);
        selection = s;
        selectionArgs = as1;
        projection = as;
        label = s1;
        viewDescriptor = viewdescriptor;
        setSortType(mediaitemsorttype);
    }


    public Uri getContentUri()
    {
        return uri;
    }

    public String[] getProjection()
    {
        return projection;
    }

    public String getSelection()
    {
        return selection;
    }

    public String[] getSelectionArgs()
    {
        return selectionArgs;
    }

    public MediaItemSortType getSortType()
    {
        return sortType;
    }

    public TimelineQuery getTimelineQuery()
    {
        return timelineQuery;
    }

    public void setSortType(MediaItemSortType mediaitemsorttype)
    {
        sortType = mediaitemsorttype;
        if (mediaitemsorttype != null)
        {
            timelineQuery = new TimelineQueryImpl("media_item a", selection, selectionArgs, mediaitemsorttype.getSortOrder());
            ((TimelineQueryImpl)timelineQuery).setMediaItemSortType(mediaitemsorttype);
        }
        if (viewDescriptor != null)
        {
            viewDescriptor.setMediaItemSortType(mediaitemsorttype);
        }
    }

    public ViewDescriptor toViewDescriptor()
    {
        return viewDescriptor;
    }
}
