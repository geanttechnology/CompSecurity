// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import android.widget.MediaController;
import com.amazon.gallery.thor.view.NoOpSidePanelListener;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            GalleryVideoViewer

class this._cls0 extends NoOpSidePanelListener
{

    final GalleryVideoViewer this$0;

    public void onClosed()
    {
        ((MediaController)getController()).setVisibility(0);
    }

    public void onDragged()
    {
        ((MediaController)getController()).setVisibility(4);
    }

    ()
    {
        this$0 = GalleryVideoViewer.this;
        super();
    }
}
