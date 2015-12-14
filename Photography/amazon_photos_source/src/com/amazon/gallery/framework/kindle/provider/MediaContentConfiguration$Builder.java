// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.provider;

import android.net.Uri;
import com.amazon.gallery.framework.data.dao.DynamicAlbumDao;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.Validate;

// Referenced classes of package com.amazon.gallery.framework.kindle.provider:
//            MediaContentConfiguration, GalleryInternalContentProvider

public static class iaItem.Columns.ALL_PROJECTION
{

    private String label;
    private String projection[];
    private StringBuilder selection;
    private List selectionArgs;
    private MediaItemSortType sortType;
    private Uri uri;
    private ViewDescriptor viewDescriptor;

    public iaItem.Columns.ALL_PROJECTION appendWhere(String s)
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

    public selection appendWhere(String s, Object obj)
    {
        if (selectionArgs == null)
        {
            selectionArgs = new ArrayList();
        }
        selectionArgs.add(obj.toString());
        return appendWhere((new StringBuilder()).append(s).append(" = ? ").toString());
    }

    public transient appendWhere appendWhereIn(String s, Object aobj[])
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
        return new MediaContentConfiguration(uri, projection, s, as, sortType, label, viewDescriptor, null);
    }

    public viewDescriptor withLabel(String s)
    {
        label = s;
        return this;
    }

    public transient label withProjection(String as[])
    {
        projection = as;
        return this;
    }

    public projection withSortType(MediaItemSortType mediaitemsorttype)
    {
        sortType = mediaitemsorttype;
        return this;
    }

    public sortType withUri(Uri uri1)
    {
        uri = (Uri)Validate.notNull(uri1);
        return this;
    }

    public uri withViewDescriptor(ViewDescriptor viewdescriptor)
    {
        Tag tag;
label0:
        {
            viewDescriptor = viewdescriptor;
            tag = viewdescriptor.getTag();
            if (tag != null)
            {
                if (!viewdescriptor.getCollectionType().ls(com.amazon.gallery.framework.gallery.view.MIC_ALBUM) || !((NetworkConnectivity)ThorGalleryApplication.getBean(Keys.NETWORK_CONNECTIVITY)).isNetworkConnected() && !((DynamicAlbumDao)ThorGalleryApplication.getBean(Keys.DYNAMIC_ALBUM_DAO)).contains(tag.getId()))
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

    public iaItem.Columns()
    {
        projection = iaItem.Columns.ALL_PROJECTION;
    }
}
