// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.amazon.gallery.framework.kindle.action:
//            ManualUploadAction

protected class tags
{

    private final List mediaItems;
    private final List tags;
    final ManualUploadAction this$0;
    private int toastMessage;

    private boolean containsVideo(List list)
    {
        for (list = list.iterator(); list.hasNext();)
        {
            MediaItem mediaitem = (MediaItem)list.next();
            if (mediaitem.getType() == MediaType.VIDEO && SyncState.SYNCED != mediaitem.getSyncState())
            {
                return true;
            }
        }

        return false;
    }

    public boolean containsVideo()
    {
label0:
        {
            if (mediaItems != null && containsVideo(mediaItems))
            {
                return true;
            }
            if (tags == null)
            {
                break label0;
            }
            Iterator iterator = tags.iterator();
            Tag tag;
            do
            {
                if (!iterator.hasNext())
                {
                    break label0;
                }
                tag = (Tag)iterator.next();
            } while (!containsVideo(ManualUploadAction.access$800(ManualUploadAction.this).getItemsByTag(tag).getMediaItems()));
            return true;
        }
        return false;
    }

    public long getFileLength(Set set)
    {
        long l = 0L;
        if (mediaItems != null)
        {
            l = 0L + MediaItemUtil.getFileLength(mediaItems, set);
        }
        long l1 = l;
        if (tags != null)
        {
            Iterator iterator = tags.iterator();
            do
            {
                l1 = l;
                if (!iterator.hasNext())
                {
                    break;
                }
                Tag tag = (Tag)iterator.next();
                l += MediaItemUtil.getFileLength(ManualUploadAction.access$800(ManualUploadAction.this).getItemsByTag(tag).getMediaItems(), set);
            } while (true);
        }
        return l1;
    }

    public List getMediaItems()
    {
        return mediaItems;
    }

    public List getTags()
    {
        return tags;
    }

    public int getToastMessage()
    {
        return toastMessage;
    }

    public int photoCount()
    {
        int i = 0;
        if (mediaItems != null)
        {
            i = 0 + mediaItems.size();
        }
        int j = i;
        if (tags != null)
        {
            Iterator iterator = tags.iterator();
            do
            {
                j = i;
                if (!iterator.hasNext())
                {
                    break;
                }
                Tag tag = (Tag)iterator.next();
                i += ManualUploadAction.access$800(ManualUploadAction.this).getItemsByTag(tag).getMediaItems().size();
            } while (true);
        }
        return j;
    }

    public void setToastMessage(int i)
    {
        toastMessage = i;
    }

    public Q(List list, List list1)
    {
        this$0 = ManualUploadAction.this;
        super();
        toastMessage = 0x7f0e018c;
        mediaItems = list;
        tags = list1;
    }
}
