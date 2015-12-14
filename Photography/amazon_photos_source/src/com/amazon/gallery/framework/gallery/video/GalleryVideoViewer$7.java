// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.media.MediaPlayer;
import android.widget.ProgressBar;
import com.amazon.gallery.foundation.utils.log.GLogger;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            GalleryVideoViewer, VideoMetrics

class this._cls0
    implements android.media.tener
{

    final GalleryVideoViewer this$0;

    public boolean onInfo(MediaPlayer mediaplayer, int i, int j)
    {
        GLogger.v(GalleryVideoViewer.access$800(), "MediaInfo: (%d, %d)", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        });
        switch (i)
        {
        default:
            return false;

        case 701: 
            GLogger.d(GalleryVideoViewer.access$800(), "MediaPlayer buffering: start", new Object[0]);
            GalleryVideoViewer.access$500(GalleryVideoViewer.this).rebufferStarted();
            GalleryVideoViewer.access$600(GalleryVideoViewer.this).setVisibility(0);
            return false;

        case 702: 
            GLogger.d(GalleryVideoViewer.access$800(), "MediaPlayer buffering: end", new Object[0]);
            GalleryVideoViewer.access$500(GalleryVideoViewer.this).rebufferEnded();
            GalleryVideoViewer.access$600(GalleryVideoViewer.this).setVisibility(8);
            return false;

        case 3: // '\003'
            GalleryVideoViewer.access$600(GalleryVideoViewer.this).setVisibility(8);
            return false;
        }
    }

    ()
    {
        this$0 = GalleryVideoViewer.this;
        super();
    }
}
