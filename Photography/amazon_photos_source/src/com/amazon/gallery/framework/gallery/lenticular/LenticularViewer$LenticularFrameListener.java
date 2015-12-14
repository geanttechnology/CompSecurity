// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.lenticular;

import com.amazon.gallery.framework.model.media.MediaItem;

// Referenced classes of package com.amazon.gallery.framework.gallery.lenticular:
//            LenticularViewer

private class mediaItem
    implements com.amazon.boombox.widget.nticularFrameListener
{

    private MediaItem mediaItem;
    final LenticularViewer this$0;

    public void onFrameChange(int i)
    {
    }

    public void onReady()
    {
        if (LenticularViewer.access$200(LenticularViewer.this) != null)
        {
            LenticularViewer.access$200(LenticularViewer.this).diaReady(mediaItem);
        }
    }

    public (MediaItem mediaitem)
    {
        this$0 = LenticularViewer.this;
        super();
        mediaItem = mediaitem;
    }
}
