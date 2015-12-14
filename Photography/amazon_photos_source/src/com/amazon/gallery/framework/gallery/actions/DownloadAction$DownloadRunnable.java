// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.widget.Toast;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.view.ViewNameFactory;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.download.GalleryDownloadManager;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import java.io.File;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            DownloadAction

private class mediaItems
    implements Runnable
{

    private List mediaItems;
    private final Tag tag;
    final DownloadAction this$0;

    private void displayDownloadMessage(final int toastMessageId)
    {
        Runnable runnable = new Runnable() {

            final DownloadAction.DownloadRunnable this$1;
            final int val$toastMessageId;

            public void run()
            {
                Toast.makeText(DownloadAction.access$500(this$0), toastMessageId, 0).show();
            }

            
            {
                this$1 = DownloadAction.DownloadRunnable.this;
                toastMessageId = i;
                super();
            }
        };
        DownloadAction.access$600(DownloadAction.this).runOnUiThread(runnable);
    }

    private File getDirForTag(Tag tag1)
    {
        if (tag1 == null)
        {
            tag1 = "";
        } else
        {
            tag1 = ViewNameFactory.getTitle(tag1, DownloadAction.access$700(DownloadAction.this));
        }
        return new File(DownloadAction.access$800(DownloadAction.this), tag1);
    }

    protected void downloadMediaItems(List list)
    {
        if (list.isEmpty())
        {
            displayDownloadMessage(0x7f0e0042);
            return;
        }
        File file = getDirForTag(tag);
        if (!file.exists() && !file.mkdirs())
        {
            GLogger.e(DownloadAction.access$300(), "Couldn't create folder %s", new Object[] {
                file.getPath()
            });
            return;
        }
        GLogger.v(DownloadAction.access$300(), "Begin Download of %d for album %s", new Object[] {
            Integer.valueOf(list.size()), file
        });
        if (networkConnectivity.isNetworkConnected())
        {
            displayDownloadMessage(0x7f0e0041);
        }
        if (tag == null)
        {
            DownloadAction.access$400(DownloadAction.this).downloadMediaItems(list, file);
            return;
        } else
        {
            DownloadAction.access$400(DownloadAction.this).downloadMediaItems(tag, list, file);
            return;
        }
    }

    public void run()
    {
        if (DownloadAction.access$100(DownloadAction.this).promptForStoragePreferenceIfNeeded(DownloadAction.access$000(DownloadAction.this)))
        {
            return;
        }
        GlobalMessagingBus.post(new ActionCompleteEvent());
        if (mediaItems == null)
        {
            mediaItems = DownloadAction.access$200(DownloadAction.this).getItemsByTag(tag).getMediaItems();
        }
        for (Iterator iterator = mediaItems.iterator(); iterator.hasNext(); ((MediaItem)iterator.next()).getSyncState()) { }
        downloadMediaItems(mediaItems);
    }

    public _cls1.val.toastMessageId(Tag tag1)
    {
        this(tag1, null);
    }

    public <init>(Tag tag1, List list)
    {
        this$0 = DownloadAction.this;
        super();
        tag = tag1;
        mediaItems = list;
    }
}
