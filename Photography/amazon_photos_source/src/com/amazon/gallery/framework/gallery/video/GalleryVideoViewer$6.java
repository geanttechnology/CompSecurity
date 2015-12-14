// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.media.MediaPlayer;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.gallery.video.player.ErrorCodeResolver;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            GalleryVideoViewer, VideoMetrics

class this._cls0
    implements android.media.stener
{

    final GalleryVideoViewer this$0;

    public boolean onError(MediaPlayer mediaplayer, int i, int j)
    {
        GLogger.e(GalleryVideoViewer.access$800(), "MediaPlayer err: %d, extra: %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        if (MediaItemUtil.isLocalMediaItem(mediaItem))
        {
            mediaplayer = GalleryVideoViewer.access$900(mediaItem.getLocalPath());
            if (mediaplayer != null)
            {
                GalleryVideoViewer.access$500(GalleryVideoViewer.this).playError(mediaplayer);
            }
        }
        if (GalleryVideoViewer.access$1000(GalleryVideoViewer.this) != null)
        {
            GalleryVideoViewer.access$1000(GalleryVideoViewer.this).onVideoError();
        }
        return displayErrorDialogue(ErrorCodeResolver.resolve(i, j));
    }

    ver()
    {
        this$0 = GalleryVideoViewer.this;
        super();
    }
}
