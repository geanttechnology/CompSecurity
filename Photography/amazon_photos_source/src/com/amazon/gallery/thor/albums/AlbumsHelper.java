// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.support.design.widget.Snackbar;
import android.view.View;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.framework.kindle.activity.BasicListActivity;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumPageTracker, ListChildrenTask, RefreshCoverPhotoTask

public class AlbumsHelper
{

    private final String addItemsError;
    private final String addItemsPlural;
    private final String addItemsSingle;
    private final View container;

    public AlbumsHelper(View view)
    {
        container = view;
        view = view.getContext();
        addItemsSingle = view.getString(0x7f0e0018);
        addItemsPlural = view.getString(0x7f0e0017);
        addItemsError = view.getString(0x7f0e0016);
    }

    public static int getAlbumCoverPhotoBoundingSize(Context context)
    {
        Resources resources = context.getResources();
        return BasicListActivity.calculateImageWidth(context, resources.getInteger(0x7f0d0000), resources.getDimensionPixelSize(0x7f0a0037), resources.getDimensionPixelSize(0x7f0a0033));
    }

    private int getItemAddedCount(Intent intent)
    {
        return intent.getIntExtra("countAddedToAlbum", -1);
    }

    public boolean fromAddToAlbumIntent(Intent intent)
    {
        if (intent.hasExtra("fromAddToAlbumAction"))
        {
            intent.removeExtra("fromAddToAlbumAction");
            return true;
        } else
        {
            return false;
        }
    }

    public void onEnterAlbum(Intent intent)
    {
        Object obj = null;
        Tag tag = (Tag)intent.getSerializableExtra("mediaTag");
        ObjectID objectid;
        if (tag != null && tag.getType() == TagType.ALBUM)
        {
            objectid = tag.getObjectId();
        } else
        {
            objectid = obj;
            if (intent.getAction() != null)
            {
                objectid = obj;
                if (intent.getAction().equals("com.amazon.photos.CMS"))
                {
                    intent = intent.getStringExtra("mediaTagId");
                    objectid = obj;
                    if (intent != null)
                    {
                        objectid = ObjectID.parseString(intent);
                    }
                }
            }
        }
        if (objectid != null)
        {
            AlbumPageTracker.getInstance().setLoading(true);
            if (tag != null)
            {
                ListChildrenTask.executeWithOffset(tag, 0);
            } else
            {
                ListChildrenTask.executeWithOffset(objectid, 0);
            }
            (new RefreshCoverPhotoTask(container.getContext(), IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits()), getAlbumCoverPhotoBoundingSize(container.getContext()))).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void showSnackbar(Intent intent, Tag tag)
    {
        int i = getItemAddedCount(intent);
        if (i != -1)
        {
            if (i > 1 && tag != null)
            {
                intent = String.format(addItemsPlural, new Object[] {
                    tag.getLabel()
                });
            } else
            {
                intent = addItemsSingle;
            }
        } else
        {
            intent = addItemsError;
        }
        Snackbar.make(container, intent, 0).show();
    }
}
