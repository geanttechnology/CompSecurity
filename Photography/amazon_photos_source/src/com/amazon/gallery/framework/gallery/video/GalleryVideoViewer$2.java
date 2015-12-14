// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.video;

import com.amazon.gallery.framework.network.exceptions.TerminalException;

// Referenced classes of package com.amazon.gallery.framework.gallery.video:
//            GalleryVideoViewer, GalleryVideoView

class this._cls0
    implements com.amazon.gallery.framework.network.tHandler
{

    final GalleryVideoViewer this$0;

    public void onFailure(TerminalException terminalexception)
    {
        GalleryVideoViewer.access$000(GalleryVideoViewer.this).post(new Runnable() {

            final GalleryVideoViewer._cls2 this$1;

            public void run()
            {
                onURLLoadFailure();
            }

            
            {
                this$1 = GalleryVideoViewer._cls2.this;
                super();
            }
        });
    }

    public volatile void onSuccess(Object obj)
    {
        onSuccess((String)obj);
    }

    public void onSuccess(final String url)
    {
        GalleryVideoViewer.access$000(GalleryVideoViewer.this).post(new Runnable() {

            final GalleryVideoViewer._cls2 this$1;
            final String val$url;

            public void run()
            {
                onURLLoadSuccess(url);
            }

            
            {
                this$1 = GalleryVideoViewer._cls2.this;
                url = s;
                super();
            }
        });
    }

    _cls2.this._cls1()
    {
        this$0 = GalleryVideoViewer.this;
        super();
    }
}
