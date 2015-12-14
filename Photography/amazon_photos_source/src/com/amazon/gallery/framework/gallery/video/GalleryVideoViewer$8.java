// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.content.DialogInterface;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.gallery.messaging.VideoViewerErrorEvent;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            GalleryVideoViewer

class this._cls0
    implements android.content.ckListener
{

    final GalleryVideoViewer this$0;

    public void onClick(DialogInterface dialoginterface, int i)
    {
        destroy();
        GlobalMessagingBus.post(new VideoViewerErrorEvent());
    }

    ()
    {
        this$0 = GalleryVideoViewer.this;
        super();
    }
}
